package com.sgs.portlet.sovanbannoibo.util;

import com.liferay.portal.kernel.util.OrderByComparator;
import com.sgs.portlet.department.model.Department;

public class MaPhongBanComparator extends OrderByComparator {

	private static final long serialVersionUID = 1L;

	public static String ORDER_BY_ASC = "departmentsCode ASC";

	public static String ORDER_BY_DESC = "departmentsCode DESC";

	private boolean _asc;

	public MaPhongBanComparator() {
		this(false);
	}

	public MaPhongBanComparator(boolean asc) {
		this._asc = asc;
	}

	public int compare(Object o1, Object o2) {
		Department d1 = (Department) o1;
		Department d2 = (Department) o2;

		int value = d1.getDepartmentsCode().compareTo(d2.getDepartmentsCode());

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
