package com.nss.portlet.filestatus.search;

import javax.portlet.RenderRequest;

import com.liferay.portal.kernel.dao.search.DisplayTerms;
import com.liferay.portal.kernel.util.ParamUtil;

public class PmlFileStatusDisplayTerms extends DisplayTerms{
	public static final String FILESTATUS_CODE = "filestatuscode";
	public static final String FILESTATUS_NAME = "filestatusname";
	
	public PmlFileStatusDisplayTerms(RenderRequest renderRequest) {
		super(renderRequest);
		filestatuscode = ParamUtil.getString(renderRequest, FILESTATUS_CODE);
		filestatusname = ParamUtil.getString(renderRequest, FILESTATUS_NAME);
	}
	
	public String getFilestatuscode() {
		return filestatuscode;
	}
	public void setFilestatuscode(String filestatuscode) {
		this.filestatuscode = filestatuscode;
	}
	public String getFilestatusname() {
		return filestatusname;
	}
	public void setFilestatusname(String filestatusname) {
		this.filestatusname = filestatusname;
	}

	protected String filestatuscode;
	protected String filestatusname;
	

}
