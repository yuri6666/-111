package com.winit.service;

import java.util.List;

import com.winit.entity.pojo.City;
import com.winit.entity.pojo.County;
import com.winit.entity.pojo.Province;

public interface AreaService {

	List<Province> getProvince(Province area);


	List<City> getCity(City city);


	List<County> getCounty(County county);

}
