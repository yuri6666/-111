 var vm;


      $(function(){
    	
    	  initVue();
          vm.getJsonList();
      });
     
      function initVue(){  
    		vm = new Vue({
    	        el: '#vueBox',
    	        data:function(){
    	        	
    	             return {
    	            	  modal:false,
    	            	 
    	              param: {
    	            	  id:"",
    	            	  page: 1,
    	                  rows: 10
    	                },
    	                classId:"",
    	                levelId:"",
    	                expericeId:"",
    	                educationId:"",
    	                priceId:"",
    	                abilityId:"",
    	                ageId:"",
    	                provinceCode:"",
    	                cityCode:"",
    	                areaCode:"",
    	                expericeList:[],
    	                educationList:[],
    	                abilityList:[],
    	                ageList:[],
    	                classList:[],
    	                priceList:[],
    	                levelList:[],
    	                provinceList:[],
    	                citiesList:[],
    	                countyList:[],
    	                detailModel:false,
    	                commentModel:false,
    	                detailCommentModel:false,
    	                detailcutomermodel:false,
    	                detailnursemodel:false,
    	                total:0,
    	                detailform:{},
    	                commentform:{},
    	                columns1: [
               {
					type : 'index',
					title : '序号',
					align : 'center'
				},
				            { title: '顾客',  key: 'customerName',render:function (h, params){
					return h( 
           				 'Tooltip',
           	                {
           	                  props: { placement: 'top', content:"查看顾客信息", theme: 'light' }
           	                },	
           				[
                       h('a', {
                           style: {
                           	
                           	marginRight: '5px',
                               backgroundSize: '15px 15px',
                              /* paddingTop: '16px',*/
                               display: 'inline-block',
                               cursor:'pointer',
                           
                                 	 
                            },
                            on: {
                                click:function() {
                                	vm.detailcustomer(params.row);
                                }
                            }
                        }, params.row.customerName)
           	]	
           		
           		)}
				            },
                            { title: '服务类别',  key: 'className' },
                            { title: '级别',  key: 'levelName' },
                            { title: '经验',  key: 'experience' },
                            { title: '学历',  key: 'education' },
                            { title: '能力',  key: 'ability' },
                            { title: '年龄',  key: 'age' },
                            { title: '薪酬',  key: 'price' },
                            { title: '省',  key: 'province' },
                            { title: '市',  key: 'city' },
                            { title: '区',  key: 'county' },
                            { title: '实付金额',  key: 'money'},
                            { title: '保姆',  key: 'nurseName',render:function (h, params){
            					return h( 
            	           				 'Tooltip',
            	           	                {
            	           	                  props: { placement: 'top', content:"查看保姆信息", theme: 'light' }
            	           	                },	
            	           				[
            	                       h('a', {
            	                           style: {
            	                           	
            	                           	marginRight: '5px',
            	                               backgroundSize: '15px 15px',
            	                              /* paddingTop: '16px',*/
            	                               display: 'inline-block',
            	                               cursor:'pointer',
            	                           
            	                                 	 
            	                            },
            	                            on: {
            	                                click:function() {
            	                                	vm.detailnurse(params.row);
            	                                }
            	                            }
            	                        }, params.row.nurseName)
            	           	]	
            	           		
            	           		)}
                            	
                            
                            
                            },
                            { title: '状态',  key: 'status' ,
                            	render: function (h, params) {
                            		if(params.row.status=='0'){
        	                       		return  h('span', '未支付');
        	                       	}else if(params.row.status=='1'){
        	                       		return  h('span', '已支付');
        	                       		
        	                       	}else if(params.row.status=='2'){
        	                       		return  h('span', '已接单');
        	                       		
        	                       	}else if(params.row.status=='3'){
        	                       		return  h('span', '已完成');
        	                       		
        	                       	}else if(params.row.status=='4'){
        	                       		return  h('span', '已评价');
        	                       		
        	                       	}else if(params.row.status=='5'){
        	                       		return  h('span', '解除中');
        	                       		
        	                       	}			
                            	}
                            },
                           
    	                    {
    	                        title: '操作',
    	                        key: 'action',
    	                        width: 200,
    	                        align: 'center',
    	                        render: function(h, params){ 
    	                       var userType=$("#userType").val();
    	                        if(userType!=1){
    	                       if(params.row.status==0){
    	                    	   return h('div', [
	                        			  h('Button', {
      	                                    props: {
      	                                        type: 'primary',
      	                                        size: 'small'
      	                                    },
      	                                    style: {
      	                                        marginRight: '5px',
      	                                    },
      	                                    on: {
      	                                        click:function(){
      	                                        	vm.tijiao(params.row);
      	                                        }
      	                                    }
      	                                }, '修改'),
      	                               h('Button', {
    	                                    props: {
    	                                        type: 'primary',
    	                                        size: 'small'
    	                                    },
    	                                    style: {
    	                                        marginRight: '5px',
    	                                    },
    	                                    on: {
    	                                        click:function(){
    	                                        	vm.deleteRow(params.row);
    	                                        }
    	                                    }
    	                                }, '删除'),  
    	                                h('Button', {
    	                                    props: {
    	                                        type: 'primary',
    	                                        size: 'small'
    	                                    },
    	                                    style: {
    	                                        marginRight: '5px',
    	                                    },
    	                                    on: {
    	                                        click:function(){
    	                                        	vm.pay(params.row);
    	                                        }
    	                                    }
    	                                }, '去支付'),
	                        	]) 
    	                       }else if(params.row.status==2){
    	                    	   return h('div', [
	                        		
 	                                h('Button', {
 	                                    props: {
 	                                        type: 'primary',
 	                                        size: 'small'
 	                                    },
 	                                    style: {
 	                                        marginRight: '5px',
 	                                    },
 	                                    on: {
 	                                        click:function(){
 	                                        	vm.cancelServer(params.row);
 	                                        }
 	                                    }
 	                                }, '解除服务'),
 	                               h('Button', {
	                                    props: {
	                                        type: 'primary',
	                                        size: 'small'
	                                    },
	                                    style: {
	                                        marginRight: '5px',
	                                    },
	                                    on: {
	                                        click:function(){
	                                        	vm.confirm(params.row);
	                                        }
	                                    }
	                                }, '确认'),
	                        	]) 
    	                       }else if(params.row.status==3){
    	                    	   return h('div', [
	                        			 
	                                h('Button', {
	                                    props: {
	                                        type: 'primary',
	                                        size: 'small'
	                                    },
	                                    style: {
	                                        marginRight: '5px',
	                                    },
	                                    on: {
	                                        click:function(){
	                                        	vm.assess(params.row);
	                                        }
	                                    }
	                                }, '评价'),
	                        	]) 
	                        	
 	                       }else if(params.row.status==4){
	                    	   return h('div', [
                      			 
	                                h('Button', {
	                                    props: {
	                                        type: 'primary',
	                                        size: 'small'
	                                    },
	                                    style: {
	                                        marginRight: '5px',
	                                    },
	                                    on: {
	                                        click:function(){
	                                        	vm.assess(params.row);
	                                        }
	                                    }
	                                }, '评价'),
	                        	]) 
	                        	
	                       }else if(params.row.status==1){
	                    	   return h('div', [
	                      			 
	                                h('Button', {
	                                    props: {
	                                        type: 'primary',
	                                        size: 'small'
	                                    },
	                                    style: {
	                                        marginRight: '5px',
	                                    },
	                                    on: {
	                                        click:function(){
	                                        	vm.deleteRow(params.row);
	                                        }
	                                    }
	                                }, '取消订单'),
	                        	]) 
	                        	
	                       }else if(userType==0&&params.row.status==5){
	                    	   return h('div', [	                        			
	 	                                h('Button', {
	 	                                    props: {
	 	                                        type: 'primary',
	 	                                        size: 'small'
	 	                                    },
	 	                                    style: {
	 	                                        marginRight: '5px',
	 	                                    },
	 	                                    on: {
	 	                                        click:function(){
	 	                                        	vm.agreeServer(params.row);
	 	                                        }
	 	                                    }
	 	                                }, '同意解除服务'),
	                        	]) 
	                       }
    	                        }else if(userType==1){
    	                        	if(params.row.status==4){
    	                        		   return h('div', [	                        			
    	 	                                h('Button', {
    	 	                                    props: {
    	 	                                        type: 'primary',
    	 	                                        size: 'small'
    	 	                                    },
    	 	                                    style: {
    	 	                                        marginRight: '5px',
    	 	                                    },
    	 	                                    on: {
    	 	                                        click:function(){
    	 	                                        	vm.detailComment(params.row);
    	 	                                        }
    	 	                                    }
    	 	                                }, '查看评价'),
    		                        	]) 
    	                        	}else if(params.row.status==1){
    	                        		 return h('div', [	                        			
     	 	                                h('Button', {
     	 	                                    props: {
     	 	                                        type: 'primary',
     	 	                                        size: 'small'
     	 	                                    },
     	 	                                    style: {
     	 	                                        marginRight: '5px',
     	 	                                    },
     	 	                                    on: {
     	 	                                        click:function(){
     	 	                                        	vm.jiedan(params.row);
     	 	                                        }
     	 	                                    }
     	 	                                }, '我要接单'),
     		                        	]) 
    	                        	}else if(params.row.status==5){
  	                        		 return h('div', [	                        			
   	 	                                h('Button', {
   	 	                                    props: {
   	 	                                        type: 'primary',
   	 	                                        size: 'small'
   	 	                                    },
   	 	                                    style: {
   	 	                                        marginRight: '5px',
   	 	                                    },
   	 	                                    on: {
   	 	                                        click:function(){
   	 	                                        	vm.agreeServer(params.row);
   	 	                                        }
   	 	                                    }
   	 	                                }, '同意解除服务'),
   		                        	]) 
  	                        	}
    	                        }
    	                      
    	                        	
    	                   		}}],           
    	               data1:[],
    	
    	               formValidate: {
    	                  
    	                },
    	                value:''
    	                
    	            }
    	        },
    	        created:function(){
    	        	this.getProvinceList();
    	        	this.getClassList();
    	        	this.getLevelList();
    	        	this.getEducationList();
    	        	this.getAgeList();
    	        	this.getAbilityList();
    	        	this.getExpericeList();
    	        	this.getPriceList();
    	        },
    	        methods:{
    	        	
    	        	
    	            changePageNum: function (pageNum) {
    	              this.param.page = pageNum;
    	              this.getJsonList();
    	            },
    	           
    	           
    	          search:function(){
          	        	   this.param.page = 1;
        	        	   this.getJsonList();
        	       },
        	       changeProvince:function(){
   	            	if(this.provinceCode){
   	    	        	this.getCityList(this.provinceCode);
   	            	}
   	            },
   	            changeCity:function(){
   	            	if(this.cityCode){
   	            		this.getCountyList(this.cityCode);	
   	            	}
	    	        	
	    	        	
	            },
        	       tijiao:function(row){
	        	    	  vm.detailform={};
	        	    	  this.detailform.id=row.id;
	        	    	  this.abilityId=row.abilityId;
	     	       	     this.priceId=row.priceId;
	     		       	    this.ageId=row.ageId;
	     		       	    this.educationId=row.educationId;
	     		       	   this.classId=row.classId;
	     		       	 this.expericeId=row.experienceId;
	     		       	     this.levelId=row.levelId;
	     		       	  this.provinceCode=row.provinceCode;
	     		       	  this.cityCode=row.cityCode;
	     		       	this.areaCode=row.countyCode;
	       	     		   this.detailModel=true;
	       	     	   },
        	     deleteRow:function(row){
	       	          	 this.$Modal.confirm({
	     	                    title: '提示框',
	     	                    content: '<p>确定操作吗？</p>',
	     	                    onOk:function(){
	     	                    	$.ajax({
	     	    	                    type:"post",
	     	    	                    url:"api/need/delete",
	     	    	                    data:{"id":row.id},
	     	    	                    dataType:'json',
	     	    	                    async:false,
	     	    	                    success : function(data) {  
	     	    	                    	if(data.resultCode=='200'){
	     	    	                    		layer.msg('操作成功!');
    	     	    	                   		vm.getJsonList();
	     	    	                   	}else{
	     	    	                   		
	     	    	                   		 layer.msg(data.resultDesc);
	     	    	                   	}
	     	    	                     
	     	    	                    },
	     	    	                   error :function() {
	     	    	                	   layer.msg('操作失败！');
	     	    	                    }
	     	    	              	 });
	     	                    	
	     	                    }});
	     	        },

		       	     getProvinceList:function(){
		   	            	$.ajax({
		     	                  type:"post",
		     	                  url:"api/area/getProvince",
		     	                  data:{},
		     	                  dataType:'json',
		     	                  async:true,
		     	                  success : function(response) {    	                	  
		     	                	  if(response.resultCode == '200'){
						        		  vm.provinceList = response.data;
						        	  } 
		     	                  },
		     	                 error :function() {
		     	                	 alert("后台报错");
		     	                  }
		     	            	 });	
		   	            	
		   	            },
	    	            getCityList:function(param){
	    	            	$.ajax({
	      	                  type:"post",
	      	                  url:"api/area/getCity",
	      	                  data:{provinceCode:param},
	      	                  dataType:'json',
	      	                  async:true,
	      	                  success : function(response) {    	                	  
	      	                	  if(response.resultCode == '200'){
					        		  vm.citiesList = response.data;
					        	  } 
	      	                  },
	      	                 error :function() {
	      	                	 alert("后台报错");
	      	                  }
	      	            	 });	
	    	            	
	    	            },
	    	            getCountyList:function(param){
	    	            	$.ajax({
	      	                  type:"post",
	      	                  url:"api/area/getCounty",
	      	                  data:{cityCode:param},
	      	                  dataType:'json',
	      	                  async:true,
	      	                  success : function(response) {    	                	  
	      	                	  if(response.resultCode == '200'){
					        		  vm.countyList = response.data;
					        	  } 
	      	                  },
	      	                 error :function() {
	      	                	 alert("后台报错");
	      	                  }
	      	            	 });	
	    	            	
	    	            },
	    	            getClassList:function(){
	    	            	$.ajax({
	      	                  type:"post",
	      	                  url:"api/classify/getAll",
	      	                  data:{},
	      	                  dataType:'json',
	      	                  async:true,
	      	                  success : function(response) {    	                	  
	      	                	  if(response.resultCode == '200'){
					        		  vm.classList = response.data;
					        	  } 
	      	                  },
	      	                 error :function() {
	      	                	 alert("后台报错");
	      	                  }
	      	            	 });	
	    	            	
	    	            },
	    	            getLevelList:function(){
	    	            	$.ajax({
	      	                  type:"post",
	      	                  url:"api/level/getAll",
	      	                  data:{},
	      	                  dataType:'json',
	      	                  async:true,
	      	                  success : function(response) {    	                	  
	      	                	  if(response.resultCode == '200'){
					        		  vm.levelList = response.data;
					        	  } 
	      	                  },
	      	                 error :function() {
	      	                	 alert("后台报错");
	      	                  }
	      	            	 });	
	    	            	
	    	            },
	    	            getAgeList:function(){
	    	            	$.ajax({
	      	                  type:"post",
	      	                  url:"api/dictionary/getDictionary",
	      	                  data:{parentCode:"age"},
	      	                  dataType:'json',
	      	                  async:true,
	      	                  success : function(response) {    	                	  
	      	                	  if(response.resultCode == '200'){
					        		  vm.ageList = response.data;
					        	  } 
	      	                  },
	      	                 error :function() {
	      	                	 alert("后台报错");
	      	                  }
	      	            	 });	
	    	            	
	    	            },
	    	            getAbilityList:function(){
	    	            	$.ajax({
	      	                  type:"post",
	      	                  url:"api/dictionary/getDictionary",
	      	                  data:{parentCode:"ability"},
	      	                  dataType:'json',
	      	                  async:true,
	      	                  success : function(response) {    	                	  
	      	                	  if(response.resultCode == '200'){
					        		  vm.abilityList = response.data;
					        	  } 
	      	                  },
	      	                 error :function() {
	      	                	 alert("后台报错");
	      	                  }
	      	            	 });	
	    	            	
	    	            },
	    	            getEducationList:function(){
	    	            	$.ajax({
	      	                  type:"post",
	      	                  url:"api/dictionary/getDictionary",
	      	                  data:{parentCode:"education"},
	      	                  dataType:'json',
	      	                  async:true,
	      	                  success : function(response) {    	                	  
	      	                	  if(response.resultCode == '200'){
					        		  vm.educationList = response.data;
					        	  } 
	      	                  },
	      	                 error :function() {
	      	                	 alert("后台报错");
	      	                  }
	      	            	 });	
	    	            	
	    	            },
	    	            getExpericeList:function(){
	    	            	$.ajax({
	      	                  type:"post",
	      	                  url:"api/dictionary/getDictionary",
	      	                  data:{parentCode:"experice"},
	      	                  dataType:'json',
	      	                  async:true,
	      	                  success : function(response) {    	                	  
	      	                	  if(response.resultCode == '200'){
					        		  vm.expericeList = response.data;
					        	  } 
	      	                  },
	      	                 error :function() {
	      	                	 alert("后台报错");
	      	                  }
	      	            	 });	
	    	            	
	    	            },
	    	            getPriceList:function(){
	    	            	$.ajax({
	      	                  type:"post",
	      	                  url:"api/dictionary/getDictionary",
	      	                  data:{parentCode:"price"},
	      	                  dataType:'json',
	      	                  async:true,
	      	                  success : function(response) {    	                	  
	      	                	  if(response.resultCode == '200'){
					        		  vm.priceList = response.data;
					        	  } 
	      	                  },
	      	                 error :function() {
	      	                	 alert("后台报错");
	      	                  }
	      	            	 });	
	    	            	
	    	            },
	    	          
    	           getJsonList:function(){
    	        	   var load=this.$Loading;
    	        	   load.start();
    	        	   var index = layer.load(0, {shade: false});  
    	        	   var Data = this.param;
    	            	$.ajax({
    	                  type:"post",
    	                  url:"api/need/geNeedList",
    	                  data:Data,
    	                  dataType:'json',
    	                  async:false,
    	                  success : function(data) {    	                	  
    	                   vm.data1 = data.data.result;
    	                   vm.total = data.data.total;
    	                   load.finish();
    	                   layer.close(index);
    	                  },
    	                 error :function() {
    	                	 load.error();
    	                	 alert("后台报错");
    	                  }
    	            	 });
    	            },
    	            getClassList:function(){
    	            	$.ajax({
      	                  type:"post",
      	                  url:"api/classify/getAll",
      	                  data:{},
      	                  dataType:'json',
      	                  async:true,
      	                  success : function(response) {    	                	  
      	                	  if(response.resultCode == '200'){
				        		  vm.classList = response.data;
				        	  } 
      	                  },
      	                 error :function() {
      	                	 alert("后台报错");
      	                  }
      	            	 });	
    	            	
    	            },
    	            detailcustomer:function(row){
    	            	$.ajax({
        	                  type:"post",
        	                  url:"api/user/allUser",
        	                  data:{id:row.customerId},
        	                  dataType:'json',
        	                  async:true,
        	                  success : function(response) {    	                	  
        	                	  if(response.resultCode == '200'){
        	                	
  				        		  var phonenumber = response.data[0].phoneNumber;
  				        		 var photorUrl = response.data[0].photoUrl;
  				        		 $("#customerphone").html(phonenumber);
  				        		 $("#customerphotourl").attr("src",photorUrl);
  				        		vm.detailcutomermodel=true;
  				        	  } 
        	                  },
        	                 error :function() {
        	                	 alert("后台报错");
        	                  }
        	            	 });	
      	            	
      	            },
      	          detailnurse:function(row){
  	            	$.ajax({
      	                  type:"post",
      	                  url:"api/user/allUser",
      	                  data:{id:row.nurseId},
      	                  dataType:'json',
      	                  async:true,
      	                  success : function(response) {    	                	  
      	                	  if(response.resultCode == '200'){
				        		  var phonenumber = response.data[0].phoneNumber;
				        		 var photorUrl = response.data[0].photoUrl;
				        		 $("#nursephone").html(phonenumber);
				        		 $("#nursephotourl").attr("src",photorUrl);
				        		vm.detailnursemodel=true;
				        	  } 
      	                  },
      	                 error :function() {
      	                	 alert("后台报错");
      	                  }
      	            	 });	
    	            	
    	            },
    	            pay:function(row){    	
    	            	 var index=layer.open({
    	            		 title:'支付',
    	                     type: 1,
    	                     area: ['500px', '500px'],
    	                     btn: ['确定','取消'], //按钮组
    	                     scrollbar: false ,//屏蔽浏览器滚动条
    	                     closeBtn: false,
    	                     shift: 2,
    	                     shadeClose: true,
    	                     content: $("#paycontent"),
    	                     yes:function(index){
    	                    	 var paymoney=document.getElementById("paymoney").value;
    	                    	  	$.ajax({
         	    	                    type:"post",
         	    	                    url:"api/need/updateselective",
         	    	                    data:{"id":row.id,status:1,money:paymoney,isEnable:1},
         	    	                    dataType:'json',
         	    	                    async:false,
         	    	                    success : function(data) {  
         	    	                    	if(data.resultCode=='200'){
         	    	                    		layer.close(index);               		
         	                    	         layer.msg('支付成功');
         	                    	        vm.getJsonList();
         	    	                   	}else{
         	    	                   		
         	    	                   		 layer.msg(data.resultDesc);
         	    	                   	}
         	    	                     
         	    	                    },
         	    	                   error :function() {
         	    	                	   layer.msg('支付失败！');
         	    	                    }
         	    	              	 });
    	                    	
    	                     }
    	                 });
    	              
    	            },
    	            jiedan:function(row){   
    	            	 this.$Modal.confirm({
	     	                    title: '提示框',
	     	                    content: '<p>确定接单吗？</p>',
	     	                    onOk:function(){
	     	                    	var userId=$("#userId").val();
	     	                    	$.ajax({
	     	    	                    type:"post",
	     	    	                    url:"api/need/updateselective",
	     	    	                    data:{"id":row.id,status:2,nurseId:userId},
	     	    	                    dataType:'json',
	     	    	                    async:false,
	     	    	                    success : function(data) {  
	     	    	                    	if(data.resultCode=='200'){
	     	    	                    		layer.msg('接单成功,请与雇主沟通!');
 	     	    	                   		vm.getJsonList();
	     	    	                   	}else{
	     	    	                   		
	     	    	                   		 layer.msg(data.resultDesc);
	     	    	                   	}
	     	    	                     
	     	    	                    },
	     	    	                   error :function() {
	     	    	                	   layer.msg('接单失败！');
	     	    	                    }
	     	    	              	 });
	     	                    	
	     	                    }});
    	            	
    	            	
    	              	
    	            },
    	            agreeServer:function(row){
    	           	 this.$Modal.confirm({
  	                    title: '提示框',
  	                    content: '<p>确定解除服务吗？</p>',
  	                    onOk:function(){
  	                    	var userId=$("#userId").val();
  	                    	$.ajax({
  	    	                    type:"post",
  	    	                    url:"api/need/updateServer",
  	    	                    data:{"id":row.id,nurseId:userId},
  	    	                    dataType:'json',
  	    	                    async:false,
  	    	                    success : function(data) {  
  	    	                    	if(data.resultCode=='200'){
  	    	                    		layer.msg('解除服务成功');
   	    	                   		vm.getJsonList();
  	    	                   	}else{
  	    	                   		
  	    	                   		 layer.msg(data.resultDesc);
  	    	                   	}
  	    	                     
  	    	                    },
  	    	                   error :function() {
  	    	                	   layer.msg('解除失败！');
  	    	                    }
  	    	              	 });
  	                    	
  	                    }});
 	            },
 	           cancelServer:function(row){
  	           	 this.$Modal.confirm({
	                    title: '提示框',
	                    content: '<p>确定解除服务吗？</p>',
	                    onOk:function(){
	                    	$.ajax({
	    	                    type:"post",
	    	                    url:"api/need/updateselective",
	    	                    data:{"id":row.id,status:5},
	    	                    dataType:'json',
	    	                    async:false,
	    	                    success : function(data) {  
	    	                    	if(data.resultCode=='200'){
	    	                    		layer.msg('联系对方，对方同意后方可解除');
 	    	                   		vm.getJsonList();
	    	                   	}else{
	    	                   		
	    	                   		 layer.msg(data.resultDesc);
	    	                   	}
	    	                     
	    	                    },
	    	                   error :function() {
	    	                	   layer.msg('操作失败！');
	    	                    }
	    	              	 });
	                    	
	                    }});
	            },
 	           confirm:function(row){
  	           	 this.$Modal.confirm({
	                    title: '提示框',
	                    content: '<p>确认收到服务后,钱款将立即到达保姆账户</p>',
	                    onOk:function(){
	                    	  var param={
	                    			  "id":row.id,
	                    			  status:3,
	                    			  customerId:row.customerId,
	                    			  nurseId:row.nurseId,
	                    			  money:row.money,
	                    			  customerName:row.customerName,
	                    			  nurseName:row.nurseName
	                    	  }
	                    	$.ajax({
	    	                    type:"post",
	    	                    url:"api/need/updateselective",
	    	                    data:param,
	    	                    dataType:'json',
	    	                    async:false,
	    	                    success : function(data) {  
	    	                    	if(data.resultCode=='200'){
	    	                    		layer.msg('操作成功');
	    	                   		vm.getJsonList();
	    	                   	}else{
	    	                   		
	    	                   		 layer.msg(data.resultDesc);
	    	                   	}
	    	                     
	    	                    },
	    	                   error :function() {
	    	                	   layer.msg('操作失败！');
	    	                    }
	    	              	 });
	                    	
	                    }});
	            },
	            assess:function(row){
	            	if(row.comment){
	            		$("#comment").val(row.comment);
	            	}
	            	 this.commentform.id=row.id;
	            	vm.commentModel=true;
		            },
		            saveComentInfo:function(row){
		            	var comment=$("#comment").val();
		            	var id=this.commentform.id;
		            	$.ajax({
    	                    type:"post",
    	                    url:"api/need/updateselective",
    	                    data:{id:id,comment:comment,status:4},
    	                    dataType:'json',
    	                    async:false,
    	                    success : function(data) {  
    	                    	if(data.resultCode=='200'){
    	                    		layer.msg('操作成功');
    	                    		vm.commentModel=false
    	                   		vm.getJsonList();
    	                   		
    	                   	}else{
    	                   		
    	                   		 layer.msg(data.resultDesc);
    	                   	}
    	                     
    	                    },
    	                   error :function() {
    	                	   layer.msg('操作失败！');
    	                    }
    	              	 });
		            },
		            detailComment:function(row){
		            	
		            	if(row.comment){
		            		$("#detailComment").html(row.comment);
		            	}
		            	vm.detailCommentModel=true;
		            },
       	     	   save:function(row){
       	     		  var id=this.detailform.id;
       	     		  var customerId=document.getElementById("userId").value;
       	  	       var abilityId=this.abilityId;
       	  	      var priceId=this.priceId;
       	  	      var educationId=this.educationId;  	 
       	  	      var classId=this.classId;
       	  	     var levelId=this.levelId;
       	  	     var provinceCode=this.provinceCode;
       	  	     var cityCode=this.cityCode;
       	  	     var areaCode=this.areaCode;
       	  	     var expericeId=this.expericeId;
       	  	     var ageId=this.ageId;
       	  	var param={
		    			 id:id,
		    			 customerId:customerId,
		    			abilityId:abilityId,
		    			priceId:priceId,
		    			ageId:ageId,
		    			educationId:educationId,
		    			classId:classId,
		    			levelId:levelId,
		    			provinceCode:provinceCode,
		    			cityCode:cityCode,
		    			countyCode:areaCode,
		    			experienceId:expericeId,   		
    		    }	
       	          	$.ajax({
       	              type:"post",
       	              url:"api/need/save",
       	              data:param,
       	              dataType:'json',
       	             success : function(data) {  
       	              	if(data.resultCode=='200'){
       	               		 layer.msg(data.resultDesc);
       	               		 vm.getJsonList();
       	               	     vm.detailModel=false; 
       	               	    
       	               	     
       	               	}else{
       	               		 layer.msg(data.resultDesc);
       	               	}
       	              },
       	             error :function() {
       	            	 alert('后台查询出错！');
       	              }
       	        	 });
                
    	     	    }
    	     
    	   
    	        }
    	    });
    	}

      function add(){ 
    	      vm.abilityId="";
 	  	      vm.priceId="";
 	  	      vm.educationId="";  	 
 	  	     vm.classId="";
 	  	     vm.levelId="";
 	  	    vm.provinceCode="";
 	  	     vm.cityCode="";
 	  	     vm.areaCode="";
 	  	     vm.expericeId="";
 	  	     vm.ageId="";
    	  vm.detailModel=true; 
  
       }
       
      function search(){
    	  vm.getJsonList();
    	  
      }
      
      function saveinfo(){
    	 vm.save(); 
      }
      function saveComment(){
    	  vm.saveComentInfo();
      }
        	 
