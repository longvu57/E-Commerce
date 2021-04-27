<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"	prefix="decorator"%>

<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>E-Commerce</title>
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet" href="<c:url value="/assets/user/css/animate.css"/>">
<link rel="stylesheet" href="<c:url value="/assets/user/css/icomoon.css"/>">
<link rel="stylesheet" href="<c:url value="/assets/user/css/bootstrap.css"/>">
<link rel="stylesheet" href="<c:url value="/assets/user/css/flexslider.css"/>">
<link rel="stylesheet" href="<c:url value="/assets/user/css/owl.carousel.min.css"/>">
<link rel="stylesheet" href="<c:url value="/assets/user/css/owl.theme.default.min.css"/>">
<link rel="stylesheet" href="<c:url value="/assets/user/css/style.css"/>">
<script src="<c:url value="/assets/user/js/modernizr-2.6.2.min.js"/>"></script>

</head>
<body>

	<div class="hanu-loader"></div>

	<div id="page">
		
		<%@include file="/WEB-INF/views/layouts/user/header.jsp"%>
		
		<decorator:body />
		
		<%@include file="/WEB-INF/views/layouts/user/footer.jsp"%>
		
	</div>

	<div class="gototop js-top">
		<a href="#" class="js-gotop"><i class="icon-arrow-up"></i></a>
	</div>

	<script src="<c:url value="/assets/user/js/jquery.min.js"/>"></script>
	<script src="<c:url value="/assets/user/js/jquery.easing.1.3.js"/>"></script>
	<script src="<c:url value="/assets/user/js/bootstrap.min.js"/>"></script>
	<script src="<c:url value="/assets/user/js/jquery.waypoints.min.js"/>"></script>
	<script src="<c:url value="/assets/user/js/owl.carousel.min.js"/>"></script>
	<script src="<c:url value="/assets/user/js/jquery.countTo.js"/>"></script>
	<script src="<c:url value="/assets/user/js/jquery.flexslider-min.js"/>"></script>
	<script src="<c:url value="/assets/user/js/main.js"/>"></script>
	<script src="<c:url value="/assets/user/js/validator.js"/>"></script>
	<script>
		Validator({
			form: '#form-checkout',
			errorSelector: '.form-message',
			rules: [
				Validator.isRequired("#address"),
				Validator.isPhone("#phone"),
			],
			onSubmit: function(data){
				
			}
		});
	</script>
</body>
</html>

