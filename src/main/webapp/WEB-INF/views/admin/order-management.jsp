<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<body>
	<main class="dash-content">
                <div class="container-fluid">
                    <h1 class="dash-title">Order Management</h1>
                    <div class="row">
				<div class="col-lg-12">
					<div class="card easion-card">
						<div class="card-header">
							<div class="easion-card-icon">
								<i class="fas fa-table"></i>
							</div>
							<div class="easion-card-title">Table of order list</div>
						</div>
						<div class="card-body ">
							<table class="table table-hover table-in-card">
								<thead>
									<tr>
										<th scope="col">#</th>
										<th scope="col">User name</th>
										<th scope="col">Phone</th>
										<th scope="col">Address</th>
										<th scope="col">Status</th>
										<th scope="col">Content</th>
										<th scope="col">Voucher</th>
										<th scope="col">Accept</th>
										<th scope="col">Reject</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var = "order" items = "${orders}">
									<tr>
										<th scope="row">${order.getId()}</th>
										<td>${order.getUsername()}</td>
										<td>${order.getPhone()}</td>
										<td>${order.getAddress()}</td>
										<c:if test="${order.getStatus() == 0}">
											<td>Pending</td>
										</c:if>
										<c:if test="${order.getStatus() == 1}">
											<td class="alert alert-success">Accepted</td>
										</c:if>
										<c:if test="${order.getStatus() == 2}">
											<td class="alert alert-danger">Rejected</td>
										</c:if>
										
										<td><a class="page-link" href="<c:url value="/admin/order-details?id=${order.getId()}"/>">Order details</a></td>
										<td>${order.getVoucher()}</td>
										<c:if test="${order.getStatus() == 0}">
											<td>
											<form method="POST" action="accept-order">
												<input name="id" type="number" hidden="true" value="${order.getId()}" />
												<button type="submit" class="btn btn-primary">Accept</button>
											</form>
											</td>
											<td>
												<form method="POST" action="reject-order">
													<input name="id" type="number" hidden="true" value="${order.getId()}" />
													<button type="submit" class="btn btn-danger">Reject</button>
												</form>
											</td>
										</c:if>										
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