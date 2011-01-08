
package com.sgs.portlet.recievergroup.model.impl;

import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace;
import com.sgs.portlet.pmlissuingplace.service.PmlEdmIssuingPlaceLocalServiceUtil;
import com.sgs.portlet.recievergroup.model.Reciever;
import com.sgs.portlet.recievergroup.util.RecieverKeys;

public class RecieverImpl extends RecieverModelImpl implements Reciever {

	public RecieverImpl() {

	}

	public String getViewName() {

		try {
			switch (getRecieverType()) {
			case RecieverKeys.PORSONAL:

				User user = UserLocalServiceUtil.getUser(getRecieverUserId());
				StringBuilder sb = new StringBuilder();
				sb.append(user.getLastName());
				sb.append(" ");
				sb.append(user.getMiddleName());
				sb.append(" ");
				sb.append(user.getFirstName());
				return sb.toString();

			case RecieverKeys.ORGANIZATION:

				PmlEdmIssuingPlace edmIssuingPlace =
					PmlEdmIssuingPlaceLocalServiceUtil.getPmlEdmIssuingPlace(getRecieverUserName());
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
