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
<title>예매하기(좌석선택)</title>

<link rel="stylesheet" type="text/css" href="../css/hotelCss.css?test8">

</head>
<body>
	<c:import url="movieHeader.jsp"></c:import>
	
	<form method="post" action="ticketingOK.do">
		<table id="ticketingMainTable">
			<c:set var="check" value="0" />
			<c:forEach var="i" begin="1" end="10" step="1">
				<tr>
					<td>
						<c:forEach var="j" begin="1" end="10" step="1">
							<c:set var="row" value="${i}"/>
							<c:set var="column" value="${j}"/>
							<c:forEach var="dto" items="${dto}">
		 						<c:if test="${row eq dto.row}">
									<c:if test="${column eq dto.column}">
										<c:set var="check" value="1" />
									</c:if>
								</c:if> 
							</c:forEach>
							<c:if test="${check eq 1}">
								<input type="checkbox" checked="checked" disabled="disabled">
							</c:if>
							<c:if test="${check eq 0 }">
								<input type="checkbox" name="seat" value="${i},${j}">
							</c:if>
							<c:set var="check" value="0" />
						</c:forEach>
					</td>
				</tr> 
			</c:forEach>
			<tr>
				<td>
					<input type="hidden" name="member_id" value="${userInfo.id}">
					<input type="hidden" name="time_id" value="${time_id}">
					<input type="submit" value="예매하기">
				</td>
			</tr>
		</table>
	</form>
	
	<c:import url="movieFooter.jsp"></c:import>
</body>
</html>