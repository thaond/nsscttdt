package com.sgs.portlet.signer.search;

import javax.portlet.RenderRequest;

import com.liferay.portal.kernel.dao.search.DAOParamUtil;

public class UserSearchTerms extends UserDisplayTerms{

	public UserSearchTerms(RenderRequest renderRequest) {
		super(renderRequest);
		lastName = DAOParamUtil.getLike(renderRequest, LASTNAME);
		firstName = DAOParamUtil.getLike(renderRequest, FIRSTNAME);
	}

}
