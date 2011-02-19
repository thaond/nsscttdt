package com.sgs.portlet.sovanbannoibo.util;

import com.liferay.portal.kernel.util.OrderByComparator;

public class SoVanBanNoiBoSearchUtil {

	public static OrderByComparator getSoVanBanNoiBoOrderByComparator(String orderByCol, String orderByType) {
		boolean orderByAsc = false;

		if (orderByType.equals("asc")) {
			orderByAsc = true;
		}

		OrderByComparator orderByComparator = null;

		if (orderByCol.equals("maSoVanBanNoiBo")) {
			orderByComparator = new MaSoVanBanNoiBoComparator(orderByAsc);
		} else if (orderByCol.equals("tenSoVanBanNoiBo")) {
			orderByComparator = new TenSoVanBanNoiBoComparator(orderByAsc);
		} 

		return orderByComparator;
	}

}
