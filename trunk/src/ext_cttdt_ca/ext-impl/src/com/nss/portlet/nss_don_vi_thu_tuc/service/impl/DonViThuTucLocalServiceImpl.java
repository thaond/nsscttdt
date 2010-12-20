package com.nss.portlet.nss_don_vi_thu_tuc.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.nss.portlet.nss_don_vi_thu_tuc.model.DonViThuTuc;
import com.nss.portlet.nss_don_vi_thu_tuc.service.base.DonViThuTucLocalServiceBaseImpl;


public class DonViThuTucLocalServiceImpl extends DonViThuTucLocalServiceBaseImpl {
	
	public int countByKeywords(String keywords) throws SystemException{
		return donViThuTucFinder.countByKeywords(keywords);
	}
	
	public int countByTEN_MOTA(String name, String des, boolean andOperator) throws SystemException{
		return donViThuTucFinder.countByTEN_MOTA(name, des, andOperator);
	}
	
	public List<DonViThuTuc> findByKeywords(String keywords,int start, int end, OrderByComparator obc) throws SystemException{
		return donViThuTucFinder.findByKeywords(keywords, start, end, obc);
	}
	
	public List<DonViThuTuc> findTEN_MOTA(String name, String des, boolean andOperator, int start, int end, OrderByComparator obc) throws SystemException {
		return donViThuTucFinder.findTEN_MOTA(name, des, andOperator, start, end, obc);
	}
	
	public List<DonViThuTuc> findByActive(int active) {
		List<DonViThuTuc> donViThuTucList = new ArrayList<DonViThuTuc>();
		try {
			donViThuTucList = donViThuTucPersistence.findByActive(active);
		} catch (SystemException e) {
			e.printStackTrace();
		}
		return donViThuTucList;
	}
	
	public List<DonViThuTuc> findByCapDonVi(int capDonVi) {
		List<DonViThuTuc> donViThuTucList = new ArrayList<DonViThuTuc>();
		try {
			donViThuTucList = donViThuTucPersistence.findByCapDonVi(capDonVi);
		} catch (SystemException e) {
			e.printStackTrace();
		}
		return donViThuTucList;
	}
	
	public List<DonViThuTuc> findByCapDonVi_Active(int capDonVi, int active) {
		List<DonViThuTuc> donViThuTucList = new ArrayList<DonViThuTuc>();
		try {
			donViThuTucList = donViThuTucPersistence.findByCapDonVi_Active(capDonVi, active);
		} catch (SystemException e) {
			e.printStackTrace();
		}
		return donViThuTucList;
	}
	
}
