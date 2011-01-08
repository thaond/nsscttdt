package com.sgs.portlet.document.receipt.searchdocumentsend;

import com.liferay.portal.kernel.util.OrderByComparator;

public class PmlEdmDocumentSendUtil {

	public static OrderByComparator getPmlEdmDocumentSendOrderByComparator(
			String orderByCol, String orderByType) {
		boolean orderByAsc = false;

		if (orderByType.equals("asc")) {
			orderByAsc = true;
		}

		OrderByComparator orderByComparator = null;

		if (orderByCol.equals("so-phat-hanh")) {
			orderByComparator = new PmlEdmDocumentSendSoPhathanhComparator(orderByAsc);
		}
		else if (orderByCol.equals("ngay-phat-hanh")) {
			orderByComparator = new PmlEdmDocumentSendNgayPhathanhComparator(orderByAsc);
		}
		else {
			orderByComparator = new PmlEdmDocumentSendSoPhathanhComparator(orderByAsc);
		}

		return orderByComparator;
	}

	

}
