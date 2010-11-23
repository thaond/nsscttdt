package com.nss.portlet.link.util;

import com.liferay.portal.kernel.util.OrderByComparator;
import com.nss.portlet.link.model.LienKetWebsite;

public class LienKetWebsiteTenWebsiteComparator extends OrderByComparator {
	public static String ORDER_BY_ASC = "ten_website ASC";
	public static String ORDER_BY_DESC = "ten_website DESC";
	
	private boolean _asc;
	
	public LienKetWebsiteTenWebsiteComparator(){
		this(false);
	}
	
	public LienKetWebsiteTenWebsiteComparator(boolean asc){
		this._asc = asc;
	}
	
	public int compare(Object arg0, Object arg1) {
		LienKetWebsite lienKetWebsite1 = (LienKetWebsite)arg0;
		LienKetWebsite lienKetWebsite2 = (LienKetWebsite)arg1;
		
		int value = lienKetWebsite1.getTenWebsite().compareTo(lienKetWebsite2.getTenWebsite());
		
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
