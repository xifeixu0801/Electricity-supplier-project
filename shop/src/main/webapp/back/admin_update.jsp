<%@page contentType="text/html; charset=utf-8" pageEncoding="utf-8"
	isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="gbk" />

<title>电商平台后台管理</title>
<link rel="stylesheet" href="css/bootstrap.css" />
<link rel="stylesheet" href="css/bootstrap-responsive.css" />
<link rel="stylesheet" href="css/styles.css" />
<link rel="stylesheet" href="css/toastr.css" />
<link rel="stylesheet" href="css/fullcalendar.css" />
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.js"></script>
<script src="js/jquery.knob.js"></script>
<script src="js/jquery.sparkline.min.js"></script>
<script src="js/toastr.js"></script>
<script src="js/jquery.tablesorter.min.js"></script>
<script src="js/jquery.peity.min.js"></script>
<script src="js/fullcalendar.min.js"></script>
<script src="js/gcal.js"></script>
<script src="js/setup.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=gbk" />
</head>
<body>
	<%@include file="header.jsp" %>
	<div class="page">
		<div class="page-container">
			<div class="container">
				<div class="row">
					<div class="span12">
						<h4 class="header">修改管理员信息</h4>
						<form action="updateAdmin.admin" method="post">
							<table class="table table-striped sortable">
								<thead>
								</thead>
								<tbody>
									<tr>
										<th>管理员ID</th>
										<td>${admin.id }</td>
									</tr>

									<tr>
										<th>管理员账号</th>
										<td><input type="text" name="username"
											value="${admin.name }" disabled="disabled"/></td>
									</tr>

									<tr>
										<th>原始密码</th>
										<td><input type="password" name="pwd"/></td>
									</tr>
									<tr>
										<th>新密码</th>
										<td><input type="password" name="newpwd"/></td>
									</tr>
									<tr>
										<th>确认新密码</th>
										<td><input type="password" name="confirmpwd"/></td>
									</tr>
									<tr>

										<td></td>
										<td><input class="btn btn-success" type="submit"
											value="修改" />&nbsp;&nbsp;&nbsp;<input class="btn btn-danger"
											type="reset" value="重置" /></td>
										<td></td>
										<td></td>
										<td></td>
									</tr>

								</tbody>
							</table>
						</form>

					</div>
				</div>
			</div>

		</div>
	</div>
	<%@include file="footer.jsp" %>
</body>
<script src="js/d3-setup.js"></script>

</html>