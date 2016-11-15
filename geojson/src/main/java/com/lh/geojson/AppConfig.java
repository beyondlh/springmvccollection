package com.lh.geojson;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * Created by lh on 2016/11/15.
 */
@Component
public class AppConfig {
    @Value("${shape.dir}")
    String filePath;
}