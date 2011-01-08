package com.sgs.portlet.pcccdocumentreceiptprocess.util;

import com.liferay.portal.kernel.util.OrderByComparator;
import com.sgs.portlet.pcccdocumentreceiptprocess.searchtemp.PcccDocumentReceiptTempSoCongVanDenComparator;

public class PcccDocumentReceiptTempSearchUtil {
	public static OrderByComparator getPcccDocumentReceiptTempOrderByComparator(
			String orderByCol, String orderByType) {
		
		boolean orderByAsc = false;

		if (orderByType.equals("asc")) {
			orderByAsc = true;
		}

		OrderByComparator orderByComparator = null;
		if (orderByCol.equals("pccc-cvdtn-soCVden")) {
			orderByComparator = new PcccDocumentReceiptTempSoCongVanDenComparator(orderByAsc);
		} 

		return orderByComparator;
	}
}
