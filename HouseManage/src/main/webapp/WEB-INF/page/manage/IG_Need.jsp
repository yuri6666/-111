<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/WEB-INF/page/common/IG_Scheme.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en"><head>
<base href="<%=basePath%>">
    <meta charset="utf-8">
    <title>需求信息</title>
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
     <script type="text/javascript" src="IG_Public/script/IG_Need.js"></script>
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
            
            <h1 class="page-title">需求信息</h1>
                    <ul class="breadcrumb">
            <li><a href="javascript:void(0)">主页</a> </li>
            <li class="active">需求信息</li>
        </ul>

        </div>
        		
      <div class="btn-toolbar list-toolbar">
     
      <div class="row">
								<div class="col-lg-4">
									<div class="input-group">
										
										<span class="input-group-btn">
											<button class="btn btn-default" type="button">需求</button>
										</span> <input type="text" class="form-control" placeholder="请输入需求"	id="name">
									
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
            <Modal v-model="detailModel"   scrollable="true" title="需求信息" @on-ok="save" >
                      <i-form v-model="detailform" label-position="center" :label-width="100">     
              <Form-item label="家政服务类别:">
					        <select id="modalclassId"   v-model="classId" :value="classId"  style="width:380px;border:1px solid #dddee1;padding:5px;border-radius:4px;font-size:14px;" >
						  <Option v-for="item in  classList" :value="item.id" :key="item.id">
						{{item.name }}</Option>
					      </select>
					   
                                     </Form-item>   
                                        <Form-item label="级别:">
					        <select id="modallevelId"   v-model="levelId" :value="levelId"  style="width:380px;border:1px solid #dddee1;padding:5px;border-radius:4px;font-size:14px;" >
						  <Option v-for="item in  levelList" :value="item.id" :key="item.id">
						{{item.name }}</Option>
					      </select>
					   
                                     </Form-item>
                                    
               <Form-item label="经验:">
					        <select id="modallevelId"   v-model="expericeId" :value="expericeId"  style="width:380px;border:1px solid #dddee1;padding:5px;border-radius:4px;font-size:14px;" >
						  <Option v-for="item in  expericeList" :value="item.id" :key="item.id">
						{{item.name }}</Option>
					      </select>
					   
                                     </Form-item>
                                       <Form-item label="学历:">
					        <select id="modallevelId"   v-model="educationId" :value="educationId"  style="width:380px;border:1px solid #dddee1;padding:5px;border-radius:4px;font-size:14px;" >
						  <Option v-for="item in  educationList" :value="item.id" :key="item.id">
						{{item.name }}</Option>
					      </select>
					   
                                     </Form-item>
                                       <Form-item label="能力:">
					        <select id="modallevelId"   v-model="abilityId" :value="abilityId"  style="width:380px;border:1px solid #dddee1;padding:5px;border-radius:4px;font-size:14px;" >
						  <Option v-for="item in  abilityList" :value="item.id" :key="item.id">
						{{item.name }}</Option>
					      </select>
					   
                                     </Form-item>
                                       <Form-item label="年龄:">
					        <select id="modallevelId"   v-model="ageId" :value="ageId"  style="width:380px;border:1px solid #dddee1;padding:5px;border-radius:4px;font-size:14px;" >
						  <Option v-for="item in  ageList" :value="item.id" :key="item.id">
						{{item.name }}</Option>
					      </select>
					   
                                     </Form-item>
                                     <Form-item label="薪酬:">
					        <select id="modalpriceId"   v-model="priceId" :value="priceId"  style="width:380px;border:1px solid #dddee1;padding:5px;border-radius:4px;font-size:14px;" >
						  <Option v-for="item in  priceList" :value="item.id" :key="item.id">
						{{item.name }}</Option>
					      </select>
					   
                                     </Form-item>
                                  
                                      <Form-item label="省份:">
                   <Select v-model="provinceCode" placeholder="请选择省份" @change="changeProvince"  style="width:380px;border:1px solid #dddee1;padding:5px;border-radius:4px;font-size:14px;">
                   <Option v-for="(item,index) in provinceList" :key="item.provinceCode" :value="item.provinceCode" >{{ item.name }}</Option>
                  </Select>
               </Form-item>
                 <Form-item  label="城市:">
               <Select v-model="cityCode" placeholder="请选择城市" @change="changeCity"  style="width:380px;border:1px solid #dddee1;padding:5px;border-radius:4px;font-size:14px;">
              <Option v-for="(item,index) in citiesList" :key="item.cityCode" :value="item.cityCode" >{{ item.name }}</Option>
               </Select>
             </Form-item>
              <Form-item  label="区县:">
            <Select v-model="areaCode" placeholder="请选择区县"  style="width:380px;border:1px solid #dddee1;padding:5px;border-radius:4px;font-size:14px;">
              <Option v-for="(item,index) in countyList" :key="item.areaCode" :value="item.areaCode" >{{ item.name }}</Option>
            </Select>
             </Form-item>
   
  
                                      </i-form>
                           <div slot="footer">
                            <button class="esayui-linkbutton" style="margin-left:40px"onclick="saveinfo()">保存</button>
		</div>
                                     </Modal>
      
                    <Modal v-model="commentModel" width="1000" height="1000" draggable scrollable title="评价信息" @on-ok="saveComentInfo" >
                                      <i-form v-model="commentform" label-position="center" :label-width="100">  
                                     
                               <textarea id="comment" rows="30" cols="150"> </textarea>
                                 
                           </i-form>
                           <div slot="footer">
                            <button class="esayui-linkbutton" style="margin-left:40px"onclick="saveComment()">保存</button>
		</div>
                 </Modal>
                  <Modal v-model="detailCommentModel"  draggable scrollable title="评价信息"  >
                                     
                               <div id="detailComment" ></div>
                 </Modal>
                   <Modal v-model="detailcutomermodel"  draggable scrollable title="顾客信息"  >
                                                                                          手机号: <div id="customerphone" ></div>   
                                                                                          照片: <img id="customerphotourl" >
                 </Modal>
                  <Modal v-model="detailnursemodel"  draggable scrollable title="保姆信息"  >
                                                                                手机号:<div id="nursephone" ></div>       
                                                                                照片: <img id="nursephotourl" >
                 </Modal>
              
        </div>
    </div>
          <div style="display:none;text-align:center;padding-top:100px;" id="paycontent" >
            <div style="margin-right:30px;">
             <label class="remember-me">支付金额：</label>
			<input type="number" name="paymoney" id="paymoney" 
			 placeholder="请输入支付金额"
				>
           </div>
		 <div style="margin-left:50px;">
	
	</div>
         </div>
           <div style="display:none;text-align:center;padding-top:100px;" id="Server" >
            <div style="margin-right:30px;">
             <label class="remember-me">是否同意对方为您服务：</label>
			  <select id="checkServer">
		  <option value="1" selected="selected">同意</option>
		     <option value="0">拒绝</option>
		  
	         </select>
           </div>
		 <div style="margin-left:50px;">
	
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


