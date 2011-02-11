package com.sgs.portlet.pml_edm_confidentiallevel.util;

import com.liferay.portal.kernel.util.OrderByComparator;

public class PmlEDMConfidentialLevelSearchUtil {

	public static OrderByComparator getPmlEDMConfidentialLevelOrderByComparator(
			String orderByCol, String orderByType) {
		
		boolean orderByAsc = false;

		if (orderByType.equals("asc")) {
			orderByAsc = true;
		}

		OrderByComparator orderByComparator = null;

		if (orderByCol.equals("pml_edm_confidential_level_name")) {
			orderByComparator = new PmlEDMConfidentialLevelNameCodeComparator(orderByAsc);
		}
		

		return orderByComparator;
	}

}
