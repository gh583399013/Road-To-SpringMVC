package com.ft.devPlugins.dao.impl;

import com.ft.devPlugins.dao.StudentDao;
import com.ft.devPlugins.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("studentDaoImplByHibernate")
public class StudentDaoImplByHibernate implements StudentDao{
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session openSession(){
		System.out.println("这里打开了session没有啊");
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public int insert(Student student) {
		Session session = openSession();
		session.save(student);
		return 0;
	}

	@Override
	public int update(Student student) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getDAOtime() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
