package com.sgs.portlet.pcccdocumentsendreport.util;

import com.liferay.portal.kernel.util.OrderByComparator;
import com.sgs.portlet.document.send.model.PmlEdmDocumentSend;

@SuppressWarnings("serial")
public class DocSendReportNgayPHComparator extends OrderByComparator {
	public static final String ORDER_BY_ASC = "issuingdate ASC";
	public static final String ORDER_BY_DESC = "issuingdate DESC";

	public DocSendReportNgayPHComparator() {
		this(false);
	}
	
	public DocSendReportNgayPHComparator(boolean asc) {
		this._asc = asc;
	}
	
	public int compare(Object arg0, Object arg1) {
		PmlEdmDocumentSend doc1 = (PmlEdmDocumentSend)arg0;
		PmlEdmDocumentSend doc2 = (PmlEdmDocumentSend)arg1;
		int value = doc1.getIssuingDate().compareTo(doc2.getIssuingDate());
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
