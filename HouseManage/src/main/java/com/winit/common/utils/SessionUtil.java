package com.winit.common.utils;

import javax.servlet.http.HttpSession;

import com.winit.entity.pojo.User;


public class SessionUtil {

	 public static void setUserDetail(HttpSession session,User cspUser) {
		 session.setAttribute("cspUser",cspUser);
	 }
     public static User getUserDetail(HttpSession session) {
			return  (User) session.getAttribute("cspUser");
	 }


	

}
