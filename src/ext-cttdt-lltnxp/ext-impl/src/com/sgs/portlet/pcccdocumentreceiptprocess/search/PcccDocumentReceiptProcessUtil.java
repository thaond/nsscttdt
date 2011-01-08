package com.sgs.portlet.pcccdocumentreceiptprocess.search;

import com.liferay.portal.kernel.util.OrderByComparator;

public class PcccDocumentReceiptProcessUtil {

	public static OrderByComparator getPcccDocumentReceiptProcessOrderByComparator(
			String orderByCol, String orderByType) {
		
		boolean orderByAsc = false;

		if (orderByType.equals("asc")) {
			orderByAsc = true;
		}

		OrderByComparator orderByComparator = null;

		/* xuancong close start
		if (orderByCol.equals("pccc-cvdtn-sohieu")) {
			orderByComparator = new PcccDocumentReceiptProcessSoCongVanDenComparator(orderByAsc);
		}
		
		else {
			orderByComparator = new PcccDocumentReceiptProcessSoCongVanDenComparator(orderByAsc);
		}
		xuancong close end */
		if (orderByCol.equals("pccc-cvdtn-soCVden")) {
			orderByComparator = new PcccDocumentReceiptProcessSoCongVanDenComparator(orderByAsc);
		} // end if

		return orderByComparator;
	}

}
