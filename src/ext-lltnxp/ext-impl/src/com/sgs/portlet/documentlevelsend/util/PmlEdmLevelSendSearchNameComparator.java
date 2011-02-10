package com.sgs.portlet.documentlevelsend.util;

import com.liferay.portal.kernel.util.OrderByComparator;
import com.sgs.portlet.pmllevelsend.model.PmlEdmLevelSend;

public class PmlEdmLevelSendSearchNameComparator extends OrderByComparator {
	public static final String ORDER_BY_ASC = "levelsendname ASC";
	public static final String ORDER_BY_DESC = "levelsendname DESC";
	
	
	public PmlEdmLevelSendSearchNameComparator(){
		this(false);
	}
	
	public PmlEdmLevelSendSearchNameComparator(boolean asc){
		this._asc = asc;
	}
	
	@Override
	public int compare(Object o1, Object o2) {
		
		PmlEdmLevelSend pmlEdmLevelSend1 = (PmlEdmLevelSend)o1;
		PmlEdmLevelSend pmlEdmLevelSend2 = (PmlEdmLevelSend)o2;
		
		int value = pmlEdmLevelSend1.getLevelSendName().compareTo(pmlEdmLevelSend2.getLevelSendName());
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
