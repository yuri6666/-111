package com.winit.common.baseclass;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtil {

	public static String format(Date time){
		String pattern = "yyyy-MM-dd HH:mm:ss";
		return format(time, pattern);
	}
	
	public static String format(Date time, String pattern){
		SimpleDateFormat format = new SimpleDateFormat(pattern);
		return format.format(time);
	}
	
	public static Date formatToDate(String time){
		String pattern = "yyyy-MM-dd HH:mm:ss";
		SimpleDateFormat format = new SimpleDateFormat(pattern);
		try {
			return format.parse(time);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
}
