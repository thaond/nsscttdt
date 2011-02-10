package com.sgs.portlet.documentrecord.util;

import com.liferay.portal.kernel.util.OrderByComparator;
import com.sgs.portlet.agency.model.Agency;

public class AgencyNameComparator extends OrderByComparator{
	public static String ORDER_BY_ASC = "pml_agency.agencyname ASC";

	public static String ORDER_BY_DESC = "pml_agency.agencyname DESC";
	
	private boolean _asc;
	
	public AgencyNameComparator(){
		this(false);
	}
	
	public AgencyNameComparator(boolean asc){
		this._asc = asc;
	}
	
	public int compare(Object arg0, Object arg1) {
		Agency agencyCode1 = (Agency)arg0;
		Agency agencyCode2 = (Agency)arg1;
		
		int value = agencyCode1.getAgencyName().compareTo(agencyCode2.getAgencyName());
		
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
