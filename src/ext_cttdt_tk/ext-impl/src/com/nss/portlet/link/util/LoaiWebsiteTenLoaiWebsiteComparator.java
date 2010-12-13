package com.nss.portlet.link.util;

import com.liferay.portal.kernel.util.OrderByComparator;
import com.nss.portlet.link.model.LoaiWebsite;

public class LoaiWebsiteTenLoaiWebsiteComparator extends OrderByComparator{
	public static String ORDER_BY_ASC = "ten_loai_website ASC";
	public static String ORDER_BY_DESC = "ten_loai_website DESC";
	
	private boolean _asc;
	
	public LoaiWebsiteTenLoaiWebsiteComparator(){
		this(false);
	}
	
	public LoaiWebsiteTenLoaiWebsiteComparator(boolean asc){
		this._asc = asc;
	}
	
	public int compare(Object arg0, Object arg1) {
		LoaiWebsite loaiWebsite1 = (LoaiWebsite)arg0;
		LoaiWebsite loaiWebsite2 = (LoaiWebsite)arg1;
		
		int value = loaiWebsite1.getTenLoaiWebsite().compareTo(loaiWebsite2.getTenLoaiWebsite());
		
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
