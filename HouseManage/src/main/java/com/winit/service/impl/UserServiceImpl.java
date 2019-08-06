package com.winit.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.codehaus.plexus.util.StringUtils;
import org.springframework.stereotype.Service;

import tk.mybatis.mapper.entity.Example;

import com.github.pagehelper.PageHelper;
import com.winit.common.baseclass.ResultUtil;
import com.winit.common.utils.SessionUtil;
import com.winit.entity.dto.ResultDto;
import com.winit.entity.pojo.User;
import com.winit.mapper.UserMapper;
import com.winit.service.UserService;


@Service
public class UserServiceImpl implements UserService{
	
	@Resource
	private UserMapper userMapper;

	@Override
	public List<User> userList(User user) {
		PageHelper.startPage(user.getPage(), user.getRows());
		return userMapper.userList(user);
	}

	@Override
	public List<User> allUser(Integer type) {
		Example example = new Example(User.class);
		return userMapper.selectAll();
	}

	/*@Override
	public User checkRepeat(String username, Integer id) {
		return userMapper.checkRepeat(username, id);
	}
*/
	@Override
	public int updatePwd(String password, Integer id) {
		return userMapper.updatePwd(password, id);
	}

	@SuppressWarnings("null")
	@Override
	public int  save(User user) {
		User u = userMapper.getByUsername(user.getUsername());
		User us=userMapper.getByUserEmail(user.getEmail());
		if(u!=null) {
			return -1;
		}
		if(us!=null) {
			return -2;
		}
		         user.setIsEnable("0");
		         user.setCreateTime(new Date());
			int result=userMapper.insertSelective(user);
			return result;
	}

	@Override
	public int deleteUser(int userId) {
		return userMapper.deleteByPrimaryKey(userId);
	}

	@Override
	public User getByUsername(String username) {
		return userMapper.getByUsername(username);
	}
	
	
	/**
	 * 用户登录
	 */
	public Map<String, Object> userLogin(User user,HttpSession session) {
		Map<String, Object>  map=new HashMap<String,Object>();
		User u = userMapper.getByUsername(user.getUsername());
		if(u != null && u.getPassword().equals(user.getPassword())){
			SessionUtil.setUserDetail(session, u);
			if(StringUtils.equals(u.getIsEnable(), "1")||u.getType()==0) {
				map.put("flag", true);
				map.put("userType", u.getType());	
			}else {
				map.put("flag", false);
				map.put("resultMsg", "还未通过管理员审核，审核通过后才可登录");	
			}
			
		}else{
			map.put("flag", false);
			map.put("resultMsg", "账号或密码输入错误");
		}

		return map;
	}

	@Override
	public List<User> getallUser(User user) {
		// TODO Auto-generated method stub
		return userMapper.getAllUser(user);
	}

	@Override
	public int updateselective(User user) {
		userMapper.updateselective(user);
		return 1;
	}



	@Override
	public ResultDto saveUser(User user) {
		ResultDto resultDto =new ResultDto();
		if(user.getId() != null){
		
			int result=userMapper.updateByPrimaryKeySelective(user);
			if(result>0) {
			resultDto.setResultCode("200");
			resultDto.setResultDesc("修改成功");
			}else {
				resultDto.setResultCode("400");
				resultDto.setResultDesc("修改失败");
			}
		}else {
			User old = userMapper.checkRepeat(user.getUsername());
			if(old != null){
				resultDto.setResultDesc("用户名已存在");
				return resultDto;
			}
			user.setIsEnable("1");//管理员添加用户信息默认通过
            user.setCreateTime(new Date());
			int result=userMapper.insertSelective(user);
			if(result>0) {
				resultDto.setResultCode("200");
				resultDto.setResultDesc("新增成功");
			}else {
				resultDto.setResultCode("400");
				resultDto.setResultDesc("新增失败");
			}
		}
		return resultDto;
	}

	@Override
	public User getUserById(Integer userId) {
		// TODO Auto-generated method stub
		return userMapper.getUserById(userId);
	}

	

}
