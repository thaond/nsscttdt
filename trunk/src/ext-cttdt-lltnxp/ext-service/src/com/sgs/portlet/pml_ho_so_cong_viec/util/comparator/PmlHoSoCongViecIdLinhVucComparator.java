package com.sgs.portlet.pml_ho_so_cong_viec.util.comparator;

import com.liferay.portal.kernel.util.OrderByComparator;
import com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec;

/**
 * <a href="PmlHoSoCongViecIdLinhVucComparator.java.html"><b><i>View Source</i></b></a>
 *
 * @author XUANCONG
 *
 */
public class PmlHoSoCongViecIdLinhVucComparator extends OrderByComparator {

	public static String ORDER_BY_ASC = "id_linh_vuc ASC";

	public static String ORDER_BY_DESC = "id_linh_vuc DESC";

	public PmlHoSoCongViecIdLinhVucComparator() {
		this(false);
	}

	public PmlHoSoCongViecIdLinhVucComparator(boolean asc) {
		_asc = asc;
	}

	public int compare(Object obj1, Object obj2) {
		PmlHoSoCongViec pmlHoSoCongViec1 = (PmlHoSoCongViec)obj1;
		PmlHoSoCongViec pmlHoSoCongViec2 = (PmlHoSoCongViec)obj2;

		
		int value = pmlHoSoCongViec1.getIdLinhVuc().toLowerCase().compareTo(
				pmlHoSoCongViec2.getIdLinhVuc().toLowerCase());

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