
package com.sgs.portlet.recievergroup.service.impl;

import java.util.Date;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.sgs.portlet.recievergroup.model.RecieverGroup;
import com.sgs.portlet.recievergroup.service.base.RecieverGroupLocalServiceBaseImpl;

public class RecieverGroupLocalServiceImpl
	extends RecieverGroupLocalServiceBaseImpl {

	public void addReciever(long recieverGroupPK, long recieverPK)
		throws SystemException {

		recieverGroupPersistence.addReciever(recieverGroupPK, recieverPK);
	}

	public void removeReciever(long recieverGroupPK, long recieverPK)
		throws SystemException {

		recieverGroupPersistence.removeReciever(recieverGroupPK, recieverPK);
	}

	public RecieverGroup updateRecieverGroup(
		long userId, long recieverGroupId, String recieverGroupName,
		String description, int type, boolean active)
		throws PortalException, SystemException {

		RecieverGroup group;
		RecieverGroup groupTemp =
			recieverGroupPersistence.fetchByUID_Name(userId, recieverGroupName);
		if ((recieverGroupId < 1) && (groupTemp != null)) {
			throw new PortalException("this-name-already-exists");
		}
		Date now = new Date();
		if (recieverGroupId > 0) {
			group = recieverGroupPersistence.findByPrimaryKey(recieverGroupId);
			if (group.getUserId() != userId) {
				throw new PortalException("you-do-not-have-permission");
			}
		}
		else {
			User user = UserLocalServiceUtil.getUser(userId);
			group =
				recieverGroupPersistence.create(CounterLocalServiceUtil.increment(RecieverGroup.class.getName()));
			group.setCompanyId(user.getCompanyId());
			group.setUserId(userId);
			group.setUserName(user.getScreenName());
			group.setCreateDate(now);
			group.setType(type);
		}

		group.setModifiedDate(now);
		if (!group.getRecieverGroupName().equals(recieverGroupName) &&
			(groupTemp != null)) {
			throw new PortalException("this-name-already-exists");
		}
		else {
			group.setRecieverGroupName(recieverGroupName);
		}
		group.setDescription(description);
		group.setActive(active);

		return recieverGroupPersistence.update(group, false);
	}
}
