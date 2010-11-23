package com.nss.portlet.loai_thu_tuc.util;

import com.liferay.portal.kernel.util.OrderByComparator;
import com.nss.portlet.loai_thu_tuc.model.LoaiThuTucHanhChinh;

public class TenLoaiThuTucHanhChinhComparator extends OrderByComparator{
	public static String ORDER_BY_ASC = "tenloaithutuchanhchinh ASC";
	public static String ORDER_BY_DESC = "tenloaithutuchanhchinh DESC";
	
	private boolean _asc;
	
	public TenLoaiThuTucHanhChinhComparator(){
		this(false);
	}
	
	public TenLoaiThuTucHanhChinhComparator(boolean asc){
		this._asc = asc;
	}
	
	public int compare(Object arg0, Object arg1) {
		LoaiThuTucHanhChinh loaiThuTucHanhChinh1 = (LoaiThuTucHanhChinh)arg0;
		LoaiThuTucHanhChinh loaiThuTucHanhChinh2 = (LoaiThuTucHanhChinh)arg1;
		
		int value = loaiThuTucHanhChinh1.getTenLoaiThuTucHanhChinh().compareTo(loaiThuTucHanhChinh2.getTenLoaiThuTucHanhChinh());
		
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
