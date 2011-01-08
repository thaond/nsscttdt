package com.sgs.portlet.deleteprocessinstance.util;

import com.liferay.portal.kernel.util.OrderByComparator;

public class DocumentSendUnpublishUtil {
	public static OrderByComparator getDocumentSendOrderByComparator(
			String orderByCol, String orderByType) {
		boolean orderByAsc = false;

		if (orderByType.equals("asc")) {
			orderByAsc = true;
		}

		OrderByComparator orderByComparator = null;

		if (orderByCol.equals("nguoiKy")) {
			orderByComparator = new DocumentSendSignerNameComparator(orderByAsc);
		} else if (orderByCol.equals("loaiVB")) {
			orderByComparator = new DocumentTypeComparator(orderByAsc);
		} else {
			orderByComparator = new DocumentSendSignerNameComparator(orderByAsc);
		}

		return orderByComparator;
	}
}
