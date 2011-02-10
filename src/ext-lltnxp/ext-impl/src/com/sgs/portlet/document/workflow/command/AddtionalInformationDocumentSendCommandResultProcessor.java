/**
 * 
 */
package com.sgs.portlet.document.workflow.command;

import java.io.IOException;

import com.sgs.liferay.jbpm.command.StrutsActionCommandResultProcessor;

/**
 * @author hieuvh
 *
 */
public class AddtionalInformationDocumentSendCommandResultProcessor extends
		StrutsActionCommandResultProcessor {

	
	@Override
	protected void processResultInStrutsAction(Object arg0) {
		try {
			response.sendRedirect(getRequest().getParameter("redirect"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
