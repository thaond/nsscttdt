package com.sgs.portlet.signer.util;

import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.model.Contact;

public class ContactFirstnameComparator extends OrderByComparator{
	public static final String ORDER_BY_ASC = "firstname ASC";
	public static final String ORDER_BY_DESC ="firstname DESC";

	public ContactFirstnameComparator(){
		this(false);
	}
	
	public ContactFirstnameComparator(boolean asc){
		this._asc = asc;
	}
	
	public int compare(Object arg0, Object arg1) {
		Contact contactFirstname1 = (Contact)arg0;
		Contact contactFirstname2 = (Contact)arg1;
		int value = contactFirstname1.getFirstName().compareTo(contactFirstname2.getFirstName());
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
