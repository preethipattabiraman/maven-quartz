package com.example.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class ByeJob implements Job {

    private ByeService hs = new ByeService();
    @Override
    public void execute(JobExecutionContext arg0) throws JobExecutionException {
        hs.sayGoodBye();
        
    }
    
}
