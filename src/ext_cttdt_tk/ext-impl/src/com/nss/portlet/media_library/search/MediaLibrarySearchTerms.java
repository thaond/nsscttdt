package com.nss.portlet.media_library.search;

import javax.portlet.PortletRequest;

import com.liferay.portal.kernel.dao.search.DAOParamUtil;
import com.liferay.portal.kernel.util.ParamUtil;

public class MediaLibrarySearchTerms extends MediaLibraryDisplayTerms{

	public MediaLibrarySearchTerms(PortletRequest portletRequest) {
		super(portletRequest);
		tieuDeMediaLibrary = DAOParamUtil.getLike(portletRequest, TIEU_DE_MEDIA_LIBRARY);
		tenMediaLibrary = DAOParamUtil.getLike(portletRequest, TEN_MEDIA_LIBRARY);
		maMediaChuDe = ParamUtil.getLong(portletRequest, MA_MEDIA_CHU_DE, 0);
	}

}
