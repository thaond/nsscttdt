package com.sgs.portlet.pml_ho_so_cong_viec.service.persistence;

import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.Type;
import com.liferay.portal.kernel.util.CalendarUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;
import com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec;
import com.sgs.portlet.pml_ho_so_cong_viec.model.impl.PmlHoSoCongViecImpl;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * <a href="PmlHoSoCongViecFinderImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author XUANCONG
 *
 */
public class PmlHoSoCongViecFinderImpl
	extends BasePersistenceImpl implements PmlHoSoCongViecFinder {


	public static String COUNT_BY_S_T_N_I_V_I_I_T_H =
		PmlHoSoCongViecFinder.class.getName() + ".countByS_T_N_I_V_I_I_T_H";

	public static String FIND_BY_S_T_N_I_V_I_I_T_H =
		PmlHoSoCongViecFinder.class.getName() + ".findByS_T_N_I_V_I_I_T_H";

	public static String COUNT_BY_I_S =
		PmlHoSoCongViecFinder.class.getName() + ".countByI_S";

	public int countByKeywords(String keywords)
		throws SystemException {

		String[] soHieuHSCVs = null;
		String[] tieuDes = null;
		String[] vanDeLienQuans = null;
		String[] tomTatNoiDungs = null;
		String hoatDong = "1";
		boolean andOperator = false;

		if (Validator.isNotNull(keywords)) {
			soHieuHSCVs = CustomSQLUtil.keywords(keywords, false);
			tieuDes = CustomSQLUtil.keywords(keywords, false);
			vanDeLienQuans = CustomSQLUtil.keywords(keywords, false);
			tomTatNoiDungs = CustomSQLUtil.keywords(keywords, false);
		}
		else {
			andOperator = true;
		}

		return countByS_T_N_I_V_I_I_T_H(
				soHieuHSCVs, tieuDes, null, null, vanDeLienQuans, 0, 0, 
				tomTatNoiDungs, hoatDong, andOperator);
	}

	public int countByS_T_N_I_V_I_I_T_H(
			String soHieuHSCV, String tieuDe, Date ngayMoHSCV, String idLinhVuc, 
			String vanDeLienQuan, long idDoQuanTrong, long idTrangThaiHSCV, 
			String tomTatNoiDung, String hoatDong, boolean andOperator)
		throws SystemException {

		return countByS_T_N_I_V_I_I_T_H(
				new String[] {soHieuHSCV}, new String[] {tieuDe}, ngayMoHSCV, 
				idLinhVuc, new String[] {vanDeLienQuan}, idDoQuanTrong, 
				idTrangThaiHSCV, new String[] {tomTatNoiDung}, hoatDong, andOperator);
	}

	public int countByS_T_N_I_V_I_I_T_H(
			String[] soHieuHSCVs, String[] tieuDes, Date ngayMoHSCV, String idLinhVuc, 
			String[] vanDeLienQuans, long idDoQuanTrong, long idTrangThaiHSCV, 
			String[] tomTatNoiDungs, String hoatDong, boolean andOperator)
		throws SystemException {

		// Replace keywords
		soHieuHSCVs = CustomSQLUtil.keywords(soHieuHSCVs, false);
		tieuDes = CustomSQLUtil.keywords(tieuDes, false);
		vanDeLienQuans = CustomSQLUtil.keywords(vanDeLienQuans, false);
		tomTatNoiDungs = CustomSQLUtil.keywords(tomTatNoiDungs, false);

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String ngayMoHSCVDateStr = null;
		if (ngayMoHSCV != null) {
			ngayMoHSCVDateStr = format.format(ngayMoHSCV);
		}
		if (idLinhVuc != null && idLinhVuc.trim().equals("")) {
			idLinhVuc = null;
		}
		
		Session session = null;

		try {
			session = openSession();

			String sql = CustomSQLUtil.get(COUNT_BY_S_T_N_I_V_I_I_T_H);

			sql = CustomSQLUtil.replaceKeywords(
				sql, "so_hieu_hscv", StringPool.LIKE, false, soHieuHSCVs);
			sql = CustomSQLUtil.replaceKeywords(
				sql, "tieu_de", StringPool.LIKE, false, tieuDes);
			// Ngay mo
			if (ngayMoHSCV == null) {
				sql = StringUtil.replace(sql, "(substr(cast(ngay_mo_hscv as text), 1, 10) = ?) [$AND_OR_CONNECTOR$]", "");
			}
			// Linh vuc
			sql = CustomSQLUtil.replaceKeywords(
					sql, "id_linh_vuc", StringPool.EQUAL, false, new String[] {idLinhVuc});
			sql = CustomSQLUtil.replaceKeywords(
				sql, "van_de_lien_quan", StringPool.LIKE, false, vanDeLienQuans);
			// Do quan trong
			if (idDoQuanTrong <= 0) {
				sql = StringUtil.replace(sql, "(id_do_quan_trong = ?) [$AND_OR_CONNECTOR$]", "");
			}
			// Trang thai
			if (idTrangThaiHSCV <= 0) {
				sql = StringUtil.replace(sql, "(id_trang_thai_hscv = ?) [$AND_OR_CONNECTOR$]", "");
			}
			sql = CustomSQLUtil.replaceKeywords(
					sql, "tom_tat_noi_dung", StringPool.LIKE, false, tomTatNoiDungs);

			sql = CustomSQLUtil.replaceAndOperator(sql, andOperator);

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME, Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			// Add parameters value
			qPos.add(soHieuHSCVs, 2);
			qPos.add(tieuDes, 2);
			if (ngayMoHSCV != null) {
				qPos.add(ngayMoHSCVDateStr);
			}
			//qPos.add(new String[] {ngayMoHSCVDateStr}, 2);
			qPos.add(new String[] {idLinhVuc}, 2);
			qPos.add(vanDeLienQuans, 2);
			if (idDoQuanTrong > 0) {
				qPos.add(idDoQuanTrong);
			}
			if (idTrangThaiHSCV > 0) {
				qPos.add(idTrangThaiHSCV);
			}
			qPos.add(tomTatNoiDungs, 2);
			qPos.add(hoatDong);

			Iterator<Long> itr = q.list().iterator();

			if (itr.hasNext()) {
				Long count = itr.next();

				if (count != null) {
					return count.intValue();
				}
			}

			return 0;
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<PmlHoSoCongViec> findByKeywords(
			String keywords, int start, int end,
			OrderByComparator obc)
		throws SystemException {

		String[] soHieuHSCVs = null;
		String[] tieuDes = null;
		String[] vanDeLienQuans = null;
		String[] tomTatNoiDungs = null;
		String hoatDong = "1";
		boolean andOperator = false;

		if (Validator.isNotNull(keywords)) {
			soHieuHSCVs = CustomSQLUtil.keywords(keywords, false);
			tieuDes = CustomSQLUtil.keywords(keywords, false);
			vanDeLienQuans = CustomSQLUtil.keywords(keywords, false);
			tomTatNoiDungs = CustomSQLUtil.keywords(keywords, false);
		}
		else {
			andOperator = true;
		}

		return findByS_T_N_I_V_I_I_T_H(
				soHieuHSCVs, tieuDes, null, null, vanDeLienQuans, 0, 0, 
				tomTatNoiDungs, hoatDong, andOperator, start, end, obc);
	}

	public List<PmlHoSoCongViec> findByS_T_N_I_V_I_I_T_H(
			String soHieuHSCV, String tieuDe, Date ngayMoHSCV, String idLinhVuc, 
			String vanDeLienQuan, long idDoQuanTrong, long idTrangThaiHSCV, 
			String tomTatNoiDung, String hoatDong, boolean andOperator, 
			int start, int end, OrderByComparator obc)
		throws SystemException {

		return findByS_T_N_I_V_I_I_T_H(
				new String[] {soHieuHSCV}, new String[] {tieuDe}, ngayMoHSCV, idLinhVuc, 
				new String[] {vanDeLienQuan}, idDoQuanTrong, idTrangThaiHSCV, 
				new String[] {tomTatNoiDung}, hoatDong, andOperator, start, end, obc);
	}

	public List<PmlHoSoCongViec> findByS_T_N_I_V_I_I_T_H(
			String[] soHieuHSCVs, String[] tieuDes, Date ngayMoHSCV, String idLinhVuc, 
			String[] vanDeLienQuans, long idDoQuanTrong, long idTrangThaiHSCV, 
			String[] tomTatNoiDungs, String hoatDong, boolean andOperator, 
			int start, int end, OrderByComparator obc)
		throws SystemException {

		// Replace keywords
		soHieuHSCVs = CustomSQLUtil.keywords(soHieuHSCVs, false);
		tieuDes = CustomSQLUtil.keywords(tieuDes, false);
		vanDeLienQuans = CustomSQLUtil.keywords(vanDeLienQuans, false);
		tomTatNoiDungs = CustomSQLUtil.keywords(tomTatNoiDungs, false);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String ngayMoHSCVDateStr = null;
		if (ngayMoHSCV != null) {
			ngayMoHSCVDateStr = format.format(ngayMoHSCV);
		}
		
		if (idLinhVuc != null && idLinhVuc.trim().equals("")) {
			idLinhVuc = null;
		}
		
		Session session = null;

		try {
			session = openSession();

			String sql = CustomSQLUtil.get(FIND_BY_S_T_N_I_V_I_I_T_H);

			sql = CustomSQLUtil.replaceKeywords(
				sql, "so_hieu_hscv", StringPool.LIKE, false, soHieuHSCVs);
			sql = CustomSQLUtil.replaceKeywords(
				sql, "tieu_de", StringPool.LIKE, false, tieuDes);
			// Ngay mo
			if (ngayMoHSCV == null) {
				sql = StringUtil.replace(sql, "(substr(cast(ngay_mo_hscv as text), 1, 10) = ?) [$AND_OR_CONNECTOR$]", "");
			}
			sql = CustomSQLUtil.replaceKeywords(
					sql, "id_linh_vuc", StringPool.EQUAL, false, new String[] {idLinhVuc});
			sql = CustomSQLUtil.replaceKeywords(
				sql, "van_de_lien_quan", StringPool.LIKE, false, vanDeLienQuans);
			// Do quan trong
			if (idDoQuanTrong <= 0) {
				sql = StringUtil.replace(sql, "(id_do_quan_trong = ?) [$AND_OR_CONNECTOR$]", "");
			}
			// Trang thai
			if (idTrangThaiHSCV <= 0) {
				sql = StringUtil.replace(sql, "(id_trang_thai_hscv = ?) [$AND_OR_CONNECTOR$]", "");
			}
			sql = CustomSQLUtil.replaceKeywords(
					sql, "tom_tat_noi_dung", StringPool.LIKE, false, tomTatNoiDungs);

			sql = CustomSQLUtil.replaceAndOperator(sql, andOperator);
			sql = CustomSQLUtil.replaceOrderBy(sql, obc);

			SQLQuery q = session.createSQLQuery(sql);

			q.addEntity("pml_ho_so_cong_viec", PmlHoSoCongViecImpl.class);

			QueryPos qPos = QueryPos.getInstance(q);

			// Add parameters value
			qPos.add(soHieuHSCVs, 2);
			qPos.add(tieuDes, 2);
			if (ngayMoHSCV != null) {
				qPos.add(ngayMoHSCVDateStr);
			}

			qPos.add(new String[] {idLinhVuc}, 2);
			qPos.add(vanDeLienQuans, 2);
			if (idDoQuanTrong > 0) {
				qPos.add(idDoQuanTrong);
			}
			if (idTrangThaiHSCV > 0) {
				qPos.add(idTrangThaiHSCV);
			}
			qPos.add(tomTatNoiDungs, 2);
			qPos.add(hoatDong);

			return (List<PmlHoSoCongViec>)QueryUtil.list(
				q, getDialect(), start, end);
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public int countByI_S(
			long idHoSoCongViec, String soHieuHSCV)
		throws SystemException {

		Session session = null;

		try {
			session = openSession();

			String sql = CustomSQLUtil.get(COUNT_BY_I_S);

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME, Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(idHoSoCongViec);
			qPos.add(soHieuHSCV);

			Iterator<Long> itr = q.list().iterator();

			if (itr.hasNext()) {
				Long count = itr.next();

				if (count != null) {
					return count.intValue();
				}
			}

			return 0;
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public int countByID_T_C(long[] idTinhChats)
		throws SystemException {

		Session session = null;

		try {
			session = openSession();
	
			StringBuilder query = new StringBuilder();
	
			query.append("SELECT COUNT(*) AS COUNT_VALUE FROM pml_ho_so_cong_viec ");
			query.append("WHERE ");
			query.append("pml_ho_so_cong_viec.id_tinh_chat IN (");
	
			if ((idTinhChats != null) && (idTinhChats.length > 0)) {
				query.append("");
	
				for (int i = 0; i < idTinhChats.length; i++) {

					if (idTinhChats.length == 1)
						query.append(idTinhChats[i]);
					else
						query.append(idTinhChats[i] + " , ");
						
					if (i == idTinhChats.length - 1 && idTinhChats.length > 1)
						query.append(idTinhChats[i]);
				}
	
				query.append(") ");
			}
	
	
			SQLQuery q = session.createSQLQuery(query.toString());
	
			q.addScalar(COUNT_COLUMN_NAME, Type.LONG);
	
			QueryPos qPos = QueryPos.getInstance(q);
	
			Iterator<Long> itr = q.list().iterator();
	
			if (itr.hasNext()) {
				Long count = itr.next();
	
				if (count != null) {
					return count.intValue();
				}
			}
	
			return 0;
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
		finally {
			closeSession(session);
		}
	}
	
	// Ham tim kiem khoa ngoai trong ban pml_ho_so_cong_viec
	public int countByID_T_T_HSCV(long[] idTrangThaiHSCVs)
		throws SystemException {

		Session session = null;

		try {
			session = openSession();
	
			StringBuilder query = new StringBuilder();
	
			query.append("SELECT COUNT(*) AS COUNT_VALUE FROM pml_ho_so_cong_viec ");
			query.append("WHERE ");
			query.append("pml_ho_so_cong_viec.id_trang_thai_hscv IN (");
	
			if ((idTrangThaiHSCVs != null) && (idTrangThaiHSCVs.length > 0)) {
				query.append("");
	
				for (int i = 0; i < idTrangThaiHSCVs.length; i++) {

					if (idTrangThaiHSCVs.length == 1)
						query.append(idTrangThaiHSCVs[i]);
					else
						query.append(idTrangThaiHSCVs[i] + " , ");
						
					if (i == idTrangThaiHSCVs.length - 1 && idTrangThaiHSCVs.length > 1)
						query.append(idTrangThaiHSCVs[i]);
				}
	
				query.append(") ");
			}
	
	
			SQLQuery q = session.createSQLQuery(query.toString());
	
			q.addScalar(COUNT_COLUMN_NAME, Type.LONG);
	
			QueryPos qPos = QueryPos.getInstance(q);	
	
			Iterator<Long> itr = q.list().iterator();
	
			if (itr.hasNext()) {
				Long count = itr.next();
	
				if (count != null) {
					return count.intValue();
				}
			}
	
			return 0;
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
		finally {
			closeSession(session);
		}
	}
	
	// Ham tim kiem khoa ngoai trong ban pml_ho_so_cong_viec
	public int countByID_D_Q_T(long[] idDoQuanTrongs)
		throws SystemException {

		Session session = null;

		try {
			session = openSession();
	
			StringBuilder query = new StringBuilder();
	
			query.append("SELECT COUNT(*) AS COUNT_VALUE FROM pml_ho_so_cong_viec ");
			query.append("WHERE ");
			query.append("pml_ho_so_cong_viec.id_do_quan_trong IN (");
	
			if ((idDoQuanTrongs != null) && (idDoQuanTrongs.length > 0)) {
				query.append("");
	
				for (int i = 0; i < idDoQuanTrongs.length; i++) {

					if (idDoQuanTrongs.length == 1)
						query.append(idDoQuanTrongs[i]);
					else
						query.append(idDoQuanTrongs[i] + " , ");
						
					if (i == idDoQuanTrongs.length - 1 && idDoQuanTrongs.length > 1)
						query.append(idDoQuanTrongs[i]);
				}
	
				query.append(") ");
			}
	
	
			SQLQuery q = session.createSQLQuery(query.toString());
	
			q.addScalar(COUNT_COLUMN_NAME, Type.LONG);
	
			QueryPos qPos = QueryPos.getInstance(q);	
	
			Iterator<Long> itr = q.list().iterator();
	
			if (itr.hasNext()) {
				Long count = itr.next();
	
				if (count != null) {
					return count.intValue();
				}
			}
	
			return 0;
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
		finally {
			closeSession(session);
		}
	}
}