<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/WEB-INF/page/common/IG_Scheme.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en"><head>
<base href="<%=basePath%>">
    <meta charset="utf-8">
    <title>用户信息</title>
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
     <script type="text/javascript" src="IG_Public/script/IG_Userinfo.js"></script>
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
            
            <h1 class="page-title">用户信息</h1>
                    <ul class="breadcrumb">
            <li><a href="javascript:void(0)">主页</a> </li>
            <li class="active">用户信息</li>
        </ul>

        </div>
        		
      <div class="btn-toolbar list-toolbar">
       <c:if test="${cspUser.type eq 0}">
      <div class="row">
								<div class="col-lg-4">
									<div class="input-group">
										
										<span class="input-group-btn">
											<button class="btn btn-default" type="button">服务类别</button>
										</span> <select id="className" class="form-control">
										<option value=""></option>
										</select>
									
									</div>
									<div class="input-group">
										
										<span class="input-group-btn">
											<button class="btn btn-default" type="button">级别</button>
										</span> <select id="levelName" class="form-control">
										<option value=""></option>
										</select>
									
									</div>
									<div class="input-group">
										
										<span class="input-group-btn">
											<button class="btn btn-default" type="button">身份</button>
										</span> <select id="type" class="form-control">
										<option value=""></option>
										<option value="1">保姆</option>
										<option value="2">顾客</option>
										</select>
									
									</div>
								</div>
								 
								<div class="col-lg-4">
								 <button class="btn btn-primary" onclick="search()"><i class="fa fa-search"></i>查询</button>
								</div>
							</div>
							
		
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
              
                 
           <Modal v-model="detailModel" draggable scrollable title="用户信息" @on-ok="save" >
                          
                                   <i-form v-model="detailform" label-position="left" :label-width="100">                        
                                        <c:if test="${cspUser.type eq 0}">
                                      <Form-item label="账号">
                                         <i-input v-model="detailform.username"  data-options="required:true" id="username" placeholder="请输入手机号或者邮箱" style="width:380px;border:1px solid #dddee1;">
                                      </Form-item>
                                         </c:if>
                                         <c:if test="${cspUser.type ne 0}">
                                            <Form-item label="账号">
                                         <i-input v-model="detailform.username" readonly=true data-options="required:true" id="username" placeholder="请输入手机号或者邮箱" style="width:380px;border:1px solid #dddee1;">
                                      </Form-item>
                                       </c:if>
                                       <Form-item label="密码">
                                         <i-input v-model="detailform.password"  id="password" placeholder="请输入密码" style="width:380px;border:1px solid #dddee1;">
                                          </Form-item>
                             
                                     <c:if test="${cspUser.type eq 0}">
                                      <Form-item label="真实姓名">
                                             <i-input v-model="detailform.realname" id="realname" style="width:380px;border:1px solid #dddee1;" placeholder="请输入真实姓名"></input>
                                     </Form-item> 
                                                                  
                                      </c:if>
                                        <c:if test="${cspUser.type ne 0}">
                                         <Form-item label="真实姓名">
                                             <i-input v-model="detailform.realname" readonly=true id="realname" style="width:380px;border:1px solid #dddee1;" placeholder="请输入真实姓名"></input>
                                     </Form-item> 
                                                                                               
                                      </c:if>
                                     
                                       <Form-item label="身份">
                                             <select id="usertype"   style="width:380px;border:1px solid #dddee1;padding:5px;border-radius:4px;font-size:14px;">
                                              <option value=""></option>
                                             <option value="1">保姆</option>
                                             <option value="2">顾客</option>
                                              <option value="0">管理员<option>
					      </select>
                                     </Form-item>    
             
                        
                                       <Form-item label="邮箱">
                                         <i-input v-model="detailform.email"  data-options="required:true" id="email" placeholder="请输入手机号或者邮箱" style="width:380px;border:1px solid #dddee1;">
                                      </Form-item>
                                      
                           </i-form>
                           <div slot="footer">
                            <button class="esayui-linkbutton" style="margin-left:40px"onclick="saveinfo()">保存</button>
		</div>
                 </Modal>
                    <Modal v-model="finishModel"   scrollable="true" title="完善信息" @on-ok="savefinish" >
                      <i-form v-model="detailform" label-position="center" :label-width="100">     
                      
                        <Form-item label="身份证号">
                                         <i-input v-model="cardNumber"  id="cardnumber" placeholder="请输入身份证号" style="width:380px;border:1px solid #dddee1;">
                                          </Form-item>      
                                     <Form-item label="手机号">
                                         <i-input v-model="phoneNumber"  id="phonenumber" placeholder="请输入手机号" style="width:380px;border:1px solid #dddee1;">
                                          </Form-item>  
                         <c:if test="${cspUser.type ne 2}">   
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
                                     <Form-item label="期望薪酬:">
					        <select id="modalpriceId"   v-model="priceId" :value="priceId"  style="width:380px;border:1px solid #dddee1;padding:5px;border-radius:4px;font-size:14px;" >
						  <Option v-for="item in  priceList" :value="item.id" :key="item.id">
						{{item.name }}</Option>
					      </select>
					   
                                     </Form-item>
                                     </c:if>
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
               <Form-item  label="照片:">
              <div onclick="uploadImg()" style="border:2px solid #5DB0D4;width:70px;height:30px;line-hight:23px;text-align:center;background-color:#5DB0D4;cursor:pointer;">上传图片</div>
<input type="file" id="FileUpload"  placeholder="封面"   accept="image/gif, image/jpeg,image/png"  style="display:none"  onchange="previewimage()" ></input>
<div id="article" style="width:100px;height:100px;display:none" >
<img id="img" style="width:100%;height:100%;" />
</div>
             </Form-item>
  
                                      </i-form>
                           <div slot="footer">
                            <button class="esayui-linkbutton" style="margin-left:40px"onclick="savefinishinfo()">保存</button>
		</div>
                                     </Modal>
              
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


