package com.winit.mapper;

import java.util.List;

import com.winit.common.baseclass.MyMapper;

import com.winit.entity.pojo.NeedNurse;

public interface NeedNurseMapper extends MyMapper<NeedNurse> {


	List<NeedNurse> getAll(NeedNurse nd);
}
