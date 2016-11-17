package com.lh.geojson;

import ch.qos.logback.classic.Level;
import org.geotools.data.DataStore;
import org.geotools.data.DataStoreFinder;
import org.geotools.data.FeatureSource;
import org.geotools.data.Query;
import org.geotools.feature.FeatureCollection;
import org.geotools.geojson.feature.FeatureJSON;
import org.opengis.feature.simple.SimpleFeature;
import org.opengis.feature.simple.SimpleFeatureType;
import org.opengis.filter.Filter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    //    @Value("${shape.dir}")
    @Value("${mytest.value}")
    String filePath;

    @PostConstruct
    void getFeaturesFromShape() throws IOException {
        logger.info("logger.getName(),{}", logger.getName());
//        ch.qos.logback.classic.Logger logger =
//                (ch.qos.logback.classic.Logger) LoggerFactory.getLogger("com.foo");
//        logger.setLevel(Level. INFO);

        logger.trace("======trace");
        if (logger.isDebugEnabled()) {
            logger.debug("======debug");
        }
        logger.info("======info");
        logger.warn("======warn");
        logger.error("======error");

/*
        String name = "Aub";
        String message = "3Q";
        String[] fruits = {"apple", "banana"};

        // logback提供的可以使用变量的打印方式，结果为"Hello,Aub!"
        logger.info("Hello,{}!", name);

        // 可以有多个参数,结果为“Hello,Aub! 3Q!”
        logger.info("Hello,{}!   {}!", name, message);

        // 可以传入一个数组，结果为"Fruit:  apple,banana"
        logger.info("Fruit:  {},{}", fruits);*/


        /*File file = new File(this.filePath);
        Map<String, Object> map = new HashMap<>();
        map.put("url", file.toURI().toURL());
        map.put("charset", "gbk");

        DataStore dataStore = DataStoreFinder.getDataStore(map);
        FeatureSource<SimpleFeatureType, SimpleFeature> source = null;
        FeatureCollection<SimpleFeatureType, SimpleFeature> collection = null;
        List<SimpleFeature> simpleFeatureList = new ArrayList<>();
        Filter filter = Filter.INCLUDE; // ECQL.toFilter("BBOX(THE_GEOM, 10,20,30,40)")
        FeatureJSON fjson = new FeatureJSON();

        String[] typeNames = dataStore.getTypeNames();
        File f = new File("D:\\POI.geojson");
        if (f.exists()) {
            f.delete();
        }
        f.createNewFile();

        FileWriter fileWriter = new FileWriter(f, true);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        Query qurey = new Query();
        qurey.setMaxFeatures(1000);
        long start = System.currentTimeMillis();
        for (String typeName : typeNames) {
            StringWriter writer = new StringWriter();
            simpleFeatureList.clear();
            source = dataStore.getFeatureSource(typeName);
            collection = source.getFeatures(qurey);
            fjson.writeFeatureCollection(collection, writer);
            String json = writer.toString();
            fileWriter.flush();
            fileWriter.write(json);

        }
        fileWriter.close();
        long end = System.currentTimeMillis();
        System.out.println(end - start + "ms");*/
    }
}