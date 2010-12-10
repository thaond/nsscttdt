package com.nss.portlet.permissonuserbyfile.util;

import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;

public class PermissionUserNameComparator extends OrderByComparator {
	public static final String ORDER_BY_ASC ="user_.firstname ASC , user_.middlename ASC, user_.lastname ASC";
	public static final String ORDER_BY_DESC ="user_.firstname DESC, user_.middlename DESC, user_.lastname DESC";
	
	
	public PermissionUserNameComparator(){
		this(false);
	}
	
	public PermissionUserNameComparator(boolean asc){
		this._asc = asc;
	}
	
	@Override
	public int compare(Object o1, Object o2) {
		
		User user1 = (User)o1;
		User user2 = (User)o2;
		String fullName1 = ""; 
		String fullName2 = ""; 
		
		try {
//			User user1 = UserLocalServiceUtil.getUser(pmlUser1.getUserId());
//			User user2 = UserLocalServiceUtil.getUser(pmlUser2.getUserId());
			fullName1 = user1.getLastName().concat(" ").concat(user1.getMiddleName()).concat(" ").concat(user1.getFirstName()); 
			fullName1 = user2.getLastName().concat(" ").concat(user2.getMiddleName()).concat(" ").concat(user2.getFirstName()); 
		} catch (Exception e) {
			
		}
		
		int value = fullName1.compareTo(fullName2);
		if(_asc){
			return value;
		}else{
			return -value;
		}
	}

	@Override
	public String getOrderBy(){
		if(_asc){
			return ORDER_BY_ASC;
		}else{
			return ORDER_BY_DESC;
		}
	}
	
	private final boolean _asc;

}
