<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"	prefix="decorator"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!doctype html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.4.1/css/all.css">
    <link href="https://fonts.googleapis.com/css?family=Nunito:400,600|Open+Sans:400,600,700" rel="stylesheet">
    <link rel="stylesheet" href="<c:url value="/assets/admin/css/bootstrap.css"/>">
    <link rel="stylesheet" href="<c:url value="/assets/admin/css/style.css"/>">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.3/Chart.bundle.min.js"></script>
    <script src="<c:url value="/assets/admin/js/chart-js-config.js"/>"></script>
    <title>HANU Furniture Dashboard</title>
</head>

<body>
    <div class="dash">
        <%@include file="/WEB-INF/views/layouts/admin/sidebar.jsp"%>
        <div class="dash-app">
            <%@include file="/WEB-INF/views/layouts/admin/header.jsp"%>
            <decorator:body />
        </div>
    </div>
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
    <script src="<c:url value="/assets/admin/js/script.js"/>"></script>
    <script src="<c:url value="/assets/user/js/validator.js"/>"></script>
	<script>
		Validator({
			form: '#form-product',
			errorSelector: '.form-message',
			rules: [
				Validator.isRequired("#name"),
				Validator.isPrice("#price"),
				Validator.isRequired("#brand"),
				Validator.isRequired("#description"),
				Validator.isRequired("#origin"),
			],
			onSubmit: function(data){
				
			}
		});
	</script>
	<script>
		Validator({
			form: '#form-voucher',
			errorSelector: '.form-message',
			rules: [
				Validator.isRequired("#vourcherCode")
			]
		});
	</script>
</body>

</html>