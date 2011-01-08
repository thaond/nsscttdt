/**
 * 
 */
package com.sgs.portlet.documenttype.util;

import com.liferay.portal.kernel.util.OrderByComparator;
import com.sgs.portlet.document.receipt.model.PmlEdmDocumentType;

/**
 * @author canhminh
 *
 */
public class PmlEdmDocumentTypeNameComparator extends OrderByComparator {

	public static String ORDER_BY_ASC = "pml_edm_documenttype.documenttypename ASC";

	public static String ORDER_BY_DESC = "pml_edm_documenttype.documenttypename DESC";
	
	private final boolean _asc;
	
	public PmlEdmDocumentTypeNameComparator(){
		this(false);
	}
	
	public PmlEdmDocumentTypeNameComparator(boolean asc){
		this._asc = asc;
	}
	
	@Override
	public int compare(Object arg0, Object arg1) {
		PmlEdmDocumentType documentType1 = (PmlEdmDocumentType)arg0;
		PmlEdmDocumentType documentType2 = (PmlEdmDocumentType)arg1;
		
		int value = documentType1.getDocumentTypeName().compareTo(documentType2.getDocumentTypeName());
		
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
