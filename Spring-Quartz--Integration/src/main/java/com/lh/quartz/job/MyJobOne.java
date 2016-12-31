package com.lh.quartz.job;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

/**
 * Created by lh on 2016/12/30.
 */
public class MyJobOne implements Job {
    /**
     * <p>
     * 无参数构造函数
     * </p>
     * <p>
     * Quartz requires a public empty   so that the
     * scheduler can instantiate the class whenever it needs.
     * </p>
     */
    public MyJobOne() {

    }
    /**
     * <p>
     * Called by the <code>{@link org.quartz.Scheduler}</code> when a
     * <code>{@link org.quartz.Trigger}</code> fires that is associated with
     * the <code>Job</code>.
     * </p>
     *
     * @throws JobExecutionException if there is an exception while executing the job.
     */
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.err.println("Hello World!  MyJobOne is executing.");
    }
}
