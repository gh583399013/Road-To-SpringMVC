package com.ft.test.test001.main;

import com.ft.test.test001.api.IUserManagerService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAopByAnotation {
    public static void main(String[] args) throws Exception {


//        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
//        ApplicationContext ac = new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml","dao.xml"});
//        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:/*.xml");
        ApplicationContext act = new ClassPathXmlApplicationContext("classpath:/test001/spring-context-anotation.xml");
        IUserManagerService userManager = (IUserManagerService) act.getBean("userManager");
        userManager.findUser();
        System.out.println("\n");
        userManager.addUser("fengtao","123456", 25);
    }
}