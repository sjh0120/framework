<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="template/header.jspf" %>
</head>
<body>
<%@ include file="template/menu.jspf" %>
<div id="main">
	<div class="jumbotron">
	  <h1>Emp page!</h1>
	  <p>...</p>
	</div>
</div>
<table class="table">
	<thead>
		<tr>
			<th>empno</th>
			<th>ename</th>
			<th>job</th>
			<th>sal</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${list }" var="bean">
		<tr>
			<td><a href="./${bean.empno }">${bean.empno }</a></td>
			<td><a href="./${bean.empno }">${bean.ename }</a></td>
			<td><a href="./${bean.empno }">${bean.job }</a></td>
			<td><a href="./${bean.empno }">${bean.sal }</a></td>
		</tr>
		</c:forEach>
	</tbody>
</table>
<script type="text/javascript">
$('#main').css('padding-top',$('nav').height());
</script>
</body>
</html>
