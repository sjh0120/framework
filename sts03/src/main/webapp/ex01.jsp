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
	<h1>jstl</h1>
	<h2>out</h2>
	<ul>
		<li><c:out value="1234"></c:out></li>
		<li><c:out value="3.14"></c:out></li>
		<li><c:out value="문자열"></c:out></li>
		<li><c:out value="값1">값2</c:out></li>
		<%-- <li><c:out>abcd</c:out></li> --%><!-- 안됨! -->
		<li><c:out value="${null }">값</c:out></li><!-- null이라서 값이 대체되서 들어감 -->
		<li><c:out value="">비었음</c:out></li><!-- 공백은 null이 아니라서 값 대체 안됨 -->
		<li><c:out value="null">비었음2</c:out></li><!-- 또한 value="null"은 값이 0 이 아님! 따라서 대체 x-->
		<li><c:out default="초기값" value=""></c:out></li>
		<li><c:out default="초기값" value="${null }"></c:out></li>
		<li>${"출력" }</li>
		<c:set value="abc" var="a1" scope="page"></c:set>
		<li>${a1 }</li>
		<li><c:out value="${a1 }"></c:out></li>
		<li><c:set var="a2" scope="page">1234</c:set></li>
		<li>${pageScope.a2 }</li>
		<c:set var="a2" scope="request">4321</c:set>
		<li>${requestScope.a2 }</li>
		<jsp:useBean id="bean" class="com.bit.frame.service.UserService"></jsp:useBean>
		<c:set target="${bean}" value="2222" property="su"></c:set>
		<li>${bean.su }</li><!-- 왜 안되지...? -->
	</ul>
</body>
</html>