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
	<form action="/product?cmd=save" method="POST" >
		<input type="text" name="id" hidden="hidden" value=${product.getId()} >
		productName:<input type="text" name="productName" value=${product.getProductName()} >
		<br/>
		     dir_id:<input type="number" name="dir_id" value=${product.getDir_id()} >
		<br />
		  salePrice:<input type="text" name="salePrice" value=${product.getSalePrice()} >
		<br />
		   supplier:<input type="text" name="supplier" value=${product.getSupplier()} >
		<br />
		      brand:<input type="text" name="brand" value=${product.getBrand()} >
		<br />
		     cutoff:<input type="text" name="cutoff" value=${product.getCutoff()} >
		<br />
		  costPrice:<input type="text" name="costPrice" value=${product.getCutoff()} >
		<br />
		<input type="submit" value=${product == null ? "保存新增" : "保存编辑"}>
	</form>
	
</body>
</html>