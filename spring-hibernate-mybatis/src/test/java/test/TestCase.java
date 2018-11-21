package test;

import com.ft.devPlugins.entity.Student;
import com.ft.devPlugins.service.StudentService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestCase {
	private ApplicationContext ctx;
	private StudentService service;
	@Before
	public void init() {
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		service = (StudentService)ctx.getBean("studentServiceImpl");
	}

	/**
	 * 获取系统时间（测试连接数据库是否成功）
	 */
	@Test
	public void getSystemTime() {
		//这里如果是下面这么写 回报代理类强制转换异常，百度一下 是Spring的两种代理JDK和CGLIB的区别浅谈
		//http://zhidao.baidu.com/link?url=ty5viyGhLquHmbAeM-X4LCPxUhPKgzrmAaUzvm-qz6CB1AA3NTdvguE9iKRDxDU33rp6nyj_cY2osXxF1xWtQHSxyNSk0c9TpQEL8zFJC9C
		//StudentService service = (StudentServiceImpl)ctx.getBean("studentServiceImpl");
		System.out.println(service.getSystemTime());
	}
	
//	/**
//	 * 获取系统时间（测试连接数据库是否成功）（代理模式）
//	 */
//	@Test
//	public void getSystemTime() {
//		ApplicationContext ctx =  new ClassPathXmlApplicationContext("applicationContext.xml");
//		StudentServiceImplProxy service = (StudentServiceImplProxy)ctx.getBean("studentServiceImplProxy");
//	}
	
	@Test
	public void testSaveStudent(){
		Student student = new Student();
		student.setName("测试学生1");
		student.setSex("M");
		try {
			System.out.println(service.saveStudent(student));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testSaveStudentWithException(){
		Student student = new Student();
		student.setName("测试学生2");
		student.setSex("M");
		try {
			System.out.println(service.saveStudentWithException(student));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	

	@Test
	public void testPersitStudentWithException1(){
		Student student = new Student();
		student.setName("测试学生3");
		student.setSex("M");
		try {
			System.out.println(service.persitStudentWithException1(student));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	

	@Test
	public void testPersitStudentWithException2(){
		Student student = new Student();
		student.setName("测试学生4");
		student.setSex("M");
		try {
			System.out.println(service.persitStudentWithException2(student));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
	
	@Test
	public void testSaveStudentByHibernate(){
		Student student = new Student();
		student.setName("学生1-hibernate");
		student.setSex("F");
		try {
			System.out.println(service.saveStudentByHibernate(student));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testSaveStudentByHibernateWithException1(){
		Student student = new Student();
		student.setName("学生2-hibernate");
		student.setSex("F");
		try {
			System.out.println(service.saveStudentByHibernateWithException1(student));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testSaveStudentByHibernateWithException2(){
		Student student = new Student();
		student.setName("学生3-hibernate");
		student.setSex("F");
		try {
			System.out.println(service.saveStudentByHibernateWithException2(student));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
	
	
	public static void main(String[] args) {
		ApplicationContext ctx =  new ClassPathXmlApplicationContext("applicationContext.xml");
		//这里如果是下面这么写 回报代理类强制转换异常，百度一下 是Spring的两种代理JDK和CGLIB的区别浅谈
		//http://zhidao.baidu.com/link?url=ty5viyGhLquHmbAeM-X4LCPxUhPKgzrmAaUzvm-qz6CB1AA3NTdvguE9iKRDxDU33rp6nyj_cY2osXxF1xWtQHSxyNSk0c9TpQEL8zFJC9C
		//StudentService service = (StudentServiceImpl)ctx.getBean("studentServiceImpl");
		StudentService service = (StudentService)ctx.getBean("studentServiceImpl");
		System.out.println(service.getSystemTime());
		
		Student student = new Student();
		student.setName("德玛西亚之力");
		student.setSex("M");
		try {
			System.out.println(service.saveStudent(student));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
