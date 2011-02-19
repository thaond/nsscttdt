package com.sgs.portlet.sovanbannoibo.util;

import com.liferay.portal.kernel.util.OrderByComparator;
import com.sgs.portlet.sovanbannoibo.model.SoVanBanNoiBo;

public class MaSoVanBanNoiBoComparator extends OrderByComparator {

	private static final long serialVersionUID = 1L;

	public static String ORDER_BY_ASC = "maSoVanBanNoiBo ASC";

	public static String ORDER_BY_DESC = "maSoVanBanNoiBo DESC";

	private boolean _asc;

	public MaSoVanBanNoiBoComparator() {
		this(false);
	}

	public MaSoVanBanNoiBoComparator(boolean asc) {
		this._asc = asc;
	}

	public int compare(Object o1, Object o2) {
		SoVanBanNoiBo s1 = (SoVanBanNoiBo) o1;
		SoVanBanNoiBo s2 = (SoVanBanNoiBo) o2;

		int value = s1.getMaSoVanBanNoiBo().compareTo(s2.getMaSoVanBanNoiBo());

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
