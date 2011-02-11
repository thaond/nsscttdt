package com.sgs.portlet.pml_ho_so_cong_viec.action;

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

import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.model.User;
import com.liferay.portal.service.persistence.UserUtil;
import com.sgs.portlet.document.model.PmlDocumentSendLog;
import com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile;
import com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt;
import com.sgs.portlet.document.receipt.model.impl.PmlEdmDocumentReceiptImpl;
import com.sgs.portlet.document.receipt.service.persistence.PmlEdmAttachedFileUtil;
import com.sgs.portlet.document.receipt.service.persistence.PmlEdmDocumentReceiptUtil;
import com.sgs.portlet.document.send.dto.DocumentSendDTO;
import com.sgs.portlet.document.send.model.PmlEdmAnswerDetail;
import com.sgs.portlet.document.send.model.PmlEdmDocumentSend;
import com.sgs.portlet.document.send.model.impl.PmlEdmDocumentSendImpl;
import com.sgs.portlet.document.send.service.PmlEdmDocumentSendLocalServiceUtil;
import com.sgs.portlet.document.send.service.persistence.PmlEdmAnswerDetailUtil;
import com.sgs.portlet.document.service.persistence.PmlDocumentSendLogUtil;
import com.sgs.portlet.document.workflow.DocumentSendPortletAction;
import com.sgs.portlet.department.model.Department;
import com.sgs.portlet.pmluser.model.PmlUser;
import com.sgs.portlet.pmluser.service.PmlUserLocalServiceUtil;
import com.sgs.portlet.department.service.persistence.DepartmentUtil;
import com.sgs.portlet.pcccdocumentsend.dto.DocumentSendLogDTO;
import com.sgs.portlet.pml_ho_so_cong_viec.model.PmlChiTietHSCV;
import com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec;
import com.sgs.portlet.pml_ho_so_cong_viec.service.persistence.PmlChiTietHSCVUtil;
import com.sgs.portlet.pml_ho_so_cong_viec.service.persistence.PmlHoSoCongViecUtil;

public class DetailSendAction extends DocumentSendPortletAction {
	
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
		DocumentSendDTO documentSendDTO = new DocumentSendDTO();
		long documentSendId = ParamUtil.getLong(req, "documentSendId");
		PmlEdmDocumentSend document = PmlEdmDocumentSendLocalServiceUtil
										.getPmlEdmDocumentSend(documentSendId);
		documentSendDTO = populateDocumentSendToDTO2(document);
		
		List<PmlEdmAttachedFile> attachedFiles = PmlEdmAttachedFileUtil
						.findByObjectContentId_ObjectType(documentSendId, 
							new PmlEdmDocumentSendImpl().getClass().getName());
		List<PmlEdmAnswerDetail> answerDetails = 
			PmlEdmAnswerDetailUtil.findByDocumentSendId(documentSendId);
		
		if (answerDetails != null && answerDetails.size() != 0) {
			PmlEdmAnswerDetail answerDetail = answerDetails.get(0);
			long documentReceipt = answerDetail.getDocumentReceiptId();
			PmlEdmDocumentReceipt receipt = PmlEdmDocumentReceiptUtil.findByPrimaryKey(documentReceipt);
			req.setAttribute("documentReceipt", receipt);
			
			List<PmlEdmAttachedFile> attachedFileReceivers = PmlEdmAttachedFileUtil
			.findByObjectContentId_ObjectType(documentReceipt, 
				new PmlEdmDocumentReceiptImpl().getClass().getName());
			req.setAttribute("attachedFileReceivers", attachedFileReceivers);
		}
		
		long editor = document.getEditorId();
		PmlUser user = PmlUserLocalServiceUtil.getPmlUser(editor);
		String departmentId = user.getDepartmentsId();
		Department department = DepartmentUtil.findByPrimaryKey(departmentId);
		
		req.setAttribute("department", department.getDepartmentsName());
		
		
		req.setAttribute("documentDTO", documentSendDTO);
		req.setAttribute("attachedFiles", attachedFiles);
		
		
		//lay hscv
		List<PmlChiTietHSCV> chiTietHSCVList = new ArrayList<PmlChiTietHSCV>();
		try {
			chiTietHSCVList = PmlChiTietHSCVUtil.findByIdCongVanDi(documentSendId);
		} catch (Exception e) {
			
		}
		
		List<PmlHoSoCongViec> pmlHoSoCongViecList = new ArrayList<PmlHoSoCongViec>();
		if (chiTietHSCVList.size() > 0) {
			
			PmlHoSoCongViec pmlHoSoCongViec = null;
			for (PmlChiTietHSCV pmlChiTietHSCV : chiTietHSCVList) {
				try {
					pmlHoSoCongViec = PmlHoSoCongViecUtil.findByPrimaryKey(pmlChiTietHSCV.getIdHoSoCongViec());
				} catch (Exception e) {	}
					
				if (pmlHoSoCongViec != null) {
					pmlHoSoCongViecList.add(pmlHoSoCongViec);
				}
					
			}
		}
		req.setAttribute("pmlHoSoCongViecList", pmlHoSoCongViecList);
		
		
		//watch series process
		List<PmlDocumentSendLog> pmlDocumentSendLogList = PmlDocumentSendLogUtil.findByDocumentSendId(documentSendId);
		List<DocumentSendLogDTO> documentSendLogDTOs = new ArrayList<DocumentSendLogDTO>();
		if (pmlDocumentSendLogList != null) {
			for (int i = 0; i < pmlDocumentSendLogList.size(); i++) {
				PmlDocumentSendLog log = pmlDocumentSendLogList.get(i);
				DocumentSendLogDTO sendDTO = new DocumentSendLogDTO();
				User processer = null;
				try {
					processer = UserUtil.findByPrimaryKey(log.getProcesser());
					sendDTO.setProcessor(
						com.sgs.portlet.pcccdocumentsend.util.DocumendSendUtil
						.getVietnameseStypeName(processer));
						
				} catch (Exception e) {
					sendDTO.setProcessor("");
				}
				sendDTO.setProcessor(
					com.sgs.portlet.pcccdocumentsend.util.DocumendSendUtil.getVietnameseStypeName(processer));
				sendDTO.setDateProcess(log.getDateProcess());
				sendDTO.setProcessInformation(log.getProcessInfomation());
				User receiver = null;
				try {
					receiver = UserUtil.findByPrimaryKey(log.getReceiver());
					sendDTO.setReceiver(
						com.sgs.portlet.pcccdocumentsend.util.DocumendSendUtil.getVietnameseStypeName(receiver));
				} catch (Exception e) {
					sendDTO.setReceiver("");
				}
				
				sendDTO.setReceiverDate(log.getReceiveDate());
				sendDTO.setExpireDate(log.getExpiredDate());
				documentSendLogDTOs.add(sendDTO);
			}
		}
		
		List<DocumentSendLogDTO> logDTOs = new ArrayList<DocumentSendLogDTO>();
		for (int i = documentSendLogDTOs.size() -1; i > -1; i--) {
			logDTOs.add(documentSendLogDTOs.get(i));
		}
		
		req.setAttribute("pmlDocumentSendLogList", logDTOs);
		
		/* get current node by fileId */
		/*
		 DocumentSendLiferayWorkflowService service = new DocumentSendLiferayWorkflowService();
		service.updateReceiveDate(documentSendId, PortalUtil.getUserId(req));
		*/
		
			if (getForward(req) != null && !getForward(req).equals("")) {
				return mapping.findForward(getForward(req)); // Use forward set in processAction if available
			} else {
				return mapping.findForward("portlet.sgs.pml_ho_so_cong_viec.detailSend");
			}
	}

}
