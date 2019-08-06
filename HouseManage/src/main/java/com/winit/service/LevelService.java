package com.winit.service;

import java.util.List;


import com.winit.entity.pojo.Level;

public interface LevelService {



	void delete(Integer id);

	List<Level> levelList(Level level);

	int save(Level level);

	List<Level> levelALL(Level level);

	int updateselective(Level level);


	
}
