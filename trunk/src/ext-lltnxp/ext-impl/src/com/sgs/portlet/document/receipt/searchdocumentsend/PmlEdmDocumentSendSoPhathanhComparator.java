package com.sgs.portlet.document.receipt.searchdocumentsend;

import com.liferay.portal.kernel.util.OrderByComparator;
import com.sgs.portlet.document.send.model.PmlEdmDocumentSend;

public class PmlEdmDocumentSendSoPhathanhComparator extends OrderByComparator {

	//xuancong close public static String ORDER_BY_ASC = "pml_edm_documentsend.issuingdate, pml_edm_documentsend.documentreference ASC";
	public static String ORDER_BY_ASC = "pml_edm_documentsend.numofdocref ASC";

	//xuancong close public static String ORDER_BY_DESC = "pml_edm_documentsend.issuingdate DESC, pml_edm_documentsend.documentreference DESC";
	public static String ORDER_BY_DESC = "pml_edm_documentsend.numofdocref DESC";
	
	private boolean _asc;
	
	public PmlEdmDocumentSendSoPhathanhComparator() {
		this(false);
	}

	public PmlEdmDocumentSendSoPhathanhComparator(boolean asc) {
		_asc = asc;
	}
	
	
	@Override
	public int compare(Object obj1, Object obj2) {
		
		PmlEdmDocumentSend pmlEdmDocumentSend1 = (PmlEdmDocumentSend)obj1;
		PmlEdmDocumentSend pmlEdmDocumentSend2 = (PmlEdmDocumentSend)obj2;

		//xuancong close int value = pmlEdmDocumentSend1.getDocumentReference().compareTo(pmlEdmDocumentSend2.getDocumentReference());
		// Sap xep phan so cua so van ban
		int num1 = 0;
		int num2 = 0;
		try {
			num1 = Integer.parseInt(pmlEdmDocumentSend1.getDocumentReference().split("/")[0]);
		}
		catch (Exception ex) {
			// Do nothing
		}
		try {
			num2 = Integer.parseInt(pmlEdmDocumentSend2.getDocumentReference().split("/")[0]);
		}
		catch (Exception ex) {
			// Do nothing
		}
		int value = 0;
		if (num1 < num2) {
			value = -1;
		} // end if
		else if (num1 > num2) {
			value = 1;
		} // end if

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
