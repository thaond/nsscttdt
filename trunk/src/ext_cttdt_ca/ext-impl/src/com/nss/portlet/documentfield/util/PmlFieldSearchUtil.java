/**
 * 
 */
package com.nss.portlet.documentfield.util;

import com.liferay.portal.kernel.util.OrderByComparator;

/**
 * @author canhminh
 *
 */
public class PmlFieldSearchUtil {

	public static OrderByComparator getPmlFieldOrderByComparator(
			String orderByCol, String orderByType) {
		
		boolean orderByAsc = false;
		if (orderByType.equals("asc")) {
			orderByAsc = true;
		}
		
		OrderByComparator orderByComparator = null;
		
		if(orderByCol.equals("field.code")) {
			orderByComparator = new PmlFieldCodeComparator(orderByAsc);
		} else  if (orderByCol.equals("field.name")) {
			orderByComparator = new PmlFieldNameComparator(orderByAsc);		
		} else {
			orderByComparator = new PmlFieldCodeComparator(orderByAsc);
		}
		
		return orderByComparator;
	}


}
