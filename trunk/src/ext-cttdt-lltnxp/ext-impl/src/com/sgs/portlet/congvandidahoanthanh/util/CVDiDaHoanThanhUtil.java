package com.sgs.portlet.congvandidahoanthanh.util;

import com.liferay.portal.kernel.util.OrderByComparator;

public class CVDiDaHoanThanhUtil {

	public static OrderByComparator getPhanTichOrderByComparator(String orderByCol, String orderByType) {
		boolean orderByAsc = false;

		if (orderByType.equals("asc")) {
			orderByAsc = true;
		}

		OrderByComparator orderByComparator = null;

		if (orderByCol.equals("ngayphathanh")) {
			orderByComparator = new CVDiDaHoanThanhOrderByNgayPhatHanh(orderByAsc);
		}
		
		return orderByComparator;
	}
}
