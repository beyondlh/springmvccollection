package com.lh.geojson;

import com.alibaba.fastjson.JSON;
import org.geotools.data.Base64;
import org.geotools.data.DataStore;
import org.geotools.data.DataStoreFinder;
import org.geotools.data.FeatureSource;
import org.geotools.feature.FeatureCollection;
import org.geotools.feature.FeatureIterator;
import org.geotools.geojson.feature.FeatureJSON;
import org.opengis.feature.simple.SimpleFeature;
import org.opengis.feature.simple.SimpleFeatureType;
import org.opengis.filter.Filter;
import org.springframework.beans.factory.annotation.Value;
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
    @Value("${shape.dir}")
    String filePath;

    @PostConstruct
    void readShapes() throws IOException {
        File file = new File(this.filePath + ".shp");
        Map<String, Object> map = new HashMap<>();
        map.put("url", file.toURI().toURL());
        map.put("charset", "gbk");

        DataStore dataStore = DataStoreFinder.getDataStore(map);
        String typeName = dataStore.getTypeNames()[0];

        FeatureSource<SimpleFeatureType, SimpleFeature> source = dataStore
                .getFeatureSource(typeName);
        Filter filter = Filter.INCLUDE; // ECQL.toFilter("BBOX(THE_GEOM, 10,20,30,40)")

        FeatureCollection<SimpleFeatureType, SimpleFeature> collection = source.getFeatures(filter);
        List<SimpleFeature> simpleFeatureList = new ArrayList<>();
        FeatureJSON fjson = new FeatureJSON();
        StringWriter writer = new StringWriter();
        fjson.writeFeatureCollection(collection, writer);
        String json = writer.toString();
        File f = new File("D:\\POI.txt");
        if (!f.exists()) {
            f.createNewFile();
        }
        FileWriter fileWriter = new FileWriter(f);

        byte[] bytes = new byte[512];
        fileWriter.flush();
        fileWriter.write(json);
        fileWriter.close();
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