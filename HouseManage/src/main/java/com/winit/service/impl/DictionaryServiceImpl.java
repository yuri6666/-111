package com.winit.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.winit.entity.pojo.Dictionary;
import com.winit.mapper.DictionaryMapper;
import com.winit.service.DictionaryService;
@Service
public class DictionaryServiceImpl implements DictionaryService {
	@Resource
	private DictionaryMapper dicMapper;

	@Override
	public List<Dictionary> getDictionary(Dictionary dictionary) {
		List<Dictionary> list= dicMapper.getDictionary(dictionary);
		return list;
	}
}
