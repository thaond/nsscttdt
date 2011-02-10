/**
 * 
 */
package com.sgs.portlet.documentdelegate.util;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;

/**
 * @author WIN7
 *
 */
public class PmlDocumentDelegateUtil {

	
	public static OrderByComparator getPmlDepartmentOrderByComparator(
			String orderByCol, String orderByType) {
			boolean orderByAsc = false;

			if (orderByType.equals("asc")) {
				orderByAsc = true;
			}

			OrderByComparator orderByComparator = null;

			if (orderByCol.equals("nguoi-uy-quyen")) {
				orderByComparator = new PmlDocumentDelegateUserDelegateComparator(orderByAsc);
			} else if (orderByCol.equals("ngay-bat-dau-uy-quyen")) {
				orderByComparator = new PmlDocumentDelegateFromDateComparator(orderByAsc);
			} else {
				orderByComparator = new PmlDocumentDelegateFromDateComparator(orderByAsc);
			}

			return orderByComparator;
		}
	
	public static String getFullName(long userId) {
		try {
			User u = UserLocalServiceUtil.getUser(userId);
			return u.getLastName() + " "+ u.getMiddleName() + " "+ u.getFirstName();
		} catch (PortalException e) {
			return "";
		} catch (SystemException e) {
			return "";
		}
	}
}
