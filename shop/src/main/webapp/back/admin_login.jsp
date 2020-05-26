<%@page contentType="text/html; charset=utf-8" pageEncoding="utf-8"
	isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge, chrome=1" />
<meta name="description" content="description of your site" />
<meta name="author" content="author of the site" />
<title>电商平台后台管理登录页面</title>
<link rel="stylesheet" href="css/bootstrap.css" />
<link rel="stylesheet" href="css/bootstrap-responsive.css" />

<link rel="stylesheet" href="css/styles.css" />
<link rel="stylesheet" href="css/toastr.css" />
<link rel="stylesheet" href="css/fullcalendar.css" />
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.js"></script>
<script src="js/jquery.knob.js"></script>
<!-- <script src="http://d3js.org/d3.v3.min.js"></script> -->
<script src="js/jquery.sparkline.min.js"></script>
<script src="js/toastr.js"></script>
<script src="js/jquery.tablesorter.min.js"></script>
<script src="js/jquery.peity.min.js"></script>
<script src="js/fullcalendar.min.js"></script>
<script src="js/gcal.js"></script>
<script src="js/setup.js"></script>
<style>
	.error_msg{
		color:red;
	}
</style>

</head>
<%
// 获取当前系统的路径http://localhost:8080/shop/
	String path = request.getContextPath();
%>
<body>
	<div id="in-nav">
		<div class="container">
			<div class="row">
				<div class="span12">
					<ul class="pull-right">
						<li><a href="<%=path%>/pre/index.product">前台首页</a></li>
						<li><a href="<%=path%>">前台登录</a></li>
						<li><a href="<%=path%>">前台注册</a></li>
					</ul>
					<h4>
						<a id="logo" href="index.jsp"> 健身器材后台<strong>管理员登录</strong></a>
					</h4>
				</div>
			</div>
		</div>
	</div>
	<div class="container">
		<div class="row">
			<div class="span6 offset2">
				<div class="login">
					<form class="form-horizontal" action="login.admin" method="post">
						<div class="control-group">
							<div class="controls">
								<h3><strong>登 录</strong></h3>
							</div>
						</div>
						<div class="control-group">
							<label for="inputEmail" class="control-label">用户名 </label>
							<div class="controls">
								<input id="inputEmail" name="name" type="text"
									placeholder="请输入用户名" />
								<span class="error_msg">${error_msg }</span>
							</div>
						</div>
						<div class="control-group">
							<label for="inputPassword" class="control-label">密码 </label>
							<div class="controls">
								<input id="inputPassword" name="pwd" type="password"
									placeholder="请输入密码" />
							</div>
						</div>
						<div class="control-group">
							<label for="inputPassword" class="control-label">验证码 </label>
							<div class="controls">
								<input id="inputvalidate" style="width: 100px" name="code"
									type="text" placeholder="请输验证码" /> <a href="javascript:;" id="code"><img
									src="code.code" id="img">看不清，换一个</a><br/>
								<script type="text/javascript">
									$(function(){
										$("#code").click(function(){
											$("#img").attr("src","code.code?"+new Date().getTime()+Math.random());
										});
									});
								</script>
								<span class="error_msg">${code_msg }</span>
								<span><span class="error_msg">*</span>验证码不区分大小写</span>
								
							</div>


						</div>
						<div class="control-group">
							<div class="controls">
								<input type="submit" class="btn" value="登录"> <input
									type="button" class="btn" value="注册"
									onclick="window.location.href='admin_register.jsp'">
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>

</html>