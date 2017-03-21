package com.kaikeba.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.kaikeba.entity.User;
import com.kaikeba.service.UserService;
 
@Controller
@RequestMapping("/user")//放在类上 表示的是前置路径  访问  都要加user      类似struts的namespace的概念
public class HelloController {
	@Autowired
	private UserService userServcie;
	@RequestMapping("hello")  //hello 与前面的* 号匹配 是访问路径   这个路径是不加后缀的  加/ 和不加 效果一样
	public String hello(){
		//这里返回的 是jsp 页面
		return "/index.jsp";
		//return"redirect:/index.jsp";  //重定向
	}
	
	@RequestMapping("hello2")
	public ModelAndView hello2(){
		// springmvc-servlet.xml 配置过前缀 和后缀  之后 是不用加 后缀 前缀的
		//创建model对象   map对象   赋值map  map放到model   前台el获取
		return new ModelAndView("/index.jsp");
	}
	@RequestMapping("/aa")
	public String aa(){
		return "aa";//这里返回的是jsp页面的路径 = prefix + "aa" + suffix = /jsps/aa.jsp
	}
	
	@RequestMapping("/aa1")
	public String aa1(){
		return "redirect:/jsps/aa1.jsp";// 重定向 不能用于 上面 省写 前缀 后缀
	}
	
	@RequestMapping(value="/hello5", method={RequestMethod.POST})// 加斜杠和不加是一样的效果
	public String hello5(){
		return "index";//这里返回的是jsp页面的路径 ,这个路径是不加后缀.
	}
	
	
	
	@RequestMapping("/validateLiginname")
	@ResponseBody  //把返回值作为整个内容输出到response对象中
	public boolean validateLiginname(){
		String loginname="abc";
		//查询数据库, 判断是否存在, 如果存在true, 不存在false
		return true;
		
	}
	
	
	

	@RequestMapping("listuser")
	@ResponseBody//把返回值作为整个内容输出到response对象中
	public User listUser(){
		String loginname = "abc";
		//查询数据库, 返回List<user>
		List<User> userlist = new ArrayList();
		User user = new User();
		user.setName("abc");
		user.setAge(12);
		user.setId(1);
		userlist.add(user);
		return user;
	}
	
	/**
	 * 参数的绑定
	 */
	@RequestMapping("add")
	public String addUser(){
		User user = new User();
		user.setName("aaa");
		//添加数据到数据源
		userServcie.addUser(user);
		return "success";
	}
	
	
	@RequestMapping("add2")
	public String addUser2(String name,Integer age,User user){
		
		System.out.print(name);
		System.out.println(age);
		System.out.println("--------------");
    	System.out.println(user.getName());
		System.out.println(user.getAge());
		//添加数据到数据源
	    userServcie.addUser(user);
		return "success";
	}
	
	
	/**
	 * 从数据库获取一个user数据, 在页面上展示出来
	 * @return
	 */
	@RequestMapping("get")
	public ModelAndView getUser(){
		User user = new User();
		user.setName("asdf");
		user.setAge(23);
		return new ModelAndView("user").addObject("u", user);
	}
	
	@RequestMapping("get1")
	public String getUser1(
			HttpServletRequest request, 
			HttpServletResponse response, 
			HttpSession session){
		User user = new User();
		user.setName("asdf");
		user.setAge(23);
		request.setAttribute("u", user);
		System.out.println("显示response:"+response);
		System.out.println("显示session:"+session);
		return "user";// /jsps/user.jsp
	}
	
	@RequestMapping("upload")
	@ResponseBody
	public String fileupload(@RequestParam("xxx") CommonsMultipartFile file) throws Exception{
		//file.getBytes();//文件的内容
		System.out.println("文件名:"+file.getOriginalFilename());
		String content = new String(file.getBytes(),"UTF-8");
		System.out.println("文件内容:"+content);
		return null;
	}
}
