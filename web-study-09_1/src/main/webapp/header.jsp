<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	 td{
	 	border: 1px solid black;
	 	width: 200px;
	 	text-align: center;
 	 }
 	 .menu{
 	 	
 	 }
</style>
</head>
<body>
	<table class="menu" align="center" style="width:70%">
		<c:if test="${empty loginUser}">
			<tr>
				<td></td><td></td>
				<td>로그인</td>
				<td style="width:20%">
					사원등록<br>
					<span>(관리자로 로그인 후 사용 가능)</span>
				</td>
				<td style="width:20%">
					마이페이지<br>
					<span>(로그인 후 사용 가능)</span>
				</td>
				
			</tr>
		</c:if>
		<c:if test="${!empty loginUser}">
			<tr>
				<td>${loginUser.name}님 반갑습니다</td>
				<td>레벨 : ${loginUser.lev}</td>
				<td>로그아웃</td>
				<td>
					<c:if test="${loginUser.lev == 'A' }">
						사원등록
					</c:if>
					<c:if test="${loginUser.lev == 'B' }">
						사원등록<br>
						<span>(관리자로 로그인 후 사용 가능)</span>
					</c:if>
				</td>
				<td>
					마이페이지
				</td>
				
			</tr>
		</c:if>
	</table>
</body>
</html>