
package com.sgs.portlet.recievergroup.model.impl;

import java.util.ArrayList;
import java.util.List;

import com.liferay.portal.SystemException;
import com.sgs.portlet.recievergroup.model.Reciever;
import com.sgs.portlet.recievergroup.model.RecieverGroup;
import com.sgs.portlet.recievergroup.service.persistence.RecieverGroupUtil;

public class RecieverGroupImpl extends RecieverGroupModelImpl
	implements RecieverGroup {

	public RecieverGroupImpl() {

	}

	public List<Reciever> getRecievers() {

		try {
			return RecieverGroupUtil.getRecievers(getRecieverGroupId());
		}
		catch (SystemException e) {
			e.printStackTrace();
			return new ArrayList<Reciever>();
		}
	}
}
