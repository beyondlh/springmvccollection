package com.lh.aop.demo;

import org.springframework.stereotype.Service;

/**
 * @description
 *
 * @author lh
 *
 * @date 2016年6月27日 上午9:32:04
 */
@Service
public class InterfaceDemoImpl implements InterfaceDemo {

	@Override
	public String teString(String name) {
		return "test string";
	}

	@Override
	public void testAnother() {
		System.out.println("this 对象" + this.getClass());
		teString("hello 接口代理");
	}

}
