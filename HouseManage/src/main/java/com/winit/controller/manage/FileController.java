package com.winit.controller.manage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.time.DateUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;




@Controller
@RequestMapping(value="file")
public class FileController {
    
	@Value("${file.host.path}")
	private String fileHostPath;
	
	//前端先上传图片预览生成图片id 给图片右上角一个删除图标 点击时remove(id)  压缩或者不压缩放入到一个数组里统一上传file 
	@RequestMapping("/uploadFile")//同时上传多张文件前端数组存储之后点保存 统一上传 集修改删除于一体
	@ResponseBody
	public Map<String,Object> save(@RequestParam(value = "file", required = false) MultipartFile[] files,String userId) throws IllegalStateException, IOException {
		     List<String> fileUrls = new ArrayList<>();
		     List<String> fileNames = new ArrayList<>();
		      String threeLeveldirPath=fileHostPath+"images/"+userId+"/";
		      File threeLeveldir=new File(threeLeveldirPath);
		      if(!threeLeveldir.exists()) {//如果目录不存在就创建目录
		    	  threeLeveldir.mkdirs();
		      }
		      File[] Files=threeLeveldir.listFiles();
		      if(Files!=null&&Files.length>0) {//如果该userId下有文件 就先删除掉原有文件 然后做存储
		    	  for(File dirFile:Files) {
		    		  dirFile.delete();
		    	  }
		      }
		      for(MultipartFile file:files) {
		    	  String fileName=file.getOriginalFilename();
		    	  String fileType=fileName.substring(fileName.indexOf("."),fileName.length());
		    	  String serialName=String.valueOf(System.currentTimeMillis());	 
		    	  String filePath=fileHostPath+"images/"+userId+"/"+serialName+fileType;//新建文件路径 存在服务器本地磁盘  路径中有userId 便于查找某个用户的图片
		    	  String url="file/images/"+userId+"/"+serialName+fileType;//返回url 存在数据库中
		    	  File saveDirFile =new File(filePath);
		    	  if(!saveDirFile.getParentFile().exists()) {
			    	  saveDirFile.getParentFile().mkdirs();
			      }
		    	  file.transferTo(saveDirFile);//文件转存
		    	  if(saveDirFile.exists()) {//如果文件存在	
		    		  fileUrls.add(url);
		    		  fileNames.add(fileName);
		    	  }
		    	  }
		      Map<String,Object> map=new HashMap<String,Object>();
		 	    map.put("errno",0);
		 		map.put("data",fileUrls);
		 		return map;
		      }

	@RequestMapping("/uploadeditorFile")//同时上传多张文件前端数组存储之后点保存 统一上传 集修改删除于一体
	@ResponseBody
	public Map<String,Object> uploadFile(@RequestParam(value = "files", required = false) MultipartFile[] files,String userId) throws IllegalStateException, IOException {
		     List<String> fileUrls = new ArrayList<>();
		     List<String> fileNames = new ArrayList<>();
		      String threeLeveldirPath=fileHostPath+"images/"+userId+"/";
		      File threeLeveldir=new File(threeLeveldirPath);
		      if(!threeLeveldir.exists()) {//如果目录不存在就创建目录
		    	  threeLeveldir.mkdirs();
		      }
		     /* File[] Files=threeLeveldir.listFiles();
		      if(Files!=null&&Files.length>0) {//如果该userId下有文件 就先删除掉原有文件 然后做存储
		    	  for(File dirFile:Files) {
		    		  dirFile.delete();
		    	  }
		      }*/
		      for(MultipartFile file:files) {
		    	  String fileName=file.getOriginalFilename();
		    	  String fileType=fileName.substring(fileName.indexOf("."),fileName.length());
		    	  String serialName=String.valueOf(System.currentTimeMillis());	 
		    	  String filePath=fileHostPath+"images/"+userId+"/"+serialName+fileType;//新建文件路径 存在服务器本地磁盘  路径中有userId 便于查找某个用户的图片
		    	  String url="file/images/"+userId+"/"+serialName+fileType;//返回url 存在数据库中
		    	  File saveDirFile =new File(filePath);
		    	  if(!saveDirFile.getParentFile().exists()) {
			    	  saveDirFile.getParentFile().mkdirs();
			      }
		    	  file.transferTo(saveDirFile);//文件转存
		    	  if(saveDirFile.exists()) {//如果文件存在	
		    		  fileUrls.add(url);
		    		  fileNames.add(fileName);
		    	  }
		    	  }
		      Map<String,Object> map=new HashMap<String,Object>();
		 	    map.put("errno",0);
		 		map.put("data",fileUrls);
		 		return map;
		      }
	
	
	@RequestMapping(value="/{twoLevelDir}/{userId}/{fileName}.{suffix}")
	   public void readFile(@PathVariable(value = "twoLevelDir") String twoLevelDir, @PathVariable(value = "userId") String userId,@PathVariable(value = "fileName") String fileName, @PathVariable(value = "suffix") String suffix, HttpServletResponse response) throws IOException{
		InputStream fileIs=null;
		 try {
	   String filePath=fileHostPath+twoLevelDir+"/"+userId+"/"+fileName+"."+suffix;
	   File file =new File(filePath);
	   fileIs=new FileInputStream(file);
	   IOUtils.copy(fileIs,response.getOutputStream());
	 //设置缓存
		response.setHeader("Cache-Control", "max-age=604800");
		response.setHeader("Pragrma", "Pragma");
		response.setDateHeader("Expires", DateUtils.addDays(new Date(), 30).getTime());
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		IOUtils.closeQuietly(fileIs);
	}
		
	}
	
}
