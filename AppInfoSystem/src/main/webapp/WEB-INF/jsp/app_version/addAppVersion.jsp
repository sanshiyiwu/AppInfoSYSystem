<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>App版本信息添加页面</title>
    <!-- Bootstrap core CSS -->
    <link href="<%=request.getContextPath() %>/statics/css/bootstrap.min.css" rel="stylesheet">
    <link href="<%=request.getContextPath() %>/statics/fonts/css/font-awesome.min.css" rel="stylesheet">
    <link href="<%=request.getContextPath() %>/statics/css/animate.min.css" rel="stylesheet">
    <!-- Custom styling plus plugins -->
    <link href="<%=request.getContextPath() %>/statics/css/custom.css" rel="stylesheet">
    <link href="<%=request.getContextPath() %>/statics/css/icheck/flat/green.css" rel="stylesheet">
    <script src="<%=request.getContextPath() %>/statics/js/jquery.min.js"></script>
</head>
<body class="nav-md">
	<div class="">
	    <div class="clearfix"></div>
	    <div class="row">
	        <div class="col-md-12 col-sm-12 col-xs-12">
	            <div class="x_panel"> 
	            	<div class="x_panel">
                        <div class="x_title">
                            <h2>历史版本列表</h2>
                            <ul class="nav navbar-right panel_toolbox">
                                <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                                </li>
                            </ul>
                            <div class="clearfix"></div>
                        </div>
                        <div class="x_content">

                            <table class="table table-bordered">
                                <thead>
                                    <tr>
                                        <th>软件名称</th>
                                        <th>版本号</th>
                                        <th>版本大小(单位:M)</th>
                                        <th>发布状态</th>
                                        <th>APK文件下载</th>
                                        <th>最新更新时间</th>
                                    </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${appVersionList }" var="appVersion">
                                    <tr>
                                        <th scope="row">${appInfo.softwareName }</th>
                                        <td>${appVersion.versionNo }</td>
                                        <td>${appVersion.versionSize }</td>
                                        <c:forEach items="${dataDictionaryList }" var="dataDictionary">
                                        <c:if test="${dataDictionary.id == appVersion.publishStatus }">
                                        <td>${dataDictionary.valueName }</td>
                                        </c:if>
                                        </c:forEach>
                                        <td>${appVersion.downloadLink }</td>
                                        <td>${appVersion.modifyDate }</td>
                                    </tr>
                                 </c:forEach>   
                                </tbody>
                            </table>

                        </div>
                    </div>
                    <form class="form-horizontal form-label-left" action="javascript:;" method="post" enctype="multipart/form-data" id="addForm">
                        <span class="section">App版本信息添加</span>
                        <div class="item form-group">
                            <label class="control-label col-md-3 col-sm-3 col-xs-12">版本号 <span class="required">*</span>
                            </label>
                            <div class="col-md-6 col-sm-6 col-xs-12">
                                <input type="text" id="versionNo" name="versionNo" placeholder="请输入版本号 " required="required" class="form-control col-md-7 col-xs-12">
                            </div>
                        </div>
                        <div class="item form-group">
                            <label class="control-label col-md-3 col-sm-3 col-xs-12">版本大小<span class="required">*</span>
                            </label>
                            <div class="col-md-6 col-sm-6 col-xs-12">
                                <input type="text" id="versionSize" name="versionSize" placeholder="请输版本大小 " required="required"  class="form-control col-md-7 col-xs-12">
                            </div>
                        </div>
                        <div class="item form-group">
                            <label class="control-label col-md-3 col-sm-3 col-xs-12">发布状态<span class="required">*</span>
                            </label>
                            <div class="col-md-6 col-sm-6 col-xs-12">
                                <input id="downloads" type="text" name="publishStatus" placeholder="发布状态 " class="optional form-control col-md-7 col-xs-12">
                            </div>
                        </div>
                        <div class="item form-group">
                            <label class="control-label col-md-3 col-sm-3 col-xs-12">版本简介 <span class="required">*</span>
                            </label>
                            <div class="col-md-6 col-sm-6 col-xs-12">
                                <!-- <textarea id="appInfo" name="appInfo" placeholder="请输入版本简介相关的信息 "  class="form-control col-md-7 col-xs-12"></textarea> -->
                                <input type="text" id="versionInfo" name="versionInfo" placeholder="请输入版本简介相关的信息 "  class="form-control col-md-7 col-xs-12"/>
                            </div>  
                        </div>
                        <div class="item form-group">
                            <label class="control-label col-md-3">apk文件 <span class="required">*</span>
                            </label>
                            <div class="col-md-6 col-sm-6 col-xs-12">
                                <input id="a_apkLocPath" type="file" name="attach" class="form-control col-md-7 col-xs-12">
                            </div>
                        </div>
                        <div class="ln_solid"></div>
                        <div class="form-group">
                            <div class="col-md-6 col-md-offset-3">
                                <button type="reset" class="btn btn-primary">取消</button>
                                <button id="send" type="submit" class="btn btn-success">提交</button>
                            </div>
                        </div>
                    </form>
	            </div>
	        </div>
	    </div>
	</div>
    <script src="<%=request.getContextPath() %>/statics/js/bootstrap.min.js"></script>
    <!-- chart js -->
    <script src="<%=request.getContextPath() %>/statics/js/chartjs/chart.min.js"></script>
    <!-- bootstrap progress js -->
    <script src="<%=request.getContextPath() %>/statics/js/progressbar/bootstrap-progressbar.min.js"></script>
    <script src="<%=request.getContextPath() %>/statics/js/nicescroll/jquery.nicescroll.min.js"></script>
    <!-- icheck -->
    <script src="<%=request.getContextPath() %>/statics/js/icheck/icheck.min.js"></script>

    <script src="<%=request.getContextPath() %>/statics/js/custom.js"></script>
    <!-- form validation -->
    <script src="<%=request.getContextPath() %>/statics/js/validator/validator.js"></script>
    <script type="text/javascript">
        // initialize the validator function
        validator.message['date'] = 'not a real date';

        // validate a field on "blur" event, a 'select' on 'change' event & a '.reuired' classed multifield on 'keyup':
        $('form')
            .on('blur', 'input[required], input.optional, select.required', validator.checkField)
            .on('change', 'select.required', validator.checkField)
            .on('keypress', 'input[required][pattern]', validator.keypress);

        $('.multi.required')
            .on('keyup blur', 'input', function () {
                validator.checkField.apply($(this).siblings().last()[0]);
            });

        // bind the validation to the form submit event
        //$('#send').click('submit');//.prop('disabled', true);

        $('form').submit(function () {
        	var data = new FormData(document.getElementById("addForm"));
        	$.ajax({
        		url:"<%=request.getContextPath() %>/dev_user/app_info/addAppInfoSave",
        		type:"POST",
        		data:data,
        		processData:false,
				contentType:false,
        		dataType:"html",
        		success:function(data){
        			$("body").html(data);
        		}
        	});
        });

        /* FOR DEMO ONLY */
        $('#vfields').change(function () {
            $('form').toggleClass('mode2');
        }).prop('checked', false);
        $('#alerts').change(function () {
            validator.defaults.alerts = (this.checked) ? false : true;
            if (this.checked)
                $('form .alert').remove();
        }).prop('checked', false);
        
    </script>
</body>

</html>