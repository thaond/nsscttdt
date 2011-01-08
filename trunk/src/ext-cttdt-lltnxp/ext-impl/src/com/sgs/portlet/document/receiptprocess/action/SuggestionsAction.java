package com.sgs.portlet.document.receiptprocess.action;

import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.util.PortalUtil;
import com.sgs.portlet.document.receipt.dto.PmlEdmDocumentReceiptDTO;
import com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile;
import com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt;
import com.sgs.portlet.document.receipt.model.impl.PmlEdmDocumentReceiptImpl;
import com.sgs.portlet.document.receipt.service.PmlEdmDocumentReceiptLocalServiceUtil;
import com.sgs.portlet.document.receipt.service.persistence.PmlEdmAttachedFileUtil;
import com.sgs.portlet.document.workflow.DocumentReceiptPortletAction;

public class SuggestionsAction extends DocumentReceiptPortletAction {

	@Override
	public void processStrutsAction(ActionMapping mapping, ActionForm form,
			PortletConfig config, ActionRequest req, ActionResponse res)
			throws Exception {
		
	}

	@Override
	public ActionForward renderStruts(ActionMapping mapping, ActionForm form,
			PortletConfig config, RenderRequest req, RenderResponse res)
			throws Exception {
		long documentReceiptId = Long.parseLong(ParamUtil.getString(req, "documentReceiptId")); 
		PmlEdmDocumentReceipt documentReceipt = PmlEdmDocumentReceiptLocalServiceUtil.getPmlEdmDocumentReceipt(documentReceiptId);
		PmlEdmDocumentReceiptDTO documentDTO = new PmlEdmDocumentReceiptDTO();
		
		documentDTO = populateDocumentReceiptToDTO(req, documentReceipt);
		
		req.setAttribute("documentDTO", documentDTO);
		
		//get files attach
		PmlEdmDocumentReceipt documentReceiptImp = new PmlEdmDocumentReceiptImpl();
		List<PmlEdmAttachedFile> listPmlEdmAttachedFile = PmlEdmAttachedFileUtil.findByObjectContentId_ObjectType(documentReceiptId, documentReceiptImp.getClass().getName());
		req.setAttribute("listPmlEdmAttachedFile", listPmlEdmAttachedFile);
		
		if (getForward(req) != null && !getForward(req).equals("")) {
			return mapping.findForward(getForward(req)); 
		} else {
			return mapping.findForward("portlet.sgs.document.receiptprocess.suggestions");
		}
	}

}
