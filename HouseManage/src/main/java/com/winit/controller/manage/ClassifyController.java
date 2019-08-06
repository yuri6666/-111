package com.winit.controller.manage;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.winit.common.baseclass.PageDto;
import com.winit.common.baseclass.ResultUtil;
import com.winit.entity.dto.ResultDto;
import com.winit.entity.pojo.Classify;
import com.winit.service.ClassifyService;

@RestController
@RequestMapping("/api/classify")
public class ClassifyController {

	@Autowired
	private ClassifyService classifyService;
	
	@RequestMapping(value="/geClassifyList",method = RequestMethod.POST)
	public ResultDto list(Classify classify){
		PageDto<Classify> pageDto = new PageDto<Classify>();
		List<Classify> list = classifyService.classifyList(classify);
		PageInfo<Classify> page = new PageInfo<Classify>(list);
		pageDto.setTotal(page.getTotal());
		pageDto.setResult(list);
		return ResultUtil.success(pageDto, null);
	}
	@RequestMapping(value="/getAll",method = RequestMethod.POST)
	public ResultDto getAll(Classify classify){
		ResultDto resultDto=new ResultDto();
		List<Classify> list = classifyService.classifyALL(classify);
		if(list.size()>0) {
			resultDto.setResultCode("200");
			resultDto.setData(list);
		}
		return resultDto;
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ResultDto save(Classify classify){
		classifyService.save(classify);
		return ResultUtil.success("保存成功");
	}
	
	@RequestMapping(value="/delete", method = RequestMethod.POST)
	public ResultDto delete(Classify classify){
		List<Classify> list = classifyService.classifyList(classify);
		if(list.size()>0) {
			classifyService.delete(classify.getId());
			 return ResultUtil.success("删除成功"); 
		}else {
			   return ResultUtil.fail("无法删除");  
		   }
	
			
}
}

