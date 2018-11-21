package com.ft.devPlugins.dao.impl;

import com.ft.devPlugins.dao.BaseDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

public class BaseDaoImpl<T> implements BaseDao<T> {
	@Autowired
	private SessionFactory sessionFactory;
	private Session openSession(){
		System.out.println("这里打开了session没有啊");
		return sessionFactory.getCurrentSession();
	}
	private Class<?> clazz = null;
	//直接传入实体类的class   属于第一种方法
	public BaseDaoImpl(Class<?> clazz){
		this.clazz = clazz;
	}
	
	//利用java反射，获取实际class
	public BaseDaoImpl(){
        //利用泛型的反射在实例化时拿到实体类的字节码
        Type t = this.getClass().getGenericSuperclass();
        ParameterizedType pt =  (ParameterizedType)t;
        Type actualType = pt.getActualTypeArguments()[0];
        clazz = (Class<?>)actualType;
    }
	
	@Override
	public int insert(T t) {
		Session session = openSession();
		session.save(t);
		return 0;
	}

	@Override
	public int update(T t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int get(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(T t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int remove(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<T> getList(int page, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

}
