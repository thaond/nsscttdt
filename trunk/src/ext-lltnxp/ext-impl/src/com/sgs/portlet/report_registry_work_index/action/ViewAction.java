package com.sgs.portlet.report_registry_work_index.action;

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

import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.struts.PortletAction;

public class ViewAction extends PortletAction {
	private static Log _log = LogFactory.getLog(ViewAction.class);

	private static final boolean _CHECK_METHOD_ON_PROCESS_ACTION = false;

	protected boolean isCheckMethodOnProcessAction() {
		return _CHECK_METHOD_ON_PROCESS_ACTION;
	}

	public void processAction(ActionMapping mapping, ActionForm form,
			PortletConfig config, ActionRequest req, ActionResponse res)
			throws Exception {

		String cmd = ParamUtil.getString(req, Constants.CMD);
		String varAction = ParamUtil.getString(req, "varAction");

		if (!Validator.isNull(cmd)) {
			if (varAction.equals("reportregistry")) {
				if (cmd.equals("SELECT")) {
					selectReportRegistry(req, res);
				}
			}
		}
	}

	public void selectReportRegistry(ActionRequest req, ActionResponse res) {
		try {
			long departmentId = ParamUtil.getLong(req, "department");
			req.setAttribute("departmentId", String.valueOf(departmentId));
		} catch (Exception e) {
			_log.error("ERROR IN METHOD selectReportRegistry OF "
					+ ViewAction.class + " " + e.getMessage());
		}
	}

	public ActionForward render(ActionMapping mapping, ActionForm form,
			PortletConfig config, RenderRequest req, RenderResponse res)
			throws Exception {
		try {
			long departmentId = ParamUtil.getLong(req, "department");
			String dateFrom = ParamUtil.getString(req, "dateFrom");
			String dateTo = ParamUtil.getString(req, "dateTo");
			req.setAttribute("departmentId", String.valueOf(departmentId));
			req.setAttribute("dateFrom", dateFrom);
			req.setAttribute("dateTo", dateTo);
		} catch (Exception e) {
			_log.error("ERROR IN RENDER OF " + ViewAction.class + " "
					+ e.getMessage());
		}
		if (getForward(req) != null && !getForward(req).equals("")) {
			return mapping.findForward(getForward(req));
		} else {
			return mapping.findForward("portlet.sgs.report_registry_work_index.view");
		}
	}
}
