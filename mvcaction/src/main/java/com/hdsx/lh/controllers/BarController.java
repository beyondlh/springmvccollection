package com.hdsx.lh.controllers;

import com.hdsx.lh.entities.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/bar")
public class BarController {
	//List与数组绑定基本数据类型
	@RequestMapping("/action11")
	public String action11(Model model,@RequestParam("id") List<Integer> ids){
		model.addAttribute("message",Arrays.deepToString(ids.toArray()));
		return "bar/index";
	}
	
	@RequestMapping("/action12")
	public String action12(Model model,@RequestParam("id") Integer[] ids){
		model.addAttribute("message",Arrays.deepToString(ids));
		return "bar/index";
	}
	
	//List与数组直接绑定自定义数据类型与AJAX
	@RequestMapping("/action21")
	public void action21(@RequestBody List<Product> products,HttpServletResponse response) throws IOException
	{
		response.setCharacterEncoding("UTF-8");
		System.out.println(Arrays.deepToString(products.toArray()));
		response.getWriter().write("添加成功");
	}
	
	@RequestMapping("/action22")
	@ResponseBody
	public List<Product> action22(@RequestBody List<Product> products)
	{
		products.get(0).setPrice(999.99);
		return products;
	}
	
	//返回值为String
	@RequestMapping("/action31")
	public String action31(Model model)
	{
		model.addAttribute("message","action31");
		return "bar/action31";
	}
	
	//@ResponseBody 将内容或对象作为 HTTP 响应正文返回，并调用适合HttpMessageConverter的Adapter转换对象，写入输出流。
	@RequestMapping("/action32")
	@ResponseBody
	public String action32()
	{
		return "not <b>path</b>,but <b>content</b>";
	}
	
	//返回值为void
	@RequestMapping("/action33")
	public String action33()
	{
		return "bar/action33";  //bar是控制器的路径
	}
	
	@RequestMapping("/action34")
	public void action34(HttpServletResponse response) throws IOException
	{
		response.getWriter().write("<h2>void method</h2>");
	}
	
	//ModelAndView
	@RequestMapping("/action35")
	public ModelAndView action35()
	{
		//1只指定视图
		//return new ModelAndView("/bar/index");
		
		//2分别指定视图与模型
		//Map<String, Object> model=new HashMap<String,Object>();
		//model.put("message", "ModelAndView action35");
		//return new ModelAndView("/bar/index",model);
		
		//3同时指定视图与模型
		//return new ModelAndView("/bar/index","message","action35 ModelAndView ");
		
		//4分开指定视图与模型
		ModelAndView modelAndView=new ModelAndView();
		//指定视图名称
		modelAndView.setViewName("/bar/index");
		//添加模型中的对象
		modelAndView.addObject("message", "<h2>Hello ModelAndView</h2>");
		return modelAndView;
	}
	
	//Map
	@RequestMapping("/action36")
	public Map<String, Object> action36()
	{
		Map<String, Object> model=new HashMap<String,Object>();
		model.put("message", "Hello Map");
		model.put("other", "more item");
		return model;
	}
	
	@RequestMapping("/action37")
	public int action37()
	{
		return 9527;
	}
	
	@RequestMapping("/action38")
	@ResponseBody
	public int action38()
	{
		return 9527;
	}
	
	@RequestMapping("/action39")
	@ResponseBody
	public Product action39()
	{
		return new Product(1,"iPhone",1980.5);
	}
	
	@RequestMapping("/action40")
	public Model action40(Model model)
	{
		model.addAttribute("message", "返回类型为org.springframework.ui.Model");
		return model;
	}
	
	@RequestMapping("/action41")
	@ResponseBody
	public String action41(HttpServletResponse response)
	{
		response.setHeader("Content-type","application/octet-stream");         
		response.setHeader("Content-Disposition","attachment; filename=table.xls"); //指定文件名
		return "<table><tr><td>Hello</td><td>Excel</td></tr></table>";
	}
	
}
