/**
 * 
 */
package com.sgs.portlet.document.workflow;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.portlet.PortletRequest;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.User;
import com.liferay.portal.service.persistence.UserUtil;
import com.liferay.portal.util.PortalUtil;
import com.sgs.liferay.jbpm.service.LiferayWorkflowService;
import com.sgs.liferay.web.struts.action.WorkflowPortletAction;
import com.sgs.liferay.web.struts.support.TaskNameDispatcher;
import com.sgs.portlet.department.model.Department;
import com.sgs.portlet.department.service.DepartmentLocalServiceUtil;
import com.sgs.portlet.document.model.PmlDocumentSendWF;
import com.sgs.portlet.document.receipt.model.PmlEdmConfidentialLevel;
import com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordType;
import com.sgs.portlet.document.receipt.model.PmlEdmDocumentType;
import com.sgs.portlet.document.receipt.model.PmlEdmPrivilegeLevel;
import com.sgs.portlet.document.receipt.service.PmlEdmConfidentialLevelLocalServiceUtil;
import com.sgs.portlet.document.receipt.service.PmlEdmDocumentRecordTypeLocalServiceUtil;
import com.sgs.portlet.document.receipt.service.PmlEdmDocumentTypeLocalServiceUtil;
import com.sgs.portlet.document.receipt.service.PmlEdmPrivilegeLevelLocalServiceUtil;
import com.sgs.portlet.document.send.dto.DocumentSendDTO;
import com.sgs.portlet.document.send.dto.LogProcessDTO;
import com.sgs.portlet.document.send.model.PmlEdmDocumentSend;
import com.sgs.portlet.document.service.persistence.PmlDocumentSendWFUtil;
import com.sgs.portlet.document.service.persistence.PmlStateProcessUtil;
import com.sgs.portlet.pcccdocumentreceipt.util.PCCCDocumentUtil;
import com.sgs.portlet.pmluser.model.PmlUser;
import com.sgs.portlet.pmluser.service.PmlUserLocalServiceUtil;

/**
 * @author hieuvh
 *
 */
public abstract class DocumentSendPortletAction extends WorkflowPortletAction {
	public static final String COMMAND_PREFIX = "command.document.send";
	
	private DocumentSendLiferayWorkflowService documentSendLWS = new DocumentSendLiferayWorkflowService(); 
	private DocumentSendProcessTaskNameDispatcher documentSendTND = new DocumentSendProcessTaskNameDispatcher();
	
	@Override
	protected LiferayWorkflowService getLiferayWorkflowService() {
		 return documentSendLWS;
	}

	@Override
	protected long getProcessInstanceId(PortletRequest req) {
		// get documentSendId from request.
		long documentSendId = ParamUtil.getLong(req, "documentSendId", -1);
		long userIdXLT = ParamUtil.getLong(req, "userIdXLT", -1);	// yenlt update 11082010
		// yenlt update 20101102
		boolean rutLai = ParamUtil.getBoolean(req, "rutLai", false);
		long receiverIdBack = ParamUtil.getLong(req, "receiverIdBack", -1);
		// end yenlt update 20101102
		if (documentSendId == -1) {
			return -1;
		}
		
		// find a WF_DocumentSend entry with given fileId
		PmlDocumentSendWF wf = null;
		
		try {
			wf = PmlDocumentSendWFUtil.findByPrimaryKey(documentSendId);
		} catch (PortalException e) {
			e.printStackTrace();
		} catch (SystemException e) {
			e.printStackTrace();
		}
		
		// if not exist WF_DocumentSend entry return -1
		if (Validator.isNull(wf)) {
			return -1;
		}

		// yenlt update 11082010 
		
		// get User Id login portal
		long userId = PortalUtil.getUserId(PortalUtil.getHttpServletRequest(req));
		if (userId == 0) {
			return -1;
		}
		
		// yenlt update 20101119
		//boolean hasRight = documentSendLWS.checkUserInDocumentSendWorkflow(userId, wf.getProcessId()); 
		boolean hasRight = false;
		if (rutLai) {
			hasRight = documentSendLWS.checkUserInDocumentSendWorkflow(receiverIdBack, wf.getProcessId()); 
		} else {
			hasRight = documentSendLWS.checkUserInDocumentSendWorkflow(userId, wf.getProcessId()); 
		}
		// end yenlt update 20101119
		
		if (hasRight) {
			return wf.getProcessId();
		}
		
		if (userIdXLT != -1) {
			boolean hasRightXLT = documentSendLWS.checkUserInDocumentSendWorkflow(userIdXLT, wf.getProcessId());
			
			if (hasRightXLT) {
				return wf.getProcessId();
			}
		}
		
		return -1;
		// end yenlt
		// RETURN processId
//		return wf.getProcessId(); // yenlt close 11082010
		
	}

	@Override
	protected long getTaskInstanceId(PortletRequest req) {
		// get "taskId" parameter from request.
		return ParamUtil.getLong(req, "taskId", -1);
	}

	@Override
	protected TaskNameDispatcher getTaskNameDispatcher() {
		return documentSendTND;
	}

	/**
	 * @param documentSend
	 * @return
	 */
	protected DocumentSendDTO populateDocumentSendToDTO(PmlEdmDocumentSend documentSend) {
		PmlEdmDocumentType documentType = null;
		PmlEdmPrivilegeLevel privilegel = null;
		PmlEdmConfidentialLevel confidentialLevel = null;
		DocumentSendDTO sendDTO = null;
		try {
			long documentTypeId = documentSend.getDocumentTypeId();
			documentType = PmlEdmDocumentTypeLocalServiceUtil.getPmlEdmDocumentType(documentTypeId);
			
			long editorId = documentSend.getEditorId();
			/* xuancong close start
			 * Bi loi khi khong lay duoc nguoi dung 
			User user = UserUtil.findByPrimaryKey(editorId);
			String editor = user.getLastName() + " " + user.getMiddleName() + " " + user.getFirstName();
			*/
			// xuancong add start
			// Ap dung khi nguoi dung import vao ko co
			User user = null;
			String editor = "";
			if (editorId > 0) {
				try {
					user = UserUtil.findByPrimaryKey(editorId);
					editor = user.getLastName() + " " + user.getMiddleName() + " " + user.getFirstName();
				}
				catch (Exception ex) {
					// Do nothing
				}
			}
			// xuancong add end
		
			confidentialLevel = PmlEdmConfidentialLevelLocalServiceUtil
				.getPmlEdmConfidentialLevel(documentSend.getConfidentialLevelId());
			privilegel = PmlEdmPrivilegeLevelLocalServiceUtil
				.getPmlEdmPrivilegeLevel(documentSend.getPrivilegeLevelId());
		
			String signer = documentSend.getSignerName();
			
			sendDTO = new DocumentSendDTO();
			sendDTO.setDocumentSendId(documentSend.getDocumentSendId());
			sendDTO.setBriefContent(documentSend.getBriefContent());
			sendDTO.setDocumentReference(documentSend.getDocumentReference());
			sendDTO.setReceivingPlace(documentSend.getReceivingPlace());
			
			sendDTO.setIssuingDate(documentSend.getIssuingDate());
			
			sendDTO.setActive(documentSend.getActive());
			sendDTO.setConfidentialLevel(confidentialLevel.getConfidentialLevelName());
			sendDTO.setDateCreate(documentSend.getDateCreated());
			sendDTO.setDocumentType(documentType.getDocumentTypeName());
			sendDTO.setEditor(editor);
			sendDTO.setIsLocal(documentSend.getIsLocal());
			sendDTO.setOpinion(documentSend.getOpinion());
			sendDTO.setPrivilegel(privilegel.getPrivilegeLevelName());
			sendDTO.setSigner(signer);
			sendDTO.setIscongvanphucdap(documentSend.getIscongvanphucdap());
			
//			String state = ((DocumentSendLiferayWorkflowService) getLiferayWorkflowService())
//					.getCurrentStateOfDocumentSend(documentSend.getDocumentSendId());
//			sendDTO.setState(state);
			
			String stateProcess = ((DocumentSendLiferayWorkflowService) getLiferayWorkflowService())
					.getCurrentStateOfDocumentSend(documentSend.getDocumentSendId());
			try{
				stateProcess = PmlStateProcessUtil.findByStateProcessCode(stateProcess).get(0).getStateProcessName();
			} catch (Exception e) {				
			}
			
			sendDTO.setState(stateProcess);
			
			sendDTO.setSendDate(documentSend.getSendDate());
			sendDTO.setPosition(documentSend.getPosition());
			sendDTO.setDocumentSendCode(documentSend.getDocumentSendCode());
			sendDTO.setNumberPage(documentSend.getNumberPage());
			sendDTO.setNumberPublish(documentSend.getNumberPublish());
			int documentRecordTypeId = documentType.getDocumentRecordTypeId();
			PmlEdmDocumentRecordType documentRecordType = 
					PmlEdmDocumentRecordTypeLocalServiceUtil
					.getPmlEdmDocumentRecordType(documentRecordTypeId);
			sendDTO.setDocumentRecord(documentRecordType.getDocumentRecordTypeName());
			
			// phmphuc them 2 thuoc tinh cho vb di phat hanh - 01/12/2010
			PmlUser pmlUser = PmlUserLocalServiceUtil.getPmlUser(editorId);
			Department department = DepartmentLocalServiceUtil.getDepartment(pmlUser.getDepartmentsId());
			
			long soHieuVB = PCCCDocumentUtil.getSoHieuVB(documentTypeId);
			String phanMoRong = PCCCDocumentUtil.getPhanMoRong(documentTypeId, department.getDepartmentsId());
			sendDTO.setSoHieuVB(soHieuVB);
			sendDTO.setPhanMoRong(phanMoRong);
			// end phmphuc them 01/12/2010
			sendDTO.setDocumentTypeId(documentTypeId);
			sendDTO.setDocumentRecordTypeId(documentSend.getDocumentRecordTypeId());
		}
		catch (PortalException e) {
			e.printStackTrace();
		}
		catch (SystemException e) {
			e.printStackTrace();
		}
		return sendDTO;
	}

	/**
	 * Chuyen gia tri tu doi tuong cong van di sang DTO
	 * @param documentSend
	 * @return
	 */
	protected DocumentSendDTO populateDocumentSendToDTO2(PmlEdmDocumentSend documentSend) {
		PmlEdmDocumentType documentType = null;
		PmlEdmPrivilegeLevel privilegel = null;
		PmlEdmConfidentialLevel confidentialLevel = null;
		DocumentSendDTO sendDTO = null;
		try {
			documentType = PmlEdmDocumentTypeLocalServiceUtil
				.getPmlEdmDocumentType(documentSend.getDocumentTypeId());
		
		
			long editorId = documentSend.getEditorId();
			User user = UserUtil.findByPrimaryKey(editorId);
			String editor = user.getLastName() + " " + user.getMiddleName() + " " + user.getFirstName();
		
			confidentialLevel = PmlEdmConfidentialLevelLocalServiceUtil
				.getPmlEdmConfidentialLevel(documentSend.getConfidentialLevelId());
			privilegel = PmlEdmPrivilegeLevelLocalServiceUtil
				.getPmlEdmPrivilegeLevel(documentSend.getPrivilegeLevelId());
		
			String signer = documentSend.getSignerName();
			
			sendDTO = new DocumentSendDTO();
			sendDTO.setDocumentSendId(documentSend.getDocumentSendId());
			sendDTO.setBriefContent(documentSend.getBriefContent());
			sendDTO.setDocumentReference(documentSend.getDocumentReference());
			sendDTO.setReceivingPlace(documentSend.getReceivingPlace());
			
			sendDTO.setIssuingDate(documentSend.getIssuingDate());
			
			sendDTO.setActive(documentSend.getActive());
			sendDTO.setConfidentialLevel(confidentialLevel.getConfidentialLevelName());
			sendDTO.setDateCreate(documentSend.getDateCreated());
			sendDTO.setDocumentType(documentType.getDocumentTypeName());
			sendDTO.setEditor(editor);
			sendDTO.setIsLocal(documentSend.getIsLocal());
			sendDTO.setOpinion(documentSend.getOpinion());
			sendDTO.setPrivilegel(privilegel.getPrivilegeLevelName());
			sendDTO.setSigner(signer);
			sendDTO.setIscongvanphucdap(documentSend.getIscongvanphucdap());
			
//			String state = ((DocumentSendLiferayWorkflowService) getLiferayWorkflowService())
//					.getCurrentStateOfDocumentSend(documentSend.getDocumentSendId());
//			sendDTO.setState(state);
			
			/*
			Lay trang thai xu ly tu quy trinh
			String stateProcess = ((DocumentSendLiferayWorkflowService) getLiferayWorkflowService())
					.getCurrentStateOfDocumentSend(documentSend.getDocumentSendId());
			try{
				stateProcess = PmlStateProcessUtil.findByStateProcessCode(stateProcess).get(0).getStateProcessName();
			} 
			catch (Exception e) {				
			}
			*/
			// Chua dung trang thai xu ly, tam thoi gan la rong
			String stateProcess = "";
			
			sendDTO.setState(stateProcess);
			
			sendDTO.setSendDate(documentSend.getSendDate());
			sendDTO.setPosition(documentSend.getPosition());
			sendDTO.setDocumentSendCode(documentSend.getDocumentSendCode());
			sendDTO.setNumberPage(documentSend.getNumberPage());
			sendDTO.setNumberPublish(documentSend.getNumberPublish());
			int documentRecordTypeId = documentType.getDocumentRecordTypeId();
			PmlEdmDocumentRecordType documentRecordType = 
					PmlEdmDocumentRecordTypeLocalServiceUtil
					.getPmlEdmDocumentRecordType(documentRecordTypeId);
			sendDTO.setDocumentRecord(documentRecordType.getDocumentRecordTypeName());
			
		}
		catch (PortalException e) {
			e.printStackTrace();
		}
		catch (SystemException e) {
			e.printStackTrace();
		}
		return sendDTO;
	}

	

	protected List<LogProcessDTO> getLogProcessDTOs(long documentSendId) {
		List<LogProcessDTO> logProcessDTOs = new ArrayList<LogProcessDTO>();
		LogProcessDTO logProcessDTO = new LogProcessDTO();
		logProcessDTO.setSender("nguyen van a");
		logProcessDTO.setReceiver("nguyen van b");
		logProcessDTO.setDate(new Date());
		logProcessDTO.setContent("noi dung xu ly");
		logProcessDTO.setState("dang xu ly");
		logProcessDTOs.add(logProcessDTO);
		return logProcessDTOs;
	}
}
