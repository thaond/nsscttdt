package com.sgs.portlet.onedoorpcccprocess.util;

import net.sourceforge.rtf.RTFUtil;
import net.sourceforge.rtf.template.IContext;
/**
 * 
 * @author yenlt
 *
 */
public class InBienNhanUtil extends RTFUtil{

	private String day;
	private String month;
	private String year;
	private String receiptNumber;
	private String hour;
	private String minutes;
	private String address;
	private String represent;
	private String receive;
	private int processTime;
	private String appRepresent;
	
	
	public InBienNhanUtil(String outDirectory) {
		super(outDirectory);
	}

	
	public InBienNhanUtil(String outDirectory, String day, String month,
			String year, String receiptNumber, String appRepresent, String hour, String minutes, String address,
			String represent, String receive, int processTime) {
		super(outDirectory);
		this.day = day;
		this.month = month;
		this.year = year;
		this.receiptNumber = receiptNumber;
		this.appRepresent = appRepresent;
		this.hour = hour;
		this.minutes = minutes;
		this.address = address;
		this.represent = represent;
		this.receive = receive;
		this.processTime = processTime;
	}

	@Override
	protected void putContext(IContext iContext) {
		iContext.put("day", this.day);
		iContext.put("month", this.month);
		iContext.put("year", this.year);
		iContext.put("receiptNumber", this.receiptNumber);
		iContext.put("appRepresent", this.appRepresent);
		iContext.put("hour", this.hour);
		iContext.put("minutes", this.minutes);
		iContext.put("address", this.address);
		iContext.put("represent", this.represent);
		iContext.put("receive", this.receive);
		iContext.put("processTime", this.processTime);
		
	}

}
