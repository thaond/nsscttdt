package com.nss.portlet.thong_tin_lien_quan.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.nss.portlet.thong_tin_lien_quan.model.ThongTinLienQuan;
import com.nss.portlet.thong_tin_lien_quan.service.base.ThongTinLienQuanLocalServiceBaseImpl;


public class ThongTinLienQuanLocalServiceImpl
    extends ThongTinLienQuanLocalServiceBaseImpl {
	public int countByKeywords(String keywords) throws SystemException{
		return thongTinLienQuanFinder.countByKeywords(keywords);
	}
	
	public int searchCount(String name, String des, boolean andOperator) throws SystemException{
		return thongTinLienQuanFinder.countByTEN_MOTA(name, des, andOperator);
	}
	
	public List<ThongTinLienQuan> findByKeywords(String keywords,int start, int end, OrderByComparator obc) throws SystemException{
		return thongTinLienQuanFinder.findByKeywords(keywords, start, end, obc);
	}
	
	public List<ThongTinLienQuan> search(String name, String des, boolean andOperator, int start, int end, OrderByComparator obc) throws SystemException {
		return thongTinLienQuanFinder.findTEN_MOTA(name, des, andOperator, start, end, obc);
	}
	
	public List<ThongTinLienQuan> findByActive(int active) {
		List<ThongTinLienQuan> thongTinLienQuanList = new ArrayList<ThongTinLienQuan>();
		try {
			thongTinLienQuanList = thongTinLienQuanPersistence.findByActive(active);
		} catch (SystemException e) {
			e.printStackTrace();
		}
		return thongTinLienQuanList;
	}
}
