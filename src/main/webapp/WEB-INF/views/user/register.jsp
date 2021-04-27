<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<body>
<body>
	<div id="hanu-started">
		<div class="container">
			<div class="row">
				<div
					class="col-md-2 col-md-push-1 animate-box fadeInUp animated-fast">
				</div>
				<div class="col-md-8 animate-box fadeInUp animated-fast">
					<h3 class="text-center">Sign up for new account!</h3>
					<h4 class="alert-heading">${error}</h4>
					<form action="register" method = "POST">
						<div class="row form-group">
							<div class="col-md-12">
								<input name = "username" type="text" id="subject" class="form-control" placeholder="Your name">
							</div>
						</div>
						<div class="row form-group">
							<div class="col-md-6">
								<input name = "password" type="password" id="password" class="form-control"
									placeholder="Your password">
							</div>
							<div class="col-md-6">
								<input name = "confirmPassword" type="password" id="password" class="form-control"
									placeholder="Your password">
							</div>
						</div>

						<div class="row form-group">
							<div class="col-md-6">
								<input name = "phone" type="text" id="phone" class="form-control" placeholder="Your phone number">
							</div>
							<div class="col-md-6">
								<input name = email type="email" id="email" class="form-control"
									placeholder="Your email address">
							</div>
						</div>
						<nav class="nav nav-pills flex-column flex-sm-row">
						  <a class="flex-sm-fill text-sm-center nav-link" href="#">Link</a>
						</nav>
						<div class="form-group text-center">
							<input type="submit" value="Register" class="btn btn-primary">
						</div>
						<div class="btn-group-toggle text-center">
						  <span class="badge badge-primary ">Have an account? </span><a class="badge badge-success" href="<c:url value="/login"/>">Login</a>
						</div>
					</form>
				</div>
				<div
					class="col-md-2 col-md-push-1 animate-box fadeInUp animated-fast">
				</div>
			</div>

		</div>
	</div>
</body>
</body>