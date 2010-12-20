package com.nss.portlet.documentfield.action;

import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletSession;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.struts.PortletAction;
import com.liferay.portal.util.PortalUtil;
import com.nss.portlet.department.model.Department;
import com.nss.portlet.department.service.DepartmentLocalServiceUtil;
import com.nss.portlet.documentfield.FieldCodeSameCodeException;
import com.nss.portlet.documentfield.model.PmlField;
import com.nss.portlet.documentfield.service.PmlFieldLocalServiceUtil;

public class AddAction extends PortletAction {
	
	public void processAction(ActionMapping mapping, ActionForm form,
			PortletConfig config, ActionRequest req, ActionResponse res)
			throws Exception {
			
		try {
			String redirect = ParamUtil.getString(req, "redirect");
			addField(req);	
			res.sendRedirect(redirect);
		} catch (Exception e) {
			if (e instanceof FieldCodeSameCodeException) {
				List<Department> listDepartment = DepartmentLocalServiceUtil.getDepartments(-1, -1);
				req.setAttribute("listDepartment", listDepartment);
				req.setAttribute("fieldFlag", "fail");
				
				setForward(req, "portlet.nss.documentfield.add");
				
				SessionErrors.add(req, e.getClass().getName());
			}
			else {
				throw e;
			}
		}
		
	}

	private PmlField addField(ActionRequest req) throws SystemException, PortalException {
		
		UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(req);
		
		String code = ParamUtil.getString(uploadRequest, "code");
		String name = ParamUtil.getString(uploadRequest, "name");
		String departmentId = ParamUtil.getString(uploadRequest, "departmentId");
		String description = ParamUtil.getString(uploadRequest, "description");
		
		PmlField pmlField = null;
		
		pmlField = PmlFieldLocalServiceUtil.addPmlField(code, name, departmentId, description, "1");
		
		req.getPortletSession().setAttribute("field", Constants.ADD, PortletSession.APPLICATION_SCOPE);
		
		return pmlField;
	}
	
	public ActionForward render(ActionMapping mapping, ActionForm form,
			PortletConfig config, RenderRequest req, RenderResponse res)
			throws Exception {
	
			List<Department> listDepartment = DepartmentLocalServiceUtil.getDepartments(-1, -1);
			
			req.setAttribute("listDepartment", listDepartment);
			return mapping.findForward("portlet.nss.documentfield.add");
	}
}