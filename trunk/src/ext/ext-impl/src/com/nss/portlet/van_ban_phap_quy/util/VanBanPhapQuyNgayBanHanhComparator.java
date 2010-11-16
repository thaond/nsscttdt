package com.nss.portlet.van_ban_phap_quy.util;

import com.liferay.portal.kernel.util.OrderByComparator;
import com.nss.portlet.van_ban_phap_quy.model.VanBanPhapQuy;

public class VanBanPhapQuyNgayBanHanhComparator extends OrderByComparator{
	public static String ORDER_BY_ASC = "ngay_ban_hanh ASC";

	public static String ORDER_BY_DESC = "ngay_ban_hanh DESC";

	public VanBanPhapQuyNgayBanHanhComparator() {
		this(false);
	}

	public VanBanPhapQuyNgayBanHanhComparator(boolean asc) {
		_asc = asc;
	}

	public int compare(Object obj1, Object obj2) {
		VanBanPhapQuy v1 = (VanBanPhapQuy)obj1;
		VanBanPhapQuy v2 = (VanBanPhapQuy)obj2;

		int value = v1.getNgayBanHanh().compareTo( v2.getNgayBanHanh());

		if (_asc) {
			return value;
		}
		else {
			return -value;
		}
	}

	public String getOrderBy() {
		if (_asc) {
			return ORDER_BY_ASC;
		}
		else {
			return ORDER_BY_DESC;
		}
	}

	private boolean _asc;
}
