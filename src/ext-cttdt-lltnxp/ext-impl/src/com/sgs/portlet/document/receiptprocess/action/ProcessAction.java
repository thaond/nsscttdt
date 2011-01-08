/**
 * Luu thong tin xu ly cong van.
 * Sau khi luu tru thong tin da xu ly, he thong chuyen sang trang 
 * danh sach (display.jsp)
 */

package com.sgs.portlet.document.receiptprocess.action;

import java.util.Date;

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
import com.sgs.portlet.document.workflow.DocumentReceiptPortletAction;

/**
 * @author doanhdv
 * @author hieuvh
 */
public class ProcessAction extends DocumentReceiptPortletAction {

	private static Log _log = LogFactory.getLog(ProcessAction.class);

	/*
	 * (non-Javadoc)
	 * @see
	 * com.sgs.liferay.web.struts.action.WorkflowPortletAction#processStrutsAction
	 * (org.apache.struts.action.ActionMapping,
	 * org.apache.struts.action.ActionForm, javax.portlet.PortletConfig,
	 * javax.portlet.ActionRequest, javax.portlet.ActionResponse)
	 */
	public void processStrutsAction(
		ActionMapping mapping, ActionForm form, PortletConfig config,
		ActionRequest req, ActionResponse res)
		throws Exception {

		long processor = PortalUtil.getUserId(req);
		Date date = new Date();
		String processContent = ParamUtil.getString(req, "processContent");
		addWorkflowParameter(
			req, "processInformation", WorkflowParam.TRANSIENT,
			ParamUtil.getString(req, "processInformation"));
		addWorkflowParameter(
			req, "processor", WorkflowParam.TRANSIENT,
			String.valueOf(processor));
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * com.sgs.liferay.web.struts.action.WorkflowPortletAction#renderStruts(
	 * org.apache.struts.action.ActionMapping,
	 * org.apache.struts.action.ActionForm, javax.portlet.PortletConfig,
	 * javax.portlet.RenderRequest, javax.portlet.RenderResponse)
	 */
	public ActionForward renderStruts(
		ActionMapping mapping, ActionForm form, PortletConfig config,
		RenderRequest req, RenderResponse res)
		throws Exception {

		return null;
	}
}
