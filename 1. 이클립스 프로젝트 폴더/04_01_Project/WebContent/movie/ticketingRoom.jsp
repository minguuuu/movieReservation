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
<title>예매하기(상영관선택)</title>

<link rel="stylesheet" type="text/css" href="../css/hotelCss.css?test8">

</head>
<body>
	<c:import url="movieHeader.jsp"></c:import>
	
	<form method="post" action="ticketingSeat.do">
		<table id="ticketingMainTable">
			<tr>
				<td>
					<select name="room">
						<option value="-">상영관선택</option>
						<c:forEach var="dto1" items="${roomList}">
							<option value="${dto1.room_id}">${dto1.number}</option>
						</c:forEach>
					</select>
					<select name="time">
						<option value="-">시간선택</option>
						<c:forEach var="dto2" items="${timeList}">
							<option value="${dto2.time_id}">${dto2.start_time}</option>
						</c:forEach>
					</select>
				</td>
				<td><input type="submit" value="다음"></td>
			</tr>
		</table>
	</form>
	
	<c:import url="movieFooter.jsp"></c:import>
</body>
</html>