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
public class NgayDenComparator extends OrderByComparator {

	public static String ORDER_BY_ASC = "cv.datearrive ASC";
	public static String ORDER_BY_DESC = "cv.datearrive DESC";
	
	/**
	 * 
	 */
	public NgayDenComparator() {
		// TODO Auto-generated constructor stub
		this(false);
	}
	
	public NgayDenComparator(boolean asc) {
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
		
		int value = doc1.getDateArrive().compareTo(doc2.getDateArrive());
		
		if (_asc) {
			return value;
		}
		else {
			return -value;
		}
	}
	
	private boolean _asc;
	
}
