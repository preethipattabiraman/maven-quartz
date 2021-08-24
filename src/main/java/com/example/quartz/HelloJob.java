package com.example.quartz;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.Job;

public class HelloJob implements Job {
    private HelloService hs = new HelloService();
    public void execute(JobExecutionContext context) throws JobExecutionException {
        hs.sayHello();
    }
    
}
