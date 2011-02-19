package com.sgs.portlet.pcccdocumentrecordto.util;

import com.liferay.portal.kernel.util.OrderByComparator;
import com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt;

public class DocumentRecordToSoNoiBoComparator extends OrderByComparator {
	// Vi generalorderno anh xa tuong ung voi numberdocumentreceipt
	// nen khi so sanh so van ban noi bo thi di so sanh generalorderno
	public static final String ORDER_BY_ASC = "numberdocumentreceipt ASC";
	public static final String ORDER_BY_DESC = "numberdocumentreceipt DESC";

	public DocumentRecordToSoNoiBoComparator() {
		this(false);
	}
	
	public DocumentRecordToSoNoiBoComparator(boolean asc) {
		this._asc = asc;
	}
	
	public int compare(Object arg0, Object arg1) {
		PmlEdmDocumentReceipt doc1 = (PmlEdmDocumentReceipt)arg0;
		PmlEdmDocumentReceipt doc2 = (PmlEdmDocumentReceipt)arg1;
		int value = 0;
		if (doc1.getGeneralOrderNo() < doc2.getGeneralOrderNo()) {
			value = -1;
		}
		else if (doc1.getGeneralOrderNo() > doc2.getGeneralOrderNo()) {
			value = 1;
		}
		
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
