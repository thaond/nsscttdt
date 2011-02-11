/**
 * 
 */
package com.sgs.portlet.pml_edm_privelegeleveladmin.search;

import javax.portlet.RenderRequest;

import com.liferay.portal.kernel.util.ParamUtil;

/**
 * @author canhminh
 *
 */
public class PmlEDMPrivelegelevelAdminSearchTerms extends PmlEDMPrivelegelevelAdminDisplayTerms{

	
	public PmlEDMPrivelegelevelAdminSearchTerms(RenderRequest renderRequest) {
		super(renderRequest);
		privilegelevelName = ParamUtil.getString(renderRequest, PRIVILEGELEVEL_NAME);
	}

}
