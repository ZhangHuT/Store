<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>注册页面</title>
</head>
<body>
	<h3>用户注册</h3>
	<div style="color: red">
		${erroMsg}
	</div>
	<form action="/com.store.www/login">
		<table>
			<tr>
				<td>账号：</td>
				<td>
					<input type="text" name="username"/>
				</td>
			</tr>
			<tr>
				<td>密码：</td>
				<td>
					<input type="password" name="password"/>
				</td>
			</tr>
			<tr>
				<td	colspan="2" align="center">
					<input type="submit" value="确认"/>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>