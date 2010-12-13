package com.nss.portlet.position.util;

import com.liferay.portal.kernel.util.OrderByComparator;
import com.nss.portlet.position.model.Position;

public class PositionNameComparator extends OrderByComparator {
	
	private static final long serialVersionUID = 1L;

	public static String ORDER_BY_ASC = "positionname ASC";

	public static String ORDER_BY_DESC = "positionname DESC";
	
	private boolean _asc;
	
	public PositionNameComparator(){
		this(false);
	}
	
	public PositionNameComparator(boolean asc){
		this._asc = asc;
	}
	
	public int compare(Object arg0, Object arg1) {
		Position position1 = (Position)arg0;
		Position position2 = (Position)arg1;
		
		int value = position1.getPositionName().compareTo(position2.getPositionName());
		
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
