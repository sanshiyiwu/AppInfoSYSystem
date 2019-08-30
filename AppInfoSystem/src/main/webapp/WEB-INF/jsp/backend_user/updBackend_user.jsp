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
	<h3>修改后台管理用户</h3>
	<form action="javascript:;" id="updForm">
		<div>
			用户名：<input type="text" name="userCode" value="${backendUser.userCode}" required="required">
		</div><br/>
		<div>
			用户真实姓名：<input type="text" name="userName" value="${backendUser.userName}" required="required">
		</div><br/>
		<div>
		密码：<input type="password" name="password" value="${backendUser.userPassword}" required="required">
		</div><br/>
		<div>
		用户类型：<c:if test="${backendUser.userType==1}">
						<select name="userType">
							<option value="0">请选择</option>
							<option value="1" checked>管理员用户</option>
							<option value="2">普通用户</option>
						</select>
				</c:if>
				<c:if test="${backendUser.userType==2}">
						<select name="userType">
							<option value="0">请选择</option>
							<option value="1">管理员用户</option>
							<option value="2" checked>普通用户</option>
						</select>
				</c:if>
		</div><br/>
		<input type="submit" value="提交">
		<input type="reset" value="清空">
		<input type="button" value="返回" onclick="javascript:back();">
	</form>
</body>
	<script>
	$("form").submit(function(){
		var data=new FormData(document.getElementById("updForm"));
		$.ajax({
			url:"<%=request.getContextPath()%>/backend_user/index/updBackend_userSave",
			data:data,
			type:"POST",
			dataType:"html",
			processData:false,
			contentType:false,
			success:function(data){
				$("#content").html(data);
			}
		});
	})
	function back(){
		$("#content").load("<%=request.getContextPath()%>/backend_user/index/showBackend_userList")
	}
	</script>
</html>