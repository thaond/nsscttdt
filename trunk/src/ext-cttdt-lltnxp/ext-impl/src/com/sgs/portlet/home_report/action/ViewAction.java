package com.sgs.portlet.home_report.action;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.struts.PortletAction;
import com.liferay.portal.util.PortalUtil;
import com.sgs.portlet.home_report.search.HomeReportDisplayTerms;
import com.sgs.portlet.pmluser.service.persistence.PmlUserUtil;

public class ViewAction extends PortletAction {
	
	public void processAction(ActionMapping mapping, ActionForm form,
			PortletConfig config, ActionRequest req, ActionResponse res)
			throws Exception {
		/*
		 * Process Action Code Goes Here
		 * 
		 * */
	}

	
	public ActionForward render(ActionMapping mapping, ActionForm form,
			PortletConfig config, RenderRequest req, RenderResponse res)
			throws Exception {
			if (getForward(req) != null && !getForward(req).equals("")) {
				return mapping.findForward(getForward(req)); // Use forward set in processAction if available
			} else {
				
				long userLogin = PortalUtil.getUserId(req);
				String departmentIdOfUserLogin = PmlUserUtil.findByPrimaryKey(userLogin).getDepartmentsId();
				
				long userIdChoice = ParamUtil.getLong(req, HomeReportDisplayTerms.USERID, 0);
				String departmentIdChoice = ParamUtil.getString(req, HomeReportDisplayTerms.DEPARTMENTID, "");
				String loaiThongKe = ParamUtil.getString(req, HomeReportDisplayTerms.LOAITHONGKE, "");
				String fromDate = ParamUtil.getString(req, HomeReportDisplayTerms.FROMDATE, "");
				String toDate = ParamUtil.getString(req, HomeReportDisplayTerms.TODATE, "");
				
				req.setAttribute("userId", userLogin);
				req.setAttribute("departmentId", departmentIdOfUserLogin);

				req.setAttribute("userIdChoice", userIdChoice);
				req.setAttribute("departmentIdChoice", departmentIdChoice);
				req.setAttribute("loaiThongKe", loaiThongKe);
				req.setAttribute("toDate", toDate);
				req.setAttribute("fromDate", fromDate);
				
				return mapping.findForward("portlet.sgs.home_report.view");
			}
	}

}
