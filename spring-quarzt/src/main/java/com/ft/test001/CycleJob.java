package com.ft.test001;

import org.quartz.*;

@DisallowConcurrentExecution
public class CycleJob implements Job {
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {

        JobDataMap data = context.getJobDetail().getJobDataMap();
        System.out.println("这是一个周期性执行的job。参数：" + data.getString("key"));
    }
}