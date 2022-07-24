<%@ page import="com.lihd.pojo.Account" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<meta charset="UTF-8">
<title>尚硅谷会员注册页面</title>
	<base href="http://localhost/FmBank/index.jsp">
<link type="text/css" rel="stylesheet" href="static/css/style.css" >
<style type="text/css">
	h1 {
		text-align: center;
		margin-top: 200px;
	}
	
	h1 a {
		color:red;
	}
</style>
<script type="text/javascript" src="../../static/script/jquery-1.7.2.js"></script>
<script type="text/javascript">
	$(function (){
		$('#td_sub').click(function () {
			$('form').submit()
		})
	})



</script>
</head>
<body>
	<%
		Account account = (Account) request.getAttribute("account");
	%>
		<div id="header">
			<img class="logo_img" alt="" src="static/img/logo.gif" width="258px" height="82px">

			<div>
					<span>欢迎<span class="um_span"><%=account.getName()%>_<%=account.getId()%></span>光临飞马银行</span>
					<a href="index.jsp">注销</a>&nbsp;&nbsp;
					<a href="index.jsp">返回</a>
				</div>
		</div>

		<div id="main">
			<table>
				<tr>
					<td>id</td>
					<td>学号</td>
					<td>余额</td>
				</tr>
				<tr>
					<td><%=account.getId()%></td>
					<td><%=account.getStuid()%></td>
					<td><%=account.getBalance()%></td>
				</tr>
			</table>
			<form action="${pageContext.request.contextPath}/changeInfoServlet" method="post">
				<table>
					<tr>
						<td>名称</td>
						<td>性别</td>
						<td>密码</td>
						<td>电话号码</td>
						<td>生日</td>
					</tr>
					<tr>
						<input type="hidden" name="id" value="<%=account.getId()%>">
						<td><input name="name" type="text" value="<%=account.getName()%>"/></td>
						<td><input name="sex" type="text" value="<%=account.getSex()%>"/></td>
						<td><input name="password" type="text" value="<%=account.getPassword()%>"/></td>
						<td><input name="number" type="text" value="<%=account.getNumber()%>"/></td>
						<td><input name="birth" type="text" value="<%=account.getBirth()%>"/></td>
					</tr>


					<tr>
						<td>存钱</td>
						<td><input name="save" type="text" value=""/></td>

						<td>取钱</td>
						<td><input name="pay" type="text" value=""/></td>
						<td>祝您开心</td>

					</tr>
					<tr>
						<td>转账</td>
						<td><input name="pay_id" type="text" value="0"/></td>

						<td><input name="pay_money" type="text" value=""/></td>

						<input name="admin" type="hidden" value="false"/>

						<td colspan="2" id="td_sub"><button>提交所有的修改</button></td>
					</tr>

				</table>
			</form>


		</div>

		<%@ include file="../other/footer.jsp" %>
</body>
</html>