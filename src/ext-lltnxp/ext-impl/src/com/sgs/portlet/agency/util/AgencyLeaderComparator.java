package com.sgs.portlet.agency.util;

import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.model.Contact;

public class AgencyLeaderComparator extends OrderByComparator{

	public static String ORDER_BY_ASC = "contact_.lastname ASC";

	public static String ORDER_BY_DESC = "contact_.lastname DESC";
	
	private boolean _asc;
	
	public AgencyLeaderComparator(){
		this(false);
	}
	
	public AgencyLeaderComparator(boolean asc){
		this._asc = asc;
	}
	
	public int compare(Object arg0, Object arg1) {
		Contact contactFirstname1 = (Contact)arg0;
		Contact contactFirstname2 = (Contact)arg1;
		
		int value = contactFirstname1.getLastName().compareTo(contactFirstname2.getLastName());
		
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
