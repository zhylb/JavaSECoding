<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>飞马银行</title>
<link type="text/css" rel="stylesheet" href="static/css/style.css" >
	<style type="text/css">
		h1 {
			text-align: center;
			margin-top: 200px;
		}
	</style>
</head>
<body>
	
	<div id="header">
			<img class="logo_img"  alt="" src="static/img/logo.gif" width="258px" height="82px">
			<span class="wel_word">飞马银行</span>
			<div>
				<a href="pages/user/login.jsp">登录</a> |
				<a href="pages/user/regist.jsp">注册</a> &nbsp;&nbsp;

				<a href="pages/manager/manager.jsp">管理员模式</a>
			</div>
	</div>
	<div id="main">
		<h1>欢迎来到飞马银行</h1>
	</div>

	<%@ include file="pages/other/footer.jsp" %>

</body>
</html>