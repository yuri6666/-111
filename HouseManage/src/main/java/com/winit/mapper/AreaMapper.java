package com.winit.mapper;

import java.util.List;


import com.winit.entity.pojo.City;
import com.winit.entity.pojo.County;
import com.winit.entity.pojo.Province;

public interface AreaMapper {

	List<Province> getProvince(Province area);

	List<City> getCity(City city);

	List<County> getCounty(County county);

}
