/**
 * 
 */
package com.sgs.portlet.pcccdocumentsendprocess.search;

import javax.portlet.RenderRequest;

import com.liferay.portal.kernel.dao.search.DAOParamUtil;

/**
 * @author minh.nv
 *
 */
public class PcccDocumentSendProcessSearchTerms extends PcccDocumentSendProcessSearchDisplayTerms {

	/**
	 * @param renderRequest
	 */
	public PcccDocumentSendProcessSearchTerms(RenderRequest renderRequest) {
		super(renderRequest);
		loaiSoCongVan =  DAOParamUtil.getInteger(renderRequest, LOAISOCONGVAN);
	}

}
