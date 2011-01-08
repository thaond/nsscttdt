package com.sgs.portlet.filetype.search;

import javax.portlet.RenderRequest;

import com.liferay.portal.kernel.dao.search.DAOParamUtil;

public class FileTypeSearchTerms extends FileTypeDisplayTerms {

	
	public FileTypeSearchTerms(RenderRequest renderRequest) {
		super(renderRequest);
		//YENLT UPDATE 12/03/2010
//		fileTypeCode = ParamUtil.getString(renderRequest, FILETYPE_CODE);
//		fileTypeName = ParamUtil.getString(renderRequest, FILETYPE_NAME);
		fileTypeCode = DAOParamUtil.getLike(renderRequest, FILETYPE_CODE);
		fileTypeName = DAOParamUtil.getLike(renderRequest, FILETYPE_NAME);
	}

}
