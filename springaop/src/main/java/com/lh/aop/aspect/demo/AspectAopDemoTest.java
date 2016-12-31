package com.lh.aop.aspect.demo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lh.aop.demo.Demo;

/**
 * @author lh
 * @description
 * @date 2016年6月27日 下午2:16:57
 * <p>
 * aspect 编译时候注入，克服动态代理方法嵌套调用失效问题.
 * <p>
 * 运行方法：把项目转换成AspectJ工程，运行的时候选择：Run As-> AspectJ/Java Application
 */
class AspectAopDemoTest {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(
                "classpath:/aopDemo1/spring-aop2.xml");
        Demo demo = applicationContext.getBean(Demo.class);
        demo.test01();
        demo.test02("doctor who");
        System.out.println("注入到spring容器的类实例是代理类" + demo.getClass());
        // class com.doctor.aop.demo.Demo$$EnhancerBySpringCGLIB$$e9a9050a
        // 注入到spring容器的类实例是代理类

        applicationContext.close();
    }

}
