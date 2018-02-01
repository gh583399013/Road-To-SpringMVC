package com.ft.test002;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author mask
 * @date 2018/2/1 15:03
 * @desc
 */
public class TypeATask {
    public void execute(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sdf.format(new Date()) + "------A：使用 MethodInvokingJobDetailFactoryBean");
    }
}
