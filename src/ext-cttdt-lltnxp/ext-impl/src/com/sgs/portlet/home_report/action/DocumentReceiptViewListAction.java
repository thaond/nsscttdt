package com.sgs.portlet.home_report.action;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.util.portlet.PortletProps;
import com.sgs.portlet.department.model.Department;
import com.sgs.portlet.department.service.DepartmentLocalServiceUtil;
import com.sgs.portlet.document.workflow.DocumentReceiptPortletAction;
import com.sgs.portlet.home_report.util.HomeReportDWRUtil;
import com.sgs.portlet.pmluser.model.PmlUser;
import com.sgs.portlet.pmluser.service.PmlUserLocalServiceUtil;

public class DocumentReceiptViewListAction extends DocumentReceiptPortletAction {
	private final static Logger _log = Logger.getLogger(DocumentReceiptViewListAction.class);
	
	public void processStrutsAction(ActionMapping mapping, ActionForm form,
			PortletConfig config, ActionRequest req, ActionResponse res)
			throws Exception {
	}


	public ActionForward renderStruts(ActionMapping mapping, ActionForm form,
			PortletConfig config, RenderRequest req, RenderResponse res)
			throws Exception {
		if (getForward(req) != null && !getForward(req).equals("")) {
			return mapping.findForward(getForward(req)); // Use forward set in processAction if available
		} else {
			String action = ParamUtil.getString(req, "action");
			String row = ParamUtil.getString(req, "row");
			
			String tenChuyenVien = getTenChuyenVien(row);
			String tenAction = getTenAction(action);
			
			req.setAttribute("tenChuyenVien", tenChuyenVien);
			req.setAttribute("tenAction", tenAction);
			
			return mapping.findForward("portlet.sgs.home_report.documentreceiptviewlist");
		}
	}

	// lay ten action
	private String getTenAction(String action) {
		String tenAction = "";
		if (action.equals("tonthangtruoc")) {
			tenAction = PortletProps.get("ton-thang-truoc");
		} 
		else if (action.equals("nhantrongthang")) {
			tenAction = PortletProps.get("nhan-trong-thang");
		} 
		else if (action.equals("daxuly")) {
			tenAction = PortletProps.get("da-xu-ly");
		} 
		else if (action.equals("conton")) {
			tenAction = PortletProps.get("con-ton");
		} 
		return tenAction;
	}

	// lay ten phong ban
	private String getTenChuyenVien(String row) {
		String tenChuyenVien = "";
		
		Department department = null;
		Department departmentParent = null;
		String departmentName = "";
		
		PmlUser pmlUser = null;
		String userName = "";
		
		if (row != null && !row.equals("")) {
			long userId = Long.parseLong(row);
			try {
				pmlUser = PmlUserLocalServiceUtil.getPmlUser(userId);
				userName = HomeReportDWRUtil.getFullName(userId);
				
				
				String departmentsId = pmlUser.getDepartmentsId();
				try {
					department = DepartmentLocalServiceUtil.getDepartment(departmentsId);
					if (department.getDepartmentsParentId() != null && !department.getDepartmentsParentId().equals("")) {
						departmentParent = DepartmentLocalServiceUtil.getDepartment(department.getDepartmentsParentId());
						departmentName = departmentParent.getDepartmentsName();
					} else {
						departmentName = department.getDepartmentsName();
					}
				} catch (Exception e1) {
					_log.warn("CAN NOT GET DEPARTMENT WITH PRIMARY KEY " + departmentsId);
				}
			} catch (Exception e) {
				_log.warn("CAN NOT GET PMLUSER WITH PRIMARY KEY " + userId);
			}
		}
		
		if (!userName.equals("") && !departmentName.equals("")) {
			tenChuyenVien = departmentName + " - CV: " + userName;
		}
		
		return tenChuyenVien;
	}
}
