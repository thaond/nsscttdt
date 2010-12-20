package com.nss.portlet.media_library.util;

import com.liferay.portal.kernel.util.OrderByComparator;
import com.nss.portlet.media_chu_de.model.MediaChuDe;

public class MediaChuDeComparator extends OrderByComparator{
	public static String ORDER_BY_ASC = "nss_media_chu_de.tenmediachude ASC";
	public static String ORDER_BY_DESC = "nss_media_chu_de.tenmediachude DESC";
	
	private boolean _asc;
	
	public MediaChuDeComparator(){
		this(false);
	}
	
	public MediaChuDeComparator(boolean asc){
		this._asc = asc;
	}
	
	public int compare(Object arg0, Object arg1) {
		MediaChuDe mediaChuDe1 = (MediaChuDe)arg0;
		MediaChuDe mediaChuDe2 = (MediaChuDe)arg1;
		
		int value = mediaChuDe1.getTenMediaChuDe().compareTo(mediaChuDe2.getTenMediaChuDe());
		
		if(this._asc){
			return value;
		}else{
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

}
