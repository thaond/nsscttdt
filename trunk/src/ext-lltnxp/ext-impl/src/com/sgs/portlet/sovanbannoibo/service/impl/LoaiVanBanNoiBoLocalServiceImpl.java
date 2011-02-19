package com.sgs.portlet.sovanbannoibo.service.impl;

import java.util.List;

import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.sgs.portlet.sovanbannoibo.model.LoaiVanBanNoiBo;
import com.sgs.portlet.sovanbannoibo.service.base.LoaiVanBanNoiBoLocalServiceBaseImpl;


public class LoaiVanBanNoiBoLocalServiceImpl extends LoaiVanBanNoiBoLocalServiceBaseImpl {
	
	public int countByKeyword(String keyword) throws SystemException{
		return loaiVanBanNoiBoFinder.countByKeywords(keyword);
	}
	
	public List<LoaiVanBanNoiBo> findByKeyword(String keyword, int start, int end, OrderByComparator obc) throws SystemException{
		return loaiVanBanNoiBoFinder.findByKeywords(keyword, start, end, obc);
	}
	
	public int countLoaiVanBanNoiBo(String kyHieuLoaiVanBanNoiBos, String tenLoaiVanBanNoiBos, boolean andOperator) throws SystemException {
		return loaiVanBanNoiBoFinder.count_loai_van_ban_noi_bo(kyHieuLoaiVanBanNoiBos, tenLoaiVanBanNoiBos, andOperator);
	}
	
	public List<LoaiVanBanNoiBo> findLoaiVanBanNoiBo(String kyHieuLoaiVanBanNoiBos, String tenLoaiVanBanNoiBos, int start, int end, boolean andOperator, OrderByComparator obc) throws SystemException{
		return loaiVanBanNoiBoFinder.find_loai_van_ban_noi_bo(kyHieuLoaiVanBanNoiBos, tenLoaiVanBanNoiBos, start, end, andOperator, obc);
	}
}
