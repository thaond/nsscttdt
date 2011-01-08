/**
 * 
 */
package com.sgs.portlet.pml_edm_privelegeleveladmin.util;

import com.liferay.portal.kernel.util.OrderByComparator;

/**
 * @author canhminh
 *
 */
public class PmlEdmPrivilegeLevelUtil {

	
	public static OrderByComparator getPmlEdmPrivilegeLevelOrderByComparator(
			String orderByCol, String orderByType) {
		
		boolean orderByAsc = false;

		if (orderByType.equals("asc")) {
			orderByAsc = true;
		}

		OrderByComparator orderByComparator = null;

		if (orderByCol.equals("pml_edm_privilege_level_name")) {
			orderByComparator = new PmlEdmPrivilegeLevelNameCodeComparator(orderByAsc);
		}
		

		return orderByComparator;
	}

}
