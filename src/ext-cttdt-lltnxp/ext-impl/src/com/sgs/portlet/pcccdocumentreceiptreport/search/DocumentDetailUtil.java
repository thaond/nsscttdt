package com.sgs.portlet.pcccdocumentreceiptreport.search;

import com.liferay.portal.kernel.util.OrderByComparator;

public class DocumentDetailUtil {
	
	public static OrderByComparator getDocumentDetailOrderByComparator(
			String orderByCol, String orderByType) {
		
		boolean orderByAsc = false;

		if (orderByType.equals("asc")) {
			orderByAsc = true;
		}

		OrderByComparator orderByComparator = null;

		if (orderByCol.equals("pccc-cvdtn-domat")) {
//			orderByComparator = new DocumentDetailByCVXuLyChinh(orderByAsc);
			orderByComparator = new DocumentDetailOrderByDoMat(orderByAsc);
		}

		return orderByComparator;
	}

}
