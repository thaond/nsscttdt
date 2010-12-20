package com.nss.portlet.onedoorprocess.utilsearch;

import com.liferay.portal.kernel.util.OrderByComparator;

/**
 * @author canhminh
 *
 */
public class PmlOneDoorReceiveFileSearchUtil {
	
	public static OrderByComparator getPmlOneDoorReceiveFileOrderByComparator(
			String orderByCol, String orderByType) {
		
		boolean orderByAsc = false;

		if (orderByType.equals("asc")) {
			orderByAsc = true;
		}

		OrderByComparator orderByComparator = null;

		if (orderByCol.equals("pccc-DSHS-mahoso")) {
			orderByComparator = new PmlOneDoorReceiveFileCodeComparator(orderByAsc);
		} else {
			orderByComparator = new PmlOneDoorReceiveFileCodeComparator(orderByAsc);
		}

		return orderByComparator;
	}
}
