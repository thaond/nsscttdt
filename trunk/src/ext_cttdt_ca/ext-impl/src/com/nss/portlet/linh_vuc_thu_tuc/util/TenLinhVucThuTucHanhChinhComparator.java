package com.nss.portlet.linh_vuc_thu_tuc.util;

import com.liferay.portal.kernel.util.OrderByComparator;
import com.nss.portlet.linh_vuc_thu_tuc.model.LinhVucThuTucHanhChinh;

@SuppressWarnings("serial")
public class TenLinhVucThuTucHanhChinhComparator extends OrderByComparator {
	
	public static String ORDER_BY_ASC = "tenlinhvucthutuchanhchinh ASC";
	public static String ORDER_BY_DESC = "tenlinhvucthutuchanhchinh DESC";
	
	private boolean _asc;
	
	public TenLinhVucThuTucHanhChinhComparator(){
		this(false);
	}
	
	public TenLinhVucThuTucHanhChinhComparator(boolean asc){
		this._asc = asc;
	}
	
	public int compare(Object arg0, Object arg1) {
		LinhVucThuTucHanhChinh loaiVB1 = (LinhVucThuTucHanhChinh)arg0;
		LinhVucThuTucHanhChinh loaiVB2 = (LinhVucThuTucHanhChinh)arg1;
		
		int value = loaiVB1.getTenLinhVucThuTucHanhChinh().compareTo(loaiVB2.getTenLinhVucThuTucHanhChinh());
		
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
