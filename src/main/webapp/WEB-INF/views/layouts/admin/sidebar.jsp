<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="dash-nav dash-nav-dark mobile-show">
	<header>
		<a href="#!" class="menu-toggle"> <i class="fas fa-bars"></i>
		</a> <a href="<c:url value="/admin"/>" class="easion-logo"> <span>HANU Admin</span></a>
	</header>
	<nav class="dash-nav-list">
		<a href="<c:url value="/admin"/>" class="dash-nav-item"> <i class="fab fa-product-hunt"></i>
			Products
		</a>
		<a href="<c:url value="/admin/order-management"/>" class="dash-nav-item"> <i
			class="fas fa-scroll"></i> Orders
		</a>
		<a href="<c:url value="/admin/user-management"/>" class="dash-nav-item"> <i
			class="fas fa-user-friends"></i> Customers
		</a>
		<a href="<c:url value="/admin/voucher-management"/>" class="dash-nav-item"> <i
			class="fab fa-get-pocket"></i> Vouchers
		</a>
	</nav>
</div>