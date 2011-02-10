package com.sgs.portlet.country.util;

import com.liferay.portal.kernel.util.OrderByComparator;

public class CountryUtil {
	public static OrderByComparator getCountryOrderByComparator(
			String orderByCol, String orderByType) {
		boolean orderByAsc = false;

		if (orderByType.equals("asc")) {
			orderByAsc = true;
		}

		OrderByComparator orderByComparator = null;

		if (orderByCol.equals("ma")) {
			orderByComparator = new CountryCodeComparator(orderByAsc);
		} else if (orderByCol.equals("ten")) {
			orderByComparator = new CountryNameComparator(orderByAsc);
		} 

		return orderByComparator;
	}
}
