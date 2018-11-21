package com.ft.devPlugins.dao;

import com.ft.devPlugins.entity.Student;

public interface StudentDao {
	public int insert(Student student);
	public int update(Student student);
	public String getDAOtime();
}
