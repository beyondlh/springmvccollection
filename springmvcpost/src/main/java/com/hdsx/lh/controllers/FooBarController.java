package com.hdsx.lh.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping
public class FooBarController {
	@RequestMapping("/action1")
	public String action1(Model model) {
		// 在模型中添加属性message值为action1，渲染页面时使用
		model.addAttribute("message", "action1");
		return "foo/index";
	}

	@RequestMapping
	public String action2(Model model) {
		// 在模型中添加属性message值为action2，渲染页面时使用
		model.addAttribute("message", "action2");
		return "foo/index";
	}

	@RequestMapping("/action3/{p1}/{p2}")
	public String action3(@PathVariable int p1, @PathVariable int p2, Model model) {
		model.addAttribute("message", p1 + p2);
		return "foo/index";
	}

	// 正则
	@RequestMapping(value = "/action4/{id:\\d{6}}-{name:[a-z]{3}}")
	public String action4(@PathVariable int id, @PathVariable String name, Model model) {
		model.addAttribute("message", "id:" + id + " name:" + name);
		return "foo/index";
	}

	// 矩阵变量
	@RequestMapping(value = "/action5/{name}")
	public String action5(Model model, 
			@PathVariable String name, // 路径变量，用于获得路径中的变量name的值
			@MatrixVariable String r, 
			@MatrixVariable(required = true) String g, // 参数g是必须的
			@MatrixVariable(defaultValue = "99", required = false) String b) { // 参数b不是必须的，默认值是99
		model.addAttribute("message", name + " is #" + r + g + b);
		return "foo/index";
	}

	// Ant风格路径模式
	@RequestMapping(value = "/action6/*.do")
	public String action6(Model model) {
		model.addAttribute("message", "Ant风格路径模式");
		return "foo/index";
	}

	// 谓词类型
	@RequestMapping(value = "/action7", method = RequestMethod.GET)
	public String action7(Model model) {
		model.addAttribute("message", "请求谓词只能是GET");
		return "foo/index";
	}

}





