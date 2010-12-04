package com.nss.portlet.agency.util;

import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.model.User;

public class AgencyLeaderComparator extends OrderByComparator{

	public static String ORDER_BY_ASC = "user_.lastname ASC";

	public static String ORDER_BY_DESC = "user_.lastname DESC";
	
	private boolean _asc;
	
	public AgencyLeaderComparator(){
		this(false);
	}
	
	public AgencyLeaderComparator(boolean asc){
		this._asc = asc;
	}
	
	public int compare(Object arg0, Object arg1) {
		User userFirstname1 = (User)arg0;
		User userFirstname2 = (User)arg1;
		
		int value = userFirstname1.getLastName().compareTo(userFirstname2.getLastName());
		
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
