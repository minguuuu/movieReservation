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
<title>영화 수정하기</title>

<link rel="stylesheet" type="text/css" href="../css/hotelCss.css?test23">

</head>
<body>
	<c:import url="movieHeader.jsp"></c:import>
	
	<form id="movieRegisterForm" method="post" action="../movie/movieModifyOK.do">
		<table>
			<tr>
				<td>영화제목</td>
				<td><input type="text" name="title" value="${movieInfo.title}" readonly></td>
			</tr>
			<tr>
				<td>감독</td>
				<td><input type="text" name="director" value="${movieInfo.director}"></td>
			</tr>
			<tr>
				<td>상영시간</td>
				<td><input type="text" name="runtime" value="${movieInfo.run_time}"></td>
			</tr>
			<tr>
				<td colspan="2"><textarea name="contents" rows="15" cols="32">${movieInfo.contents}</textarea></td>
			</tr>
			<tr>
				<td colspan="2">
					<div id="registerButton">
						<input type="hidden" value="${movieInfo.movie_id}">
						<input type="submit" value="수정하기">
					</div>
				</td>
			</tr>
		</table>
	</form>
	
	<c:import url="movieFooter.jsp"></c:import>
</body>
</html>