package com.winit.service;

import java.util.List;


import com.winit.entity.pojo.Need;

public interface NeedService {



	void delete(Integer id);

	List<Need> needList(Need need);

	int save(Need need);

	List<Need> needALL(Need need);

	int updateselective(Need need);

	int updateServer(Need need);


	
}

