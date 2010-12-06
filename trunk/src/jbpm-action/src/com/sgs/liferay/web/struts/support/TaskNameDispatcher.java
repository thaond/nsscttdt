/**
 * 
 */
package com.sgs.liferay.web.struts.support;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.apache.struts.action.ActionMapping;

/**
 * @author hieuvh
 *
 */
public interface TaskNameDispatcher {
	
	String dispatchToAction(String taskName, ActionMapping mapping, RenderRequest renderRequest,
			RenderResponse renderResponse);
	
	
	String dispatchToView(String taskName, ActionMapping mapping, RenderRequest renderRequest,
			RenderResponse renderResponse);
}
