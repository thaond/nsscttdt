package com.nss.portlet.thu_tuc_hanh_chinh.util;

import com.liferay.portal.kernel.util.OrderByComparator;
import com.nss.portlet.thu_tuc_hanh_chinh.model.ThuTucHanhChinh;

public class TenThuTucHanhChinhComparator extends OrderByComparator{
	public static String ORDER_BY_ASC = "tenthutuchanhchinh ASC";
	public static String ORDER_BY_DESC = "tenthutuchanhchinh DESC";
	
	private boolean _asc;
	
	public TenThuTucHanhChinhComparator(){
		this(false);
	}
	
	public TenThuTucHanhChinhComparator(boolean asc){
		this._asc = asc;
	}
	
	public int compare(Object arg0, Object arg1) {
		ThuTucHanhChinh thuTucHanhChinh1 = (ThuTucHanhChinh)arg0;
		ThuTucHanhChinh thuTucHanhChinh2 = (ThuTucHanhChinh)arg1;
		
		int value = thuTucHanhChinh1.getTenThuTucHanhChinh().compareTo(thuTucHanhChinh2.getTenThuTucHanhChinh());
		
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
