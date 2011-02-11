package com.sgs.portlet.wardsmanagement.util;

import com.liferay.portal.kernel.util.OrderByComparator;
import com.sgs.portlet.wardsmanagement.model.Wards;

public class WardCodeComparator extends OrderByComparator{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static String ORDER_BY_ASC = "pml_wards.wardscode ASC";

	public static String ORDER_BY_DESC = "pml_wards.wardscode DESC";
	
	private boolean _asc;
	
	public WardCodeComparator(){
		this(false);
	}
	
	public WardCodeComparator(boolean asc){
		this._asc = asc;
	}
	
	public int compare(Object arg0, Object arg1) {
		Wards wards1 = (Wards)arg0;
		Wards wards2 = (Wards)arg1;
		
		int value = wards1.getWardsCode().compareTo(wards2.getWardsCode());
		
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
