package com.winit.entity.pojo;

import javax.persistence.Table;

@Table(name = "province")

public class Province extends BaseEntity{
	
      private String provinceCode;

      
      private String name;

	public String getProvinceCode() {
		return provinceCode;
	}

	public void setProvinceCode(String provinceCode) {
		this.provinceCode = provinceCode;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
      
      
	
}
