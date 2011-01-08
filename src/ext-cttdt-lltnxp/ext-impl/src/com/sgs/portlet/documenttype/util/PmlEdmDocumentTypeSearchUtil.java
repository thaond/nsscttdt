/**
 * 
 */
package com.sgs.portlet.documenttype.util;

import com.liferay.portal.kernel.util.OrderByComparator;

/**
 * @author minhnv
 *
 */
public class PmlEdmDocumentTypeSearchUtil {

	
	public static OrderByComparator getPmlEdmDocumentTypeOrderByComparator(
			String orderByCol, String orderByType) {
		boolean orderByAsc = false;
		
		if (orderByType.equals("asc")) {
			orderByAsc = true;
		}

		OrderByComparator orderByComparator = null;

		if (orderByCol.equals("ten-loai-cong-van")) {
			orderByComparator = new PmlEdmDocumentTypeNameComparator(orderByAsc);
		} else if (orderByCol.equals("ten-loai-so-cong-van")) {
			orderByComparator = new PmlEdmDocumentTypeDocumentRecordTypeName(orderByAsc);
		}

		return orderByComparator;
	}

}
