/**
 *
 */

package com.sgs.portlet.onedoorpcccprocess.action;

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

import com.sgs.liferay.jbpm.param.WorkflowParam;
import com.sgs.portlet.onedoor.workflow.OneDoorProcessPortletAction;

/**
 * @author kienbqc
 */
public class InBienNhanAction extends OneDoorProcessPortletAction {

	private static Log _log = LogFactory.getLog(InBienNhanAction.class);

	public void processStrutsAction(
			ActionMapping mapping, ActionForm form, PortletConfig config,
			ActionRequest req, ActionResponse res) throws Exception {
		addWorkflowParameter(req, "path", WorkflowParam.TRANSIENT, getServlet().getServletContext().getRealPath("reports"));
//		System.out.println(getServlet().getServletContext().getRealPath("reports") + "AddAction");
//		_log.info("----------process");
	}

	public ActionForward renderStruts(
			ActionMapping mapping, ActionForm form, PortletConfig config,
			RenderRequest req, RenderResponse res)
			throws Exception {

		return mapping.findForward("portlet.sgs.onedoorpcccprocess.view");
	}
}
