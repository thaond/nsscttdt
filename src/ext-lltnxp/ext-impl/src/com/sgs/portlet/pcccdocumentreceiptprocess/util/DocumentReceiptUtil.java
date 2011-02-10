package com.sgs.portlet.pcccdocumentreceiptprocess.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;

import com.sgs.portlet.holiday.service.PmlHolidayLocalServiceUtil;

public class DocumentReceiptUtil {
	
	private final static Logger log = Logger.getLogger(DocumentReceiptUtil.class);
	
	public Date getExpectedReturningDate(String numberDate, String dateReceipt) {
		
		int numberDateIncrement = PmlHolidayLocalServiceUtil.checkDateHoliday(dateReceipt, Integer.parseInt(numberDate));

		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		long receipt = (Long.parseLong(numberDate) + numberDateIncrement) * 24 * 60 * 60 * 1000;
		long numberDateReturn = 0;
		Date returnDate = null;
		
		try {
			numberDateReturn = receipt + dateFormat.parse(dateReceipt).getTime();
			returnDate = new Date(numberDateReturn);
		} catch (Exception e) {
			log.error("ERROR: in method getExpectedReturningDate() " + DocumentReceiptUtil.class);
		}
		
		return returnDate;
	}
	
	public String getNumDateProcess(String dateReceipt, String expireDate) {
		
		String dateNumberProcess = "0";
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		if (dateReceipt.length() != dateFormat.toPattern().length() || 
				expireDate.length() != dateFormat.toPattern().length()) {
			return dateNumberProcess;
		}
		
		int totalDateOffRes = PmlHolidayLocalServiceUtil.checkDateHolidayWithTwoDays(dateReceipt, expireDate);
		
		try {
			Date dateNow = dateFormat.parse(dateReceipt);
			long totalDateProcessCalenResDis = (dateFormat.parse(expireDate)).getTime() - dateNow.getTime();
			dateNumberProcess = String.valueOf(totalDateProcessCalenResDis/(1000*60*60*24) - totalDateOffRes);
		} catch (ParseException e) {
			log.error("ERROR: in method getNumDateProcess() " + DocumentReceiptUtil.class);
		}
		
		return dateNumberProcess;
	}

}
