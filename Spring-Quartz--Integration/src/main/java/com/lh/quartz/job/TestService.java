package com.lh.quartz.job;

import org.springframework.stereotype.Service;

/**
 * Created by lh on 2016/12/31.
 */
@Service
public class TestService {

    String name = "lh";

    public TestService() {
        System.out.println("name:" + name);
    }

    public TestService(String name) {
        this.name = name;
        System.out.println("name:" + name);
    }

    public void tt() {
        System.out.println("Test输出");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
