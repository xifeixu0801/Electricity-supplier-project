<%@page contentType="text/html; charset=utf-8" pageEncoding="utf-8"
	isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<title>验证码</title>
		<meta charset="utf-8">
		<script src="js/jQuery.js"></script>
	</head>
	
	<body>
		<img id="code" alt="错误路径" src="code.code">
		<script type="text/javascript">
			$(function(){
				$("#code").click(function(){
					$(this).attr("src","code.code?"+new Date().getTime()+Math.random());
				});
			});
		</script>
	</body>
</html>