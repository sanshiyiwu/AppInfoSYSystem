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
 	<link href="<%=request.getContextPath() %>/statics/localcss/bootstrap.min.css" rel="stylesheet">
    <link href="<%=request.getContextPath() %>/statics/localfonts/css/font-awesome.min.css" rel="stylesheet">
    <link href="<%=request.getContextPath() %>/statics/localcss/animate.min.css" rel="stylesheet">
    <link href="<%=request.getContextPath() %>/statics/localcss/custom.css" rel="stylesheet">
    <link href="<%=request.getContextPath() %>/statics/localcss/icheck/flat/green.css" rel="stylesheet">
    <script src="<%=request.getContextPath()%>/statics/localjs/jquery.min.js" type="text/javascript"></script>
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
                    <form action="">
                        <h1>注册界面</h1>
                        <div>
                            <input type="text" class="form-control" placeholder="用户名" required="" />
                            <input type="text" class="form-control" placeholder="用户真实姓名" required="" />
                            <input type="password" class="form-control" placeholder="密码" required="" />
                            <div class="input-out">
                           	 性别：<input type="radio"  name="gender" value="1" checked="checked"/>男
				  				  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio"  name="gender" value="2"/>女
				  			</div>
				  			<br>
				  			<input type="number" class="form-control" name="age" placeholder="年龄" required="" min="1" max="100"/><br/> 
                            <input type="email" class="form-control" placeholder="电子邮箱" required="" />
                            
                        </div>
                        <div>
                            <a class="btn btn-default submit" href="index.html">注册</a>
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
		$("body").load("<%=request.getContextPath()%>/")
	}
	$("#login>form").submit(function(){
		$.ajax({
			url:"<%=request.getContextPath() %>/backend/loginCheck",
			data:$("#login>form").serialize(),
			type:"POST",
			dataType:"html",
			success:function(data){
				$("body").html(data);
			}
		})
	})
	$("#regist>form").submit(function(){
		$.ajax({
			url:"<%=request.getContextPath() %>/backend/loginCheck",
			data:$("#regist>form").serialize(),
			type:"POST",
			dataType:"html",
			success:function(data){
				$("body").html(data);
			}
		})
	})
	</script>
</html>