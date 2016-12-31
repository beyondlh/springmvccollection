package com.lh.aop.demo;

import org.springframework.stereotype.Component;

/**
 * @description 
 *
 * @author lh
 *
 * @date 2016年6月24日 下午6:44:32
 */
@Component
public class Demo {
	public void test01() {
		System.out.println("test1");
		System.out.println("this对象指的不是代理类对象，而是原对象" + this.getClass());
		test02("hello nest ");
	}
	
	public String test02(String name) {
		return name;
	}
}
