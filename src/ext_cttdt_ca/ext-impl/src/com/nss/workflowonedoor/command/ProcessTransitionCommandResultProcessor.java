/**
 * 
 */
package com.nss.workflowonedoor.command;

import java.io.IOException;

import com.sgs.liferay.jbpm.command.StrutsActionCommandResultProcessor;

/**
 * @author hieuvh
 *
 */
public class ProcessTransitionCommandResultProcessor extends
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
