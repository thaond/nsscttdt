package com.sgs.portlet.career.util;

import com.liferay.portal.kernel.util.OrderByComparator;

public class CareerUtil {
	public static OrderByComparator getCareerOrderByComparator(
			String orderByCol, String orderByType) {
		boolean orderByAsc = false;
		if(orderByType.equals("asc")){
			orderByAsc = true;
		}
		OrderByComparator orderByComparator = null;
		if(orderByCol.equals("ma")){
			orderByComparator = new CareerCodeComparator(orderByAsc);
		}else if(orderByCol.equals("ten")){
			orderByComparator = new CareerNameComparator(orderByAsc);
		}
		return orderByComparator;
	}
}
