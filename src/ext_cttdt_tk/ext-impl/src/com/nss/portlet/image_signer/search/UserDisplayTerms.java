package com.nss.portlet.image_signer.search;

import javax.portlet.PortletRequest;

import com.liferay.portal.kernel.dao.search.DisplayTerms;
import com.liferay.portal.kernel.util.ParamUtil;

public class UserDisplayTerms extends DisplayTerms {
	protected String firstname;
	protected String middlename;
	protected String lastname;
	
	public static final String FIRSTNAME = "firstName";
	public static final String MIDDLENAME = "middleName";
	public static final String LASTNAME = "lastName";

	public UserDisplayTerms(PortletRequest portletRequest) {
		super(portletRequest);
		firstname = ParamUtil.getString(portletRequest, FIRSTNAME);
		middlename = ParamUtil.getString(portletRequest, MIDDLENAME);
		lastname = ParamUtil.getString(portletRequest, LASTNAME);
	}

	public String getFirstName() {
		return firstname;
	}

	public void setFirstName(String firstName) {
		this.firstname = firstName;
	}

	public String getMiddleName() {
		return middlename;
	}

	public void setMiddleName(String middleName) {
		this.middlename = middleName;
	}

	public String getLastName() {
		return lastname;
	}

	public void setLastName(String lastName) {
		this.lastname = lastName;
	}

}
