<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="description" content="HTML Study">
<meta name="keywords" content="HTML,CSS,XML,JavaScript">
<meta name="author" content="Mingu">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Mingu's Movie</title>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	
<link rel="stylesheet" type="text/css" href="../css/jquery.bxslider.css">
<script src="../js/jquery.bxslider.js?test"></script>
	
<link rel="stylesheet" type="text/css" href="../slick/slick.css"/>
<link rel="stylesheet" type="text/css" href="../slick/slick-theme.css"/>
<script type="text/javascript" src="../slick/slick.min.js"></script>

<link rel="stylesheet" type="text/css" href="../css/hotelCss.css?test6">
<script type="text/javascript" src="../js/hotelJS.js"></script>

</head>
<body>
	<c:import url="movieHeader.jsp"></c:import>
	<div id="sec1">
		<article id="sec1art">
			<ul class="bxslider">
				<li><iframe width="1280" height="720" src="https://www.youtube.com/embed/Ko2NWhXI9e8?autoplay=1&mute=1" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe></li>
				<li><iframe width="1280" height="720" src="https://www.youtube.com/embed/5O5PVvHTWRo" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe></li>
				<li><iframe width="1280" height="720" src="https://www.youtube.com/embed/hcKp68DtBb0" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe></li>
				<li><iframe width="1280" height="720" src="https://www.youtube.com/embed/BBEDtovULHY" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe></li>
			</ul>
		</article>
	</div>

	<div class="text_a">HOT MOVIE</div>
	<section id="sec2" class="slider2">
		<div class="sec2art">
			<a href="#"><img src="../images/movie1.jpg"></a>
		</div>
		<div class="sec2art">
			<a href="#"><img src="../images/movie2.jpg"></a>
		</div>
		<div class="sec2art">
			<a href="#"><img src="../images/movie3.jpg"></a>
		</div>
		<div class="sec2art">
			<a href="#"><img src="../images/movie4.jpg"></a>
		</div>
		<div class="sec2art">
			<a href="#"><img src="../images/movie5.jpg"></a>
		</div>
		<div class="sec2art">
			<a href="#"><img src="../images/movie6.jpg"></a>
		</div>
		<div class="sec2art">
			<a href="#"><img src="../images/movie7.jpg"></a>
		</div>
	</section>

	<div class="text_a">EXPORE TASTE</div>
	<section id="sec3">
		<div class="sec3art">
			<a href="#"><img src="../images/taste13.jpg"></a>
		</div>
		<div class="sec3art">
			<a href="#"><img src="../images/taste14.jpg"></a>
		</div>
		<div class="sec3art">
			<a href="#"><img src="../images/taste15.jpg"></a>
		</div>
		<div class="sec3art">
			<a href="#"><img src="../images/taste16.jpg"></a>
		</div>
	</section>

	<div class="cle"></div>

	<c:import url="movieFooter.jsp"></c:import>
</body>
</html>