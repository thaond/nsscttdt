package com.sgs.portlet.documentrecordtype.util;

import com.liferay.portal.kernel.util.OrderByComparator;
import com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordType;

public class PmlEdmDocumentRecordTypeNameComparator extends OrderByComparator {

	public static String ORDER_BY_ASC = "documentrecordtypename ASC";

	public static String ORDER_BY_DESC = "documentrecordtypename DESC";
	
	private boolean _asc;
	
	public PmlEdmDocumentRecordTypeNameComparator(){
		this(false);
	}
	
	public PmlEdmDocumentRecordTypeNameComparator(boolean asc){
		this._asc = asc;
	}
	
	public int compare(Object arg0, Object arg1) {
		PmlEdmDocumentRecordType pmlEdmDocumentRecordType1 = (PmlEdmDocumentRecordType)arg0;
		PmlEdmDocumentRecordType pmlEdmDocumentRecordType2 = (PmlEdmDocumentRecordType)arg1;
		
		int value = pmlEdmDocumentRecordType1.getDocumentRecordTypeName().compareTo(pmlEdmDocumentRecordType2.getDocumentRecordTypeName());
		
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
