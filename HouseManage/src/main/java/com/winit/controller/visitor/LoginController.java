package com.winit.controller.visitor;


import java.util.HashMap;
import java.util.List;
import java.util.Map;


import javax.servlet.http.HttpSession;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.winit.common.utils.EmailUtil;
import com.winit.entity.dto.ResultDto;
import com.winit.entity.pojo.User;
import com.winit.service.UserService;


/**
 * 登录控制器
 * @author 555
 *
 */
@Controller
@RequestMapping("web/visitor")
public class LoginController {

	
	@Autowired
	private UserService userService;

	
	@RequestMapping(value = "/toLogin")
	public ModelAndView toLogin(ModelAndView view,HttpSession session){
		view.setViewName("login");
		return view;
	}

	  
	/**
	 * 用户登录
	 */
	@RequestMapping(value = "/userLogin")
	public @ResponseBody Map<String,Object> userLogin(User cspUser,HttpSession session) {
		Map<String,Object>  map=new HashMap<String,Object>();
		try{
			map = userService.userLogin(cspUser,session);
		}catch(Exception e){
			e.printStackTrace();
			map.put("flag", false);
			map.put("resultMsg", "系统异常");
		}
		return map;
	}
	
	@RequestMapping(value = "/retrievePassword")
	@ResponseBody
	public ResultDto retrievePassword(User user)  {
		ResultDto resultDto=new ResultDto();
	   List<User> list=userService.getallUser(user);
	   if(null!=list&&list.size()>0) {
		   try {
			EmailUtil.sendMail(user.getEmail(), EmailUtil.systemName+"提醒您,您的密码为"+list.get(0).getPassword());
			 resultDto.setResultCode("200");
			   resultDto.setResultDesc("恭喜您找回密码,请到您的邮箱查看");
		} catch (Exception e) {
			e.printStackTrace();
			resultDto.setResultCode("202");
			   resultDto.setResultDesc("发送邮箱异常");
		}
		  
	   }else {
		   resultDto.setResultCode("201");
		   resultDto.setResultDesc("请检查您输入的信息，您的邮箱找不到");
		   }
	   return resultDto;
	}
	


}
