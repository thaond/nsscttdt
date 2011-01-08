/**
 * 
 */
package com.sgs.portlet.workflow_admin.search;

import javax.portlet.RenderRequest;

import com.liferay.portal.kernel.dao.search.DAOParamUtil;

/**
 * @author minhnv
 *
 */
public class OneDoorWorkflowSearchTems extends OneDoorWorkflowDisplayTerms{

	
	public OneDoorWorkflowSearchTems(RenderRequest renderRequest) {
		super(renderRequest);
		fileTypeName = DAOParamUtil.getLike(renderRequest, FILETYPENAME);
		workflowName = DAOParamUtil.getLike(renderRequest, WORKFLOWNAME);
	}

}
