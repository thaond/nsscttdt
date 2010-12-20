package com.nss.portlet.necessary_info.util;

import com.liferay.portal.kernel.util.OrderByComparator;

public class ThongTinCanThietSearchUtil {
	public static OrderByComparator getThongTinCanThietOrderByComparator(
			String orderByCol, String orderByType) {
		boolean orderByAsc = false;

		if (orderByType.equals("asc")) {
			orderByAsc = true;
		}

		OrderByComparator orderByComparator = null;

		if (orderByCol.equals("tenThongTinCanThiet")) {
			orderByComparator = new TenThongTinCanThietComparator(orderByAsc);
		} else {
			orderByComparator = new TenThongTinCanThietComparator(orderByAsc);
		}

		return orderByComparator;
	}
}
