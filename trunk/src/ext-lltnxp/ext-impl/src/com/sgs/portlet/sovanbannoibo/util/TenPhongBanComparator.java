package com.sgs.portlet.sovanbannoibo.util;

import com.liferay.portal.kernel.util.OrderByComparator;
import com.sgs.portlet.department.model.Department;

public class TenPhongBanComparator extends OrderByComparator {

	private static final long serialVersionUID = 1L;

	public static String ORDER_BY_ASC = "departmentsName ASC";

	public static String ORDER_BY_DESC = "departmentsName DESC";

	private boolean _asc;

	public TenPhongBanComparator() {
		this(false);
	}

	public TenPhongBanComparator(boolean asc) {
		this._asc = asc;
	}

	public int compare(Object o1, Object o2) {
		Department d1 = (Department) o1;
		Department d2 = (Department) o2;

		int value = d1.getDepartmentsName().compareTo(d2.getDepartmentsName());

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
