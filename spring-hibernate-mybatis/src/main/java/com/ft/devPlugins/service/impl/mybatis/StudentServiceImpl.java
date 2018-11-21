package com.ft.devPlugins.service.impl.mybatis;


import com.ft.devPlugins.dao.StudentDao;
import com.ft.devPlugins.entity.Student;
import com.ft.devPlugins.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

//@Service("studentServiceImpl")
@Service
public class StudentServiceImpl implements StudentService {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
//	@Autowired
//	private StudentDao studentDao;
	
	@Resource(name="studentDaoImplByMybatis")
	private StudentDao studentDao1;
	
	@Resource(name="studentDaoImplByHibernate")
	private StudentDao studentDao2;
	
	@Override
	public String getSystemTime() {
		System.out.println("执行到service层");
		return studentDao1.getDAOtime();
	}

	@Override
	public int saveStudent(Student student) throws Exception{
		int result = studentDao1.insert(student);
		logger.info("result =" + result);
		return result;
	}

	@Override
	public int saveStudentWithException(Student student) throws Exception {
		studentDao1.insert(student);
		throw(new Exception("来个异常"));
	}

	@Override
	public int persitStudentWithException1(Student student) throws Exception {
		studentDao1.insert(student);
		throw(new Exception("来个异常"));
	}

	@Override
	@Transactional(rollbackFor={Exception.class})
	public int persitStudentWithException2(Student student) throws Exception {
		int result = studentDao1.insert(student);
//		throw(new Exception("来个异常"));
		String text = "abc";
		text = text.substring(100);
		return result;
	}

	@Override
	public int saveStudentByHibernate(Student student) throws Exception {
		return studentDao2.insert(student);
	}

	@Override
	public int saveStudentByHibernateWithException1(Student student) throws Exception {
		studentDao2.insert(student);
		throw new Exception("error occured!");
	}

	@Override
	@Transactional(rollbackFor={Exception.class})
	public int saveStudentByHibernateWithException2(Student student) throws Exception {
		studentDao2.insert(student);
		throw new Exception("error occured!");
	}

}
