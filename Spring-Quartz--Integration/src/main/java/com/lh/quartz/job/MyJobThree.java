package com.lh.quartz.job;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by lh on 2016/12/31.
 */
@Component("myJob")
public class MyJobThree {

    @Autowired
    Test test;


    @Autowired
    TestService testService;

    public MyJobThree(){

    }
    /**
     * 执行定时统计任务
     * 自行指定方法
     */
    public void execute() {
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + "执行ExampleJob2");
        System.out.println(test.getTestAttr());
        testService.tt();
    }
}
