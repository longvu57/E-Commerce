<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<body>
	<main class="dash-content">
		<div class="container-fluid">
			<h1 class="dash-title">Order Management</h1>
			<c:if test="${message != null}">
				<div class="alert alert-success" role="alert">${message}</div>
			</c:if>
			<c:if test="${error != null}">
				<div class="alert alert-danger" role="alert">${error}</div>
			</c:if>
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
										<th scope="col">Email</th>
										<th scope="col">Role</th>
										<th scope="col">Status</th>
										<th scope="col">Lock</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="user" items="${users}">

										<tr>
											<th scope="row">1</th>
											<td>${user.getUsername()}</td>
											<td>${user.getPhone()}</td>
											<td>${user.getEmail()}</td>
											<td>${user.getRole()}</td>
											<td>
												<c:if test="${user.getEnabled() == 0}">
													<div class="alert alert-danger" role="alert">LOCKED
													</div>
												</c:if> 
												<c:if test="${user.getEnabled() == 1}">
													<div class="alert alert-primary" role="alert">ACTIVE
													</div>
												</c:if>
											</td>
											<td><c:if test="${user.getEnabled() == 0}">
													<form method="POST" action="unlock-user">
														<input name="id" type="number" hidden="true"
															value="${user.getId()}" />
														<button type="submit" class="btn btn-primary">Unlock</button>
													</form>
												</c:if> <c:if test="${user.getEnabled() == 1}">
													<form method="POST" action="lock-user">
														<input name="id" type="number" hidden="true"
															value="${user.getId()}" />
														<button type="submit" class="btn btn-danger">Lock</button>
													</form>
												</c:if></td>
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