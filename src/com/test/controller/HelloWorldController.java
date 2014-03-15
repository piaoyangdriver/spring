package com.test.controller;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.test.dao.HelloDao;
import com.test.domain.HelloBean;
import com.test.service.HelloService;

@Controller
public class HelloWorldController extends BasicController {
	
	@RequestMapping("/testHello")
	public String helloWorld(Model model){
		model.addAttribute("message", "Hello World!");
		return "hello";		
	}
	
	@RequestMapping("/para")
	public String para(@RequestParam("userId") String userId, Model model){
		model.addAttribute("message", "Hello World!" + userId);
		return "hello";
		}
	
	@RequestMapping(value="/test/{userId}", method=RequestMethod.GET)
	public String printUser(@PathVariable("userId") String userId, Model model){
		model.addAttribute("message", "Hello World!" + userId);
		return "hello";
	}
	
	@RequestMapping(value="/handle2")
	public String handle2(@CookieValue(value = "JSESSIONID" ,required= false) String sessionId,
	       @RequestHeader("Accept-Language") String accpetLanguage){
		System.out.println("cookie id: " + sessionId + " accpetLanguage " + accpetLanguage);
		return "hello";
	}

	@RequestMapping("/handle14")
	public String handle14(@ModelAttribute User user, Model model){
		int age = user.getAge() + 10;
		String name = user.getName();
		model.addAttribute("message", "Age=" + age + " Name=" + name);
		return "hello";
	}

	@RequestMapping(value = "/handle41")
	public String handle41(@RequestBody  String requestBody ) {
	      System.out.println(requestBody);
	      return "hello";
	}
	
	//@Autowired 默认按类型装配，@Resource默认按名称装配
	@Resource(name="df")
	private HelloService helloServiceImpl;
	
	@Resource
	private HelloDao helloDaoImpl;
	
	
	@RequestMapping("/handle42")
	public String handle42(){
		helloServiceImpl.printMessage("hhhhh");
		
		HelloBean hb = new HelloBean();
		hb.setName("Tomcat");
		hb.setDate(new Date());
		hb.setAge(10);
		helloDaoImpl.save(hb);
		
		HelloBean bean = helloDaoImpl.getHello(1);
		System.out.println("username=" + bean.getName());
		return "hello";
	}
	
	@RequestMapping("json")
	@ResponseBody
	public String json(){
		JsonArray ja = new JsonArray();
		User user = new User();
		user.setName("Tom");
		user.setAge(19);
		ja.add(objectToJson(user));
		ja.add(objectToJson(user));
		return this.responseJson(true, ja);
	}
	
	private JsonObject objectToJson(User u){
		JsonObject jo = new JsonObject();
		jo.addProperty("name", u.getName());
		jo.addProperty("age", u.getAge());
		return jo;
	}

}
