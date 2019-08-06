<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/WEB-INF/page/common/IG_Scheme.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en"><head>
<base href="<%=basePath%>">
    <meta charset="utf-8">
    <title>收益信息</title>
    <meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <link href='IG_Public/stylesheets/base.css' rel='stylesheet' type='text/css'>
    <link rel="stylesheet" type="text/css" href="IG_Public/lib/bootstrap/css/bootstrap.css">
    <link rel="stylesheet" href="IG_Public/lib/font-awesome/css/font-awesome.css">
     <script src="IG_Public/lib/iview/vue.min.js" type="text/javascript"></script>
    <link rel="stylesheet" href="IG_Public/lib/iview/iview.css">
    <script src="IG_Public/lib/iview/iview.min.js" type="text/javascript"></script>
    <script src="IG_Public/lib/jquery-1.11.1.min.js" type="text/javascript"></script>
     <script type="text/javascript" src="IG_Public/script/IG_Income.js"></script>
      <script type="text/javascript" src="IG_Public/lib/layer/layer.js"></script>
      <script type="text/javascript" src="IG_Public/lib/laydate/laydate.js"></script>
    <script src="IG_Public/lib/jQuery-Knob/js/jquery.knob.js" type="text/javascript"></script>
    <script type="text/javascript">
        $(function() {
            $(".knob").knob();
        });
    </script>


    <link rel="stylesheet" type="text/css" href="IG_Public/stylesheets/theme.css">
    <link rel="stylesheet" type="text/css" href="IG_Public/stylesheets/premium.css">

</head>
<body class=" theme-blue">

    <jsp:include page="/WEB-INF/page/common/IG_ManageHeader.jsp"></jsp:include>
    
    <jsp:include page="/WEB-INF/page/common/IG_LeftMenu.jsp"></jsp:include>


    <div class="content">
             <div class="header">
            
            <h1 class="page-title">收益信息</h1>
                    <ul class="breadcrumb">
            <li><a href="javascript:void(0)">主页</a> </li>
            <li class="active">收益信息</li>
        </ul>

        </div>
        		
      <div class="btn-toolbar list-toolbar">
     
      <div class="row">
								<div class="col-lg-4">
									<div class="input-group">
										
										<span class="input-group-btn">
											<button class="btn btn-default" type="button">收益</button>
										</span> <input type="text" class="form-control" placeholder="请输入收益"	id="name">
									
									</div>
								</div>
								 
								<div class="col-lg-4">
								 <button class="btn btn-primary" onclick="search()"><i class="fa fa-search"></i>查询</button>
								</div>
							</div>	
			<div>				
	       <input type="radio" name="time" value="1">年 
	     <input type="radio" name="time" value="2">季节
	     <input type="radio" name="time" value="3">月
	     <input type="radio" name="time" value="4">日
	     </div>
		<button style="margin-left:20px"  class="esayui-linkbutton" onclick="excel()"><i class="fa fa-plus"></i>导出</button>   
      </div>  	
        <div class="contant" id="vueBox" v-cloak>
				<div class="tbDiv">
		
				  <i-table border stripe :columns="columns1" :data="data1"></i-table>
                  <Page :total="total" :current="param.page" :page-size="param.rows" @on-change="changePageNum" show-total show-elevator></Page>
                 </div>          
              
        </div>
    </div>
 

  <jsp:include page="/WEB-INF/page/common/IG_Footer.jsp"></jsp:include>
    
  
</body></html>

<style>
.file-list{
list-style: none;
}
  [v-cloak] {

    display: none;

  }
</style>


