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
public class PmlDocumentDelegateFromDateComparator extends OrderByComparator {
	public static String ORDER_BY_ASC = "pml_edm_documentdelegate.fromtdate ASC";

	public static String ORDER_BY_DESC = "pml_edm_documentdelegate.fromtdate DESC";
	
	private final boolean _asc;
	
	public PmlDocumentDelegateFromDateComparator(){
		this(false);
	}
	
	public PmlDocumentDelegateFromDateComparator(boolean asc){
		this._asc = asc;
	}
	
	@Override
	public int compare(Object o1, Object o2) {
		PmlDocumentDelegate pmlDocumentDelegate1 = (PmlDocumentDelegate) o1;
		PmlDocumentDelegate pmlDocumentDelegate2 = (PmlDocumentDelegate) o2;
		
		int value = pmlDocumentDelegate1.getFromtDate().compareTo(pmlDocumentDelegate2.getFromtDate());
		
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
