<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<body>
	<main class="dash-content">
		<div class="container-fluid">

			<h1 class="dash-title">Product Management</h1>
			<c:if test="${message != null}">
				<div class="alert alert-success" role="alert">${message}</div>
			</c:if>
			<c:if test="${error != null}">
				<div class="alert alert-danger" role="alert">${error}</div>
			</c:if>
			
			<div class="row">
				<div class="col-xl-12">
					<div class="card easion-card">
						<div class="card-header">
							<div class="easion-card-icon">
								<i class="fas fa-chart-bar"></i>
							</div>
							<div class="easion-card-title">Add new product!</div>
						</div>
						<div class="card-body">
							<form action="admin/addNewProduct" method="POST" enctype="multipart/form-data" id="form-product">
								<div class="form-row">
									<div class="form-group col-md-4">
										<label for="name">Product name</label> 
										<div class="form-message"></div>
										<input type="text"	name="productName" class="form-control" id="name" placeholder="Enter product name" maxlength="20" required />
									</div>
									<div class="form-group col-md-4">
										<label for="price">Product price</label> 
										<div class="form-message"></div>
										<input type="number" name="productPrice" class="form-control" id="price"
											placeholder="Enter the price" max = "10000" required/>
									</div>
									<div class="form-group col-md-4">
										<label for="brand">Product brand</label> 
										<div class="form-message"></div>
										<input type="text"	name="brand" class="form-control" id="brand"
											placeholder="Enter the brand, eg. Bosch" maxlength="20" required/>
									</div>
								</div>
								<div class="form-row">
									<div class="form-group col-md-8">
										<label for="description">Product description</label>
										<div class="form-message"></div>
										<textarea name="productDescription" class="form-control"
											id="description" placeholder="Enter the product description" maxlength="200" required></textarea>
									</div>
									<div class="form-group col-md-4">
										<label class="form-label" for="customFile">Product
											Image</label> <input type="file" name="image" class="form-control"
											id="customFile" required/>
									</div>
								</div>

								<div class="form-row">
									<div class="form-group col-md-4">
										<label for="origin">Product origin</label> 
										<div class="form-message"></div>
										<input type="text"	name="productOrigin" class="form-control" id="origin"
											placeholder="Enter the origin of the product" maxlength="20" required/>
									</div>
									<div class="form-group col-md-4">
										<label for="inputState">Category</label> 
										
										<select	id="inputState" class="form-control" name="productCategory" required>
											<c:forEach var = "category" items = "${categories}">
												<option value="${category.getCategoryName()}">${category.getCategoryName()}</option>
											</c:forEach>  
										</select>
										
									</div>
								</div>
								<button type="submit" class="btn btn-primary">Add now!</button>
							</form>
						</div>
					</div>
				</div>
			</div>

			<div class="row">
				<div class="col-lg-12">
					<div class="card easion-card">
						<div class="card-header">
							<div class="easion-card-icon">
								<i class="fas fa-table"></i>
							</div>
							<div class="easion-card-title">Table of product list</div>
						</div>
						<div class="card-body ">
							<table class="table table-hover table-in-card">
								<thead>
									<tr>
										<th scope="col">#</th>
										<th scope="col">Product Name</th>
										<th scope="col">Price</th>
										<th scope="col">Description</th>
										<th scope="col">Origin</th>
										<th scope="col">Brand</th>
										<th scope="col">Image</th>
										<th scope="col">Category</th>
										<th scope="col">Edit</th>
										<th scope="col">Delete</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="product" items="${products}">
										<tr>
											<th scope="row">${product.getId()}</th>
											<td>${product.getProductName()}</td>
											<td>${product.getProductPrice()}</td>
											<td>${product.getProductDescription()}</td>
											<td>${product.getProductOrigin()}</td>
											<td>${product.getBrand()}</td>
											<td><img src="<c:url value="${product.getImage()}"/>"
												class="img-fluid img-thumbnail"></td>
											<td>${product.getProductCategory()}</td>
											<td><a
												href="<c:url value="/admin/edit-product?productId=${product.getId()}"/>"
												class="btn btn-primary" role="button">Edit</a></td>
											<td>
												<button type="button" class="btn btn-danger"
													data-toggle="modal" data-target="#modal-${product.getId()}">Delete</button>
												<div class="modal fade" id="modal-${product.getId()}"
													tabindex="-1" role="dialog"
													aria-labelledby="deleteModalLabel" aria-hidden="true">
													<div class="modal-dialog" role="document">
														<div class="modal-content">
															<div class="modal-header">
																<h5 class="modal-title" id="deleteModalLabel">Are
																	you sure want to delete?</h5>
																<button type="button" class="close" data-dismiss="modal"
																	aria-label="Close">
																	<span aria-hidden="true">&times;</span>
																</button>
															</div>
															<div class="modal-body">You cannot restore the
																product after delete it!</div>
															<div class="modal-footer">
																<button type="button" class="btn btn-secondary"
																	data-dismiss="modal">Close</button>
																<form method="POST" action="<c:url value="admin/deleteProduct"/>">
																	<input name="id" type="number" hidden="true"
																		value="${product.getId()}" />
																	<button type="submit" class="btn btn-danger">DELETE</button>
																</form>
															</div>
														</div>
													</div>
												</div>
											</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>
			<div class="row">
                        <div class="col-lg-6">
                            <div class="card easion-card">
                                <div class="card-header">
                                    <div class="easion-card-icon">
                                        <i class="fas fa-chart-bar"></i>
                                    </div>
                                    <div class="easion-card-title"> Category </div>
                                </div>
                                <div class="card-body ">
                                    <form:form action = "admin/add-product-category" method = "POST" modelAttribute="productCategory">
                                        <div class="form-group row">
                                        	<div class="col-sm-3">
                                                <label for="category">Category</label>
                                            </div>
                                            
                                            <div class="col-sm-7">
                                                <form:input path="categoryName" type="text" class="form-control" id="category" placeholder="Category" required = "true"/>
                                            </div>
                                        </div>
                                        <div class="form-group row">
                                            <div class="col-sm-10">
                                                <button type="submit" class="btn btn-primary">Add new!</button>
                                            </div>
                                        </div>
                                    </form:form>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-6">
                            <div class="card easion-card">
                                <div class="card-header">
                                    <div class="easion-card-icon">
                                        <i class="fas fa-table"></i>
                                    </div>
                                    <div class="easion-card-title">List of Category</div>
                                </div>
                                <div class="card-body ">
                                    <table class="table table-hover table-in-card">
                                        <thead>
                                            <tr>
                                                <th scope="col">Id</th>
                                                <th scope="col">Name</th>
												<th scope="col">Delete</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                        <c:forEach var = "category" items = "${categories}">
                                        	<tr>
                                                <th scope="row">${category.getId()}</th>
                                                <td>${category.getCategoryName()}</td>
                                                <td>
                                                	<form method="POST" action="admin/delete-productCategory">
														<input name="id" type="number" hidden="true" value="${category.getId()}" />
														<button type="submit" class="btn btn-danger">DELETE</button>
													</form>
												</td>
                                            </tr> 
                                        </c:forEach>                                          
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
		</div>
	</main>
</body>