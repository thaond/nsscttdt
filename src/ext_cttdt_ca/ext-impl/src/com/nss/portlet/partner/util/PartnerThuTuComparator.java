package com.nss.portlet.partner.util;

import com.liferay.portal.kernel.util.OrderByComparator;
import com.nss.portlet.partner.model.Partner;

public class PartnerThuTuComparator extends OrderByComparator{
	
	public static String ORDER_BY_ASC = "thu_tu_partner ASC";
	public static String ORDER_BY_DESC = "thu_tu_partner DESC";
	
	private boolean _asc;
	
	public PartnerThuTuComparator(){
		this(false);
	}
	
	public PartnerThuTuComparator(boolean asc){
		this._asc = asc;
	}
	
	public int compare(Object arg0, Object arg1) {
		Partner partner1 = (Partner)arg0;
		Partner partner2 = (Partner)arg1;
		
		int value = partner1.getThuTuPartner() - partner2.getThuTuPartner();
		
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
