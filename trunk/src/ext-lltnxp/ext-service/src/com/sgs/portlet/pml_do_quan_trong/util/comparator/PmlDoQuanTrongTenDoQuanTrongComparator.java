package com.sgs.portlet.pml_do_quan_trong.util.comparator;

import com.liferay.portal.kernel.util.OrderByComparator;
import com.sgs.portlet.pml_do_quan_trong.model.PmlDoQuanTrong;
import com.sgs.portlet.pml_tinh_chat.model.PmlTinhChat;
/**
 * <a href="PmlDoQuanTrongTenDoQuanTrongComparator.java.html"><b><i>View Source</i></b></a>
 *
 * @author Hai Trieu
 *
 */
public class PmlDoQuanTrongTenDoQuanTrongComparator extends OrderByComparator {

	public static String ORDER_BY_ASC = "ten_do_quan_trong ASC";
	public static String ORDER_BY_DESC = "ten_do_quan_trong DESC";

	public PmlDoQuanTrongTenDoQuanTrongComparator() {
		this(false);
	}

	public PmlDoQuanTrongTenDoQuanTrongComparator(boolean asc) {
		_asc = asc;
	}

	public int compare(Object obj1, Object obj2) {
		PmlDoQuanTrong pmlDoQuanTrong1 = (PmlDoQuanTrong)obj1;
		PmlDoQuanTrong pmlDoQuanTrong2 = (PmlDoQuanTrong)obj2;

		int value = pmlDoQuanTrong1.getTenDoQuanTrong().toLowerCase().compareTo(
				pmlDoQuanTrong2.getTenDoQuanTrong().toLowerCase());

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