package com.nss.portlet.loai_van_ban.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.nss.portlet.loai_van_ban.model.LoaiVanBan;
import com.nss.portlet.loai_van_ban.service.base.LoaiVanBanLocalServiceBaseImpl;


public class LoaiVanBanLocalServiceImpl extends LoaiVanBanLocalServiceBaseImpl {
	public int countByKeywords(String keywords) throws SystemException{
		return loaiVanBanFinder.countByKeywords(keywords);
	}
	
	public int countByTEN_MOTA(String name, String des, boolean andOperator) throws SystemException{
		return loaiVanBanFinder.countByTEN_MOTA(name, des, andOperator);
	}
	
	public List<LoaiVanBan> findByKeywords(String keywords,int start, int end, OrderByComparator obc) throws SystemException{
		return loaiVanBanFinder.findByKeywords(keywords, start, end, obc);
	}
	
	public List<LoaiVanBan> findTEN_MOTA(String name, String des, boolean andOperator, int start, int end, OrderByComparator obc) throws SystemException {
		return loaiVanBanFinder.findTEN_MOTA(name, des, andOperator, start, end, obc);
	}
	
	public List<LoaiVanBan> findByActive(int active) {
		List<LoaiVanBan> loaiVanBanList = new ArrayList<LoaiVanBan>();
		try {
			loaiVanBanList = loaiVanBanPersistence.findByActive(active);
		} catch (SystemException e) {
			e.printStackTrace();
		}
		return loaiVanBanList;
	}
}
