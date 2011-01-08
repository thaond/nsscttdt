/**
 * 
 */
package com.sgs.portlet.pcccdocumentsendprocess.search;

import com.liferay.portal.kernel.util.OrderByComparator;

/**
 * @author minh.nv
 *
 */
public class PcccDocumentSendProcessUtil {

	
	public static OrderByComparator getPcccDocumentSendProcessOrderByComparator(
			String orderByCol, String orderByType) {
		
		boolean orderByAsc = false;

		if (orderByType.equals("asc")) {
			orderByAsc = true;
		}

		OrderByComparator orderByComparator = null;

		if (orderByCol.equals("receipt.creator")) {
			orderByComparator = new PcccDocumentSendProcessEditorComparator(orderByAsc);
		}
		
		else {
			orderByComparator = new PcccDocumentSendProcessEditorComparator(orderByAsc);
		}

		return orderByComparator;
	}

}
