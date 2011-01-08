/**
 * 
 */
package com.sgs.portlet.documenttype.search;

import javax.portlet.RenderRequest;

import com.liferay.portal.kernel.dao.search.DisplayTerms;
import com.liferay.portal.kernel.util.ParamUtil;

/**
 * @author minhnv
 *
 */
public class PmlEdmDocumentTypeDisplayTerms extends DisplayTerms{
	public static final String PMLEDMDOCUMENTTYPE_NAME = "pmlEdmDocumentTypeName";
	public static final String PMLEDMDOCUMENTTYPE_DOCUMENTRECORDTYPENAME = "pmlEdmDocumentRecordTypeName";

	protected String pmlEdmDocumentTypeName;
	protected String pmlEdmDocumentRecordTypeName;
	
	public PmlEdmDocumentTypeDisplayTerms(RenderRequest renderRequest) {
		super(renderRequest);
		 pmlEdmDocumentTypeName = ParamUtil.getString(renderRequest, PMLEDMDOCUMENTTYPE_NAME);
		 pmlEdmDocumentRecordTypeName = ParamUtil.getString(renderRequest, PMLEDMDOCUMENTTYPE_DOCUMENTRECORDTYPENAME); 
	}

	public String getPmlEdmDocumentTypeName() {
		return pmlEdmDocumentTypeName;
	}

	public void setPmlEdmDocumentTypeName(String pmlEdmDocumentTypeName) {
		this.pmlEdmDocumentTypeName = pmlEdmDocumentTypeName;
	}

	public String getPmlEdmDocumentRecordTypeName() {
		return pmlEdmDocumentRecordTypeName;
	}

	public void setPmlEdmDocumentRecordTypeName(String pmlEdmDocumentRecordTypeName) {
		this.pmlEdmDocumentRecordTypeName = pmlEdmDocumentRecordTypeName;
	}
	
	
}
