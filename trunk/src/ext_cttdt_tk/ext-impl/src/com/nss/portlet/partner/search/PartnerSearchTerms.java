package com.nss.portlet.partner.search;

import javax.portlet.PortletRequest;

import com.liferay.portal.kernel.dao.search.DAOParamUtil;

public class PartnerSearchTerms extends PartnerDisplayTerms{

	public PartnerSearchTerms(PortletRequest portletRequest) {
		super(portletRequest);
		
		tenPartner = DAOParamUtil.getLike(portletRequest, TEN_PARTNER);
		moTaPartner = DAOParamUtil.getLike(portletRequest, MO_TA_PARTNER);
	}

}
