package com.sgs.portlet.report_registry_work.util;

import com.liferay.portal.kernel.util.OrderByComparator;

public class ReportRegistrySearchUtil {

	public static OrderByComparator getReportRegistryOrderByComparator(String orderByCol, String orderByType) {
		boolean orderByAsc = false;

		if (orderByType.equals("asc")) {
			orderByAsc = true;
		}

		OrderByComparator orderByComparator = null;

		if (orderByCol.equals("reportRegistryCode")) {
			orderByComparator = new ReportRegistryCodeComparator(orderByAsc);
		} else if (orderByCol.equals("userCreate")) {
			orderByComparator = new UserCreateComparator(orderByAsc);
		} else if (orderByCol.equals("resultWork")) {
			orderByComparator = new ResultWorkComparator(orderByAsc);
		} else if (orderByCol.equals("programWork")) {
			orderByComparator = new ProgramWorkComparator(orderByAsc);
		}

		return orderByComparator;
	}
}
