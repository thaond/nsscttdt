package com.nss.portlet.nss_don_vi_thu_tuc.util;

import com.liferay.portal.kernel.util.OrderByComparator;

public class DonViThuTucSearchUtil {
	
	public static OrderByComparator getDonViThuTucOrderByComparator(
			String orderByCol, String orderByType) {
		boolean orderByAsc = false;

		if (orderByType.equals("asc")) {
			orderByAsc = true;
		}

		OrderByComparator orderByComparator = null;

		if (orderByCol.equals("tenDonViThuTuc")) {
			orderByComparator = new DonViThuTucTenDonViThuTucComparator(orderByAsc);
		} else {
			orderByComparator = new DonViThuTucTenDonViThuTucComparator(orderByAsc);
		}

		return orderByComparator;
	}
}
