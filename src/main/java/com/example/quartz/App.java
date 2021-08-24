package com.example.quartz;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdScheduler;
import org.quartz.impl.StdSchedulerFactory;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        try {
            JobDetail jobDetail = JobBuilder.newJob(HelloJob.class).withIdentity("helloJob", "group1").build();
            Trigger trigger = TriggerBuilder.newTrigger().withIdentity("simpleTrigger", "group1")
                                .withSchedule(SimpleScheduleBuilder.repeatSecondlyForTotalCount(10)).build();
            Scheduler scheduler = new StdSchedulerFactory().getScheduler();
            scheduler.scheduleJob(jobDetail, trigger);
            scheduler.start();

            JobDetail jobDetail2 = JobBuilder.newJob(ByeJob.class).withIdentity("byeJob", "group2").build();
            Trigger trigger2 = TriggerBuilder.newTrigger().withIdentity("simpleTrigger", "group2")
                                .withSchedule(CronScheduleBuilder.cronSchedule("0/5 * * * * ?")).build();
            Scheduler scheduler2 = new StdSchedulerFactory().getScheduler();
            scheduler2.scheduleJob(jobDetail2, trigger2);
            scheduler2.start();

        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
}
