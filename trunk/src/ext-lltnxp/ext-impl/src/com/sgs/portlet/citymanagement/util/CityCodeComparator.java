package com.sgs.portlet.citymanagement.util;

import com.liferay.portal.kernel.util.OrderByComparator;
import com.sgs.portlet.citymanagement.model.City;

public class CityCodeComparator extends OrderByComparator{
	public static String ORDER_BY_ASC = "pml_city.citycode ASC";
	public static String ORDER_BY_DESC = "pml_city.citycode DESC";
	
	private boolean _asc;
	
	public CityCodeComparator(){
		this(false);
	}
	
	public CityCodeComparator(boolean asc){
		this._asc = asc;
	}
	
	public int compare(Object arg0, Object arg1) {
		City cityCode1 = (City)arg0;
		City cityCode2 = (City)arg1;
		
		int value = cityCode1.getCityCode().compareTo(cityCode2.getCityCode());
		
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
