package com.nss.portlet.linh_vuc_thu_tuc.util;

import com.liferay.portal.kernel.util.OrderByComparator;

public class LinhVucThuTucHanhChinhSearchUtil {
	
	public static OrderByComparator getLinhVucThuTucHanhChinhOrderByComparator(
			String orderByCol, String orderByType) {
		boolean orderByAsc = false;

		if (orderByType.equals("asc")) {
			orderByAsc = true;
		}

		OrderByComparator orderByComparator = null;

		if (orderByCol.equals("tenLinhVucThuTucHanhChinh")) {
			orderByComparator = new TenLinhVucThuTucHanhChinhComparator(orderByAsc);
		} else {
			orderByComparator = new TenLinhVucThuTucHanhChinhComparator(orderByAsc);
		}

		return orderByComparator;
	}
}
