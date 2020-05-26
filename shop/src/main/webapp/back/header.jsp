<%@page import="com.neuedu.shop.entity.Admin"%>
<%@page contentType="text/html; charset=utf-8" pageEncoding="utf-8"
	isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
	/* 
		拦截除了admin_login.jsp以外的所有页面
	*/
	Admin admin = (Admin)session.getAttribute("admin");
	if(admin == null){
		response.sendRedirect("admin_login.jsp");
		return;
	}
	// 获取当前系统的路径http://localhost:8080/shop/
	String path = request.getContextPath();
%>
<script>
	function logout() {
		if (confirm('确认要注销么？')) {
			if (confirm('注销成功！')) {
				
				window.location.href = "logout.admin";
			} 
			/* else {
				alert('请三思');
			} */
		}
	}
	
	$(function(){
		$(".menu li a").each(function(){
			if($(this)[0].href === String(window.location)){
				var active = $(this);
				// set attribute
				$(this).attr("class","active");
				// add class
				// $(this).addClass("active");
			}
			
		});
	});
</script>

<!-- header -->
<div id="in-nav">
	<div class="container">
		<div class="row">
			<div class="span12">
				<ul class="pull-right">
					<li><a href="#">链接1</a></li>
					<li><a href="#">链接2</a></li>
					<li><a href="#">链接3</a></li>
					<!-- 如果登录了，显示登录显示登录的管理员名称，如果没有显示登录 -->
					<c:choose>
						<c:when test="${admin!=null }">
							<li><span>欢迎您，${admin.name }</span></li>
						</c:when>
						<c:otherwise>
							<li><a href="admin_login.jsp">登录</a></li>
						</c:otherwise>
					</c:choose>

					<li><a href="javascript:void(0);" onclick="logout()">注销</a></li>
					<li><a href="admin_register.jsp">管理员注册</a></li>
				</ul>
				<h4>
					<a id="logo" href="index.jsp"> 健身器材后台<strong>管理</strong>
					</a>
				</h4>
			</div>
		</div>
	</div>

</div>
<div id="in-sub-nav">
	<div class="container">
		<div class="row">
			<div class="span12">
				<ul class="menu">
					<li><a href="index.jsp"> <i class="batch home"></i><br />主页
					</a></li>
					<li>
						<span class="label label-important pull-right">${admins.size() }</span>
						<a href="findAll.admin"><i class="batch stream"></i><br />管理员列表</a>
					</li>
					<li>
						<span class="label label-important pull-right">${users.size() }</span>
						<a href="findAll.user"><i class="batch users"></i><br />用户列表</a>
					</li>
					<li>
						<a href="category_list.jsp"><i class="batch forms"></i><br />类别列表</a>
					</li>
					<li>
						<span class="label label-important pull-right">${products.size() }</span>
						<a href="findAll.product"><i class="batch quill"></i><br />商品列表</a>
					</li>
					<li><span class="label label-important pull-right">04</span><a
						href="orders.html"><i class="batch plane"></i><br />订单列表</a></li>
					<li><a href="anothers.html"><i class="batch calendar"></i><br />其它扩展功能</a></li>
					<li><a href="settings.html"><i class="batch settings"></i><br />系统设置</a></li>
				</ul>
			</div>
		</div>
	</div>
</div>
<!-- End header -->