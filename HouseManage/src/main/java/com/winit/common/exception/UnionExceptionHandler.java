package com.winit.common.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.winit.common.baseclass.ResultUtil;
import com.winit.entity.dto.ResultDto;






@ControllerAdvice
public class UnionExceptionHandler {
 
    /**
      * @Description: 系统异常捕获处理
      */
    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public ResultDto javaExceptionHandler(Exception ex) {
    	ex.printStackTrace();
    	return ResultUtil.exception(null,ex.getMessage());
    }
    /**
      * @Description: 自定义异常捕获处理
      */
    @ResponseBody
    @ExceptionHandler(value = CustomException.class)
    public ResultDto messageCenterExceptionHandler(CustomException ex) {
    	ex.printStackTrace();
    	return ResultUtil.exception(null,ex.getMessage());
    }
 
}