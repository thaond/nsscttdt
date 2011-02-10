package com.sgs.portlet.document.receipt.service.impl;

import java.util.List;

import com.sgs.portlet.document.receipt.model.PmlEdmBookDocumentRecordTo;
import com.sgs.portlet.document.receipt.service.base.PmlEdmBookDocumentRecordToLocalServiceBaseImpl;
import com.sgs.portlet.document.receipt.service.persistence.PmlEdmBookDocumentRecordToUtil;


public class PmlEdmBookDocumentRecordToLocalServiceImpl
    extends PmlEdmBookDocumentRecordToLocalServiceBaseImpl {
	
	public int deletePmdEdmBookDocumentRecordToByRecId(long documentReceiptId) {
		int retVal = 0;
		
		try {
			List<PmlEdmBookDocumentRecordTo> bookDocRecTos = PmlEdmBookDocumentRecordToUtil
					.findByDocumentReceiptId(documentReceiptId);
			for (PmlEdmBookDocumentRecordTo bookDocRecItem : bookDocRecTos) {
				// Xoa muc
				PmlEdmBookDocumentRecordToUtil.remove(bookDocRecItem);
				// Tang so luong muc bi xoa
				retVal ++;
}
		} // end try
		catch (Exception ex) {
			System.out.println("Co loi khi xoa book document record to.");
			ex.printStackTrace();
		} // end catch
		return retVal;
	}
}
