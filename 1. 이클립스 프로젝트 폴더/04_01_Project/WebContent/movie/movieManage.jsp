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
<title>영화관리</title>

<link rel="stylesheet" type="text/css" href="../css/hotelCss.css?test3">

</head>
<body>
	<c:import url="movieHeader.jsp"></c:import>
	<form id="movieListForm">
		<c:forEach var="dto" items="${list}">
			<table class="movieListTable">
			<tr>
				<td class="listBar">
					<img src="../images/listBar.JPG">
				</td>
				<td class="mvoieList1">
				<b>${dto.title}</b><br/>
				감독 ${dto.director}<br/>
				상영시간 ${dto.run_time}분<br/>
				</td>
				<td class="poster"><img src="../poster/${dto.poster}"></td>
			</tr>
			<tr>
				<td colspan="3" class="mvoieContents">${dto.contents}</td>
			</tr>
			<tr>
				<td colspan="3">
					<div  id="mobieManageButton">
						<input type="button" value="수정하기" onclick="location.href='../movie/movieModify.do?title=${dto.title}&director=${dto.director}&runtime=${dto.run_time}&contents=${dto.contents}'">
						<input type="button" value="삭제하기" onclick="location.href='../movie/movieDelete.do?title=${dto.title}'">
					</div>
				</td>
			</tr>
			</table>
		</c:forEach>
	</form>
	
	<div id="moviePage">
		<c:set var="curPage" value="${param.curPage }" />
		<c:if test="${curPage eq null }">
			<c:set var="curPage" value="0"/>
		</c:if>
		<c:forEach var="i" begin="0" end="${totalPage}" step="1">
			<c:if test="${i eq curPage}">
				${i+1}
			</c:if>
			<c:if test="${i ne curPage}">
				<a href="../movie/movieManage.do?curPage=${i}">${i+1}</a>
			</c:if>			
		</c:forEach>
	</div>
	
	<c:import url="movieFooter.jsp"></c:import>
</body>
</html>