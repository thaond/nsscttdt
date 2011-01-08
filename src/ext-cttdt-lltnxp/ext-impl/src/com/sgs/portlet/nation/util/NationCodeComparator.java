package com.sgs.portlet.nation.util;

import com.liferay.portal.kernel.util.OrderByComparator;
import com.sgs.portlet.nation.model.Nation;


public class NationCodeComparator extends OrderByComparator {
	public static String ORDER_BY_ASC = "pml_nation.nationcode ASC";

	public static String ORDER_BY_DESC = "pml_nation.nationcode DESC";
	
	private boolean _asc;
	
	public NationCodeComparator(){
		this(false);
	}
	
	public NationCodeComparator(boolean asc){
		this._asc = asc;
	}
	
	public int compare(Object arg0, Object arg1) {
		Nation nation1 = (Nation)arg0;
		Nation nation2 = (Nation)arg1;
		
		int value = nation1.getNationCode().compareTo(nation2.getNationCode());
		
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
