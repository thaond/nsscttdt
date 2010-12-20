package com.nss.portlet.qa_cau_hoi.util;

import com.liferay.portal.kernel.util.OrderByComparator;
import com.nss.portlet.qa_cau_hoi.model.CauHoiQA;

public class QACauHoiTieuDeComparator extends OrderByComparator {
	public static String ORDER_BY_ASC = "nss_qa_cau_hoi.tieude ASC";
	public static String ORDER_BY_DESC = "nss_qa_cau_hoi.tieude DESC";
	
	private boolean _asc;
	
	public QACauHoiTieuDeComparator(){
		this(false);
	}
	
	public QACauHoiTieuDeComparator(boolean asc){
		this._asc = asc;
	}
	
	public int compare(Object arg0, Object arg1) {
		CauHoiQA cauHoi1 = (CauHoiQA)arg0;
		CauHoiQA cauHoi2 = (CauHoiQA)arg1;
		
		int value = cauHoi1.getTieuDe().compareTo(cauHoi2.getTieuDe());
		
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
