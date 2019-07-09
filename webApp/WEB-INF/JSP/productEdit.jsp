<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/product?cmd=save" method="POST">
		<input type="text" name="id" hidden="hidden" value="${product.getId()}" >
		<table>
			<tr>
				<td>商品名称</td>
				<td>
					<input type="text" name="productName" value="${product.getProductName()}" required >
				</td>
			</tr>
			
			<tr>
				<td>商品品牌</td>
				<td>
					<input type="text" name="brand" value="${product.getBrand()}" required >
				</td>
			</tr>
			
			<tr>
				<td>供应商</td>
				<td>
					<input type="text" name="supplier" value="${product.getSupplier()}" required >
				</td>
			</tr>
			
			<tr>
				<td>零售价</td>
				<td>
					<input type="text" name="salePrice" value="${product.getSalePrice()}" required >
				</td>
			</tr>
			
			<tr>
				<td>成本价</td>
				<td>
					<input type="text" name="costPrice" value="${product.getCostPrice()}" required >
				</td>
			</tr>
			
			<tr>
				<td>折扣</td>
				<td>
					<input type="text" name="cutoff" value="${product.getCutoff()}" required >
				</td>
			</tr>
			
			<tr>
				<td>商品分类</td>
				<td>
					<select name="dir_id">
						<option value="1" ${product.getDir_id() == 1 ? "selected" : ""} >鼠标</option>
						<option value="2" ${product.getDir_id() == 2 ? "selected" : ""} >无线鼠标</option>
						<option value="3" ${product.getDir_id() == 3 ? "selected" : ""} >有线鼠标</option>
						<option value="4" ${product.getDir_id() == 4 ? "selected" : ""} >美女鼠标</option>
					</select>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value=${product == null ? "保存新增" : "保存编辑"}>
				</td>
			</tr>
			
		</table>
	</form>

</body>
</html>