package com.sgs.portlet.report_registry_work.util;

import com.liferay.portal.kernel.util.OrderByComparator;
import com.sgs.portlet.report_registry_work.model.ReportRegistry;

public class ReportRegistryCodeComparator extends OrderByComparator {

	private static final long serialVersionUID = 1L;

	public static String ORDER_BY_ASC = "reportRegistryCode ASC";

	public static String ORDER_BY_DESC = "reportRegistryCode DESC";

	private boolean _asc;

	public ReportRegistryCodeComparator() {
		this(false);
	}

	public ReportRegistryCodeComparator(boolean asc) {
		this._asc = asc;
	}

	public int compare(Object o1, Object o2) {
		ReportRegistry reportRegistry1 = (ReportRegistry) o1;
		ReportRegistry reportRegistry2 = (ReportRegistry) o2;

		int value = reportRegistry1.getReportRegistryCode().compareTo(reportRegistry2.getReportRegistryCode());

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
