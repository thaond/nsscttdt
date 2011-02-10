package com.sgs.portlet.pcccdocumentreceiptprocess.search;

import com.liferay.portal.kernel.util.OrderByComparator;
import com.sgs.portlet.document.send.model.PmlEdmDocumentSend;


public class PcccDocumentReceiptProcessSoCongVanDenComparator extends OrderByComparator {

	/* xuancong close start
	public static String ORDER_BY_ASC = "cv.numberdocumentreceipt ASC";

	public static String ORDER_BY_DESC = "cv.numberdocumentreceipt DESC";
	xuancong close end */
	public static String ORDER_BY_ASC = "cv.generalorderno ASC, cv.datearrive ASC";
	public static String ORDER_BY_DESC = "cv.generalorderno DESC, cv.datearrive DESC";
	
	private boolean _asc;
	
	public PcccDocumentReceiptProcessSoCongVanDenComparator() {
		this(false);
	}

	public PcccDocumentReceiptProcessSoCongVanDenComparator(boolean asc) {
		_asc = asc;
	}
	
	@Override
	public int compare(Object obj1, Object obj2) {
		PmlEdmDocumentSend pmlEdmDocumentSend1 = (PmlEdmDocumentSend)obj1;
		PmlEdmDocumentSend pmlEdmDocumentSend2 = (PmlEdmDocumentSend)obj2;

		int value = pmlEdmDocumentSend1.getIssuingDate().compareTo(pmlEdmDocumentSend2.getIssuingDate());

		if (_asc) {
			return value;
		}
		else {
			return -value;
		}
	}
	
	public String getOrderBy() {
		if (_asc) {
			return ORDER_BY_ASC;
		}
		else {
			return ORDER_BY_DESC;
		}
	}

	

}
