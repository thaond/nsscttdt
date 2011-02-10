package com.sgs.portlet.document.service.impl;

import java.util.List;

import com.sgs.portlet.document.model.PmlDocumentSendLog;
import com.sgs.portlet.document.service.base.PmlDocumentSendLogLocalServiceBaseImpl;
import com.sgs.portlet.document.service.persistence.PmlDocumentSendLogUtil;


public class PmlDocumentSendLogLocalServiceImpl
    extends PmlDocumentSendLogLocalServiceBaseImpl {
	
	/**
	 * Xoa log luan chuyen van ban di dua vao ma so van ban di
	 * 
	 * @param documentSendId
	 * @return
	 */
	public int deletePmlDocumentSendLogBySendId(long documentSendId) {
		int retVal = 0;
		
		try {
			List<PmlDocumentSendLog> docSendLogs = PmlDocumentSendLogUtil
					.findByDocumentSendId(documentSendId);
			for (PmlDocumentSendLog docSendLogItem : docSendLogs) {
				// Xoa muc
				PmlDocumentSendLogUtil.remove(docSendLogItem);
				// Tang so luong bi xoa
				retVal ++;
			} // end for
		} // end try
		catch (Exception ex) {
			System.out.println("Co loi khi xoa log luan chuyen van ban di.");
			ex.printStackTrace();
		} // end catch
		return retVal;
}
}