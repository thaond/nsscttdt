package com.sgs.portlet.sovanbannoibo.util;

import com.liferay.portal.kernel.util.OrderByComparator;

public class LoaiVanBanNoiBoSearchUtil {

	public static OrderByComparator getLoaiVanBanNoiBoOrderByComparator(
			String orderByCol, String orderByType) {
		boolean orderByAsc = false;

		if (orderByType.equals("asc")) {
			orderByAsc = true;
		}

		OrderByComparator orderByComparator = null;

		if (orderByCol.equals("kyHieuLoaiVanBanNoiBo")) {
			orderByComparator = new KyHieuLoaiVanBanNoiBoComparator(orderByAsc);
		} else if (orderByCol.equals("tenLoaiVanBanNoiBo")) {
			orderByComparator = new TenLoaiVanBanNoiBoComparator(orderByAsc);
		} 

		return orderByComparator;
	}
}
