package com.nss.portlet.link.util;

import com.liferay.portal.kernel.util.OrderByComparator;

public class LienKetWebsiteSearchUtil {
	public static OrderByComparator getLienKetWebsiteOrderByComparator(
			String orderByCol, String orderByType) {
		boolean orderByAsc = false;

		if (orderByType.equals("asc")) {
			orderByAsc = true;
		}

		OrderByComparator orderByComparator = null;

		if (orderByCol.equals("tenwebsite")) {
			orderByComparator = new LienKetWebsiteTenWebsiteComparator(orderByAsc);
		}
		if (orderByCol.equals("thuTuwebsite")) {
			orderByComparator = new LienKetWebsiteThuTuWebsiteComparator(orderByAsc);
		}
		else {
			orderByComparator = new LienKetWebsiteTenWebsiteComparator(orderByAsc);
		}

		return orderByComparator;
	}
}
