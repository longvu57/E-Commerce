<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<body>
	<div id="hanu-product">
		<div id="shopping-cart">
			<div class="card">
				<div class="row">
					<div class="col-md-2 summary"></div>
					<div class="col-md-8 summary">
						<div>
							<h5>
								<b>YOUR ORDER</b>
							</h5>
						</div>
						<c:if test="${message != null}">
							<div class="alert alert-success" role="alert">${message}</div>
						</c:if>
						<hr>
						<form action="place-order" method="POST">
							<div class="row">
								<div class="col" style="padding-left: 0;">ITEMS</div>
								<div class="col text-right">
									<h3>
										<a class="badge badge-secondary">${sessionScope.totalItem}
											items</a>
									</h3>
								</div>
							</div>
							<div>
								<p>USERNAME</p>
								<input type="text" name="username" value="${username}"
									readonly="true" />
								<p>MOBILE PHONE</p>
								<input type="text" name="phone" value="${phone}" readonly="true" />
								<p>ADDRESS</p>
								<input type="text" name="address" value="${address}"
									readonly="true" />
								<p>VOUCHER</p>
								<input type="text" id="code" name="voucherCode"
									value="${voucherCode}" readonly="true" />
							</div>
							<div class="row"
								style="border-top: 1px solid rgba(0, 0, 0, .1); padding: 2vh 0;">
								<div class="col">TOTAL PRICE</div>
								<div class="col text-right">&#36; ${finalPrice}</div>
							</div>
							<div class="row"
								style="border-top: 1px solid rgba(0, 0, 0, .1); padding: 2vh 0;">
								<div class="col-md-4"></div>
								<div class="col-md-4">
									<button type="submit" class="btn btn-primary">PLACE
										ORDER</button>
								</div>
								<div class="col-md-4"></div>
							</div>

						</form>
					</div>
					<div class="col-md-2 summary"></div>
				</div>
			</div>
		</div>
	</div>
</body>