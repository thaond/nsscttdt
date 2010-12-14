package com.nss.portlet.phone_book.util;

import com.liferay.portal.kernel.util.OrderByComparator;

public class DetailBookUtil {
	public static OrderByComparator getDetailBookOrderByComparator(
			String orderByCol, String orderByType) {
		boolean orderByAsc = false;

		if (orderByType.equals("asc")) {
			orderByAsc = true;
		}

		OrderByComparator orderByComparator = null;

		if (orderByCol.equals("detailBookCode")) {
			orderByComparator = new DetailBookCodeComparator(orderByAsc);
		} else if (orderByCol.equals("detailBookName")) {
			orderByComparator = new DetailBookNameComparator(orderByAsc);
		} else if (orderByCol.equals("detailDescription")) {
			orderByComparator = new DetailBookDescriptionComparator(orderByAsc);
		}

		return orderByComparator;
	}
}
