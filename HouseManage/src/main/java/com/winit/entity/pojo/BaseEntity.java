package com.winit.entity.pojo;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import com.winit.common.utils.SimpleGenId;

import tk.mybatis.mapper.annotation.KeySql;


/**
 * 基础信息
 */
public class BaseEntity{

	@Id
    @Column(name = "id")
    @KeySql(genId = SimpleGenId.class)
    private Integer id;
	/**
	 * 页码
	 */
    @Transient
    private Integer page = 1;

    @Transient
    private Integer rows = 10;
    
    @Transient
    private String sort;
    @Transient
    private String order;
    
    
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getRows() {
		return rows;
	}
	public void setRows(Integer rows) {
		this.rows = rows;
	}
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
	public String getOrder() {
		return order;
	}
	public void setOrder(String order) {
		this.order = order;
	}
    
    
}
