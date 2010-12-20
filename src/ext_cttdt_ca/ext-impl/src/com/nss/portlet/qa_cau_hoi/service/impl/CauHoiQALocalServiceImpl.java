package com.nss.portlet.qa_cau_hoi.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.nss.portlet.qa_cau_hoi.model.CauHoiQA;
import com.nss.portlet.qa_cau_hoi.service.base.CauHoiQALocalServiceBaseImpl;


public class CauHoiQALocalServiceImpl extends CauHoiQALocalServiceBaseImpl {
	public List<CauHoiQA> findTieuDe_ChuDe(long maChuDeCauHoi, String name, boolean andOperator, int start, int end, OrderByComparator obc) throws SystemException {
		return cauHoiQAFinder.findTieuDe_ChuDe(maChuDeCauHoi, name, andOperator, start, end, obc);
	}
	
	public int countByTieuDe_ChuDe(long maChuDeCauHoi, String name, boolean andOperator) throws SystemException{
		return cauHoiQAFinder.countByTieuDe_ChuDe(maChuDeCauHoi, name, andOperator);
	}
	
	public int countByTieuDe_ChuDe_PhanQuyen(long userId, long maChuDeCauHoi, String name, boolean andOperator) throws SystemException{
		return cauHoiQAFinder.countByTieuDe_ChuDe_PhanQuyen(userId, maChuDeCauHoi, name, andOperator);
	}
	
	public List<CauHoiQA> findTieuDe_ChuDe_PhanQuyen(long userId, long maChuDeCauHoi, String name, boolean andOperator, int start, int end, OrderByComparator obc) throws SystemException {
		return cauHoiQAFinder.findTieuDe_ChuDe_PhanQuyen(userId, maChuDeCauHoi, name, andOperator, start, end, obc);
	}
	
	public List<CauHoiQA> findByMaChuDeCauHoi(long maChuDeCauHoi) {
		List<CauHoiQA> cauHoiQAList = new ArrayList<CauHoiQA>();
		try {
			cauHoiQAList = cauHoiQAPersistence.findByMaChuDeCauHoi_Publish(maChuDeCauHoi, true);
		} catch (SystemException e) {
			cauHoiQAList = new ArrayList<CauHoiQA>();
		}
		
		return cauHoiQAList;
	}
}
