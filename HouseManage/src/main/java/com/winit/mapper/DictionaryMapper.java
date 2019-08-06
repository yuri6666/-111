package com.winit.mapper;

import java.util.List;

import com.winit.common.baseclass.MyMapper;
import com.winit.entity.pojo.Dictionary;

public interface DictionaryMapper extends MyMapper<Dictionary>{

	List<Dictionary> getDictionary(Dictionary dictionary);

}
