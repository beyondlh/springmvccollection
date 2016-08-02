<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>List与数组直接绑定自定义数据类型与AJAX</title>
</head>
<body>
	<button type="button" onclick="addPdts_click1();">向服务器发送json</button>
	<button type="button" onclick="addPdts_click2();">接收服务器返回的json</button>
	<p id="msg"></p>
	<script type="text/javascript"
		src="<c:url value="/scripts/jQuery1.11.3/jquery-1.11.3.min.js"/>"></script>
	<script type="text/javascript">
		var products = new Array();
		products.push({
			id : 1,
			name : "iPhone 6 Plus",
			price : 4987.5
		});
		products.push({
			id : 2,
			name : "iPhone 7 Plus",
			price : 5987.5
		});
		products.push({
			id : 3,
			name : "iPhone 8 Plus",
			price : 6987.5
		});
		
		function addPdts_click1() {
			$.ajax({
				type : "POST", //请求谓词类型
				url : "bar/action21",
				data : JSON.stringify(products), //将products对象转换成json字符串
				contentType : "application/json;charset=UTF-8", //发送信息至服务器时内容编码类型，(默认: "application/x-www-form-urlencoded")
				dataType : "text", //预期服务器返回的数据类型
				success : function(result) {
					$("#msg").html(result);
				}
			});
		}
		
		function addPdts_click2() {
			$.ajax({
				type : "POST", //请求谓词类型
				url : "bar/action22",
				data : JSON.stringify(products), //将products对象转换成json字符串
				contentType : "application/json;charset=UTF-8", //发送信息至服务器时内容编码类型，(默认: "application/x-www-form-urlencoded")
				dataType : "json", //预期服务器返回的数据类型
				success : function(result) {
					var str="";
					 $.each(result,function(i,obj){
					     str+="编号："+obj.id+",名称："+obj.name+",价格："+obj.price+"<br/>";	
					  });
					$("#msg").html(str);
					}
				});
			}
	</script>
</body>
</html>