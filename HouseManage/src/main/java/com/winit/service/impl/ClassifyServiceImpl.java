package com.winit.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.winit.entity.pojo.Classify;
import com.winit.mapper.ClassifyMapper;
import com.winit.service.ClassifyService;

@Service
public class ClassifyServiceImpl implements ClassifyService {

	@Resource
	private ClassifyMapper classifyMapper;
	@Override
	public List<Classify> classifyList(Classify classify) {
		PageHelper.startPage(classify.getPage(),classify.getRows());
		return classifyMapper.classifyList(classify);
	}

	@Override
	public int save(Classify classify) {
		if(classify.getId()!=null) {
			return classifyMapper.updateByPrimaryKeySelective(classify);
		}
		 classify.setCreateTime(new Date());
		return classifyMapper.insertSelective(classify);
	}
      
	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		classifyMapper.deletebyId(id);
	}

	@Override
	public List<Classify> classifyALL(Classify classify) {
		List<Classify> list=classifyMapper.getAll(classify);
		return list;
	}
	
	
}
