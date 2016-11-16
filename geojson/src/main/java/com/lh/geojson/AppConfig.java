package com.lh.geojson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.geotools.data.*;
import org.geotools.feature.FeatureCollection;
import org.geotools.feature.FeatureIterator;
import org.geotools.geojson.feature.FeatureJSON;
import org.opengis.feature.simple.SimpleFeature;
import org.opengis.feature.simple.SimpleFeatureType;
import org.opengis.filter.Filter;
import org.opengis.filter.FilterFactory2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.support.StaticListableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
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

    Logger logger = LoggerFactory.getLogger(AppConfig.class);

    @Value("${shape.dir}")
    String filePath;

    @PostConstruct
    void readShapes() throws IOException {

        logger.info("test");

        File file = new File(this.filePath);
        Map<String, Object> map = new HashMap<>();
        map.put("url", file.toURI().toURL());
        map.put("charset", "gbk");
//        map.put("charset", "UTF-8");

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
//        qurey.setFilter();
        int i = 0;
        int off = 0;
        long start = System.currentTimeMillis();
        for (String typeName : typeNames) {
            StringWriter writer = new StringWriter();
            simpleFeatureList.clear();
            source = dataStore.getFeatureSource(typeName);
            collection = source.getFeatures(qurey);
            fjson.writeFeatureCollection(collection, writer);

            String json = writer.toString();
//
            fileWriter.flush();
            fileWriter.write(json);


//            bufferedWriter.flush();
//            bufferedWriter.write(json);
        }
        fileWriter.close();
//        bufferedWriter.close();
        FilterFactory2 ff;


        long end = System.currentTimeMillis();
        System.out.println(end - start + "ms");
        /*int i = 0;
        try (FeatureIterator<SimpleFeature> features = collection.features()) {
            while (features.hasNext()) {
                i++;
                if (i > 10) {
                    return;
                }
                SimpleFeature feature = features.next();
                System.out.println(feature.toString());
                System.out.println(JSON.toJSONString(feature.getDefaultGeometry().toString(), SerializerFeature.WriteMapNullValue, SerializerFeature.WriteNullBooleanAsFalse
                ));
            }
        }*/

//        System.out.print(json);
//        int i = 0;
//        try (FeatureIterator<SimpleFeature> features = collection.features()) {
//            while (features.hasNext()) {
//                i++;
//                if (i > 10) {
//                    return;
//                }
//                SimpleFeature feature = features.next();
//                simpleFeatureList.add(feature);
//                fjson.writeFeature(feature, writer);
//                fjson.writeFeatureCollection(collection,writer);
//                String json = writer.toString();
//                System.out.print(json);
//            }
//        }

    }
}