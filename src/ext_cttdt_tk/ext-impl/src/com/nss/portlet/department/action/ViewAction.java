package com.nss.portlet.department.action;

import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.struts.PortletAction;
import com.nss.portlet.department.DepartmentCanNotDeleteException;
import com.nss.portlet.department.model.Department;
import com.nss.portlet.department.service.DepartmentLocalServiceUtil;

public class ViewAction extends PortletAction {

	private static final boolean _CHECK_METHOD_ON_PROCESS_ACTION = false;

	protected boolean isCheckMethodOnProcessAction() {
		return _CHECK_METHOD_ON_PROCESS_ACTION;
	}
	
	public void processAction(ActionMapping mapping, ActionForm form,
			PortletConfig config, ActionRequest req, ActionResponse res)
			throws Exception {
		String cmd = ParamUtil.getString(req, Constants.CMD, "");
		try {
			if (Constants.DELETE.equals(cmd)) {
				deleteDepartment(req);
			}
			if (Validator.isNotNull(cmd)) {
				String departmentURL = ParamUtil.getString(req, "departmentURL");
				sendRedirect(req, res, departmentURL);
			}
		} catch (Exception e) {
			if (e instanceof DepartmentCanNotDeleteException){
				SessionErrors.add(req,e.getClass().getName());
			}
			else {
				throw e;
			}
		}
	}

	private void deleteDepartment(ActionRequest req) throws Exception {
		String departmentId = ParamUtil.getString(req, "departmentId","");
		DepartmentLocalServiceUtil.removeDepartment(departmentId);
	}
	
	public ActionForward render(ActionMapping mapping, ActionForm form,
			PortletConfig config, RenderRequest req, RenderResponse res)
			throws Exception {
			List<Department> departmentList = DepartmentLocalServiceUtil.getDepartments(-1, -1);
			
			req.setAttribute("departmentList", departmentList);
			if (getForward(req) != null && !getForward(req).equals("")) {
				return mapping.findForward(getForward(req)); // Use forward set in processAction if available
			} else {
				return mapping.findForward("portlet.nss.department.view");
			}
	}

}
