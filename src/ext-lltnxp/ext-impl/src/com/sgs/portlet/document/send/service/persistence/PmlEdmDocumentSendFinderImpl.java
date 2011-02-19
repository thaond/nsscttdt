package com.sgs.portlet.document.send.service.persistence;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

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
import com.sgs.portlet.department.model.Department;
import com.sgs.portlet.department.service.persistence.DepartmentUtil;
import com.sgs.portlet.document.model.PmlDocumentSendLog;
import com.sgs.portlet.document.model.impl.PmlDocumentSendLogImpl;
import com.sgs.portlet.document.send.model.PmlEdmDocumentSend;
import com.sgs.portlet.document.send.model.impl.PmlEdmDocumentSendImpl;
import com.sgs.portlet.document.workflow.DocumentSendLiferayWorkflowService;

/**
 * @author
 * @author XUAN CONG
 */
@SuppressWarnings("unchecked")
public class PmlEdmDocumentSendFinderImpl extends BasePersistenceImpl implements
		PmlEdmDocumentSendFinder {
	public static String FIND_BY_S_L_T_P_N_N_TN_DN_S_T = PmlEdmDocumentSendFinder.class
			.getName() + ".findByS_L_T_P_N_N_TN_DN_S_T";
	public static String COUNT_BY_S_L_T_P_N_N_TN_DN_S_T = PmlEdmDocumentSendFinder.class
			.getName() + ".countByS_L_T_P_N_N_TN_DN_S_T";

	// By TriLTM
	public static String COUNT_BY_R_B_F_T = PmlEdmDocumentSendFinder.class
			.getName() + ".countBy_R_B_F_T";
	public static String FIND_BY_R_B_F_T = PmlEdmDocumentSendFinder.class
			.getName() + ".findBy_R_B_F_T";

	// End By TriLTM

	public int countByS_L_T_P_N_N_TN_DN_S_T(String soPhatHanh,
			long loaiCongVan, String traLoiCongVanSo, String phongSoanThao,
			String noiNhan, long nguoiKy, String tuNgay, String denNgay,
			long soHSCV, String trichYeu) throws SystemException {
		soPhatHanh = StringUtil.lowerCase(soPhatHanh);
		traLoiCongVanSo = StringUtil.lowerCase(traLoiCongVanSo);
		phongSoanThao = StringUtil.lowerCase(phongSoanThao);
		noiNhan = StringUtil.lowerCase(noiNhan);
		trichYeu = StringUtil.lowerCase(trichYeu);

		Session session = null;

		try {
			session = openSession();

			String sql = "SELECT "
					+ "COUNT(DISTINCT pml_edm_documentsend.documentSendId) AS COUNT_VALUE "
					+ "FROM "
					+ "pml_edm_documentsend ,pml_edm_answerdetail ,pml_edm_documentreceipt ,pml_user ,pml_departments ,pml_ho_so_cong_viec ,pml_chi_tiet_hscv  "
					+ "WHERE " + "( '"
					+ tuNgay
					+ "' <= pml_edm_documentsend.datecreated ) "
					+ "AND (pml_edm_documentsend.documentTypeId = "
					+ loaiCongVan
					+ " ) "
					+

					"AND (pml_edm_documentsend.documentSendId = pml_edm_answerdetail.documentsendid ) AND (pml_edm_documentreceipt.documentreceiptid = pml_edm_answerdetail.documentreceipt) AND (lower(pml_edm_documentreceipt.documentReference) LIKE '%"
					+ traLoiCongVanSo
					+ "%' ) "
					+

					"AND (pml_edm_documentsend.editorid = pml_user.userid) AND (pml_user.departmentsid = pml_departments.departmentsid) AND (lower(pml_departments.departmentsid)  LIKE '%"
					+ phongSoanThao
					+ "%') "
					+

					"AND (lower(pml_edm_documentsend.receivingPlace) LIKE '%"
					+ noiNhan
					+ "%' ) "
					+

					"AND (pml_edm_documentsend.signerId = "
					+ nguoiKy
					+ " ) "
					+

					"AND (lower(pml_edm_documentsend.documentReference) LIKE '%"
					+ soPhatHanh
					+ "%' ) "
					+

					"AND (pml_edm_documentsend.datecreated <= '"
					+ denNgay
					+ "' ) "
					+

					"AND (pml_edm_documentsend.documentSendId = pml_chi_tiet_hscv.id_cong_van_di) AND (pml_chi_tiet_hscv.id_ho_so_cong_viec = pml_ho_so_cong_viec.id_ho_so_cong_viec) AND (pml_ho_so_cong_viec.id_ho_so_cong_viec = "
					+ soHSCV
					+ " ) "
					+

					"AND (lower(pml_edm_documentsend.briefContent) LIKE '%"
					+ trichYeu + "%')";

			if ("".equals(soPhatHanh)) {
				sql = sql.replace(
						"AND (lower(pml_edm_documentsend.documentReference) LIKE '%"
								+ soPhatHanh + "%' ) ", "");
			}

			if (0 == loaiCongVan) {
				sql = sql.replace("AND (pml_edm_documentsend.documentTypeId = "
						+ loaiCongVan + " ) ", "");
			}

			if ("".equals(traLoiCongVanSo)) {
				sql = sql
						.replace(
								"AND (pml_edm_documentsend.documentSendId = pml_edm_answerdetail.documentsendid ) AND (pml_edm_documentreceipt.documentreceiptid = pml_edm_answerdetail.documentreceipt) AND (lower(pml_edm_documentreceipt.documentReference) LIKE '%"
										+ traLoiCongVanSo + "%' ) ", "");
				sql = sql.replace(",pml_edm_answerdetail", "");
				sql = sql.replace(",pml_edm_documentreceipt", "");
			}

			if ("".equals(phongSoanThao)) {
				sql = sql
						.replace(
								"AND (pml_edm_documentsend.editorid = pml_user.userid) AND (pml_user.departmentsid = pml_departments.departmentsid) AND (lower(pml_departments.departmentsid)  LIKE '%"
										+ phongSoanThao + "%') ", "");
				sql = sql.replace(",pml_user", "");
				sql = sql.replace(",pml_departments", "");
			}

			if ("".equals(noiNhan)) {
				sql = sql.replace(
						"AND (lower(pml_edm_documentsend.receivingPlace) LIKE '%"
								+ noiNhan + "%' ) ", "");

			}

			if (0 == nguoiKy) {
				sql = sql.replace("AND (pml_edm_documentsend.signerId = "
						+ nguoiKy + " ) ", "");

			}

			if (0 == soHSCV) {
				sql = sql
						.replace(
								"AND (pml_edm_documentsend.documentSendId = pml_chi_tiet_hscv.id_cong_van_di) AND (pml_chi_tiet_hscv.id_ho_so_cong_viec = pml_ho_so_cong_viec.id_ho_so_cong_viec) AND (pml_ho_so_cong_viec.id_ho_so_cong_viec = "
										+ soHSCV + " ) ", "");
				sql = sql.replace(",pml_ho_so_cong_viec", "");
				sql = sql.replace(",pml_chi_tiet_hscv", "");
			}

			if ("".equals(trichYeu)) {
				sql = sql.replace(
						"AND (lower(pml_edm_documentsend.briefContent) LIKE '%"
								+ trichYeu + "%')", "");
			}

			if ("".equals(tuNgay)) {
				sql = sql.replace("( '" + tuNgay
						+ "' <= pml_edm_documentsend.datecreated ) ", "");
			}

			if ("".equals(denNgay)) {
				sql = sql.replace("AND (pml_edm_documentsend.datecreated <= '"
						+ denNgay + "' ) ", "");
			}

			sql = sql.replace("WHERE AND", "WHERE");

			SQLQuery q = session.createSQLQuery(sql);
			q.addScalar(COUNT_COLUMN_NAME, Type.LONG);

			Iterator<Long> itr = q.list().iterator();

			if (itr.hasNext()) {
				Long count = itr.next();

				if (count != null) {
					return count.intValue();
				}
			}

			return 0;
		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}

	}

	public List<PmlEdmDocumentSend> findByS_L_T_P_N_N_TN_DN_S_T(
			String soPhatHanh, long loaiCongVan, String traLoiCongVanSo,
			String phongSoanThao, String noiNhan, long nguoiKy, String tuNgay,
			String denNgay, long soHSCV, String trichYeu, int start, int end,
			OrderByComparator obc) throws SystemException {

		soPhatHanh = StringUtil.lowerCase(soPhatHanh);
		traLoiCongVanSo = StringUtil.lowerCase(traLoiCongVanSo);
		phongSoanThao = StringUtil.lowerCase(phongSoanThao);
		noiNhan = StringUtil.lowerCase(noiNhan);
		trichYeu = StringUtil.lowerCase(trichYeu);

		Session session = null;

		try {
			session = openSession();

			String sql = "SELECT "
					+ "DISTINCT {pml_edm_documentsend.*} "
					+ "FROM "
					+ "pml_edm_documentsend ,pml_edm_answerdetail ,pml_edm_documentreceipt ,pml_user ,pml_departments ,pml_ho_so_cong_viec ,pml_chi_tiet_hscv "
					+ "WHERE " + "( '"
					+ tuNgay
					+ "' <= pml_edm_documentsend.datecreated ) "
					+

					"AND (pml_edm_documentsend.documentTypeId = "
					+ loaiCongVan
					+ " ) "
					+

					"AND (pml_edm_documentsend.documentSendId = pml_edm_answerdetail.documentsendid ) AND (pml_edm_documentreceipt.documentreceiptid = pml_edm_answerdetail.documentreceipt) AND (lower(pml_edm_documentreceipt.documentReference) LIKE '%"
					+ traLoiCongVanSo
					+ "%' ) "
					+

					"AND (pml_edm_documentsend.editorid = pml_user.userid) AND (pml_user.departmentsid = pml_departments.departmentsid) AND (lower(pml_departments.departmentsid)  LIKE '%"
					+ phongSoanThao
					+ "%') "
					+

					"AND (lower(pml_edm_documentsend.receivingPlace) LIKE '%"
					+ noiNhan
					+ "%' ) "
					+

					"AND (pml_edm_documentsend.signerId = "
					+ nguoiKy
					+ " ) "
					+

					"AND (lower(pml_edm_documentsend.documentReference) LIKE '%"
					+ soPhatHanh
					+ "%' ) "
					+

					"AND (pml_edm_documentsend.datecreated <= '"
					+ denNgay
					+ "' ) "
					+

					"AND (pml_edm_documentsend.documentSendId = pml_chi_tiet_hscv.id_cong_van_di) AND (pml_chi_tiet_hscv.id_ho_so_cong_viec = pml_ho_so_cong_viec.id_ho_so_cong_viec) AND (pml_ho_so_cong_viec.id_ho_so_cong_viec = "
					+ soHSCV
					+ " ) "
					+

					"AND (lower(pml_edm_documentsend.briefContent) LIKE '%"
					+ trichYeu + "%') " +
					/*
					 * xuancong close start "ORDER BY "+
					 * "pml_edm_documentsend.documentReference ASC, "+
					 * "pml_edm_documentsend.issuingDate ASC"; xuancong close
					 * end
					 */
					" ORDER BY pml_edm_documentsend.numofdocref DESC ";

			if ("".equals(soPhatHanh)) {
				sql = sql.replace(
						"AND (lower(pml_edm_documentsend.documentReference) LIKE '%"
								+ soPhatHanh + "%' ) ", "");

			}

			if (0 == loaiCongVan) {
				sql = sql.replace("AND (pml_edm_documentsend.documentTypeId = "
						+ loaiCongVan + " ) ", "");
			}

			if ("".equals(traLoiCongVanSo)) {
				sql = sql
						.replace(
								"AND (pml_edm_documentsend.documentSendId = pml_edm_answerdetail.documentsendid ) AND (pml_edm_documentreceipt.documentreceiptid = pml_edm_answerdetail.documentreceipt) AND (lower(pml_edm_documentreceipt.documentReference) LIKE '%"
										+ traLoiCongVanSo + "%' ) ", "");
				sql = sql.replace(",pml_edm_answerdetail", "");
				sql = sql.replace(",pml_edm_documentreceipt", "");
			}

			if ("".equals(phongSoanThao)) {
				sql = sql
						.replace(
								"AND (pml_edm_documentsend.editorid = pml_user.userid) AND (pml_user.departmentsid = pml_departments.departmentsid) AND (lower(pml_departments.departmentsid)  LIKE '%"
										+ phongSoanThao + "%') ", "");
				sql = sql.replace(",pml_user", "");
				sql = sql.replace(",pml_departments", "");
			}

			if ("".equals(noiNhan)) {
				sql = sql.replace(
						"AND (lower(pml_edm_documentsend.receivingPlace) LIKE '%"
								+ noiNhan + "%' ) ", "");

			}

			if (0 == nguoiKy) {
				sql = sql.replace("AND (pml_edm_documentsend.signerId = "
						+ nguoiKy + " ) ", "");

			}

			if (0 == soHSCV) {
				sql = sql
						.replace(
								"AND (pml_edm_documentsend.documentSendId = pml_chi_tiet_hscv.id_cong_van_di) AND (pml_chi_tiet_hscv.id_ho_so_cong_viec = pml_ho_so_cong_viec.id_ho_so_cong_viec) AND (pml_ho_so_cong_viec.id_ho_so_cong_viec = "
										+ soHSCV + " ) ", "");
				sql = sql.replace(",pml_ho_so_cong_viec", "");
				sql = sql.replace(",pml_chi_tiet_hscv", "");
			}

			if ("".equals(trichYeu)) {
				sql = sql.replace(
						"AND (lower(pml_edm_documentsend.briefContent) LIKE '%"
								+ trichYeu + "%')", "");
			}

			if ("".equals(tuNgay)) {
				sql = sql.replace("( '" + tuNgay
						+ "' <= pml_edm_documentsend.datecreated ) ", "");
			}

			if ("".equals(denNgay)) {
				sql = sql.replace("AND (pml_edm_documentsend.datecreated <= '"
						+ denNgay + "' ) ", "");
			}

			sql = sql.replace("WHERE AND", "WHERE");

			sql = CustomSQLUtil.replaceOrderBy(sql, obc);
			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("pml_edm_documentsend", PmlEdmDocumentSendImpl.class);

			return (List<PmlEdmDocumentSend>) QueryUtil.list(q, getDialect(),
					start, end);
		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}

	}

	/**
	 * Dem so luong cong van di can xu ly cua nguoi dung
	 * 
	 * @author XUAN CONG
	 * @param userId
	 *            Ma so nguoi dung
	 * @return So luong cong van di can xu ly cua nguoi dung
	 * @throws SystemException
	 */
	public int countDocSendNeedProcess(long userId) throws SystemException {

		Session session = null;

		try {
			session = openSession();

			String sql = "SELECT COUNT(DISTINCT(cv.documentsendid)) AS COUNT_VALUE ";
			sql += "FROM pml_edm_documentsend cv inner join pml_documentsend_log log ";
			sql += "ON cv.documentsendid = log.documentsendid ";
			sql += "WHERE log.processer = " + userId + " AND ";
			sql += "log.dateprocess is null ";

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
			throw processException(e);
		} finally {
			closeSession(session);
		}
	}

	// minh update 25/11/2009
	/**
	 * tra ve so luong cong van den ung voi mot dang sach user va trang thai cu
	 * the
	 */

	public int countByDocumentSend_Users(List<Long> userIds,
			String loaisocongvan) throws Exception {
		Session session = null;

		try {
			session = openSession();

			DocumentSendLiferayWorkflowService workflowService = new DocumentSendLiferayWorkflowService();
			List<Long> listProcessId = workflowService
					.getProcessInstances(userIds);

			String sql = "SELECT COUNT(DISTINCT(cvsend.documentsendid)) AS COUNT_VALUE ";
			// minh update 20100401
			sql += "FROM pml_edm_documentsend cvsend, pml_documentsend_wf cvsendwf ";
			// , pml_edm_documenttype dt, pml_edm_documentrecordtype drt ";
			// end minh update
			sql += "WHERE cvsend.documentsendid = cvsendwf.documentsendid ";

			if (!"0".equals(loaisocongvan)) {
				sql = sql
						.replace(
								"FROM pml_edm_documentsend cvsend, pml_documentsend_wf cvsendwf ",
								"FROM pml_edm_documentsend cvsend, pml_documentsend_wf cvsendwf, pml_edm_documenttype dt, pml_edm_documentrecordtype drt ");
				sql += "AND cvsend.documenttypeid = dt.documenttypeid AND dt.documentrecordtypeid = drt.documentrecordtypeid AND drt.documentrecordtypeid = "
						+ loaisocongvan;
			}

			sql += "AND cvsendwf.processid in (";

			for (Long processId : listProcessId) {
				sql += processId + ",";
			}

			sql += "0)";

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

	/**
	 * tra ve danh sach cong van den ung voi mot dang sach user va trang thai cu
	 * the
	 */

	public List<PmlEdmDocumentSend> findByDocumentSend_Users(
			List<Long> userIds, String loaisocongvan, int start, int end,
			OrderByComparator obc) throws Exception {
		Session session = null;

		try {
			session = openSession();

			DocumentSendLiferayWorkflowService workflowService = new DocumentSendLiferayWorkflowService();
			List<Long> listProcessId = workflowService
					.getProcessInstances(userIds);

			String sql = "SELECT DISTINCT(cvsend.*) ";
			// minh update 20100401
			sql += "FROM pml_edm_documentsend cvsend, pml_documentsend_wf cvsendwf ";
			// , pml_edm_documenttype dt, pml_edm_documentrecordtype drt ";
			// end minh update
			sql += "WHERE cvsend.documentsendid = cvsendwf.documentsendid ";

			if (!"0".equals(loaisocongvan)) {
				sql = sql
						.replace(
								"FROM pml_edm_documentsend cvsend, pml_documentsend_wf cvsendwf ",
								"FROM pml_edm_documentsend cvsend, pml_documentsend_wf cvsendwf, pml_edm_documenttype dt, pml_edm_documentrecordtype drt ");
				sql += "AND cvsend.documenttypeid = dt.documenttypeid AND dt.documentrecordtypeid = drt.documentrecordtypeid AND drt.documentrecordtypeid = "
						+ loaisocongvan;
			}

			sql += "AND cvsendwf.processid in (";

			for (Long processId : listProcessId) {
				sql += processId + ",";
			}

			sql += "0)";

			sql = CustomSQLUtil.replaceOrderBy(sql, obc);

			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("PmlEdmDocumentSend", PmlEdmDocumentSendImpl.class);

			return (List<PmlEdmDocumentSend>) QueryUtil.list(q, getDialect(),
					start, end);
		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}

	/**
	 * tra ve so luong cong van den ung voi mot dang sach user va trang thai cu the
	 */

	public int countByDocumentSend_Users_Status_DangXuLy(List<Long> userIds,
			long statusId, String loaisocongvan, String capGui)
			throws Exception {
		Session session = null;

		try {
			session = openSession();

			DocumentSendLiferayWorkflowService workflowService = new DocumentSendLiferayWorkflowService();
			List<Long> listProcessId = workflowService
					.getListProcessInstanceByStatusId(userIds, statusId);

			String sql = "SELECT COUNT(DISTINCT(cvsend.documentsendid)) AS COUNT_VALUE ";
			// minh update 20100401
			sql += "FROM pml_edm_documentsend cvsend, pml_documentsend_wf cvsendwf ";
			// , pml_edm_documenttype dt, pml_edm_documentrecordtype drt ";
			// end
			sql += "WHERE cvsend.documentsendid = cvsendwf.documentsendid ";

			if (!"0".equals(loaisocongvan)) {
				sql = sql
						.replace(
								"FROM pml_edm_documentsend cvsend, pml_documentsend_wf cvsendwf ",
								"FROM pml_edm_documentsend cvsend, pml_documentsend_wf cvsendwf, pml_edm_documenttype dt ");
				sql += "AND cvsend.documenttypeid = dt.documenttypeid AND dt.documenttypeid = "
						+ loaisocongvan;
			}

			sql += "AND cvsendwf.processid in (";

			for (Long processId : listProcessId) {
				sql += processId + ",";
			}

			sql += "0)";

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

	/**
	 * tra ve danh sach cong van den ung voi mot dang sach user va trang thai cu
	 * the
	 */

	public List<PmlEdmDocumentSend> findByDocumentSend_Users_Status_DangXuLy(
			List<Long> userIds, long statusId, String loaisocongvan,
			String capGui, int start, int end, OrderByComparator obc)
			throws Exception {
		Session session = null;

		try {
			session = openSession();

			DocumentSendLiferayWorkflowService workflowService = new DocumentSendLiferayWorkflowService();
			List<Long> listProcessId = workflowService
					.getListProcessInstanceByStatusId(userIds, statusId);

			String sql = "SELECT DISTINCT(cvsend.*) ";
			// minh update 20100401
			sql += "FROM pml_edm_documentsend cvsend, pml_documentsend_wf cvsendwf ";
			// , pml_edm_documenttype dt, pml_edm_documentrecordtype drt ";
			// end minh update
			sql += "WHERE cvsend.documentsendid = cvsendwf.documentsendid ";

			if (!"0".equals(loaisocongvan)) {
				// sql =
				// sql.replace("FROM pml_edm_documentsend cvsend, pml_documentsend_wf cvsendwf ",
				// "FROM pml_edm_documentsend cvsend, pml_documentsend_wf cvsendwf, pml_edm_documenttype dt, pml_edm_documentrecordtype drt ");
				// sql +=
				// "AND cvsend.documenttypeid = dt.documenttypeid AND dt.documentrecordtypeid = drt.documentrecordtypeid AND drt.documentrecordtypeid = "
				sql = sql
						.replace(
								"FROM pml_edm_documentsend cvsend, pml_documentsend_wf cvsendwf ",
								"FROM pml_edm_documentsend cvsend, pml_documentsend_wf cvsendwf, pml_edm_documenttype dt ");
				sql += " AND cvsend.documenttypeid = dt.documenttypeid AND dt.documenttypeid = "
						+ loaisocongvan;
			}

			sql += "AND cvsendwf.processid in (";

			for (Long processId : listProcessId) {
				sql += processId + ",";
			}

			sql += "0)";

			sql = CustomSQLUtil.replaceOrderBy(sql, obc);

			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("PmlEdmDocumentSend", PmlEdmDocumentSendImpl.class);

			return (List<PmlEdmDocumentSend>) QueryUtil.list(q, getDialect(),
					start, end);
		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}

	public int countByDocumentSend_Users_Status_DangXuLy_TreHan(
			List<Long> userIds, long statusId, String loaisocongvan,
			String capGui) throws Exception {
		Session session = null;

		try {
			session = openSession();

			DocumentSendLiferayWorkflowService workflowService = new DocumentSendLiferayWorkflowService();
			List<Long> listProcessId = workflowService
					.getListProcessInstanceByStatusId(userIds, statusId);

			// Lay ngay hien tai
			String currentDate = new SimpleDateFormat("yyyy-MM-dd")
					.format(new Date());

			String sql = "SELECT COUNT(DISTINCT(cvsend.documentsendid)) AS COUNT_VALUE ";
			if (!"0".equals(loaisocongvan)) {
				sql += "FROM pml_edm_documentsend cvsend, pml_documentsend_wf cvsendwf , pml_edm_documentreceipt cvden, pml_edm_answerdetail ad, pml_edm_documenttype dt ";
			} else {
				sql += "FROM pml_edm_documentsend cvsend, pml_documentsend_wf cvsendwf , pml_edm_documentreceipt cvden, pml_edm_answerdetail ad ";
			}
			sql += "WHERE cvsend.documentsendid = cvsendwf.documentsendid ";

			if (!"0".equals(loaisocongvan)) {
				sql += "AND cvsend.documenttypeid = dt.documenttypeid AND dt.documenttypeid = "
						+ loaisocongvan;
			}

			sql += "AND cvsendwf.processid in (";

			for (Long processId : listProcessId) {
				sql += processId + ",";
			}

			sql += "0) ";

			sql += "AND cvsend.documentsendid = ad.documentsendid ";
			sql += "AND cvden.documentreceiptid = ad.documentreceiptid ";
			sql += "AND cvsend.datecreated + cvden.processtime + songaynghile(cvsend.datecreated, cvden.processtime) < '"
					+ currentDate + "'";

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

	public List<PmlEdmDocumentSend> findByDocumentSend_Users_Status_DangXuLy_TreHan(
			List<Long> userIds, long statusId, String loaisocongvan,
			String capGui, int start, int end, OrderByComparator obc)
			throws Exception {
		Session session = null;

		try {
			session = openSession();

			DocumentSendLiferayWorkflowService workflowService = new DocumentSendLiferayWorkflowService();
			List<Long> listProcessId = workflowService
					.getListProcessInstanceByStatusId(userIds, statusId);

			// Lay ngay hien tai
			String currentDate = new SimpleDateFormat("yyyy-MM-dd")
					.format(new Date());

			String sql = "SELECT DISTINCT(cvsend.*) ";

			if (!"0".equals(loaisocongvan)) {
				sql += "FROM pml_edm_documentsend cvsend, pml_documentsend_wf cvsendwf, pml_edm_documentreceipt cvden, pml_edm_answerdetail ad, pml_edm_documenttype dt";
			} else {
				sql += "FROM pml_edm_documentsend cvsend, pml_documentsend_wf cvsendwf , pml_edm_documentreceipt cvden, pml_edm_answerdetail ad ";
			}
			sql += "WHERE cvsend.documentsendid = cvsendwf.documentsendid ";

			if (!"0".equals(loaisocongvan)) {
				sql += " AND cvsend.documenttypeid = dt.documenttypeid AND dt.documenttypeid = "
						+ loaisocongvan;
			}

			sql += "AND cvsendwf.processid in (";

			for (Long processId : listProcessId) {
				sql += processId + ",";
			}

			sql += "0) ";

			sql += "AND cvsend.documentsendid = ad.documentsendid ";
			sql += "AND cvden.documentreceiptid = ad.documentreceiptid ";
			sql += "AND cvsend.datecreated + cvden.processtime + songaynghile(cvsend.datecreated, cvden.processtime) < '"
					+ currentDate + "'";

			sql = CustomSQLUtil.replaceOrderBy(sql, obc);

			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("PmlEdmDocumentSend", PmlEdmDocumentSendImpl.class);

			return (List<PmlEdmDocumentSend>) QueryUtil.list(q, getDialect(),
					start, end);
		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}

	@SuppressWarnings("static-access")
	public int countDocumentType(int documentTypeId, String abbreviateName)
			throws SystemException {
		Date date = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int year = calendar.get(calendar.YEAR);

		Session session = null;
		try {
			session = openSession();
			String sql = "select COUNT(pml_edm_documentsend.documenttypeid) AS COUNT_VALUE from pml_edm_documentsend, pml_departments where pml_edm_documentsend.documenttypeid = "
					+ documentTypeId
					+ " AND date_part('year', pml_edm_documentsend.issuingdate)= "
					+ year
					+ " AND pml_departments.abbreviatename = '"
					+ abbreviateName + "'";
			SQLQuery q = session.createSQLQuery(sql);
			q.addScalar(COUNT_COLUMN_NAME, Type.LONG);

			Iterator<Long> itr = q.list().iterator();

			if (itr.hasNext()) {
				Long count = itr.next();

				if (count != null) {
					return count.intValue();
				}
			}

			return 0;
		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}

	}

	/**
	 * Lay id lon nhat trong bang pml_edm_documentsend
	 * 
	 * @return long
	 * @throws SystemException
	 */
	public long getMaxDocumentSendId() throws SystemException {

		long retVal = 0;
		// Lay id lon nhat trong bang pml_edm_documentsend
		Session session = null;
		try {
			session = openSession();

			SQLQuery q = session
					.createSQLQuery("SELECT MAX(documentsendid) AS COUNT_VALUE FROM pml_edm_documentsend ");

			q.addScalar(COUNT_COLUMN_NAME, Type.LONG);

			@SuppressWarnings("unused")
			QueryPos qPos = QueryPos.getInstance(q);

			Iterator<Long> itr = q.list().iterator();

			if (itr.hasNext()) {
				Long count = itr.next();

				if (count != null) {
					retVal = count.longValue();
				}
			}
			return retVal;
		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}

	/**
	 * Lay so lon nhat cua van ban di theo loai va theo nam
	 * 
	 * @param docTypeId
	 *            : ma so loai van ban di
	 * @param issuingYear
	 *            : nam phat hanh
	 * @return
	 * @throws SystemException
	 */
	public long getMaxDocRefByTypeYear(long docTypeId, int issuingYear)
			throws SystemException {

		long retVal = 0;
		// Lay numofdocref lon nhat trong bang pml_edm_documentsend theo loai va
		// theo nam
		Session session = null;
		try {
			session = openSession();

			String sql = "SELECT MAX(numofdocref) AS COUNT_VALUE FROM pml_edm_documentsend ";
			sql += "WHERE documenttypeid = " + docTypeId + " ";
			sql += "AND date_part('year', issuingdate) = " + issuingYear + " ";
			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME, Type.LONG);

			@SuppressWarnings("unused")
			QueryPos qPos = QueryPos.getInstance(q);

			Iterator<Long> itr = q.list().iterator();

			if (itr.hasNext()) {
				Long count = itr.next();

				if (count != null) {
					retVal = count.longValue();
				}
			}
			return retVal;
		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}

	/**
	 * danh cho bao cao tong hop cong van di
	 */

	/******************************************************************************************************************/
	/** CHUYEN VIEN */
	/******************************************************************************************************************/

	/**
	 * chuyen vien ton dau ky cong van di so luong
	 */
	public int countTonDauKyChuyenVien_CVDi(long userId,
			int documentRecordTypeId, int loaiVB, String doMat, Date fromDate,
			Date toDate) throws Exception {
		Session session = null;

		try {
			session = openSession();

			// Chuyen doi dinh dang ngay
			String ngaybatdauthongke = new SimpleDateFormat("yyyy-MM-dd")
					.format(fromDate);

			String sql = "SELECT COUNT(DISTINCT(cvdi.documentsendid)) AS COUNT_VALUE";
			sql += " FROM pml_documentsend_log log";
			sql += " INNER JOIN (SELECT MAX(transition_) AS maxtran, documentsendid";
			sql += " FROM pml_documentsend_log";
			sql += " WHERE processer = " + userId;
			sql += " GROUP BY documentsendid) AS a ON log.documentsendid = a.documentsendid AND a.maxtran = log.transition_";
			sql += " INNER JOIN pml_edm_documentsend cvdi ON cvdi.documentsendid = log.documentsendid";
			if (!doMat.equals("")) {
				sql += " AND cvdi.confidentiallevelid = '" + doMat + "'";
			}
			// Neu co chon phan nhom
			if (documentRecordTypeId != 0) {
				sql += " INNER JOIN pml_edm_documenttype t ON cvdi.documenttypeid = t.documenttypeid";
				sql += " AND t.documentrecordtypeid = " + documentRecordTypeId;
			}
			// Neu co chon loai van ban
			if (loaiVB != 0) {
				sql += " INNER JOIN pml_edm_documenttype dt ON cvdi.documenttypeid = dt.documenttypeid";
				sql += " INNER JOIN pml_edm_documentrecordtype drt ON dt.documentrecordtypeid = drt.documentrecordtypeid";
				sql += " AND drt.documentrecordtypeid = " + loaiVB;
			}

			sql += " LEFT OUTER JOIN (SELECT MAX(transition_) AS maxtran, documentsendid FROM pml_documentsend_log";
			sql += " WHERE receiver = " + userId;
			sql += " GROUP BY documentsendid) AS b ON log.documentsendid = b.documentsendid AND b.maxtran < log.transition_";
			sql += " LEFT OUTER JOIN pml_documentsend_log log2";
			sql += " ON log.documentsendid = log2.documentsendid AND b.maxtran = log2.transition_";
			sql += " WHERE (log.dateprocess IS null OR log.dateprocess >= '"
					+ ngaybatdauthongke + "')";
			sql += " AND ((log2.documentsendid IS NOT null and log2.receivedate IS NOT null";
			sql += " AND log2.receivedate < '" + ngaybatdauthongke + "')";
			sql += " OR (log.senddatebefore IS null AND cvdi.datecreated < '"
					+ ngaybatdauthongke + "'))";

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
			throw processException(e);
		} finally {
			closeSession(session);
		}
	}

	/**
	 * chuyen vien ton dau ky cong van di danh sach
	 */
	public List<PmlEdmDocumentSend> listTonDauKyChuyenVien_CVDi(long userId,
			int documentRecordTypeId, int loaiVB, String doMat, Date fromDate,
			Date toDate, int start, int end, OrderByComparator obc)
			throws Exception {
		Session session = null;

		try {
			session = openSession();

			String ngaybatdauthongke = new SimpleDateFormat("yyyy-MM-dd")
					.format(fromDate);

			String sql = "SELECT DISTINCT(cvdi.*), conf.confidentiallevelsymbol";
			sql += " FROM pml_documentsend_log log";
			sql += " INNER JOIN (SELECT MAX(transition_) AS maxtran, documentsendid";
			sql += " FROM pml_documentsend_log";
			sql += " WHERE processer = " + userId;
			sql += " GROUP BY documentsendid) AS a ON log.documentsendid = a.documentsendid AND a.maxtran = log.transition_";
			sql += " INNER JOIN pml_edm_documentsend cvdi ON cvdi.documentsendid = log.documentsendid";

			sql += " INNER JOIN pml_edm_confidentiallevel conf ON cvdi.confidentiallevelid = conf.confidentiallevelid";
			if (!doMat.equals("")) {
				sql += " AND conf.confidentiallevelid = '" + doMat + "'";
			}

			// Neu co chon phan nhom
			if (documentRecordTypeId != 0) {
				sql += " INNER JOIN pml_edm_documenttype t ON cvdi.documenttypeid = t.documenttypeid";
				sql += " AND t.documentrecordtypeid = " + documentRecordTypeId;
			}
			// Neu co chon loai van ban
			if (loaiVB != 0) {
				sql += " INNER JOIN pml_edm_documenttype dt ON cvdi.documenttypeid = dt.documenttypeid";
				sql += " INNER JOIN pml_edm_documentrecordtype drt ON dt.documentrecordtypeid = drt.documentrecordtypeid";
				sql += " AND drt.documentrecordtypeid = " + loaiVB;
			}

			sql += " LEFT OUTER JOIN (SELECT MAX(transition_) AS maxtran, documentsendid FROM pml_documentsend_log";
			sql += " WHERE receiver = " + userId;
			sql += " GROUP BY documentsendid) AS b ON log.documentsendid = b.documentsendid AND b.maxtran < log.transition_";
			sql += " LEFT OUTER JOIN pml_documentsend_log log2";
			sql += " ON log.documentsendid = log2.documentsendid AND b.maxtran = log2.transition_";
			sql += " WHERE (log.dateprocess IS null OR log.dateprocess >= '"
					+ ngaybatdauthongke + "')";
			sql += " AND ((log2.documentsendid IS NOT null and log2.receivedate IS NOT null";
			sql += " AND log2.receivedate < '" + ngaybatdauthongke + "')";
			sql += " OR (log.senddatebefore IS null AND cvdi.datecreated < '"
					+ ngaybatdauthongke + "'))";

			sql += " ORDER BY conf.confidentiallevelsymbol ASC, cvdi.datecreated DESC";

			sql = CustomSQLUtil.replaceOrderBy(sql, obc);

			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("PmlEdmDocumentSend", PmlEdmDocumentSendImpl.class);

			return (List<PmlEdmDocumentSend>) QueryUtil.list(q, getDialect(),
					start, end);
		} catch (Exception e) {
			throw processException(e);
		} finally {
			closeSession(session);
		}
	}

	/**
	 * chuyen vien nhan trong ky cong van di so luong
	 */
	public int countNhanTrongKyChuyenVien_CVDi(long userId,
			int documentRecordTypeId, int loaiVB, String doMat, Date fromDate,
			Date toDate) throws Exception {

		Session session = null;

		try {
			session = openSession();

			// Chuyen doi dinh dang ngay
			String ngaybatdauthongke = new SimpleDateFormat("yyyy-MM-dd")
					.format(fromDate);
			String ngayketthucthongke = new SimpleDateFormat("yyyy-MM-dd")
					.format(toDate);

			String sql = "SELECT COUNT(DISTINCT(cvdi.documentsendid)) AS COUNT_VALUE";
			sql += " FROM pml_documentsend_log log";
			sql += " INNER JOIN (SELECT MAX(transition_) AS maxtran, documentsendid";
			sql += " FROM pml_documentsend_log";
			sql += " WHERE processer = " + userId;
			sql += " GROUP BY documentsendid) AS a ON log.documentsendid = a.documentsendid AND a.maxtran = log.transition_";
			sql += " INNER JOIN pml_edm_documentsend cvdi ON cvdi.documentsendid = log.documentsendid";
			if (!doMat.equals("")) {
				sql += " AND cvdi.confidentiallevelid = '" + doMat + "'";
			}
			// Neu co chon phan nhom
			if (documentRecordTypeId != 0) {
				sql += " INNER JOIN pml_edm_documenttype t ON cvdi.documenttypeid = t.documenttypeid";
				sql += " AND t.documentrecordtypeid = " + documentRecordTypeId;
			}
			// Neu co chon loai van ban
			if (loaiVB != 0) {
				sql += " INNER JOIN pml_edm_documenttype dt ON cvdi.documenttypeid = dt.documenttypeid";
				sql += " INNER JOIN pml_edm_documentrecordtype drt ON dt.documentrecordtypeid = drt.documentrecordtypeid";
				sql += " AND drt.documentrecordtypeid = " + loaiVB;
			}

			sql += " LEFT OUTER JOIN (SELECT MAX(transition_) AS maxtran, documentsendid FROM pml_documentsend_log";
			sql += " WHERE receiver = " + userId;
			sql += " GROUP BY documentsendid) AS b ON log.documentsendid = b.documentsendid AND b.maxtran < log.transition_";
			sql += " LEFT OUTER JOIN pml_documentsend_log log2";
			sql += " ON log.documentsendid = log2.documentsendid AND b.maxtran = log2.transition_";
			sql += " WHERE (log.dateprocess IS null OR log.dateprocess >= '"
					+ ngaybatdauthongke + "')";
			sql += " AND ((log2.documentsendid IS NOT null and log2.receivedate IS NOT null";
			sql += " AND log2.receivedate BETWEEN '" + ngaybatdauthongke
					+ "' AND '" + ngayketthucthongke + "')";
			sql += " OR (log.senddatebefore IS null";
			sql += " AND cvdi.datecreated BETWEEN '" + ngaybatdauthongke
					+ "' AND '" + ngayketthucthongke + "'))";

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
			throw processException(e);
		} finally {
			closeSession(session);
		}
	}

	/**
	 * chuyen vien nhan trong ky cong van di danh sach
	 */
	public List<PmlEdmDocumentSend> listNhanTrongKyChuyenVien_CVDi(long userId,
			int documentRecordTypeId, int loaiVB, String doMat, Date fromDate,
			Date toDate, int start, int end, OrderByComparator obc)
			throws Exception {
		Session session = null;

		try {
			session = openSession();

			// Chuyen doi dinh dang ngay
			String ngaybatdauthongke = new SimpleDateFormat("yyyy-MM-dd")
					.format(fromDate);
			String ngayketthucthongke = new SimpleDateFormat("yyyy-MM-dd")
					.format(toDate);

			String sql = "SELECT DISTINCT(cvdi.*), conf.confidentiallevelsymbol";
			sql += " FROM pml_documentsend_log log";
			sql += " INNER JOIN (SELECT MAX(transition_) AS maxtran, documentsendid";
			sql += " FROM pml_documentsend_log";
			sql += " WHERE processer = " + userId;
			sql += " GROUP BY documentsendid) AS a ON log.documentsendid = a.documentsendid AND a.maxtran = log.transition_";
			sql += " INNER JOIN pml_edm_documentsend cvdi ON cvdi.documentsendid = log.documentsendid";

			sql += " INNER JOIN pml_edm_confidentiallevel conf ON cvdi.confidentiallevelid = conf.confidentiallevelid";
			if (!doMat.equals("")) {
				sql += " AND conf.confidentiallevelid = '" + doMat + "'";
			}

			// Neu co chon phan nhom
			if (documentRecordTypeId != 0) {
				sql += " INNER JOIN pml_edm_documenttype t ON cvdi.documenttypeid = t.documenttypeid";
				sql += " AND t.documentrecordtypeid = " + documentRecordTypeId;
			}
			// Neu co chon loai van ban
			if (loaiVB != 0) {
				sql += " INNER JOIN pml_edm_documenttype dt ON cvdi.documenttypeid = dt.documenttypeid";
				sql += " INNER JOIN pml_edm_documentrecordtype drt ON dt.documentrecordtypeid = drt.documentrecordtypeid";
				sql += " AND drt.documentrecordtypeid = " + loaiVB;
			}

			sql += " LEFT OUTER JOIN (SELECT MAX(transition_) AS maxtran, documentsendid FROM pml_documentsend_log";
			sql += " WHERE receiver = " + userId;
			sql += " GROUP BY documentsendid) AS b ON log.documentsendid = b.documentsendid AND b.maxtran < log.transition_";
			sql += " LEFT OUTER JOIN pml_documentsend_log log2";
			sql += " ON log.documentsendid = log2.documentsendid AND b.maxtran = log2.transition_";
			sql += " WHERE (log.dateprocess IS null OR log.dateprocess >= '"
					+ ngaybatdauthongke + "')";
			sql += " AND ((log2.documentsendid IS NOT null and log2.receivedate IS NOT null";
			sql += " AND log2.receivedate BETWEEN '" + ngaybatdauthongke
					+ "' AND '" + ngayketthucthongke + "')";
			sql += " OR (log.senddatebefore IS null";
			sql += " AND cvdi.datecreated BETWEEN '" + ngaybatdauthongke
					+ "' AND '" + ngayketthucthongke + "'))";

			sql += " ORDER BY conf.confidentiallevelsymbol ASC, cvdi.datecreated DESC";

			sql = CustomSQLUtil.replaceOrderBy(sql, obc);

			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("PmlEdmDocumentSend", PmlEdmDocumentSendImpl.class);

			return (List<PmlEdmDocumentSend>) QueryUtil.list(q, getDialect(),
					start, end);
		} catch (Exception e) {
			throw processException(e);
		} finally {
			closeSession(session);
		}
	}

	/**
	 * chuyen vien chua nhan cong van di so luong
	 */
	public int countChuaNhanChuyenVien_CVDi(long userId,
			int documentRecordTypeId, int loaiVB, String doMat, Date fromDate,
			Date toDate) throws Exception {

		Session session = null;

		try {
			session = openSession();

			String ngayketthucthongke = new SimpleDateFormat("yyyy-MM-dd")
					.format(toDate);

			String sql = "SELECT COUNT(DISTINCT(cvdi.documentsendid)) AS COUNT_VALUE";
			sql += " FROM pml_documentsend_log log";
			sql += " INNER JOIN (SELECT MAX(transition_) AS maxtran, documentsendid";
			sql += " FROM pml_documentsend_log";
			sql += " WHERE processer = " + userId;
			sql += " GROUP BY documentsendid) AS a ON log.documentsendid = a.documentsendid AND a.maxtran = log.transition_";
			sql += " INNER JOIN pml_edm_documentsend cvdi ON cvdi.documentsendid = log.documentsendid";
			if (!doMat.equals("")) {
				sql += " AND cvdi.confidentiallevelid = '" + doMat + "'";
			}
			// Neu co chon phan nhom
			if (documentRecordTypeId != 0) {
				sql += " INNER JOIN pml_edm_documenttype t ON cvdi.documenttypeid = t.documenttypeid";
				sql += " AND t.documentrecordtypeid = " + documentRecordTypeId;
			}
			// Neu co chon loai van ban
			if (loaiVB != 0) {
				sql += " INNER JOIN pml_edm_documenttype dt ON cvdi.documenttypeid = dt.documenttypeid";
				sql += " INNER JOIN pml_edm_documentrecordtype drt ON dt.documentrecordtypeid = drt.documentrecordtypeid";
				sql += " AND drt.documentrecordtypeid = " + loaiVB;
			}

			sql += " LEFT OUTER JOIN (SELECT MAX(transition_) AS maxtran, documentsendid FROM pml_documentsend_log";
			sql += " WHERE receiver = " + userId;
			sql += " GROUP BY documentsendid) AS b ON log.documentsendid = b.documentsendid AND b.maxtran < log.transition_";
			sql += " LEFT OUTER JOIN pml_documentsend_log log2";
			sql += " ON log.documentsendid = log2.documentsendid AND b.maxtran = log2.transition_";
			sql += " WHERE (log.dateprocess IS null OR log.dateprocess > '"
					+ ngayketthucthongke + "')";
			sql += " AND log2.documentsendid IS NOT null AND (log2.receivedate IS null";
			sql += " OR log2.receivedate > '" + ngayketthucthongke + "')";
			sql += " AND log2.dateprocess <= '" + ngayketthucthongke
					+ "' AND cvdi.datecreated <= '" + ngayketthucthongke + "'";

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
			throw processException(e);
		} finally {
			closeSession(session);
		}
	}

	/**
	 * chuyen vien chua nhan cong van di danh sach
	 */
	public List<PmlEdmDocumentSend> listChuaNhanChuyenVien_CVDi(long userId,
			int documentRecordTypeId, int loaiVB, String doMat, Date fromDate,
			Date toDate, int start, int end, OrderByComparator obc)
			throws Exception {
		Session session = null;

		try {
			session = openSession();

			String ngayketthucthongke = new SimpleDateFormat("yyyy-MM-dd")
					.format(toDate);

			String sql = "SELECT DISTINCT(cvdi.*), conf.confidentiallevelsymbol";
			sql += " FROM pml_documentsend_log log";
			sql += " INNER JOIN (SELECT MAX(transition_) AS maxtran, documentsendid";
			sql += " FROM pml_documentsend_log";
			sql += " WHERE processer = " + userId;
			sql += " GROUP BY documentsendid) AS a ON log.documentsendid = a.documentsendid AND a.maxtran = log.transition_";
			sql += " INNER JOIN pml_edm_documentsend cvdi ON cvdi.documentsendid = log.documentsendid";

			sql += " INNER JOIN pml_edm_confidentiallevel conf ON cvdi.confidentiallevelid = conf.confidentiallevelid";
			if (!doMat.equals("")) {
				sql += " AND conf.confidentiallevelid = '" + doMat + "'";
			}

			// Neu co chon phan nhom
			if (documentRecordTypeId != 0) {
				sql += " INNER JOIN pml_edm_documenttype t ON cvdi.documenttypeid = t.documenttypeid";
				sql += " AND t.documentrecordtypeid = " + documentRecordTypeId;
			}
			// Neu co chon loai van ban
			if (loaiVB != 0) {
				sql += " INNER JOIN pml_edm_documenttype dt ON cvdi.documenttypeid = dt.documenttypeid";
				sql += " INNER JOIN pml_edm_documentrecordtype drt ON dt.documentrecordtypeid = drt.documentrecordtypeid";
				sql += " AND drt.documentrecordtypeid = " + loaiVB;
			}

			sql += " LEFT OUTER JOIN (SELECT MAX(transition_) AS maxtran, documentsendid FROM pml_documentsend_log";
			sql += " WHERE receiver = " + userId;
			sql += " GROUP BY documentsendid) AS b ON log.documentsendid = b.documentsendid AND b.maxtran < log.transition_";
			sql += " LEFT OUTER JOIN pml_documentsend_log log2";
			sql += " ON log.documentsendid = log2.documentsendid AND b.maxtran = log2.transition_";
			sql += " WHERE (log.dateprocess IS null OR log.dateprocess > '"
					+ ngayketthucthongke + "')";
			sql += " AND log2.documentsendid IS NOT null AND (log2.receivedate IS null";
			sql += " OR log2.receivedate > '" + ngayketthucthongke + "')";
			sql += " AND log2.dateprocess <= '" + ngayketthucthongke
					+ "' AND cvdi.datecreated <= '" + ngayketthucthongke + "'";

			sql += " ORDER BY conf.confidentiallevelsymbol ASC, cvdi.datecreated DESC";

			sql = CustomSQLUtil.replaceOrderBy(sql, obc);

			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("PmlEdmDocumentSend", PmlEdmDocumentSendImpl.class);

			return (List<PmlEdmDocumentSend>) QueryUtil.list(q, getDialect(),
					start, end);
		} catch (Exception e) {
			throw processException(e);
		} finally {
			closeSession(session);
		}
	}

	/**
	 * chuyen vien nhan trong thang cong van di so luong
	 */
	public int countNhanTrongThangChuyenVien_CVDi(long userId,
			int documentRecordTypeId, int loaiVB, Date fromDate, Date toDate)
			throws Exception {

		Session session = null;

		try {
			session = openSession();

			// Chuyen doi dinh dang ngay
			String ngaybatdauthongke = new SimpleDateFormat("yyyy-MM-dd")
					.format(fromDate);
			String ngayketthucthongke = new SimpleDateFormat("yyyy-MM-dd")
					.format(toDate);

			String sql = "SELECT COUNT(DISTINCT(cvdi.documentsendid)) AS COUNT_VALUE";
			sql += " FROM pml_documentsend_log log";
			sql += " INNER JOIN (SELECT MAX(transition_) AS maxtran, documentsendid";
			sql += " FROM pml_documentsend_log";
			sql += " WHERE processer = " + userId;
			sql += " GROUP BY documentsendid) AS a ON log.documentsendid = a.documentsendid AND a.maxtran = log.transition_";
			sql += " INNER JOIN pml_edm_documentsend cvdi ON cvdi.documentsendid = log.documentsendid";
			// Neu co chon phan nhom
			if (documentRecordTypeId != 0) {
				sql += " INNER JOIN pml_edm_documenttype t ON cvdi.documenttypeid = t.documenttypeid";
				sql += " AND t.documentrecordtypeid = " + documentRecordTypeId;
			}
			// Neu co chon loai van ban
			if (loaiVB != 0) {
				sql += " INNER JOIN pml_edm_documenttype dt ON cvdi.documenttypeid = dt.documenttypeid";
				sql += " INNER JOIN pml_edm_documentrecordtype drt ON dt.documentrecordtypeid = drt.documentrecordtypeid";
				sql += " AND drt.documentrecordtypeid = " + loaiVB;
			}

			sql += " LEFT OUTER JOIN (SELECT MAX(transition_) AS maxtran, documentsendid FROM pml_documentsend_log";
			sql += " WHERE receiver = " + userId;
			sql += " GROUP BY documentsendid) AS b ON log.documentsendid = b.documentsendid AND b.maxtran < log.transition_";
			sql += " LEFT OUTER JOIN pml_documentsend_log log2";
			sql += " ON log.documentsendid = log2.documentsendid AND b.maxtran = log2.transition_";
			sql += " WHERE (log.dateprocess IS null OR log.dateprocess >= '"
					+ ngaybatdauthongke + "')";
			sql += " AND ((log2.documentsendid IS NOT null AND (log2.receivedate is null OR log2.receivedate > '"
					+ ngaybatdauthongke
					+ "')"
					+ " AND log2.dateprocess <= '"
					+ ngayketthucthongke
					+ "' AND cvdi.datecreated <= '"
					+ ngayketthucthongke + "')";
			sql += " OR (log2.documentsendid IS null AND log.senddatebefore IS null"
					+ " AND cvdi.datecreated BETWEEN '"
					+ ngaybatdauthongke
					+ "' AND '" + ngayketthucthongke + "'))";

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
			throw processException(e);
		} finally {
			closeSession(session);
		}
	}

	/**
	 * chuyen vien nhan trong thang cong van di danh sach
	 */
	public List<PmlEdmDocumentSend> listNhanTrongThangChuyenVien_CVDi(
			long userId, int documentRecordTypeId, int loaiVB, Date fromDate,
			Date toDate, int start, int end, OrderByComparator obc)
			throws Exception {
		Session session = null;

		try {
			session = openSession();

			// Chuyen doi dinh dang ngay
			String ngaybatdauthongke = new SimpleDateFormat("yyyy-MM-dd")
					.format(fromDate);
			String ngayketthucthongke = new SimpleDateFormat("yyyy-MM-dd")
					.format(toDate);

			String sql = "SELECT DISTINCT(cvdi.*)";
			sql += " FROM pml_documentsend_log log";
			sql += " INNER JOIN (SELECT MAX(transition_) AS maxtran, documentsendid";
			sql += " FROM pml_documentsend_log";
			sql += " WHERE processer = " + userId;
			sql += " GROUP BY documentsendid) AS a ON log.documentsendid = a.documentsendid AND a.maxtran = log.transition_";
			sql += " INNER JOIN pml_edm_documentsend cvdi ON cvdi.documentsendid = log.documentsendid";
			// Neu co chon phan nhom
			if (documentRecordTypeId != 0) {
				sql += " INNER JOIN pml_edm_documenttype t ON cvdi.documenttypeid = t.documenttypeid";
				sql += " AND t.documentrecordtypeid = " + documentRecordTypeId;
			}
			// Neu co chon loai van ban
			if (loaiVB != 0) {
				sql += " INNER JOIN pml_edm_documenttype dt ON cvdi.documenttypeid = dt.documenttypeid";
				sql += " INNER JOIN pml_edm_documentrecordtype drt ON dt.documentrecordtypeid = drt.documentrecordtypeid";
				sql += " AND drt.documentrecordtypeid = " + loaiVB;
			}

			sql += " LEFT OUTER JOIN (SELECT MAX(transition_) AS maxtran, documentsendid FROM pml_documentsend_log";
			sql += " WHERE receiver = " + userId;
			sql += " GROUP BY documentsendid) AS b ON log.documentsendid = b.documentsendid AND b.maxtran < log.transition_";
			sql += " LEFT OUTER JOIN pml_documentsend_log log2";
			sql += " ON log.documentsendid = log2.documentsendid AND b.maxtran = log2.transition_";
			sql += " WHERE (log.dateprocess IS null OR log.dateprocess >= '"
					+ ngaybatdauthongke + "')";
			sql += " AND ((log2.documentsendid IS NOT null AND (log2.receivedate is null OR log2.receivedate > '"
					+ ngaybatdauthongke
					+ "')"
					+ " AND log2.dateprocess <= '"
					+ ngayketthucthongke
					+ "' AND cvdi.datecreated <= '"
					+ ngayketthucthongke + "')";
			sql += " OR (log2.documentsendid IS null AND log.senddatebefore IS null"
					+ " AND cvdi.datecreated BETWEEN '"
					+ ngaybatdauthongke
					+ "' AND '" + ngayketthucthongke + "'))";

			sql += " ORDER BY cvdi.documentreference ASC";

			// sql = CustomSQLUtil.replaceOrderBy(sql, obc);

			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("PmlEdmDocumentSend", PmlEdmDocumentSendImpl.class);

			return (List<PmlEdmDocumentSend>) QueryUtil.list(q, getDialect(),
					start, end);
		} catch (Exception e) {
			throw processException(e);
		} finally {
			closeSession(session);
		}
	}

	/**
	 * chuyen vien da giai quyet dung han cong van di so luong
	 */
	public int countDungHanDaXuLyChuyenVien_CVDi(long userId,
			int documentRecordTypeId, int loaiVB, String doMat, Date fromDate,
			Date toDate) throws Exception {

		Session session = null;

		try {
			session = openSession();

			String ngaybatdauthongke = new SimpleDateFormat("yyyy-MM-dd")
					.format(fromDate);
			String ngayketthucthongke = new SimpleDateFormat("yyyy-MM-dd")
					.format(toDate);

			String sql = "SELECT COUNT(DISTINCT(cvdi.documentsendid)) AS COUNT_VALUE";
			sql += " FROM pml_documentsend_log log";
			sql += " INNER JOIN (SELECT MAX(transition_) AS maxtran, documentsendid";
			sql += " FROM pml_documentsend_log";
			sql += " WHERE processer = " + userId;
			sql += " GROUP BY documentsendid) AS a ON log.documentsendid = a.documentsendid AND log.transition_ = a.maxtran";
			sql += " AND log.dateprocess BETWEEN '" + ngaybatdauthongke
					+ "' AND '" + ngayketthucthongke + "'";
			sql += " INNER JOIN pml_edm_documentsend cvdi ON log.documentsendid = cvdi.documentsendid";
			if (!doMat.equals("")) {
				sql += " AND cvdi.confidentiallevelid = '" + doMat + "'";
			}
			// Neu co chon phan nhom
			if (documentRecordTypeId != 0) {
				sql += " INNER JOIN pml_edm_documenttype t ON cvdi.documenttypeid = t.documenttypeid";
				sql += " AND t.documentrecordtypeid = " + documentRecordTypeId;
			}
			// Neu co chon loai van ban
			if (loaiVB != 0) {
				sql += " INNER JOIN pml_edm_documenttype dt ON cvdi.documenttypeid = dt.documenttypeid";
				sql += " INNER JOIN pml_edm_documentrecordtype drt ON dt.documentrecordtypeid = drt.documentrecordtypeid";
				sql += " AND drt.documentrecordtypeid = " + loaiVB;
			}

			sql += " LEFT OUTER JOIN pml_edm_answerdetail rep ON cvdi.documentsendid = rep.documentsendid";
			sql += " LEFT OUTER JOIN pml_edm_documentreceipt cvden ON rep.documentreceiptid = cvden.documentreceiptid";
			sql += " WHERE (log.processer <> cvdi.editorid)";
			sql += " OR (rep.documentreceiptid IS NULL)";
			sql += " OR (rep.documentreceiptid IS NOT NULL AND cvden.processtime = 0)";
			sql += " OR (rep.documentreceiptid IS NOT NULL AND cvden.processtime > 0";
			sql += " AND (((cvdi.issuingdate IS NULL OR cvdi.issuingdate > '"
					+ ngayketthucthongke + "')";
			sql += " AND cvden.datearrive + cvden.processtime + songaynghile(cvden.datearrive, cvden.processtime) >= '"
					+ ngayketthucthongke + "')";
			sql += " OR (cvdi.issuingdate IS NOT NULL";
			sql += " AND cvden.datearrive + cvden.processtime + songaynghile(cvden.datearrive, cvden.processtime) >= cvdi.issuingdate)))";

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
			throw processException(e);
		} finally {
			closeSession(session);
		}
	}

	/**
	 * chuyen vien da giai quyet dung han cong van di danh sach
	 */
	public List<PmlEdmDocumentSend> listDungHanDaXuLyChuyenVien_CVDi(
			long userId, int documentRecordTypeId, int loaiVB, String doMat,
			Date fromDate, Date toDate, int start, int end,
			OrderByComparator obc) throws Exception {

		Session session = null;

		try {
			session = openSession();

			String ngaybatdauthongke = new SimpleDateFormat("yyyy-MM-dd")
					.format(fromDate);
			String ngayketthucthongke = new SimpleDateFormat("yyyy-MM-dd")
					.format(toDate);

			String sql = "SELECT DISTINCT(cvdi.*), conf.confidentiallevelsymbol";
			sql += " FROM pml_documentsend_log log";
			sql += " INNER JOIN (SELECT MAX(transition_) AS maxtran, documentsendid";
			sql += " FROM pml_documentsend_log";
			sql += " WHERE processer = " + userId;
			sql += " GROUP BY documentsendid) AS a ON log.documentsendid = a.documentsendid AND log.transition_ = a.maxtran";
			sql += " AND log.dateprocess BETWEEN '" + ngaybatdauthongke
					+ "' AND '" + ngayketthucthongke + "'";
			sql += " INNER JOIN pml_edm_documentsend cvdi ON log.documentsendid = cvdi.documentsendid";

			sql += " INNER JOIN pml_edm_confidentiallevel conf ON cvdi.confidentiallevelid = conf.confidentiallevelid";
			if (!doMat.equals("")) {
				sql += " AND conf.confidentiallevelid = '" + doMat + "'";
			}

			// Neu co chon phan nhom
			if (documentRecordTypeId != 0) {
				sql += " INNER JOIN pml_edm_documenttype t ON cvdi.documenttypeid = t.documenttypeid";
				sql += " AND t.documentrecordtypeid = " + documentRecordTypeId;
			}
			// Neu co chon loai van ban
			if (loaiVB != 0) {
				sql += " INNER JOIN pml_edm_documenttype dt ON cvdi.documenttypeid = dt.documenttypeid";
				sql += " INNER JOIN pml_edm_documentrecordtype drt ON dt.documentrecordtypeid = drt.documentrecordtypeid";
				sql += " AND drt.documentrecordtypeid = " + loaiVB;
			}

			sql += " LEFT OUTER JOIN pml_edm_answerdetail rep ON cvdi.documentsendid = rep.documentsendid";
			sql += " LEFT OUTER JOIN pml_edm_documentreceipt cvden ON rep.documentreceiptid = cvden.documentreceiptid";
			sql += " WHERE (log.processer <> cvdi.editorid)";
			sql += " OR (rep.documentreceiptid IS NULL)";
			sql += " OR (rep.documentreceiptid IS NOT NULL AND cvden.processtime = 0)";
			sql += " OR (rep.documentreceiptid IS NOT NULL AND cvden.processtime > 0";
			sql += " AND (((cvdi.issuingdate IS NULL OR cvdi.issuingdate > '"
					+ ngayketthucthongke + "')";
			sql += " AND cvden.datearrive + cvden.processtime + songaynghile(cvden.datearrive, cvden.processtime) >= '"
					+ ngayketthucthongke + "')";
			sql += " OR (cvdi.issuingdate IS NOT NULL";
			sql += " AND cvden.datearrive + cvden.processtime + songaynghile(cvden.datearrive, cvden.processtime) >= cvdi.issuingdate)))";

			sql += " ORDER BY conf.confidentiallevelsymbol ASC, cvdi.datecreated DESC";

			sql = CustomSQLUtil.replaceOrderBy(sql, obc);

			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("PmlEdmDocumentSend", PmlEdmDocumentSendImpl.class);

			return (List<PmlEdmDocumentSend>) QueryUtil.list(q, getDialect(),
					start, end);
		} catch (Exception e) {
			throw processException(e);
		} finally {
			closeSession(session);
		}
	}

	/**
	 * chuyen vien da giai quyet tre han cong van di so luong
	 */
	public int countTreHanDaXuLyChuyenVien_CVDi(long userId,
			int documentRecordTypeId, int loaiVB, String doMat, Date fromDate,
			Date toDate) throws Exception {

		Session session = null;

		try {
			session = openSession();

			String ngaybatdauthongke = new SimpleDateFormat("yyyy-MM-dd")
					.format(fromDate);
			String ngayketthucthongke = new SimpleDateFormat("yyyy-MM-dd")
					.format(toDate);

			String sql = "SELECT COUNT(DISTINCT(cvdi.documentsendid)) AS COUNT_VALUE";
			sql += " FROM pml_documentsend_log log";
			sql += " INNER JOIN (SELECT MAX(transition_) AS maxtran, documentsendid";
			sql += " FROM pml_documentsend_log";
			sql += " WHERE processer = " + userId;
			sql += " GROUP BY documentsendid) AS a ON log.documentsendid = a.documentsendid AND log.transition_ = a.maxtran";
			sql += " AND log.dateprocess BETWEEN '" + ngaybatdauthongke
					+ "' AND '" + ngayketthucthongke + "'";
			sql += " INNER JOIN pml_edm_documentsend cvdi ON log.documentsendid = cvdi.documentsendid";
			if (!doMat.equals("")) {
				sql += " AND cvdi.confidentiallevelid = '" + doMat + "'";
			}
			// Neu co chon phan nhom
			if (documentRecordTypeId != 0) {
				sql += " INNER JOIN pml_edm_documenttype t ON cvdi.documenttypeid = t.documenttypeid";
				sql += " AND t.documentrecordtypeid = " + documentRecordTypeId;
			}
			// Neu co chon loai van ban
			if (loaiVB != 0) {
				sql += " INNER JOIN pml_edm_documenttype dt ON cvdi.documenttypeid = dt.documenttypeid";
				sql += " INNER JOIN pml_edm_documentrecordtype drt ON dt.documentrecordtypeid = drt.documentrecordtypeid";
				sql += " AND drt.documentrecordtypeid = " + loaiVB;
			}

			sql += " LEFT OUTER JOIN pml_edm_answerdetail rep ON cvdi.documentsendid = rep.documentsendid";
			sql += " LEFT OUTER JOIN pml_edm_documentreceipt cvden ON rep.documentreceiptid = cvden.documentreceiptid";
			sql += " WHERE log.processer = cvdi.editorid AND rep.documentreceiptid IS NOT NULL AND cvden.processtime > 0";
			sql += " AND (((cvdi.issuingdate IS NULL OR cvdi.issuingdate > '"
					+ ngayketthucthongke + "')";
			sql += " AND cvden.datearrive + cvden.processtime + songaynghile(cvden.datearrive, cvden.processtime) < '"
					+ ngayketthucthongke + "')";
			sql += " OR (cvdi.issuingdate IS NOT NULL";
			sql += " AND cvden.datearrive + cvden.processtime + songaynghile(cvden.datearrive, cvden.processtime) < cvdi.issuingdate))";

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
			throw processException(e);
		} finally {
			closeSession(session);
		}
	}

	/**
	 * chuyen vien da giai quyet tre han cong van di danh sach
	 */
	public List<PmlEdmDocumentSend> listTreHanDaXuLyChuyenVien_CVDi(
			long userId, int documentRecordTypeId, int loaiVB, String doMat,
			Date fromDate, Date toDate, int start, int end,
			OrderByComparator obc) throws Exception {
		Session session = null;

		try {
			session = openSession();

			String ngaybatdauthongke = new SimpleDateFormat("yyyy-MM-dd")
					.format(fromDate);
			String ngayketthucthongke = new SimpleDateFormat("yyyy-MM-dd")
					.format(toDate);

			String sql = "SELECT DISTINCT(cvdi.*), conf.confidentiallevelsymbol";
			sql += " FROM pml_documentsend_log log";
			sql += " INNER JOIN (SELECT MAX(transition_) AS maxtran, documentsendid";
			sql += " FROM pml_documentsend_log";
			sql += " WHERE processer = " + userId;
			sql += " GROUP BY documentsendid) AS a ON log.documentsendid = a.documentsendid AND log.transition_ = a.maxtran";
			sql += " AND log.dateprocess BETWEEN '" + ngaybatdauthongke
					+ "' AND '" + ngayketthucthongke + "'";
			sql += " INNER JOIN pml_edm_documentsend cvdi ON log.documentsendid = cvdi.documentsendid";

			sql += " INNER JOIN pml_edm_confidentiallevel conf ON cvdi.confidentiallevelid = conf.confidentiallevelid";
			if (!doMat.equals("")) {
				sql += " AND conf.confidentiallevelid = '" + doMat + "'";
			}

			// Neu co chon phan nhom
			if (documentRecordTypeId != 0) {
				sql += " INNER JOIN pml_edm_documenttype t ON cvdi.documenttypeid = t.documenttypeid";
				sql += " AND t.documentrecordtypeid = " + documentRecordTypeId;
			}
			// Neu co chon loai van ban
			if (loaiVB != 0) {
				sql += " INNER JOIN pml_edm_documenttype dt ON cvdi.documenttypeid = dt.documenttypeid";
				sql += " INNER JOIN pml_edm_documentrecordtype drt ON dt.documentrecordtypeid = drt.documentrecordtypeid";
				sql += " AND drt.documentrecordtypeid = " + loaiVB;
			}

			sql += " LEFT OUTER JOIN pml_edm_answerdetail rep ON cvdi.documentsendid = rep.documentsendid";
			sql += " LEFT OUTER JOIN pml_edm_documentreceipt cvden ON rep.documentreceiptid = cvden.documentreceiptid";
			sql += " WHERE log.processer = cvdi.editorid AND rep.documentreceiptid IS NOT NULL AND cvden.processtime > 0";
			sql += " AND (((cvdi.issuingdate IS NULL OR cvdi.issuingdate > '"
					+ ngayketthucthongke + "')";
			sql += " AND cvden.datearrive + cvden.processtime + songaynghile(cvden.datearrive, cvden.processtime) < '"
					+ ngayketthucthongke + "')";
			sql += " OR (cvdi.issuingdate IS NOT NULL";
			sql += " AND cvden.datearrive + cvden.processtime + songaynghile(cvden.datearrive, cvden.processtime) < cvdi.issuingdate))";

			sql += " ORDER BY conf.confidentiallevelsymbol ASC, cvdi.datecreated DESC";

			sql = CustomSQLUtil.replaceOrderBy(sql, obc);

			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("PmlEdmDocumentSend", PmlEdmDocumentSendImpl.class);

			return (List<PmlEdmDocumentSend>) QueryUtil.list(q, getDialect(),
					start, end);
		} catch (Exception e) {
			throw processException(e);
		} finally {
			closeSession(session);
		}
	}

	/**
	 * chuyen vien tong da giai quyet cong van di so luong
	 */
	public int countTongDaXuLyChuyenVien_CVDi(long userId,
			int documentRecordTypeId, int loaiVB, String doMat, Date fromDate,
			Date toDate) throws Exception {

		Session session = null;

		try {
			session = openSession();

			String ngaybatdauthongke = new SimpleDateFormat("yyyy-MM-dd")
					.format(fromDate);
			String ngayketthucthongke = new SimpleDateFormat("yyyy-MM-dd")
					.format(toDate);

			String sql = "SELECT COUNT(DISTINCT(cvdi.documentsendid)) AS COUNT_VALUE";
			sql += " FROM (SELECT MAX(log.transition_) AS maxtran, log.documentsendid";
			sql += " FROM pml_documentsend_log log";
			sql += " WHERE log.processer = " + userId;
			sql += " GROUP BY log.documentsendid) AS a, pml_documentsend_log log, pml_edm_documentsend cvdi";

			if (documentRecordTypeId != 0) { // Chon phan nhom
				sql += ", pml_edm_documenttype t";
			}
			if (0 != loaiVB) {
				sql += ", pml_edm_documenttype dt, pml_edm_documentrecordtype drt";
			}

			sql += " WHERE cvdi.documentsendid = log.documentsendid";
			sql += " AND a.maxtran = log.transition_";
			sql += " AND a.documentsendid = log.documentsendid";

			sql += " AND (log.dateprocess is not null AND log.dateprocess between '"
					+ ngaybatdauthongke + "' AND '" + ngayketthucthongke + "')";

			if (!doMat.equals("")) {
				sql += " AND cvdi.confidentiallevelid = '" + doMat + "'";
			}

			if (documentRecordTypeId != 0) { // Chon phan nhom
				sql += " AND cvdi.documenttypeid = t.documenttypeid";
				sql += " AND t.documentrecordtypeid = " + documentRecordTypeId;
			}
			if (0 != loaiVB) {
				sql += " AND cvdi.documenttypeid = dt.documenttypeid AND dt.documentrecordtypeid = drt.documentrecordtypeid AND drt.documentrecordtypeid = "
						+ loaiVB;
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
			throw processException(e);
		} finally {
			closeSession(session);
		}
	}

	/**
	 * chuyen vien tong da giai quyet cong van di danh sach = da giai quyet dung
	 * han (cv di) + da giai quyet tre han (cv di)
	 */
	public List<PmlEdmDocumentSend> listTongDaXuLyChuyenVien_CVDi(long userId,
			int documentRecordTypeId, int loaiVB, String doMat, Date fromDate,
			Date toDate, int start, int end, OrderByComparator obc)
			throws Exception {

		Session session = null;

		try {
			session = openSession();

			String ngaybatdauthongke = new SimpleDateFormat("yyyy-MM-dd")
					.format(fromDate);
			String ngayketthucthongke = new SimpleDateFormat("yyyy-MM-dd")
					.format(toDate);

			String sql = "SELECT DISTINCT(cvdi.*), conf.confidentiallevelsymbol";
			sql += " FROM (SELECT MAX(log.transition_) AS maxtran, log.documentsendid";
			sql += " FROM pml_documentsend_log log";
			sql += " WHERE log.processer = " + userId;
			sql += " GROUP BY log.documentsendid) AS a, pml_documentsend_log log, pml_edm_documentsend cvdi, pml_edm_confidentiallevel conf";

			if (documentRecordTypeId != 0) { // Chon phan nhom
				sql += ", pml_edm_documenttype t";
			}
			if (0 != loaiVB) {
				sql += ", pml_edm_documenttype dt, pml_edm_documentrecordtype drt";
			}

			sql += " WHERE cvdi.documentsendid = log.documentsendid";
			sql += " AND a.maxtran = log.transition_";
			sql += " AND a.documentsendid = log.documentsendid";

			sql += " AND (log.dateprocess is not null AND log.dateprocess between '"
					+ ngaybatdauthongke + "' AND '" + ngayketthucthongke + "')";

			sql += " AND cvdi.confidentiallevelid = conf.confidentiallevelid";
			if (!doMat.equals("")) {
				sql += " AND conf.confidentiallevelid = '" + doMat + "'";
			}

			if (documentRecordTypeId != 0) { // Chon phan nhom
				sql += " AND cvdi.documenttypeid = t.documenttypeid";
				sql += " AND t.documentrecordtypeid = " + documentRecordTypeId;
			}
			if (0 != loaiVB) {
				sql += " AND cvdi.documenttypeid = dt.documenttypeid AND dt.documentrecordtypeid = drt.documentrecordtypeid AND drt.documentrecordtypeid = "
						+ loaiVB;
			}

			sql += " ORDER BY conf.confidentiallevelsymbol ASC, cvdi.datecreated DESC";

			sql = CustomSQLUtil.replaceOrderBy(sql, obc);

			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("PmlEdmDocumentSend", PmlEdmDocumentSendImpl.class);

			return (List<PmlEdmDocumentSend>) QueryUtil.list(q, getDialect(),
					start, end);
		} catch (Exception e) {
			throw processException(e);
		} finally {
			closeSession(session);
		}
	}

	/**
	 * chuyen vien dang giai quyet dung han cong van di so luong
	 */
	public int countDungHanDangXuLyChuyenVien_CVDi(long userId,
			int documentRecordTypeId, int loaiVB, String doMat, Date fromDate,
			Date toDate) throws Exception {
		Session session = null;

		try {
			session = openSession();

			String ngayketthucthongke = new SimpleDateFormat("yyyy-MM-dd")
					.format(toDate);

			String sql = "SELECT COUNT(DISTINCT(cvdi.documentsendid)) AS COUNT_VALUE";
			sql += " FROM pml_documentsend_log log";
			sql += " INNER JOIN (SELECT MAX(transition_) AS maxtran, documentsendid";
			sql += " FROM pml_documentsend_log";
			sql += " WHERE processer = " + userId;
			sql += " GROUP BY documentsendid) AS a ON log.documentsendid = a.documentsendid AND log.transition_ = a.maxtran";
			sql += " AND (log.dateprocess IS NULL OR log.dateprocess > '"
					+ ngayketthucthongke + "')";
			sql += " INNER JOIN pml_edm_documentsend cvdi ON log.documentsendid = cvdi.documentsendid";
			sql += " AND ((log.senddatebefore IS NOT NULL AND log.senddatebefore <= '"
					+ ngayketthucthongke + "')";
			sql += " OR (log.senddatebefore IS NULL AND cvdi.datecreated <= '"
					+ ngayketthucthongke + "'))";

			if (!doMat.equals("")) {
				sql += " AND cvdi.confidentiallevelid = '" + doMat + "'";
			}

			// Neu co chon phan nhom
			if (documentRecordTypeId != 0) {
				sql += " INNER JOIN pml_edm_documenttype t ON cvdi.documenttypeid = t.documenttypeid";
				sql += " AND t.documentrecordtypeid = " + documentRecordTypeId;
			}
			// Neu co chon loai van ban
			if (loaiVB != 0) {
				sql += " INNER JOIN pml_edm_documenttype dt ON cvdi.documenttypeid = dt.documenttypeid";
				sql += " INNER JOIN pml_edm_documentrecordtype drt ON dt.documentrecordtypeid = drt.documentrecordtypeid";
				sql += " AND drt.documentrecordtypeid = " + loaiVB;
			}

			sql += " LEFT OUTER JOIN pml_edm_answerdetail rep ON cvdi.documentsendid = rep.documentsendid";
			sql += " LEFT OUTER JOIN pml_edm_documentreceipt cvden ON rep.documentreceiptid = cvden.documentreceiptid";
			sql += " WHERE (log.processer <> cvdi.editorid)";
			sql += " OR (rep.documentreceiptid IS NULL)";
			sql += " OR (rep.documentreceiptid IS NOT NULL AND cvden.processtime = 0)";
			sql += " OR (rep.documentreceiptid IS NOT NULL AND cvden.processtime > 0";
			sql += " AND (((cvdi.issuingdate IS NULL OR cvdi.issuingdate > '"
					+ ngayketthucthongke + "')";
			sql += " AND cvden.datearrive + cvden.processtime + songaynghile(cvden.datearrive, cvden.processtime) >= '"
					+ ngayketthucthongke + "')";
			sql += " OR (cvdi.issuingdate IS NOT NULL";
			sql += " AND cvden.datearrive + cvden.processtime + songaynghile(cvden.datearrive, cvden.processtime) >= cvdi.issuingdate)))";

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
			throw processException(e);
		} finally {
			closeSession(session);
		}
	}

	/**
	 * chuyen vien dang giai quyet dung han cong van di danh sach
	 */
	public List<PmlEdmDocumentSend> listDungHanDangXuLyChuyenVien_CVDi(
			long userId, int documentRecordTypeId, int loaiVB, String doMat,
			Date fromDate, Date toDate, int start, int end,
			OrderByComparator obc) throws Exception {
		Session session = null;

		try {
			session = openSession();

			String ngayketthucthongke = new SimpleDateFormat("yyyy-MM-dd")
					.format(toDate);

			String sql = "SELECT DISTINCT(cvdi.*), conf.confidentiallevelsymbol";
			sql += " FROM pml_documentsend_log log";
			sql += " INNER JOIN (SELECT MAX(transition_) AS maxtran, documentsendid";
			sql += " FROM pml_documentsend_log";
			sql += " WHERE processer = " + userId;
			sql += " GROUP BY documentsendid) AS a ON log.documentsendid = a.documentsendid AND log.transition_ = a.maxtran";
			sql += " AND (log.dateprocess IS NULL OR log.dateprocess > '"
					+ ngayketthucthongke + "')";
			sql += " INNER JOIN pml_edm_documentsend cvdi ON log.documentsendid = cvdi.documentsendid";
			sql += " AND ((log.senddatebefore IS NOT NULL AND log.senddatebefore <= '"
					+ ngayketthucthongke + "')";
			sql += " OR (log.senddatebefore IS NULL AND cvdi.datecreated <= '"
					+ ngayketthucthongke + "'))";

			sql += " INNER JOIN pml_edm_confidentiallevel conf ON cvdi.confidentiallevelid = conf.confidentiallevelid";
			if (!doMat.equals("")) {
				sql += " AND conf.confidentiallevelid = '" + doMat + "'";
			}

			// Neu co chon phan nhom
			if (documentRecordTypeId != 0) {
				sql += " INNER JOIN pml_edm_documenttype t ON cvdi.documenttypeid = t.documenttypeid";
				sql += " AND t.documentrecordtypeid = " + documentRecordTypeId;
			}
			// Neu co chon loai van ban
			if (loaiVB != 0) {
				sql += " INNER JOIN pml_edm_documenttype dt ON cvdi.documenttypeid = dt.documenttypeid";
				sql += " INNER JOIN pml_edm_documentrecordtype drt ON dt.documentrecordtypeid = drt.documentrecordtypeid";
				sql += " AND drt.documentrecordtypeid = " + loaiVB;
			}

			sql += " LEFT OUTER JOIN pml_edm_answerdetail rep ON cvdi.documentsendid = rep.documentsendid";
			sql += " LEFT OUTER JOIN pml_edm_documentreceipt cvden ON rep.documentreceiptid = cvden.documentreceiptid";
			sql += " WHERE (log.processer <> cvdi.editorid)";
			sql += " OR (rep.documentreceiptid IS NULL)";
			sql += " OR (rep.documentreceiptid IS NOT NULL AND cvden.processtime = 0)";
			sql += " OR (rep.documentreceiptid IS NOT NULL AND cvden.processtime > 0";
			sql += " AND (((cvdi.issuingdate IS NULL OR cvdi.issuingdate > '"
					+ ngayketthucthongke + "')";
			sql += " AND cvden.datearrive + cvden.processtime + songaynghile(cvden.datearrive, cvden.processtime) >= '"
					+ ngayketthucthongke + "')";
			sql += " OR (cvdi.issuingdate IS NOT NULL";
			sql += " AND cvden.datearrive + cvden.processtime + songaynghile(cvden.datearrive, cvden.processtime) >= cvdi.issuingdate)))";

			sql += " ORDER BY conf.confidentiallevelsymbol ASC, cvdi.datecreated DESC";

			sql = CustomSQLUtil.replaceOrderBy(sql, obc);

			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("PmlEdmDocumentSend", PmlEdmDocumentSendImpl.class);

			return (List<PmlEdmDocumentSend>) QueryUtil.list(q, getDialect(),
					start, end);
		} catch (Exception e) {
			throw processException(e);
		} finally {
			closeSession(session);
		}
	}

	/**
	 * chuyen vien dang giai quyet tre han cong van di so luong
	 */
	public int countTreHanDangXuLyChuyenVien_CVDi(long userId,
			int documentRecordTypeId, int loaiVB, String doMat, Date fromDate,
			Date toDate) throws Exception {
		Session session = null;

		try {
			session = openSession();

			String ngayketthucthongke = new SimpleDateFormat("yyyy-MM-dd")
					.format(toDate);

			String sql = "SELECT COUNT(DISTINCT(cvdi.documentsendid)) AS COUNT_VALUE";
			sql += " FROM pml_documentsend_log log";
			sql += " INNER JOIN (SELECT MAX(transition_) AS maxtran, documentsendid";
			sql += " FROM pml_documentsend_log";
			sql += " WHERE processer = " + userId;
			sql += " GROUP BY documentsendid) AS a ON log.documentsendid = a.documentsendid AND log.transition_ = a.maxtran";
			sql += " AND (log.dateprocess IS NULL OR log.dateprocess > '"
					+ ngayketthucthongke + "')";
			sql += " INNER JOIN pml_edm_documentsend cvdi ON log.documentsendid = cvdi.documentsendid";
			sql += " AND ((log.senddatebefore IS NOT NULL AND log.senddatebefore <= '"
					+ ngayketthucthongke + "')";
			sql += " OR (log.senddatebefore IS NULL AND cvdi.datecreated <= '"
					+ ngayketthucthongke + "'))";

			if (!doMat.equals("")) {
				sql += " AND cvdi.confidentiallevelid = '" + doMat + "'";
			}

			// Neu co chon phan nhom
			if (documentRecordTypeId != 0) {
				sql += " INNER JOIN pml_edm_documenttype t ON cvdi.documenttypeid = t.documenttypeid";
				sql += " AND t.documentrecordtypeid = " + documentRecordTypeId;
			}
			// Neu co chon loai van ban
			if (loaiVB != 0) {
				sql += " INNER JOIN pml_edm_documenttype dt ON cvdi.documenttypeid = dt.documenttypeid";
				sql += " INNER JOIN pml_edm_documentrecordtype drt ON dt.documentrecordtypeid = drt.documentrecordtypeid";
				sql += " AND drt.documentrecordtypeid = " + loaiVB;
			}

			sql += " LEFT OUTER JOIN pml_edm_answerdetail rep ON cvdi.documentsendid = rep.documentsendid";
			sql += " LEFT OUTER JOIN pml_edm_documentreceipt cvden ON rep.documentreceiptid = cvden.documentreceiptid";
			sql += " WHERE log.processer = cvdi.editorid AND rep.documentreceiptid IS NOT NULL AND cvden.processtime > 0";
			sql += " AND (((cvdi.issuingdate IS NULL OR cvdi.issuingdate > '"
					+ ngayketthucthongke + "')";
			sql += " AND cvden.datearrive + cvden.processtime + songaynghile(cvden.datearrive, cvden.processtime) < '"
					+ ngayketthucthongke + "')";
			sql += " OR (cvdi.issuingdate IS NOT NULL";
			sql += " AND cvden.datearrive + cvden.processtime + songaynghile(cvden.datearrive, cvden.processtime) < cvdi.issuingdate))";

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
			throw processException(e);
		} finally {
			closeSession(session);
		}
	}

	/**
	 * chuyen vien dang giai quyet tre han cong van di danh sach
	 */
	public List<PmlEdmDocumentSend> listTreHanDangXuLyChuyenVien_CVDi(
			long userId, int documentRecordTypeId, int loaiVB, String doMat,
			Date fromDate, Date toDate, int start, int end,
			OrderByComparator obc) throws Exception {
		Session session = null;

		try {
			session = openSession();

			String ngayketthucthongke = new SimpleDateFormat("yyyy-MM-dd")
					.format(toDate);

			String sql = "SELECT DISTINCT(cvdi.*), conf.confidentiallevelsymbol";
			sql += " FROM pml_documentsend_log log";
			sql += " INNER JOIN (SELECT MAX(transition_) AS maxtran, documentsendid";
			sql += " FROM pml_documentsend_log";
			sql += " WHERE processer = " + userId;
			sql += " GROUP BY documentsendid) AS a ON log.documentsendid = a.documentsendid AND log.transition_ = a.maxtran";
			sql += " AND (log.dateprocess IS NULL OR log.dateprocess > '"
					+ ngayketthucthongke + "')";
			sql += " INNER JOIN pml_edm_documentsend cvdi ON log.documentsendid = cvdi.documentsendid";
			sql += " AND ((log.senddatebefore IS NOT NULL AND log.senddatebefore <= '"
					+ ngayketthucthongke + "')";
			sql += " OR (log.senddatebefore IS NULL AND cvdi.datecreated <= '"
					+ ngayketthucthongke + "'))";

			sql += " INNER JOIN pml_edm_confidentiallevel conf ON cvdi.confidentiallevelid = conf.confidentiallevelid";
			if (!doMat.equals("")) {
				sql += " AND conf.confidentiallevelid = '" + doMat + "'";
			}

			// Neu co chon phan nhom
			if (documentRecordTypeId != 0) {
				sql += " INNER JOIN pml_edm_documenttype t ON cvdi.documenttypeid = t.documenttypeid";
				sql += " AND t.documentrecordtypeid = " + documentRecordTypeId;
			}
			// Neu co chon loai van ban
			if (loaiVB != 0) {
				sql += " INNER JOIN pml_edm_documenttype dt ON cvdi.documenttypeid = dt.documenttypeid";
				sql += " INNER JOIN pml_edm_documentrecordtype drt ON dt.documentrecordtypeid = drt.documentrecordtypeid";
				sql += " AND drt.documentrecordtypeid = " + loaiVB;
			}

			sql += " LEFT OUTER JOIN pml_edm_answerdetail rep ON cvdi.documentsendid = rep.documentsendid";
			sql += " LEFT OUTER JOIN pml_edm_documentreceipt cvden ON rep.documentreceiptid = cvden.documentreceiptid";
			sql += " WHERE log.processer = cvdi.editorid AND rep.documentreceiptid IS NOT NULL AND cvden.processtime > 0";
			sql += " AND (((cvdi.issuingdate IS NULL OR cvdi.issuingdate > '"
					+ ngayketthucthongke + "')";
			sql += " AND cvden.datearrive + cvden.processtime + songaynghile(cvden.datearrive, cvden.processtime) < '"
					+ ngayketthucthongke + "')";
			sql += " OR (cvdi.issuingdate IS NOT NULL";
			sql += " AND cvden.datearrive + cvden.processtime + songaynghile(cvden.datearrive, cvden.processtime) < cvdi.issuingdate))";

			sql += " ORDER BY conf.confidentiallevelsymbol ASC, cvdi.datecreated DESC";

			sql = CustomSQLUtil.replaceOrderBy(sql, obc);

			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("PmlEdmDocumentSend", PmlEdmDocumentSendImpl.class);

			return (List<PmlEdmDocumentSend>) QueryUtil.list(q, getDialect(),
					start, end);
		} catch (Exception e) {
			throw processException(e);
		} finally {
			closeSession(session);
		}
	}

	/**
	 * chuyen vien tong dang giai quyet cong van di so luong
	 */
	public int countTongDangXuLyChuyenVien_CVDi(long userId,
			int documentRecordTypeId, int loaiVB, String doMat, Date fromDate,
			Date toDate) throws Exception {
		Session session = null;

		try {
			session = openSession();

			String ngayketthucthongke = new SimpleDateFormat("yyyy-MM-dd")
					.format(toDate);

			String sql = "SELECT COUNT(DISTINCT(cvdi.documentsendid)) AS COUNT_VALUE";
			sql += " FROM (SELECT MAX(log.transition_) AS maxtran, log.documentsendid";
			sql += " FROM pml_documentsend_log log";
			sql += " WHERE log.processer = " + userId;
			sql += " GROUP BY log.documentsendid) AS a, pml_documentsend_log log, pml_edm_documentsend cvdi";

			if (documentRecordTypeId != 0) { // Chon phan nhom
				sql += ", pml_edm_documenttype t";
			}
			if (0 != loaiVB) {
				sql += ", pml_edm_documenttype dt, pml_edm_documentrecordtype drt";
			}

			sql += " WHERE cvdi.documentsendid = log.documentsendid";
			sql += " AND a.maxtran = log.transition_";
			sql += " AND a.documentsendid = log.documentsendid";

			sql += " AND (log.dateprocess is null or log.dateprocess > '"
					+ ngayketthucthongke + "')";
			sql += " AND ((log.senddatebefore is not null AND log.senddatebefore <= '"
					+ ngayketthucthongke
					+ "')"
					+ " OR (log.senddatebefore is null AND cvdi.datecreated <= '"
					+ ngayketthucthongke + "'))";

			if (!doMat.equals("")) {
				sql += " AND cvdi.confidentiallevelid = '" + doMat + "'";
			}

			if (documentRecordTypeId != 0) { // Chon phan nhom
				sql += " AND cvdi.documenttypeid = t.documenttypeid";
				sql += " AND t.documentrecordtypeid = " + documentRecordTypeId;
			}
			if (0 != loaiVB) {
				sql += " AND cvdi.documenttypeid = dt.documenttypeid AND dt.documentrecordtypeid = drt.documentrecordtypeid AND drt.documentrecordtypeid = "
						+ loaiVB;
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
			throw processException(e);
		} finally {
			closeSession(session);
		}
	}

	/**
	 * chuyen vien tong dang giai quyet cong van di danh sach (dung han + tre
	 * han)
	 */
	public List<PmlEdmDocumentSend> listTongDangXuLyChuyenVien_CVDi(
			long userId, int documentRecordTypeId, int loaiVB, String doMat,
			Date fromDate, Date toDate, int start, int end,
			OrderByComparator obc) throws Exception {
		Session session = null;

		try {
			session = openSession();

			String ngayketthucthongke = new SimpleDateFormat("yyyy-MM-dd")
					.format(toDate);

			String sql = "SELECT DISTINCT(cvdi.*), conf.confidentiallevelsymbol";
			sql += " FROM (SELECT MAX(log.transition_) AS maxtran, log.documentsendid";
			sql += " FROM pml_documentsend_log log";
			sql += " WHERE log.processer = " + userId;
			sql += " GROUP BY log.documentsendid) AS a, pml_documentsend_log log, pml_edm_documentsend cvdi, pml_edm_confidentiallevel conf";

			if (documentRecordTypeId != 0) { // Chon phan nhom
				sql += ", pml_edm_documenttype t";
			}
			if (0 != loaiVB) {
				sql += ", pml_edm_documenttype dt, pml_edm_documentrecordtype drt";
			}

			sql += " WHERE cvdi.documentsendid = log.documentsendid";
			sql += " AND a.maxtran = log.transition_";
			sql += " AND a.documentsendid = log.documentsendid";

			sql += " AND (log.dateprocess is null or log.dateprocess > '"
					+ ngayketthucthongke + "')";
			sql += " AND ((log.senddatebefore is not null AND log.senddatebefore <= '"
					+ ngayketthucthongke
					+ "')"
					+ " OR (log.senddatebefore is null AND cvdi.datecreated <= '"
					+ ngayketthucthongke + "'))";

			sql += " AND cvdi.confidentiallevelid = conf.confidentiallevelid";
			if (!doMat.equals("")) {
				sql += " AND conf.confidentiallevelid = '" + doMat + "'";
			}

			if (documentRecordTypeId != 0) { // Chon phan nhom
				sql += " AND cvdi.documenttypeid = t.documenttypeid";
				sql += " AND t.documentrecordtypeid = " + documentRecordTypeId;
			}
			if (0 != loaiVB) {
				sql += " AND cvdi.documenttypeid = dt.documenttypeid AND dt.documentrecordtypeid = drt.documentrecordtypeid AND drt.documentrecordtypeid = "
						+ loaiVB;
			}

			sql += " ORDER BY conf.confidentiallevelsymbol ASC, cvdi.datecreated DESC";

			sql = CustomSQLUtil.replaceOrderBy(sql, obc);

			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("PmlEdmDocumentSend", PmlEdmDocumentSendImpl.class);

			return (List<PmlEdmDocumentSend>) QueryUtil.list(q, getDialect(),
					start, end);
		} catch (Exception e) {
			throw processException(e);
		} finally {
			closeSession(session);
		}
	}

	/******************************************************************************************************************/
	/** PHONG BAN */
	/******************************************************************************************************************/

	/**
	 * phong ban ton dau ky cong van di so luong
	 */
	public int countTonDauKyPhongBan_CVDi(String departmentId,
			int documentRecordTypeId, int loaiVB, String doMat, Date fromDate,
			Date toDate) throws Exception {
		Session session = null;

		try {
			session = openSession();

			String ngaybatdauthongke = new SimpleDateFormat("yyyy-MM-dd")
					.format(fromDate);

			// Tao dieu kien loc theo phong ban de loai bo cau truy van con
			String depProcess = " departmentprocessid = '" + departmentId + "'";
			String depReceive = " departmentreceiveid = '" + departmentId + "'";
			if (departmentId.trim().length() > 0) {
				List<Department> deps = DepartmentUtil
						.findByDepartmentsParentId(departmentId);
				if (!deps.isEmpty()) {
					for (int idx = 0; idx < deps.size(); idx++) {
						Department depItem = deps.get(idx);
						depProcess += " OR departmentprocessid = '"
								+ depItem.getDepartmentsId() + "'";
						depReceive += " OR departmentreceiveid = '"
								+ depItem.getDepartmentsId() + "'";
					}
				}
			}
			depProcess = "(" + depProcess + ")";
			depReceive = "(" + depReceive + ")";

			String sql = "SELECT COUNT(DISTINCT(cvdi.documentsendid)) AS COUNT_VALUE";
			sql += " FROM pml_documentsend_log log";
			sql += " INNER JOIN (SELECT MAX(transition_) AS maxtran, documentsendid";
			sql += " FROM pml_documentsend_log";
			sql += " WHERE " + depProcess;
			sql += " GROUP BY documentsendid) AS a ON log.documentsendid = a.documentsendid AND a.maxtran = log.transition_";
			sql += " INNER JOIN pml_edm_documentsend cvdi ON cvdi.documentsendid = log.documentsendid";

			if (!doMat.equals("")) {
				sql += " AND cvdi.confidentiallevelid = '" + doMat + "'";
			}

			// Neu co chon phan nhom
			if (documentRecordTypeId != 0) {
				sql += " INNER JOIN pml_edm_documenttype t ON cvdi.documenttypeid = t.documenttypeid";
				sql += " AND t.documentrecordtypeid = " + documentRecordTypeId;
			}
			// Neu co chon loai van ban
			if (loaiVB != 0) {
				sql += " INNER JOIN pml_edm_documenttype dt ON cvdi.documenttypeid = dt.documenttypeid";
				sql += " INNER JOIN pml_edm_documentrecordtype drt ON dt.documentrecordtypeid = drt.documentrecordtypeid";
				sql += " AND drt.documentrecordtypeid = " + loaiVB;
			}

			sql += " LEFT OUTER JOIN (SELECT MAX(transition_) AS maxtran, documentsendid FROM pml_documentsend_log";
			sql += " WHERE " + depReceive;
			sql += " GROUP BY documentsendid) AS b ON log.documentsendid = b.documentsendid AND b.maxtran < log.transition_";
			sql += " LEFT OUTER JOIN pml_documentsend_log log2";
			sql += " ON log.documentsendid = log2.documentsendid AND b.maxtran = log2.transition_";

			sql += " WHERE (log.dateprocess IS null OR log.dateprocess >= '"
					+ ngaybatdauthongke + "')";
			sql += " AND ((log2.documentsendid IS NOT null and log2.receivedate IS NOT null";
			sql += " AND log2.receivedate < '" + ngaybatdauthongke + "')";
			sql += " OR (log.senddatebefore IS null AND cvdi.datecreated < '"
					+ ngaybatdauthongke + "'))";

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
			throw processException(e);
		} finally {
			closeSession(session);
		}
	}

	/**
	 * phong ban ton dau ky cong van di danh sach
	 */
	public List<PmlEdmDocumentSend> listTonDauKyPhongBan_CVDi(
			String departmentId, int documentRecordTypeId, int loaiVB,
			String doMat, Date fromDate, Date toDate, int start, int end,
			OrderByComparator obc) throws Exception {
		Session session = null;

		try {
			session = openSession();

			String ngaybatdauthongke = new SimpleDateFormat("yyyy-MM-dd")
					.format(fromDate);

			// Tao dieu kien loc theo phong ban de loai bo cau truy van con
			String depProcess = " departmentprocessid = '" + departmentId + "'";
			String depReceive = " departmentreceiveid = '" + departmentId + "'";
			if (departmentId.trim().length() > 0) {
				List<Department> deps = DepartmentUtil
						.findByDepartmentsParentId(departmentId);
				if (!deps.isEmpty()) {
					for (int idx = 0; idx < deps.size(); idx++) {
						Department depItem = deps.get(idx);
						depProcess += " OR departmentprocessid = '"
								+ depItem.getDepartmentsId() + "'";
						depReceive += " OR departmentreceiveid = '"
								+ depItem.getDepartmentsId() + "'";
					}
				}
			}
			depProcess = "(" + depProcess + ")";
			depReceive = "(" + depReceive + ")";

			String sql = "SELECT DISTINCT(cvdi.*), conf.confidentiallevelsymbol";
			sql += " FROM pml_documentsend_log log";
			sql += " INNER JOIN (SELECT MAX(transition_) AS maxtran, documentsendid";
			sql += " FROM pml_documentsend_log";
			sql += " WHERE " + depProcess;
			sql += " GROUP BY documentsendid) AS a ON log.documentsendid = a.documentsendid AND a.maxtran = log.transition_";
			sql += " INNER JOIN pml_edm_documentsend cvdi ON cvdi.documentsendid = log.documentsendid";
			sql += " INNER JOIN pml_edm_confidentiallevel conf ON cvdi.confidentiallevelid = conf.confidentiallevelid";
			if (!doMat.equals("")) {
				sql += " AND conf.confidentiallevelid = '" + doMat + "'";
			}
			// Neu co chon phan nhom
			if (documentRecordTypeId != 0) {
				sql += " INNER JOIN pml_edm_documenttype t ON cvdi.documenttypeid = t.documenttypeid";
				sql += " AND t.documentrecordtypeid = " + documentRecordTypeId;
			}
			// Neu co chon loai van ban
			if (loaiVB != 0) {
				sql += " INNER JOIN pml_edm_documenttype dt ON cvdi.documenttypeid = dt.documenttypeid";
				sql += " INNER JOIN pml_edm_documentrecordtype drt ON dt.documentrecordtypeid = drt.documentrecordtypeid";
				sql += " AND drt.documentrecordtypeid = " + loaiVB;
			}

			sql += " LEFT OUTER JOIN (SELECT MAX(transition_) AS maxtran, documentsendid FROM pml_documentsend_log";
			sql += " WHERE " + depReceive;
			sql += " GROUP BY documentsendid) AS b ON log.documentsendid = b.documentsendid AND b.maxtran < log.transition_";
			sql += " LEFT OUTER JOIN pml_documentsend_log log2";
			sql += " ON log.documentsendid = log2.documentsendid AND b.maxtran = log2.transition_";

			sql += " WHERE (log.dateprocess IS null OR log.dateprocess >= '"
					+ ngaybatdauthongke + "')";
			sql += " AND ((log2.documentsendid IS NOT null and log2.receivedate IS NOT null";
			sql += " AND log2.receivedate < '" + ngaybatdauthongke + "')";
			sql += " OR (log.senddatebefore IS null AND cvdi.datecreated < '"
					+ ngaybatdauthongke + "'))";

			sql += " ORDER BY conf.confidentiallevelsymbol ASC, cvdi.datecreated DESC";

			sql = CustomSQLUtil.replaceOrderBy(sql, obc);

			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("PmlEdmDocumentSend", PmlEdmDocumentSendImpl.class);

			return (List<PmlEdmDocumentSend>) QueryUtil.list(q, getDialect(),
					start, end);
		} catch (Exception e) {
			throw processException(e);
		} finally {
			closeSession(session);
		}
	}

	/**
	 * phong ban nhan trong ky cong van di so luong
	 */
	public int countNhanTrongKyPhongBan_CVDi(String departmentId,
			int documentRecordTypeId, int loaiVB, String doMat, Date fromDate,
			Date toDate) throws Exception {

		Session session = null;

		try {
			session = openSession();

			String ngaybatdauthongke = new SimpleDateFormat("yyyy-MM-dd")
					.format(fromDate);
			String ngayketthucthongke = new SimpleDateFormat("yyyy-MM-dd")
					.format(toDate);

			// Tao dieu kien loc theo phong ban de loai bo cau truy van con
			String depProcess = " departmentprocessid = '" + departmentId + "'";
			String depReceive = " departmentreceiveid = '" + departmentId + "'";
			if (departmentId.trim().length() > 0) {
				List<Department> deps = DepartmentUtil
						.findByDepartmentsParentId(departmentId);
				if (!deps.isEmpty()) {
					for (int idx = 0; idx < deps.size(); idx++) {
						Department depItem = deps.get(idx);
						depProcess += " OR departmentprocessid = '"
								+ depItem.getDepartmentsId() + "'";
						depReceive += " OR departmentreceiveid = '"
								+ depItem.getDepartmentsId() + "'";
					}
				}
			}
			depProcess = "(" + depProcess + ")";
			depReceive = "(" + depReceive + ")";

			String sql = "SELECT COUNT(DISTINCT(cvdi.documentsendid)) AS COUNT_VALUE";
			sql += " FROM pml_documentsend_log log";
			sql += " INNER JOIN (SELECT MAX(transition_) AS maxtran, documentsendid";
			sql += " FROM pml_documentsend_log";
			sql += " WHERE " + depProcess;
			sql += " GROUP BY documentsendid) AS a ON log.documentsendid = a.documentsendid AND a.maxtran = log.transition_";
			sql += " INNER JOIN pml_edm_documentsend cvdi ON cvdi.documentsendid = log.documentsendid";
			if (!doMat.equals("")) {
				sql += " AND cvdi.confidentiallevelid = '" + doMat + "'";
			}
			// Neu co chon phan nhom
			if (documentRecordTypeId != 0) {
				sql += " INNER JOIN pml_edm_documenttype t ON cvdi.documenttypeid = t.documenttypeid";
				sql += " AND t.documentrecordtypeid = " + documentRecordTypeId;
			}
			// Neu co chon loai van ban
			if (loaiVB != 0) {
				sql += " INNER JOIN pml_edm_documenttype dt ON cvdi.documenttypeid = dt.documenttypeid";
				sql += " INNER JOIN pml_edm_documentrecordtype drt ON dt.documentrecordtypeid = drt.documentrecordtypeid";
				sql += " AND drt.documentrecordtypeid = " + loaiVB;
			}

			sql += " LEFT OUTER JOIN (SELECT MAX(transition_) AS maxtran, documentsendid FROM pml_documentsend_log";
			sql += " WHERE " + depReceive;
			sql += " GROUP BY documentsendid) AS b ON log.documentsendid = b.documentsendid AND b.maxtran < log.transition_";

			sql += " LEFT OUTER JOIN pml_documentsend_log log2";
			sql += " ON log.documentsendid = log2.documentsendid AND b.maxtran = log2.transition_";
			sql += " WHERE (log.dateprocess IS null OR log.dateprocess >= '"
					+ ngaybatdauthongke + "')";
			sql += " AND ((log2.documentsendid IS NOT null and log2.receivedate IS NOT null";
			sql += " AND log2.receivedate BETWEEN '" + ngaybatdauthongke
					+ "' AND '" + ngayketthucthongke + "')";
			sql += " OR (log.senddatebefore IS null";
			sql += " AND cvdi.datecreated BETWEEN '" + ngaybatdauthongke
					+ "' AND '" + ngayketthucthongke + "'))";

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
			throw processException(e);
		} finally {
			closeSession(session);
		}
	}

	/**
	 * phong ban nhan trong ky cong van di danh sach
	 */
	public List<PmlEdmDocumentSend> listNhanTrongKyPhongBan_CVDi(
			String departmentId, int documentRecordTypeId, int loaiVB,
			String doMat, Date fromDate, Date toDate, int start, int end,
			OrderByComparator obc) throws Exception {
		Session session = null;

		try {
			session = openSession();

			// Chuyen doi dinh dang ngay
			String ngaybatdauthongke = new SimpleDateFormat("yyyy-MM-dd")
					.format(fromDate);
			String ngayketthucthongke = new SimpleDateFormat("yyyy-MM-dd")
					.format(toDate);

			// Tao dieu kien loc theo phong ban de loai bo cau truy van con
			String depProcess = " departmentprocessid = '" + departmentId + "'";
			String depReceive = " departmentreceiveid = '" + departmentId + "'";
			if (departmentId.trim().length() > 0) {
				List<Department> deps = DepartmentUtil
						.findByDepartmentsParentId(departmentId);
				if (!deps.isEmpty()) {
					for (int idx = 0; idx < deps.size(); idx++) {
						Department depItem = deps.get(idx);
						depProcess += " OR departmentprocessid = '"
								+ depItem.getDepartmentsId() + "'";
						depReceive += " OR departmentreceiveid = '"
								+ depItem.getDepartmentsId() + "'";
					}
				}
			}
			depProcess = "(" + depProcess + ")";
			depReceive = "(" + depReceive + ")";

			String sql = "SELECT DISTINCT(cvdi.*), conf.confidentiallevelsymbol";
			sql += " FROM pml_documentsend_log log";
			sql += " INNER JOIN (SELECT MAX(transition_) AS maxtran, documentsendid";
			sql += " FROM pml_documentsend_log";
			sql += " WHERE " + depProcess;
			sql += " GROUP BY documentsendid) AS a ON log.documentsendid = a.documentsendid AND a.maxtran = log.transition_";
			sql += " INNER JOIN pml_edm_documentsend cvdi ON cvdi.documentsendid = log.documentsendid";
			sql += " INNER JOIN pml_edm_confidentiallevel conf ON cvdi.confidentiallevelid = conf.confidentiallevelid";
			if (!doMat.equals("")) {
				sql += " AND conf.confidentiallevelid = '" + doMat + "'";
			}
			// Neu co chon phan nhom
			if (documentRecordTypeId != 0) {
				sql += " INNER JOIN pml_edm_documenttype t ON cvdi.documenttypeid = t.documenttypeid";
				sql += " AND t.documentrecordtypeid = " + documentRecordTypeId;
			}
			// Neu co chon loai van ban
			if (loaiVB != 0) {
				sql += " INNER JOIN pml_edm_documenttype dt ON cvdi.documenttypeid = dt.documenttypeid";
				sql += " INNER JOIN pml_edm_documentrecordtype drt ON dt.documentrecordtypeid = drt.documentrecordtypeid";
				sql += " AND drt.documentrecordtypeid = " + loaiVB;
			}

			sql += " LEFT OUTER JOIN (SELECT MAX(transition_) AS maxtran, documentsendid FROM pml_documentsend_log";
			sql += " WHERE " + depReceive;
			sql += " GROUP BY documentsendid) AS b ON log.documentsendid = b.documentsendid AND b.maxtran < log.transition_";

			sql += " LEFT OUTER JOIN pml_documentsend_log log2";
			sql += " ON log.documentsendid = log2.documentsendid AND b.maxtran = log2.transition_";
			sql += " WHERE (log.dateprocess IS null OR log.dateprocess >= '"
					+ ngaybatdauthongke + "')";
			sql += " AND ((log2.documentsendid IS NOT null and log2.receivedate IS NOT null";
			sql += " AND log2.receivedate BETWEEN '" + ngaybatdauthongke
					+ "' AND '" + ngayketthucthongke + "')";
			sql += " OR (log.senddatebefore IS null";
			sql += " AND cvdi.datecreated BETWEEN '" + ngaybatdauthongke
					+ "' AND '" + ngayketthucthongke + "'))";

			sql += " ORDER BY conf.confidentiallevelsymbol ASC, cvdi.datecreated DESC";

			sql = CustomSQLUtil.replaceOrderBy(sql, obc);

			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("PmlEdmDocumentSend", PmlEdmDocumentSendImpl.class);

			return (List<PmlEdmDocumentSend>) QueryUtil.list(q, getDialect(),
					start, end);
		} catch (Exception e) {
			throw processException(e);
		} finally {
			closeSession(session);
		}
	}

	/**
	 * phong ban chua nhan cong van di so luong
	 */
	public int countChuaNhanTrongKyPhongBan_CVDi(String departmentId,
			int documentRecordTypeId, int loaiVB, String doMat, Date fromDate,
			Date toDate) throws Exception {

		Session session = null;

		try {
			session = openSession();

			String ngayketthucthongke = new SimpleDateFormat("yyyy-MM-dd")
					.format(toDate);

			// Tao dieu kien loc theo phong ban de loai bo cau truy van con
			String depProcess = " departmentprocessid = '" + departmentId + "'";
			String depReceive = " departmentreceiveid = '" + departmentId + "'";
			if (departmentId.trim().length() > 0) {
				List<Department> deps = DepartmentUtil
						.findByDepartmentsParentId(departmentId);
				if (!deps.isEmpty()) {
					for (int idx = 0; idx < deps.size(); idx++) {
						Department depItem = deps.get(idx);
						depProcess += " OR departmentprocessid = '"
								+ depItem.getDepartmentsId() + "'";
						depReceive += " OR departmentreceiveid = '"
								+ depItem.getDepartmentsId() + "'";
					}
				}
			}
			depProcess = "(" + depProcess + ")";
			depReceive = "(" + depReceive + ")";

			String sql = "SELECT COUNT(DISTINCT(cvdi.documentsendid)) AS COUNT_VALUE";
			sql += " FROM pml_documentsend_log log";
			sql += " INNER JOIN (SELECT MAX(transition_) AS maxtran, documentsendid";
			sql += " FROM pml_documentsend_log";
			sql += " WHERE " + depProcess;
			sql += " GROUP BY documentsendid) AS a ON log.documentsendid = a.documentsendid AND a.maxtran = log.transition_";
			sql += " INNER JOIN pml_edm_documentsend cvdi ON cvdi.documentsendid = log.documentsendid";
			if (!doMat.equals("")) {
				sql += " AND cvdi.confidentiallevelid = '" + doMat + "'";
			}
			// Neu co chon phan nhom
			if (documentRecordTypeId != 0) {
				sql += " INNER JOIN pml_edm_documenttype t ON cvdi.documenttypeid = t.documenttypeid";
				sql += " AND t.documentrecordtypeid = " + documentRecordTypeId;
			}
			// Neu co chon loai van ban
			if (loaiVB != 0) {
				sql += " INNER JOIN pml_edm_documenttype dt ON cvdi.documenttypeid = dt.documenttypeid";
				sql += " INNER JOIN pml_edm_documentrecordtype drt ON dt.documentrecordtypeid = drt.documentrecordtypeid";
				sql += " AND drt.documentrecordtypeid = " + loaiVB;
			}

			sql += " LEFT OUTER JOIN (SELECT MAX(transition_) AS maxtran, documentsendid FROM pml_documentsend_log";
			sql += " WHERE " + depReceive;
			sql += " GROUP BY documentsendid) AS b ON log.documentsendid = b.documentsendid AND b.maxtran < log.transition_";

			sql += " LEFT OUTER JOIN pml_documentsend_log log2";
			sql += " ON log.documentsendid = log2.documentsendid AND b.maxtran = log2.transition_";
			sql += " WHERE (log.dateprocess IS null OR log.dateprocess > '"
					+ ngayketthucthongke + "')";
			sql += " AND log2.documentsendid IS NOT null AND (log2.receivedate IS null";
			sql += " OR log2.receivedate > '" + ngayketthucthongke + "')";
			sql += " AND log2.dateprocess <= '" + ngayketthucthongke
					+ "' AND cvdi.datecreated <= '" + ngayketthucthongke + "'";

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
			throw processException(e);
		} finally {
			closeSession(session);
		}
	}

	/**
	 * phong ban nhan trong ky cong van di danh sach
	 */
	public List<PmlEdmDocumentSend> listChuaNhanTrongKyPhongBan_CVDi(
			String departmentId, int documentRecordTypeId, int loaiVB,
			String doMat, Date fromDate, Date toDate, int start, int end,
			OrderByComparator obc) throws Exception {
		Session session = null;

		try {
			session = openSession();

			// Chuyen doi dinh dang ngay
			String ngayketthucthongke = new SimpleDateFormat("yyyy-MM-dd")
					.format(toDate);

			// Tao dieu kien loc theo phong ban de loai bo cau truy van con
			String depProcess = " departmentprocessid = '" + departmentId + "'";
			String depReceive = " departmentreceiveid = '" + departmentId + "'";
			if (departmentId.trim().length() > 0) {
				List<Department> deps = DepartmentUtil
						.findByDepartmentsParentId(departmentId);
				if (!deps.isEmpty()) {
					for (int idx = 0; idx < deps.size(); idx++) {
						Department depItem = deps.get(idx);
						depProcess += " OR departmentprocessid = '"
								+ depItem.getDepartmentsId() + "'";
						depReceive += " OR departmentreceiveid = '"
								+ depItem.getDepartmentsId() + "'";
					}
				}
			}
			depProcess = "(" + depProcess + ")";
			depReceive = "(" + depReceive + ")";

			String sql = "SELECT DISTINCT(cvdi.*), conf.confidentiallevelsymbol";
			sql += " FROM pml_documentsend_log log";
			sql += " INNER JOIN (SELECT MAX(transition_) AS maxtran, documentsendid";
			sql += " FROM pml_documentsend_log";
			sql += " WHERE " + depProcess;
			sql += " GROUP BY documentsendid) AS a ON log.documentsendid = a.documentsendid AND a.maxtran = log.transition_";
			sql += " INNER JOIN pml_edm_documentsend cvdi ON cvdi.documentsendid = log.documentsendid";
			sql += " INNER JOIN pml_edm_confidentiallevel conf ON cvdi.confidentiallevelid = conf.confidentiallevelid";
			if (!doMat.equals("")) {
				sql += " AND conf.confidentiallevelid = '" + doMat + "'";
			}
			// Neu co chon phan nhom
			if (documentRecordTypeId != 0) {
				sql += " INNER JOIN pml_edm_documenttype t ON cvdi.documenttypeid = t.documenttypeid";
				sql += " AND t.documentrecordtypeid = " + documentRecordTypeId;
			}
			// Neu co chon loai van ban
			if (loaiVB != 0) {
				sql += " INNER JOIN pml_edm_documenttype dt ON cvdi.documenttypeid = dt.documenttypeid";
				sql += " INNER JOIN pml_edm_documentrecordtype drt ON dt.documentrecordtypeid = drt.documentrecordtypeid";
				sql += " AND drt.documentrecordtypeid = " + loaiVB;
			}

			sql += " LEFT OUTER JOIN (SELECT MAX(transition_) AS maxtran, documentsendid FROM pml_documentsend_log";
			sql += " WHERE " + depReceive;
			sql += " GROUP BY documentsendid) AS b ON log.documentsendid = b.documentsendid AND b.maxtran < log.transition_";

			sql += " LEFT OUTER JOIN pml_documentsend_log log2";
			sql += " ON log.documentsendid = log2.documentsendid AND b.maxtran = log2.transition_";
			sql += " WHERE (log.dateprocess IS null OR log.dateprocess > '"
					+ ngayketthucthongke + "')";
			sql += " AND log2.documentsendid IS NOT null AND (log2.receivedate IS null";
			sql += " OR log2.receivedate > '" + ngayketthucthongke + "')";
			sql += " AND log2.dateprocess <= '" + ngayketthucthongke
					+ "' AND cvdi.datecreated <= '" + ngayketthucthongke + "'";

			sql += " ORDER BY conf.confidentiallevelsymbol ASC, cvdi.datecreated DESC";

			sql = CustomSQLUtil.replaceOrderBy(sql, obc);

			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("PmlEdmDocumentSend", PmlEdmDocumentSendImpl.class);

			return (List<PmlEdmDocumentSend>) QueryUtil.list(q, getDialect(),
					start, end);
		} catch (Exception e) {
			throw processException(e);
		} finally {
			closeSession(session);
		}
	}

	/**
	 * phong ban da giai quyet dung han cong van di so luong
	 */
	public int countDungHanDaXuLyPhongBan_CVDi(String departmentId,
			int documentRecordTypeId, int loaiVB, String doMat, Date fromDate,
			Date toDate) throws Exception {

		Session session = null;

		try {
			session = openSession();

			String ngaybatdauthongke = new SimpleDateFormat("yyyy-MM-dd")
					.format(fromDate);
			String ngayketthucthongke = new SimpleDateFormat("yyyy-MM-dd")
					.format(toDate);
			// Tao dieu kien loc theo phong ban de loai bo cau truy van con
			String depProcess = " departmentprocessid = '" + departmentId + "'";
			if (departmentId.trim().length() > 0) {
				List<Department> deps = DepartmentUtil
						.findByDepartmentsParentId(departmentId);
				if (!deps.isEmpty()) {
					for (int idx = 0; idx < deps.size(); idx++) {
						Department depItem = deps.get(idx);
						depProcess += " OR departmentprocessid = '"
								+ depItem.getDepartmentsId() + "'";
					}
				}
			}
			depProcess = "(" + depProcess + ")";

			String sql = "SELECT COUNT(DISTINCT(cvdi.documentsendid)) AS COUNT_VALUE";
			sql += " FROM pml_documentsend_log log";
			sql += " INNER JOIN (SELECT MAX(transition_) AS maxtran, documentsendid";
			sql += " FROM pml_documentsend_log";
			sql += " WHERE " + depProcess;
			sql += " GROUP BY documentsendid) AS a ON log.documentsendid = a.documentsendid AND log.transition_ = a.maxtran";
			sql += " AND log.dateprocess BETWEEN '" + ngaybatdauthongke
					+ "' AND '" + ngayketthucthongke + "'";
			sql += " INNER JOIN pml_edm_documentsend cvdi ON log.documentsendid = cvdi.documentsendid";
			if (!doMat.equals("")) {
				sql += " AND cvdi.confidentiallevelid = '" + doMat + "'";
			}
			// Neu co chon phan nhom
			if (documentRecordTypeId != 0) {
				sql += " INNER JOIN pml_edm_documenttype t ON cvdi.documenttypeid = t.documenttypeid";
				sql += " AND t.documentrecordtypeid = " + documentRecordTypeId;
			}
			// Neu co chon loai van ban
			if (loaiVB != 0) {
				sql += " INNER JOIN pml_edm_documenttype dt ON cvdi.documenttypeid = dt.documenttypeid";
				sql += " INNER JOIN pml_edm_documentrecordtype drt ON dt.documentrecordtypeid = drt.documentrecordtypeid";
				sql += " AND drt.documentrecordtypeid = " + loaiVB;
			}

			sql += " INNER JOIN pml_user u ON cvdi.editorid = u.userid";
			sql += " LEFT OUTER JOIN pml_edm_answerdetail rep ON cvdi.documentsendid = rep.documentsendid";
			sql += " LEFT OUTER JOIN pml_edm_documentreceipt cvden ON rep.documentreceiptid = cvden.documentreceiptid";
			sql += " WHERE (log.departmentprocessid <> u.departmentsid)";
			sql += " OR (rep.documentreceiptid IS NULL)";
			sql += " OR (rep.documentreceiptid IS NOT NULL AND cvden.processtime = 0)";
			sql += " OR (rep.documentreceiptid IS NOT NULL AND cvden.processtime > 0";
			sql += " AND (((cvdi.issuingdate IS NULL OR cvdi.issuingdate > '"
					+ ngayketthucthongke + "')";
			sql += " AND cvden.datearrive + cvden.processtime + songaynghile(cvden.datearrive, cvden.processtime) >= '"
					+ ngayketthucthongke + "')";
			sql += " OR (cvdi.issuingdate IS NOT NULL";
			sql += " AND cvden.datearrive + cvden.processtime + songaynghile(cvden.datearrive, cvden.processtime) >= cvdi.issuingdate)))";

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
			throw processException(e);
		} finally {
			closeSession(session);
		}
	}

	/**
	 * phong ban da giai quyet dung han cong van di danh sach
	 */
	public List<PmlEdmDocumentSend> listDungHanDaXuLyPhongBan_CVDi(
			String departmentId, int documentRecordTypeId, int loaiVB,
			String doMat, Date fromDate, Date toDate, int start, int end,
			OrderByComparator obc) throws Exception {

		Session session = null;

		try {
			session = openSession();

			String ngaybatdauthongke = new SimpleDateFormat("yyyy-MM-dd")
					.format(fromDate);
			String ngayketthucthongke = new SimpleDateFormat("yyyy-MM-dd")
					.format(toDate);
			// Tao dieu kien loc theo phong ban de loai bo cau truy van con
			String depProcess = " departmentprocessid = '" + departmentId + "'";
			if (departmentId.trim().length() > 0) {
				List<Department> deps = DepartmentUtil
						.findByDepartmentsParentId(departmentId);
				if (!deps.isEmpty()) {
					for (int idx = 0; idx < deps.size(); idx++) {
						Department depItem = deps.get(idx);
						depProcess += " OR departmentprocessid = '"
								+ depItem.getDepartmentsId() + "'";
					}
				}
			}
			depProcess = "(" + depProcess + ")";

			String sql = "SELECT DISTINCT(cvdi.*), conf.confidentiallevelsymbol";
			sql += " FROM pml_documentsend_log log";
			sql += " INNER JOIN (SELECT MAX(transition_) AS maxtran, documentsendid";
			sql += " FROM pml_documentsend_log";
			sql += " WHERE " + depProcess;
			sql += " GROUP BY documentsendid) AS a ON log.documentsendid = a.documentsendid AND log.transition_ = a.maxtran";
			sql += " AND log.dateprocess BETWEEN '" + ngaybatdauthongke
					+ "' AND '" + ngayketthucthongke + "'";
			sql += " INNER JOIN pml_edm_documentsend cvdi ON log.documentsendid = cvdi.documentsendid";
			sql += " INNER JOIN pml_edm_confidentiallevel conf ON cvdi.confidentiallevelid = conf.confidentiallevelid";
			if (!doMat.equals("")) {
				sql += " AND conf.confidentiallevelid = '" + doMat + "'";
			}
			// Neu co chon phan nhom
			if (documentRecordTypeId != 0) {
				sql += " INNER JOIN pml_edm_documenttype t ON cvdi.documenttypeid = t.documenttypeid";
				sql += " AND t.documentrecordtypeid = " + documentRecordTypeId;
			}
			// Neu co chon loai van ban
			if (loaiVB != 0) {
				sql += " INNER JOIN pml_edm_documenttype dt ON cvdi.documenttypeid = dt.documenttypeid";
				sql += " INNER JOIN pml_edm_documentrecordtype drt ON dt.documentrecordtypeid = drt.documentrecordtypeid";
				sql += " AND drt.documentrecordtypeid = " + loaiVB;
			}

			sql += " INNER JOIN pml_user u ON cvdi.editorid = u.userid";
			sql += " LEFT OUTER JOIN pml_edm_answerdetail rep ON cvdi.documentsendid = rep.documentsendid";
			sql += " LEFT OUTER JOIN pml_edm_documentreceipt cvden ON rep.documentreceiptid = cvden.documentreceiptid";
			sql += " WHERE (log.departmentprocessid <> u.departmentsid)";
			sql += " OR (rep.documentreceiptid IS NULL)";
			sql += " OR (rep.documentreceiptid IS NOT NULL AND cvden.processtime = 0)";
			sql += " OR (rep.documentreceiptid IS NOT NULL AND cvden.processtime > 0";
			sql += " AND (((cvdi.issuingdate IS NULL OR cvdi.issuingdate > '"
					+ ngayketthucthongke + "')";
			sql += " AND cvden.datearrive + cvden.processtime + songaynghile(cvden.datearrive, cvden.processtime) >= '"
					+ ngayketthucthongke + "')";
			sql += " OR (cvdi.issuingdate IS NOT NULL";
			sql += " AND cvden.datearrive + cvden.processtime + songaynghile(cvden.datearrive, cvden.processtime) >= cvdi.issuingdate)))";

			sql += " ORDER BY conf.confidentiallevelsymbol ASC, cvdi.datecreated DESC";

			sql = CustomSQLUtil.replaceOrderBy(sql, obc);

			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("PmlEdmDocumentSend", PmlEdmDocumentSendImpl.class);

			return (List<PmlEdmDocumentSend>) QueryUtil.list(q, getDialect(),
					start, end);
		} catch (Exception e) {
			throw processException(e);
		} finally {
			closeSession(session);
		}
	}

	/**
	 * phong ban da giai quyet tre han cong van di so luong
	 */
	public int countTreHanDaXuLyPhongBan_CVDi(String departmentId,
			int documentRecordTypeId, int loaiVB, String doMat, Date fromDate,
			Date toDate) throws Exception {

		Session session = null;

		try {
			session = openSession();

			String ngaybatdauthongke = new SimpleDateFormat("yyyy-MM-dd")
					.format(fromDate);
			String ngayketthucthongke = new SimpleDateFormat("yyyy-MM-dd")
					.format(toDate);
			// Tao dieu kien loc theo phong ban de loai bo cau truy van con
			String depProcess = " departmentprocessid = '" + departmentId + "'";
			if (departmentId.trim().length() > 0) {
				List<Department> deps = DepartmentUtil
						.findByDepartmentsParentId(departmentId);
				if (!deps.isEmpty()) {
					for (int idx = 0; idx < deps.size(); idx++) {
						Department depItem = deps.get(idx);
						depProcess += " OR departmentprocessid = '"
								+ depItem.getDepartmentsId() + "'";
					}
				}
			}
			depProcess = "(" + depProcess + ")";

			String sql = "SELECT COUNT(DISTINCT(cvdi.documentsendid)) AS COUNT_VALUE";
			sql += " FROM pml_documentsend_log log";
			sql += " INNER JOIN (SELECT MAX(transition_) AS maxtran, documentsendid";
			sql += " FROM pml_documentsend_log";
			sql += " WHERE " + depProcess;
			sql += " GROUP BY documentsendid) AS a ON log.documentsendid = a.documentsendid AND log.transition_ = a.maxtran";
			sql += " AND log.dateprocess BETWEEN '" + ngaybatdauthongke
					+ "' AND '" + ngayketthucthongke + "'";
			sql += " INNER JOIN pml_edm_documentsend cvdi ON log.documentsendid = cvdi.documentsendid";
			if (!doMat.equals("")) {
				sql += " AND cvdi.confidentiallevelid = '" + doMat + "'";
			}
			// Neu co chon phan nhom
			if (documentRecordTypeId != 0) {
				sql += " INNER JOIN pml_edm_documenttype t ON cvdi.documenttypeid = t.documenttypeid";
				sql += " AND t.documentrecordtypeid = " + documentRecordTypeId;
			}
			// Neu co chon loai van ban
			if (loaiVB != 0) {
				sql += " INNER JOIN pml_edm_documenttype dt ON cvdi.documenttypeid = dt.documenttypeid";
				sql += " INNER JOIN pml_edm_documentrecordtype drt ON dt.documentrecordtypeid = drt.documentrecordtypeid";
				sql += " AND drt.documentrecordtypeid = " + loaiVB;
			}

			sql += " INNER JOIN pml_user u ON cvdi.editorid = u.userid";
			sql += " LEFT OUTER JOIN pml_edm_answerdetail rep ON cvdi.documentsendid = rep.documentsendid";
			sql += " LEFT OUTER JOIN pml_edm_documentreceipt cvden ON rep.documentreceiptid = cvden.documentreceiptid";
			sql += " WHERE log.departmentprocessid = u.departmentsid AND rep.documentreceiptid IS NOT NULL AND cvden.processtime > 0";
			sql += " AND (((cvdi.issuingdate IS NULL OR cvdi.issuingdate > '"
					+ ngayketthucthongke + "')";
			sql += " AND cvden.datearrive + cvden.processtime + songaynghile(cvden.datearrive, cvden.processtime) < '"
					+ ngayketthucthongke + "')";
			sql += " OR (cvdi.issuingdate IS NOT NULL";
			sql += " AND cvden.datearrive + cvden.processtime + songaynghile(cvden.datearrive, cvden.processtime) < cvdi.issuingdate))";

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
			throw processException(e);
		} finally {
			closeSession(session);
		}
	}

	/**
	 * phong ban da giai quyet tre han cong van di danh sach
	 */
	public List<PmlEdmDocumentSend> listTreHanDaXuLyPhongBan_CVDi(
			String departmentId, int documentRecordTypeId, int loaiVB,
			String doMat, Date fromDate, Date toDate, int start, int end,
			OrderByComparator obc) throws Exception {
		Session session = null;

		try {
			session = openSession();

			String ngaybatdauthongke = new SimpleDateFormat("yyyy-MM-dd")
					.format(fromDate);
			String ngayketthucthongke = new SimpleDateFormat("yyyy-MM-dd")
					.format(toDate);
			// Tao dieu kien loc theo phong ban de loai bo cau truy van con
			String depProcess = " departmentprocessid = '" + departmentId + "'";
			if (departmentId.trim().length() > 0) {
				List<Department> deps = DepartmentUtil
						.findByDepartmentsParentId(departmentId);
				if (!deps.isEmpty()) {
					for (int idx = 0; idx < deps.size(); idx++) {
						Department depItem = deps.get(idx);
						depProcess += " OR departmentprocessid = '"
								+ depItem.getDepartmentsId() + "'";
					}
				}
			}
			depProcess = "(" + depProcess + ")";

			String sql = "SELECT DISTINCT(cvdi.*), conf.confidentiallevelsymbol";
			sql += " FROM pml_documentsend_log log";
			sql += " INNER JOIN (SELECT MAX(transition_) AS maxtran, documentsendid";
			sql += " FROM pml_documentsend_log";
			sql += " WHERE " + depProcess;
			sql += " GROUP BY documentsendid) AS a ON log.documentsendid = a.documentsendid AND log.transition_ = a.maxtran";
			sql += " AND log.dateprocess BETWEEN '" + ngaybatdauthongke
					+ "' AND '" + ngayketthucthongke + "'";
			sql += " INNER JOIN pml_edm_documentsend cvdi ON log.documentsendid = cvdi.documentsendid";
			sql += " INNER JOIN pml_edm_confidentiallevel conf ON cvdi.confidentiallevelid = conf.confidentiallevelid";
			if (!doMat.equals("")) {
				sql += " AND conf.confidentiallevelid = '" + doMat + "'";
			}
			// Neu co chon phan nhom
			if (documentRecordTypeId != 0) {
				sql += " INNER JOIN pml_edm_documenttype t ON cvdi.documenttypeid = t.documenttypeid";
				sql += " AND t.documentrecordtypeid = " + documentRecordTypeId;
			}
			// Neu co chon loai van ban
			if (loaiVB != 0) {
				sql += " INNER JOIN pml_edm_documenttype dt ON cvdi.documenttypeid = dt.documenttypeid";
				sql += " INNER JOIN pml_edm_documentrecordtype drt ON dt.documentrecordtypeid = drt.documentrecordtypeid";
				sql += " AND drt.documentrecordtypeid = " + loaiVB;
			}

			sql += " INNER JOIN pml_user u ON cvdi.editorid = u.userid";
			sql += " LEFT OUTER JOIN pml_edm_answerdetail rep ON cvdi.documentsendid = rep.documentsendid";
			sql += " LEFT OUTER JOIN pml_edm_documentreceipt cvden ON rep.documentreceiptid = cvden.documentreceiptid";
			sql += " WHERE log.departmentprocessid = u.departmentsid AND rep.documentreceiptid IS NOT NULL AND cvden.processtime > 0";
			sql += " AND (((cvdi.issuingdate IS NULL OR cvdi.issuingdate > '"
					+ ngayketthucthongke + "')";
			sql += " AND cvden.datearrive + cvden.processtime + songaynghile(cvden.datearrive, cvden.processtime) < '"
					+ ngayketthucthongke + "')";
			sql += " OR (cvdi.issuingdate IS NOT NULL";
			sql += " AND cvden.datearrive + cvden.processtime + songaynghile(cvden.datearrive, cvden.processtime) < cvdi.issuingdate))";

			sql += " ORDER BY conf.confidentiallevelsymbol ASC, cvdi.datecreated DESC";

			sql = CustomSQLUtil.replaceOrderBy(sql, obc);

			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("PmlEdmDocumentSend", PmlEdmDocumentSendImpl.class);

			return (List<PmlEdmDocumentSend>) QueryUtil.list(q, getDialect(),
					start, end);
		} catch (Exception e) {
			throw processException(e);
		} finally {
			closeSession(session);
		}
	}

	/**
	 * phong ban tong da giai quyet cong van di so luong
	 */
	public int countTongDaXuLyPhongBan_CVDi(String departmentId,
			int documentRecordTypeId, int loaiVB, String doMat, Date fromDate,
			Date toDate) throws Exception {

		Session session = null;

		try {
			session = openSession();

			String ngaybatdauthongke = new SimpleDateFormat("yyyy-MM-dd")
					.format(fromDate);
			String ngayketthucthongke = new SimpleDateFormat("yyyy-MM-dd")
					.format(toDate);
			// Tao dieu kien loc theo phong ban de loai bo cau truy van con
			String depProcess = " departmentprocessid = '" + departmentId + "'";
			if (departmentId.trim().length() > 0) {
				List<Department> deps = DepartmentUtil
						.findByDepartmentsParentId(departmentId);
				if (!deps.isEmpty()) {
					for (int idx = 0; idx < deps.size(); idx++) {
						Department depItem = deps.get(idx);
						depProcess += " OR departmentprocessid = '"
								+ depItem.getDepartmentsId() + "'";
					}
				}
			}
			depProcess = "(" + depProcess + ")";

			String sql = "SELECT COUNT(DISTINCT(cvdi.documentsendid)) AS COUNT_VALUE";
			sql += " FROM (SELECT MAX(log.transition_) AS maxtran, log.documentsendid";
			sql += " FROM pml_documentsend_log log";
			sql += " WHERE " + depProcess;
			sql += " GROUP BY log.documentsendid) AS a, pml_documentsend_log log, pml_edm_documentsend cvdi";

			if (documentRecordTypeId != 0) { // Chon phan nhom
				sql += ", pml_edm_documenttype t";
			}
			if (0 != loaiVB) {
				sql += ", pml_edm_documenttype dt, pml_edm_documentrecordtype drt";
			}

			sql += " WHERE cvdi.documentsendid = log.documentsendid";
			sql += " AND a.maxtran = log.transition_";
			sql += " AND a.documentsendid = log.documentsendid";

			sql += " AND (log.dateprocess is not null AND log.dateprocess between '"
					+ ngaybatdauthongke + "' AND '" + ngayketthucthongke + "')";

			if (!doMat.equals("")) {
				sql += " AND cvdi.confidentiallevelid = '" + doMat + "'";
			}

			if (documentRecordTypeId != 0) { // Chon phan nhom
				sql += " AND cvdi.documenttypeid = t.documenttypeid";
				sql += " AND t.documentrecordtypeid = " + documentRecordTypeId;
			}
			if (0 != loaiVB) {
				sql += " AND cvdi.documenttypeid = dt.documenttypeid AND dt.documentrecordtypeid = drt.documentrecordtypeid AND drt.documentrecordtypeid = "
						+ loaiVB;
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
			throw processException(e);
		} finally {
			closeSession(session);
		}
	}

	/**
	 * phong ban tong da giai quyet cong van di danh sach = da giai quyet dung
	 * han (cv di) + da giai quyet tre han (cv di)
	 */
	public List<PmlEdmDocumentSend> listTongDaXuLyPhongBan_CVDi(
			String departmentId, int documentRecordTypeId, int loaiVB,
			String doMat, Date fromDate, Date toDate, int start, int end,
			OrderByComparator obc) throws Exception {

		Session session = null;

		try {
			session = openSession();

			String ngaybatdauthongke = new SimpleDateFormat("yyyy-MM-dd")
					.format(fromDate);
			String ngayketthucthongke = new SimpleDateFormat("yyyy-MM-dd")
					.format(toDate);
			// Tao dieu kien loc theo phong ban de loai bo cau truy van con
			String depProcess = " departmentprocessid = '" + departmentId + "'";
			if (departmentId.trim().length() > 0) {
				List<Department> deps = DepartmentUtil
						.findByDepartmentsParentId(departmentId);
				if (!deps.isEmpty()) {
					for (int idx = 0; idx < deps.size(); idx++) {
						Department depItem = deps.get(idx);
						depProcess += " OR departmentprocessid = '"
								+ depItem.getDepartmentsId() + "'";
					}
				}
			}
			depProcess = "(" + depProcess + ")";

			String sql = "SELECT DISTINCT(cvdi.*), conf.confidentiallevelsymbol";
			sql += " FROM (SELECT MAX(log.transition_) AS maxtran, log.documentsendid";
			sql += " FROM pml_documentsend_log log";
			sql += " WHERE " + depProcess;
			sql += " GROUP BY log.documentsendid) AS a, pml_documentsend_log log, pml_edm_documentsend cvdi, pml_edm_confidentiallevel conf";

			if (documentRecordTypeId != 0) { // Chon phan nhom
				sql += ", pml_edm_documenttype t";
			}
			if (0 != loaiVB) {
				sql += ", pml_edm_documenttype dt, pml_edm_documentrecordtype drt";
			}

			sql += " WHERE cvdi.documentsendid = log.documentsendid";
			sql += " AND a.maxtran = log.transition_";
			sql += " AND a.documentsendid = log.documentsendid";

			sql += " AND (log.dateprocess is not null AND log.dateprocess between '"
					+ ngaybatdauthongke + "' AND '" + ngayketthucthongke + "')";

			sql += " AND cvdi.confidentiallevelid = conf.confidentiallevelid";
			if (!doMat.equals("")) {
				sql += " AND conf.confidentiallevelid = '" + doMat + "'";
			}

			if (documentRecordTypeId != 0) { // Chon phan nhom
				sql += " AND cvdi.documenttypeid = t.documenttypeid";
				sql += " AND t.documentrecordtypeid = " + documentRecordTypeId;
			}
			if (0 != loaiVB) {
				sql += " AND cvdi.documenttypeid = dt.documenttypeid AND dt.documentrecordtypeid = drt.documentrecordtypeid AND drt.documentrecordtypeid = "
						+ loaiVB;
			}

			sql += " ORDER BY cvdi.documentreference  ASC";

			// sql = CustomSQLUtil.replaceOrderBy(sql, obc);

			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("PmlEdmDocumentSend", PmlEdmDocumentSendImpl.class);

			return (List<PmlEdmDocumentSend>) QueryUtil.list(q, getDialect(),
					start, end);
		} catch (Exception e) {
			throw processException(e);
		} finally {
			closeSession(session);
		}
	}

	/**
	 * phong ban dang giai quyet dung han cong van di so luong
	 */
	public int countDungHanDangXuLyPhongBan_CVDi(String departmentId,
			int documentRecordTypeId, int loaiVB, String doMat, Date fromDate,
			Date toDate) throws Exception {
		Session session = null;

		try {
			session = openSession();

			String ngayketthucthongke = new SimpleDateFormat("yyyy-MM-dd")
					.format(toDate);
			// Tao dieu kien loc theo phong ban de loai bo cau truy van con
			String depProcess = " departmentprocessid = '" + departmentId + "'";
			if (departmentId.trim().length() > 0) {
				List<Department> deps = DepartmentUtil
						.findByDepartmentsParentId(departmentId);
				if (!deps.isEmpty()) {
					for (int idx = 0; idx < deps.size(); idx++) {
						Department depItem = deps.get(idx);
						depProcess += " OR departmentprocessid = '"
								+ depItem.getDepartmentsId() + "'";
					}
				}
			}
			depProcess = "(" + depProcess + ")";

			String sql = "SELECT COUNT(DISTINCT(cvdi.documentsendid)) AS COUNT_VALUE";
			sql += " FROM pml_documentsend_log log";
			sql += " INNER JOIN (SELECT MAX(transition_) AS maxtran, documentsendid";
			sql += " FROM pml_documentsend_log";
			sql += " WHERE " + depProcess;
			sql += " GROUP BY documentsendid) AS a ON log.documentsendid = a.documentsendid AND log.transition_ = a.maxtran";
			sql += " AND (log.dateprocess IS NULL OR log.dateprocess > '"
					+ ngayketthucthongke + "')";
			sql += " INNER JOIN pml_edm_documentsend cvdi ON log.documentsendid = cvdi.documentsendid";
			sql += " AND ((log.senddatebefore IS NOT NULL AND log.senddatebefore <= '"
					+ ngayketthucthongke + "')";
			sql += " OR (log.senddatebefore IS NULL AND cvdi.datecreated <= '"
					+ ngayketthucthongke + "'))";
			if (!doMat.equals("")) {
				sql += " AND cvdi.confidentiallevelid = '" + doMat + "'";
			}
			// Neu co chon phan nhom
			if (documentRecordTypeId != 0) {
				sql += " INNER JOIN pml_edm_documenttype t ON cvdi.documenttypeid = t.documenttypeid";
				sql += " AND t.documentrecordtypeid = " + documentRecordTypeId;
			}
			// Neu co chon loai van ban
			if (loaiVB != 0) {
				sql += " INNER JOIN pml_edm_documenttype dt ON cvdi.documenttypeid = dt.documenttypeid";
				sql += " INNER JOIN pml_edm_documentrecordtype drt ON dt.documentrecordtypeid = drt.documentrecordtypeid";
				sql += " AND drt.documentrecordtypeid = " + loaiVB;
			}

			sql += " INNER JOIN pml_user u ON cvdi.editorid = u.userid";
			sql += " LEFT OUTER JOIN pml_edm_answerdetail rep ON cvdi.documentsendid = rep.documentsendid";
			sql += " LEFT OUTER JOIN pml_edm_documentreceipt cvden ON rep.documentreceiptid = cvden.documentreceiptid";
			sql += " WHERE (log.departmentprocessid <> u.departmentsid)";
			sql += " OR (rep.documentreceiptid IS NULL)";
			sql += " OR (rep.documentreceiptid IS NOT NULL AND cvden.processtime = 0)";
			sql += " OR (rep.documentreceiptid IS NOT NULL AND cvden.processtime > 0";
			sql += " AND (((cvdi.issuingdate IS NULL OR cvdi.issuingdate > '"
					+ ngayketthucthongke + "')";
			sql += " AND cvden.datearrive + cvden.processtime + songaynghile(cvden.datearrive, cvden.processtime) >= '"
					+ ngayketthucthongke + "')";
			sql += " OR (cvdi.issuingdate IS NOT NULL";
			sql += " AND cvden.datearrive + cvden.processtime + songaynghile(cvden.datearrive, cvden.processtime) >= cvdi.issuingdate)))";

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
			throw processException(e);
		} finally {
			closeSession(session);
		}
	}

	/**
	 * phong ban dang giai quyet dung han cong van di danh sach
	 */
	public List<PmlEdmDocumentSend> listDungHanDangXuLyPhongBan_CVDi(
			String departmentId, int documentRecordTypeId, int loaiVB,
			String doMat, Date fromDate, Date toDate, int start, int end,
			OrderByComparator obc) throws Exception {
		Session session = null;

		try {
			session = openSession();

			String ngayketthucthongke = new SimpleDateFormat("yyyy-MM-dd")
					.format(toDate);
			// Tao dieu kien loc theo phong ban de loai bo cau truy van con
			String depProcess = " departmentprocessid = '" + departmentId + "'";
			if (departmentId.trim().length() > 0) {
				List<Department> deps = DepartmentUtil
						.findByDepartmentsParentId(departmentId);
				if (!deps.isEmpty()) {
					for (int idx = 0; idx < deps.size(); idx++) {
						Department depItem = deps.get(idx);
						depProcess += " OR departmentprocessid = '"
								+ depItem.getDepartmentsId() + "'";
					}
				}
			}
			depProcess = "(" + depProcess + ")";

			String sql = "SELECT DISTINCT(cvdi.*), conf.confidentiallevelsymbol";
			sql += " FROM pml_documentsend_log log";
			sql += " INNER JOIN (SELECT MAX(transition_) AS maxtran, documentsendid";
			sql += " FROM pml_documentsend_log";
			sql += " WHERE " + depProcess;
			sql += " GROUP BY documentsendid) AS a ON log.documentsendid = a.documentsendid AND log.transition_ = a.maxtran";
			sql += " AND (log.dateprocess IS NULL OR log.dateprocess > '"
					+ ngayketthucthongke + "')";
			sql += " INNER JOIN pml_edm_documentsend cvdi ON log.documentsendid = cvdi.documentsendid";
			sql += " AND ((log.senddatebefore IS NOT NULL AND log.senddatebefore <= '"
					+ ngayketthucthongke + "')";
			sql += " OR (log.senddatebefore IS NULL AND cvdi.datecreated <= '"
					+ ngayketthucthongke + "'))";

			sql += " INNER JOIN pml_edm_confidentiallevel conf ON cvdi.confidentiallevelid = conf.confidentiallevelid";
			if (!doMat.equals("")) {
				sql += " AND conf.confidentiallevelid = '" + doMat + "'";
			}

			// Neu co chon phan nhom
			if (documentRecordTypeId != 0) {
				sql += " INNER JOIN pml_edm_documenttype t ON cvdi.documenttypeid = t.documenttypeid";
				sql += " AND t.documentrecordtypeid = " + documentRecordTypeId;
			}
			// Neu co chon loai van ban
			if (loaiVB != 0) {
				sql += " INNER JOIN pml_edm_documenttype dt ON cvdi.documenttypeid = dt.documenttypeid";
				sql += " INNER JOIN pml_edm_documentrecordtype drt ON dt.documentrecordtypeid = drt.documentrecordtypeid";
				sql += " AND drt.documentrecordtypeid = " + loaiVB;
			}

			sql += " INNER JOIN pml_user u ON cvdi.editorid = u.userid";
			sql += " LEFT OUTER JOIN pml_edm_answerdetail rep ON cvdi.documentsendid = rep.documentsendid";
			sql += " LEFT OUTER JOIN pml_edm_documentreceipt cvden ON rep.documentreceiptid = cvden.documentreceiptid";
			sql += " WHERE (log.departmentprocessid <> u.departmentsid)";
			sql += " OR (rep.documentreceiptid IS NULL)";
			sql += " OR (rep.documentreceiptid IS NOT NULL AND cvden.processtime = 0)";
			sql += " OR (rep.documentreceiptid IS NOT NULL AND cvden.processtime > 0";
			sql += " AND (((cvdi.issuingdate IS NULL OR cvdi.issuingdate > '"
					+ ngayketthucthongke + "')";
			sql += " AND cvden.datearrive + cvden.processtime + songaynghile(cvden.datearrive, cvden.processtime) >= '"
					+ ngayketthucthongke + "')";
			sql += " OR (cvdi.issuingdate IS NOT NULL";
			sql += " AND cvden.datearrive + cvden.processtime + songaynghile(cvden.datearrive, cvden.processtime) >= cvdi.issuingdate)))";

			sql += " ORDER BY conf.confidentiallevelsymbol ASC, cvdi.datecreated DESC";

			sql = CustomSQLUtil.replaceOrderBy(sql, obc);

			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("PmlEdmDocumentSend", PmlEdmDocumentSendImpl.class);

			return (List<PmlEdmDocumentSend>) QueryUtil.list(q, getDialect(),
					start, end);
		} catch (Exception e) {
			throw processException(e);
		} finally {
			closeSession(session);
		}
	}

	/**
	 * phong ban dang giai quyet tre han cong van di so luong
	 */
	public int countTreHanDangXuLyPhongBan_CVDi(String departmentId,
			int documentRecordTypeId, int loaiVB, String doMat, Date fromDate,
			Date toDate) throws Exception {
		Session session = null;

		try {
			session = openSession();

			String ngayketthucthongke = new SimpleDateFormat("yyyy-MM-dd")
					.format(toDate);
			// Tao dieu kien loc theo phong ban de loai bo cau truy van con
			String depProcess = " departmentprocessid = '" + departmentId + "'";
			if (departmentId.trim().length() > 0) {
				List<Department> deps = DepartmentUtil
						.findByDepartmentsParentId(departmentId);
				if (!deps.isEmpty()) {
					for (int idx = 0; idx < deps.size(); idx++) {
						Department depItem = deps.get(idx);
						depProcess += " OR departmentprocessid = '"
								+ depItem.getDepartmentsId() + "'";
					}
				}
			}
			depProcess = "(" + depProcess + ")";

			String sql = "SELECT COUNT(DISTINCT(cvdi.documentsendid)) AS COUNT_VALUE";
			sql += " FROM pml_documentsend_log log";
			sql += " INNER JOIN (SELECT MAX(transition_) AS maxtran, documentsendid";
			sql += " FROM pml_documentsend_log";
			sql += " WHERE " + depProcess;
			sql += " GROUP BY documentsendid) AS a ON log.documentsendid = a.documentsendid AND log.transition_ = a.maxtran";
			sql += " AND (log.dateprocess IS NULL OR log.dateprocess > '"
					+ ngayketthucthongke + "')";
			sql += " INNER JOIN pml_edm_documentsend cvdi ON log.documentsendid = cvdi.documentsendid";
			sql += " AND ((log.senddatebefore IS NOT NULL AND log.senddatebefore <= '"
					+ ngayketthucthongke + "')";
			sql += " OR (log.senddatebefore IS NULL AND cvdi.datecreated <= '"
					+ ngayketthucthongke + "'))";
			if (!doMat.equals("")) {
				sql += " AND cvdi.confidentiallevelid = '" + doMat + "'";
			}
			// Neu co chon phan nhom
			if (documentRecordTypeId != 0) {
				sql += " INNER JOIN pml_edm_documenttype t ON cvdi.documenttypeid = t.documenttypeid";
				sql += " AND t.documentrecordtypeid = " + documentRecordTypeId;
			}
			// Neu co chon loai van ban
			if (loaiVB != 0) {
				sql += " INNER JOIN pml_edm_documenttype dt ON cvdi.documenttypeid = dt.documenttypeid";
				sql += " INNER JOIN pml_edm_documentrecordtype drt ON dt.documentrecordtypeid = drt.documentrecordtypeid";
				sql += " AND drt.documentrecordtypeid = " + loaiVB;
			}

			sql += " INNER JOIN pml_user u ON cvdi.editorid = u.userid";
			sql += " LEFT OUTER JOIN pml_edm_answerdetail rep ON cvdi.documentsendid = rep.documentsendid";
			sql += " LEFT OUTER JOIN pml_edm_documentreceipt cvden ON rep.documentreceiptid = cvden.documentreceiptid";
			sql += " WHERE log.departmentprocessid = u.departmentsid AND rep.documentreceiptid IS NOT NULL AND cvden.processtime > 0";
			sql += " AND (((cvdi.issuingdate IS NULL OR cvdi.issuingdate > '"
					+ ngayketthucthongke + "')";
			sql += " AND cvden.datearrive + cvden.processtime + songaynghile(cvden.datearrive, cvden.processtime) < '"
					+ ngayketthucthongke + "')";
			sql += " OR (cvdi.issuingdate IS NOT NULL";
			sql += " AND cvden.datearrive + cvden.processtime + songaynghile(cvden.datearrive, cvden.processtime) >= cvdi.issuingdate))";

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
			throw processException(e);
		} finally {
			closeSession(session);
		}
	}

	/**
	 * phong ban dang giai quyet tre han cong van di danh sach
	 */
	public List<PmlEdmDocumentSend> listTreHanDangXuLyPhongBan_CVDi(
			String departmentId, int documentRecordTypeId, int loaiVB,
			String doMat, Date fromDate, Date toDate, int start, int end,
			OrderByComparator obc) throws Exception {
		Session session = null;

		try {
			session = openSession();

			String ngayketthucthongke = new SimpleDateFormat("yyyy-MM-dd")
					.format(toDate);
			// Tao dieu kien loc theo phong ban de loai bo cau truy van con
			String depProcess = " departmentprocessid = '" + departmentId + "'";
			if (departmentId.trim().length() > 0) {
				List<Department> deps = DepartmentUtil
						.findByDepartmentsParentId(departmentId);
				if (!deps.isEmpty()) {
					for (int idx = 0; idx < deps.size(); idx++) {
						Department depItem = deps.get(idx);
						depProcess += " OR departmentprocessid = '"
								+ depItem.getDepartmentsId() + "'";
					}
				}
			}
			depProcess = "(" + depProcess + ")";

			String sql = "SELECT DISTINCT(cvdi.*), conf.confidentiallevelsymbol";
			sql += " FROM pml_documentsend_log log";
			sql += " INNER JOIN (SELECT MAX(transition_) AS maxtran, documentsendid";
			sql += " FROM pml_documentsend_log";
			sql += " WHERE " + depProcess;
			sql += " GROUP BY documentsendid) AS a ON log.documentsendid = a.documentsendid AND log.transition_ = a.maxtran";
			sql += " AND (log.dateprocess IS NULL OR log.dateprocess > '"
					+ ngayketthucthongke + "')";
			sql += " INNER JOIN pml_edm_documentsend cvdi ON log.documentsendid = cvdi.documentsendid";
			sql += " AND ((log.senddatebefore IS NOT NULL AND log.senddatebefore <= '"
					+ ngayketthucthongke + "')";
			sql += " OR (log.senddatebefore IS NULL AND cvdi.datecreated <= '"
					+ ngayketthucthongke + "'))";
			sql += " INNER JOIN pml_edm_confidentiallevel conf ON cvdi.confidentiallevelid = conf.confidentiallevelid";
			if (!doMat.equals("")) {
				sql += " AND conf.confidentiallevelid = '" + doMat + "'";
			}
			// Neu co chon phan nhom
			if (documentRecordTypeId != 0) {
				sql += " INNER JOIN pml_edm_documenttype t ON cvdi.documenttypeid = t.documenttypeid";
				sql += " AND t.documentrecordtypeid = " + documentRecordTypeId;
			}
			// Neu co chon loai van ban
			if (loaiVB != 0) {
				sql += " INNER JOIN pml_edm_documenttype dt ON cvdi.documenttypeid = dt.documenttypeid";
				sql += " INNER JOIN pml_edm_documentrecordtype drt ON dt.documentrecordtypeid = drt.documentrecordtypeid";
				sql += " AND drt.documentrecordtypeid = " + loaiVB;
			}

			sql += " INNER JOIN pml_user u ON cvdi.editorid = u.userid";
			sql += " LEFT OUTER JOIN pml_edm_answerdetail rep ON cvdi.documentsendid = rep.documentsendid";
			sql += " LEFT OUTER JOIN pml_edm_documentreceipt cvden ON rep.documentreceiptid = cvden.documentreceiptid";
			sql += " WHERE log.departmentprocessid = u.departmentsid AND rep.documentreceiptid IS NOT NULL AND cvden.processtime > 0";
			sql += " AND (((cvdi.issuingdate IS NULL OR cvdi.issuingdate > '"
					+ ngayketthucthongke + "')";
			sql += " AND cvden.datearrive + cvden.processtime + songaynghile(cvden.datearrive, cvden.processtime) < '"
					+ ngayketthucthongke + "')";
			sql += " OR (cvdi.issuingdate IS NOT NULL";
			sql += " AND cvden.datearrive + cvden.processtime + songaynghile(cvden.datearrive, cvden.processtime) < cvdi.issuingdate))";

			sql += " ORDER BY conf.confidentiallevelsymbol ASC, cvdi.datecreated DESC";

			sql = CustomSQLUtil.replaceOrderBy(sql, obc);

			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("PmlEdmDocumentSend", PmlEdmDocumentSendImpl.class);

			return (List<PmlEdmDocumentSend>) QueryUtil.list(q, getDialect(),
					start, end);
		} catch (Exception e) {
			throw processException(e);
		} finally {
			closeSession(session);
		}
	}

	/**
	 * phong ban tong dang giai quyet cong van di so luong
	 */
	public int countTongDangXuLyPhongBan_CVDi(String departmentId,
			int documentRecordTypeId, int loaiVB, String doMat, Date fromDate,
			Date toDate) throws Exception {
		Session session = null;

		try {
			session = openSession();

			String ngayketthucthongke = new SimpleDateFormat("yyyy-MM-dd")
					.format(toDate);
			// Tao dieu kien loc theo phong ban de loai bo cau truy van con
			String depProcess = " departmentprocessid = '" + departmentId + "'";
			if (departmentId.trim().length() > 0) {
				List<Department> deps = DepartmentUtil
						.findByDepartmentsParentId(departmentId);
				if (!deps.isEmpty()) {
					for (int idx = 0; idx < deps.size(); idx++) {
						Department depItem = deps.get(idx);
						depProcess += " OR departmentprocessid = '"
								+ depItem.getDepartmentsId() + "'";
					}
				}
			}
			depProcess = "(" + depProcess + ")";

			String sql = "SELECT COUNT(DISTINCT(cvdi.documentsendid)) AS COUNT_VALUE";
			sql += " FROM (SELECT MAX(log.transition_) AS maxtran, log.documentsendid";
			sql += " FROM pml_documentsend_log log";
			sql += " WHERE " + depProcess;
			sql += " GROUP BY log.documentsendid) AS a, pml_documentsend_log log, pml_edm_documentsend cvdi";
			if (documentRecordTypeId != 0) { // Chon phan nhom
				sql += ", pml_edm_documenttype t";
			}
			if (0 != loaiVB) {
				sql += ", pml_edm_documenttype dt, pml_edm_documentrecordtype drt";
			}

			sql += " WHERE cvdi.documentsendid = log.documentsendid";
			sql += " AND a.maxtran = log.transition_";
			sql += " AND a.documentsendid = log.documentsendid";
			if (!doMat.equals("")) {
				sql += " AND cvdi.confidentiallevelid = '" + doMat + "'";
			}

			sql += " AND (log.dateprocess is null or log.dateprocess > '"
					+ ngayketthucthongke + "')";
			sql += " AND ((log.senddatebefore is not null AND log.senddatebefore <= '"
					+ ngayketthucthongke
					+ "')"
					+ " OR (log.senddatebefore is null AND cvdi.datecreated <= '"
					+ ngayketthucthongke + "'))";

			if (documentRecordTypeId != 0) { // Chon phan nhom
				sql += " AND cvdi.documenttypeid = t.documenttypeid";
				sql += " AND t.documentrecordtypeid = " + documentRecordTypeId;
			}
			if (0 != loaiVB) {
				sql += " AND cvdi.documenttypeid = dt.documenttypeid AND dt.documentrecordtypeid = drt.documentrecordtypeid AND drt.documentrecordtypeid = "
						+ loaiVB;
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
			throw processException(e);
		} finally {
			closeSession(session);
		}
	}

	/**
	 * phong ban tong dang giai quyet cong van di danh sach (dung han + tre han)
	 */
	public List<PmlEdmDocumentSend> listTongDangXuLyPhongBan_CVDi(
			String departmentId, int documentRecordTypeId, int loaiVB,
			String doMat, Date fromDate, Date toDate, int start, int end,
			OrderByComparator obc) throws Exception {
		Session session = null;

		try {
			session = openSession();

			String ngayketthucthongke = new SimpleDateFormat("yyyy-MM-dd")
					.format(toDate);
			// Tao dieu kien loc theo phong ban de loai bo cau truy van con
			String depProcess = " departmentprocessid = '" + departmentId + "'";
			if (departmentId.trim().length() > 0) {
				List<Department> deps = DepartmentUtil
						.findByDepartmentsParentId(departmentId);
				if (!deps.isEmpty()) {
					for (int idx = 0; idx < deps.size(); idx++) {
						Department depItem = deps.get(idx);
						depProcess += " OR departmentprocessid = '"
								+ depItem.getDepartmentsId() + "'";
					}
				}
			}
			depProcess = "(" + depProcess + ")";

			String sql = "SELECT DISTINCT(cvdi.*), conf.confidentiallevelsymbol";
			sql += " FROM (SELECT MAX(log.transition_) AS maxtran, log.documentsendid";
			sql += " FROM pml_documentsend_log log";
			sql += " WHERE " + depProcess;
			sql += " GROUP BY log.documentsendid) AS a, pml_documentsend_log log, pml_edm_documentsend cvdi, pml_edm_confidentiallevel conf";

			if (documentRecordTypeId != 0) { // Chon phan nhom
				sql += ", pml_edm_documenttype t";
			}
			if (0 != loaiVB) {
				sql += ", pml_edm_documenttype dt, pml_edm_documentrecordtype drt";
			}

			sql += " WHERE cvdi.documentsendid = log.documentsendid";
			sql += " AND a.maxtran = log.transition_";
			sql += " AND a.documentsendid = log.documentsendid";

			sql += " AND (log.dateprocess is null or log.dateprocess > '"
					+ ngayketthucthongke + "')";
			sql += " AND ((log.senddatebefore is not null AND log.senddatebefore <= '"
					+ ngayketthucthongke
					+ "')"
					+ " OR (log.senddatebefore is null AND cvdi.datecreated <= '"
					+ ngayketthucthongke + "'))";

			sql += " AND cvdi.confidentiallevelid = conf.confidentiallevelid";
			if (!doMat.equals("")) {
				sql += " AND conf.confidentiallevelid = '" + doMat + "'";
			}

			if (documentRecordTypeId != 0) { // Chon phan nhom
				sql += " AND cvdi.documenttypeid = t.documenttypeid";
				sql += " AND t.documentrecordtypeid = " + documentRecordTypeId;
			}
			if (0 != loaiVB) {
				sql += " AND cvdi.documenttypeid = dt.documenttypeid AND dt.documentrecordtypeid = drt.documentrecordtypeid AND drt.documentrecordtypeid = "
						+ loaiVB;
			}

			sql += " ORDER BY conf.confidentiallevelsymbol ASC, cvdi.datecreated DESC";

			sql = CustomSQLUtil.replaceOrderBy(sql, obc);

			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("PmlEdmDocumentSend", PmlEdmDocumentSendImpl.class);

			return (List<PmlEdmDocumentSend>) QueryUtil.list(q, getDialect(),
					start, end);
		} catch (Exception e) {
			throw processException(e);
		} finally {
			closeSession(session);
		}
	}

	/******************************************************************************************************************/
	/** TOAN CO QUAN */
	/******************************************************************************************************************/

	/**
	 * toan co quan ton dau ky cong van di so luong
	 */
	public int countTonDauKySo_CVDi(int documentRecordTypeId, int loaiVB,
			String doMat, Date fromDate, Date toDate) throws Exception {
		Session session = null;

		try {
			session = openSession();

			// Chuyen doi dinh dang ngay
			String ngaybatdauthongke = new SimpleDateFormat("yyyy-MM-dd")
					.format(fromDate);

			String sql = "SELECT COUNT(DISTINCT(cvdi.documentsendid)) AS COUNT_VALUE";
			sql += " FROM (SELECT MAX(log.transition_) AS maxtran, log.documentsendid";
			sql += " FROM pml_documentsend_log log";
			sql += " GROUP BY log.documentsendid) AS a, pml_documentsend_log log, pml_edm_documentsend cvdi";

			if (documentRecordTypeId != 0) { // Chon phan nhom
				sql += ", pml_edm_documenttype t";
			}
			if (0 != loaiVB) {
				sql += ", pml_edm_documenttype dt, pml_edm_documentrecordtype drt";
			}

			sql += " WHERE cvdi.documentsendid = log.documentsendid";
			sql += " AND a.maxtran = log.transition_";
			sql += " AND a.documentsendid = log.documentsendid";
			if (!doMat.equals("")) {
				sql += " AND cvdi.confidentiallevelid = '" + doMat + "'";
			}
			sql += " AND (log.dateprocess is null OR log.dateprocess >= '"
					+ ngaybatdauthongke + "')";

			sql += " AND ((log.senddatebefore is not null AND log.senddatebefore < '"
					+ ngaybatdauthongke
					+ "')"
					+ " OR (log.senddatebefore is null AND cvdi.datecreated < '"
					+ ngaybatdauthongke + "'))";

			if (documentRecordTypeId != 0) { // Chon phan nhom
				sql += " AND cvdi.documenttypeid = t.documenttypeid";
				sql += " AND t.documentrecordtypeid = " + documentRecordTypeId;
			}
			if (0 != loaiVB) {
				sql += " AND cvdi.documenttypeid = dt.documenttypeid AND dt.documentrecordtypeid = drt.documentrecordtypeid AND drt.documentrecordtypeid = "
						+ loaiVB;
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
			throw processException(e);
		} finally {
			closeSession(session);
		}
	}

	/**
	 * toan co quan ton dau ky cong van di danh sach
	 */
	public List<PmlEdmDocumentSend> listTonDauKySo_CVDi(
			int documentRecordTypeId, int loaiVB, String doMat, Date fromDate,
			Date toDate, int start, int end, OrderByComparator obc)
			throws Exception {
		Session session = null;

		try {
			session = openSession();

			String ngaybatdauthongke = new SimpleDateFormat("yyyy-MM-dd")
					.format(fromDate);

			String sql = "SELECT DISTINCT(cvdi.*), conf.confidentiallevelsymbol";
			sql += " FROM (SELECT MAX(log.transition_) AS maxtran, log.documentsendid";
			sql += " FROM pml_documentsend_log log";
			sql += " GROUP BY log.documentsendid) AS a, pml_documentsend_log log, pml_edm_documentsend cvdi, pml_edm_confidentiallevel conf";

			if (documentRecordTypeId != 0) { // Chon phan nhom
				sql += ", pml_edm_documenttype t";
			}
			if (0 != loaiVB) {
				sql += ", pml_edm_documenttype dt, pml_edm_documentrecordtype drt";
			}

			sql += " WHERE cvdi.documentsendid = log.documentsendid";
			sql += " AND a.maxtran = log.transition_";
			sql += " AND a.documentsendid = log.documentsendid";

			sql += " AND (log.dateprocess is null OR log.dateprocess >= '"
					+ ngaybatdauthongke + "')";// dieu kien chung

			sql += " AND ((log.senddatebefore is not null AND log.senddatebefore < '"
					+ ngaybatdauthongke
					+ "')"
					+ " OR (log.senddatebefore is null AND cvdi.datecreated < '"
					+ ngaybatdauthongke + "'))";

			sql += " AND cvdi.confidentiallevelid = conf.confidentiallevelid";
			if (!doMat.equals("")) {
				sql += " AND conf.confidentiallevelid = '" + doMat + "'";
			}

			if (documentRecordTypeId != 0) { // Chon phan nhom
				sql += " AND cvdi.documenttypeid = t.documenttypeid";
				sql += " AND t.documentrecordtypeid = " + documentRecordTypeId;
			}
			if (0 != loaiVB) {
				sql += " AND cvdi.documenttypeid = dt.documenttypeid AND dt.documentrecordtypeid = drt.documentrecordtypeid AND drt.documentrecordtypeid = "
						+ loaiVB;
			}

			sql += " ORDER BY conf.confidentiallevelsymbol ASC, cvdi.datecreated DESC";

			sql = CustomSQLUtil.replaceOrderBy(sql, obc);

			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("PmlEdmDocumentSend", PmlEdmDocumentSendImpl.class);

			return (List<PmlEdmDocumentSend>) QueryUtil.list(q, getDialect(),
					start, end);
		} catch (Exception e) {
			throw processException(e);
		} finally {
			closeSession(session);
		}
	}

	/**
	 * toan co quan nhan trong ky cong van di so luong
	 */
	public int countNhanTrongKySo_CVDi(int documentRecordTypeId, int loaiVB,
			String doMat, Date fromDate, Date toDate) throws Exception {

		Session session = null;

		try {
			session = openSession();

			// Chuyen doi dinh dang ngay
			String ngaybatdauthongke = new SimpleDateFormat("yyyy-MM-dd")
					.format(fromDate);
			String ngayketthucthongke = new SimpleDateFormat("yyyy-MM-dd")
					.format(toDate);

			String sql = "SELECT COUNT(DISTINCT(cvdi.documentsendid)) AS COUNT_VALUE";
			sql += " FROM (SELECT MAX(log.transition_) AS maxtran, log.documentsendid";
			sql += " FROM pml_documentsend_log log";
			sql += " GROUP BY log.documentsendid) AS a, pml_documentsend_log log, pml_edm_documentsend cvdi";

			if (documentRecordTypeId != 0) { // Chon phan nhom
				sql += ", pml_edm_documenttype t";
			}
			if (0 != loaiVB) {
				sql += ", pml_edm_documenttype dt, pml_edm_documentrecordtype drt";
			}

			sql += " WHERE cvdi.documentsendid = log.documentsendid";
			sql += " AND a.maxtran = log.transition_";
			sql += " AND a.documentsendid = log.documentsendid";
			if (!doMat.equals("")) {
				sql += " AND cvdi.confidentiallevelid = '" + doMat + "'";
			}

			sql += " AND ((log.senddatebefore is not null AND log.senddatebefore between '"
					+ ngaybatdauthongke
					+ "' AND '"
					+ ngayketthucthongke
					+ "')"
					+ " OR (log.senddatebefore is null AND cvdi.datecreated between '"
					+ ngaybatdauthongke
					+ "' AND '"
					+ ngayketthucthongke
					+ "'))";

			if (documentRecordTypeId != 0) { // Chon phan nhom
				sql += " AND cvdi.documenttypeid = t.documenttypeid";
				sql += " AND t.documentrecordtypeid = " + documentRecordTypeId;
			}
			if (0 != loaiVB) {
				sql += " AND cvdi.documenttypeid = dt.documenttypeid AND dt.documentrecordtypeid = drt.documentrecordtypeid AND drt.documentrecordtypeid = "
						+ loaiVB;
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
			throw processException(e);
		} finally {
			closeSession(session);
		}
	}

	/**
	 * toan co quan nhan trong ky cong van di danh sach
	 */
	public List<PmlEdmDocumentSend> listNhanTrongKySo_CVDi(
			int documentRecordTypeId, int loaiVB, String doMat, Date fromDate,
			Date toDate, int start, int end, OrderByComparator obc)
			throws Exception {
		Session session = null;

		try {
			session = openSession();

			String ngaybatdauthongke = new SimpleDateFormat("yyyy-MM-dd")
					.format(fromDate);
			String ngayketthucthongke = new SimpleDateFormat("yyyy-MM-dd")
					.format(toDate);

			String sql = "SELECT DISTINCT(cvdi.*), conf.confidentiallevelsymbol";
			sql += " FROM (SELECT MAX(log.transition_) AS maxtran, log.documentsendid";
			sql += " FROM pml_documentsend_log log";
			sql += " GROUP BY log.documentsendid) AS a, pml_documentsend_log log, pml_edm_documentsend cvdi, pml_edm_confidentiallevel conf";

			if (documentRecordTypeId != 0) { // Chon phan nhom
				sql += ", pml_edm_documenttype t";
			}
			if (0 != loaiVB) {
				sql += ", pml_edm_documenttype dt, pml_edm_documentrecordtype drt";
			}

			sql += " WHERE cvdi.documentsendid = log.documentsendid";
			sql += " AND a.maxtran = log.transition_";
			sql += " AND a.documentsendid = log.documentsendid";

			sql += " AND ((log.senddatebefore is not null AND log.senddatebefore between '"
					+ ngaybatdauthongke
					+ "' AND '"
					+ ngayketthucthongke
					+ "')"
					+ " OR (log.senddatebefore is null AND cvdi.datecreated between '"
					+ ngaybatdauthongke
					+ "' AND '"
					+ ngayketthucthongke
					+ "'))";

			sql += " AND cvdi.confidentiallevelid = conf.confidentiallevelid";
			if (!doMat.equals("")) {
				sql += " AND conf.confidentiallevelid = '" + doMat + "'";
			}

			if (documentRecordTypeId != 0) { // Chon phan nhom
				sql += " AND cvdi.documenttypeid = t.documenttypeid";
				sql += " AND t.documentrecordtypeid = " + documentRecordTypeId;
			}
			if (0 != loaiVB) {
				sql += " AND cvdi.documenttypeid = dt.documenttypeid AND dt.documentrecordtypeid = drt.documentrecordtypeid AND drt.documentrecordtypeid = "
						+ loaiVB;
			}

			sql += " ORDER BY conf.confidentiallevelsymbol ASC, cvdi.datecreated DESC";

			sql = CustomSQLUtil.replaceOrderBy(sql, obc);

			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("PmlEdmDocumentSend", PmlEdmDocumentSendImpl.class);

			return (List<PmlEdmDocumentSend>) QueryUtil.list(q, getDialect(),
					start, end);
		} catch (Exception e) {
			throw processException(e);
		} finally {
			closeSession(session);
		}
	}

	/**
	 * toan co quan da giai quyet dung han cong van di so luong
	 */
	public int countDungHanDaXuLySo_CVDi(int documentRecordTypeId, int loaiVB,
			String doMat, Date fromDate, Date toDate) throws Exception {

		Session session = null;

		try {
			session = openSession();

			String ngaybatdauthongke = new SimpleDateFormat("yyyy-MM-dd")
					.format(fromDate);
			String ngayketthucthongke = new SimpleDateFormat("yyyy-MM-dd")
					.format(toDate);

			String sql = "SELECT COUNT(DISTINCT(cvdi.documentsendid)) AS COUNT_VALUE";
			sql += " FROM pml_documentsend_log log";
			sql += " INNER JOIN (SELECT MAX(transition_) AS maxtran, documentsendid";
			sql += " FROM pml_documentsend_log";
			sql += " GROUP BY documentsendid) AS a ON log.documentsendid = a.documentsendid AND log.transition_ = a.maxtran";
			sql += " AND log.dateprocess BETWEEN '" + ngaybatdauthongke
					+ "' AND '" + ngayketthucthongke + "'";
			sql += " INNER JOIN pml_edm_documentsend cvdi ON log.documentsendid = cvdi.documentsendid";
			if (!doMat.equals("")) {
				sql += " AND cvdi.confidentiallevelid = '" + doMat + "'";
			}
			// Neu co chon phan nhom
			if (documentRecordTypeId != 0) {
				sql += " INNER JOIN pml_edm_documenttype t ON cvdi.documenttypeid = t.documenttypeid";
				sql += " AND t.documentrecordtypeid = " + documentRecordTypeId;
			}
			// Neu co chon loai van ban
			if (loaiVB != 0) {
				sql += " INNER JOIN pml_edm_documenttype dt ON cvdi.documenttypeid = dt.documenttypeid";
				sql += " INNER JOIN pml_edm_documentrecordtype drt ON dt.documentrecordtypeid = drt.documentrecordtypeid";
				sql += " AND drt.documentrecordtypeid = " + loaiVB;
			}

			sql += " LEFT OUTER JOIN pml_edm_answerdetail rep ON cvdi.documentsendid = rep.documentsendid";
			sql += " LEFT OUTER JOIN pml_edm_documentreceipt cvden ON rep.documentreceiptid = cvden.documentreceiptid";
			sql += " WHERE (rep.documentreceiptid IS NULL)";
			sql += " OR (rep.documentreceiptid IS NOT NULL AND cvden.processtime = 0)";
			sql += " OR (rep.documentreceiptid IS NOT NULL AND cvden.processtime > 0";
			sql += " AND (((cvdi.issuingdate IS NULL OR cvdi.issuingdate > '"
					+ ngayketthucthongke + "')";
			sql += " AND cvden.datearrive + cvden.processtime + songaynghile(cvden.datearrive, cvden.processtime) >= '"
					+ ngayketthucthongke + "')";
			sql += " OR (cvdi.issuingdate IS NOT NULL";
			sql += " AND cvden.datearrive + cvden.processtime + songaynghile(cvden.datearrive, cvden.processtime) >= cvdi.issuingdate)))";

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
			throw processException(e);
		} finally {
			closeSession(session);
		}
	}

	/**
	 * toan co quan da giai quyet dung han cong van di danh sach
	 */
	public List<PmlEdmDocumentSend> listDungHanDaXuLySo_CVDi(
			int documentRecordTypeId, int loaiVB, String doMat, Date fromDate,
			Date toDate, int start, int end, OrderByComparator obc)
			throws Exception {

		Session session = null;

		try {
			session = openSession();

			String ngaybatdauthongke = new SimpleDateFormat("yyyy-MM-dd")
					.format(fromDate);
			String ngayketthucthongke = new SimpleDateFormat("yyyy-MM-dd")
					.format(toDate);

			String sql = "SELECT DISTINCT(cvdi.*), conf.confidentiallevelsymbol";
			sql += " FROM pml_documentsend_log log";
			sql += " INNER JOIN (SELECT MAX(transition_) AS maxtran, documentsendid";
			sql += " FROM pml_documentsend_log";
			sql += " GROUP BY documentsendid) AS a ON log.documentsendid = a.documentsendid AND log.transition_ = a.maxtran";
			sql += " AND log.dateprocess BETWEEN '" + ngaybatdauthongke
					+ "' AND '" + ngayketthucthongke + "'";
			sql += " INNER JOIN pml_edm_documentsend cvdi ON log.documentsendid = cvdi.documentsendid";

			sql += " INNER JOIN pml_edm_confidentiallevel conf ON cvdi.confidentiallevelid = conf.confidentiallevelid";
			if (!doMat.equals("")) {
				sql += " AND conf.confidentiallevelid = '" + doMat + "'";
			}

			// Neu co chon phan nhom
			if (documentRecordTypeId != 0) {
				sql += " INNER JOIN pml_edm_documenttype t ON cvdi.documenttypeid = t.documenttypeid";
				sql += " AND t.documentrecordtypeid = " + documentRecordTypeId;
			}
			// Neu co chon loai van ban
			if (loaiVB != 0) {
				sql += " INNER JOIN pml_edm_documenttype dt ON cvdi.documenttypeid = dt.documenttypeid";
				sql += " INNER JOIN pml_edm_documentrecordtype drt ON dt.documentrecordtypeid = drt.documentrecordtypeid";
				sql += " AND drt.documentrecordtypeid = " + loaiVB;
			}

			sql += " LEFT OUTER JOIN pml_edm_answerdetail rep ON cvdi.documentsendid = rep.documentsendid";
			sql += " LEFT OUTER JOIN pml_edm_documentreceipt cvden ON rep.documentreceiptid = cvden.documentreceiptid";
			sql += " WHERE (rep.documentreceiptid IS NULL)";
			sql += " OR (rep.documentreceiptid IS NOT NULL AND cvden.processtime = 0)";
			sql += " OR (rep.documentreceiptid IS NOT NULL AND cvden.processtime > 0";
			sql += " AND (((cvdi.issuingdate IS NULL OR cvdi.issuingdate > '"
					+ ngayketthucthongke + "')";
			sql += " AND cvden.datearrive + cvden.processtime + songaynghile(cvden.datearrive, cvden.processtime) >= '"
					+ ngayketthucthongke + "')";
			sql += " OR (cvdi.issuingdate IS NOT NULL";
			sql += " AND cvden.datearrive + cvden.processtime + songaynghile(cvden.datearrive, cvden.processtime) >= cvdi.issuingdate)))";

			sql += " ORDER BY conf.confidentiallevelsymbol ASC, cvdi.datecreated DESC";

			sql = CustomSQLUtil.replaceOrderBy(sql, obc);

			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("PmlEdmDocumentSend", PmlEdmDocumentSendImpl.class);

			return (List<PmlEdmDocumentSend>) QueryUtil.list(q, getDialect(),
					start, end);
		} catch (Exception e) {
			throw processException(e);
		} finally {
			closeSession(session);
		}
	}

	/**
	 * toan co quan da giai quyet tre han cong van di so luong
	 */
	public int countTreHanDaXuLySo_CVDi(int documentRecordTypeId, int loaiVB,
			String doMat, Date fromDate, Date toDate) throws Exception {

		Session session = null;

		try {
			session = openSession();

			String ngaybatdauthongke = new SimpleDateFormat("yyyy-MM-dd")
					.format(fromDate);
			String ngayketthucthongke = new SimpleDateFormat("yyyy-MM-dd")
					.format(toDate);

			String sql = "SELECT COUNT(DISTINCT(cvdi.documentsendid)) AS COUNT_VALUE";
			sql += " FROM pml_documentsend_log log";
			sql += " INNER JOIN (SELECT MAX(transition_) AS maxtran, documentsendid";
			sql += " FROM pml_documentsend_log";
			sql += " GROUP BY documentsendid) AS a ON log.documentsendid = a.documentsendid AND log.transition_ = a.maxtran";
			sql += " AND log.dateprocess BETWEEN '" + ngaybatdauthongke
					+ "' AND '" + ngayketthucthongke + "'";
			sql += " INNER JOIN pml_edm_documentsend cvdi ON log.documentsendid = cvdi.documentsendid";
			if (!doMat.equals("")) {
				sql += " AND cvdi.confidentiallevelid = '" + doMat + "'";
			}
			// Neu co chon phan nhom
			if (documentRecordTypeId != 0) {
				sql += " INNER JOIN pml_edm_documenttype t ON cvdi.documenttypeid = t.documenttypeid";
				sql += " AND t.documentrecordtypeid = " + documentRecordTypeId;
			}
			// Neu co chon loai van ban
			if (loaiVB != 0) {
				sql += " INNER JOIN pml_edm_documenttype dt ON cvdi.documenttypeid = dt.documenttypeid";
				sql += " INNER JOIN pml_edm_documentrecordtype drt ON dt.documentrecordtypeid = drt.documentrecordtypeid";
				sql += " AND drt.documentrecordtypeid = " + loaiVB;
			}

			sql += " LEFT OUTER JOIN pml_edm_answerdetail rep ON cvdi.documentsendid = rep.documentsendid";
			sql += " LEFT OUTER JOIN pml_edm_documentreceipt cvden ON rep.documentreceiptid = cvden.documentreceiptid";
			sql += " WHERE rep.documentreceiptid IS NOT NULL AND cvden.processtime > 0";
			sql += " AND (((cvdi.issuingdate IS NULL OR cvdi.issuingdate > '"
					+ ngayketthucthongke + "')";
			sql += " AND cvden.datearrive + cvden.processtime + songaynghile(cvden.datearrive, cvden.processtime) < '"
					+ ngayketthucthongke + "')";
			sql += " OR (cvdi.issuingdate IS NOT NULL";
			sql += " AND cvden.datearrive + cvden.processtime + songaynghile(cvden.datearrive, cvden.processtime) < cvdi.issuingdate))";

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
			throw processException(e);
		} finally {
			closeSession(session);
		}
	}

	/**
	 * toan co quan da giai quyet tre han cong van di danh sach
	 */
	public List<PmlEdmDocumentSend> listTreHanDaXuLySo_CVDi(
			int documentRecordTypeId, int loaiVB, String doMat, Date fromDate,
			Date toDate, int start, int end, OrderByComparator obc)
			throws Exception {
		Session session = null;

		try {
			session = openSession();

			String ngaybatdauthongke = new SimpleDateFormat("yyyy-MM-dd")
					.format(fromDate);
			String ngayketthucthongke = new SimpleDateFormat("yyyy-MM-dd")
					.format(toDate);

			String sql = "SELECT DISTINCT(cvdi.*), conf.confidentiallevelsymbol";
			sql += " FROM pml_documentsend_log log";
			sql += " INNER JOIN (SELECT MAX(transition_) AS maxtran, documentsendid";
			sql += " FROM pml_documentsend_log";
			sql += " GROUP BY documentsendid) AS a ON log.documentsendid = a.documentsendid AND log.transition_ = a.maxtran";
			sql += " AND log.dateprocess BETWEEN '" + ngaybatdauthongke
					+ "' AND '" + ngayketthucthongke + "'";
			sql += " INNER JOIN pml_edm_documentsend cvdi ON log.documentsendid = cvdi.documentsendid";

			sql += " INNER JOIN pml_edm_confidentiallevel conf ON cvdi.confidentiallevelid = conf.confidentiallevelid";
			if (!doMat.equals("")) {
				sql += " AND conf.confidentiallevelid = '" + doMat + "'";
			}

			// Neu co chon phan nhom
			if (documentRecordTypeId != 0) {
				sql += " INNER JOIN pml_edm_documenttype t ON cvdi.documenttypeid = t.documenttypeid";
				sql += " AND t.documentrecordtypeid = " + documentRecordTypeId;
			}
			// Neu co chon loai van ban
			if (loaiVB != 0) {
				sql += " INNER JOIN pml_edm_documenttype dt ON cvdi.documenttypeid = dt.documenttypeid";
				sql += " INNER JOIN pml_edm_documentrecordtype drt ON dt.documentrecordtypeid = drt.documentrecordtypeid";
				sql += " AND drt.documentrecordtypeid = " + loaiVB;
			}

			sql += " LEFT OUTER JOIN pml_edm_answerdetail rep ON cvdi.documentsendid = rep.documentsendid";
			sql += " LEFT OUTER JOIN pml_edm_documentreceipt cvden ON rep.documentreceiptid = cvden.documentreceiptid";
			sql += " WHERE rep.documentreceiptid IS NOT NULL AND cvden.processtime > 0";
			sql += " AND (((cvdi.issuingdate IS NULL OR cvdi.issuingdate > '"
					+ ngayketthucthongke + "')";
			sql += " AND cvden.datearrive + cvden.processtime + songaynghile(cvden.datearrive, cvden.processtime) < '"
					+ ngayketthucthongke + "')";
			sql += " OR (cvdi.issuingdate IS NOT NULL";
			sql += " AND cvden.datearrive + cvden.processtime + songaynghile(cvden.datearrive, cvden.processtime) < cvdi.issuingdate))";

			sql += " ORDER BY conf.confidentiallevelsymbol ASC, cvdi.datecreated DESC";

			sql = CustomSQLUtil.replaceOrderBy(sql, obc);

			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("PmlEdmDocumentSend", PmlEdmDocumentSendImpl.class);

			return (List<PmlEdmDocumentSend>) QueryUtil.list(q, getDialect(),
					start, end);
		} catch (Exception e) {
			throw processException(e);
		} finally {
			closeSession(session);
		}
	}

	/**
	 * toan co quan tong da giai quyet cong van di so luong
	 */
	public int countTongDaXuLySo_CVDi(int documentRecordTypeId, int loaiVB,
			String doMat, Date fromDate, Date toDate) throws Exception {

		Session session = null;

		try {
			session = openSession();

			String ngaybatdauthongke = new SimpleDateFormat("yyyy-MM-dd")
					.format(fromDate);
			String ngayketthucthongke = new SimpleDateFormat("yyyy-MM-dd")
					.format(toDate);

			String sql = "SELECT COUNT(DISTINCT(cvdi.documentsendid)) AS COUNT_VALUE";
			sql += " FROM (SELECT MAX(log.transition_) AS maxtran, log.documentsendid";
			sql += " FROM pml_documentsend_log log";
			sql += " GROUP BY log.documentsendid) AS a, pml_documentsend_log log, pml_edm_documentsend cvdi";

			if (documentRecordTypeId != 0) { // Chon phan nhom
				sql += ", pml_edm_documenttype t";
			}
			if (0 != loaiVB) {
				sql += ", pml_edm_documenttype dt, pml_edm_documentrecordtype drt";
			}

			sql += " WHERE cvdi.documentsendid = log.documentsendid";
			sql += " AND a.maxtran = log.transition_";
			sql += " AND a.documentsendid = log.documentsendid";

			sql += " AND (log.dateprocess is not null AND log.dateprocess between '"
					+ ngaybatdauthongke + "' AND '" + ngayketthucthongke + "')";

			if (!doMat.equals("")) {
				sql += " AND cvdi.confidentiallevelid = '" + doMat + "'";
			}
			if (documentRecordTypeId != 0) { // Chon phan nhom
				sql += " AND cvdi.documenttypeid = t.documenttypeid";
				sql += " AND t.documentrecordtypeid = " + documentRecordTypeId;
			}
			if (0 != loaiVB) {
				sql += " AND cvdi.documenttypeid = dt.documenttypeid AND dt.documentrecordtypeid = drt.documentrecordtypeid AND drt.documentrecordtypeid = "
						+ loaiVB;
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
			throw processException(e);
		} finally {
			closeSession(session);
		}
	}

	/**
	 * toan co quan tong da giai quyet cong van di danh sach = da giai quyet
	 * dung han (cv di) + da giai quyet tre han (cv di)
	 */
	public List<PmlEdmDocumentSend> listTongDaXuLySo_CVDi(
			int documentRecordTypeId, int loaiVB, String doMat, Date fromDate,
			Date toDate, int start, int end, OrderByComparator obc)
			throws Exception {

		Session session = null;

		try {
			session = openSession();

			String ngaybatdauthongke = new SimpleDateFormat("yyyy-MM-dd")
					.format(fromDate);
			String ngayketthucthongke = new SimpleDateFormat("yyyy-MM-dd")
					.format(toDate);

			String sql = "SELECT DISTINCT(cvdi.*), conf.confidentiallevelsymbol";
			sql += " FROM (SELECT MAX(log.transition_) AS maxtran, log.documentsendid";
			sql += " FROM pml_documentsend_log log";
			sql += " GROUP BY log.documentsendid) AS a, pml_documentsend_log log, pml_edm_documentsend cvdi, pml_edm_confidentiallevel conf";

			if (documentRecordTypeId != 0) { // Chon phan nhom
				sql += ", pml_edm_documenttype t";
			}
			if (0 != loaiVB) {
				sql += ", pml_edm_documenttype dt, pml_edm_documentrecordtype drt";
			}

			sql += " WHERE cvdi.documentsendid = log.documentsendid";
			sql += " AND a.maxtran = log.transition_";
			sql += " AND a.documentsendid = log.documentsendid";

			sql += " AND (log.dateprocess is not null AND log.dateprocess between '"
					+ ngaybatdauthongke + "' AND '" + ngayketthucthongke + "')";

			sql += " AND cvdi.confidentiallevelid = conf.confidentiallevelid";
			if (!doMat.equals("")) {
				sql += " AND conf.confidentiallevelid = '" + doMat + "'";
			}

			if (documentRecordTypeId != 0) { // Chon phan nhom
				sql += " AND cvdi.documenttypeid = t.documenttypeid";
				sql += " AND t.documentrecordtypeid = " + documentRecordTypeId;
			}
			if (0 != loaiVB) {
				sql += " AND cvdi.documenttypeid = dt.documenttypeid AND dt.documentrecordtypeid = drt.documentrecordtypeid AND drt.documentrecordtypeid = "
						+ loaiVB;
			}

			sql += " ORDER BY conf.confidentiallevelsymbol ASC, cvdi.datecreated DESC";

			sql = CustomSQLUtil.replaceOrderBy(sql, obc);

			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("PmlEdmDocumentSend", PmlEdmDocumentSendImpl.class);

			return (List<PmlEdmDocumentSend>) QueryUtil.list(q, getDialect(),
					start, end);
		} catch (Exception e) {
			throw processException(e);
		} finally {
			closeSession(session);
		}
	}

	/**
	 * toan co quan dang giai quyet dung han cong van di so luong
	 */
	public int countDungHanDangXuLySo_CVDi(int documentRecordTypeId,
			int loaiVB, String doMat, Date fromDate, Date toDate)
			throws Exception {
		Session session = null;

		try {
			session = openSession();

			String ngayketthucthongke = new SimpleDateFormat("yyyy-MM-dd")
					.format(toDate);

			String sql = "SELECT COUNT(DISTINCT(cvdi.documentsendid)) AS COUNT_VALUE";
			sql += " FROM pml_documentsend_log log";
			sql += " INNER JOIN (SELECT MAX(transition_) AS maxtran, documentsendid";
			sql += " FROM pml_documentsend_log";
			sql += " GROUP BY documentsendid) AS a ON log.documentsendid = a.documentsendid AND log.transition_ = a.maxtran";
			sql += " AND (log.dateprocess IS NULL OR log.dateprocess > '"
					+ ngayketthucthongke + "')";
			sql += " INNER JOIN pml_edm_documentsend cvdi ON log.documentsendid = cvdi.documentsendid";
			sql += " AND ((log.senddatebefore IS NOT NULL AND log.senddatebefore <= '"
					+ ngayketthucthongke + "')";
			sql += " OR (log.senddatebefore IS NULL AND cvdi.datecreated <= '"
					+ ngayketthucthongke + "'))";
			if (!doMat.equals("")) {
				sql += " AND cvdi.confidentiallevelid = '" + doMat + "'";
			}
			// Neu co chon phan nhom
			if (documentRecordTypeId != 0) {
				sql += " INNER JOIN pml_edm_documenttype t ON cvdi.documenttypeid = t.documenttypeid";
				sql += " AND t.documentrecordtypeid = " + documentRecordTypeId;
			}
			// Neu co chon loai van ban
			if (loaiVB != 0) {
				sql += " INNER JOIN pml_edm_documenttype dt ON cvdi.documenttypeid = dt.documenttypeid";
				sql += " INNER JOIN pml_edm_documentrecordtype drt ON dt.documentrecordtypeid = drt.documentrecordtypeid";
				sql += " AND drt.documentrecordtypeid = " + loaiVB;
			}

			sql += " LEFT OUTER JOIN pml_edm_answerdetail rep ON cvdi.documentsendid = rep.documentsendid";
			sql += " LEFT OUTER JOIN pml_edm_documentreceipt cvden ON rep.documentreceiptid = cvden.documentreceiptid";
			sql += " WHERE (rep.documentreceiptid IS NULL)";
			sql += " OR (rep.documentreceiptid IS NOT NULL AND cvden.processtime = 0)";
			sql += " OR (rep.documentreceiptid IS NOT NULL AND cvden.processtime > 0";
			sql += " AND (((cvdi.issuingdate IS NULL OR cvdi.issuingdate > '"
					+ ngayketthucthongke + "')";
			sql += " AND cvden.datearrive + cvden.processtime + songaynghile(cvden.datearrive, cvden.processtime) >= '"
					+ ngayketthucthongke + "')";
			sql += " OR (cvdi.issuingdate IS NOT NULL";
			sql += " AND cvden.datearrive + cvden.processtime + songaynghile(cvden.datearrive, cvden.processtime) >= cvdi.issuingdate)))";

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
			throw processException(e);
		} finally {
			closeSession(session);
		}
	}

	/**
	 * toan co quan dang giai quyet dung han cong van di danh sach
	 */
	public List<PmlEdmDocumentSend> listDungHanDangXuLySo_CVDi(
			int documentRecordTypeId, int loaiVB, String doMat, Date fromDate,
			Date toDate, int start, int end, OrderByComparator obc)
			throws Exception {
		Session session = null;

		try {
			session = openSession();

			String ngayketthucthongke = new SimpleDateFormat("yyyy-MM-dd")
					.format(toDate);

			String sql = "SELECT DISTINCT(cvdi.*), conf.confidentiallevelsymbol";
			sql += " FROM pml_documentsend_log log";
			sql += " INNER JOIN (SELECT MAX(transition_) AS maxtran, documentsendid";
			sql += " FROM pml_documentsend_log";
			sql += " GROUP BY documentsendid) AS a ON log.documentsendid = a.documentsendid AND log.transition_ = a.maxtran";
			sql += " AND (log.dateprocess IS NULL OR log.dateprocess > '"
					+ ngayketthucthongke + "')";
			sql += " INNER JOIN pml_edm_documentsend cvdi ON log.documentsendid = cvdi.documentsendid";
			sql += " AND ((log.senddatebefore IS NOT NULL AND log.senddatebefore <= '"
					+ ngayketthucthongke + "')";
			sql += " OR (log.senddatebefore IS NULL AND cvdi.datecreated <= '"
					+ ngayketthucthongke + "'))";
			sql += " INNER JOIN pml_edm_confidentiallevel conf ON cvdi.confidentiallevelid = conf.confidentiallevelid";
			if (!doMat.equals("")) {
				sql += " AND conf.confidentiallevelid = '" + doMat + "'";
			}
			// Neu co chon phan nhom
			if (documentRecordTypeId != 0) {
				sql += " INNER JOIN pml_edm_documenttype t ON cvdi.documenttypeid = t.documenttypeid";
				sql += " AND t.documentrecordtypeid = " + documentRecordTypeId;
			}
			// Neu co chon loai van ban
			if (loaiVB != 0) {
				sql += " INNER JOIN pml_edm_documenttype dt ON cvdi.documenttypeid = dt.documenttypeid";
				sql += " INNER JOIN pml_edm_documentrecordtype drt ON dt.documentrecordtypeid = drt.documentrecordtypeid";
				sql += " AND drt.documentrecordtypeid = " + loaiVB;
			}

			sql += " LEFT OUTER JOIN pml_edm_answerdetail rep ON cvdi.documentsendid = rep.documentsendid";
			sql += " LEFT OUTER JOIN pml_edm_documentreceipt cvden ON rep.documentreceiptid = cvden.documentreceiptid";
			sql += " WHERE (rep.documentreceiptid IS NULL)";
			sql += " OR (rep.documentreceiptid IS NOT NULL AND cvden.processtime = 0)";
			sql += " OR (rep.documentreceiptid IS NOT NULL AND cvden.processtime > 0";
			sql += " AND (((cvdi.issuingdate IS NULL OR cvdi.issuingdate > '"
					+ ngayketthucthongke + "')";
			sql += " AND cvden.datearrive + cvden.processtime + songaynghile(cvden.datearrive, cvden.processtime) >= '"
					+ ngayketthucthongke + "')";
			sql += " OR (cvdi.issuingdate IS NOT NULL";
			sql += " AND cvden.datearrive + cvden.processtime + songaynghile(cvden.datearrive, cvden.processtime) >= cvdi.issuingdate)))";

			sql += " ORDER BY conf.confidentiallevelsymbol ASC, cvdi.datecreated DESC";

			sql = CustomSQLUtil.replaceOrderBy(sql, obc);

			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("PmlEdmDocumentSend", PmlEdmDocumentSendImpl.class);

			return (List<PmlEdmDocumentSend>) QueryUtil.list(q, getDialect(),
					start, end);
		} catch (Exception e) {
			throw processException(e);
		} finally {
			closeSession(session);
		}
	}

	/**
	 * toan co quan dang giai quyet tre han cong van di so luong
	 */
	public int countTreHanDangXuLySo_CVDi(int documentRecordTypeId, int loaiVB,
			String doMat, Date fromDate, Date toDate) throws Exception {
		Session session = null;

		try {
			session = openSession();

			String ngayketthucthongke = new SimpleDateFormat("yyyy-MM-dd")
					.format(toDate);

			String sql = "SELECT COUNT(DISTINCT(cvdi.documentsendid)) AS COUNT_VALUE";
			sql += " FROM pml_documentsend_log log";
			sql += " INNER JOIN (SELECT MAX(transition_) AS maxtran, documentsendid";
			sql += " FROM pml_documentsend_log";
			sql += " GROUP BY documentsendid) AS a ON log.documentsendid = a.documentsendid AND log.transition_ = a.maxtran";
			sql += " AND (log.dateprocess IS NULL OR log.dateprocess > '"
					+ ngayketthucthongke + "')";
			sql += " INNER JOIN pml_edm_documentsend cvdi ON log.documentsendid = cvdi.documentsendid";
			sql += " AND ((log.senddatebefore IS NOT NULL AND log.senddatebefore <= '"
					+ ngayketthucthongke + "')";
			sql += " OR (log.senddatebefore IS NULL AND cvdi.datecreated <= '"
					+ ngayketthucthongke + "'))";
			if (!doMat.equals("")) {
				sql += " AND cvdi.confidentiallevelid = '" + doMat + "'";
			}
			// Neu co chon phan nhom
			if (documentRecordTypeId != 0) {
				sql += " INNER JOIN pml_edm_documenttype t ON cvdi.documenttypeid = t.documenttypeid";
				sql += " AND t.documentrecordtypeid = " + documentRecordTypeId;
			}
			// Neu co chon loai van ban
			if (loaiVB != 0) {
				sql += " INNER JOIN pml_edm_documenttype dt ON cvdi.documenttypeid = dt.documenttypeid";
				sql += " INNER JOIN pml_edm_documentrecordtype drt ON dt.documentrecordtypeid = drt.documentrecordtypeid";
				sql += " AND drt.documentrecordtypeid = " + loaiVB;
			}

			sql += " LEFT OUTER JOIN pml_edm_answerdetail rep ON cvdi.documentsendid = rep.documentsendid";
			sql += " LEFT OUTER JOIN pml_edm_documentreceipt cvden ON rep.documentreceiptid = cvden.documentreceiptid";
			sql += " WHERE rep.documentreceiptid IS NOT NULL AND cvden.processtime > 0";
			sql += " AND (((cvdi.issuingdate IS NULL OR cvdi.issuingdate > '"
					+ ngayketthucthongke + "')";
			sql += " AND cvden.datearrive + cvden.processtime + songaynghile(cvden.datearrive, cvden.processtime) < '"
					+ ngayketthucthongke + "')";
			sql += " OR (cvdi.issuingdate IS NOT NULL";
			sql += " AND cvden.datearrive + cvden.processtime + songaynghile(cvden.datearrive, cvden.processtime) < cvdi.issuingdate))";

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
			throw processException(e);
		} finally {
			closeSession(session);
		}
	}

	/**
	 * toan co quan dang giai quyet tre han cong van di danh sach
	 */
	public List<PmlEdmDocumentSend> listTreHanDangXuLySo_CVDi(
			int documentRecordTypeId, int loaiVB, String doMat, Date fromDate,
			Date toDate, int start, int end, OrderByComparator obc)
			throws Exception {
		Session session = null;

		try {
			session = openSession();

			String ngayketthucthongke = new SimpleDateFormat("yyyy-MM-dd")
					.format(toDate);

			String sql = "SELECT DISTINCT(cvdi.*), conf.confidentiallevelsymbol";
			sql += " FROM pml_documentsend_log log";
			sql += " INNER JOIN (SELECT MAX(transition_) AS maxtran, documentsendid";
			sql += " FROM pml_documentsend_log";
			sql += " GROUP BY documentsendid) AS a ON log.documentsendid = a.documentsendid AND log.transition_ = a.maxtran";
			sql += " AND (log.dateprocess IS NULL OR log.dateprocess > '"
					+ ngayketthucthongke + "')";
			sql += " INNER JOIN pml_edm_documentsend cvdi ON log.documentsendid = cvdi.documentsendid";
			sql += " AND ((log.senddatebefore IS NOT NULL AND log.senddatebefore <= '"
					+ ngayketthucthongke + "')";
			sql += " OR (log.senddatebefore IS NULL AND cvdi.datecreated <= '"
					+ ngayketthucthongke + "'))";
			sql += " INNER JOIN pml_edm_confidentiallevel conf ON cvdi.confidentiallevelid = conf.confidentiallevelid";
			if (!doMat.equals("")) {
				sql += " AND conf.confidentiallevelid = '" + doMat + "'";
			}
			// Neu co chon phan nhom
			if (documentRecordTypeId != 0) {
				sql += " INNER JOIN pml_edm_documenttype t ON cvdi.documenttypeid = t.documenttypeid";
				sql += " AND t.documentrecordtypeid = " + documentRecordTypeId;
			}
			// Neu co chon loai van ban
			if (loaiVB != 0) {
				sql += " INNER JOIN pml_edm_documenttype dt ON cvdi.documenttypeid = dt.documenttypeid";
				sql += " INNER JOIN pml_edm_documentrecordtype drt ON dt.documentrecordtypeid = drt.documentrecordtypeid";
				sql += " AND drt.documentrecordtypeid = " + loaiVB;
			}

			sql += " LEFT OUTER JOIN pml_edm_answerdetail rep ON cvdi.documentsendid = rep.documentsendid";
			sql += " LEFT OUTER JOIN pml_edm_documentreceipt cvden ON rep.documentreceiptid = cvden.documentreceiptid";
			sql += " WHERE rep.documentreceiptid IS NOT NULL AND cvden.processtime > 0";
			sql += " AND (((cvdi.issuingdate IS NULL OR cvdi.issuingdate > '"
					+ ngayketthucthongke + "')";
			sql += " AND cvden.datearrive + cvden.processtime + songaynghile(cvden.datearrive, cvden.processtime) < '"
					+ ngayketthucthongke + "')";
			sql += " OR (cvdi.issuingdate IS NOT NULL";
			sql += " AND cvden.datearrive + cvden.processtime + songaynghile(cvden.datearrive, cvden.processtime) < cvdi.issuingdate))";

			sql += " ORDER BY conf.confidentiallevelsymbol ASC, cvdi.datecreated DESC";

			sql = CustomSQLUtil.replaceOrderBy(sql, obc);

			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("PmlEdmDocumentSend", PmlEdmDocumentSendImpl.class);

			return (List<PmlEdmDocumentSend>) QueryUtil.list(q, getDialect(),
					start, end);
		} catch (Exception e) {
			throw processException(e);
		} finally {
			closeSession(session);
		}
	}

	/**
	 * toan co quan tong dang giai quyet cong van di so luong
	 */
	public int countTongDangXuLySo_CVDi(int documentRecordTypeId, int loaiVB,
			String doMat, Date fromDate, Date toDate) throws Exception {
		Session session = null;

		try {
			session = openSession();

			String ngayketthucthongke = new SimpleDateFormat("yyyy-MM-dd")
					.format(toDate);

			String sql = "SELECT COUNT(DISTINCT(cvdi.documentsendid)) AS COUNT_VALUE";
			sql += " FROM (SELECT MAX(log.transition_) AS maxtran, log.documentsendid";
			sql += " FROM pml_documentsend_log log";
			sql += " GROUP BY log.documentsendid) AS a, pml_documentsend_log log, pml_edm_documentsend cvdi";

			if (documentRecordTypeId != 0) { // Chon phan nhom
				sql += ", pml_edm_documenttype t";
			}
			if (0 != loaiVB) {
				sql += ", pml_edm_documenttype dt, pml_edm_documentrecordtype drt";
			}

			sql += " WHERE cvdi.documentsendid = log.documentsendid";
			sql += " AND a.maxtran = log.transition_";
			sql += " AND a.documentsendid = log.documentsendid";

			sql += " AND (log.dateprocess is null or log.dateprocess > '"
					+ ngayketthucthongke + "')";
			sql += " AND ((log.senddatebefore is not null AND log.senddatebefore <= '"
					+ ngayketthucthongke
					+ "')"
					+ " OR (log.senddatebefore is null AND cvdi.datecreated <= '"
					+ ngayketthucthongke + "'))";

			if (!doMat.equals("")) {
				sql += " AND cvdi.confidentiallevelid = '" + doMat + "'";
			}
			if (documentRecordTypeId != 0) { // Chon phan nhom
				sql += " AND cvdi.documenttypeid = t.documenttypeid";
				sql += " AND t.documentrecordtypeid = " + documentRecordTypeId;
			}
			if (0 != loaiVB) {
				sql += " AND cvdi.documenttypeid = dt.documenttypeid AND dt.documentrecordtypeid = drt.documentrecordtypeid AND drt.documentrecordtypeid = "
						+ loaiVB;
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
			throw processException(e);
		} finally {
			closeSession(session);
		}
	}

	/**
	 * toan co quan tong dang giai quyet cong van di danh sach (dung han + tre
	 * han)
	 */
	public List<PmlEdmDocumentSend> listTongDangXuLySo_CVDi(
			int documentRecordTypeId, int loaiVB, String doMat, Date fromDate,
			Date toDate, int start, int end, OrderByComparator obc)
			throws Exception {
		Session session = null;

		try {
			session = openSession();

			String ngayketthucthongke = new SimpleDateFormat("yyyy-MM-dd")
					.format(toDate);

			String sql = "SELECT DISTINCT(cvdi.*), conf.confidentiallevelsymbol";
			sql += " FROM (SELECT MAX(log.transition_) AS maxtran, log.documentsendid";
			sql += " FROM pml_documentsend_log log";
			sql += " GROUP BY log.documentsendid) AS a, pml_documentsend_log log, pml_edm_documentsend cvdi, pml_edm_confidentiallevel conf";

			if (documentRecordTypeId != 0) { // Chon phan nhom
				sql += ", pml_edm_documenttype t";
			}
			if (0 != loaiVB) {
				sql += ", pml_edm_documenttype dt, pml_edm_documentrecordtype drt";
			}

			sql += " WHERE cvdi.documentsendid = log.documentsendid";
			sql += " AND a.maxtran = log.transition_";
			sql += " AND a.documentsendid = log.documentsendid";

			sql += " AND (log.dateprocess is null or log.dateprocess > '"
					+ ngayketthucthongke + "')";
			sql += " AND ((log.senddatebefore is not null AND log.senddatebefore <= '"
					+ ngayketthucthongke
					+ "')"
					+ " OR (log.senddatebefore is null AND cvdi.datecreated <= '"
					+ ngayketthucthongke + "'))";

			sql += " AND cvdi.confidentiallevelid = conf.confidentiallevelid";
			if (!doMat.equals("")) {
				sql += " AND conf.confidentiallevelid = '" + doMat + "'";
			}

			if (documentRecordTypeId != 0) { // Chon phan nhom
				sql += " AND cvdi.documenttypeid = t.documenttypeid";
				sql += " AND t.documentrecordtypeid = " + documentRecordTypeId;
			}
			if (0 != loaiVB) {
				sql += " AND cvdi.documenttypeid = dt.documenttypeid AND dt.documentrecordtypeid = drt.documentrecordtypeid AND drt.documentrecordtypeid = "
						+ loaiVB;
			}

			sql += " ORDER BY conf.confidentiallevelsymbol ASC, cvdi.datecreated DESC";

			sql = CustomSQLUtil.replaceOrderBy(sql, obc);

			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("PmlEdmDocumentSend", PmlEdmDocumentSendImpl.class);

			return (List<PmlEdmDocumentSend>) QueryUtil.list(q, getDialect(),
					start, end);
		} catch (Exception e) {
			throw processException(e);
		} finally {
			closeSession(session);
		}
	}

	/**
	 * @author phmphuc 09/04/2010 portlet congvandidahoanthanh lay danh sach
	 *         cong van di da hoan thanh theo tung loai so cong van cho
	 *         ViewAction
	 */
	public List<PmlEdmDocumentSend> getListPmlEdmDocumentSend(
			int loaiSoCongVan, String fromDate, String toDate, int start,
			int end, OrderByComparator obc) throws Exception {

		try {
			fromDate = new SimpleDateFormat("yyyy-MM-dd")
					.format(new SimpleDateFormat("dd/MM/yyyy").parse(fromDate));
			toDate = new SimpleDateFormat("yyyy-MM-dd")
					.format(new SimpleDateFormat("dd/MM/yyyy").parse(toDate));
		} catch (ParseException e) {
			e.printStackTrace();
		}

		Session session = null;
		try {
			session = openSession();

			String sql = "SELECT DISTINCT(cvdi.*), conf.confidentiallevelsymbol";

			sql += " FROM pml_edm_documentsend cvdi";

			sql += " WHERE cvdi.documenttypeid IN";

			sql += " (SELECT DISTINCT(type.documenttypeid)";
			sql += " FROM pml_edm_documenttype type";
			sql += " WHERE type.documentrecordtypeid = " + loaiSoCongVan + ")";

			sql += " AND cvdi.issuingdate >= '" + fromDate + "'";
			sql += " AND cvdi.issuingdate <= '" + toDate + "'";

			sql += " ORDER BY cvdi.issuingdate";

			sql = CustomSQLUtil.replaceOrderBy(sql, obc);

			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("PmlEdmDocumentSend", PmlEdmDocumentSendImpl.class);

			return (List<PmlEdmDocumentSend>) QueryUtil.list(q, getDialect(),
					start, end);
		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}

	/**
	 * @author phmphuc 09/04/2010 portlet congvandidahoanthanh lay danh sach
	 *         cong van di da hoan thanh theo danh sach loai so cong van duoc
	 *         chon cho search
	 */
	public List<PmlEdmDocumentSend> getListPmlEdmDocumentSendByLoaiSoCV(
			String loaiSoCongVan, String fromDate, String toDate, int start,
			int end, OrderByComparator obc) throws Exception {

		try {
			fromDate = new SimpleDateFormat("yyyy-MM-dd")
					.format(new SimpleDateFormat("dd/MM/yyyy").parse(fromDate));
			toDate = new SimpleDateFormat("yyyy-MM-dd")
					.format(new SimpleDateFormat("dd/MM/yyyy").parse(toDate));
		} catch (ParseException e) {
			e.printStackTrace();
		}

		Session session = null;
		try {
			session = openSession();

			String sql = "SELECT DISTINCT(cvdi.*), conf.confidentiallevelsymbol";

			sql += " FROM pml_edm_documentsend cvdi";

			sql += " WHERE cvdi.documenttypeid IN";

			sql += " (SELECT DISTINCT(type.documenttypeid)";
			sql += " FROM pml_edm_documenttype type";
			sql += " WHERE type.documentrecordtypeid IN (" + loaiSoCongVan
					+ "))";

			sql += " AND cvdi.issuingdate >= '" + fromDate + "'";
			sql += " AND cvdi.issuingdate <= '" + toDate + "'";

			sql += " ORDER BY cvdi.issuingdate";

			sql = CustomSQLUtil.replaceOrderBy(sql, obc);

			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("PmlEdmDocumentSend", PmlEdmDocumentSendImpl.class);

			return (List<PmlEdmDocumentSend>) QueryUtil.list(q, getDialect(),
					start, end);
		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}

	public int countListPmlEdmDocumentSendByLoaiSoCV(String loaiSoCongVan,
			String fromDate, String toDate) throws SystemException {

		try {
			fromDate = new SimpleDateFormat("yyyy-MM-dd")
					.format(new SimpleDateFormat("dd/MM/yyyy").parse(fromDate));
			toDate = new SimpleDateFormat("yyyy-MM-dd")
					.format(new SimpleDateFormat("dd/MM/yyyy").parse(toDate));
		} catch (ParseException e) {
			e.printStackTrace();
		}

		Session session = null;
		try {
			session = openSession();

			String sql = "SELECT COUNT (DISTINCT(cvdi.documentsendid)) AS COUNT_VALUE";

			sql += " FROM pml_edm_documentsend cvdi";

			sql += " WHERE cvdi.documenttypeid IN";

			sql += " (SELECT DISTINCT(type.documenttypeid)";
			sql += " FROM pml_edm_documenttype type";
			sql += " WHERE type.documentrecordtypeid IN (" + loaiSoCongVan
					+ "))";

			sql += " AND cvdi.issuingdate >= '" + fromDate + "'";
			sql += " AND cvdi.issuingdate <= '" + toDate + "'";

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME, Type.LONG);

			Iterator<Long> iter = q.list().iterator();

			if (iter.hasNext()) {
				Long count = iter.next();
				if (count != null) {
					return count.intValue();
				}
			}
			return 0;
		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}

	/**
	 * yenlt 26/04/210 CONG VAN DI DA XU LY
	 * 
	 * @throws SystemException
	 */
	public List<PmlEdmDocumentSend> getListCVDiDaXuLyChung(long userId,
			String year, String loaisocongvan, int start, int end,
			OrderByComparator obc) throws SystemException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		String fromDate = "";
		String toDate = "";
		try {
			fromDate = sdf.format(df.parse("01/01/" + year));
			toDate = sdf.format(df.parse("31/12/" + year));
		} catch (ParseException e) {
		}

		Session session = null;

		try {
			session = openSession();

			String sql = " SELECT cvsend.*  ";
			sql += " FROM pml_edm_documentsend cvsend, (SELECT  DISTINCT (pml_documentsend_log.documentsendid), MAX  (pml_documentsend_log.transition_) AS tran  ";
			sql += " FROM pml_documentsend_log  ";
			sql += " WHERE ( pml_documentsend_log.processer = " + userId + ") ";
			sql += " GROUP BY pml_documentsend_log.documentsendid ";
			sql += ") AS pml_send_log, pml_documentsend_log ";
			sql += " WHERE ( pml_send_log.documentsendid = pml_documentsend_log.documentsendid ) ";
			sql += " AND ( pml_send_log.tran = pml_documentsend_log.transition_ ) ";
			sql += " AND ( cvsend.documentsendid = pml_documentsend_log.documentsendid ) ";
			sql += " AND ('" + fromDate
					+ "' <= pml_documentsend_log.dateprocess";
			sql += " AND pml_documentsend_log.dateprocess <= '" + toDate
					+ "' )";

			if (!"0".equals(loaisocongvan)) {
				sql = sql
						.replace(") AS pml_send_log, pml_documentsend_log ",
								") AS pml_send_log , pml_documentsend_log, pml_edm_documenttype dt ");
				sql += " AND ( cvsend.documenttypeid = dt.documenttypeid ) ";
				sql += " AND dt.documenttypeid = " + loaisocongvan;
			}
			
			sql = CustomSQLUtil.replaceOrderBy(sql, obc);

			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("pml_edm_documentreceipt", PmlEdmDocumentSendImpl.class);

			return (List<PmlEdmDocumentSend>) QueryUtil.list(q, getDialect(),
					start, end);
		} catch (Exception e) {
			throw processException(e);
		} finally {
			closeSession(session);
		}
	}

	/**
	 * count list cong van di da xu ly chung
	 * 
	 * @param userId
	 * @param year
	 * @param loaisocongvan
	 * @return
	 * @throws SystemException
	 */
	public int countListCVDiDaXuLyChung(long userId, String year,
			String loaisocongvan) throws SystemException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		String fromDate = "";
		String toDate = "";
		try {
			fromDate = sdf.format(df.parse("01/01/" + year));
			toDate = sdf.format(df.parse("31/12/" + year));
		} catch (ParseException e) {
		}

		Session session = null;

		try {
			session = openSession();

			String sql = "SELECT COUNT(*) AS COUNT_VALUE ";
			sql += " FROM pml_edm_documentsend cvsend, (SELECT  DISTINCT (pml_documentsend_log.documentsendid), MAX  (pml_documentsend_log.transition_) AS tran  ";
			sql += " FROM pml_documentsend_log  ";
			sql += " WHERE ( pml_documentsend_log.processer = " + userId + ") ";
			sql += " GROUP BY pml_documentsend_log.documentsendid ";
			sql += ") AS pml_send_log, pml_documentsend_log ";
			sql += " WHERE ( pml_send_log.documentsendid = pml_documentsend_log.documentsendid ) ";
			sql += " AND ( pml_send_log.tran = pml_documentsend_log.transition_ ) ";
			sql += " AND ( cvsend.documentsendid = pml_documentsend_log.documentsendid ) ";
			sql += " AND ('" + fromDate
					+ "' <= pml_documentsend_log.dateprocess";
			sql += " AND pml_documentsend_log.dateprocess <= '" + toDate
					+ "' )";

			if (!"0".equals(loaisocongvan)) {
				sql = sql
						.replace(") AS pml_send_log, pml_documentsend_log ",
								") AS pml_send_log , pml_documentsend_log, pml_edm_documenttype dt ");
				sql += " AND ( cvsend.documenttypeid = dt.documenttypeid ) ";
				sql += " AND dt.documenttypeid  = " + loaisocongvan;
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

	/**
	 * get list cv di da xu ly - tu xu ly
	 * 
	 * @param userId
	 * @param year
	 * @param loaisocongvan
	 * @param start
	 * @param end
	 * @return
	 * @throws SystemException
	 */
	public List<PmlEdmDocumentSend> getListCVDiDaXuLyTuXuLy(long userId,
			String year, String loaisocongvan, int start, int end,
			OrderByComparator obc) throws SystemException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		String fromDate = "";
		String toDate = "";
		try {
			fromDate = sdf.format(df.parse("01/01/" + year));
			toDate = sdf.format(df.parse("31/12/" + year));
		} catch (ParseException e) {
		}

		Session session = null;

		try {
			session = openSession();

			String sql = "SELECT cvsend.* ";
			sql += " FROM pml_edm_documentsend cvsend, (SELECT  DISTINCT (pml_documentsend_log.documentsendid), MAX  (pml_documentsend_log.transition_) AS tran  ";
			sql += " FROM pml_documentsend_log  ";
			sql += " WHERE ( pml_documentsend_log.processer = " + userId + ") ";
			sql += " GROUP BY pml_documentsend_log.documentsendid ";
			sql += ") AS pml_send_log, pml_documentsend_log ";
			sql += " WHERE ( pml_send_log.documentsendid = pml_documentsend_log.documentsendid ) ";
			sql += " AND ( pml_send_log.tran = pml_documentsend_log.transition_ ) ";
			sql += " AND ( pml_documentsend_log.processer = pml_documentsend_log.receiver ) ";
			sql += " AND ( cvsend.documentsendid = pml_documentsend_log.documentsendid ) ";
			sql += " AND ('" + fromDate
					+ "' <= pml_documentsend_log.dateprocess";
			sql += " AND pml_documentsend_log.dateprocess <= '" + toDate
					+ "' )";

			if (!"0".equals(loaisocongvan)) {
				sql = sql
						.replace(") AS pml_send_log, pml_documentsend_log ",
								") AS pml_send_log , pml_documentsend_log, pml_edm_documenttype dt ");
				sql += " AND ( cvsend.documenttypeid = dt.documenttypeid ) ";
				sql += " AND dt.documenttypeid = " + loaisocongvan;
			}

			sql = CustomSQLUtil.replaceOrderBy(sql, obc);

			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("pml_edm_documentsend", PmlEdmDocumentSendImpl.class);

			return (List<PmlEdmDocumentSend>) QueryUtil.list(q, getDialect(),
					start, end);
		} catch (Exception e) {
			throw processException(e);
		} finally {
			closeSession(session);
		}
	}

	/**
	 * count list cv di da xu ly, tu xu ly
	 * 
	 * @param userId
	 * @param year
	 * @param loaisocongvan
	 * @return
	 * @throws SystemException
	 */
	public int countListCVDiDaXuLyTuXuLy(long userId, String year,
			String loaisocongvan) throws SystemException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		String fromDate = "";
		String toDate = "";
		try {
			fromDate = sdf.format(df.parse("01/01/" + year));
			toDate = sdf.format(df.parse("31/12/" + year));
		} catch (ParseException e) {
		}

		Session session = null;

		try {
			session = openSession();

			String sql = "SELECT COUNT(*) AS COUNT_VALUE ";
			sql += " FROM pml_edm_documentsend cvsend, (SELECT  DISTINCT (pml_documentsend_log.documentsendid), MAX  (pml_documentsend_log.transition_) AS tran  ";
			sql += " FROM pml_documentsend_log  ";
			sql += " WHERE ( pml_documentsend_log.processer = " + userId + ") ";
			sql += " GROUP BY pml_documentsend_log.documentsendid ";
			sql += ") AS pml_send_log, pml_documentsend_log ";
			sql += " WHERE ( pml_send_log.documentsendid = pml_documentsend_log.documentsendid ) ";
			sql += " AND ( pml_send_log.tran = pml_documentsend_log.transition_ ) ";
			sql += " AND ( pml_documentsend_log.processer = pml_documentsend_log.receiver ) ";
			sql += " AND ( cvsend.documentsendid = pml_documentsend_log.documentsendid ) ";
			sql += " AND ('" + fromDate
					+ "' <= pml_documentsend_log.dateprocess";
			sql += " AND pml_documentsend_log.dateprocess <= '" + toDate
					+ "' )";

			if (!"0".equals(loaisocongvan)) {
				sql = sql
						.replace(") AS pml_send_log, pml_documentsend_log ",
								") AS pml_send_log , pml_documentsend_log, pml_edm_documenttype dt ");
				sql += " AND ( cvsend.documenttypeid = dt.documenttypeid ) ";
				sql += " AND dt.documenttypeid = " + loaisocongvan;
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

	/**
	 * cv di da xu ly chung - tre han
	 * 
	 * @param userId
	 * @param year
	 * @param loaisocongvan
	 * @param start
	 * @param end
	 * @param obc
	 * @return
	 * @throws SystemException
	 */
	public List<PmlEdmDocumentSend> getListCVDiDaXuLyChung_treHan(long userId,
			String year, String loaisocongvan, int start, int end,
			OrderByComparator obc) throws SystemException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		String fromDate = "";
		String toDate = "";
		try {
			fromDate = sdf.format(df.parse("01/01/" + year));
			toDate = sdf.format(df.parse("31/12/" + year));
		} catch (ParseException e) {
		}

		Session session = null;

		try {
			session = openSession();

			String sql = " SELECT cvsend.* ";
			sql += " FROM pml_edm_documentsend cvsend, ";
			sql += " (SELECT DISTINCT (logdi.documentsendid) ";
			sql += " FROM pml_documentsend_log logdi, ";
			sql += " ( SELECT logden.documentreceiptid AS  docid, MAX(logden.transition_) AS t_  ";
			sql += " FROM pml_documentsend_log logdi, pml_documentreceipt_log logden, pml_edm_answerdetail detail ";
			sql += " WHERE detail.documentsendid =  logdi.documentsendid ";
			sql += " AND detail.documentreceiptid = logden.documentreceiptid ";
			sql += " AND logdi.processer = " + userId;
			sql += " GROUP BY logden.documentreceiptid ";
			sql += " ) AS logden, pml_documentreceipt_log logres, pml_edm_answerdetail detail ";
			sql += " WHERE logres.documentreceiptid = logden.docid ";
			sql += " AND logres.transition_ = logden.t_  ";
			sql += " AND detail.documentsendid =  logdi.documentsendid ";
			sql += " AND detail.documentreceiptid = logden.docid ";
			sql += " AND logdi.processer = " + userId;
			sql += " AND ('" + fromDate
					+ "' <= logdi.dateprocess AND logdi.dateprocess <= '"
					+ toDate + "' )";
			sql += " AND (logres.senddatebefore IS NOT NULL )";
			sql += " AND (logres.senddatebefore + logres.numdateprocess + songaynghile(logres.senddatebefore, logres.numdateprocess)) < logdi.dateprocess ";
			sql += ") AS logdi ";
			sql += " WHERE ( cvsend.documentsendid = logdi.documentsendid ) ";

			if (!"0".equals(loaisocongvan)) {
				sql = sql.replace(") AS logdi ",
						") AS logdi , pml_edm_documenttype dt ");
				sql += " AND cvsend.documenttypeid = dt.documenttypeid ";
				sql += " AND dt.documenttypeid = " + loaisocongvan;
			}

			sql = CustomSQLUtil.replaceOrderBy(sql, obc);

			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("pml_edm_documentsend", PmlEdmDocumentSendImpl.class);

			return (List<PmlEdmDocumentSend>) QueryUtil.list(q, getDialect(),
					start, end);
		} catch (Exception e) {
			throw processException(e);
		} finally {
			closeSession(session);
		}
	}

	/*
	 * cv di da xu ly chung - tre han
	 */
	public int countListCVDiDaXuLyChung_treHan(long userId, String year,
			String loaisocongvan) throws SystemException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		String fromDate = "";
		String toDate = "";
		try {
			fromDate = sdf.format(df.parse("01/01/" + year));
			toDate = sdf.format(df.parse("31/12/" + year));
		} catch (ParseException e) {
		}

		Session session = null;

		try {
			session = openSession();

			String sql = "SELECT COUNT(*) AS COUNT_VALUE ";
			sql += " FROM pml_edm_documentsend cvsend, ";
			sql += " (SELECT DISTINCT (logdi.documentsendid) ";
			sql += " FROM pml_documentsend_log logdi, ";
			sql += " ( SELECT logden.documentreceiptid AS  docid, MAX(logden.transition_) AS t_  ";
			sql += " FROM pml_documentsend_log logdi, pml_documentreceipt_log logden, pml_edm_answerdetail detail ";
			sql += " WHERE detail.documentsendid =  logdi.documentsendid ";
			sql += " AND detail.documentreceiptid = logden.documentreceiptid ";
			sql += " AND logdi.processer = " + userId;
			sql += " GROUP BY logden.documentreceiptid ";
			sql += " ) AS logden, pml_documentreceipt_log logres, pml_edm_answerdetail detail ";
			sql += " WHERE logres.documentreceiptid = logden.docid ";
			sql += " AND logres.transition_ = logden.t_  ";
			sql += " AND detail.documentsendid =  logdi.documentsendid ";
			sql += " AND detail.documentreceiptid = logden.docid ";
			sql += " AND logdi.processer = " + userId;
			sql += " AND ('" + fromDate
					+ "' <= logdi.dateprocess AND logdi.dateprocess <= '"
					+ toDate + "' )";
			sql += " AND (logres.senddatebefore IS NOT NULL )";
			sql += " AND (logres.senddatebefore + logres.numdateprocess + songaynghile(logres.senddatebefore, logres.numdateprocess)) < logdi.dateprocess ";
			sql += ") AS logdi ";
			sql += " WHERE ( cvsend.documentsendid = logdi.documentsendid ) ";

			if (!"0".equals(loaisocongvan)) {
				sql = sql.replace(") AS logdi ",
						") AS logdi , pml_edm_documenttype dt ");
				sql += " AND cvsend.documenttypeid = dt.documenttypeid ";
				sql += " AND dt.documenttypeid = " + loaisocongvan;
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

	/*
	 * cv di da xu ly - tu xu ly - tre han
	 */
	public List<PmlEdmDocumentSend> getListCVDiDaXuLyTuXuLy_treHan(long userId,
			String year, String loaisocongvan, int start, int end,
			OrderByComparator obc) throws SystemException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		String fromDate = "";
		String toDate = "";
		try {
			fromDate = sdf.format(df.parse("01/01/" + year));
			toDate = sdf.format(df.parse("31/12/" + year));
		} catch (ParseException e) {
		}

		Session session = null;

		try {
			session = openSession();

			String sql = "SELECT cvsend.* ";
			sql += " FROM pml_edm_documentsend cvsend, ";
			sql += " (SELECT DISTINCT (logdi.documentsendid) ";
			sql += " FROM pml_documentsend_log logdi, ";
			sql += " ( SELECT logden.documentreceiptid AS  docid, MAX(logden.transition_) AS t_  ";
			sql += " FROM pml_documentsend_log logdi, pml_documentreceipt_log logden, pml_edm_answerdetail detail ";
			sql += " WHERE detail.documentsendid =  logdi.documentsendid ";
			sql += " AND detail.documentreceiptid = logden.documentreceiptid ";
			sql += " AND logdi.processer = " + userId;
			sql += " GROUP BY logden.documentreceiptid ";
			sql += " ) AS logden, pml_documentreceipt_log logres, pml_edm_answerdetail detail ";
			sql += " WHERE logres.documentreceiptid = logden.docid ";
			sql += " AND logres.transition_ = logden.t_  ";
			sql += " AND detail.documentsendid =  logdi.documentsendid ";
			sql += " AND detail.documentreceiptid = logden.docid ";
			sql += " AND logdi.processer = " + userId;
			sql += " AND logdi.processer = logdi.receiver ";
			sql += " AND ('" + fromDate
					+ "' <= logdi.dateprocess AND logdi.dateprocess <= '"
					+ toDate + "' )";
			sql += " AND (logres.senddatebefore IS NOT NULL )";
			sql += " AND (logres.senddatebefore + logres.numdateprocess + songaynghile(logres.senddatebefore, logres.numdateprocess)) < logdi.dateprocess ";
			sql += ") AS logdi ";
			sql += " WHERE ( cvsend.documentsendid = logdi.documentsendid ) ";

			if (!"0".equals(loaisocongvan)) {
				sql = sql.replace(") AS logdi ",
						") AS logdi , pml_edm_documenttype dt ");
				sql += " AND cvsend.documenttypeid = dt.documenttypeid ";
				sql += " AND dt.documenttypeid = " + loaisocongvan;
			}

			sql = CustomSQLUtil.replaceOrderBy(sql, obc);

			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("pml_edm_documentsend", PmlEdmDocumentSendImpl.class);

			return (List<PmlEdmDocumentSend>) QueryUtil.list(q, getDialect(),
					start, end);
		} catch (Exception e) {
			throw processException(e);
		} finally {
			closeSession(session);
		}
	}

	/*
	 * count cv di da xu ly - tu xu ly - tre han
	 */
	public int countListCVDiDaXuLyTuXuLy_treHan(long userId, String year,
			String loaisocongvan) throws SystemException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		String fromDate = "";
		String toDate = "";
		try {
			fromDate = sdf.format(df.parse("01/01/" + year));
			toDate = sdf.format(df.parse("31/12/" + year));
		} catch (ParseException e) {
		}

		Session session = null;

		try {
			session = openSession();

			String sql = "SELECT COUNT(*) AS COUNT_VALUE ";
			sql += " FROM pml_edm_documentsend cvsend, ";
			sql += " (SELECT DISTINCT (logdi.documentsendid) ";
			sql += " FROM pml_documentsend_log logdi, ";
			sql += " ( SELECT logden.documentreceiptid AS  docid, MAX(logden.transition_) AS t_  ";
			sql += " FROM pml_documentsend_log logdi, pml_documentreceipt_log logden, pml_edm_answerdetail detail ";
			sql += " WHERE detail.documentsendid =  logdi.documentsendid ";
			sql += " AND detail.documentreceiptid = logden.documentreceiptid ";
			sql += " AND logdi.processer = " + userId;
			sql += " GROUP BY logden.documentreceiptid ";
			sql += " ) AS logden, pml_documentreceipt_log logres, pml_edm_answerdetail detail ";
			sql += " WHERE logres.documentreceiptid = logden.docid ";
			sql += " AND logres.transition_ = logden.t_  ";
			sql += " AND detail.documentsendid =  logdi.documentsendid ";
			sql += " AND detail.documentreceiptid = logden.docid ";
			sql += " AND logdi.processer = " + userId;
			sql += " AND logdi.processer = logdi.receiver ";
			sql += " AND ('" + fromDate
					+ "' <= logdi.dateprocess AND logdi.dateprocess <= '"
					+ toDate + "' )";
			sql += " AND (logres.senddatebefore IS NOT NULL )";
			sql += " AND (logres.senddatebefore + logres.numdateprocess + songaynghile(logres.senddatebefore, logres.numdateprocess)) < logdi.dateprocess ";
			sql += ") AS logdi ";
			sql += " WHERE ( cvsend.documentsendid = logdi.documentsendid ) ";

			if (!"0".equals(loaisocongvan)) {
				sql = sql.replace(") AS logdi ",
						") AS logdi , pml_edm_documenttype dt ");
				sql += " AND cvsend.documenttypeid = dt.documenttypeid ";
				sql += " AND dt.documenttypeid = " + loaisocongvan;
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

	// end yenlt 09/04/2010

	/**
	 * Tinh so luong van ban di
	 * 
	 * @param soPH
	 *            So phat hanh van ban di
	 * @param ngayPHMonth
	 *            Thang cua ngay phat hanh
	 * @param ngayPHYear
	 *            Nam cua ngay phat hanh
	 * @param phongST
	 *            Phong soan thao
	 * @param noiNhan
	 *            Noi nhan van ban di
	 * @param loaiVB
	 *            Loai van ban
	 * @param tenNguoiKy
	 *            Ten cua nguoi ky
	 * @param nguoiST
	 *            Nguoi soan thao
	 * @param trichYeu
	 *            Trich yeu
	 * @return
	 * @throws SystemException
	 */
	public int countByD_I_D_R_D_S_E_B(String soPH, int ngayPHMonth,
			int ngayPHYear, String phongST, String noiNhan, long loaiVB,
			String tenNguoiKy, long nguoiST, String trichYeu)
			throws SystemException {

		Session session = null;

		try {
			session = openSession();

			String sql = "SELECT COUNT(DISTINCT(doc.documentsendid)) AS COUNT_VALUE ";
			sql += "FROM pml_edm_documentsend doc ";
			// Neu co chon phong thi tinh dua vao bang pml_user
			if ((phongST != null) && (phongST.trim().length() > 0)) {
				sql += "INNER JOIN pml_user usr on doc.editorid = usr.userid ";
			}

			// Mac dinh them dieu kien loc
			sql += "WHERE 1 = 1 ";
			// So phat hanh
			if ((soPH != null) && (soPH.trim().length() > 0)) {
				sql += "AND lower(doc.documentreference) LIKE '" + soPH + "' ";
			}
			// Cac thanh phan cua ngay phat hanh
			if (ngayPHYear > 0) {
				sql += "AND DATE_PART('year', doc.issuingdate) = " + ngayPHYear
						+ " ";
				// Thang
				if ((ngayPHMonth > 0) && (ngayPHMonth < 13)) {
					sql += "AND DATE_PART('month', doc.issuingdate) = "
							+ ngayPHMonth + " ";
				}
			} // end if
				// Phong soan thao
			if ((phongST != null) && (phongST.trim().length() > 0)) {
				sql += "AND usr.departmentsid = '" + phongST + "' ";
			}
			// Noi nhan
			if ((noiNhan != null) && (noiNhan.trim().length() > 0)) {
				sql += "AND lower(doc.receivingplace) like '" + noiNhan + "' ";
			}
			// Loai van ban
			if (loaiVB > 0) {
				sql += "AND doc.documenttypeid = " + loaiVB + " ";
			}
			// Ten nguoi ky
			if ((tenNguoiKy != null) && (tenNguoiKy.trim().length() > 0)) {
				sql += "AND lower(doc.signername) LIKE '" + tenNguoiKy + "' ";
			}
			// Nguoi soan thao
			if (nguoiST > 0) {
				sql += "AND editorid = " + nguoiST + " ";
			}
			// Trich yeu
			if ((trichYeu != null) && (trichYeu.trim().length() > 0)) {
				sql += "AND lower(doc.briefcontent) LIKE '" + trichYeu + "' ";
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

	/**
	 * Lay danh sach van ban di
	 * 
	 * @param soPH
	 *            So phat hanh van ban di
	 * @param ngayPHMonth
	 *            Thang cua ngay phat hanh
	 * @param ngayPHYear
	 *            Nam cua ngay phat hanh
	 * @param phongST
	 *            Phong soan thao
	 * @param noiNhan
	 *            Noi nhan van ban di
	 * @param loaiVB
	 *            Loai van ban
	 * @param tenNguoiKy
	 *            Ten cua nguoi ky
	 * @param nguoiST
	 *            Nguoi soan thao
	 * @param trichYeu
	 *            Trich yeu
	 * @param start
	 *            Vi tri bat dau
	 * @param end
	 *            Vi tri ket thuc
	 * @param obc
	 *            Cach sap xep
	 * @return
	 * @throws SystemException
	 */
	public List<PmlEdmDocumentSend> findByD_I_D_R_D_S_E_B(String soPH,
			int ngayPHMonth, int ngayPHYear, String phongST, String noiNhan,
			long loaiVB, String tenNguoiKy, long nguoiST, String trichYeu,
			int start, int end, OrderByComparator obc) throws SystemException {

		Session session = null;

		try {
			session = openSession();

			String sql = "SELECT DISTINCT(doc.*) ";
			sql += "FROM pml_edm_documentsend doc ";
			// Neu co chon phong thi tinh dua vao bang pml_user
			if ((phongST != null) && (phongST.trim().length() > 0)) {
				sql += "INNER JOIN pml_user usr on doc.editorid = usr.userid ";
			}

			// Mac dinh them dieu kien loc
			sql += "WHERE 1 = 1 ";
			// So phat hanh
			if ((soPH != null) && (soPH.trim().length() > 0)) {
				sql += "AND lower(doc.documentreference) LIKE '" + soPH + "' ";
			}
			// Cac thanh phan cua ngay phat hanh
			if (ngayPHYear > 0) {
				sql += "AND DATE_PART('year', doc.issuingdate) = " + ngayPHYear
						+ " ";
				// Thang
				if ((ngayPHMonth > 0) && (ngayPHMonth < 13)) {
					sql += "AND DATE_PART('month', doc.issuingdate) = "
							+ ngayPHMonth + " ";
				}
			} // end if
				// Phong soan thao
			if ((phongST != null) && (phongST.trim().length() > 0)) {
				sql += "AND usr.departmentsid = '" + phongST + "' ";
			}
			// Noi nhan
			if ((noiNhan != null) && (noiNhan.trim().length() > 0)) {
				sql += "AND lower(doc.receivingplace) like '" + noiNhan + "' ";
			}
			// Loai van ban
			if (loaiVB > 0) {
				sql += "AND doc.documenttypeid = " + loaiVB + " ";
			}
			// Ten nguoi ky
			if ((tenNguoiKy != null) && (tenNguoiKy.trim().length() > 0)) {
				sql += "AND lower(doc.signername) LIKE '" + tenNguoiKy + "' ";
			}
			// Nguoi soan thao
			if (nguoiST > 0) {
				sql += "AND editorid = " + nguoiST + " ";
			}
			// Trich yeu
			if ((trichYeu != null) && (trichYeu.trim().length() > 0)) {
				sql += "AND lower(doc.briefcontent) LIKE '" + trichYeu + "' ";
			}

			sql = CustomSQLUtil.replaceOrderBy(sql, obc);

			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("PmlEdmDocumentSend", PmlEdmDocumentSendImpl.class);

			return (List<PmlEdmDocumentSend>) QueryUtil.list(q, getDialect(),
					start, end);
		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}

	// yenlt 19-06-2010
	// delete cv di bi loi va chua phat hanh.
	public int countByKeywords(String keywords) throws SystemException {
		long loaiVB = 0;
		String[] nguoiKy = null;

		boolean andOperator = false;
		if (Validator.isNotNull(keywords)) {
			loaiVB = 0;
			nguoiKy = CustomSQLUtil.keywords(keywords, true);
		} else {
			andOperator = true;
		}

		return countByLOAIVB_NGUOIKY(loaiVB, nguoiKy, andOperator);
	}

	public int countByLOAIVB_NGUOIKY(long loaiVB, String nguoiKy,
			boolean andOperator) throws SystemException {
		return countByLOAIVB_NGUOIKY(loaiVB, new String[] { nguoiKy },
				andOperator);
	}

	private int countByLOAIVB_NGUOIKY(long loaiVB, String[] nguoiKy,
			boolean andOperator) throws SystemException {
		nguoiKy = CustomSQLUtil.keywords(nguoiKy, true);

		Session session = null;
		try {
			session = openSession();
			String sql = "SELECT COUNT(*) AS COUNT_VALUE ";
			sql += " FROM pml_edm_documentsend, pml_documentsend_wf ";
			sql += " WHERE pml_edm_documentsend.issuingdate IS NULL ";
			sql += " AND pml_edm_documentsend.documentreference = ''";
			sql += " AND pml_edm_documentsend.documentsendid = pml_documentsend_wf.documentsendid";
			sql += " AND (";
			sql += " (lower(pml_edm_documentsend.signername) LIKE ? [$AND_OR_NULL_CHECK$])";

			if (0 != loaiVB) {
				sql += " [$AND_OR_CONNECTOR$] ";
				sql += " (pml_edm_documentsend.documenttypeid = " + loaiVB
						+ ") )";
			} else {
				sql += ")";
			}

			sql = CustomSQLUtil.replaceKeywords(sql,
					"lower(pml_edm_documentsend.signername)", StringPool.LIKE,
					true, nguoiKy);
			sql = CustomSQLUtil.replaceAndOperator(sql, andOperator);
			SQLQuery q = session.createSQLQuery(sql);
			q.addScalar(COUNT_COLUMN_NAME, Type.LONG);

			QueryPos qpos = QueryPos.getInstance(q);
			qpos.add(nguoiKy, 2);

			Iterator<Long> iter = q.list().iterator();
			if (iter.hasNext()) {
				Long count = iter.next();
				if (count != null) {
					return count.intValue();
				}
			}
			return 0;
		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}

	public List<PmlEdmDocumentSend> findByKeywords(String keywords, int start,
			int end, OrderByComparator obc) throws SystemException {
		long loaiVB = 0;
		String[] nguoiKy = null;

		boolean andOperator = false;
		if (Validator.isNotNull(keywords)) {
			loaiVB = 0;
			nguoiKy = CustomSQLUtil.keywords(keywords, true);
		} else {
			andOperator = true;
		}

		return findByLOAIVB_NGUOIKY(loaiVB, nguoiKy, andOperator, start, end,
				obc);
	}

	public List<PmlEdmDocumentSend> findByLOAIVB_NGUOIKY(long loaiVB,
			String nguoiKy, boolean andOperator, int start, int end,
			OrderByComparator obc) throws SystemException {
		return findByLOAIVB_NGUOIKY(loaiVB, new String[] { nguoiKy },
				andOperator, start, end, obc);
	}

	private List<PmlEdmDocumentSend> findByLOAIVB_NGUOIKY(long loaiVB,
			String[] nguoiKy, boolean andOperator, int start, int end,
			OrderByComparator obc) throws SystemException {
		nguoiKy = CustomSQLUtil.keywords(nguoiKy, true);

		Session session = null;
		try {
			session = openSession();
			String sql = "SELECT pml_edm_documentsend.* ";
			sql += "FROM pml_edm_documentsend, pml_documentsend_wf, pml_edm_documenttype ";
			sql += " WHERE pml_edm_documentsend.issuingdate IS NULL ";
			sql += " AND pml_edm_documentsend.documentreference = ''";
			sql += " AND pml_edm_documentsend.documentsendid = pml_documentsend_wf.documentsendid";
			sql += " AND pml_edm_documentsend.documenttypeid = pml_edm_documenttype.documenttypeid";

			if (0 != loaiVB) {
				sql += " AND (";
				sql += " (lower(pml_edm_documentsend.signername) LIKE ? [$AND_OR_NULL_CHECK$]) [$AND_OR_CONNECTOR$] ";
				sql += " (pml_edm_documentsend.documenttypeid = " + loaiVB
						+ ") )";
			} else {
				sql += " AND (";
				sql += " (lower(pml_edm_documentsend.signername) LIKE ? [$AND_OR_NULL_CHECK$])";
				sql += ")";
			}

			sql = CustomSQLUtil.replaceKeywords(sql,
					"lower(pml_edm_documentsend.signername)", StringPool.LIKE,
					true, nguoiKy);
			sql = CustomSQLUtil.replaceAndOperator(sql, andOperator);
			sql = CustomSQLUtil.replaceOrderBy(sql, obc);

			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("pml_edm_documentsend", PmlEdmDocumentSendImpl.class);

			QueryPos qpos = QueryPos.getInstance(q);
			qpos.add(nguoiKy, 2);

			return (List<PmlEdmDocumentSend>) QueryUtil.list(q, getDialect(),
					start, end);
		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}

	/**
	 * yenlt 20101023 == TIM THEO SEARCH FORM CONG VAN DI DA XU LY
	 * 
	 * @throws SystemException
	 */
	public List<PmlEdmDocumentSend> getListCVDiDaXuLyChung(long userId,
			long loaiVB, String soKyHieu, String donViSoanThao, String nguoiKy,
			String trichYeu, String coQuanNhan, String tuNgay, String denNgay,
			int start, int end, OrderByComparator obc) throws SystemException {
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
		} catch (ParseException e) {
		}

		Session session = null;

		try {
			session = openSession();

			String sql = " SELECT cvsend.*  ";
			sql += " FROM pml_edm_documentsend cvsend, (SELECT  DISTINCT (pml_documentsend_log.documentsendid), MAX  (pml_documentsend_log.transition_) AS tran  ";
			sql += " FROM pml_documentsend_log  ";
			sql += " WHERE ( pml_documentsend_log.processer = " + userId + ") ";
			sql += " GROUP BY pml_documentsend_log.documentsendid ";
			sql += ") AS pml_send_log, pml_documentsend_log log";
			sql += " WHERE ( pml_send_log.documentsendid = log.documentsendid ) ";
			sql += " AND ( pml_send_log.tran = log.transition_ ) ";
			sql += " AND ( cvsend.documentsendid = log.documentsendid ) ";
			sql += " AND ('" + fromDate + "' <= log.dateprocess";
			sql += " AND log.dateprocess <= '" + toDate + "' )";

			if (!"".equals(donViSoanThao)) {
				sql = sql
						.replace(") AS pml_send_log, pml_documentsend_log log",
								") AS pml_send_log, pml_documentsend_log log, pml_user ");
				sql += " AND cvsend.editorid = pml_user.userid";
				sql += " AND pml_user.departmentsid = '" + donViSoanThao + "' ";
			}

			if (0 != loaiVB) {
				sql = sql
						.replace(") AS pml_send_log, pml_documentsend_log log",
								") AS pml_send_log, pml_documentsend_log log, pml_edm_documenttype dt ");
				sql += " AND ( cvsend.documenttypeid = dt.documenttypeid ) ";
				sql += " AND dt.documenttypeid = " + loaiVB;
			}

			if (!"".equals(soKyHieu)) {
				sql += " AND lower(cvsend.documentreference) LIKE lower('%"
						+ soKyHieu + "%')";
			}

			if (!"".equals(nguoiKy)) {
				sql += " AND lower(cvsend.signername) LIKE lower('%" + nguoiKy
						+ "%') ";
			}

			if (!"".equals(trichYeu)) {
				sql += "AND lower(cvsend.briefcontent) LIKE lower('%"
						+ trichYeu + "%') ";
			}

			if (!"".equals(coQuanNhan)) {
				sql += " AND lower(cvsend.receivingplace) LIKE lower('%"
						+ coQuanNhan + "%')";
			}

			sql = CustomSQLUtil.replaceOrderBy(sql, obc);
			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("pml_edm_documentsend", PmlEdmDocumentSendImpl.class);

			return (List<PmlEdmDocumentSend>) QueryUtil.list(q, getDialect(),
					start, end);
		} catch (Exception e) {
			throw processException(e);
		} finally {
			closeSession(session);
		}
	}

	public int countListCVDiDaXuLyChung(long userId, long loaiVB,
			String soKyHieu, String donViSoanThao, String nguoiKy,
			String trichYeu, String coQuanNhan, String tuNgay, String denNgay)
			throws SystemException {
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
		} catch (ParseException e) {
		}

		Session session = null;

		try {
			session = openSession();

			String sql = " SELECT COUNT(*) AS COUNT_VALUE";
			sql += " FROM pml_edm_documentsend cvsend, (SELECT  DISTINCT (pml_documentsend_log.documentsendid), MAX  (pml_documentsend_log.transition_) AS tran  ";
			sql += " FROM pml_documentsend_log  ";
			sql += " WHERE ( pml_documentsend_log.processer = " + userId + ") ";
			sql += " GROUP BY pml_documentsend_log.documentsendid ";
			sql += ") AS pml_send_log, pml_documentsend_log log";
			sql += " WHERE ( pml_send_log.documentsendid = log.documentsendid ) ";
			sql += " AND ( pml_send_log.tran = log.transition_ ) ";
			sql += " AND ( cvsend.documentsendid = log.documentsendid ) ";
			sql += " AND ('" + fromDate + "' <= log.dateprocess";
			sql += " AND log.dateprocess <= '" + toDate + "' )";

			if (!"".equals(donViSoanThao)) {
				sql = sql
						.replace(") AS pml_send_log, pml_documentsend_log log",
								") AS pml_send_log, pml_documentsend_log log, pml_user ");
				sql += " AND cvsend.editorid = pml_user.userid";
				sql += " AND pml_user.departmentsid = '" + donViSoanThao + "' ";
			}

			if (0 != loaiVB) {
				sql = sql
						.replace(") AS pml_send_log, pml_documentsend_log log",
								") AS pml_send_log, pml_documentsend_log log, pml_edm_documenttype dt ");
				sql += " AND ( cvsend.documenttypeid = dt.documenttypeid ) ";
				sql += " AND dt.documenttypeid = " + loaiVB;
			}

			if (!"".equals(soKyHieu)) {
				sql += " AND lower(cvsend.documentreference) LIKE lower('%"
						+ soKyHieu + "%')";
			}

			if (!"".equals(nguoiKy)) {
				sql += " AND lower(cvsend.signername) LIKE lower('%" + nguoiKy
						+ "%') ";
			}

			if (!"".equals(trichYeu)) {
				sql += "AND lower(cvsend.briefcontent) LIKE lower('%"
						+ trichYeu + "%') ";
			}

			if (!"".equals(coQuanNhan)) {
				sql += " AND lower(cvsend.receivingplace) LIKE lower('%"
						+ coQuanNhan + "%')";
			}

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME, Type.LONG);

			Iterator<Long> iter = q.list().iterator();
			if (iter.hasNext()) {
				Long count = iter.next();
				if (count != null) {
					return count.intValue();
				}
			}
			return 0;
		} catch (Exception e) {
			throw processException(e);
		} finally {
			closeSession(session);
		}
	}

	/**
	 * get list cv di da xu ly - tu xu ly
	 */
	public List<PmlEdmDocumentSend> getListCVDiDaXuLyTuXuLy(long userId,
			long loaiVB, String soKyHieu, String donViSoanThao, String nguoiKy,
			String trichYeu, String coQuanNhan, String tuNgay, String denNgay,
			int start, int end, OrderByComparator obc) throws SystemException {
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
		} catch (ParseException e) {
		}

		Session session = null;

		try {
			session = openSession();

			String sql = "SELECT cvsend.* ";
			sql += " FROM pml_edm_documentsend cvsend, (SELECT  DISTINCT (pml_documentsend_log.documentsendid), MAX  (pml_documentsend_log.transition_) AS tran  ";
			sql += " FROM pml_documentsend_log  ";
			sql += " WHERE ( pml_documentsend_log.processer = " + userId + ") ";
			sql += " GROUP BY pml_documentsend_log.documentsendid ";
			sql += ") AS pml_send_log, pml_documentsend_log log";
			sql += " WHERE ( pml_send_log.documentsendid = log.documentsendid ) ";
			sql += " AND ( pml_send_log.tran = log.transition_ ) ";
			sql += " AND ( log.processer = log.receiver ) ";
			sql += " AND ( cvsend.documentsendid = log.documentsendid ) ";
			sql += " AND ('" + fromDate + "' <= log.dateprocess";
			sql += " AND log.dateprocess <= '" + toDate + "' )";

			if (!"".equals(donViSoanThao)) {
				sql = sql
						.replace(") AS pml_send_log, pml_documentsend_log log",
								") AS pml_send_log, pml_documentsend_log log, pml_user ");
				sql += " AND cvsend.editorid = pml_user.userid";
				sql += " AND pml_user.departmentsid = '" + donViSoanThao + "' ";
			}

			if (0 != loaiVB) {
				sql = sql
						.replace(") AS pml_send_log, pml_documentsend_log log",
								") AS pml_send_log, pml_documentsend_log log, pml_edm_documenttype dt ");
				sql += " AND ( cvsend.documenttypeid = dt.documenttypeid ) ";
				sql += " AND dt.documenttypeid = " + loaiVB;
			}

			if (!"".equals(soKyHieu)) {
				sql += " AND lower(cvsend.documentreference) LIKE lower('%"
						+ soKyHieu + "%')";
			}

			if (!"".equals(nguoiKy)) {
				sql += " AND lower(cvsend.signername) LIKE lower('%" + nguoiKy
						+ "%') ";
			}

			if (!"".equals(trichYeu)) {
				sql += "AND lower(cvsend.briefcontent) LIKE lower('%"
						+ trichYeu + "%') ";
			}

			if (!"".equals(coQuanNhan)) {
				sql += " AND lower(cvsend.receivingplace) LIKE lower('%"
						+ coQuanNhan + "%')";
			}

			sql = CustomSQLUtil.replaceOrderBy(sql, obc);
			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("pml_edm_documentsend", PmlEdmDocumentSendImpl.class);

			return (List<PmlEdmDocumentSend>) QueryUtil.list(q, getDialect(),
					start, end);
		} catch (Exception e) {
			throw processException(e);
		} finally {
			closeSession(session);
		}
	}

	public int countListCVDiDaXuLyTuXuLy(long userId, long loaiVB,
			String soKyHieu, String donViSoanThao, String nguoiKy,
			String trichYeu, String coQuanNhan, String tuNgay, String denNgay)
			throws SystemException {
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
		} catch (ParseException e) {
		}

		Session session = null;

		try {
			session = openSession();

			String sql = " SELECT COUNT(*) AS COUNT_VALUE";
			sql += " FROM pml_edm_documentsend cvsend, (SELECT  DISTINCT (pml_documentsend_log.documentsendid), MAX  (pml_documentsend_log.transition_) AS tran  ";
			sql += " FROM pml_documentsend_log  ";
			sql += " WHERE ( pml_documentsend_log.processer = " + userId + ") ";
			sql += " GROUP BY pml_documentsend_log.documentsendid ";
			sql += ") AS pml_send_log, pml_documentsend_log log";
			sql += " WHERE ( pml_send_log.documentsendid = log.documentsendid ) ";
			sql += " AND ( pml_send_log.tran = log.transition_ ) ";
			sql += " AND ( log.processer = log.receiver ) ";
			sql += " AND ( cvsend.documentsendid = log.documentsendid ) ";
			sql += " AND ('" + fromDate + "' <= log.dateprocess";
			sql += " AND log.dateprocess <= '" + toDate + "' )";

			if (!"".equals(donViSoanThao)) {
				sql = sql
						.replace(") AS pml_send_log, pml_documentsend_log log",
								") AS pml_send_log, pml_documentsend_log log, pml_user ");
				sql += " AND cvsend.editorid = pml_user.userid";
				sql += " AND pml_user.departmentsid = '" + donViSoanThao + "' ";
			}

			if (0 != loaiVB) {
				sql = sql
						.replace(") AS pml_send_log, pml_documentsend_log log",
								") AS pml_send_log, pml_documentsend_log log, pml_edm_documenttype dt ");
				sql += " AND ( cvsend.documenttypeid = dt.documenttypeid ) ";
				sql += " AND dt.documenttypeid = " + loaiVB;
			}

			if (!"".equals(soKyHieu)) {
				sql += " AND lower(cvsend.documentreference) LIKE lower('%"
						+ soKyHieu + "%')";
			}

			if (!"".equals(nguoiKy)) {
				sql += " AND lower(cvsend.signername) LIKE lower('%" + nguoiKy
						+ "%') ";
			}

			if (!"".equals(trichYeu)) {
				sql += "AND lower(cvsend.briefcontent) LIKE lower('%"
						+ trichYeu + "%') ";
			}

			if (!"".equals(coQuanNhan)) {
				sql += " AND lower(cvsend.receivingplace) LIKE lower('%"
						+ coQuanNhan + "%')";
			}

			SQLQuery q = session.createSQLQuery(sql);
			q.addScalar(COUNT_COLUMN_NAME, Type.LONG);

			Iterator<Long> iter = q.list().iterator();
			if (iter.hasNext()) {
				Long count = iter.next();
				if (count != null) {
					return count.intValue();
				}
			}
			return 0;
		} catch (Exception e) {
			throw processException(e);
		} finally {
			closeSession(session);
		}
	}

	/**
	 * cv di da xu ly chung - tre han
	 */
	public List<PmlEdmDocumentSend> getListCVDiDaXuLyChung_treHan(long userId,
			long loaiVB, String soKyHieu, String donViSoanThao, String nguoiKy,
			String trichYeu, String coQuanNhan, String tuNgay, String denNgay,
			int start, int end, OrderByComparator obc) throws SystemException {
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
		} catch (ParseException e) {
		}

		Session session = null;

		try {
			session = openSession();

			String sql = " SELECT cvsend.* ";
			sql += " FROM pml_edm_documentsend cvsend, ";
			sql += " (SELECT DISTINCT (logdi.documentsendid) ";
			sql += " FROM pml_documentsend_log logdi, ";
			sql += " ( SELECT logden.documentreceiptid AS  docid, MAX(logden.transition_) AS t_  ";
			sql += " FROM pml_documentsend_log logdi, pml_documentreceipt_log logden, pml_edm_answerdetail detail ";
			sql += " WHERE detail.documentsendid =  logdi.documentsendid ";
			sql += " AND detail.documentreceiptid = logden.documentreceiptid ";
			sql += " AND logdi.processer = " + userId;
			sql += " GROUP BY logden.documentreceiptid ";
			sql += " ) AS logden, pml_documentreceipt_log logres, pml_edm_answerdetail detail ";
			sql += " WHERE logres.documentreceiptid = logden.docid ";
			sql += " AND logres.transition_ = logden.t_  ";
			sql += " AND detail.documentsendid =  logdi.documentsendid ";
			sql += " AND detail.documentreceiptid = logden.docid ";
			sql += " AND logdi.processer = " + userId;
			sql += " AND ('" + fromDate
					+ "' <= logdi.dateprocess AND logdi.dateprocess <= '"
					+ toDate + "' )";
			sql += " AND (logres.senddatebefore IS NOT NULL )";
			sql += " AND (logres.senddatebefore + logres.numdateprocess + songaynghile(logres.senddatebefore, logres.numdateprocess)) < logdi.dateprocess ";
			sql += ") AS logdi ";
			sql += " WHERE ( cvsend.documentsendid = logdi.documentsendid ) ";

			if (!"".equals(donViSoanThao)) {
				sql = sql.replace(") AS logdi ", ") AS logdi , pml_user ");
				sql += " AND cvsend.editorid = pml_user.userid";
				sql += " AND pml_user.departmentsid = '" + donViSoanThao + "' ";
			}

			if (0 != loaiVB) {
				sql = sql.replace(") AS logdi ",
						") AS logdi , pml_edm_documenttype dt  ");
				sql += " AND ( cvsend.documenttypeid = dt.documenttypeid ) ";
				sql += " AND dt.documenttypeid = " + loaiVB;
			}

			if (!"".equals(soKyHieu)) {
				sql += " AND lower(cvsend.documentreference) LIKE lower('%"
						+ soKyHieu + "%')";
			}

			if (!"".equals(nguoiKy)) {
				sql += " AND lower(cvsend.signername) LIKE lower('%" + nguoiKy
						+ "%') ";
			}

			if (!"".equals(trichYeu)) {
				sql += "AND lower(cvsend.briefcontent) LIKE lower('%"
						+ trichYeu + "%') ";
			}

			if (!"".equals(coQuanNhan)) {
				sql += " AND lower(cvsend.receivingplace) LIKE lower('%"
						+ coQuanNhan + "%')";
			}

			sql = CustomSQLUtil.replaceOrderBy(sql, obc);
			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("pml_edm_documentsend", PmlEdmDocumentSendImpl.class);

			return (List<PmlEdmDocumentSend>) QueryUtil.list(q, getDialect(),
					start, end);
		} catch (Exception e) {
			throw processException(e);
		} finally {
			closeSession(session);
		}
	}

	public int countListCVDiDaXuLyChung_treHan(long userId, long loaiVB,
			String soKyHieu, String donViSoanThao, String nguoiKy,
			String trichYeu, String coQuanNhan, String tuNgay, String denNgay)
			throws SystemException {
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
		} catch (ParseException e) {
		}

		Session session = null;

		try {
			session = openSession();

			String sql = " SELECT COUNT(*) AS COUNT_VALUE";
			sql += " FROM pml_edm_documentsend cvsend, ";
			sql += " (SELECT DISTINCT (logdi.documentsendid) ";
			sql += " FROM pml_documentsend_log logdi, ";
			sql += " ( SELECT logden.documentreceiptid AS  docid, MAX(logden.transition_) AS t_  ";
			sql += " FROM pml_documentsend_log logdi, pml_documentreceipt_log logden, pml_edm_answerdetail detail ";
			sql += " WHERE detail.documentsendid =  logdi.documentsendid ";
			sql += " AND detail.documentreceiptid = logden.documentreceiptid ";
			sql += " AND logdi.processer = " + userId;
			sql += " GROUP BY logden.documentreceiptid ";
			sql += " ) AS logden, pml_documentreceipt_log logres, pml_edm_answerdetail detail ";
			sql += " WHERE logres.documentreceiptid = logden.docid ";
			sql += " AND logres.transition_ = logden.t_  ";
			sql += " AND detail.documentsendid =  logdi.documentsendid ";
			sql += " AND detail.documentreceiptid = logden.docid ";
			sql += " AND logdi.processer = " + userId;
			sql += " AND ('" + fromDate
					+ "' <= logdi.dateprocess AND logdi.dateprocess <= '"
					+ toDate + "' )";
			sql += " AND (logres.senddatebefore IS NOT NULL )";
			sql += " AND (logres.senddatebefore + logres.numdateprocess + songaynghile(logres.senddatebefore, logres.numdateprocess)) < logdi.dateprocess ";
			sql += ") AS logdi ";
			sql += " WHERE ( cvsend.documentsendid = logdi.documentsendid ) ";

			if (!"".equals(donViSoanThao)) {
				sql = sql.replace(") AS logdi ", ") AS logdi , pml_user ");
				sql += " AND cvsend.editorid = pml_user.userid";
				sql += " AND pml_user.departmentsid = '" + donViSoanThao + "' ";
			}

			if (0 != loaiVB) {
				sql = sql.replace(") AS logdi ",
						") AS logdi , pml_edm_documenttype dt  ");
				sql += " AND ( cvsend.documenttypeid = dt.documenttypeid ) ";
				sql += " AND dt.documenttypeid = " + loaiVB;
			}

			if (!"".equals(soKyHieu)) {
				sql += " AND lower(cvsend.documentreference) LIKE lower('%"
						+ soKyHieu + "%')";
			}

			if (!"".equals(nguoiKy)) {
				sql += " AND lower(cvsend.signername) LIKE lower('%" + nguoiKy
						+ "%') ";
			}

			if (!"".equals(trichYeu)) {
				sql += "AND lower(cvsend.briefcontent) LIKE lower('%"
						+ trichYeu + "%') ";
			}

			if (!"".equals(coQuanNhan)) {
				sql += " AND lower(cvsend.receivingplace) LIKE lower('%"
						+ coQuanNhan + "%')";
			}

			SQLQuery q = session.createSQLQuery(sql);
			q.addScalar(COUNT_COLUMN_NAME, Type.LONG);

			Iterator<Long> iter = q.list().iterator();
			if (iter.hasNext()) {
				Long count = iter.next();
				if (count != null) {
					return count.intValue();
				}
			}
			return 0;
		} catch (Exception e) {
			throw processException(e);
		} finally {
			closeSession(session);
		}
	}

	/*
	 * cv di da xu ly - tu xu ly - tre han
	 */
	public List<PmlEdmDocumentSend> getListCVDiDaXuLyTuXuLy_treHan(long userId,
			long loaiVB, String soKyHieu, String donViSoanThao, String nguoiKy,
			String trichYeu, String coQuanNhan, String tuNgay, String denNgay,
			int start, int end, OrderByComparator obc) throws SystemException {
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
		} catch (ParseException e) {
		}

		Session session = null;

		try {
			session = openSession();

			String sql = "SELECT cvsend.* ";
			sql += " FROM pml_edm_documentsend cvsend, ";
			sql += " (SELECT DISTINCT (logdi.documentsendid) ";
			sql += " FROM pml_documentsend_log logdi, ";
			sql += " ( SELECT logden.documentreceiptid AS  docid, MAX(logden.transition_) AS t_  ";
			sql += " FROM pml_documentsend_log logdi, pml_documentreceipt_log logden, pml_edm_answerdetail detail ";
			sql += " WHERE detail.documentsendid =  logdi.documentsendid ";
			sql += " AND detail.documentreceiptid = logden.documentreceiptid ";
			sql += " AND logdi.processer = " + userId;
			sql += " GROUP BY logden.documentreceiptid ";
			sql += " ) AS logden, pml_documentreceipt_log logres, pml_edm_answerdetail detail ";
			sql += " WHERE logres.documentreceiptid = logden.docid ";
			sql += " AND logres.transition_ = logden.t_  ";
			sql += " AND detail.documentsendid =  logdi.documentsendid ";
			sql += " AND detail.documentreceiptid = logden.docid ";
			sql += " AND logdi.processer = " + userId;
			sql += " AND logdi.processer = logdi.receiver ";
			sql += " AND ('" + fromDate
					+ "' <= logdi.dateprocess AND logdi.dateprocess <= '"
					+ toDate + "' )";
			sql += " AND (logres.senddatebefore IS NOT NULL )";
			sql += " AND (logres.senddatebefore + logres.numdateprocess + songaynghile(logres.senddatebefore, logres.numdateprocess)) < logdi.dateprocess ";
			sql += ") AS logdi ";
			sql += " WHERE ( cvsend.documentsendid = logdi.documentsendid ) ";

			if (!"".equals(donViSoanThao)) {
				sql = sql.replace(") AS logdi ", ") AS logdi , pml_user ");
				sql += " AND cvsend.editorid = pml_user.userid";
				sql += " AND pml_user.departmentsid = '" + donViSoanThao + "' ";
			}

			if (0 != loaiVB) {
				sql = sql.replace(") AS logdi ",
						") AS logdi , pml_edm_documenttype dt  ");
				sql += " AND ( cvsend.documenttypeid = dt.documenttypeid ) ";
				sql += " AND dt.documenttypeid = " + loaiVB;
			}

			if (!"".equals(soKyHieu)) {
				sql += " AND lower(cvsend.documentreference) LIKE lower('%"
						+ soKyHieu + "%')";
			}

			if (!"".equals(nguoiKy)) {
				sql += " AND lower(cvsend.signername) LIKE lower('%" + nguoiKy
						+ "%') ";
			}

			if (!"".equals(trichYeu)) {
				sql += "AND lower(cvsend.briefcontent) LIKE lower('%"
						+ trichYeu + "%') ";
			}

			if (!"".equals(coQuanNhan)) {
				sql += " AND lower(cvsend.receivingplace) LIKE lower('%"
						+ coQuanNhan + "%')";
			}

			sql = CustomSQLUtil.replaceOrderBy(sql, obc);

			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("pml_edm_documentsend", PmlEdmDocumentSendImpl.class);

			return (List<PmlEdmDocumentSend>) QueryUtil.list(q, getDialect(),
					start, end);
		} catch (Exception e) {
			throw processException(e);
		} finally {
			closeSession(session);
		}
	}

	public int countListCVDiDaXuLyTuXuLy_treHan(long userId, long loaiVB,
			String soKyHieu, String donViSoanThao, String nguoiKy,
			String trichYeu, String coQuanNhan, String tuNgay, String denNgay)
			throws SystemException {
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
		} catch (ParseException e) {
		}

		Session session = null;

		try {
			session = openSession();

			String sql = " SELECT COUNT(*) AS COUNT_VALUE";
			sql += " FROM pml_edm_documentsend cvsend, ";
			sql += " (SELECT DISTINCT (logdi.documentsendid) ";
			sql += " FROM pml_documentsend_log logdi, ";
			sql += " ( SELECT logden.documentreceiptid AS  docid, MAX(logden.transition_) AS t_  ";
			sql += " FROM pml_documentsend_log logdi, pml_documentreceipt_log logden, pml_edm_answerdetail detail ";
			sql += " WHERE detail.documentsendid =  logdi.documentsendid ";
			sql += " AND detail.documentreceiptid = logden.documentreceiptid ";
			sql += " AND logdi.processer = " + userId;
			sql += " GROUP BY logden.documentreceiptid ";
			sql += " ) AS logden, pml_documentreceipt_log logres, pml_edm_answerdetail detail ";
			sql += " WHERE logres.documentreceiptid = logden.docid ";
			sql += " AND logres.transition_ = logden.t_  ";
			sql += " AND detail.documentsendid =  logdi.documentsendid ";
			sql += " AND detail.documentreceiptid = logden.docid ";
			sql += " AND logdi.processer = " + userId;
			sql += " AND logdi.processer = logdi.receiver ";
			sql += " AND ('" + fromDate
					+ "' <= logdi.dateprocess AND logdi.dateprocess <= '"
					+ toDate + "' )";
			sql += " AND (logres.senddatebefore IS NOT NULL )";
			sql += " AND (logres.senddatebefore + logres.numdateprocess + songaynghile(logres.senddatebefore, logres.numdateprocess)) < logdi.dateprocess ";
			sql += ") AS logdi ";
			sql += " WHERE ( cvsend.documentsendid = logdi.documentsendid ) ";

			if (!"".equals(donViSoanThao)) {
				sql = sql.replace(") AS logdi ", ") AS logdi , pml_user ");
				sql += " AND cvsend.editorid = pml_user.userid";
				sql += " AND pml_user.departmentsid = '" + donViSoanThao + "' ";
			}

			if (0 != loaiVB) {
				sql = sql.replace(") AS logdi ",
						") AS logdi , pml_edm_documenttype dt  ");
				sql += " AND ( cvsend.documenttypeid = dt.documenttypeid ) ";
				sql += " AND dt.documenttypeid = " + loaiVB;
			}

			if (!"".equals(soKyHieu)) {
				sql += " AND lower(cvsend.documentreference) LIKE lower('%"
						+ soKyHieu + "%')";
			}

			if (!"".equals(nguoiKy)) {
				sql += " AND lower(cvsend.signername) LIKE lower('%" + nguoiKy
						+ "%') ";
			}

			if (!"".equals(trichYeu)) {
				sql += "AND lower(cvsend.briefcontent) LIKE lower('%"
						+ trichYeu + "%') ";
			}

			if (!"".equals(coQuanNhan)) {
				sql += " AND lower(cvsend.receivingplace) LIKE lower('%"
						+ coQuanNhan + " %')";
			}

			SQLQuery q = session.createSQLQuery(sql);
			q.addScalar(COUNT_COLUMN_NAME, Type.LONG);

			Iterator<Long> iter = q.list().iterator();
			if (iter.hasNext()) {
				Long count = iter.next();
				if (count != null) {
					return count.intValue();
				}
			}
			return 0;
		} catch (Exception e) {
			throw processException(e);
		} finally {
			closeSession(session);
		}
	}

	/*
	 * VB di Dang xu ly tre han
	 */
	public List<PmlEdmDocumentSend> findByDocumentSend_Users_Status_DangXuLy_TreHan(
			List<Long> userIds, long statusId, long loaiVB, String soKyHieu,
			String donViSoanThao, String nguoiKy, String trichYeu,
			String coQuanNhan, String tuNgay, String denNgay, int start,
			int end, OrderByComparator obc) throws Exception {
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
		} catch (ParseException e) {
		}

		String userIdList = "";
		for (int i = 0; i < userIds.size(); i++) {
			if (i != userIds.size() - 1) {
				userIdList += userIds.get(i) + ", ";
			}
			userIdList += userIds.get(i);
		}

		DocumentSendLiferayWorkflowService workflowService = new DocumentSendLiferayWorkflowService();
		List<Long> listProcessId = workflowService
				.getListProcessInstanceByStatusId(userIds, statusId);

		// Lay ngay hien tai
		String currentDate = new SimpleDateFormat("yyyy-MM-dd")
				.format(new Date());
		Session session = null;

		try {
			session = openSession();

			String sql = " SELECT DISTINCT(cvsend.*) ";
			sql += " FROM pml_edm_documentsend cvsend, pml_documentsend_wf cvsendwf, pml_edm_documentreceipt cvden, pml_edm_answerdetail ad,";
			sql += " (SELECT  DISTINCT (pml_documentsend_log.documentsendid), MAX  (pml_documentsend_log.transition_) AS tran ";
			sql += " FROM pml_documentsend_log  ";
			sql += " WHERE ( pml_documentsend_log.processer IN (" + userIdList
					+ "))";
			sql += " GROUP BY pml_documentsend_log.documentsendid ";
			sql += ") AS pml_send_log, pml_documentsend_log log";
			sql += " WHERE cvsend.documentsendid = cvsendwf.documentsendid";
			sql += " AND cvsendwf.processid in (";

			for (Long processId : listProcessId) {
				sql += processId + ",";
			}

			sql += "0) ";

			sql += " AND cvsend.documentsendid = ad.documentsendid ";
			sql += " AND cvden.documentreceiptid = ad.documentreceiptid ";
			sql += " AND pml_send_log.documentsendid = log.documentsendid ";
			sql += " AND pml_send_log.tran = log.transition_ ";
			sql += " AND log.documentsendid = cvsendwf.documentsendid";
			sql += " AND cvsend.datecreated + cvden.processtime + songaynghile(cvsend.datecreated, cvden.processtime) < '"
					+ currentDate + "'";

			sql += " AND log.dateprocess IS NULL ";
			sql += " AND ( '" + fromDate
					+ "' <= log.senddatebefore AND log.senddatebefore <= '"
					+ toDate + "' )";

			if (0 != loaiVB) {
				sql = sql
						.replace(
								") AS pml_send_log, pml_documentsend_log log, pml_edm_documentreceipt cvden, pml_edm_answerdetail ad",
								") AS pml_send_log, pml_documentsend_log log, pml_edm_documentreceipt cvden, pml_edm_answerdetail ad, pml_edm_documenttype dt");
				sql += " AND cvsend.documenttypeid = dt.documenttypeid";
				sql += " AND dt.documenttypeid = " + loaiVB;
			}

			if (!"".equals(donViSoanThao)) {
				sql = sql
						.replace(
								") AS pml_send_log, pml_documentsend_log log, pml_edm_documentreceipt cvden, pml_edm_answerdetail ad",
								") AS pml_send_log, pml_documentsend_log log, pml_edm_documentreceipt cvden, pml_edm_answerdetail ad, pml_user ");
				sql += " AND cvsend.editorid = pml_user.userid";
				sql += " AND pml_user.departmentsid = '" + donViSoanThao + "' ";
			}

			if (!"".equals(soKyHieu)) {
				sql += " AND lower(cvsend.documentreference) LIKE lower('%"
						+ soKyHieu + "%')";
			}

			if (!"".equals(nguoiKy)) {
				sql += " AND lower(cvsend.signername) LIKE lower('%" + nguoiKy
						+ "%') ";
			}

			if (!"".equals(trichYeu)) {
				sql += "AND lower(cvsend.briefcontent) LIKE lower('%"
						+ trichYeu + "%') ";
			}

			if (!"".equals(coQuanNhan)) {
				sql += " AND lower(cvsend.receivingplace) LIKE lower('%"
						+ coQuanNhan + " %')";
			}

			sql = CustomSQLUtil.replaceOrderBy(sql, obc);

			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("PmlEdmDocumentSend", PmlEdmDocumentSendImpl.class);

			return (List<PmlEdmDocumentSend>) QueryUtil.list(q, getDialect(),
					start, end);
		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}

	public int countByDocumentSend_Users_Status_DangXuLy_TreHan(
			List<Long> userIds, long statusId, long loaiVB, String soKyHieu,
			String donViSoanThao, String nguoiKy, String trichYeu,
			String coQuanNhan, String tuNgay, String denNgay) throws Exception {
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
		} catch (ParseException e) {
		}

		String userIdList = "";
		for (int i = 0; i < userIds.size(); i++) {
			if (i != userIds.size() - 1) {
				userIdList += userIds.get(i) + ", ";
			}
			userIdList += userIds.get(i);
		}

		// Lay ngay hien tai
		String currentDate = new SimpleDateFormat("yyyy-MM-dd")
				.format(new Date());

		DocumentSendLiferayWorkflowService workflowService = new DocumentSendLiferayWorkflowService();
		List<Long> listProcessId = workflowService
				.getListProcessInstanceByStatusId(userIds, statusId);

		Session session = null;

		try {
			session = openSession();

			String sql = "SELECT COUNT(DISTINCT(cvsend.documentsendid)) AS COUNT_VALUE";
			sql += " FROM pml_edm_documentsend cvsend, pml_documentsend_wf cvsendwf, pml_edm_documentreceipt cvden, pml_edm_answerdetail ad,";
			sql += " (SELECT  DISTINCT (pml_documentsend_log.documentsendid), MAX  (pml_documentsend_log.transition_) AS tran ";
			sql += " FROM pml_documentsend_log  ";
			sql += " WHERE ( pml_documentsend_log.processer IN (" + userIdList
					+ "))";
			sql += " GROUP BY pml_documentsend_log.documentsendid ";
			sql += ") AS pml_send_log, pml_documentsend_log log";
			sql += " WHERE cvsend.documentsendid = cvsendwf.documentsendid";
			sql += " AND cvsendwf.processid in (";

			for (Long processId : listProcessId) {
				sql += processId + ",";
			}

			sql += "0) ";

			sql += " AND cvsend.documentsendid = ad.documentsendid ";
			sql += " AND cvden.documentreceiptid = ad.documentreceiptid ";
			sql += " AND pml_send_log.documentsendid = log.documentsendid ";
			sql += " AND pml_send_log.tran = log.transition_ ";
			sql += " AND log.documentsendid = cvsendwf.documentsendid";
			sql += " AND cvsend.datecreated + cvden.processtime + songaynghile(cvsend.datecreated, cvden.processtime) < '"
					+ currentDate + "'";

			sql += " AND log.dateprocess IS NULL ";
			sql += " AND ( '" + fromDate
					+ "' <= log.senddatebefore AND log.senddatebefore <= '"
					+ toDate + "' )";

			if (0 != loaiVB) {
				sql = sql
						.replace(
								") AS pml_send_log, pml_documentsend_log log, pml_edm_documentreceipt cvden, pml_edm_answerdetail ad",
								") AS pml_send_log, pml_documentsend_log log, pml_edm_documentreceipt cvden, pml_edm_answerdetail ad, pml_edm_documenttype dt");
				sql += " AND cvsend.documenttypeid = dt.documenttypeid";
				sql += " AND dt.documenttypeid = " + loaiVB;
			}

			if (!"".equals(donViSoanThao)) {
				sql = sql
						.replace(
								") AS pml_send_log, pml_documentsend_log log, pml_edm_documentreceipt cvden, pml_edm_answerdetail ad",
								") AS pml_send_log, pml_documentsend_log log, pml_edm_documentreceipt cvden, pml_edm_answerdetail ad, pml_user ");
				sql += " AND cvsend.editorid = pml_user.userid";
				sql += " AND pml_user.departmentsid = '" + donViSoanThao + "' ";
			}

			if (!"".equals(soKyHieu)) {
				sql += " AND lower(cvsend.documentreference) LIKE lower('%"
						+ soKyHieu + "%')";
			}

			if (!"".equals(nguoiKy)) {
				sql += " AND lower(cvsend.signername) LIKE lower('%" + nguoiKy
						+ "%') ";
			}

			if (!"".equals(trichYeu)) {
				sql += "AND lower(cvsend.briefcontent) LIKE lower('%"
						+ trichYeu + "%') ";
			}

			if (!"".equals(coQuanNhan)) {
				sql += " AND lower(cvsend.receivingplace) LIKE lower('%"
						+ coQuanNhan + " %')";
			}
			SQLQuery q = session.createSQLQuery(sql);
			q.addScalar(COUNT_COLUMN_NAME, Type.LONG);

			Iterator<Long> iter = q.list().iterator();
			if (iter.hasNext()) {
				Long count = iter.next();
				if (count != null) {
					return count.intValue();
				}
			}
			return 0;
		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}

	public List<PmlEdmDocumentSend> findByDocumentSend_Users_Status_DangXuLy(
			List<Long> userIds, long statusId, long loaiVB, String soKyHieu,
			String donViSoanThao, String nguoiKy, String trichYeu,
			String coQuanNhan, String tuNgay, String denNgay, int start,
			int end, OrderByComparator obc) throws Exception {
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
		} catch (ParseException e) {
		}

		String userIdList = "";
		for (int i = 0; i < userIds.size(); i++) {
			if (i != userIds.size() - 1) {
				userIdList += userIds.get(i) + ", ";
			}
			userIdList += userIds.get(i);
		}

		DocumentSendLiferayWorkflowService workflowService = new DocumentSendLiferayWorkflowService();
		List<Long> listProcessId = workflowService
				.getListProcessInstanceByStatusId(userIds, statusId);
		Session session = null;

		try {
			session = openSession();

			String sql = " SELECT cvsend.*  ";
			sql += " FROM pml_edm_documentsend cvsend, pml_documentsend_wf cvsendwf,";
			sql += " (SELECT  DISTINCT (pml_documentsend_log.documentsendid), MAX  (pml_documentsend_log.transition_) AS tran ";
			sql += " FROM pml_documentsend_log  ";
			sql += " WHERE ( pml_documentsend_log.processer IN (" + userIdList
					+ "))";
			sql += " GROUP BY pml_documentsend_log.documentsendid ";
			sql += ") AS pml_send_log, pml_documentsend_log log";
			sql += " WHERE cvsend.documentsendid = cvsendwf.documentsendid ";

			sql += " AND cvsendwf.processid in (";

			for (Long processId : listProcessId) {
				sql += processId + ",";
			}

			sql += "0)";

			sql += " AND pml_send_log.documentsendid = log.documentsendid ";
			sql += " AND ( pml_send_log.tran = log.transition_ ) ";
			sql += " AND log.documentsendid = cvsendwf.documentsendid";
			sql += " AND log.dateprocess IS NULL ";
			sql += " AND (log.senddatebefore IS NULL OR (log.senddatebefore IS NOT NULL AND( '"
					+ fromDate
					+ "' <= log.senddatebefore AND log.senddatebefore <= '"
					+ toDate + "' )))";

			if (0 != loaiVB) {
				sql = sql
						.replace(") AS pml_send_log, pml_documentsend_log log",
								") AS pml_send_log, pml_documentsend_log log, pml_edm_documenttype dt");
				sql += " AND cvsend.documenttypeid = dt.documenttypeid";
				sql += " AND dt.documenttypeid = " + loaiVB;
			}

			if (!"".equals(donViSoanThao)) {
				sql = sql
						.replace(") AS pml_send_log, pml_documentsend_log log",
								") AS pml_send_log, pml_documentsend_log log, pml_user ");
				sql += " AND cvsend.editorid = pml_user.userid";
				sql += " AND pml_user.departmentsid = '" + donViSoanThao + "' ";
			}

			if (!"".equals(soKyHieu)) {
				sql += " AND lower(cvsend.documentreference) LIKE lower('%"
						+ soKyHieu + "%')";
			}

			if (!"".equals(nguoiKy)) {
				sql += " AND lower(cvsend.signername) LIKE lower('%" + nguoiKy
						+ "%') ";
			}

			if (!"".equals(trichYeu)) {
				sql += "AND lower(cvsend.briefcontent) LIKE lower('%"
						+ trichYeu + "%') ";
			}

			if (!"".equals(coQuanNhan)) {
				sql += " AND lower(cvsend.receivingplace) LIKE lower('%"
						+ coQuanNhan + " %')";
			}

			sql = CustomSQLUtil.replaceOrderBy(sql, obc);

			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("PmlEdmDocumentSend", PmlEdmDocumentSendImpl.class);

			return (List<PmlEdmDocumentSend>) QueryUtil.list(q, getDialect(),
					start, end);
		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}

	public int countByDocumentSend_Users_Status_DangXuLy(List<Long> userIds,
			long statusId, long loaiVB, String soKyHieu, String donViSoanThao,
			String nguoiKy, String trichYeu, String coQuanNhan, String tuNgay,
			String denNgay) throws Exception {
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
		} catch (ParseException e) {
		}

		String userIdList = "";
		for (int i = 0; i < userIds.size(); i++) {
			if (i != userIds.size() - 1) {
				userIdList += userIds.get(i) + ", ";
			}
			userIdList += userIds.get(i);
		}

		Session session = null;

		try {
			session = openSession();

			DocumentSendLiferayWorkflowService workflowService = new DocumentSendLiferayWorkflowService();
			List<Long> listProcessId = workflowService
					.getListProcessInstanceByStatusId(userIds, statusId);

			String sql = " SELECT COUNT(*) AS COUNT_VALUE";
			sql += " FROM pml_edm_documentsend cvsend, pml_documentsend_wf cvsendwf,";
			sql += " (SELECT  DISTINCT (pml_documentsend_log.documentsendid), MAX  (pml_documentsend_log.transition_) AS tran ";
			sql += " FROM pml_documentsend_log  ";
			sql += " WHERE ( pml_documentsend_log.processer IN (" + userIdList
					+ "))";
			sql += " GROUP BY pml_documentsend_log.documentsendid ";
			sql += ") AS pml_send_log, pml_documentsend_log log";
			sql += " WHERE cvsend.documentsendid = cvsendwf.documentsendid ";

			sql += "AND cvsendwf.processid in (";

			for (Long processId : listProcessId) {
				sql += processId + ",";
			}

			sql += "0)";

			sql += " AND pml_send_log.documentsendid = log.documentsendid ";
			sql += " AND ( pml_send_log.tran = log.transition_ ) ";
			sql += " AND log.documentsendid = cvsendwf.documentsendid";
			sql += " AND log.dateprocess IS NULL ";
			sql += " AND (log.senddatebefore IS NULL OR (log.senddatebefore IS NOT NULL AND( '"
					+ fromDate
					+ "' <= log.senddatebefore AND log.senddatebefore <= '"
					+ toDate + "' )))";

			if (0 != loaiVB) {
				sql = sql
						.replace(") AS pml_send_log, pml_documentsend_log log",
								") AS pml_send_log, pml_documentsend_log log, pml_edm_documenttype dt");
				sql += " AND cvsend.documenttypeid = dt.documenttypeid";
				sql += " AND dt.documenttypeid = " + loaiVB;
			}

			if (!"".equals(donViSoanThao)) {
				sql = sql
						.replace(") AS pml_send_log, pml_documentsend_log log",
								") AS pml_send_log, pml_documentsend_log log, pml_user ");
				sql += " AND cvsend.editorid = pml_user.userid";
				sql += " AND pml_user.departmentsid = '" + donViSoanThao + "' ";
			}

			if (!"".equals(soKyHieu)) {
				sql += " AND lower(cvsend.documentreference) LIKE lower('%"
						+ soKyHieu + "%')";
			}

			if (!"".equals(nguoiKy)) {
				sql += " AND lower(cvsend.signername) LIKE lower('%" + nguoiKy
						+ "%') ";
			}

			if (!"".equals(trichYeu)) {
				sql += "AND lower(cvsend.briefcontent) LIKE lower('%"
						+ trichYeu + "%') ";
			}

			if (!"".equals(coQuanNhan)) {
				sql += " AND lower(cvsend.receivingplace) LIKE lower('%"
						+ coQuanNhan + "%')";
			}

			SQLQuery q = session.createSQLQuery(sql);
			q.addScalar(COUNT_COLUMN_NAME, Type.LONG);

			Iterator<Long> iter = q.list().iterator();
			if (iter.hasNext()) {
				Long count = iter.next();
				if (count != null) {
					return count.intValue();
				}
			}
			return 0;
		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}

	/**
	 * YENLT UPDATE XU LY THAY 20101028
	 */
	public List<PmlEdmDocumentSend> findByDocumentSend_Users(
			List<Long> userIds, long loaiVB, String donViSoanThao,
			String nguoiKy, String trichYeu, String coQuanNhan, String tuNgay,
			String denNgay, int start, int end, OrderByComparator obc)
			throws Exception {
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
		} catch (ParseException e) {
		}

		String userIdList = "";
		for (int i = 0; i < userIds.size(); i++) {
			if (i != userIds.size() - 1) {
				userIdList += userIds.get(i) + ", ";
			}
			userIdList += userIds.get(i);
		}

		Session session = null;

		try {

			session = openSession();

			DocumentSendLiferayWorkflowService workflowService = new DocumentSendLiferayWorkflowService();
			List<Long> listProcessId = workflowService
					.getProcessInstances(userIds);

			String sql = "SELECT DISTINCT(cvsend.*) ";
			sql += " FROM pml_edm_documentsend cvsend, pml_documentsend_wf cvsendwf, ";
			sql += " (SELECT  DISTINCT (pml_documentsend_log.documentsendid), MAX  (pml_documentsend_log.transition_) AS tran ";
			sql += " FROM pml_documentsend_log  ";
			sql += " WHERE ( pml_documentsend_log.processer IN (" + userIdList
					+ "))";
			sql += " GROUP BY pml_documentsend_log.documentsendid ";
			sql += ") AS pml_send_log, pml_documentsend_log log";

			if (0 != loaiVB) {
				sql += ", pml_edm_documenttype dt ";
			}
			if (!"".equals(donViSoanThao)) {
				sql += ", pml_user ";
			}

			sql += " WHERE cvsend.documentsendid = cvsendwf.documentsendid ";

			sql += " AND cvsendwf.processid in (";

			for (Long processId : listProcessId) {
				sql += processId + ",";
			}

			sql += "0)";

			sql += " AND log.documentsendid = cvsendwf.documentsendid";
			sql += " AND pml_send_log.documentsendid = log.documentsendid ";
			sql += " AND ( pml_send_log.tran = log.transition_ ) ";
			sql += " AND log.dateprocess IS NULL ";
			sql += " AND (log.senddatebefore IS NULL OR (log.senddatebefore IS NOT NULL AND( '"
					+ fromDate
					+ "' <= log.senddatebefore AND log.senddatebefore <= '"
					+ toDate + "' )))";

			if (0 != loaiVB) {
				sql += " AND cvsend.documenttypeid = dt.documenttypeid ";
				sql += " AND dt.documenttypeid = " + loaiVB;
			}

			if (!"".equals(donViSoanThao)) {
				sql += " AND cvsend.editorid = pml_user.userid";
				sql += " AND pml_user.departmentsid = '" + donViSoanThao + "' ";
			}

			if (!"".equals(nguoiKy)) {
				sql += " AND lower(cvsend.signername) LIKE lower('%" + nguoiKy
						+ "%') ";
			}

			if (!"".equals(trichYeu)) {
				sql += "AND lower(cvsend.briefcontent) LIKE lower('%"
						+ trichYeu + "%') ";
			}

			if (!"".equals(coQuanNhan)) {
				sql += " AND lower(cvsend.receivingplace) LIKE lower('%"
						+ coQuanNhan + "%')";
			}

			sql = CustomSQLUtil.replaceOrderBy(sql, obc);

			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("PmlEdmDocumentSend", PmlEdmDocumentSendImpl.class);

			return (List<PmlEdmDocumentSend>) QueryUtil.list(q, getDialect(),
					start, end);
		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}

	public int countByDocumentSend_Users(List<Long> userIds, long loaiVB,
			String donViSoanThao, String nguoiKy, String trichYeu,
			String coQuanNhan, String tuNgay, String denNgay) throws Exception {
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
		} catch (ParseException e) {
		}

		String userIdList = "";
		for (int i = 0; i < userIds.size(); i++) {
			if (i != userIds.size() - 1) {
				userIdList += userIds.get(i) + ", ";
			}
			userIdList += userIds.get(i);
		}

		Session session = null;

		try {

			session = openSession();

			DocumentSendLiferayWorkflowService workflowService = new DocumentSendLiferayWorkflowService();
			List<Long> listProcessId = workflowService
					.getProcessInstances(userIds);

			String sql = "SELECT COUNT(*) AS COUNT_VALUE";
			sql += " FROM pml_edm_documentsend cvsend, pml_documentsend_wf cvsendwf, ";
			sql += " (SELECT  DISTINCT (pml_documentsend_log.documentsendid), MAX  (pml_documentsend_log.transition_) AS tran ";
			sql += " FROM pml_documentsend_log  ";
			sql += " WHERE ( pml_documentsend_log.processer IN (" + userIdList
					+ "))";
			sql += " GROUP BY pml_documentsend_log.documentsendid ";
			sql += ") AS pml_send_log, pml_documentsend_log log";

			if (0 != loaiVB) {
				sql += ", pml_edm_documenttype dt ";
			}
			if (!"".equals(donViSoanThao)) {
				sql += ", pml_user ";
			}

			sql += " WHERE cvsend.documentsendid = cvsendwf.documentsendid ";

			sql += " AND cvsendwf.processid in (";

			for (Long processId : listProcessId) {
				sql += processId + ",";
			}

			sql += "0)";

			sql += " AND log.documentsendid = cvsendwf.documentsendid";
			sql += " AND pml_send_log.documentsendid = log.documentsendid ";
			sql += " AND ( pml_send_log.tran = log.transition_ ) ";
			sql += " AND log.dateprocess IS NULL ";
			sql += " AND (log.senddatebefore IS NULL OR (log.senddatebefore IS NOT NULL AND( '"
					+ fromDate
					+ "' <= log.senddatebefore AND log.senddatebefore <= '"
					+ toDate + "' )))";

			if (0 != loaiVB) {
				sql += " AND cvsend.documenttypeid = dt.documenttypeid ";
				sql += " AND dt.documenttypeid = " + loaiVB;
			}

			if (!"".equals(donViSoanThao)) {
				sql += " AND cvsend.editorid = pml_user.userid";
				sql += " AND pml_user.departmentsid = '" + donViSoanThao + "' ";
			}

			if (!"".equals(nguoiKy)) {
				sql += " AND lower(cvsend.signername) LIKE lower('%" + nguoiKy
						+ "%') ";
			}

			if (!"".equals(trichYeu)) {
				sql += "AND lower(cvsend.briefcontent) LIKE lower('%"
						+ trichYeu + "%') ";
			}

			if (!"".equals(coQuanNhan)) {
				sql += " AND lower(cvsend.receivingplace) LIKE lower('%"
						+ coQuanNhan + "%')";
			}

			SQLQuery q = session.createSQLQuery(sql);
			q.addScalar(COUNT_COLUMN_NAME, Type.LONG);

			Iterator<Long> iter = q.list().iterator();
			if (iter.hasNext()) {
				Long count = iter.next();
				if (count != null) {
					return count.intValue();
				}
			}
			return 0;
		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}

	/**
	 * phmphuc them cac phuong thuc lay ds log tuong tu nhu documentsend muc
	 * dich lay noi dung yeu cau xu ly cho tung documentsend 12/11/2010
	 */
	// chuyen vien dang xu ly
	public List<PmlDocumentSendLog> findByDocumentSendLog_Users_Status_DangXuLy(
			List<Long> userIds, long statusId, long soVanBan, String soKyHieu,
			String donViSoanThao, String nguoiKy, String trichYeu,
			String coQuanNhan, String tuNgay, String denNgay, int start,
			int end, OrderByComparator obc) throws Exception {

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
		} catch (ParseException e) {
		}

		String userIdList = "";
		for (int i = 0; i < userIds.size(); i++) {
			if (i != userIds.size() - 1) {
				userIdList += userIds.get(i) + ", ";
			}
			userIdList += userIds.get(i);
		}

		DocumentSendLiferayWorkflowService workflowService = new DocumentSendLiferayWorkflowService();
		List<Long> listProcessId = workflowService
				.getListProcessInstanceByStatusId(userIds, statusId);
		Session session = null;

		try {
			session = openSession();

			String sql = " SELECT log.*, cvsend.editorid ";
			sql += " FROM pml_edm_documentsend cvsend, pml_documentsend_wf cvsendwf,";
			sql += " (SELECT  DISTINCT (documentsendid), MAX (transition_) AS tran ";
			sql += " FROM pml_documentsend_log  ";
			sql += " WHERE (receiver IN (" + userIdList + ") OR (transition_ = 1 AND processer IN (" + userIdList + ")))";
			sql += " GROUP BY pml_documentsend_log.documentsendid ";
			sql += ") AS pml_send_log, pml_documentsend_log log";
			sql += " WHERE cvsend.documentsendid = cvsendwf.documentsendid ";

			sql += " AND cvsendwf.processid in (";

			for (Long processId : listProcessId) {
				sql += processId + ",";
			}

			sql += "0)";

			sql += " AND pml_send_log.documentsendid = log.documentsendid ";
			sql += " AND ( pml_send_log.tran = log.transition_ ) ";
			sql += " AND log.documentsendid = cvsendwf.documentsendid";
			sql += " AND cvsend.datecreated IS NOT NULL ";
			sql += " AND('" + fromDate
					+ "' <= cvsend.datecreated AND cvsend.datecreated <= '" + toDate
					+ "' )";

			if (0 != soVanBan) {
				sql += " AND cvsend.documentrecordtypeid = " + soVanBan;
			}

			if (!"".equals(donViSoanThao)) {
				sql = sql
						.replace(") AS pml_send_log, pml_documentsend_log log",
								") AS pml_send_log, pml_documentsend_log log, pml_user ");
				sql += " AND cvsend.editorid = pml_user.userid";
				sql += " AND pml_user.departmentsid = '" + donViSoanThao + "' ";
			}

			if (!"".equals(soKyHieu)) {
				sql += " AND lower(cvsend.documentreference) LIKE lower('%"
						+ soKyHieu + "%')";
			}

			if (!"".equals(nguoiKy)) {
				sql += " AND lower(cvsend.signername) LIKE lower('%" + nguoiKy
						+ "%') ";
			}

			if (!"".equals(trichYeu)) {
				sql += "AND lower(cvsend.briefcontent) LIKE lower('%"
						+ trichYeu + "%') ";
			}

			if (!"".equals(coQuanNhan)) {
				sql += " AND lower(cvsend.receivingplace) LIKE lower('%"
						+ coQuanNhan + " %')";
			}

			sql = CustomSQLUtil.replaceOrderBy(sql, obc);
			
			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("PmlDocumentSendLog", PmlDocumentSendLogImpl.class);

			return (List<PmlDocumentSendLog>) QueryUtil.list(q, getDialect(),
					start, end);
		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}

	// chuyen vien xu ly tre han
	public List<PmlDocumentSendLog> findByDocumentSendLog_Users_Status_DangXuLy_TreHan(
			List<Long> userIds, long statusId, long soVanBan, String soKyHieu,
			String donViSoanThao, String nguoiKy, String trichYeu,
			String coQuanNhan, String tuNgay, String denNgay, int start,
			int end, OrderByComparator obc) throws Exception {
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
		} catch (ParseException e) {
		}

		String userIdList = "";
		for (int i = 0; i < userIds.size(); i++) {
			if (i != userIds.size() - 1) {
				userIdList += userIds.get(i) + ", ";
			}
			userIdList += userIds.get(i);
		}

		DocumentSendLiferayWorkflowService workflowService = new DocumentSendLiferayWorkflowService();
		List<Long> listProcessId = workflowService
				.getListProcessInstanceByStatusId(userIds, statusId);

		// Lay ngay hien tai
		String currentDate = new SimpleDateFormat("yyyy-MM-dd")
				.format(new Date());
		Session session = null;

		try {
			session = openSession();

			String sql = " SELECT log.*, cvsend.editorid ";
			sql += " FROM pml_edm_documentsend cvsend, pml_documentsend_wf cvsendwf, pml_edm_documentreceipt cvden, pml_edm_answerdetail ad,";
			sql += " (SELECT  DISTINCT (documentsendid), MAX (transition_) AS tran ";
			sql += " FROM pml_documentsend_log  ";
			sql += " WHERE (receiver IN (" + userIdList + ") OR (transition_ = 1 AND processer IN (" + userIdList + ")))";
			sql += " GROUP BY pml_documentsend_log.documentsendid ";
			sql += ") AS pml_send_log, pml_documentsend_log log";
			sql += " WHERE cvsend.documentsendid = cvsendwf.documentsendid";
			sql += " AND cvsendwf.processid in (";

			for (Long processId : listProcessId) {
				sql += processId + ",";
			}

			sql += "0) ";

			sql += " AND cvsend.documentsendid = ad.documentsendid ";
			sql += " AND cvden.documentreceiptid = ad.documentreceiptid ";
			sql += " AND pml_send_log.documentsendid = log.documentsendid ";
			sql += " AND pml_send_log.tran = log.transition_ ";
			sql += " AND log.documentsendid = cvsendwf.documentsendid";
			sql += " AND cvsend.datecreated + cvden.processtime + songaynghile(cvsend.datecreated, cvden.processtime) < '"
					+ currentDate + "'";

			sql += " AND cvsend.datecreated IS NOT NULL ";
			sql += " AND ( '" + fromDate
					+ "' <= cvsend.datecreated AND cvsend.datecreated <= '" + toDate
					+ "' )";

			if (0 != soVanBan) {
				sql += " AND cvsend.documentrecordtypeid = " + soVanBan;
			}

			if (!"".equals(donViSoanThao)) {
				sql = sql
						.replace(
								") AS pml_send_log, pml_documentsend_log log, pml_edm_documentreceipt cvden, pml_edm_answerdetail ad",
								") AS pml_send_log, pml_documentsend_log log, pml_edm_documentreceipt cvden, pml_edm_answerdetail ad, pml_user ");
				sql += " AND cvsend.editorid = pml_user.userid";
				sql += " AND pml_user.departmentsid = '" + donViSoanThao + "' ";
			}

			if (!"".equals(soKyHieu)) {
				sql += " AND lower(cvsend.documentreference) LIKE lower('%"
						+ soKyHieu + "%')";
			}

			if (!"".equals(nguoiKy)) {
				sql += " AND lower(cvsend.signername) LIKE lower('%" + nguoiKy
						+ "%') ";
			}

			if (!"".equals(trichYeu)) {
				sql += "AND lower(cvsend.briefcontent) LIKE lower('%"
						+ trichYeu + "%') ";
			}

			if (!"".equals(coQuanNhan)) {
				sql += " AND lower(cvsend.receivingplace) LIKE lower('%"
						+ coQuanNhan + " %')";
			}

			sql = CustomSQLUtil.replaceOrderBy(sql, obc);

			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("PmlDocumentSendLog", PmlDocumentSendLogImpl.class);

			return (List<PmlDocumentSendLog>) QueryUtil.list(q, getDialect(),
					start, end);
		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}

	// van thu xu ly thay
	public List<PmlDocumentSendLog> findByDocumentSendLog_Users(
			List<Long> userIds, long loaiVB, String donViSoanThao,
			String nguoiKy, String trichYeu, String coQuanNhan, String tuNgay,
			String denNgay, int start, int end, OrderByComparator obc)
			throws Exception {

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
		} catch (ParseException e) {
		}

		String userIdList = "";
		for (int i = 0; i < userIds.size(); i++) {
			if (i != userIds.size() - 1) {
				userIdList += userIds.get(i) + ", ";
			}
			userIdList += userIds.get(i);
		}

		Session session = null;

		try {
			session = openSession();

			DocumentSendLiferayWorkflowService workflowService = new DocumentSendLiferayWorkflowService();
			List<Long> listProcessId = workflowService
					.getProcessInstances(userIds);

			String sql = " SELECT log.*, cvsend.editorid ";
			sql += " FROM pml_edm_documentsend cvsend, pml_documentsend_wf cvsendwf, ";
			sql += " (SELECT  DISTINCT (pml_documentsend_log.documentsendid), MAX  (pml_documentsend_log.transition_) AS tran ";
			sql += " FROM pml_documentsend_log  ";
			sql += " WHERE ( pml_documentsend_log.receiver IN (" + userIdList
					+ "))";
			sql += " GROUP BY pml_documentsend_log.documentsendid ";
			sql += ") AS pml_send_log, pml_documentsend_log log";

			if (0 != loaiVB) {
				sql += ", pml_edm_documenttype dt ";
			}
			if (!"".equals(donViSoanThao)) {
				sql += ", pml_user ";
			}

			sql += " WHERE cvsend.documentsendid = cvsendwf.documentsendid ";

			sql += " AND cvsendwf.processid in (";

			for (Long processId : listProcessId) {
				sql += processId + ",";
			}

			sql += "0)";

			sql += " AND log.documentsendid = cvsendwf.documentsendid";
			sql += " AND pml_send_log.documentsendid = log.documentsendid ";
			sql += " AND ( pml_send_log.tran = log.transition_ ) ";
			sql += " AND log.dateprocess IS NOT NULL ";
			sql += " AND( '" + fromDate
					+ "' <= log.dateprocess AND log.dateprocess <= '" + toDate
					+ "' )";

			if (0 != loaiVB) {
				sql += " AND cvsend.documenttypeid = dt.documenttypeid ";
				sql += " AND dt.documenttypeid = " + loaiVB;
			}

			if (!"".equals(donViSoanThao)) {
				sql += " AND cvsend.editorid = pml_user.userid";
				sql += " AND pml_user.departmentsid = '" + donViSoanThao + "' ";
			}

			if (!"".equals(nguoiKy)) {
				sql += " AND lower(cvsend.signername) LIKE lower('%" + nguoiKy
						+ "%') ";
			}

			if (!"".equals(trichYeu)) {
				sql += "AND lower(cvsend.briefcontent) LIKE lower('%"
						+ trichYeu + "%') ";
			}

			if (!"".equals(coQuanNhan)) {
				sql += " AND lower(cvsend.receivingplace) LIKE lower('%"
						+ coQuanNhan + "%')";
			}

			sql = CustomSQLUtil.replaceOrderBy(sql, obc);

			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("PmlDocumentSendLog", PmlDocumentSendLogImpl.class);

			return (List<PmlDocumentSendLog>) QueryUtil.list(q, getDialect(),
					start, end);
		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}

	// phmphuc update 27/12/2010 - lay so phat hanh vb di co kem theo so giam
	// doc hoac so phong ban
	public long getSoPhatHanhVBDi(long docTypeId, int issuingYear,
			boolean numOfDirector) throws SystemException {

		long retVal = 0;
		// Lay numofdocref lon nhat trong bang pml_edm_documentsend theo loai va
		// theo nam
		Session session = null;
		try {
			session = openSession();

			String sql = "SELECT MAX(numofdocref) AS COUNT_VALUE FROM pml_edm_documentsend";
			sql += " WHERE documenttypeid = " + docTypeId;
			sql += " AND date_part('year', issuingdate) = " + issuingYear;
			sql += " AND numofdirector = " + numOfDirector;
			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME, Type.LONG);

			@SuppressWarnings("unused")
			QueryPos qPos = QueryPos.getInstance(q);

			Iterator<Long> itr = q.list().iterator();

			if (itr.hasNext()) {
				Long count = itr.next();

				if (count != null) {
					retVal = count.longValue();
				}
			}
			return retVal;
		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}

	/**
	 * phmphuc update - 06/01/2011 So van ban di cua phong
	 */
	public int countByVBDi_SoVBDiCuaPhong(String soPH, int ngayPHMonth,
			int ngayPHYear, String phongST, String noiNhan, long loaiVB,
			String tenNguoiKy, long nguoiST, String trichYeu, String vanBanPH)
			throws SystemException {

		Session session = null;

		try {
			session = openSession();

			String sql = "SELECT COUNT(DISTINCT(doc.documentsendid)) AS COUNT_VALUE ";
			sql += "FROM pml_edm_documentsend doc ";
			// Neu co chon phong thi tinh dua vao bang pml_user
			if ((phongST != null) && (phongST.trim().length() > 0)) {
				sql += "INNER JOIN pml_user usr on doc.editorid = usr.userid ";
			}

			// Mac dinh them dieu kien loc
			sql += "WHERE 1 = 1 ";
			// So phat hanh
			if ((soPH != null) && (soPH.trim().length() > 0)) {
				sql += "AND lower(doc.documentreference) LIKE '" + soPH + "' ";
			}
			// Cac thanh phan cua ngay phat hanh
			if (ngayPHYear > 0) {
				sql += "AND DATE_PART('year', doc.issuingdate) = " + ngayPHYear
						+ " ";
				// Thang
				if ((ngayPHMonth > 0) && (ngayPHMonth < 13)) {
					sql += "AND DATE_PART('month', doc.issuingdate) = "
							+ ngayPHMonth + " ";
				}
			} // end if
				// Phong soan thao
			if ((phongST != null) && (phongST.trim().length() > 0)) {
				sql += "AND usr.departmentsid = '" + phongST + "' ";
			}
			// Noi nhan
			if ((noiNhan != null) && (noiNhan.trim().length() > 0)) {
				sql += "AND lower(doc.receivingplace) like '" + noiNhan + "' ";
			}
			// Loai van ban
			if (loaiVB > 0) {
				//sql += "AND doc.documenttypeid = " + loaiVB + " ";
				sql += "AND doc.documentrecordtypeid = " + loaiVB + " ";
			}
			// Ten nguoi ky
			if ((tenNguoiKy != null) && (tenNguoiKy.trim().length() > 0)) {
				sql += "AND lower(doc.signername) LIKE '" + tenNguoiKy + "' ";
			}
			// Nguoi soan thao
			if (nguoiST > 0) {
				sql += "AND editorid = " + nguoiST + " ";
			}
			// Trich yeu
			if ((trichYeu != null) && (trichYeu.trim().length() > 0)) {
				sql += "AND lower(doc.briefcontent) LIKE '" + trichYeu + "' ";
			}
			// van ban phat hanh
			if ("daphathanh".equals(vanBanPH)) {
				sql += " AND doc.issuingdate is not null ";
			} else if ("chuaphathanh".equals(vanBanPH)) {
				sql += " AND doc.issuingdate is null ";
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

	public List<PmlEdmDocumentSend> findByVBDi_SoVBDiCuaPhong(String soPH,
			int ngayPHMonth, int ngayPHYear, String phongST, String noiNhan,
			long loaiVB, String tenNguoiKy, long nguoiST, String trichYeu,
			String vanBanPH, int start, int end, OrderByComparator obc)
			throws SystemException {

		Session session = null;

		try {
			session = openSession();

			String sql = "SELECT DISTINCT(doc.*) ";
			sql += "FROM pml_edm_documentsend doc ";
			// Neu co chon phong thi tinh dua vao bang pml_user
			if ((phongST != null) && (phongST.trim().length() > 0)) {
				sql += "INNER JOIN pml_user usr on doc.editorid = usr.userid ";
			}

			// Mac dinh them dieu kien loc
			sql += "WHERE 1 = 1 ";
			// So phat hanh
			if ((soPH != null) && (soPH.trim().length() > 0)) {
				sql += "AND lower(doc.documentreference) LIKE '" + soPH + "' ";
			}
			// Cac thanh phan cua ngay phat hanh
			if (ngayPHYear > 0) {
				sql += "AND DATE_PART('year', doc.issuingdate) = " + ngayPHYear
						+ " ";
				// Thang
				if ((ngayPHMonth > 0) && (ngayPHMonth < 13)) {
					sql += "AND DATE_PART('month', doc.issuingdate) = "
							+ ngayPHMonth + " ";
				}
			} // end if
				// Phong soan thao
			if ((phongST != null) && (phongST.trim().length() > 0)) {
				sql += "AND usr.departmentsid = '" + phongST + "' ";
			}
			// Noi nhan
			if ((noiNhan != null) && (noiNhan.trim().length() > 0)) {
				sql += "AND lower(doc.receivingplace) like '" + noiNhan + "' ";
			}
			// Loai van ban
			if (loaiVB > 0) {
				//sql += "AND doc.documenttypeid = " + loaiVB + " ";
				sql += "AND doc.documentrecordtypeid = " + loaiVB + " ";
			}
			// Ten nguoi ky
			if ((tenNguoiKy != null) && (tenNguoiKy.trim().length() > 0)) {
				sql += "AND lower(doc.signername) LIKE '" + tenNguoiKy + "' ";
			}
			// Nguoi soan thao
			if (nguoiST > 0) {
				sql += "AND editorid = " + nguoiST + " ";
			}
			// Trich yeu
			if ((trichYeu != null) && (trichYeu.trim().length() > 0)) {
				sql += "AND lower(doc.briefcontent) LIKE '" + trichYeu + "' ";
			}
			// van ban phat hanh
			if ("daphathanh".equals(vanBanPH)) {
				sql += " AND doc.issuingdate is not null ";
			} else if ("chuaphathanh".equals(vanBanPH)) {
				sql += " AND doc.issuingdate is null ";
			}

			sql = CustomSQLUtil.replaceOrderBy(sql, obc);

			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("PmlEdmDocumentSend", PmlEdmDocumentSendImpl.class);

			return (List<PmlEdmDocumentSend>) QueryUtil.list(q, getDialect(),
					start, end);
		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}

	// end phmphuc 06/01/2011

	// phmphuc add 07/01/2011 - ham kiem tra so va ky hieu cho vb phat hanh theo
	// nam co ton tai trong csdl chua
	public int kiemTraSoVaKyHieuVBPhatHanh(String soVBPhatHanh,
			int issuingYear, long documentSendId) throws SystemException {

		Session session = null;
		try {
			session = openSession();

			String sql = "SELECT COUNT(*) AS COUNT_VALUE";
			sql += " FROM pml_edm_documentsend WHERE";
			if (documentSendId != 0) {
				sql += " documentsendid != " + documentSendId + " AND";
			}
			sql += " (ltrim(documentreference) = '" + soVBPhatHanh.trim()
					+ "' " + " or rtrim(documentreference) = '"
					+ soVBPhatHanh.trim() + "') ";
			sql += " AND date_part('year', issuingdate) = " + issuingYear;

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

	// end phmphuc 07/01/2011

	// TriLTM
	public List<PmlEdmDocumentSend> findBy_R_B_F_T(String documentReference,
			String briefContent, Date fromDate, Date toDate,
			boolean andOperator, int start, int end, OrderByComparator obc)
			throws SystemException {

		return findBy_R_B_F_T(new String[] { documentReference },
				new String[] { briefContent }, fromDate, toDate, andOperator,
				start, end, obc);
	}

	private List<PmlEdmDocumentSend> findBy_R_B_F_T(
			String[] documentReferences, String[] briefContents, Date fromDate,
			Date toDate, boolean andOperator, int start, int end,
			OrderByComparator obc) throws SystemException {
		documentReferences = CustomSQLUtil.keywords(documentReferences);
		briefContents = CustomSQLUtil.keywords(briefContents);

		Session session = null;

		try {
			session = openSession();

			String sql = CustomSQLUtil.get(FIND_BY_R_B_F_T);

			if (Validator.isNull(fromDate)) {
				sql = StringUtil.replace(sql, "(datecreated >= ?) AND",
						StringPool.BLANK);
			}

			if (Validator.isNull(toDate)) {
				sql = StringUtil.replace(sql, "(datecreated <= ?) AND",
						StringPool.BLANK);
			}

			sql = CustomSQLUtil.replaceKeywords(sql,
					"lower(documentreference)", StringPool.LIKE, false,
					documentReferences);
			sql = CustomSQLUtil.replaceKeywords(sql, "lower(briefcontent)",
					StringPool.LIKE, true, briefContents);

			sql = CustomSQLUtil.replaceAndOperator(sql, andOperator);
			sql = CustomSQLUtil.replaceOrderBy(sql, obc);

			SQLQuery q = session.createSQLQuery(sql);

			q.addEntity("pml_edm_documentsend", PmlEdmDocumentSendImpl.class);

			QueryPos qpos = QueryPos.getInstance(q);

			if (Validator.isNotNull(fromDate)) {
				Timestamp fromDate_TS = CalendarUtil.getTimestamp(fromDate);
				qpos.add(fromDate_TS);
			}

			if (Validator.isNotNull(toDate)) {
				Timestamp toDate_TS = CalendarUtil.getTimestamp(toDate);
				qpos.add(toDate_TS);
			}

			qpos.add(documentReferences, 2);
			qpos.add(briefContents, 2);

			return (List<PmlEdmDocumentSend>) QueryUtil.list(q, getDialect(),
					start, end);

		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}

	public int countBy_R_B_F_T(String documentReference, String briefContent,
			Date fromDate, Date toDate, boolean andOperator) {

		return countBy_R_B_F_T(new String[] { documentReference },
				new String[] { briefContent }, fromDate, toDate, andOperator);
	}

	private int countBy_R_B_F_T(String[] documentReferences,
			String[] briefContents, Date fromDate, Date toDate,
			boolean andOperator) {
		documentReferences = CustomSQLUtil.keywords(documentReferences);
		briefContents = CustomSQLUtil.keywords(briefContents);

		Session session = null;

		try {
			session = openSession();

			String sql = CustomSQLUtil.get(COUNT_BY_R_B_F_T);

			if (Validator.isNull(fromDate)) {
				sql = StringUtil.replace(sql, "(datecreated >= ?) AND",
						StringPool.BLANK);
			}

			if (Validator.isNull(toDate)) {
				sql = StringUtil.replace(sql, "(datecreated <= ?) AND",
						StringPool.BLANK);
			}

			sql = CustomSQLUtil.replaceKeywords(sql,
					"lower(documentreference)", StringPool.LIKE, false,
					documentReferences);
			sql = CustomSQLUtil.replaceKeywords(sql, "lower(briefcontent)",
					StringPool.LIKE, true, briefContents);

			sql = CustomSQLUtil.replaceAndOperator(sql, andOperator);

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME, Type.LONG);

			QueryPos qpos = QueryPos.getInstance(q);

			if (Validator.isNotNull(fromDate)) {
				Timestamp fromDate_TS = CalendarUtil.getTimestamp(fromDate);
				qpos.add(fromDate_TS);
			}

			if (Validator.isNotNull(toDate)) {
				Timestamp toDate_TS = CalendarUtil.getTimestamp(toDate);
				qpos.add(toDate_TS);
			}

			qpos.add(documentReferences, 2);
			qpos.add(briefContents, 2);

			Iterator<Long> iter = q.list().iterator();

			if (iter.hasNext()) {
				Long count = iter.next();
				if (count != null) {
					return count.intValue();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeSession(session);
		}
		return 0;
	}
	
	/* phmphuc add methods replace Loai Van Ban by So Van Ban 16/02/2011 */
	public int countByDocumentSend_Users_Status_DangXuLy1(List<Long> userIds,
			long statusId, long soVanBan, String soKyHieu, String donViSoanThao,
			String nguoiKy, String trichYeu, String coQuanNhan, String tuNgay,
			String denNgay) throws Exception {
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
		} catch (ParseException e) {
		}

		String userIdList = "";
		for (int i = 0; i < userIds.size(); i++) {
			if (i != userIds.size() - 1) {
				userIdList += userIds.get(i) + ", ";
			}
			userIdList += userIds.get(i);
		}

		Session session = null;

		try {
			session = openSession();

			DocumentSendLiferayWorkflowService workflowService = new DocumentSendLiferayWorkflowService();
			List<Long> listProcessId = workflowService
					.getListProcessInstanceByStatusId(userIds, statusId);

			String sql = " SELECT COUNT(*) AS COUNT_VALUE";
			sql += " FROM pml_edm_documentsend cvsend, pml_documentsend_wf cvsendwf,";
			sql += " (SELECT  DISTINCT (pml_documentsend_log.documentsendid), MAX  (pml_documentsend_log.transition_) AS tran ";
			sql += " FROM pml_documentsend_log  ";
			sql += " WHERE ( pml_documentsend_log.processer IN (" + userIdList
					+ "))";
			sql += " GROUP BY pml_documentsend_log.documentsendid ";
			sql += ") AS pml_send_log, pml_documentsend_log log";
			sql += " WHERE cvsend.documentsendid = cvsendwf.documentsendid ";

			sql += "AND cvsendwf.processid in (";

			for (Long processId : listProcessId) {
				sql += processId + ",";
			}

			sql += "0)";

			sql += " AND pml_send_log.documentsendid = log.documentsendid ";
			sql += " AND ( pml_send_log.tran = log.transition_ ) ";
			sql += " AND log.documentsendid = cvsendwf.documentsendid";
			sql += " AND log.dateprocess IS NULL ";
			sql += " AND (log.senddatebefore IS NULL OR (log.senddatebefore IS NOT NULL AND( '"
					+ fromDate
					+ "' <= log.senddatebefore AND log.senddatebefore <= '"
					+ toDate + "' )))";

			if (0 != soVanBan) {
				sql += " AND cvsend.documentrecordtypeid = " + soVanBan;
			}

			if (!"".equals(donViSoanThao)) {
				sql = sql
						.replace(") AS pml_send_log, pml_documentsend_log log",
								") AS pml_send_log, pml_documentsend_log log, pml_user ");
				sql += " AND cvsend.editorid = pml_user.userid";
				sql += " AND pml_user.departmentsid = '" + donViSoanThao + "' ";
			}

			if (!"".equals(soKyHieu)) {
				sql += " AND lower(cvsend.documentreference) LIKE lower('%"
						+ soKyHieu + "%')";
			}

			if (!"".equals(nguoiKy)) {
				sql += " AND lower(cvsend.signername) LIKE lower('%" + nguoiKy
						+ "%') ";
			}

			if (!"".equals(trichYeu)) {
				sql += "AND lower(cvsend.briefcontent) LIKE lower('%"
						+ trichYeu + "%') ";
			}

			if (!"".equals(coQuanNhan)) {
				sql += " AND lower(cvsend.receivingplace) LIKE lower('%"
						+ coQuanNhan + "%')";
			}

			SQLQuery q = session.createSQLQuery(sql);
			q.addScalar(COUNT_COLUMN_NAME, Type.LONG);

			Iterator<Long> iter = q.list().iterator();
			if (iter.hasNext()) {
				Long count = iter.next();
				if (count != null) {
					return count.intValue();
				}
			}
			return 0;
		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}
	
	public List<PmlEdmDocumentSend> findByDocumentSend_Users_Status_DangXuLy1(
			List<Long> userIds, long statusId, long soVanBan, String soKyHieu,
			String donViSoanThao, String nguoiKy, String trichYeu,
			String coQuanNhan, String tuNgay, String denNgay, int start,
			int end, OrderByComparator obc) throws Exception {
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
		} catch (ParseException e) {
		}

		String userIdList = "";
		for (int i = 0; i < userIds.size(); i++) {
			if (i != userIds.size() - 1) {
				userIdList += userIds.get(i) + ", ";
			}
			userIdList += userIds.get(i);
		}

		DocumentSendLiferayWorkflowService workflowService = new DocumentSendLiferayWorkflowService();
		List<Long> listProcessId = workflowService
				.getListProcessInstanceByStatusId(userIds, statusId);
		Session session = null;

		try {
			session = openSession();

			String sql = " SELECT cvsend.*  ";
			sql += " FROM pml_edm_documentsend cvsend, pml_documentsend_wf cvsendwf,";
			sql += " (SELECT  DISTINCT (pml_documentsend_log.documentsendid), MAX  (pml_documentsend_log.transition_) AS tran ";
			sql += " FROM pml_documentsend_log  ";
			sql += " WHERE ( pml_documentsend_log.processer IN (" + userIdList
					+ "))";
			sql += " GROUP BY pml_documentsend_log.documentsendid ";
			sql += ") AS pml_send_log, pml_documentsend_log log";
			sql += " WHERE cvsend.documentsendid = cvsendwf.documentsendid ";

			sql += " AND cvsendwf.processid in (";

			for (Long processId : listProcessId) {
				sql += processId + ",";
			}

			sql += "0)";

			sql += " AND pml_send_log.documentsendid = log.documentsendid ";
			sql += " AND ( pml_send_log.tran = log.transition_ ) ";
			sql += " AND log.documentsendid = cvsendwf.documentsendid";
			sql += " AND log.dateprocess IS NULL ";
			sql += " AND (log.senddatebefore IS NULL OR (log.senddatebefore IS NOT NULL AND( '"
					+ fromDate
					+ "' <= log.senddatebefore AND log.senddatebefore <= '"
					+ toDate + "' )))";

			if (0 != soVanBan) {
				sql += " AND cvsend.documentrecordtypeid = " + soVanBan;
			}

			if (!"".equals(donViSoanThao)) {
				sql = sql
						.replace(") AS pml_send_log, pml_documentsend_log log",
								") AS pml_send_log, pml_documentsend_log log, pml_user ");
				sql += " AND cvsend.editorid = pml_user.userid";
				sql += " AND pml_user.departmentsid = '" + donViSoanThao + "' ";
			}

			if (!"".equals(soKyHieu)) {
				sql += " AND lower(cvsend.documentreference) LIKE lower('%"
						+ soKyHieu + "%')";
			}

			if (!"".equals(nguoiKy)) {
				sql += " AND lower(cvsend.signername) LIKE lower('%" + nguoiKy
						+ "%') ";
			}

			if (!"".equals(trichYeu)) {
				sql += "AND lower(cvsend.briefcontent) LIKE lower('%"
						+ trichYeu + "%') ";
			}

			if (!"".equals(coQuanNhan)) {
				sql += " AND lower(cvsend.receivingplace) LIKE lower('%"
						+ coQuanNhan + " %')";
			}

			sql = CustomSQLUtil.replaceOrderBy(sql, obc);

			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("PmlEdmDocumentSend", PmlEdmDocumentSendImpl.class);

			return (List<PmlEdmDocumentSend>) QueryUtil.list(q, getDialect(),
					start, end);
		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}
	
	public int countByDocumentSend_Users_Status_DangXuLy_TreHan1(
			List<Long> userIds, long statusId, long soVanBan, String soKyHieu,
			String donViSoanThao, String nguoiKy, String trichYeu,
			String coQuanNhan, String tuNgay, String denNgay) throws Exception {
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
		} catch (ParseException e) {
		}

		String userIdList = "";
		for (int i = 0; i < userIds.size(); i++) {
			if (i != userIds.size() - 1) {
				userIdList += userIds.get(i) + ", ";
			}
			userIdList += userIds.get(i);
		}

		// Lay ngay hien tai
		String currentDate = new SimpleDateFormat("yyyy-MM-dd")
				.format(new Date());

		DocumentSendLiferayWorkflowService workflowService = new DocumentSendLiferayWorkflowService();
		List<Long> listProcessId = workflowService
				.getListProcessInstanceByStatusId(userIds, statusId);

		Session session = null;

		try {
			session = openSession();

			String sql = "SELECT COUNT(DISTINCT(cvsend.documentsendid)) AS COUNT_VALUE";
			sql += " FROM pml_edm_documentsend cvsend, pml_documentsend_wf cvsendwf, pml_edm_documentreceipt cvden, pml_edm_answerdetail ad,";
			sql += " (SELECT  DISTINCT (pml_documentsend_log.documentsendid), MAX  (pml_documentsend_log.transition_) AS tran ";
			sql += " FROM pml_documentsend_log  ";
			sql += " WHERE ( pml_documentsend_log.processer IN (" + userIdList
					+ "))";
			sql += " GROUP BY pml_documentsend_log.documentsendid ";
			sql += ") AS pml_send_log, pml_documentsend_log log";
			sql += " WHERE cvsend.documentsendid = cvsendwf.documentsendid";
			sql += " AND cvsendwf.processid in (";

			for (Long processId : listProcessId) {
				sql += processId + ",";
			}

			sql += "0) ";

			sql += " AND cvsend.documentsendid = ad.documentsendid ";
			sql += " AND cvden.documentreceiptid = ad.documentreceiptid ";
			sql += " AND pml_send_log.documentsendid = log.documentsendid ";
			sql += " AND pml_send_log.tran = log.transition_ ";
			sql += " AND log.documentsendid = cvsendwf.documentsendid";
			sql += " AND cvsend.datecreated + cvden.processtime + songaynghile(cvsend.datecreated, cvden.processtime) < '"
					+ currentDate + "'";

			sql += " AND log.dateprocess IS NULL ";
			sql += " AND ( '" + fromDate
					+ "' <= log.senddatebefore AND log.senddatebefore <= '"
					+ toDate + "' )";

			if (0 != soVanBan) {
				sql += " AND cvsend.documentrecordtypeid = " + soVanBan;
			}

			if (!"".equals(donViSoanThao)) {
				sql = sql
						.replace(
								") AS pml_send_log, pml_documentsend_log log, pml_edm_documentreceipt cvden, pml_edm_answerdetail ad",
								") AS pml_send_log, pml_documentsend_log log, pml_edm_documentreceipt cvden, pml_edm_answerdetail ad, pml_user ");
				sql += " AND cvsend.editorid = pml_user.userid";
				sql += " AND pml_user.departmentsid = '" + donViSoanThao + "' ";
			}

			if (!"".equals(soKyHieu)) {
				sql += " AND lower(cvsend.documentreference) LIKE lower('%"
						+ soKyHieu + "%')";
			}

			if (!"".equals(nguoiKy)) {
				sql += " AND lower(cvsend.signername) LIKE lower('%" + nguoiKy
						+ "%') ";
			}

			if (!"".equals(trichYeu)) {
				sql += "AND lower(cvsend.briefcontent) LIKE lower('%"
						+ trichYeu + "%') ";
			}

			if (!"".equals(coQuanNhan)) {
				sql += " AND lower(cvsend.receivingplace) LIKE lower('%"
						+ coQuanNhan + " %')";
			}
			SQLQuery q = session.createSQLQuery(sql);
			q.addScalar(COUNT_COLUMN_NAME, Type.LONG);

			Iterator<Long> iter = q.list().iterator();
			if (iter.hasNext()) {
				Long count = iter.next();
				if (count != null) {
					return count.intValue();
				}
			}
			return 0;
		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}
	
	public List<PmlEdmDocumentSend> findByDocumentSend_Users_Status_DangXuLy_TreHan1(
			List<Long> userIds, long statusId, long soVanBan, String soKyHieu,
			String donViSoanThao, String nguoiKy, String trichYeu,
			String coQuanNhan, String tuNgay, String denNgay, int start,
			int end, OrderByComparator obc) throws Exception {
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
		} catch (ParseException e) {
		}

		String userIdList = "";
		for (int i = 0; i < userIds.size(); i++) {
			if (i != userIds.size() - 1) {
				userIdList += userIds.get(i) + ", ";
			}
			userIdList += userIds.get(i);
		}

		DocumentSendLiferayWorkflowService workflowService = new DocumentSendLiferayWorkflowService();
		List<Long> listProcessId = workflowService
				.getListProcessInstanceByStatusId(userIds, statusId);

		// Lay ngay hien tai
		String currentDate = new SimpleDateFormat("yyyy-MM-dd")
				.format(new Date());
		Session session = null;

		try {
			session = openSession();

			String sql = " SELECT DISTINCT(cvsend.*) ";
			sql += " FROM pml_edm_documentsend cvsend, pml_documentsend_wf cvsendwf, pml_edm_documentreceipt cvden, pml_edm_answerdetail ad,";
			sql += " (SELECT  DISTINCT (pml_documentsend_log.documentsendid), MAX  (pml_documentsend_log.transition_) AS tran ";
			sql += " FROM pml_documentsend_log  ";
			sql += " WHERE ( pml_documentsend_log.processer IN (" + userIdList
					+ "))";
			sql += " GROUP BY pml_documentsend_log.documentsendid ";
			sql += ") AS pml_send_log, pml_documentsend_log log";
			sql += " WHERE cvsend.documentsendid = cvsendwf.documentsendid";
			sql += " AND cvsendwf.processid in (";

			for (Long processId : listProcessId) {
				sql += processId + ",";
			}

			sql += "0) ";

			sql += " AND cvsend.documentsendid = ad.documentsendid ";
			sql += " AND cvden.documentreceiptid = ad.documentreceiptid ";
			sql += " AND pml_send_log.documentsendid = log.documentsendid ";
			sql += " AND pml_send_log.tran = log.transition_ ";
			sql += " AND log.documentsendid = cvsendwf.documentsendid";
			sql += " AND cvsend.datecreated + cvden.processtime + songaynghile(cvsend.datecreated, cvden.processtime) < '"
					+ currentDate + "'";

			sql += " AND log.dateprocess IS NULL ";
			sql += " AND ( '" + fromDate
					+ "' <= log.senddatebefore AND log.senddatebefore <= '"
					+ toDate + "' )";

			if (0 != soVanBan) {
				sql += " AND cvsend.documentrecordtypeid = " + soVanBan;
			}

			if (!"".equals(donViSoanThao)) {
				sql = sql
						.replace(
								") AS pml_send_log, pml_documentsend_log log, pml_edm_documentreceipt cvden, pml_edm_answerdetail ad",
								") AS pml_send_log, pml_documentsend_log log, pml_edm_documentreceipt cvden, pml_edm_answerdetail ad, pml_user ");
				sql += " AND cvsend.editorid = pml_user.userid";
				sql += " AND pml_user.departmentsid = '" + donViSoanThao + "' ";
			}

			if (!"".equals(soKyHieu)) {
				sql += " AND lower(cvsend.documentreference) LIKE lower('%"
						+ soKyHieu + "%')";
			}

			if (!"".equals(nguoiKy)) {
				sql += " AND lower(cvsend.signername) LIKE lower('%" + nguoiKy
						+ "%') ";
			}

			if (!"".equals(trichYeu)) {
				sql += "AND lower(cvsend.briefcontent) LIKE lower('%"
						+ trichYeu + "%') ";
			}

			if (!"".equals(coQuanNhan)) {
				sql += " AND lower(cvsend.receivingplace) LIKE lower('%"
						+ coQuanNhan + " %')";
			}

			sql = CustomSQLUtil.replaceOrderBy(sql, obc);

			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("PmlEdmDocumentSend", PmlEdmDocumentSendImpl.class);

			return (List<PmlEdmDocumentSend>) QueryUtil.list(q, getDialect(),
					start, end);
		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}
	
	public List<PmlEdmDocumentSend> getListCVDiDaXuLyChung1(long userId,
			long soVanBan, String soKyHieu, String donViSoanThao, String nguoiKy,
			String trichYeu, String coQuanNhan, String tuNgay, String denNgay,
			int start, int end, OrderByComparator obc) throws SystemException {
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
		} catch (ParseException e) {
		}

		Session session = null;

		try {
			session = openSession();

			String sql = " SELECT cvsend.*  ";
			sql += " FROM pml_edm_documentsend cvsend, (SELECT  DISTINCT (pml_documentsend_log.documentsendid), MAX  (pml_documentsend_log.transition_) AS tran  ";
			sql += " FROM pml_documentsend_log  ";
			sql += " WHERE ( pml_documentsend_log.processer = " + userId + ") ";
			sql += " GROUP BY pml_documentsend_log.documentsendid ";
			sql += ") AS pml_send_log, pml_documentsend_log log";
			sql += " WHERE ( pml_send_log.documentsendid = log.documentsendid ) ";
			sql += " AND ( pml_send_log.tran = log.transition_ ) ";
			sql += " AND ( cvsend.documentsendid = log.documentsendid ) ";
			sql += " AND ('" + fromDate + "' <= log.dateprocess";
			sql += " AND log.dateprocess <= '" + toDate + "' )";
			
			if (!"".equals(donViSoanThao)) {
				sql = sql
						.replace(") AS pml_send_log, pml_documentsend_log log",
								") AS pml_send_log, pml_documentsend_log log, pml_user ");
				sql += " AND cvsend.editorid = pml_user.userid";
				sql += " AND pml_user.departmentsid = '" + donViSoanThao + "' ";
			}

			if (0 != soVanBan) {
				sql += " AND cvsend.documentrecordtypeid = " + soVanBan;
			}

			if (!"".equals(soKyHieu)) {
				sql += " AND lower(cvsend.documentreference) LIKE lower('%"
						+ soKyHieu + "%')";
			}

			if (!"".equals(nguoiKy)) {
				sql += " AND lower(cvsend.signername) LIKE lower('%" + nguoiKy
						+ "%') ";
			}

			if (!"".equals(trichYeu)) {
				sql += "AND lower(cvsend.briefcontent) LIKE lower('%"
						+ trichYeu + "%') ";
			}

			if (!"".equals(coQuanNhan)) {
				sql += " AND lower(cvsend.receivingplace) LIKE lower('%"
						+ coQuanNhan + "%')";
			}
			
			sql = CustomSQLUtil.replaceOrderBy(sql, obc);
			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("pml_edm_documentsend", PmlEdmDocumentSendImpl.class);

			return (List<PmlEdmDocumentSend>) QueryUtil.list(q, getDialect(),
					start, end);
		} catch (Exception e) {
			throw processException(e);
		} finally {
			closeSession(session);
		}
	}
	
	public int countListCVDiDaXuLyChung1(long userId, long soVanBan,
			String soKyHieu, String donViSoanThao, String nguoiKy,
			String trichYeu, String coQuanNhan, String tuNgay, String denNgay)
			throws SystemException {
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
		} catch (ParseException e) {
		}

		Session session = null;

		try {
			session = openSession();

			String sql = " SELECT COUNT(*) AS COUNT_VALUE";
			sql += " FROM pml_edm_documentsend cvsend, (SELECT  DISTINCT (pml_documentsend_log.documentsendid), MAX  (pml_documentsend_log.transition_) AS tran  ";
			sql += " FROM pml_documentsend_log  ";
			sql += " WHERE ( pml_documentsend_log.processer = " + userId + ") ";
			sql += " GROUP BY pml_documentsend_log.documentsendid ";
			sql += ") AS pml_send_log, pml_documentsend_log log";
			sql += " WHERE ( pml_send_log.documentsendid = log.documentsendid ) ";
			sql += " AND ( pml_send_log.tran = log.transition_ ) ";
			sql += " AND ( cvsend.documentsendid = log.documentsendid ) ";
			sql += " AND ('" + fromDate + "' <= log.dateprocess";
			sql += " AND log.dateprocess <= '" + toDate + "' )";

			if (!"".equals(donViSoanThao)) {
				sql = sql
						.replace(") AS pml_send_log, pml_documentsend_log log",
								") AS pml_send_log, pml_documentsend_log log, pml_user ");
				sql += " AND cvsend.editorid = pml_user.userid";
				sql += " AND pml_user.departmentsid = '" + donViSoanThao + "' ";
			}

			if (0 != soVanBan) {
				sql += " AND cvsend.documentrecordtypeid = " + soVanBan;
			}

			if (!"".equals(soKyHieu)) {
				sql += " AND lower(cvsend.documentreference) LIKE lower('%"
						+ soKyHieu + "%')";
			}

			if (!"".equals(nguoiKy)) {
				sql += " AND lower(cvsend.signername) LIKE lower('%" + nguoiKy
						+ "%') ";
			}

			if (!"".equals(trichYeu)) {
				sql += "AND lower(cvsend.briefcontent) LIKE lower('%"
						+ trichYeu + "%') ";
			}

			if (!"".equals(coQuanNhan)) {
				sql += " AND lower(cvsend.receivingplace) LIKE lower('%"
						+ coQuanNhan + "%')";
			}

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME, Type.LONG);

			Iterator<Long> iter = q.list().iterator();
			if (iter.hasNext()) {
				Long count = iter.next();
				if (count != null) {
					return count.intValue();
				}
			}
			return 0;
		} catch (Exception e) {
			throw processException(e);
		} finally {
			closeSession(session);
		}
	}
	
	public List<PmlEdmDocumentSend> getListCVDiDaXuLyTuXuLy1(long userId,
			long soVanBan, String soKyHieu, String donViSoanThao, String nguoiKy,
			String trichYeu, String coQuanNhan, String tuNgay, String denNgay,
			int start, int end, OrderByComparator obc) throws SystemException {
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
		} catch (ParseException e) {
		}

		Session session = null;

		try {
			session = openSession();

			String sql = "SELECT cvsend.* ";
			sql += " FROM pml_edm_documentsend cvsend, (SELECT  DISTINCT (pml_documentsend_log.documentsendid), MAX  (pml_documentsend_log.transition_) AS tran  ";
			sql += " FROM pml_documentsend_log  ";
			sql += " WHERE ( pml_documentsend_log.processer = " + userId + ") ";
			sql += " GROUP BY pml_documentsend_log.documentsendid ";
			sql += ") AS pml_send_log, pml_documentsend_log log";
			sql += " WHERE ( pml_send_log.documentsendid = log.documentsendid ) ";
			sql += " AND ( pml_send_log.tran = log.transition_ ) ";
			sql += " AND ( log.processer = log.receiver ) ";
			sql += " AND ( cvsend.documentsendid = log.documentsendid ) ";
			sql += " AND ('" + fromDate + "' <= log.dateprocess";
			sql += " AND log.dateprocess <= '" + toDate + "' )";

			if (!"".equals(donViSoanThao)) {
				sql = sql
						.replace(") AS pml_send_log, pml_documentsend_log log",
								") AS pml_send_log, pml_documentsend_log log, pml_user ");
				sql += " AND cvsend.editorid = pml_user.userid";
				sql += " AND pml_user.departmentsid = '" + donViSoanThao + "' ";
			}

			if (0 != soVanBan) {
				sql += " AND cvsend.documentrecordtypeid = " + soVanBan;
			}

			if (!"".equals(soKyHieu)) {
				sql += " AND lower(cvsend.documentreference) LIKE lower('%"
						+ soKyHieu + "%')";
			}

			if (!"".equals(nguoiKy)) {
				sql += " AND lower(cvsend.signername) LIKE lower('%" + nguoiKy
						+ "%') ";
			}

			if (!"".equals(trichYeu)) {
				sql += "AND lower(cvsend.briefcontent) LIKE lower('%"
						+ trichYeu + "%') ";
			}

			if (!"".equals(coQuanNhan)) {
				sql += " AND lower(cvsend.receivingplace) LIKE lower('%"
						+ coQuanNhan + "%')";
			}

			sql = CustomSQLUtil.replaceOrderBy(sql, obc);
			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("pml_edm_documentsend", PmlEdmDocumentSendImpl.class);

			return (List<PmlEdmDocumentSend>) QueryUtil.list(q, getDialect(),
					start, end);
		} catch (Exception e) {
			throw processException(e);
		} finally {
			closeSession(session);
		}
	}
	
	public int countListCVDiDaXuLyTuXuLy1(long userId, long soVanBan,
			String soKyHieu, String donViSoanThao, String nguoiKy,
			String trichYeu, String coQuanNhan, String tuNgay, String denNgay)
			throws SystemException {
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
		} catch (ParseException e) {
		}

		Session session = null;

		try {
			session = openSession();

			String sql = " SELECT COUNT(*) AS COUNT_VALUE";
			sql += " FROM pml_edm_documentsend cvsend, (SELECT  DISTINCT (pml_documentsend_log.documentsendid), MAX  (pml_documentsend_log.transition_) AS tran  ";
			sql += " FROM pml_documentsend_log  ";
			sql += " WHERE ( pml_documentsend_log.processer = " + userId + ") ";
			sql += " GROUP BY pml_documentsend_log.documentsendid ";
			sql += ") AS pml_send_log, pml_documentsend_log log";
			sql += " WHERE ( pml_send_log.documentsendid = log.documentsendid ) ";
			sql += " AND ( pml_send_log.tran = log.transition_ ) ";
			sql += " AND ( log.processer = log.receiver ) ";
			sql += " AND ( cvsend.documentsendid = log.documentsendid ) ";
			sql += " AND ('" + fromDate + "' <= log.dateprocess";
			sql += " AND log.dateprocess <= '" + toDate + "' )";

			if (!"".equals(donViSoanThao)) {
				sql = sql
						.replace(") AS pml_send_log, pml_documentsend_log log",
								") AS pml_send_log, pml_documentsend_log log, pml_user ");
				sql += " AND cvsend.editorid = pml_user.userid";
				sql += " AND pml_user.departmentsid = '" + donViSoanThao + "' ";
			}

			if (0 != soVanBan) {
				sql += " AND cvsend.documentrecordtypeid = " + soVanBan;
			}

			if (!"".equals(soKyHieu)) {
				sql += " AND lower(cvsend.documentreference) LIKE lower('%"
						+ soKyHieu + "%')";
			}

			if (!"".equals(nguoiKy)) {
				sql += " AND lower(cvsend.signername) LIKE lower('%" + nguoiKy
						+ "%') ";
			}

			if (!"".equals(trichYeu)) {
				sql += "AND lower(cvsend.briefcontent) LIKE lower('%"
						+ trichYeu + "%') ";
			}

			if (!"".equals(coQuanNhan)) {
				sql += " AND lower(cvsend.receivingplace) LIKE lower('%"
						+ coQuanNhan + "%')";
			}

			SQLQuery q = session.createSQLQuery(sql);
			q.addScalar(COUNT_COLUMN_NAME, Type.LONG);

			Iterator<Long> iter = q.list().iterator();
			if (iter.hasNext()) {
				Long count = iter.next();
				if (count != null) {
					return count.intValue();
				}
			}
			return 0;
		} catch (Exception e) {
			throw processException(e);
		} finally {
			closeSession(session);
		}
	}
	
	public List<PmlEdmDocumentSend> getListCVDiDaXuLyChung_treHan1(long userId,
			long soVanBan, String soKyHieu, String donViSoanThao, String nguoiKy,
			String trichYeu, String coQuanNhan, String tuNgay, String denNgay,
			int start, int end, OrderByComparator obc) throws SystemException {
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
		} catch (ParseException e) {
		}

		Session session = null;

		try {
			session = openSession();

			String sql = " SELECT cvsend.* ";
			sql += " FROM pml_edm_documentsend cvsend, ";
			sql += " (SELECT DISTINCT (logdi.documentsendid) ";
			sql += " FROM pml_documentsend_log logdi, ";
			sql += " ( SELECT logden.documentreceiptid AS  docid, MAX(logden.transition_) AS t_  ";
			sql += " FROM pml_documentsend_log logdi, pml_documentreceipt_log logden, pml_edm_answerdetail detail ";
			sql += " WHERE detail.documentsendid =  logdi.documentsendid ";
			sql += " AND detail.documentreceiptid = logden.documentreceiptid ";
			sql += " AND logdi.processer = " + userId;
			sql += " GROUP BY logden.documentreceiptid ";
			sql += " ) AS logden, pml_documentreceipt_log logres, pml_edm_answerdetail detail ";
			sql += " WHERE logres.documentreceiptid = logden.docid ";
			sql += " AND logres.transition_ = logden.t_  ";
			sql += " AND detail.documentsendid =  logdi.documentsendid ";
			sql += " AND detail.documentreceiptid = logden.docid ";
			sql += " AND logdi.processer = " + userId;
			sql += " AND ('" + fromDate
					+ "' <= logdi.dateprocess AND logdi.dateprocess <= '"
					+ toDate + "' )";
			sql += " AND (logres.senddatebefore IS NOT NULL )";
			sql += " AND (logres.senddatebefore + logres.numdateprocess + songaynghile(logres.senddatebefore, logres.numdateprocess)) < logdi.dateprocess ";
			sql += ") AS logdi ";
			sql += " WHERE ( cvsend.documentsendid = logdi.documentsendid ) ";

			if (!"".equals(donViSoanThao)) {
				sql = sql.replace(") AS logdi ", ") AS logdi , pml_user ");
				sql += " AND cvsend.editorid = pml_user.userid";
				sql += " AND pml_user.departmentsid = '" + donViSoanThao + "' ";
			}

			if (0 != soVanBan) {
				sql += " AND cvsend.documentrecordtypeid = " + soVanBan;
			}

			if (!"".equals(soKyHieu)) {
				sql += " AND lower(cvsend.documentreference) LIKE lower('%"
						+ soKyHieu + "%')";
			}

			if (!"".equals(nguoiKy)) {
				sql += " AND lower(cvsend.signername) LIKE lower('%" + nguoiKy
						+ "%') ";
			}

			if (!"".equals(trichYeu)) {
				sql += "AND lower(cvsend.briefcontent) LIKE lower('%"
						+ trichYeu + "%') ";
			}

			if (!"".equals(coQuanNhan)) {
				sql += " AND lower(cvsend.receivingplace) LIKE lower('%"
						+ coQuanNhan + "%')";
			}

			sql = CustomSQLUtil.replaceOrderBy(sql, obc);
			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("pml_edm_documentsend", PmlEdmDocumentSendImpl.class);

			return (List<PmlEdmDocumentSend>) QueryUtil.list(q, getDialect(),
					start, end);
		} catch (Exception e) {
			throw processException(e);
		} finally {
			closeSession(session);
		}
	}
	
	public int countListCVDiDaXuLyChung_treHan1(long userId, long soVanBan,
			String soKyHieu, String donViSoanThao, String nguoiKy,
			String trichYeu, String coQuanNhan, String tuNgay, String denNgay)
			throws SystemException {
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
		} catch (ParseException e) {
		}

		Session session = null;

		try {
			session = openSession();

			String sql = " SELECT COUNT(*) AS COUNT_VALUE";
			sql += " FROM pml_edm_documentsend cvsend, ";
			sql += " (SELECT DISTINCT (logdi.documentsendid) ";
			sql += " FROM pml_documentsend_log logdi, ";
			sql += " ( SELECT logden.documentreceiptid AS  docid, MAX(logden.transition_) AS t_  ";
			sql += " FROM pml_documentsend_log logdi, pml_documentreceipt_log logden, pml_edm_answerdetail detail ";
			sql += " WHERE detail.documentsendid =  logdi.documentsendid ";
			sql += " AND detail.documentreceiptid = logden.documentreceiptid ";
			sql += " AND logdi.processer = " + userId;
			sql += " GROUP BY logden.documentreceiptid ";
			sql += " ) AS logden, pml_documentreceipt_log logres, pml_edm_answerdetail detail ";
			sql += " WHERE logres.documentreceiptid = logden.docid ";
			sql += " AND logres.transition_ = logden.t_  ";
			sql += " AND detail.documentsendid =  logdi.documentsendid ";
			sql += " AND detail.documentreceiptid = logden.docid ";
			sql += " AND logdi.processer = " + userId;
			sql += " AND ('" + fromDate
					+ "' <= logdi.dateprocess AND logdi.dateprocess <= '"
					+ toDate + "' )";
			sql += " AND (logres.senddatebefore IS NOT NULL )";
			sql += " AND (logres.senddatebefore + logres.numdateprocess + songaynghile(logres.senddatebefore, logres.numdateprocess)) < logdi.dateprocess ";
			sql += ") AS logdi ";
			sql += " WHERE ( cvsend.documentsendid = logdi.documentsendid ) ";

			if (!"".equals(donViSoanThao)) {
				sql = sql.replace(") AS logdi ", ") AS logdi , pml_user ");
				sql += " AND cvsend.editorid = pml_user.userid";
				sql += " AND pml_user.departmentsid = '" + donViSoanThao + "' ";
			}

			if (0 != soVanBan) {
				sql += " AND cvsend.documentrecordtypeid = " + soVanBan;
			}

			if (!"".equals(soKyHieu)) {
				sql += " AND lower(cvsend.documentreference) LIKE lower('%"
						+ soKyHieu + "%')";
			}

			if (!"".equals(nguoiKy)) {
				sql += " AND lower(cvsend.signername) LIKE lower('%" + nguoiKy
						+ "%') ";
			}

			if (!"".equals(trichYeu)) {
				sql += "AND lower(cvsend.briefcontent) LIKE lower('%"
						+ trichYeu + "%') ";
			}

			if (!"".equals(coQuanNhan)) {
				sql += " AND lower(cvsend.receivingplace) LIKE lower('%"
						+ coQuanNhan + "%')";
			}

			SQLQuery q = session.createSQLQuery(sql);
			q.addScalar(COUNT_COLUMN_NAME, Type.LONG);

			Iterator<Long> iter = q.list().iterator();
			if (iter.hasNext()) {
				Long count = iter.next();
				if (count != null) {
					return count.intValue();
				}
			}
			return 0;
		} catch (Exception e) {
			throw processException(e);
		} finally {
			closeSession(session);
		}
	}
	
	public List<PmlEdmDocumentSend> getListCVDiDaXuLyTuXuLy_treHan1(long userId,
			long soVanBan, String soKyHieu, String donViSoanThao, String nguoiKy,
			String trichYeu, String coQuanNhan, String tuNgay, String denNgay,
			int start, int end, OrderByComparator obc) throws SystemException {
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
		} catch (ParseException e) {
		}

		Session session = null;

		try {
			session = openSession();

			String sql = "SELECT cvsend.* ";
			sql += " FROM pml_edm_documentsend cvsend, ";
			sql += " (SELECT DISTINCT (logdi.documentsendid) ";
			sql += " FROM pml_documentsend_log logdi, ";
			sql += " ( SELECT logden.documentreceiptid AS  docid, MAX(logden.transition_) AS t_  ";
			sql += " FROM pml_documentsend_log logdi, pml_documentreceipt_log logden, pml_edm_answerdetail detail ";
			sql += " WHERE detail.documentsendid =  logdi.documentsendid ";
			sql += " AND detail.documentreceiptid = logden.documentreceiptid ";
			sql += " AND logdi.processer = " + userId;
			sql += " GROUP BY logden.documentreceiptid ";
			sql += " ) AS logden, pml_documentreceipt_log logres, pml_edm_answerdetail detail ";
			sql += " WHERE logres.documentreceiptid = logden.docid ";
			sql += " AND logres.transition_ = logden.t_  ";
			sql += " AND detail.documentsendid =  logdi.documentsendid ";
			sql += " AND detail.documentreceiptid = logden.docid ";
			sql += " AND logdi.processer = " + userId;
			sql += " AND logdi.processer = logdi.receiver ";
			sql += " AND ('" + fromDate
					+ "' <= logdi.dateprocess AND logdi.dateprocess <= '"
					+ toDate + "' )";
			sql += " AND (logres.senddatebefore IS NOT NULL )";
			sql += " AND (logres.senddatebefore + logres.numdateprocess + songaynghile(logres.senddatebefore, logres.numdateprocess)) < logdi.dateprocess ";
			sql += ") AS logdi ";
			sql += " WHERE ( cvsend.documentsendid = logdi.documentsendid ) ";

			if (!"".equals(donViSoanThao)) {
				sql = sql.replace(") AS logdi ", ") AS logdi , pml_user ");
				sql += " AND cvsend.editorid = pml_user.userid";
				sql += " AND pml_user.departmentsid = '" + donViSoanThao + "' ";
			}

			if (0 != soVanBan) {
				sql += " AND cvsend.documentrecordtypeid = " + soVanBan;
			}

			if (!"".equals(soKyHieu)) {
				sql += " AND lower(cvsend.documentreference) LIKE lower('%"
						+ soKyHieu + "%')";
			}

			if (!"".equals(nguoiKy)) {
				sql += " AND lower(cvsend.signername) LIKE lower('%" + nguoiKy
						+ "%') ";
			}

			if (!"".equals(trichYeu)) {
				sql += "AND lower(cvsend.briefcontent) LIKE lower('%"
						+ trichYeu + "%') ";
			}

			if (!"".equals(coQuanNhan)) {
				sql += " AND lower(cvsend.receivingplace) LIKE lower('%"
						+ coQuanNhan + "%')";
			}

			sql = CustomSQLUtil.replaceOrderBy(sql, obc);

			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("pml_edm_documentsend", PmlEdmDocumentSendImpl.class);

			return (List<PmlEdmDocumentSend>) QueryUtil.list(q, getDialect(),
					start, end);
		} catch (Exception e) {
			throw processException(e);
		} finally {
			closeSession(session);
		}
	}
	
	public int countListCVDiDaXuLyTuXuLy_treHan1(long userId, long soVanBan,
			String soKyHieu, String donViSoanThao, String nguoiKy,
			String trichYeu, String coQuanNhan, String tuNgay, String denNgay)
			throws SystemException {
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
		} catch (ParseException e) {
		}

		Session session = null;

		try {
			session = openSession();

			String sql = " SELECT COUNT(*) AS COUNT_VALUE";
			sql += " FROM pml_edm_documentsend cvsend, ";
			sql += " (SELECT DISTINCT (logdi.documentsendid) ";
			sql += " FROM pml_documentsend_log logdi, ";
			sql += " ( SELECT logden.documentreceiptid AS  docid, MAX(logden.transition_) AS t_  ";
			sql += " FROM pml_documentsend_log logdi, pml_documentreceipt_log logden, pml_edm_answerdetail detail ";
			sql += " WHERE detail.documentsendid =  logdi.documentsendid ";
			sql += " AND detail.documentreceiptid = logden.documentreceiptid ";
			sql += " AND logdi.processer = " + userId;
			sql += " GROUP BY logden.documentreceiptid ";
			sql += " ) AS logden, pml_documentreceipt_log logres, pml_edm_answerdetail detail ";
			sql += " WHERE logres.documentreceiptid = logden.docid ";
			sql += " AND logres.transition_ = logden.t_  ";
			sql += " AND detail.documentsendid =  logdi.documentsendid ";
			sql += " AND detail.documentreceiptid = logden.docid ";
			sql += " AND logdi.processer = " + userId;
			sql += " AND logdi.processer = logdi.receiver ";
			sql += " AND ('" + fromDate
					+ "' <= logdi.dateprocess AND logdi.dateprocess <= '"
					+ toDate + "' )";
			sql += " AND (logres.senddatebefore IS NOT NULL )";
			sql += " AND (logres.senddatebefore + logres.numdateprocess + songaynghile(logres.senddatebefore, logres.numdateprocess)) < logdi.dateprocess ";
			sql += ") AS logdi ";
			sql += " WHERE ( cvsend.documentsendid = logdi.documentsendid ) ";

			if (!"".equals(donViSoanThao)) {
				sql = sql.replace(") AS logdi ", ") AS logdi , pml_user ");
				sql += " AND cvsend.editorid = pml_user.userid";
				sql += " AND pml_user.departmentsid = '" + donViSoanThao + "' ";
			}

			if (0 != soVanBan) {
				sql += " AND cvsend.documentrecordtypeid = " + soVanBan;
			}

			if (!"".equals(soKyHieu)) {
				sql += " AND lower(cvsend.documentreference) LIKE lower('%"
						+ soKyHieu + "%')";
			}

			if (!"".equals(nguoiKy)) {
				sql += " AND lower(cvsend.signername) LIKE lower('%" + nguoiKy
						+ "%') ";
			}

			if (!"".equals(trichYeu)) {
				sql += "AND lower(cvsend.briefcontent) LIKE lower('%"
						+ trichYeu + "%') ";
			}

			if (!"".equals(coQuanNhan)) {
				sql += " AND lower(cvsend.receivingplace) LIKE lower('%"
						+ coQuanNhan + " %')";
			}

			SQLQuery q = session.createSQLQuery(sql);
			q.addScalar(COUNT_COLUMN_NAME, Type.LONG);

			Iterator<Long> iter = q.list().iterator();
			if (iter.hasNext()) {
				Long count = iter.next();
				if (count != null) {
					return count.intValue();
				}
			}
			return 0;
		} catch (Exception e) {
			throw processException(e);
		} finally {
			closeSession(session);
		}
	}
	/* end phmphuc update 16/02/2011 */
}