package com.sgs.portlet.home_report.util;

import com.liferay.portal.kernel.util.OrderByComparator;

public class HomeReportUtil {
	
	public static OrderByComparator getHomeReportOrderByComparator(String orderByCol, String orderByType) {
		
		boolean orderByAsc = false;
		
		if(orderByType.equals("asc")){
			orderByAsc = true;
		}
		
		OrderByComparator orderByComparator = null;
		
		if(orderByCol.equals("hoten")){
			orderByComparator = new HomeReportUserNameComparator(orderByAsc);
		}
		
		return orderByComparator;
	}
}
