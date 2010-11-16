package com.nss.portlet.van_ban_phap_quy.service.impl;

import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.search.BooleanClauseOccur;
import com.liferay.portal.kernel.search.BooleanQuery;
import com.liferay.portal.kernel.search.BooleanQueryFactoryUtil;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Hits;
import com.liferay.portal.kernel.search.SearchEngineUtil;
import com.liferay.portal.kernel.search.SearchException;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.Validator;
import com.nss.portlet.van_ban_phap_quy.NoSuchVanBanPhapQuyException;
import com.nss.portlet.van_ban_phap_quy.model.VanBanPhapQuy;
import com.nss.portlet.van_ban_phap_quy.search.VanBanPhapQuyDisplayTerms;
import com.nss.portlet.van_ban_phap_quy.service.base.VanBanPhapQuyLocalServiceBaseImpl;
import com.nss.portlet.van_ban_phap_quy.util.VanBanPhapQuyIndexer;

public class VanBanPhapQuyLocalServiceImpl
    extends VanBanPhapQuyLocalServiceBaseImpl {
	
//	minh 
	
	public int searchCount(String keywords) throws SystemException{
		return vanBanPhapQuyFinder.countByKeywords(keywords);
	}
	
	public int searchCount(String kyHieuVanBan, boolean andOperator) throws SystemException{
		return vanBanPhapQuyFinder.countByVanBanPhapQuy(kyHieuVanBan, andOperator);
	}
	
	public List<VanBanPhapQuy> search(String keywords, int start, int end, OrderByComparator obc) throws SystemException{
		return vanBanPhapQuyFinder.findByKeywords(keywords, start, end, obc);
	}
	
	public List<VanBanPhapQuy> search(String kyHieuVanBan, boolean andOperator, int start, int end, OrderByComparator obc) throws SystemException{
		return vanBanPhapQuyFinder.findByVanBanPhapQuy(kyHieuVanBan, andOperator, start, end, obc);
	}
	
//  end	
	
	// yenlt 13072010
	public void reIndex(long companyId, VanBanPhapQuy vanBanPhapQuy) throws SearchException {
		try {
			VanBanPhapQuyIndexer.updateVanBanPhapQuy(companyId, vanBanPhapQuy);
		} catch (UnsupportedEncodingException e) {
			throw new SearchException(e);
		}
	}
	
	public void reIndex(String[] ids) throws SystemException, SearchException {
		long companyId = GetterUtil.getLong(ids[0]);

		for (VanBanPhapQuy vanBanPhapQuy : vanBanPhapQuyPersistence.findAll()) {
			reIndex(companyId, vanBanPhapQuy);
		}
	}
	
	public Hits search(long companyId, String kyHieuVanBan, String tomTat, String nguoiKy, long maLoaiVanBan, long maLinhVucVanBan, long maCoQuanBanHanh,
			 Date tuNgay, Date denNgay, String sortField, int sortType, boolean reverse, int start, int end) throws SystemException {
		try {
			DateFormat df = new SimpleDateFormat("yyyyMMdd");

			StringBuilder sb = new StringBuilder();
			
			String tuNgayStr = tuNgay != null ? df.format(tuNgay) : "";
			String denNgayStr = denNgay != null ? df.format(denNgay) : "";

			if (!tuNgayStr.equals(denNgayStr)) {
				sb.append("[");
				sb.append(tuNgayStr);
				sb.append(" TO ");
				sb.append(denNgayStr);
				sb.append("]");
			} else {
				sb.append(tuNgayStr);
			}
			
			BooleanQuery contextQuery = BooleanQueryFactoryUtil.create();
			contextQuery.addRequiredTerm(Field.PORTLET_ID, VanBanPhapQuyIndexer.PORTLET_ID);
			
			BooleanQuery kyHieuVanBanQuery = BooleanQueryFactoryUtil.create();
			BooleanQuery tomTatQuery = BooleanQueryFactoryUtil.create();
			BooleanQuery nguoiKyQuery = BooleanQueryFactoryUtil.create();
			BooleanQuery loaiVBQuery = BooleanQueryFactoryUtil.create();
			BooleanQuery linhVucVBQuery = BooleanQueryFactoryUtil.create();
			BooleanQuery coQuanBanHanhQuery = BooleanQueryFactoryUtil.create();
			BooleanQuery rangeQuery = BooleanQueryFactoryUtil.create();
			
			List<BooleanQuery> booleanQueries = new ArrayList<BooleanQuery>();
			
			if (Validator.isNotNull(kyHieuVanBan)) {
				kyHieuVanBanQuery.addTerm(VanBanPhapQuyDisplayTerms.KY_HIEU_VAN_BAN, kyHieuVanBan);
				booleanQueries.add(kyHieuVanBanQuery);
			}
			
			if (Validator.isNotNull(tomTat)) {
				tomTatQuery.addTerm(VanBanPhapQuyDisplayTerms.TOM_TAT, tomTat);
				booleanQueries.add(tomTatQuery);
			}
			
			if (Validator.isNotNull(nguoiKy)) {
				nguoiKyQuery.addTerm(VanBanPhapQuyDisplayTerms.NGUOI_KY, nguoiKy);
				booleanQueries.add(nguoiKyQuery);
			}
			
			if (maLoaiVanBan > 0) {
				loaiVBQuery.addTerm(VanBanPhapQuyDisplayTerms.MA_LOAI_VAN_BAN, maLoaiVanBan);
				booleanQueries.add(loaiVBQuery);
			}
			
			if (maLinhVucVanBan > 0) {
				linhVucVBQuery.addTerm(VanBanPhapQuyDisplayTerms.MA_LINH_VUC_VAN_BAN, maLinhVucVanBan);
				booleanQueries.add(linhVucVBQuery);
			}
			
			if (maCoQuanBanHanh > 0) {
				coQuanBanHanhQuery.addTerm(VanBanPhapQuyDisplayTerms.MA_CO_QUAN_BAN_HANH, maCoQuanBanHanh);
				booleanQueries.add(coQuanBanHanhQuery);
			}
			
			if (sb.length() > 6) {
				rangeQuery.addTerm("ngayBanHanh", sb.toString());
				booleanQueries.add(rangeQuery);
			}
			
			BooleanQuery fullQuery = BooleanQueryFactoryUtil.create();

			fullQuery.add(contextQuery, BooleanClauseOccur.MUST);
			for (int i = 0; i < booleanQueries.size(); i++) {
				fullQuery.add(booleanQueries.get(i), BooleanClauseOccur.MUST);
			}

			Sort sort;

			if (sortField.equals("ngayBanHanh")) {
				sort = new Sort(sortField, sortType, reverse);
			} else {
				sort = new Sort(sortField, sortType, reverse);
			}
			
			return SearchEngineUtil.search(companyId, fullQuery, sort, start, end);
		} catch (Exception e) {
			throw new SystemException(e);
		}
	}
	
	public Hits searchDisplay(long companyId, long maLoaiVanBan, long maLinhVucVanBan, long maCoQuanBanHanh, String sortField, int sortType, boolean reverse, int start, int end) throws SystemException {
		try {
			
			BooleanQuery contextQuery = BooleanQueryFactoryUtil.create();
			BooleanQuery loaiVBQuery = BooleanQueryFactoryUtil.create();
			BooleanQuery linhVucVBQuery = BooleanQueryFactoryUtil.create();
			BooleanQuery coQuanBanHanhQuery = BooleanQueryFactoryUtil.create();
			List<BooleanQuery> booleanQueries = new ArrayList<BooleanQuery>();
			
			contextQuery.addRequiredTerm(Field.COMPANY_ID, companyId);
			
			if (Validator.isNotNull(VanBanPhapQuyIndexer.PORTLET_ID)) {
				contextQuery.addRequiredTerm(Field.PORTLET_ID, VanBanPhapQuyIndexer.PORTLET_ID);
			}
			
			if (maLoaiVanBan > 0) {
				loaiVBQuery.addTerm(VanBanPhapQuyDisplayTerms.MA_LOAI_VAN_BAN, maLoaiVanBan);
				booleanQueries.add(loaiVBQuery);
			}
			
			if (maLinhVucVanBan > 0) {
				linhVucVBQuery.addTerm(VanBanPhapQuyDisplayTerms.MA_LINH_VUC_VAN_BAN, maLinhVucVanBan);
				booleanQueries.add(linhVucVBQuery);
			}
			
			if (maCoQuanBanHanh > 0) {
				coQuanBanHanhQuery.addTerm(VanBanPhapQuyDisplayTerms.MA_CO_QUAN_BAN_HANH, maCoQuanBanHanh);
				booleanQueries.add(coQuanBanHanhQuery);
			}
			
			BooleanQuery fullQuery = BooleanQueryFactoryUtil.create();

			fullQuery.add(contextQuery, BooleanClauseOccur.MUST);
			for (int i = 0; i < booleanQueries.size(); i++) {
				fullQuery.add(booleanQueries.get(i), BooleanClauseOccur.MUST);
			}

			Sort sort;

			if (sortField.equals("ngayBanHanh")) {
				sort = new Sort(sortField, sortType, reverse);
			} else {
				sort = new Sort(sortField, sortType, reverse);
			}
			
			return SearchEngineUtil.search(companyId, fullQuery, sort, start, end);
		} catch (Exception e) {
			throw new SystemException(e);
		}
	}
	
	// tim kiem co ban == full text
	public Hits search(long companyId, String keywords, String sortField, int sortType, boolean reverse, int start, int end) throws SystemException {
		try {
			
			BooleanQuery contextQuery = BooleanQueryFactoryUtil.create();
			
			contextQuery.addRequiredTerm(Field.COMPANY_ID, companyId);
			
			if (Validator.isNotNull(VanBanPhapQuyIndexer.PORTLET_ID)) {
				contextQuery.addRequiredTerm(Field.PORTLET_ID, VanBanPhapQuyIndexer.PORTLET_ID);
			}
			
			BooleanQuery searchQuery = BooleanQueryFactoryUtil.create();

			if (Validator.isNotNull(keywords)) {
				searchQuery.addTerm(Field.TITLE, keywords);
				searchQuery.addTerm("kyHieuVanBan", keywords + "*");
				searchQuery.addTerm("tomTat", keywords);
				searchQuery.addTerm("nguoiKy", keywords);
				searchQuery.addTerm("loaiVanBan", keywords);
				searchQuery.addTerm("linhVucVanBan", keywords);
				searchQuery.addTerm("coQuanBanHanh", keywords);
			}

			BooleanQuery fullQuery = BooleanQueryFactoryUtil.create();

			fullQuery.add(contextQuery, BooleanClauseOccur.MUST);

			if (searchQuery.clauses().size() > 0) {
				fullQuery.add(searchQuery, BooleanClauseOccur.MUST);
			}

			Sort sort;

			if (sortField.equals("ngayBanHanh")) {
				sort = new Sort(sortField, sortType, reverse);
			} else {
				sort = new Sort(sortField, sortType, reverse);
			}
			
			return SearchEngineUtil.search(companyId, fullQuery, sort, start, end);
			
		} catch (Exception e) {
			throw new SystemException(e);
		}
	}
	
	
	
	public VanBanPhapQuy addVanBanPhapQuy(long companyId, String kyHieuVanBan, long maLoaiVanBan, long maLinhVucVanBan, long maCoQuanBanHanh,
			String tomTat, String nguoiKy, Date ngayBanHanh) throws SystemException, SearchException {
		
		long maVanBanPhapQuy = 0;
		maVanBanPhapQuy = CounterLocalServiceUtil.increment();
		VanBanPhapQuy vanBanPhapQuy = vanBanPhapQuyPersistence.create(maVanBanPhapQuy);
		
		vanBanPhapQuy.setMaVanBanPhapQuy(maVanBanPhapQuy);
		vanBanPhapQuy.setKyHieuVanBan(kyHieuVanBan);
		vanBanPhapQuy.setNguoiKy(nguoiKy);
		vanBanPhapQuy.setTomTat(tomTat);
		vanBanPhapQuy.setMaLoaiVanBan(maLoaiVanBan);
		vanBanPhapQuy.setMaLinhVucVanBan(maLinhVucVanBan);
		vanBanPhapQuy.setMaCoQuanBanHanh(maCoQuanBanHanh);
		vanBanPhapQuy.setNgayBanHanh(ngayBanHanh);
		vanBanPhapQuy.setNew(true);
		
		vanBanPhapQuyPersistence.update(vanBanPhapQuy, false);
		reIndex(companyId, vanBanPhapQuy);
		return vanBanPhapQuy;
	}
	
	public VanBanPhapQuy addVanBanPhapQuy(long companyId, VanBanPhapQuy vanBanPhapQuy) throws SystemException, SearchException {
		vanBanPhapQuy.setNew(true);
		vanBanPhapQuyPersistence.update(vanBanPhapQuy, false);
		
		reIndex(companyId, vanBanPhapQuy);
		return vanBanPhapQuy;
	}
	
	@Override
	public VanBanPhapQuy addVanBanPhapQuy(VanBanPhapQuy vanBanPhapQuy) throws SystemException {
		throw new SystemException(
		"Please use method: addVanBanPhapQuy(long companyId, VanBanPhapQuy vanBanPhapQuy)");
	}
	
	public VanBanPhapQuy updateVanBanPhapQuy(long companyId, long maVanBanPhapQuy, String kyHieuVanBan, long maLoaiVanBan, long maLinhVucVanBan, long maCoQuanBanHanh,
			String tomTat, String nguoiKy, Date ngayBanHanh) throws SystemException, SearchException, NoSuchVanBanPhapQuyException {
	
		VanBanPhapQuy vanBanPhapQuy = vanBanPhapQuyPersistence.findByPrimaryKey(maVanBanPhapQuy);
		
		vanBanPhapQuy.setMaVanBanPhapQuy(maVanBanPhapQuy);
		vanBanPhapQuy.setKyHieuVanBan(kyHieuVanBan);
		vanBanPhapQuy.setNguoiKy(nguoiKy);
		vanBanPhapQuy.setTomTat(tomTat);
		vanBanPhapQuy.setMaLoaiVanBan(maLoaiVanBan);
		vanBanPhapQuy.setMaLinhVucVanBan(maLinhVucVanBan);
		vanBanPhapQuy.setMaCoQuanBanHanh(maCoQuanBanHanh);
		vanBanPhapQuy.setNgayBanHanh(ngayBanHanh);
		
		vanBanPhapQuyPersistence.update(vanBanPhapQuy, true);
		reIndex(companyId, vanBanPhapQuy);
		return vanBanPhapQuy;
	}
	
	public VanBanPhapQuy updateVanBanPhapQuy(long companyId, VanBanPhapQuy vanBanPhapQuy) throws SystemException, SearchException {
		vanBanPhapQuyPersistence.update(vanBanPhapQuy, false);
		
		reIndex(companyId, vanBanPhapQuy);
		return vanBanPhapQuy;
	}
	
	@Override
	public VanBanPhapQuy updateVanBanPhapQuy(VanBanPhapQuy vanBanPhapQuy) throws SystemException {
		throw new SystemException(
		"Please use method: upDateVanBanPhapQuy(long companyId, VanBanPhapQuy vanBanPhapQuy)");
	}
	
	public void deleteVanBanPhapQuy(long companyId, long maVanBanPhapQuy) throws NoSuchVanBanPhapQuyException, SystemException, SearchException {
		VanBanPhapQuy vanBanPhapQuy = vanBanPhapQuyPersistence.findByPrimaryKey(maVanBanPhapQuy);
		deleteVanBanPhapQuy(companyId, vanBanPhapQuy);
		
	}
	
	public void deleteVanBanPhapQuy(long companyId, VanBanPhapQuy vanBanPhapQuy) throws SystemException, SearchException {
		vanBanPhapQuyPersistence.remove(vanBanPhapQuy);
		try {
			VanBanPhapQuyIndexer.deleteVanBanPhapQuy(companyId, vanBanPhapQuy);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void deleteVanBanPhapQuy(long maVanBanPhapQuy) throws SystemException {
		throw new SystemException(
		"Please use method: deletePmlEdmDocumentSend(long companyId, long maVanBanPhapQuy)");
	}
	
	@Override
	public void deleteVanBanPhapQuy(VanBanPhapQuy vanBanPhapQuy) throws SystemException {
		throw new SystemException(
		"Please use method: deletePmlEdmDocumentSend(long companyId, VanBanPhapQuy vanBanPhapQuy)");
	}
	
	public List<VanBanPhapQuy> getVanbanPhapQuyFromMaLinhVucVanBan(long maLinhVucVanBan) {
		List<VanBanPhapQuy> vanBanPhapQuyList = new ArrayList<VanBanPhapQuy>();
		try {
			vanBanPhapQuyList = vanBanPhapQuyPersistence.findByMaLinhVucVanBan(maLinhVucVanBan);
		} catch (SystemException e) {
			e.printStackTrace();
		}
		return vanBanPhapQuyList;
	}
	
	public List<VanBanPhapQuy> getVanbanPhapQuyFromMaLoaiVanBan(long maLoaiVanBan) {
		List<VanBanPhapQuy> vanBanPhapQuyList = new ArrayList<VanBanPhapQuy>();
		try {
			vanBanPhapQuyList = vanBanPhapQuyPersistence.findByMaLoaiVanBan(maLoaiVanBan);
		} catch (SystemException e) {
			e.printStackTrace();
		}
		return vanBanPhapQuyList;
	}
	public List<VanBanPhapQuy> getVanbanPhapQuyFromMaCoQuanBanHanh(long maCoQuanBanHanh) {
		List<VanBanPhapQuy> vanBanPhapQuyList = new ArrayList<VanBanPhapQuy>();
		try {
			vanBanPhapQuyList = vanBanPhapQuyPersistence.findByMaCoQuanBanHanh(maCoQuanBanHanh);
		} catch (SystemException e) {
			e.printStackTrace();
		}
		return vanBanPhapQuyList;
	}
	// end yenlt 13072010
}
