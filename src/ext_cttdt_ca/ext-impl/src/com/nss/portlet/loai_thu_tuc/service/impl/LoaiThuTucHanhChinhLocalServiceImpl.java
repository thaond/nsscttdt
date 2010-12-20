package com.nss.portlet.loai_thu_tuc.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.nss.portlet.loai_thu_tuc.model.LoaiThuTucHanhChinh;
import com.nss.portlet.loai_thu_tuc.service.base.LoaiThuTucHanhChinhLocalServiceBaseImpl;


public class LoaiThuTucHanhChinhLocalServiceImpl
    extends LoaiThuTucHanhChinhLocalServiceBaseImpl {
	public int countByKeywords(String keywords) throws SystemException{
		return loaiThuTucHanhChinhFinder.countByKeywords(keywords);
	}
	
	public int searchCount(String name, String des, boolean andOperator) throws SystemException{
		return loaiThuTucHanhChinhFinder.countByTEN_MOTA(name, des, andOperator);
	}
	
	public List<LoaiThuTucHanhChinh> findByKeywords(String keywords,int start, int end, OrderByComparator obc) throws SystemException{
		return loaiThuTucHanhChinhFinder.findByKeywords(keywords, start, end, obc);
	}
	
	public List<LoaiThuTucHanhChinh> search(String name, String des, boolean andOperator, int start, int end, OrderByComparator obc) throws SystemException {
		return loaiThuTucHanhChinhFinder.findTEN_MOTA(name, des, andOperator, start, end, obc);
	}
	
	public List<LoaiThuTucHanhChinh> findByActive(int active) {
		List<LoaiThuTucHanhChinh> loaiThuTucHanhChinhList = new ArrayList<LoaiThuTucHanhChinh>();
		try {
			loaiThuTucHanhChinhList = loaiThuTucHanhChinhPersistence.findByActive(active);
		} catch (SystemException e) {
			e.printStackTrace();
		}
		return loaiThuTucHanhChinhList;
	}
}
