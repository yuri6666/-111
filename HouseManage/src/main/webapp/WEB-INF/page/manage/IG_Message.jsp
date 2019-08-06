<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/WEB-INF/page/common/IG_Scheme.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en"><head>
<base href="<%=basePath%>">
    <meta charset="utf-8">
    <title>公告和新闻</title>
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
     <script type="text/javascript" src="IG_Public/script/IG_Message.js"></script>
      <script type="text/javascript" src="IG_Public/lib/layer/layer.js"></script>
      <script type="text/javascript" src="IG_Public/lib/laydate/laydate.js"></script>
      <script type="text/javascript" src="wangEditor/wangEditor-3.1.1.min.js"></script>
   <script type="text/javascript" src="wangEditor/wangeditor-create.js"></script>
   <script type="text/javascript" src="wangEditor/wangEditor-filterword.js"></script>
   <script type="text/javascript" src="wangEditor/wangEditor-fullscreen-plugin.js"></script>
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
            
            <h1 class="page-title">公告和新闻</h1>
                    <ul class="breadcrumb">
            <li><a href="javascript:void(0)">主页</a> </li>
            <li class="active">公告和新闻</li>
        </ul>

        </div>
        		
      <div class="btn-toolbar list-toolbar">
     
      <div class="row">
								<div class="col-lg-4">
									<div class="input-group">
										
										<span class="input-group-btn">
											<button class="btn btn-default" type="button">标题</button>
										</span> <input type="text" class="form-control" placeholder="请输入标题"	id="title">
									
									</div>
								</div>
								 
								<div class="col-lg-4">
								 <button class="btn btn-primary" onclick="search()"><i class="fa fa-search"></i>查询</button>
								</div>
							</div>	
		<c:if test="${cspUser.type ne 1}"> 	
		<button style="margin-left:20px"  class="esayui-linkbutton" onclick="add()"><i class="fa fa-plus"></i>新增</button>   
		</c:if>   
          <input style="display:none"  id="userType" value=${cspUser.type}>
        <input style="display:none"  id="userId" value=${cspUser.id}>
      </div>  	
        <div class="contant" id="vueBox" v-cloak>
				<div class="tbDiv">
		
				  <i-table border stripe :columns="columns1" :data="data1"></i-table>
                  <Page :total="total" :current="param.page" :page-size="param.rows" @on-change="changePageNum" show-total show-elevator></Page>
                 </div>
                 
           <Modal v-model="detailModel" width="1400"  scrollable="true"   title="公告和新闻" @on-ok="save" >
                                   <i-form v-model="detailform"  label-position="right" :label-width="100">                                                               
                                       <Form-item label="标题:">
                                         <i-input v-model="title"  id="title" placeholder="请输入标题" style="width:100%;border:1px solid #dddee1;">
                                          </Form-item>                            
                                           <Form-item label="内容:">
                                     <div  style="width:100%;" id="content" name="content" required=true ></div><div style="text-align:right"><span>字数统计:</span><span id="length"></span>/<span id="maxLength"></span></div>
                                          </Form-item>
                         
                           </i-form>
                           <div slot="footer">
                              <a  style="width:50px;height:50px;display:block;margin-left:50%;border:1px solid #eee;border-radius:10px;text-align:center;vertical-align:top;line-height:4;background-color:#c5c8ce" onclick="saveinfo()">保存</a>
	
		</div>
                 </Modal>       
                  <Modal v-model="contentModel" width="1400"  scrollable="true" title="详情"  >
                              <div id="contentdetail" style="margin-bottom:50px;" ></div>         
                               <div slot="footer">
                              <a  style="width:50px;height:50px;display:block;margin-left:50%;border:1px solid #eee;border-radius:10px;text-align:center;vertical-align:top;line-height:4;background-color:#c5c8ce" onclick="closeModel()">关闭</a>
		
		                        </div>
                 </Modal>
              
        </div>
    </div>
 

  <jsp:include page="/WEB-INF/page/common/IG_Footer.jsp"></jsp:include>
    
  <div id="previewContent" ></div>

</body></html>

<style>
.file-list{
list-style: none;
}
  [v-cloak] {

    display: none;

  }
</style>


