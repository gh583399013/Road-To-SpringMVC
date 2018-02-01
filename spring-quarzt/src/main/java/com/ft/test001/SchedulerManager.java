package com.ft.test001;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.quartz.CronScheduleBuilder.cronSchedule;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

public class SchedulerManager {

    private static final Logger LOGGER = LoggerFactory.getLogger(SchedulerManager.class);

    private static SchedulerFactory sf = new StdSchedulerFactory();
    private static Scheduler scheduler;
    static{
        try{
            LOGGER.info("------------------------- SchedulerManager.start----------------");
            // 通过SchedulerFactory来获取一个调度器scheduler
            scheduler = sf.getScheduler();
            scheduler.start();
        }
        catch(SchedulerException e){
            LOGGER.error("SchedulerManager.start.error", e);
        }
    }

    public static Scheduler getScheduler() {
        return scheduler;
    }

    public static String getSchedulerName() throws SchedulerException {
        return scheduler.getSchedulerName();
    }

    /**
     * 创建周期执行的job
     * 
     * @param jobId
     * @throws SchedulerException
     */
    public static void createCycleJob(Integer jobId) throws Exception {
        JobKey jobKey = JobKey.jobKey("cycleJob_" + jobId, getSchedulerName());
        if(scheduler.checkExists(jobKey)){
            throw new IllegalStateException("[周期任务JobKey: " + jobKey + "] 已经存在");
        }

        // 作业
        JobDetail job = newJob(CycleJob.class).withIdentity(jobKey).requestRecovery(true).build();

        // 设置job参数
        job.getJobDataMap().put("key", "jobId=" + jobId);

        // 计划表达式 cron 一秒执行一次
        String corn = "* */1 * * * ?";

        // 触发器
        CronTrigger trigger = newTrigger().withIdentity("cycleTrigger_" + jobId, getSchedulerName())
                .withSchedule(cronSchedule(corn)).build();

        // 作业和触发器设置到调度器中
        SchedulerManager.getScheduler().scheduleJob(job, trigger);
    }

    /**
     * 创建立刻执行的job
     * 
     * @param jobId
     * @throws SchedulerException
     */
    public static void createStartNowJob(Integer jobId) throws Exception {
        JobKey jobKey = JobKey.jobKey("startNowJob_" + jobId, getSchedulerName());
        if(scheduler.checkExists(jobKey)){
            throw new IllegalStateException("[立刻执行的JobKey: " + jobKey + "] 已经存在");
        }

        JobDetail job = newJob(StartNowJob.class).withIdentity(jobKey).requestRecovery(true).build();
        job.getJobDataMap().put("key", "jobId=" + jobId);

        Trigger trigger = newTrigger().withIdentity("startNowTrigger" + jobId, getSchedulerName()).startNow().build();

        SchedulerManager.getScheduler().scheduleJob(job, trigger);
    }

    /**
     * 创建定时执行的job
     * 
     * @param jobId
     * @throws SchedulerException
     */
    public static void createStartFixedTimeJob(Integer jobId) throws Exception {
        JobKey jobKey = JobKey.jobKey("startFixedTimeJob_" + jobId, getSchedulerName());
        if(scheduler.checkExists(jobKey)){
            throw new IllegalStateException("[定时执行的JobKey: " + jobKey + "] 已经存在");
        }

        JobDetail job = newJob(StartFixedTimeJob.class).withIdentity(jobKey).requestRecovery(true).build();
        job.getJobDataMap().put("key", "jobId=" + jobId);

        // 定时执行。2017-04-25 09:58:00分执行
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

        //Date date = DateUtils.parseDate("2017-04-25 09:59:00", new String[]{"yyyy-MM-dd hh:mm:ss"});
        Date date = simpleDateFormat.parse("2017-04-25 09:59:00");
        Trigger trigger = newTrigger().withIdentity("srartNowTrigger" + jobId, getSchedulerName()).startAt(date)
                .build();
        SchedulerManager.getScheduler().scheduleJob(job, trigger);
    }

    /**
     * 删除job
     * 
     * @param jobId
     * @throws SchedulerException
     */
    public static void stopCycleTaskJob(Integer jobId) throws SchedulerException {
        JobKey jobKey = JobKey.jobKey("cycleJob_" + jobId, getSchedulerName());
        if(scheduler.checkExists(jobKey)){
            scheduler.deleteJob(jobKey);
            LOGGER.info("------SchedulerManager.stopCycleTaskJob: delete the job jobKey [" + jobKey + "]");
        }
    }
}