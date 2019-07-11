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
		<input type="text" name="id" hidden="hidden" value="${productInfo.product.id}" >
		<table>
			<tr>
				<td>商品名称</td>
				<td>
					<input type="text" name="productName" value="${productInfo.product.getProductName()}" required >
				</td>
			</tr>
			
			<tr>
				<td>商品品牌</td>
				<td>
					<input type="text" name="brand" value="${productInfo.product.getBrand()}" required >
				</td>
			</tr>
			
			<tr>
				<td>供应商</td>
				<td>
					<input type="text" name="supplier" value="${productInfo.product.getSupplier()}" required >
				</td>
			</tr>
			
			<tr>
				<td>零售价</td>
				<td>
					<input type="text" name="salePrice" value="${productInfo.product.getSalePrice()}" required >
				</td>
			</tr>
			
			<tr>
				<td>成本价</td>
				<td>
					<input type="text" name="costPrice" value="${productInfo.product.getCostPrice()}" required >
				</td>
			</tr>
			
			<tr>
				<td>折扣</td>
				<td>
					<input type="text" name="cutoff" value="${productInfo.product.getCutoff()}" required >
				</td>
			</tr>
			
			<tr>
				<td>商品分类</td>
				<td>
					<select name="dir_id">
						<c:forEach items="${productDir}" var='dir' >
							<option value="${dir.dir_id}" ${productInfo.product.getDir_id() == dir.dir_id ? "selected" : ""} >${dir.dir_name}</option>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value=${productInfo.product == null ? "保存新增" : "保存编辑"}>
				</td>
			</tr>
		</table>
	</form>

</body>
</html>