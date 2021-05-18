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
<title>예매하기(영화선택)</title>

<link rel="stylesheet" type="text/css" href="../css/hotelCss.css?test8">

</head>
<body>
	<c:import url="movieHeader.jsp"></c:import>
	
	<form method="post" action="ticketingRoom.do">
		<table id="ticketingMainTable">
			<tr>
				<td>
					<select name="title">
						<option value="-">영화선택</option>
						<c:forEach var="dto" items="${list}">
							<option value="${dto.movie_id}">${dto.title}</option>
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