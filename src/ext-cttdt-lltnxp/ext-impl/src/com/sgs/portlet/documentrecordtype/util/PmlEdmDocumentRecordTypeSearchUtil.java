package com.sgs.portlet.documentrecordtype.util;

import com.liferay.portal.kernel.util.OrderByComparator;

public class PmlEdmDocumentRecordTypeSearchUtil {

	public static OrderByComparator getPmlEdmDocumentRecordTypeOrderByComparator(
			String orderByCol, String orderByType) {
		
		boolean orderByAsc = false;

		if (orderByType.equals("asc")) {
			orderByAsc = true;
		}

		OrderByComparator orderByComparator = null;

		if (orderByCol.equals("ten-loai-so-cong-van")) {
			orderByComparator = new PmlEdmDocumentRecordTypeNameComparator(orderByAsc);
		} else if (orderByCol.equals("recordtype.code")) {
			orderByComparator = new PmlEdmDocumentRecordTypeCodeComparator(orderByAsc);
		}

		return orderByComparator;
	}

}
