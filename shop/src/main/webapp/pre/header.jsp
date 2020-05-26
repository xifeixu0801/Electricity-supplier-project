<%@page contentType="text/html; charset=utf-8" pageEncoding="utf-8"
	isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<%
	String path = request.getContextPath();
%>

<style type="text/css">
#logo {
	max-width: 200%
}

.header-bottom .cart-block .label{
	display: inline-block;
    padding: 3px 6px;
    font-size: 13px;
    font-weight: bold;
    border-radius: 10px;
    line-height: 14px;
    color: #ffffff;
    text-shadow: 0 -1px 0 rgba(0, 0, 0, 0.25);
    white-space: nowrap;
    vertical-align: baseline;
    background-color: #b94a48;
    float:right;
    position: relative;
  	margin-right:3px;
    
}

</style>

<!--Header Block-->
<div class="header-wrapper">
	<header class="container">
		<div class="head-right">
			<ul class="top-nav">
				<c:if test="${ user != null}">
					<li class=""><a href="#">欢迎您，${user.name}</a></li>
					<li class=""><a href="404_error.html" title="我的账户">我的账户</a></li>
					<li class="my-wishlist"><a href="404_error.html" title="我的收藏">我的收藏</a></li>
				</c:if>

				<li class="contact-us"><a href="contact_us.html" title="联系我们">联系我们</a></li>
				<c:if test="${ user != null}">
					<li class="checkout"><a href="findByUserId.cartitem"
						title="我的购物车">我的购物车</a></li>
				</c:if>
				<c:if test="${ user == null}">
					<li class="log-in"><a href="user_login.jsp" title="登录">登录</a></li>
					<li class=""><a href="user_register.jsp" title="注册">注册</a></li>
				</c:if>
				<c:if test="${ user != null}">
					<li class=""><a href="logout.user" title="注销">注销</a></li>
				</c:if>

			</ul>
			<ul class="currencyBox">
				<li id="header_currancy" class="currency"><a
					class="mainCurrency" href="#">币种: RMB</a>
					<div id="currancyBox" class="currency_detial">
						<a href="#">￥</a> <a href="#"></a> <a href="#">$</a>
					</div></li>
			</ul>
			<section class="header-bottom">
				<div class="cart-block">
					<ul style="background-color: #f9f9f9;">
						<!-- <li>()</li> -->
						<li style="width: 50px;"><span class="label">${cartitems.size() } </span>
						<a href="findByUserId.cartitem" title="Cart"><img title="Item"
								alt="Item" src="images/item_icon.png" /></a></li>
						<li><a href="findByUserId.cartitem">我的购物车</a></li>
					</ul>
					<div id="minicart" class="remain_cart" style="display: none;">
						<p class="empty">购物车中有(${cartitems.size() })件商品</p>
						<ol>
							<c:forEach items="${cartitems }" var="cartitem">
								<li>
									<div class="img-block">
										<img src="<%=path %>${cartitem.product.imgpath}" title="" alt="" />
									</div>
									<div style="padding-left:20px;width: 130px;" class="detail-block">
										<h4>
											<a href="#" title="${cartitem.product.name }">${cartitem.product.name }</a>
										</h4>
										<p style="padding-top:5px;">
											<strong>${cartitem.pcount }</strong> x ${cartitem.unitprice}
										</p>
										<a href="#" title="去购物车">去购物车</a>
									</div>
									<div class="edit-delete-block" style="padding-top:10px;" >
										<a style="margin-top:10px;" href="#" title="修改">修改</a> 
										<a style="margin-top:10px;" href="#" title="删除">删除</a>
									</div>
								</li>
							</c:forEach>
							
							<li>
								<div class="total-block">
									总计：<span>￥1,900.00</span>
								</div> <a href="cart.html" title="付款" class="orange-btn">付款</a>
								<div class="clear"></div>
							</li>
						</ol>
					</div>
				</div>
				<div class="search-block">
					<form action="findByKeywords.product" method="post">
						<input type="text" name="keywords" placeholder="搜索商品" /> <input
							type="submit" value="搜索" title="搜索商品" />
					</form>
				</div>
			</section>
		</div>
		<h1 class="logo">
			<a href="index.product" title="Logo"> <img id="logo" title="Logo"
				alt="Logo" src="images/logo.jpg" />
			</a>
		</h1>
		<script type="text/javascript">
			// 改变加载顺序
				$.ajax({
					url:"http://<%=path%>/back/findToTree.category",
						dataType : "json",
						success : function(categories) {
							let a = "";
							for ( let i in categories) {
								let c_grade1 = categories[i];
								a = $("<a href='#' title='"+c_grade1.name+"'>"
										+ c_grade1.name + "</a>");
								$("#first").append(a);
								if (c_grade1.children) {
									let ul = $("<ul></ul>");
									for ( let j in c_grade1.children) {
										let c_grade2 = c_grade1.children[j];
										let li2 = $("<li><a href='#'>"
												+ c_grade2.name + "</a></li>");
										ul.append(li2);
										if (c_grade2.children) {
											let ul2 = $("<ul></ul>");
											for ( let k in c_grade2.children) {
												let c_grade3 = c_grade2.children[k];
												let li3 = $("<li><a href='findByCategoryId.product?categoryid="
														+ c_grade3.id
														+ "'>"
														+ c_grade3.name
														+ "</a></li>");
												ul2.append(li3);
											}
											li2.append(ul2);
										}
									}
									$("#first").append(ul);
								}
							}

						}
					});
		</script>
		<nav id="smoothmenu1" class="ddsmoothmenu mainMenu">
			<ul id="nav">
				<li class="active"><a href="index.product" title="Home">首页</a></li>
				<!-- 使用ajax动态生成类别列表层级显示 -->
				<li id="first"></li>
				<!-- <li class=""><a href="category.html" title="商品类别">商品类别</a>
					<ul>
						<li><a href="category.html">女装</a></li>
						<li><a href="category.html">男装</a></li>
						<li><a href="category.html">饰品</a></li>
						<li><a href="category.html">移动设备</a>
							<ul>
								<li><a href="category.html">二级类别</a></li>
								<li><a href="category.html">二级类别</a></li>
								<li><a href="category.html">二级类别</a></li>
								<li><a href="category.html">二级类别</a></li>
								<li><a href="category.html">二级类别</a></li>
								<li><a href="category.html">二级类别</a></li>
							</ul>
						</li>
						<li><a href="category.html">鞋</a></li>
						<li><a href="category.html">其他</a></li>
					</ul>
				</li> -->
				<li class=""><a href="blog.html" title="博客">博客</a></li>
				<li class=""><a href="faq.html" title="FAQ">FAQ</a></li>
				<li class=""><a href="about_us.html" title="关于我们">关于我们</a></li>
				<li class=""><a href="404_error.html" title="Pages">Pages</a></li>
				<li class=""><a href="contact_us.html" title="联系我们">联系我们</a></li>
			</ul>
		</nav>

		<div class="mobMenu">
			<h1>
				<span>菜单</span> <a class="menuBox highlight"
					href="javascript:void(0);">ccc</a> <span class="clearfix"></span>
			</h1>
			<div id="menuInnner" style="display: none;">
				<ul class="accordion">
					<li class="active"><a href="index.html" title="主页">主页</a></li>
					<li class="parent"><a href="category.html" title="类别">类别</a>
						<ul>
							<li><a href="category.html">女装</a></li>
							<li><a href="category.html">男装</a></li>
							<li><a href="category.html">饰品</a></li>
							<li><a href="category.html">移动设备</a>
								<ul>
									<li><a href="category.html">二级类别</a></li>
									<li><a href="category.html">二级类别</a></li>
									<li><a href="category.html">二级类别</a></li>
									<li><a href="category.html">二级类别</a></li>
									<li><a href="category.html">二级类别</a></li>
									<li><a href="category.html">二级类别</a></li>
								</ul></li>
							<li><a href="category.html">鞋</a></li>
							<li><a href="category.html">其他</a></li>
						</ul></li>
					<li class=""><a href="blog.html" title="博客">博客</a></li>
					<li class=""><a href="faq.html" title="Faq">Faq</a></li>
					<li class=""><a href="about_us.html" title="关于我们">关于我们</a></li>
					<li class=""><a href="404_error.html" title="Pages">Pages</a></li>
					<li class=""><a href="contact_us.html" title="联系我们">联系我们</a></li>
					<span class="clearfix"></span>
				</ul>

			</div>
		</div>

	</header>
</div>