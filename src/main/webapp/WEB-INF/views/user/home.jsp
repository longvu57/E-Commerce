<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<body>
	<div id="hanu-product">
		<div class="container">
			<div id="hanu-started">
				<div class="container">
					<div class="row animate-box fadeInUp animated-fast">
						<div class="col-md-8 col-md-offset-2 text-center hanu-heading">
							<h2>Sort the product</h2>
							<p>Cannot wait to explore our new product?</p>
						</div>
					</div>
					<div class="row">
						<div class="col-md-3 col-sm-3">
							<a href="<c:url value="sort-product?price=ASC"/>"
								class="btn btn-primary btn-lg active" role="button"
								aria-pressed="true">Price: Low to High</a>
						</div>
						<div class="col-md-3 col-sm-3">
							<a href="<c:url value="sort-product?price=DESC"/>"
								class="btn btn-primary btn-lg active" role="button"
								aria-pressed="true">Price: High to Low</a>
						</div>
						<div class="col-md-3 col-sm-3">
							<a href="<c:url value="sort-product?alphabet=ASC"/>"
								class="btn btn-primary btn-lg active" role="button"
								aria-pressed="true">A to Z</a>
						</div>
						<div class="dropdown">
						  <button class="dropbtn btn btn-primary btn-lg active">Category</button>
						  <div class="dropdown-content">
						    <c:forEach var="category" items="${categories}">
									<a class="dropdown-item" href="<c:url value="sort-product?category=${category.getCategoryName()}"/>">${category.getCategoryName()}</a>
								</c:forEach>
						  </div>
						</div>
					</div>
				</div>
			</div>

			<div class="row">
				<c:forEach var="product" items="${products}">
					<div class="col-md-4 text-center animate-box">
						<div class="product">
							<div class="product-grid"
								style="background-image: url(${product.getImage()});">
								<div class="inner">
									<p>
										<a href="<c:url value="add-to-cart?id=${product.getId()}"/>"
											class="icon"><i class="icon-shopping-cart"></i></a> <a
											href="<c:url value="product-detail?id=${product.getId()}"/>"
											class="icon"><i class="icon-eye"></i></a>
									</p>
								</div>
							</div>
							<div>
								<h3>
									<a href="<c:url value="product-detail?id=${product.getId()}"/>">${product.getProductName()}</a>
								</h3>
								<span class="price">${product.getProductPrice()}$</span>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>
</body>