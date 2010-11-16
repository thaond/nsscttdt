package com.nss.portlet.co_quan_ban_hanh.util;

import com.liferay.portal.kernel.util.OrderByComparator;

public class CoQuanBanHanhSearchUtil {
	public static OrderByComparator getCoQuanBanHanhOrderByComparator(
			String orderByCol, String orderByType) {
		boolean orderByAsc = false;

		if (orderByType.equals("asc")) {
			orderByAsc = true;
		}

		OrderByComparator orderByComparator = null;

		if (orderByCol.equals("tenCoQuanBanHanh")) {
			orderByComparator = new TenCoQuanBanHanhComparator(orderByAsc);
		} else {
			orderByComparator = new TenCoQuanBanHanhComparator(orderByAsc);
		}

		return orderByComparator;
	}
}
