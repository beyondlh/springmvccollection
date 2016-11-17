package com.lh.geojson;

/**
 * Created by lh on 2016/11/15.
 */
public class App {
    public static void main(String[] args) {
        AppConfig appConfig = (AppConfig) ApplicationContextHelper.getBean(AppConfig.class);
        System.out.println(appConfig.shapeFilePathDir);
    }
}