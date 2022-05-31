<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="../template/header.jspf" %>
</head>
<body>
<%@ include file="../template/menu.jspf" %>
<div class="jumbotron">
  <h1>EMP Add page</h1>
</div>
<div class="container">
	<form class="form-horizontal" action="insert.bit" method="post">
	  <div class="form-group">
	    <label for="empno" class="col-sm-2 control-label">empno</label>
	    <div class="col-sm-10">
	      <input type="text" name="empno" class="form-control" id="empno" placeholder="empno">
	    </div>
	  </div>
	  <div class="form-group">
	    <label for="ename" class="col-sm-2 control-label">ename</label>
	    <div class="col-sm-10">
	      <input type="text" name="ename" class="form-control" id="ename" placeholder="ename">
	    </div>
	  </div>
	  <div class="form-group">
	    <label for="sal" class="col-sm-2 control-label">sal</label>
	    <div class="col-sm-10">
	      <input type="text" name="sal" class="form-control" id="sal" placeholder="sal">
	    </div>
	  </div>
	  <div class="form-group">
	    <label for="job" class="col-sm-2 control-label">job</label>
	    <div class="col-sm-10">
	      <input type="text" name="job" class="form-control" id="job" placeholder="job">
	    </div>
	  </div>
	  <div class="form-group">
	    <div class="col-sm-offset-2 col-sm-10">
		    <div class="btn-group btn-group-justified" role="group" aria-label="...">
		      <div class="btn-group" role="group">
		      	<button type="submit" class="btn btn-primary">입력</button>
		      </div>
		      <div class="btn-group" role="group">
		      	<button type="reset" class="btn btn-default">취소</button>
		      </div>
		      <div class="btn-group" role="group">
		      	<button type="button" class="btn btn-default" onclick="history.back();">뒤로</button>
		      </div>
		    </div>
	    </div>
	  </div>
	</form>
</div>
</body>
</html>