package com.sgs.portlet.pml_template.util;

import com.liferay.portal.kernel.util.OrderByComparator;

public class PmlTemplateSearchUtil {
	public static OrderByComparator getPmlTemplateOrderByComparator(
			String orderByCol, String orderByType) {
		boolean orderByAsc = false;

		if (orderByType.equals("asc")) {
			orderByAsc = true;
		}

		OrderByComparator orderByComparator = null;

		if (orderByCol.equals("tenBieuMau")) {
			orderByComparator = new TenBieuMauComparator(orderByAsc);
		} else if (orderByCol.equals("maBieuMau")) {
			orderByComparator = new MaBieuMauComparator(orderByAsc);
		} else {
			orderByComparator = new TenBieuMauComparator(orderByAsc);
		}

		return orderByComparator;
	}
}
