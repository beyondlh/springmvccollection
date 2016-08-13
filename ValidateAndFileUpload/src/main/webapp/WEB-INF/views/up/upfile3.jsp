<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>上传文件 - Servlet3.0</title>
</head>
<body>
<h2>上传文件 - Servlet3.0</h2>
<form action="file3Save" method="post"  enctype="multipart/form-data">
  <p>
     <label for="files">文件：</label>
      <%--multiple="multiple"这个属性是HTML5新增加的属性，一些旧版的浏览器可能不支持，使用JavaScript可以处理一下。--%>
     <input type="file" name="files" id="files" multiple="multiple" />
   </p>
   <p>
   <button>提交</button>
   </p>
   <p>
     ${message}
   </p>
</form>
</body>
</html>