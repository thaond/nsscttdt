package com.sgs.portlet.signer.util;

import com.liferay.portal.kernel.util.OrderByComparator;

public class UserUtil {
	/**
	 * @method getSignerOrderByComparator	
	 * @param orderByCol, orderByType
	 * @return OrderByComparator
	 * sap xep tang hoac giam theo lastname hoac firstname
	 */
	public static OrderByComparator getSignerOrderByComparator(
			String orderByCol, String orderByType) {
		boolean orderByAsc = false;
		if(orderByType.equals("asc")){
			orderByAsc = true;
		}
		OrderByComparator orderByComparator = null;
		if(orderByCol.equals("orderFirstname")){
			orderByComparator = new ContactFirstnameComparator(orderByAsc);
		}else if(orderByCol.equals("orderLastname")){
			orderByComparator = new ContactLastnameComparator(orderByAsc);
		}
		return orderByComparator;
	}
}
