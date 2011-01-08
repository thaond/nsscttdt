package com.sgs.portlet.generatetemplateid.util;

import com.liferay.portal.kernel.util.OrderByComparator;

public class GenerateTemplateIdUtil {
	public static OrderByComparator getGenerateTemplateIdOrderByComparator(
			String orderByCol, String orderByType) {
		boolean orderByAsc = false;

		if (orderByType.equals("asc")) {
			orderByAsc = true;
		}

		OrderByComparator orderByComparator = null;

		if (orderByCol.equals("code")) {
			orderByComparator = new TemplateCodeComparator(orderByAsc);
		} else if (orderByCol.equals("description")) {
			orderByComparator = new TemplateDesComparator(orderByAsc);
		} else {
			orderByComparator = new TemplateCodeComparator(orderByAsc);
		}
		return orderByComparator;
	}

}
