package com.nss.portlet.media_chu_de.util;

import com.liferay.portal.kernel.util.OrderByComparator;

public class MediaChuDeSearchUtil {
	public static OrderByComparator getMediaChuDeOrderByComparator(
			String orderByCol, String orderByType) {
		boolean orderByAsc = false;

		if (orderByType.equals("asc")) {
			orderByAsc = true;
		}

		OrderByComparator orderByComparator = null;

		if (orderByCol.equals("tenMediaChuDe")) {
			orderByComparator = new TenMediaChuDeComparator(orderByAsc);
		} else {
			orderByComparator = new TenMediaChuDeComparator(orderByAsc);
		}

		return orderByComparator;
	}
}
