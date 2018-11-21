package com.ft.test.test001.impl;

import com.ft.test.test001.api.IUserManagerService;
import org.springframework.stereotype.Service;

@Service("userManager")
public class UserManagerServiceImpl implements IUserManagerService {
    
private String name;
    
    public void setName(String name){
        this.name=name;
    }
    
    public String getName(){
        return this.name;
    }

    @Override
    public String findUser(){
        System.out.println("---->执行业务方法findUser,查找的用户是："+name+"");
        return name;
    }

    @Override
    public void addUser(String userName, String password, int age){
        System.out.println("---->执行业务方法addUser");
        System.out.println(String.format("新增用户 用户名:%s, 密码:%s  年龄:%d", userName, password, age));
    }
}