package com.nss.portlet.linh_vuc_van_ban.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.nss.portlet.linh_vuc_van_ban.model.LinhVucVanBan;
import com.nss.portlet.linh_vuc_van_ban.service.base.LinhVucVanBanLocalServiceBaseImpl;


public class LinhVucVanBanLocalServiceImpl
    extends LinhVucVanBanLocalServiceBaseImpl {
	public int countByKeywords(String keywords) throws SystemException{
		return linhVucVanBanFinder.countByKeywords(keywords);
	}
	
	public int countByTEN_MOTA(String name, String des, boolean andOperator) throws SystemException{
		return linhVucVanBanFinder.countByTEN_MOTA(name, des, andOperator);
	}
	
	public List<LinhVucVanBan> findByKeywords(String keywords,int start, int end, OrderByComparator obc) throws SystemException{
		return linhVucVanBanFinder.findByKeywords(keywords, start, end, obc);
	}
	
	public List<LinhVucVanBan> findTEN_MOTA(String name, String des, boolean andOperator, int start, int end, OrderByComparator obc) throws SystemException {
		return linhVucVanBanFinder.findTEN_MOTA(name, des, andOperator, start, end, obc);
	}
	
	public List<LinhVucVanBan> getListLinhVucVanBanByParenId(long parentId) {
		List<LinhVucVanBan> linhVucVanBanList = new ArrayList<LinhVucVanBan>();
		try {
			linhVucVanBanList = linhVucVanBanPersistence.findByParentId(parentId);
		} catch (SystemException e) {
			e.printStackTrace();
		}
		return linhVucVanBanList;
	}
	
	public List<LinhVucVanBan> findByActive(int active) {
		List<LinhVucVanBan> linhVucVanBanList = new ArrayList<LinhVucVanBan>();
		try {
			linhVucVanBanList = linhVucVanBanPersistence.findByActive(active);
		} catch (SystemException e) {
			e.printStackTrace();
		}
		return linhVucVanBanList;
	}
}
