<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登陆</title>
<script type="text/javascript">
	function logon() {
		window.location.href="/com.store.www/logon"
	}
	function login() {
		window.location.href="/com.store.www/login.jsp"
	}
</script>
</head>
<body>
	<h3>登陆界面</h3>
	<div style="color:red;">
		${erroMsg}
	</div>
	<form action="/com.store.www/logon" method="post">
		<table>
			<tr>
				<td>账号:</td>
				<td>
					<input type="text" name="username" required/>
				</td>
			</tr>
			<tr>
				<td>密码:</td>
				<td>
					<input type="password" name="password" required/>
				</td>
			</tr>
			<tr>
				<td colspan="2"  align="center">
					<input type="submit" value="登陆" onclick="logon()"/>
					<input type="submit" value="注册" onclick="login()"/>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>