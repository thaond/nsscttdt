/**
 * 
 */
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

/**
 * Prepare data and set them into attribute of request. Detail form will use
 * these data to show. 
 * @author doanhdv create
 * @author kienbqc filter data and process
 * @author hieuvh change to jbpm
 *
 */
public class DetailAction extends DocumentReceiptPortletAction {
	public void processStrutsAction(ActionMapping mapping, ActionForm form,
			PortletConfig config, ActionRequest req, ActionResponse res)
			throws Exception {
		/*
		 * Process Action Code Goes Here
		 * 
		 * */
	}

	public ActionForward renderStruts(ActionMapping mapping, ActionForm form,
			PortletConfig config, RenderRequest req, RenderResponse res) {
			try {	
				/* Get documentReceiptId from request */
				long documentReceiptId = Long.parseLong(
					ParamUtil.getString(req, "documentReceiptId"));
				
				/* get receipt document object with documentReceiptId */
				PmlEdmDocumentReceipt documentReceipt = 
					PmlEdmDocumentReceiptLocalServiceUtil
					.getPmlEdmDocumentReceipt(documentReceiptId);
				
				/* declare new documentReceiptDTO */
				PmlEdmDocumentReceiptDTO documentDTO = 
					new PmlEdmDocumentReceiptDTO();
				
				/* trans documentReceipt to documentReceiptDTo */
				documentDTO = populateDocumentReceiptToDTO(req, documentReceipt);
				
				long userId = PortalUtil.getUserId(req);
				
				/* set documentDTO object into attribute of request */
				req.setAttribute("documentDTO", documentDTO);
				
				/* 
				 * get files attach
				 */
				PmlEdmDocumentReceipt documentReceiptImp = 
					new PmlEdmDocumentReceiptImpl();
				List<PmlEdmAttachedFile> listPmlEdmAttachedFile = 
					PmlEdmAttachedFileUtil
					.findByObjectContentId_ObjectType(documentReceiptId, 
						documentReceiptImp.getClass().getName());
				
				/* set list attachedFile into attribute of request */
				req.setAttribute("listPmlEdmAttachedFile", 
					listPmlEdmAttachedFile);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			if (getForward(req) != null && !getForward(req).equals("")) {
				return mapping.findForward(getForward(req)); 
			} else {
				return mapping.findForward("portlet.sgs.document.receiptprocess.detail");
			}
	}
}
