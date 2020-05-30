<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored= "false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<%@ include file="styleAll.jsp" %>
	<link rel="stylesheet" type="text/css" href="./resources/static/css/account/account.css">
</head>
<body>
	<%@ include file="headAll.jsp" %>
	<div class="personal-info">

		<div>Your profile</div>
		<div>Login:</div>
		<div>${sessionScope.user.login}</div>
		<div>First name:</div>
		<div>${sessionScope.user.firstName}</div>
		<div>Last name:</div>
		<div>${sessionScope.user.lastName}</div>
		<div>Age:</div>
		<div>${sessionScope.user.age}</div>
		<div>Gender:</div>
		<div>${sessionScope.user.gender}</div>
		<div>Country:</div>
		<div>${sessionScope.user.country.name}</div>
	
	</div>

	<div class="shopping-list">
		<div class="head-items">
			<div>Shopping list</div>
			<div>Name</div>
			<div>Specifications</div>
			<div>Guarantee</div>
			<div>Code</div>
			<div>Amount</div>
			<div>Price</div>
		</div>
		<c:forEach items="${cart}" var="item">
			<div class="items">
				<div><img src='./resources/static/img/telescopes/${item.key.linkImg}'> ${item.key.name}</div>
				<div>${item.key.specifications}</div>
				<div>${item.key.guarantee}</div>
				<div>${item.key.id}</div>
				<div>${item.value}</div>
				<div>${item.key.price}</div>
			</div>
		</c:forEach>	
	</div>
</body>
	<%@ include file="footerAll.jsp" %>
	<script type="text/javascript" src="./resources/static/js/popupReg.js"></script>
</html>
