package com.sgs.portlet.documenttype.util;

import java.util.List;

import com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt;
import com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordType;
import com.sgs.portlet.document.receipt.model.PmlEdmDocumentType;
//xuancong close import com.sgs.portlet.document.receipt.model.impl.PmlEdmDocumentRecordTypeImpl;
import com.sgs.portlet.document.receipt.service.PmlEdmDocumentTypeLocalServiceUtil;
import com.sgs.portlet.document.receipt.service.persistence.PmlEdmDocumentReceiptUtil;
import com.sgs.portlet.document.receipt.service.persistence.PmlEdmDocumentRecordTypeUtil;
import com.sgs.portlet.document.receipt.service.persistence.PmlEdmDocumentTypeUtil;

public class DocumentTypeUtil {
	
	public static boolean updateDocumentType (
			int id, String documentSymbol, String documentTypeName, int documentRecordTypeId){
		try {
			PmlEdmDocumentType pmlEdmDocumentType = PmlEdmDocumentTypeUtil.findByPrimaryKey(id);
			
			pmlEdmDocumentType.setDocumentSymbol(documentSymbol);
			pmlEdmDocumentType.setDocumentTypeName(documentTypeName);
			pmlEdmDocumentType.setDocumentRecordTypeId(documentRecordTypeId);
			PmlEdmDocumentTypeLocalServiceUtil.updatePmlEdmDocumentType(pmlEdmDocumentType);
			return true;
		} // end try 
		catch (Exception e) {
			return false;
		} // end catch
	}
	
	//minh update
	public static boolean deleteDocumentType(long documentTypeId)  {
		
		List<PmlEdmDocumentReceipt> pmlEdmDocumentReceiptList = null;
		try {
			pmlEdmDocumentReceiptList = PmlEdmDocumentReceiptUtil.findByDocumentTypeId(documentTypeId);
		} catch (Exception e) {			
		}
		
		if (pmlEdmDocumentReceiptList != null && !pmlEdmDocumentReceiptList.isEmpty()) {
			return false;
		}
		
		else {
			try {
				PmlEdmDocumentTypeUtil.remove(documentTypeId);
				return true;
			} catch (Exception e) {
				return false;
			}
			
		}
	}
	
	public static List<PmlEdmDocumentRecordType> getPmlEdmDocumentRecordTypeList () throws Exception {
		List<PmlEdmDocumentRecordType> pmlEdmDocumentRecordTypeList = null;
		pmlEdmDocumentRecordTypeList = PmlEdmDocumentRecordTypeUtil.findAll();
		//PmlEdmDocumentRecordType p = new PmlEdmDocumentRecordTypeImpl();
		//p.getDocumentRecordTypeId()
		return pmlEdmDocumentRecordTypeList;
	}
}
