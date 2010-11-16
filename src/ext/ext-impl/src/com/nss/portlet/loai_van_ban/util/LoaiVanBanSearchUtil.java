package com.nss.portlet.loai_van_ban.util;

import com.liferay.portal.kernel.util.OrderByComparator;

public class LoaiVanBanSearchUtil {
	public static OrderByComparator getLoaiVanBanOrderByComparator(
			String orderByCol, String orderByType) {
		boolean orderByAsc = false;

		if (orderByType.equals("asc")) {
			orderByAsc = true;
		}

		OrderByComparator orderByComparator = null;

		if (orderByCol.equals("tenLoaiVanBan")) {
			orderByComparator = new LoaiVanBanTenLoaiVanBanComparator(orderByAsc);
		} else {
			orderByComparator = new LoaiVanBanTenLoaiVanBanComparator(orderByAsc);
		}

		return orderByComparator;
	}
}
