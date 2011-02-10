/**
 * 
 */
package com.sgs.portlet.document.receiptprocess.action;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
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

import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.util.PortalUtil;
import com.sgs.liferay.jbpm.param.WorkflowParam;
import com.sgs.portlet.department.model.Department;
import com.sgs.portlet.department.service.persistence.DepartmentUtil;
import com.sgs.portlet.document.model.PmlDocumentReceiptWF;
import com.sgs.portlet.document.receipt.model.PmlEdmBookDocumentRecordTo;
import com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo;
import com.sgs.portlet.document.receipt.model.impl.PmlEdmBookDocumentRecordToImpl;
import com.sgs.portlet.document.receipt.service.PmlEdmBookDocumentRecordToLocalServiceUtil;
import com.sgs.portlet.document.receipt.service.PmlEdmDocumentReceiptLocalServiceUtil;
import com.sgs.portlet.document.receipt.service.PmlEdmDocumentRecordToLocalServiceUtil;
import com.sgs.portlet.document.receipt.util.Constants;
import com.sgs.portlet.document.service.PmlDocumentReceiptWFLocalServiceUtil;
import com.sgs.portlet.document.service.persistence.PmlDocumentReceiptWFUtil;
import com.sgs.portlet.document.workflow.DocumentReceiptPortletAction;

/**
 * ChangeAssignDepartmentAction class is used to prepare data for
 * assign department form and add information assign department into workflow.
 * 
 * @version 1.5 10 Apr 2009
 * @author doanhdv
 * @author kienbqc
 */
public class ChangeAssignDepartmentAction extends DocumentReceiptPortletAction {
	private static Log _log = LogFactory.getLog(ChangeAssignDepartmentAction.class);
	
	public void processStrutsAction(ActionMapping mapping, ActionForm form,
			PortletConfig config, ActionRequest req, ActionResponse res)
			throws Exception {
		
		String[] array = req.getParameterValues("selectedOptions");
		String supportedDepartment = "";
		
		//co them cau if 
		if (array != null && array.length > 0 ) {
			for (int i = 0; i < array.length; i++) {
				supportedDepartment += array[i];
				if (i + 1 < array.length) {
					supportedDepartment += Constants.DEPARTMENT_SEPERATOR;
				}
			}
		}
		
		String mainDepartment =  ParamUtil.getString(req, "selectedOptionsmain", "");
				
		// vao so cho phong
		bookDocumentRecordTo(req, res, mainDepartment);
		
		_log.info("Is Workflow Action = " + ParamUtil.getBoolean(req, "workflowAction"));
		_log.info("Workflow Action Name = " + ParamUtil.getString(req, "workflowActionName"));
		
		addWorkflowParameter(req, "mainDepartment", WorkflowParam.TRANSIENT, mainDepartment);
		addWorkflowParameter(req, "supportedDepartment", WorkflowParam.TRANSIENT, supportedDepartment);
		addWorkflowParameter(req, "processor", WorkflowParam.TRANSIENT, String.valueOf(PortalUtil.getUserId(req)));
		
	}

	/**
	 * Add document for department
	 * @param req ActionRequest
	 * @param res ActionRespose
	 * @param mainDepartment
	 */
	private void bookDocumentRecordTo(ActionRequest req, ActionResponse res, String mainDepartment) {

		Date date = new Timestamp( new Date().getTime());
		long documentReceiptId = ParamUtil.getLong(req, "documentReceiptId");
		
		if (mainDepartment == null || "".equals(mainDepartment)) {
			return;
		}
		
		String yearInUse = String.valueOf(date.getYear() + 1900);
		int documentRecordTypeId = PmlEdmDocumentRecordToLocalServiceUtil.getDocumentRecordTypeIdByDocumentReceipt(documentReceiptId);
		
		PmlEdmDocumentRecordTo pmlEdmDocumentRecordTo = 
			PmlEdmDocumentRecordToLocalServiceUtil.getDocumentRecordTo(yearInUse, mainDepartment, documentRecordTypeId);
		if (pmlEdmDocumentRecordTo != null) {
			if (pmlEdmDocumentRecordTo.getYearInUse() != null && pmlEdmDocumentRecordTo.getDepartmentsId() != null) {
				PmlEdmBookDocumentRecordTo bookDocumentRecordTo = new PmlEdmBookDocumentRecordToImpl();
				
				/* set data into bookDocumentRecordTo object */
				bookDocumentRecordTo = setDataIntoBookDocumentRecordTo(bookDocumentRecordTo, documentReceiptId,	pmlEdmDocumentRecordTo, date);
				
				try {
					/* Add PmlEdmBookDocumentRecordTo into system */
					PmlEdmBookDocumentRecordToLocalServiceUtil.updatePmlEdmBookDocumentRecordTo(bookDocumentRecordTo);
				}
				catch (SystemException e) {
					e.printStackTrace();
				}
			}
		} else {
			try {
				List<PmlDocumentReceiptWF> list = PmlDocumentReceiptWFUtil.findByDocumentReceiptId(documentReceiptId);
				PmlDocumentReceiptWF pmlDocumentReceiptWF = null;
				
				if (list != null && list.size() > 0) {
					pmlDocumentReceiptWF = list.get(0);
				}
				
				long processId = pmlDocumentReceiptWF.getProcessId();
				
				PmlEdmDocumentReceiptLocalServiceUtil.deletePmlEdmDocumentReceipt(documentReceiptId);
				PmlDocumentReceiptWFLocalServiceUtil.deletePmlDocumentReceiptWF(processId);
				return ;
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/* (non-Javadoc)
	 * @see com.sgs.liferay.web.struts.action.WorkflowPortletAction#renderStruts(org.apache.struts.action.ActionMapping, org.apache.struts.action.ActionForm, javax.portlet.PortletConfig, javax.portlet.RenderRequest, javax.portlet.RenderResponse)
	 */
	public ActionForward renderStruts(ActionMapping mapping, ActionForm form,
			PortletConfig config, RenderRequest req, RenderResponse res)
			throws Exception {
		//load cac danh muc dung chung cho cac select box
		
			if (getForward(req) != null && !getForward(req).equals("")) {
				return mapping.findForward(getForward(req)); // Use forward set in processAction if available
			} else {
				List<Department> list = DepartmentUtil.findAll();
				
				if (list == null) {
					_log.info("department is null");
				} else {
					_log.info("list department size: " + list.size());
				}
				
				Date date = new Date();
				
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				req.setAttribute("date", sdf.format(date));
				
				req.setAttribute("departmentList", list);
				
				return mapping.findForward("portlet.sgs.document.receiptprocess.changeAssignDepartment");
			}
	}

	/**
	 * Set data into BookDocumentRecordTo
	 * @param bookDocumentRecordTo
	 * @param documentReceiptId
	 * @param pmlEdmDocumentRecordTo
	 * @param date
	 * @return PmlEdmBookDocumentRecordTo object
	 */
	private PmlEdmBookDocumentRecordTo setDataIntoBookDocumentRecordTo(
		PmlEdmBookDocumentRecordTo bookDocumentRecordTo,
		long documentReceiptId, PmlEdmDocumentRecordTo pmlEdmDocumentRecordTo,
		Date date) {

		bookDocumentRecordTo.setDocumentReceiptId(documentReceiptId);
		bookDocumentRecordTo.setDocumentRecordToId(
			pmlEdmDocumentRecordTo.getDocumentRecordToId());
		bookDocumentRecordTo.setDateCreate(date);
		
		return bookDocumentRecordTo;
	}
}
