package com.winit.controller.manage;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.winit.entity.dto.ResultDto;
import com.winit.entity.pojo.Dictionary;
import com.winit.service.DictionaryService;

@RestController
@RequestMapping("/api/dictionary")
public class DictionaryController {
	@Autowired
	private DictionaryService dictionaryService;
	@RequestMapping(value="/getDictionary",method = RequestMethod.POST)
	public ResultDto getDictionary(Dictionary dictionary){
		ResultDto resultDto=new ResultDto();
		List<Dictionary> list = dictionaryService.getDictionary(dictionary);
		if(list.size()>0) {
			resultDto.setResultCode("200");
			resultDto.setData(list);
		}
		return resultDto;
	}
}