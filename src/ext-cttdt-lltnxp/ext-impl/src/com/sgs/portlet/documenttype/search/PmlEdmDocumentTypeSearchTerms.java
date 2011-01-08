/**
 * 
 */
package com.sgs.portlet.documenttype.search;

import javax.portlet.RenderRequest;

import com.liferay.portal.kernel.dao.search.DAOParamUtil;

/**
 * @author minhnv
 *
 */
public class PmlEdmDocumentTypeSearchTerms extends PmlEdmDocumentTypeDisplayTerms{
	
	public PmlEdmDocumentTypeSearchTerms(RenderRequest renderRequest) {
		super(renderRequest);
		pmlEdmDocumentTypeName = DAOParamUtil.getLike(renderRequest, PMLEDMDOCUMENTTYPE_NAME);
		 pmlEdmDocumentRecordTypeName = DAOParamUtil.getLike(renderRequest, PMLEDMDOCUMENTTYPE_DOCUMENTRECORDTYPENAME); 
	}

}
