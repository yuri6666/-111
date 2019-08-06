package com.winit.controller.manage;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.winit.entity.dto.ResultDto;
import com.winit.entity.pojo.City;
import com.winit.entity.pojo.County;
import com.winit.entity.pojo.Province;
import com.winit.service.AreaService;


@RestController
@RequestMapping("/api/area")
public class AreaController {
	@Autowired
	private AreaService areaService;
	@RequestMapping(value="/getProvince",method = RequestMethod.POST)
	public ResultDto getProvince(Province province){
		ResultDto resultDto=new ResultDto();
		List<Province> list = areaService.getProvince(province);
		if(list.size()>0) {
			resultDto.setResultCode("200");
			resultDto.setData(list);
		}
		return resultDto;
	}
	@RequestMapping(value="/getCity",method = RequestMethod.POST)
	public ResultDto getCity(City city){
		ResultDto resultDto=new ResultDto();
		List<City> list = areaService.getCity(city);
		if(list.size()>0) {
			resultDto.setResultCode("200");
			resultDto.setData(list);
		}
		return resultDto;
	}
	@RequestMapping(value="/getCounty",method = RequestMethod.POST)
	public ResultDto getCounty(County county){
		ResultDto resultDto=new ResultDto();
		List<County> list = areaService.getCounty(county);
		if(list.size()>0) {
			resultDto.setResultCode("200");
			resultDto.setData(list);
		}
		return resultDto;
	}
}
