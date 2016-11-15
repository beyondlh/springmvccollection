package com.lh.geojson;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by lh on 2016/11/15.
 */
public class AppTest extends SpringTestUtil{

    @Autowired
    AppConfig appConfig;
    @Test
    public void test(){
        System.out.println(appConfig.filePath);
    }
}
