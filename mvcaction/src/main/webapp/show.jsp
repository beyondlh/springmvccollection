<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>
	<button type="button" onclick="request01_click()">发送ajax请求</button>
	<script type="text/javascript"
		src='<c:url value="/scripts/jQuery1.11.3/jquery-1.11.3.min.js" />'></script>
	<script>
		function request01_click() {
			var products = new Array();
			products.push({
				id : "1",
				name : "Java Book",
				price : "88.5"
			});
			products.push({
				id : "2",
				name : "Computer",
				price : "6783.7"
			});
			$.ajax({
				type : "POST",
				url : "foo/action06",
				data : JSON.stringify(products),//序列化对象为JSON字符串
				dataType : "json",//预期服务器返回的数据类型
				contentType : 'application/json;charset=utf-8', //内容类型
				success : function(data) {
					var result="";
					$.each(data,function(i,obj){
						result+=obj.id+","+obj.name+","+obj.price+"\n";
					});
					alert(result);
				}
			});
		}
	</script>
</body>
</html>