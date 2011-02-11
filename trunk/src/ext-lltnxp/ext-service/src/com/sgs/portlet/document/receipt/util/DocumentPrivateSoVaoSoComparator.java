package com.sgs.portlet.document.receipt.util;

import com.liferay.portal.kernel.util.OrderByComparator;
import com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt;

public class DocumentPrivateSoVaoSoComparator extends OrderByComparator {

	public static String ORDER_BY_ASC = "numberDocumentReceipt ASC";
	public static String ORDER_BY_DESC = "numberDocumentReceipt DESC";
	
	boolean _asc = false;
	
	public DocumentPrivateSoVaoSoComparator() {
		this(false);
	}
	
	public DocumentPrivateSoVaoSoComparator(boolean asc) {
		_asc = asc;
	}
	
	@Override
	public int compare(Object obj1, Object obj2) {
		PmlEdmDocumentReceipt p1 = (PmlEdmDocumentReceipt) obj1;
		PmlEdmDocumentReceipt p2 = (PmlEdmDocumentReceipt) obj2;
		
		int value = p1.getNumberDocumentReceipt().toLowerCase().compareTo(p2.getNumberDocumentReceipt().toLowerCase());
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
