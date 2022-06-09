<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="webjars/bootstrap/3.4.1/css/bootstrap.min.css">
<script type="text/javascript" src="webjars/jquery/1.12.4/dist/jquery.min.js"></script>
<script type="text/javascript" src="webjars/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
<nav class="navbar navbar-default navbar-fixed-top">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#main">비트교육센터</a>
    </div>
    <ul class="nav navbar-nav">
    	<li><a href="#main">HOME</a></li>
    	<li><a href="#emp">EMP</a></li>
    	<li><a href="#addemp">ADD EMP</a></li>
    	<li><a href="#login">LOGIN</a></li>
    </ul>
  </div>
</nav>
<div id="main"></div>
<div id="emp">
<table class="table">
	<thead>
		<tr>
			<th>empno</th>
			<th>ename</th>
			<th>job</th>
			<th>sal</th>
		</tr>
	</thead>
	<tbody id="tBody"></tbody>
</table>
<div id="addemp" class="container">
	<h2>입력페이지</h2>
	<form class="form-horizontal">
	  <div class="form-group">
	    <label class="col-sm-2 control-label">empno</label>
	    <div class="col-sm-10">
	      <input type="text" class="form-control" name="empno" placeholder="Empno">
	    </div>
	  </div>
	  <div class="form-group">
	    <label class="col-sm-2 control-label">ename</label>
	    <div class="col-sm-10">
	      <input type="text" class="form-control" name="ename" placeholder="Ename">
	    </div>
	  </div>
	  <div class="form-group">
	    <label class="col-sm-2 control-label">sal</label>
	    <div class="col-sm-10">
	      <input type="text" class="form-control" name="sal" placeholder="Sal">
	    </div>
	  </div>
	  <div class="form-group">
	    <label class="col-sm-2 control-label">job</label>
	    <div class="col-sm-10">
	      <input type="text" class="form-control" name="job" placeholder="Job">
	    </div>
	  </div>
	  <div class="form-group">
	    <div class="col-sm-offset-2 col-sm-10">
	      <button type="submit" class="btn btn-primary">입력</button>
	      <button type="reset" class="btn btn-default">취소</button>
	      <button type="button" class="btn btn-default">뒤로</button>
	    </div>
	  </div>
	</form>
</div>
</div>
<script type="text/javascript">
$('#main,#emp,#addemp').css('padding-top',$('nav').height());
$('#main,#addemp').height($(document).height());
showList();
function showList(){
	$('#tBody').empty();
	$.get('api/emp/',function(data){
		var arr=data.root;
		arr.forEach(function(ele,idx){
			$('<tr/>')
				.append('<td>'+ele.empno+'</td>')
				.append('<td>'+ele.ename+'</td>')
				.append('<td>'+ele.job+'</td>')
				.append('<td>'+ele.sal+'</td>')
				.appendTo('#tBody')
		});
	});
};

$('#addemp form').submit(function(e){
	$.post('api/emp/',$(e.target).serialize(),function(){
		location.href="#emp";
		showList();
		e.target.empno.value='';
		e.target.ename.value='';
		e.target.sal.value='';
		e.target.job.value='';
	});
});
</script>
</body>
</html>