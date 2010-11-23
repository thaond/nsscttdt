package com.nss.portlet.linh_vuc_van_ban.util;

import com.liferay.portal.kernel.util.OrderByComparator;

public class LinhVucVanBanSearchUtil {
	public static OrderByComparator getLinhVucVanBanOrderByComparator(
			String orderByCol, String orderByType) {
		boolean orderByAsc = false;

		if (orderByType.equals("asc")) {
			orderByAsc = true;
		}

		OrderByComparator orderByComparator = null;

		if (orderByCol.equals("tenLinhVucVanBan")) {
			orderByComparator = new LinhVucVanBanTenLinhVucVanBanComparator(orderByAsc);
		} else {
			orderByComparator = new LinhVucVanBanTenLinhVucVanBanComparator(orderByAsc);
		}

		return orderByComparator;
	}
}
