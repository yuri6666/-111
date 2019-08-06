package com.winit.entity.pojo;

import java.util.Date;

import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Table(name = "neednurse")
public class NeedNurse extends BaseEntity{

	private Integer nurseId;
	
	private Integer needId;
	  @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date createTime;

	public Integer getNurseId() {
		return nurseId;
	}

	public void setNurseId(Integer nurseId) {
		this.nurseId = nurseId;
	}

	public Integer getNeedId() {
		return needId;
	}

	public void setNeedId(Integer needId) {
		this.needId = needId;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	
	
}
