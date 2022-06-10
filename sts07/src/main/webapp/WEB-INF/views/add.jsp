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
<div class="page-header">
  <h1>DEPT Insert Page <small>Add dept</small></h1>
</div>
<form action="./" method="post">
  <div class="form-group">
    <label for="deptno">deptno</label>
    <input type="text" name="deptno" class="form-control" id="deptno" placeholder="deptno">
  </div>
  <div class="form-group">
    <label for="dname">dname</label>
    <input type="text" name="dname" class="form-control" id="dname" placeholder="dname">
  </div>
  <div class="form-group">
    <label for="loc">loc</label>
    <input type="text" name="loc" class="form-control" id="loc" placeholder="loc">
  </div>
  <button type="submit" class="btn btn-primary">입력</button>
  <button type="reset" class="btn btn-default">취소</button>
  <button type="button" class="btn btn-default" onclick="history.back();">뒤로</button>
</form>
</body>
</html>