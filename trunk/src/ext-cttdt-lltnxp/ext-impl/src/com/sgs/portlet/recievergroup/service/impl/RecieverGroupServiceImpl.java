
package com.sgs.portlet.recievergroup.service.impl;

import java.util.List;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.service.permission.PortletPermissionUtil;
import com.sgs.portlet.recievergroup.model.Reciever;
import com.sgs.portlet.recievergroup.model.RecieverGroup;
import com.sgs.portlet.recievergroup.service.base.RecieverGroupServiceBaseImpl;
import com.sgs.portlet.recievergroup.util.RecieverKeys;

public class RecieverGroupServiceImpl extends RecieverGroupServiceBaseImpl {

	public void addRecieverToGroup(
		long groupPK, long recieverUserId, String recieverUserName,
		int recieverType)
		throws PortalException, SystemException {

		long userId = getUserId();

		PortletPermissionUtil.check(
			getPermissionChecker(), RecieverKeys.PORTLET_NAME,
			RecieverKeys.UPDATE_ACTION);

		Reciever reciever =
			recieverLocalService.addReciever(
				userId, recieverUserId, recieverUserName, recieverType);
		RecieverGroup group =
			recieverGroupPersistence.fetchByPrimaryKey(groupPK);

		if (group.getType() != recieverType) {
			throw new PortalException("type-is-different");
		}

		recieverGroupLocalService.addReciever(groupPK, reciever.getRecieverId());
	}

	public void deleteRecieverGroup(long recieverGroupId)
		throws PortalException, SystemException {

		long userId = getUserId();

		PortletPermissionUtil.check(
			getPermissionChecker(), RecieverKeys.PORTLET_NAME,
			RecieverKeys.UPDATE_ACTION);

		RecieverGroup group =
			recieverGroupLocalService.getRecieverGroup(recieverGroupId);

		if (group.getUserId() != userId) {
			throw new PrincipalException("you-do-not-have-permission");
		}

		recieverGroupPersistence.remove(group);
	}

	public List<RecieverGroup> getRecieverGroups(int type)
		throws PortalException, SystemException {

		long userId = getUserId();

		PortletPermissionUtil.check(
			getPermissionChecker(), RecieverKeys.PORTLET_NAME,
			RecieverKeys.VIEW_ACTION);

		return recieverGroupPersistence.findByUserId_Type(userId, type);
	}

	public void removeRecieverFromGroup(
		long recieverGroupId, long recieverUserId, String recieverUserName,
		int recieverType)
		throws PortalException, SystemException {

		long userId = getUserId();

		PortletPermissionUtil.check(
			getPermissionChecker(), RecieverKeys.PORTLET_NAME,
			RecieverKeys.UPDATE_ACTION);

		Reciever reciever =
			recieverLocalService.getReciever(
				userId, recieverUserId, recieverUserName, recieverType);

		recieverGroupPersistence.removeReciever(
			recieverGroupId, reciever.getRecieverId());
	}

	public RecieverGroup updateRecieverGroup(
		long recieverGroupId, String recieverGroupName, String description,
		int type, boolean active)
		throws PortalException, SystemException {

		long userId = getUserId();

		PortletPermissionUtil.check(
			getPermissionChecker(), RecieverKeys.PORTLET_NAME,
			RecieverKeys.UPDATE_ACTION);

		return recieverGroupLocalService.updateRecieverGroup(
			userId, recieverGroupId, recieverGroupName, description, type,
			active);
	}
}
