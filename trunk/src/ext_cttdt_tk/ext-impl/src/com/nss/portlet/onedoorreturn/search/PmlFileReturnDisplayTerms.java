package com.nss.portlet.onedoorreturn.search;

import javax.portlet.RenderRequest;

import com.liferay.portal.kernel.dao.search.DisplayTerms;
import com.liferay.portal.kernel.util.ParamUtil;

public class PmlFileReturnDisplayTerms extends DisplayTerms{

	public static final String NUMBERRECEIPT = "numberreceipt";
	public static final String FILETYPEID = "fileTypeId";
	public static final String YEAR = "year";
	
	protected String numberreceipt;
	protected String fileTypeId;
	protected String year;
	
	public PmlFileReturnDisplayTerms(RenderRequest renderRequest) {
		super(renderRequest);
		numberreceipt = ParamUtil.getString(renderRequest, NUMBERRECEIPT);
		fileTypeId = ParamUtil.getString(renderRequest, FILETYPEID);
		year = ParamUtil.getString(renderRequest, YEAR);
		
	}

	public String getNumberreceipt() {
		return numberreceipt;
	}

	public void setNumberreceipt(String numberreceipt) {
		this.numberreceipt = numberreceipt;
	}

	public String getFileTypeId() {
		return fileTypeId;
	}

	public void setFileTypeId(String fileTypeId) {
		this.fileTypeId = fileTypeId;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

}
