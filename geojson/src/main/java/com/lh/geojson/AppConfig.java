package com.lh.geojson;

import ch.qos.logback.classic.Level;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexWriter;
import org.geotools.data.DataStore;
import org.geotools.data.DataStoreFinder;
import org.geotools.data.FeatureSource;
import org.geotools.data.Query;
import org.geotools.feature.FeatureCollection;
import org.geotools.feature.FeatureIterator;
import org.geotools.geojson.feature.FeatureJSON;
import org.opengis.feature.simple.SimpleFeature;
import org.opengis.feature.simple.SimpleFeatureType;
import org.opengis.feature.type.Name;
import org.opengis.filter.Filter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.io.*;
import java.util.*;

/**
 * Created by lh on 2016/11/15.
 */
@Component
public class AppConfig {
    /*1.logback首先会试着查找logback.groovy文件;
    2.当没有找到时，继续试着查找logback-test.xml文件;
    3.当没有找到时，继续试着查找logback.xml文件;
    4.如果仍然没有找到，则使用默认配置（打印到控制台）。
    TRACE < DEBUG < INFO < WARN < ERROR
    */
    Logger logger = LoggerFactory.getLogger(AppConfig.class);

    @Value("${shape.dir}")
    String shapeFilePathDir;
    @Value("${feature.fileds}")
    String[] featureFields;

    @Autowired
    public LuceneConfig luceneConfig;

    @PostConstruct
    void getFeaturesFromShape() throws IOException {
        IndexWriter indexWriter = luceneConfig.getIndexWriter();
        if (indexWriter == null) {
            logger.error("indexWriter为null");
            return;
        }

        File file = new File(this.shapeFilePathDir);
        Map<String, Object> map = new HashMap<>();
        map.put("url", file.toURI().toURL());
        map.put("charset", "gbk");

        DataStore dataStore = DataStoreFinder.getDataStore(map);
        FeatureSource<SimpleFeatureType, SimpleFeature> source = null;
        FeatureCollection<SimpleFeatureType, SimpleFeature> collection = null;
        List<SimpleFeature> simpleFeatureList = new ArrayList<>();
        Filter filter = Filter.INCLUDE; // ECQL.toFilter("BBOX(THE_GEOM, 10,20,30,40)")

        String[] typeNames = dataStore.getTypeNames();
        Query qurey = new Query();
        qurey.setPropertyNames(featureFields);
        long starttime = System.currentTimeMillis();
        System.out.println("开始时间:" + String.valueOf(starttime));
        for (String typeName : typeNames) {
            simpleFeatureList.clear();
            source = dataStore.getFeatureSource(typeName);
            collection = source.getFeatures(qurey);
            try (FeatureIterator<SimpleFeature> features = collection.features()) {
                while (features.hasNext()) {
                    SimpleFeature feature = features.next();
                    Document document = new Document();
                    for (String m : featureFields) {
                        document.add(new TextField(m, feature.getAttribute(m).toString(), Field.Store.YES));
                    }
                    indexWriter.addDocument(document);
                }
            }
        }
        indexWriter.commit();
        indexWriter.close();
        long endtime = System.currentTimeMillis();
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(endtime - starttime);
        System.out.println("总共耗时:" + c.get(Calendar.MINUTE) + "分" + c.get(Calendar.SECOND) + "秒" + c.get(Calendar.MILLISECOND) + "毫秒");
    }

}