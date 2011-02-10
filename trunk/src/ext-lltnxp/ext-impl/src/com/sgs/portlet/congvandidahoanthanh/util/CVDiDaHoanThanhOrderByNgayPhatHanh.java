package com.sgs.portlet.congvandidahoanthanh.util;

import com.liferay.portal.kernel.util.OrderByComparator;
import com.sgs.portlet.document.send.model.PmlEdmDocumentSend;

public class CVDiDaHoanThanhOrderByNgayPhatHanh extends OrderByComparator {

	private static final long serialVersionUID = 1L;

	public static String ORDER_BY_ASC = "cvdi.issuingdate ASC";

	public static String ORDER_BY_DESC = "cvdi.issuingdate DESC";
	
	private boolean _asc;

	public CVDiDaHoanThanhOrderByNgayPhatHanh(){
		this(false);
	}
	
	public CVDiDaHoanThanhOrderByNgayPhatHanh(boolean asc){
		this._asc = asc;
	}
	
	public int compare(Object arg0, Object arg1) {
		PmlEdmDocumentSend cvdi1 = (PmlEdmDocumentSend) arg0;
		PmlEdmDocumentSend cvdi2 = (PmlEdmDocumentSend) arg1;
		
		int value = cvdi1.getIssuingDate().compareTo(cvdi2.getIssuingDate());
		
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
