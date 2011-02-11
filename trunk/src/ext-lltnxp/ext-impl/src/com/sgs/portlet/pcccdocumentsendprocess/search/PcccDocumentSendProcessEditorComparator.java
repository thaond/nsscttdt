package com.sgs.portlet.pcccdocumentsendprocess.search;

import com.liferay.portal.kernel.util.OrderByComparator;
import com.sgs.portlet.document.send.model.PmlEdmDocumentSend;


public class PcccDocumentSendProcessEditorComparator extends
		OrderByComparator {

	public static String ORDER_BY_ASC = "cvsend.editorid ASC";

	public static String ORDER_BY_DESC = "cvsend.editorid DESC";
	
	private boolean _asc;
	
	public PcccDocumentSendProcessEditorComparator() {
		this(false);
	}

	public PcccDocumentSendProcessEditorComparator(boolean asc) {
		_asc = asc;
	}
	
	@Override
	public int compare(Object obj1, Object obj2) {
		PmlEdmDocumentSend pmlEdmDocumentSend1 = (PmlEdmDocumentSend)obj1;
		PmlEdmDocumentSend pmlEdmDocumentSend2 = (PmlEdmDocumentSend)obj2;

		int value = pmlEdmDocumentSend1.getEditorId() == pmlEdmDocumentSend2.getEditorId() ? 1 : 0;

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
