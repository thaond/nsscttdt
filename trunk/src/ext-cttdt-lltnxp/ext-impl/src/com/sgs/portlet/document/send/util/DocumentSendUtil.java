/**
 * 
 */
package com.sgs.portlet.document.send.util;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.sgs.portlet.document.receipt.model.PmlEdmConfidentialLevel;
import com.sgs.portlet.document.receipt.model.PmlEdmDocumentType;
import com.sgs.portlet.document.receipt.model.PmlEdmPrivilegeLevel;
import com.sgs.portlet.document.receipt.service.PmlEdmConfidentialLevelLocalServiceUtil;
import com.sgs.portlet.document.receipt.service.PmlEdmDocumentTypeLocalServiceUtil;
import com.sgs.portlet.document.receipt.service.PmlEdmPrivilegeLevelLocalServiceUtil;
import com.sgs.portlet.document.send.dto.PmlEdmDocumentSendDTO;
import com.sgs.portlet.document.send.model.PmlEdmDocumentSend;
import com.sgs.portlet.document.send.service.persistence.PmlEdmDocumentSendUtil;

/**
 * @author kienbqc
 *
 */
public class DocumentSendUtil {

	/**
	 * lay danh sach cong van di theo user
	 * @param userId
	 * @return danh sach cong van di
	 */
	public static List<PmlEdmDocumentSendDTO> getDocumentSendsByUser(long userId) {
		List<PmlEdmDocumentSendDTO> list = null;
		try {
			list = new ArrayList<PmlEdmDocumentSendDTO>();
			//lay du lieu de test
			List<PmlEdmDocumentSend> documentSends = PmlEdmDocumentSendUtil.findAll();
			if(documentSends != null) {
				for (int i = 0; i < documentSends.size(); i++) {
					PmlEdmDocumentSendDTO sendDTO = new PmlEdmDocumentSendDTO();
					PmlEdmDocumentSend documentSend = documentSends.get(i);
					sendDTO.setDocumentSendId(documentSend.getDocumentSendId());
					sendDTO.setBriefContent(documentSend.getBriefContent());
					sendDTO.setDocumentReference(documentSend.getDocumentReference());
					sendDTO.setReceivingPlace(documentSend.getReceivingPlace());
					sendDTO.setIssuingDate(new Date());
					sendDTO.setState("dang xu ly");
					sendDTO.setIscongvanphucdap(documentSend.getIscongvanphucdap());
					list.add(sendDTO);
				}
			}
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public static PmlEdmDocumentSendDTO getDocDTOFormDocSend(
			PmlEdmDocumentSend documentSend) {
		
		PmlEdmDocumentSendDTO sendDTO = null;
		try {
		
		sendDTO = new PmlEdmDocumentSendDTO();
		long documentTypeId = documentSend.getDocumentTypeId();
		PmlEdmDocumentType documentType = 
			PmlEdmDocumentTypeLocalServiceUtil.getPmlEdmDocumentType(documentTypeId);
		
		String confidentialLevelId = documentSend.getConfidentialLevelId();
		PmlEdmConfidentialLevel confidentialLevel = 
			PmlEdmConfidentialLevelLocalServiceUtil.getPmlEdmConfidentialLevel(confidentialLevelId);
		
		String privilegeLevelId = documentSend.getPrivilegeLevelId();
		PmlEdmPrivilegeLevel privilegeLevel = 
			PmlEdmPrivilegeLevelLocalServiceUtil.getPmlEdmPrivilegeLevel(privilegeLevelId);
		
		sendDTO.setDocumentSendId(documentSend.getDocumentSendId());
		sendDTO.setBriefContent(documentSend.getBriefContent());
		sendDTO.setDocumentReference(documentSend.getDocumentReference());
		sendDTO.setReceivingPlace(documentSend.getReceivingPlace());
		sendDTO.setIssuingDate(documentSend.getIssuingDate());
		sendDTO.setDocumentType(documentType.getDocumentTypeName());
		sendDTO.setDateCreate(documentSend.getDateCreated());
		sendDTO.setConfidentialLevel(confidentialLevel.getConfidentialLevelName());
		sendDTO.setPrivilegel(privilegeLevel.getPrivilegeLevelName());
		sendDTO.setState("dang xu ly");
		sendDTO.setIscongvanphucdap(documentSend.getIscongvanphucdap());
		
		
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return sendDTO;
	}
	
	public static String formatDate(Date date, String format) {
		return new SimpleDateFormat(format).format(date);
	}
}
