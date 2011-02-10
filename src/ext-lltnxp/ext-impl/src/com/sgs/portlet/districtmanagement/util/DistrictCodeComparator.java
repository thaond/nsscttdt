package com.sgs.portlet.districtmanagement.util;

import com.liferay.portal.kernel.util.OrderByComparator;
import com.sgs.portlet.districtmanagement.model.District;

public class DistrictCodeComparator  extends OrderByComparator{
	public static String ORDER_BY_ASC = "pml_district.districtcode ASC";
	public static String ORDER_BY_DESC = "pml_district.districtcode DESC";
	
	private boolean _asc;
	
	public DistrictCodeComparator(){
		this(false);
	}
	
	public DistrictCodeComparator(boolean asc){
		this._asc = asc;
	}
	
	public int compare(Object arg0, Object arg1) {
		District district1 = (District)arg0;
		District district2 = (District)arg1;
		
		int value = district1.getDistrictCode().compareTo(district2.getDistrictCode());
		
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
