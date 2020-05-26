<%@page import="com.neuedu.shop.entity.User"%>
<%@page contentType="text/html; charset=utf-8" pageEncoding="utf-8"
	isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%-- <%

	User user = (User)session.getAttribute("user");
	if(user == null){
		response.sendRedirect("user_login.jsp");
		return ;
	}

%> --%>
<!doctype html>

<html>
<head>

<meta charset="utf-8">
<title>电商平台首页</title>
<!--js-->
<script src="js/jquery-1.8.2.min.js"></script>

<script type="text/javascript">
	$(document).ready(function() {
		$(".inline").colorbox({
			inline : true,
			width : "50%"
		});
	});
</script>
<style type="text/css">
.remove-item-btn a {
	color: #666;
}

#cartitem_pcount_container {
	width: 100%;
}

.cartitem_pcount {
	position: relative;
	overflow: hidden;
	height: 22px;
	width: 80px;
}

.cartitem_pcount .inputcontent {
	position: absolute;
	left: 17px;
	top: 0;
	border: 1px solid #cacbcb;
	width: 42px;
	height: 18px;
	line-height: 18px;
	text-align: center;
	padding: 1px;
	margin: 0;
	font-size: 12px;
	font-family: verdana;
	color: #333;
}

.cartitem_pcount .lefta {
	border: 1px solid #cacbcb;
	width: 16px;
	height: 18px;
	line-height: 18px;
	padding: 1px 0;
	text-align: center;
	color: #666;
	float: left;
}

.cartitem_pcount .righta {
	border: 1px solid #cacbcb;
	width: 16px;
	height: 18px;
	line-height: 18px;
	padding: 1px 0;
	text-align: center;
	color: #666;
	float: right;
}
</style>
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">

<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/orange.css">
<link rel="stylesheet" href="css/skeleton.css">
<link rel="stylesheet" href="css/layout.css">
<link rel="stylesheet" href="css/ddsmoothmenu.css" />
<link rel="stylesheet" href="css/elastislide.css" />
<link rel="stylesheet" href="css/home_flexslider.css" />

<link rel="stylesheet" href="css/light_box.css" />
<script type="text/javascript">
	function incrementPcount(cartitem_pcount){
		console.log("加之前" + cartitem_pcount);
		cartitem_pcount++;
		console.log("加之后" + cartitem_pcount);
	}
	function decrementPcount(cartitem_pcount){
		if(cartitem_pcount<=1){
			console.log(cartitem_pcount);
			cartitem_pcount=1;
			console.log(cartitem_pcount);
		}else{
			console.log("减之前" + cartitem_pcount);
			cartitem_pcount--;
			console.log("减之后" + cartitem_pcount);
		}
	}
</script>


</head>
<body>
	<div class="mainContainer sixteen container">
		<!--Header Block-->
		<%@include file="header.jsp"%>
		<!--Content Block-->
		<section class="content-wrapper">
			<div class="content-container container">
				<div class="col-1-layout">
					<c:forEach items="${cartitems }" var="cartitem">
						<ul class="shopping-cart-table"
							style="background-color: #fff4e8; height: 110px; padding: 14px 0px 2px; margin-bottom: 5px;">
							<li>
								<div
									style="width: 100px; height: 97px; padding-left: 30px; border: none;"
									class="img-box">
									<img src="<%=path %>${cartitem.product.imgpath}" title=""
										alt="" />
								</div> <!-- <a class="edit-btn" href="#" title="编辑">编辑</a> -->
							</li>
							<li
								style="display: flex; justify-content: space-around; padding-top: 40px;">
								<!--   -->
								<div class="pro-name">${cartitem.product.name}</div>
								<div id="cartitem_pcount_container">
									<div class="cartitem_pcount">
										<a class="lefta" href="#"
											onclick="decrementPcount(${cartitem.pcount})"> <img
											style="width: 16px;" src="images/decrement.svg" />
										</a> <input class="inputcontent" type="text"
											value="${cartitem.pcount}" /> <a class="righta" href="#"
											onclick="incrementPcount(${cartitem.pcount})"> <img
											style="width: 16px;" src="images/increment.svg" />
										</a>
									</div>
								</div>
								<div class="pro-price">￥${cartitem.product.memberprice}</div>
								<div style="padding-top: 5px;" class="remove-item-btn">
									<a class="remove" href="#" title="删除">删除</a>
								</div>
							</li>
						</ul>
					</c:forEach>
					<div class="show-option-block">
						<a href="#" title="Show Options">显示选项</a>
					</div>
					<div class="update-shopping-cart">
						<button class="orange-btn">更新购物车</button>
					</div>
					<div class="shopping-cart-collaterals">
						<div class="cart-box">
							<div class="box-title">折扣</div>
							<div class="box-content">
								<p>如果您有优惠券，请输入您的优惠券代码</p>
							</div>
							<button class="orange-btn" title="Apply Coupon">使用优惠券</button>
						</div>
						<div class="cart-box">
							<div class="box-title">运费及税估价;</div>
							<div class="box-content">
								<p>Enter your destnation to get a shipping estimate</p>
								<ul>
									<li><label>国家<em>*</em></label> <select><option>中国</option></select>
									</li>
									<li><label>地区</label> <select><option>请选择地区、州或省</option></select>
									</li>
									<li><label>邮编</label> <input type="text" /></li>
								</ul>
							</div>
							<button class="orange-btn" title="获取报价">获取报价</button>
						</div>
					</div>
					<div class="shopping-cart-totals">
						<div class="subtotal-row">
							<div class="left">小计</div>
							<div class="right">￥1,000,00</div>
						</div>
						<div class="grand-row">
							<div class="left">总计</div>
							<div class="right">￥1,000.00</div>
						</div>
						<ul class="checkout-types">
							<li><button class="orange-btn" title="付款"
									onclick="location.href='order.html'">付款</button></li>
							<li><a href="#" title="更多地址">更多地址</a></li>
						</ul>
					</div>
					<div class="generic-product-list">
						<h4>猜你喜欢：</h4>
						<ul>
							<li>
								<div class="left-img">
									<img src="images/tshir_img.png" title="" alt="" />
								</div>
								<div class="right-content">
									<div class="pro-name">
										White Round Neck <br>T-Shirt
									</div>
									<div class="pro-price">$600.00</div>
									<div class="add-cart-row">
										<button class="orange-btn" title="添加购物车">添加购物车</button>
									</div>
									<a href="#" class="add-wishlist" title="添加收藏">添加收藏</a> <a
										href="#" class="add-compare" title="同类比较">同类比较</a>
								</div>
							</li>
							<li>
								<div class="left-img">
									<img src="images/tshir_img.png" title="" alt="" />
								</div>
								<div class="right-content">
									<div class="pro-name">
										White Round Neck <br>T-Shirt
									</div>
									<div class="pro-price">$600.00</div>
									<div class="add-cart-row">
										<button class="orange-btn" title="添加购物车">添加购物车</button>
									</div>
									<a href="#" class="add-wishlist" title="添加收藏">添加收藏</a> <a
										href="#" class="add-compare" title="同类比较">同类比较</a>
								</div>
							</li>
							<li>
								<div class="left-img">
									<img src="images/tshir_img.png" title="" alt="" />
								</div>
								<div class="right-content">
									<div class="pro-name">
										White Round Neck <br>T-Shirt
									</div>
									<div class="pro-price">$600.00</div>
									<div class="add-cart-row">
										<button class="orange-btn" title="添加购物车">添加购物车</button>
									</div>
									<a href="#" class="add-wishlist" title="添加收藏">添加收藏</a> <a
										href="#" class="add-compare" title="同类比较">同类比较</a>
								</div>
							</li>
							<li>
								<div class="left-img">
									<img src="images/tshir_img.png" title="" alt="" />
								</div>
								<div class="right-content">
									<div class="pro-name">
										White Round Neck <br>T-Shirt
									</div>
									<div class="pro-price">$600.00</div>
									<div class="add-cart-row">
										<button class="orange-btn" title="添加购物车">添加购物车</button>
									</div>
									<a href="#" class="add-wishlist" title="添加收藏">添加收藏</a> <a
										href="#" class="add-compare" title="同类比较">同类比较</a>
								</div>
							</li>
						</ul>
					</div>
				</div>
				<div class="clearfix"></div>
				<div class="news-letter-container">
					<div class="free-shipping-block">
						<h1>ENJOY FREE SHIPPING</h1>
						<p>on all orders as our holiday gift for you!</p>
					</div>
					<div class="news-letter-block">
						<h2>SIGN UP FOR OUR NEWSLETTER</h2>
						<input type="text" value="Enter email address" title="" /> <input
							class="submit-btn" type="submit" value="Submit" title="Submit" />
					</div>
				</div>
			</div>
		</section>
	</div>
	<%@include file="footer.jsp"%>
	<script src="js/common.js"></script>
	<script src="js/jquery.easing.1.3.js"></script>
	<script src="js/ddsmoothmenu.js"></script>
	<script src="js/jquery.flexslider.js"></script>
	<script src="js/jquery.elastislide.js"></script>
	<script src="js/jquery.jcarousel.min.js"></script>
	<script src="js/jquery.accordion.js"></script>
	<script src="js/light_box.js"></script>
	<script src="js/html5.js"></script>
</body>
</html>