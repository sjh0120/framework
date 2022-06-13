<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>Home</title>
<link rel="stylesheet" type="text/css" href="webjars/bootstrap/5.1.3/css/bootstrap.min.css">
<script type="text/javascript">
</script>
</head>
<body>
<nav class="navbar navbar-dark bg-dark">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">Navbar</a>
  </div>
  <p class="navbar-text">
  	<a href="./">HOME</a>
  	<a href="./emp/">EMP</a>
  	<a href="./emp/add">EMP_Add</a>
  	<c:if test="${sessionScope.result eq true}">
  		<a href="./logout/">LOGOUT</a>
  	</c:if>
  	<c:if test="${sessionScope.result eq null}">
  		<a href="./login/">LOGIN</a>
  	</c:if>
  </p>
  <c:if test="${sessionScope.result}">
  <p class="navbar-text">${sessionScope.user }님 로그인 중...</p>
  </c:if>
</nav>
</body>
</html>
