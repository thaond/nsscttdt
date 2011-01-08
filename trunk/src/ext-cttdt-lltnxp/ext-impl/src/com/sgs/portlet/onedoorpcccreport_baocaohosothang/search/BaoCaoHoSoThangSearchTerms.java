package com.sgs.portlet.onedoorpcccreport_baocaohosothang.search;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.portlet.RenderRequest;

import com.liferay.portal.kernel.util.ParamUtil;

public class BaoCaoHoSoThangSearchTerms extends BaoCaoHoSoThangDisplayTerms{
	public BaoCaoHoSoThangSearchTerms(RenderRequest renderRequest) {
		super(renderRequest);
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		fromDate = ParamUtil.getString(renderRequest, TUNGAY , dateFormat.format(new Date()));
		toDate = ParamUtil.getString(renderRequest, DENNGAY, dateFormat.format(new Date()));
	}
}
