package com.nss.portlet.media_library.util;

import com.liferay.portal.kernel.util.OrderByComparator;
import com.nss.portlet.media_library.model.MediaLibrary;

public class TenMediaLibraryComparator extends OrderByComparator {
	public static String ORDER_BY_ASC = "nss_media_library.tenmedialibrary ASC";
	public static String ORDER_BY_DESC = "nss_media_library.tenmedialibrary DESC";
	
	private boolean _asc;
	
	public TenMediaLibraryComparator(){
		this(false);
	}
	
	public TenMediaLibraryComparator(boolean asc){
		this._asc = asc;
	}
	
	public int compare(Object arg0, Object arg1) {
		MediaLibrary mediaLibrary1 = (MediaLibrary)arg0;
		MediaLibrary mediaLibrary2 = (MediaLibrary)arg1;
		
		int value = mediaLibrary1.getTenMediaLibrary().compareTo(mediaLibrary2.getTenMediaLibrary());
		
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
