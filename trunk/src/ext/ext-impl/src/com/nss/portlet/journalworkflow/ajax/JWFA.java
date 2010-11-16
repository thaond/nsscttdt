package com.nss.portlet.journalworkflow.ajax;

import java.util.ArrayList;
import java.util.List;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.nss.portlet.journalworkflow.model.JournalProcessDefinition;
import com.nss.portlet.journalworkflow.service.JournalProcessDefinitionLocalServiceUtil;
import com.nss.portlet.journalworkflow.util.XmlRead;

public class JWFA {
	public List<String> getTaskNode(long bpid) {
		List<String> result = new ArrayList<String>();
		try {
			JournalProcessDefinition processDefinition = JournalProcessDefinitionLocalServiceUtil.getJournalProcessDefinition(bpid);
			result = XmlRead.getNodeName("task-node", processDefinition.getContent());
		} catch (PortalException e) {
			e.printStackTrace();
		} catch (SystemException e) {
			e.printStackTrace();
		}
		return result;
	}
}
