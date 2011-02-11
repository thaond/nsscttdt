package com.sgs.portlet.signer.util;

import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.model.Contact;

public class ContactLastnameComparator extends OrderByComparator{
	public static final String ORDER_BY_ASC ="lastname ASC";
	public static final String ORDER_BY_DESC ="lastname DESC";

	public ContactLastnameComparator(){
		this(false);
	}
	
	public ContactLastnameComparator(boolean asc){
		this._asc = asc;
	}
	
	public int compare(Object arg0, Object arg1) {
		Contact contactLastname1 = (Contact)arg0;
		Contact contactLastname2 = (Contact)arg1;
		int value = contactLastname1.getLastName().compareTo(contactLastname2.getLastName());
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
