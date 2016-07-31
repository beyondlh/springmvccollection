package com.hdsx.lh.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class HomeController {
	// 请求内容类型必须为text/html，注意浏览器默认没有指定Content-type
	@RequestMapping(value = "/action8",consumes="text/html")
	public String action8(Model model) {
		model.addAttribute("message", "请求的提交内容类型（Content-Type）是text/html");
		return "foo/index";
	}
	
	//客户端接收json且编码为utf-8，多数浏览器Accept设置的为*/*，接收任意类型
	@RequestMapping(value = "/action9",produces="application/json; charset=UTF-8")
	public String action9(Model model) {
		model.addAttribute("message", "客户端可以接收的类型是application/json; charset=UTF-8");
		return "foo/index";
	}
	
	//请求的参数必须包含id=215与name不等于abc
	@RequestMapping(value = "/action10",params={"id=215","name!=abc"})
	public String action10(Model model) {
		model.addAttribute("message", "请求的参数必须包含id=215与name不等于abc");
		return "foo/index";
	}
	
	//请求头部信息中必须包含Host=localhost:8087
	@RequestMapping(value = "/action11",headers="Host=localhost:8087")
	public String action11(Model model) {
		model.addAttribute("message", "请求头部信息中必须包含Host=localhost:8087");
		return "foo/index";
	}
	
	//映射访问路径为/action12或/myaction，指定映射名称为actionTest
	@RequestMapping(path ={"/action12","/myaction"},name="actionTest")
	public String action12(Model model) {
		model.addAttribute("message", "映射访问路径为/action12或/myaction，指定映射名称为actionTest");
		return "foo/index";
	}
}