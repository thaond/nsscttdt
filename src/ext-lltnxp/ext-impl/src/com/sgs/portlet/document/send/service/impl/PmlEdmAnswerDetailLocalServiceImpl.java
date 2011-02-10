package com.sgs.portlet.document.send.service.impl;

import java.util.List;

import com.sgs.portlet.document.send.model.PmlEdmAnswerDetail;
import com.sgs.portlet.document.send.service.base.PmlEdmAnswerDetailLocalServiceBaseImpl;
import com.sgs.portlet.document.send.service.persistence.PmlEdmAnswerDetailUtil;


public class PmlEdmAnswerDetailLocalServiceImpl
    extends PmlEdmAnswerDetailLocalServiceBaseImpl {
	
	/**
	 * Xoa lien quan van ban den va van ban di dua vao ma so van ban di
	 * 
	 * @param documentSendId
	 * @return
	 */
	public int deletePmlEdmAnswerDetailBySendId(long documentSendId) {
		int retVal = 0;
		
		try {
			List<PmlEdmAnswerDetail> ansDets = PmlEdmAnswerDetailUtil
					.findByDocumentSendId(documentSendId);
			for (PmlEdmAnswerDetail ansDetItem : ansDets) {
				// Xoa muc
				PmlEdmAnswerDetailUtil.remove(ansDetItem);
				// Tang so luong muc bi xoa
				retVal ++;
			} // end for
		} // end try
		catch (Exception ex) {
			System.out.println("Co loi khi xoa lien quan van ban di den dua vao ma so van ban di.");
			ex.printStackTrace();
		} // end catch
		return retVal;
}
}