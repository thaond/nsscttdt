
package com.sgs.portlet.receivergroup.model.impl;

import java.util.ArrayList;
import java.util.List;

import com.liferay.portal.SystemException;
import com.sgs.portlet.receivergroup.model.Receiver;
import com.sgs.portlet.receivergroup.model.ReceiverGroup;
import com.sgs.portlet.receivergroup.service.persistence.ReceiverGroupUtil;

public class ReceiverGroupImpl extends ReceiverGroupModelImpl
	implements ReceiverGroup {

	public ReceiverGroupImpl() {

	}

	public List<Receiver> getReceivers() {

		try {
			return ReceiverGroupUtil.getReceivers(getReceiverGroupId());
		}
		catch (SystemException e) {
			e.printStackTrace();
			return new ArrayList<Receiver>();
		}
	}
}
