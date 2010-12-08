/**
 * 
 */

package com.nss.workflow.command;

import java.io.IOException;

import com.sgs.liferay.jbpm.command.StrutsActionCommandResultProcessor;

/**
 * @author hieuvh
 */
public class AddWorkflowJournalArticleCommandResultProcessor
	extends StrutsActionCommandResultProcessor {

	@Override
	protected void processResultInStrutsAction(Object result) {

		try {
			String url = getRequest().getParameter("redirect").trim();

			if (!"".equals(String.valueOf(result))) {
				response.sendRedirect(String.valueOf(result));
			}
			else if (!"".equals(url.trim())) {
				response.sendRedirect(url + String.valueOf(result));
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}
