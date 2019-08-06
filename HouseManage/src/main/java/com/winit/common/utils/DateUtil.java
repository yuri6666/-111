package com.winit.common.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
public class DateUtil {
	public static Date StringToDate(String stringDate ,String formatStyle){
		SimpleDateFormat simpledateformat = new SimpleDateFormat(formatStyle);
		try {
			return simpledateformat.parse(stringDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static String DateToString(Date date,String formatStyle){
		SimpleDateFormat simpledateformat = new SimpleDateFormat(formatStyle);
		return simpledateformat.format(date);
	}
	
	public static Date DateToDate(Date date,String formatStyle){
		SimpleDateFormat dateFormater = new SimpleDateFormat(formatStyle);
		String dateStr = dateFormater.format(date);
		Date ss = null;
		try {
			ss = dateFormater.parse(dateStr);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ss;
	}

   public static  int[]  getDateLength(String  fromDate, String  toDate)  { 
	   String from = "";
	   String to = "";
	   String [] ss_fromDate = fromDate.split("-");
	   String [] ss_toDate = toDate.split("-");
	   	  for(String ss_f :ss_fromDate){
	   		from+=ss_f;
	   	  }
	   	  for(String ss_t :ss_toDate){
	   		to+=ss_t;
	   	  }
	      Calendar  c1  =  getCal(from); 
	      Calendar  c2  =  getCal(to); 
	      int[]  p1  =  {  c1.get(Calendar.YEAR), c1.get(Calendar.MONTH), c1.get(Calendar.DAY_OF_MONTH)  }; 
	      int[]  p2  =  {  c2.get(Calendar.YEAR), c2.get(Calendar.MONTH), c2.get(Calendar.DAY_OF_MONTH)  }; 
	      return  new  int[]  {  p2[0]  -  p1[0], p2[0]  *  12  +  p2[1]  -  p1[0]  *  12  -  p1[1], (int)  ((c2.getTimeInMillis()  -  c1.getTimeInMillis())  /  (24  *  3600  *  1000))  }; 
	   } 
   public  static  Calendar  getCal(String  date)  { 
	      Calendar  cal  =  Calendar.getInstance(); 
	      cal.clear(); 
	      cal.set(Integer.parseInt(date.substring(0, 4)), Integer.parseInt(date.substring(4, 6))  -  1, Integer.parseInt(date.substring(6, 8))); 
	      return  cal; 
	   } 
   /**
    * 时间比较
    * @param dt1
    * @param dt2
    * @return
    */
	public static int compareDate(Date dt1,Date dt2){
        if (dt1.getTime() > dt2.getTime()) {
            System.out.println("dt1 在dt2时间后");
            return 1;
        } else if (dt1.getTime() < dt2.getTime()) {
            System.out.println("dt1在dt2前");
            return -1;
        } else {//相等
            return 0;
        }
	}
	
	//[start] 获取指定日期前一天
	public static String getSpecifiedDayBefore(String specifiedDay){
		Calendar c = Calendar.getInstance();
		Date date = null;
		try{
			date = new SimpleDateFormat("yy-MM-dd").parse(specifiedDay);
		}catch(ParseException e){
			e.printStackTrace();
		}
		c.setTime(date);
		int day = c.get(Calendar.DATE);
		c.set(Calendar.DATE, day - 1);
		String dayBefore = new SimpleDateFormat("yyyy-MM-dd").format(c.getTime());
		return dayBefore;
	}
	//[end]
	
	//[start] 获取指定日期当前月的第一天
	public static String getFirstDayOfGivenMonth(String dateStr, String format){
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		try{
			Date date = sdf.parse(dateStr);
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			calendar.set(Calendar.DAY_OF_MONTH, 1);
			calendar.add(Calendar.MONTH, 0);
			return sdf.format(calendar.getTime());
		}catch(ParseException e){
			e.printStackTrace();
		}
		return null;
	}
	
	public static void main(String[] args) {
		String date = "2019-02-22";
		
		System.out.println(DateUtil.StringToDate(date, "yyyy-MM-dd"));
	}
	
	//[end]
}
