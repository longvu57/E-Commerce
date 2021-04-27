<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<body>
	<div id="hanu-started">
		<div class="container">
			<div class="row">
				<div class="col-md-4"></div>
				<div class="col-md-4 animate-box fadeInUp animated-fast">
					<h2 class="text-center">SIGN IN</h2>
					<h4 class="alert-heading">${message}</h4>
					<form action="login" method="POST">
						<div class="row form-group">
							<div class="col-md-12">
								<input name="username" type="text" id="username" class="form-control" placeholder="Your username">
							</div>
						</div>
						<div class="row form-group">
							<div class="col-md-12">
								<input name="password" type="password" id="subject" class="form-control"
									placeholder="Your password">
							</div>
						</div>
						<div class="row form-group text-center">
							<input type="submit" value="Login" class="btn btn-primary">
						</div>
						<div class="btn-group-toggle text-center">
						  <span class="badge badge-primary">Don't have any account? </span><a class="badge badge-success" href="<c:url value="/register"/>">Register</a>
						</div>
					</form>
				</div>
				<div class="col-md-4"></div>
			</div>

		</div>
	</div>
</body>