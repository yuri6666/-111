package com.winit.mapper;

import java.util.List;

import com.winit.common.baseclass.MyMapper;
import com.winit.entity.pojo.Need;

public interface NeedMapper extends MyMapper<Need>{

	List<Need> needList(Need need);

	void deletebyId(Integer id);

	List<Need> getAll(Need need);

	void updateSelective(Need need);

	void updateServer(Need need);

}
