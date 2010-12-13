package com.nss.portlet.thu_tuc_hanh_chinh.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.nss.portlet.thu_tuc_hanh_chinh.model.ThuTucHanhChinh;
import com.nss.portlet.thu_tuc_hanh_chinh.service.base.ThuTucHanhChinhLocalServiceBaseImpl;


public class ThuTucHanhChinhLocalServiceImpl
    extends ThuTucHanhChinhLocalServiceBaseImpl {
	public int searchCount(String name, long linhVuc, long capDonVi, long donVi, boolean andOperator) throws SystemException{
		return thuTucHanhChinhFinder.countByTEN_LINHVUC_DONVI(name, linhVuc, capDonVi, donVi, andOperator);
	}
	
	public List<ThuTucHanhChinh> search(String name, long linhVuc, long capDonVi, long donVi, boolean andOperator, int start, int end, OrderByComparator obc) throws SystemException {
		return thuTucHanhChinhFinder.findTEN_LINHVUC_DONVI(name, linhVuc, capDonVi, donVi, andOperator, start, end, obc);
	}
	
	public List<ThuTucHanhChinh> findByMaLinhVucThuTuc(long maLinhVucThuTuc) {
		List<ThuTucHanhChinh> thuTucHanhChinhList = new ArrayList<ThuTucHanhChinh>();
		try {
			thuTucHanhChinhList = thuTucHanhChinhPersistence.findByMaLinhVucThuTucHanhChinh(maLinhVucThuTuc);
		} catch (SystemException e) {
			thuTucHanhChinhList = new ArrayList<ThuTucHanhChinh>();
		}
		return thuTucHanhChinhList;
	}
	
	public List<ThuTucHanhChinh> findByMaDonViThuTuc(long maDonViThuTuc) {
		List<ThuTucHanhChinh> thuTucHanhChinhList = new ArrayList<ThuTucHanhChinh>();
		try {
			thuTucHanhChinhList = thuTucHanhChinhPersistence.findByMaDonViThuTucHanhChinh(maDonViThuTuc);
		} catch (SystemException e) {
			thuTucHanhChinhList = new ArrayList<ThuTucHanhChinh>();
		}
		return thuTucHanhChinhList;
	}
}
