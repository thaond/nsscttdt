package com.sgs.portlet.pml_trang_thai_hscv.util;


import com.liferay.portal.kernel.util.OrderByComparator;

import com.sgs.portlet.pml_trang_thai_hscv.util.comparator.PmlTrangThaiHSCVTenTrangThaiHSCVComparator;

/**
 * <a href="pmlTrangThaiHSCVUtil.java.html"><b><i>View Source</i></b></a>
 *
 * @author Hai Trieu
 * 
 */
public class PmlTrangThaiHSCVUtil {

	public static OrderByComparator getPmlTrangThaiHSCVOrderByComparator(
		String orderByCol, String orderByType) {

		boolean orderByAsc = false;

		if (orderByType.equals("asc")) {
			orderByAsc = true;
		}

		OrderByComparator orderByComparator = null;

		if (orderByCol.equals("ten-trang-thai-hscv")) {
			orderByComparator = new PmlTrangThaiHSCVTenTrangThaiHSCVComparator(orderByAsc);
		}

		return orderByComparator;
	}
}