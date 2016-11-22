package com.lh.geojson.beans;

import com.alibaba.fastjson.JSON;
import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.geom.GeometryFactory;
import org.junit.*;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertThat;

/**
 * Created by lh on 2016/11/17.
 */
public class PoiTest {

//    @Ignore
    @Test()
    public void test() {
        Coordinate coordinate = new Coordinate(123, 456);
        GeometryFactory geometryFactory = new GeometryFactory();
        Geometry geometry = geometryFactory.createPoint(coordinate);
        POI poi = new POI();
        poi.setAddress("测试地址");
        poi.setName("xx饭店");
        poi.setTel("1254");
        poi.setGeometry(geometry);


        POI poi2 = new POI();
        poi2.setAddress("测试地址");
        poi2.setName("xx饭店");
        poi2.setTel("1254");
        poi2.setGeometry(geometry);

        if (poi.equals(poi2)) {
            System.out.println(true);
            System.out.println(JSON.toJSONString(poi));
        }
        Assert.assertEquals(poi, poi2);
    }

    @BeforeClass
    public static void runOnceBeforeClass() {
        System.out.println("@BeforeClass - runOnceBeforeClass");
    }

    // Run once, e.g close connection, cleanup
    @AfterClass
    public static void runOnceAfterClass() {
        Map<String, String> map = new HashMap<>();
        map.put("j", "java");
        map.put("c", "c++");
        map.put("p", "python");
        map.put("n", "node");

        Map<String, String> expected = new HashMap<>();
        expected.put("n", "node");
        expected.put("c", "c++");
        expected.put("j", "java");
        expected.put("p", "python");

        //All passed / true

        //1. Test equal, ignore order
        System.out.println("@AfterClass - runOnceAfterClass");
    }
}