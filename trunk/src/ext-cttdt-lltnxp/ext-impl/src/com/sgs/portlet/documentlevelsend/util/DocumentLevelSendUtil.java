package com.sgs.portlet.documentlevelsend.util;

import java.util.List;

import com.ext.portlet.util.StringUtil;
import com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt;
import com.sgs.portlet.pmllevelsend.model.PmlEdmLevelSend;
import com.sgs.portlet.document.receipt.model.PmlEdmLevelSendDetail;
import com.sgs.portlet.pmllevelsend.service.PmlEdmLevelSendLocalServiceUtil;
import com.sgs.portlet.document.receipt.service.persistence.PmlEdmDocumentReceiptUtil;
import com.sgs.portlet.document.receipt.service.persistence.PmlEdmLevelSendDetailUtil;
import com.sgs.portlet.pmllevelsend.service.persistence.PmlEdmLevelSendUtil;

public class DocumentLevelSendUtil {
	public static boolean updateDocumentLevelSend (int id, String documentLevelSendName) {
		try {
		PmlEdmLevelSend pmlEdmDocumentLevelSend = PmlEdmLevelSendUtil.findByPrimaryKey(id);
		documentLevelSendName = StringUtil.encodeHtml(documentLevelSendName);
		pmlEdmDocumentLevelSend.setLevelSendName(documentLevelSendName);
		PmlEdmLevelSendLocalServiceUtil.updatePmlEdmLevelSend(pmlEdmDocumentLevelSend);
		return true;
		}catch (Exception e) {
			return false;
		}
	}
	
	public static boolean deleteDocumentLevelSendServer(int leveSendId){
		List<PmlEdmDocumentReceipt>  pmlEdmDocumentReceiptList = null;
		List<PmlEdmLevelSendDetail> pmlEdmLevelSendDetailList = null; 
		
		
		try {
			pmlEdmDocumentReceiptList = PmlEdmDocumentReceiptUtil.findByLevelSendId(leveSendId);
		} catch (Exception e) {}
		
		try{
			pmlEdmLevelSendDetailList = PmlEdmLevelSendDetailUtil.findByLevelSendId(leveSendId) ;
		} catch (Exception e) {}
		
		if ((pmlEdmDocumentReceiptList != null &&  !pmlEdmDocumentReceiptList.isEmpty()) || (pmlEdmLevelSendDetailList != null && !pmlEdmLevelSendDetailList.isEmpty())) {
			return false ;
		}
			
		else {	
			try {
				PmlEdmLevelSendUtil.remove(leveSendId);
				return true;
			} catch (Exception e) {
				return false;
			}
		}		
	}
	
}
