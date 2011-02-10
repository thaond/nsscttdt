package com.sgs.portlet.districtmanagement.util;

import com.liferay.portal.kernel.util.OrderByComparator;

public class DistrictUtil {
	public static OrderByComparator getDistrictOrderByComparator(
			String orderByCol, String orderByType) {
		boolean orderByAsc = false;

		if (orderByType.equals("asc")) {
			orderByAsc = true;
		}

		OrderByComparator orderByComparator = null;

		if (orderByCol.equals("ma")) {
			orderByComparator = new DistrictCodeComparator(orderByAsc);
		} else if (orderByCol.equals("ten")) {
			orderByComparator = new DistrictNameComparator(orderByAsc);
		} else if (orderByCol.equals("tenTinh")) {
			orderByComparator = new CityNameComparator(orderByAsc);
		} 

		return orderByComparator;
	}
}
