
package com.sgs.portlet.recievergroup.service.impl;

import java.util.Date;
import java.util.List;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.sgs.portlet.recievergroup.model.Reciever;
import com.sgs.portlet.recievergroup.service.base.RecieverLocalServiceBaseImpl;
import com.sgs.portlet.recievergroup.util.RecieverKeys;

public class RecieverLocalServiceImpl extends RecieverLocalServiceBaseImpl {

	public Reciever addReciever(
		long userId, long recieverUserId, String recieverUserName,
		int recieverType)
		throws SystemException, PortalException {

		User user = UserLocalServiceUtil.getUser(userId);
		Reciever reciever = null;

		switch (recieverType) {
		case RecieverKeys.PORSONAL:
			reciever =
				recieverPersistence.fetchByUID_RUID_Type(
					userId, recieverUserId, recieverType);

			break;
		case RecieverKeys.DEPARTMENT:

			break;
		case RecieverKeys.ORGANIZATION:
			reciever =
				recieverPersistence.fetchByUID_RCN_Type(
					userId, recieverUserName, recieverType);

			break;
		}

		Date now = new Date();

		if (reciever == null) {
			reciever =
				recieverPersistence.create(CounterLocalServiceUtil.increment(Reciever.class.getName()));

			reciever.setCompanyId(user.getCompanyId());
			reciever.setUserId(userId);
			reciever.setUserName(user.getScreenName());
			reciever.setCreateDate(now);
		}

		reciever.setModifiedDate(now);

		reciever.setRecieverUserId(recieverUserId);
		reciever.setRecieverUserName(recieverUserName);
		reciever.setRecieverType(recieverType);

		return updateReciever(reciever);
	}

	/**
	 * Lay users theo ten va ten dang nhap
	 * 
	 * @author canhminh
	 */
	public List<User> findUsersByFullname_ScreenName(long companyId, String name)
		throws SystemException {

		return recieverFinder.findUserByFullName(companyId, name);
	}

	public Reciever getReciever(
		long userId, long recieverUserId, String recieverUserName,
		int recieverType)
		throws PortalException, SystemException {

		Reciever reciever = null;
		switch (recieverType) {
		case RecieverKeys.PORSONAL:
			reciever =
				recieverPersistence.fetchByUID_RUID_Type(
					userId, recieverUserId, recieverType);

			break;
		case RecieverKeys.DEPARTMENT:

			break;
		case RecieverKeys.ORGANIZATION:
			reciever =
				recieverPersistence.fetchByUID_RCN_Type(
					userId, recieverUserName, recieverType);

			break;
		}

		return reciever;
	}

}
