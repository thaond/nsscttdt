package com.sgs.portlet.pml_edm_confidentiallevel.util;

import com.liferay.portal.kernel.util.OrderByComparator;
import com.sgs.portlet.document.receipt.model.PmlEdmConfidentialLevel;

public class PmlEDMConfidentialLevelNameCodeComparator extends
		OrderByComparator {

	public static final String ORDER_BY_ASC = "confidentiallevelname ASC";
	public static final String ORDER_BY_DESC = "confidentiallevelname DESC";
	
	
	public PmlEDMConfidentialLevelNameCodeComparator(){
		this(false);
	}
	
	public PmlEDMConfidentialLevelNameCodeComparator(boolean asc){
		this._asc = asc;
	}
	
	@Override
	public int compare(Object o1, Object o2) {
		
		PmlEdmConfidentialLevel pmlEdmConfidentialLevel1  = (PmlEdmConfidentialLevel)o1;
		PmlEdmConfidentialLevel pmlEdmConfidentialLevel2 = (PmlEdmConfidentialLevel)o2;
		
		int value = pmlEdmConfidentialLevel1.getConfidentialLevelName().compareTo(pmlEdmConfidentialLevel2.getConfidentialLevelName());
		if(_asc){
			return value;
		}else{
			return -value;
		}
	}

	@Override
	public String getOrderBy(){
		if(_asc){
			return ORDER_BY_ASC;
		}else{
			return ORDER_BY_DESC;
		}
	}
	
	private final boolean _asc;
}
