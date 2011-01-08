package com.sgs.portlet.nation.util;

import com.liferay.portal.kernel.util.OrderByComparator;

public class NationUtil {
	public static OrderByComparator getNationOrderByComparator(
			String orderByCol, String orderByType) {
		boolean orderByAsc = false;

		if (orderByType.equals("asc")) {
			orderByAsc = true;
		}

		OrderByComparator orderByComparator = null;

		if (orderByCol.equals("ma")) {
			orderByComparator = new NationCodeComparator(orderByAsc);
		} else if (orderByCol.equals("ten")) {
			orderByComparator = new NationNameComparator(orderByAsc);
		} 

		return orderByComparator;
	}
}
