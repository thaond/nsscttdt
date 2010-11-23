package com.nss.portlet.media_chu_de.search;

import javax.portlet.PortletRequest;

import com.liferay.portal.kernel.dao.search.DAOParamUtil;

public class MediaChuDeSearchTerms extends MediaChuDeDisplayTerms{

	public MediaChuDeSearchTerms(PortletRequest portletRequest) {
		super(portletRequest);
		tenMediaChuDe = DAOParamUtil.getLike(portletRequest, TEN_MEDIA_CHU_DE);
	}

}
