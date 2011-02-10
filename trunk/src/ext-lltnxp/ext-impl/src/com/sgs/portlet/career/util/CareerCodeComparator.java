package com.sgs.portlet.career.util;

import com.liferay.portal.kernel.util.OrderByComparator;
import com.sgs.portlet.career.model.Career;

public class CareerCodeComparator extends OrderByComparator{
	public static final String ORDER_BY_ASC = "careercode ASC";
	public static final String ORDER_BY_DESC ="careercode DESC";

	public CareerCodeComparator(){
		this(false);
	}
	
	public CareerCodeComparator(boolean asc){
		this._asc = asc;
	}
	
	public int compare(Object arg0, Object arg1) {
		Career career1 = (Career)arg0;
		Career career2 = (Career)arg1;
		int value = career1.getCareerCode().compareTo(career2.getCareerCode());
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
