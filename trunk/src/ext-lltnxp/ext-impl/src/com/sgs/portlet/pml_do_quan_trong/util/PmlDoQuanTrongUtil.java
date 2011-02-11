package com.sgs.portlet.pml_do_quan_trong.util;


import com.liferay.portal.kernel.util.OrderByComparator;

import com.sgs.portlet.pml_do_quan_trong.util.comparator.PmlDoQuanTrongTenDoQuanTrongComparator;

/**
 * <a href="PmlDoQuanTrongUtil.java.html"><b><i>View Source</i></b></a>
 *
 * @author Hai Trieu
 * 
 */
public class PmlDoQuanTrongUtil {

	public static OrderByComparator getPmlDoQuanTrongOrderByComparator(
		String orderByCol, String orderByType) {

		boolean orderByAsc = false;

		if (orderByType.equals("asc")) {
			orderByAsc = true;
		}

		OrderByComparator orderByComparator = null;

		if (orderByCol.equals("ten-do-quan-trong")) {
			orderByComparator = new PmlDoQuanTrongTenDoQuanTrongComparator(orderByAsc);
		}

		return orderByComparator;
	}
}