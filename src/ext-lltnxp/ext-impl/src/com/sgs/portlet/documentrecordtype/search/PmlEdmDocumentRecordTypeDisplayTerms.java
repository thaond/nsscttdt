package com.sgs.portlet.documentrecordtype.search;

import javax.portlet.RenderRequest;

import com.liferay.portal.kernel.dao.search.DisplayTerms;
import com.liferay.portal.kernel.util.ParamUtil;

public class PmlEdmDocumentRecordTypeDisplayTerms extends DisplayTerms{
	public static final String PMLEDMDOCUMENTRECORDTYPE_CODE = "pmlEdmDocumentRecordTypeCode";
	public static final String PMLEDMDOCUMENTRECORDTYPE_NAME = "pmlEdmDocumentRecordTypeName";

	protected String pmlEdmDocumentRecordTypeCode;
	protected String pmlEdmDocumentRecordTypeName;
	
	public PmlEdmDocumentRecordTypeDisplayTerms(RenderRequest renderRequest) {
		super(renderRequest);
		pmlEdmDocumentRecordTypeCode = ParamUtil.getString(renderRequest, PMLEDMDOCUMENTRECORDTYPE_CODE);
		pmlEdmDocumentRecordTypeName = ParamUtil.getString(renderRequest, PMLEDMDOCUMENTRECORDTYPE_NAME);
	}

	public String getPmlEdmDocumentRecordTypeCode() {
		return pmlEdmDocumentRecordTypeCode;
	}

	public void setPmlEdmDocumentRecordTypeCode(String pmlEdmDocumentRecordTypeCode) {
		this.pmlEdmDocumentRecordTypeCode = pmlEdmDocumentRecordTypeCode;
	}

	public String getPmlEdmDocumentRecordTypeName() {
		return pmlEdmDocumentRecordTypeName;
	}

	public void setPmlEdmDocumentRecordTypeName(String pmlEdmDocumentRecordTypeName) {
		this.pmlEdmDocumentRecordTypeName = pmlEdmDocumentRecordTypeName;
	}

	
}
