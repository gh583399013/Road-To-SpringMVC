package com.ft.devPlugins.mapper;

import com.ft.devPlugins.entity.Student;

public interface StudentMapper {
	/**
	 * 获取数据库当前时间（用于测试连接数据库是否成功）
	 * @return
	 */
	public String getTime();

	/**
	 * 插入一条学生记录
	 * @param student
	 * @return
	 */
	public int insert(Student student);
}
