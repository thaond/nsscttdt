package com.nss.portlet.qa_chu_de.search;

import javax.portlet.PortletRequest;

import com.liferay.portal.kernel.dao.search.DAOParamUtil;

public class QAChuDeSearchTerms extends QAChuDeDisplayTerms{
	public QAChuDeSearchTerms(PortletRequest portletRequest) {
		super(portletRequest);
		tenChuDeCauHoi = DAOParamUtil.getLike(portletRequest, TEN_CHU_DE_CAU_HOI);
	}

}
