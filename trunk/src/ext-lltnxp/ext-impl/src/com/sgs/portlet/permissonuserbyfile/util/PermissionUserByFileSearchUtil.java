package com.sgs.portlet.permissonuserbyfile.util;

import com.liferay.portal.kernel.util.OrderByComparator;

public class PermissionUserByFileSearchUtil {
	public static OrderByComparator getUserOrderByComparator(
			String orderByCol, String orderByType) {
		
		boolean orderByAsc = false;
		if (orderByType.equals("asc")) {
			orderByAsc = true;
		}
		
		OrderByComparator orderByComparator = null;
		
		if (orderByCol.equals("userName")) {
			orderByComparator = new PermissionUserNameComparator(orderByAsc);
		} else  {
			orderByComparator = new PermissionUserNameComparator(orderByAsc);		
		} 
		return orderByComparator;
	}

}
