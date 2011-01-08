package com.sgs.portlet.congvandidahoanthanh.search;

import java.util.Calendar;
import java.util.Date;

import javax.portlet.RenderRequest;

import com.liferay.portal.kernel.dao.search.DisplayTerms;
import com.liferay.portal.kernel.util.ParamUtil;

public class CVDiDaHoanThanhDisplayTerms extends DisplayTerms {

	public static final String FROMDATE = "fromDate";
	public static final String TODATE = "toDate";
	public static final String LOAISOCONGVAN = "pmlEdmDocumentRecordTypes";

	protected String fromDate;
	protected String toDate;
	protected int[] loaiSoCongVan;

	public CVDiDaHoanThanhDisplayTerms(RenderRequest renderRequest) {
		super(renderRequest);

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		int year = calendar.get(Calendar.YEAR);
		String dauNam = "01/01/" + year;
		String cuoiNam = "31/12/" + year;
		
		fromDate = ParamUtil.getString(renderRequest, FROMDATE, dauNam);
		toDate = ParamUtil.getString(renderRequest, TODATE, cuoiNam);
		loaiSoCongVan = ParamUtil.getIntegerValues(renderRequest, LOAISOCONGVAN, new int[] {});

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

	public int[] getLoaiSoCongVan() {
		return loaiSoCongVan;
	}

	public void setLoaiSoCongVan(int[] loaiSoCongVan) {
		this.loaiSoCongVan = loaiSoCongVan;
	}

}
