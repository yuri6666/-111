package com.winit.controller.manage;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("web/manage")
public class IG_WebCommonController {
	
	/**
	 * @return
	 */
	@RequestMapping(value = "/logout")
	public ModelAndView invalidateSession(HttpSession session,ModelAndView view) {
		session.invalidate();
		view.setViewName("login");
		return view;
	}
	
	@RequestMapping(value = "/toUserinfo")
	public ModelAndView toUserinfo(HttpSession session,ModelAndView view) {
		view.setViewName("manage/IG_UserInfo");
		return view;
	}
	@RequestMapping(value = "/toMessage")
	public ModelAndView toMessage(HttpSession session,ModelAndView view) {
		view.setViewName("manage/IG_Message");
		return view;
	}
	@RequestMapping(value = "/toClassInfo")
	public ModelAndView toclassInfo(HttpSession session,ModelAndView view) {
		view.setViewName("manage/IG_Class");
		return view;
	}
	@RequestMapping(value = "/toLevelInfo")
	public ModelAndView toLevelInfo(HttpSession session,ModelAndView view) {
		view.setViewName("manage/IG_Level");
		return view;
	}
	@RequestMapping(value = "/toNeedInfo")
	public ModelAndView toNeedInfo(HttpSession session,ModelAndView view) {
		view.setViewName("manage/IG_Need");
		return view;
	}
	@RequestMapping(value = "/toIncomeInfo")
	public ModelAndView toIncomeInfo(HttpSession session,ModelAndView view) {
		view.setViewName("manage/IG_Income");
		return view;
	}
}
