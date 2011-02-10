package com.sgs.portlet.career.util;

import com.liferay.portal.kernel.util.OrderByComparator;
import com.sgs.portlet.career.model.Career;

public class CareerNameComparator extends OrderByComparator{
	public static final String ORDER_BY_ASC = "careername ASC";
	public static final String ORDER_BY_DESC ="careername DESC";

	public CareerNameComparator(){
		this(false);
	}
	
	public CareerNameComparator(boolean asc){
		this._asc = asc;
	}
	
	public int compare(Object arg0, Object arg1) {
		Career career1 = (Career)arg0;
		Career career2 = (Career)arg1;
		int value = career1.getCareerName().compareTo(career2.getCareerName());
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
