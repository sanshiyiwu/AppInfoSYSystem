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
 	<link href="<%=request.getContextPath() %>/statics/css/bootstrap.min.css" rel="stylesheet">
    <link href="<%=request.getContextPath() %>/statics/fonts/css/font-awesome.min.css" rel="stylesheet">
    <link href="<%=request.getContextPath() %>/statics/css/animate.min.css" rel="stylesheet">
    <link href="<%=request.getContextPath() %>/statics/css/custom.css" rel="stylesheet">
    <link href="<%=request.getContextPath() %>/statics/css/icheck/flat/green.css" rel="stylesheet">
    <script src="<%=request.getContextPath()%>/statics/js/jquery.min.js" type="text/javascript"></script>
<title>APP后台管理系统界面</title>
</head>
<body style="background:#F7F7F7;">
	<div class="">
        <a class="hiddenanchor" id="toregister"></a>
        <a class="hiddenanchor" id="tologin"></a>

        <div id="wrapper">
            <div id="login" class="animate form">
                <section class="login_content" id="login">
                    <form action="javascript:;">
                        <h1>APP后台管理系统</h1>
                        <div>
                            <input type="text" class="form-control" placeholder="用户名" required="" name="name"/>
                            <input type="password" class="form-control" placeholder="密码" required="" name="password"/>
                            <input type="submit" class="btn btn-default submit" value="登录">
                            <input type="reset" class="btn btn-default submit" value="重填">
                            <input type="button" class="btn btn-default submit" value="返回上一级" onclick="javascript:back();">
                            <a class="reset_pass" href="#">忘记密码</a>
                        </div>
                        <div class="clearfix"></div>
                        <div class="separator">
                            <p class="change_link">还不是APP后台管理系统的用户？
                                <a href="#toregister" class="to_register">注册</a>
                            </p>
                            <div class="clearfix"></div>
                            <br />
                        </div>
                    </form>
                    <!-- form -->
                </section>
                <!-- content -->
            </div>
            <div id="register" class="animate form">
                <section class="login_content" id="regist">
                    <form action="javascript:;" id="backRegistForm">
                        <h1>后台管理系统注册</h1>
                        <div>
                        	<input type="hidden" value="" name="id">
                            <input type="text" class="form-control" name="userCode" id="userCode" placeholder="请输入用户名" required=""/><span style="color:red;" id="error"></span><br>
                            <input type="text" class="form-control" name="userName" placeholder="请输入用户真实姓名" required="" /><br>
                            <input type="password" class="form-control" name="userPassword" placeholder="请输入密码" required="" /><br>
                            <input type="submit" class="btn btn-default submit" value="注册" id="registButton" disabled="disabled">
                            <input type="reset" class="btn btn-default submit" value="重填">
                        </div>
                        <div class="clearfix"></div>
                        <div class="separator">
                            <p class="change_link">已经是APP后台管理系统的用户 ?
                                <a href="#tologin" class="to_register">登录</a>
                            </p>
                            <div class="clearfix"></div>
                            <br />
                        </div>
                    </form>
                    <!-- form -->
                </section>
                <!-- content -->
            </div>
        </div>
    </div>
</body>
	<script>
	function back(){
		$("body").load("<%=request.getContextPath()%>/");
	}
	$("#login>form").submit(function(){
		$.ajax({
			url:"<%=request.getContextPath() %>/backend_user/backLoginCheck",
			data:$("#login>form").serialize(),
			type:"POST",
			dataType:"html",
			success:function(data){
				$("body").html(data);
			}
		});
	});
	$("#userCode").blur(checkBackUserCode);
	function checkBackUserCode(){
		var userCode=$("#userCode").val();
		$.ajax({
			url:"<%=request.getContextPath() %>/backend_user/backRegistCheck",
			data:{"userCode":userCode},
			type:"get",
			dataType:"json",
			success:function(data){
				if(data.userCode=="exist"){
					$("#userCode").next().html("用户已存在！");
					$("#registButton").attr("disabled","disabled");
					return true;
				}else{
					$("#userCode").next().html("用户名可使用！");
					$("#registButton").removeAttr("disabled");
					return false;
				}
			}
		});
	};
	$("#regist>form").submit(function(){
		var data=new FormData(document.getElementById("backRegistForm"));
		$.ajax({
			url:"<%=request.getContextPath()%>/backend_user/backRegistSave",
			data:data,
			type:"POST",
			dataType:"html",
			processData:false,
			contentType:false,
			success:function(data){
				$("body").html(data);
			}
		});
	});
	$("")
	</script>
</html>