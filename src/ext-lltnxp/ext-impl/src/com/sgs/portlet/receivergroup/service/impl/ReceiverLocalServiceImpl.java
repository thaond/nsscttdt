
package com.sgs.portlet.receivergroup.service.impl;

import java.util.Date;
import java.util.List;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.sgs.portlet.receivergroup.model.Receiver;
import com.sgs.portlet.receivergroup.service.base.ReceiverLocalServiceBaseImpl;
import com.sgs.portlet.receivergroup.util.ReceiverKeys;

public class ReceiverLocalServiceImpl extends ReceiverLocalServiceBaseImpl {

	public Receiver addReceiver(
		long userId, long receiverUserId, String receiverUserName,
		int receiverType)
		throws SystemException, PortalException {

		User user = UserLocalServiceUtil.getUser(userId);
		Receiver receiver = null;

		switch (receiverType) {
		case ReceiverKeys.PERSONAL:
			receiver =
				receiverPersistence.fetchByUID_RUID_Type(
					userId, receiverUserId, receiverType);

			break;
		case ReceiverKeys.DEPARTMENT:

			break;
		case ReceiverKeys.ORGANIZATION:
			receiver =
				receiverPersistence.fetchByUID_RCN_Type(
					userId, receiverUserName, receiverType);

			break;
		}

		Date now = new Date();

		if (receiver == null) {
			receiver =
				receiverPersistence.create(CounterLocalServiceUtil.increment(Receiver.class.getName()));

			receiver.setCompanyId(user.getCompanyId());
			receiver.setUserId(userId);
			receiver.setUserName(user.getScreenName());
			receiver.setCreateDate(now);
		}

		receiver.setModifiedDate(now);

		receiver.setReceiverUserId(receiverUserId);
		receiver.setReceiverUserName(receiverUserName);
		receiver.setReceiverType(receiverType);

		return updateReceiver(receiver);
	}

	/**
	 * Lay users theo ten va ten dang nhap
	 * 
	 * @author canhminh
	 */
	public List<User> findUsersByFullname_ScreenName(long companyId, String name)
		throws SystemException {

		return receiverFinder.findUserByFullName(companyId, name);
	}

	public Receiver getReceiver(
		long userId, long receiverUserId, String receiverUserName,
		int receiverType)
		throws PortalException, SystemException {

		Receiver receiver = null;
		switch (receiverType) {
		case ReceiverKeys.PERSONAL:
			receiver =
				receiverPersistence.fetchByUID_RUID_Type(
					userId, receiverUserId, receiverType);

			break;
		case ReceiverKeys.DEPARTMENT:

			break;
		case ReceiverKeys.ORGANIZATION:
			receiver =
				receiverPersistence.fetchByUID_RCN_Type(
					userId, receiverUserName, receiverType);

			break;
		}

		return receiver;
	}

}
