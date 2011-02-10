package com.sgs.portlet.documentrecordtype.search;

import javax.portlet.RenderRequest;

import com.liferay.portal.kernel.dao.search.DAOParamUtil;

public class PmlEdmDocumentRecordTypeSearchTerms extends PmlEdmDocumentRecordTypeDisplayTerms{

	public PmlEdmDocumentRecordTypeSearchTerms(RenderRequest renderRequest) {
		super(renderRequest);
		pmlEdmDocumentRecordTypeCode = DAOParamUtil.getLike(renderRequest, PMLEDMDOCUMENTRECORDTYPE_CODE);
		pmlEdmDocumentRecordTypeName = DAOParamUtil.getLike(renderRequest, PMLEDMDOCUMENTRECORDTYPE_NAME);
	}

}
