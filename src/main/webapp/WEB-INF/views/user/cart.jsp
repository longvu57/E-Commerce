<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<body>
	<div id="hanu-product">
		<div id="shopping-cart">
			<div class="card">
				<div class="row">
					<div class="col-md-8 cart">
						<div class="title">
							<div class="row">
								<div class="col">
									<h4>
										<b>Shopping Cart</b>
									</h4>
								</div>
								<div class="col align-self-center text-right text-muted">${sessionScope.totalItem}
									Items</div>
							</div>
						</div>

						<c:if test="${!(sessionScope.totalItem > 0)}">
							<div class="alert alert-warning" role="alert">Your cart is
								now empty! Let's go shopping!</div>
						</c:if>

						<c:if test="${sessionScope.totalItem > 0}">
							<c:forEach var="product" items="${sessionScope.cart}">
								<div class="row main align-items-center">
									<div class="col-md-3">
										<img class="img-fluid img-thumbnail"
											src="${product.value.product.getImage()}">
										<div class="row text-muted">${product.value.product.getProductCategory()}</div>
										<div class="row">${product.value.product.getProductName()}</div>
									</div>
									<div class="col-md-2 price">&#36;
										${product.value.product.getProductPrice()}</div>
									<div class="col-md-2 quantity">
										<c:if test="${product.value.getQuantity() == 1}"><a href="<c:url value="/view-cart"/>">-</a></c:if><c:if test="${product.value.getQuantity() > 1}"><a href="<c:url value="/remove-item-cart?id=${product.value.product.getId()}"/>">-</a></c:if><a href="#" class="border">${product.value.getQuantity()}</a><a href="<c:url value="/add-item-cart?id=${product.value.product.getId()}"/>">+</a>
									</div>
									<div class="col-md-2 price">&#36;
										${product.value.product.getProductPrice() * product.value.getQuantity()}
									</div>
									<div class="col-md-1">
										<a
											href="<c:url value="remove-cart?id=${product.value.product.getId()}"/>"><span
											class="close">&#10005;</span></a>
									</div>
								</div>
							</c:forEach>
						</c:if>


						<div class="back-to-shop">
							<a href="<c:url value="/"/>">&leftarrow;</a><span
								class="text-muted">Back to shop</span>
						</div>
					</div>
					
					<div class="col-md-4 summary">
						<div>
							<h5>
								<b>Summary</b>
							</h5>
						</div>
						<hr>
						<form action="checkout" method="POST" id="form-checkout">
							<div class="row">
								<div class="col" style="padding-left: 0;">ITEMS</div>
								<div class="col text-right">
									<h3>
										<span class="badge badge-secondary">${sessionScope.totalItem}
											items</span>
									</h3>
								</div>
							</div>
							<div>
								 <div class="form-group">
									<p>ADDRESS</p>
									<div class="form-message"></div>
									<input id="address" type="text" name="address" placeholder="Your address" required/>
								</div>
								
								 <div class="form-group">
									<p>MOBILE PHONE</p>
									<div class="form-message"></div>
									<input id="phone" type="text" name="phone" placeholder="Your mobile phone" required/>
								</div>
								
								 <div class="form-group">
									<p>VOUCHER</p>
									<input type="text" id="code" name="voucherCode"	placeholder="Enter your code" />
								</div>
							</div>
							<div class="row"
								style="border-top: 1px solid rgba(0, 0, 0, .1); padding: 2vh 0;">
								<div class="col">TOTAL PRICE</div>
								<div class="col text-right">&#36;
									${sessionScope.totalPrice}</div>
							</div>
							<c:if test="${alert != null}">
								<div class="alert alert-danger" role="alert">${alert}</div>
							</c:if>
							<div class="row"
								style="border-top: 1px solid rgba(0, 0, 0, .1); padding: 2vh 0;">
								<div class="col-md-2"></div>
								<div class="col-md-8">
									<c:if test="${sessionScope.totalItem > 0}">
										<button type="submit" class="btn btn-primary">CHECK	OUT</button>
									</c:if>
									<c:if test="${!(sessionScope.totalItem > 0)}">
										<button type="submit" class="btn btn-primary" disabled>CHECK OUT</button>
									</c:if>
								</div>
								<div class="col-md-2"></div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>

	</div>
</body>