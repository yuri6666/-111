package com.winit.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.winit.entity.pojo.Level;
import com.winit.mapper.LevelMapper;
import com.winit.service.LevelService;

@Service
public class LevelServiceImpl implements LevelService {

	@Resource
	private LevelMapper levelMapper;
	@Override
	public List<Level> levelList(Level level) {
		PageHelper.startPage(level.getPage(),level.getRows());
		return levelMapper.levelList(level);
	}

	@Override
	public int save(Level level) {
		if(level.getId()!=null) {
			return levelMapper.updateByPrimaryKeySelective(level);
		}
		 level.setCreateTime(new Date());
		return levelMapper.insertSelective(level);
	}
      
	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		levelMapper.deletebyId(id);
	}

	@Override
	public List<Level> levelALL(Level level) {
		List<Level> list=levelMapper.getAll(level);
		return list;
	}

	@Override
	public int updateselective(Level level) {
		levelMapper.updateSelective(level);
		return 1;
	}
	
	
}
