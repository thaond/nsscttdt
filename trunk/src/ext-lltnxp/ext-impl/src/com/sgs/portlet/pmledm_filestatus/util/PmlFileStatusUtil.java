package com.sgs.portlet.pmledm_filestatus.util;

import com.liferay.portal.kernel.util.OrderByComparator;

public class PmlFileStatusUtil {
	
	public static OrderByComparator getPmlFileStatusOrderByComparator(
			String orderByCol, String orderByType) {
		boolean orderByAsc = false;
		if(orderByType.equals("asc")){
			orderByAsc = true;
		}
		OrderByComparator orderByComparator = null;
		if(orderByCol.equals("orderFilestatuscode")){
			orderByComparator = new PmlFilestatusCodeComparator(orderByAsc);
		}else if(orderByCol.equals("orderFilestatusname")){
			orderByComparator = new PmlFilestatusNameComparator(orderByAsc);
		}
		return orderByComparator;
	}
}
