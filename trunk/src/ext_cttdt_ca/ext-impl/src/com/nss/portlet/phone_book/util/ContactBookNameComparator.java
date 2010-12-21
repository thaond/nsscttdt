package com.nss.portlet.phone_book.util;

import com.liferay.portal.kernel.util.OrderByComparator;
import com.nss.portlet.phone_book.model.ContactBook;

public class ContactBookNameComparator extends OrderByComparator {

	public static String ORDER_BY_ASC = "contactBookName ASC";
	public static String ORDER_BY_DESC = "contactBookName DESC";
	
	public ContactBookNameComparator() {
		this(false);
	}

	public ContactBookNameComparator(boolean asc) {
		_asc = asc;
	}

	@Override
	public int compare(Object cb1, Object cb2) {
		ContactBook contactBook1 = (ContactBook) cb1;
		ContactBook contactBook2 = (ContactBook) cb2;
		
		int value = contactBook1.getContactBookName().compareTo(contactBook2.getContactBookName());
		
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
