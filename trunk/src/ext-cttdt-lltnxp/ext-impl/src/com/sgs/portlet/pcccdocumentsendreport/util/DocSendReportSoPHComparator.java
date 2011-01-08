package com.sgs.portlet.pcccdocumentsendreport.util;

import com.liferay.portal.kernel.util.OrderByComparator;
import com.sgs.portlet.document.send.model.PmlEdmDocumentSend;

@SuppressWarnings("serial")
public class DocSendReportSoPHComparator extends OrderByComparator {
	// Vi numofdocref anh xa tuong ung voi documentreference
	// nen khi so sanh so van ban phat hanh thi di so sanh numofdocref
	public static final String ORDER_BY_ASC = "numofdocref ASC";
	public static final String ORDER_BY_DESC = "numofdocref DESC";

	public DocSendReportSoPHComparator() {
		this(false);
	}
	
	public DocSendReportSoPHComparator(boolean asc) {
		this._asc = asc;
	}
	
	public int compare(Object arg0, Object arg1) {
		PmlEdmDocumentSend doc1 = (PmlEdmDocumentSend)arg0;
		PmlEdmDocumentSend doc2 = (PmlEdmDocumentSend)arg1;
		int value = 0;
		if (doc1.getNumOfDocRef() < doc2.getNumOfDocRef()) {
			value = -1;
		}
		else if (doc1.getNumOfDocRef() > doc2.getNumOfDocRef()) {
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
