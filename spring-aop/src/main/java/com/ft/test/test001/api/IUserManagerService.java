package com.ft.test.test001.api;

public interface IUserManagerService {
    //查找用户
    public String findUser();
    
    //添加用户
    public void addUser(String userName, String password, int age);
}