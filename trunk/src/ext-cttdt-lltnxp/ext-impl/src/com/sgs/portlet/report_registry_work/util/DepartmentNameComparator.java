package com.sgs.portlet.report_registry_work.util;

import com.liferay.portal.kernel.util.OrderByComparator;
import com.sgs.portlet.report_registry_work.model.Department;

public class DepartmentNameComparator extends OrderByComparator {

	private static final long serialVersionUID = 1L;

	public static String ORDER_BY_ASC = "departmentName ASC";

	public static String ORDER_BY_DESC = "departmentName DESC";

	private boolean _asc;

	public DepartmentNameComparator() {
		this(false);
	}

	public DepartmentNameComparator(boolean asc) {
		this._asc = asc;
	}

	public int compare(Object o1, Object o2) {
		Department department1 = (Department) o1;
		Department department2 = (Department) o2;

		int value = department1.getDepartmentName().compareTo(department2.getDepartmentName());

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
