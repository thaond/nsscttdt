package com.nss.portlet.managementworkflowjournal.util;

import com.liferay.portal.kernel.util.OrderByComparator;

public class ManagementWorkflowJournalSearchUtil {
	
	
	public static OrderByComparator getManagementWorkflowJournalOrderByComparator(
			String orderByCol, String orderByType) {
		boolean orderByAsc = false;

		if (orderByType.equals("asc")) {
			orderByAsc = true;
		}

		if (orderByCol.equals("version")) {
			return new VersionManagementWorkflowJournalComparator(orderByAsc);
		} else {
			return new VersionManagementWorkflowJournalComparator(orderByAsc);
		}
	}

}
