package com.sgs.portlet.pcccdocumentreceiptreport.search;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.portlet.RenderRequest;

import com.liferay.portal.kernel.dao.search.DisplayTerms;
import com.liferay.portal.kernel.util.ParamUtil;

/**
 * @author phmphuc dung cho phan hien thi chi tiet danh sach cong van
 */

public class DocumentDetailDisplayTerms extends DisplayTerms {

	public static final String DEPARTMENTID = "departmentId";
	public static final String USERID = "userId";
	public static final String NHOMCONGVAN = "nhomCongVan";
	public static final String LOAICONGVAN = "loaiCongVan";
	public static final String FROMDATE = "fromDate";
	public static final String TODATE = "toDate";
	public static final String DOMAT = "doMat";
	
	public static final String CAPGUI = "capgui";
	public static final String LOAISOCONGVAN = "loaisocongvan";
	
	protected String departmentId;
	protected long userId;
	protected int nhomCongVan;
	protected String loaiCongVan;
	protected String fromDate;
	protected String toDate;	
	protected String doMat;	
	
	protected int capgui;
	protected int loaisocongvan;

	public DocumentDetailDisplayTerms(RenderRequest renderRequest) {
		super(renderRequest);
		departmentId = ParamUtil.getString(renderRequest, DEPARTMENTID);
		userId = ParamUtil.getLong(renderRequest, USERID);
		nhomCongVan = ParamUtil.getInteger(renderRequest, NHOMCONGVAN);
		loaiCongVan = ParamUtil.getString(renderRequest, LOAICONGVAN);
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		fromDate = ParamUtil.getString(renderRequest, FROMDATE, dateFormat.format(new Date()));
		toDate = ParamUtil.getString(renderRequest, TODATE, dateFormat.format(new Date()));
		doMat = ParamUtil.getString(renderRequest, DOMAT);
		
		capgui = ParamUtil.getInteger(renderRequest, CAPGUI);
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

	public int getNhomCongVan() {
		return nhomCongVan;
	}

	public void setNhomCongVan(int nhomCongVan) {
		this.nhomCongVan = nhomCongVan;
	}

	public String getLoaiCongVan() {
		return loaiCongVan;
	}

	public void setLoaiCongVan(String loaiCongVan) {
		this.loaiCongVan = loaiCongVan;
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

	public int getCapgui() {
		return capgui;
	}

	public void setCapgui(int capgui) {
		this.capgui = capgui;
	}

	public int getLoaisocongvan() {
		return loaisocongvan;
	}

	public void setLoaisocongvan(int loaisocongvan) {
		this.loaisocongvan = loaisocongvan;
	}

	public String getDoMat() {
		return doMat;
	}

	public void setDoMat(String doMat) {
		this.doMat = doMat;
	}
}
