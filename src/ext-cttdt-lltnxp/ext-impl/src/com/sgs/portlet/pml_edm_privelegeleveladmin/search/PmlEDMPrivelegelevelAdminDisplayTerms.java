/**
 * 
 */
package com.sgs.portlet.pml_edm_privelegeleveladmin.search;

import javax.portlet.RenderRequest;

import com.liferay.portal.kernel.dao.search.DisplayTerms;
import com.liferay.portal.kernel.util.ParamUtil;

/**
 * @author canhminh
 *
 */
public class PmlEDMPrivelegelevelAdminDisplayTerms extends DisplayTerms{

	public static final String PRIVILEGELEVEL_NAME = "privilegelevelName";
	
	protected String privilegelevelName;
	public PmlEDMPrivelegelevelAdminDisplayTerms(RenderRequest renderRequest) {
		super(renderRequest);
		privilegelevelName = ParamUtil.getString(renderRequest, PRIVILEGELEVEL_NAME);
	}
	public String getPrivilegelevelName() {
		return privilegelevelName;
	}
	public void setPrivilegelevelName(String privilegelevelName) {
		this.privilegelevelName = privilegelevelName;
	}

}
