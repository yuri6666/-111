<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/page/common/IG_Scheme.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en"><head>
    <meta charset="utf-8">
    <base href="<%=basePath%>">
    <title>登录页面</title>
    <meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <link href='IG_Public/stylesheets/base.css' rel='stylesheet' type='text/css'>
    <link rel="stylesheet" type="text/css" href="IG_Public/lib/bootstrap/css/bootstrap.css">
    <link rel="stylesheet" href="IG_Public/lib/font-awesome/css/font-awesome.css">
    <script src="IG_Public/lib/jquery-1.11.1.min.js" type="text/javascript"></script>
      <script src="IG_Public/lib/bootstrap/js/bootstrapValidator.min.js" type="text/javascript"></script>  
        <script src="IG_Public/lib/laydate/laydate.js" type="text/javascript"></script>
   <script type="text/javascript" src="IG_Public/lib/layer/layer.js"></script>
    <script src="IG_Public/script/IG_Login.js" type="text/javascript"></script>
    <link rel="stylesheet" type="text/css" href="IG_Public/stylesheets/theme.css">
    <link rel="stylesheet" type="text/css" href="IG_Public/stylesheets/premium.css">
  <link href='IG_Public/lib/bootstrap/css/bootstrapValidator.css' rel='stylesheet' type='text/css'>
</head>
<body class="theme-blue"  style="background:url(IG_Public/images/media/1.jpg);background-repeat: no-repeat;background-size: 100% 100%;background-attachment: fixed;">

    <jsp:include page="/WEB-INF/page/common/IG_Header.jsp"></jsp:include>
    
   <div class="navbar navbar-default" role="navigation">
        <div class="navbar-header">
          <a class="" href="index.html"><span class="navbar-brand"><span class="fa fa-paper-plane"></span>家政服务管理系统</span></a></div>

        <div class="navbar-collapse collapse" style="height: 1px;">

        </div>
      </div>

   <div class="dialog">
    <div class="panel panel-default">
        <p class="panel-heading no-collapse">用戶登录</p>
        <div class="panel-body">
            <form id="loginform">
                <div class="form-group">
                    <label>账号</label>
                    <input type="text" class="form-control span12" name="username">
                </div>
                <div class="form-group">
                <label>密码</label>
                    <input type="password" class="form-controlspan12 form-control" name="password">
                </div>
                  <select class="form-control" name="type"  id="userType">
                     <option value="1" >保姆</option>
                      <option value="2" selected = "selected">顾客</option>
                     <option value="0" >管理员</option>  
                    </select>
                <span style="color:red" id="hip"></span>
                <a href="javascript:void(0)" class="btn btn-primary pull-right" onclick="login()">登  录</a>
                 <label class="remember-me"><a href="web/visitor/toRegister">没有账号?去注册</a></label>
                  <label class="remember-me"><a href="javascript:void(0)" onclick="retrieve()">找回密码</a></label>
                <div class="clearfix"></div>
            </form>
        </div>
    </div>
</div>
 
<div style="display:none;text-align:center;padding-top:100px;" id="content" >
            <div style="margin-right:30px;">
             <label class="remember-me">用户名：</label>
			<input type="text" name="userName" id="userName" 
			 placeholder="请输入您的用户名"
				>
           </div>
           <div style="padding-top:40px;margin-right:30px;">
           <label class="remember-me">邮箱地址：</label>
			<input type="email" name="email" id="email" 
			 placeholder="请输入您的邮箱地址"
				>	</div>
		 <div style="margin-left:50px;">
	
	</div>
         </div>


</body></html>
