/**
 * 
 */
package com.sgs.portlet.onedoorreturn.util;

import com.liferay.portal.kernel.util.OrderByComparator;

/**
 * @author minhnv
 *
 */
public class PmlFileReturnUtil {

	
	public static OrderByComparator getPmlFileReturnOrderByComparator(
			String orderByCol, String orderByType) {
		
		boolean orderByAsc = false;

		if (orderByType.equals("asc")) {
			orderByAsc = true;
		}

		OrderByComparator orderByComparator = null;

		if (orderByCol.equals("pccc-DSHS-mahoso")) {
			orderByComparator = new PmlFileReturnCodeComparator(orderByAsc);
		}
//		else if (orderByCol.equals("pccc-TN-tenhoso")) {
//			orderByComparator = new PmlFileReturnNameComparator(orderByAsc);
//		}
		else {
			orderByComparator = new PmlFileReturnCodeComparator(orderByAsc);
		}

		return orderByComparator;
	}


}
