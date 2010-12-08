/**
 * 
 */

package com.nss.portlet.onedoorprocess.util;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.nss.workflowonedoor.OneDoorProcessLiferayWorkflowService;

public class OneDoorUtil {
	
	/**
	 * Lay danh sach ho so theo userId
	 * Rieng bo phan tiep nhan lay ho so theo Role
	 * @param userId
	 * @return
	 */
	public static List getFilesByUserId(long userId) {
		OneDoorProcessLiferayWorkflowService workflow = new OneDoorProcessLiferayWorkflowService();
		return workflow.getListPmlFilesByUser(userId);
	}
	
	public static List getFilesByUserId(long userId, String type, String valueType) {
		OneDoorProcessLiferayWorkflowService workflow = new OneDoorProcessLiferayWorkflowService();
		return workflow.getListPmlFilesByUser(userId, type, valueType);
	}
	
	public static String getCurrentDate(){
		Date date = new Date();
		int month =date.getMonth()+ 1;
		int year = date.getYear() + 1900;
		return  date.getDate()+"/"+ month  +"/"+ year;
	}
	
	
	public static Date getDate(){
		String[] arr = getCurrentDate().split("/");
		int date = Integer.parseInt(arr[0]);
		int month = Integer.parseInt(arr[1]) - 1;
		int year = Integer.parseInt(arr[2]) - 1900 ;
		return	new Date(year, month, date);
	}
	
	public static void getReturningDate(){
		Calendar.getInstance().roll(Calendar.getInstance().DAY_OF_MONTH, +10);
	}
	
	public static Calendar createCalendarFromDate(Date d) {
		int date = d.getDate();
		int month = d.getMonth();
		int year = d.getYear() + 1900;
		Calendar cal = Calendar.getInstance();
		cal.set(year, month, date);
		return cal;
	}
	
	private static Date getEndDateOfCalendar(Calendar cal) {
		cal.roll(Calendar.DAY_OF_MONTH, +10);
		return cal.getTime();
	}
	
	public static Date getEndDate() {
		Calendar cal = createCalendarFromDate(OneDoorUtil.getDate());
		return getEndDateOfCalendar(cal);
	}
	
	public static void main(String[] args) {
		OneDoorUtil doorUtil = new OneDoorUtil();
		System.out.println(doorUtil.getDate());
		
	}

	/**
	 * Get status of file when know fileId. Use jBpm
	 * @param fileId
	 * @return status
	 */
	public static String getFileStatus(String fileId) {
//		OneDoorProcessLiferayWorkflowService workflow = new OneDoorProcessLiferayWorkflowService();
//		return workflow.getState(fileId);\
		return "dang xu ly";
	}
}
