
package com.sgs.portlet.pmluser.model.impl;

import com.sgs.portlet.pmluser.model.PmlUser;

public class PmlUserImpl extends PmlUserModelImpl implements PmlUser {

	public PmlUserImpl() {

	}

	public String getFullName() {

		return getLastName() + " " + getMiddleName() + " " + getFirstName();
	}
}
