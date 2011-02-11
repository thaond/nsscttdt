package com.sgs.portlet.pmlstreet.util;

import com.liferay.portal.kernel.util.OrderByComparator;
import com.sgs.portlet.pmlstreet.model.PmlStreet;

@SuppressWarnings("serial")
public class StreetNameComparator extends OrderByComparator{
	public static final String ORDER_BY_ASC = "streetname ASC";
	public static final String ORDER_BY_DESC ="streetname DESC";

	public StreetNameComparator(){
		this(false);
	}
	
	public StreetNameComparator(boolean asc){
		this._asc = asc;
	}
	
	public int compare(Object arg0, Object arg1) {
		PmlStreet street1 = (PmlStreet)arg0;
		PmlStreet street2 = (PmlStreet)arg1;
		int value = street1.getStreetName().compareTo(street2.getStreetName());
		if(_asc){
			return value;
		}else{
			return -value;
		}
	}
	
	public String getOrderBy(){
		if(_asc){
			return ORDER_BY_ASC;
		}else{
			return ORDER_BY_DESC;
		}
	}
	
	private boolean _asc;
}
