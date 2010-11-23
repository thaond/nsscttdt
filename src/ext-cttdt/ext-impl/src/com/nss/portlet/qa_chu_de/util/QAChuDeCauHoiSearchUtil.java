package com.nss.portlet.qa_chu_de.util;

import com.liferay.portal.kernel.util.OrderByComparator;

public class QAChuDeCauHoiSearchUtil {
	public static OrderByComparator getChuDeCauHoiOrderByComparator(
			String orderByCol, String orderByType) {
		boolean orderByAsc = false;

		if (orderByType.equals("asc")) {
			orderByAsc = true;
		}

		OrderByComparator orderByComparator = null;

		if (orderByCol.equals("tenChuDeCauHoi")) {
			orderByComparator = new TenChuDeCauHoiComparator(orderByAsc);
		} else {
			orderByComparator = new TenChuDeCauHoiComparator(orderByAsc);
		}

		return orderByComparator;
	}
}
