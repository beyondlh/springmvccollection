package com.lh.geojson.beans;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.geom.GeometryFactory;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by lh on 2016/11/17.
 */
public class PoiTest {

    @Test
    public void test() {
        Coordinate coordinate = new Coordinate(123, 456);
        GeometryFactory geometryFactory = new GeometryFactory();
        Geometry geometry = geometryFactory.createPoint(coordinate);
        Poi poi = new Poi();
        poi.setAddress("测试地址");
        poi.setName("xx饭店");
        poi.setTel("1254");
        poi.setGeometry(geometry);


        Poi poi2 = new Poi();
        poi2.setAddress("测试地址");
        poi2.setName("xx饭店");
        poi2.setTel("1254");
        poi2.setGeometry(geometry);

        if (poi.equals(poi2)) {
            System.out.println(true);
        }

        Assert.assertEquals(poi, poi2);
    }

}