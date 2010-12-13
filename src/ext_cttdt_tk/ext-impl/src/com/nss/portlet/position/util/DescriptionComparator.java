package com.nss.portlet.position.util;

import com.liferay.portal.kernel.util.OrderByComparator;
import com.nss.portlet.position.model.Position;

public class DescriptionComparator extends OrderByComparator {
	
	private static final long serialVersionUID = 1L;

	public static String ORDER_BY_ASC = "description ASC";

	public static String ORDER_BY_DESC = "description DESC";
	
	private boolean _asc;
	
	public DescriptionComparator(){
		this(false);
	}
	
	public DescriptionComparator(boolean asc){
		this._asc = asc;
	}
	
	public int compare(Object arg0, Object arg1) {
		Position position1 = (Position)arg0;
		Position position2 = (Position)arg1;
		
		int value = position1.getDescription().compareTo(position2.getDescription());
		
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
