package com.sgs.portlet.document_manager.util;

import com.liferay.portal.kernel.util.OrderByComparator;
import com.sgs.portlet.document_manager.model.DocumentManager;

public class DocumentManagerCodeComparator extends OrderByComparator {

	private static final long serialVersionUID = 1L;

	public static String ORDER_BY_ASC = "documentManagerCode ASC";

	public static String ORDER_BY_DESC = "documentManagerCode DESC";

	private boolean _asc;

	public DocumentManagerCodeComparator() {
		this(false);
	}

	public DocumentManagerCodeComparator(boolean asc) {
		this._asc = asc;
	}

	public int compare(Object o1, Object o2) {
		DocumentManager dm1 = (DocumentManager) o1;
		DocumentManager dm2 = (DocumentManager) o2;

		int value = dm1.getDocumentManagerCode().compareTo(dm2.getDocumentManagerCode());

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
