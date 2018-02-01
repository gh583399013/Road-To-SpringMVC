package com.ft.test001;

/**
 * @author mask
 * @date 2018/2/1 14:45
 * @desc
 */
public class SchedulerManagerTest {

    public static void main(String[] args) {
        SchedulerManagerTest test = new SchedulerManagerTest();
        try {
            test.test3();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void test1(){
        try {
            SchedulerManager.createCycleJob(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void test2(){
        try {
            SchedulerManager.createStartFixedTimeJob(2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void test3(){
        try {
            SchedulerManager.createStartNowJob(3);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}