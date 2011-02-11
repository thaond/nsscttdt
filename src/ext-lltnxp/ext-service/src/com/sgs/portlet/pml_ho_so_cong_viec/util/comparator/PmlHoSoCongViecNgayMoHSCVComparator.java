package com.sgs.portlet.pml_ho_so_cong_viec.util.comparator;

import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec;

/**
 * <a href="PmlHoSoCongViecNgayMoHSCVComparator.java.html"><b><i>View Source</i></b></a>
 *
 * @author XUANCONG
 *
 */
public class PmlHoSoCongViecNgayMoHSCVComparator extends OrderByComparator {

	public static String ORDER_BY_ASC = "ngay_mo_hscv ASC";

	public static String ORDER_BY_DESC = "ngay_mo_hscv DESC";

	public PmlHoSoCongViecNgayMoHSCVComparator() {
		this(false);
	}

	public PmlHoSoCongViecNgayMoHSCVComparator(boolean asc) {
		_asc = asc;
	}

	public int compare(Object obj1, Object obj2) {
		PmlHoSoCongViec pmlHoSoCongViec1 = (PmlHoSoCongViec)obj1;
		PmlHoSoCongViec pmlHoSoCongViec2 = (PmlHoSoCongViec)obj2;

		int value = DateUtil.compareTo(
			pmlHoSoCongViec1.getNgayMoHSCV(), pmlHoSoCongViec2.getNgayMoHSCV());

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