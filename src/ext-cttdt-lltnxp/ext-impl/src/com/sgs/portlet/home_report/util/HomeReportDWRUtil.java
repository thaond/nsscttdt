package com.sgs.portlet.home_report.util;

import com.liferay.portal.model.User;
import com.liferay.portal.service.persistence.UserUtil;

public class HomeReportDWRUtil {
	
	public static String getFullName(long userId) {
		User user = null;
		String fullname = "";
		try {
			user = UserUtil.findByPrimaryKey(userId);
			fullname= user.getLastName() + " " + user.getMiddleName() + " " + user.getFirstName();
		} catch (Exception e) {
			fullname = "";
		}
		return fullname;
	}

}
