package com.sgs.portlet.document.workflow.command;

import java.io.IOException;

import com.sgs.liferay.jbpm.command.StrutsActionCommandResultProcessor;

/**
 * 
 */

/**
 * @author WIN7
 *
 */
public class SaveAndPublishDocumentSendSupportCommandResultProcessor  extends
		StrutsActionCommandResultProcessor {

	
	@Override
	protected void processResultInStrutsAction(Object res) {
		try {
			response.sendRedirect(getRequest().getParameter("redirect") + "&message="+ ((String)res));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
