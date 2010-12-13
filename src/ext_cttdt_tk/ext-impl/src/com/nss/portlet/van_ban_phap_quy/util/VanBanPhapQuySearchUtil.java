package com.nss.portlet.van_ban_phap_quy.util;

import com.liferay.portal.kernel.util.OrderByComparator;

public class VanBanPhapQuySearchUtil {

	public static OrderByComparator getVanBanPhapQuyOrderByComparator(
			String orderByCol, String orderByType) {
		boolean orderByAsc = false;

		if (orderByType.equals("asc")) {
			orderByAsc = true;
		}

		OrderByComparator orderByComparator = null;

		if (orderByCol.equals("kyHieuVanBan")) {
			orderByComparator = new VanBanPhapQuyKyHieuVanBanComparator(orderByAsc);
		} else if (orderByCol.equals("ngayBanHanh")) {
			orderByComparator = new VanBanPhapQuyNgayBanHanhComparator(orderByAsc);
		} else {
			orderByComparator = new VanBanPhapQuyKyHieuVanBanComparator(orderByAsc);
		}

		return orderByComparator;
	}

}
