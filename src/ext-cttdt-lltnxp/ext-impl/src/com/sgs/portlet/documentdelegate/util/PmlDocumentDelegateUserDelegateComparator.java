/**
 * 
 */
package com.sgs.portlet.documentdelegate.util;

import com.liferay.portal.kernel.util.OrderByComparator;
import com.sgs.portlet.documentdelegate.model.PmlDocumentDelegate;

/**
 * @author WIN7
 *
 */
public class PmlDocumentDelegateUserDelegateComparator extends OrderByComparator {
	public static String ORDER_BY_ASC = "pml_edm_documentdelegate.userdelegateid ASC";

	public static String ORDER_BY_DESC = "pml_edm_documentdelegate.userdelegateid DESC";
	
	private final boolean _asc;
	
	public PmlDocumentDelegateUserDelegateComparator(){
		this(false);
	}
	
	public PmlDocumentDelegateUserDelegateComparator(boolean asc){
		this._asc = asc;
	}
	
	@Override
	public int compare(Object o1, Object o2) {
		PmlDocumentDelegate pmlDocumentDelegate1 = (PmlDocumentDelegate) o1;
		PmlDocumentDelegate pmlDocumentDelegate2 = (PmlDocumentDelegate) o2;
		String uName1 = PmlDocumentDelegateUtil.getFullName(pmlDocumentDelegate1.getUserDelegateId());
		String uName2  = PmlDocumentDelegateUtil.getFullName(pmlDocumentDelegate2.getUserDelegateId());	
		
		int value = uName1.compareTo(uName2);
		
		if(this._asc){
			return value;
		}else{
			return -value;
		}
	}

	@Override
	public String getOrderBy() {
		if (_asc) {
			return ORDER_BY_ASC;
		}
		else {
			return ORDER_BY_DESC;
		}
	}
}
