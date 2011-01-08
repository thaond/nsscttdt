/**
 * 
 */
package com.sgs.portlet.pmluser.search;

import javax.portlet.RenderRequest;

import com.liferay.portal.kernel.dao.search.DAOParamUtil;

/**
 * @author canhminh
 *
 */
public class PmlUserSearchTerms extends PmlUserDisplayTerms{

	
	public PmlUserSearchTerms(RenderRequest renderRequest) {
		super(renderRequest);
		tenGoi = DAOParamUtil.getLike(renderRequest, TEN_GOI);
		ho = DAOParamUtil.getLike(renderRequest, HO);
		lot = DAOParamUtil.getLike(renderRequest, LOT);
		ten = DAOParamUtil.getLike(renderRequest, TEN);
		chucVu = DAOParamUtil.getString(renderRequest, CHUC_VU);
	}

}
