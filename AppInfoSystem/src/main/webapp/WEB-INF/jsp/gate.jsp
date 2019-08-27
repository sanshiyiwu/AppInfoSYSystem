<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
<script src="<%=request.getContextPath()%>/statics/localjs/jquery.min.js" type="text/javascript"></script>
<title>APP信息管理平台界面</title>
</head>
<body style="background:#F7F7F7;">
	<h1>APP信息管理平台</h1>
	后台管理系统<a href="javascript:showBackendLogin();">&nbsp;入口</a><br>
	开发者平台<a href="javascript:showDevLogin();">&nbsp;入口</a>
</body>
<script>
	function showBackendLogin(){
		$("body").load("<%=request.getContextPath()%>/backend/login")
	}
	function showDevLogin(){
		$("body").load("<%=request.getContextPath()%>/dev/login")
	}
</script>
</html>