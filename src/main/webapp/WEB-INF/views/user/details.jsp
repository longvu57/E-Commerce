<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<body>
	<div id="hanu-product">
		<div class="container">
			<div class="row animate-box fadeInUp animated-fast">
				<div class="col-md-8 col-md-offset-2 text-center hanu-heading">
					<h2>${product.getProductName()}</h2>
					<p>${product.getProductDescription()}</p>
				</div>
			</div>
			<div class="row">
				<div class="col-md-4 text-center animate-box fadeInUp animated-fast">
					<div class="product">
						<div class="product-grid"
							style="background-image: url(${product.getImage()});">
							<div class="inner">
								<p>
									<a href="single.html" class="icon"><i
										class="icon-shopping-cart"></i></a>
								</p>
							</div>
						</div>
					</div>
				</div>
				<div class="col-md-1 text-center animate-box fadeInUp animated-fast">
				</div>
				<div
					class="col-md-7 col-md-push-1 animate-box fadeInUp animated-fast">

					<div class="hanu-contact-info row">
						<h3>Information</h3>
						<div class="col-md-6">
							<ul>
								<h3>
									<span class="badge badge-secondary">Price</span>
								</h3>
								<li class="price">${product.getProductPrice()}</li>
								<h3>
									<span class="badge badge-secondary">Brand</span>
								</h3>
								<li class="brand">${product.getBrand()}</li>
							</ul>
						</div>
						<div class="col-md-6">
							<ul>
								<h3>
									<span class="badge badge-secondary">Origin</span>
								</h3>
								<li class="url">${product.getProductOrigin()}</li>
								<h3>
									<span class="badge badge-secondary">Category</span>
								</h3>
								<li class="category">${product.getProductCategory()}</li>
							</ul>
						</div>
					</div>
					<div class="row form-group text-center">
						<a href="add-to-cart?id=${product.getId()}"
							class="btn btn-primary" role="button" aria-pressed="true">Add
							to cart!</a>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>