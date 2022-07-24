<%@ page import="com.lihd.service.AccountService" %>
<%@ page import="com.lihd.service.impl.AccountServiceImpl" %>
<%@ page import="com.lihd.pojo.Account" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<meta charset="UTF-8">
<title>后台管理</title>
<link type="text/css" rel="stylesheet" href="../../static/css/style.css" >
<style type="text/css">
	h1 {
		text-align: center;
		margin-top: 200px;
	}
</style>
	<script type="text/javascript" src="../../static/script/jquery-1.7.2.js"></script>
	<script type="text/javascript">
		$(function (){
			$('#button01').click(function () {
				$('form').submit()
			})
		})



	</script>
</head>
<body>
	<%
		AccountService as = new AccountServiceImpl();
		List<Account> all = as.getAll();

	%>
	
	<div id="header">
		<img class="logo_img"  alt="" src="../../static/img/logo.gif" width="258px" height="82px">

		<span class="wel_word">后台管理系统</span>
			<div>
				<a href="../../index.jsp">返回飞马银行</a>
			</div>
	</div>

	<div id="main">
		<form method="post" action="">
			<input type="file" name="excel" value="导入" ectype="multipart/form-data">
		</form>

		<% for(int i=0;i<all.size();i++){
			Account account = all.get(i);%>
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
					<input name="admin" type="hidden" value="true"/>
					<td id="button01"><button>提交所有的修改</button></td>
				</tr>

			</table>
		</form>
		<br/>
		<%}%>


	</div>

	<%@ include file="../other/footer.jsp" %>
</body>
</html>