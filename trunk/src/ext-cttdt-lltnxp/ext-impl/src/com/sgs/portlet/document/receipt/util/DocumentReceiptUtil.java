/**
 * 
 */
package com.sgs.portlet.document.receipt.util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.liferay.portal.SystemException;
import com.sgs.portlet.document.receipt.dto.LogProcessDTO;
import com.sgs.portlet.document.receipt.dto.PmlEdmDocumentReceiptDTO;
import com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt;
import com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace;
import com.sgs.portlet.document.receipt.service.PmlEdmConfidentialLevelLocalServiceUtil;
import com.sgs.portlet.document.receipt.service.PmlEdmDocumentTypeLocalServiceUtil;
import com.sgs.portlet.pmlissuingplace.service.PmlEdmIssuingPlaceLocalServiceUtil;
import com.sgs.portlet.pmllevelsend.service.PmlEdmLevelSendLocalServiceUtil;
import com.sgs.portlet.document.receipt.service.PmlEdmPrivilegeLevelLocalServiceUtil;
import com.sgs.portlet.document.receipt.service.persistence.PmlEdmDocumentReceiptUtil;

/**
 * @author kienbqc
 *
 */
public class DocumentReceiptUtil {
	public static List<PmlEdmDocumentReceipt> getDocumentReceiptsByUser(long userId, int start, int end) {
		
		
		List<PmlEdmDocumentReceipt> list = null;
		try {
			//lay du lieu de test
			list = PmlEdmDocumentReceiptUtil.findAll(start, end);
		} catch (SystemException e) {
			e.printStackTrace();
		}
		return list;
	}

	public static PmlEdmDocumentReceiptDTO getDocDTOFromDocRe(
			PmlEdmDocumentReceipt document) {
		PmlEdmDocumentReceiptDTO docDTO = null;
		try {
			docDTO = new PmlEdmDocumentReceiptDTO();
			
			String issuingPlaceId = document.getIssuingPlaceId();
			
			PmlEdmIssuingPlace issuingPlace = PmlEdmIssuingPlaceLocalServiceUtil.getPmlEdmIssuingPlace(issuingPlaceId);
			
			docDTO.setDocumentReceiptId(document.getDocumentReceiptId());
			docDTO.setLevelSendName(PmlEdmLevelSendLocalServiceUtil
					.getPmlEdmLevelSend(document.getLevelSendId()).getLevelSendName());
			docDTO.setDocumentTypeName(PmlEdmDocumentTypeLocalServiceUtil
					.getPmlEdmDocumentType(document.getDocumentTypeId()).getDocumentTypeName());
			docDTO.setDocumentReference(document.getDocumentReference());
			docDTO.setIssuingPlaceName(issuingPlace.getIssuingPlaceName());
			docDTO.setIsuuingDate(document.getIssuingDate());
			docDTO.setSigner(document.getSigner());
			docDTO.setPrivilegeLevel(PmlEdmPrivilegeLevelLocalServiceUtil.
					getPmlEdmPrivilegeLevel(document.getPrivilegeLevelId()).getPrivilegeLevelName());
			docDTO.setConfidentialLevelName(PmlEdmConfidentialLevelLocalServiceUtil
					.getPmlEdmConfidentialLevel(document.getConfidentialLevelId()).getConfidentialLevelName());
			docDTO.setBriefContent(document.getBriefContent());
			docDTO.setIsPublic(document.getIsPublic());
			docDTO.setDateArrive(document.getDateArrive());
			docDTO.setProcessTime(document.getProcessTime());
			docDTO.setNumberLocalDocumentReceipt(document.getNumberLocalDocumentReceipt());
			docDTO.setState(DocumentReceiptUtil.getStateOfDoc(document.getDocumentReceiptId())); //dung jbpm lay trang thai
		} catch (Exception e) {
		}
		return docDTO;
		
	}

	/**
	 * Dung jBPM lay trang thai hien tai cua ho so
	 * @param documentReceiptId
	 * @return
	 */
	private static String getStateOfDoc(long documentReceiptId) {
		return "dang xu ly";
	}

	public static List<LogProcessDTO> getLogProcessDTOs() {
		List<LogProcessDTO> list = new ArrayList<LogProcessDTO>();
		
		//tao du lieu gia de test
		LogProcessDTO processDTO = new LogProcessDTO();
		processDTO.setContent("content");
		processDTO.setDate(new Date());
		processDTO.setReceiver("receiver");
		processDTO.setSender("sender");
		
		list.add(processDTO);
		
		return list;
	}
	
	public static String formatDate(Date date, String formatStyte) {
		return new SimpleDateFormat(formatStyte).format(date);
	}
}
