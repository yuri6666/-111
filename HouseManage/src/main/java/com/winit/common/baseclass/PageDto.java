package com.winit.common.baseclass;

import java.io.Serializable;
import java.util.List;

/**
 * 分页参数
 * @author 
 *
 */
public class PageDto<T> implements Serializable{

	private static final long serialVersionUID = 1L;

	public static final Integer default_page_size = 10;
	
	/**
	 * 页码，从1开始
	 */
	private Integer page = 1;
	
	/**
	 * 每页条数
	 */
	private Integer rows = 10;
	
	/**
	 * 排序方式，例如：按 销量（或价格、评论数等）排序
	 * 枚举值，由具体业务决定
	 * 后台使用时，必须对其校验，避免sql注入
	 */
	private String sort;
	
	/**
	 * 总数
	 */
	private Long total;
	
	/**
	 * 分页结果
	 */
	private List<T> result;

	public PageDto() {
		
	}
	
	public PageDto(List<T> result, Long total) {
		super();
		this.total = total;
		this.result = result;
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

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

	public List<T> getResult() {
		return result;
	}

	public void setResult(List<T> result) {
		this.result = result;
	}
	
	
}
