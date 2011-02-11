
package com.sgs.portlet.receivergroup.service.impl;

import java.util.List;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.service.permission.PortletPermissionUtil;
import com.sgs.portlet.receivergroup.model.Receiver;
import com.sgs.portlet.receivergroup.model.ReceiverGroup;
import com.sgs.portlet.receivergroup.service.base.ReceiverGroupServiceBaseImpl;
import com.sgs.portlet.receivergroup.util.ReceiverKeys;

public class ReceiverGroupServiceImpl extends ReceiverGroupServiceBaseImpl {

	public void addReceiverToGroup(
		long groupPK, long receiverUserId, String receiverUserName,
		int receiverType)
		throws PortalException, SystemException {

		long userId = getUserId();

		PortletPermissionUtil.check(
			getPermissionChecker(), ReceiverKeys.PORTLET_NAME,
			ReceiverKeys.UPDATE_ACTION);

		Receiver receiver =
			receiverLocalService.addReceiver(
				userId, receiverUserId, receiverUserName, receiverType);
		ReceiverGroup group =
			receiverGroupPersistence.fetchByPrimaryKey(groupPK);

		if (group.getType() != receiverType) {
			throw new PortalException("type-is-different");
		}

		receiverGroupLocalService.addReceiver(groupPK, receiver.getReceiverId());
	}

	public void deleteReceiverGroup(long receiverGroupId)
		throws PortalException, SystemException {

		long userId = getUserId();

		PortletPermissionUtil.check(
			getPermissionChecker(), ReceiverKeys.PORTLET_NAME,
			ReceiverKeys.UPDATE_ACTION);

		ReceiverGroup group =
			receiverGroupLocalService.getReceiverGroup(receiverGroupId);

		if (group.getUserId() != userId) {
			throw new PrincipalException("you-do-not-have-permission");
		}

		receiverGroupPersistence.remove(group);
	}

	public List<ReceiverGroup> getReceiverGroups(int type)
		throws PortalException, SystemException {

		long userId = getUserId();

		PortletPermissionUtil.check(
			getPermissionChecker(), ReceiverKeys.PORTLET_NAME,
			ReceiverKeys.VIEW_ACTION);

		return receiverGroupPersistence.findByUserId_Type(userId, type);
	}

	public void removeReceiverFromGroup(
		long receiverGroupId, long receiverUserId, String receiverUserName,
		int receiverType)
		throws PortalException, SystemException {

		long userId = getUserId();

		PortletPermissionUtil.check(
			getPermissionChecker(), ReceiverKeys.PORTLET_NAME,
			ReceiverKeys.UPDATE_ACTION);

		Receiver receiver =
			receiverLocalService.getReceiver(
				userId, receiverUserId, receiverUserName, receiverType);

		receiverGroupPersistence.removeReceiver(
			receiverGroupId, receiver.getReceiverId());
	}

	public ReceiverGroup updateReceiverGroup(
		long receiverGroupId, String receiverGroupName, String description,
		int type, boolean active)
		throws PortalException, SystemException {

		long userId = getUserId();

		PortletPermissionUtil.check(
			getPermissionChecker(), ReceiverKeys.PORTLET_NAME,
			ReceiverKeys.UPDATE_ACTION);

		return receiverGroupLocalService.updateReceiverGroup(
			userId, receiverGroupId, receiverGroupName, description, type,
			active);
	}
}
