package com.sgs.portlet.document.receipt.util;

import com.liferay.portal.kernel.util.OrderByComparator;
import com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt;

public class DocumentPrivateSoCVDenComparator extends OrderByComparator {
	public static String ORDER_BY_ASC = "documentReference ASC";
	public static String ORDER_BY_DESC = "documentReference DESC";
	
	boolean _asc;
		
	public DocumentPrivateSoCVDenComparator() {
		this(false);
	}
	public DocumentPrivateSoCVDenComparator(boolean asc) {
		_asc = asc;
	}
	@Override
	public int compare(Object obj1, Object obj2) {
		PmlEdmDocumentReceipt p1 = (PmlEdmDocumentReceipt) obj1;
		PmlEdmDocumentReceipt p2 = (PmlEdmDocumentReceipt) obj2;
		
		int value = p1.getDocumentReference().toLowerCase().compareTo(p2.getDocumentReference().toLowerCase());
		if(_asc){
			return value;
		} else{
			return -value;
		}
	}
	
	public String getOrderBy(){
		if(_asc){
			return ORDER_BY_ASC;
		} else
			return ORDER_BY_DESC;
	}
}
