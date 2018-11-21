package test;

import com.ft.devPlugins.service.StudentService;
import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestByMain {
	
	@Before
	private void intiContext(){
		ApplicationContext ctx =  new ClassPathXmlApplicationContext("applicationContext.xml");
	}
	
	@Autowired
	private StudentService studentService;
	
	public void getSystemTime(){
		System.out.println(studentService.getSystemTime());
	}
	
	public static void main(String[] args) {
		TestByMain main = new TestByMain();
		main.getSystemTime();
	}
}
