package com.nss.portlet.necessary_info.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.nss.portlet.necessary_info.model.ThongTinCanThiet;
import com.nss.portlet.necessary_info.service.base.ThongTinCanThietLocalServiceBaseImpl;


public class ThongTinCanThietLocalServiceImpl
    extends ThongTinCanThietLocalServiceBaseImpl {
	
	public int countByKeywords(String keywords) throws SystemException{
		return thongTinCanThietFinder.countByKeywords(keywords);
	}
	
	public int searchCount(String name, String des, boolean andOperator) throws SystemException{
		return thongTinCanThietFinder.countByTEN_MOTA(name, des, andOperator);
	}
	
	public List<ThongTinCanThiet> findByKeywords(String keywords,int start, int end, OrderByComparator obc) throws SystemException{
		return thongTinCanThietFinder.findByKeywords(keywords, start, end, obc);
	}
	
	public List<ThongTinCanThiet> search(String name, String des, boolean andOperator, int start, int end, OrderByComparator obc) throws SystemException {
		return thongTinCanThietFinder.findTEN_MOTA(name, des, andOperator, start, end, obc);
	}
	
	public List<ThongTinCanThiet> findByActive(int active) {
		List<ThongTinCanThiet> thongTinCanThietList = new ArrayList<ThongTinCanThiet>();
		try {
			thongTinCanThietList = thongTinCanThietPersistence.findByActive(active);
		} catch (SystemException e) {
			e.printStackTrace();
		}
		return thongTinCanThietList;
	}
}
