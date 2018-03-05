package junit_test.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import junit_test.entity.Student;
import junit_test.service.TestService;

@Controller
@RequestMapping("/test")
public class TestController {
	@Autowired
	private TestService testService;

	/**
	 * post get接受字符串  return json
	 * @param request
	 * @param response
	 * @param text
	 * @return
	 */
	@RequestMapping(value = "/test001",method = {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public Map<String, Object> test001(HttpServletRequest request,HttpServletResponse response,String text){
		String test = testService.getStr("拼接传过来的" + text);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("test", test);
		return map;
	}


	/**
	 * post get接受字符串  return String
	 * @param request
	 * @param response
	 * @param text
	 * @return
	 */
	@RequestMapping(value = "/test002",method = {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public String test002(HttpServletRequest request,HttpServletResponse response,String text){
		String test = testService.getStr("拼接传过来的" + text);
		return test;
	}

	/**
	 * post get接受数组  return json
	 * 这里@RequestParam  填的是text  如果name 传的是text[] 那这里也填[]
	 * @param request
	 * @param response
	 * @param text
	 * @return
	 */
	@RequestMapping(value = "/test003A",method = {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public Map<String, Object> test003A(HttpServletRequest request,HttpServletResponse response, @RequestParam("text") String[] text){
		String test = "";
		if(StringUtils.isEmpty(text)){
			test = "啥也没有";
		}else{
			test = "取第二个" + text[1];
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("test", test);
		return map;
	}

	/**
	 * post get接受数组  return json
	 * @param request
	 * @param response
	 * @param text
	 * @return
	 */
	@RequestMapping(value = "/test003B",method = {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public Map<String, Object> test003B(HttpServletRequest request,HttpServletResponse response, String[] text){
		String test = "";
		if(StringUtils.isEmpty(text)){
			test = "啥也没有";
		}else{
			test = "取第一个" + text[1];
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("test", test);
		return map;
	}

	/**
	 * 接受参数封装成bean
	 * @param request
	 * @param response
	 * @param student
	 * @param text
	 */
	@RequestMapping(value = "/test004",method = {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public Map<String, Object> login(HttpServletRequest request,HttpServletResponse response,Student student,String text){
		Map<String, Object> map = new HashMap<String, Object>(2);
		map.put("student",student);
		map.put("text",text);

		return map;
	}

	/**
	 * 接受json数组参数 必须要用@RequestBody
	 * remark*-2
	 * springmvc controller在接受json数组的时候 不管是数组或者list接受 如String[] strArr 或 List<String> strList
	 * 一定要用@RequestBody
	 *
	 * @param studentList
	 * @return
	 */
	@RequestMapping(value = "/test005",method = {RequestMethod.POST})
	@ResponseBody
	public String test005(@RequestBody List<Student> studentList){
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

	/**
	 * 测试get 请求post
	 * @param request
	 * @param response
	 * @param student
	 * @return
	 */
	@RequestMapping(value = "/getPostFunc",method = {RequestMethod.POST})
	@ResponseBody
	public String getPostFunc(HttpServletRequest request,HttpServletResponse response,Student student){
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

}
