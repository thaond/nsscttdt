package com.nss.portlet.onedoorfileprocessed.util;

import com.liferay.portal.kernel.util.OrderByComparator;

public class OneDoorFileProcessedSearchUtil {
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

		return orderByComparator;
	}
}
