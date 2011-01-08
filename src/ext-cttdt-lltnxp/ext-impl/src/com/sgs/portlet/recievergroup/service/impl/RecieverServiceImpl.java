
package com.sgs.portlet.recievergroup.service.impl;

import java.util.List;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.service.permission.PortletPermissionUtil;
import com.sgs.portlet.recievergroup.model.Reciever;
import com.sgs.portlet.recievergroup.model.RecieverGroup;
import com.sgs.portlet.recievergroup.service.base.RecieverServiceBaseImpl;
import com.sgs.portlet.recievergroup.util.RecieverKeys;

public class RecieverServiceImpl extends RecieverServiceBaseImpl {

	public Reciever addReciever(
		long recieverUserId, String recieverUserName, int recieverType)
		throws PortalException, SystemException {

		long userId = getUserId();

		PortletPermissionUtil.check(
			getPermissionChecker(), RecieverKeys.PORTLET_NAME,
			RecieverKeys.UPDATE_ACTION);

		return recieverLocalService.addReciever(
			userId, recieverUserId, recieverUserName, recieverType);
	}

	public Reciever getReciever(
		long recieverUserId, String recieverUserName, int recieverType)
		throws PortalException, SystemException {

		long userId = getUserId();

		PortletPermissionUtil.check(
			getPermissionChecker(), RecieverKeys.PORTLET_NAME,
			RecieverKeys.VIEW_ACTION);

		return recieverLocalService.getReciever(
			userId, recieverUserId, recieverUserName, recieverType);
	}

	public List<Reciever> getRecievers(long recieverGroupId)
		throws PortalException, SystemException {

		long userId = getUserId();

		PortletPermissionUtil.check(
			getPermissionChecker(), RecieverKeys.PORTLET_NAME,
			RecieverKeys.VIEW_ACTION);

		RecieverGroup group =
			recieverGroupPersistence.fetchByPrimaryKey(recieverGroupId);

		if ((group == null) || (group.getUserId() != userId)) {
			return null;
		}

		return recieverGroupPersistence.getRecievers(recieverGroupId);
	}

}
