package com.sgs.portlet.document_manager.util;

import com.liferay.portal.kernel.util.OrderByComparator;

public class DocumentManagerSearchUtil {

	public static OrderByComparator getDocumentManagerOrderByComparator(String orderByCol, String orderByType) {
		boolean orderByAsc = false;

		if (orderByType.equals("asc")) {
			orderByAsc = true;
		}

		OrderByComparator orderByComparator = null;

		if (orderByCol.equals("documentManagerCode")) {
			orderByComparator = new DocumentManagerCodeComparator(orderByAsc);
		} else if (orderByCol.equals("documentManagerDescription")) {
			orderByComparator = new DocumentManagerDescriptionComparator(orderByAsc);
		} else if (orderByCol.equals("documentManagerTitle")) {
			orderByComparator = new DocumentManagerTitleComparator(orderByAsc);
		}

		return orderByComparator;
	}
}
