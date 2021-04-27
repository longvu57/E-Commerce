<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<body>
	<main class="dash-content">
		<div class="container-fluid">
			<h1 class="dash-title">Vouchers Management</h1>
			<c:if test="${message != null}">
				<div class="alert alert-success" role="alert">${message}</div>
			</c:if>
			<c:if test="${error != null}">
				<div class="alert alert-danger" role="alert">${error}</div>
			</c:if>
			<div class="row">
				<div class="col-xl-2"></div>
				<div class="col-xl-8">
					<div class="card easion-card">
						<div class="card-header">
							<div class="easion-card-icon">
								<i class="fas fa-chart-bar"></i>
							</div>
							<div class="easion-card-title">Add new voucher!</div>
						</div>
						<div class="card-body ">
							<form action="add-voucher" method="POST" id="form-voucher">
								<div class="form-row">
									<div class="form-group col-md-6">
										<label for="voucherCode">Voucher Code</label> 
										<div class="form-message"></div>
										<input	name="voucherCode" type="text" class="form-control"
											id="vourcherCode" placeholder="Enter vourcher code" required/>
									</div>
									<div class="form-group col-md-6">
										<label for="voucherLimit">Limit</label> <input
											name="voucherLimit" type="number" class="form-control"
											id="vourcherLimit" placeholder="Limit" min = "1" max="200" required/>
									</div>
								</div>
								<div class="form-row">
									<div class="form-group col-md-6">
										<label for="voucherType">Voucher Type</label> <select
											name="voucherType" id="inputState" class="form-control" required>
											<option value="per_order">Per order</option>
										</select>
									</div>
									<div class="form-group col-md-6">
										<label for="voucherAmount">Voucher Amount</label> <input
											name="voucherAmount" type="number" class="form-control"
											id="vourcherAmount"
											placeholder="Enter the amount of vourcher" min="5" max="30" required/>
									</div>
								</div>
								<div class="form-row">
									<div class="form-group col-md-6">
										<label for="expiryDate">Expiry Date</label> <input
											name="expiryDate" type="date"
											class="form-control label-floating is-empty" id="expiryDate" required/>
									</div>
								</div>
								<div class="form-row">
									<div class="form-group col-md-3"></div>
									<div class="form-group col-md-6 text-center">
										<button type="submit" class="btn btn-primary">Add
											now!</button>
									</div>
									<div class="form-group col-md-3"></div>
								</div>

							</form>
						</div>
					</div>
				</div>
				<div class="col-xl-2"></div>
			</div>

			<div class="row">
				<div class="col-lg-12">
					<div class="card easion-card">
						<div class="card-header">
							<div class="easion-card-icon">
								<i class="fas fa-table"></i>
							</div>
							<div class="easion-card-title">Table of voucher list</div>
						</div>
						<div class="card-body ">
							<table class="table table-hover table-in-card">
								<thead>
									<tr>
										<th scope="col">Id</th>
										<th scope="col">Voucher Code</th>
										<th scope="col">Type</th>
										<th scope="col">Amount</th>
										<th scope="col">Limit</th>
										<th scope="col">Expiry date</th>
										<th scope="col">Delete</th>
									</tr>
								</thead>
								<tbody>

									<c:forEach var="voucherItem" items="${voucherList}">
										<tr>
											<th scope="row">${voucherItem.getId()}</th>
											<td>${voucherItem.getVoucherCode()}</td>
											<td>${voucherItem.getVoucherType()}</td>
											<td>${voucherItem.getVoucherAmount()}%</td>
											<td>${voucherItem.getVoucherLimit()}</td>
											<td>${voucherItem.getExpiryDate()}</td>
											<td>

												<button type="button" class="btn btn-danger"
													data-toggle="modal"
													data-target="#modal-${voucherItem.getId()}"><i class="far fa-trash-alt"></i> Delete</button>
												<div class="modal fade" id="modal-${voucherItem.getId()}"
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
																voucher after delete it!</div>
															<div class="modal-footer">
																<button type="button" class="btn btn-secondary"
																	data-dismiss="modal">Close</button>
																<form method="POST" action="delete-voucher">
																	<input name="id" type="number" hidden="true"
																		value="${voucherItem.getId()}" />
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
		</div>
	</main>
</body>