package com.sgs.portlet.pcccdocumentreceiptprocess.action;

/**
 * @author triltm
 * @author thoind
 */
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

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

import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.util.PortalUtil;
import com.sgs.portlet.document.receipt.model.PmlEdmBookDocumentRecordTo;
import com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo;
import com.sgs.portlet.document.receipt.service.PmlEdmBookDocumentRecordToLocalServiceUtil;
import com.sgs.portlet.document.receipt.service.PmlEdmDocumentRecordToLocalServiceUtil;
import com.sgs.portlet.document.receipt.service.persistence.PmlEdmBookDocumentRecordToUtil;
import com.sgs.portlet.document.workflow.DocumentReceiptPortletAction;
import com.sgs.portlet.pmluser.model.PmlUser;
import com.sgs.portlet.department.service.persistence.DepartmentUtil;
import com.sgs.portlet.pmluser.service.persistence.PmlUserUtil;

public class ProcessAction extends DocumentReceiptPortletAction {
	private static Log _log = LogFactory.getLog(ProcessAction.class);
	public void processStrutsAction(ActionMapping mapping, ActionForm form,
			PortletConfig config, ActionRequest req, ActionResponse res)
			throws Exception {
		_log.info("in processstrutsAction method");
		
		//update date document receipt go away department 
		//get year current
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());		
		String yearInUse = String.valueOf(calendar.get(calendar.YEAR));
		
		long documentReceiptId = ParamUtil.getLong(req, "documentReceiptId");
		int documentRecordTypeId = PmlEdmDocumentRecordToLocalServiceUtil.getDocumentRecordTypeIdByDocumentReceipt(documentReceiptId);
		long userId = PortalUtil.getUserId(req);
		updateBookDocumentReceipt(userId, yearInUse, documentRecordTypeId, documentReceiptId);
	}

	/**
	 * set date complete of department process document receipt
	 * @param userId
	 * @param yearInUse
	 * @param documentRecordTypeId
	 * @param documentReceiptId
	 * void
	 *
	 */
	private void updateBookDocumentReceipt (long userId, String yearInUse, int documentRecordTypeId, long documentReceiptId) {
		PmlUser pmlUser = null;
		String departmentIdMain = null;
		try {
			pmlUser = PmlUserUtil.findByPrimaryKey(userId);
			
		} catch (Exception e) {	} 
		
		if (pmlUser != null) {
			try {
				departmentIdMain = DepartmentUtil.findByPrimaryKey(pmlUser.getDepartmentsId()).getDepartmentsId();
				if (departmentIdMain != null) {
					PmlEdmDocumentRecordTo pmlEdmDocumentRecordTo = PmlEdmDocumentRecordToLocalServiceUtil.getDocumentRecordTo(yearInUse, departmentIdMain, documentRecordTypeId);
					if (pmlEdmDocumentRecordTo != null) {
						
						PmlEdmBookDocumentRecordTo bookDocumentRecordTo = PmlEdmBookDocumentRecordToUtil.findByDocumentReceiptId_DocumentRecordToId(documentReceiptId, pmlEdmDocumentRecordTo.getDocumentRecordToId()).get(0);
						Date date = new Timestamp( new Date().getTime());
						bookDocumentRecordTo.setDateComplete(date);
						
						PmlEdmBookDocumentRecordToLocalServiceUtil.updatePmlEdmBookDocumentRecordTo(bookDocumentRecordTo);
					}
				}
			} catch (Exception e) {}
		}		
		}
		
	public ActionForward renderStruts(ActionMapping mapping, ActionForm form,
			PortletConfig config, RenderRequest req, RenderResponse res)
			throws Exception {
				
				return mapping.findForward("portlet.sgs.pcccdocumentreceiptprocess.process");
	}

}
