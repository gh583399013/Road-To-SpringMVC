package com.ft.devPlugins.service.impl.mybatis;

import com.ft.devPlugins.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImplProxy {
	@Autowired
	private StudentService studentService;
	public String getSystemTime(){
		return studentService.getSystemTime();
	}
	public void before(){
		System.out.println("代理模式使用before方法");
	}
	public void after(){
		System.out.println("代理模式使用after方法");
	}
}
