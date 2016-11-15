package com.lh.spring.web.servlet.handler;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;

/**
 * Created by lh on 2016/11/10.
 */
@Controller
public class TestBean {
    /*尝试值自动注入*/
//    @Value("configuration.keyword")
    @Value("testvalue")
    String name;
    String age;
}
