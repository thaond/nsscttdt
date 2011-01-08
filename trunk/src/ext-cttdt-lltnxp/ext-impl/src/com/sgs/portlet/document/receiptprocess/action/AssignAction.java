/**
 * 
 */
package com.sgs.portlet.document.receiptprocess.action;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.util.PortalUtil;
import com.sgs.liferay.jbpm.param.WorkflowParam;
import com.sgs.portlet.document.receipt.util.Constants;
import com.sgs.portlet.document.workflow.DocumentReceiptPortletAction;

/**
 * AssignAction class can use to set assign information 
 * in workflow (processStrutsAction method)
 * 
 * @version 1.5 10 Apr 2009
 * @author doanhdv
 * @author kienbqc
 */
public class AssignAction extends DocumentReceiptPortletAction {
	private static Log _log = LogFactory.getLog(AssignAction.class);
	
	public void processStrutsAction(ActionMapping mapping, ActionForm form,
			PortletConfig config, ActionRequest req, ActionResponse res)
			throws Exception {
		
		_log.info("assign receipt");
		
		/* 
		 * Get parameter form request: 
		 * - userIds 
		 * - mainProcess
		 * - daysProcess
		 * - processInformation
		 */
		long[] userIds = ParamUtil.getLongValues(req, "userIds", new long[] {} );
		long mainProcess = ParamUtil.getLong(req, "mainProcess"); //xu ly chinh
		int daysProcess = ParamUtil.getInteger(req, "daysProcess");
		String processInformation = ParamUtil.getString(req, "processInformation");
		
		_log.info("userIds: " + userIds.length);
		_log.info("mainProcess: " + mainProcess);
		_log.info("daysProcess: " + daysProcess);
		_log.info("processInformation: " + processInformation);
		
		String supportedUsers = "";
		
		for (int i = 0; i < userIds.length; i++) {
			
			if (userIds[i] == mainProcess) {
				continue;
			}
			
			supportedUsers += userIds[i];
			if (i + 1 < userIds.length) {
				supportedUsers += Constants.USER_SEPERATOR;
			}
		}
		
		/* set information into workflow */
		addWorkflowParameter(req, "mainUser", WorkflowParam.TRANSIENT, "" + mainProcess);
		addWorkflowParameter(req, "supportedUsers", WorkflowParam.TRANSIENT, supportedUsers);
		addWorkflowParameter(req, "processor", WorkflowParam.TRANSIENT, String.valueOf(PortalUtil.getUserId(req)));
	}

	public ActionForward renderStruts(ActionMapping mapping, ActionForm form,
			PortletConfig config, RenderRequest req, RenderResponse res)
			throws Exception {

		if (getForward(req) != null && !getForward(req).equals("")) {
			return mapping.findForward(getForward(req)); // Use forward set in processAction if available
		} else {
			return mapping.findForward("portlet.sgs.document.receipt.view");
		}
	}
}
