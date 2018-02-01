package com.ft.test002;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author mask
 * @date 2018/2/1 15:04
 * @desc
 */
public class TypeBTask extends QuartzJobBean {

    private TypeBTaskParam typeBTaskParam;

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        //remark*-1
        //传递参数的时候,定义个和key同名的参数接受并且要实现setter方法,
        //        或者直接去jobDataMap中去拿 然后强转
        System.out.println(sdf.format(new Date()) + "------B:使用 JobDetailFactoryBean");
        System.out.println("打印传参1-" + typeBTaskParam.getText());

        TypeBTaskParam typeBTaskParam2 = (TypeBTaskParam)context.getMergedJobDataMap().get("typeBTaskParam");
        System.out.println("打印传参2-" + typeBTaskParam2.getText());
    }

    public void setTypeBTaskParam(TypeBTaskParam typeBTaskParam) {
        this.typeBTaskParam = typeBTaskParam;
    }
}
