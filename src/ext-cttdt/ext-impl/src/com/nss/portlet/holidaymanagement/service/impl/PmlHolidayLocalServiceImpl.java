package com.nss.portlet.holidaymanagement.service.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.liferay.portal.SystemException;
import com.nss.portlet.holidaymanagement.model.PmlHoliday;
import com.nss.portlet.holidaymanagement.service.base.PmlHolidayLocalServiceBaseImpl;

public class PmlHolidayLocalServiceImpl extends PmlHolidayLocalServiceBaseImpl {
public Date getExpextedRetrningDateByDateArrive (Date dateArrive, int numProcessDate) {
		
		String DATE_FORMAT = "dd/MM/yyyy";
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		Calendar cal=Calendar.getInstance();
		cal.setTime(dateArrive);
		Date retValue = cal.getTime();
		
		List<Date> listDateHoliday = getListDate(dateArrive);
		
		for (int i = 0; i < numProcessDate; i++) {
			cal.add(cal.DATE, 1);
			if (listDateHoliday.contains(cal)) {
				retValue = cal.getTime();
			}
		}
		return retValue;
	}
	
	private List<Date> getListDate(Date dateArrive) {
		
		List<Date> retValue = new ArrayList<Date>();
		List<Date> listDateByHolidayValue = getListDateByHolidaySpecialDate();
		List<Date> listSaturday = getListSaturday(dateArrive);
		List<Date> listSunday = getListSunday(dateArrive);
		
		retValue.addAll(listDateByHolidayValue);
		retValue.addAll(listSaturday);
		retValue.addAll(listSunday);
	
		return retValue;
	}
	
	private List<Date> getListDateByHolidaySpecialDate() {
		
		List<Date> retValue = new ArrayList<Date>();
		List<PmlHoliday> listHolidaySpecial = null;
		
		String holidayTypeSpecial = "Holiday";
		String holidayValue = "";
		
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		Date date = null;
		
		try {
			listHolidaySpecial = pmlHolidayPersistence.findByHoliday_Type(holidayTypeSpecial);
			for (PmlHoliday item : listHolidaySpecial) {
				holidayValue = item.getHoliday_value();
				date = df.parse(holidayValue);
				retValue.add(date);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}

		return retValue;
	}
	
	private List<Date> getListSaturday (Date dateArrive) {
		
		List<Date> retValue = new ArrayList<Date>();
		List<PmlHoliday> listHoliday = null;
		Calendar calArrive = Calendar.getInstance();
		Calendar calSaturday = Calendar.getInstance();
		Date saturday = null;
		calArrive.setTime(dateArrive);
		
		Date fromDate = null;
		Date toDate = null;
		
		String DATE_FORMAT = "dd/MM/yyyy";
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		
		// lay ngay thu 7 trong tuan dua tren ngay nhan
		calSaturday.setTime(dateArrive);
		int d1 = calSaturday.DATE;
		int d2 = calSaturday.SATURDAY;
		calSaturday.add(calSaturday.DATE, (d2 - d1));
		
		try {
			listHoliday = pmlHolidayPersistence.findByHolidayType_HolidayValue("Day Of Week", "Saturday");
			
			if (listHoliday != null) {
				for (PmlHoliday pmlHoliday : listHoliday) {
					if (pmlHoliday.getFrom_date() != null && pmlHoliday.getTo_date() != null) {
						// change fromDate and toDate to date format dd/MM/yyyy 
						fromDate = df.parse(sdf.format(pmlHoliday.getFrom_date()));
						toDate = df.parse(sdf.format(pmlHoliday.getTo_date()));
						
						if (dateArrive.after(fromDate) && dateArrive.before(toDate)) {
							// change saturday to format dd/MM/yyyy
							saturday = df.parse(sdf.format(calSaturday.getTime()));
							
							// change saturday from Date type to Calendar
							calSaturday.setTime(saturday);
							
							while (saturday.before(toDate)) {
								retValue.add(saturday);
								
								// di chuyen ngay thu 7 di bay ngay
								calSaturday.add(calSaturday.DATE, 7);
							}
						}
					}
				}
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return retValue;
	}
	
	private List<Date> getListSunday (Date dateArrive) {
		
		List<Date> retValue = new ArrayList<Date>();
		List<PmlHoliday> listHoliday = null;
		Calendar calArrive = Calendar.getInstance();
		Calendar calSunday = Calendar.getInstance();
		Date sunday = null;
		calArrive.setTime(dateArrive);
		
		Date fromDate = null;
		Date toDate = null;
		
		String DATE_FORMAT = "dd/MM/yyyy";
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		
		// lay ngay thu 7 trong tuan dua tren ngay nhan
		calSunday.setTime(dateArrive);
		int d1 = calSunday.DATE;
		int d2 = calSunday.SUNDAY;
		calSunday.add(calSunday.DATE, (d2 - d1));
		
		try {
			listHoliday = pmlHolidayPersistence.findByHolidayType_HolidayValue("Day Of Week", "Sunday");
			
			if (listHoliday != null) {
				for (PmlHoliday pmlHoliday : listHoliday) {
					if (pmlHoliday.getFrom_date() != null && pmlHoliday.getTo_date() != null) {
						// change fromDate and toDate to date format dd/MM/yyyy 
						fromDate = df.parse(sdf.format(pmlHoliday.getFrom_date()));
						toDate = df.parse(sdf.format(pmlHoliday.getTo_date()));
						
						if (dateArrive.after(fromDate) && dateArrive.before(toDate)) {
							// change saturday to format dd/MM/yyyy
							sunday = df.parse(sdf.format(calSunday.getTime()));
							
							// change saturday from Date type to Calendar
							calSunday.setTime(sunday);
							
							while (sunday.before(toDate)) {
								retValue.add(sunday);
								
								// di chuyen ngay thu 7 di bay ngay
								calSunday.add(calSunday.DATE, 7);
							}
						}
					}
				}
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return retValue;
	}
	
	public int countHolidayByValue(String holidayValue) throws SystemException {
		int result = 0;
		
		try {
			result = pmlHolidayPersistence.countByHoliday_Value(holidayValue);
		} catch (Exception ex) {
		}
		return result;
	}
	
}
