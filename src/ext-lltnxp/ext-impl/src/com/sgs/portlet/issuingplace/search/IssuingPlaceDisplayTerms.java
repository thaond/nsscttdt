package com.sgs.portlet.issuingplace.search;

import javax.portlet.RenderRequest;

import com.liferay.portal.kernel.dao.search.DisplayTerms;
import com.liferay.portal.kernel.util.ParamUtil;

public class IssuingPlaceDisplayTerms extends DisplayTerms{
	public static final String MA = "code";
	public static final String NAME = "name";
	
	protected String code;
	protected String name;
	
	public IssuingPlaceDisplayTerms(RenderRequest renderRequest) {
		super(renderRequest);
		code = ParamUtil.getString(renderRequest, MA);
		name = ParamUtil.getString(renderRequest, NAME);
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
