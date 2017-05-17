package com.lh.aop.aspect.demo;

import com.lh.aop.demo.Demo;
import com.lh.aop.demo.InterfaceDemo;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author lh
 * @description
 * @date 2016年6月27日 下午2:16:57
 * <p>
 * aspect 编译时候注入，克服动态代理方法嵌套调用失效问题.
 * <p>
 */
class AspectAopDemoTest {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:/aopDemo1/spring-aop2.xml");
//        Demo demo = applicationContext.getBean(Demo.class);
//        demo.test01();
//        System.out.println("注入到spring容器的demo类实例" + demo.getClass());

        // 注入到spring容器的类实例是代理类
        InterfaceDemo interfaceDemo = applicationContext.getBean(InterfaceDemo.class);
        System.out.println("注入到spring容器的类实例是代理类" + interfaceDemo.getClass());
        interfaceDemo.testAnother();
        applicationContext.close();
    }

}
