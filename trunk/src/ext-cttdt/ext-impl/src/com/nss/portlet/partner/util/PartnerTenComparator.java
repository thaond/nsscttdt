package com.nss.portlet.partner.util;

import com.liferay.portal.kernel.util.OrderByComparator;
import com.nss.portlet.partner.model.Partner;

public class PartnerTenComparator extends OrderByComparator {

	public static String ORDER_BY_ASC = "ten_partner ASC";
	public static String ORDER_BY_DESC = "ten_partner DESC";
	
	private boolean _asc;
	
	public PartnerTenComparator(){
		this(false);
	}
	
	public PartnerTenComparator(boolean asc){
		this._asc = asc;
	}
	
	public int compare(Object arg0, Object arg1) {
		Partner partner1 = (Partner)arg0;
		Partner partner2 = (Partner)arg1;
		
		int value = partner1.getTenPartner().compareTo(partner2.getTenPartner());
		
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
