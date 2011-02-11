
package com.sgs.portlet.receivergroup.model.impl;

import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace;
import com.sgs.portlet.pmlissuingplace.service.PmlEdmIssuingPlaceLocalServiceUtil;
import com.sgs.portlet.receivergroup.model.Receiver;
import com.sgs.portlet.receivergroup.util.ReceiverKeys;

public class ReceiverImpl extends ReceiverModelImpl implements Receiver {

	public ReceiverImpl() {

	}

	public String getViewName() {

		try {
			switch (getReceiverType()) {
			case ReceiverKeys.PERSONAL:

				User user = UserLocalServiceUtil.getUser(getReceiverUserId());
				StringBuilder sb = new StringBuilder();
				sb.append(user.getLastName());
				sb.append(" ");
				sb.append(user.getMiddleName());
				sb.append(" ");
				sb.append(user.getFirstName());
				return sb.toString();

			case ReceiverKeys.ORGANIZATION:

				PmlEdmIssuingPlace edmIssuingPlace =
					PmlEdmIssuingPlaceLocalServiceUtil.getPmlEdmIssuingPlace(getReceiverUserName());
				return edmIssuingPlace.getIssuingPlaceName();

			default:
				return "";
			}
		}
		catch (Exception e) {
			return "";
		}
	}
}
