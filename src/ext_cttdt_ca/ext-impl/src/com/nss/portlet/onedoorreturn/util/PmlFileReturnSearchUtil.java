package com.nss.portlet.onedoorreturn.util;

import com.liferay.portal.kernel.util.OrderByComparator;

public class PmlFileReturnSearchUtil {

	
	public static OrderByComparator getPmlFileReturnOrderByComparator(
			String orderByCol, String orderByType) {
		
		boolean orderByAsc = false;

		if (orderByType.equals("asc")) {
			orderByAsc = true;
		}

		OrderByComparator orderByComparator = null;

		if (orderByCol.equals("pccc-DSHS-mahoso")) {
			orderByComparator = new PmlFileReturnCodeComparator(orderByAsc);
		}
		else {
			orderByComparator = new PmlFileReturnCodeComparator(orderByAsc);
		}

		return orderByComparator;
	}


}
