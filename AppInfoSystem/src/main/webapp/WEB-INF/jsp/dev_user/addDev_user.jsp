<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="${pageContext.request.contextPath }/statics/js/jquery.min.js"></script>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<title></title>
</head>
<body>
	<h3>增加开发者用户</h3>
	<form action="javascript:;" id="addForm">
		<input type="hidden" value="" name="id">
		用户名：<input type="text" name="devCode" value="" required="required"><br/>
		用户真实姓名：<input type="text" name="devName" value="" required="required"><br/>
		密码：<input type="password" name="devPassword" value="" required="required"><br/>
		电子邮箱:<input type="text" name="devEmail" value="" required="required"><br/>
		用户信息:<input type="text" name="devInfo" value="" required="required"><br/>
		<input type="submit" value="提交">
		<input type="reset" value="清空">
		<input type="button" value="返回" onclick="javascript:back();">
	</form>
</body>
<script>
	$("form").submit(function(){
		var data=new FormData(document.getElementById("addForm"));
		$.ajax({
			url:"<%=request.getContextPath()%>/Dev_user/index/addDev_userSave",
			data:data,
			type:"POST",
			dataType:"html",
			processData:false,
			contentType:false,
			success:function(data){
				$("body").html(data);
			}
		});
	})
	function back(){
		$("body").load("<%=request.getContextPath()%>/Dev_user/index/showDev_userList")
	}
</script>
	
</html>