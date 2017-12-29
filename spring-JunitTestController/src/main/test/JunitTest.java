import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

/** 
 * @author zhzh 
 * 2015-4-7 
 */  
@RunWith(SpringJUnit4ClassRunner.class)    
@WebAppConfiguration    
@ContextConfiguration({"classpath*:/junt-test-applicationContext.xml"})
//当然 你可以声明一个事务管理 每个单元测试都进行事务回滚 无论成功与否    
//@TransactionConfiguration(defaultRollback = true)    
//@Transactional   
public class JunitTest {  
    @Autowired    
    private WebApplicationContext wac;    
    
    private MockMvc mockMvc;   
      
    @Before
    public void setup() {     
        this.mockMvc = webAppContextSetup(this.wac).build();  
    }

//    String responseString = mockMvc.perform(
//            get("/categories/getAllCategory")    //请求的url,请求的方法是get
//                    .contentType(MediaType.APPLICATION_FORM_URLENCODED)  //数据的格式
//            　　　　　　　　　　　　　　 .param("pcode","root")         //添加参数
//        ).andExpect(status().isOk())    //返回的状态是200
//            .andDo(print())         //打印出请求和相应的内容
//            .andReturn().getResponse().getContentAsString();   //将相应的数据转换为字符串
//        System.out.println("--------返回的json = " + responseString);


    /**
     * 测试get 请求post
     * @throws Exception
     */
    @Test
    public void testGetPostFunc() throws Exception {
        String reponse =mockMvc.perform((get("/test/getPostFunc")))
            	.andExpect(status().isOk())
    	.andDo(print()).andReturn().getResponse().getContentAsString();
        System.out.println(reponse);
    }

    /**
     * 测试接受json对象
     * @throws Exception
     */
    @Test
    public void testGetJsonParam() throws Exception {
        String paramJson = "[{\"name\":\"fengtao\",\"id\":\"1\"},{\"name\":\"chensi\",\"id\":\"2\"}]";
        String reponse =mockMvc.perform((post("/test/getJsonParam").contentType(MediaType.APPLICATION_JSON_UTF8).content(paramJson)))
                .andExpect(status().isOk())
                .andDo(print()).andReturn().getResponse().getContentAsString();
        System.out.println(reponse);
    }

    @Test    
    public void testGetStr() throws Exception {   
//    	mockMvc.perform((post("/test/test001").param("userName", "admin").param("password", "1")))
//    	.andExpect(status().isOk())    
//    	.andDo(print());  
    	
    	MvcResult result = mockMvc.perform((post("/test/test001").param("userName", "admin").param("password", "1"))).andReturn();
    	MockHttpServletResponse res = result.getResponse();
    	/*
    	 * remark*-1
    	 * 浏览器访问不乱码，但是junit访问怎么都乱码，必须setCharacterEncoding一次
    	 * 原因是通过浏览器 我们是经过了web.xml中的过滤器，request和response都被强制编码了一次
    	 * 但是junit不经过web.xml,所以默认编码是ISO-9958-1
    	 */
    	res.setCharacterEncoding("UTF-8");
    	System.out.println(res.getContentAsString());
    }    
    
    @Test    
    public void testGetSt1r() throws Exception {   
//    	mockMvc.perform((post("/test/test001").param("userName", "admin").param("password", "1")))
//    	.andExpect(status().isOk())    
//    	.andDo(print());  
    	
    	MvcResult result = mockMvc.perform((post("/test/test002").param("userName", "admin").param("password", "1"))).andReturn();
    	MockHttpServletResponse res = result.getResponse();
//    	res.setCharacterEncoding("UTF-8");
    	System.out.println(res.getContentAsString());
    } 
    
    @Test    
    public void testLogin() throws Exception {   
//    	mockMvc.perform((post("/test/test001").param("userName", "admin").param("password", "1")))
//    	.andExpect(status().isOk())    
//    	.andDo(print());  
    	
    	mockMvc.perform((post("/test/test003").param("id", "1110321207").param("name", "fengtao")))
    	    	.andExpect(status().isOk())    
    	    	.andDo(print());  
    }     
      
    /*@Test   
    //有些单元测试你不希望回滚   
    @Rollback(false)   
    public void testInsert() throws Exception {   
        mockMvc.perform((post("/insertTest"))).andExpect(status().isOk())   
                .andDo(print());   
    } */  
}