<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored= "false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="UTF-8">
		<%@ include file="styleAll.jsp" %>
		<link rel="stylesheet" type="text/css" href="./resources/static/css/items/goods.css">
	</head>
	<body>
		<%@ include file="headAll.jsp" %>
		<main>
			<div class = "goods-block">
				<div class="menu-filter">
					<form class = "filter">
						<ul>
							<li><h3>What do you want to see?</h3></li>
							<li><input type="checkbox" value="2" name="mercury">Mercury</li>
							<li><input type="checkbox" value="1" name="venus">Venus</li>
							<li><input type="checkbox" value="0" name="earth">Earth</li> 
							<li><input type="checkbox" value="1" name="Mars">Mars</li>
							<li><input type="checkbox" value="2" name="jupiter">Jupiter</li> 
							<li><input type="checkbox" value="3" name="saturn">Saturn</li> 
							<li><input type="checkbox" value="4" name="uranus">Uranus</li> 
							<li><input type="checkbox" value="5" name="neptune">Neptune</li> 
							<li><input type="checkbox" value="6" name="pluto">Pluto</li> 
							<li><input class = "buttom-filter" type="submit" value="SEARCH"></li>
						</ul>
					</form>
				</div>
				<div class="catalog-grid">
					<div class="catalog-grid__cell">
					
						<c:forEach items="${goods}" var="item">
		    					<div class="cell">
									<div><img src="./resources/static/img/telescopes/${item.linkImg}"></div>
									<div><span>${item.name}</span></div>
									<div class="price">
										<div>${item.price} $</div>
										<div><i class="fa fa-shopping-bag p-l-r-5" id ='${item.id}'></i></div>
									</div>
								</div>
						</c:forEach>
						
					</div>
				</div>
			</div>
		</main>		
	</body>
	<%@ include file="footerAll.jsp" %>
	<script type="text/javascript" src="./resources/static/js/popupReg.js"></script>
</html>