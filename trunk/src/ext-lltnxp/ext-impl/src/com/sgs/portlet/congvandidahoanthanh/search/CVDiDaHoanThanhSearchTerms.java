package com.sgs.portlet.congvandidahoanthanh.search;

import java.util.Calendar;
import java.util.Date;

import javax.portlet.RenderRequest;
import com.liferay.portal.kernel.util.ParamUtil;

public class CVDiDaHoanThanhSearchTerms extends CVDiDaHoanThanhDisplayTerms {
	
	public CVDiDaHoanThanhSearchTerms(RenderRequest renderRequest) {
		super(renderRequest);

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		int year = calendar.get(Calendar.YEAR);
		String dauNam = "01/01/" + year;
		String cuoiNam = "31/12/" + year;
		
		fromDate = ParamUtil.getString(renderRequest, FROMDATE, dauNam);
		toDate = ParamUtil.getString(renderRequest, TODATE, cuoiNam);
		loaiSoCongVan = ParamUtil.getIntegerValues(renderRequest, LOAISOCONGVAN, new int[]{});
	}

}
