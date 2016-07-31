package com.hdsx.lh.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 定义控制器
 */
//BarController类的实例是一个控制器，会自动添加到Spring上下文中
@Controller
public class BarController {
	//映射访问路径
	@RequestMapping("/bar")
	public String index(Model model){
		//Spring MVC会自动实例化一个Model对象用于向视图中传值
		model.addAttribute("message", "这是通过注解定义的一个控制器中的Action");
		//返回视图位置
		return "foo/index";
	}
}
