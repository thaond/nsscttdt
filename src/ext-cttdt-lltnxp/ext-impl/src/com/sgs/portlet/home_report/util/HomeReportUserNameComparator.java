package com.sgs.portlet.home_report.util;

import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.sgs.portlet.pmluser.model.PmlUser;

@SuppressWarnings("serial")
public class HomeReportUserNameComparator extends OrderByComparator {

	public static final String ORDER_BY_ASC ="firstname ASC , middlename ASC, lastname ASC";
	public static final String ORDER_BY_DESC ="firstname DESC, middlename DESC, lastname DESC";
	
	
	public HomeReportUserNameComparator(){
		this(false);
	}
	
	public HomeReportUserNameComparator(boolean asc){
		this._asc = asc;
	}
	
	@Override
	public int compare(Object o1, Object o2) {
		
		PmlUser pmlUser1 = (PmlUser)o1;
		PmlUser pmlUser2 = (PmlUser)o2;
		String fullName1 = ""; 
		String fullName2 = ""; 
		
		try {
			User user1 = UserLocalServiceUtil.getUser(pmlUser1.getUserId());
			User user2 = UserLocalServiceUtil.getUser(pmlUser2.getUserId());
			fullName1 = user1.getLastName().concat(" ").concat(user1.getMiddleName()).concat(" ").concat(user1.getFirstName()); 
			fullName1 = user2.getLastName().concat(" ").concat(user2.getMiddleName()).concat(" ").concat(user2.getFirstName()); 
		} catch (Exception e) { }
		
		int value = fullName1.compareTo(fullName2);
		if (_asc) {
			return value;
		} else {
			return -value;
		}
	}

	@Override
	public String getOrderBy(){
		if (_asc) {
			return ORDER_BY_ASC;
		} else {
			return ORDER_BY_DESC;
		}
	}
	
	private final boolean _asc;
}
