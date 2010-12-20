package com.nss.portlet.adv.util;

import com.liferay.portal.kernel.util.OrderByComparator;

public class QuangCaoSearchUtil {
	public static OrderByComparator getQuangCaoOrderByComparator(
			String orderByCol, String orderByType) {
		boolean orderByAsc = false;

		if (orderByType.equals("asc")) {
			orderByAsc = true;
		}

		OrderByComparator orderByComparator = null;

		if (orderByCol.equals("tenQuangCao")) {
			orderByComparator = new TenQuangCaoComparator(orderByAsc);
		} else {
			orderByComparator = new TenQuangCaoComparator(orderByAsc);
		}

		return orderByComparator;
	}
}
