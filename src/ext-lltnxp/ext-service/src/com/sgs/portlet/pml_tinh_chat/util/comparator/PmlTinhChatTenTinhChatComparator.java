package com.sgs.portlet.pml_tinh_chat.util.comparator;

import com.liferay.portal.kernel.util.OrderByComparator;
import com.sgs.portlet.pml_tinh_chat.model.PmlTinhChat;
/**
 * <a href="PmlTinhChatTenTinhChatComparator.java.html"><b><i>View Source</i></b></a>
 *
 * @author Hai Trieu
 *
 */
public class PmlTinhChatTenTinhChatComparator extends OrderByComparator {

	public static String ORDER_BY_ASC = "ten_tinh_chat ASC";
	public static String ORDER_BY_DESC = "ten_tinh_chat DESC";

	public PmlTinhChatTenTinhChatComparator() {
		this(false);
	}

	public PmlTinhChatTenTinhChatComparator(boolean asc) {
		_asc = asc;
	}

	public int compare(Object obj1, Object obj2) {
		PmlTinhChat pmlTinhChat1 = (PmlTinhChat)obj1;
		PmlTinhChat pmlTinhChat2 = (PmlTinhChat)obj2;

		int value = pmlTinhChat1.getTenTinhChat().toLowerCase().compareTo(
				pmlTinhChat2.getTenTinhChat().toLowerCase());

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