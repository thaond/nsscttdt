package com.nss.portlet.attachedfile.search;

import javax.portlet.RenderRequest;

import com.liferay.portal.kernel.dao.search.DAOParamUtil;
import com.liferay.portal.kernel.util.ParamUtil;

public class AttachedfileSearchTerms extends AttachedfileDisplayTerms{

	public AttachedfileSearchTerms(RenderRequest renderRequest) {
		super(renderRequest);
//		ma = DAOParamUtil.getLike(renderRequest, MA);
		ma = "%" + ParamUtil.getString(renderRequest, MA) + "%";
		ten = DAOParamUtil.getLike(renderRequest, TEN);
	}

}
