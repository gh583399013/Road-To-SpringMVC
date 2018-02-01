package com.ft.test002;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author mask
 * @date 2018/2/1 15:46
 * @desc
 */
public class Main {
    public static void main(String[] args) {
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("app.xml");
    }
}
