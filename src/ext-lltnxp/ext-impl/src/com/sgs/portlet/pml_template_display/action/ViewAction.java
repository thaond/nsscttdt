package com.sgs.portlet.pml_template_display.action;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.WindowState;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.struts.PortletAction;
import com.sgs.portlet.department.model.Department;
import com.sgs.portlet.department.service.DepartmentLocalServiceUtil;
import com.sgs.portlet.pml_template.model.PmlTemplate;
import com.sgs.portlet.pml_template.service.PmlTemplateLocalServiceUtil;
import com.sgs.portlet.pml_template_display.search.PmlTemplateDisplaySearch;

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
			List<Department> departmentList = new ArrayList<Department>();
			departmentList = DepartmentLocalServiceUtil.getDepartments(-1, -1);
			req.setAttribute("departmentList", departmentList);
		
			String type = ParamUtil.getString(req, "locTheo", "");
			String valueType = ParamUtil.getString(req, "valueType", "");		
			String ngayBanHanhParam = ParamUtil.getString(req,"ngayBanHanhSearch", "");
			String departmentIdFilter = ParamUtil.getString(req,"departmentIdFilter", "");
			// Dieu kien sort 
			PortletURL portletURL = res.createRenderURL();
			portletURL.setWindowState(WindowState.MAXIMIZED);
			portletURL.setParameter("struts_action", "/sgs/pml_template_display/view");
			portletURL.setParameter("type", type);
			portletURL.setParameter("valueType", valueType);
			portletURL.setParameter("ngayBanHanhParam", ngayBanHanhParam);
			portletURL.setParameter("departmentIdFilter", departmentIdFilter);
			PmlTemplateDisplaySearch searchContainer = new PmlTemplateDisplaySearch(req, portletURL);
			
			if (!"".equals(valueType)) {
				departmentIdFilter = "";
				ngayBanHanhParam = "";
			}
			
			if (!"".equals(ngayBanHanhParam)) {
				valueType = ngayBanHanhParam ;
				departmentIdFilter = "";
			} 
			
			if (!"".equals(departmentIdFilter)) {
				valueType = departmentIdFilter;
				ngayBanHanhParam = "";
			}
			
			List<PmlTemplate> pmlTemplateList = new ArrayList<PmlTemplate>();
			int total = 0;
			pmlTemplateList = PmlTemplateLocalServiceUtil.search(type, valueType, searchContainer.getStart(), searchContainer.getEnd(), searchContainer.getOrderByComparator());
			total = PmlTemplateLocalServiceUtil.searchCount(type, valueType);
			req.setAttribute("pmlTemplateList", pmlTemplateList);
			req.setAttribute("total", total);
			req.setAttribute("valueType", valueType);
			req.setAttribute("departmentIdFilter", departmentIdFilter);
			req.setAttribute("locTheo", type);
			req.setAttribute("ngayBanHanhParam", ngayBanHanhParam);
			req.setAttribute("templateSearchContainer", searchContainer);
			
			if (getForward(req) != null && !getForward(req).equals("")) {
				return mapping.findForward(getForward(req)); // Use forward set in processAction if available
			} else {
				return mapping.findForward("portlet.sgs.pml_template_display.view");
			}
	}

}
