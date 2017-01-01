Spring MVC 练习
=============
Spring Web MVC能帮我们做什么  

√让我们能非常简单的设计出干净的Web层和薄薄的Web层;

√进行更简洁的Web层的开发;

√天生与Spring框架集成（如IoC容器、AOP等);

√提供强大的约定大于配置的契约式编程支持;

√能简单的进行Web层的单元测试;

√支持灵活的URL到页面控制器的映射;

√非常容易与其他视图技术集成，如Velocity、FreeMarker等等，因为模型数据不放在特定的API里，而是放在一个Model里（Map数据结构实现，因此很容易被其他框架使用）;

√非常灵活的数据验证、格式化和数据绑定机制，能使用任何对象进行数据绑定，不必实现特定框架的API;

√提供一套强大的JSP标签库，简化JSP开发;

√支持灵活的本地化、主题等解析;

√更加简单的异常处理;

√对静态资源的支持;

√支持Restful风格。

<img src='http://docs.spring.io/autorepo/docs/spring/4.2.x/spring-framework-reference/html/images/spring-overview.png' >

Spring各个包的作用
权威介绍见http://docs.spring.io/autorepo/docs/spring/4.2.x/spring-framework-reference/html/overview.html
Spring包括有很多独立的jar包，各自包含着对应的Spring组件，用户可以根据自己的需要来选择组合自己的jar包，而不必引入整个spring.jar的所有类文件。
1. spring-core.jar
这个jar文件包含Spring框架基本的核心工具类，Spring其它组件要都要使用到这个包里的类，是其它组件的基本核心。

2. spring-beans.jar
这个jar文件是所有应用都要用到的，它包含访问配置文件、创建和管理bean以及进行Inversion of Control / Dependency Injection（IoC/DI）操作相关的所有类。
如果应用只需基本的IoC/DI支持，引入spring-core.jar及spring-beans.jar文件就可以了。

3. spring-aop.jar
这个jar文件包含在应用中使用Spring的AOP特性时所需的类。
使用基于AOP的Spring特性，如声明型事务管理（Declarative Transaction Management），也要在应用里包含这个jar包。

4. spring-context.jar　　
这个jar文件为Spring核心提供了大量扩展。可以找到使用Spring ApplicationContext特性时所需的全部类，
JDNI所需的全部类，UI方面的用来与模板（Templating）引擎如Velocity、FreeMarker、JasperReports集成的类，以及校验Validation方面的相关类。

5. spring-dao.jar　　
这个jar文件包含Spring DAO、Spring Transaction进行数据访问的所有类。
为了使用声明型事务支持，还需在自己的应用里包含spring-aop.jar。

6. spring-hibernate.jar　　
这个jar文件包含Spring对Hibernate 2及Hibernate 3进行封装的所有类。

7. spring-jdbc.jar　　
这个jar文件包含对Spring对JDBC数据访问进行封装的所有类。

8. spring-orm.jar　　
这个jar文件包含Spring对DAO特性集进行了扩展，使其支持 iBATIS、JDO、OJB、TopLink，因为Hibernate已经独立成包了，现在不包含在这个包里了。
这个jar文件里大部分的类都要依赖spring-dao.jar里的类，用这个包时你需要同时包含spring-dao.jar包。

9. spring-remoting.jar　　
这个jar文件包含支持EJB、JMS、远程调用Remoting（RMI、Hessian、Burlap、Http Invoker、JAX-RPC）方面的类。

10. spring-support.jar　　
这个jar文件包含支持缓存Cache（ehcache）、JCA、JMX、邮件服务（Java Mail、COS Mail）、任务计划Scheduling（Timer、Quartz）方面的类。

11. spring-web.jar　　
这个jar文件包含Web应用开发时，用到Spring框架时所需的核心类，
包括自动载入WebApplicationContext特性的类、Struts与JSF集成类、文件上传的支持类、Filter类和大量工具辅助类。

12. spring-webmvc.jar　　
这个jar文件包含Spring MVC框架相关的所有类。包含国际化、标签、Theme、视图展现的FreeMarker、JasperReports、Tiles、Velocity、XSLT相关类。当然，如果你的应用使用了独立的MVC框架，则无需这个JAR文件里的任何类。

13. spring-mock.jar　　
这个jar文件包含Spring一整套mock类来辅助应用的测试。Spring测试套件使用了其中大量mock类，这样测试就更加简单。
模拟HttpServletRequest和HttpServletResponse类在Web应用单元测试是很方便的。　　
选择
如何选择这些发布包，决定选用哪些发布包其实相当简单。
如果你正在构建Web应用并将全程使用Spring，那么最好就使用单个全部的spring.jar文件；
如果你的应用仅仅用到简单的Inversion of Control / Dependency Injection（IoC/DI）容器，那么只需spring-core.jar与spring-beans.jar即可；
如果你对发布的大小要求很高，那么就得精挑细选了，只取包含自己所需特性的jar文件了。

Spring包依赖说明
spring-core.jar需commons-logging.jar。spring-core.jar是以下其它各个的基本。

spring-beans.jar需spring-core.jar

spring-aop.jar需spring-core.jar，spring-beans.jar

spring-context.jar需spring-core.jar，spring-beans.jar，spring-aop.jar

spring-dao.jar需spring-core.jar，spring-beans.jar，spring-aop.jar，spring-context.jar

spring-jdbc.jar需spring-core.jar，spring-beans.jar，spring-dao.jar

spring-web.jar需spring-core.jar，spring-beans.jar，spring-context.jar

spring-webmvc.jar需spring-core.jar，spring-beans.jar，spring-context.jar，spring-web.jar

spring-hibernate.jar需spring-core.jar，spring-beans.jar，spring-aop.jar，spring-dao.jar，spring-jdbc.jar，spring-orm.jar，spring-web.jar， spring-webmvc.jar

spring-orm.jar需spring-core.jar，spring-beans.jar，spring-aop.jar，spring-dao.jar，spring-jdbc.jar，spring-web.jar，spring-webmvc.jar

spring-remoting.jar需spring-core.jar，spring-beans.jar，spring-aop.jar，spring-dao.jar，spring-context.jar，spring-web.jar，spring-webmvc.jar

spring-support.jar需spring-core.jar，spring-beans.jar，spring-aop.jar，spring-dao.jar，spring-context.jar，spring-jdbc.jar

spring-mock.jar需spring-core.jar，spring-beans.jar，spring-dao.jar，spring-context.jar，spring-jdbc.jar

注
commons-logging.jar包是使用spring的必备包。用来记录程序运行时的活动的日志记录。

使用Spring框架一般也需要这个包:spring-expression.jar(Spring表达式语言)

# Spring