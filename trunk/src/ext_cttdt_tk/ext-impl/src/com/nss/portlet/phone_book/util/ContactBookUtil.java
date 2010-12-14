package com.nss.portlet.phone_book.util;

import com.liferay.portal.kernel.util.OrderByComparator;

public class ContactBookUtil {
	public static OrderByComparator getContactBookOrderByComparator(
			String orderByCol, String orderByType) {
		boolean orderByAsc = false;

		if (orderByType.equals("asc")) {
			orderByAsc = true;
		}

		OrderByComparator orderByComparator = null;

		if (orderByCol.equals("contactBookCode")) {
			orderByComparator = new ContactBookCodeComparator(orderByAsc);
		} else if (orderByCol.equals("contactBookName")) {
			orderByComparator = new ContactBookNameComparator(orderByAsc);
		} else if (orderByCol.equals("contactDescription")) {
			orderByComparator = new ContactBookDescriptionComparator(orderByAsc);
		}

		return orderByComparator;
	}
}
