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
<title>영화등록</title>

<link rel="stylesheet" type="text/css" href="../css/hotelCss.css?test23">

</head>
<body>
	<c:import url="movieHeader.jsp"></c:import>
	
	<form id="movieRegisterForm" method="post" action="../movie/movieRegisterOK.do" enctype="multipart/form-data">
		<table>
			<tr>
				<td>영화제목</td>
				<td><input type="text" name="title"></td>
			</tr>
			<tr>
				<td>감독</td>
				<td><input type="text" name="director"></td>
			</tr>
			<tr>
				<td>상영시간</td>
				<td><input type="text" name="runtime"></td>
			</tr>
			<tr>
				<td colspan="2"><textarea name="contents" rows="15" cols="32" ></textarea></td>
			</tr>
			<tr>
				<td colspan="2"><input type="file" name="poster"></td>
			</tr>
			<tr>
				<td colspan="2">
					<div id="registerButton"><input type="submit" value="등록"></div>
				</td>
			</tr>
		</table>
	</form>
	
	<c:import url="movieFooter.jsp"></c:import>
</body>
</html>