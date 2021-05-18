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
<title>회원관리</title>

<link rel="stylesheet" type="text/css" href="../css/hotelCss.css?test22">

</head>
<body>
	<c:import url="movieHeader.jsp"></c:import>
	
	<table id="managerMamberTable">
		<tr>
			<td>이름</td>
			<td>아이디</td>
			<td>비밀번호</td>
			<td>이메일</td>
			<td>생년월일</td>
			<td>휴대전화</td>
			<td>가입일자</td>
			<td>등급</td>
			<td></td>
		</tr>
		<c:forEach var="dto" items="${list}">
			<tr>
				<td>${dto.name}</td>
				<td>${dto.id}</td>
				<td>${dto.pw }</td>
				<td>${dto.email }</td>
				<td>${dto.birthYear}년 ${dto.birthMonth}월 ${dto.birthDate}일</td>
				<td>${dto.cellphone}</td>
				<td>${dto.wTime}</td>
				<td>
					<c:if test="${dto.grade eq 1}">매니저</c:if>
					<c:if test="${dto.grade eq 0}">일반회원</c:if>
				</td>
				<td><input type="button" value="강제탈퇴" onclick="location.href='../movie/deleteMember.do?id=${dto.id}'"></td>
			</tr>
		</c:forEach>
	</table>
	
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
				<a href="../movie/managerMember.do?curPage=${i}">${i+1}</a>
			</c:if>			
		</c:forEach>
	</div>
	
	<c:import url="movieFooter.jsp"></c:import>
</body>
</html>