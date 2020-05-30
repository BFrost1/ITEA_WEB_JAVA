<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored= "false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<html>
	<head>
		<title>Telescopes</title>
		<%@ include file="styleAll.jsp" %>
		<link rel="stylesheet" type="text/css" href="./resources/static/css/homePage/solarsystem.css">
		
	</head>
	<body>
			<%@ include file="headAll.jsp" %>
		<main>
			<div class = "question"> What do you want to see?</div>
			<div class="wrap clearfix">
			    <section class="clearfix">
			        <ul class="solarsystem">
			          <li class="sun"><a href="#sun"><span>Sun</span></a></li>
			          <li class="mercury"><a href="#mercury"><span>Mercury</span></a></li>
			          <li class="venus"><a href="#venus"><span>Venus</span></a></li>
			          <li class="earth"><a href="#earth"><span>Earth<span class="moon"> &amp; Moon</span></span></a></li>
			          <li class="mars"><a href="#mars"><span>Mars</span></a></li>
			          <li class="jupiter"><a href="#jupiter"><span>Jupiter</span></a></li>
			          <li class="saturn"><a href="#saturn"><span>Saturn &amp; 
			          <span class="ring">Ring</span></span></a></li>
			          <li class="uranus"><a href="#uranus"><span>Uranus</span></a></li>
			          <li class="neptune"><a href="#neptune"><span>Neptune</span></a></li>
			          <li class="pluto"><a href="#pluto"><span>Pluto</span></a></li>
			        </ul>
			        
			        <ul id="descriptions">
			            <li>
			             <h2 id = "mercury"> <a href="./telescopes?id=2">Mercury</a></h2>
			            </li>
			            
			            <li>
			             <h2 id = "venus"><a href="./telescopes?id=1">Venus</a></h2>
			            </li>
			             
			            <li>
			             <h2 id = "earth"><a href="./telescopes?id=0">Earth</a></h2></a>
			            </li>
			            
			            <li>
			             <h2 id = "mars"> <a href="./telescopes?id=1">Mars</a></h2>
			            </li>
			            
			            <li>
			              <h2 id = "jupiter"><a href="./telescopes?id=2">Jupiter</a></h2>
			            </li>
			            
			            <li>
			             <h2 id = "saturn"><a href="./telescopes?id=3">Saturn</a></h2>
			            </li>
			            
			            <li>
			              <h2 id = "uranus"><a href="./telescopes?id=4">Uranus</a></h2>
			            </li>
			            
			            <li>
			              <h2 id = "neptune"><a href="./telescopes?id=5">Neptune</a></h2>
			            </li>
			            
			            <li>
			             <h2 id = "pluto"> <a href="./telescopes?id=6">Pluto</a></h2>
			            </li>
			        </ul>
			    </section>
		  </div>
		</main>  
		</body>
		<%@ include file="footerAll.jsp" %>
	<script type="text/javascript" src="./resources/static/js/popupReg.js"></script>
	<script type="text/javascript" src="./resources/static/js/solarsystem.js"></script>
</html>
