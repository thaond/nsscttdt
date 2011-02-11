/**
 * 
 */
package com.sgs.portlet.pmluser.util;

import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.sgs.portlet.pmluser.model.PmlUser;

/**
 * @author minhnv
 *
 */
public class PmlUserScreenNameComparator extends OrderByComparator {

	public static final String ORDER_BY_ASC ="pml_user.screenname ASC";
	public static final String ORDER_BY_DESC ="pml_user.screenname DESC";
	
	
	public PmlUserScreenNameComparator(){
		this(false);
	}
	
	public PmlUserScreenNameComparator(boolean asc){
		this._asc = asc;
	}
	
	@Override
	public int compare(Object o1, Object o2) {
		
		PmlUser pmlUser1 = (PmlUser)o1;
		PmlUser pmlUser2 = (PmlUser)o2;
		String screenname1 = ""; 
		String screenname2 = ""; 
		try {
			User user1 = UserLocalServiceUtil.getUser(pmlUser1.getUserId());
			User user2 = UserLocalServiceUtil.getUser(pmlUser2.getUserId());
			screenname1 = user1.getScreenName(); 
			screenname2 = user2.getScreenName(); 
		} catch (Exception e) {
			
		}
		
		int value = screenname1.compareTo(screenname2);
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
