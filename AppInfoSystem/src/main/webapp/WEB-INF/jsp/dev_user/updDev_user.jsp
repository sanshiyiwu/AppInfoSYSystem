<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="${pageContext.request.contextPath }/statics/js/jquery.min.js"></script>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<title>Insert title here</title>
</head>
<body>
	<h3>修改开发者用户</h3>
	<form action="javascript:;" id="updForm">
		用户名：<input type="text" name="devCode" value="${devUser.devCode}" required="required"><br/>
		用户真实姓名：<input type="text" name="devName" value="${devUser.devName}" required="required"><br/>
		密码：<input type="password" name="devPassword" value="${devUser.devPassword}" required="required"><br/>
		电子邮箱:<input type="text" name="devEmail" value="${devUser.devEmail}" required="required"><br/>
		用户信息:<input type="text" name="devInfo" value="${devUser.devInfo}" required="required"><br/>
		<input type="submit" value="提交">
		<input type="reset" value="清空">
		<input type="button" value="返回" onclick="javascript:back();">
	</form>
</body>
	<script>
	$("form").submit(function(){
		var data=new FormData(document.getElementById("updForm"));
		$.ajax({
			url:"<%=request.getContextPath()%>/dev_user/index/updDev_userSave",
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
		$("body").load("<%=request.getContextPath()%>/dev_user/index/showDev_userList")
	}
	</script>
</html>