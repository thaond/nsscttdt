package com.nss.portlet.thong_tin_lien_quan.util;

import com.liferay.portal.kernel.util.OrderByComparator;

public class ThongTinLienQuanSearchUtil {
	public static OrderByComparator getThongTinLienQuanOrderByComparator(
			String orderByCol, String orderByType) {
		boolean orderByAsc = false;

		if (orderByType.equals("asc")) {
			orderByAsc = true;
		}

		OrderByComparator orderByComparator = null;

		if (orderByCol.equals("tenThongTinLienQuan")) {
			orderByComparator = new TenThongTinLienQuanComparator(orderByAsc);
		} else {
			orderByComparator = new TenThongTinLienQuanComparator(orderByAsc);
		}

		return orderByComparator;
	}
}
