/**
 * 
 */

package com.sgs.portlet.pmluser.ajax;

import java.util.ArrayList;
import java.util.List;

import com.liferay.portal.SystemException;
import com.sgs.portlet.pmluser.model.PmlUser;
import com.sgs.portlet.pmluser.util.PmlUserUtil;

/**
 * @author canhminh
 */
public class UserAjaxUtil {

	public List<PmlUser> getPmlUserByDepartmentId(String departmentsId) {

		return PmlUserUtil.getPmlUserByDepartmentId(departmentsId);
	}

	public List<String> getSponsorUsers() {

		List<String> results = new ArrayList<String>();
		try {
			List<PmlUser> pmlUsers =
				com.sgs.portlet.pmluser.service.persistence.PmlUserUtil.findByIsLeaderMetting(true);
			for (PmlUser pmlUser : pmlUsers) {
				results.add(pmlUser.getFullName());
			}
		}
		catch (SystemException e) {
			e.printStackTrace();
		}
		return results;
	}
}
