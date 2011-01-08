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

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.struts.PortletAction;
import com.sgs.portlet.document.receipt.dto.PmlEdmDocumentReceiptDTO;
import com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile;
import com.sgs.portlet.document.receipt.model.PmlEdmConfidentialLevel;
import com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt;
import com.sgs.portlet.document.receipt.model.PmlEdmDocumentType;
import com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace;
import com.sgs.portlet.pmllevelsend.model.PmlEdmLevelSend;
import com.sgs.portlet.document.receipt.model.PmlEdmPrivilegeLevel;
import com.sgs.portlet.document.receipt.model.impl.PmlEdmDocumentReceiptImpl;
import com.sgs.portlet.document.receipt.service.PmlEdmConfidentialLevelLocalServiceUtil;
import com.sgs.portlet.document.receipt.service.PmlEdmDocumentReceiptLocalServiceUtil;
import com.sgs.portlet.document.receipt.service.PmlEdmDocumentTypeLocalServiceUtil;
import com.sgs.portlet.pmlissuingplace.service.PmlEdmIssuingPlaceLocalServiceUtil;
import com.sgs.portlet.pmllevelsend.service.PmlEdmLevelSendLocalServiceUtil;
import com.sgs.portlet.document.receipt.service.PmlEdmPrivilegeLevelLocalServiceUtil;
import com.sgs.portlet.document.receipt.service.persistence.PmlEdmAttachedFileUtil;
import com.sgs.portlet.document.receipt.service.persistence.PmlEdmConfidentialLevelUtil;
import com.sgs.portlet.document.receipt.service.persistence.PmlEdmDocumentTypeUtil;
import com.sgs.portlet.pmlissuingplace.service.persistence.PmlEdmIssuingPlaceUtil;
import com.sgs.portlet.pmllevelsend.service.persistence.PmlEdmLevelSendUtil;
import com.sgs.portlet.document.receipt.service.persistence.PmlEdmPrivilegeLevelUtil;

/**
 * Prepare data for update form
 * @author doanhdv
 * @author kienbqc
 */
public class EditAction extends PortletAction {
	public void processAction(ActionMapping mapping, ActionForm form,
			PortletConfig config, ActionRequest req, ActionResponse res)
			throws Exception {
	}

	public ActionForward render(ActionMapping mapping, ActionForm form,
			PortletConfig config, RenderRequest req, RenderResponse res)
			throws Exception {
			
		/* Get documentReceiptId from parameter */
		long documentReceiptId = Long.parseLong(
			ParamUtil.getString(req, "documentReceiptId"));
		
		/* Get PmlEdmDocumentReceipt object from system by documentReceiptId */
		PmlEdmDocumentReceipt documentReceipt = 
			PmlEdmDocumentReceiptLocalServiceUtil
			.getPmlEdmDocumentReceipt(documentReceiptId);
		
		/* Declare a pmlEdmDocumentReceiptDTO object */
		PmlEdmDocumentReceiptDTO documentDTO = new PmlEdmDocumentReceiptDTO();
		
		/* Set data into documentDTO by documentReceipt */
		documentDTO = setDataIntoPmlEdmDocumentReceiptDTOByPmlEdmDocumentReceipt(
			documentDTO, documentReceipt);
		
		/* Get list level send */
		List<PmlEdmLevelSend> levelSends = PmlEdmLevelSendUtil.findAll();
		
		/* Get list document type */
		List<PmlEdmDocumentType> documentTypes = PmlEdmDocumentTypeUtil.findAll();
		
		/* Get list document privilege level*/
		List<PmlEdmPrivilegeLevel> documentPrivilegeLevels = 
			PmlEdmPrivilegeLevelUtil.findAll();
		
		/* Get list document confidential level */
		List<PmlEdmConfidentialLevel> documentConfidentialLevels = 
			PmlEdmConfidentialLevelUtil.findAll();
		
		/* Get list issuing place */
		List<PmlEdmIssuingPlace> issuingPlaces = PmlEdmIssuingPlaceUtil.findAll();
		
		/*
		 * Set
		 * - documentDTO
		 * - levelSends
		 * - documentTypes
		 * - privilegeLevels
		 * - confidentialLevels
		 * - issuingPlaces
		 * into attribute of request
		 */
		req.setAttribute("documentDTO", documentDTO);
		req.setAttribute("levelSends", levelSends);
		req.setAttribute("documentTypes", documentTypes);
		req.setAttribute("privilegeLevels", documentPrivilegeLevels);
		req.setAttribute("confidentialLevels", documentConfidentialLevels);
		req.setAttribute("issuingPlaces", issuingPlaces);
		
		/* get files attach */
		PmlEdmDocumentReceipt documentReceiptImp = new PmlEdmDocumentReceiptImpl();
		List<PmlEdmAttachedFile> listPmlEdmAttachedFile = PmlEdmAttachedFileUtil
			.findByObjectContentId_ObjectType(
				documentReceiptId, documentReceiptImp.getClass().getName());
		
		/* set list of attached file into attribute of request */
		req.setAttribute("listPmlEdmAttachedFile", listPmlEdmAttachedFile);	
		
		if (getForward(req) != null && !getForward(req).equals("")) {
			return mapping.findForward(getForward(req)); // Use forward set in processAction if available
		} else {
			return mapping.findForward("portlet.sgs.document.receiptprocess.edit");
		}
	}

	/**
	 * set data into PmlEdmDocumentReceiptDTO by PmlEdmDocumentReceipt
	 * @param documentDTO
	 * @param documentReceipt
	 * @return PmlEdmDocumentReceiptDTO
	 * @throws PortalException
	 * @throws SystemException
	 */
	private PmlEdmDocumentReceiptDTO setDataIntoPmlEdmDocumentReceiptDTOByPmlEdmDocumentReceipt(
		PmlEdmDocumentReceiptDTO documentDTO,
		PmlEdmDocumentReceipt documentReceipt) throws PortalException, SystemException {

		documentDTO.setLevelSendName(
			PmlEdmLevelSendLocalServiceUtil.getPmlEdmLevelSend(
				documentReceipt.getLevelSendId()).getLevelSendName());
		
		documentDTO.setDocumentTypeName(
			PmlEdmDocumentTypeLocalServiceUtil.getPmlEdmDocumentType(
				documentReceipt.getDocumentTypeId()).getDocumentTypeName());
		
		documentDTO.setDocumentReference(documentReceipt.getDocumentReference());
		
		documentDTO.setIssuingPlaceName(
			PmlEdmIssuingPlaceLocalServiceUtil.getPmlEdmIssuingPlace(
				documentReceipt.getIssuingPlaceId()).getIssuingPlaceName());
		
		documentDTO.setIsuuingDate(documentReceipt.getIssuingDate());
		
		documentDTO.setSigner(documentReceipt.getSigner());
		
		documentDTO.setPrivilegeLevel(
			PmlEdmPrivilegeLevelLocalServiceUtil.getPmlEdmPrivilegeLevel(
				documentReceipt.getPrivilegeLevelId()).getPrivilegeLevelName());
		
		documentDTO.setConfidentialLevelName(
			PmlEdmConfidentialLevelLocalServiceUtil.getPmlEdmConfidentialLevel(
				documentReceipt.getConfidentialLevelId()).getConfidentialLevelName());
		
		documentDTO.setBriefContent(documentReceipt.getBriefContent());
		
		documentDTO.setIsPublic(documentReceipt.getIsPublic());
		
		documentDTO.setDateArrive(documentReceipt.getDateArrive());
		
		documentDTO.setProcessTime(documentReceipt.getProcessTime());
		
		documentDTO.setNumberLocalDocumentReceipt(
			documentReceipt.getNumberLocalDocumentReceipt());
		return documentDTO;
	}
}
