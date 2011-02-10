package com.sgs.portlet.document_manager.util;

import com.liferay.portal.kernel.util.OrderByComparator;
import com.sgs.portlet.document_manager.model.DocumentManager;

public class DocumentManagerCategoryComparator extends OrderByComparator {

	private static final long serialVersionUID = 1L;

	public static String ORDER_BY_ASC = "documentManagerCategory ASC";

	public static String ORDER_BY_DESC = "documentManagerCategory DESC";

	private boolean _asc;

	public DocumentManagerCategoryComparator() {
		this(false);
	}

	public DocumentManagerCategoryComparator(boolean asc) {
		this._asc = asc;
	}

	public int compare(Object o1, Object o2) {
		DocumentManager dm1 = (DocumentManager) o1;
		DocumentManager dm2 = (DocumentManager) o2;

		int value = dm1.getDocumentManagerCategory().compareTo(dm2.getDocumentManagerCategory());

		if (this._asc) {
			return value;
		} else {
			return -value;
		}
	}

	public String getOrderBy() {
		if (_asc) {
			return ORDER_BY_ASC;
		} else {
			return ORDER_BY_DESC;
		}
	}
}
