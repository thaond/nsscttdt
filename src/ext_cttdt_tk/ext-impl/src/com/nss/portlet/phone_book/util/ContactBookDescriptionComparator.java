package com.nss.portlet.phone_book.util;

import com.liferay.portal.kernel.util.OrderByComparator;
import com.nss.portlet.phone_book.model.ContactBook;

public class ContactBookDescriptionComparator extends OrderByComparator {

	public static String ORDER_BY_ASC = "contactDescription ASC";

	public static String ORDER_BY_DESC = "contactDescription DESC";
	
	public ContactBookDescriptionComparator() {
		this(false);
	}

	public ContactBookDescriptionComparator(boolean asc) {
		_asc = asc;
	}

	@Override
	public int compare(Object cb1, Object cb2) {
		ContactBook contactBook1 = (ContactBook) cb1;
		ContactBook contactBook2 = (ContactBook) cb2;
		
		int value = contactBook1.getContactDescription().compareTo(contactBook2.getContactDescription());
		
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
