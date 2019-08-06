package com.winit.service;

import java.util.List;

import com.winit.entity.pojo.NeedNurse;

public interface NeedNurseService {

	int save(NeedNurse nd);

	List<NeedNurse> selective(NeedNurse nd);

	  
}
