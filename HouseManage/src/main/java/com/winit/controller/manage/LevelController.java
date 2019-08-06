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
import com.winit.entity.pojo.Level;
import com.winit.service.LevelService;

@RestController
@RequestMapping("/api/level")
public class LevelController {

	@Autowired
	private LevelService levelService;
	
	@RequestMapping(value="/geLevelList",method = RequestMethod.POST)
	public ResultDto list(Level level){
		PageDto<Level> pageDto = new PageDto<Level>();
		List<Level> list = levelService.levelList(level);
		PageInfo<Level> page = new PageInfo<Level>(list);
		pageDto.setTotal(page.getTotal());
		pageDto.setResult(list);
		return ResultUtil.success(pageDto, null);
	}
	@RequestMapping(value="/getAll",method = RequestMethod.POST)
	public ResultDto getAll(Level level){
		ResultDto resultDto=new ResultDto();
		List<Level> list = levelService.levelALL(level);
		if(list.size()>0) {
			resultDto.setResultCode("200");
			resultDto.setData(list);
		}
		return resultDto;
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ResultDto save(Level level){
		levelService.save(level);
		return ResultUtil.success("保存成功");
	}
	
	@RequestMapping(value="/delete", method = RequestMethod.POST)
	public ResultDto delete(Level level){
		List<Level> list = levelService.levelList(level);
		if(list.size()>0) {
			levelService.delete(level.getId());
			 return ResultUtil.success("删除成功"); 
		}else {
			   return ResultUtil.fail("无法删除");  
		   }
	
			
}
	@RequestMapping(value = "/updateselective", method = RequestMethod.POST)
	public ResultDto updateselective(Level level){
		   ResultDto resultdto =new ResultDto();
           int result= levelService.updateselective(level);
          if(result>0) {
        	  resultdto.setResultCode("200");
        	  resultdto.setResultDesc("成功");
          }else { 
            	  resultdto.setResultCode("400");
            	  resultdto.setResultDesc("后台报错");
          }
          return resultdto;
	}
}
