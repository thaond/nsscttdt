package com.sgs.portlet.pmlstreet.util;

import com.liferay.portal.kernel.util.OrderByComparator;

public class PmlStreetUtil {
	public static OrderByComparator getStreetOrderByComparator(
			String orderByCol, String orderByType) {
		boolean orderByAsc = false;
		if(orderByType.equals("asc")){
			orderByAsc = true;
		}
		OrderByComparator orderByComparator = null;
		if(orderByCol.equals("tenDuong")){
			orderByComparator = new StreetNameComparator(orderByAsc);
		} else {
			orderByComparator = new StreetNameComparator(orderByAsc);
		}
		return orderByComparator;
	}
}
