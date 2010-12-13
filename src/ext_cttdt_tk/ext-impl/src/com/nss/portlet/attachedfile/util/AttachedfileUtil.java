package com.nss.portlet.attachedfile.util;

import com.liferay.portal.kernel.util.OrderByComparator;

public class AttachedfileUtil {
	public static OrderByComparator getAttachedfileOrderByComparator(
			String orderByCol, String orderByType) {
		boolean orderByAsc = false;

		if (orderByType.equals("asc")) {
			orderByAsc = true;
		}

		OrderByComparator orderByComparator = null;

		if (orderByCol.equals("code")) {
			orderByComparator = new AttachedfileCodeComparator(orderByAsc);
		} else if (orderByCol.equals("name")) {
			orderByComparator = new AttachedfileNameComparator(orderByAsc);
		} else {
			orderByComparator = new AttachedfileCodeComparator(orderByAsc);
		}

		return orderByComparator;
	}
}
