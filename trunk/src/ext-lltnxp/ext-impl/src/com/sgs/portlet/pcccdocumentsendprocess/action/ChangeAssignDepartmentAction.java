/**
 * 
 */
package com.sgs.portlet.pcccdocumentsendprocess.action;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletSession;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.struts.PortletAction;
import com.liferay.portal.util.PortalUtil;
import com.sgs.liferay.jbpm.param.WorkflowParam;
import com.sgs.portlet.department.model.Department;
import com.sgs.portlet.department.service.persistence.DepartmentUtil;
import com.sgs.portlet.document.model.PmlDocumentReceiptLog;
import com.sgs.portlet.document.model.PmlStateWorkFlow;
import com.sgs.portlet.document.receipt.model.PmlEdmBookDocumentRecordTo;
import com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt;
import com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo;
import com.sgs.portlet.document.receipt.model.impl.PmlEdmBookDocumentRecordToImpl;
import com.sgs.portlet.document.receipt.service.PmlEdmBookDocumentRecordToLocalServiceUtil;
import com.sgs.portlet.document.receipt.service.PmlEdmDocumentReceiptLocalServiceUtil;
import com.sgs.portlet.document.receipt.service.PmlEdmDocumentRecordToLocalServiceUtil;
import com.sgs.portlet.document.receipt.service.persistence.PmlEdmDocumentReceiptUtil;
import com.sgs.portlet.document.receipt.util.Constants;
import com.sgs.portlet.document.send.model.PmlEdmDocumentSend;
import com.sgs.portlet.document.send.service.PmlEdmDocumentSendLocalServiceUtil;
import com.sgs.portlet.document.service.persistence.PmlDocumentReceiptLogUtil;
import com.sgs.portlet.document.service.persistence.PmlStateWorkFlowUtil;
import com.sgs.portlet.document.workflow.DocumentReceiptPortletAction;
import com.sgs.portlet.document.workflow.DocumentSendPortletAction;
import com.sgs.portlet.generatetemplateid.service.IdGeneratedLocalServiceUtil;
import com.sgs.portlet.generatetemplateid.service.IdTemplateLocalServiceUtil;
import com.sgs.portlet.generatetemplateid.service.IdTemplateServiceUtil;
import com.sgs.portlet.field.model.PmlField;
import com.sgs.portlet.pmluser.model.PmlUser;
import com.sgs.portlet.pmluser.service.PmlUserLocalServiceUtil;

/**
 * ChangeAssignDepartmentAction class is used to prepare data for
 * assign department form and add information assign department into workflow.
 * 
 * @version 1.5 09 November 2009
 * @author 
 * @author 
 */
@SuppressWarnings("unused")
public class ChangeAssignDepartmentAction extends DocumentSendPortletAction {
	private static Log _log = LogFactory.getLog(ChangeAssignDepartmentAction.class);
	
	public void processStrutsAction(ActionMapping mapping, ActionForm form,
			PortletConfig config, ActionRequest req, ActionResponse res)
			throws Exception {
		// get params in request
		String[] supportDepartments = req.getParameterValues("DepartmentsSendId");
		String supportedDepartment = "";
		
		if (supportDepartments != null && supportDepartments.length > 0 ) {
			for (int i = 0; i < supportDepartments.length; i++) {
				supportedDepartment += supportDepartments[i];
				if (i + 1 < supportDepartments.length) {
					supportedDepartment += Constants.DEPARTMENT_SEPERATOR;
				}
			}
		}
		
		long documentSendId = ParamUtil.getLong(req, "documentSendId");		
		String processInformation =  ParamUtil.getString(req, "processInformation", "");
		
		addWorkflowParameter(req, "supportedDepartment", WorkflowParam.TRANSIENT, supportedDepartment);
//		addWorkflowParameter(req, "procssor", WorkflowParam.TRANSIENT, String.valueOf(PortalUtil.getUserId(req)));
		
		// vu update 20110112
		long userIdXLT = ParamUtil.getLong(req, "userIdXLT", 0);
		if (userIdXLT == 0) {
			addWorkflowParameter(
				req, "processor", WorkflowParam.TRANSIENT,
				String.valueOf(PortalUtil.getUserId(req)));
		}
		else {
			addWorkflowParameter(
				req, "processor", WorkflowParam.TRANSIENT,
				String.valueOf(userIdXLT));
			addWorkflowParameter(
				req, "directprocessor", WorkflowParam.TRANSIENT,
				String.valueOf(PortalUtil.getUserId(req)));
		}
		
		// end vu update
		
		addWorkflowParameter(req, "processInformation", WorkflowParam.TRANSIENT, processInformation);
		addWorkflowParameter(req, "documentSendId", WorkflowParam.TRANSIENT, String.valueOf(documentSendId));
		
		PortletSession session= req.getPortletSession();
		session.setAttribute("transition", "transition",PortletSession.APPLICATION_SCOPE);
	}

	
	public ActionForward renderStruts(ActionMapping mapping, ActionForm form,
			PortletConfig config, RenderRequest req, RenderResponse res)
			throws Exception {
		
				int page = ParamUtil.getInteger(req, "page", 1);
				int limit = ParamUtil.getInteger(req, "limit", 20); // default
				req.setAttribute("currentPage", page);
				req.setAttribute("currentLimit", limit);
		
				long documentSendId = ParamUtil.getLong(req, "documentSendId");
				
				PmlEdmDocumentSend pmlEdmDocumentSend = null;
				try {
					pmlEdmDocumentSend = PmlEdmDocumentSendLocalServiceUtil.getPmlEdmDocumentSend(documentSendId);
				} catch (Exception e) {
					pmlEdmDocumentSend = null;
				}
				PmlUser pmlUser = null;
				String editorDepartment = null;
				long userEditor = 0;
				if (pmlEdmDocumentSend != null) {
					userEditor = pmlEdmDocumentSend.getEditorId();
					try {
						pmlUser = PmlUserLocalServiceUtil.getPmlUser(userEditor);
					} catch (Exception e) {
						pmlUser = null;
					}
					if (pmlUser != null) {
						editorDepartment = pmlUser.getDepartmentsId();
					}
				}
				
				
				List<Department> list = null;	
				try {
					list = DepartmentUtil.findAll();
				} catch (Exception e) {
					list = new ArrayList<Department>();
				}
				
				for (Department department : list) {
					if (editorDepartment.equals(department.getDepartmentsId())) {
						list.remove(department);
						break;
					}
				}
				
				
				//sort with name deparment
				for (int j = 0; j < list.size(); j++) {	
					int temp = j;
					for (int i = temp; i < list.size(); i++) {
						if (list.get(j).getDepartmentsName().compareTo(list.get(i).getDepartmentsName())> 0) {				
							java.util.Collections.swap(list, j, i);
						}
					}
				}
				req.setAttribute("documentSendId", documentSendId);	
				req.setAttribute("departmentList", list);
				return mapping.findForward("portlet.sgs.pcccdocumentsendprocess.changedeparments");
			
	}
	
	
}
