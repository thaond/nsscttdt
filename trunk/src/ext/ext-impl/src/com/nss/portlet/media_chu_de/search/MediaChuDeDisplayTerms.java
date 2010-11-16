package com.nss.portlet.media_chu_de.search;

import javax.portlet.PortletRequest;

import com.liferay.portal.kernel.dao.search.DisplayTerms;
import com.liferay.portal.kernel.util.ParamUtil;

public class MediaChuDeDisplayTerms extends DisplayTerms{
	public static final String TEN_MEDIA_CHU_DE = "tenMediaChuDe";
	protected String tenMediaChuDe;
	
	public MediaChuDeDisplayTerms(PortletRequest portletRequest) {
		super(portletRequest);
		tenMediaChuDe = ParamUtil.getString(portletRequest, TEN_MEDIA_CHU_DE);
	}

	public String getTenMediaChuDe() {
		return tenMediaChuDe;
	}

	public void setTenMediaChuDe(String tenMediaChuDe) {
		this.tenMediaChuDe = tenMediaChuDe;
	}

}
