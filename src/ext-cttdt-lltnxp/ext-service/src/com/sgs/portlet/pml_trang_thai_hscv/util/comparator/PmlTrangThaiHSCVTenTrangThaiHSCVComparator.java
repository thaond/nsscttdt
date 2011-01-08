package com.sgs.portlet.pml_trang_thai_hscv.util.comparator;

import com.liferay.portal.kernel.util.OrderByComparator;
import com.sgs.portlet.pml_trang_thai_hscv.model.PmlTrangThaiHSCV;
/**
 * <a href="PmlTrangThaiHSCVTenTrangThaiHSCVComparator.java.html"><b><i>View Source</i></b></a>
 *
 * @author Hai Trieu
 *
 */
public class PmlTrangThaiHSCVTenTrangThaiHSCVComparator extends OrderByComparator {

	public static String ORDER_BY_ASC = "ten_trang_thai_hscv ASC";
	public static String ORDER_BY_DESC = "ten_trang_thai_hscv DESC";

	public PmlTrangThaiHSCVTenTrangThaiHSCVComparator() {
		this(false);
	}

	public PmlTrangThaiHSCVTenTrangThaiHSCVComparator(boolean asc) {
		_asc = asc;
	}

	public int compare(Object obj1, Object obj2) {
		PmlTrangThaiHSCV pmlTrangThaiHSCV1 = (PmlTrangThaiHSCV)obj1;
		PmlTrangThaiHSCV pmlTrangThaiHSCV2 = (PmlTrangThaiHSCV)obj2;

		int value = pmlTrangThaiHSCV1.getTenTrangThaiHSCV().toLowerCase().compareTo(
				pmlTrangThaiHSCV2.getTenTrangThaiHSCV().toLowerCase());

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