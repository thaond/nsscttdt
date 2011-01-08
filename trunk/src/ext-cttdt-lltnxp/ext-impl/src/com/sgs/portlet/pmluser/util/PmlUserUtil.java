package com.sgs.portlet.pmluser.util;

import java.util.List;

import com.liferay.portal.kernel.util.OrderByComparator;
import com.sgs.portlet.pmluser.model.PmlUser;

/**
 * @author canhminh
 *
 */
public class PmlUserUtil {

	public static OrderByComparator getPmlUserOrderByComparator(
			String orderByCol, String orderByType) {
		
		boolean orderByAsc = false;
		if (orderByType.equals("asc")) {
			orderByAsc = true;
		}
		
		OrderByComparator orderByComparator = null;
		
		if (orderByCol.equals("screen-name")) {
			orderByComparator = new PmlUserScreenNameComparator(orderByAsc);
		} else  if (orderByCol.equals("full-name")) {
			orderByComparator = new PmlUserFullNameComparator(orderByAsc);		
		}  else if (orderByCol.equals("receipt.position")) {
			orderByComparator = new PmlUserPositionNameComparator(orderByAsc);		
			
		} 
		return orderByComparator;
	}

	/**
	 * Lay danh sach nguoi dung theo ma so phong ban
	 * 
	 * @param departmentsId
	 * @return
	 */
	public static List<PmlUser> getPmlUserByDepartmentId(String departmentsId) {
		
		List<PmlUser> retVal = null;
		try {
			if (departmentsId.trim().length() == 0) {
				retVal = com.sgs.portlet.pmluser.service.persistence.PmlUserUtil.findAll();
			}
			else {
				retVal = com.sgs.portlet.pmluser.service.persistence.PmlUserUtil.findByDepartmentsId(
						departmentsId);
			}
		}
		catch (Exception ex) {
			retVal = null;
			System.out.println("Co loi khi goi ham getPmlUserByDepartmentId.");
		}
		return retVal;
	}
}
