<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<meta charset="UTF-8">
<title>飞马银行登录界面</title>
<link type="text/css" rel="stylesheet" href="../../static/css/style.css" >
	<script type="text/javascript" src="../../static/script/jquery-1.7.2.js"></script>
	<script type="text/javascript">
		$(function (){
			<% Object login = request.getAttribute("login");
			if(login != null && login.equals("false")){%>
			$("span.errorMsg").text("用户id或密码错误");
			alert("用户id或密码错误")

			<%}%>
		})



	</script>
</head>
<body>
		<div id="login_header">
			<img class="logo_img" alt="" src="../../static/img/logo.gif" width="258px" height="82px">
		</div>
		
			<div class="login_banner">
			
				<div id="l_content">
					<span class="login_word">欢迎登录</span>
				</div>
				
				<div id="content">
					<div class="login_form">
						<div class="login_box">
							<div class="tit">
								<h1>FM 用户</h1>
								<a href="regist.jsp">立即注册</a>
							</div>
							<div class="msg_cont">
								<b></b>
								<span class="errorMsg">请输入id和密码</span>
							</div>
							<div class="form">
								<form action="${pageContext.request.contextPath}/loginServlet" method="post">
									<label>用户id ：</label>
									<input class="itxt" type="text" placeholder="请输入用户id" autocomplete="off" tabindex="1" name="id" />
									<br />
									<br />
									<label>用户密码：</label>
									<input class="itxt" type="password" placeholder="请输入密码" autocomplete="off" tabindex="1" name="password" />
									<br />
									<br />
									<input type="submit" value="登录" id="sub_btn" />
								</form>
							</div>
							
						</div>
					</div>
				</div>
			</div>
		<%@ include file="../other/footer.jsp" %>
</body>
</html>