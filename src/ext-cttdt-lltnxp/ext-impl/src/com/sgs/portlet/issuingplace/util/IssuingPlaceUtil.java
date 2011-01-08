package com.sgs.portlet.issuingplace.util;

import com.liferay.portal.kernel.util.OrderByComparator;

public class IssuingPlaceUtil {
	public static OrderByComparator getIssuingPlaceByComparator(
			String orderByCol, String orderByType) {
		boolean orderByAsc = false;

		if (orderByType.equals("asc")) {
			orderByAsc = true;
		}

		OrderByComparator orderByComparator = null;

		if (orderByCol.equals("code")) {
			orderByComparator = new IssuingPlaceCodeComparator(orderByAsc);
		} else if (orderByCol.equals("name")) {
			orderByComparator = new IssuingPlaceNameComparator(orderByAsc);
		}

		return orderByComparator;
	}
}
