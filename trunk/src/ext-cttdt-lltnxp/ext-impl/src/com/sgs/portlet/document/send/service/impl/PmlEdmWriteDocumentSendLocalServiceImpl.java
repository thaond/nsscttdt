package com.sgs.portlet.document.send.service.impl;

import java.util.List;

import com.sgs.portlet.document.receipt.model.PmlEdmDocumentType;
import com.sgs.portlet.document.receipt.service.persistence.PmlEdmDocumentTypeUtil;
import com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend;
import com.sgs.portlet.document.send.model.PmlEdmDocumentSend;
import com.sgs.portlet.document.send.model.PmlEdmWriteDocumentSend;
import com.sgs.portlet.document.send.service.base.PmlEdmWriteDocumentSendLocalServiceBaseImpl;
import com.sgs.portlet.document.send.service.persistence.PmlEdmBookDocumentSendUtil;
import com.sgs.portlet.document.send.service.persistence.PmlEdmDocumentSendUtil;
import com.sgs.portlet.document.send.service.persistence.PmlEdmWriteDocumentSendUtil;


/**
 * @author lethanhtung
 * @author XuanCong
 */
public class PmlEdmWriteDocumentSendLocalServiceImpl  extends PmlEdmWriteDocumentSendLocalServiceBaseImpl {
	
	/**
	 * this method get PmlEdmBookDocumentSend object by documentSendId
	 * @param documentSendId : ID của công văn đi
	 * @return PmlEdmBookDocumentSend object
	 * 
	 */
	public PmlEdmBookDocumentSend getBookDocumentSendByDocumentSend (long documentSendId) {
		
		PmlEdmBookDocumentSend retValue = null;
		
		try {
			PmlEdmDocumentSend documentSend = PmlEdmDocumentSendUtil.findByPrimaryKey(documentSendId);
			if (documentSend == null) {
				return retValue;
			}
				
			long documentTypeId = documentSend.getDocumentTypeId();
			
			PmlEdmDocumentType documentType = PmlEdmDocumentTypeUtil.findByPrimaryKey(documentTypeId);
			
			if (documentType != null) {
				int documentRecordTypeId = documentType.getDocumentRecordTypeId();
				
				retValue = PmlEdmBookDocumentSendUtil.findByDocumentRecordTypeId(documentRecordTypeId).get(0);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return retValue;
	}
	
	/**
	 * Xoa PmlEdmWriteDocumentSend dua vao ma so van ban di
	 * 
	 * @param documentSendId
	 * @return
	 */
	public int deletePmlEdmWriteDocumentSendBySendId(long documentSendId) {
		int retVal = 0;
		
		try {
			List<PmlEdmWriteDocumentSend> wrtDocSends = PmlEdmWriteDocumentSendUtil
					.findByDocumentSendId(documentSendId);
			for (PmlEdmWriteDocumentSend wrtDocSendItem : wrtDocSends) {
				// Xoa muc
				PmlEdmWriteDocumentSendUtil.remove(wrtDocSendItem);
				// Tang so luong muc bi xoa
				retVal ++;
			} // end for
		} // end try
		catch (Exception ex) {
			System.out.println("Co loi khi xoa PmlEdmWriteDocumentSend dua vao ma so van ban di.");
			ex.printStackTrace();
		} // end catch
		return retVal;
	}
}
