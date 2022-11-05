<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit category</title>
</head>
<body>
	<c:url value="/admin/category/edit" var="edit"></c:url>
	<form role="form" action="${edit}" method="post"
		enctype="multipart/form-data">
		<input name="id" value="${category.cateid}" hidden="">
		<div class="form-group">
			<label>Tên danh sách:</label> <input type="text" class="form-control"
				value="${category.catename}" name="name" />
		</div>
		<div class="form-group">
			<c:url value="/image?fname=${category.image}" var="imgUrl"></c:url>
			<img class="img-responsive" width="100px" src="${imgUrl}" alt="">
			<label>Ảnh đại diện</label> <input type="file" name="image"
				value="${category.image}" />
		</div>
		<button type="submit" class="btn btn-default">Edit</button>
		<button type="reset" class="btn btn-primary">Reset</button>
	</form>


</body>
</html>