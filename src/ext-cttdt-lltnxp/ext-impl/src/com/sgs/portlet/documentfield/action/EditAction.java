package com.sgs.portlet.documentfield.action;


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

import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.struts.PortletAction;
import com.sgs.portlet.department.model.Department;
import com.sgs.portlet.field.model.PmlField;
import com.sgs.portlet.department.service.DepartmentLocalServiceUtil;
import com.sgs.portlet.field.service.PmlFieldLocalServiceUtil;

public class EditAction extends PortletAction {
	
	public void processAction(ActionMapping mapping, ActionForm form,
			PortletConfig config, ActionRequest req, ActionResponse res)
			throws Exception {
			
			String redirect = ParamUtil.getString(req, "redirect");
			updateField(req);	
			res.sendRedirect(redirect);
		
	}
	private void updateField(ActionRequest req)	throws Exception {
		String fieldId = ParamUtil.getString(req, "fieldId");
		String code = ParamUtil.getString(req, "code");
		String name = ParamUtil.getString(req, "name");
		String departmentId = ParamUtil.getString(req, "departmentId");
		String description = ParamUtil.getString(req, "description");
		
//		Field fieldObj= FieldLocalServiceUtil.getField(fieldId);
		PmlField fieldObj = PmlFieldLocalServiceUtil.getPmlField(fieldId);
		
		fieldObj.setFieldCode(code);
		fieldObj.setFieldName(name);
		fieldObj.setDepartmentsId(departmentId);
		fieldObj.setDescription(description);
		
//		FieldLocalServiceUtil.updateField(fieldObj);
		PmlFieldLocalServiceUtil.updatePmlField(fieldObj);
		req.getPortletSession().setAttribute("field", Constants.UPDATE, PortletSession.APPLICATION_SCOPE);
	}
	
	public ActionForward render(ActionMapping mapping, ActionForm form,
			PortletConfig config, RenderRequest req, RenderResponse res)
			throws Exception {

			PmlField fieldObj= PmlFieldLocalServiceUtil.getPmlField(ParamUtil.getString(req, "fieldId"));
//			Field fieldObj= FieldLocalServiceUtil.getField(ParamUtil.getString(req, "fieldId"));
			List<Department> listDepartment= DepartmentLocalServiceUtil.getDepartments(-1, -1);
			
			req.setAttribute("fieldObj", fieldObj);
			req.setAttribute("listDepartment",listDepartment);
			return mapping.findForward("portlet.sgs.documentfield.editfield");
	}
}
