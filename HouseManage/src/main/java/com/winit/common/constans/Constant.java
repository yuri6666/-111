package com.winit.common.constans;

public class Constant {
	
	
	public  static enum RESULT_CODE{
		/**
		 * 成功
		 */
		SUCCESS("200"),
		/**
		 * 失败
		 */
		FAIL("400"),
		/**
		 *异常
		 */
		EXCEPTION("500"),
		/**
		 * 没登录
		 */
		NOT_LOGIN("401"),
		/**
		 * 没权限
		 */
		NOT_AUTH("403"),
		/**
		 * 找不到资源
		 */
		ERROR_404("404"),
		/**
		 * 长时间未登录
		 */
		LOGN_TIME_NOT_LOGIN("408"),
		/**
		 * 另一个地方登录(踢出)
		 */
		ANTHER_PLACE_LOGIN("409");
		
		private  String resultCode;
		
		RESULT_CODE(String resultCode){
			this.resultCode=resultCode;
		}

		public String getResultCode() {
			return resultCode;
		}

	
		
	}
	
	/**
	 * 通用的是否状态
	 * 
	 * @author
	 *
	 */
	public static enum GENERAL_WHETHER {
		/**
		 * 1是
		 */
		YES("1"),
		/**
		 * 0否
		 */
		NO("0");

		private String state;

		GENERAL_WHETHER(String state) {
			this.state = state;
		}

		public String getState() {
			return state;
		}
	}
	
	
	public  static enum paystatus{
		/**
		 * 未支付
		 */
		PaymentsDue(0),
		/**
		 * 已支付
		 */
		PaymentsMade(1),
		/**
		 *已接单
		 */
		orderReceived(2),
		/**
		 * 已完成
		 */
		finished(3),
		/**
		 * 已评价
		 */
		assessed(4),
		/**
		 * 解除中
		 */
		canceled(5);
		
		private  int status;
		
		paystatus(int status){
			this.status=status;
		}

		public int getStatus() {
			return status;
		}

		public void setStatus(int status) {
			this.status = status;
		}

		

	
		
	}
	public  static enum isEnable{
		/**
		 * 可见
		 */
		no(0),
		/**
		 * 已支付
		 */
		yes(1);
		
	
		
		private  int status;
		
		isEnable(int status){
			this.status=status;
		}

		public int getStatus() {
			return status;
		}

		public void setStatus(int status) {
			this.status = status;
		}

		

	
		
	}

	public  static enum timeType{
//		
		/**
		 * 年
		 */
		year(1),
		/**
		 * 月
		 */
		quarter(2),
		/**
		 * 
		 */
		month(3),
		/**
		 * 年
		 */
		day(4);
		
		private  int timeType;
		
		public int getTimeType() {
			return timeType;
		}

		timeType(int timeType){
			this.timeType=timeType;
		}


	
	}
	

}
