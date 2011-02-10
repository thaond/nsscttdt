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
public class SoVaoSoComparator extends OrderByComparator {

	/* xuancong close start
	public static String ORDER_BY_ASC = "cv.numberdocumentreceipt ASC";
	public static String ORDER_BY_DESC = "cv.numberdocumentreceipt DESC";
	xuancong close end */
	public static String ORDER_BY_ASC = "cv.generalorderno ASC";
	public static String ORDER_BY_DESC = "cv.generalorderno DESC";
	
	/**
	 * 
	 */
	public SoVaoSoComparator() {
		// TODO Auto-generated constructor stub
		this(false);
	}
	
	public SoVaoSoComparator(boolean asc) {
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
		
	//xuancong close int value = doc1.getNumberDocumentReceipt().compareTo(doc2.getNumberDocumentReceipt());
		// Phai so sanh phan so cua so van ban chu khong phai coi nguoi so van ban la mot chuoi
		int num1 = 0;
		int num2 = 0;
		try {
			num1 = Integer.parseInt(doc1.getNumberDocumentReceipt().split("/")[0]);
		}
		catch (Exception ex) {
			// Do nothing
		}
		try {
			num2 = Integer.parseInt(doc2.getNumberDocumentReceipt().split("/")[0]);
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
	
	private boolean _asc;
	
}
