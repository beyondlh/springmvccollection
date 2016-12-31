package com.lh.aop.aspect.demo;

/**
 * @description 
 *
 * @author lh
 *
 * @date 2016年6月27日 下午1:51:14
 */
public aspect AspectAopDemo {
pointcut demo() : execution(* com.doctor.aop.demo.Demo.* (..));

before() : demo() {
	System.out.println("AspectAopDemo===before  " + thisJoinPoint);
}

after() : demo() {
	System.out.println("AspectAopDemo===after   " + thisJoinPoint);
 }
}
