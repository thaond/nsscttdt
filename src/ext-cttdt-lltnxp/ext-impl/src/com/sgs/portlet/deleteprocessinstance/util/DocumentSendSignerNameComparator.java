package com.sgs.portlet.deleteprocessinstance.util;

import com.liferay.portal.kernel.util.OrderByComparator;
import com.sgs.portlet.document.send.model.PmlEdmDocumentSend;

public class DocumentSendSignerNameComparator extends OrderByComparator{
	public static String ORDER_BY_ASC = "pml_edm_documentsend.signername ASC";

	public static String ORDER_BY_DESC = "pml_edm_documentsend.signername DESC";
	
	private boolean _asc;
	
	public DocumentSendSignerNameComparator(){
		this(false);
	}
	
	public DocumentSendSignerNameComparator(boolean asc){
		this._asc = asc;
	}
	
	public int compare(Object arg0, Object arg1) {
		PmlEdmDocumentSend signerName1 = (PmlEdmDocumentSend)arg0;
		PmlEdmDocumentSend signerName2 = (PmlEdmDocumentSend)arg1;
		
		int value = signerName1.getSignerName().compareTo(signerName2.getSignerName());
		
		if(this._asc){
			return value;
		}else{
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
