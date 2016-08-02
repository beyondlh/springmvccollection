<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>表单</title>
</head>
<body>
	<form action="bar/action11" method="post">
		<p>
			<label>爱好：</label>
			<input type="checkbox" value="15" name="id"/>阅读
			<input type="checkbox" value="20"  name="id"/>上网
			<input type="checkbox" value="73"  name="id"/>电游
		</p>
		<button>提交</button>
	</form>
</body>
</html>