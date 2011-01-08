package com.sgs.portlet.issuingplace.util;

import com.liferay.portal.kernel.util.OrderByComparator;
import com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace;

public class IssuingPlaceNameComparator extends OrderByComparator{
	public static String ORDER_BY_ASC = "pml_edm_issuingplace.issuingplacename ASC";
	public static String ORDER_BY_DESC = "pml_edm_issuingplace.issuingplacename DESC";
	
	private boolean _asc;
	
	public IssuingPlaceNameComparator(){
		this(false);
	}
	
	public IssuingPlaceNameComparator(boolean asc){
		this._asc = asc;
	}
	
	public int compare(Object arg0, Object arg1) {
		PmlEdmIssuingPlace issuingPlace1 = (PmlEdmIssuingPlace)arg0;
		PmlEdmIssuingPlace issuingPlace2 = (PmlEdmIssuingPlace)arg1;
		
		int value = issuingPlace1.getIssuingPlaceName().compareTo(issuingPlace2.getIssuingPlaceName());
		
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
