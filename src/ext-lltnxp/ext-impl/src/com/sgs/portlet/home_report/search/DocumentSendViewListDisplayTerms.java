package com.sgs.portlet.home_report.search;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.portlet.RenderRequest;

import com.liferay.portal.kernel.dao.search.DisplayTerms;
import com.liferay.portal.kernel.util.ParamUtil;

/**
 * @author phmphuc dung cho phan hien thi chi tiet danh sach van ban di
 */

public class DocumentSendViewListDisplayTerms extends DisplayTerms {

	public static final String DEPARTMENTID = "departmentId";
	public static final String USERID = "userId";
	public static final String LOAITHONGKE = "loaiThongKe";
	public static final String FROMDATE = "fromDate";
	public static final String TODATE = "toDate";
	
	public static final String LOAISOCONGVAN = "loaisocongvan";
	
	protected String departmentId;
	protected long userId;
	protected String loaiThongKe;
	protected String fromDate;
	protected String toDate;	
	
	protected int loaisocongvan;

	public DocumentSendViewListDisplayTerms(RenderRequest renderRequest) {
		super(renderRequest);
		departmentId = ParamUtil.getString(renderRequest, DEPARTMENTID);
		userId = ParamUtil.getLong(renderRequest, USERID);
		loaiThongKe = ParamUtil.getString(renderRequest, LOAITHONGKE);
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		fromDate = ParamUtil.getString(renderRequest, FROMDATE, dateFormat.format(new Date()));
		toDate = ParamUtil.getString(renderRequest, TODATE, dateFormat.format(new Date()));
		
		loaisocongvan = ParamUtil.getInteger(renderRequest, LOAISOCONGVAN);
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

	public int getLoaisocongvan() {
		return loaisocongvan;
	}

	public void setLoaisocongvan(int loaisocongvan) {
		this.loaisocongvan = loaisocongvan;
	}

}
