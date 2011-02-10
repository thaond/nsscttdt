/**
 * chuan bi du lieu cho form update
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
import com.sgs.portlet.document.receipt.model.PmlEdmConfidentialLevel;
import com.sgs.portlet.document.receipt.model.PmlEdmDocumentType;
import com.sgs.portlet.document.receipt.model.PmlEdmPrivilegeLevel;
import com.sgs.portlet.document.receipt.service.persistence.PmlEdmAttachedFileUtil;
import com.sgs.portlet.document.receipt.service.persistence.PmlEdmConfidentialLevelUtil;
import com.sgs.portlet.document.receipt.service.persistence.PmlEdmDocumentTypeUtil;
import com.sgs.portlet.document.receipt.service.persistence.PmlEdmPrivilegeLevelUtil;
import com.sgs.portlet.document.send.model.PmlEdmDocumentSend;
import com.sgs.portlet.document.send.model.impl.PmlEdmDocumentSendImpl;
import com.sgs.portlet.document.send.service.PmlEdmDocumentSendLocalServiceUtil;
import com.sgs.portlet.document.workflow.DocumentSendPortletAction;

/**
 * @author doanhdv
 *
 */
public class EditAction extends DocumentSendPortletAction {
	private static Log _log = LogFactory.getLog(EditAction.class);
	
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
		
		List<PmlEdmPrivilegeLevel> privilegeLevels = PmlEdmPrivilegeLevelUtil.findAll();
		List<PmlEdmDocumentType> documentTypes = PmlEdmDocumentTypeUtil.findAll();
		List<PmlEdmConfidentialLevel> confidentialLevels = PmlEdmConfidentialLevelUtil.findAll();
		
		req.setAttribute("privilegeLevels", privilegeLevels);
		req.setAttribute("documentTypes", documentTypes);
		req.setAttribute("confidentialLevels", confidentialLevels);
		
		req.setAttribute("documentSend", documentSend);
		
		
		//get files attach
		PmlEdmDocumentSend documentSendImpl = new PmlEdmDocumentSendImpl();
		List<PmlEdmAttachedFile> listPmlEdmAttachedFile = PmlEdmAttachedFileUtil.findByObjectContentId_ObjectType(documentSendId, documentSendImpl.getClass().getName());
		req.setAttribute("listPmlEdmAttachedFile", listPmlEdmAttachedFile);	
		if (getForward(req) != null && !getForward(req).equals("")) {
			return mapping.findForward(getForward(req)); // Use forward set in processAction if available
		} else {
			_log.info("----------edit----------");
			return mapping.findForward("portlet.sgs.document.sendprocess.edit");
		}
	}
}
