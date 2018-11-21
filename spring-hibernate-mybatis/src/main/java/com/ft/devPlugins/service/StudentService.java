package com.ft.devPlugins.service;

import com.ft.devPlugins.entity.Student;

/**
 * 
 * @author fengtao
 *
 */
public interface StudentService {
	/**
	 * 获取数据库时间（用作测试连接数据库是否成功）
	 * @return
	 */
	public String getSystemTime();
	
	/**
	 * 保存一个学生信息
	 * @param student
	 * @return
	 * @throws Exception
	 */
	public int saveStudent(Student student) throws Exception;
	
	/**
	 * 保存一个学生信息，并抛出异常，使用事务，看是否回滚（事务采用xml配置）
	 * @param student
	 * @return
	 * @throws Exception
	 */
	public int saveStudentWithException(Student student) throws Exception;
	
	/**
	 * 保存一个学生信息，并抛出异常，不采用事务
	 * @param student
	 * @return
	 * @throws Exception
	 */
	public int persitStudentWithException1(Student student) throws Exception;	
	
	/**
	 * 保存一个学生信息，并抛出异常，使用事务，看是否回滚（事务采用xml配置）
	 * @param student
	 * @return
	 * @throws Exception
	 */
	public int persitStudentWithException2(Student student) throws Exception;
	
	/**
	 * 保存学生信息-通过hibernate
	 * @param student
	 * @return
	 * @throws Exception
	 */
	public int saveStudentByHibernate(Student student) throws Exception;
	
	/**
	 * 保存学生信息-通过hibernate(并抛出异常，不回滚)
	 * @param student
	 * @return
	 * @throws Exception
	 */
	public int saveStudentByHibernateWithException1(Student student) throws Exception;
	/**
	 * 保存学生信息-通过hibernate(并抛出异常，回滚)
	 * @param student
	 * @return
	 * @throws Exception
	 */
	public int saveStudentByHibernateWithException2(Student student) throws Exception;	
}
