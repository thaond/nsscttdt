package com.sgs.portlet.signer.search;

import javax.portlet.RenderRequest;

import com.liferay.portal.kernel.dao.search.DisplayTerms;
import com.liferay.portal.kernel.util.ParamUtil;

public class UserDisplayTerms extends DisplayTerms{
	public static final String LASTNAME = "LastName";
	public static final String FIRSTNAME = "FirstName";
	
	public UserDisplayTerms(RenderRequest renderRequest) {
		super(renderRequest);
		lastName = ParamUtil.getString(renderRequest, LASTNAME);
		firstName = ParamUtil.getString(renderRequest, FIRSTNAME);
	}
	
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	protected String lastName;
	protected String firstName;
}
