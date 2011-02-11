package com.sgs.portlet.report_registry_work.util;

import com.liferay.portal.kernel.util.OrderByComparator;

public class DepartmentSearchUtil {

	public static OrderByComparator getDepartmentOrderByComparator(String orderByCol, String orderByType) {
		boolean orderByAsc = false;

		if (orderByType.equals("asc")) {
			orderByAsc = true;
		}

		OrderByComparator orderByComparator = null;

		if (orderByCol.equals("departmentCode")) {
			orderByComparator = new DepartmentCodeComparator(orderByAsc);
		} else if (orderByCol.equals("departmentName")) {
			orderByComparator = new DepartmentNameComparator(orderByAsc);
		} else if (orderByCol.equals("departmentDescription")) {
			orderByComparator = new DepartmentDescriptionComparator(orderByAsc);
		} 
		
		return orderByComparator;
	}
}
