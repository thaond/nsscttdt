package com.nss.portlet.nss_don_vi_thu_tuc.util;

import com.liferay.portal.kernel.util.OrderByComparator;
import com.nss.portlet.nss_don_vi_thu_tuc.model.DonViThuTuc;

@SuppressWarnings("serial")
public class DonViThuTucTenDonViThuTucComparator extends OrderByComparator {
	
	public static String ORDER_BY_ASC = "ten_don_vi_thu_tuc ASC";
	public static String ORDER_BY_DESC = "ten_don_vi_thu_tuc DESC";
	
	private boolean _asc;
	
	public DonViThuTucTenDonViThuTucComparator(){
		this(false);
	}
	
	public DonViThuTucTenDonViThuTucComparator(boolean asc){
		this._asc = asc;
	}
	
	public int compare(Object arg0, Object arg1) {
		DonViThuTuc loaiVB1 = (DonViThuTuc)arg0;
		DonViThuTuc loaiVB2 = (DonViThuTuc)arg1;
		
		int value = loaiVB1.getTenDonViThuTuc().compareTo(loaiVB2.getTenDonViThuTuc());
		
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
