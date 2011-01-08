package com.sgs.portlet.pcccdocumentreceiptreport.search;

import com.liferay.portal.kernel.util.OrderByComparator;
import com.sgs.portlet.document.receipt.model.PmlEdmConfidentialLevel;

public class DocumentDetailOrderByDoMat extends OrderByComparator {

	private static final long serialVersionUID = 1L;
	
	public static String ORDER_BY_ASC = "conf.confidentiallevelsymbol ASC";
	public static String ORDER_BY_DESC = "conf.confidentiallevelsymbol DESC";
	
	private boolean _asc;
	
	public DocumentDetailOrderByDoMat() {
		this(false);
	}

	public DocumentDetailOrderByDoMat(boolean asc) {
		_asc = asc;
	}
	
	public int compare(Object obj1, Object obj2) {
		PmlEdmConfidentialLevel confidentialLevel1 = (PmlEdmConfidentialLevel)obj1;
		PmlEdmConfidentialLevel confidentialLevel2 = (PmlEdmConfidentialLevel)obj2;
		
		int value = confidentialLevel1.getConfidentialLevelSymbol() - confidentialLevel2.getConfidentialLevelSymbol();

		if (_asc) {
			return value;
		}
		else {
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
