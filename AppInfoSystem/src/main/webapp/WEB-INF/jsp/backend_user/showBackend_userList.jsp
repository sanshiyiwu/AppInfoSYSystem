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
	<div id="table">
	<h3>后台用户列表界面</h3><br>
	<input type="button" class="btn btn-primary" value="增加后台用户" onclick="javascript:addBackend_user();">
	<table id="userList" class="table table-striped table-bordered dt-responsive nowrap dataTable no-footer dtr-inline collapsed" cellspacing="0" width="100%" role="grid" aria-describedby="datatable-responsive_info" style="width: 100%;">
		<thead>
			<tr>
				<td>序号</td>
				<td>用户名</td>
				<td>用户真实姓名</td>
				<td>用户类型</td>
				<td>创建者</td>
				<td>创建时间</td>
				<td>修改者</td>
				<td>修改时间</td>
				<td>功能</td>
			</tr>
		</thead>
		<c:forEach items="${backendUserList}" var="backendUser">
			<tbody>
				<tr>
					<td>${backendUser.id}</td>
					<td>${backendUser.userCode}</td>
					<td>${backendUser.userName}</td>
					<td>${backendUser.userType}</td>
					<td>${backendUser.createdBy}</td>
					<td>${backendUser.creationDate}</td>
					<td>${backendUser.modifyBy}</td>
					<td>${backendUser.modifyDate}</td>
					<td>
						<a href="javascript:updateUser(${backendUser.id});">修改</a>
						<a href="javascript:delteUser(${backendUser.id});">删除</a>
					</td>
				</tr>
			</tbody>
		</c:forEach>
	</table>
	</div>
</body>
	<script>
		function updateUser(id){
			$("#content").load("<%=request.getContextPath()%>/backend_user/index/updBackend_user?id="+id);
		}
		function deleteUser(id){
			$("#content").load("<%=request.getContextPath()%>/backend_user/index/delBackend_user?id="+id);
		}
		function addBackend_user(){
    		$("#content").load("<%=request.getContextPath()%>/backend_user/index/addBackend_user")
    	}
	</script>
</html>