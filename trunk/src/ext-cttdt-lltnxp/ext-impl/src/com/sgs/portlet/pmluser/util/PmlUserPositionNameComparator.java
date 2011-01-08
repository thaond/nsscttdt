/**
 * 
 */
package com.sgs.portlet.pmluser.util;

import com.liferay.portal.kernel.util.OrderByComparator;
import com.sgs.portlet.pmluser.model.PmlUser;
import com.sgs.portlet.position.model.Position;
import com.sgs.portlet.position.service.PositionLocalServiceUtil;

/**
 * @author canhminh
 *
 */
public class PmlUserPositionNameComparator extends OrderByComparator {

	public static final String ORDER_BY_ASC ="pml_user.positionid ASC";
	public static final String ORDER_BY_DESC ="pml_user.positionid DESC";
	
	
	public PmlUserPositionNameComparator(){
		this(false);
	}
	
	public PmlUserPositionNameComparator(boolean asc){
		this._asc = asc;
	}
	
	@Override
	public int compare(Object o1, Object o2) {
		
		PmlUser pmlUser1 = (PmlUser)o1;
		PmlUser pmlUser2 = (PmlUser)o2;
		String positionName1 = ""; 
		String positionName2 = ""; 
		
		try {
			Position position1 = PositionLocalServiceUtil.getPosition(pmlUser1.getPositionId());
			Position position2 = PositionLocalServiceUtil.getPosition(pmlUser2.getPositionId());
			positionName1 = position1.getPositionName(); 
			positionName2 = position2.getPositionName(); 
		} catch (Exception e) {
			
		}
		
		int value = positionName1.compareTo(positionName2);
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
