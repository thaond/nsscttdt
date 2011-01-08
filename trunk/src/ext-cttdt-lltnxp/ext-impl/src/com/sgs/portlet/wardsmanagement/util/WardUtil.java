package com.sgs.portlet.wardsmanagement.util;

import com.liferay.portal.kernel.util.OrderByComparator;

public class WardUtil {
	public static OrderByComparator getWardOrderByComparator(
			String orderByCol, String orderByType) {
		boolean orderByAsc = false;

		if (orderByType.equals("asc")) {
			orderByAsc = true;
		}

		OrderByComparator orderByComparator = null;

		if (orderByCol.equals("ma")) {
			orderByComparator = new WardCodeComparator(orderByAsc);
		} else if (orderByCol.equals("ten")) {
			orderByComparator = new WardNameComparator(orderByAsc);
		} else if (orderByCol.equals("quan")) {
			orderByComparator = new DistrictNameComparator(orderByAsc);
		} 

		return orderByComparator;
	}
}
