package com.nss.portlet.agency.util;

import com.liferay.portal.kernel.util.OrderByComparator;

public class AgencyUtil {

	public static OrderByComparator getAgencyOrderByComparator(
			String orderByCol, String orderByType) {
		boolean orderByAsc = false;

		if (orderByType.equals("asc")) {
			orderByAsc = true;
		}

		OrderByComparator orderByComparator = null;

		if (orderByCol.equals("tenLanhDao")) {
			orderByComparator = new AgencyLeaderComparator(orderByAsc);
		} else if (orderByCol.equals("ma")) {
			orderByComparator = new AgencyCodeComparator(orderByAsc);
		} else if (orderByCol.equals("tenCoQuan")) {
			orderByComparator = new AgencyNameComparator(orderByAsc);
		} else {
			orderByComparator = new AgencyCodeComparator(orderByAsc);
		}

		return orderByComparator;
	}

}
