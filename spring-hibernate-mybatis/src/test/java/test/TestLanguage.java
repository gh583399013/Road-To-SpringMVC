package test;

import com.ft.devPlugins.entity.Language;
import com.ft.devPlugins.service.LanguageService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestLanguage {
	private LanguageService languageService;
	private ApplicationContext ctx;
	@Before
	public void init(){
		//加载spring上下文环境
		ctx =  new ClassPathXmlApplicationContext("applicationContext.xml");
		languageService = (LanguageService)ctx.getBean("languageServiceImpl");
	}
	@Test
	public void testSaveLanguage(){
		Language language = new Language();
		language.setRank("1");
		language.setName("java");
		language.setDescription("java是使用人数最多的语言");
		System.out.println(languageService.saveLanguage(language));
	}

	@Test
	public void testSaveLanguageWithException(){
		Language language = new Language();
		language.setRank("1");
		language.setName("java");
		language.setDescription("java是使用人数最多的语言-withException");
		try {
			System.out.println(languageService.saveLanguageWithException(language));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
	
	public static void main(String[] args) {
		
	}
}
