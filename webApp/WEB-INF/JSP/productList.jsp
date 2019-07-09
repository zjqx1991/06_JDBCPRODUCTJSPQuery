<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="/product?cmd=edit">Add</a>
	<table border="1" cellpadding="2" cellspacing="0" width=800 >
		<tr bgcolor="orange">
			<th>id</th>
			<th>productName</th>
			<th>dir_id</th>
			<th>salePrice</th>
			<th>supplier</th>
			<th>brand</th>
			<th>cutoff</th>
			<th>costPrice</th>
			<th colspan="2">option</th>
		</tr>
		
		<c:forEach items="${list}" var='item' varStatus="status" >
			<tr style="background-color:${status.count % 2 == 0 ? 'gray' : ''};">
				<td>${item.getId()}</td>
				<td>${item.getProductName()}</td>
				<td>${item.getDir_id()}</td>
				<td>${item.getSalePrice()}</td>
				<td>${item.getSupplier()}</td>
				<td>${item.getBrand()}</td>
				<td>${item.getCutoff()}</td>
				<td>${item.getCostPrice()}</td>
				<td><a href="/product?cmd=edit&id=${item.getId()}">Edit</a></td>
				<td><a href="/product?cmd=delete&id=${item.getId()}">Delete</a></td>
			</tr>
		</c:forEach>
		
	</table>
	
</body>
</html>