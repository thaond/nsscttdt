package com.nss.portlet.filetype.search;

import javax.portlet.RenderRequest;

import com.liferay.portal.kernel.dao.search.DisplayTerms;
import com.liferay.portal.kernel.util.ParamUtil;

public class FileTypeDisplayTerms extends DisplayTerms {
	public static final String FILETYPE_CODE = "fileTypeCode";
	public static final String FILETYPE_NAME = "fileTypeName";
	
	protected String fileTypeCode;
	protected String fileTypeName;
	
	public FileTypeDisplayTerms(RenderRequest renderRequest) {
		super(renderRequest);
		fileTypeCode = ParamUtil.getString(renderRequest, FILETYPE_CODE);
		fileTypeName = ParamUtil.getString(renderRequest, FILETYPE_NAME);
	}

	public String getFileTypeCode() {
		return fileTypeCode;
	}

	public void setFileTypeCode(String fileTypeCode) {
		this.fileTypeCode = fileTypeCode;
	}

	public String getFileTypeName() {
		return fileTypeName;
	}

	public void setFileTypeName(String fileTypeName) {
		this.fileTypeName = fileTypeName;
	}


}
