package com.sgs.portlet.position.util;

import com.liferay.portal.kernel.util.OrderByComparator;

public class PositionSearchUtil {
	
	public static OrderByComparator getPositionOrderByComparator(
			String orderByCol, String orderByType) {
		boolean orderByAsc = false;

		if (orderByType.equals("asc")) {
			orderByAsc = true;
		}

		OrderByComparator orderByComparator = null;

		if (orderByCol.equals("code")) {
			orderByComparator = new PositionCodeComparator(orderByAsc);
		} else if (orderByCol.equals("name")) {
			orderByComparator = new PositionNameComparator(orderByAsc);
		} else if (orderByCol.equals("description")) {
			orderByComparator = new DescriptionComparator(orderByAsc);
		} else {
			orderByComparator = new PositionNameComparator(orderByAsc);
		}

		return orderByComparator;
	}

}
