package com.winit.entity.pojo;

import javax.persistence.Table;

@Table(name = "area")
public class County extends BaseEntity{

	 private String name;
	 
	 private String areaCode;
	 
	 private String cityCode;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	public String getCityCode() {
		return cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}


	 
	 
}
