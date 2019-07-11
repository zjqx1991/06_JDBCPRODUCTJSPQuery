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
			<th>商品名称</th>
			<th>商品分类</th>
			<th>零售价</th>
			<th>供应商</th>
			<th>品牌</th>
			<th>折扣</th>
			<th>成本价</th>
			<th colspan="2">操作</th>
		</tr>
		
		<c:forEach items="${list}" var='item' varStatus="status" >
			<tr style="background-color:${status.count % 2 == 0 ? 'gray' : ''};">
				<td>${item.product.getId()}</td>
				<td>${item.product.getProductName()}</td>
				<td>${item.productDir.dir_name}</td>
				<td>${item.product.getSalePrice()}</td>
				<td>${item.product.getSupplier()}</td>
				<td>${item.product.getBrand()}</td>
				<td>${item.product.getCutoff()}</td>
				<td>${item.product.getCostPrice()}</td>
				<td><a href="/product?cmd=edit&id=${item.product.getId()}">Edit</a></td>
				<td><a href="/product?cmd=delete&id=${item.product.getId()}">Delete</a></td>
			</tr>
		</c:forEach>
		
	</table>
	
</body>
</html>