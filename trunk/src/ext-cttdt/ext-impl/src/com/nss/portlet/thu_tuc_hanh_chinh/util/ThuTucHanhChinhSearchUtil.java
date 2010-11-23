package com.nss.portlet.thu_tuc_hanh_chinh.util;

import com.liferay.portal.kernel.util.OrderByComparator;

public class ThuTucHanhChinhSearchUtil {
	public static OrderByComparator getThuTucHanhChinhOrderByComparator(
			String orderByCol, String orderByType) {
		boolean orderByAsc = false;

		if (orderByType.equals("asc")) {
			orderByAsc = true;
		}

		OrderByComparator orderByComparator = null;

		if (orderByCol.equals("tenThuTucHanhChinh")) {
			orderByComparator = new TenThuTucHanhChinhComparator(orderByAsc);
		} else {
			orderByComparator = new TenThuTucHanhChinhComparator(orderByAsc);
		}

		return orderByComparator;
	}
}
