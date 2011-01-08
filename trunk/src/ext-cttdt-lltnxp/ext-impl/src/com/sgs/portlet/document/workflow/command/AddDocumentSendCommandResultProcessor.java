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
public class AddDocumentSendCommandResultProcessor extends
		StrutsActionCommandResultProcessor {

	
	@Override
	protected void processResultInStrutsAction(Object arg0) {
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
