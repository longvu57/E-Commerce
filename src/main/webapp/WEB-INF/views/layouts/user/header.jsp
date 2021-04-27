<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>
<nav class="hanu-nav" role="navigation">
	<div class="container">
		<div class="row">
			<div class="col-md-3 col-xs-2">
				<div id="hanu-logo">
					<a href="<c:url value="/"/>">HANU Furniture</a>
				</div>
			</div>
			<div class="col-md-4 col-xs-3 text-center menu-1">
				<ul>
					<li class="has-dropdown"><a href="<c:url value="/"/>">Shop</a></li>
					<li><a href="<c:url value="/about"/>">About</a></li>
				</ul>
			</div>
			<div class="col-md-5 col-xs-4 text-right hidden-xs menu-2">
				<ul>
					<li class="has-dropdown">
					<a href="#">
					<security:authorize access="isAuthenticated()">
							<security:authentication property="principal" var = "user"/> Welcome ${user.username}
					</security:authorize>
					<security:authorize access="!isAuthenticated()">
							Let's explore!
					</security:authorize>
					</a>
						<ul class="dropdown">
					<security:authorize access="!isAuthenticated()">
							<li><a href="login">Login</a></li>
							<li><a href="register">Register</a></li>
					</security:authorize>
					<security:authorize access="isAuthenticated()">
							<li><a href="logout">Logout</a></li>
					</security:authorize>
				</ul>
				</li>
					<li class="shopping-cart"><a href="<c:url value="/view-cart"/>" class="cart"><span><small>${sessionScope.totalItem}</small><i
								class="icon-shopping-cart"></i></span></a></li>
				</ul>
			</div>
		</div>

	</div>
</nav>
<header id="hanu-header" class="hanu-cover hanu-cover-sm"
	role="banner"
	style="background-image: url(assets/user/images/slider.jpg);">
	<div class="overlay"></div>
	<div class="container">
		<div class="row">
			<div class="col-md-8 col-md-offset-2 text-center">
				<div class="display-t">
					<div class="display-tc animate-box fadeIn animated-fast"
						data-animate-effect="fadeIn">
							<h1>HANU FURNITURE</h1>
					</div>
				</div>
			</div>
		</div>
	</div>
</header>