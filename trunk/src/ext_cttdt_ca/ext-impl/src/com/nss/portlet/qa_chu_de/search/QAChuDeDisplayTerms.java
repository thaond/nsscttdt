package com.nss.portlet.qa_chu_de.search;

import javax.portlet.PortletRequest;

import com.liferay.portal.kernel.dao.search.DisplayTerms;
import com.liferay.portal.kernel.util.ParamUtil;

public class QAChuDeDisplayTerms extends DisplayTerms{
	public static final String TEN_CHU_DE_CAU_HOI= "tenChuDeCauHoi";
	protected String tenChuDeCauHoi;
	
	public QAChuDeDisplayTerms(PortletRequest portletRequest) {
		super(portletRequest);
		tenChuDeCauHoi = ParamUtil.getString(portletRequest, TEN_CHU_DE_CAU_HOI);
	}

	public String getTenChuDeCauHoi() {
		return tenChuDeCauHoi;
	}

	public void setTenChuDeCauHoi(String tenChuDeCauHoi) {
		this.tenChuDeCauHoi = tenChuDeCauHoi;
	}

}
