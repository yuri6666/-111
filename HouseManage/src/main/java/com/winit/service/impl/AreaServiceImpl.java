package com.winit.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.winit.entity.pojo.City;
import com.winit.entity.pojo.County;
import com.winit.entity.pojo.Province;
import com.winit.mapper.AreaMapper;
import com.winit.service.AreaService;

@Service
public class AreaServiceImpl implements AreaService{
	@Resource
	private AreaMapper areaMapper;

	@Override
	public List<Province> getProvince(Province area) {
		List<Province> list= areaMapper.getProvince(area);
		return list;
	}

	@Override
	public List<City> getCity(City city) {
		List<City> list= areaMapper.getCity(city);
		return list;
	}

	@Override
	public List<County> getCounty(County county) {
		List<County> list=areaMapper.getCounty(county);
		return list;
	}

}
