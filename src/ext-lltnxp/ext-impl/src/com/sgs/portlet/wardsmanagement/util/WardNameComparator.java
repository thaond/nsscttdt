package com.sgs.portlet.wardsmanagement.util;

import com.liferay.portal.kernel.util.OrderByComparator;
import com.sgs.portlet.wardsmanagement.model.Wards;

public class WardNameComparator extends OrderByComparator{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static String ORDER_BY_ASC = "pml_wards.wardsname ASC";

	public static String ORDER_BY_DESC = "pml_wards.wardsname DESC";
	
	private boolean _asc;
	
	public WardNameComparator(){
		this(false);
	}
	
	public WardNameComparator(boolean asc){
		this._asc = asc;
	}
	
	public int compare(Object arg0, Object arg1) {
		Wards wards1 = (Wards)arg0;
		Wards wards2 = (Wards)arg1;
		
		int value = wards1.getWardsName().compareTo(wards2.getWardsName());
		
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
