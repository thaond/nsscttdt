package com.sgs.portlet.doccumentprivate.action;

import java.util.List;

import javax.portlet.ActionRequest;

import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.struts.PortletAction;
import com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile;
import com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt;
import com.sgs.portlet.document.receipt.model.impl.PmlEdmDocumentReceiptImpl;
import com.sgs.portlet.document.receipt.service.PmlEdmDocumentReceiptLocalServiceUtil;
import com.sgs.portlet.document.receipt.service.persistence.PmlEdmAttachedFileUtil;

public class DetailAction extends PortletAction {
	private static Log _log = LogFactory.getLog(DetailAction.class);
	
	public void processAction(ActionMapping mapping, ActionForm form,
			PortletConfig config, ActionRequest req, ActionResponse res)
			throws Exception {
			
	}

	
	
	public ActionForward render(ActionMapping mapping, ActionForm form,
			PortletConfig config, RenderRequest req, RenderResponse res)
			throws Exception {
			
			if (getForward(req) != null && !getForward(req).equals("")) {
				return mapping.findForward(getForward(req)); // Use forward set in processAction if available
			} else {
				long documentReceiptId = ParamUtil.getLong(req, "documentReceiptId");
				PmlEdmDocumentReceipt documentReceipt = PmlEdmDocumentReceiptLocalServiceUtil.getPmlEdmDocumentReceipt(documentReceiptId);
			
				List<PmlEdmAttachedFile> attachedFiles = PmlEdmAttachedFileUtil.findByObjectContentId_ObjectType(documentReceiptId, 
						new PmlEdmDocumentReceiptImpl().getClass().getName());
				req.setAttribute("attachedFiles", attachedFiles);
				req.setAttribute("documentReceipt", documentReceipt);
				return mapping.findForward("portlet.sgs.doccumentprivate.viewDetail");
			}
	}

}
