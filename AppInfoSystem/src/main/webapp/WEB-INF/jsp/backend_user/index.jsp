<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="common/header.jsp" %>
<div class="page-title">
	<div class="title_left">
		<h3>
			欢迎你：${presentCust.userName }<strong> | 角色：
			<c:if test="${presentCust.userType==1}">
			管理员用户
			</c:if>
			<c:if test="${presentCust.userType==2}">
			普通用户
			</c:if>
			</strong>
		</h3>
	</div>
</div>
<br>
<div class="clearfix" id="content"></div>        
<%@include file="common/footer.jsp" %>  
     