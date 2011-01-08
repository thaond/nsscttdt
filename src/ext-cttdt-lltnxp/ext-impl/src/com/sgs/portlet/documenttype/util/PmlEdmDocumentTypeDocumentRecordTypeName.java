/**
 * 
 */
package com.sgs.portlet.documenttype.util;

import com.liferay.portal.kernel.util.OrderByComparator;
import com.sgs.portlet.document.receipt.model.PmlEdmDocumentType;
import com.sgs.portlet.document.receipt.service.PmlEdmDocumentRecordTypeLocalServiceUtil;

/**
 * @author canhminh
 *
 */
public class PmlEdmDocumentTypeDocumentRecordTypeName extends OrderByComparator {

	public static String ORDER_BY_ASC = "pml_edm_documentrecordtype.documentrecordtypename ASC";

	public static String ORDER_BY_DESC = "pml_edm_documentrecordtype.documentrecordtypename DESC";
	
	private final boolean _asc;
	
	public PmlEdmDocumentTypeDocumentRecordTypeName(){
		this(false);
	}
	
	public PmlEdmDocumentTypeDocumentRecordTypeName(boolean asc){
		this._asc = asc;
	}
	
	@Override
	public int compare(Object arg0, Object arg1) {
		PmlEdmDocumentType documentType1 = (PmlEdmDocumentType)arg0;
		PmlEdmDocumentType documentType2 = (PmlEdmDocumentType)arg1;
		String documentRecordType1 = "";
		String documentRecordType2 = "";
		try {
			documentRecordType1 = PmlEdmDocumentRecordTypeLocalServiceUtil.
					getPmlEdmDocumentRecordType(documentType1.getDocumentRecordTypeId()).getDocumentRecordTypeName();
			documentRecordType2 = PmlEdmDocumentRecordTypeLocalServiceUtil.
					getPmlEdmDocumentRecordType(documentType2.getDocumentRecordTypeId()).getDocumentRecordTypeName();
		} catch (Exception e) {
		}
		
		int value = documentRecordType1.compareTo(documentRecordType2);
		
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