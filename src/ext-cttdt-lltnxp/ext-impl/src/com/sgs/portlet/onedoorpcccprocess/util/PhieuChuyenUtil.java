package com.sgs.portlet.onedoorpcccprocess.util;

import net.sourceforge.rtf.RTFUtil;
import net.sourceforge.rtf.template.IContext;

public class PhieuChuyenUtil  extends RTFUtil{
	private String day;
	private String month;
	private String year;
	private String receiptNumber;
	private String hour;
	private String minutes;
	private String address;
	private String represent;
	private int processTime;
	private String departmentReceive;

	public PhieuChuyenUtil(String outDirectory) {
		super(outDirectory);
		
	}

	public PhieuChuyenUtil(String outDirectory, String day, String month,
			String year, String receiptNumber, String hour, String minutes, String address,
			String represent, int processTime, String departmentReceive) {
		super(outDirectory);
		this.day = day;
		this.month = month;
		this.year = year;
		this.receiptNumber = receiptNumber;
		this.hour = hour;
		this.minutes = minutes;
		this.address = address;
		this.represent = represent;
		this.processTime = processTime;
		this.departmentReceive = departmentReceive;
	}

	@Override
	protected void putContext(IContext iContext) {
		iContext.put("day", this.day);
		iContext.put("month", this.month);
		iContext.put("year", this.year);
		iContext.put("receiptNumber", this.receiptNumber);
		iContext.put("hour", this.hour);
		iContext.put("minutes", this.minutes);
		iContext.put("address", this.address);
		iContext.put("represent", this.represent);
		iContext.put("processTime", this.processTime);
		iContext.put("departmentReceive", this.departmentReceive);
		
	}

}
