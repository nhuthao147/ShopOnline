<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/commons/taglib.jsp"%>

<body>
	<section class="jumbotron text-center">
		<div class="container">
			<h1 class="jumbotron-heading">E-COMMERCE CATEGORY</h1>
			<p class="lead text-muted mb-0">Le Lorem Ipsum est simplement du
				faux texte employé dans la composition et la mise en page avant
				impression. Le Lorem Ipsum est le faux texte standard de
				l'imprimerie depuis les années 1500, quand un peintre anonyme
				assembla ensemble des morceaux de texte pour réaliser un livre
				spécimen de polices de texte...</p>
		</div>
	</section>
	<div class="container">
		<div class="row">
			<div class="col">
				<nav aria-label="breadcrumb">
					<ol class="breadcrumb">
						<li class="breadcrumb-item"><a href="index.html">Home</a></li>
						<li class="breadcrumb-item"><a href="category.html">Category</a></li>
						<li class="breadcrumb-item active" aria-current="page">Sub-category</li>
					</ol>
				</nav>
			</div>
		</div>
	</div>
	<div class="container">
		<div class="row">
			<div class="col-12 col-sm-3">
				<div class="card bg-light mb-3">
					<div class="card-header bg-primary text-white text-uppercase">
						<i class="fa fa-list"></i> Categories
					</div>
					<ul class="list-group margin-bottom-25 sidebar-menu">
						<c:forEach items="${categoryList}" var="cateList">
							<li class="list-group-item clearfix"><a
								href="<c:url value="/product/list?categoryid=${cateList.cateid}"/>">
									<img src="<c:url value="/image?fname=${cateList.image}"/>"
									class="img-circle" width="22px"> ${cateList.catename}
							</a></li>
						</c:forEach>
					</ul>
				</div>
				<div class="card bg-light mb-3">
					<div class="card-header bg-success text-white text-uppercase">Last
						product</div>
					<div class="card-body">
						<img src="<c:url value="/image?fname=${topProduct.image}"/>"
							class="img-fluid">

						<h5 class="card-title">${topProduct.productName}</h5>
						<p class="card-text">${topProduct.description }</p>
						<p class="bloc_left_price">${topProduct.price }</p>
					</div>
				</div>
			</div>
			<div class="col">
				<div class="row">
					<c:forEach items="${productListNew}" var="proList">
						<div class="col-12 col-md-6 col-lg-4">
							<div class="card">
								<img class="card-img-top"
									src="<c:url value="/image?fname=${proList.image}"/>"
									alt="Card image cap">
								<div class="card-body">
									<h4 class="card-title">
										<a href="<c:url value='/product/detail?productid=${proList.productId}'/>" title="View Product">${proList.productName}</a>
									</h4>
									<p class="card-text">${proList.description}</p>
									<div class="row">
										<div class="col">
											<p class="btn btn-danger btn-block">${proList.price}</p>
										</div>
										<div class="col">
											<a href="#" class="btn btn-success btn-block">Add to cart</a>
										</div>
									</div>
								</div>
							</div>
						</div>
					</c:forEach>
					<div class="col-md-8 col-sm-8">
						<nav aria-label="...">
							<ul class="pagination pull-right">
								<c:if test="${tag>1}">
									<li><a
										href="${pageContext.request.contextPath }/product/list?index=${tag-1}&categoryid=0&sellerid=0">&laquo;
									</a></li>
								</c:if>
								<c:forEach begin="1" end="${endP}" var="i">
									<li class='${tag==i?"active":"" }'><a
										href="${pageContext.request.contextPath}/product/list?index=${i}">${i}</a></li>
								</c:forEach>
								<c:if test="${tag<endP}">
									<li><a
										href="${pageContext.request.contextPath}/product/list?index=${tag+1}">&raquo;</a></li>
								</c:if>
							</ul>
						</nav>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>