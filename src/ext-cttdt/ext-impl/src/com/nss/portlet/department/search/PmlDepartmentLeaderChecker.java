package com.nss.portlet.department.search;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.RenderResponse;

import com.liferay.portal.kernel.dao.search.RowChecker;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.nss.portlet.department.model.PmlDepartmentsLeader;
import com.nss.portlet.department.model.PmlUser;
import com.nss.portlet.department.service.PmlDepartmentsLeaderLocalServiceUtil;

/**
 * @author phmphuc
 */
public class PmlDepartmentLeaderChecker extends RowChecker {

	public PmlDepartmentLeaderChecker(RenderResponse renderResponse) {
		super(renderResponse);
	}
	
	public boolean isChecked(Object obj) {
		PmlUser user = (PmlUser)obj;

		List<PmlDepartmentsLeader> list = new ArrayList<PmlDepartmentsLeader>();
		
		try {
			String departmentsId = user.getDepartmentsId();
			list = PmlDepartmentsLeaderLocalServiceUtil.findByDepartmentsId_UserId(departmentsId, user.getUserId());
		}
		catch (Exception e) {
			_log.error(e);
		}
		
		if (list.size() > 0) {
			return true;
		}
		else {
			return false;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(PmlDepartmentLeaderChecker.class);
}
