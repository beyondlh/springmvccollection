<%--
  Created by IntelliJ IDEA.
  User: lh
  Date: 2016/4/4
  Time: 18:40
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <%--EL是默认关闭的。。。必须手动打开。<%@ page isELIgnored="false" %>
    JSP2.0默认是打开支持EL的，所以声明jsp2.0就可以直接用了。--%>
    <%--<%@ page isELIgnored="false" %>--%>
    <title>InternalResourceViewResolver</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
${message}
InternalResourceViewResolver视图解析
</body>
</html>
