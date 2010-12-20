package com.nss.portlet.co_quan_ban_hanh.util;

import com.liferay.portal.kernel.util.OrderByComparator;
import com.nss.portlet.co_quan_ban_hanh.model.CoQuanBanHanh;

public class TenCoQuanBanHanhComparator extends OrderByComparator{
	public static String ORDER_BY_ASC = "ten_co_quan_ban_hanh ASC";
	public static String ORDER_BY_DESC = "ten_co_quan_ban_hanh DESC";
	
	private boolean _asc;
	
	public TenCoQuanBanHanhComparator(){
		this(false);
	}
	
	public TenCoQuanBanHanhComparator(boolean asc){
		this._asc = asc;
	}
	
	public int compare(Object arg0, Object arg1) {
		CoQuanBanHanh coQuanBH1 = (CoQuanBanHanh)arg0;
		CoQuanBanHanh coQuanBH2 = (CoQuanBanHanh)arg1;
		
		int value = coQuanBH1.getTenCoQuanBanHanh().compareTo(coQuanBH2.getTenCoQuanBanHanh());
		
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
