package com.winit.common.baseclass;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.winit.common.constans.Constant;
import com.winit.entity.dto.ResultDto;






public class ResultUtil {
	
	
	public static Map<String,Object> toGridJson(Long totalCount, Object obj) {  
        // 如果数据集对象为null做个特殊处理  
        if(null == obj) {  
            Map<String,Object> map = new HashMap<String,Object>();  
            map.put("total", totalCount);  
            map.put("rows", obj);  
            return map;  
        }  
  
        if(!Collection.class.isAssignableFrom(obj.getClass())) {  
        	 Map<String,Object> map = new HashMap<String,Object>();  
        	 map.put("total", totalCount);  
        	 map.put("rows", obj);  
            return map;  
        }  
  
        Map<String,Object> map = new HashMap<String,Object>();  
        map.put("total", totalCount);  
        map.put("rows", obj);  
        return map;  
    }
	
	

	/**
	 * 成功
	 * @return
	 */
	public static ResultDto success(Object ...object){
		if(object.length>=2){
			return new ResultDto(Constant.RESULT_CODE.SUCCESS.getResultCode(), object[0],object[1]!=null?object[1].toString():null);
		}else if(object.length==1){
			return new ResultDto(Constant.RESULT_CODE.SUCCESS.getResultCode(), object[0].toString());
		}else{
			return new ResultDto(Constant.RESULT_CODE.FAIL.getResultCode(), "返回的结果，传入参数错误");
		}
	}
	
	/**
	 * 失败
	 * @return
	 */
	public static ResultDto fail(Object ...object){
		if(object.length>=2){
			return new ResultDto(Constant.RESULT_CODE.FAIL.getResultCode(), object[0],object[1]!=null?object[1].toString():null);
		}else if(object.length==1){
			return new ResultDto(Constant.RESULT_CODE.FAIL.getResultCode(), object[0].toString());
		}else{
			return new ResultDto(Constant.RESULT_CODE.FAIL.getResultCode(), "返回的结果，传入参数错误");
		}
	}
	
	
	/**
	 * 异常
	 * @return
	 */
	public static ResultDto exception(Object ...object){
		if(object.length>=2){
			return new ResultDto(Constant.RESULT_CODE.EXCEPTION.getResultCode(), object[0],object[1]!=null?object[1].toString():null);
		}else if(object.length==1){
			return new ResultDto(Constant.RESULT_CODE.EXCEPTION.getResultCode(), object);
		}else{
			return new ResultDto(Constant.RESULT_CODE.FAIL.getResultCode(), "返回的结果，传入参数错误");
		}
	}
	
	
	/**
	 * 未登录
	 * @return
	 */
	public static ResultDto notLogin(Object ...object){
		if(object.length>=2){
			return new ResultDto(Constant.RESULT_CODE.NOT_LOGIN.getResultCode(), object[0],object[1]!=null?object[1].toString():null);
		}else if(object.length==1){
			return new ResultDto(Constant.RESULT_CODE.NOT_LOGIN.getResultCode(), object);
		}else{
			return new ResultDto(Constant.RESULT_CODE.FAIL.getResultCode(), "返回的结果，传入参数错误");
		}
	}
	
	/**
	 * 没权限
	 * @param object
	 * @return
	 */
	public static ResultDto notAuth(Object ...object){
		if(object.length>=2){
			return new ResultDto(Constant.RESULT_CODE.NOT_AUTH.getResultCode(), object[0],object[1]!=null?object[1].toString():null);
		}else if(object.length==1){
			return new ResultDto(Constant.RESULT_CODE.NOT_AUTH.getResultCode(), object);
		}else{
			return new ResultDto(Constant.RESULT_CODE.FAIL.getResultCode(), "返回的结果，传入参数错误");
		}
	}
	
	
	/**
	 * 404找不到
	 */
	public static ResultDto error404(Object ...object){
		if(object.length>=2){
			return new ResultDto(Constant.RESULT_CODE.ERROR_404.getResultCode(), object[0],object[1]!=null?object[1].toString():null);
		}else if(object.length==1){
			return new ResultDto(Constant.RESULT_CODE.ERROR_404.getResultCode(), object);
		}else{
			return new ResultDto(Constant.RESULT_CODE.FAIL.getResultCode(), "返回的结果，传入参数错误");
		}
	}
	
	
	/**
	 * 时间过长,登录掉线
	 */
	public static ResultDto longTimeNotLogin(Object ...object){
		if(object.length>=2){
			return new ResultDto(Constant.RESULT_CODE.LOGN_TIME_NOT_LOGIN.getResultCode(), object[0],object[1]!=null?object[1].toString():null);
		}else if(object.length==1){
			return new ResultDto(Constant.RESULT_CODE.LOGN_TIME_NOT_LOGIN.getResultCode(), object);
		}else{
			return new ResultDto(Constant.RESULT_CODE.FAIL.getResultCode(), "返回的结果，传入参数错误");
		}
	}
	
	/**
	 * 被踢出来了
	 */
	public static ResultDto anotherPlaceLogin(Object ...object){
		if(object.length>=2){
			return new ResultDto(Constant.RESULT_CODE.ANTHER_PLACE_LOGIN.getResultCode(), object[0],object[1]!=null?object[1].toString():null);
		}else if(object.length==1){
			return new ResultDto(Constant.RESULT_CODE.ANTHER_PLACE_LOGIN.getResultCode(), object);
		}else{
			return new ResultDto(Constant.RESULT_CODE.FAIL.getResultCode(), "返回的结果，传入参数错误");
		}
	}
	
	

}
