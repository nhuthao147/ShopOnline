<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="/commons/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:forEach items="${listAllproduct}" var="p">
		<div class="product col-12 col-md-6 col-lg-4">
			<div class="card">
				<c:url value="/image?fname=${p.image}" var="imgUrl"></c:url>
				<img class="card-img-top" src="${imgUrl}" alt="${p.productName}">
				<div class="card-body">
					<h4 class="card-title">
						<a href="productdetail?pid=${p.productId}" title="View Product">${p.productName}</a>
					</h4>
					<p class="card-text">${p.description}</p>
					<div class="row">
						<div class="col">
							<p class="btn btn-danger btn-block">${p.price}$</p>
						</div>
						<div class="col">
							<a href="#" class="btn btn-success btn-block">Add to cart</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</c:forEach>
	<script>
		$(window).scroll(
				function() {
					if ($(window).scrollTop() + $(window).height() >= $(
							document).height()) {
						loadMore();
					}
				});
		function loadMore() {
			/* tạo viên amount để Gọi và đếm classname là product */
			var amount = document.getElementsByClassName("product").length;
			$.ajax({
				url : "/BanHang/load", //send to Controller
				type : "get", //send it through get method
				data : {
					exits : amount
				},
				success : function(data) {
					$("#content").append(data);
				},
				error : function(xhr) {
					//Do Something to handle error
				}
			});
		};
</script>
</body>
</html>
