package com.sgs.portlet.document.service.impl;

import java.util.List;

import com.liferay.portal.SystemException;
import com.sgs.portlet.document.model.PmlDocumentReceiptWF;
import com.sgs.portlet.document.service.base.PmlDocumentReceiptWFLocalServiceBaseImpl;
import com.sgs.portlet.document.service.persistence.PmlDocumentReceiptWFUtil;


/**
 * @author lethanhtung
 * @author XuanCong
 */
public class PmlDocumentReceiptWFLocalServiceImpl extends PmlDocumentReceiptWFLocalServiceBaseImpl {
	
	/**
	 * this method get PmlDocumentReceiptWF object by documentReceiptId
	 * @param documentReceiptId : ID của công văn đến
	 * @return PmlDocumentReceiptWF object
	 * 
	 */
	public PmlDocumentReceiptWF getPmlDocumentReceiptWFByDocumentReceiptID (long documentReceiptId) {
		
		PmlDocumentReceiptWF retValue = null;
		
		try {
			List<PmlDocumentReceiptWF> list = PmlDocumentReceiptWFUtil.findByDocumentReceiptIdIsMain(documentReceiptId, "1");
			if (list != null ) {
				retValue = list.get(0);
			}
		}
		catch (SystemException e) {
			e.printStackTrace();
		}
		
		return retValue;
	}
	
	/**
	 * Xoa wf cua document receipt dua vao document receipt id
	 * 
	 * @param documentReceiptId
	 * @return
	 */
	public int deletePmlDocumentReceiptWFByRecId(long documentReceiptId) {
		int retVal = 0;
		
		try {
			List<PmlDocumentReceiptWF> docRecWFs = PmlDocumentReceiptWFUtil.findByDocumentReceiptId(documentReceiptId);
			for (PmlDocumentReceiptWF docRecWFItem : docRecWFs) {
				// Xoa wf receipt
				PmlDocumentReceiptWFUtil.remove(docRecWFItem);
				// Tang so luong bi xoa
				retVal ++;
			} // end for
		} // end try
		catch (Exception ex) {
			System.out.println("Co loi khi xoa tham chieu WF cua van ban den.");
			ex.printStackTrace();
		} // end catch
		return retVal;
	}
}
