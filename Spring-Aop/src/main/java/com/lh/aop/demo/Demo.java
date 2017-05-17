package com.lh.aop.demo;

import org.aspectj.lang.annotation.AdviceName;
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
		test02("hello test,类内部调用 ");
	}
	
	public void test02(String name) {
		System.out.println("this对象指的不是代理类对象，而是原对象" + this.getClass());
		System.out.println(name);
	}
}
