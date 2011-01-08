package com.sgs.portlet.documentlevelsend.util;

import com.liferay.portal.kernel.util.OrderByComparator;

public class PmlEdmLevelSendSearchUtil {

	public static OrderByComparator getPmlEdmLevelSendOrderByComparator(
			String orderByCol, String orderByType) {
		boolean orderByAsc = false;

		if (orderByType.equals("asc")) {
			orderByAsc = true;
		}

		OrderByComparator orderByComparator = null;

		if (orderByCol.equals("document.level")) {
			orderByComparator = new PmlEdmLevelSendSearchNameComparator(orderByAsc);
		}

		return orderByComparator;
	}

}
