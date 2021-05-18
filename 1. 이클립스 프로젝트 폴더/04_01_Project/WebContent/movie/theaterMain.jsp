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
<title>영화관 관리</title>
<link rel="stylesheet" type="text/css" href="../css/hotelCss.css?test19">

</head>
<body>
	<c:import url="movieHeader.jsp"></c:import>

	<table id="managerMainTable">
		<tr>
			<td><div class="managerbutton"><input type="button" value="상영관등록" onclick="location.href='../movie/theaterRegister.do'"></div></td>
		</tr>
		<tr>
			<td><div class="managerbutton"><input type="button" value="상영관관리" onclick="location.href='../movie/movieRegister.do'"></div></td>
		</tr>
	</table>

	<c:import url="movieFooter.jsp"></c:import>
</body>
</html>