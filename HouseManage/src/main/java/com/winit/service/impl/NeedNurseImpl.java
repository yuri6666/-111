package com.winit.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.winit.entity.pojo.Need;
import com.winit.entity.pojo.NeedNurse;
import com.winit.mapper.NeedNurseMapper;
import com.winit.service.NeedNurseService;
@Service
public class NeedNurseImpl implements NeedNurseService{
	@Resource
	private NeedNurseMapper ndMapper;
	@Override
	public int save(NeedNurse nd) {
		nd.setCreateTime(new Date());
		return ndMapper.insertSelective(nd);
	}

	@Override
	public List<NeedNurse> selective(NeedNurse nd) {
		List<NeedNurse> list=ndMapper.getAll(nd);
		return list;
	}

}
