<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/WEB-INF/page/common/IG_Scheme.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en"><head>
    <meta charset="utf-8">
    <title>注册页面</title>
    <base href="<%=basePath%>">
    <meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
     <script src="IG_Public/lib/jquery-1.11.1.min.js" type="text/javascript"></script>
    <link href='IG_Public/stylesheets/base.css' rel='stylesheet' type='text/css'>
    <link rel="stylesheet" type="text/css" href="IG_Public/lib/bootstrap/css/bootstrap.css">
    <link rel="stylesheet" href="IG_Public/lib/font-awesome/css/font-awesome.css">
   <script src="IG_Public/lib/laydate/laydate.js" type="text/javascript"></script>
   <script type="text/javascript" src="IG_Public/lib/layer/layer.js"></script>
  <script src="IG_Public/script/IG_Register.js" type="text/javascript"></script>
    <link rel="stylesheet" type="text/css" href="IG_Public/stylesheets/theme.css">
    <link rel="stylesheet" type="text/css" href="IG_Public/stylesheets/premium.css">
</head>
<body class=" theme-blue" style="background:url(IG_Public/images/media/1.jpg);background-repeat: no-repeat;background-size: 100% 100%;background-attachment: fixed;">

   <jsp:include page="/WEB-INF/page/common/IG_Header.jsp"></jsp:include>
    
   <div class="navbar navbar-default" role="navigation">
        <div class="navbar-header">
          <a class="" href="index.html"><span class="navbar-brand"><span class="fa fa-paper-plane"></span>家政服务管理系统</span></a></div>

        <div class="navbar-collapse collapse" style="height: 1px;">

        </div>
      </div>
    </div>

        <div class="dialog">
    <div class="panel panel-default">
        <p class="panel-heading no-collapse">注册</p>
        <div class="panel-body">
            <form  name="form1"  method="post" id="reigsterForm">
                <div class="form-group">
                    <label>账号</label>
                    <input type="text" class="form-control span12" id="username" name="username">
                </div>
                <div class="form-group">
                    <label>密码</label>
                    <input type="text" class="form-control span12" id="password"  name="password">
                </div>
                <div class="form-group">
                    <label>用户</label>
                    <select class="form-control" name="type"  id="userType">
                      <option value="1" >保姆</option>
                      <option value="2" selected = "selected">顾客</option>
                      <option value="0" >管理员</option>  
                 
                    </select>
                </div>
                <div class="form-group">
                    <label>真实姓名</label>
                    <input type="text" class="form-control span12" id="realname" name="realname">
                </div>
                 <div class="form-group">
                    <label>邮箱</label>
                    <input type="email" class="form-control span12" id="email" name="email">
                </div>
                <div class="form-group">
                <span style="color:red" id="hip"></span>
                    <a href="javaScript:void(0)" onclick="reigster();" class="btn btn-primary pull-right">提交</a>
                    <label class="remember-me"><a href="web/visitor/toLogin">已有账号!去登录</a></label>
                </div>
                    <div class="clearfix"></div>
            </form>
        </div>
    </div>
  <p><a href="javascript:void(0)" style="font-size: .75em; margin-top: .25em;"><span style="color:red;margin-left:12px;">${requestScope.errorMsg}</span></a></p> 
</div>




    
  
</body></html>
