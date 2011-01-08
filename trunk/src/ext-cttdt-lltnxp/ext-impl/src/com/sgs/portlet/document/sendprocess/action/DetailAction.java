/**
 * 
 */
package com.sgs.portlet.document.sendprocess.action;

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
import com.sgs.portlet.document.receipt.service.persistence.PmlEdmAttachedFileUtil;
import com.sgs.portlet.document.send.dto.DocumentSendDTO;
import com.sgs.portlet.document.send.model.PmlEdmDocumentSend;
import com.sgs.portlet.document.send.model.impl.PmlEdmDocumentSendImpl;
import com.sgs.portlet.document.send.service.PmlEdmDocumentSendLocalServiceUtil;
import com.sgs.portlet.document.workflow.DocumentSendPortletAction;

/**
 * @author doanhdv
 *
 */
public class DetailAction extends DocumentSendPortletAction {
	private static Log _log = LogFactory.getLog(DetailAction.class);
	
	public void processStrutsAction(ActionMapping mapping, ActionForm form,
			PortletConfig config, ActionRequest req, ActionResponse res)
			throws Exception {
		/*
		 * Process Action Code Goes Here
		 * 
		 * */
	}

	
	

	public ActionForward renderStruts(ActionMapping mapping, ActionForm form,
			PortletConfig config, RenderRequest req, RenderResponse res)
			throws Exception {
		long documentSendId = ParamUtil.getLong(req, "documentSendId");
		
		PmlEdmDocumentSend documentSend = PmlEdmDocumentSendLocalServiceUtil.getPmlEdmDocumentSend(documentSendId);
		DocumentSendDTO documentSendDTO = populateDocumentSendToDTO(documentSend);
		
		req.setAttribute("documentSendDTO", documentSendDTO);
		
		//get files attach
		PmlEdmDocumentSend documentSendImpl = new PmlEdmDocumentSendImpl();		
//		List<PmlEdmAttachedFile> listPmlEdmAttachedFile = PmlEdmAttachedFileUtil.findByObjectContentId_ObjectType(documentSendId, documentSendImpl.getClass().getName());
//		req.setAttribute("listPmlEdmAttachedFile", listPmlEdmAttachedFile);
		
		List<PmlEdmAttachedFile> attachFiles = PmlEdmAttachedFileUtil.findByObjectContentId_ObjectType(documentSendId, documentSendImpl.getClass().getName());
		req.setAttribute("attachFiles", attachFiles);
		
		if (getForward(req) != null && !getForward(req).equals("")) {
			return mapping.findForward(getForward(req)); // Use forward set in processAction if available
		} else {
			_log.info("----------detail----------");
			return mapping.findForward("portlet.sgs.document.sendprocess.detail");
		}
	}
}
