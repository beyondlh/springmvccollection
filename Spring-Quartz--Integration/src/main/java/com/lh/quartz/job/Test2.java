package com.lh.quartz.job;

/**
 * Created by lh on 2016/12/31.
 */
public class Test2 {

    String name = "lh";

    public Test2() {
        System.out.println("name:" + name);
    }

    public Test2(String name) {
        this.name = name;
        System.out.println("name:" + name);
    }

    void tt() {
        System.out.println("Test2构造函数调用");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
