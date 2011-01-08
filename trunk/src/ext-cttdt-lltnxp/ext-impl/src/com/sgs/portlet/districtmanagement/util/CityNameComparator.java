package com.sgs.portlet.districtmanagement.util;

import com.liferay.portal.kernel.util.OrderByComparator;
import com.sgs.portlet.citymanagement.model.City;

public class CityNameComparator extends OrderByComparator{
	public static String ORDER_BY_ASC = "pml_city.cityname ASC";
	public static String ORDER_BY_DESC = "pml_city.cityname DESC";
	
	private boolean _asc;
	
	public CityNameComparator(){
		this(false);
	}
	
	public CityNameComparator(boolean asc){
		this._asc = asc;
	}
	
	public int compare(Object arg0, Object arg1) {
		City city1 = (City)arg0;
		City city2 = (City)arg1;
		
		int value = city1.getCityName().compareTo(city2.getCityName());
		
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
