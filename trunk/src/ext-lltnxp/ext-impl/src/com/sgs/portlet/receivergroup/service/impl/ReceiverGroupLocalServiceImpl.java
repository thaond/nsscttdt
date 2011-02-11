
package com.sgs.portlet.receivergroup.service.impl;

import java.util.Date;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.sgs.portlet.receivergroup.model.ReceiverGroup;
import com.sgs.portlet.receivergroup.service.base.ReceiverGroupLocalServiceBaseImpl;

public class ReceiverGroupLocalServiceImpl
	extends ReceiverGroupLocalServiceBaseImpl {

	public void addReceiver(long receiverGroupPK, long receiverPK)
		throws SystemException {

		receiverGroupPersistence.addReceiver(receiverGroupPK, receiverPK);
	}

	public void removeReceiver(long receiverGroupPK, long receiverPK)
		throws SystemException {

		receiverGroupPersistence.removeReceiver(receiverGroupPK, receiverPK);
	}

	public ReceiverGroup updateReceiverGroup(
		long userId, long receiverGroupId, String receiverGroupName,
		String description, int type, boolean active)
		throws PortalException, SystemException {

		ReceiverGroup group;
		ReceiverGroup groupTemp =
			receiverGroupPersistence.fetchByUID_Name(userId, receiverGroupName);
		if ((receiverGroupId < 1) && (groupTemp != null)) {
			throw new PortalException("this-name-already-exists");
		}
		Date now = new Date();
		if (receiverGroupId > 0) {
			group = receiverGroupPersistence.findByPrimaryKey(receiverGroupId);
			if (group.getUserId() != userId) {
				throw new PortalException("you-do-not-have-permission");
			}
		}
		else {
			User user = UserLocalServiceUtil.getUser(userId);
			group =
				receiverGroupPersistence.create(CounterLocalServiceUtil.increment(ReceiverGroup.class.getName()));
			group.setCompanyId(user.getCompanyId());
			group.setUserId(userId);
			group.setUserName(user.getScreenName());
			group.setCreateDate(now);
			group.setType(type);
		}

		group.setModifiedDate(now);
		if (!group.getReceiverGroupName().equals(receiverGroupName) &&
			(groupTemp != null)) {
			throw new PortalException("this-name-already-exists");
		}
		else {
			group.setReceiverGroupName(receiverGroupName);
		}
		group.setDescription(description);
		group.setActive(active);

		return receiverGroupPersistence.update(group, false);
	}
}
