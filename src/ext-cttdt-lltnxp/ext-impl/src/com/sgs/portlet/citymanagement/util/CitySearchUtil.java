package com.sgs.portlet.citymanagement.util;

import com.liferay.portal.kernel.util.OrderByComparator;

public class CitySearchUtil {
	public static OrderByComparator getCityOrderByComparator(
			String orderByCol, String orderByType) {
		boolean orderByAsc = false;

		if (orderByType.equals("asc")) {
			orderByAsc = true;
		}

		OrderByComparator orderByComparator = null;

		if (orderByCol.equals("ma")) {
			orderByComparator = new CityCodeComparator(orderByAsc);
		} else if (orderByCol.equals("ten")) {
			orderByComparator = new CityNameComparator(orderByAsc);
		} else {
			orderByComparator = new CityCodeComparator(orderByAsc);
		}

		return orderByComparator;
	}

}
