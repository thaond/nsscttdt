/**
 * 
 */
package com.sgs.portlet.document.workflow;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.portlet.PortletRequest;

import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.util.PortalUtil;
import com.sgs.liferay.jbpm.service.LiferayWorkflowService;
import com.sgs.liferay.web.struts.action.WorkflowPortletAction;
import com.sgs.liferay.web.struts.support.TaskNameDispatcher;
import com.sgs.portlet.document.model.PmlDocumentReceiptWF;
import com.sgs.portlet.document.model.PmlStateProcess;
import com.sgs.portlet.document.receipt.dto.PmlEdmDocumentReceiptDTO;
import com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt;
import com.sgs.portlet.document.receipt.model.PmlFileStatusStateProcess;
import com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace;
import com.sgs.portlet.document.receipt.service.PmlEdmConfidentialLevelLocalServiceUtil;
import com.sgs.portlet.document.receipt.service.PmlEdmDocumentTypeLocalServiceUtil;
import com.sgs.portlet.pmlissuingplace.service.PmlEdmIssuingPlaceLocalServiceUtil;
import com.sgs.portlet.document.receipt.service.PmlEdmPrivilegeLevelLocalServiceUtil;
import com.sgs.portlet.document.receipt.service.persistence.PmlFileStatusStateProcessUtil;
import com.sgs.portlet.pmllevelsend.service.persistence.PmlEdmLevelSendUtil;
import com.sgs.portlet.document.service.persistence.PmlDocumentReceiptWFUtil;
import com.sgs.portlet.document.service.persistence.PmlStateProcessUtil;

/**
 * @author hieuvh
 *
 */
public abstract class DocumentReceiptPortletAction extends WorkflowPortletAction {
	public static final String COMMAND_PREFIX = "command.document.receipt";
	
	protected DocumentReceiptLiferayWorkflowService documentReceiptLWS = new DocumentReceiptLiferayWorkflowService(); 
	protected DocumentReceiptProcessTaskNameDispatcher documentReceiptTND = new DocumentReceiptProcessTaskNameDispatcher();
	
	@Override
	protected LiferayWorkflowService getLiferayWorkflowService() {
		 return documentReceiptLWS;
	}

	@Override
	protected long getProcessInstanceId(PortletRequest req) {
		// get documentReceiptId from request.
		long documentReceiptId = ParamUtil.getLong(req, "documentReceiptId", -1);
		long userIdXLT = ParamUtil.getLong(req, "userIdXLT", -1);	
		// yenlt update rut lai vb 20101119
		boolean rutLai = ParamUtil.getBoolean(req, "rutLai", false);
		long receiverIdBack = ParamUtil.getLong(req, "receiverIdBack", -1);
		// end yenlt update 20101119
		if (documentReceiptId == -1) {
			return -1;
		}		
		
		// find a WF_DocumentReceipt entry with given fileId
		List<PmlDocumentReceiptWF> wfs = null;
		
		try {
			wfs = PmlDocumentReceiptWFUtil.findByDocumentReceiptId(documentReceiptId);
		} catch (SystemException e) {
			e.printStackTrace();
		}

//		minh update 20091123
//		boolean xulythayLd_vpb = ParamUtil.getBoolean(req, "xulythayLd_vpb", false);		
//		if (xulythayLd_vpb) {
//			return wfs.get(0).getProcessId();
//		}
		
		// if not exist WF_DocumentReceipt entry return -1
		if (Validator.isNull(wfs)) {
			return -1;
		}
		
		
		if (wfs.size() == 1) {
			return wfs.get(0).getProcessId();
		}
		
//		end		
		// get User Id login portal
		long userId = PortalUtil.getUserId(PortalUtil.getHttpServletRequest(req));
		if (userId == 0) {
			return -1;
		}
		
		for (Iterator<PmlDocumentReceiptWF> it = wfs.iterator(); it.hasNext();) {
			PmlDocumentReceiptWF wf = (PmlDocumentReceiptWF) it.next();
			// yenlt update 20101119
			boolean hasRight = false;
			if (rutLai) {
				hasRight = documentReceiptLWS.checkUserInDocumentReceiptWorkflow(
						receiverIdBack, wf.getProcessId());
			} else { // end yenlt update 20101119
				hasRight = documentReceiptLWS.checkUserInDocumentReceiptWorkflow(
						userId, wf.getProcessId());
			}
			if (hasRight) {
				return wf.getProcessId();
			}
		}
		
		if (userIdXLT != -1) {
			for (Iterator<PmlDocumentReceiptWF> it = wfs.iterator(); it.hasNext();) {
				PmlDocumentReceiptWF wf = (PmlDocumentReceiptWF) it.next();
				// yenlt update 20101119
				boolean hasRight = false;
				if (rutLai) {
					hasRight = documentReceiptLWS.checkUserInDocumentReceiptWorkflow(
							receiverIdBack, wf.getProcessId());
				} else { // end yenlt update 20101119
					hasRight = documentReceiptLWS.checkUserInDocumentReceiptWorkflow(
							userIdXLT, wf.getProcessId());
				}
				if (hasRight) {
					return wf.getProcessId();
				}
			}
		}
		
		return -1;
	}

	@Override
	protected long getTaskInstanceId(PortletRequest req) {
		// get "taskId" parameter from request.
		return ParamUtil.getLong(req, "taskId", -1);
	}


	@Override
	protected TaskNameDispatcher getTaskNameDispatcher() {
		return documentReceiptTND;
	}

	/**
	 * @param document
	 * @return
	 */
	protected PmlEdmDocumentReceiptDTO populateDocumentReceiptToDTO(PortletRequest req,
			PmlEdmDocumentReceipt document) {
		
		PmlEdmDocumentReceiptDTO docDTO = null;
		try {
			docDTO = new PmlEdmDocumentReceiptDTO();
			
			String issuingPlaceName = "";
			
			String issuingPlaceId = document.getIssuingPlaceId();
			
			try {
				PmlEdmIssuingPlace issuingPlace = PmlEdmIssuingPlaceLocalServiceUtil
						.getPmlEdmIssuingPlace(issuingPlaceId);
				issuingPlaceName = issuingPlace.getIssuingPlaceName();
			} catch (Exception e) {
				issuingPlaceName = document.getIssuingPlaceOtherName();
			}
			
			docDTO.setDocumentReceiptId(document.getDocumentReceiptId());
			
			int levelSendId = document.getLevelSendId();
			String levelSendName = "";
			try {
				levelSendName = PmlEdmLevelSendUtil.findByPrimaryKey(levelSendId).getLevelSendName();
			} catch (Exception e) {
			}
			docDTO.setLevelSendName(levelSendName);
			
			docDTO.setDocumentTypeName(PmlEdmDocumentTypeLocalServiceUtil
					.getPmlEdmDocumentType(document.getDocumentTypeId()).getDocumentTypeName());
			docDTO.setDocumentReference(document.getDocumentReference());
			docDTO.setIssuingPlaceName(issuingPlaceName);
			
			docDTO.setIsuuingDate(document.getIssuingDate());
			docDTO.setSigner(document.getSigner());
			docDTO.setPrivilegeLevel(PmlEdmPrivilegeLevelLocalServiceUtil.
					getPmlEdmPrivilegeLevel(document.getPrivilegeLevelId()).getPrivilegeLevelName());
			
			docDTO.setThoigiannhancvden(document.getThoigiannhancvden());
			
			docDTO.setConfidentialLevelName(PmlEdmConfidentialLevelLocalServiceUtil
					.getPmlEdmConfidentialLevel(document.getConfidentialLevelId()).getConfidentialLevelName());
			docDTO.setBriefContent(document.getBriefContent());
			docDTO.setIsPublic(document.getIsPublic());
			
			docDTO.setDateArrive(document.getDateArrive());
			docDTO.setProcessTime(document.getProcessTime());
			docDTO.setNumberLocalDocumentReceipt(document.getNumberLocalDocumentReceipt());
			docDTO.setNumberDocumentReceipt(document.getNumberDocumentReceipt());
			docDTO.setSocongvandiphucdap(document.getSocongvandiphucdap());
			/**
			 * phmphuc 09/03/2010
			 * sua phan hien thi trang thai cong van
			 * trang thai hien thi bang ten (luc dau la id)
			 */
			/* yenlt close start 02062010
			long stateId = document.getStatusId();
			String state = "";
			try {
				PmlStateProcess stateProcess = PmlStateProcessUtil.findByPrimaryKey(stateId);
				state = stateProcess.getStateProcessName();
			} catch (Exception e) {
				state = "khong xac dinh";
			}
			yenlt close end 02062010 */
			
			// yenlt update 02062010
			
			String state = "";
			String stateCode = ((DocumentReceiptLiferayWorkflowService)getLiferayWorkflowService()).getState(document.getDocumentReceiptId());
			List<PmlStateProcess> list = new ArrayList<PmlStateProcess>();
			PmlFileStatusStateProcess fileStatusStateProcess = null;
			PmlStateProcess stateProcess = null;
			try {
				list = PmlStateProcessUtil.findByStateProcessCode(stateCode, DocumentReceiptLiferayWorkflowService.TYPE_CV);
				stateProcess = list.get(0);
				fileStatusStateProcess = PmlFileStatusStateProcessUtil.findByStateProcessId(stateProcess.getStateProcessId()).get(0);
				state = fileStatusStateProcess.getDescription();
			} catch (Exception e) {
			}
			
			//end yenlt update 02062010
			docDTO.setState(state);
			
			docDTO.setDonViSaoY(document.getDonViSaoY());
		} 
		catch (Exception e) {
		}
		return docDTO;
		
	}
	
	/**
	 * Chuyen gia tri tu van ban den vao doi tuong DTO
	 * @param document
	 * @return
	 */
	protected PmlEdmDocumentReceiptDTO populateDocumentReceiptToDTO2(PortletRequest req,
			PmlEdmDocumentReceipt document) {
		
		PmlEdmDocumentReceiptDTO docDTO = null;
		try {
			docDTO = new PmlEdmDocumentReceiptDTO();
			
			String issuingPlaceName = "";
			
			String issuingPlaceId = document.getIssuingPlaceId();
			
			try {
				PmlEdmIssuingPlace issuingPlace = PmlEdmIssuingPlaceLocalServiceUtil
						.getPmlEdmIssuingPlace(issuingPlaceId);
				issuingPlaceName = issuingPlace.getIssuingPlaceName();
			} catch (Exception e) {
				issuingPlaceName = document.getIssuingPlaceOtherName();
			}
			
			docDTO.setDocumentReceiptId(document.getDocumentReceiptId());
			
			int levelSendId = document.getLevelSendId();
			String levelSendName = "";
			try {
				levelSendName = PmlEdmLevelSendUtil.findByPrimaryKey(levelSendId).getLevelSendName();
			} catch (Exception e) {
				
			}
			docDTO.setLevelSendName(levelSendName);
			
			docDTO.setDocumentTypeName(PmlEdmDocumentTypeLocalServiceUtil
					.getPmlEdmDocumentType(document.getDocumentTypeId()).getDocumentTypeName());
			docDTO.setDocumentReference(document.getDocumentReference());
			docDTO.setIssuingPlaceName(issuingPlaceName);
			
			docDTO.setIsuuingDate(document.getIssuingDate());
			docDTO.setSigner(document.getSigner());
			docDTO.setPrivilegeLevel(PmlEdmPrivilegeLevelLocalServiceUtil.
					getPmlEdmPrivilegeLevel(document.getPrivilegeLevelId()).getPrivilegeLevelName());
			
			docDTO.setThoigiannhancvden(document.getThoigiannhancvden());
			
			docDTO.setConfidentialLevelName(PmlEdmConfidentialLevelLocalServiceUtil
					.getPmlEdmConfidentialLevel(document.getConfidentialLevelId()).getConfidentialLevelName());
			docDTO.setBriefContent(document.getBriefContent());
			docDTO.setIsPublic(document.getIsPublic());
			
			docDTO.setDateArrive(document.getDateArrive());
			docDTO.setProcessTime(document.getProcessTime());
			docDTO.setNumberLocalDocumentReceipt(document.getNumberLocalDocumentReceipt());
			docDTO.setNumberDocumentReceipt(document.getNumberDocumentReceipt());
			docDTO.setSocongvandiphucdap(document.getSocongvandiphucdap());
			//xuancong close long userId = PortalUtil.getUserId(PortalUtil.getHttpServletRequest(req));
			// Phan nay de lay trang thai xu ly dua vao ma so nguoi dung
			// Tam thoi chua dung, dat trang thai xu ly la rong
			String stateProcess = "";
			
			try{
				//stateProcess = PmlStateProcessUtil.findByStateProcessCode(stateProcess).get(0).getStateProcessName();
			} 
			catch (Exception e) {
				
			}
			
			docDTO.setState(stateProcess);
			
		} 
		catch (Exception e) {
		}
		return docDTO;
		
	}
}