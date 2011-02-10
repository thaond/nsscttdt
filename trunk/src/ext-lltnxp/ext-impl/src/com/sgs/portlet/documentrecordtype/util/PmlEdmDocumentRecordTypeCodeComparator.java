package com.sgs.portlet.documentrecordtype.util;

import com.liferay.portal.kernel.util.OrderByComparator;
import com.sgs.portlet.agency.model.Agency;
import com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordType;

public class PmlEdmDocumentRecordTypeCodeComparator extends OrderByComparator {

	public static String ORDER_BY_ASC = "documentrecordtypecode ASC";

	public static String ORDER_BY_DESC = "documentrecordtypecode DESC";
	
	private boolean _asc;
	
	public PmlEdmDocumentRecordTypeCodeComparator(){
		this(false);
	}
	
	public PmlEdmDocumentRecordTypeCodeComparator(boolean asc){
		this._asc = asc;
	}
	
	public int compare(Object arg0, Object arg1) {
		PmlEdmDocumentRecordType pmlEdmDocumentRecordType1 = (PmlEdmDocumentRecordType)arg0;
		PmlEdmDocumentRecordType pmlEdmDocumentRecordType2 = (PmlEdmDocumentRecordType)arg1;
		
		int value = pmlEdmDocumentRecordType1.getDocumentRecordTypeCode().compareTo(pmlEdmDocumentRecordType2.getDocumentRecordTypeCode());
		
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
