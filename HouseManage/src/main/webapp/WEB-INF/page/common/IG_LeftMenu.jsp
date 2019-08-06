<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@ include file="/WEB-INF/page/common/IG_Scheme.jsp" %>

<base href="<%=basePath%>"/>
<meta http-equiv="X-UA-Compatible" content="IE=10">
   <!--  <script src="IG_Public/lib/jquery-1.11.1.min.js" type="text/javascript"></script> -->
     <div class="sidebar-nav">
    <ul>
        <c:if test="${cspUser.type eq 0}">
        <li><a href="javascript:void(0)"  data-target=".chu-menu" class="nav-header collapsed" data-toggle="collapse" ><i  class="fa fa-fw fa-dashboard"></i>管理员<i class="fa fa-collapse"></i></a></li>
        <li><ul  class="chu-menu nav nav-list  "> 
            <li ><a href="web/manage/toUserinfo"><span class="fa fa-caret-right"></span>用户信息</a></li>  
               <li ><a href="web/manage/toMessage"><span class="fa fa-caret-right"></span>公告和新闻</a></li>            
                <li ><a href="web/manage/toNeedInfo"><span class="fa fa-caret-right"></span>需求信息</a></li> 
                   <li ><a href="web/manage/toIncomeInfo"><span class="fa fa-caret-right"></span>收益信息</a></li>  
                     <li ><a href="web/manage/toClassInfo"><span class="fa fa-caret-right"></span>家政服务类别</a></li>  
               <li ><a href="web/manage/toLevelInfo"><span class="fa fa-caret-right"></span>级别信息</a></li>   
         </ul> </li>
    </c:if>
    <c:if test="${cspUser.type eq 1}">
    <li><a href="javascript:void(0)" data-target=".dashboard-menu" class="nav-header" data-toggle="collapse"><i class="fa fa-fw fa-dashboard"></i>保姆<i class="fa fa-collapse"></i></a></li>
    <li><ul class="dashboard-menu nav nav-list ">
            <li ><a href="web/manage/toMessage"><span class="fa fa-caret-right"></span>公告和新闻</a></li>   
             <li ><a href="web/manage/toNeedInfo"><span class="fa fa-caret-right"></span>需求信息</a></li>    
              <li ><a href="web/manage/toIncomeInfo"><span class="fa fa-caret-right"></span>收益信息</a></li>                  
       <li > <a href="web/manage/toUserinfo"><span class="fa fa-caret-right"></span>个人信息</a></li>  
    </ul></li>
    </c:if>
 <c:if test="${cspUser.type eq 2}">
    <li><a href="javascript:void(0)" data-target=".dashboard-menu" class="nav-header" data-toggle="collapse"><i class="fa fa-fw fa-dashboard"></i>顾客<i class="fa fa-collapse"></i></a></li>
    <li><ul class="dashboard-menu nav nav-list ">
               <li ><a href="web/manage/toMessage"><span class="fa fa-caret-right"></span>公告和新闻</a></li>   
             <li ><a href="web/manage/toNeedInfo"><span class="fa fa-caret-right"></span>需求信息</a></li>    
       <li > <a href="web/manage/toUserinfo"><span class="fa fa-caret-right"></span>个人信息</a></li>  
    </ul></li>
    </c:if>
   </ul> 

  </div>
  
  
      <script type="text/javascript">
      
       
      $(function(){

    	  var list = $('.sidebar-nav').find('ul').find('li');
    	  for(var i = 0; i < list.length; i++) {
    		  if(window.location.pathname=="/"+$(list[i]).find("a").attr("href")){
    			  $(list[i]).addClass("active");
    			  if($(list[i]).parent("ul").length>0){
    				  $(list[i]).parent("ul").addClass("in");
    			  }
    		  }
            }
    	  
    	  
    	  
    	
      }) 
      
      
      


    </script>