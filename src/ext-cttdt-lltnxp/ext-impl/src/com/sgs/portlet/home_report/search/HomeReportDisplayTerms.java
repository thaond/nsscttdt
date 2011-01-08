package com.sgs.portlet.home_report.search;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.portlet.RenderRequest;

import com.liferay.portal.kernel.dao.search.DisplayTerms;
import com.liferay.portal.kernel.util.ParamUtil;

public class HomeReportDisplayTerms extends DisplayTerms {

	public static final String DEPARTMENTID = "departmentId";
	public static final String USERID = "userId";
	public static final String LOAITHONGKE = "loaiThongKe";
	public static final String FROMDATE = "fromDate";
	public static final String TODATE = "toDate";

	protected String departmentId;
	protected long userId;
	protected String loaiThongKe;
	protected String fromDate;
	protected String toDate;

	public HomeReportDisplayTerms(RenderRequest renderRequest) {
		super(renderRequest);

		departmentId = ParamUtil.getString(renderRequest, DEPARTMENTID);
		userId = ParamUtil.getLong(renderRequest, USERID);
		loaiThongKe = ParamUtil.getString(renderRequest, LOAITHONGKE);
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		
		Calendar calendar = Calendar.getInstance();
		String fromDateTemp = "01" + "/" + (calendar.get(Calendar.MONTH)+1) + "/" + calendar.get(Calendar.YEAR);
		
		fromDate = ParamUtil.getString(renderRequest, FROMDATE, fromDateTemp);
		toDate = ParamUtil.getString(renderRequest, TODATE, dateFormat.format(new Date()));
	}

	public String getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getLoaiThongKe() {
		return loaiThongKe;
	}

	public void setLoaiThongKe(String loaiThongKe) {
		this.loaiThongKe = loaiThongKe;
	}

	public String getFromDate() {
		return fromDate;
	}

	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}

	public String getToDate() {
		return toDate;
	}

	public void setToDate(String toDate) {
		this.toDate = toDate;
	}

}
