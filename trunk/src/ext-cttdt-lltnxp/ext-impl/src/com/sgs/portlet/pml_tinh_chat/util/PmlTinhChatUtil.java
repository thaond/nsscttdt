package com.sgs.portlet.pml_tinh_chat.util;


import com.liferay.portal.kernel.util.OrderByComparator;

import com.sgs.portlet.pml_tinh_chat.util.comparator.PmlTinhChatTenTinhChatComparator;

/**
 * <a href="PmlTinhChatUtil.java.html"><b><i>View Source</i></b></a>
 *
 * @author Hai Trieu
 * 
 */
public class PmlTinhChatUtil {

	public static OrderByComparator getPmlTinhChatOrderByComparator(
		String orderByCol, String orderByType) {

		boolean orderByAsc = false;

		if (orderByType.equals("asc")) {
			orderByAsc = true;
		}

		OrderByComparator orderByComparator = null;

		if (orderByCol.equals("ten-tinh-chat")) {
			orderByComparator = new PmlTinhChatTenTinhChatComparator(orderByAsc);
		}

		return orderByComparator;
	}
}