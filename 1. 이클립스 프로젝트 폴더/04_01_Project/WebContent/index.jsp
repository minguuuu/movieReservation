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
<title>Insert title here</title>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	
<link rel="stylesheet" type="text/css" href="css/jquery.bxslider.css">
<script src="js/jquery.bxslider.js?test"></script>
	
<link rel="stylesheet" type="text/css" href="slick/slick.css"/>
<link rel="stylesheet" type="text/css" href="slick/slick-theme.css"/>
<script type="text/javascript" src="slick/slick.min.js"></script>

<script type="text/javascript" src="js/hotelJS.js"></script>

<link rel="stylesheet" type="text/css" href="css/hotelCss.css?test5">

</head>
<body>
	<c:if test="${userInfo eq null}">
		<form action="login.do" method="post">
			<table id="indexTable">
			<tr>
				<td colspan="2">
					<img src="images/indexLogo.jpg">
				</td>
			</tr>
			<tr>
				<td>아이디</td>
				<td><input type="text" name="id"><td>
			<tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="pw"></td>
			<tr>
			<tr>
			<td colspan="2">
				<div class="indexButton">
					<input type="submit" value="로그인">
					<input type="button" value="회원가입" onclick="location.href='Member/memberRegister.do'">
				</div>	
			</td>
			</tr>
			</table>			
		</form>
	</c:if>
	
	<section id="sec2" class="slider2">
		<div class="sec2art">
			<img src="images/movie1.jpg">
		</div>
		<div class="sec2art">
			<img src="images/movie2.jpg">
		</div>
		<div class="sec2art">
			<img src="images/movie3.jpg">
		</div>
		<div class="sec2art">
			<img src="images/movie4.jpg">
		</div>
		<div class="sec2art">
			<img src="images/movie5.jpg">
		</div>
		<div class="sec2art">
			<img src="images/movie6.jpg">
		</div>
		<div class="sec2art">
			<img src="images/movie7.jpg">
		</div>
	</section>
	
	<c:if test="${userInfo ne null }">
		<script>
			location.href="movie/movieMain.do";
		</script>
	</c:if>
	
	<c:import url="movie/movieFooter.jsp"></c:import>
</body>
</html>