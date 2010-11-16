package com.nss.portlet.link.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.nss.portlet.link.model.LoaiWebsite;
import com.nss.portlet.link.service.base.LoaiWebsiteLocalServiceBaseImpl;


public class LoaiWebsiteLocalServiceImpl extends LoaiWebsiteLocalServiceBaseImpl {
	public int countLoaiWebsiteByKeywords(String keywords) throws SystemException {
		return loaiWebsiteFinder.countByKeywords(keywords);
	}
	
	public int countLoaiWebsite(String name, String des, boolean andOperator) throws SystemException{
		return loaiWebsiteFinder.countByTEN_MOTA(name, des, andOperator);
	}
	
	public List<LoaiWebsite> findLoaiWebsiteByKeywords(String keywords,int start, int end, OrderByComparator obc) throws SystemException{
		return loaiWebsiteFinder.findByKeywords(keywords, start, end, obc);
	}
	
	public List<LoaiWebsite> findLoaiWebsite(String name, String des, boolean andOperator, int start, int end, OrderByComparator obc) throws SystemException {
		return loaiWebsiteFinder.findTEN_MOTA(name, des, andOperator, start, end, obc);
	}
	
	public List<LoaiWebsite> findByActive(int active) {
		List<LoaiWebsite> loaiWebsiteList = new ArrayList<LoaiWebsite>();
		try {
			loaiWebsiteList = loaiWebsitePersistence.findByActive(active);
		} catch (SystemException e) {
			e.printStackTrace();
		}
		return loaiWebsiteList;
	}
}
