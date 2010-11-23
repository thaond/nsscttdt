package com.nss.portlet.nss_don_vi_thu_tuc.util;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.nss.portlet.nss_don_vi_thu_tuc.model.DonViThuTuc;
import com.nss.portlet.nss_don_vi_thu_tuc.service.DonViThuTucLocalServiceUtil;

public class DonViThuTucDWRUtil {
	private static Log _log = LogFactory.getLog(DonViThuTucDWRUtil.class);
	public static List<DonViThuTuc> getListDonViThuTuc(int capDonVi) {
		List<DonViThuTuc> list = new ArrayList<DonViThuTuc>();
		try {
			list = DonViThuTucLocalServiceUtil.findByCapDonVi_Active(capDonVi, 1);
		} catch (Exception e) {
			list = new ArrayList<DonViThuTuc>();
			_log.error(e.getMessage());
		}
		return list;
	}
}
