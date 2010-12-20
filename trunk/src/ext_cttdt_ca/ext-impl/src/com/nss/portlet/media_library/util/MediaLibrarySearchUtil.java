package com.nss.portlet.media_library.util;

import com.liferay.portal.kernel.util.OrderByComparator;

public class MediaLibrarySearchUtil {
	public static OrderByComparator getMediaLibraryOrderByComparator(
			String orderByCol, String orderByType) {
		boolean orderByAsc = false;

		if (orderByType.equals("asc")) {
			orderByAsc = true;
		}

		OrderByComparator orderByComparator = null;

		if (orderByCol.equals("tenMediaLibrary")) {
			orderByComparator = new TenMediaLibraryComparator(orderByAsc);
		//} else if (orderByCol.equals("tenMediaChuDe")) {
		//	orderByComparator = new MediaChuDeComparator(orderByAsc);
		} 
//		else {
//			orderByComparator = new MediaChuDeComparator(orderByAsc);
//		}

		return orderByComparator;
	}
}
