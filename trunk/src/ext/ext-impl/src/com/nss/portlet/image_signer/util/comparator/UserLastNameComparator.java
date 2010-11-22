package com.nss.portlet.image_signer.util.comparator;

import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.model.User;

public class UserLastNameComparator extends OrderByComparator{
	private boolean _asc;
	public static String ORDER_BY_ASC = "lastname ASC";
	public static String ORDER_BY_DESC = "lastname DESC";

	public UserLastNameComparator() {
		this(false);
	}

	public UserLastNameComparator(boolean asc) {
		_asc = asc;
	}

	@Override
	public int compare(Object arg0, Object arg1) {
		User user1 = (User) arg0;
		User user2 = (User) arg1;

		int value = user1.getLastName().toLowerCase()
				.compareTo(user2.getLastName().toLowerCase());

		if (_asc) {
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
