package com.winit.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.winit.common.constans.Constant;
import com.winit.entity.pojo.Message;
import com.winit.entity.pojo.Need;
import com.winit.mapper.NeedMapper;
import com.winit.service.NeedService;

@Service
public class NeedServiceImpl implements NeedService {

	@Resource
	private NeedMapper needMapper;
	@Override
	public List<Need> needList(Need need) {
		PageHelper.startPage(need.getPage(),need.getRows());
		return needMapper.needList(need);
	}

	@Override
	public int save(Need need) {
		if(need.getId()!=null) {
			return needMapper.updateByPrimaryKeySelective(need);
		}
		need.setCreateTime(new Date());
		need.setStatus(Constant.paystatus.PaymentsDue.getStatus());
		need.setIsEnable(Constant.isEnable.no.getStatus());
		return needMapper.insertSelective(need);
	}
      
	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		needMapper.deletebyId(id);
	}

	@Override
	public List<Need> needALL(Need need) {
		List<Need> list=needMapper.getAll(need);
		return list;
	}
	
	@Override
	public int updateselective(Need need) {
		needMapper.updateSelective(need);	
		return 1;
	}
	@Override
	public int updateServer(Need need) {
		needMapper.updateServer(need);	
		return 1;
	}
	
}
