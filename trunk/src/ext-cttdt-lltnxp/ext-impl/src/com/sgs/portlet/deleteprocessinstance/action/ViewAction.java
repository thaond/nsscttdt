package com.sgs.portlet.deleteprocessinstance.action;


import java.util.ArrayList;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.User;
import com.liferay.portal.util.PortalUtil;
import com.sgs.portlet.deleteprocessinstance.search.DeleteDocumentSendUnpublishDisplayTerms;
import com.sgs.portlet.document.model.PmlDocumentSendWF;
import com.sgs.portlet.document.receipt.model.PmlEdmDocumentType;
import com.sgs.portlet.document.receipt.service.PmlEdmAttachedFileLocalServiceUtil;
import com.sgs.portlet.document.receipt.service.persistence.PmlEdmDocumentTypeUtil;
import com.sgs.portlet.document.send.model.impl.PmlEdmDocumentSendImpl;
import com.sgs.portlet.document.send.service.PmlEdmAnswerDetailLocalServiceUtil;
import com.sgs.portlet.document.send.service.PmlEdmDocumentSendLocalServiceUtil;
import com.sgs.portlet.document.send.service.PmlEdmWriteDocumentSendLocalServiceUtil;
import com.sgs.portlet.document.send.service.persistence.PmlEdmDocumentSendUtil;
import com.sgs.portlet.document.service.PmlDocumentSendLogLocalServiceUtil;
import com.sgs.portlet.document.service.PmlDocumentSendWFLocalServiceUtil;
import com.sgs.portlet.document.service.persistence.PmlDocumentSendWFUtil;
import com.sgs.portlet.document.workflow.DocumentSendLiferayWorkflowService;
import com.sgs.portlet.document.workflow.DocumentSendPortletAction;
import com.sgs.portlet.pml_ho_so_cong_viec.service.PmlChiTietHSCVLocalServiceUtil;

public class ViewAction extends DocumentSendPortletAction {
	private static final boolean _CHECK_METHOD_ON_PROCESS_ACTION = false;
	
	protected boolean isCheckMethodOnProcessAction() {
		return _CHECK_METHOD_ON_PROCESS_ACTION;
	}

	public void processStrutsAction(ActionMapping mapping, ActionForm form,
			PortletConfig portletConfig, ActionRequest actionRequest,
			ActionResponse actionResponse) throws Exception {
		String cmd = ParamUtil.getString(actionRequest, Constants.CMD);
		String redirect = ParamUtil.getString(actionRequest, "redirect"); 

		if (Validator.isNotNull(cmd)) {
			if (Constants.DELETE.equals(cmd)) {
				deleteDocumentSendFromList(actionRequest);
				sendRedirect(actionRequest, actionResponse, redirect);
			}
		}
	}

	public void deleteDocumentSendFromList(ActionRequest actionRequest) {
		String idDocumentSendList = actionRequest.getParameter("deleteDocumentSendIds");
		String idDocumentSend = actionRequest.getParameter("deleteDocumentSendId");
		
		if (!"".equals(idDocumentSendList)) {
			String[] documentSendIds = idDocumentSendList.split(",");
			if (documentSendIds.length > 0) {
				for (int i=0; i < documentSendIds.length; i++) {
					deleteDocumentSend(actionRequest,Long.valueOf(documentSendIds[i]));
				}
			}
		}
		
		if (!"".equals(idDocumentSend)) {
			deleteDocumentSend(actionRequest,Long.parseLong(idDocumentSend));
		}
		
	}

	public void deleteDocumentSend(ActionRequest req, long documentSendId){
		try {
			// Kiem tra ma so van ban di ton tai
			PmlEdmDocumentSendUtil.findByPrimaryKey(documentSendId);
			// Xoa log luan chuyen van ban di
			PmlDocumentSendLogLocalServiceUtil.deletePmlDocumentSendLogBySendId(documentSendId);
			// Xoa chi tiet ho so cong viec
			PmlChiTietHSCVLocalServiceUtil.deletePmlChiTietHSCVByCVDiId(documentSendId);
			// Xoa lien quan van ban den va van ban di
			PmlEdmAnswerDetailLocalServiceUtil.deletePmlEdmAnswerDetailBySendId(documentSendId);
			// Xoa file dinh kem van ban di
			PmlEdmAttachedFileLocalServiceUtil.deletePmlEdmAttachedFileByOO(documentSendId, 
					new PmlEdmDocumentSendImpl().getClass().getName());
			// Xoa pml_edm_writedocumentsend
			PmlEdmWriteDocumentSendLocalServiceUtil.deletePmlEdmWriteDocumentSendBySendId(documentSendId);
			// Xoa thong tin van ban di
			User user = PortalUtil.getUser(req);
			PmlEdmDocumentSendLocalServiceUtil.deletePmlEdmDocumentSend(user.getCompanyId(), documentSendId);
			// Xoa jbpm cua van ban
			DocumentSendLiferayWorkflowService workflowService = new DocumentSendLiferayWorkflowService();
			PmlDocumentSendWF documentSendWF = null;
			try {
				documentSendWF = PmlDocumentSendWFUtil.findByPrimaryKey(documentSendId);
				workflowService.getJbpmService().deleteProcessInstance(documentSendWF.getProcessId());
				PmlDocumentSendWFLocalServiceUtil.deletePmlDocumentSendWF(documentSendId);
			} catch (Exception e) {
				
			}
			
		} 
		catch (Exception e) {
			System.out.println("ERROR IN method deleteDocumentSend : CAN NOT DELETE");
		}
	}
	
	public ActionForward renderStruts(ActionMapping mapping, ActionForm form,
			PortletConfig portletConfig, RenderRequest req,
			RenderResponse res) throws Exception {
		List<PmlEdmDocumentType> pmlEdmDocumentTypeList = new ArrayList<PmlEdmDocumentType>();
		try {
			pmlEdmDocumentTypeList = PmlEdmDocumentTypeUtil.findAll();
		} catch (Exception e) {
			pmlEdmDocumentTypeList = new ArrayList<PmlEdmDocumentType>();
		}
		
		long documentTypeId = ParamUtil.getLong(req, DeleteDocumentSendUnpublishDisplayTerms.LOAIVB, 0);
		
		req.setAttribute("documentTypeId", documentTypeId);
		req.setAttribute("pmlEdmDocumentTypeList", pmlEdmDocumentTypeList);
		
		return mapping.findForward("portlet.sgs.deleteprocessinstance.view");
	}

}
