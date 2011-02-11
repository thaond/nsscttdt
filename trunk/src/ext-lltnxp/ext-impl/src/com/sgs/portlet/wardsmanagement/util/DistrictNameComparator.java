package com.sgs.portlet.wardsmanagement.util;

import com.liferay.portal.kernel.util.OrderByComparator;
import com.sgs.portlet.districtmanagement.model.District;


public class DistrictNameComparator extends OrderByComparator{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static String ORDER_BY_ASC = "pml_district.districtname ASC";

	public static String ORDER_BY_DESC = "pml_district.districtname DESC";
	
	private boolean _asc;
	
	public DistrictNameComparator(){
		this(false);
	}
	
	public DistrictNameComparator(boolean asc){
		this._asc = asc;
	}
	
	public int compare(Object arg0, Object arg1) {
		District district1 = (District)arg0;
		District district2 = (District)arg1;
		
		int value = district1.getDistrictName().compareTo(district2.getDistrictName());
		
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
