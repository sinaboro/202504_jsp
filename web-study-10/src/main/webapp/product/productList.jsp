<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>상품 리스트 - 관리자 페이지</h1>
	<table>
		<tr>
			<td colspan="5" align="center">상품 등록</td>
		</tr>
		<tr>
			<td>번호</td>
			<td>이름</td>
			<td>가격</td>
			<td>수정</td>
			<td>삭제</td>
		</tr>
		
		<c:forEach  var = "product" items="${productList}">
			<tr>
				<td>${product.code}</td>
				<td>${product.name}</td>
				<td>${product.price}</td>
				<td>상품 수정</td>
				<td>상품 삭제</td>
			</tr>
		</c:forEach>		
	</table>
</body>
</html>