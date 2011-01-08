package com.sgs.portlet.document.receiptprocess.action;

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

import com.liferay.portal.kernel.util.ParamUtil;
import com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile;
import com.sgs.portlet.document.receipt.model.PmlEdmConfidentialLevel;
import com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt;
import com.sgs.portlet.document.receipt.model.PmlEdmDocumentType;
import com.sgs.portlet.document.receipt.model.PmlEdmPrivilegeLevel;
import com.sgs.portlet.document.receipt.service.PmlEdmDocumentReceiptLocalServiceUtil;
import com.sgs.portlet.document.receipt.service.persistence.PmlEdmAttachedFileUtil;
import com.sgs.portlet.document.receipt.service.persistence.PmlEdmConfidentialLevelUtil;
import com.sgs.portlet.document.receipt.service.persistence.PmlEdmDocumentTypeUtil;
import com.sgs.portlet.document.receipt.service.persistence.PmlEdmPrivilegeLevelUtil;
import com.sgs.portlet.document.workflow.DocumentReceiptPortletAction;

/**
 * Prepare data for form add send document.
 * @author doanhdv
 * @author kienbqc
 */
public class WriteDocumentAction extends DocumentReceiptPortletAction {
	private static Log _log = LogFactory.getLog(WriteDocumentAction.class);
	
	public void processStrutsAction(ActionMapping mapping, ActionForm form,
			PortletConfig config, ActionRequest req, ActionResponse res)
			throws Exception {
		
	}

	public ActionForward renderStruts(ActionMapping mapping, ActionForm form,
			PortletConfig config, RenderRequest req, RenderResponse res)
			throws Exception {
		
		/* Get id of document receipt in request */
		long documentReceiptId = ParamUtil.getLong(req, "documentReceiptId");
		
		/* Get list of privilegeLevel */
		List<PmlEdmPrivilegeLevel> privilegeLevels = PmlEdmPrivilegeLevelUtil.findAll();
		
		/* Get list of documentType */
		List<PmlEdmDocumentType> documentTypes = PmlEdmDocumentTypeUtil.findAll();
		
		/* Get list of ConfidentialLevel */
		List<PmlEdmConfidentialLevel> confidentialLevels = PmlEdmConfidentialLevelUtil.findAll();
		
		/* Get documentReceipt by documentReceiptId */
		PmlEdmDocumentReceipt documentReceipt = 
			PmlEdmDocumentReceiptLocalServiceUtil
				.getPmlEdmDocumentReceipt(documentReceiptId);
		
		/* Get attachFiles by documentReceiptId */
		List<PmlEdmAttachedFile> attachFiles = PmlEdmAttachedFileUtil
			.findByObjectContentId(documentReceiptId);
		
		/*
		 * set into attribute of request:
		 * - privilegeLevels
		 * - documentTypes
		 * - confidentialLevels
		 * - documentReference
		 * - briefContent
		 * - attachFiles
		 * - documentReceiptId
		 */
		req.setAttribute("privilegeLevels", privilegeLevels);
		req.setAttribute("documentTypes", documentTypes);
		req.setAttribute("confidentialLevels", confidentialLevels);
		req.setAttribute("documentReference", documentReceipt.getDocumentReference());
		req.setAttribute("briefContent", documentReceipt.getBriefContent());
		req.setAttribute("attachFiles", attachFiles);
		req.setAttribute("documentReceiptId", documentReceiptId);
		
		if (getForward(req) != null && !getForward(req).equals("")) {
			return mapping.findForward(getForward(req)); // Use forward set in processAction if available
		} else {
			return mapping.findForward("portlet.sgs.document.receiptprocess.writeDocument");
		}
	}
}
