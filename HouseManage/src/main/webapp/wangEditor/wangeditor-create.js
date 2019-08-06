
/*--------------------------编辑器创建和配置-----------------------------*/
function creatEidtor(){

var E = window.wangEditor
	 editor = new E('#content')
	editor.customConfig.menus = [
	    'head',  // 标题
	    'bold',  // 粗体
	    'fontSize',  // 字号
	    'fontName',  // 字体
	    'italic',  // 斜体
	    'underline',  // 下划线
	    'strikeThrough',  // 删除线
	    'foreColor',  // 文字颜色
	    'backColor',  // 背景颜色
	    'link',  // 插入链接
	    'list',  // 列表
	    'justify',  // 对齐方式
	    'quote',  // 引用
	    'emoticon',  // 表情
	    'image',  // 插入图片
	    'table',  // 表格
	    'video',  // 插入视频
	    'code',  // 插入代码
	    'undo',  // 撤销
	    'redo' // 重复

	]

	wangeditor_debug_mode=1 //才会开启 debug 模式
	  editor.customConfig.debug =
	    location.href.indexOf('wangeditor_debug_mode=1') > 0;

	  // 将图片大小限制为 3M
	  editor.customConfig.uploadImgMaxSize = 3 * 1024 * 1024;

	  // 配置编辑区域的 z-index
	  editor.customConfig.zIndex = 1;

	  // 下面两个配置，使用其中一个即可显示“上传图片”的tab。但是两者不要同时使用！！！
	 // editor.customConfig.uploadImgShowBase64 = true; // 使用 base64 保存图片
	/*  editor.customConfig.uploadFileName = 'uploadimg'*///相当于formdata中append
	 /* editor.customConfig.uploadImgServer = ''  // 上传图片到服务器
	  * 
*/	  editor.customConfig.uploadFileName = 'files'//相当于formdata中append
	  editor.customConfig.uploadImgServer = 'file/uploadeditorFile'  // 上传图片到服务器用
		  editor.customConfig.uploadImgParams = {
			    // 如果版本 <=v3.1.0 ，属性值会自动进行 encode ，此处无需 encode
			    // 如果版本 >=v3.1.1 ，属性值不会自动 encode ，如有需要自己手动 encode
		           
			  
			}
	  editor.customConfig.uploadImgTimeout = 30000;
	  editor.customConfig.pasteFilterStyle = true;
	  editor.customConfig.pasteIgnoreImg = false;
	  //editor.customConfig.uploadImgShowBase64 = true;
	
	  editor.customConfig.pasteTextHandle = function (content){
		  var html=isWordDocument(content)?filterPasteWord(content):content;
		  return html;
	  }
	  editor.customConfig.uploadImgHooks = {
			  success: function (xhr, editor, result) {	
				 /* var title=$("#title").val();
				  $(".w-e-text img").removeAttr("style");
				  $(".w-e-text img").css({"width":"82%","margin":"10px 40px"});//对图片进行缩放
				  $(".w-e-text img").attr("alt",title);*/
				
				 
			  }
	  }
	  editor.customConfig.onchange  = function (html) {
		        var text=editor.txt.text();
		        var currentLength=text.length;
		        var maxlength=2000;
		        if(currentLength<=2000){
		        $("#length").text(currentLength);
		        $("#maxLength").text(maxlength);
		        }else{
		        	 $("#length").text(currentLength);
				     $("#maxLength").text(maxlength);
				     var index= layer.msg("字数超过,上传可能会异常",{time:4000,offset:[400,600]});
		        }
	              $("#previewContent").val(html);
	             
	          };
	          editor.customConfig.emotions = [
	  	        {
	  	            // tab 的标题
	  	            title: '默认',
	  	            // type -> 'emoji' / 'image'
	  	            type: 'image',
	  	            // content -> 数组
	  	            content: [
	  	                {
	  	                    alt: '[爱你]',
	  	                    src: 'http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/f6/2018new_aini_org.png'
	  	                },
	  	                {
	  	                    alt: '[悲伤]',
	  	                    src: 'http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/ee/2018new_beishang_org.png'
	  	                },
	  	                {
	  	                    alt: '[吃惊]',
	  	                    src: 'http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/49/2018new_chijing_org.png'
	  	                },
	  	                {
	  	                    alt: '[偷笑]',
	  	                    src: 'http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/71/2018new_touxiao_org.png'
	  	                },
	  	                {
	  	                    alt: '[互粉]',
	  	                    src: 'http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/86/2018new_hufen02_org.png'
	  	                },
	  	                {
	  	                    alt: '[可怜]',
	  	                    src: 'http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/96/2018new_kelian_org.png'
	  	                },
	  	                {
	  	                    alt: '[生病]',
	  	                    src: 'http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/3b/2018new_shengbing_org.png'
	  	                },
	  	                {
	  	                    alt: '[憧憬]',
	  	                    src: 'http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/c9/2018new_chongjing_org.png'
	  	                },
	  	                {
	  	                    alt: '[可爱]',
	  	                    src: 'http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/09/2018new_keai_org.png'
	  	                },
	  	                {
	  	                    alt: '[太开心]',
	  	                    src: 'http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/1e/2018new_taikaixin_org.png'
	  	                },
	  	                {
	  	                    alt: '[握手]',
	  	                    src: 'http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/e9/2018new_woshou_org.png'
	  	                },
	  	                {
	  	                    alt: '[拳头]',
	  	                    src: 'http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/86/2018new_quantou_org.png'
	  	                },
	  	                {
	  	                    alt: '[ok]',
	  	                    src: 'http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/45/2018new_ok_org.png'
	  	                },
	  	                {
	  	                    alt: '[抱抱]',
	  	                    src: 'http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/42/2018new_baobao_org.png'
	  	                },
	  	                {
	  	                    alt: '[给力]',
	  	                    src: 'http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/36/2018new_geili_org.png'
	  	                },
	  	              {
	  	                    alt: '[太阳]',
	  	                    src: 'http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/cd/2018new_taiyang_org.png'
	  	                },
	  	              {
	  	                    alt: '[亲亲]',
	  	                    src: 'http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/2c/2018new_qinqin_org.png'
	  	                },
	  	                
	  	            ]
	  	        },
	  	   
	  	    ]
	editor.create()
 $(".w-e-text-container").css("text-indent","2rem");
	E.fullscreen.init('#artcontent');
	
}