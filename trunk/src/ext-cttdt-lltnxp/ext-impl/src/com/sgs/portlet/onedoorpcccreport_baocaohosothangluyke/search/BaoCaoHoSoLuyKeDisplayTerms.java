package com.sgs.portlet.onedoorpcccreport_baocaohosothangluyke.search;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.portlet.RenderRequest;

import com.liferay.portal.kernel.dao.search.DisplayTerms;
import com.liferay.portal.kernel.util.ParamUtil;

public class BaoCaoHoSoLuyKeDisplayTerms extends DisplayTerms{
	public static final String TUNGAY = "fromDate";
	public static final String DENNGAY = "toDate";
	
	protected String fromDate;
	protected String toDate;
	
	public BaoCaoHoSoLuyKeDisplayTerms(RenderRequest renderRequest) {
		super(renderRequest);
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		fromDate = ParamUtil.getString(renderRequest, TUNGAY , dateFormat.format(new Date()));
		toDate = ParamUtil.getString(renderRequest, DENNGAY, dateFormat.format(new Date()));
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
