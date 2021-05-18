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

<link rel="stylesheet" type="text/css" href="../css/hotelCss.css?test2">

</head>
<body>
	<header id="hd">
		<div id="hd_wrap">
			<div id="logo">
				<a href="../index.do"><img src="../images/logo3.png"></a>
			</div>
			
			<ul id="t_nav1">
				<li class="main_menu"><a href="../movie/movieList.do">영화목록</a>
					<!-- <ul class="sub_menu">
						<li><a href="#">Introduce</a></li>
						<li><a href="#">Location</a></li>
						<li><a href="#">VR Tour</a></li>
					</ul> -->
				</li>
				<li class="main_menu"><a href="../movie/ticketingMain.do">예매하기</a></li>
				<li class="main_menu"><a href="../movie/reservationCheck.do?member_id=${userInfo.id}">예메확인</a></li>
				<!-- <li class="main_menu"><a href="#">공지사항</a></li> -->
				<li class="main_menu"><a href="#">Mingu's Movie</a></li>
			</ul>

			<ul id="t_nav2">
				<c:if test="${1 eq userInfo.grade}">
					<li><a href="../movie/managerMain.do">${userInfo.id}님</a></li>
				</c:if>
				<c:if test="${0 eq userInfo.grade}">
					<li>${userInfo.id}님</li>
				</c:if>
				<li><a href="../Member/memberModify.do">회원정보 수정</a></li>
				<li><a href="../logout.do">로그아웃</a></li>
			</ul>
		</div>
	</header>
</body>
</html>