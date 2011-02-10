package com.sgs.portlet.deleteprocessinstance.util;

import com.liferay.portal.kernel.util.OrderByComparator;
import com.sgs.portlet.document.receipt.model.PmlEdmDocumentType;

public class DocumentTypeComparator extends OrderByComparator{
	public static String ORDER_BY_ASC = "pml_edm_documenttype.documenttypename ASC";

	public static String ORDER_BY_DESC = "pml_edm_documenttype.documenttypename DESC";
	
	private boolean _asc;
	
	public DocumentTypeComparator(){
		this(false);
	}
	
	public DocumentTypeComparator(boolean asc){
		this._asc = asc;
	}
	
	public int compare(Object arg0, Object arg1) {
		PmlEdmDocumentType typeName1 = (PmlEdmDocumentType)arg0;
		PmlEdmDocumentType typeName2 = (PmlEdmDocumentType)arg1;
		
		int value = typeName1.getDocumentTypeName().compareTo(typeName2.getDocumentTypeName());
		
		if(this._asc){
			return value;
		}else{
			return -value;
		}
	}
	
	public String getOrderBy() {
		if (_asc) {
			return ORDER_BY_ASC;
		}
		else {
			return ORDER_BY_DESC;
		}
	}

}
