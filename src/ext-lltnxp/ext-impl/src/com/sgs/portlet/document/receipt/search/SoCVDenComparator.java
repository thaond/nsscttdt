/**
 * 
 */
package com.sgs.portlet.document.receipt.search;

import com.liferay.portal.kernel.util.OrderByComparator;
import com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt;

/**
 * @author DienNH
 *
 */
public class SoCVDenComparator extends OrderByComparator {

	public static String ORDER_BY_ASC = "cv.documentreference ASC";
	public static String ORDER_BY_DESC = "cv.documentreference DESC";
	
	/**
	 * 
	 */
	public SoCVDenComparator() {
		// TODO Auto-generated constructor stub
		this(false);
	}
	
	public SoCVDenComparator(boolean asc) {
		// TODO Auto-generated constructor stub
		_asc = asc;
	}
	
	public String getOrderBy() {
		if (_asc) {
			return ORDER_BY_ASC;
		}
		else {
			return ORDER_BY_DESC;
		}
 	}
	
	public int compare(Object obj1, Object obj2) {
		PmlEdmDocumentReceipt doc1 = (PmlEdmDocumentReceipt) obj1;
		PmlEdmDocumentReceipt doc2 = (PmlEdmDocumentReceipt) obj2;
		
		int value = doc1.getDocumentReference().compareTo(doc2.getDocumentReference());
		
		if (_asc) {
			return value;
		}
		else {
			return -value;
		}
	}
	
	private boolean _asc;
	
}
