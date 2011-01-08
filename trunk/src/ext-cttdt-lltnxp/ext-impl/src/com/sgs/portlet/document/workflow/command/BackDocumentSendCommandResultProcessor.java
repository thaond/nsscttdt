package com.sgs.portlet.document.workflow.command;

import java.io.IOException;

import com.sgs.liferay.jbpm.command.StrutsActionCommandResultProcessor;

public class BackDocumentSendCommandResultProcessor extends
		StrutsActionCommandResultProcessor {

	@Override
	protected void processResultInStrutsAction(Object result) {
		try {
			response.sendRedirect(getRequest().getParameter("redirect"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
