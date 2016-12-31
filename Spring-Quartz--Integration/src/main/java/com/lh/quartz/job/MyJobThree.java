package com.lh.quartz.job;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by lh on 2016/12/31.
 */
public class MyJobThree {

    public MyJobThree(){

    }
    /**
     * 执行定时统计任务
     * 自行指定方法
     */
    public void execute() {
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + "执行ExampleJob2");
    }
}
