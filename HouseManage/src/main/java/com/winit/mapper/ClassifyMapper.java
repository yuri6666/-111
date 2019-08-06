package com.winit.mapper;

import java.util.List;

import com.winit.common.baseclass.MyMapper;
import com.winit.entity.pojo.Classify;

public interface ClassifyMapper extends MyMapper<Classify>{

	List<Classify> classifyList(Classify classify);

	void deletebyId(Integer id);

	List<Classify> getAll(Classify classify);

}
