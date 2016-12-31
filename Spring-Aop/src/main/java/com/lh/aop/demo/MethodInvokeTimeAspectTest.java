package com.lh.aop.demo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @description
 *
 * @author lh
 *
 * @date 2016年6月24日 下午6:44:12
 * 
 *       spring代理嵌套方法调用不生效
 * 
 *       Spring AOP defaults to using standard JDK dynamic proxies for AOP
 *       proxies. This enables any interface (or set of interfaces) to be
 *       proxied.
 * 
 *       Spring AOP can also use CGLIB proxies. This is necessary to proxy
 *       classes rather than interfaces. CGLIB is used by default if a business
 *       object does not implement an interface. As it is good practice to
 *       program to interfaces rather than classes; business classes normally
 *       will implement one or more business interfaces. It is possible to force
 *       the use of CGLIB, in those (hopefully rare) cases where you need to
 *       advise a method that is not declared on an interface, or where you need
 *       to pass a proxied object to a method as a concrete type.
 * 
 *       It is important to grasp the fact that Spring AOP is proxy-based. See
 *       Section 11.6.1, “Understanding AOP proxies” for a thorough examination
 *       of exactly what this implementation detail actually means.
 * 
 * 
 * 
 *       通过配置 <aop:aspectj-autoproxy proxy-target-class="true" />可以统一用CGLIB
 *       proxies。
 * 
 */
public class MethodInvokeTimeAspectTest {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"classpath:/aopDemo1/spring-aop.xml");
		Demo demo = applicationContext.getBean(Demo.class);
		demo.test01();
		demo.test02("doctor who");
		System.out.println("注入到spring容器的类实例是代理类" + demo.getClass());
		// class com.doctor.aop.demo.Demo$$EnhancerBySpringCGLIB$$e9a9050a
		// 注入到spring容器的类实例是代理类

		InterfaceDemo interfaceDemo = applicationContext.getBean(InterfaceDemo.class);
		System.out.println("注入到spring容器的类实例是代理类" + interfaceDemo.getClass());
		interfaceDemo.testAnother();
		applicationContext.close();
	}

}
