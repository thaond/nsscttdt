package com.nss.portlet.link.util;

import com.liferay.portal.kernel.util.OrderByComparator;
import com.nss.portlet.link.model.LienKetWebsite;

public class LienKetWebsiteThuTuWebsiteComparator extends OrderByComparator{
	public static String ORDER_BY_ASC = "thu_tu_website ASC";
	public static String ORDER_BY_DESC = "thu_tu_website DESC";
	
	private boolean _asc;
	
	public LienKetWebsiteThuTuWebsiteComparator(){
		this(false);
	}
	
	public LienKetWebsiteThuTuWebsiteComparator(boolean asc){
		this._asc = asc;
	}
	
	public int compare(Object arg0, Object arg1) {
		LienKetWebsite lienKetWebsite1 = (LienKetWebsite)arg0;
		LienKetWebsite lienKetWebsite2 = (LienKetWebsite)arg1;
		
		int value = lienKetWebsite1.getThuTuWebsite()- lienKetWebsite2.getThuTuWebsite();
		
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
