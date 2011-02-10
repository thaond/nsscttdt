package com.sgs.portlet.pcccdocumentreceiptprocess.searchtemp;

import com.liferay.portal.kernel.util.OrderByComparator;
import com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp;

public class PcccDocumentReceiptTempSoCongVanDenComparator extends OrderByComparator{
	public static String ORDER_BY_ASC = "cv.datearrive ASC, cv.generalorderno ASC";
	public static String ORDER_BY_DESC = "cv.datearrive DESC, cv.generalorderno DESC";
	
	private boolean _asc;
	
	public PcccDocumentReceiptTempSoCongVanDenComparator() {
		this(false);
	}

	public PcccDocumentReceiptTempSoCongVanDenComparator(boolean asc) {
		_asc = asc;
	}
	
	@Override
	public int compare(Object obj1, Object obj2) {
		PmlEdmDocumentReceiptTemp receiptTemp1 = (PmlEdmDocumentReceiptTemp)obj1;
		PmlEdmDocumentReceiptTemp receiptTemp2 = (PmlEdmDocumentReceiptTemp)obj2;

		int value = receiptTemp1.getDateArrive().compareTo(receiptTemp2.getDateArrive());

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
