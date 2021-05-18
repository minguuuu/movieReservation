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
<title>회원가입</title>


<link rel="stylesheet" type="text/css" href="../css/hotelCss.css">

</head>
<body>
	<div id="join_wrap">
	<form id="joinForm" action="memberRegisterOK.do" method="post">
		<div id="join_text"><b>회원가입</b></div>
	 	<table id="joinTable1">
	 		<tr>
	 			<td class="sub_text">이름</td>
	 			<td>
	 				<input type="text" name="name" maxlength="5" value="이름을 입력하세요." onclick=this.value='' class="boxwidth" required>
	 			</td>
	 		</tr>
	 		<tr>
	 			<td class="sub_text">아이디</td>
	 			<td>
					<input type="text" name="id" maxlength="13" value="아이디를 입력하세요." onclick=this.value='' class="boxwidth" required>
					<div class="join_button"><input type="button" name="idtest" value="중복 확인"></div>
	 			</td>
	 		</tr>
	 		<tr>
	 			<td class="sub_text">비밀번호</td>
	 			<td>
	 				<input type="password" name="pw" onclick=this.value='' class="boxwidth" maxlength="16" required>
	 			</td>
	 		</tr>
	 		<tr>
	 			<td class="sub_text">비밀번호 확인</td>
	 			<td>
	 				<input type="password" name="pw2" onclick=this.value='' class="boxwidth" maxlength="16" required>
	 			</td>
	 		</tr>
	 		<tr>
	 			<td class="sub_text">이메일</td>
	 			<td>
	 				<input type="text" name="email" onclick=this.value='' class="boxwidth" required>
	 			</td>
	 		</tr>
	 		<tr>
	 			<td class="sub_text">생년월일</td>
	 			<td>
	 				<input type="text" name="birthYear" value="년도" onclick=this.value='' class="birthwidth" required>
	 				<input type="text" name="birthMonth" value="월" onclick=this.value='' class="birthwidth" required>
	 				<input type="text" name="birthDate" value="일" onclick=this.value='' class="birthwidth" required>
	 			</td>
	 		</tr>
	 		<tr>
	 			<td class="sub_text">휴대폰 번호</td>
	 			<td>
	 				<input type="text" name="cellphone" maxlength="11" value="휴대폰번호를 입력하세요." onclick=this.value='' class="boxwidth" required>
	 			</td>
	 		</tr>
	 		
	 	</table>

	 	<div id="last_submit">
	 		<input type="submit" name="submit" value="회원가입">
	 	</div>
	 </form>
	 </div>

</body>
</html>