$(function(){

$("#sendRegMessage").click(function(){
	
	getRegMessageCode();
	
})

$("#myCarousel").carousel('cycle');
$("#myCarousel").carousel('next');


$("input[name='username']").keydown(function(event){
    if (event.keyCode == 13) login();
});

$("input[name='password']").keydown(function(event){
    if (event.keyCode == 13) login();
});

})	




/**
 * 登录
 */
function login(){

	var userType=$('#userType option:selected') .val();
	$("#loginform").bootstrapValidator('validate');//提交验证
    if ($("#loginform").data('bootstrapValidator').isValid()) {//获取验证结果，如果成功，执行下面代码
    $.ajax({
        type: "post",
        url: "web/visitor/userLogin",
        data: $("#loginform").serialize(),
        dataType: "json",
        success: function(data){
                 if(data.flag){
                	 if(userType==data.userType.toString()){
                		 $("#hip").empty();
                    	 if(data.userType==0){//管理员
                    		 window.location.href="web/manage/toUserinfo";
                    	 }else if(data.userType==1){//保姆
                    		 window.location.href="web/manage/toNeedInfo";
                    	 }else if(data.userType==2){//顾客
                    		 window.location.href="web/manage/toNeedInfo";
                    	 }
                	 }else{
                		 $("#hip").empty();
                    	 $("#hip").html("身份不符，请重新选择"); 
                	 }
                 }else{
                	 $("#hip").empty();
                	 $("#hip").html(data.resultMsg);
                 }

         }

    });
      }

}




function retrieve(){
	
	 var index=layer.open({
		 title:'找回密码',
         type: 1,
         area: ['500px', '500px'],
         btn: ['确定','取消'], //按钮组
         scrollbar: false ,//屏蔽浏览器滚动条
         closeBtn: false,
         shift: 2,
         shadeClose: true,
         content: $("#content"),
         yes:function(index){
        	 var loadindex = layer.load(1, {
       		  shade: [0.1,'#fff'] //0.1透明度的白色背景
       		});
        	 var userName=$("#userName").val();
        	 var email=$("#email").val();
        	     $.ajax({
        	       type: "post",
        	       url:'web/visitor/retrievePassword',
        	       data:{userName:userName,email:email},
        	       dataType:'json',
        	       success:function(data){
        	    	   layer.close(index);
        	    	   layer.close(loadindex);
        	         layer.msg(data.resultDesc);
        	        
        	       },
        	       error:function(){
        	         layer.msg("后台报错");
        	         layer.close(loadindex);
        	       }
        	     
        	     })
         }
     });
}



