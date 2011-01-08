package com.sgs.portlet.onedoorfileprocessed.util;

import com.liferay.portal.kernel.util.OrderByComparator;

public class OneDoorFileProcessedUtil {
	public static OrderByComparator getOneDoorFileByComparator(
			String orderByCol, String orderByType) {
		boolean orderByAsc = false;

		if (orderByType.equals("asc")) {
			orderByAsc = true;
		}

		OrderByComparator orderByComparator = null;

		if (orderByCol.equals("maHoSo")) {
			orderByComparator = new OneDoorFileIdComparator(orderByAsc);
		} 
//		else if (orderByCol.equals("tenHoSo")) {
//			orderByComparator = new OneDoorFileNameComparator(orderByAsc);
//		}

		return orderByComparator;
	}
}
