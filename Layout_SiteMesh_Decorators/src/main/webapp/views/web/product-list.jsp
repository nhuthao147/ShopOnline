<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@include file="/commons/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<c:forEach items="${productListNew}" var="proList">
	<img src="<c:url value="/image?fname=${proList.image}"/>"
		class="img-responsive" alt="${proList.productName}">
	<a
		href="<c:url value="/product/detail?productid=${proList.productId}"/>">
		${proList.productName}</a>
</c:forEach>

</body>
</html>