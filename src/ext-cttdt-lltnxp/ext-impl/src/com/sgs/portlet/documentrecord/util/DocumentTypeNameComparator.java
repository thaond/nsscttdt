package com.sgs.portlet.documentrecord.util;

import com.liferay.portal.kernel.util.OrderByComparator;
import com.sgs.portlet.agency.model.Agency;
import com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordType;

public class DocumentTypeNameComparator extends OrderByComparator{
	public static String ORDER_BY_ASC = "pml_edm_documentrecordtype.documentrecordtypename ASC";

	public static String ORDER_BY_DESC = "pml_edm_documentrecordtype.documentrecordtypename DESC";
	
	private boolean _asc;
	
	public DocumentTypeNameComparator(){
		this(false);
	}
	
	public DocumentTypeNameComparator(boolean asc){
		this._asc = asc;
	}
	
	public int compare(Object arg0, Object arg1) {
		PmlEdmDocumentRecordType type1 = (PmlEdmDocumentRecordType)arg0;
		PmlEdmDocumentRecordType type2 = (PmlEdmDocumentRecordType)arg1;
		
		int value = type1.getDocumentRecordTypeName().compareTo(type2.getDocumentRecordTypeName());
		
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
