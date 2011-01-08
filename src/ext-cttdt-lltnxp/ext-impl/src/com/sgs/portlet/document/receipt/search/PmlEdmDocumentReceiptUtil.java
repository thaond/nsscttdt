/**
 * 
 */
package com.sgs.portlet.document.receipt.search;

import com.liferay.portal.kernel.util.OrderByComparator;

/**
 * @author DienNH
 *
 */
public class PmlEdmDocumentReceiptUtil {

	/**
	 * 
	 */
	public PmlEdmDocumentReceiptUtil() {
		// TODO Auto-generated constructor stub
	}
	
	public static OrderByComparator getDocumentReceiptOrderByComparator(String orderByCol, String orderByType) {
		boolean orderByASC = false;
		
		if (orderByType.equals("asc")) {
			orderByASC = true;
		}
		
		OrderByComparator orderByComparator = null;
		
		if (orderByCol.equals("socvden")) {
			orderByComparator = new SoCVDenComparator(orderByASC);
		}
		else if (orderByCol.equals("sovaoso")) {
			orderByComparator = new SoVaoSoComparator(orderByASC);
		}
		else if (orderByCol.equals("loaicv")) {
			//orderByComparator = new ;		
		}
		else if (orderByCol.equals("noiphathanh")) {
			//orderByComparator = new ;
		}
		else if (orderByCol.equals("ngayden")) {
			orderByComparator = new NgayDenComparator(orderByASC);
		}
		else if (orderByCol.equals("trichyeu")) {
			orderByComparator = new TrichYeuComparator(orderByASC);
		}
		else if (orderByCol.equals("nguoiky")) {
			orderByComparator = new NguoiKyComparator(orderByASC);
		}
		else {
			orderByComparator = new SoCVDenComparator(orderByASC);
		}
		
		return orderByComparator;
	}

}
