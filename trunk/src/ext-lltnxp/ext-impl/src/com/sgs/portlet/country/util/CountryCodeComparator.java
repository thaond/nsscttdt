package com.sgs.portlet.country.util;

import com.liferay.portal.kernel.util.OrderByComparator;
import com.sgs.portlet.country.model.Country;

@SuppressWarnings("serial")
public class CountryCodeComparator extends OrderByComparator {
	public static String ORDER_BY_ASC = "pml_country.countrycode ASC";

	public static String ORDER_BY_DESC = "pml_country.countrycode DESC";
	
	private boolean _asc;
	
	public CountryCodeComparator(){
		this(false);
	}
	
	public CountryCodeComparator(boolean asc){
		this._asc = asc;
	}
	
	public int compare(Object arg0, Object arg1) {
		Country country1 = (Country)arg0;
		Country country2 = (Country)arg1;
		
		int value = country1.getCountryCode().compareTo(country2.getCountryCode());
		
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
