/**
 * 
 */
package com.sgs.liferay.jbpm.command;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

/**
 * @author hieuvh
 *
 */
public abstract class StrutsActionCommandResultProcessor implements
		CommandResultProcessor {
	protected ActionRequest request;
	protected ActionResponse response;
	
	public void setRequestResponse(ActionRequest req, ActionResponse res) {
		request = req;
		response = res;
	}

	/* (non-Javadoc)
	 * @see com.sgs.liferay.jbpm.command.CommandResultProcessor#processResult(java.lang.Object)
	 */
	public void processResult(Object commandRusult) {
		if (request == null || response == null) {
			// do nothing.
			return;
		}
		
		processResultInStrutsAction(commandRusult);
	}

	/**
	 * process command result in struts action with actionRequest and ActionResponse 
	 * @param commandRusult
	 */
	protected abstract void processResultInStrutsAction(Object commandRusult);

	/**
	 * @return the request
	 */
	public ActionRequest getRequest() {
		return request;
	}

	/**
	 * @param request the request to set
	 */
	public void setRequest(ActionRequest request) {
		this.request = request;
	}

	/**
	 * @return the response
	 */
	public ActionResponse getResponse() {
		return response;
	}

	/**
	 * @param response the response to set
	 */
	public void setResponse(ActionResponse response) {
		this.response = response;
	}
	
	
}
