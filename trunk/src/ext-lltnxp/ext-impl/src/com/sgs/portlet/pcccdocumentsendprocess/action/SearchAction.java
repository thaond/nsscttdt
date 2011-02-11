package com.sgs.portlet.pcccdocumentsendprocess.action;

import java.util.ArrayList;

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

import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.model.User;
import com.sgs.portlet.document.receipt.model.PmlEdmDocumentType;
import com.sgs.portlet.document.receipt.service.persistence.PmlEdmDocumentTypeUtil;
import com.sgs.portlet.document.workflow.DocumentReceiptPortletAction;
import com.sgs.portlet.department.model.Department;
import com.sgs.portlet.department.service.persistence.DepartmentUtil;
import com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec;
import com.sgs.portlet.pml_ho_so_cong_viec.service.persistence.PmlHoSoCongViecUtil;
import com.sgs.portlet.document.receipt.service.PmlEdmDocumentReceiptLocalServiceUtil;

public class SearchAction extends DocumentReceiptPortletAction {
	public void processStrutsAction(ActionMapping mapping, ActionForm form,
			PortletConfig config, ActionRequest req, ActionResponse res)
			throws Exception {
		
	}
	
	public ActionForward renderStruts(ActionMapping mapping, ActionForm form,
			PortletConfig config, RenderRequest req, RenderResponse res)
			throws Exception {
		
			req.setAttribute("receiptFlag", ParamUtil.getString(req, "receiptFlag", "flase"));
			req.setAttribute("sendFlag", ParamUtil.getString(req, "sendFlag", "flase"));
		
			// phan cho cong van di
			boolean search = ParamUtil.getBoolean(req, "search");			
			PortletSession session= req.getPortletSession();
			session.setAttribute("search", search ,PortletSession.APPLICATION_SCOPE);
			
			// loai cong van
			List<PmlEdmDocumentType> pmlEdmDocumentTypeList = new ArrayList<PmlEdmDocumentType>();
			try {
				pmlEdmDocumentTypeList = PmlEdmDocumentTypeUtil.findAll(); 
			} catch (Exception e) {}
			
			req.setAttribute("pmlEdmDocumentTypeList", pmlEdmDocumentTypeList);
			
			// phong soan thao
			
			List<Department> pmlDepartmentList = new ArrayList<Department>();
			
			try {
				pmlDepartmentList = DepartmentUtil.findAll();
			} catch (Exception e) {}
			
			req.setAttribute("pmlDepartmentList", pmlDepartmentList);
			
			// nguoi ky
			
			List<User> userList = new ArrayList<User>();
			
			try {
				//userList = UserUtil.findAll();
				//lay danh sach nguoi ky theo alphabe
				userList = PmlEdmDocumentReceiptLocalServiceUtil.getSortedListUser();
			} catch (Exception e) {}
			
			req.setAttribute("userList", userList);
			
			// so ho so cong viec
			
			List<PmlHoSoCongViec> pmlHoSoCongViecList = new ArrayList<PmlHoSoCongViec>();
			try {
				pmlHoSoCongViecList = PmlHoSoCongViecUtil.findAll();
			} catch (Exception e) {}
			
			req.setAttribute("pmlHoSoCongViecList", pmlHoSoCongViecList);
			
			return mapping.findForward("portlet.sgs.pcccdocumentsendprocess.search");
	}
}