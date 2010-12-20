package com.nss.portlet.qa_cau_hoi.util;

import com.liferay.portal.kernel.util.OrderByComparator;

public class QACauHoiSearchUtil {
	public static OrderByComparator getTieuDeCauHoiOrderByComparator(
			String orderByCol, String orderByType) {
		boolean orderByAsc = false;

		if (orderByType.equals("asc")) {
			orderByAsc = true;
		}

		OrderByComparator orderByComparator = null;

		if (orderByCol.equals("tieuDeCauHoi")) {
			orderByComparator = new QACauHoiTieuDeComparator(orderByAsc);
		} else {
			orderByComparator = new QACauHoiTieuDeComparator(orderByAsc);
		}

		return orderByComparator;
	}
}
