package com.nss.portlet.phone_book.util;

import com.liferay.portal.kernel.util.OrderByComparator;
import com.nss.portlet.phone_book.model.ContactBook;
import com.nss.portlet.phone_book.model.DetailBook;

public class DetailBookDescriptionComparator extends OrderByComparator {

	public static String ORDER_BY_ASC = "detailDescription ASC";

	public static String ORDER_BY_DESC = "detailDescription DESC";
	
	public DetailBookDescriptionComparator() {
		this(false);
	}

	public DetailBookDescriptionComparator(boolean asc) {
		_asc = asc;
	}

	@Override
	public int compare(Object cb1, Object cb2) {
		DetailBook detailBook1 = (DetailBook) cb1;
		DetailBook detailBook2 = (DetailBook) cb2;
		
		int value = detailBook1.getDetailDescription().compareTo(detailBook2.getDetailDescription());
		
		if (_asc) {
			return value;
		}
		else {
			return -value;
		}
	}
	public String getOrderBy() {
		if (_asc) {
			return ORDER_BY_ASC;
		}
		else {
			return ORDER_BY_DESC;
		}
	}

	private boolean _asc;

}
