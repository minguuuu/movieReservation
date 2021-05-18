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
<title>예약확인</title>

<link rel="stylesheet" type="text/css" href="../css/hotelCss.css?test8">

</head>
<body>
	<c:import url="movieHeader.jsp"></c:import>
	
	<table id="managerMamberTable">
		<tr>
			<td>아이디</td>
			<td>영화제목</td>
			<td>상영관</td>
			<td>시간</td>
			<td>좌석</td>
			<td></td>
		</tr>
		<c:forEach var="dto" items="${list}">
			<tr>
				<td>${dto.id}</td>
				<td>${dto.title}</td>
				<td>${dto.room}</td>
				<td>${dto.time}</td>
				<td>${dto.row}열 ${dto.column}열</td>
				<td><input type="button" value="예약취소" onclick="location.href='../movie/deleteReservation.do?member_id=${userInfo.id}&seat_id=${dto.seat_id}'"></td>
			</tr>
		</c:forEach>
	</table>
	
	<c:import url="movieFooter.jsp"></c:import>
</body>
</html>