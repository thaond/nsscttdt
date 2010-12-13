package com.nss.portlet.filetype.search;

import javax.portlet.RenderRequest;

import com.liferay.portal.kernel.dao.search.DAOParamUtil;

public class FileTypeSearchTerms extends FileTypeDisplayTerms {

	
	public FileTypeSearchTerms(RenderRequest renderRequest) {
		super(renderRequest);
		fileTypeCode = DAOParamUtil.getLike(renderRequest, FILETYPE_CODE);
		fileTypeName = DAOParamUtil.getLike(renderRequest, FILETYPE_NAME);
	}

}
