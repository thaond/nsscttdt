package com.nss.portlet.onedoorreturn.search;

import javax.portlet.RenderRequest;

import com.liferay.portal.kernel.dao.search.DAOParamUtil;
import com.liferay.portal.kernel.util.ParamUtil;

public class PmlFileReturnSearchTerms extends PmlFileReturnDisplayTerms{

	public PmlFileReturnSearchTerms(RenderRequest renderRequest) {
		super(renderRequest);	
		numberreceipt = DAOParamUtil.getLike(renderRequest, NUMBERRECEIPT);
		fileTypeId = DAOParamUtil.getString(renderRequest, FILETYPEID);
		year = ParamUtil.getString(renderRequest, YEAR);
	}

}
