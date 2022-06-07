<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="../template/header.jspf" %>
</head>
<body>
<%@ include file="../template/menu.jspf" %>
<ol class="breadcrumb">
  <li><a href="${root }">Home</a></li>
  <li class="active">Emp</li>
</ol>
<div class="page-header">
  <h1>List Page<small>EMP</small></h1>
</div>
<table class="table">
	<thead>
		<tr>
			<th>empno</th>
			<th>ename</th>
			<th>sal</th>
			<th>job</th>
		</tr>
	</thead>
	<c:forEach items="${list }" var="bean">
		<tr>
			<td><a href="detail?idx=${bean.empno }">${bean.empno }</a></td>
			<td>${bean.ename }</td>
			<td>${bean.sal }</td>
			<td>${bean.job }</td>
		</tr>
	</c:forEach>
	<tbody>
	</tbody>
</table>
<p>
	<a href="add" class="btn btn-primary btn-block" role="button">입력</a>
</p>
<%@ include file="../template/footer.jspf" %>
</body>
</html>