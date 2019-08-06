package com.winit.mapper;

import java.util.List;

import com.winit.common.baseclass.MyMapper;
import com.winit.entity.pojo.Level;

public interface LevelMapper extends MyMapper<Level>{

	List<Level> levelList(Level level);

	void deletebyId(Integer id);

	List<Level> getAll(Level level);

	void updateSelective(Level level);

}
