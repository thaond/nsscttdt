package com.sgs.portlet.document.receipt.searchdocumentsend;

import com.liferay.portal.kernel.util.OrderByComparator;
import com.sgs.portlet.document.send.model.PmlEdmDocumentSend;

public class PmlEdmDocumentSendNgayPhathanhComparator extends OrderByComparator {
	public static String ORDER_BY_ASC = "pml_edm_documentsend.issuingDate ASC";

	public static String ORDER_BY_DESC = "pml_edm_documentsend.issuingDate DESC";
	
	private boolean _asc;
	
	public PmlEdmDocumentSendNgayPhathanhComparator() {
		this(false);
	}

	public PmlEdmDocumentSendNgayPhathanhComparator(boolean asc) {
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
