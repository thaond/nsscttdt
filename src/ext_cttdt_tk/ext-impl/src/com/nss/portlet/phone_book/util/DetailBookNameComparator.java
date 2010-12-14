package com.nss.portlet.phone_book.util;

import com.liferay.portal.kernel.util.OrderByComparator;
import com.nss.portlet.phone_book.model.ContactBook;
import com.nss.portlet.phone_book.model.DetailBook;

public class DetailBookNameComparator extends OrderByComparator {

	public static String ORDER_BY_ASC = "detailBookName ASC";

	public static String ORDER_BY_DESC = "detailBookName DESC";
	
	public DetailBookNameComparator() {
		this(false);
	}

	public DetailBookNameComparator(boolean asc) {
		_asc = asc;
	}

	@Override
	public int compare(Object cb1, Object cb2) {
		DetailBook detailBook1 = (DetailBook) cb1;
		DetailBook detailBook2 = (DetailBook) cb2;
		
		int value = detailBook1.getDetailBookName().compareTo(detailBook2.getDetailBookName());
		
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
