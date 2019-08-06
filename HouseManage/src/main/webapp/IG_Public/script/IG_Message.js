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
    	                title:"",
    	                content:"",
    	                detailModel:false,
    	                contentModel:false,
    	                contentdetail:"",
    	                total:0,
    	                detailform:{},
    	                columns1: [
               {
					type : 'index',
					title : '序号',
					align : 'center'
				},
                            { title: '标题',  key: 'title' },
                            { title: '创造时间',  key: 'createTime' },
                            { title: '发布时间',  key: 'releaseTime' },                                      
                            { title: '状态',  key: 'isEnable',
                            	render: function (h, params) {
                            		if(params.row.isEnable=='0'){
        	                       		return  h('span', '未发布');
        	                       	}else if(params.row.isEnable=='1'){
        	                       		return  h('span', '已发布');
        	                       		
        	                       	}	
                            	}
                            },
    	                    {
    	                        title: '操作',
    	                        key: 'action',
    	                        width: 310,
    	                        align: 'center',
    	                        render: function(h, params){   	
    	                        	var userType=$("#userType").val();
    	                        if(userType==0&&params.row.isEnable=='0'){
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
    	                                        	vm.release(params.row);
    	                                        }
    	                                    }
    	                                }, '发布'),
         	                              
    	                        	])
    	                        	
    	                        	}else if(userType==0&&params.row.isEnable=='1'){
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
        	                                        	vm.detail(params.row);
        	                                        }
        	                                    }
        	                                }, '查看'),
       	                        
           	                              
      	                        	])
      	                        	
    	                        	}else if(userType!=0){
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
            	                                        	vm.detail(params.row);
            	                                        }
            	                                    }
            	                                }, '查看'),
           	                        
      	                        	])
    	                        	}
    	                   		}}],           
    	               data1:[],
    	
    	               formValidate: {
    	                  
    	                },
    	                value:''
    	                
    	            }
    	        },
    	        created:function(){

    	        },
    	        mounted:function(){
    	        	creatEidtor();
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
        	       tijiao:function(row){
	        	    	  vm.detailform={};
	        	    	  this.detailform.id=row.id;
	       	     	  this.title=row.title;
	       	           editor.txt.html(row.Content);
	       	     		   this.detailModel=true;
	       	     	   },
        	     deleteRow:function(row){
	       	          	 this.$Modal.confirm({
	     	                    title: '提示框',
	     	                    content: '<p>确定删除吗？</p>',
	     	                    onOk:function(){
	     	                    	$.ajax({
	     	    	                    type:"post",
	     	    	                    url:"api/message/delete",
	     	    	                    data:{"id":row.id},
	     	    	                    dataType:'json',
	     	    	                    async:false,
	     	    	                    success : function(data) {  
	     	    	                    	if(data.resultCode=='200'){
	     	    	                    		layer.msg('删除成功!');
    	     	    	                   		vm.getJsonList();
	     	    	                   	}else{
	     	    	                   		
	     	    	                   		 layer.msg(data.resultDesc);
	     	    	                   	}
	     	    	                     
	     	    	                    },
	     	    	                   error :function() {
	     	    	                	   layer.msg('删除失败！');
	     	    	                    }
	     	    	              	 });
	     	                    	
	     	                    }});
	     	        },
	     	       detail:function(row){
	     	    		$.ajax({
	    	                  type:"post",
	    	                  url:"api/message/geMessageList",
	    	                  data:{id:row.id},
	    	                  dataType:'json',
	    	                  async:false,
	    	                  success : function(data) {    
	    	                	  
	    	                	  var response=data.data.result;
	    	                   var content= response[0].content;
	    	                  $("#contentdetail").html(content)
	    	                  vm.contentModel=true;
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
    	        	   var userType=$("#userType").val();
    	        	   var userId=$("#userId").val();
    	        	   if(userType!=0){
    	        		   this.param.isEnable=1;
    	        	   }
    	        	   var Data = this.param;
    	            	$.ajax({
    	                  type:"post",
    	                  url:"api/message/geMessageList",
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
    	            release:function(row){
    	     	    	this.$Modal.confirm({
     	                    title: '提示框',
     	                    content: '<p>确定发布吗？</p>',
     	                    onOk:function(){
     	                    	$.ajax({
     	    	                    type:"post",
     	    	                    url:"api/message/updateselective",
     	    	                    data:{"id":row.id,isEnable:1},
     	    	                    dataType:'json',
     	    	                    async:false,
     	    	                    success : function(data) {  
     	    	                    	if(data.resultCode=='200'){
     	    	                    		layer.msg('发布成功!');
         	    	                   		vm.getJsonList();
     	    	                   	}else{
     	    	                   		
     	    	                   		 layer.msg(data.resultDesc);
     	    	                   	}
     	    	                     
     	    	                    },
     	    	                   error :function() {
     	    	                	   layer.msg('发布失败！');
     	    	                    }
     	    	              	 });
     	                    	
     	                    }});
    	     	     },
       	     	save:function(row){
       	     		var title=this.title;
       	     		   var param={
       	     				   id:this.detailform.id,
       	     			       title:this.title,
       	     	               Content:geteditorContent()
       	     		    }
       	     		   
       	          	$.ajax({
       	              type:"post",
       	              url:"api/message/save",
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
                
    	     	    },
    	     
    	     
    	   
    	        }
    	    });
    	}

      function add(){ 
    	  vm.detailform={};
    	  editor.txt.html("");
    	  vm.detailModel=true; 
    	  
  
       }
       
      function search(){
    	  
    	  vm.param.title=$("#title").val();
    	  vm.getJsonList();
    	  
      }
     function closeModel(){
    	 vm.contentModel=false;
     }

      function saveinfo(){
    	 
    	 vm.save(); 
      }

      function geteditorTxtContent(){//获取富文本的不带标签的内容
    		var txt=editor.txt.text();
    		if(txt.length > 200){
    			txt = txt.substring(0,200);
    		}
    		return txt.replace(/&nbsp;/ig,"");
    	}
      function geteditorContent(){//获取富文本的内容
    		return editor.txt.html();
    	}
      
