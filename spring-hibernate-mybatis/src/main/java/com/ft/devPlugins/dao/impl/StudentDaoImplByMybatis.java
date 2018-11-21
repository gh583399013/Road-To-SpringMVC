package com.ft.devPlugins.dao.impl;

import com.ft.devPlugins.dao.StudentDao;
import com.ft.devPlugins.entity.Student;
import com.ft.devPlugins.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("studentDaoImplByMybatis")
public class StudentDaoImplByMybatis implements StudentDao{
	@Autowired
	private StudentMapper studentMapper;

	@Override
	public int insert(Student student) {
		int result = studentMapper.insert(student);
		return result;
	}

	@Override
	public int update(Student student) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getDAOtime() {
		System.out.println("执行到dao层");
		return studentMapper.getTime();
	}
	
}
