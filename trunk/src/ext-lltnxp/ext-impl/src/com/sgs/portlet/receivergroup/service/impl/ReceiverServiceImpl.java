
package com.sgs.portlet.receivergroup.service.impl;

import java.util.List;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.service.permission.PortletPermissionUtil;
import com.sgs.portlet.receivergroup.model.Receiver;
import com.sgs.portlet.receivergroup.model.ReceiverGroup;
import com.sgs.portlet.receivergroup.service.base.ReceiverServiceBaseImpl;
import com.sgs.portlet.receivergroup.util.ReceiverKeys;

public class ReceiverServiceImpl extends ReceiverServiceBaseImpl {

	public Receiver addReceiver(
		long receiverUserId, String receiverUserName, int receiverType)
		throws PortalException, SystemException {

		long userId = getUserId();

		PortletPermissionUtil.check(
			getPermissionChecker(), ReceiverKeys.PORTLET_NAME,
			ReceiverKeys.UPDATE_ACTION);

		return receiverLocalService.addReceiver(
			userId, receiverUserId, receiverUserName, receiverType);
	}

	public Receiver getReceiver(
		long receiverUserId, String receiverUserName, int receiverType)
		throws PortalException, SystemException {

		long userId = getUserId();

		PortletPermissionUtil.check(
			getPermissionChecker(), ReceiverKeys.PORTLET_NAME,
			ReceiverKeys.VIEW_ACTION);

		return receiverLocalService.getReceiver(
			userId, receiverUserId, receiverUserName, receiverType);
	}

	public List<Receiver> getReceivers(long receiverGroupId)
		throws PortalException, SystemException {

		long userId = getUserId();

		PortletPermissionUtil.check(
			getPermissionChecker(), ReceiverKeys.PORTLET_NAME,
			ReceiverKeys.VIEW_ACTION);

		ReceiverGroup group =
			receiverGroupPersistence.fetchByPrimaryKey(receiverGroupId);

		if ((group == null) || (group.getUserId() != userId)) {
			return null;
		}

		return receiverGroupPersistence.getReceivers(receiverGroupId);
	}

}
