package com.nss.portlet.image_signer.util;

import com.liferay.portal.kernel.util.OrderByComparator;
import com.nss.portlet.image_signer.util.comparator.UserFirstNameComparator;
import com.nss.portlet.image_signer.util.comparator.UserLastNameComparator;
import com.nss.portlet.image_signer.util.comparator.UserMiddleNameComparator;

public class UserUtil {

	public static OrderByComparator getUserOrderByComparator(
			String orderByCol, String orderByType) {
		boolean orderByAsc = false;

		if (orderByType.equals("asc")) {
			orderByAsc = true;
		}
		OrderByComparator orderByComparator = null;
		if (orderByCol.equals("FirstName")) {
			orderByComparator = new UserFirstNameComparator(orderByAsc);

		} else if (orderByCol.equals("MiddleName")) {
			orderByComparator = new UserMiddleNameComparator(orderByAsc);

		} else if (orderByCol.equals("LastName")) {
			orderByComparator = new UserLastNameComparator(orderByAsc);
		} 
		return orderByComparator;
	}
}
