package com.sgs.portlet.documentrecordtype.util;

import java.util.List;

import com.ext.portlet.util.StringUtil;
import com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo;
import com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordType;
import com.sgs.portlet.document.receipt.model.PmlEdmDocumentType;
import com.sgs.portlet.document.receipt.service.PmlEdmDocumentRecordTypeLocalServiceUtil;
import com.sgs.portlet.document.receipt.service.persistence.PmlEdmDocumentRecordToUtil;
import com.sgs.portlet.document.receipt.service.persistence.PmlEdmDocumentRecordTypeUtil;
import com.sgs.portlet.document.receipt.service.persistence.PmlEdmDocumentTypeUtil;

public class DocumentRecordTypeUtil {
	public static boolean updateDocumentRecordType (int id, String documentRecordTypeName) {
		try {
			PmlEdmDocumentRecordType pmlEdmDocumentRecordType = PmlEdmDocumentRecordTypeUtil.findByPrimaryKey(id);
			//quan add 20091020 start
			//noi code va name bang "_" de update ca 2 bien
			String[] value = documentRecordTypeName.split("_");
			String documentRecordTypeCode = "";
			int check = documentRecordTypeName.indexOf("_");
			
			if(check != -1){
				documentRecordTypeCode = value[0];
				documentRecordTypeName = value[1];
				documentRecordTypeCode = StringUtil.encodeHtml(documentRecordTypeCode);
				pmlEdmDocumentRecordType.setDocumentRecordTypeCode(documentRecordTypeCode);
			}
			//quan add 20091020 end
			
			documentRecordTypeName = StringUtil.encodeHtml(documentRecordTypeName);
			pmlEdmDocumentRecordType.setDocumentRecordTypeName(documentRecordTypeName);
			PmlEdmDocumentRecordTypeLocalServiceUtil.updatePmlEdmDocumentRecordType(pmlEdmDocumentRecordType);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	// minh update
	public static boolean deleteDocumentRecordType(int documentRecordTypeId) {
		List<PmlEdmDocumentType> pmlEdmDocumentTypeList = null;
		List<PmlEdmDocumentRecordTo> pmlEdmDocumentRecordToList = null;
		
		try {
			pmlEdmDocumentTypeList = PmlEdmDocumentTypeUtil.findByDocumentRecordTypeId(documentRecordTypeId);
		} catch (Exception e) {}
		
		try {
			pmlEdmDocumentRecordToList = PmlEdmDocumentRecordToUtil.findByDocumentRecordTypeId(documentRecordTypeId);
		} catch (Exception e) {}
		
		if ((pmlEdmDocumentTypeList != null && !pmlEdmDocumentTypeList.isEmpty()) || (pmlEdmDocumentRecordToList != null && !pmlEdmDocumentRecordToList.isEmpty()) ) {
			return false;
		}
		else {
			try {
				PmlEdmDocumentRecordTypeUtil.remove(documentRecordTypeId);
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
	
	// vu update 25122010
	public static boolean checkCodeDocumentRecordType(String documentRecordTypeCode) {
		List<PmlEdmDocumentRecordType> pmlEdmDocumentTypeList = null;
		
		try {
			pmlEdmDocumentTypeList = PmlEdmDocumentRecordTypeLocalServiceUtil.findByDocumentRecordTypeCode(documentRecordTypeCode.trim());
			
			if (pmlEdmDocumentTypeList.size() > 0) {
				return true;
			}
		} catch (Exception e) {}
			return false;
	}
	//end
}
