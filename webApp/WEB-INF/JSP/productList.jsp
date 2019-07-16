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
	<form action="/product" method="POST">
		关键字<input type="search" name="keywords" placeholder="名称/品牌/供应商" value="${qObject.keywords}" >
		<br/>
		商品名称<input type="text" name="productName" value="${qObject.productName}" >
		最低价 <input type="number" name="minPrice" value="${qObject.minPrice}" >
		最高价 <input type="number" name="maxPrice" value="${qObject.maxPrice}" >
		类别<select name="dir_id" >
				<option value="-1" >选择分类</option>
			<c:forEach items="${productDir}" var='dir' >
				<option value="${dir.dir_id}" ${dir.dir_id == qObject.dir_id ? "selected" : ""} >${dir.dir_name}</option>
			</c:forEach>
		</select>
		<input type="submit" value="查询" >
	</form>
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
		<c:forEach items="${pageResult.listData}" var='item' varStatus="status" >
			<tr style="background-color:${status.count % 2 == 0 ? 'gray' : ''};">
				<td>${item.product.id}</td>
				<td>${item.product.productName}</td>
				<td>${item.productDir.dir_name}</td> 
				<td>${item.product.salePrice}</td>
				<td>${item.product.supplier}</td>
				<td>${item.product.brand}</td>
				<td>${item.product.cutoff}</td>
				<td>${item.product.costPrice}</td>
				<td><a href="/product?cmd=edit&id=${item.product.id}">Edit</a></td>
				<td><a href="/product?cmd=delete&id=${item.product.id}">Delete</a></td>
			</tr> 
		</c:forEach>
		<tr>
			<td colspan="10" align="center">
				<a href="/product?cmd=list&currentPage=1">首页</a>
				<a href="/product?cmd=list&currentPage=${pageResult.previousPage}">上一页</a>
				<a href="/product?cmd=list&currentPage=${pageResult.nextPage}">下一页</a>
				<a href="/product?cmd=list&currentPage=${pageResult.lastPage}">尾页</a>
				一共${pageResult.totalCount}条数据，当前${pageResult.currentPage}/${pageResult.lastPage}第页
			</td>
		</tr>
		
	</table>
	
</body>
</html>