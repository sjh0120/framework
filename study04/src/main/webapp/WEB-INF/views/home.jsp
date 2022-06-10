<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	  <h1>Main page!</h1>
	  <p>...</p>
	</div>
</div>
<script type="text/javascript">
$('#main').css('padding-top',$('nav').height());
</script>
</body>
</html>
