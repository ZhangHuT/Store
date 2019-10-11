<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品展示</title>
</head>
<body>
	<div align="ennter">
		<h3>商品展示</h3>
	</div>
	<form action="#" method="post">
		<table>
			<tr>
				<td>商品名：</td>
				<td>
					<input type="text" name="name" size="5"/>
				</td>
				<td>价钱：</td>
				<td>
					<input type="text" name="minalse" size="4"/>
				</td>
				<td>
					到
				</td>
				<td>
					<input type="text" name="maxsale" size="4"/>
				</td>
				<td>
					<input type="submit" value="查询"/>
				</td>
			</tr>
		</table>
	</form>
	<table border="1" cellspacing="0" style="width: 800px;">
		<tr style="background-color:OrangeRed">
			<td>货品名称</td>
			<td>货品品牌</td>
			<td>货品分类</td>
			<td>供应商</td>
			<td>价格</td>
			<td>折扣</td>
			<td>剩余数量</td>
			<td>操作</td>
		</tr>
		<c:forEach items="${Store_IN_SESSION}" var="store" varStatus="s">
			<tr bgcolor='<c:if test="${s.index%2==0}">grey</c:if>'>
				<td>${store.sname}</td>
				<td>${store.sbrand}</td>
				<td>${store.dir}</td>
				<td>${store.sfactory}</td>
				<td>${store.sale}</td>
				<td>${store.discount}</td>
				<td>${store.count}</td>
				<td>
					<a href="#">【购买】</a>
				</td>
			</tr>
			</c:forEach>
		</table>
</body>
</html>