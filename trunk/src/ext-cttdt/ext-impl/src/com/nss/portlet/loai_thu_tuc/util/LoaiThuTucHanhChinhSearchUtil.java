package com.nss.portlet.loai_thu_tuc.util;

import com.liferay.portal.kernel.util.OrderByComparator;

public class LoaiThuTucHanhChinhSearchUtil {
	public static OrderByComparator getLoaiThuTucHanhChinhOrderByComparator(
			String orderByCol, String orderByType) {
		boolean orderByAsc = false;

		if (orderByType.equals("asc")) {
			orderByAsc = true;
		}

		OrderByComparator orderByComparator = null;

		if (orderByCol.equals("tenLoaiThuTucHanhChinh")) {
			orderByComparator = new TenLoaiThuTucHanhChinhComparator(orderByAsc);
		} else {
			orderByComparator = new TenLoaiThuTucHanhChinhComparator(orderByAsc);
		}

		return orderByComparator;
	}
}
