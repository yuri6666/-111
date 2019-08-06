package com.winit.entity.pojo;

import java.util.Date;

import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

@Table(name = "messages")
public class Message extends BaseEntity {

	  private String title;
	  
      private String content;
      @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
  	  @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
      private Date createTime;
      @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
  	  @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
      private Date releaseTime;
      
      private Integer isEnable;
      
   
      
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getReleaseTime() {
		return releaseTime;
	}

	public void setReleaseTime(Date releaseTime) {
		this.releaseTime = releaseTime;
	}

	public Integer getIsEnable() {
		return isEnable;
	}

	public void setIsEnable(Integer isEnable) {
		this.isEnable = isEnable;
	}




	
	  
	  
}
