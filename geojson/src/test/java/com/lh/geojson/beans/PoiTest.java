package com.lh.geojson.beans;

import com.alibaba.fastjson.JSON;
import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.geom.GeometryFactory;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by lh on 2016/11/17.
 */
public class PoiTest {
    Logger logger = LoggerFactory.getLogger(PoiTest.class);


//    @Ignore
    @Test()
    public void test() {
        logger.debug("开始测试");

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
}