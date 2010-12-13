package com.nss.portlet.link.util;

import com.liferay.portal.kernel.util.OrderByComparator;

public class LoaiWebsiteSearchUtil {
	public static OrderByComparator getLoaiWebsiteOrderByComparator(
			String orderByCol, String orderByType) {
		boolean orderByAsc = false;

		if (orderByType.equals("asc")) {
			orderByAsc = true;
		}

		OrderByComparator orderByComparator = null;

		if (orderByCol.equals("tenloaiwebsite")) {
			orderByComparator = new LoaiWebsiteTenLoaiWebsiteComparator(orderByAsc);
		}
		else {
			orderByComparator = new LoaiWebsiteTenLoaiWebsiteComparator(orderByAsc);
		}

		return orderByComparator;
	}
}
