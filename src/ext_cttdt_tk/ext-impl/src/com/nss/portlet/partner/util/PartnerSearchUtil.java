package com.nss.portlet.partner.util;

import com.liferay.portal.kernel.util.OrderByComparator;

public class PartnerSearchUtil {
	
	public static OrderByComparator getPartnerOrderByComparator(
			String orderByCol, String orderByType) {
		boolean orderByAsc = false;

		if (orderByType.equals("asc")) {
			orderByAsc = true;
		}

		OrderByComparator orderByComparator = null;

		if (orderByCol.equals("tenPartner")) {
			orderByComparator = new PartnerTenComparator(orderByAsc);
		}
		if (orderByCol.equals("thuTuPartner")) {
			orderByComparator = new PartnerThuTuComparator(orderByAsc);
		}
		else {
			orderByComparator = new PartnerTenComparator(orderByAsc);
		}

		return orderByComparator;
	}
}
