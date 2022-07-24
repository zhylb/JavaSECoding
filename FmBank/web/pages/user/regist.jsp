<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
	<head>
		<meta charset="UTF-8">
		<title>尚硅谷会员注册页面</title>
		<link type="text/css" rel="stylesheet" href="../../static/css/style.css" >
		<script type="text/javascript" src="../../static/script/jquery-1.7.2.js"></script>
		<script type="text/javascript">
			// 页面加载完成之后


		</script>
	<style type="text/css">
		.login_form{
			height:420px;
			margin-top: 25px;
		}

	</style>
	</head>
	<body>
		<div id="login_header">
			<img class="logo_img" alt="" src="../../static/img/logo.gif" width="258px" height="82px">

		</div>

			<div class="login_banner">

				<div id="l_content">
					<span class="login_word">欢迎注册</span>
				</div>

				<div id="content">
					<div class="login_form">
						<div class="login_box">
							<div class="tit">
								<h1>注册尚硅谷会员</h1>
								<span class="errorMsg"></span>
							</div>
							<div class="form">
								<form action="${pageContext.request.contextPath}/registServlet" method="post">
									<label>用户名称：</label>
									<input class="itxt" type="text" placeholder="请输入用户名"
										   autocomplete="off" tabindex="1" name="name" id="name" />
									<br />
									<br />
									<label>用户密码：</label>
									<input class="itxt" type="password" placeholder="请输入密码"
										   autocomplete="off" tabindex="1" name="password" id="password" />
									<br />
									<br />
									<label>学号：</label>
									<input class="itxt" type="text" placeholder="请输入学号"
										   autocomplete="off" tabindex="1" name="stuId" id="stuId" />
									<br />
									<br />
									<label>电话号码：</label>
									<input class="itxt" type="text" placeholder="请输入电话号码"
										   autocomplete="off" tabindex="1" name="number" id="number" />
									<br />
									<label>性别：  </label>
									男<input type="radio" value="M" name="sex" checked="checked">
									女<input type="radio" value="W" name="sex" >


									<br />
									<label>出生日期：</label>
									<input class="itxt" type="text" placeholder="请输入密码"
										   autocomplete="off" tabindex="1" name="birth" id="birth" />
									<br />


									<br />
									<label>验证码：</label>
									<input class="itxt" type="text" style="width: 150px;" id="code"/>
									<img alt="" src="../../static/img/code.bmp" style="float: right; margin-right: 40px">
									<br />
									<br />
									<input type="submit" value="注册" id="sub_btn" />
								</form>
							</div>

						</div>
					</div>
				</div>
			</div>
		<%@ include file="../other/footer.jsp" %>
	</body>
</html>