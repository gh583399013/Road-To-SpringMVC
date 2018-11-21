package com.ft.controller;

import base.BaseTest;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class JunitTest extends BaseTest {

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
    public void testTest005() throws Exception {
        String paramJson = "[{\"name\":\"fengtao\",\"id\":\"1\"},{\"name\":\"chensi\",\"id\":\"2\"}]";
        String reponse =mockMvc.perform((post("/test/test005").contentType(MediaType.APPLICATION_JSON_UTF8).content(paramJson)))
                .andExpect(status().isOk())
                .andDo(print()).andReturn().getResponse().getContentAsString();
        System.out.println(reponse);
    }

    @Test
    public void testTest006() throws Exception {
        String paramJson = "{\"name\":\"fengtao\",\"id\":\"1\"}";
        String reponse =mockMvc.perform((post("/test/test006").contentType(MediaType.APPLICATION_JSON_UTF8).content(paramJson)))
                .andExpect(status().isOk())
                .andDo(print()).andReturn().getResponse().getContentAsString();
        System.out.println(reponse);
    }

    @Test
    public void testTest007() throws Exception {
        String paramJson = "{\"name\":\"fengtao\",\"id\":\"1\"}";
        String reponse =mockMvc.perform((post("/test/test007").contentType(MediaType.APPLICATION_JSON_UTF8).content(paramJson)))
                .andExpect(status().isOk())
                .andDo(print()).andReturn().getResponse().getContentAsString();
        System.out.println(reponse);
    }

    @Test    
    public void test001() throws Exception {
//    	mockMvc.perform((post("/test/test001").param("userName", "admin").param("password", "1")))
//    	.andExpect(status().isOk())    
//    	.andDo(print());  
    	
    	MvcResult result = mockMvc.perform((post("/test/test001").param("text", "maru小天使"))).andReturn();
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
    public void test002() throws Exception {
//    	mockMvc.perform((post("/test/test001").param("userName", "admin").param("password", "1")))
//    	.andExpect(status().isOk())    
//    	.andDo(print());  
    	
    	MvcResult result = mockMvc.perform((post("/test/test002").param("text", "maru小天使"))).andReturn();
    	MockHttpServletResponse res = result.getResponse();
    	res.setCharacterEncoding("UTF-8");
    	System.out.println(res.getContentAsString());
    }

    /**
     * get请求传输中文
     * @throws Exception
     */
    @Test
    public void test003A() throws Exception {
        MvcResult result = mockMvc.perform((get("/test/test003A").param("text","maru小天使","soO输本"))).andDo(print()).andReturn();
        MockHttpServletResponse res = result.getResponse();
    	res.setCharacterEncoding("UTF-8");
        System.out.println(res.getContentAsString());
    }

    @Test
    public void test003B() throws Exception {
        MvcResult result = mockMvc.perform((get("/test/test003B").param("text","maru小天使","soO输本"))).andDo(print()).andReturn();
        MockHttpServletResponse res = result.getResponse();
        res.setCharacterEncoding("UTF-8");
        System.out.println(res.getContentAsString());
    }

    @Test
    public void test004() throws Exception {
        MvcResult result = mockMvc.perform((get("/test/test004").param("id","韩服NO.1").param("name","输本").param("text","无冕之王 史诗十亚"))).andDo(print()).andReturn();
        MockHttpServletResponse res = result.getResponse();
        res.setCharacterEncoding("UTF-8");
        System.out.println(res.getContentAsString());
    }

    @Test    
    public void testLogin() throws Exception {   
//    	mockMvc.perform((post("/test/test001").param("userName", "admin").param("password", "1")))
//    	.andExpect(status().isOk())    
//    	.andDo(print());  
    	
    	mockMvc.perform((post("/test/test001")))
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