package com.winit.entity.dto;



/**
 * 查询结果
 * @author wj
 *
 */
public class ResultDto implements java.io.Serializable{

	private static final long serialVersionUID = 8041992411161251934L;
	/**
	 * 返回代码
	 */
	private String resultCode;
	
	/**返回描述
	 * 
	 */
	private String resultDesc;

	/**
	 * 返回对象
	 */
	private Object data;
	
	
	public ResultDto(){}
	

	public ResultDto(String resultCode, String resultDesc) {
		super();
		this.resultCode = resultCode;
		this.resultDesc = resultDesc;
	}

	public ResultDto(String resultCode, Object data) {
		super();
		this.resultCode = resultCode;
		this.data = data;
	}


	public ResultDto(String resultCode, String resultDesc, Object data) {
		super();
		this.resultCode = resultCode;
		this.resultDesc = resultDesc;
		this.data = data;
	}
	
	public ResultDto(String resultCode, Object data, String resultDesc) {
		super();
		this.resultCode = resultCode;
		this.data = data;
		this.resultDesc = resultDesc;
	}


	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}


	public String getResultCode() {
		return resultCode;
	}


	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}


	public String getResultDesc() {
		return resultDesc;
	}


	public void setResultDesc(String resultDesc) {
		this.resultDesc = resultDesc;
	}

	
	
	
	
	
}
