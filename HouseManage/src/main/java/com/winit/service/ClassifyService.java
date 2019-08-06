package com.winit.service;

import java.util.List;


import com.winit.entity.pojo.Classify;

public interface ClassifyService {



	void delete(Integer id);

	List<Classify> classifyList(Classify classify);

	int save(Classify classify);

	List<Classify> classifyALL(Classify classify);


	
}
