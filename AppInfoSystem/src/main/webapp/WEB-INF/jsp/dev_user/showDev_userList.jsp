<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="<%=request.getContextPath()%>/statics/js/jquery.min.js"></script>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>开发者用户列表界面</h3><input type="button" value="增加开发者用户" onclick="javascript:addDev_user();">
	<table id="userList" style="border:1px solid">
		<thead>
			<tr>
				<td>序号</td>
				<td>用户名</td>
				<td>用户真实姓名</td>
				<td>电子邮箱</td>
				<td>用户信息</td>
				<td>创建者</td>
				<td>创建时间</td>
				<td>修改者</td>
				<td>修改时间</td>
				<td>功能</td>
			</tr>
		</thead>
		<c:forEach items="${DevUserList}" var="DevUser">
			<tbody>
				<tr>
					<td>${DevUser.id}</td>
					<td>${DevUser.devCode}</td>
					<td>${DevUser.devName}</td>
					<td>${DevUser.devEmail}</td>
					<td>${DevUser.devInfo}</td>
					<td>${DevUser.createdBy}</td>
					<td>${DevUser.creationDate}</td>
					<td>${DevUser.modifyBy}</td>
					<td>${DevUser.modifyDate}</td>
					<td>
						<a href="javascript:updateUser(${DevUser.id});">修改</a>
						<a href="javascript:delteUser(${DevUser.id});">删除</a>
					</td>
				</tr>
			</tbody>
		</c:forEach>
	</table>
</body>
	<script>
		function updateUser(id){
			$("body").load("<%=request.getContextPath()%>/Dev_user/index/updDev_user"+id);
		}
		function deleteUser(id){
			$("body").load("<%=request.getContextPath()%>/Dev_user/index/delDev_user"+id);
		}
		function addDev_user(){
    		$("body").load("<%=request.getContextPath()%>/Dev_user/index/addDev_user")
    	}
	</script>
</html>