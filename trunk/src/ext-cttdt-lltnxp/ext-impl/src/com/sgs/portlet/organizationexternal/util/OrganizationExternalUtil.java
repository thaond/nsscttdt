package com.sgs.portlet.organizationexternal.util;

import com.liferay.portal.kernel.util.OrderByComparator;

public class OrganizationExternalUtil {
	
	public static OrderByComparator getOrgExternalOrderByComparator(String orderByCol, String orderByType) {
		
		boolean orderByAsc = false;
		
		if(orderByType.equals("asc")) {
			orderByAsc = true;
		}
		
		OrderByComparator orderByComparator = null;
		
		if(orderByCol.equals("ma")) {
			orderByComparator = new OrgExternalCodeComparator(orderByAsc);
		}
		else if(orderByCol.equals("ten")) {
			orderByComparator = new OrgExternalNameComparator(orderByAsc);
		}
		
		return orderByComparator;
	}

}
