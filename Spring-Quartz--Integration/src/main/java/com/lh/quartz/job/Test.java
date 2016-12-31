package com.lh.quartz.job;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Created by lh on 2016/12/31.
 */
@Component
public class Test {
    @Value("${configuration.keyword:testValue}")
    String testAttr;

    @PostConstruct
    void postConstruct() {
//      是用@Value注解得到值需要在构造函数调用完成之后，包括@PostConstruct
        System.out.println("Test构造函数调用");
        System.out.println("this.testAttr:" + this.testAttr);
    }
}
