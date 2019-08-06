package com.winit.entity.pojo;

import javax.persistence.Table;

@Table(name = "city")
public class City extends BaseEntity{

	 private String cityCode;
	 
	 private String name;
	 
	 private String provinceCode;

	public String getCityCode() {
		return cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProvinceCode() {
		return provinceCode;
	}

	public void setProvinceCode(String provinceCode) {
		this.provinceCode = provinceCode;
	}


	 
	 
}
