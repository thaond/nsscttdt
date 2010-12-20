package com.nss.portlet.linh_vuc_thu_tuc.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.nss.portlet.linh_vuc_thu_tuc.model.LinhVucThuTucHanhChinh;
import com.nss.portlet.linh_vuc_thu_tuc.service.base.LinhVucThuTucHanhChinhLocalServiceBaseImpl;


public class LinhVucThuTucHanhChinhLocalServiceImpl
    extends LinhVucThuTucHanhChinhLocalServiceBaseImpl {
	
	public int countByKeywords(String keywords) throws SystemException{
		return linhVucThuTucHanhChinhFinder.countByKeywords(keywords);
	}
	
	public int countByTEN_MOTA(String name, String des, boolean andOperator) throws SystemException{
		return linhVucThuTucHanhChinhFinder.countByTEN_MOTA(name, des, andOperator);
	}
	
	public List<LinhVucThuTucHanhChinh> findByKeywords(String keywords,int start, int end, OrderByComparator obc) throws SystemException{
		return linhVucThuTucHanhChinhFinder.findByKeywords(keywords, start, end, obc);
	}
	
	public List<LinhVucThuTucHanhChinh> findTEN_MOTA(String name, String des, boolean andOperator, int start, int end, OrderByComparator obc) throws SystemException {
		return linhVucThuTucHanhChinhFinder.findTEN_MOTA(name, des, andOperator, start, end, obc);
	}
	
	public List<LinhVucThuTucHanhChinh> findByActive(int active) {
		List<LinhVucThuTucHanhChinh> linhVucThuTucList = new ArrayList<LinhVucThuTucHanhChinh>();
		try {
			linhVucThuTucList = linhVucThuTucHanhChinhPersistence.findByActive(active);
		} catch (SystemException e) {
			e.printStackTrace();
		}
		return linhVucThuTucList;
	}
	public List<LinhVucThuTucHanhChinh> findByMaLoaiThuTucHanhChinh(long maLoaiThuTucHanhChinh) {
		List<LinhVucThuTucHanhChinh> linhVucThuTucList = new ArrayList<LinhVucThuTucHanhChinh>();
		try {
			linhVucThuTucList = linhVucThuTucHanhChinhPersistence.findByMaLoaiThuTucHanhChinh(maLoaiThuTucHanhChinh);
		} catch (SystemException e) {
			e.printStackTrace();
		}
		return linhVucThuTucList;
	}
}
