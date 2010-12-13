/**
 * 
 */
package com.nss.portlet.department.util;

import com.liferay.portal.kernel.util.OrderByComparator;
import com.nss.portlet.agency.util.AgencyCodeComparator;

/**
 * @author minhnv
 *
 */
public class PmlDepartmentSearchUtil {

	
	public static OrderByComparator getPmlDepartmentOrderByComparator(
			String orderByCol, String orderByType) {
		
		boolean orderByAsc = false;

		if (orderByType.equals("asc")) {
			orderByAsc = true;
		}

		OrderByComparator orderByComparator = null;

		if (orderByCol.equals("department_code")) {
			orderByComparator = new PmlDepartmentCodeComparator(orderByAsc);
		} else if (orderByCol.equals("department_name")) {
			orderByComparator = new PmlDepartmentNameComparator(orderByAsc);
		} else if (orderByCol.equals("abbreviate_name")) {
			orderByComparator = new PmlDepartmentAbbreviateNameComparator(orderByAsc);
		} else {
			orderByComparator = new AgencyCodeComparator(orderByAsc);
		}

		return orderByComparator;
	}

}
