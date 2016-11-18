package com.lh.geojson;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * Created by lh on 2016/11/18.
 */
public class LuceneConfigTest  extends SpringTestUtil{

    @Autowired
    LuceneConfig luceneConfig;

    @Test
    public void test(){
        System.out.println(luceneConfig.getIndexFilePath());
    }
}