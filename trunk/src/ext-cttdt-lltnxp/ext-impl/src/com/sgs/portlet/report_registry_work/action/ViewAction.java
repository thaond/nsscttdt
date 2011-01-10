package com.sgs.portlet.report_registry_work.action;

import java.util.List;

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

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.struts.PortletAction;
import com.liferay.portal.util.PortalUtil;
import com.sgs.portlet.report_registry_work.model.Department;
import com.sgs.portlet.report_registry_work.model.ReportRegistry;
import com.sgs.portlet.report_registry_work.service.DepartmentLocalServiceUtil;

public class ViewAction extends PortletAction {
	private static Log _log = LogFactory.getLog(ViewAction.class);
	
	private static final boolean _CHECK_METHOD_ON_PROCESS_ACTION = false;
	
	protected boolean isCheckMethodOnProcessAction() {
		return _CHECK_METHOD_ON_PROCESS_ACTION;
	}
	
	public void processAction(ActionMapping mapping, ActionForm form, 
			PortletConfig config, ActionRequest req, ActionResponse res) throws Exception {
		
		String redirect = ParamUtil.getString(req, "redirect", "/sgs/report_registry_work/view");
		String cmd = ParamUtil.getString(req, Constants.CMD);
		String varAction = ParamUtil.getString(req, "varAction");
		
		if (!Validator.isNull(cmd) && varAction.equals("department")) {
			if(cmd.equals(Constants.ADD)){
				addDepartment(req);
				sendRedirect(req, res, redirect);
			}else if(cmd.equals(Constants.EDIT)){
				editDepartment(req);
			}else if(cmd.equals(Constants.UPDATE)){
				updateDepartment(req, res);
				sendRedirect(req, res, redirect);
			}else if(cmd.equals(Constants.DELETE)){
				deleteDepartment(req, res, redirect);
			}
		}
	}

	public void addDepartment(ActionRequest req) {
		String code = ParamUtil.getString(req, "departmentCode");
		String name = ParamUtil.getString(req, "departmentName");
		String description = ParamUtil.getString(req, "departmentDescription");
		long userId = PortalUtil.getUserId(req);
		long companyId = 0;

		try {
			userId = PortalUtil.getUserId(req);
			if (userId != 0) {
				User user = UserLocalServiceUtil.getUser(userId);
				companyId = user.getCompanyId();
				long departmentId = CounterLocalServiceUtil.increment();
				Department department = DepartmentLocalServiceUtil.createDepartment(departmentId);
				department.setDepartmentCode(code);
				department.setDepartmentName(name);
				department.setDepartmentDescription(description);
				department.setUserId(userId);
				department.setCompanyId(companyId);
				DepartmentLocalServiceUtil.addDepartment(department);
			}
		} catch (Exception e) {
			_log.error("ERROR IN METHOD addDepartment OF " + ViewAction.class + " " + e.getMessage());
		}
	}

	public void editDepartment(ActionRequest req) {
		long departmentId = ParamUtil.getLong(req, "departmentId");
		long userId = PortalUtil.getUserId(req);
		try {
			if(userId != 0){
				Department department = DepartmentLocalServiceUtil.getDepartment(departmentId);
				req.setAttribute("department", department);
			}
		} catch (Exception e) {
			_log.error("ERROR IN METHOD editDepartment OF " + ViewAction.class + " " + e.getMessage());
		}	
	}
	
	public void updateDepartment(ActionRequest req, ActionResponse res) {
		long departmentId = ParamUtil.getLong(req, "departmentId");
		String code = ParamUtil.getString(req, "departmentCode");
		String name = ParamUtil.getString(req, "departmentName");
		String description = ParamUtil.getString(req, "departmentDescription");
		long userId = PortalUtil.getUserId(req);

		try {
			userId = PortalUtil.getUserId(req);
			if (userId != 0) {
				Department department = DepartmentLocalServiceUtil.getDepartment(departmentId);
				department.setDepartmentCode(code);
				department.setDepartmentName(name);
				department.setDepartmentDescription(description);
				DepartmentLocalServiceUtil.updateDepartment(department);
			}
		} catch (Exception e) {
			_log.error("ERROR IN METHOD updateDepartment OF " + ViewAction.class + " " + e.getMessage());
		}
	}
	
	public void deleteDepartment(ActionRequest req, ActionResponse res, String redirect) {
		long departmentId = ParamUtil.getLong(req, "departmentId");
		long userId = PortalUtil.getUserId(req);
		try {
			if(userId != 0){
				Department department = DepartmentLocalServiceUtil.getDepartment(departmentId);
				List<ReportRegistry> reportRegistries = DepartmentLocalServiceUtil.getReportRegistries(departmentId);
				if(reportRegistries.size()>0){
					DepartmentLocalServiceUtil.deleteDepartment(department);
				}else{
					req.setAttribute("error_delete_department", "error_delete_department");
				}
			}
		} catch (Exception e) {
			_log.error("ERROR IN METHOD deleteDepartment OF " + ViewAction.class + " " + e.getMessage());
		}
	}

	public ActionForward render(ActionMapping mapping, ActionForm form,
			PortletConfig config, RenderRequest req, RenderResponse res)
			throws Exception {
			if (getForward(req) != null && !getForward(req).equals("")) {
				return mapping.findForward(getForward(req));
			} else {
				return mapping.findForward("portlet.sgs.report_registry_work.view");
			}
	}
}
