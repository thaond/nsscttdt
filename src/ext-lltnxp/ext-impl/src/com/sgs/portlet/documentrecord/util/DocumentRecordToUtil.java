package com.sgs.portlet.documentrecord.util;

import com.liferay.portal.kernel.util.OrderByComparator;

public class DocumentRecordToUtil {
	public static OrderByComparator getDocumentRecordToOrderByComparator(
			String orderByCol, String orderByType) {
		boolean orderByAsc = false;

		if (orderByType.equals("asc")) {
			orderByAsc = true;
		}

		OrderByComparator orderByComparator = null;

		if (orderByCol.equals("loaiSoCV")) {
			orderByComparator = new DocumentTypeNameComparator(orderByAsc);
		} else if (orderByCol.equals("agency")) {
			orderByComparator = new AgencyNameComparator(orderByAsc);
		} else if (orderByCol.equals("department")){
			orderByComparator = new DepartmentNameComparator(orderByAsc);
		}

		return orderByComparator;
	}
}
