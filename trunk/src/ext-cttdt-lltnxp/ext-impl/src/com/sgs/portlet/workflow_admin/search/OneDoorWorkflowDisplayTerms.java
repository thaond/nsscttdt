/**
 * 
 */
package com.sgs.portlet.workflow_admin.search;

import javax.portlet.RenderRequest;

import com.liferay.portal.kernel.dao.search.DisplayTerms;
import com.liferay.portal.kernel.util.ParamUtil;

/**
 * @author minhnv
 *
 */
public class OneDoorWorkflowDisplayTerms extends DisplayTerms{
	public static final String FILETYPENAME = "fileTypeName";
	public static final String WORKFLOWNAME = "workflowName";
	
	protected String fileTypeName;
	protected String workflowName;
	
	public OneDoorWorkflowDisplayTerms(RenderRequest renderRequest) {
		super(renderRequest);
		fileTypeName = ParamUtil.getString(renderRequest, FILETYPENAME);
		workflowName = ParamUtil.getString(renderRequest, WORKFLOWNAME);
	}

	public String getFileTypeName() {
		return fileTypeName;
	}

	public void setFileTypeName(String fileTypeName) {
		this.fileTypeName = fileTypeName;
	}

	public String getWorkflowName() {
		return workflowName;
	}

	public void setWorkflowName(String workflowName) {
		this.workflowName = workflowName;
	}
	
	

}
