package com.sgs.portlet.pml_ho_so_cong_viec.util;

import com.liferay.portal.kernel.util.OrderByComparator;
import com.sgs.portlet.pml_ho_so_cong_viec.util.comparator.PmlHoSoCongViecIdLinhVucComparator;
import com.sgs.portlet.pml_ho_so_cong_viec.util.comparator.PmlHoSoCongViecNgayMoHSCVComparator;
import com.sgs.portlet.pml_ho_so_cong_viec.util.comparator.PmlHoSoCongViecSoHieuHSCVComparator;

/**
 * <a href="PmlHoSoCongViecUtil.java.html"><b><i>View Source</i></b></a>
 *
 * @author XUANCONG
 *
 */
public class PmlHoSoCongViecUtil {

	public static OrderByComparator getPmlHoSoCongViecOrderByComparator(
		String orderByCol, String orderByType) {

		boolean orderByAsc = false;

		if (orderByType.equals("asc")) {
			orderByAsc = true;
		}

		OrderByComparator orderByComparator = null;

		if (orderByCol.equals("pml_sohieuhscv")) {
			orderByComparator = new PmlHoSoCongViecSoHieuHSCVComparator(orderByAsc);
		}
		else if (orderByCol.equals("pml_ngaymohscv")) {
			orderByComparator = new PmlHoSoCongViecNgayMoHSCVComparator(orderByAsc);
		}
		else if (orderByCol.equals("pml_linhvuc")) {
			orderByComparator = new PmlHoSoCongViecIdLinhVucComparator(orderByAsc);
		}

		return orderByComparator;
	}
}