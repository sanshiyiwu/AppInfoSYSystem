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
    <title>基础信息添加页面</title>
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
                    <form class="form-horizontal form-label-left" action="javascript:;" method="post" enctype="multipart/form-data" id="addForm">
                        <span class="section">基础信息添加</span>
                        <div class="item form-group">
                            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="name">软件名称 <span class="required">*</span>
                            </label>
                            <div class="col-md-6 col-sm-6 col-xs-12">
                                <input type="text" id="softwareName" name="softwareName" class="form-control col-md-7 col-xs-12"  placeholder="请输入软件名" required="required">
                            </div>
                        </div>
                        <div class="item form-group">
                            <label class="control-label col-md-3 col-sm-3 col-xs-12">APK名称 <span class="required">*</span>
                            </label>
                            <div class="col-md-6 col-sm-6 col-xs-12">
                                <input type="text" id="APKName" name="APKName" onblur="isExistAPKName()" placeholder="请输入APK名称" required="required" class="form-control col-md-7 col-xs-12">
                                <span style="color: red;"></span>
                            </div>
                        </div>
                        <div class="item form-group">
                            <label class="control-label col-md-3 col-sm-3 col-xs-12">支持ROM <span class="required">*</span>
                            </label>
                            <div class="col-md-6 col-sm-6 col-xs-12">
                                <input type="text" id="supportROM" name="supportROM" placeholder="请输入支持的ROM" required="required" class="form-control col-md-7 col-xs-12">
                            </div>
                        </div>
                        <div class="item form-group">
                            <label class="control-label col-md-3 col-sm-3 col-xs-12">界面语言 <span class="required">*</span>
                            </label>
                            <div class="col-md-6 col-sm-6 col-xs-12">
                                <input type="text" id="interfaceLanguage" name="interfaceLanguage" placeholder="请输入支持的界面语言 " required="required" class="form-control col-md-7 col-xs-12">
                            </div>
                        </div>
                        <div class="item form-group">
                            <label class="control-label col-md-3 col-sm-3 col-xs-12">软件大小<span class="required">*</span>
                            </label>
                            <div class="col-md-6 col-sm-6 col-xs-12">
                                <input type="text" id="softwareSize" name="softwareSize" placeholder="请输入软件大小 " required="required"  class="form-control col-md-7 col-xs-12">
                            </div>
                        </div>
                        <div class="item form-group">
                            <label class="control-label col-md-3 col-sm-3 col-xs-12">下载次数 <span class="required">*</span>
                            </label>
                            <div class="col-md-6 col-sm-6 col-xs-12">
                                <input id="downloads" type="number" name="downloads" placeholder="请输入下载次数  " class="optional form-control col-md-7 col-xs-12">
                            </div>
                        </div>
                        <div class="item form-group">
                            <label class="control-label col-md-3 col-sm-3 col-xs-12">所属平台 <span class="required">*</span>
                            </label>
                            <div class="col-md-6 col-sm-6 col-xs-12">
                                <select class="form-control" name="flatformId" id="flatformId">
                                	<c:forEach items="${dataDictionaryList_f }" var="dataDictionary">
                                    <option value="${dataDictionary.valueId }">${dataDictionary.valueName}</option> 
                                    </c:forEach>  
                                </select>
                            </div>
                        </div>
                       	
                        <div class="item form-group">
                            <label class="control-label col-md-3 col-sm-3 col-xs-12">一级分类<span class="required">*</span>
                            </label>
                            <div class="col-md-6 col-sm-6 col-xs-12">
                                <select class="form-control" name="categoryLevel1" id="categoryLevel1" onchange="getCategoryLevel1()">
                                	<c:forEach items="${appCategoryList }" var="appCategory">
                                	<c:if test="${appCategory.parentId == null}">
                                	<c:if test="${appInfo.categoryLevel1 == appCategory.id}">
                                	<option value="${appInfo.categoryLevel1 }" selected="selected">${appCategory.categoryName }</option>	
                                	</c:if>
                                	<c:if test="${appInfo.categoryLevel1 != appCategory.id}">
                                    <option value="${appCategory.id }">${appCategory.categoryName }</option>
                                    </c:if>
                                  	</c:if> 
                                   	</c:forEach> 
                                </select>
                            </div>
                        </div>
                        <div class="item form-group">
                            <label class="control-label col-md-3 col-sm-3 col-xs-12">二级分类<span class="required">*</span>
                            </label>
                            <div class="col-md-6 col-sm-6 col-xs-12">
                                <select class="form-control" name="appInfo" id="categoryLevel2" onchange="getCategoryLevel2()">
                                	<c:forEach items="${appCategoryList }">
                                	<c:if test="${appInfo.categoryLevel2 == appCategory.id}">
                                    <option value="${appInfo.categoryLevel2 }" selected="selected">${appCategory.categoryName }</option>
                                    </c:if> 
                                    </c:forEach>  
                                </select>
                            </div>
                        </div>
                        <div class="item form-group">
                            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="occupation">三级分类<span class="required">*</span>
                            </label>
                            <div class="col-md-6 col-sm-6 col-xs-12">
                                <select class="form-control" name="categoryLevel3" id="categoryLevel3">
                                    <c:forEach items="${appCategoryList }">
                                	<c:if test="${appInfo.categoryLevel3 == appCategory.id}">
                                    <option value="${appInfo.categoryLevel3 }" selected="selected">${appCategory.categoryName }</option>
                                    </c:if> 
                                    </c:forEach>    
                                </select>
                            </div>
                        </div> 
                        <div class="item form-group">
                            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="occupation">APP状态<span class="required">*</span>
                            </label>
                            <div class="col-md-6 col-sm-6 col-xs-12">
                            	<c:forEach items="${dataDictionaryList_s }" var="dataDictionary">
                            	<c:if test="${dataDictionary.valueId==1 }">
                            	<span>${dataDictionary.valueName }</span>
                                <input id="status" type="hidden" name="status" value="${appInfo.status }" class="form-control col-md-7 col-xs-12" required="required">
                                </c:if>
                                </c:forEach>
                            </div>
                        </div>
                        <div class="item form-group">
                            <label class="control-label col-md-3 col-sm-3 col-xs-12">应用简介 <span class="required">*</span>
                            </label>
                            <div class="col-md-6 col-sm-6 col-xs-12">
                                <!-- <textarea id="appInfo" name="appInfo" placeholder="请输入与本软件相关的信息 "  class="form-control col-md-7 col-xs-12"></textarea> -->
                                <input type="text" id="appInfo" name="appInfo" placeholder="请输入与本软件相关的信息 "  class="form-control col-md-7 col-xs-12"/>
                            </div>
                            
                            
                        </div>
                        <div class="item form-group">
                            <label for="password" class="control-label col-md-3">LOGO图片 <span class="required">*</span>
                            </label>
                            <div class="col-md-6 col-sm-6 col-xs-12">
                                <input id="a_logoLocPath" type="file" name="attach" class="form-control col-md-7 col-xs-12">
                            </div>
                            <img alt="logo" src="<%=request.getContextPath() %>/statics/uploadfiles/${appInfo.logoLocPath}">
                        </div>
                        <div class="ln_solid"></div>
                        <div class="form-group">
                            <div class="col-md-6 col-md-offset-3" id="">
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
        		url:"<%=request.getContextPath() %>/dev_user/app_info/updeteAppInfoSave",
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
        
        function getCategoryLevel1(){
        	var id = $("#categoryLevel1").find('option:selected').val();
        	$("#categoryLevel2").empty();
        	var classNext=$("#categoryLevel2");
        	$.ajax({
        		url:"<%=request.getContextPath() %>/dev_user/app_info/getCategoryLevel1?id="+id,
        		type: "post",  
                contentType:"application/json",  
        		success: function(data){
        			var data = eval('(' + data + ')');
        			if(data.length!="" && data.length!=null){
        				for ( var i = 0; i < data.length; i++) {
                 			classNext.append("<option value="+data[i].id+">"+data[i].categoryName+"</option>");
                 	      }
        			}else{
                		classNext.append("<option>---无---</option>");
            	    }
        	     }
        	});
        }    
        function getCategoryLevel2(){
        	var id = $("#categoryLevel2").find('option:selected').val();
        	$("#categoryLevel3").empty();
        	var classNext=$("#categoryLevel3");
        	$.ajax({
        		url:"<%=request.getContextPath() %>/dev_user/app_info/getCategoryLevel2?id="+id,
        		type: "post",  
                contentType:"application/json",  
        		success: function(data){
        			var data = eval('(' + data + ')');
        			if(data.length!="" && data.length!=null){
        				for ( var i = 0; i < data.length; i++) {
                 			classNext.append("<option value="+data[i].id+">"+data[i].categoryName+"</option>");
                 	      }
        			}else{
                		classNext.append("<option value="+id+">---无---</option>");
            	    }
        	     }
        	});
        }  	
      function isExistAPKName(){
    	  var APKName = $("#APKName").val();
    	  $.ajax({
    		  url:"<%=request.getContextPath() %>/dev_user/app_info/isExistAPKName",
    		  data:{"APKName":APKName},
    		  type:"post",
    		  dataType:"json",
    		  success:function(data){
    			  if(data=="1"){
    				  $("#APKName").next().html("已存在!");
    				  return true;
    			  }else{
    				  $("#APKName").next().html("可以使用!");
    				  return false;
    			  }
    		  }
    	  });
      }
      $(document).ready(function(){
    	  var status = $("#status").val();
    	  if(status != "1"){
    		  $("#button").append("<button id='send' type='submit' class='btn btn-success'>提交审核</button>");
    	  }
      });
    	             
               
        
    </script>
</body>

</html>