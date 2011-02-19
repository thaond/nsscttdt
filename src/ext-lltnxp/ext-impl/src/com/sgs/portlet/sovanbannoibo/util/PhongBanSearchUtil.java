package com.sgs.portlet.sovanbannoibo.util;

import com.liferay.portal.kernel.util.OrderByComparator;

public class PhongBanSearchUtil {

	public static OrderByComparator getPhongBanOrderByComparator(String orderByCol, String orderByType) {
		boolean orderByAsc = false;

		if (orderByType.equals("asc")) {
			orderByAsc = true;
		}

		OrderByComparator orderByComparator = null;

		if (orderByCol.equals("departmentsCode")) {
			orderByComparator = new MaPhongBanComparator(orderByAsc);
		} else if (orderByCol.equals("departmentsName")) {
			orderByComparator = new TenPhongBanComparator(orderByAsc);
		} else if (orderByCol.equals("abbreviateName")) {
			orderByComparator = new TenVietTatComparator(orderByAsc);
		} 
		return orderByComparator;
	}
}
