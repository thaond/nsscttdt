package com.sgs.portlet.holiday_calendar.uitl;

import java.sql.Timestamp;
import java.util.Date;

public class Constants {
	public static final String DEPARTMENT_SEPERATOR = "#";
	public static final String USER_SEPERATOR = "#";
	public static final int HOUR_WORK_IN_DAY = 8;
	
	public static String getDateTime() {
		String result = "";
		Date dateCurrent = new Date();			
	    Timestamp timestamp = new Timestamp(dateCurrent.getTime());
	    result = timestamp.toString();	   
	    result = result.replaceAll("-", "");
	    result = result.replaceAll(" ", "");
	    result = result.replaceAll(":", "");
	    result = result.substring(0, result.indexOf("."));
		return result;
	}
	public static void main(String[] args) {
		
		System.out.println(Constants.getDateTime());
	}
}
