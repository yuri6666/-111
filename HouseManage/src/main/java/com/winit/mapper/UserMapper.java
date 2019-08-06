package com.winit.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.winit.common.baseclass.MyMapper;
import com.winit.entity.pojo.User;

public interface UserMapper extends MyMapper<User>{

	List<User> userList(User user);
	
	User checkRepeat(@Param("username") String username);
	
	int updatePwd(@Param("password") String password, @Param("id") Integer id);
	
	User getByUsername(String username);

	List<User> getAllUser(User user);

	void updateselective(User user);

	User getUserById(Integer userId);

	User getByUserEmail(String email);
}
