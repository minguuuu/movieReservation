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
<title>회원정보 수정</title>

<link rel="stylesheet" type="text/css" href="../css/hotelCss.css">

</head>
<body>
	<c:import url="../movie/movieHeader.jsp"></c:import>
	<div id="join_wrap">
	<form id="joinForm" action="memberModifyOK.do" method="post">
		<div id="join_text"><b>회원정보 수정</b></div>
	 	<table id="joinTable1">
	 		<tr>
	 			<td class="sub_text">이름</td>
	 			<td>
	 				<input type="text" name="name" maxlength="5"  value="${userInfo.name}" class="boxwidth" readonly>
	 			</td>
	 		</tr>
	 		<tr>
	 			<td class="sub_text">아이디</td>
	 			<td>
					<input type="text" name="id" maxlength="13" value="${userInfo.id}" class="boxwidth" readonly>
	 			</td>
	 		</tr>
	 		<tr>
	 			<td class="sub_text">비밀번호</td>
	 			<td>
	 				<input type="password" name="pw" class="boxwidth" maxlength="16" required>
	 			</td>
	 		</tr>
	 		<tr>
	 			<td class="sub_text">비밀번호 확인</td>
	 			<td>
	 				<input type="password" name="pw2" class="boxwidth" maxlength="16" required>
	 			</td>
	 		</tr>
	 		<tr>
	 			<td class="sub_text">이메일</td>
	 			<td>
	 				<input type="text" name="email" value="${userInfo.email}" class="boxwidth" required>
	 			</td>
	 		</tr>
	 		<tr>
	 			<td class="sub_text">생년월일</td>
	 			<td>
	 				<input type="text" name="birthYear" value="${userInfo.birthYear}" class="birthwidth" required>
	 				<input type="text" name="birthMonth" value="${userInfo.birthMonth}" class="birthwidth" required>
	 				<input type="text" name="birthDate" value="${userInfo.birthDate}" class="birthwidth" required>
	 			</td>
	 		</tr>
	 		<tr>
	 			<td class="sub_text">휴대폰 번호</td>
	 			<td>
	 				<input type="text" name="cellphone" maxlength="11" value="${userInfo.cellphone}" class="boxwidth" required>
	 			</td>
	 		</tr>
	 		
	 	</table>

	 	<div id="last_submit">
	 		<input type="submit" name="submit" value="수정하기">
	 	</div>
	 </form>
	 </div>
	 
	 <c:import url="../movie/movieFooter.jsp"></c:import>
</body>
</html>