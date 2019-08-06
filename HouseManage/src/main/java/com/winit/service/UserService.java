package com.winit.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.winit.common.baseclass.PageDto;
import com.winit.entity.dto.ResultDto;
import com.winit.entity.pojo.User;

public interface UserService {
	
	List<User> userList(User user);
	
	List<User> allUser(Integer type);
	
	int updatePwd(String password, Integer id);
	
	int save(User user);
	
	int deleteUser(int userId);
	
	User getByUsername(String username);
	
	Map<String, Object> userLogin(User user,HttpSession session);

	List<User> getallUser(User user);

	int updateselective(User user);

	ResultDto saveUser(User user);
	
	User getUserById(Integer userId);
}
