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
public class NguoiKyComparator extends OrderByComparator {

	public static String ORDER_BY_ASC = "cv.signer ASC";
	public static String ORDER_BY_DESC = "cv.signer DESC";
	
	/**
	 * 
	 */
	public NguoiKyComparator() {
		// TODO Auto-generated constructor stub
		this(false);
	}
	
	public NguoiKyComparator(boolean asc) {
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
		
		int value = doc1.getSigner().compareTo(doc2.getSigner());
		
		if (_asc) {
			return value;
		}
		else {
			return -value;
		}
	}
	
	private boolean _asc;
	
}
