package com.sgs.portlet.document.receipt.service.persistence;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.Type;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;
import com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp;
import com.sgs.portlet.document.receipt.model.impl.PmlEdmDocumentReceiptTempImpl;

public class PmlEdmDocumentReceiptTempFinderImpl extends BasePersistenceImpl implements PmlEdmDocumentReceiptTempFinder{
	public int countPmlEdmDocumentReceiptTemp(String soVBDen, String soHieuGoc, int loaiSoVanBan, String issuingplaceId, String noiBanHanh,
			String trichYeu, String tuNgay, String denNgay) throws SystemException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		String fromDate = "";
		String toDate = "";
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		int year = calendar.get(Calendar.YEAR);
		try {
			if ("".equals(tuNgay) && "".equals(denNgay)) {
				fromDate = sdf.format(df.parse("01/01/" + year));
				toDate = sdf.format(df.parse("31/12/" + year));
			} else {
				fromDate = sdf.format(df.parse(tuNgay));
				toDate = sdf.format(df.parse(denNgay));
			}
		} catch (ParseException e) { }
		
		Session session = null;
		try {
			session = openSession();
			String sql = "SELECT COUNT(*) AS COUNT_VALUE ";
			sql += " FROM pml_edm_documentreceipt_temp cv";
			if (0 != loaiSoVanBan) { // chon loai so cong van
				sql += ", pml_edm_documenttype dt, pml_edm_documentrecordtype drt";
			}
			
			if (!"".equals(issuingplaceId)) {
				sql += ", pml_edm_issuingplace iss ";
			}
			
			sql += " WHERE ('" + fromDate + "' <= cv.datearrive AND cv.datearrive <= '" + toDate + "') ";
			
			if (0 != loaiSoVanBan) {
				sql += " AND cv.documenttypeid = dt.documenttypeid AND dt.documentrecordtypeid = drt.documentrecordtypeid AND drt.documentrecordtypeid = " + loaiSoVanBan;
			}
			
			if (!"".equals(soVBDen)) {
				sql += " AND (lower(cv.numberdocumentreceipt) LIKE (lower('%" + soVBDen + "%'))) ";
			}
			
			if (!"".equals(soHieuGoc)) {
				sql += " AND (lower(cv.documentreference) LIKE (lower('%" + soHieuGoc + "%'))) ";
			}
			
			if (!"".equals(issuingplaceId)) {
				sql += " AND cv.issuingplaceid = iss.issuingplaceid ";
				sql += " AND iss.issuingplaceid = '" + issuingplaceId + "' ";
			}
			
			if (!"".equals(noiBanHanh)) {
				sql += " AND (lower(cv.issuingplaceothername) LIKE (lower('%" + noiBanHanh + "%'))) ";
			}
			
			if (!"".equals(trichYeu)) {
				sql += " AND (lower(cv.briefcontent) LIKE (lower('%" + trichYeu + "%'))) ";
			}
			
			SQLQuery q = session.createSQLQuery(sql);
			q.addScalar(COUNT_COLUMN_NAME, Type.LONG);
			
			Long count = null;

			Iterator<Long> itr = q.list().iterator();

			if (itr.hasNext()) {
				count = itr.next();
			}

			if (count == null) {
				count = new Long(0);
			}

			return count.intValue();
		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}
	
	public List<PmlEdmDocumentReceiptTemp> listPmlEdmDocumentReceiptTemp(String soVBDen, String soHieuGoc, int loaiSoVanBan, String issuingplaceId, String noiBanHanh,
			String trichYeu, String tuNgay, String denNgay, int start, int end, OrderByComparator obc) throws SystemException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		String fromDate = "";
		String toDate = "";
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		int year = calendar.get(Calendar.YEAR);
		try {
			if ("".equals(tuNgay) && "".equals(denNgay)) {
				fromDate = sdf.format(df.parse("01/01/" + year));
				toDate = sdf.format(df.parse("31/12/" + year));
			} else {
				fromDate = sdf.format(df.parse(tuNgay));
				toDate = sdf.format(df.parse(denNgay));
			}
		} catch (ParseException e) { }
		
		Session session = null;
		try {
			session = openSession();
			String sql = "SELECT cv.* ";
			sql += " FROM pml_edm_documentreceipt_temp cv";
			if (0 != loaiSoVanBan) { // chon loai so cong van
				sql += ", pml_edm_documenttype dt, pml_edm_documentrecordtype drt";
			}
			
			if (!"".equals(issuingplaceId)) {
				sql += ", pml_edm_issuingplace iss ";
			}
			
			sql += " WHERE ('" + fromDate + "' <= cv.datearrive AND cv.datearrive <= '" + toDate + "') ";
			
			if (0 != loaiSoVanBan) {
				sql += " AND cv.documenttypeid = dt.documenttypeid AND dt.documentrecordtypeid = drt.documentrecordtypeid AND drt.documentrecordtypeid = " + loaiSoVanBan;
			}
			
			if (!"".equals(soVBDen)) {
				sql += " AND (lower(cv.numberdocumentreceipt) LIKE (lower('%" + soVBDen + "%'))) ";
			}
			
			if (!"".equals(soHieuGoc)) {
				sql += " AND (lower(cv.documentreference) LIKE (lower('%" + soHieuGoc + "%'))) ";
			}
			
			if (!"".equals(issuingplaceId)) {
				sql += " AND cv.issuingplaceid = iss.issuingplaceid ";
				sql += " AND iss.issuingplaceid = '" + issuingplaceId + "' ";
			}
			
			if (!"".equals(noiBanHanh)) {
				sql += " AND (lower(cv.issuingplaceothername) LIKE (lower('%" + noiBanHanh + "%'))) ";
			}
			
			if (!"".equals(trichYeu)) {
				sql += " AND (lower(cv.briefcontent) LIKE (lower('%" + trichYeu + "%'))) ";
			}
			sql = CustomSQLUtil.replaceOrderBy(sql, obc);

			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("PmlEdmDocumentReceiptTemp", PmlEdmDocumentReceiptTempImpl.class);

			return (List<PmlEdmDocumentReceiptTemp>) QueryUtil.list(q, getDialect(), start, end);
		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}
	
	public List<PmlEdmDocumentReceiptTemp> getAllList(int start, int end, OrderByComparator obc) throws SystemException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		String fromDate = "";
		String toDate = "";
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		int year = calendar.get(Calendar.YEAR);
		try {
			fromDate = sdf.format(df.parse("01/01/" + year));
			toDate = sdf.format(df.parse("31/12/" + year));
		} catch (ParseException e) { }
		
		Session session = null;
		try {
			session = openSession();
			String sql = "SELECT cv.* ";
			sql += " FROM pml_edm_documentreceipt_temp cv";
			
			sql += " WHERE ('" + fromDate + "' <= cv.datearrive AND cv.datearrive <= '" + toDate + "') ";
			
			sql = CustomSQLUtil.replaceOrderBy(sql, obc);
			
			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("PmlEdmDocumentReceiptTemp", PmlEdmDocumentReceiptTempImpl.class);

			return (List<PmlEdmDocumentReceiptTemp>) QueryUtil.list(q, getDialect(), start, end);
		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}
	
	public int countAllList() throws SystemException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		String fromDate = "";
		String toDate = "";
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		int year = calendar.get(Calendar.YEAR);
		try {
			fromDate = sdf.format(df.parse("01/01/" + year));
			toDate = sdf.format(df.parse("31/12/" + year));
		} catch (ParseException e) { }
		
		Session session = null;
		try {
			session = openSession();
			String sql = "SELECT COUNT(*) AS COUNT_VALUE ";
			sql += " FROM pml_edm_documentreceipt_temp cv";
			
			sql += " WHERE ('" + fromDate + "' <= cv.datearrive AND cv.datearrive <= '" + toDate + "') ";
			
			SQLQuery q = session.createSQLQuery(sql);
			q.addScalar(COUNT_COLUMN_NAME, Type.LONG);
			
			Long count = null;

			Iterator<Long> itr = q.list().iterator();

			if (itr.hasNext()) {
				count = itr.next();
			}

			if (count == null) {
				count = new Long(0);
			}

			return count.intValue();
		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}
	
}
