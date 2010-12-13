package com.nss.portlet.van_ban_phap_quy.util;

import com.liferay.portal.kernel.util.OrderByComparator;
import com.nss.portlet.van_ban_phap_quy.model.VanBanPhapQuy;

public class VanBanPhapQuyKyHieuVanBanComparator extends OrderByComparator {
	public static String ORDER_BY_ASC = "ky_hieu_van_ban ASC";

	public static String ORDER_BY_DESC = "ky_hieu_van_ban DESC";

	public VanBanPhapQuyKyHieuVanBanComparator() {
		this(false);
	}

	public VanBanPhapQuyKyHieuVanBanComparator(boolean asc) {
		_asc = asc;
	}

	public int compare(Object obj1, Object obj2) {
		VanBanPhapQuy v1 = (VanBanPhapQuy)obj1;
		VanBanPhapQuy v2 = (VanBanPhapQuy)obj2;

		int value = v1.getKyHieuVanBan().compareTo( v2.getKyHieuVanBan());

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
