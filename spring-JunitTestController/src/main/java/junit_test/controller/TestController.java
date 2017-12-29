package junit_test.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import junit_test.entity.Student;
import junit_test.service.TestService;

@Controller
@RequestMapping("/test")
public class TestController {
	@Autowired
	private TestService testService;
	
	@RequestMapping(value = "/test001",method = {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public Map<String, Object> dealPost(HttpServletRequest requst,HttpServletResponse response){
		String test = testService.getStr("new 一个对象");
		System.out.println(test);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("test", test);
		return map;
	}
	
	@RequestMapping(value = "/test002",method = {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public String dealPost1(HttpServletRequest requst,HttpServletResponse response){
		String test = testService.getStr("new 一个对象");
		System.out.println(test);
		return test;
	}

	@RequestMapping(value = "/test003",method = {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public void login(HttpServletRequest requst,HttpServletResponse response,Student student){
		System.out.println("id = " + student.getId());
		System.out.println("name = " + student.getName());
	}

	/**
	 * 测试get 请求post
	 * @param requst
	 * @param response
	 * @param student
	 * @return
	 */
	@RequestMapping(value = "/getPostFunc",method = {RequestMethod.POST})
	@ResponseBody
	public String getPostFunc(HttpServletRequest requst,HttpServletResponse response,Student student){
		return "你想用get请求post方法嘛 骚年";
	}


//	@RequestMapping(value = "/getJsonParam",method = {RequestMethod.POST})
//	@ResponseBody
//	public String getGetJsonParam(@RequestBody Student[] studentList){
//		if(studentList == null || studentList.length == 0){
//			return "吔屎啦你 传个空";
//		}else{
//			return JSON.toJSONString(studentList);
//		}
//	}

	/**
	 * 接受json数组参数 必须要用@RequestBody
	 * remark*-2
	 * springmvc controller在接受json数组的时候 不管是数组或者list接受 如String[] strArr 或 List<String> strList
	 * 一定要用@RequestBody
	 *
	 * @param studentList
	 * @return
	 */
	@RequestMapping(value = "/getJsonParam",method = {RequestMethod.POST})
	@ResponseBody
	public String getGetJsonParam(@RequestBody List<Student> studentList){
		if(studentList.isEmpty()){
			return "吔屎啦你 传个空";
		}else{
			Student student = new Student();
			student.setName("系统管理员");
			student.setId("-1");
			studentList.add(student);
			return JSON.toJSONString(studentList);
		}
	}
}
