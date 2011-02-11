package com.sgs.portlet.report_registry_work.util;

import com.liferay.portal.kernel.util.OrderByComparator;
import com.sgs.portlet.report_registry_work.model.Department;

public class DepartmentCodeComparator extends OrderByComparator {
	private static final long serialVersionUID = 1L;

	public static String ORDER_BY_ASC = "departmentCode ASC";

	public static String ORDER_BY_DESC = "departmentCode DESC";

	private boolean _asc;

	public DepartmentCodeComparator() {
		this(false);
	}

	public DepartmentCodeComparator(boolean asc) {
		this._asc = asc;
	}

	public int compare(Object o1, Object o2) {
		Department department1 = (Department) o1;
		Department department2 = (Department) o2;

		int value = department1.getDepartmentCode().compareTo(department2.getDepartmentCode());

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
