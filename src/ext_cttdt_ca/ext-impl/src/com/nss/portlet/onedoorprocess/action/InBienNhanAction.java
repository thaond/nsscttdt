/**
 *
 */

package com.nss.portlet.onedoorprocess.action;

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

import com.nss.workflowonedoor.OneDoorProcessPortletAction;
import com.sgs.liferay.jbpm.param.WorkflowParam;

/**
 * @author kienbqc
 */
public class InBienNhanAction extends OneDoorProcessPortletAction {

	private static Log _log = LogFactory.getLog(InBienNhanAction.class);

	public void processStrutsAction(
			ActionMapping mapping, ActionForm form, PortletConfig config,
			ActionRequest req, ActionResponse res) throws Exception {
		addWorkflowParameter(req, "path", WorkflowParam.TRANSIENT, getServlet().getServletContext().getRealPath("reports"));
	}

	public ActionForward renderStruts(
			ActionMapping mapping, ActionForm form, PortletConfig config,
			RenderRequest req, RenderResponse res)
			throws Exception {

		return mapping.findForward("portlet.nss.onedoorprocess.view");
	}
}
