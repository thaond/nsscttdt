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
public class AddFileCommandResultProcessor extends
		StrutsActionCommandResultProcessor {

	@Override
	protected void processResultInStrutsAction(Object result) {
		try {
			String url = getRequest().getParameter("redirect").trim();
			if(!"".equals(url.trim())) {
				response.sendRedirect(url);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
