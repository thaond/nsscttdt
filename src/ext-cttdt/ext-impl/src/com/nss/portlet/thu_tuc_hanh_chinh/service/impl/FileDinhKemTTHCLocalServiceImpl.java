package com.nss.portlet.thu_tuc_hanh_chinh.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.liferay.portal.SystemException;
import com.nss.portlet.thu_tuc_hanh_chinh.model.FileDinhKemTTHC;
import com.nss.portlet.thu_tuc_hanh_chinh.service.base.FileDinhKemTTHCLocalServiceBaseImpl;

public class FileDinhKemTTHCLocalServiceImpl
    extends FileDinhKemTTHCLocalServiceBaseImpl {
	public List<FileDinhKemTTHC> findByMaThuTucHanhChinh(long maThuTucHanhChinh) {
		List<FileDinhKemTTHC> fileDinhKemTTHCList = new ArrayList<FileDinhKemTTHC>();
		try {
			fileDinhKemTTHCList = fileDinhKemTTHCPersistence.findByMaThuTucHanhChinh(maThuTucHanhChinh);
		} catch (SystemException e) {
			fileDinhKemTTHCList = new ArrayList<FileDinhKemTTHC>();
			e.printStackTrace();
		}
		return fileDinhKemTTHCList;
	}
	
	public int searchCount(long maThuTucHanhChinh) throws SystemException {
		return fileDinhKemTTHCFinder.countFileDinhKem(maThuTucHanhChinh);
	}
	
	public List<FileDinhKemTTHC> search(long maThuTucHanhChinh, int start, int end) throws SystemException {
		return fileDinhKemTTHCFinder.findFileDinhKem(maThuTucHanhChinh, start, end);
	}
}
