package com.nss.portlet.journalworkflow.util;

import java.util.ArrayList;
import java.util.List;

import com.liferay.portal.SystemException;
import com.liferay.portal.model.Permission;
import com.liferay.portal.model.Role;
import com.liferay.portal.service.PermissionLocalServiceUtil;
import com.liferay.portal.service.RoleLocalServiceUtil;

public class RoleFilter {
	public static List<Role> getRolesHavePermission(long companyId,
			String actionId) {
		List<Role> result = new ArrayList<Role>();
		try {
			List<Role> roles = RoleLocalServiceUtil.getRoles(companyId);
			List<Permission> permissions = new ArrayList<Permission>();
			for (int i = 0; i < roles.size(); i++) {
				permissions = PermissionLocalServiceUtil
						.getRolePermissions(roles.get(i).getRoleId());
				if (hasPermission(permissions, actionId))
					result.add(roles.get(i));
			}
		} catch (SystemException e) {
			e.printStackTrace();
		}
		return result;
	}

	private static boolean hasPermission(List<Permission> permissions,
			String actionId) {
		for (int i = 0; i < permissions.size(); i++) {
			if (permissions.get(i).getActionId().equals(actionId))
				return true;
		}
		return false;
	}

}
