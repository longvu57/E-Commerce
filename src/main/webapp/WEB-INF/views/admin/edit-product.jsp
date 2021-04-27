<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  

<body>
	<main class="dash-content">
		<div class="container-fluid">
			<h1 class="dash-title">Edit Product</h1>
			<div class="row">
				<div class="col-xl-12">
					<div class="card easion-card">
						<div class="card-header">
							<div class="easion-card-icon">
								<i class="fas fa-chart-bar"></i>
							</div>
							<div class="easion-card-title">Edit product!</div>
						</div>
						<div class="card-body">
							<form action="updateProduct" method="POST" enctype="multipart/form-data">
								<div class="form-row">
									<div class="form-group col-md-4">
										<label for="name">Product name</label>
										<input name=id type="text" class="form-control" id="id" value="${product.getId()}" hidden="true"/> 
										<input name="productName" type="text" class="form-control" id="name" placeholder="Enter product name" value="${product.getProductName()}"/>
									</div>
									<div class="form-group col-md-4">
										<label for="price">Product price</label> 
										<input name="productPrice" type="text" class="form-control" id="price" placeholder="Enter the price" value="${product.getProductPrice()}"/>
									</div>
									<div class="form-group col-md-4">
										<label for="brand">Product brand</label> 
										<input name="brand" type="text" class="form-control" id="brand" placeholder="Enter the brand, eg. Bosch" value="${product.getBrand()}"/>
									</div>
								</div>
								<div class="form-row"> 
									<div class="form-group col-md-8">
										<label for="description">Product description</label> 
										<textarea name="productDescription" class="form-control" id="description" placeholder="Enter the product description">${product.getProductDescription()}</textarea>
									</div>
									<div class="form-group col-md-4">
										<label class="form-label" for="customFile">Product Image</label>
										<input name="image" type="file" class="form-control" id="customFile" value="${product.getImage()}" required/>
									</div>
								</div>

								<div class="form-row">
									<div class="form-group col-md-4">
										<label for="origin">Product origin</label> 
										<input name="productOrigin" type="text" class="form-control" id="origin" placeholder="Enter the origin of the product" value="${product.getProductOrigin()}"/>
									</div>
									<div class="form-group col-md-4">
										<label for="inputState">Category</label> 
										<select name="productCategory" id="inputState" class="form-control"">
											<c:forEach var = "category" items = "${categories}">
												<option value="${category.getCategoryName()}">${category.getCategoryName()}</option>
											</c:forEach>  
										</select>
									</div>
								</div>
								<button type="submit" class="btn btn-primary">Update!</button>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</main>
</body>