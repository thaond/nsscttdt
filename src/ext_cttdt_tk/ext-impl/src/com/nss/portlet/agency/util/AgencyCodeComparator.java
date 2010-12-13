package com.nss.portlet.agency.util;

import com.liferay.portal.kernel.util.OrderByComparator;
import com.nss.portlet.agency.model.Agency;

public class AgencyCodeComparator extends OrderByComparator{
	public static String ORDER_BY_ASC = "pml_agency.agencycode ASC";

	public static String ORDER_BY_DESC = "pml_agency.agencycode DESC";
	
	private boolean _asc;
	
	public AgencyCodeComparator(){
		this(false);
	}
	
	public AgencyCodeComparator(boolean asc){
		this._asc = asc;
	}
	
	public int compare(Object arg0, Object arg1) {
		Agency agencyCode1 = (Agency)arg0;
		Agency agencyCode2 = (Agency)arg1;
		
		int value = agencyCode1.getAgencyCode().compareTo(agencyCode2.getAgencyCode());
		
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
