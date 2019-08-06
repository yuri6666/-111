package com.winit.entity.pojo;

import java.util.Date;

import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Table(name = "levels")
public class Level extends BaseEntity {

	  private String name;
	  @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
      private Date createTime;
      
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

  
}