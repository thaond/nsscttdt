package com.sgs.portlet.pcccdocumentrecordto.util;

import com.liferay.portal.kernel.util.OrderByComparator;
import com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt;

public class DocumentRecordToNgayDenComparator extends OrderByComparator {
	public static final String ORDER_BY_ASC = "datearrive ASC";
	public static final String ORDER_BY_DESC = "datearrive DESC";

	public DocumentRecordToNgayDenComparator() {
		this(false);
	}
	
	public DocumentRecordToNgayDenComparator(boolean asc) {
		this._asc = asc;
	}
	
	public int compare(Object arg0, Object arg1) {
		PmlEdmDocumentReceipt doc1 = (PmlEdmDocumentReceipt)arg0;
		PmlEdmDocumentReceipt doc2 = (PmlEdmDocumentReceipt)arg1;
		int value = doc1.getDateArrive().compareTo(doc2.getDateArrive());
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
	
	private boolean _asc;
}
