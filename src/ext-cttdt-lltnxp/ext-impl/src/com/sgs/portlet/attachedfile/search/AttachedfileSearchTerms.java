package com.sgs.portlet.attachedfile.search;

import javax.portlet.RenderRequest;

import com.liferay.portal.kernel.dao.search.DAOParamUtil;
import com.liferay.portal.kernel.util.ParamUtil;

public class AttachedfileSearchTerms extends AttachedfileDisplayTerms{

	public AttachedfileSearchTerms(RenderRequest renderRequest) {
		super(renderRequest);
		//YENLT UPDATE 12/03/2010
//		ma = ParamUtil.getString(renderRequest, MA);
//		ten = ParamUtil.getString(renderRequest, TEN);
		ma = DAOParamUtil.getLike(renderRequest, MA);
		ten = DAOParamUtil.getLike(renderRequest, TEN);
	}

}
