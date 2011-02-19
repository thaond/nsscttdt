package com.sgs.portlet.sovanbannoibo.util;

import com.liferay.portal.kernel.util.OrderByComparator;
import com.sgs.portlet.sovanbannoibo.model.LoaiVanBanNoiBo;

public class KyHieuLoaiVanBanNoiBoCuaSoComparator extends OrderByComparator {

	private static final long serialVersionUID = 1L;

	public static String ORDER_BY_ASC = "kyHieuLoaiVanBanNoiBo ASC";

	public static String ORDER_BY_DESC = "kyHieuLoaiVanBanNoiBo DESC";

	private boolean _asc;

	public KyHieuLoaiVanBanNoiBoCuaSoComparator() {
		this(false);
	}

	public KyHieuLoaiVanBanNoiBoCuaSoComparator(boolean asc) {
		this._asc = asc;
	}

	public int compare(Object o1, Object o2) {
		LoaiVanBanNoiBo v1 = (LoaiVanBanNoiBo) o1;
		LoaiVanBanNoiBo v2 = (LoaiVanBanNoiBo) o2;

		int value = v1.getKyHieuLoaiVanBanNoiBo().compareTo(v2.getKyHieuLoaiVanBanNoiBo());

		if (this._asc) {
			return value;
		} else {
			return -value;
		}
	}

	public String getOrderBy() {
		if (_asc) {
			return ORDER_BY_ASC;
		} else {
			return ORDER_BY_DESC;
		}
	}
}
