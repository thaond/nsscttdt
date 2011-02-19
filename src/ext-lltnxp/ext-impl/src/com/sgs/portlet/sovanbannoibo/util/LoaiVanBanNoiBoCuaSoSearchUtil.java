package com.sgs.portlet.sovanbannoibo.util;

import com.liferay.portal.kernel.util.OrderByComparator;

public class LoaiVanBanNoiBoCuaSoSearchUtil {

	public static OrderByComparator getLoaiVanBanNoiBoOrderByComparator(
			String orderByCol, String orderByType) {
		boolean orderByAsc = false;

		if (orderByType.equals("asc")) {
			orderByAsc = true;
		}

		OrderByComparator orderByComparator = null;

		if (orderByCol.equals("kyHieuLoaiVanBanNoiBo")) {
			orderByComparator = new KyHieuLoaiVanBanNoiBoCuaSoComparator(orderByAsc);
		} else if (orderByCol.equals("tenLoaiVanBanNoiBo")) {
			orderByComparator = new TenLoaiVanBanNoiBoCuaSoComparator(orderByAsc);
		} 

		return orderByComparator;
	}
}
