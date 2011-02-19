/**
 * 
 */
package com.sgs.portlet.document.receipt.service.persistence;

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
import com.liferay.portal.model.User;
import com.liferay.portal.model.impl.UserImpl;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;
import com.sgs.portlet.department.model.Department;
import com.sgs.portlet.department.service.persistence.DepartmentUtil;
import com.sgs.portlet.document.model.PmlDocumentReceiptLog;
import com.sgs.portlet.document.model.impl.PmlDocumentReceiptLogImpl;
import com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt;
import com.sgs.portlet.document.receipt.model.PmlFileStatusStateProcess;
import com.sgs.portlet.document.receipt.model.impl.PmlEdmDocumentReceiptImpl;
import com.sgs.portlet.document.workflow.DocumentReceiptLiferayWorkflowService;

/**
 * @author DienNH
 * @author XUAN CONG
 */
@SuppressWarnings("unchecked")
public class PmlEdmDocumentReceiptFinderImpl extends BasePersistenceImpl
		implements PmlEdmDocumentReceiptFinder {

	public static String FIND_BY_S_L_N_S_N_T_D_D_S_T = PmlEdmDocumentReceiptFinder.class
			.getName() + ".findByS_L_N_S_N_T_D_D_S_T";
	public static String COUNT_BY_S_L_N_S_N_T_D_D_S_T = PmlEdmDocumentReceiptFinder.class
			.getName() + ".countByS_L_N_S_N_T_D_D_S_T";

	// By TriLTM
	public static String COUNT_BY_R_B_F_T = PmlEdmDocumentReceiptFinder.class
			.getName() + ".countBy_R_B_F_T";
	public static String FIND_BY_R_B_F_T = PmlEdmDocumentReceiptFinder.class
			.getName() + ".findBy_R_B_F_T";

	/**
	 * 
	 */
	public PmlEdmDocumentReceiptFinderImpl() {

	}

	/**
	 * @author minhquan Lay tat ca user sap xep theo alphabe
	 * @return Sorted List<User>
	 * @throws SystemException
	 *             20100201
	 */
	public List<User> getSortedListUser() throws SystemException {
		try {
			return getSortedListUser(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		} catch (Exception ex) {
			return null;
		}
	}

	public List<User> getSortedListUser(int start, int end) throws Exception {
		Session session = null;
		try {
			session = openSession();

			String sql = "SELECT u.* from User_ u,Contact_ c WHERE u.contactid = c.contactid ";
			sql += "ORDER by c.firstname asc,c.lastname ASC ";

			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("User", UserImpl.class);

			return (List<User>) QueryUtil.list(q, getDialect(), start, end);
		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}

	// minh update 2009/11/25
	/**
	 * tra ve so luong cong van den ung voi mot dang sach user va trang thai cu
	 * the
	 */

	public int countByDocumentReceipt_Users(List<Long> userIds, String capGui,
			String loaisocongvan) throws Exception {
		Session session = null;

		try {
			session = openSession();

			DocumentReceiptLiferayWorkflowService workflowService = new DocumentReceiptLiferayWorkflowService();
			List<Long> listProcessId = workflowService
					.getProcessInstances(userIds);

			String sql = "SELECT COUNT(DISTINCT(cv.documentreceiptid)) AS COUNT_VALUE ";
			sql += "FROM pml_edm_documentreceipt cv, pml_documentreceipt_wf cvwf ";
			// minh update 20103103
			// ", pml_edm_documenttype dt, pml_edm_documentrecordtype drt ";
			// end minh update
			sql += "WHERE cv.documentreceiptid = cvwf.documentreceiptid ";
			// xuancong add start, bo van ban den da soan van ban di ra khoi
			// danh sach
			sql += "AND NOT EXISTS (SELECT * FROM pml_edm_answerdetail WHERE documentreceiptid = cv.documentreceiptid) ";

			if (!"0".equals(capGui)) {
				sql += "AND cv.levelsendid = " + capGui;
			}

			if (!"0".equals(loaisocongvan)) {
				// minh update 20103103
				sql = sql
						.replace(
								"FROM pml_edm_documentreceipt cv, pml_documentreceipt_wf cvwf ",
								"FROM pml_edm_documentreceipt cv, pml_documentreceipt_wf cvwf,pml_edm_documenttype dt, pml_edm_documentrecordtype drt ");
				// end minh update
				sql += "AND cv.documenttypeid = dt.documenttypeid AND dt.documentrecordtypeid = drt.documentrecordtypeid AND drt.documentrecordtypeid = "
						+ loaisocongvan;
			}

			sql += "AND cvwf.processid in (";

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

	public List<PmlEdmDocumentReceipt> findByDocumentReceipt_Users(
			List<Long> userIds, String capGui, String loaisocongvan, int start,
			int end, OrderByComparator obc) throws Exception {
		Session session = null;

		try {
			session = openSession();

			DocumentReceiptLiferayWorkflowService workflowService = new DocumentReceiptLiferayWorkflowService();
			List<Long> listProcessId = workflowService
					.getProcessInstances(userIds);

			String sql = "SELECT DISTINCT(cv.*) ";
			sql += "FROM pml_edm_documentreceipt cv, pml_documentreceipt_wf cvwf ";
			// minh update 20103103
			// , pml_edm_documenttype dt, pml_edm_documentrecordtype drt ";
			// end minh update
			sql += "WHERE cv.documentreceiptid = cvwf.documentreceiptid ";
			// xuancong add start, bo van ban den da soan van ban di ra khoi
			// danh sach
			sql += "AND NOT EXISTS (SELECT * FROM pml_edm_answerdetail WHERE documentreceiptid = cv.documentreceiptid) ";

			if (!"0".equals(capGui)) {
				sql += "AND cv.levelsendid = " + capGui;
			}

			if (!"0".equals(loaisocongvan)) {
				// minh update 20103103
				sql = sql
						.replace(
								"FROM pml_edm_documentreceipt cv, pml_documentreceipt_wf cvwf ",
								"FROM pml_edm_documentreceipt cv, pml_documentreceipt_wf cvwf,pml_edm_documenttype dt, pml_edm_documentrecordtype drt ");
				// end minh update
				sql += "AND cv.documenttypeid = dt.documenttypeid AND dt.documentrecordtypeid = drt.documentrecordtypeid AND drt.documentrecordtypeid = "
						+ loaisocongvan;
			}

			sql += "AND cvwf.processid in (";

			for (Long processId : listProcessId) {
				sql += processId + ",";
			}

			sql += "0)";

			sql = CustomSQLUtil.replaceOrderBy(sql, obc);

			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("PmlEdmDocumentReceipt",
					PmlEdmDocumentReceiptImpl.class);

			return (List<PmlEdmDocumentReceipt>) QueryUtil.list(q,
					getDialect(), start, end);
		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}

	/**
	 * Ham tra ve so luong van ban theo user va trang thai
	 */
	public int countByDocumentReceipt_Users_Status_DangXuLy(List<Long> userIds,
			long statusId, String soCVDen, String capGui) throws Exception {
		return countByDocumentReceipt_Users_Status_DangXuLy(userIds, statusId,
				soCVDen, capGui, "-1");
	}

	/**
	 * tra ve so luong cong van den ung voi mot dang sach user va trang thai cu
	 * the
	 */

	public int countByDocumentReceipt_Users_Status_DangXuLy(List<Long> userIds,
			long statusId, String soCVDen, String capGui, String cachThucXuLy)
			throws Exception {
		// xuancong sua lai ham nay co them tham so cachThucXuLy
		// Khi cachThucXuLy la "", "1", "2", "3" thi lay lam dieu kien loc du
		// lieu
		// Khi cachThucXuLy null hoac "-1" hoac khac cac gia tri tren thi bo qua
		Session session = null;

		try {
			session = openSession();

			DocumentReceiptLiferayWorkflowService workflowService = new DocumentReceiptLiferayWorkflowService();
			List<Long> listProcessId = workflowService
					.getListProcessInstanceByStatusId(userIds, statusId);

			String sql = "SELECT COUNT(DISTINCT(cv.documentreceiptid)) AS COUNT_VALUE ";
			sql += "FROM pml_edm_documentreceipt cv, pml_documentreceipt_wf cvwf ";
			// minh update 20103103
			// sql
			// +=",pml_edm_documenttype dt, pml_edm_documentrecordtype drt ";
			// end minh update
			sql += "WHERE cv.documentreceiptid = cvwf.documentreceiptid ";
			// xuancong add start, bo van ban den da soan van ban di ra khoi
			// danh sach
			sql += "AND NOT EXISTS (SELECT * FROM pml_edm_answerdetail WHERE documentreceiptid = cv.documentreceiptid) ";

			if (!"0".equals(capGui)) {
				sql += "AND cv.levelsendid = " + capGui;
			}

			if (!"0".equals(soCVDen)) {
				// minh update 20103103
				sql = sql
						.replace(
								"FROM pml_edm_documentreceipt cv, pml_documentreceipt_wf cvwf ",
								"FROM pml_edm_documentreceipt cv, pml_documentreceipt_wf cvwf,pml_edm_documenttype dt, pml_edm_documentrecordtype drt ");
				// end minh update
				sql += "AND cv.documenttypeid = dt.documenttypeid AND dt.documentrecordtypeid = drt.documentrecordtypeid AND drt.documentrecordtypeid = "
						+ soCVDen;
			}

			// Phan xu ly cach thuc xu ly
			if (cachThucXuLy != null) {
				if (cachThucXuLy.length() == 0) {// Chua co cach thuc xu ly -
													// Van ban vua tiep nhan
													// hoac chua xac dinh cach
													// xu ly
					sql += "AND (documenttype is null OR documenttype = '')";
				} // end if
				else if (cachThucXuLy.equals("1") || cachThucXuLy.equals("2")
						|| cachThucXuLy.equals("3")) { // Da co cach thuc xu ly
					sql += "AND documenttype = '" + cachThucXuLy + "'";
				}
			} // end if

			sql += "AND cvwf.processid in (";

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
	 * Tra ve danh sach van ban theo user va trang thai
	 */
	public List<PmlEdmDocumentReceipt> findByDocumentReceipt_Users_Status_DangXuLy(
			List<Long> userIds, long statusId, String soCVDen, String capGui,
			int start, int end, OrderByComparator obc) throws Exception {
		return findByDocumentReceipt_Users_Status_DangXuLy(userIds, statusId,
				soCVDen, capGui, "-1", start, end, obc);
	}

	/**
	 * tra ve danh sach cong van den ung voi mot dang sach user va trang thai cu
	 * the
	 */

	public List<PmlEdmDocumentReceipt> findByDocumentReceipt_Users_Status_DangXuLy(
			List<Long> userIds, long statusId, String soCVDen, String capGui,
			String cachThucXuLy, int start, int end, OrderByComparator obc)
			throws Exception {
		// xuancong sua lai ham nay co them tham so cachThucXuLy
		// Khi cachThucXuLy la "", "1", "2", "3" thi lay lam dieu kien loc du
		// lieu
		// Khi cachThucXuLy null hoac "-1" hoac khac cac gia tri tren thi bo qua
		Session session = null;

		try {
			session = openSession();

			DocumentReceiptLiferayWorkflowService workflowService = new DocumentReceiptLiferayWorkflowService();
			List<Long> listProcessId = workflowService
					.getListProcessInstanceByStatusId(userIds, statusId);

			String sql = "SELECT DISTINCT(cv.*) ";
			sql += "FROM pml_edm_documentreceipt cv, pml_documentreceipt_wf cvwf ";
			// minh update 20103103
			// ", pml_edm_documenttype dt, pml_edm_documentrecordtype drt ";
			// end minh update
			sql += "WHERE cv.documentreceiptid = cvwf.documentreceiptid ";
			// xuancong add start, bo van ban den da soan van ban di ra khoi
			// danh sach
			sql += "AND NOT EXISTS (SELECT * FROM pml_edm_answerdetail WHERE documentreceiptid = cv.documentreceiptid) ";

			if (!"0".equals(capGui)) {
				sql += "AND cv.levelsendid = " + capGui;
			}

			if (!"0".equals(soCVDen)) {
				// minh update 20103103
				sql = sql
						.replace(
								"FROM pml_edm_documentreceipt cv, pml_documentreceipt_wf cvwf ",
								"FROM pml_edm_documentreceipt cv, pml_documentreceipt_wf cvwf,pml_edm_documenttype dt, pml_edm_documentrecordtype drt ");
				// end minh update
				sql += "AND cv.documenttypeid = dt.documenttypeid AND dt.documentrecordtypeid = drt.documentrecordtypeid AND drt.documentrecordtypeid = "
						+ soCVDen;
			}

			// Phan xu ly cach thuc xu ly
			if (cachThucXuLy != null) {
				if (cachThucXuLy.length() == 0) {// Chua co cach thuc xu ly -
													// Van ban vua tiep nhan
													// hoac chua xac dinh cach
													// xu ly
					sql += "AND (documenttype is null OR documenttype = '')";
				} // end if
				else if (cachThucXuLy.equals("1") || cachThucXuLy.equals("2")
						|| cachThucXuLy.equals("3")) { // Da co cach thuc xu ly
					sql += "AND documenttype = '" + cachThucXuLy + "'";
				}
			} // end if

			sql += "AND cvwf.processid in (";

			for (Long processId : listProcessId) {
				sql += processId + ",";
			}

			sql += "0)";

			sql = CustomSQLUtil.replaceOrderBy(sql, obc);

			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("PmlEdmDocumentReceipt",
					PmlEdmDocumentReceiptImpl.class);

			return (List<PmlEdmDocumentReceipt>) QueryUtil.list(q,
					getDialect(), start, end);
		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}

	public int countByDocumentReceipt_Users_Status_DangXuLy_TreHan(
			List<Long> userIds, long statusId, String soCVDen, String capGui)
			throws Exception {

		Session session = null;

		try {
			session = openSession();

			DocumentReceiptLiferayWorkflowService workflowService = new DocumentReceiptLiferayWorkflowService();
			List<Long> listProcessId = workflowService
					.getListProcessInstanceByStatusId(userIds, statusId);
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

			String sql = "SELECT COUNT(DISTINCT(cv.documentreceiptid)) AS COUNT_VALUE ";
			sql += "FROM pml_edm_documentreceipt cv, pml_documentreceipt_wf cvwf, ";
			sql += "(SELECT MAX(log.transition_) as maxtran, log.documentreceiptid";
			sql += " FROM pml_documentreceipt_log log";
			sql += " WHERE log.processer IN (" + userIdList + ")"; // truong hop
																	// xu ly
																	// thay nen
																	// nhap vao
																	// ds userId
			sql += " GROUP BY log.documentreceiptid) AS a, pml_documentreceipt_log log";
			if (!"0".equals(soCVDen)) { // chon so cong van
				sql += ", pml_edm_documenttype dt, pml_edm_documentrecordtype drt";
			}

			sql += " WHERE cv.documentreceiptid = cvwf.documentreceiptid ";
			sql += "AND NOT EXISTS (SELECT * FROM pml_edm_answerdetail WHERE documentreceiptid = cv.documentreceiptid) ";

			sql += "AND cvwf.processid in (";

			for (Long processId : listProcessId) {
				sql += processId + ",";
			}

			sql += "0) ";

			sql += "AND cv.datearrive + cv.processtime + songaynghile(cv.datearrive, cv.processtime) < '"
					+ currentDate + "'";

			sql += " AND cv.documentreceiptid = log.documentreceiptid";
			sql += " AND a.maxtran = log.transition_";
			sql += " AND a.documentreceiptid = log.documentreceiptid";
			sql += " AND log.dateprocess is null ";
			sql += " AND log.senddatebefore is not null AND log.senddatebefore <= '"
					+ currentDate + "'";
			sql += " AND log.numdateprocess > 0 ";
			sql += " AND (log.senddatebefore + log.numdateprocess + songaynghile(log.senddatebefore, log.numdateprocess)) < '"
					+ currentDate + "'";

			if (!"0".equals(capGui)) {
				sql += " AND cv.levelsendid = " + capGui;
			}

			if (!"0".equals(soCVDen)) {
				sql += " AND cv.documenttypeid = dt.documenttypeid ";
				sql += " AND dt.documentrecordtypeid = drt.documentrecordtypeid";
				sql += " AND drt.documentrecordtypeid = " + soCVDen;
			}

			// end yenlt 28042010
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

	public List<PmlEdmDocumentReceipt> findByDocumentReceipt_Users_Status_DangXuLy_TreHan(
			List<Long> userIds, long statusId, String soCVDen, String capGui,
			int start, int end, OrderByComparator obc) throws Exception {

		Session session = null;

		try {
			session = openSession();

			DocumentReceiptLiferayWorkflowService workflowService = new DocumentReceiptLiferayWorkflowService();
			List<Long> listProcessId = workflowService
					.getListProcessInstanceByStatusId(userIds, statusId);

			// Lay ngay hien tai
			String currentDate = new SimpleDateFormat("yyyy-MM-dd")
					.format(new Date());

			String userIdList = "";
			for (int i = 0; i < userIds.size(); i++) {
				if (i != userIds.size() - 1) {
					userIdList += userIds.get(i) + ", ";
				}
				userIdList += userIds.get(i);
			}
			String sql = "SELECT DISTINCT(cv.*) ";
			sql += "FROM pml_edm_documentreceipt cv, pml_documentreceipt_wf cvwf, ";
			sql += "(SELECT MAX(log.transition_) as maxtran, log.documentreceiptid";
			sql += " FROM pml_documentreceipt_log log";
			sql += " WHERE log.processer IN (" + userIdList + ")"; // truong hop
																	// xu ly
																	// thay nen
																	// nhap vao
																	// ds userId
			sql += " GROUP BY log.documentreceiptid) AS a, pml_documentreceipt_log log";
			if (!"0".equals(soCVDen)) { // chon so cong van
				sql += ", pml_edm_documenttype dt, pml_edm_documentrecordtype drt";
			}

			sql += " WHERE cv.documentreceiptid = cvwf.documentreceiptid ";
			sql += "AND NOT EXISTS (SELECT * FROM pml_edm_answerdetail WHERE documentreceiptid = cv.documentreceiptid) ";

			sql += "AND cvwf.processid in (";

			for (Long processId : listProcessId) {
				sql += processId + ",";
			}

			sql += "0) ";

			sql += "AND cv.datearrive + cv.processtime + songaynghile(cv.datearrive, cv.processtime) < '"
					+ currentDate + "'";

			sql += " AND cv.documentreceiptid = log.documentreceiptid";
			sql += " AND a.maxtran = log.transition_";
			sql += " AND a.documentreceiptid = log.documentreceiptid";
			sql += " AND log.dateprocess is null ";
			sql += " AND log.senddatebefore is not null AND log.senddatebefore <= '"
					+ currentDate + "'";
			sql += " AND log.numdateprocess > 0 ";
			sql += " AND (log.senddatebefore + log.numdateprocess + songaynghile(log.senddatebefore, log.numdateprocess)) < '"
					+ currentDate + "'";

			if (!"0".equals(capGui)) {
				sql += " AND cv.levelsendid = " + capGui;
			}

			if (!"0".equals(soCVDen)) {
				sql += " AND cv.documenttypeid = dt.documenttypeid ";
				sql += " AND dt.documentrecordtypeid = drt.documentrecordtypeid";
				sql += " AND drt.documentrecordtypeid = " + soCVDen;
			}

			// end yenlt 28042010
			sql = CustomSQLUtil.replaceOrderBy(sql, obc);

			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("PmlEdmDocumentReceipt",
					PmlEdmDocumentReceiptImpl.class);

			return (List<PmlEdmDocumentReceipt>) QueryUtil.list(q,
					getDialect(), start, end);
		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}

	/**
	 * So luong cong van den da xu ly cua user theo trang thai
	 * 
	 * @author DienNH
	 * 
	 */
	public int countByDocumentReceipt_Users_Status_DaXuLy(List<Long> userIds,
			long statusId, int year, String soCVDen, String capGui)
			throws Exception {

		Session session = null;

		try {
			session = openSession();

			String sql = "SELECT COUNT(DISTINCT(cv.documentreceiptid)) AS COUNT_VALUE ";
			sql += "FROM pml_edm_documentreceipt cv, pml_documentreceipt_log log ";
			// minh update 20103103
			// , pml_edm_documenttype dt, pml_edm_documentrecordtype drt ";
			// end minh update
			sql += "WHERE cv.documentreceiptid = log.documentreceiptid";

			if (!"0".equals(capGui)) {
				sql += " AND cv.levelsendid = " + capGui;
			}

			if (!"0".equals(soCVDen)) {
				// minh update 20103103
				sql = sql
						.replace(
								"FROM pml_edm_documentreceipt cv, pml_documentreceipt_log log ",
								"FROM pml_edm_documentreceipt cv, pml_documentreceipt_log log ,pml_edm_documenttype dt, pml_edm_documentrecordtype drt ");
				// end minh update
				sql += " AND cv.documenttypeid = dt.documenttypeid AND dt.documentrecordtypeid = drt.documentrecordtypeid AND drt.documentrecordtypeid = "
						+ soCVDen;
			}

			sql += " AND log.processer in (";

			for (Long userId : userIds) {
				sql += userId + ",";
			}

			sql += "0) ";

			sql += "AND log.dateprocess is not null ";
			sql += "AND date_part('year', log.dateprocess) = " + year;

			// Lay tinh trang nho cua statusId
			sql += " AND cv.statusid in (";

			List<PmlFileStatusStateProcess> stateProcessList = PmlFileStatusStateProcessUtil
					.findByFileStatusId(statusId);

			for (PmlFileStatusStateProcess pmlFileStatusStateProcess : stateProcessList) {
				sql += pmlFileStatusStateProcess.getStateProcessId() + ",";
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
	 * Danh sach cong van den da xu ly cua user theo trang thai
	 * 
	 * @author DienNH
	 * 
	 */
	public List<PmlEdmDocumentReceipt> findByDocumentReceipt_Users_Status_DaXuLy(
			List<Long> userIds, long statusId, int year, String soCVDen,
			String capGui, int start, int end, OrderByComparator obc)
			throws Exception {

		Session session = null;

		try {
			session = openSession();
			// minh update 20101113
			// DocumentReceiptLiferayWorkflowService workflowService = new
			// DocumentReceiptLiferayWorkflowService();
			// List<Long> listProcessId = workflowService
			// .getListProcessInstanceByStatusId(userIds, statusId);
			// end minh update 20101113
			String sql = "SELECT DISTINCT(cv.*) ";
			sql += "FROM pml_edm_documentreceipt cv, pml_documentreceipt_log log ";
			// minh update 20103103
			// , pml_edm_documenttype dt, pml_edm_documentrecordtype drt ";
			// end minh update
			sql += "WHERE cv.documentreceiptid = log.documentreceiptid";

			if (!"0".equals(capGui)) {
				sql += " AND cv.levelsendid = " + capGui;
			}

			if (!"0".equals(soCVDen)) {
				// minh update 20103103
				sql = sql
						.replace(
								"FROM pml_edm_documentreceipt cv, pml_documentreceipt_log log ",
								"FROM pml_edm_documentreceipt cv, pml_documentreceipt_log log ,pml_edm_documenttype dt, pml_edm_documentrecordtype drt ");
				// end minh update
				sql += " AND cv.documenttypeid = dt.documenttypeid AND dt.documentrecordtypeid = drt.documentrecordtypeid AND drt.documentrecordtypeid = "
						+ soCVDen;
			}

			sql += " AND log.processer in (";

			for (Long userId : userIds) {
				sql += userId + ",";
			}

			sql += "0) ";

			sql += "AND log.dateprocess is not null ";
			sql += "AND date_part('year', log.dateprocess) = " + year;

			if (statusId != 0) { // Default lay tat ca
				// Lay tinh trang nho cua statusId
				sql += " AND cv.statusid in (";

				List<PmlFileStatusStateProcess> stateProcessList = PmlFileStatusStateProcessUtil
						.findByFileStatusId(statusId);

				for (PmlFileStatusStateProcess pmlFileStatusStateProcess : stateProcessList) {
					sql += pmlFileStatusStateProcess.getStateProcessId() + ",";
				}

				sql += "0)";
			}

			sql = CustomSQLUtil.replaceOrderBy(sql, obc);

			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("PmlEdmDocumentReceipt",
					PmlEdmDocumentReceiptImpl.class);

			return (List<PmlEdmDocumentReceipt>) QueryUtil.list(q,
					getDialect(), start, end);
		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}

	/**
	 * So luong cong van den da xu ly tre han cua user theo trang thai
	 * 
	 * @author DienNH
	 * 
	 */
	public int countByDocumentReceipt_Users_Status_DaXuLy_TreHan(
			List<Long> userIds, long statusId, int year, String soCVDen,
			String capGui) throws Exception {

		Session session = null;

		try {
			session = openSession();
			// minh update 20101113
			// DocumentReceiptLiferayWorkflowService workflowService = new
			// DocumentReceiptLiferayWorkflowService();
			// List<Long> listProcessId = workflowService
			// .getListProcessInstanceByStatusId(userIds, statusId);
			// end minh update 20101113

			// Lay ngay hien tai
			String currentDate = new SimpleDateFormat("yyyy-MM-dd")
					.format(new Date());

			String sql = "SELECT COUNT(DISTINCT(cv.documentreceiptid)) AS COUNT_VALUE ";
			sql += "FROM pml_edm_documentreceipt cv, pml_documentreceipt_log log ";
			// minh update 20103103
			// , pml_edm_documenttype dt, pml_edm_documentrecordtype drt ";
			// end minh update
			sql += "WHERE cv.documentreceiptid = log.documentreceiptid";

			if (!"0".equals(capGui)) {
				sql += " AND cv.levelsendid = " + capGui;
			}

			if (!"0".equals(soCVDen)) {
				// minh update 20103103
				sql = sql
						.replace(
								"FROM pml_edm_documentreceipt cv, pml_documentreceipt_log log ",
								"FROM pml_edm_documentreceipt cv, pml_documentreceipt_log log ,pml_edm_documenttype dt, pml_edm_documentrecordtype drt ");
				// end minh update
				sql += " AND cv.documenttypeid = dt.documenttypeid AND dt.documentrecordtypeid = drt.documentrecordtypeid AND drt.documentrecordtypeid = "
						+ soCVDen;
			}

			sql += " AND log.processer in (";

			for (Long userId : userIds) {
				sql += userId + ",";
			}

			sql += "0) ";

			sql += "AND log.dateprocess is not null ";
			sql += "AND date_part('year', log.dateprocess) = " + year;

			sql += " AND cv.datearrive + cv.processtime + songaynghile(cv.datearrive, cv.processtime) < '"
					+ currentDate + "'";

			// Lay tinh trang nho cua statusId
			sql += " AND cv.statusid in (";

			List<PmlFileStatusStateProcess> stateProcessList = PmlFileStatusStateProcessUtil
					.findByFileStatusId(statusId);

			for (PmlFileStatusStateProcess pmlFileStatusStateProcess : stateProcessList) {
				sql += pmlFileStatusStateProcess.getStateProcessId() + ",";
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
	 * Danh sach cong van den da xu ly tre han cua user theo trang thai
	 * 
	 * @author DienNH
	 * 
	 */
	public List<PmlEdmDocumentReceipt> findByDocumentReceipt_Users_Status_DaXuLy_TreHan(
			List<Long> userIds, long statusId, int year, String soCVDen,
			String capGui, int start, int end, OrderByComparator obc)
			throws Exception {

		Session session = null;

		try {
			session = openSession();
			// minh update 20101113
			// DocumentReceiptLiferayWorkflowService workflowService = new
			// DocumentReceiptLiferayWorkflowService();
			// List<Long> listProcessId = workflowService
			// .getListProcessInstanceByStatusId(userIds, statusId);
			// en minh update 20101113
			// Lay ngay hien tai
			String currentDate = new SimpleDateFormat("yyyy-MM-dd")
					.format(new Date());

			String sql = "SELECT DISTINCT(cv.*) ";
			// minh update 20103103
			sql += "FROM pml_edm_documentreceipt cv, pml_documentreceipt_log log ";
			// , pml_edm_documenttype dt, pml_edm_documentrecordtype drt ";
			// end minh update
			sql += "WHERE cv.documentreceiptid = log.documentreceiptid";

			if (!"0".equals(capGui)) {
				sql += " AND cv.levelsendid = " + capGui;
			}

			if (!"0".equals(soCVDen)) {
				// minh update 20103103
				sql = sql
						.replace(
								"FROM pml_edm_documentreceipt cv, pml_documentreceipt_log log ",
								"FROM pml_edm_documentreceipt cv, pml_documentreceipt_log log ,pml_edm_documenttype dt, pml_edm_documentrecordtype drt ");
				// end minh update
				sql += " AND cv.documenttypeid = dt.documenttypeid AND dt.documentrecordtypeid = drt.documentrecordtypeid AND drt.documentrecordtypeid = "
						+ soCVDen;
			}

			sql += " AND log.processer in (";

			for (Long userId : userIds) {
				sql += userId + ",";
			}

			sql += "0) ";

			sql += "AND log.dateprocess is not null ";
			sql += "AND date_part('year', log.dateprocess) = " + year;

			sql += " AND cv.datearrive + cv.processtime + songaynghile(cv.datearrive, cv.processtime) < '"
					+ currentDate + "'";

			// Lay tinh trang nho cua statusId
			sql += " AND cv.statusid in (";

			List<PmlFileStatusStateProcess> stateProcessList = PmlFileStatusStateProcessUtil
					.findByFileStatusId(statusId);

			for (PmlFileStatusStateProcess pmlFileStatusStateProcess : stateProcessList) {
				sql += pmlFileStatusStateProcess.getStateProcessId() + ",";
			}

			sql += "0)";

			sql = CustomSQLUtil.replaceOrderBy(sql, obc);

			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("PmlEdmDocumentReceipt",
					PmlEdmDocumentReceiptImpl.class);

			return (List<PmlEdmDocumentReceipt>) QueryUtil.list(q,
					getDialect(), start, end);
		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}

	public int countByS_L_N_S_N_T_D_D_S_T(String soCVDen, String soVaoSo,
			String tuNgay, String denNgay, long soHSCV, long loaiCV,
			String noiPhatHanh, long trangThai, String nguoiKy, String trichYeu)
			throws Exception {

		Session session = null;

		try {
			session = openSession();

			String sql = "SELECT COUNT(DISTINCT(cv.documentreceiptid)) AS COUNT_VALUE ";
			sql += "FROM pml_edm_documentreceipt cv ,pml_chi_tiet_hscv cthscv ";
			// minh update 2009/11/26
			// sql += "WHERE cv.documentreceiptid = cthscv.id_cong_van_den";
			sql += "WHERE cv.documentreceiptid = cv.documentreceiptid";
			if (soHSCV != 0) { // So ho so cong viec
				// sql += " AND cthscv.id_ho_so_cong_viec = " + soHSCV;
				sql += " AND cv.documentreceiptid = cthscv.id_cong_van_den AND cthscv.id_ho_so_cong_viec = "
						+ soHSCV;
			}

			if (soHSCV == 0) { // So ho so cong viec
				sql = sql.replace(",pml_chi_tiet_hscv cthscv ", " ");
			}

			// end

			if (!tuNgay.equals("")) { // Tu ngay
				String temp = new SimpleDateFormat("yyyy-MM-dd")
						.format(new SimpleDateFormat("dd/MM/yyyy")
								.parse(tuNgay));
				sql += " AND cv.datearrive >= '" + temp + "'";
			}

			if (!denNgay.equals("")) { // Den ngay
				String temp = new SimpleDateFormat("yyyy-MM-dd")
						.format(new SimpleDateFormat("dd/MM/yyyy")
								.parse(denNgay));
				sql += " AND cv.datearrive <= '" + temp + "'";
			}

			if (trangThai != 0) { // Trang thai
				sql += " AND cv.statusid in (";
				sql += "SELECT sp.stateprocessid ";
				sql += "FROM pml_stateprocess sp, pml_filestatus fs ";
				sql += "WHERE sp.filestatusid = fs.filestatusid AND ";
				sql += "fs.filestatusid = " + trangThai + ")";
			}

			if (!soCVDen.equals("")) { // So CV den
				sql += " AND cv.documentreference LIKE '%" + soCVDen + "%'";
			}

			if (!soVaoSo.equals("")) { // So vao so
				sql += " AND cv.numberdocumentreceipt LIKE '%" + soVaoSo + "%'";
			}

			if (loaiCV != 0) { // Loai CV
				sql += " AND cv.documenttypeid = " + loaiCV;
			}

			/*
			 * xuancong close start if (!noiPhatHanh.equals("tatca") &&
			 * !noiPhatHanh.equals("")) { // Noi // phat // hanh sql +=
			 * " AND cv.issuingplaceid = '" + noiPhatHanh + "'"; } xuancong
			 * close end
			 */
			// xuancong: tim theo ten don vi gui chu ko phai ma don vi gui
			if (!"".equals(noiPhatHanh.trim())) {
				sql += " AND ((cv.issuingplaceothername LIKE '%"
						+ noiPhatHanh
						+ "%') OR (cv.issuingplaceid in (SELECT issuingplaceid FROM pml_edm_issuingplace WHERE issuingplacename LIKE '%"
						+ noiPhatHanh + "%')))";
			} // end if

			if (!nguoiKy.equals("")) { // Nguoi ky
				sql += " AND cv.signer LIKE '%" + nguoiKy + "%'";
			}

			if (!trichYeu.equals("")) { // Trich yeu
				sql += " AND cv.briefcontent LIKE '%" + trichYeu + "%'";
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

	public List<PmlEdmDocumentReceipt> findByS_L_N_S_N_T_D_D_S_T(
			String soCVDen, String soVaoSo, String tuNgay, String denNgay,
			long soHSCV, long loaiCV, String noiPhatHanh, long trangThai,
			String nguoiKy, String trichYeu, int start, int end,
			OrderByComparator obc) throws Exception {

		Session session = null;

		try {
			session = openSession();

			String sql = "SELECT DISTINCT(cv.*) ";
			// sql +=
			// "FROM pml_edm_documentreceipt cv ,pml_chi_tiet_hscv cthscv "; //
			// yenlt 25052010
			sql += "FROM pml_edm_documentreceipt cv ";
			// minh update 2009/11/26
			// sql += "WHERE cv.documentreceiptid = cthscv.id_cong_van_den";
			// sql += "WHERE cv.documentreceiptid = cv.documentreceiptid";//
			// yenlt 25052010
			sql += "WHERE 1 = 1 ";
			if (soHSCV != 0) { // So ho so cong viec
				// sql += " AND cthscv.id_ho_so_cong_viec = " + soHSCV;
				// yenlt update 25052010
				sql = sql
						.replace("FROM pml_edm_documentreceipt cv ",
								"FROM pml_edm_documentreceipt cv, pml_chi_tiet_hscv cthscv ");
				// end yenlt 25052010
				sql += " AND cv.documentreceiptid = cthscv.id_cong_van_den AND cthscv.id_ho_so_cong_viec = "
						+ soHSCV;
			}

			if (!soCVDen.equals("")) { // So CV den
				sql += " AND cv.documentreference LIKE '%" + soCVDen + "%'";
			}

			if (soHSCV == 0) { // So ho so cong viec
				sql = sql.replace(",pml_chi_tiet_hscv cthscv ", " ");
			}

			// end
			if (!tuNgay.equals("")) { // Tu ngay
				String temp = new SimpleDateFormat("yyyy-MM-dd")
						.format(new SimpleDateFormat("dd/MM/yyyy")
								.parse(tuNgay));
				sql += " AND cv.datearrive >= '" + temp + "'";
			}

			if (!denNgay.equals("")) { // Den ngay
				String temp = new SimpleDateFormat("yyyy-MM-dd")
						.format(new SimpleDateFormat("dd/MM/yyyy")
								.parse(denNgay));
				sql += " AND cv.datearrive <= '" + temp + "'";
			}

			if (trangThai != 0) { // Trang thai
				sql += " AND cv.statusid in (";
				sql += "SELECT sp.stateprocessid ";
				sql += "FROM pml_stateprocess sp, pml_filestatus fs ";
				sql += "WHERE sp.filestatusid = fs.filestatusid AND ";
				sql += "fs.filestatusid = " + trangThai + ")";
			}

			if (!soVaoSo.equals("")) { // So vao so
				sql += " AND cv.numberdocumentreceipt LIKE '%" + soVaoSo + "%'";
			}

			if (loaiCV != 0) { // Loai CV
				sql += " AND cv.documenttypeid = " + loaiCV;
			}

			/*
			 * xuancong close start if (!noiPhatHanh.equals("tatca") &&
			 * !noiPhatHanh.equals("")) { // Noi // phat // hanh sql +=
			 * " AND cv.issuingplaceid = '" + noiPhatHanh + "'"; } xuancong
			 * close end
			 */
			// xuancong: tim theo ten don vi gui chu ko phai ma don vi gui
			if (!"".equals(noiPhatHanh.trim())) {
				sql += " AND ((cv.issuingplaceothername LIKE '%"
						+ noiPhatHanh
						+ "%') OR (cv.issuingplaceid in (SELECT issuingplaceid FROM pml_edm_issuingplace WHERE issuingplacename LIKE '%"
						+ noiPhatHanh + "%')))";
			} // end if

			if (!nguoiKy.equals("")) { // Nguoi ky
				sql += " AND cv.signer LIKE '%" + nguoiKy + "%'";
			}

			if (!trichYeu.equals("")) { // Trich yeu
				sql += " AND cv.briefcontent LIKE '%" + trichYeu + "%'";
			}

			sql = CustomSQLUtil.replaceOrderBy(sql, obc);

			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("PmlEdmDocumentReceipt",
					PmlEdmDocumentReceiptImpl.class);

			return (List<PmlEdmDocumentReceipt>) QueryUtil.list(q,
					getDialect(), start, end);

		} catch (Exception e) {
			throw processException(e);
		} finally {
			closeSession(session);
		}
	}

	/******************************************************************************************************************/
	/** CHUYEN VIEN */
	/******************************************************************************************************************/

	/**
	 * chuyen vien ton dau ky cong van den so luong
	 */
	public int countTonDauKyChuyenVien_CVDen(long userId,
			int documentRecordTypeId, int capGui, int loaiVB, String doMat,
			Date fromDate, Date toDate) throws Exception {

		Session session = null;
		try {
			session = openSession();

			String ngaybatdauthongke = new SimpleDateFormat("yyyy-MM-dd")
					.format(fromDate);

			String sql = "SELECT COUNT(DISTINCT(cvden.documentreceiptid)) AS COUNT_VALUE";
			sql += " FROM pml_documentreceipt_log log";
			sql += " INNER JOIN (SELECT MAX(transition_) AS maxtran, documentreceiptid";
			sql += " FROM pml_documentreceipt_log";
			sql += " WHERE processer = " + userId;
			sql += " GROUP BY documentreceiptid) AS a";
			sql += " ON log.documentreceiptid = a.documentreceiptid AND a.maxtran = log.transition_";
			sql += " INNER JOIN pml_edm_documentreceipt cvden ON cvden.documentreceiptid = log.documentreceiptid";
			if (!doMat.equals("")) {
				sql += " AND cvden.confidentiallevelid = '" + doMat + "'";
			}

			// Neu co chon phan nhom
			if (documentRecordTypeId != 0) {
				sql += " INNER JOIN pml_edm_documenttype t ON cvden.documenttypeid = t.documenttypeid";
				sql += " AND t.documentrecordtypeid = " + documentRecordTypeId;
			}
			// Neu co chon loai van ban
			if (loaiVB != 0) {
				sql += " INNER JOIN pml_edm_documenttype dt ON cvden.documenttypeid = dt.documenttypeid";
				sql += " INNER JOIN pml_edm_documentrecordtype drt ON dt.documentrecordtypeid = drt.documentrecordtypeid";
				sql += " AND drt.documentrecordtypeid = " + loaiVB;
			}

			sql += " LEFT OUTER JOIN pml_documentreceipt_log b on log.documentreceiptid = b.documentreceiptid";
			sql += " AND log.transition_ > b.transition_ AND log.senddatebefore = b.dateprocess";
			sql += " AND log.processer = b.receiver AND b.stateprocessidafter = log.stateprocessidbefore";
			// Chua xu ly hoac ngay xu ly khong nho hon ngay bat dau thong ke
			sql += " WHERE (log.dateprocess is null OR log.dateprocess >= '"
					+ ngaybatdauthongke + "')";
			// Chuyen vien nhan truoc ngay thong ke hoac van thu nhap truoc ngay
			// thong ke
			sql += " AND ((b.documentreceiptid is not null AND b.receivedate is not null AND b.receivedate < '"
					+ ngaybatdauthongke + "')";
			sql += " OR (b.documentreceiptid is null AND log.senddatebefore is null AND cvden.datearrive < '"
					+ ngaybatdauthongke + "'))";
			// Neu co chon cap gui
			if (capGui != 0) {
				sql += " AND cvden.levelsendid = " + capGui;
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
	 * chuyen vien ton dau ky cong van den danh sach
	 */
	public List<PmlEdmDocumentReceipt> listTonDauKyChuyenVien_CVDen(
			long userId, int documentRecordTypeId, int capGui, int loaiVB,
			String doMat, Date fromDate, Date toDate, int start, int end,
			OrderByComparator obc) throws Exception {
		Session session = null;
		try {
			session = openSession();

			String ngaybatdauthongke = new SimpleDateFormat("yyyy-MM-dd")
					.format(fromDate);

			String sql = "SELECT DISTINCT(cvden.*), conf.confidentiallevelsymbol";
			sql += " FROM pml_documentreceipt_log log";
			sql += " INNER JOIN (SELECT MAX(transition_) AS maxtran, documentreceiptid";
			sql += " FROM pml_documentreceipt_log";
			sql += " WHERE processer = " + userId;
			sql += " GROUP BY documentreceiptid) AS a";
			sql += " ON log.documentreceiptid = a.documentreceiptid AND a.maxtran = log.transition_";
			sql += " INNER JOIN pml_edm_documentreceipt cvden ON cvden.documentreceiptid = log.documentreceiptid";

			sql += " INNER JOIN pml_edm_confidentiallevel conf ON cvden.confidentiallevelid = conf.confidentiallevelid";
			if (!doMat.equals("")) {
				sql += " AND conf.confidentiallevelid = '" + doMat + "'";
			}

			// Neu co chon phan nhom
			if (documentRecordTypeId != 0) {
				sql += " INNER JOIN pml_edm_documenttype t ON cvden.documenttypeid = t.documenttypeid";
				sql += " AND t.documentrecordtypeid = " + documentRecordTypeId;
			}
			// Neu co chon loai van ban
			if (loaiVB != 0) {
				sql += " INNER JOIN pml_edm_documenttype dt ON cvden.documenttypeid = dt.documenttypeid";
				sql += " INNER JOIN pml_edm_documentrecordtype drt ON dt.documentrecordtypeid = drt.documentrecordtypeid";
				sql += " AND drt.documentrecordtypeid = " + loaiVB;
			}

			sql += " LEFT OUTER JOIN pml_documentreceipt_log b on log.documentreceiptid = b.documentreceiptid";
			sql += " AND log.transition_ > b.transition_ AND log.senddatebefore = b.dateprocess";
			sql += " AND log.processer = b.receiver AND b.stateprocessidafter = log.stateprocessidbefore";
			// Chua xu ly hoac ngay xu ly khong nho hon ngay bat dau thong ke
			sql += " WHERE (log.dateprocess is null OR log.dateprocess >= '"
					+ ngaybatdauthongke + "')";
			// Chuyen vien nhan truoc ngay thong ke hoac van thu nhap truoc ngay
			// thong ke
			sql += " AND ((b.documentreceiptid is not null AND b.receivedate is not null AND b.receivedate < '"
					+ ngaybatdauthongke + "')";
			sql += " OR (b.documentreceiptid is null AND log.senddatebefore is null AND cvden.datearrive < '"
					+ ngaybatdauthongke + "'))";
			// Neu co chon cap gui
			if (capGui != 0) {
				sql += " AND cvden.levelsendid = " + capGui;
			}

			sql += " ORDER BY conf.confidentiallevelsymbol ASC, cvden.generalorderno ASC";

			sql = CustomSQLUtil.replaceOrderBy(sql, obc);

			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("PmlEdmDocumentReceipt",
					PmlEdmDocumentReceiptImpl.class);

			return (List<PmlEdmDocumentReceipt>) QueryUtil.list(q,
					getDialect(), start, end);
		} catch (Exception e) {
			throw processException(e);
		} finally {
			closeSession(session);
		}
	}

	/**
	 * chuyen vien nhan trong ky cong van den so luong
	 */
	public int countNhanTrongKyChuyenVien_CVDen(long userId,
			int documentRecordTypeId, int capGui, int loaiVB, String doMat,
			Date fromDate, Date toDate) throws Exception {

		Session session = null;

		try {
			session = openSession();

			// Chuyen doi dinh dang ngay
			String ngaybatdauthongke = new SimpleDateFormat("yyyy-MM-dd")
					.format(fromDate);
			String ngayketthucthongke = new SimpleDateFormat("yyyy-MM-dd")
					.format(toDate);

			String sql = "SELECT COUNT(DISTINCT(cvden.documentreceiptid)) AS COUNT_VALUE";
			sql += " FROM pml_documentreceipt_log log";
			sql += " INNER JOIN (SELECT MAX(transition_) AS maxtran, documentreceiptid";
			sql += " FROM pml_documentreceipt_log";
			sql += " WHERE processer = " + userId;
			sql += " GROUP BY documentreceiptid) AS a";
			sql += " ON log.documentreceiptid = a.documentreceiptid AND a.maxtran = log.transition_";
			sql += " INNER JOIN pml_edm_documentreceipt cvden ON cvden.documentreceiptid = log.documentreceiptid";

			if (!doMat.equals("")) {
				sql += " AND cvden.confidentiallevelid = '" + doMat + "'";
			}

			// Neu co chon phan nhom
			if (documentRecordTypeId != 0) {
				sql += " INNER JOIN pml_edm_documenttype t ON cvden.documenttypeid = t.documenttypeid";
				sql += " AND t.documentrecordtypeid = " + documentRecordTypeId;
			}
			// Neu co chon loai van ban
			if (loaiVB != 0) {
				sql += " INNER JOIN pml_edm_documenttype dt ON cvden.documenttypeid = dt.documenttypeid";
				sql += " INNER JOIN pml_edm_documentrecordtype drt ON dt.documentrecordtypeid = drt.documentrecordtypeid";
				sql += " AND drt.documentrecordtypeid = " + loaiVB;
			}

			sql += " LEFT OUTER JOIN pml_documentreceipt_log b ON log.documentreceiptid = b.documentreceiptid";
			sql += " AND log.transition_ > b.transition_ AND log.processer = b.receiver";
			sql += " AND b.stateprocessidafter = log.stateprocessidbefore AND log.senddatebefore = b.dateprocess";
			sql += " WHERE (log.dateprocess IS null OR log.dateprocess >= '"
					+ ngaybatdauthongke + "')";
			sql += " AND ((b.documentreceiptid IS not null AND b.receivedate IS not null";
			sql += " AND b.receivedate BETWEEN '" + ngaybatdauthongke
					+ "' AND '" + ngayketthucthongke + "')";
			sql += " OR (b.documentreceiptid IS null AND log.senddatebefore IS null";
			sql += " AND cvden.datearrive BETWEEN '" + ngaybatdauthongke
					+ "' AND '" + ngayketthucthongke + "'))";
			// Neu co chon cap gui
			if (capGui != 0) {
				sql += " AND cvden.levelsendid = " + capGui;
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
	 * chuyen vien nhan trong ky cong van den danh sach
	 */
	public List<PmlEdmDocumentReceipt> listNhanTrongKyChuyenVien_CVDen(
			long userId, int documentRecordTypeId, int capGui, int loaiVB,
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

			String sql = "SELECT DISTINCT(cvden.*), conf.confidentiallevelsymbol";
			sql += " FROM pml_documentreceipt_log log";
			sql += " INNER JOIN (SELECT MAX(transition_) AS maxtran, documentreceiptid";
			sql += " FROM pml_documentreceipt_log";
			sql += " WHERE processer = " + userId;
			sql += " GROUP BY documentreceiptid) AS a";
			sql += " ON log.documentreceiptid = a.documentreceiptid AND a.maxtran = log.transition_";
			sql += " INNER JOIN pml_edm_documentreceipt cvden ON cvden.documentreceiptid = log.documentreceiptid";

			sql += " INNER JOIN pml_edm_confidentiallevel conf ON cvden.confidentiallevelid = conf.confidentiallevelid";
			if (!doMat.equals("")) {
				sql += " AND conf.confidentiallevelid = '" + doMat + "'";
			}

			// Neu co chon phan nhom
			if (documentRecordTypeId != 0) {
				sql += " INNER JOIN pml_edm_documenttype t ON cvden.documenttypeid = t.documenttypeid";
				sql += " AND t.documentrecordtypeid = " + documentRecordTypeId;
			}
			// Neu co chon loai van ban
			if (loaiVB != 0) {
				sql += " INNER JOIN pml_edm_documenttype dt ON cvden.documenttypeid = dt.documenttypeid";
				sql += " INNER JOIN pml_edm_documentrecordtype drt ON dt.documentrecordtypeid = drt.documentrecordtypeid";
				sql += " AND drt.documentrecordtypeid = " + loaiVB;
			}

			sql += " LEFT OUTER JOIN pml_documentreceipt_log b ON log.documentreceiptid = b.documentreceiptid";
			sql += " AND log.transition_ > b.transition_ AND log.processer = b.receiver";
			sql += " AND b.stateprocessidafter = log.stateprocessidbefore AND log.senddatebefore = b.dateprocess";
			sql += " WHERE (log.dateprocess IS null OR log.dateprocess >= '"
					+ ngaybatdauthongke + "')";
			sql += " AND ((b.documentreceiptid IS not null AND b.receivedate IS not null";
			sql += " AND b.receivedate BETWEEN '" + ngaybatdauthongke
					+ "' AND '" + ngayketthucthongke + "')";
			sql += " OR (b.documentreceiptid IS null AND log.senddatebefore IS null";
			sql += " AND cvden.datearrive BETWEEN '" + ngaybatdauthongke
					+ "' AND '" + ngayketthucthongke + "'))";
			// Neu co chon cap gui
			if (capGui != 0) {
				sql += " AND cvden.levelsendid = " + capGui;
			}

			sql += " ORDER BY conf.confidentiallevelsymbol ASC, cvden.generalorderno ASC";

			sql = CustomSQLUtil.replaceOrderBy(sql, obc);

			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("PmlEdmDocumentReceipt",
					PmlEdmDocumentReceiptImpl.class);

			return (List<PmlEdmDocumentReceipt>) QueryUtil.list(q,
					getDialect(), start, end);
		} catch (Exception e) {
			throw processException(e);
		} finally {
			closeSession(session);
		}
	}

	/**
	 * chuyen vien chua nhan cong van den so luong
	 */
	public int countChuaNhanChuyenVien_CVDen(long userId,
			int documentRecordTypeId, int capGui, int loaiVB, String doMat,
			Date fromDate, Date toDate) throws Exception {
		Session session = null;

		try {
			session = openSession();

			String ngayketthucthongke = new SimpleDateFormat("yyyy-MM-dd")
					.format(toDate);

			String sql = "SELECT COUNT(DISTINCT(cvden.documentreceiptid)) AS COUNT_VALUE";
			sql += " FROM pml_documentreceipt_log log";
			sql += " INNER JOIN (SELECT MAX(transition_) AS maxtran, documentreceiptid";
			sql += " FROM pml_documentreceipt_log";
			sql += " WHERE processer = " + userId;
			sql += " GROUP BY documentreceiptid) AS a";
			sql += " ON log.documentreceiptid = a.documentreceiptid AND a.maxtran = log.transition_";
			sql += " INNER JOIN pml_edm_documentreceipt cvden ON cvden.documentreceiptid = log.documentreceiptid";
			if (!doMat.equals("")) {
				sql += " AND cvden.confidentiallevelid = '" + doMat + "'";
			}

			// Neu co chon phan nhom
			if (documentRecordTypeId != 0) {
				sql += " INNER JOIN pml_edm_documenttype t ON cvden.documenttypeid = t.documenttypeid";
				sql += " AND t.documentrecordtypeid = " + documentRecordTypeId;
			}
			// Neu co chon loai van ban
			if (loaiVB != 0) {
				sql += " INNER JOIN pml_edm_documenttype dt ON cvden.documenttypeid = dt.documenttypeid";
				sql += " INNER JOIN pml_edm_documentrecordtype drt ON dt.documentrecordtypeid = drt.documentrecordtypeid";
				sql += " AND drt.documentrecordtypeid = " + loaiVB;
			}

			sql += " LEFT OUTER JOIN pml_documentreceipt_log b ON log.documentreceiptid = b.documentreceiptid";
			sql += " AND log.transition_ > b.transition_ AND log.processer = b.receiver";
			sql += " AND b.stateprocessidafter = log.stateprocessidbefore AND log.senddatebefore = b.dateprocess";
			sql += " WHERE (log.dateprocess IS null OR log.dateprocess > '"
					+ ngayketthucthongke + "')";
			sql += " AND b.documentreceiptid IS NOT null AND (b.receivedate IS null OR b.receivedate > '"
					+ ngayketthucthongke + "')";
			sql += " AND b.dateprocess <= '" + ngayketthucthongke
					+ "' and cvden.datearrive <= '" + ngayketthucthongke + "'";
			// Neu co chon cap gui
			if (capGui != 0) {
				sql += " AND cvden.levelsendid = " + capGui;
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
	 * chuyen vien chua nhan cong van den danh sach
	 */
	public List<PmlEdmDocumentReceipt> listChuaNhanChuyenVien_CVDen(
			long userId, int documentRecordTypeId, int capGui, int loaiVB,
			String doMat, Date fromDate, Date toDate, int start, int end,
			OrderByComparator obc) throws Exception {

		Session session = null;

		try {
			session = openSession();

			String ngayketthucthongke = new SimpleDateFormat("yyyy-MM-dd")
					.format(toDate);

			String sql = "SELECT DISTINCT(cvden.*), conf.confidentiallevelsymbol";
			sql += " FROM pml_documentreceipt_log log";
			sql += " INNER JOIN (SELECT MAX(transition_) AS maxtran, documentreceiptid";
			sql += " FROM pml_documentreceipt_log";
			sql += " WHERE processer = " + userId;
			sql += " GROUP BY documentreceiptid) AS a";
			sql += " ON log.documentreceiptid = a.documentreceiptid AND a.maxtran = log.transition_";
			sql += " INNER JOIN pml_edm_documentreceipt cvden ON cvden.documentreceiptid = log.documentreceiptid";

			sql += " INNER JOIN pml_edm_confidentiallevel conf ON cvden.confidentiallevelid = conf.confidentiallevelid";
			if (!doMat.equals("")) {
				sql += " AND conf.confidentiallevelid = '" + doMat + "'";
			}

			// Neu co chon phan nhom
			if (documentRecordTypeId != 0) {
				sql += " INNER JOIN pml_edm_documenttype t ON cvden.documenttypeid = t.documenttypeid";
				sql += " AND t.documentrecordtypeid = " + documentRecordTypeId;
			}
			// Neu co chon loai van ban
			if (loaiVB != 0) {
				sql += " INNER JOIN pml_edm_documenttype dt ON cvden.documenttypeid = dt.documenttypeid";
				sql += " INNER JOIN pml_edm_documentrecordtype drt ON dt.documentrecordtypeid = drt.documentrecordtypeid";
				sql += " AND drt.documentrecordtypeid = " + loaiVB;
			}

			sql += " LEFT OUTER JOIN pml_documentreceipt_log b ON log.documentreceiptid = b.documentreceiptid";
			sql += " AND log.transition_ > b.transition_ AND log.processer = b.receiver";
			sql += " AND b.stateprocessidafter = log.stateprocessidbefore AND log.senddatebefore = b.dateprocess";
			sql += " WHERE (log.dateprocess IS null OR log.dateprocess > '"
					+ ngayketthucthongke + "')";
			sql += " AND b.documentreceiptid IS NOT null AND (b.receivedate IS null OR b.receivedate > '"
					+ ngayketthucthongke + "')";
			sql += " AND b.dateprocess <= '" + ngayketthucthongke
					+ "' and cvden.datearrive <= '" + ngayketthucthongke + "'";
			// Neu co chon cap gui
			if (capGui != 0) {
				sql += " AND cvden.levelsendid = " + capGui;
			}

			sql += " ORDER BY conf.confidentiallevelsymbol ASC, cvden.generalorderno ASC";

			sql = CustomSQLUtil.replaceOrderBy(sql, obc);

			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("PmlEdmDocumentReceipt",
					PmlEdmDocumentReceiptImpl.class);

			return (List<PmlEdmDocumentReceipt>) QueryUtil.list(q,
					getDialect(), start, end);
		} catch (Exception e) {
			throw processException(e);
		} finally {
			closeSession(session);
		}
	}

	/**
	 * chuyen vien nhan trong thang cong van den so luong
	 */
	public int countNhanTrongThangChuyenVien_CVDen(long userId,
			int documentRecordTypeId, int capGui, int loaiVB, Date fromDate,
			Date toDate) throws Exception {

		Session session = null;

		try {
			session = openSession();

			// Chuyen doi dinh dang ngay
			String ngaybatdauthongke = new SimpleDateFormat("yyyy-MM-dd")
					.format(fromDate);
			String ngayketthucthongke = new SimpleDateFormat("yyyy-MM-dd")
					.format(toDate);

			String sql = "SELECT COUNT(DISTINCT(cvden.documentreceiptid)) AS COUNT_VALUE";
			sql += " FROM pml_documentreceipt_log log";
			sql += " INNER JOIN (SELECT MAX(transition_) AS maxtran, documentreceiptid";
			sql += " FROM pml_documentreceipt_log";
			sql += " WHERE processer = " + userId;
			sql += " GROUP BY documentreceiptid) AS a";
			sql += " ON log.documentreceiptid = a.documentreceiptid AND a.maxtran = log.transition_";
			sql += " INNER JOIN pml_edm_documentreceipt cvden ON cvden.documentreceiptid = log.documentreceiptid";
			// Neu co chon phan nhom
			if (documentRecordTypeId != 0) {
				sql += " INNER JOIN pml_edm_documenttype t ON cvden.documenttypeid = t.documenttypeid";
				sql += " AND t.documentrecordtypeid = " + documentRecordTypeId;
			}
			// Neu co chon loai van ban
			if (loaiVB != 0) {
				sql += " INNER JOIN pml_edm_documenttype dt ON cvden.documenttypeid = dt.documenttypeid";
				sql += " INNER JOIN pml_edm_documentrecordtype drt ON dt.documentrecordtypeid = drt.documentrecordtypeid";
				sql += " AND drt.documentrecordtypeid = " + loaiVB;
			}

			sql += " LEFT OUTER JOIN pml_documentreceipt_log b ON log.documentreceiptid = b.documentreceiptid";
			sql += " AND log.transition_ > b.transition_ AND log.processer = b.receiver";
			sql += " AND b.stateprocessidafter = log.stateprocessidbefore AND log.senddatebefore = b.dateprocess";
			sql += " WHERE (log.dateprocess IS null OR log.dateprocess >= '"
					+ ngaybatdauthongke + "')";
			sql += " AND ((b.documentreceiptid IS NOT null AND (b.receivedate is null OR b.receivedate > '"
					+ ngaybatdauthongke
					+ "')"
					+ " AND b.dateprocess <= '"
					+ ngayketthucthongke
					+ "' AND cvden.datearrive <= '"
					+ ngayketthucthongke + "')";
			sql += " OR (b.documentreceiptid IS null AND log.senddatebefore IS null"
					+ " AND cvden.datearrive BETWEEN '"
					+ ngaybatdauthongke
					+ "' AND '" + ngayketthucthongke + "'))";
			// Neu co chon cap gui
			if (capGui != 0) {
				sql += " AND cvden.levelsendid = " + capGui;
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
	 * chuyen vien nhan trong thang cong van den danh sach
	 */
	public List<PmlEdmDocumentReceipt> listNhanTrongThangChuyenVien_CVDen(
			long userId, int documentRecordTypeId, int capGui, int loaiVB,
			Date fromDate, Date toDate, int start, int end,
			OrderByComparator obc) throws Exception {

		Session session = null;

		try {
			session = openSession();

			// Chuyen doi dinh dang ngay
			String ngaybatdauthongke = new SimpleDateFormat("yyyy-MM-dd")
					.format(fromDate);
			String ngayketthucthongke = new SimpleDateFormat("yyyy-MM-dd")
					.format(toDate);

			String sql = "SELECT DISTINCT(cvden.*)";
			sql += " FROM pml_documentreceipt_log log";
			sql += " INNER JOIN (SELECT MAX(transition_) AS maxtran, documentreceiptid";
			sql += " FROM pml_documentreceipt_log";
			sql += " WHERE processer = " + userId;
			sql += " GROUP BY documentreceiptid) AS a";
			sql += " ON log.documentreceiptid = a.documentreceiptid AND a.maxtran = log.transition_";
			sql += " INNER JOIN pml_edm_documentreceipt cvden ON cvden.documentreceiptid = log.documentreceiptid";
			// Neu co chon phan nhom
			if (documentRecordTypeId != 0) {
				sql += " INNER JOIN pml_edm_documenttype t ON cvden.documenttypeid = t.documenttypeid";
				sql += " AND t.documentrecordtypeid = " + documentRecordTypeId;
			}
			// Neu co chon loai van ban
			if (loaiVB != 0) {
				sql += " INNER JOIN pml_edm_documenttype dt ON cvden.documenttypeid = dt.documenttypeid";
				sql += " INNER JOIN pml_edm_documentrecordtype drt ON dt.documentrecordtypeid = drt.documentrecordtypeid";
				sql += " AND drt.documentrecordtypeid = " + loaiVB;
			}

			sql += " LEFT OUTER JOIN pml_documentreceipt_log b ON log.documentreceiptid = b.documentreceiptid";
			sql += " AND log.transition_ > b.transition_ AND log.processer = b.receiver";
			sql += " AND b.stateprocessidafter = log.stateprocessidbefore AND log.senddatebefore = b.dateprocess";
			sql += " WHERE (log.dateprocess IS null OR log.dateprocess >= '"
					+ ngaybatdauthongke + "')";
			sql += " AND ((b.documentreceiptid IS NOT null AND (b.receivedate is null OR b.receivedate > '"
					+ ngaybatdauthongke
					+ "')"
					+ " AND b.dateprocess <= '"
					+ ngayketthucthongke
					+ "' AND cvden.datearrive <= '"
					+ ngayketthucthongke + "')";
			sql += " OR (b.documentreceiptid IS null AND log.senddatebefore IS null"
					+ " AND cvden.datearrive BETWEEN '"
					+ ngaybatdauthongke
					+ "' AND '" + ngayketthucthongke + "'))";
			// Neu co chon cap gui
			if (capGui != 0) {
				sql += " AND cvden.levelsendid = " + capGui;
			}

			sql += " ORDER BY generalorderno ASC";

			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("PmlEdmDocumentReceipt",
					PmlEdmDocumentReceiptImpl.class);

			return (List<PmlEdmDocumentReceipt>) QueryUtil.list(q,
					getDialect(), start, end);
		} catch (Exception e) {
			throw processException(e);
		} finally {
			closeSession(session);
		}
	}

	/**
	 * chuyen vien da giai quyet dung han cong van den so luong
	 */
	public int countDungHanDaXuLyChuyenVien_CVDen(long userId,
			int documentRecordTypeId, int capGui, int loaiVB, String doMat,
			Date fromDate, Date toDate) throws Exception {
		Session session = null;

		try {
			session = openSession();

			String ngaybatdauthongke = new SimpleDateFormat("yyyy-MM-dd")
					.format(fromDate);
			String ngayketthucthongke = new SimpleDateFormat("yyyy-MM-dd")
					.format(toDate);

			String sql = "SELECT COUNT(DISTINCT(cvden.documentreceiptid)) AS COUNT_VALUE";
			sql += " FROM (SELECT MAX(log.transition_) AS maxtran, log.documentreceiptid";
			sql += " FROM pml_documentreceipt_log log";
			sql += " WHERE log.processer = " + userId;
			sql += " GROUP BY log.documentreceiptid) AS a, pml_documentreceipt_log log, pml_edm_documentreceipt cvden";

			if (documentRecordTypeId != 0) { // Chon phan nhom
				sql += ", pml_edm_documenttype t";
			}
			if (0 != loaiVB) {
				sql += ", pml_edm_documenttype dt, pml_edm_documentrecordtype drt";
			}

			sql += " WHERE cvden.documentreceiptid = log.documentreceiptid";
			sql += " AND a.maxtran = log.transition_";
			sql += " AND a.documentreceiptid = log.documentreceiptid";
			if (!doMat.equals("")) {
				sql += " AND cvden.confidentiallevelid = '" + doMat + "'";
			}

			sql += " AND log.dateprocess is not null AND log.dateprocess between '"
					+ ngaybatdauthongke + "' AND '" + ngayketthucthongke + "'";
			sql += " AND ((log.senddatebefore is not null"
					+ " AND (log.senddatebefore + log.numdateprocess + songaynghile(log.senddatebefore, log.numdateprocess)) >= log.dateprocess)"
					+ " OR (log.senddatebefore is null AND cvden.datearrive <= '"
					+ ngayketthucthongke + "')"
					+ " OR (log.numdateprocess = 0 AND log.senddatebefore <= '"
					+ ngayketthucthongke + "'))";

			if (documentRecordTypeId != 0) { // Chon phan nhom
				sql += " AND cvden.documenttypeid = t.documenttypeid";
				sql += " AND t.documentrecordtypeid = " + documentRecordTypeId;
			}
			if (0 != capGui) {
				sql += " AND cvden.levelsendid = " + capGui;
			}
			if (0 != loaiVB) {
				sql += " AND cvden.documenttypeid = dt.documenttypeid AND dt.documentrecordtypeid = drt.documentrecordtypeid AND drt.documentrecordtypeid = "
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
	 * chuyen vien da giai quyet dung han cong van den danh sach
	 */
	public List<PmlEdmDocumentReceipt> listDungHanDaXuLyChuyenVien_CVDen(
			long userId, int documentRecordTypeId, int capGui, int loaiVB,
			String doMat, Date fromDate, Date toDate, int start, int end,
			OrderByComparator obc) throws Exception {

		Session session = null;

		try {
			session = openSession();

			String ngaybatdauthongke = new SimpleDateFormat("yyyy-MM-dd")
					.format(fromDate);
			String ngayketthucthongke = new SimpleDateFormat("yyyy-MM-dd")
					.format(toDate);

			String sql = "SELECT DISTINCT(cvden.*), conf.confidentiallevelsymbol";
			sql += " FROM (SELECT MAX(log.transition_) AS maxtran, log.documentreceiptid";
			sql += " FROM pml_documentreceipt_log log";
			sql += " WHERE log.processer = " + userId;
			sql += " GROUP BY log.documentreceiptid) AS a, pml_documentreceipt_log log, pml_edm_documentreceipt cvden, pml_edm_confidentiallevel conf";

			if (documentRecordTypeId != 0) { // Chon phan nhom
				sql += ", pml_edm_documenttype t";
			}
			if (0 != loaiVB) {
				sql += ", pml_edm_documenttype dt, pml_edm_documentrecordtype drt";
			}

			sql += " WHERE cvden.documentreceiptid = log.documentreceiptid";
			sql += " AND a.maxtran = log.transition_";
			sql += " AND a.documentreceiptid = log.documentreceiptid";

			sql += " AND cvden.confidentiallevelid = conf.confidentiallevelid";
			if (!doMat.equals("")) {
				sql += " AND conf.confidentiallevelid = '" + doMat + "'";
			}

			sql += " AND log.dateprocess is not null AND log.dateprocess between '"
					+ ngaybatdauthongke + "' AND '" + ngayketthucthongke + "'";
			sql += " AND ((log.senddatebefore is not null"
					+ " AND (log.senddatebefore + log.numdateprocess + songaynghile(log.senddatebefore, log.numdateprocess)) >= log.dateprocess)"
					+ " OR (log.senddatebefore is null AND cvden.datearrive <= '"
					+ ngayketthucthongke + "')"
					+ " OR (log.numdateprocess = 0 AND log.senddatebefore <= '"
					+ ngayketthucthongke + "'))";

			if (documentRecordTypeId != 0) { // Chon phan nhom
				sql += " AND cvden.documenttypeid = t.documenttypeid";
				sql += " AND t.documentrecordtypeid = " + documentRecordTypeId;
			}
			if (0 != capGui) {
				sql += " AND cvden.levelsendid = " + capGui;
			}
			if (0 != loaiVB) {
				sql += " AND cvden.documenttypeid = dt.documenttypeid AND dt.documentrecordtypeid = drt.documentrecordtypeid AND drt.documentrecordtypeid = "
						+ loaiVB;
			}

			sql += " ORDER BY conf.confidentiallevelsymbol ASC, cvden.generalorderno ASC";

			sql = CustomSQLUtil.replaceOrderBy(sql, obc);

			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("PmlEdmDocumentReceipt",
					PmlEdmDocumentReceiptImpl.class);

			return (List<PmlEdmDocumentReceipt>) QueryUtil.list(q,
					getDialect(), start, end);
		} catch (Exception e) {
			throw processException(e);
		} finally {
			closeSession(session);
		}
	}

	/**
	 * chuyen vien da giai quyet tre han cong van den so luong
	 */
	public int countTreHanDaXuLyChuyenVien_CVDen(long userId,
			int documentRecordTypeId, int capGui, int loaiVB, String doMat,
			Date fromDate, Date toDate) throws Exception {
		Session session = null;

		try {
			session = openSession();

			String ngaybatdauthongke = new SimpleDateFormat("yyyy-MM-dd")
					.format(fromDate);
			String ngayketthucthongke = new SimpleDateFormat("yyyy-MM-dd")
					.format(toDate);

			String sql = "SELECT COUNT(DISTINCT(cvden.documentreceiptid)) AS COUNT_VALUE";
			sql += " FROM (SELECT MAX(log.transition_) AS maxtran, log.documentreceiptid";
			sql += " FROM pml_documentreceipt_log log";
			sql += " WHERE log.processer = " + userId;
			sql += " GROUP BY log.documentreceiptid) AS a, pml_documentreceipt_log log, pml_edm_documentreceipt cvden";

			if (documentRecordTypeId != 0) { // Chon phan nhom
				sql += ", pml_edm_documenttype t";
			}
			if (0 != loaiVB) {
				sql += ", pml_edm_documenttype dt, pml_edm_documentrecordtype drt";
			}

			sql += " WHERE cvden.documentreceiptid = log.documentreceiptid";
			sql += " AND a.maxtran = log.transition_";
			sql += " AND a.documentreceiptid = log.documentreceiptid";
			if (!doMat.equals("")) {
				sql += " AND cvden.confidentiallevelid = '" + doMat + "'";
			}

			sql += " AND (log.dateprocess is not null"
					+ " AND log.dateprocess between '" + ngaybatdauthongke
					+ "' AND '" + ngayketthucthongke + "')";
			sql += " AND (numdateprocess <>0 AND log.senddatebefore is not null"
					+ " AND (log.senddatebefore + log.numdateprocess + songaynghile(log.senddatebefore, log.numdateprocess)) < log.dateprocess)";

			if (documentRecordTypeId != 0) { // Chon phan nhom
				sql += " AND cvden.documenttypeid = t.documenttypeid";
				sql += " AND t.documentrecordtypeid = " + documentRecordTypeId;
			}
			if (0 != capGui) {
				sql += " AND cvden.levelsendid = " + capGui;
			}
			if (0 != loaiVB) {
				sql += " AND cvden.documenttypeid = dt.documenttypeid AND dt.documentrecordtypeid = drt.documentrecordtypeid AND drt.documentrecordtypeid = "
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
	 * chuyen vien da giai quyet tre han cong van den danh sach
	 */
	public List<PmlEdmDocumentReceipt> listTreHanDaXuLyChuyenVien_CVDen(
			long userId, int documentRecordTypeId, int capGui, int loaiVB,
			String doMat, Date fromDate, Date toDate, int start, int end,
			OrderByComparator obc) throws Exception {

		Session session = null;

		try {
			session = openSession();

			String ngaybatdauthongke = new SimpleDateFormat("yyyy-MM-dd")
					.format(fromDate);
			String ngayketthucthongke = new SimpleDateFormat("yyyy-MM-dd")
					.format(toDate);

			String sql = "SELECT DISTINCT(cvden.*), conf.confidentiallevelsymbol ";
			sql += " FROM (SELECT MAX(log.transition_) AS maxtran, log.documentreceiptid";
			sql += " FROM pml_documentreceipt_log log";
			sql += " WHERE log.processer = " + userId;
			sql += " GROUP BY log.documentreceiptid) AS a, pml_documentreceipt_log log, pml_edm_documentreceipt cvden, pml_edm_confidentiallevel conf";

			if (documentRecordTypeId != 0) { // Chon phan nhom
				sql += ", pml_edm_documenttype t";
			}
			if (0 != loaiVB) {
				sql += ", pml_edm_documenttype dt, pml_edm_documentrecordtype drt";
			}

			sql += " WHERE cvden.documentreceiptid = log.documentreceiptid";
			sql += " AND a.maxtran = log.transition_";
			sql += " AND a.documentreceiptid = log.documentreceiptid";
			sql += " AND cvden.confidentiallevelid = conf.confidentiallevelid";
			if (!doMat.equals("")) {
				sql += " AND conf.confidentiallevelid = '" + doMat + "'";
			}

			sql += " AND (log.dateprocess is not null"
					+ " AND log.dateprocess between '" + ngaybatdauthongke
					+ "' AND '" + ngayketthucthongke + "')";
			sql += " AND (numdateprocess <>0 AND log.senddatebefore is not null"
					+ " AND (log.senddatebefore + log.numdateprocess + songaynghile(log.senddatebefore, log.numdateprocess)) < log.dateprocess)";

			if (documentRecordTypeId != 0) { // Chon phan nhom
				sql += " AND cvden.documenttypeid = t.documenttypeid";
				sql += " AND t.documentrecordtypeid = " + documentRecordTypeId;
			}
			if (0 != capGui) {
				sql += " AND cvden.levelsendid = " + capGui;
			}
			if (0 != loaiVB) {
				sql += " AND cvden.documenttypeid = dt.documenttypeid AND dt.documentrecordtypeid = drt.documentrecordtypeid AND drt.documentrecordtypeid = "
						+ loaiVB;
			}

			sql += " ORDER BY conf.confidentiallevelsymbol ASC, cvden.generalorderno ASC";

			sql = CustomSQLUtil.replaceOrderBy(sql, obc);

			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("PmlEdmDocumentReceipt",
					PmlEdmDocumentReceiptImpl.class);

			return (List<PmlEdmDocumentReceipt>) QueryUtil.list(q,
					getDialect(), start, end);
		} catch (Exception e) {
			throw processException(e);
		} finally {
			closeSession(session);
		}
	}

	/**
	 * chuyen vien tong da giai quyet cong van den so luong = da giai quyet dung
	 * han (cv den) + da giai quyet tre han (cv den)
	 */
	public int countTongDaXuLyChuyenVien_CVDen(long userId,
			int documentRecordTypeId, int capGui, int loaiVB, String doMat,
			Date fromDate, Date toDate) throws Exception {
		Session session = null;

		try {
			session = openSession();

			String ngaybatdauthongke = new SimpleDateFormat("yyyy-MM-dd")
					.format(fromDate);
			String ngayketthucthongke = new SimpleDateFormat("yyyy-MM-dd")
					.format(toDate);

			String sql = "SELECT COUNT(DISTINCT(cvden.documentreceiptid)) AS COUNT_VALUE";
			sql += " FROM (SELECT MAX(log.transition_) AS maxtran, log.documentreceiptid";
			sql += " FROM pml_documentreceipt_log log";
			sql += " WHERE log.processer = " + userId;
			sql += " GROUP BY log.documentreceiptid) AS a, pml_documentreceipt_log log, pml_edm_documentreceipt cvden";

			if (documentRecordTypeId != 0) { // Chon phan nhom
				sql += ", pml_edm_documenttype t";
			}
			if (0 != loaiVB) {
				sql += ", pml_edm_documenttype dt, pml_edm_documentrecordtype drt";
			}

			sql += " WHERE cvden.documentreceiptid = log.documentreceiptid";
			sql += " AND a.maxtran = log.transition_";
			sql += " AND a.documentreceiptid = log.documentreceiptid";
			if (!doMat.equals("")) {
				sql += " AND cvden.confidentiallevelid = '" + doMat + "'";
			}

			sql += " AND (log.dateprocess is not null"
					+ " AND log.dateprocess between '" + ngaybatdauthongke
					+ "' AND '" + ngayketthucthongke + "')";

			if (documentRecordTypeId != 0) { // Chon phan nhom
				sql += " AND cvden.documenttypeid = t.documenttypeid";
				sql += " AND t.documentrecordtypeid = " + documentRecordTypeId;
			}
			if (0 != capGui) {
				sql += " AND cvden.levelsendid = " + capGui;
			}
			if (0 != loaiVB) {
				sql += " AND cvden.documenttypeid = dt.documenttypeid AND dt.documentrecordtypeid = drt.documentrecordtypeid AND drt.documentrecordtypeid = "
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
	 * chuyen vien tong da giai quyet cong van den danh sach = da giai quyet
	 * dung han (cv den) + da giai quyet tre han (cv den)
	 */
	public List<PmlEdmDocumentReceipt> listTongDaXuLyChuyenVien_CVDen(
			long userId, int documentRecordTypeId, int capGui, int loaiVB,
			String doMat, Date fromDate, Date toDate, int start, int end,
			OrderByComparator obc) throws Exception {

		Session session = null;

		try {
			session = openSession();

			String ngaybatdauthongke = new SimpleDateFormat("yyyy-MM-dd")
					.format(fromDate);
			String ngayketthucthongke = new SimpleDateFormat("yyyy-MM-dd")
					.format(toDate);

			String sql = "SELECT DISTINCT(cvden.*), conf.confidentiallevelsymbol ";
			sql += " FROM (select max(log.transition_) as maxtran, log.documentreceiptid";
			sql += " FROM pml_documentreceipt_log log";
			sql += " WHERE log.processer = " + userId;
			sql += " GROUP BY log.documentreceiptid) AS a, pml_documentreceipt_log log, pml_edm_documentreceipt cvden, pml_edm_confidentiallevel conf";

			if (documentRecordTypeId != 0) { // Chon phan nhom
				sql += ", pml_edm_documenttype t";
			}
			if (0 != loaiVB) {
				sql += ", pml_edm_documenttype dt, pml_edm_documentrecordtype drt";
			}

			sql += " WHERE cvden.documentreceiptid = log.documentreceiptid";
			sql += " AND a.maxtran = log.transition_";
			sql += " AND a.documentreceiptid = log.documentreceiptid";
			sql += " AND cvden.confidentiallevelid = conf.confidentiallevelid";
			if (!doMat.equals("")) {
				sql += " AND conf.confidentiallevelid = '" + doMat + "'";
			}

			sql += " AND (log.dateprocess is not null"
					+ " AND log.dateprocess between '" + ngaybatdauthongke
					+ "' AND '" + ngayketthucthongke + "')";

			if (documentRecordTypeId != 0) { // Chon phan nhom
				sql += " AND cvden.documenttypeid = t.documenttypeid";
				sql += " AND t.documentrecordtypeid = " + documentRecordTypeId;
			}
			if (0 != capGui) {
				sql += " AND cvden.levelsendid = " + capGui;
			}
			if (0 != loaiVB) {
				sql += " AND cvden.documenttypeid = dt.documenttypeid AND dt.documentrecordtypeid = drt.documentrecordtypeid AND drt.documentrecordtypeid = "
						+ loaiVB;
			}

			sql += " ORDER BY conf.confidentiallevelsymbol ASC, cvden.generalorderno ASC";

			sql = CustomSQLUtil.replaceOrderBy(sql, obc);

			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("PmlEdmDocumentReceipt",
					PmlEdmDocumentReceiptImpl.class);

			return (List<PmlEdmDocumentReceipt>) QueryUtil.list(q,
					getDialect(), start, end);
		} catch (Exception e) {
			throw processException(e);
		} finally {
			closeSession(session);
		}
	}

	/**
	 * chuyen vien dang giai quyet dung han cong van den so luong
	 */
	public int countDungHanDangXuLyChuyenVien_CVDen(long userId,
			int documentRecordTypeId, int capGui, int loaiVB, String doMat,
			Date fromDate, Date toDate) throws Exception {
		Session session = null;

		try {
			session = openSession();

			String ngayketthucthongke = new SimpleDateFormat("yyyy-MM-dd")
					.format(toDate);

			String sql = "SELECT COUNT(DISTINCT(cvden.documentreceiptid)) AS COUNT_VALUE";
			sql += " FROM (select max(log.transition_) as maxtran, log.documentreceiptid";
			sql += " FROM pml_documentreceipt_log log";
			sql += " WHERE log.processer = " + userId;
			sql += " GROUP BY log.documentreceiptid) AS a, pml_documentreceipt_log log, pml_edm_documentreceipt cvden";

			if (documentRecordTypeId != 0) { // Chon phan nhom
				sql += ", pml_edm_documenttype t";
			}
			if (0 != loaiVB) {
				sql += ", pml_edm_documenttype dt, pml_edm_documentrecordtype drt";
			}

			sql += " WHERE cvden.documentreceiptid = log.documentreceiptid";
			sql += " AND a.maxtran = log.transition_";
			sql += " AND a.documentreceiptid = log.documentreceiptid";
			if (!doMat.equals("")) {
				sql += " AND cvden.confidentiallevelid = '" + doMat + "'";
			}

			sql += " AND (log.dateprocess is null or log.dateprocess > '"
					+ ngayketthucthongke + "')";
			sql += " AND ((log.senddatebefore is not null AND log.senddatebefore <= '"
					+ ngayketthucthongke
					+ "'"
					+ " AND (log.senddatebefore + log.numdateprocess + songaynghile(log.senddatebefore, log.numdateprocess)) >= '"
					+ ngayketthucthongke
					+ "')"
					+ " OR (log.senddatebefore is null AND cvden.datearrive <= '"
					+ ngayketthucthongke
					+ "')"
					+ " OR (log.numdateprocess = 0 AND log.senddatebefore <= '"
					+ ngayketthucthongke + "'))";

			if (documentRecordTypeId != 0) { // Chon phan nhom
				sql += " AND cvden.documenttypeid = t.documenttypeid";
				sql += " AND t.documentrecordtypeid = " + documentRecordTypeId;
			}
			if (0 != capGui) {
				sql += " AND cvden.levelsendid = " + capGui;
			}
			if (0 != loaiVB) {
				sql += " AND cvden.documenttypeid = dt.documenttypeid AND dt.documentrecordtypeid = drt.documentrecordtypeid AND drt.documentrecordtypeid = "
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
	 * chuyen vien dang giai quyet dung han cong van den danh sach
	 */
	public List<PmlEdmDocumentReceipt> listDungHanDangXuLyChuyenVien_CVDen(
			long userId, int documentRecordTypeId, int capGui, int loaiVB,
			String doMat, Date fromDate, Date toDate, int start, int end,
			OrderByComparator obc) throws Exception {
		Session session = null;

		try {
			session = openSession();

			String ngayketthucthongke = new SimpleDateFormat("yyyy-MM-dd")
					.format(toDate);

			String sql = "SELECT DISTINCT(cvden.*), conf.confidentiallevelsymbol ";
			sql += " FROM (select max(log.transition_) as maxtran, log.documentreceiptid";
			sql += " FROM pml_documentreceipt_log log";
			sql += " WHERE log.processer = " + userId;
			sql += " GROUP BY log.documentreceiptid) AS a, pml_documentreceipt_log log, pml_edm_documentreceipt cvden, pml_edm_confidentiallevel conf";

			if (documentRecordTypeId != 0) { // Chon phan nhom
				sql += ", pml_edm_documenttype t";
			}
			if (0 != loaiVB) {
				sql += ", pml_edm_documenttype dt, pml_edm_documentrecordtype drt";
			}

			sql += " WHERE cvden.documentreceiptid = log.documentreceiptid";
			sql += " AND a.maxtran = log.transition_";
			sql += " AND a.documentreceiptid = log.documentreceiptid";
			sql += " AND cvden.confidentiallevelid = conf.confidentiallevelid";
			if (!doMat.equals("")) {
				sql += " AND conf.confidentiallevelid = '" + doMat + "'";
			}

			sql += " AND (log.dateprocess is null or log.dateprocess > '"
					+ ngayketthucthongke + "')";
			sql += " AND ((log.senddatebefore is not null AND log.senddatebefore <= '"
					+ ngayketthucthongke
					+ "'"
					+ " AND (log.senddatebefore + log.numdateprocess + songaynghile(log.senddatebefore, log.numdateprocess)) >= '"
					+ ngayketthucthongke
					+ "')"
					+ " OR (log.senddatebefore is null AND cvden.datearrive <= '"
					+ ngayketthucthongke
					+ "')"
					+ " OR (log.numdateprocess = 0 AND log.senddatebefore <= '"
					+ ngayketthucthongke + "'))";

			if (documentRecordTypeId != 0) { // Chon phan nhom
				sql += " AND cvden.documenttypeid = t.documenttypeid";
				sql += " AND t.documentrecordtypeid = " + documentRecordTypeId;
			}
			if (0 != capGui) {
				sql += " AND cvden.levelsendid = " + capGui;
			}
			if (0 != loaiVB) {
				sql += " AND cvden.documenttypeid = dt.documenttypeid AND dt.documentrecordtypeid = drt.documentrecordtypeid AND drt.documentrecordtypeid = "
						+ loaiVB;
			}

			sql += " ORDER BY conf.confidentiallevelsymbol ASC, cvden.generalorderno ASC";

			sql = CustomSQLUtil.replaceOrderBy(sql, obc);

			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("PmlEdmDocumentReceipt",
					PmlEdmDocumentReceiptImpl.class);

			return (List<PmlEdmDocumentReceipt>) QueryUtil.list(q,
					getDialect(), start, end);
		} catch (Exception e) {
			throw processException(e);
		} finally {
			closeSession(session);
		}
	}

	/**
	 * chuyen vien dang giai quyet tre han cong van den so luong
	 */
	public int countTreHanDangXuLyChuyenVien_CVDen(long userId,
			int documentRecordTypeId, int capGui, int loaiVB, String doMat,
			Date fromDate, Date toDate) throws Exception {
		Session session = null;

		try {
			session = openSession();

			String ngayketthucthongke = new SimpleDateFormat("yyyy-MM-dd")
					.format(toDate);

			String sql = "SELECT COUNT(DISTINCT(cvden.documentreceiptid)) AS COUNT_VALUE";
			sql += " FROM (select max(log.transition_) as maxtran, log.documentreceiptid";
			sql += " FROM pml_documentreceipt_log log";
			sql += " WHERE log.processer = " + userId;
			sql += " GROUP BY log.documentreceiptid) AS a, pml_documentreceipt_log log, pml_edm_documentreceipt cvden";

			if (documentRecordTypeId != 0) { // Chon phan nhom
				sql += ", pml_edm_documenttype t";
			}
			if (0 != loaiVB) {
				sql += ", pml_edm_documenttype dt, pml_edm_documentrecordtype drt";
			}

			sql += " WHERE cvden.documentreceiptid = log.documentreceiptid";
			sql += " AND a.maxtran = log.transition_";
			sql += " AND a.documentreceiptid = log.documentreceiptid";
			if (!doMat.equals("")) {
				sql += " AND cvden.confidentiallevelid = '" + doMat + "'";
			}

			sql += " AND (log.dateprocess is null or log.dateprocess > '"
					+ ngayketthucthongke + "')";
			sql += " AND log.numdateprocess <> 0";
			sql += " AND log.senddatebefore is not null AND log.senddatebefore <= '"
					+ ngayketthucthongke + "'";
			sql += " AND (log.senddatebefore + log.numdateprocess + songaynghile(log.senddatebefore, log.numdateprocess)) < '"
					+ ngayketthucthongke + "'";

			if (documentRecordTypeId != 0) { // Chon phan nhom
				sql += " AND cvden.documenttypeid = t.documenttypeid";
				sql += " AND t.documentrecordtypeid = " + documentRecordTypeId;
			}
			if (0 != capGui) {
				sql += " AND cvden.levelsendid = " + capGui;
			}
			if (0 != loaiVB) {
				sql += " AND cvden.documenttypeid = dt.documenttypeid AND dt.documentrecordtypeid = drt.documentrecordtypeid AND drt.documentrecordtypeid = "
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
	 * chuyen vien dang giai quyet tre han cong van den danh sach
	 */
	public List<PmlEdmDocumentReceipt> listTreHanDangXuLyChuyenVien_CVDen(
			long userId, int documentRecordTypeId, int capGui, int loaiVB,
			String doMat, Date fromDate, Date toDate, int start, int end,
			OrderByComparator obc) throws Exception {
		Session session = null;

		try {
			session = openSession();

			String ngayketthucthongke = new SimpleDateFormat("yyyy-MM-dd")
					.format(toDate);

			String sql = "SELECT DISTINCT(cvden.*), conf.confidentiallevelsymbol ";
			sql += " FROM (select max(log.transition_) as maxtran, log.documentreceiptid";
			sql += " FROM pml_documentreceipt_log log";
			sql += " WHERE log.processer = " + userId;
			sql += " GROUP BY log.documentreceiptid) AS a, pml_documentreceipt_log log, pml_edm_documentreceipt cvden, pml_edm_confidentiallevel conf";

			if (documentRecordTypeId != 0) { // Chon phan nhom
				sql += ", pml_edm_documenttype t";
			}
			if (0 != loaiVB) {
				sql += ", pml_edm_documenttype dt, pml_edm_documentrecordtype drt";
			}

			sql += " WHERE cvden.documentreceiptid = log.documentreceiptid";
			sql += " AND a.maxtran = log.transition_";
			sql += " AND a.documentreceiptid = log.documentreceiptid";

			sql += " AND cvden.confidentiallevelid = conf.confidentiallevelid";
			if (!doMat.equals("")) {
				sql += " AND conf.confidentiallevelid = '" + doMat + "'";
			}

			sql += " AND (log.dateprocess is null or log.dateprocess > '"
					+ ngayketthucthongke + "')";
			sql += " AND log.numdateprocess <> 0";
			sql += " AND log.senddatebefore is not null AND log.senddatebefore <= '"
					+ ngayketthucthongke + "'";
			sql += " AND (log.senddatebefore + log.numdateprocess + songaynghile(log.senddatebefore, log.numdateprocess)) < '"
					+ ngayketthucthongke + "'";

			if (documentRecordTypeId != 0) { // Chon phan nhom
				sql += " AND cvden.documenttypeid = t.documenttypeid";
				sql += " AND t.documentrecordtypeid = " + documentRecordTypeId;
			}
			if (0 != capGui) {
				sql += " AND cvden.levelsendid = " + capGui;
			}
			if (0 != loaiVB) {
				sql += " AND cvden.documenttypeid = dt.documenttypeid AND dt.documentrecordtypeid = drt.documentrecordtypeid AND drt.documentrecordtypeid = "
						+ loaiVB;
			}

			sql += " ORDER BY conf.confidentiallevelsymbol ASC, cvden.generalorderno ASC";

			sql = CustomSQLUtil.replaceOrderBy(sql, obc);

			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("PmlEdmDocumentReceipt",
					PmlEdmDocumentReceiptImpl.class);

			return (List<PmlEdmDocumentReceipt>) QueryUtil.list(q,
					getDialect(), start, end);
		} catch (Exception e) {
			throw processException(e);
		} finally {
			closeSession(session);
		}
	}

	/**
	 * chuyen vien tong dang giai quyet cong van den so luong (dung han + tre
	 * han)
	 */
	public int countTongDangXuLyChuyenVien_CVDen(long userId,
			int documentRecordTypeId, int capGui, int loaiVB, String doMat,
			Date fromDate, Date toDate) throws Exception {
		Session session = null;

		try {
			session = openSession();

			String ngayketthucthongke = new SimpleDateFormat("yyyy-MM-dd")
					.format(toDate);

			String sql = "SELECT COUNT(DISTINCT(cvden.documentreceiptid)) AS COUNT_VALUE";
			sql += " FROM (select max(log.transition_) as maxtran, log.documentreceiptid";
			sql += " FROM pml_documentreceipt_log log";
			sql += " WHERE log.processer = " + userId;
			sql += " GROUP BY log.documentreceiptid) AS a, pml_documentreceipt_log log, pml_edm_documentreceipt cvden";

			if (documentRecordTypeId != 0) { // Chon phan nhom
				sql += ", pml_edm_documenttype t";
			}
			if (0 != loaiVB) {
				sql += ", pml_edm_documenttype dt, pml_edm_documentrecordtype drt";
			}

			sql += " WHERE cvden.documentreceiptid = log.documentreceiptid";
			sql += " AND a.maxtran = log.transition_";
			sql += " AND a.documentreceiptid = log.documentreceiptid";
			if (!doMat.equals("")) {
				sql += " AND cvden.confidentiallevelid = '" + doMat + "'";
			}

			sql += " AND (log.dateprocess is null or log.dateprocess > '"
					+ ngayketthucthongke + "')";
			sql += " AND ((log.senddatebefore is not null AND log.senddatebefore <= '"
					+ ngayketthucthongke
					+ "')"
					+ " OR (log.senddatebefore is null AND cvden.datearrive <= '"
					+ ngayketthucthongke + "'))";

			if (documentRecordTypeId != 0) { // Chon phan nhom
				sql += " AND cvden.documenttypeid = t.documenttypeid";
				sql += " AND t.documentrecordtypeid = " + documentRecordTypeId;
			}
			if (0 != capGui) {
				sql += " AND cvden.levelsendid = " + capGui;
			}
			if (0 != loaiVB) {
				sql += " AND cvden.documenttypeid = dt.documenttypeid AND dt.documentrecordtypeid = drt.documentrecordtypeid AND drt.documentrecordtypeid = "
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
	 * chuyen vien tong dang giai quyet cong van den danh sach (dung han + tre
	 * han)
	 */
	public List<PmlEdmDocumentReceipt> listTongDangXuLyChuyenVien_CVDen(
			long userId, int documentRecordTypeId, int capGui, int loaiVB,
			String doMat, Date fromDate, Date toDate, int start, int end,
			OrderByComparator obc) throws Exception {
		Session session = null;

		try {
			session = openSession();

			String ngayketthucthongke = new SimpleDateFormat("yyyy-MM-dd")
					.format(toDate);

			String sql = "SELECT DISTINCT(cvden.*), conf.confidentiallevelsymbol ";
			sql += " FROM (select max(log.transition_) as maxtran, log.documentreceiptid";
			sql += " FROM pml_documentreceipt_log log";
			sql += " WHERE log.processer = " + userId;
			sql += " GROUP BY log.documentreceiptid) AS a, pml_documentreceipt_log log, pml_edm_documentreceipt cvden, pml_edm_confidentiallevel conf";

			if (documentRecordTypeId != 0) { // Chon phan nhom
				sql += ", pml_edm_documenttype t";
			}
			if (0 != loaiVB) {
				sql += ", pml_edm_documenttype dt, pml_edm_documentrecordtype drt";
			}

			sql += " WHERE cvden.documentreceiptid = log.documentreceiptid";
			sql += " AND a.maxtran = log.transition_";
			sql += " AND a.documentreceiptid = log.documentreceiptid";
			sql += " AND cvden.confidentiallevelid = conf.confidentiallevelid";
			if (!doMat.equals("")) {
				sql += " AND conf.confidentiallevelid = '" + doMat + "'";
			}

			sql += " AND (log.dateprocess is null or log.dateprocess > '"
					+ ngayketthucthongke + "')";
			sql += " AND ((log.senddatebefore is not null AND log.senddatebefore <= '"
					+ ngayketthucthongke
					+ "')"
					+ " OR (log.senddatebefore is null AND cvden.datearrive <= '"
					+ ngayketthucthongke + "'))";

			if (documentRecordTypeId != 0) { // Chon phan nhom
				sql += " AND cvden.documenttypeid = t.documenttypeid";
				sql += " AND t.documentrecordtypeid = " + documentRecordTypeId;
			}
			if (0 != capGui) {
				sql += " AND cvden.levelsendid = " + capGui;
			}
			if (0 != loaiVB) {
				sql += " AND cvden.documenttypeid = dt.documenttypeid AND dt.documentrecordtypeid = drt.documentrecordtypeid AND drt.documentrecordtypeid = "
						+ loaiVB;
			}

			sql += " ORDER BY conf.confidentiallevelsymbol ASC, cvden.generalorderno ASC";

			sql = CustomSQLUtil.replaceOrderBy(sql, obc);

			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("PmlEdmDocumentReceipt",
					PmlEdmDocumentReceiptImpl.class);

			return (List<PmlEdmDocumentReceipt>) QueryUtil.list(q,
					getDialect(), start, end);
		} catch (Exception e) {
			throw processException(e);
		} finally {
			closeSession(session);
		}
	}

	/**
	 * Dem so luong cong van den can xu ly cua nguoi dung
	 * 
	 * @author XUAN CONG
	 * @param userId
	 *            Ma so nguoi dung
	 * @return So luong cong van den can xu ly cua nguoi dung
	 * @throws SystemException
	 */
	public int countDocRecNeedProcess(long userId) throws SystemException {

		Session session = null;

		try {
			session = openSession();

			String sql = "SELECT COUNT(DISTINCT(cv.documentreceiptid)) AS COUNT_VALUE ";
			sql += "FROM pml_edm_documentreceipt cv inner join pml_documentreceipt_log log ";
			sql += "ON cv.documentreceiptid = log.documentreceiptid ";
			sql += "WHERE log.processer = " + userId + " AND ";
			sql += "log.type_ = 0 AND ";
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

	/******************************************************************************************************************/
	/** PHONG BAN */
	/******************************************************************************************************************/

	/**
	 * phong ban ton dau ky cong van den so luong
	 */
	public int countTonDauKyPhongBan_CVDen(String departmentId,
			int documentRecordTypeId, int capGui, int loaiVB, String doMat,
			Date fromDate, Date toDate) throws Exception {
		Session session = null;

		try {
			session = openSession();

			String ngaybatdauthongke = new SimpleDateFormat("yyyy-MM-dd")
					.format(fromDate);
			// Tao dieu kien loc theo phong ban de loai bo cau truy van con
			String depFind = " departmentprocessid = '" + departmentId + "'";
			if (departmentId.trim().length() > 0) {
				List<Department> deps = DepartmentUtil
						.findByDepartmentsParentId(departmentId);
				if (!deps.isEmpty()) {
					for (int idx = 0; idx < deps.size(); idx++) {
						Department depItem = deps.get(idx);
						depFind += " OR departmentprocessid = '"
								+ depItem.getDepartmentsId() + "'";
					}
				}
			}
			depFind = "(" + depFind + ")";

			String sql = "SELECT COUNT(DISTINCT(cvden.documentreceiptid)) AS COUNT_VALUE";
			sql += " FROM pml_documentreceipt_log log";
			sql += " INNER JOIN (SELECT MAX(transition_) AS maxtran, documentreceiptid";
			sql += " FROM pml_documentreceipt_log";
			sql += " WHERE " + depFind;
			sql += " GROUP BY documentreceiptid) AS a";
			sql += " ON a.maxtran = log.transition_ AND a.documentreceiptid = log.documentreceiptid";
			sql += " INNER JOIN pml_edm_documentreceipt cvden ON cvden.documentreceiptid = log.documentreceiptid";
			if (!doMat.equals("")) {
				sql += " AND cvden.confidentiallevelid = '" + doMat + "'";
			}
			// Neu co chon phan nhom
			if (documentRecordTypeId != 0) {
				sql += " INNER JOIN pml_edm_documenttype t ON cvden.documenttypeid = t.documenttypeid";
				sql += " AND t.documentrecordtypeid = " + documentRecordTypeId;
			}
			// Neu co chon loai van ban
			if (loaiVB != 0) {
				sql += " INNER JOIN pml_edm_documenttype dt ON cvden.documenttypeid = dt.documenttypeid";
				sql += " INNER JOIN pml_edm_documentrecordtype drt ON dt.documentrecordtypeid = drt.documentrecordtypeid";
				sql += " AND drt.documentrecordtypeid = " + loaiVB;
			}

			sql += " LEFT OUTER JOIN pml_documentreceipt_log b ON b.documentreceiptid = log.documentreceiptid";
			sql += " AND b.receiver = log.processer AND b.transition_ < log.transition_";
			sql += " AND b.stateprocessidafter = log.stateprocessidbefore AND log.senddatebefore = b.dateprocess";
			sql += " WHERE (log.dateprocess IS null OR log.dateprocess >= '"
					+ ngaybatdauthongke + "')";
			sql += " AND ((b.documentreceiptid IS NOT null AND b.receivedate IS NOT null AND b.receivedate < '"
					+ ngaybatdauthongke + "')";
			sql += " OR (b.documentreceiptid IS null AND log.senddatebefore IS null AND cvden.datearrive < '"
					+ ngaybatdauthongke + "'))";
			// Neu co chon cap gui
			if (capGui != 0) {
				sql += " AND cvden.levelsendid = " + capGui;
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
	 * phong ban ton dau ky cong van den danh sach
	 */
	public List<PmlEdmDocumentReceipt> listTonDauKyPhongBan_CVDen(
			String departmentId, int documentRecordTypeId, int capGui,
			int loaiVB, String doMat, Date fromDate, Date toDate, int start,
			int end, OrderByComparator obc) throws Exception {
		Session session = null;

		try {
			session = openSession();

			String ngaybatdauthongke = new SimpleDateFormat("yyyy-MM-dd")
					.format(fromDate);
			// Tao dieu kien loc theo phong ban de loai bo cau truy van con
			String depFind = " departmentprocessid = '" + departmentId + "'";
			if (departmentId.trim().length() > 0) {
				List<Department> deps = DepartmentUtil
						.findByDepartmentsParentId(departmentId);
				if (!deps.isEmpty()) {
					for (int idx = 0; idx < deps.size(); idx++) {
						Department depItem = deps.get(idx);
						depFind += " OR departmentprocessid = '"
								+ depItem.getDepartmentsId() + "'";
					}
				}
			}
			depFind = "(" + depFind + ")";

			String sql = "SELECT DISTINCT(cvden.*), conf.confidentiallevelsymbol ";
			sql += " FROM pml_documentreceipt_log log";
			sql += " INNER JOIN (SELECT MAX(transition_) AS maxtran, documentreceiptid";
			sql += " FROM pml_documentreceipt_log";
			sql += " WHERE " + depFind;
			sql += " GROUP BY documentreceiptid) AS a";
			sql += " ON a.maxtran = log.transition_ AND a.documentreceiptid = log.documentreceiptid";
			sql += " INNER JOIN pml_edm_documentreceipt cvden ON cvden.documentreceiptid = log.documentreceiptid";

			sql += " INNER JOIN pml_edm_confidentiallevel conf ON cvden.confidentiallevelid = conf.confidentiallevelid";
			if (!doMat.equals("")) {
				sql += " AND conf.confidentiallevelid = '" + doMat + "'";
			}

			// Neu co chon phan nhom
			if (documentRecordTypeId != 0) {
				sql += " INNER JOIN pml_edm_documenttype t ON cvden.documenttypeid = t.documenttypeid";
				sql += " AND t.documentrecordtypeid = " + documentRecordTypeId;
			}
			// Neu co chon loai van ban
			if (loaiVB != 0) {
				sql += " INNER JOIN pml_edm_documenttype dt ON cvden.documenttypeid = dt.documenttypeid";
				sql += " INNER JOIN pml_edm_documentrecordtype drt ON dt.documentrecordtypeid = drt.documentrecordtypeid";
				sql += " AND drt.documentrecordtypeid = " + loaiVB;
			}

			sql += " LEFT OUTER JOIN pml_documentreceipt_log b ON b.documentreceiptid = log.documentreceiptid";
			sql += " AND b.receiver = log.processer AND b.transition_ < log.transition_";
			sql += " AND b.stateprocessidafter = log.stateprocessidbefore AND log.senddatebefore = b.dateprocess";
			sql += " WHERE (log.dateprocess IS null OR log.dateprocess >= '"
					+ ngaybatdauthongke + "')";
			sql += " AND ((b.documentreceiptid IS NOT null AND b.receivedate IS NOT null AND b.receivedate < '"
					+ ngaybatdauthongke + "')";
			sql += " OR (b.documentreceiptid IS null AND log.senddatebefore IS null AND cvden.datearrive < '"
					+ ngaybatdauthongke + "'))";
			// Neu co chon cap gui
			if (capGui != 0) {
				sql += " AND cvden.levelsendid = " + capGui;
			}

			sql += " ORDER BY conf.confidentiallevelsymbol ASC, cvden.generalorderno ASC";

			sql = CustomSQLUtil.replaceOrderBy(sql, obc);

			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("PmlEdmDocumentReceipt",
					PmlEdmDocumentReceiptImpl.class);

			return (List<PmlEdmDocumentReceipt>) QueryUtil.list(q,
					getDialect(), start, end);
		} catch (Exception e) {
			throw processException(e);
		} finally {
			closeSession(session);
		}
	}

	/**
	 * phong ban nhan trong ky cong van den so luong
	 */
	public int countNhanTrongKyPhongBan_CVDen(String departmentId,
			int documentRecordTypeId, int capGui, int loaiVB, String doMat,
			Date fromDate, Date toDate) throws Exception {
		Session session = null;

		try {
			session = openSession();

			String ngaybatdauthongke = new SimpleDateFormat("yyyy-MM-dd")
					.format(fromDate);
			String ngayketthucthongke = new SimpleDateFormat("yyyy-MM-dd")
					.format(toDate);
			// Tao dieu kien loc theo phong ban de loai bo cau truy van con
			String depFind = " departmentprocessid = '" + departmentId + "'";
			if (departmentId.trim().length() > 0) {
				List<Department> deps = DepartmentUtil
						.findByDepartmentsParentId(departmentId);
				if (!deps.isEmpty()) {
					for (int idx = 0; idx < deps.size(); idx++) {
						Department depItem = deps.get(idx);
						depFind += " OR departmentprocessid = '"
								+ depItem.getDepartmentsId() + "'";
					}
				}
			}
			depFind = "(" + depFind + ")";

			String sql = "SELECT COUNT(DISTINCT(cvden.documentreceiptid)) AS COUNT_VALUE";
			sql += " FROM pml_documentreceipt_log log";
			sql += " INNER JOIN (SELECT MAX(transition_) AS maxtran, documentreceiptid";
			sql += " FROM pml_documentreceipt_log";
			sql += " WHERE " + depFind;
			sql += " GROUP BY documentreceiptid) AS a";
			sql += " ON a.maxtran = log.transition_ AND a.documentreceiptid = log.documentreceiptid";
			sql += " INNER JOIN pml_edm_documentreceipt cvden ON cvden.documentreceiptid = log.documentreceiptid";
			if (!doMat.equals("")) {
				sql += " AND cvden.confidentiallevelid = '" + doMat + "'";
			}

			// Neu co chon phan nhom
			if (documentRecordTypeId != 0) {
				sql += " INNER JOIN pml_edm_documenttype t ON cvden.documenttypeid = t.documenttypeid";
				sql += " AND t.documentrecordtypeid = " + documentRecordTypeId;
			}
			// Neu co chon loai van ban
			if (loaiVB != 0) {
				sql += " INNER JOIN pml_edm_documenttype dt ON cvden.documenttypeid = dt.documenttypeid";
				sql += " INNER JOIN pml_edm_documentrecordtype drt ON dt.documentrecordtypeid = drt.documentrecordtypeid";
				sql += " AND drt.documentrecordtypeid = " + loaiVB;
			}

			sql += " LEFT OUTER JOIN pml_documentreceipt_log b ON b.documentreceiptid = log.documentreceiptid";
			sql += " AND b.receiver = log.processer AND b.transition_ < log.transition_";
			sql += " AND b.stateprocessidafter = log.stateprocessidbefore AND log.senddatebefore = b.dateprocess";
			sql += " WHERE (log.dateprocess IS null OR log.dateprocess >= '"
					+ ngaybatdauthongke + "')";
			sql += " AND ((b.documentreceiptid IS NOT null AND b.receivedate IS NOT null";
			sql += " AND b.receivedate BETWEEN '" + ngaybatdauthongke
					+ "' AND '" + ngayketthucthongke + "')";
			sql += " OR (b.documentreceiptid IS null AND log.senddatebefore IS null";
			sql += " AND cvden.datearrive BETWEEN '" + ngaybatdauthongke
					+ "' AND '" + ngayketthucthongke + "'))";
			// Neu co chon cap gui
			if (capGui != 0) {
				sql += " AND cvden.levelsendid = " + capGui;
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
	 * phong ban nhan trong ky cong van den danh sach
	 */
	public List<PmlEdmDocumentReceipt> listNhanTrongKyPhongBan_CVDen(
			String departmentId, int documentRecordTypeId, int capGui,
			int loaiVB, String doMat, Date fromDate, Date toDate, int start,
			int end, OrderByComparator obc) throws Exception {
		Session session = null;

		try {
			session = openSession();

			String ngaybatdauthongke = new SimpleDateFormat("yyyy-MM-dd")
					.format(fromDate);
			String ngayketthucthongke = new SimpleDateFormat("yyyy-MM-dd")
					.format(toDate);
			// Tao dieu kien loc theo phong ban de loai bo cau truy van con
			String depFind = " departmentprocessid = '" + departmentId + "'";
			if (departmentId.trim().length() > 0) {
				List<Department> deps = DepartmentUtil
						.findByDepartmentsParentId(departmentId);
				if (!deps.isEmpty()) {
					for (int idx = 0; idx < deps.size(); idx++) {
						Department depItem = deps.get(idx);
						depFind += " OR departmentprocessid = '"
								+ depItem.getDepartmentsId() + "'";
					}
				}
			}
			depFind = "(" + depFind + ")";

			String sql = "SELECT DISTINCT(cvden.*), conf.confidentiallevelsymbol ";
			sql += " FROM pml_documentreceipt_log log";
			sql += " INNER JOIN (SELECT MAX(transition_) AS maxtran, documentreceiptid";
			sql += " FROM pml_documentreceipt_log";
			sql += " WHERE " + depFind;
			sql += " GROUP BY documentreceiptid) AS a";
			sql += " ON a.maxtran = log.transition_ AND a.documentreceiptid = log.documentreceiptid";
			sql += " INNER JOIN pml_edm_documentreceipt cvden ON cvden.documentreceiptid = log.documentreceiptid";

			sql += " INNER JOIN pml_edm_confidentiallevel conf ON cvden.confidentiallevelid = conf.confidentiallevelid";
			if (!doMat.equals("")) {
				sql += " AND conf.confidentiallevelid = '" + doMat + "'";
			}

			// Neu co chon phan nhom
			if (documentRecordTypeId != 0) {
				sql += " INNER JOIN pml_edm_documenttype t ON cvden.documenttypeid = t.documenttypeid";
				sql += " AND t.documentrecordtypeid = " + documentRecordTypeId;
			}
			// Neu co chon loai van ban
			if (loaiVB != 0) {
				sql += " INNER JOIN pml_edm_documenttype dt ON cvden.documenttypeid = dt.documenttypeid";
				sql += " INNER JOIN pml_edm_documentrecordtype drt ON dt.documentrecordtypeid = drt.documentrecordtypeid";
				sql += " AND drt.documentrecordtypeid = " + loaiVB;
			}

			sql += " LEFT OUTER JOIN pml_documentreceipt_log b ON b.documentreceiptid = log.documentreceiptid";
			sql += " AND b.receiver = log.processer AND b.transition_ < log.transition_";
			sql += " AND b.stateprocessidafter = log.stateprocessidbefore AND log.senddatebefore = b.dateprocess";
			sql += " WHERE (log.dateprocess IS null OR log.dateprocess >= '"
					+ ngaybatdauthongke + "')";
			sql += " AND ((b.documentreceiptid IS NOT null AND b.receivedate IS NOT null";
			sql += " AND b.receivedate BETWEEN '" + ngaybatdauthongke
					+ "' AND '" + ngayketthucthongke + "')";
			sql += " OR (b.documentreceiptid IS null AND log.senddatebefore IS null";
			sql += " AND cvden.datearrive BETWEEN '" + ngaybatdauthongke
					+ "' AND '" + ngayketthucthongke + "'))";
			// Neu co chon cap gui
			if (capGui != 0) {
				sql += " AND cvden.levelsendid = " + capGui;
			}

			sql += " ORDER BY conf.confidentiallevelsymbol ASC, cvden.generalorderno ASC";

			sql = CustomSQLUtil.replaceOrderBy(sql, obc);

			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("PmlEdmDocumentReceipt",
					PmlEdmDocumentReceiptImpl.class);

			return (List<PmlEdmDocumentReceipt>) QueryUtil.list(q,
					getDialect(), start, end);
		} catch (Exception e) {
			throw processException(e);
		} finally {
			closeSession(session);
		}
	}

	/**
	 * phong ban chua nhan trong ky cong van den so luong
	 */
	public int countChuaNhanTrongKyPhongBan_CVDen(String departmentId,
			int documentRecordTypeId, int capGui, int loaiVB, String doMat,
			Date fromDate, Date toDate) throws Exception {
		Session session = null;

		try {
			session = openSession();

			String ngayketthucthongke = new SimpleDateFormat("yyyy-MM-dd")
					.format(toDate);
			// Tao dieu kien loc theo phong ban de loai bo cau truy van con
			String depFind = " departmentprocessid = '" + departmentId + "'";
			if (departmentId.trim().length() > 0) {
				List<Department> deps = DepartmentUtil
						.findByDepartmentsParentId(departmentId);
				if (!deps.isEmpty()) {
					for (int idx = 0; idx < deps.size(); idx++) {
						Department depItem = deps.get(idx);
						depFind += " OR departmentprocessid = '"
								+ depItem.getDepartmentsId() + "'";
					}
				}
			}
			depFind = "(" + depFind + ")";

			String sql = "SELECT COUNT(DISTINCT(cvden.documentreceiptid)) AS COUNT_VALUE";
			sql += " FROM pml_documentreceipt_log log";
			sql += " INNER JOIN (SELECT MAX(transition_) AS maxtran, documentreceiptid";
			sql += " FROM pml_documentreceipt_log";
			sql += " WHERE " + depFind;
			sql += " GROUP BY documentreceiptid) AS a";
			sql += " ON a.maxtran = log.transition_ AND a.documentreceiptid = log.documentreceiptid";
			sql += " INNER JOIN pml_edm_documentreceipt cvden ON cvden.documentreceiptid = log.documentreceiptid";
			if (!doMat.equals("")) {
				sql += " AND cvden.confidentiallevelid = '" + doMat + "'";
			}

			// Neu co chon phan nhom
			if (documentRecordTypeId != 0) {
				sql += " INNER JOIN pml_edm_documenttype t ON cvden.documenttypeid = t.documenttypeid";
				sql += " AND t.documentrecordtypeid = " + documentRecordTypeId;
			}
			// Neu co chon loai van ban
			if (loaiVB != 0) {
				sql += " INNER JOIN pml_edm_documenttype dt ON cvden.documenttypeid = dt.documenttypeid";
				sql += " INNER JOIN pml_edm_documentrecordtype drt ON dt.documentrecordtypeid = drt.documentrecordtypeid";
				sql += " AND drt.documentrecordtypeid = " + loaiVB;
			}

			sql += " LEFT OUTER JOIN pml_documentreceipt_log b ON b.documentreceiptid = log.documentreceiptid";
			sql += " AND b.receiver = log.processer AND b.transition_ < log.transition_";
			sql += " AND b.stateprocessidafter = log.stateprocessidbefore AND log.senddatebefore = b.dateprocess";
			sql += " WHERE (log.dateprocess IS null OR log.dateprocess > '"
					+ ngayketthucthongke + "')";
			sql += " AND b.documentreceiptid IS NOT null AND (b.receivedate IS null OR b.receivedate > '"
					+ ngayketthucthongke + "')";
			sql += " AND b.dateprocess <= '" + ngayketthucthongke
					+ "' and cvden.datearrive <= '" + ngayketthucthongke + "'";
			// Neu co chon cap gui
			if (capGui != 0) {
				sql += " AND cvden.levelsendid = " + capGui;
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
	 * phong ban chua nhan trong ky cong van den danh sach
	 */
	public List<PmlEdmDocumentReceipt> listChuaNhanTrongKyPhongBan_CVDen(
			String departmentId, int documentRecordTypeId, int capGui,
			int loaiVB, String doMat, Date fromDate, Date toDate, int start,
			int end, OrderByComparator obc) throws Exception {
		Session session = null;

		try {
			session = openSession();

			String ngayketthucthongke = new SimpleDateFormat("yyyy-MM-dd")
					.format(toDate);
			// Tao dieu kien loc theo phong ban de loai bo cau truy van con
			String depFind = " departmentprocessid = '" + departmentId + "'";
			if (departmentId.trim().length() > 0) {
				List<Department> deps = DepartmentUtil
						.findByDepartmentsParentId(departmentId);
				if (!deps.isEmpty()) {
					for (int idx = 0; idx < deps.size(); idx++) {
						Department depItem = deps.get(idx);
						depFind += " OR departmentprocessid = '"
								+ depItem.getDepartmentsId() + "'";
					}
				}
			}
			depFind = "(" + depFind + ")";

			String sql = "SELECT DISTINCT(cvden.*), conf.confidentiallevelsymbol ";
			sql += " FROM pml_documentreceipt_log log";
			sql += " INNER JOIN (SELECT MAX(transition_) AS maxtran, documentreceiptid";
			sql += " FROM pml_documentreceipt_log";
			sql += " WHERE " + depFind;
			sql += " GROUP BY documentreceiptid) AS a";
			sql += " ON a.maxtran = log.transition_ AND a.documentreceiptid = log.documentreceiptid";
			sql += " INNER JOIN pml_edm_documentreceipt cvden ON cvden.documentreceiptid = log.documentreceiptid";

			sql += " INNER JOIN pml_edm_confidentiallevel conf ON cvden.confidentiallevelid = conf.confidentiallevelid";
			if (!doMat.equals("")) {
				sql += " AND conf.confidentiallevelid = '" + doMat + "'";
			}

			// Neu co chon phan nhom
			if (documentRecordTypeId != 0) {
				sql += " INNER JOIN pml_edm_documenttype t ON cvden.documenttypeid = t.documenttypeid";
				sql += " AND t.documentrecordtypeid = " + documentRecordTypeId;
			}
			// Neu co chon loai van ban
			if (loaiVB != 0) {
				sql += " INNER JOIN pml_edm_documenttype dt ON cvden.documenttypeid = dt.documenttypeid";
				sql += " INNER JOIN pml_edm_documentrecordtype drt ON dt.documentrecordtypeid = drt.documentrecordtypeid";
				sql += " AND drt.documentrecordtypeid = " + loaiVB;
			}

			sql += " LEFT OUTER JOIN pml_documentreceipt_log b ON b.documentreceiptid = log.documentreceiptid";
			sql += " AND b.receiver = log.processer AND b.transition_ < log.transition_";
			sql += " AND b.stateprocessidafter = log.stateprocessidbefore AND log.senddatebefore = b.dateprocess";
			sql += " WHERE (log.dateprocess IS null OR log.dateprocess > '"
					+ ngayketthucthongke + "')";
			sql += " AND b.documentreceiptid IS NOT null AND (b.receivedate IS null OR b.receivedate > '"
					+ ngayketthucthongke + "')";
			sql += " AND b.dateprocess <= '" + ngayketthucthongke
					+ "' and cvden.datearrive <= '" + ngayketthucthongke + "'";
			// Neu co chon cap gui
			if (capGui != 0) {
				sql += " AND cvden.levelsendid = " + capGui;
			}

			sql += " ORDER BY conf.confidentiallevelsymbol ASC, cvden.generalorderno ASC";

			sql = CustomSQLUtil.replaceOrderBy(sql, obc);

			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("PmlEdmDocumentReceipt",
					PmlEdmDocumentReceiptImpl.class);

			return (List<PmlEdmDocumentReceipt>) QueryUtil.list(q,
					getDialect(), start, end);
		} catch (Exception e) {
			throw processException(e);
		} finally {
			closeSession(session);
		}
	}

	/**
	 * phong ban da giai quyet dung han cong van den so luong
	 */
	public int countDungHanDaXuLyPhongBan_CVDen(String departmentId,
			int documentRecordTypeId, int capGui, int loaiVB, String doMat,
			Date fromDate, Date toDate) throws Exception {
		Session session = null;

		try {
			session = openSession();

			String ngaybatdauthongke = new SimpleDateFormat("yyyy-MM-dd")
					.format(fromDate);
			String ngayketthucthongke = new SimpleDateFormat("yyyy-MM-dd")
					.format(toDate);
			// Tao dieu kien loc theo phong ban de loai bo cau truy van con
			String depFind = " departmentprocessid = '" + departmentId + "'";
			if (departmentId.trim().length() > 0) {
				List<Department> deps = DepartmentUtil
						.findByDepartmentsParentId(departmentId);
				if (!deps.isEmpty()) {
					for (int idx = 0; idx < deps.size(); idx++) {
						Department depItem = deps.get(idx);
						depFind += " OR departmentprocessid = '"
								+ depItem.getDepartmentsId() + "'";
					}
				}
			}
			depFind = "(" + depFind + ")";

			String sql = "SELECT COUNT(DISTINCT(cvden.documentreceiptid)) AS COUNT_VALUE";
			sql += " FROM (SELECT MAX(log.transition_) AS maxtran, log.documentreceiptid";
			sql += " FROM pml_documentreceipt_log log";
			sql += " WHERE " + depFind;
			sql += " GROUP BY documentreceiptid) AS a, pml_documentreceipt_log log, pml_edm_documentreceipt cvden";

			if (documentRecordTypeId != 0) { // Chon phan nhom
				sql += ", pml_edm_documenttype t";
			}
			if (0 != loaiVB) {
				sql += ", pml_edm_documenttype dt, pml_edm_documentrecordtype drt";
			}

			sql += " WHERE cvden.documentreceiptid = log.documentreceiptid";
			sql += " AND a.maxtran = log.transition_";
			sql += " AND a.documentreceiptid = log.documentreceiptid";
			if (!doMat.equals("")) {
				sql += " AND cvden.confidentiallevelid = '" + doMat + "'";
			}

			sql += " AND (log.dateprocess is not null AND log.dateprocess between '"
					+ ngaybatdauthongke + "' AND '" + ngayketthucthongke + "')";
			sql += " AND ((log.senddatebefore is not null"
					+ " AND (log.senddatebefore + log.numdateprocess + songaynghile(log.senddatebefore, log.numdateprocess)) >= log.dateprocess)"
					+ " OR (log.senddatebefore is null AND cvden.datearrive <= '"
					+ ngayketthucthongke + "')"
					+ " OR (log.numdateprocess = 0 AND log.senddatebefore <= '"
					+ ngayketthucthongke + "'))";

			if (documentRecordTypeId != 0) { // Chon phan nhom
				sql += " AND cvden.documenttypeid = t.documenttypeid";
				sql += " AND t.documentrecordtypeid = " + documentRecordTypeId;
			}
			if (0 != capGui) {
				sql += " AND cvden.levelsendid = " + capGui;
			}
			if (0 != loaiVB) {
				sql += " AND cvden.documenttypeid = dt.documenttypeid AND dt.documentrecordtypeid = drt.documentrecordtypeid AND drt.documentrecordtypeid = "
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
	 * phong ban da giai quyet dung han cong van den danh sach
	 */
	public List<PmlEdmDocumentReceipt> listDungHanDaXuLyPhongBan_CVDen(
			String departmentId, int documentRecordTypeId, int capGui,
			int loaiVB, String doMat, Date fromDate, Date toDate, int start,
			int end, OrderByComparator obc) throws Exception {
		Session session = null;

		try {
			session = openSession();

			String ngaybatdauthongke = new SimpleDateFormat("yyyy-MM-dd")
					.format(fromDate);
			String ngayketthucthongke = new SimpleDateFormat("yyyy-MM-dd")
					.format(toDate);
			// Tao dieu kien loc theo phong ban de loai bo cau truy van con
			String depFind = " departmentprocessid = '" + departmentId + "'";
			if (departmentId.trim().length() > 0) {
				List<Department> deps = DepartmentUtil
						.findByDepartmentsParentId(departmentId);
				if (!deps.isEmpty()) {
					for (int idx = 0; idx < deps.size(); idx++) {
						Department depItem = deps.get(idx);
						depFind += " OR departmentprocessid = '"
								+ depItem.getDepartmentsId() + "'";
					}
				}
			}
			depFind = "(" + depFind + ")";

			String sql = "SELECT DISTINCT(cvden.*), conf.confidentiallevelsymbol ";
			sql += " FROM (SELECT MAX(log.transition_) AS maxtran, log.documentreceiptid";
			sql += " FROM pml_documentreceipt_log log";
			sql += " WHERE " + depFind;
			sql += " GROUP BY documentreceiptid) AS a, pml_documentreceipt_log log, pml_edm_documentreceipt cvden, pml_edm_confidentiallevel conf";

			if (documentRecordTypeId != 0) { // Chon phan nhom
				sql += ", pml_edm_documenttype t";
			}
			if (0 != loaiVB) {
				sql += ", pml_edm_documenttype dt, pml_edm_documentrecordtype drt";
			}

			sql += " WHERE cvden.documentreceiptid = log.documentreceiptid";
			sql += " AND a.maxtran = log.transition_";
			sql += " AND a.documentreceiptid = log.documentreceiptid";
			sql += " AND cvden.confidentiallevelid = conf.confidentiallevelid";
			if (!doMat.equals("")) {
				sql += " AND conf.confidentiallevelid = '" + doMat + "'";
			}

			sql += " AND (log.dateprocess is not null AND log.dateprocess between '"
					+ ngaybatdauthongke + "' AND '" + ngayketthucthongke + "')";
			sql += " AND ((log.senddatebefore is not null"
					+ " AND (log.senddatebefore + log.numdateprocess + songaynghile(log.senddatebefore, log.numdateprocess)) >= log.dateprocess)"
					+ " OR (log.senddatebefore is null AND cvden.datearrive <= '"
					+ ngayketthucthongke + "')"
					+ " OR (log.numdateprocess = 0 AND log.senddatebefore <= '"
					+ ngayketthucthongke + "'))";

			if (documentRecordTypeId != 0) { // Chon phan nhom
				sql += " AND cvden.documenttypeid = t.documenttypeid";
				sql += " AND t.documentrecordtypeid = " + documentRecordTypeId;
			}
			if (0 != capGui) {
				sql += " AND cvden.levelsendid = " + capGui;
			}
			if (0 != loaiVB) {
				sql += " AND cvden.documenttypeid = dt.documenttypeid AND dt.documentrecordtypeid = drt.documentrecordtypeid AND drt.documentrecordtypeid = "
						+ loaiVB;
			}

			sql += " ORDER BY conf.confidentiallevelsymbol ASC, cvden.generalorderno ASC";

			sql = CustomSQLUtil.replaceOrderBy(sql, obc);

			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("PmlEdmDocumentReceipt",
					PmlEdmDocumentReceiptImpl.class);

			return (List<PmlEdmDocumentReceipt>) QueryUtil.list(q,
					getDialect(), start, end);
		} catch (Exception e) {
			throw processException(e);
		} finally {
			closeSession(session);
		}
	}

	/**
	 * phong ban da giai quyet tre han cong van den so luong
	 */
	public int countTreHanDaXuLyPhongBan_CVDen(String departmentId,
			int documentRecordTypeId, int capGui, int loaiVB, String doMat,
			Date fromDate, Date toDate) throws Exception {

		Session session = null;

		try {
			session = openSession();

			String ngaybatdauthongke = new SimpleDateFormat("yyyy-MM-dd")
					.format(fromDate);
			String ngayketthucthongke = new SimpleDateFormat("yyyy-MM-dd")
					.format(toDate);
			// Tao dieu kien loc theo phong ban de loai bo cau truy van con
			String depFind = " departmentprocessid = '" + departmentId + "'";
			if (departmentId.trim().length() > 0) {
				List<Department> deps = DepartmentUtil
						.findByDepartmentsParentId(departmentId);
				if (!deps.isEmpty()) {
					for (int idx = 0; idx < deps.size(); idx++) {
						Department depItem = deps.get(idx);
						depFind += " OR departmentprocessid = '"
								+ depItem.getDepartmentsId() + "'";
					}
				}
			}
			depFind = "(" + depFind + ")";

			String sql = "SELECT COUNT(DISTINCT(cvden.documentreceiptid)) AS COUNT_VALUE";
			sql += " FROM (SELECT MAX(log.transition_) AS maxtran, log.documentreceiptid";
			sql += " FROM pml_documentreceipt_log log";
			sql += " WHERE " + depFind;
			sql += " GROUP BY documentreceiptid) AS a, pml_documentreceipt_log log, pml_edm_documentreceipt cvden";
			if (documentRecordTypeId != 0) { // Chon phan nhom
				sql += ", pml_edm_documenttype t";
			}
			if (0 != loaiVB) {
				sql += ", pml_edm_documenttype dt, pml_edm_documentrecordtype drt";
			}

			sql += " WHERE cvden.documentreceiptid = log.documentreceiptid";
			sql += " AND a.maxtran = log.transition_";
			sql += " AND a.documentreceiptid = log.documentreceiptid";
			if (!doMat.equals("")) {
				sql += " AND cvden.confidentiallevelid = '" + doMat + "'";
			}

			sql += " AND (log.dateprocess is not null"
					+ " AND log.dateprocess between '" + ngaybatdauthongke
					+ "' AND '" + ngayketthucthongke + "')";
			sql += " AND (numdateprocess <>0 AND log.senddatebefore is not null"
					+ " AND (log.senddatebefore + log.numdateprocess + songaynghile(log.senddatebefore, log.numdateprocess)) < log.dateprocess)";

			if (documentRecordTypeId != 0) { // Chon phan nhom
				sql += " AND cvden.documenttypeid = t.documenttypeid";
				sql += " AND t.documentrecordtypeid = " + documentRecordTypeId;
			}
			if (0 != capGui) {
				sql += " AND cvden.levelsendid = " + capGui;
			}
			if (0 != loaiVB) {
				sql += " AND cvden.documenttypeid = dt.documenttypeid AND dt.documentrecordtypeid = drt.documentrecordtypeid AND drt.documentrecordtypeid = "
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
	 * phong ban da giai quyet tre han cong van den danh sach
	 */
	public List<PmlEdmDocumentReceipt> listTreHanDaXuLyPhongBan_CVDen(
			String departmentId, int documentRecordTypeId, int capGui,
			int loaiVB, String doMat, Date fromDate, Date toDate, int start,
			int end, OrderByComparator obc) throws Exception {
		Session session = null;

		try {
			session = openSession();

			String ngaybatdauthongke = new SimpleDateFormat("yyyy-MM-dd")
					.format(fromDate);
			String ngayketthucthongke = new SimpleDateFormat("yyyy-MM-dd")
					.format(toDate);
			// Tao dieu kien loc theo phong ban de loai bo cau truy van con
			String depFind = " departmentprocessid = '" + departmentId + "'";
			if (departmentId.trim().length() > 0) {
				List<Department> deps = DepartmentUtil
						.findByDepartmentsParentId(departmentId);
				if (!deps.isEmpty()) {
					for (int idx = 0; idx < deps.size(); idx++) {
						Department depItem = deps.get(idx);
						depFind += " OR departmentprocessid = '"
								+ depItem.getDepartmentsId() + "'";
					}
				}
			}
			depFind = "(" + depFind + ")";

			String sql = "SELECT DISTINCT(cvden.*), conf.confidentiallevelsymbol ";
			sql += " FROM (SELECT MAX(log.transition_) AS maxtran, log.documentreceiptid";
			sql += " FROM pml_documentreceipt_log log";
			sql += " WHERE " + depFind;
			sql += " GROUP BY documentreceiptid) AS a, pml_documentreceipt_log log, pml_edm_documentreceipt cvden, pml_edm_confidentiallevel conf";

			if (documentRecordTypeId != 0) { // Chon phan nhom
				sql += ", pml_edm_documenttype t";
			}
			if (0 != loaiVB) {
				sql += ", pml_edm_documenttype dt, pml_edm_documentrecordtype drt";
			}

			sql += " WHERE cvden.documentreceiptid = log.documentreceiptid";
			sql += " AND a.maxtran = log.transition_";
			sql += " AND a.documentreceiptid = log.documentreceiptid";
			sql += " AND cvden.confidentiallevelid = conf.confidentiallevelid";
			if (!doMat.equals("")) {
				sql += " AND conf.confidentiallevelid = '" + doMat + "'";
			}

			sql += " AND (log.dateprocess is not null"
					+ " AND log.dateprocess between '" + ngaybatdauthongke
					+ "' AND '" + ngayketthucthongke + "')";
			sql += " AND (numdateprocess <>0 AND log.senddatebefore is not null"
					+ " AND (log.senddatebefore + log.numdateprocess + songaynghile(log.senddatebefore, log.numdateprocess)) < log.dateprocess)";

			if (documentRecordTypeId != 0) { // Chon phan nhom
				sql += " AND cvden.documenttypeid = t.documenttypeid";
				sql += " AND t.documentrecordtypeid = " + documentRecordTypeId;
			}
			if (0 != capGui) {
				sql += " AND cvden.levelsendid = " + capGui;
			}
			if (0 != loaiVB) {
				sql += " AND cvden.documenttypeid = dt.documenttypeid AND dt.documentrecordtypeid = drt.documentrecordtypeid AND drt.documentrecordtypeid = "
						+ loaiVB;
			}

			sql += " ORDER BY conf.confidentiallevelsymbol ASC, cvden.generalorderno ASC";

			sql = CustomSQLUtil.replaceOrderBy(sql, obc);

			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("PmlEdmDocumentReceipt",
					PmlEdmDocumentReceiptImpl.class);

			return (List<PmlEdmDocumentReceipt>) QueryUtil.list(q,
					getDialect(), start, end);
		} catch (Exception e) {
			throw processException(e);
		} finally {
			closeSession(session);
		}
	}

	/**
	 * phong ban tong da giai quyet cong van den so luong (= dung han + tre han)
	 */
	public int countTongDaXuLyPhongBan_CVDen(String departmentId,
			int documentRecordTypeId, int capGui, int loaiVB, String doMat,
			Date fromDate, Date toDate) throws Exception {

		Session session = null;

		try {
			session = openSession();

			String ngaybatdauthongke = new SimpleDateFormat("yyyy-MM-dd")
					.format(fromDate);
			String ngayketthucthongke = new SimpleDateFormat("yyyy-MM-dd")
					.format(toDate);
			// Tao dieu kien loc theo phong ban de loai bo cau truy van con
			String depFind = " departmentprocessid = '" + departmentId + "'";
			if (departmentId.trim().length() > 0) {
				List<Department> deps = DepartmentUtil
						.findByDepartmentsParentId(departmentId);
				if (!deps.isEmpty()) {
					for (int idx = 0; idx < deps.size(); idx++) {
						Department depItem = deps.get(idx);
						depFind += " OR departmentprocessid = '"
								+ depItem.getDepartmentsId() + "'";
					}
				}
			}
			depFind = "(" + depFind + ")";

			String sql = "SELECT COUNT(DISTINCT(cvden.documentreceiptid)) AS COUNT_VALUE";
			sql += " FROM (SELECT MAX(log.transition_) AS maxtran, log.documentreceiptid";
			sql += " FROM pml_documentreceipt_log log";
			sql += " WHERE " + depFind;
			sql += " GROUP BY documentreceiptid) AS a, pml_documentreceipt_log log, pml_edm_documentreceipt cvden";

			if (documentRecordTypeId != 0) { // Chon phan nhom
				sql += ", pml_edm_documenttype t";
			}
			if (0 != loaiVB) {
				sql += ", pml_edm_documenttype dt, pml_edm_documentrecordtype drt";
			}

			sql += " WHERE cvden.documentreceiptid = log.documentreceiptid";
			sql += " AND a.maxtran = log.transition_";
			sql += " AND a.documentreceiptid = log.documentreceiptid";
			if (!doMat.equals("")) {
				sql += " AND cvden.confidentiallevelid = '" + doMat + "'";
			}

			sql += " AND (log.dateprocess is not null"
					+ " AND log.dateprocess between '" + ngaybatdauthongke
					+ "' AND '" + ngayketthucthongke + "')";

			if (documentRecordTypeId != 0) { // Chon phan nhom
				sql += " AND cvden.documenttypeid = t.documenttypeid";
				sql += " AND t.documentrecordtypeid = " + documentRecordTypeId;
			}
			if (0 != capGui) {
				sql += " AND cvden.levelsendid = " + capGui;
			}
			if (0 != loaiVB) {
				sql += " AND cvden.documenttypeid = dt.documenttypeid AND dt.documentrecordtypeid = drt.documentrecordtypeid AND drt.documentrecordtypeid = "
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
	 * phong ban tong da giai quyet cong van den danh sach (= dung han + tre
	 * han)
	 */
	public List<PmlEdmDocumentReceipt> listTongDaXuLyPhongBan_CVDen(
			String departmentId, int documentRecordTypeId, int capGui,
			int loaiVB, String doMat, Date fromDate, Date toDate, int start,
			int end, OrderByComparator obc) throws Exception {
		Session session = null;

		try {
			session = openSession();

			String ngaybatdauthongke = new SimpleDateFormat("yyyy-MM-dd")
					.format(fromDate);
			String ngayketthucthongke = new SimpleDateFormat("yyyy-MM-dd")
					.format(toDate);
			// Tao dieu kien loc theo phong ban de loai bo cau truy van con
			String depFind = " departmentprocessid = '" + departmentId + "'";
			if (departmentId.trim().length() > 0) {
				List<Department> deps = DepartmentUtil
						.findByDepartmentsParentId(departmentId);
				if (!deps.isEmpty()) {
					for (int idx = 0; idx < deps.size(); idx++) {
						Department depItem = deps.get(idx);
						depFind += " OR departmentprocessid = '"
								+ depItem.getDepartmentsId() + "'";
					}
				}
			}
			depFind = "(" + depFind + ")";

			String sql = "SELECT DISTINCT(cvden.*), conf.confidentiallevelsymbol ";
			sql += " FROM (SELECT MAX(log.transition_) AS maxtran, log.documentreceiptid";
			sql += " FROM pml_documentreceipt_log log";
			sql += " WHERE " + depFind;
			sql += " GROUP BY documentreceiptid) AS a, pml_documentreceipt_log log, pml_edm_documentreceipt cvden, pml_edm_confidentiallevel conf";

			if (documentRecordTypeId != 0) { // Chon phan nhom
				sql += ", pml_edm_documenttype t";
			}
			if (0 != loaiVB) {
				sql += ", pml_edm_documenttype dt, pml_edm_documentrecordtype drt";
			}

			sql += " WHERE cvden.documentreceiptid = log.documentreceiptid";
			sql += " AND a.maxtran = log.transition_";
			sql += " AND a.documentreceiptid = log.documentreceiptid";
			sql += " AND cvden.confidentiallevelid = conf.confidentiallevelid";
			if (!doMat.equals("")) {
				sql += " AND conf.confidentiallevelid = '" + doMat + "'";
			}

			sql += " AND (log.dateprocess is not null"
					+ " AND log.dateprocess between '" + ngaybatdauthongke
					+ "' AND '" + ngayketthucthongke + "')";

			if (documentRecordTypeId != 0) { // Chon phan nhom
				sql += " AND cvden.documenttypeid = t.documenttypeid";
				sql += " AND t.documentrecordtypeid = " + documentRecordTypeId;
			}
			if (0 != capGui) {
				sql += " AND cvden.levelsendid = " + capGui;
			}
			if (0 != loaiVB) {
				sql += " AND cvden.documenttypeid = dt.documenttypeid AND dt.documentrecordtypeid = drt.documentrecordtypeid AND drt.documentrecordtypeid = "
						+ loaiVB;
			}

			sql += " ORDER BY conf.confidentiallevelsymbol ASC, cvden.generalorderno ASC";

			sql = CustomSQLUtil.replaceOrderBy(sql, obc);

			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("PmlEdmDocumentReceipt",
					PmlEdmDocumentReceiptImpl.class);

			return (List<PmlEdmDocumentReceipt>) QueryUtil.list(q,
					getDialect(), start, end);
		} catch (Exception e) {
			throw processException(e);
		} finally {
			closeSession(session);
		}
	}

	/**
	 * phong ban dang giai quyet dung han cong van den so luong
	 */
	public int countDungHanDangXuLyPhongBan_CVDen(String departmentId,
			int documentRecordTypeId, int capGui, int loaiVB, String doMat,
			Date fromDate, Date toDate) throws Exception {
		Session session = null;

		try {
			session = openSession();

			String ngayketthucthongke = new SimpleDateFormat("yyyy-MM-dd")
					.format(toDate);
			// Tao dieu kien loc theo phong ban de loai bo cau truy van con
			String depFind = " departmentprocessid = '" + departmentId + "'";
			if (departmentId.trim().length() > 0) {
				List<Department> deps = DepartmentUtil
						.findByDepartmentsParentId(departmentId);
				if (!deps.isEmpty()) {
					for (int idx = 0; idx < deps.size(); idx++) {
						Department depItem = deps.get(idx);
						depFind += " OR departmentprocessid = '"
								+ depItem.getDepartmentsId() + "'";
					}
				}
			}
			depFind = "(" + depFind + ")";

			String sql = "SELECT COUNT(DISTINCT(cvden.documentreceiptid)) AS COUNT_VALUE";
			sql += " FROM (select max(log.transition_) as maxtran, log.documentreceiptid";
			sql += " FROM pml_documentreceipt_log log";
			sql += " WHERE " + depFind;
			sql += " GROUP BY documentreceiptid) AS a, pml_documentreceipt_log log, pml_edm_documentreceipt cvden";

			if (documentRecordTypeId != 0) { // Chon phan nhom
				sql += ", pml_edm_documenttype t";
			}
			if (0 != loaiVB) {
				sql += ", pml_edm_documenttype dt, pml_edm_documentrecordtype drt";
			}

			sql += " WHERE cvden.documentreceiptid = log.documentreceiptid";
			sql += " AND a.maxtran = log.transition_";
			sql += " AND a.documentreceiptid = log.documentreceiptid";
			if (!doMat.equals("")) {
				sql += " AND cvden.confidentiallevelid = '" + doMat + "'";
			}

			sql += " AND (log.dateprocess is null or log.dateprocess > '"
					+ ngayketthucthongke + "')";
			sql += " AND ((log.senddatebefore is not null AND log.senddatebefore <= '"
					+ ngayketthucthongke
					+ "'"
					+ " AND (log.senddatebefore + log.numdateprocess + songaynghile(log.senddatebefore, log.numdateprocess)) >= '"
					+ ngayketthucthongke
					+ "')"
					+ " OR (log.senddatebefore is null AND cvden.datearrive <= '"
					+ ngayketthucthongke
					+ "')"
					+ " OR (log.numdateprocess = 0 AND log.senddatebefore <= '"
					+ ngayketthucthongke + "'))";

			if (documentRecordTypeId != 0) { // Chon phan nhom
				sql += " AND cvden.documenttypeid = t.documenttypeid";
				sql += " AND t.documentrecordtypeid = " + documentRecordTypeId;
			}
			if (0 != capGui) {
				sql += " AND cvden.levelsendid = " + capGui;
			}
			if (0 != loaiVB) {
				sql += " AND cvden.documenttypeid = dt.documenttypeid AND dt.documentrecordtypeid = drt.documentrecordtypeid AND drt.documentrecordtypeid = "
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
	 * phong ban dang giai quyet dung han cong van den danh sach
	 */
	public List<PmlEdmDocumentReceipt> listDungHanDangXuLyPhongBan_CVDen(
			String departmentId, int documentRecordTypeId, int capGui,
			int loaiVB, String doMat, Date fromDate, Date toDate, int start,
			int end, OrderByComparator obc) throws Exception {
		Session session = null;

		try {
			session = openSession();

			String ngayketthucthongke = new SimpleDateFormat("yyyy-MM-dd")
					.format(toDate);
			// Tao dieu kien loc theo phong ban de loai bo cau truy van con
			String depFind = " departmentprocessid = '" + departmentId + "'";
			if (departmentId.trim().length() > 0) {
				List<Department> deps = DepartmentUtil
						.findByDepartmentsParentId(departmentId);
				if (!deps.isEmpty()) {
					for (int idx = 0; idx < deps.size(); idx++) {
						Department depItem = deps.get(idx);
						depFind += " OR departmentprocessid = '"
								+ depItem.getDepartmentsId() + "'";
					}
				}
			}
			depFind = "(" + depFind + ")";

			String sql = "SELECT DISTINCT(cvden.*), conf.confidentiallevelsymbol ";
			sql += " FROM (select max(log.transition_) as maxtran, log.documentreceiptid";
			sql += " FROM pml_documentreceipt_log log";
			sql += " WHERE " + depFind;
			sql += " GROUP BY documentreceiptid) AS a, pml_documentreceipt_log log, pml_edm_documentreceipt cvden, pml_edm_confidentiallevel conf";

			if (documentRecordTypeId != 0) { // Chon phan nhom
				sql += ", pml_edm_documenttype t";
			}
			if (0 != loaiVB) {
				sql += ", pml_edm_documenttype dt, pml_edm_documentrecordtype drt";
			}

			sql += " WHERE cvden.documentreceiptid = log.documentreceiptid";
			sql += " AND a.maxtran = log.transition_";
			sql += " AND a.documentreceiptid = log.documentreceiptid";
			sql += " AND cvden.confidentiallevelid = conf.confidentiallevelid";
			if (!doMat.equals("")) {
				sql += " AND conf.confidentiallevelid = '" + doMat + "'";
			}

			sql += " AND (log.dateprocess is null or log.dateprocess > '"
					+ ngayketthucthongke + "')";
			sql += " AND ((log.senddatebefore is not null AND log.senddatebefore <= '"
					+ ngayketthucthongke
					+ "'"
					+ " AND (log.senddatebefore + log.numdateprocess + songaynghile(log.senddatebefore, log.numdateprocess)) >= '"
					+ ngayketthucthongke
					+ "')"
					+ " OR (log.senddatebefore is null AND cvden.datearrive <= '"
					+ ngayketthucthongke
					+ "')"
					+ " OR (log.numdateprocess = 0 AND log.senddatebefore <= '"
					+ ngayketthucthongke + "'))";

			if (documentRecordTypeId != 0) { // Chon phan nhom
				sql += " AND cvden.documenttypeid = t.documenttypeid";
				sql += " AND t.documentrecordtypeid = " + documentRecordTypeId;
			}
			if (0 != capGui) {
				sql += " AND cvden.levelsendid = " + capGui;
			}
			if (0 != loaiVB) {
				sql += " AND cvden.documenttypeid = dt.documenttypeid AND dt.documentrecordtypeid = drt.documentrecordtypeid AND drt.documentrecordtypeid = "
						+ loaiVB;
			}

			sql += " ORDER BY conf.confidentiallevelsymbol ASC, cvden.generalorderno ASC";

			sql = CustomSQLUtil.replaceOrderBy(sql, obc);

			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("PmlEdmDocumentReceipt",
					PmlEdmDocumentReceiptImpl.class);

			return (List<PmlEdmDocumentReceipt>) QueryUtil.list(q,
					getDialect(), start, end);
		} catch (Exception e) {
			throw processException(e);
		} finally {
			closeSession(session);
		}
	}

	/**
	 * phong ban dang giai quyet tre han cong van den so luong
	 */
	public int countTreHanDangXuLyPhongBan_CVDen(String departmentId,
			int documentRecordTypeId, int capGui, int loaiVB, String doMat,
			Date fromDate, Date toDate) throws Exception {
		Session session = null;

		try {
			session = openSession();

			String ngayketthucthongke = new SimpleDateFormat("yyyy-MM-dd")
					.format(toDate);
			// Tao dieu kien loc theo phong ban de loai bo cau truy van con
			String depFind = " departmentprocessid = '" + departmentId + "'";
			if (departmentId.trim().length() > 0) {
				List<Department> deps = DepartmentUtil
						.findByDepartmentsParentId(departmentId);
				if (!deps.isEmpty()) {
					for (int idx = 0; idx < deps.size(); idx++) {
						Department depItem = deps.get(idx);
						depFind += " OR departmentprocessid = '"
								+ depItem.getDepartmentsId() + "'";
					}
				}
			}
			depFind = "(" + depFind + ")";

			String sql = "SELECT COUNT(DISTINCT(cvden.documentreceiptid)) AS COUNT_VALUE";
			sql += " FROM (select max(log.transition_) as maxtran, log.documentreceiptid";
			sql += " FROM pml_documentreceipt_log log";
			sql += " WHERE " + depFind;
			sql += " GROUP BY documentreceiptid) AS a, pml_documentreceipt_log log, pml_edm_documentreceipt cvden";

			if (documentRecordTypeId != 0) { // Chon phan nhom
				sql += ", pml_edm_documenttype t";
			}
			if (0 != loaiVB) {
				sql += ", pml_edm_documenttype dt, pml_edm_documentrecordtype drt";
			}

			sql += " WHERE cvden.documentreceiptid = log.documentreceiptid";
			sql += " AND a.maxtran = log.transition_";
			sql += " AND a.documentreceiptid = log.documentreceiptid";
			if (!doMat.equals("")) {
				sql += " AND cvden.confidentiallevelid = '" + doMat + "'";
			}

			sql += " AND (log.dateprocess is null or log.dateprocess > '"
					+ ngayketthucthongke + "')";
			sql += " AND log.numdateprocess <> 0";
			sql += " AND log.senddatebefore is not null AND log.senddatebefore <= '"
					+ ngayketthucthongke + "'";
			sql += " AND (log.senddatebefore + log.numdateprocess + songaynghile(log.senddatebefore, log.numdateprocess)) < '"
					+ ngayketthucthongke + "'";

			if (documentRecordTypeId != 0) { // Chon phan nhom
				sql += " AND cvden.documenttypeid = t.documenttypeid";
				sql += " AND t.documentrecordtypeid = " + documentRecordTypeId;
			}
			if (0 != capGui) {
				sql += " AND cvden.levelsendid = " + capGui;
			}
			if (0 != loaiVB) {
				sql += " AND cvden.documenttypeid = dt.documenttypeid AND dt.documentrecordtypeid = drt.documentrecordtypeid AND drt.documentrecordtypeid = "
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
	 * phong ban dang giai quyet tre han cong van den danh sach
	 */
	public List<PmlEdmDocumentReceipt> listTreHanDangXuLyPhongBan_CVDen(
			String departmentId, int documentRecordTypeId, int capGui,
			int loaiVB, String doMat, Date fromDate, Date toDate, int start,
			int end, OrderByComparator obc) throws Exception {
		Session session = null;

		try {
			session = openSession();

			String ngayketthucthongke = new SimpleDateFormat("yyyy-MM-dd")
					.format(toDate);
			// Tao dieu kien loc theo phong ban de loai bo cau truy van con
			String depFind = " departmentprocessid = '" + departmentId + "'";
			if (departmentId.trim().length() > 0) {
				List<Department> deps = DepartmentUtil
						.findByDepartmentsParentId(departmentId);
				if (!deps.isEmpty()) {
					for (int idx = 0; idx < deps.size(); idx++) {
						Department depItem = deps.get(idx);
						depFind += " OR departmentprocessid = '"
								+ depItem.getDepartmentsId() + "'";
					}
				}
			}
			depFind = "(" + depFind + ")";

			String sql = "SELECT DISTINCT(cvden.*), conf.confidentiallevelsymbol ";
			sql += " FROM (select max(log.transition_) as maxtran, log.documentreceiptid";
			sql += " FROM pml_documentreceipt_log log";
			sql += " WHERE " + depFind;
			sql += " GROUP BY documentreceiptid) AS a, pml_documentreceipt_log log, pml_edm_documentreceipt cvden, pml_edm_confidentiallevel conf";

			if (documentRecordTypeId != 0) { // Chon phan nhom
				sql += ", pml_edm_documenttype t";
			}
			if (0 != loaiVB) {
				sql += ", pml_edm_documenttype dt, pml_edm_documentrecordtype drt";
			}

			sql += " WHERE cvden.documentreceiptid = log.documentreceiptid";
			sql += " AND a.maxtran = log.transition_";
			sql += " AND a.documentreceiptid = log.documentreceiptid";
			sql += " AND cvden.confidentiallevelid = conf.confidentiallevelid";
			if (!doMat.equals("")) {
				sql += " AND conf.confidentiallevelid = '" + doMat + "'";
			}

			sql += " AND (log.dateprocess is null or log.dateprocess > '"
					+ ngayketthucthongke + "')";
			sql += " AND log.numdateprocess <> 0";
			sql += " AND log.senddatebefore is not null AND log.senddatebefore <= '"
					+ ngayketthucthongke + "'";
			sql += " AND (log.senddatebefore + log.numdateprocess + songaynghile(log.senddatebefore, log.numdateprocess)) < '"
					+ ngayketthucthongke + "'";

			if (documentRecordTypeId != 0) { // Chon phan nhom
				sql += " AND cvden.documenttypeid = t.documenttypeid";
				sql += " AND t.documentrecordtypeid = " + documentRecordTypeId;
			}
			if (0 != capGui) {
				sql += " AND cvden.levelsendid = " + capGui;
			}
			if (0 != loaiVB) {
				sql += " AND cvden.documenttypeid = dt.documenttypeid AND dt.documentrecordtypeid = drt.documentrecordtypeid AND drt.documentrecordtypeid = "
						+ loaiVB;
			}

			sql += " ORDER BY conf.confidentiallevelsymbol ASC, cvden.generalorderno ASC";

			sql = CustomSQLUtil.replaceOrderBy(sql, obc);

			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("PmlEdmDocumentReceipt",
					PmlEdmDocumentReceiptImpl.class);

			return (List<PmlEdmDocumentReceipt>) QueryUtil.list(q,
					getDialect(), start, end);
		} catch (Exception e) {
			throw processException(e);
		} finally {
			closeSession(session);
		}
	}

	/**
	 * phong ban tong dang giai quyet cong van den so luong (= dung han + tre
	 * han)
	 */
	public int countTongDangXuLyPhongBan_CVDen(String departmentId,
			int documentRecordTypeId, int capGui, int loaiVB, String doMat,
			Date fromDate, Date toDate) throws Exception {
		Session session = null;

		try {
			session = openSession();

			String ngayketthucthongke = new SimpleDateFormat("yyyy-MM-dd")
					.format(toDate);
			// Tao dieu kien loc theo phong ban de loai bo cau truy van con
			String depFind = " departmentprocessid = '" + departmentId + "'";
			if (departmentId.trim().length() > 0) {
				List<Department> deps = DepartmentUtil
						.findByDepartmentsParentId(departmentId);
				if (!deps.isEmpty()) {
					for (int idx = 0; idx < deps.size(); idx++) {
						Department depItem = deps.get(idx);
						depFind += " OR departmentprocessid = '"
								+ depItem.getDepartmentsId() + "'";
					}
				}
			}
			depFind = "(" + depFind + ")";

			String sql = "SELECT COUNT(DISTINCT(cvden.documentreceiptid)) AS COUNT_VALUE";
			sql += " FROM (select max(log.transition_) as maxtran, log.documentreceiptid";
			sql += " FROM pml_documentreceipt_log log";
			sql += " WHERE " + depFind;
			sql += " GROUP BY documentreceiptid) AS a, pml_documentreceipt_log log, pml_edm_documentreceipt cvden";

			if (documentRecordTypeId != 0) { // Chon phan nhom
				sql += ", pml_edm_documenttype t";
			}
			if (0 != loaiVB) {
				sql += ", pml_edm_documenttype dt, pml_edm_documentrecordtype drt";
			}

			sql += " WHERE cvden.documentreceiptid = log.documentreceiptid";
			sql += " AND a.maxtran = log.transition_";
			sql += " AND a.documentreceiptid = log.documentreceiptid";
			if (!doMat.equals("")) {
				sql += " AND cvden.confidentiallevelid = '" + doMat + "'";
			}

			sql += " AND (log.dateprocess is null or log.dateprocess > '"
					+ ngayketthucthongke + "')";
			sql += " AND ((log.senddatebefore is not null AND log.senddatebefore <= '"
					+ ngayketthucthongke
					+ "')"
					+ " OR (log.senddatebefore is null AND cvden.datearrive <= '"
					+ ngayketthucthongke + "'))";

			if (documentRecordTypeId != 0) { // Chon phan nhom
				sql += " AND cvden.documenttypeid = t.documenttypeid";
				sql += " AND t.documentrecordtypeid = " + documentRecordTypeId;
			}
			if (0 != capGui) {
				sql += " AND cvden.levelsendid = " + capGui;
			}
			if (0 != loaiVB) {
				sql += " AND cvden.documenttypeid = dt.documenttypeid AND dt.documentrecordtypeid = drt.documentrecordtypeid AND drt.documentrecordtypeid = "
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
	 * phong ban tong dang giai quyet cong van den danh sach (= dung han + tre
	 * han)
	 */
	public List<PmlEdmDocumentReceipt> listTongDangXuLyPhongBan_CVDen(
			String departmentId, int documentRecordTypeId, int capGui,
			int loaiVB, String doMat, Date fromDate, Date toDate, int start,
			int end, OrderByComparator obc) throws Exception {
		Session session = null;

		try {
			session = openSession();

			String ngayketthucthongke = new SimpleDateFormat("yyyy-MM-dd")
					.format(toDate);
			// Tao dieu kien loc theo phong ban de loai bo cau truy van con
			String depFind = " departmentprocessid = '" + departmentId + "'";
			if (departmentId.trim().length() > 0) {
				List<Department> deps = DepartmentUtil
						.findByDepartmentsParentId(departmentId);
				if (!deps.isEmpty()) {
					for (int idx = 0; idx < deps.size(); idx++) {
						Department depItem = deps.get(idx);
						depFind += " OR departmentprocessid = '"
								+ depItem.getDepartmentsId() + "'";
					}
				}
			}
			depFind = "(" + depFind + ")";

			String sql = "SELECT DISTINCT(cvden.*), conf.confidentiallevelsymbol ";
			sql += " FROM (select max(log.transition_) as maxtran, log.documentreceiptid";
			sql += " FROM pml_documentreceipt_log log";
			sql += " WHERE " + depFind;
			sql += " GROUP BY documentreceiptid) AS a, pml_documentreceipt_log log, pml_edm_documentreceipt cvden, pml_edm_confidentiallevel conf";

			if (documentRecordTypeId != 0) { // Chon phan nhom
				sql += ", pml_edm_documenttype t";
			}
			if (0 != loaiVB) {
				sql += ", pml_edm_documenttype dt, pml_edm_documentrecordtype drt";
			}

			sql += " WHERE cvden.documentreceiptid = log.documentreceiptid";
			sql += " AND a.maxtran = log.transition_";
			sql += " AND a.documentreceiptid = log.documentreceiptid";
			sql += " AND cvden.confidentiallevelid = conf.confidentiallevelid";
			if (!doMat.equals("")) {
				sql += " AND conf.confidentiallevelid = '" + doMat + "'";
			}

			sql += " AND (log.dateprocess is null or log.dateprocess > '"
					+ ngayketthucthongke + "')";
			sql += " AND ((log.senddatebefore is not null AND log.senddatebefore <= '"
					+ ngayketthucthongke
					+ "')"
					+ " OR (log.senddatebefore is null AND cvden.datearrive <= '"
					+ ngayketthucthongke + "'))";

			if (documentRecordTypeId != 0) { // Chon phan nhom
				sql += " AND cvden.documenttypeid = t.documenttypeid";
				sql += " AND t.documentrecordtypeid = " + documentRecordTypeId;
			}
			if (0 != capGui) {
				sql += " AND cvden.levelsendid = " + capGui;
			}
			if (0 != loaiVB) {
				sql += " AND cvden.documenttypeid = dt.documenttypeid AND dt.documentrecordtypeid = drt.documentrecordtypeid AND drt.documentrecordtypeid = "
						+ loaiVB;
			}

			sql += " ORDER BY conf.confidentiallevelsymbol ASC, cvden.generalorderno ASC";

			sql = CustomSQLUtil.replaceOrderBy(sql, obc);

			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("PmlEdmDocumentReceipt",
					PmlEdmDocumentReceiptImpl.class);

			return (List<PmlEdmDocumentReceipt>) QueryUtil.list(q,
					getDialect(), start, end);
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
	 * toan co quan ton dau ky cong van den so luong
	 */
	public int countTonDauKySo_CVDen(int documentRecordTypeId, int capGui,
			int loaiVB, String doMat, Date fromDate, Date toDate)
			throws Exception {

		Session session = null;

		try {
			session = openSession();

			String ngaybatdauthongke = new SimpleDateFormat("yyyy-MM-dd")
					.format(fromDate);

			String sql = "SELECT COUNT(DISTINCT(cvden.documentreceiptid)) AS COUNT_VALUE";
			sql += " FROM (SELECT MAX(log.transition_) AS maxtran, log.documentreceiptid";
			sql += " FROM pml_documentreceipt_log log";
			sql += " GROUP BY log.documentreceiptid) AS a, pml_documentreceipt_log log, pml_edm_documentreceipt cvden";

			if (documentRecordTypeId != 0) { // Chon phan nhom
				sql += ", pml_edm_documenttype t";
			}
			if (0 != loaiVB) {
				sql += ", pml_edm_documenttype dt, pml_edm_documentrecordtype drt";
			}

			sql += " WHERE cvden.documentreceiptid = log.documentreceiptid";
			sql += " AND a.maxtran = log.transition_";
			sql += " AND a.documentreceiptid = log.documentreceiptid";
			if (!doMat.equals("")) {
				sql += " AND cvden.confidentiallevelid = '" + doMat + "'";
			}

			sql += " AND (log.dateprocess is null OR log.dateprocess >= '"
					+ ngaybatdauthongke + "')";// dieu kien chung

			sql += " AND ((log.senddatebefore is not null AND log.senddatebefore < '"
					+ ngaybatdauthongke
					+ "')"
					+ " OR (log.senddatebefore is null AND cvden.datearrive < '"
					+ ngaybatdauthongke + "'))";

			if (documentRecordTypeId != 0) { // Chon phan nhom
				sql += " AND cvden.documenttypeid = t.documenttypeid";
				sql += " AND t.documentrecordtypeid = " + documentRecordTypeId;
			}
			if (0 != capGui) {
				sql += " AND cvden.levelsendid = " + capGui;
			}
			if (0 != loaiVB) {
				sql += " AND cvden.documenttypeid = dt.documenttypeid AND dt.documentrecordtypeid = drt.documentrecordtypeid AND drt.documentrecordtypeid = "
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
	 * toan co quan ton dau ky cong van den danh sach
	 */
	public List<PmlEdmDocumentReceipt> listTonDauKySo_CVDen(
			int documentRecordTypeId, int capGui, int loaiVB, String doMat,
			Date fromDate, Date toDate, int start, int end,
			OrderByComparator obc) throws Exception {

		Session session = null;

		try {
			session = openSession();

			// Chuyen doi dinh dang ngay
			String ngaybatdauthongke = new SimpleDateFormat("yyyy-MM-dd")
					.format(fromDate);

			String sql = "SELECT DISTINCT(cvden.*), conf.confidentiallevelsymbol";
			sql += " FROM (SELECT MAX(log.transition_) AS maxtran, log.documentreceiptid";
			sql += " FROM pml_documentreceipt_log log";
			sql += " GROUP BY log.documentreceiptid) AS a, pml_documentreceipt_log log, pml_edm_documentreceipt cvden, pml_edm_confidentiallevel conf";

			if (documentRecordTypeId != 0) { // Chon phan nhom
				sql += ", pml_edm_documenttype t";
			}
			if (0 != loaiVB) {
				sql += ", pml_edm_documenttype dt, pml_edm_documentrecordtype drt";
			}

			sql += " WHERE cvden.documentreceiptid = log.documentreceiptid";
			sql += " AND a.maxtran = log.transition_";
			sql += " AND a.documentreceiptid = log.documentreceiptid";
			sql += " AND cvden.confidentiallevelid = conf.confidentiallevelid";
			if (!doMat.equals("")) {
				sql += " AND conf.confidentiallevelid = '" + doMat + "'";
			}

			sql += " AND (log.dateprocess is null OR log.dateprocess >= '"
					+ ngaybatdauthongke + "')";// dieu kien chung

			sql += " AND ((log.senddatebefore is not null AND log.senddatebefore < '"
					+ ngaybatdauthongke
					+ "')"
					+ " OR (log.senddatebefore is null AND cvden.datearrive < '"
					+ ngaybatdauthongke + "'))";

			if (documentRecordTypeId != 0) { // Chon phan nhom
				sql += " AND cvden.documenttypeid = t.documenttypeid";
				sql += " AND t.documentrecordtypeid = " + documentRecordTypeId;
			}
			if (0 != capGui) {
				sql += " AND cvden.levelsendid = " + capGui;
			}
			if (0 != loaiVB) {
				sql += " AND cvden.documenttypeid = dt.documenttypeid AND dt.documentrecordtypeid = drt.documentrecordtypeid AND drt.documentrecordtypeid = "
						+ loaiVB;
			}

			sql += " ORDER BY conf.confidentiallevelsymbol ASC, cvden.generalorderno ASC";

			sql = CustomSQLUtil.replaceOrderBy(sql, obc);

			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("PmlEdmDocumentReceipt",
					PmlEdmDocumentReceiptImpl.class);

			return (List<PmlEdmDocumentReceipt>) QueryUtil.list(q,
					getDialect(), start, end);

		} catch (Exception e) {
			throw processException(e);
		} finally {
			closeSession(session);
		}
	}

	/**
	 * toan co quan nhan trong ky cong van den so luong
	 */
	public int countNhanTrongKySo_CVDen(int documentRecordTypeId, int capGui,
			int loaiVB, String doMat, Date fromDate, Date toDate)
			throws Exception {

		Session session = null;

		try {
			session = openSession();

			// Chuyen doi dinh dang ngay
			String ngaybatdauthongke = new SimpleDateFormat("yyyy-MM-dd")
					.format(fromDate);
			String ngayketthucthongke = new SimpleDateFormat("yyyy-MM-dd")
					.format(toDate);

			String sql = "SELECT COUNT(DISTINCT(cvden.documentreceiptid)) AS COUNT_VALUE";
			sql += " FROM (select max(log.transition_) as maxtran, log.documentreceiptid";
			sql += " FROM pml_documentreceipt_log log";
			sql += " GROUP BY log.documentreceiptid) AS a, pml_documentreceipt_log log, pml_edm_documentreceipt cvden";

			if (documentRecordTypeId != 0) { // Chon phan nhom
				sql += ", pml_edm_documenttype t";
			}
			if (0 != loaiVB) {
				sql += ", pml_edm_documenttype dt, pml_edm_documentrecordtype drt";
			}

			sql += " WHERE cvden.documentreceiptid = log.documentreceiptid";
			sql += " AND a.maxtran = log.transition_";
			sql += " AND a.documentreceiptid = log.documentreceiptid";
			if (!doMat.equals("")) {
				sql += " AND cvden.confidentiallevelid = '" + doMat + "'";
			}

			sql += " AND ((log.senddatebefore is not null AND log.senddatebefore between '"
					+ ngaybatdauthongke
					+ "' AND '"
					+ ngayketthucthongke
					+ "')"
					+ " OR (log.senddatebefore is null AND cvden.datearrive between '"
					+ ngaybatdauthongke
					+ "' AND '"
					+ ngayketthucthongke
					+ "'))";

			if (documentRecordTypeId != 0) { // Chon phan nhom
				sql += " AND cvden.documenttypeid = t.documenttypeid";
				sql += " AND t.documentrecordtypeid = " + documentRecordTypeId;
			}
			if (0 != capGui) {
				sql += " AND cvden.levelsendid = " + capGui;
			}
			if (0 != loaiVB) {
				sql += " AND cvden.documenttypeid = dt.documenttypeid AND dt.documentrecordtypeid = drt.documentrecordtypeid AND drt.documentrecordtypeid = "
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
	 * toan co quan nhan trong ky cong van den danh sach
	 */
	public List<PmlEdmDocumentReceipt> listNhanTrongKySo_CVDen(
			int documentRecordTypeId, int capGui, int loaiVB, String doMat,
			Date fromDate, Date toDate, int start, int end,
			OrderByComparator obc) throws Exception {

		Session session = null;

		try {
			session = openSession();

			// Chuyen doi dinh dang ngay
			String ngaybatdauthongke = new SimpleDateFormat("yyyy-MM-dd")
					.format(fromDate);
			String ngayketthucthongke = new SimpleDateFormat("yyyy-MM-dd")
					.format(toDate);

			String sql = "SELECT DISTINCT(cvden.*), conf.confidentiallevelsymbol";
			sql += " FROM (select max(log.transition_) as maxtran, log.documentreceiptid";
			sql += " FROM pml_documentreceipt_log log";
			sql += " GROUP BY log.documentreceiptid) AS a, pml_documentreceipt_log log, pml_edm_documentreceipt cvden, pml_edm_confidentiallevel conf";

			if (documentRecordTypeId != 0) { // Chon phan nhom
				sql += ", pml_edm_documenttype t";
			}
			if (0 != loaiVB) {
				sql += ", pml_edm_documenttype dt, pml_edm_documentrecordtype drt";
			}

			sql += " WHERE cvden.documentreceiptid = log.documentreceiptid";
			sql += " AND a.maxtran = log.transition_";
			sql += " AND a.documentreceiptid = log.documentreceiptid";
			sql += " AND cvden.confidentiallevelid = conf.confidentiallevelid";
			if (!doMat.equals("")) {
				sql += " AND conf.confidentiallevelid = '" + doMat + "'";
			}

			sql += " AND ((log.senddatebefore is not null AND log.senddatebefore between '"
					+ ngaybatdauthongke
					+ "' AND '"
					+ ngayketthucthongke
					+ "')"
					+ " OR (log.senddatebefore is null AND cvden.datearrive between '"
					+ ngaybatdauthongke
					+ "' AND '"
					+ ngayketthucthongke
					+ "'))";

			if (documentRecordTypeId != 0) { // Chon phan nhom
				sql += " AND cvden.documenttypeid = t.documenttypeid";
				sql += " AND t.documentrecordtypeid = " + documentRecordTypeId;
			}
			if (0 != capGui) {
				sql += " AND cvden.levelsendid = " + capGui;
			}
			if (0 != loaiVB) {
				sql += " AND cvden.documenttypeid = dt.documenttypeid AND dt.documentrecordtypeid = drt.documentrecordtypeid AND drt.documentrecordtypeid = "
						+ loaiVB;
			}

			sql += " ORDER BY conf.confidentiallevelsymbol ASC, cvden.generalorderno ASC";

			sql = CustomSQLUtil.replaceOrderBy(sql, obc);

			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("PmlEdmDocumentReceipt",
					PmlEdmDocumentReceiptImpl.class);

			return (List<PmlEdmDocumentReceipt>) QueryUtil.list(q,
					getDialect(), start, end);
		} catch (Exception e) {
			throw processException(e);
		} finally {
			closeSession(session);
		}
	}

	/**
	 * toan co quan da giai quyet dung han cong van den so luong
	 */
	public int countDungHanDaXuLySo_CVDen(int documentRecordTypeId, int capGui,
			int loaiVB, String doMat, Date fromDate, Date toDate)
			throws Exception {

		Session session = null;

		try {
			session = openSession();

			// Chuyen doi dinh dang ngay
			String ngaybatdauthongke = new SimpleDateFormat("yyyy-MM-dd")
					.format(fromDate);
			String ngayketthucthongke = new SimpleDateFormat("yyyy-MM-dd")
					.format(toDate);

			String sql = "SELECT COUNT(DISTINCT(cvden.documentreceiptid)) AS COUNT_VALUE";
			sql += " FROM (SELECT MAX(log.transition_) AS maxtran, log.documentreceiptid";
			sql += " FROM pml_documentreceipt_log log";
			sql += " GROUP BY log.documentreceiptid) AS a, pml_documentreceipt_log log, pml_edm_documentreceipt cvden";

			if (documentRecordTypeId != 0) { // Chon phan nhom
				sql += ", pml_edm_documenttype t";
			}
			if (0 != loaiVB) {
				sql += ", pml_edm_documenttype dt, pml_edm_documentrecordtype drt";
			}

			sql += " WHERE cvden.documentreceiptid = log.documentreceiptid";
			sql += " AND a.maxtran = log.transition_";
			sql += " AND a.documentreceiptid = log.documentreceiptid";
			if (!doMat.equals("")) {
				sql += " AND cvden.confidentiallevelid = '" + doMat + "'";
			}

			sql += " AND (log.dateprocess is not null AND log.dateprocess between '"
					+ ngaybatdauthongke + "' AND '" + ngayketthucthongke + "')";
			sql += " AND ((log.senddatebefore is not null"
					+ " AND (log.senddatebefore + log.numdateprocess + songaynghile(log.senddatebefore, log.numdateprocess)) >= log.dateprocess)"
					+ " OR (log.senddatebefore is null AND cvden.datearrive <= '"
					+ ngayketthucthongke + "')"
					+ " OR (log.numdateprocess = 0 AND log.senddatebefore <= '"
					+ ngayketthucthongke + "'))";

			if (documentRecordTypeId != 0) { // Chon phan nhom
				sql += " AND cvden.documenttypeid = t.documenttypeid";
				sql += " AND t.documentrecordtypeid = " + documentRecordTypeId;
			}
			if (0 != capGui) {
				sql += " AND cvden.levelsendid = " + capGui;
			}
			if (0 != loaiVB) {
				sql += " AND cvden.documenttypeid = dt.documenttypeid AND dt.documentrecordtypeid = drt.documentrecordtypeid AND drt.documentrecordtypeid = "
						+ loaiVB;
			}

			if (documentRecordTypeId != 0) { // Chon phan nhom
				sql += " AND cvden.documenttypeid = t.documenttypeid";
				sql += " AND t.documentrecordtypeid = " + documentRecordTypeId;
			}
			if (0 != capGui) {
				sql += " AND cvden.levelsendid = " + capGui;
			}
			if (0 != loaiVB) {
				sql += " AND cvden.documenttypeid = dt.documenttypeid AND dt.documentrecordtypeid = drt.documentrecordtypeid AND drt.documentrecordtypeid = "
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
	 * toan co quan da giai quyet dung han cong van den danh sach
	 */
	public List<PmlEdmDocumentReceipt> listDungHanDaXuLySo_CVDen(
			int documentRecordTypeId, int capGui, int loaiVB, String doMat,
			Date fromDate, Date toDate, int start, int end,
			OrderByComparator obc) throws Exception {
		Session session = null;

		try {
			session = openSession();

			// Lay ngay hien tai
			String ngaybatdauthongke = new SimpleDateFormat("yyyy-MM-dd")
					.format(fromDate);
			String ngayketthucthongke = new SimpleDateFormat("yyyy-MM-dd")
					.format(toDate);

			String sql = "SELECT DISTINCT(cvden.*), conf.confidentiallevelsymbol";
			sql += " FROM (SELECT MAX(log.transition_) AS maxtran, log.documentreceiptid";
			sql += " FROM pml_documentreceipt_log log";
			sql += " GROUP BY log.documentreceiptid) AS a, pml_documentreceipt_log log, pml_edm_documentreceipt cvden, pml_edm_confidentiallevel conf";

			if (documentRecordTypeId != 0) { // Chon phan nhom
				sql += ", pml_edm_documenttype t";
			}
			if (0 != loaiVB) {
				sql += ", pml_edm_documenttype dt, pml_edm_documentrecordtype drt";
			}

			sql += " WHERE cvden.documentreceiptid = log.documentreceiptid";
			sql += " AND a.maxtran = log.transition_";
			sql += " AND a.documentreceiptid = log.documentreceiptid";
			sql += " AND cvden.confidentiallevelid = conf.confidentiallevelid";
			if (!doMat.equals("")) {
				sql += " AND conf.confidentiallevelid = '" + doMat + "'";
			}

			sql += " AND (log.dateprocess is not null AND log.dateprocess between '"
					+ ngaybatdauthongke + "' AND '" + ngayketthucthongke + "')";
			sql += " AND ((log.senddatebefore is not null"
					+ " AND (log.senddatebefore + log.numdateprocess + songaynghile(log.senddatebefore, log.numdateprocess)) >= log.dateprocess)"
					+ " OR (log.senddatebefore is null AND cvden.datearrive <= '"
					+ ngayketthucthongke + "')"
					+ " OR (log.numdateprocess = 0 AND log.senddatebefore <= '"
					+ ngayketthucthongke + "'))";

			if (documentRecordTypeId != 0) { // Chon phan nhom
				sql += " AND cvden.documenttypeid = t.documenttypeid";
				sql += " AND t.documentrecordtypeid = " + documentRecordTypeId;
			}
			if (0 != capGui) {
				sql += " AND cvden.levelsendid = " + capGui;
			}
			if (0 != loaiVB) {
				sql += " AND cvden.documenttypeid = dt.documenttypeid AND dt.documentrecordtypeid = drt.documentrecordtypeid AND drt.documentrecordtypeid = "
						+ loaiVB;
			}

			sql += " ORDER BY conf.confidentiallevelsymbol ASC, cvden.generalorderno ASC";

			sql = CustomSQLUtil.replaceOrderBy(sql, obc);

			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("PmlEdmDocumentReceipt",
					PmlEdmDocumentReceiptImpl.class);

			return (List<PmlEdmDocumentReceipt>) QueryUtil.list(q,
					getDialect(), start, end);
		} catch (Exception e) {
			throw processException(e);
		} finally {
			closeSession(session);
		}
	}

	/**
	 * toan co quan da giai quyet tre han cong van den so luong
	 */
	public int countTreHanDaXuLySo_CVDen(int documentRecordTypeId, int capGui,
			int loaiVB, String doMat, Date fromDate, Date toDate)
			throws Exception {

		Session session = null;

		try {
			session = openSession();

			// Chuyen doi dinh dang ngay
			String ngaybatdauthongke = new SimpleDateFormat("yyyy-MM-dd")
					.format(fromDate);
			String ngayketthucthongke = new SimpleDateFormat("yyyy-MM-dd")
					.format(toDate);

			String sql = "SELECT COUNT(DISTINCT(cvden.documentreceiptid)) AS COUNT_VALUE";
			sql += " FROM (select max(log.transition_) as maxtran, log.documentreceiptid";
			sql += " FROM pml_documentreceipt_log log";
			sql += " GROUP BY log.documentreceiptid) AS a, pml_documentreceipt_log log, pml_edm_documentreceipt cvden";

			if (documentRecordTypeId != 0) { // Chon phan nhom
				sql += ", pml_edm_documenttype t";
			}
			if (0 != loaiVB) {
				sql += ", pml_edm_documenttype dt, pml_edm_documentrecordtype drt";
			}

			sql += " WHERE cvden.documentreceiptid = log.documentreceiptid";
			sql += " AND a.maxtran = log.transition_";
			sql += " AND a.documentreceiptid = log.documentreceiptid";
			if (!doMat.equals("")) {
				sql += " AND cvden.confidentiallevelid = '" + doMat + "'";
			}

			sql += " AND (log.dateprocess is not null"
					+ " AND log.dateprocess between '" + ngaybatdauthongke
					+ "' AND '" + ngayketthucthongke + "')";
			sql += " AND (numdateprocess <>0 AND log.senddatebefore is not null"
					+ " AND (log.senddatebefore + log.numdateprocess + songaynghile(log.senddatebefore, log.numdateprocess)) < log.dateprocess)";

			if (documentRecordTypeId != 0) { // Chon phan nhom
				sql += " AND cvden.documenttypeid = t.documenttypeid";
				sql += " AND t.documentrecordtypeid = " + documentRecordTypeId;
			}
			if (0 != capGui) {
				sql += " AND cvden.levelsendid = " + capGui;
			}
			if (0 != loaiVB) {
				sql += " AND cvden.documenttypeid = dt.documenttypeid AND dt.documentrecordtypeid = drt.documentrecordtypeid AND drt.documentrecordtypeid = "
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
	 * toan co quan da giai quyet tre han cong van den danh sach
	 */
	public List<PmlEdmDocumentReceipt> listTreHanDaXuLySo_CVDen(
			int documentRecordTypeId, int capGui, int loaiVB, String doMat,
			Date fromDate, Date toDate, int start, int end,
			OrderByComparator obc) throws Exception {
		Session session = null;

		try {
			session = openSession();

			// Lay ngay hien tai
			String ngaybatdauthongke = new SimpleDateFormat("yyyy-MM-dd")
					.format(fromDate);
			String ngayketthucthongke = new SimpleDateFormat("yyyy-MM-dd")
					.format(toDate);

			String sql = "SELECT DISTINCT(cvden.*), conf.confidentiallevelsymbol";
			sql += " FROM (select max(log.transition_) as maxtran, log.documentreceiptid";
			sql += " FROM pml_documentreceipt_log log";
			sql += " GROUP BY log.documentreceiptid) AS a, pml_documentreceipt_log log, pml_edm_documentreceipt cvden, pml_edm_confidentiallevel conf";

			if (documentRecordTypeId != 0) { // Chon phan nhom
				sql += ", pml_edm_documenttype t";
			}
			if (0 != loaiVB) {
				sql += ", pml_edm_documenttype dt, pml_edm_documentrecordtype drt";
			}

			sql += " WHERE cvden.documentreceiptid = log.documentreceiptid";
			sql += " AND a.maxtran = log.transition_";
			sql += " AND a.documentreceiptid = log.documentreceiptid";
			sql += " AND cvden.confidentiallevelid = conf.confidentiallevelid";
			if (!doMat.equals("")) {
				sql += " AND conf.confidentiallevelid = '" + doMat + "'";
			}

			sql += " AND (log.dateprocess is not null"
					+ " AND log.dateprocess between '" + ngaybatdauthongke
					+ "' AND '" + ngayketthucthongke + "')";
			sql += " AND (numdateprocess <>0 AND log.senddatebefore is not null"
					+ " AND (log.senddatebefore + log.numdateprocess + songaynghile(log.senddatebefore, log.numdateprocess)) < log.dateprocess)";

			if (documentRecordTypeId != 0) { // Chon phan nhom
				sql += " AND cvden.documenttypeid = t.documenttypeid";
				sql += " AND t.documentrecordtypeid = " + documentRecordTypeId;
			}
			if (0 != capGui) {
				sql += " AND cvden.levelsendid = " + capGui;
			}
			if (0 != loaiVB) {
				sql += " AND cvden.documenttypeid = dt.documenttypeid AND dt.documentrecordtypeid = drt.documentrecordtypeid AND drt.documentrecordtypeid = "
						+ loaiVB;
			}

			sql += " ORDER BY conf.confidentiallevelsymbol ASC, cvden.generalorderno ASC";

			sql = CustomSQLUtil.replaceOrderBy(sql, obc);

			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("PmlEdmDocumentReceipt",
					PmlEdmDocumentReceiptImpl.class);

			return (List<PmlEdmDocumentReceipt>) QueryUtil.list(q,
					getDialect(), start, end);
		} catch (Exception e) {
			throw processException(e);
		} finally {
			closeSession(session);
		}
	}

	/**
	 * toan co quan tong da giai quyet cong van den so luong (= dung han + tre
	 * han)
	 */
	public int countTongDaXuLySo_CVDen(int documentRecordTypeId, int capGui,
			int loaiVB, String doMat, Date fromDate, Date toDate)
			throws Exception {

		Session session = null;

		try {
			session = openSession();

			String ngaybatdauthongke = new SimpleDateFormat("yyyy-MM-dd")
					.format(fromDate);
			String ngayketthucthongke = new SimpleDateFormat("yyyy-MM-dd")
					.format(toDate);

			String sql = "SELECT COUNT(DISTINCT(cvden.documentreceiptid)) AS COUNT_VALUE";
			sql += " FROM (select max(log.transition_) as maxtran, log.documentreceiptid";
			sql += " FROM pml_documentreceipt_log log";
			sql += " GROUP BY log.documentreceiptid) AS a, pml_documentreceipt_log log, pml_edm_documentreceipt cvden";

			if (documentRecordTypeId != 0) { // Chon phan nhom
				sql += ", pml_edm_documenttype t";
			}
			if (0 != loaiVB) {
				sql += ", pml_edm_documenttype dt, pml_edm_documentrecordtype drt";
			}

			sql += " WHERE cvden.documentreceiptid = log.documentreceiptid";
			sql += " AND a.maxtran = log.transition_";
			sql += " AND a.documentreceiptid = log.documentreceiptid";
			if (!doMat.equals("")) {
				sql += " AND cvden.confidentiallevelid = '" + doMat + "'";
			}

			sql += " AND (log.dateprocess is not null"
					+ " AND log.dateprocess between '" + ngaybatdauthongke
					+ "' AND '" + ngayketthucthongke + "')";

			if (documentRecordTypeId != 0) { // Chon phan nhom
				sql += " AND cvden.documenttypeid = t.documenttypeid";
				sql += " AND t.documentrecordtypeid = " + documentRecordTypeId;
			}
			if (0 != capGui) {
				sql += " AND cvden.levelsendid = " + capGui;
			}
			if (0 != loaiVB) {
				sql += " AND cvden.documenttypeid = dt.documenttypeid AND dt.documentrecordtypeid = drt.documentrecordtypeid AND drt.documentrecordtypeid = "
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
	 * toan co quan tong da giai quyet cong van den danh sach (= dung han + tre
	 * han)
	 */
	public List<PmlEdmDocumentReceipt> listTongDaXuLySo_CVDen(
			int documentRecordTypeId, int capGui, int loaiVB, String doMat,
			Date fromDate, Date toDate, int start, int end,
			OrderByComparator obc) throws Exception {
		Session session = null;

		try {
			session = openSession();

			// Lay ngay hien tai
			String ngaybatdauthongke = new SimpleDateFormat("yyyy-MM-dd")
					.format(fromDate);
			String ngayketthucthongke = new SimpleDateFormat("yyyy-MM-dd")
					.format(toDate);

			String sql = "SELECT DISTINCT(cvden.*), conf.confidentiallevelsymbol";
			sql += " FROM (select max(log.transition_) as maxtran, log.documentreceiptid";
			sql += " FROM pml_documentreceipt_log log";
			sql += " GROUP BY log.documentreceiptid) AS a, pml_documentreceipt_log log, pml_edm_documentreceipt cvden, pml_edm_confidentiallevel conf";

			if (documentRecordTypeId != 0) { // Chon phan nhom
				sql += ", pml_edm_documenttype t";
			}
			if (0 != loaiVB) {
				sql += ", pml_edm_documenttype dt, pml_edm_documentrecordtype drt";
			}

			sql += " WHERE cvden.documentreceiptid = log.documentreceiptid";
			sql += " AND a.maxtran = log.transition_";
			sql += " AND a.documentreceiptid = log.documentreceiptid";
			sql += " AND cvden.confidentiallevelid = conf.confidentiallevelid";
			if (!doMat.equals("")) {
				sql += " AND conf.confidentiallevelid = '" + doMat + "'";
			}

			sql += " AND (log.dateprocess is not null"
					+ " AND log.dateprocess between '" + ngaybatdauthongke
					+ "' AND '" + ngayketthucthongke + "')";

			if (documentRecordTypeId != 0) { // Chon phan nhom
				sql += " AND cvden.documenttypeid = t.documenttypeid";
				sql += " AND t.documentrecordtypeid = " + documentRecordTypeId;
			}
			if (0 != capGui) {
				sql += " AND cvden.levelsendid = " + capGui;
			}
			if (0 != loaiVB) {
				sql += " AND cvden.documenttypeid = dt.documenttypeid AND dt.documentrecordtypeid = drt.documentrecordtypeid AND drt.documentrecordtypeid = "
						+ loaiVB;
			}

			sql += " ORDER BY conf.confidentiallevelsymbol ASC, cvden.generalorderno ASC";

			sql = CustomSQLUtil.replaceOrderBy(sql, obc);

			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("PmlEdmDocumentReceipt",
					PmlEdmDocumentReceiptImpl.class);

			return (List<PmlEdmDocumentReceipt>) QueryUtil.list(q,
					getDialect(), start, end);
		} catch (Exception e) {
			throw processException(e);
		} finally {
			closeSession(session);
		}
	}

	/**
	 * toan co quan dang giai quyet dung han cong van den so luong
	 */
	public int countDungHanDangXuLySo_CVDen(int documentRecordTypeId,
			int capGui, int loaiVB, String doMat, Date fromDate, Date toDate)
			throws Exception {

		Session session = null;

		try {
			session = openSession();

			String ngayketthucthongke = new SimpleDateFormat("yyyy-MM-dd")
					.format(toDate);

			String sql = "SELECT COUNT(DISTINCT(cvden.documentreceiptid)) AS COUNT_VALUE";
			sql += " FROM (select max(log.transition_) as maxtran, log.documentreceiptid";
			sql += " FROM pml_documentreceipt_log log";
			sql += " GROUP BY log.documentreceiptid) AS a, pml_documentreceipt_log log, pml_edm_documentreceipt cvden";

			if (documentRecordTypeId != 0) { // Chon phan nhom
				sql += ", pml_edm_documenttype t";
			}
			if (0 != loaiVB) {
				sql += ", pml_edm_documenttype dt, pml_edm_documentrecordtype drt";
			}

			sql += " WHERE cvden.documentreceiptid = log.documentreceiptid";
			sql += " AND a.maxtran = log.transition_";
			sql += " AND a.documentreceiptid = log.documentreceiptid";
			if (!doMat.equals("")) {
				sql += " AND cvden.confidentiallevelid = '" + doMat + "'";
			}

			sql += " AND (log.dateprocess is null or log.dateprocess > '"
					+ ngayketthucthongke + "')";
			sql += " AND ((log.senddatebefore is not null AND log.senddatebefore <= '"
					+ ngayketthucthongke
					+ "'"
					+ " AND (log.senddatebefore + log.numdateprocess + songaynghile(log.senddatebefore, log.numdateprocess)) >= '"
					+ ngayketthucthongke
					+ "')"
					+ " OR (log.senddatebefore is null AND cvden.datearrive <= '"
					+ ngayketthucthongke
					+ "')"
					+ " OR (log.numdateprocess = 0 AND log.senddatebefore <= '"
					+ ngayketthucthongke + "'))";

			if (documentRecordTypeId != 0) { // Chon phan nhom
				sql += " AND cvden.documenttypeid = t.documenttypeid";
				sql += " AND t.documentrecordtypeid = " + documentRecordTypeId;
			}
			if (0 != capGui) {
				sql += " AND cvden.levelsendid = " + capGui;
			}
			if (0 != loaiVB) {
				sql += " AND cvden.documenttypeid = dt.documenttypeid AND dt.documentrecordtypeid = drt.documentrecordtypeid AND drt.documentrecordtypeid = "
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
	 * toan co quan dang giai quyet dung han cong van den danh sach
	 */
	public List<PmlEdmDocumentReceipt> listDungHanDangXuLySo_CVDen(
			int documentRecordTypeId, int capGui, int loaiVB, String doMat,
			Date fromDate, Date toDate, int start, int end,
			OrderByComparator obc) throws Exception {

		Session session = null;

		try {
			session = openSession();

			String ngayketthucthongke = new SimpleDateFormat("yyyy-MM-dd")
					.format(toDate);

			String sql = "SELECT DISTINCT(cvden.*), conf.confidentiallevelsymbol";
			sql += " FROM (select max(log.transition_) as maxtran, log.documentreceiptid";
			sql += " FROM pml_documentreceipt_log log";
			sql += " GROUP BY log.documentreceiptid) AS a, pml_documentreceipt_log log, pml_edm_documentreceipt cvden, pml_edm_confidentiallevel conf";

			if (documentRecordTypeId != 0) { // Chon phan nhom
				sql += ", pml_edm_documenttype t";
			}
			if (0 != loaiVB) {
				sql += ", pml_edm_documenttype dt, pml_edm_documentrecordtype drt";
			}

			sql += " WHERE cvden.documentreceiptid = log.documentreceiptid";
			sql += " AND a.maxtran = log.transition_";
			sql += " AND a.documentreceiptid = log.documentreceiptid";
			sql += " AND cvden.confidentiallevelid = conf.confidentiallevelid";
			if (!doMat.equals("")) {
				sql += " AND conf.confidentiallevelid = '" + doMat + "'";
			}

			sql += " AND (log.dateprocess is null or log.dateprocess > '"
					+ ngayketthucthongke + "')";
			sql += " AND ((log.senddatebefore is not null AND log.senddatebefore <= '"
					+ ngayketthucthongke
					+ "'"
					+ " AND (log.senddatebefore + log.numdateprocess + songaynghile(log.senddatebefore, log.numdateprocess)) >= '"
					+ ngayketthucthongke
					+ "')"
					+ " OR (log.senddatebefore is null AND cvden.datearrive <= '"
					+ ngayketthucthongke
					+ "')"
					+ " OR (log.numdateprocess = 0 AND log.senddatebefore <= '"
					+ ngayketthucthongke + "'))";

			if (documentRecordTypeId != 0) { // Chon phan nhom
				sql += " AND cvden.documenttypeid = t.documenttypeid";
				sql += " AND t.documentrecordtypeid = " + documentRecordTypeId;
			}
			if (0 != capGui) {
				sql += " AND cvden.levelsendid = " + capGui;
			}
			if (0 != loaiVB) {
				sql += " AND cvden.documenttypeid = dt.documenttypeid AND dt.documentrecordtypeid = drt.documentrecordtypeid AND drt.documentrecordtypeid = "
						+ loaiVB;
			}

			sql += " ORDER BY conf.confidentiallevelsymbol ASC, cvden.generalorderno ASC";

			sql = CustomSQLUtil.replaceOrderBy(sql, obc);

			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("PmlEdmDocumentReceipt",
					PmlEdmDocumentReceiptImpl.class);

			return (List<PmlEdmDocumentReceipt>) QueryUtil.list(q,
					getDialect(), start, end);
		} catch (Exception e) {
			throw processException(e);
		} finally {
			closeSession(session);
		}
	}

	/**
	 * toan co quan dang giai quyet tre han cong van den so luong
	 */
	public int countTreHanDangXuLySo_CVDen(int documentRecordTypeId,
			int capGui, int loaiVB, String doMat, Date fromDate, Date toDate)
			throws Exception {

		Session session = null;

		try {
			session = openSession();

			String ngayketthucthongke = new SimpleDateFormat("yyyy-MM-dd")
					.format(toDate);

			String sql = "SELECT COUNT(DISTINCT(cvden.documentreceiptid)) AS COUNT_VALUE";
			sql += " FROM (select max(log.transition_) as maxtran, log.documentreceiptid";
			sql += " FROM pml_documentreceipt_log log";
			sql += " GROUP BY log.documentreceiptid) AS a, pml_documentreceipt_log log, pml_edm_documentreceipt cvden";

			if (documentRecordTypeId != 0) { // Chon phan nhom
				sql += ", pml_edm_documenttype t";
			}
			if (0 != loaiVB) {
				sql += ", pml_edm_documenttype dt, pml_edm_documentrecordtype drt";
			}

			sql += " WHERE cvden.documentreceiptid = log.documentreceiptid";
			sql += " AND a.maxtran = log.transition_";
			sql += " AND a.documentreceiptid = log.documentreceiptid";
			if (!doMat.equals("")) {
				sql += " AND cvden.confidentiallevelid = '" + doMat + "'";
			}

			sql += " AND (log.dateprocess is null or log.dateprocess > '"
					+ ngayketthucthongke + "')";
			sql += " AND log.numdateprocess <> 0";
			sql += " AND log.senddatebefore is not null AND log.senddatebefore <= '"
					+ ngayketthucthongke + "'";
			sql += " AND (log.senddatebefore + log.numdateprocess + songaynghile(log.senddatebefore, log.numdateprocess)) < '"
					+ ngayketthucthongke + "'";

			if (documentRecordTypeId != 0) { // Chon phan nhom
				sql += " AND cvden.documenttypeid = t.documenttypeid";
				sql += " AND t.documentrecordtypeid = " + documentRecordTypeId;
			}
			if (0 != capGui) {
				sql += " AND cvden.levelsendid = " + capGui;
			}
			if (0 != loaiVB) {
				sql += " AND cvden.documenttypeid = dt.documenttypeid AND dt.documentrecordtypeid = drt.documentrecordtypeid AND drt.documentrecordtypeid = "
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
	 * toan co quan dang giai quyet tre han cong van den danh sach
	 */
	public List<PmlEdmDocumentReceipt> listTreHanDangXuLySo_CVDen(
			int documentRecordTypeId, int capGui, int loaiVB, String doMat,
			Date fromDate, Date toDate, int start, int end,
			OrderByComparator obc) throws Exception {

		Session session = null;

		try {
			session = openSession();

			String ngayketthucthongke = new SimpleDateFormat("yyyy-MM-dd")
					.format(toDate);

			String sql = "SELECT DISTINCT(cvden.*), conf.confidentiallevelsymbol";
			sql += " FROM (select max(log.transition_) as maxtran, log.documentreceiptid";
			sql += " FROM pml_documentreceipt_log log";
			sql += " GROUP BY log.documentreceiptid) AS a, pml_documentreceipt_log log, pml_edm_documentreceipt cvden, pml_edm_confidentiallevel conf";

			if (documentRecordTypeId != 0) { // Chon phan nhom
				sql += ", pml_edm_documenttype t";
			}
			if (0 != loaiVB) {
				sql += ", pml_edm_documenttype dt, pml_edm_documentrecordtype drt";
			}

			sql += " WHERE cvden.documentreceiptid = log.documentreceiptid";
			sql += " AND a.maxtran = log.transition_";
			sql += " AND a.documentreceiptid = log.documentreceiptid";
			sql += " AND cvden.confidentiallevelid = conf.confidentiallevelid";
			if (!doMat.equals("")) {
				sql += " AND conf.confidentiallevelid = '" + doMat + "'";
			}

			sql += " AND (log.dateprocess is null or log.dateprocess > '"
					+ ngayketthucthongke + "')";
			sql += " AND log.numdateprocess <> 0";
			sql += " AND log.senddatebefore is not null AND log.senddatebefore <= '"
					+ ngayketthucthongke + "'";
			sql += " AND (log.senddatebefore + log.numdateprocess + songaynghile(log.senddatebefore, log.numdateprocess)) < '"
					+ ngayketthucthongke + "'";

			if (documentRecordTypeId != 0) { // Chon phan nhom
				sql += " AND cvden.documenttypeid = t.documenttypeid";
				sql += " AND t.documentrecordtypeid = " + documentRecordTypeId;
			}
			if (0 != capGui) {
				sql += " AND cvden.levelsendid = " + capGui;
			}
			if (0 != loaiVB) {
				sql += " AND cvden.documenttypeid = dt.documenttypeid AND dt.documentrecordtypeid = drt.documentrecordtypeid AND drt.documentrecordtypeid = "
						+ loaiVB;
			}

			sql += " ORDER BY conf.confidentiallevelsymbol ASC, cvden.generalorderno ASC";

			sql = CustomSQLUtil.replaceOrderBy(sql, obc);

			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("PmlEdmDocumentReceipt",
					PmlEdmDocumentReceiptImpl.class);

			return (List<PmlEdmDocumentReceipt>) QueryUtil.list(q,
					getDialect(), start, end);
		} catch (Exception e) {
			throw processException(e);
		} finally {
			closeSession(session);
		}
	}

	/**
	 * toan co quan tong dang giai quyet cong van den so luong (= dung han + tre
	 * han)
	 */
	public int countTongDangXuLySo_CVDen(int documentRecordTypeId, int capGui,
			int loaiVB, String doMat, Date fromDate, Date toDate)
			throws Exception {

		Session session = null;

		try {
			session = openSession();

			String ngayketthucthongke = new SimpleDateFormat("yyyy-MM-dd")
					.format(toDate);

			String sql = "SELECT COUNT(DISTINCT(cvden.documentreceiptid)) AS COUNT_VALUE";
			sql += " FROM (select max(log.transition_) as maxtran, log.documentreceiptid";
			sql += " FROM pml_documentreceipt_log log";
			sql += " GROUP BY log.documentreceiptid) AS a, pml_documentreceipt_log log, pml_edm_documentreceipt cvden";

			if (documentRecordTypeId != 0) { // Chon phan nhom
				sql += ", pml_edm_documenttype t";
			}
			if (0 != loaiVB) {
				sql += ", pml_edm_documenttype dt, pml_edm_documentrecordtype drt";
			}

			sql += " WHERE cvden.documentreceiptid = log.documentreceiptid";
			sql += " AND a.maxtran = log.transition_";
			sql += " AND a.documentreceiptid = log.documentreceiptid";
			if (!doMat.equals("")) {
				sql += " AND cvden.confidentiallevelid = '" + doMat + "'";
			}

			sql += " AND (log.dateprocess is null or log.dateprocess > '"
					+ ngayketthucthongke + "')";
			sql += " AND ((log.senddatebefore is not null AND log.senddatebefore <= '"
					+ ngayketthucthongke
					+ "')"
					+ " OR (log.senddatebefore is null AND cvden.datearrive <= '"
					+ ngayketthucthongke + "'))";

			if (documentRecordTypeId != 0) { // Chon phan nhom
				sql += " AND cvden.documenttypeid = t.documenttypeid";
				sql += " AND t.documentrecordtypeid = " + documentRecordTypeId;
			}
			if (0 != capGui) {
				sql += " AND cvden.levelsendid = " + capGui;
			}
			if (0 != loaiVB) {
				sql += " AND cvden.documenttypeid = dt.documenttypeid AND dt.documentrecordtypeid = drt.documentrecordtypeid AND drt.documentrecordtypeid = "
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
	 * toan co quan tong dang giai quyet cong van den danh sach (= dung han +
	 * tre han)
	 */
	public List<PmlEdmDocumentReceipt> listTongDangXuLySo_CVDen(
			int documentRecordTypeId, int capGui, int loaiVB, String doMat,
			Date fromDate, Date toDate, int start, int end,
			OrderByComparator obc) throws Exception {

		Session session = null;

		try {
			session = openSession();

			String ngayketthucthongke = new SimpleDateFormat("yyyy-MM-dd")
					.format(toDate);

			String sql = "SELECT DISTINCT(cvden.*), conf.confidentiallevelsymbol";
			sql += " FROM (select max(log.transition_) as maxtran, log.documentreceiptid";
			sql += " FROM pml_documentreceipt_log log";
			sql += " GROUP BY log.documentreceiptid) AS a, pml_documentreceipt_log log, pml_edm_documentreceipt cvden, pml_edm_confidentiallevel conf";

			if (documentRecordTypeId != 0) { // Chon phan nhom
				sql += ", pml_edm_documenttype t";
			}
			if (0 != loaiVB) {
				sql += ", pml_edm_documenttype dt, pml_edm_documentrecordtype drt";
			}

			sql += " WHERE cvden.documentreceiptid = log.documentreceiptid";
			sql += " AND a.maxtran = log.transition_";
			sql += " AND a.documentreceiptid = log.documentreceiptid";
			sql += " AND cvden.confidentiallevelid = conf.confidentiallevelid";
			if (!doMat.equals("")) {
				sql += " AND conf.confidentiallevelid = '" + doMat + "'";
			}

			sql += " AND (log.dateprocess is null or log.dateprocess > '"
					+ ngayketthucthongke + "')";
			sql += " AND ((log.senddatebefore is not null AND log.senddatebefore <= '"
					+ ngayketthucthongke
					+ "')"
					+ " OR (log.senddatebefore is null AND cvden.datearrive <= '"
					+ ngayketthucthongke + "'))";

			if (documentRecordTypeId != 0) { // Chon phan nhom
				sql += " AND cvden.documenttypeid = t.documenttypeid";
				sql += " AND t.documentrecordtypeid = " + documentRecordTypeId;
			}
			if (0 != capGui) {
				sql += " AND cvden.levelsendid = " + capGui;
			}
			if (0 != loaiVB) {
				sql += " AND cvden.documenttypeid = dt.documenttypeid AND dt.documentrecordtypeid = drt.documentrecordtypeid AND drt.documentrecordtypeid = "
						+ loaiVB;
			}

			sql += " ORDER BY conf.confidentiallevelsymbol ASC, cvden.generalorderno ASC";

			sql = CustomSQLUtil.replaceOrderBy(sql, obc);

			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("PmlEdmDocumentReceipt",
					PmlEdmDocumentReceiptImpl.class);

			return (List<PmlEdmDocumentReceipt>) QueryUtil.list(q,
					getDialect(), start, end);
		} catch (Exception e) {
			throw processException(e);
		} finally {
			closeSession(session);
		}
	}

	/**
	 * @author HAI TRIEU Data input: dd/MM/yyyy
	 */
	public int countBy_Date_N_C(String dateNow, String dateCalen)
			throws SystemException {

		// dateCalen > dateNow
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		int dateOff = 0;
		try {
			Date dNow = sdf.parse(dateNow);
			String d = dateNow.substring(0, 2);
			int dN = Integer.valueOf(d);
			String m = dateNow.substring(3, 5);
			int mN = Integer.valueOf(m);
			if (mN > 1) {
				mN = mN - 1;
			}
			String y = dateNow.substring(6, 10);
			int yN = Integer.valueOf(y);
			Date dCalen = sdf.parse(dateCalen);
			long totalDate = dCalen.getTime() - dNow.getTime();
			totalDate = totalDate / (1000 * 60 * 60 * 24);

			// tim so ngay nghi co trong db

			String dateAdd = "";
			// idx = 1 bo qua ngay hien tai
			for (int idx = 1; idx <= totalDate; idx++) {
				Calendar cal = Calendar.getInstance();
				cal.set(yN, mN, dN);
				cal.add(Calendar.DAY_OF_YEAR, idx);
				dateAdd = sdf.format(cal.getTime());
				Session session = null;
				try {
					session = openSession();
					StringBuilder query = new StringBuilder();

					query.append("SELECT COUNT(*) AS COUNT_VALUE FROM pml_holiday ");
					query.append("WHERE ");
					query.append("pml_holiday.holiday_value = '");
					query.append(dateAdd);
					query.append("'");
					SQLQuery q = session.createSQLQuery(query.toString());

					q.addScalar(COUNT_COLUMN_NAME, Type.LONG);

					QueryPos qPos = QueryPos.getInstance(q);

					Iterator<Long> itr = q.list().iterator();

					if (itr.hasNext()) {
						Long count = itr.next();

						if (count != null) {
							if (count > 0) {
								dateOff++;
							}
						}
					}
				} catch (Exception e) {
					throw new SystemException(e);
				} finally {
					closeSession(session);
				}
			}
		} catch (Exception e) {
		}
		return dateOff;
	}

	/**
	 * Lay so tong hop lon nhat theo nam
	 * 
	 * @param ddmmyyyyReceiveDate
	 *            : chuoi dang ngay dd/mm/yyyy
	 * @return so lon nhat trong bang theo nam
	 * @throws SystemException
	 */
	public int getGeneralNumberDocumentReceipt(String ddmmyyyyReceiveDate)
			throws SystemException {

		int retVal = 0;
		Date receiveDate = null;
		try {
			SimpleDateFormat format = new SimpleDateFormat("dd/mm/yyyy");
			receiveDate = format.parse(ddmmyyyyReceiveDate);
		} catch (Exception ex) {
			// Chuoi dua vao khong phai ngay dang dd/mm/yyyy
			return -1;
		}
		// Doc so lon nhat tu trong db theo nam
		Session session = null;
		try {
			Calendar cal = Calendar.getInstance();
			cal.setTime(receiveDate);

			session = openSession();
			StringBuilder query = new StringBuilder();

			query.append("SELECT MAX(generalorderno) AS COUNT_VALUE FROM pml_edm_documentreceipt ");
			query.append("WHERE ");
			query.append("date_part('year', datearrive) = ");
			query.append(cal.get(Calendar.YEAR));

			SQLQuery q = session.createSQLQuery(query.toString());

			q.addScalar(COUNT_COLUMN_NAME, Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			Iterator<Long> itr = q.list().iterator();

			if (itr.hasNext()) {
				Long count = itr.next();

				if (count != null) {
					retVal = count.intValue();
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
	 * Lay id lon nhat trong bang pml_edm_documentreceipt
	 * 
	 * @return long
	 * @throws SystemException
	 */
	public long getMaxDocumentReceiptId() throws SystemException {

		long retVal = 0;
		// Lay id lon nhat trong bang pml_edm_documentreceipt
		Session session = null;
		try {
			session = openSession();

			SQLQuery q = session
					.createSQLQuery("SELECT MAX(documentreceiptid) AS COUNT_VALUE FROM pml_edm_documentreceipt ");

			q.addScalar(COUNT_COLUMN_NAME, Type.LONG);

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
	 * Dem so luong van ban den dua vao so hieu goc, nam phat hanh, nam den
	 * 
	 * @author XUAN CONG
	 * @param docRef
	 * @param issuingYear
	 * @param findIssuingYear
	 * @param arriveYear
	 * @param findArriveYear
	 * @return
	 * @throws SystemException
	 */
	public int countByDocrefIssyearArrYear(String docRef, int issuingYear,
			boolean findIssuingYear, int arriveYear, boolean findArriveYear)
			throws SystemException {

		Session session = null;

		try {
			session = openSession();

			String sql = "SELECT COUNT(cvden.*) AS COUNT_VALUE";
			sql += " FROM pml_edm_documentreceipt cvden ";
			sql += "WHERE cvden.documentreference = '" + docRef + "' ";

			if (findIssuingYear == true) { // Tim theo nam phat hanh
				sql += "AND date_part('year', issuingdate) = "
						+ String.valueOf(issuingYear) + " ";
			} // end if

			if (findArriveYear == true) { // Tim theo nam cua ngay nhap
				sql += "AND date_part('year', datearrive) = "
						+ String.valueOf(arriveYear) + " ";
			} // end if

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

	public List<PmlEdmDocumentReceipt> getListCVDenDaXuLyChung(long userId,
			String year, String capGui, String loaisocongvan, int start,
			int end, OrderByComparator obc) throws SystemException {
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

			String sql = "SELECT cv.* ";
			sql += " FROM pml_edm_documentreceipt cv, (SELECT  DISTINCT (pml_documentreceipt_log.documentreceiptid), MAX  (pml_documentreceipt_log.transition_) AS tran  ";
			sql += " FROM pml_documentreceipt_log ";
			sql += " WHERE  pml_documentreceipt_log.processer = " + userId;
			sql += " GROUP BY pml_documentreceipt_log.documentreceiptid ";
			sql += ") AS pml_receipt_log, pml_documentreceipt_log ";
			sql += " WHERE ( pml_receipt_log.documentreceiptid = pml_documentreceipt_log.documentreceiptid ) ";
			sql += " AND ( pml_receipt_log.tran = pml_documentreceipt_log.transition_ ) ";
			sql += " AND ( cv.documentreceiptid = pml_documentreceipt_log.documentreceiptid ) ";
			sql += " AND ( '" + fromDate
					+ "' <= pml_documentreceipt_log.dateprocess";
			sql += " AND pml_documentreceipt_log.dateprocess <= '" + toDate
					+ "' )";

			if (!"0".equals(capGui)) {
				sql = sql
						.replace(
								") AS pml_receipt_log, pml_documentreceipt_log ",
								") AS pml_receipt_log, pml_documentreceipt_log, pml_edm_documenttype dt, pml_edm_documentrecordtype drt ");
				sql += " AND cv.documenttypeid = dt.documenttypeid ";
				sql += " AND dt.documentrecordtypeid = drt.documentrecordtypeid";
				sql += " AND cv.levelsendid = " + capGui;
			}

			if (!"0".equals(loaisocongvan)) {
				sql = sql
						.replace(
								") AS pml_receipt_log, pml_documentreceipt_log ",
								") AS pml_receipt_log, pml_documentreceipt_log, pml_edm_documenttype dt, pml_edm_documentrecordtype drt ");
				sql += " AND cv.documenttypeid = dt.documenttypeid ";
				sql += " AND dt.documentrecordtypeid = drt.documentrecordtypeid";
				sql += " AND drt.documentrecordtypeid = " + loaisocongvan;
			}

			sql = CustomSQLUtil.replaceOrderBy(sql, obc);

			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("pml_edm_documentreceipt",
					PmlEdmDocumentReceiptImpl.class);

			return (List<PmlEdmDocumentReceipt>) QueryUtil.list(q,
					getDialect(), start, end);
		} catch (Exception e) {
			throw processException(e);
		} finally {
			closeSession(session);
		}
	}

	/**
	 * Count so luong cong van den da xu ly chung
	 * 
	 * @param userId
	 * @param year
	 * @return
	 * @throws SystemException
	 */
	public int countListCVDenDaXuLyChung(long userId, String year,
			String capGui, String loaisocongvan) throws SystemException {
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
			sql += " FROM pml_edm_documentreceipt cv, (SELECT  DISTINCT (pml_documentreceipt_log.documentreceiptid), MAX  (pml_documentreceipt_log.transition_) AS tran  ";
			sql += " FROM pml_documentreceipt_log ";
			sql += " WHERE  pml_documentreceipt_log.processer = " + userId;
			sql += " GROUP BY pml_documentreceipt_log.documentreceiptid ";
			sql += ") AS pml_receipt_log, pml_documentreceipt_log ";
			sql += " WHERE ( pml_receipt_log.documentreceiptid = pml_documentreceipt_log.documentreceiptid ) ";
			sql += " AND ( pml_receipt_log.tran = pml_documentreceipt_log.transition_ ) ";
			sql += " AND ( cv.documentreceiptid = pml_documentreceipt_log.documentreceiptid ) ";
			sql += " AND ( '" + fromDate
					+ "' <= pml_documentreceipt_log.dateprocess";
			sql += " AND pml_documentreceipt_log.dateprocess <= '" + toDate
					+ "' )";

			if (!"0".equals(capGui)) {
				sql = sql
						.replace(
								") AS pml_receipt_log, pml_documentreceipt_log ",
								") AS pml_receipt_log, pml_documentreceipt_log, pml_edm_documenttype dt, pml_edm_documentrecordtype drt ");
				sql += " AND cv.documenttypeid = dt.documenttypeid ";
				sql += " AND dt.documentrecordtypeid = drt.documentrecordtypeid";
				sql += " AND cv.levelsendid = " + capGui;
			}

			if (!"0".equals(loaisocongvan)) {
				sql = sql
						.replace(
								") AS pml_receipt_log, pml_documentreceipt_log ",
								") AS pml_receipt_log, pml_documentreceipt_log, pml_edm_documenttype dt, pml_edm_documentrecordtype drt ");
				sql += " AND cv.documenttypeid = dt.documenttypeid ";
				sql += " AND dt.documentrecordtypeid = drt.documentrecordtypeid";
				sql += " AND drt.documentrecordtypeid = " + loaisocongvan;
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
	 * get list cv den da xu ly, tu xu ly
	 * 
	 * @param userId
	 * @param year
	 * @param start
	 * @param end
	 * @return
	 * @throws SystemException
	 */
	public List<PmlEdmDocumentReceipt> getListCVDenDaXuLyTuXuLy(long userId,
			String year, String capGui, String loaisocongvan, int start,
			int end, OrderByComparator obc) throws SystemException {
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

			String sql = "SELECT cv.* ";
			sql += " FROM pml_edm_documentreceipt cv, (SELECT  DISTINCT (pml_documentreceipt_log.documentreceiptid), MAX  (pml_documentreceipt_log.transition_) AS tran  ";
			sql += " FROM pml_documentreceipt_log ";
			sql += " WHERE  pml_documentreceipt_log.processer = " + userId;
			sql += " GROUP BY pml_documentreceipt_log.documentreceiptid ";
			sql += ") AS pml_receipt_log, pml_documentreceipt_log ";
			sql += " WHERE ( pml_receipt_log.documentreceiptid = pml_documentreceipt_log.documentreceiptid ) ";
			sql += " AND ( pml_receipt_log.tran = pml_documentreceipt_log.transition_ ) ";
			sql += " AND ( pml_documentreceipt_log.processer = pml_documentreceipt_log.receiver ) ";
			sql += " AND ( cv.documentreceiptid = pml_documentreceipt_log.documentreceiptid ) ";
			sql += " AND ( '" + fromDate
					+ "' <= pml_documentreceipt_log.dateprocess";
			sql += " AND pml_documentreceipt_log.dateprocess <= '" + toDate
					+ "' )";

			if (!"0".equals(capGui)) {
				sql = sql
						.replace(
								") AS pml_receipt_log, pml_documentreceipt_log ",
								") AS pml_receipt_log, pml_documentreceipt_log, pml_edm_documenttype dt, pml_edm_documentrecordtype drt ");
				sql += " AND cv.documenttypeid = dt.documenttypeid ";
				sql += " AND dt.documentrecordtypeid = drt.documentrecordtypeid";
				sql += " AND cv.levelsendid = " + capGui;
			}

			if (!"0".equals(loaisocongvan)) {
				sql = sql
						.replace(
								") AS pml_receipt_log, pml_documentreceipt_log ",
								") AS pml_receipt_log, pml_documentreceipt_log, pml_edm_documenttype dt, pml_edm_documentrecordtype drt ");
				sql += " AND cv.documenttypeid = dt.documenttypeid ";
				sql += " AND dt.documentrecordtypeid = drt.documentrecordtypeid";
				sql += " AND drt.documentrecordtypeid = " + loaisocongvan;
			}

			sql = CustomSQLUtil.replaceOrderBy(sql, obc);

			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("pml_edm_documentreceipt",
					PmlEdmDocumentReceiptImpl.class);

			return (List<PmlEdmDocumentReceipt>) QueryUtil.list(q,
					getDialect(), start, end);
		} catch (Exception e) {
			throw processException(e);
		} finally {
			closeSession(session);
		}
	}

	/**
	 * count cvden da xu ly, tu xu ly
	 * 
	 * @param userId
	 * @param year
	 * @return
	 * @throws SystemException
	 */
	public int countListCVDenDaXuLyTuXuLy(long userId, String year,
			String capGui, String loaisocongvan) throws SystemException {
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
			sql += " FROM pml_edm_documentreceipt cv, (SELECT  DISTINCT (pml_documentreceipt_log.documentreceiptid), MAX  (pml_documentreceipt_log.transition_) AS tran  ";
			sql += " FROM pml_documentreceipt_log ";
			sql += " WHERE  pml_documentreceipt_log.processer = " + userId;
			sql += " GROUP BY pml_documentreceipt_log.documentreceiptid ";
			sql += ") AS pml_receipt_log, pml_documentreceipt_log ";
			sql += " WHERE ( pml_receipt_log.documentreceiptid = pml_documentreceipt_log.documentreceiptid ) ";
			sql += " AND ( pml_receipt_log.tran = pml_documentreceipt_log.transition_ ) ";
			sql += " AND ( pml_documentreceipt_log.processer = pml_documentreceipt_log.receiver ) ";
			sql += " AND ( cv.documentreceiptid = pml_documentreceipt_log.documentreceiptid ) ";
			sql += " AND ( '" + fromDate
					+ "' <= pml_documentreceipt_log.dateprocess";
			sql += " AND pml_documentreceipt_log.dateprocess <= '" + toDate
					+ "' )";

			if (!"0".equals(capGui)) {
				sql = sql
						.replace(
								") AS pml_receipt_log, pml_documentreceipt_log ",
								") AS pml_receipt_log, pml_documentreceipt_log, pml_edm_documenttype dt, pml_edm_documentrecordtype drt ");
				sql += " AND cv.documenttypeid = dt.documenttypeid ";
				sql += " AND dt.documentrecordtypeid = drt.documentrecordtypeid";
				sql += " AND cv.levelsendid = " + capGui;
			}

			if (!"0".equals(loaisocongvan)) {
				sql = sql
						.replace(
								") AS pml_receipt_log, pml_documentreceipt_log ",
								") AS pml_receipt_log, pml_documentreceipt_log, pml_edm_documenttype dt, pml_edm_documentrecordtype drt ");
				sql += " AND cv.documenttypeid = dt.documenttypeid ";
				sql += " AND dt.documentrecordtypeid = drt.documentrecordtypeid";
				sql += " AND drt.documentrecordtypeid = " + loaisocongvan;
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
	 * yenlt 13/04/2010 CV DEN DA XU LY TRE HAN
	 * 
	 */
	public List<PmlEdmDocumentReceipt> getListCVDenDaXuLyChung_treHan(
			long userId, String year, String capGui, String loaisocongvan,
			int start, int end, OrderByComparator obc) throws SystemException {
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

			String sql = " SELECT cv.* ";
			sql += " FROM pml_edm_documentreceipt cv, ( ";
			sql += " SELECT  log.documentreceiptid, MAX (log.transition_) AS tran ";
			sql += " FROM pml_documentreceipt_log log ";
			sql += " WHERE  log.processer = " + userId;
			sql += " GROUP BY log.documentreceiptid ";
			sql += ") AS logden, pml_documentreceipt_log log ";
			sql += " WHERE  logden.documentreceiptid = log.documentreceiptid ";
			sql += " AND logden.tran = log.transition_ ";
			sql += " AND cv.documentreceiptid = logden.documentreceiptid ";
			sql += " AND  log.senddatebefore IS NOT NULL ";
			sql += " AND ( '" + fromDate
					+ "' <= log.dateprocess AND log.dateprocess <= '" + toDate
					+ "' )";
			sql += " AND(log.senddatebefore + log.numdateprocess + songaynghile(log.senddatebefore, log.numdateprocess)) < log.dateprocess ";

			if (!"0".equals(capGui)) {
				sql = sql
						.replace(
								") AS logden, pml_documentreceipt_log log ",
								") AS logden, pml_documentreceipt_log log, pml_edm_documenttype dt, pml_edm_documentrecordtype drt ");
				sql += " AND cv.documenttypeid = dt.documenttypeid ";
				sql += " AND dt.documentrecordtypeid = drt.documentrecordtypeid";
				sql += " AND cv.levelsendid = " + capGui;
			}

			if (!"0".equals(loaisocongvan)) {
				sql = sql
						.replace(
								") AS logden, pml_documentreceipt_log log ",
								") AS logden, pml_documentreceipt_log log, pml_edm_documenttype dt, pml_edm_documentrecordtype drt ");
				sql += " AND cv.documenttypeid = dt.documenttypeid ";
				sql += " AND dt.documentrecordtypeid = drt.documentrecordtypeid";
				sql += " AND drt.documentrecordtypeid = " + loaisocongvan;
			}

			sql = CustomSQLUtil.replaceOrderBy(sql, obc);

			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("pml_edm_documentreceipt",
					PmlEdmDocumentReceiptImpl.class);

			return (List<PmlEdmDocumentReceipt>) QueryUtil.list(q,
					getDialect(), start, end);
		} catch (Exception e) {
			throw processException(e);
		} finally {
			closeSession(session);
		}
	}

	/**
	 * cv den xu ly chung - tre han
	 * 
	 * @param userId
	 * @param year
	 * @param capGui
	 * @param loaisocongvan
	 * @return
	 * @throws SystemException
	 */
	public int countListCVDenDaXuLyChung_treHan(long userId, String year,
			String capGui, String loaisocongvan) throws SystemException {
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
			sql += " FROM pml_edm_documentreceipt cv, ( ";
			sql += " SELECT  log.documentreceiptid, MAX (log.transition_) AS tran ";
			sql += " FROM pml_documentreceipt_log log ";
			sql += " WHERE  log.processer = " + userId;
			sql += " GROUP BY log.documentreceiptid ";
			sql += ") AS logden, pml_documentreceipt_log log ";
			sql += " WHERE  logden.documentreceiptid = log.documentreceiptid ";
			sql += " AND logden.tran = log.transition_ ";
			sql += " AND cv.documentreceiptid = logden.documentreceiptid ";
			sql += " AND  log.senddatebefore IS NOT NULL ";
			sql += " AND ( '" + fromDate
					+ "' <= log.dateprocess AND log.dateprocess <= '" + toDate
					+ "' )";
			sql += " AND(log.senddatebefore + log.numdateprocess + songaynghile(log.senddatebefore, log.numdateprocess)) < log.dateprocess ";

			if (!"0".equals(capGui)) {
				sql = sql
						.replace(
								") AS logden, pml_documentreceipt_log log ",
								") AS logden, pml_documentreceipt_log log, pml_edm_documenttype dt, pml_edm_documentrecordtype drt ");
				sql += " AND cv.documenttypeid = dt.documenttypeid ";
				sql += " AND dt.documentrecordtypeid = drt.documentrecordtypeid";
				sql += " AND cv.levelsendid = " + capGui;
			}

			if (!"0".equals(loaisocongvan)) {
				sql = sql
						.replace(
								") AS logden, pml_documentreceipt_log log ",
								") AS logden, pml_documentreceipt_log log, pml_edm_documenttype dt, pml_edm_documentrecordtype drt ");
				sql += " AND cv.documenttypeid = dt.documenttypeid ";
				sql += " AND dt.documentrecordtypeid = drt.documentrecordtypeid";
				sql += " AND drt.documentrecordtypeid = " + loaisocongvan;
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
	 * cv den da xu ly - tu xu ly - tre han
	 * 
	 * @param userId
	 * @param year
	 * @param capGui
	 * @param loaisocongvan
	 * @param start
	 * @param end
	 * @param obc
	 * @return
	 * @throws SystemException
	 */
	public List<PmlEdmDocumentReceipt> getListCVDenDaXuLyTuXuLy_treHan(
			long userId, String year, String capGui, String loaisocongvan,
			int start, int end, OrderByComparator obc) throws SystemException {
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

			String sql = "SELECT cv.* ";
			sql += " FROM pml_edm_documentreceipt cv, ( ";
			sql += " SELECT  log.documentreceiptid, MAX (log.transition_) AS tran ";
			sql += " FROM pml_documentreceipt_log log ";
			sql += " WHERE  log.processer = " + userId;
			sql += " GROUP BY log.documentreceiptid ";
			sql += ") AS logden, pml_documentreceipt_log log ";
			sql += " WHERE  logden.documentreceiptid = log.documentreceiptid ";
			sql += " AND logden.tran = log.transition_ ";
			sql += " AND log.processer = log.receiver ";
			sql += " AND cv.documentreceiptid = logden.documentreceiptid ";
			sql += " AND  log.senddatebefore IS NOT NULL ";
			sql += " AND ( '" + fromDate
					+ "' <= log.dateprocess AND log.dateprocess <= '" + toDate
					+ "' )";
			sql += " AND(log.senddatebefore + log.numdateprocess + songaynghile(log.senddatebefore, log.numdateprocess)) < log.dateprocess ";

			if (!"0".equals(capGui)) {
				sql = sql
						.replace(
								") AS logden, pml_documentreceipt_log log ",
								") AS logden, pml_documentreceipt_log log, pml_edm_documenttype dt, pml_edm_documentrecordtype drt ");
				sql += " AND cv.documenttypeid = dt.documenttypeid ";
				sql += " AND dt.documentrecordtypeid = drt.documentrecordtypeid";
				sql += " AND cv.levelsendid = " + capGui;
			}

			if (!"0".equals(loaisocongvan)) {
				sql = sql
						.replace(
								") AS logden, pml_documentreceipt_log log ",
								") AS logden, pml_documentreceipt_log log, pml_edm_documenttype dt, pml_edm_documentrecordtype drt ");
				sql += " AND cv.documenttypeid = dt.documenttypeid ";
				sql += " AND dt.documentrecordtypeid = drt.documentrecordtypeid";
				sql += " AND drt.documentrecordtypeid = " + loaisocongvan;
			}

			sql = CustomSQLUtil.replaceOrderBy(sql, obc);

			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("pml_edm_documentreceipt",
					PmlEdmDocumentReceiptImpl.class);

			return (List<PmlEdmDocumentReceipt>) QueryUtil.list(q,
					getDialect(), start, end);
		} catch (Exception e) {
			throw processException(e);
		} finally {
			closeSession(session);
		}
	}

	/**
	 * cv den da xu ly - tu xu ly - tre han
	 * 
	 * @param userId
	 * @param year
	 * @param capGui
	 * @param loaisocongvan
	 * @return
	 * @throws SystemException
	 */
	public int countListCVDenDaXuLyTuXuLy_treHan(long userId, String year,
			String capGui, String loaisocongvan) throws SystemException {
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
			sql += " FROM pml_edm_documentreceipt cv, ( ";
			sql += " SELECT  log.documentreceiptid, MAX (log.transition_) AS tran ";
			sql += " FROM pml_documentreceipt_log log ";
			sql += " WHERE  log.processer = " + userId;
			sql += " GROUP BY log.documentreceiptid ";
			sql += ") AS logden, pml_documentreceipt_log log ";
			sql += " WHERE  logden.documentreceiptid = log.documentreceiptid ";
			sql += " AND logden.tran = log.transition_ ";
			sql += " AND log.processer = log.receiver ";
			sql += " AND cv.documentreceiptid = logden.documentreceiptid ";
			sql += " AND  log.senddatebefore IS NOT NULL ";
			sql += " AND ( '" + fromDate
					+ "' <= log.dateprocess AND log.dateprocess <= '" + toDate
					+ "' )";
			sql += " AND(log.senddatebefore + log.numdateprocess + songaynghile(log.senddatebefore, log.numdateprocess)) < log.dateprocess ";

			if (!"0".equals(capGui)) {
				sql = sql
						.replace(
								") AS logden, pml_documentreceipt_log log ",
								") AS logden, pml_documentreceipt_log log, pml_edm_documenttype dt, pml_edm_documentrecordtype drt ");
				sql += " AND cv.documenttypeid = dt.documenttypeid ";
				sql += " AND dt.documentrecordtypeid = drt.documentrecordtypeid";
				sql += " AND cv.levelsendid = " + capGui;
			}

			if (!"0".equals(loaisocongvan)) {
				sql = sql
						.replace(
								") AS logden, pml_documentreceipt_log log ",
								") AS logden, pml_documentreceipt_log log, pml_edm_documenttype dt, pml_edm_documentrecordtype drt ");
				sql += " AND cv.documenttypeid = dt.documenttypeid ";
				sql += " AND dt.documentrecordtypeid = drt.documentrecordtypeid";
				sql += " AND drt.documentrecordtypeid = " + loaisocongvan;
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
	 * Ham tinh so luong van ban trong so van ban cua phong
	 * 
	 * @param soNoiBo
	 *            So van ban noi bo
	 * @param soHieuGoc
	 *            So van ban goc
	 * @param ngayPHDay
	 *            Thanh phan ngay cua ngay phat hanh
	 * @param ngayPHMonth
	 *            Thanh phan thang cua ngay phat hanh
	 * @param ngayPHYear
	 *            Thanh phan nam cua ngay phat hanh
	 * @param capGui
	 *            Cap gui van ban
	 * @param noiPhatHanh
	 *            Noi phat hanh van ban
	 * @param uuTien
	 *            Do uu tien
	 * @param ngayDenDay
	 *            Thanh phan ngay cua ngay den
	 * @param ngayDenMonth
	 *            Thanh phan thang cua ngay den
	 * @param ngayDenYear
	 *            Thanh phan nam cua ngay den
	 * @param loaiVB
	 *            Loai van ban
	 * @param phongBan
	 *            Phong ban can thong ke
	 * @param trichYeu
	 *            Noi dung trich yeu
	 * @return
	 * @throws Exception
	 */
	public int countByN_D_I_L_I_P_D_D_D_B(String soNoiBo, String soHieuGoc,
			int ngayPHDay, int ngayPHMonth, int ngayPHYear, long capGui,
			String noiPhatHanh, String uuTien, int ngayDenDay,
			int ngayDenMonth, int ngayDenYear, long loaiVB, String phongBan,
			String trichYeu) throws SystemException {

		Session session = null;

		try {
			session = openSession();

			String sql = "SELECT COUNT(DISTINCT(doc.documentreceiptid)) AS COUNT_VALUE ";
			sql += "FROM pml_edm_documentreceipt doc ";
			// Neu co chon phong thi tinh dua vao bang pml_documentreceipt_log
			if ((phongBan != null) && (phongBan.trim().length() > 0)) {
				sql += "INNER JOIN pml_documentreceipt_log log ON doc.documentreceiptid = log.documentreceiptid ";
			}

			// Neu co nhap noi phat hanh thi phai dua vao bang
			// pml_edm_issuingplace
			if ((noiPhatHanh != null) && (noiPhatHanh.trim().length() > 0)) {
				sql += "LEFT OUTER JOIN pml_edm_issuingplace iss ON doc.issuingplaceid = iss.issuingplaceid ";
			}

			// Mac dinh them dieu kien loc
			sql += "WHERE 1 = 1 ";
			// So van ban noi bo
			if ((soNoiBo != null) && (soNoiBo.trim().length() > 0)) {
				sql += "AND lower(doc.numberdocumentreceipt) LIKE '" + soNoiBo
						+ "' ";
			}
			// So van ban goc
			if ((soHieuGoc != null) && (soHieuGoc.trim().length() > 0)) {
				sql += "AND lower(doc.documentreference) LIKE '" + soHieuGoc
						+ "' ";
			}
			// Cac thanh phan cua ngay phat hanh
			if (ngayPHYear > 0) {
				sql += "AND DATE_PART('year', doc.issuingdate) = " + ngayPHYear
						+ " ";
				// Thang
				if ((ngayPHMonth > 0) && (ngayPHMonth < 13)) {
					sql += "AND DATE_PART('month', doc.issuingdate) = "
							+ ngayPHMonth + " ";
					// Ngay
					if ((ngayPHDay > 0) && (ngayPHDay < 32)) {
						sql += "AND DATE_PART('day', doc.issuingdate) = "
								+ ngayPHDay + " ";
					}
				}
			} // end if
				// Cap gui
			if (capGui > 0) {
				sql += "AND doc.levelsendid = " + capGui + " ";
			}
			// Noi phat hanh
			if ((noiPhatHanh != null) && (noiPhatHanh.trim().length() > 0)) {
				sql += "AND (lower(iss.issuingplacename) LIKE '" + noiPhatHanh
						+ "' OR lower(doc.issuingplaceothername) LIKE '"
						+ noiPhatHanh + "') ";
			}
			// Do uu tien
			if ((uuTien != null) && (uuTien.trim().length() > 0)) {
				sql += "AND doc.privilegelevelid = '" + uuTien.trim() + "' ";
			}
			// Cac thanh phan cua ngay den
			if (ngayDenYear > 0) {
				sql += "AND DATE_PART('year', doc.datearrive) = " + ngayDenYear
						+ " ";
				// Thang
				if ((ngayDenMonth > 0) && (ngayDenMonth < 13)) {
					sql += "AND DATE_PART('month', doc.datearrive) = "
							+ ngayDenMonth + " ";
					// Ngay
					if ((ngayDenDay > 0) && (ngayDenDay < 32)) {
						sql += "AND DATE_PART('day', doc.datearrive) = "
								+ ngayDenDay + " ";
					}
				}
			} // end if
				// Loai van ban
			if (loaiVB > 0) {
//				sql += "AND doc.documenttypeid = " + loaiVB + " ";
				sql += "AND doc.documentrecordtypeid = " + loaiVB + " ";
			}
			// Phong ban
			if ((phongBan != null) && (phongBan.trim().length() > 0)) {
				sql += "AND (log.departmentprocessid = '" + phongBan
						+ "' OR log.departmentreceiveid = '" + phongBan + "') ";
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
	 * Ham lay ra danh sach van ban trong so van ban den cua Phong
	 * 
	 * @param soNoiBo
	 *            So van ban noi bo
	 * @param soHieuGoc
	 *            So van ban goc
	 * @param ngayPHDay
	 *            Thanh phan ngay cua ngay phat hanh
	 * @param ngayPHMonth
	 *            Thanh phan thang cua ngay phat hanh
	 * @param ngayPHYear
	 *            Thanh phan nam cua ngay phat hanh
	 * @param capGui
	 *            Cap gui van ban
	 * @param noiPhatHanh
	 *            Noi phat hanh van ban
	 * @param uuTien
	 *            Do uu tien
	 * @param ngayDenDay
	 *            Thanh phan ngay cua ngay den
	 * @param ngayDenMonth
	 *            Thanh phan thang cua ngay den
	 * @param ngayDenYear
	 *            Thanh phan nam cua ngay den
	 * @param loaiVB
	 *            Loai van ban
	 * @param phongBan
	 *            Phong ban can thong ke
	 * @param trichYeu
	 *            Noi dung trich yeu
	 * @param start
	 *            Vi tri bat dau
	 * @param end
	 *            Vi tri ket thuc
	 * @param obc
	 *            Sap xep
	 * @return
	 * @throws SystemException
	 */
	public List<PmlEdmDocumentReceipt> findByN_D_I_L_I_P_D_D_D_B(
			String soNoiBo, String soHieuGoc, int ngayPHDay, int ngayPHMonth,
			int ngayPHYear, long capGui, String noiPhatHanh, String uuTien,
			int ngayDenDay, int ngayDenMonth, int ngayDenYear, long loaiVB,
			String phongBan, String trichYeu, int start, int end,
			OrderByComparator obc) throws SystemException {

		Session session = null;

		try {
			session = openSession();

			String sql = "SELECT DISTINCT(doc.*) ";
			sql += "FROM pml_edm_documentreceipt doc ";
			// Neu co chon phong thi tinh dua vao bang pml_documentreceipt_log
			if ((phongBan != null) && (phongBan.trim().length() > 0)) {
				sql += "INNER JOIN pml_documentreceipt_log log ON doc.documentreceiptid = log.documentreceiptid ";
			}

			// Neu co nhap noi phat hanh thi phai dua vao bang
			// pml_edm_issuingplace
			if ((noiPhatHanh != null) && (noiPhatHanh.trim().length() > 0)) {
				sql += "LEFT OUTER JOIN pml_edm_issuingplace iss ON doc.issuingplaceid = iss.issuingplaceid ";
			}

			// Mac dinh them dieu kien loc
			sql += "WHERE 1 = 1 ";
			// So van ban noi bo
			if ((soNoiBo != null) && (soNoiBo.trim().length() > 0)) {
				sql += "AND lower(doc.numberdocumentreceipt) LIKE '" + soNoiBo
						+ "' ";
			}
			// So van ban goc
			if ((soHieuGoc != null) && (soHieuGoc.trim().length() > 0)) {
				sql += "AND lower(doc.documentreference) LIKE '" + soHieuGoc
						+ "' ";
			}
			// Cac thanh phan cua ngay phat hanh
			if (ngayPHYear > 0) {
				sql += "AND DATE_PART('year', doc.issuingdate) = " + ngayPHYear
						+ " ";
				// Thang
				if ((ngayPHMonth > 0) && (ngayPHMonth < 13)) {
					sql += "AND DATE_PART('month', doc.issuingdate) = "
							+ ngayPHMonth + " ";
					// Ngay
					if ((ngayPHDay > 0) && (ngayPHDay < 32)) {
						sql += "AND DATE_PART('day', doc.issuingdate) = "
								+ ngayPHDay + " ";
					}
				}
			} // end if
				// Cap gui
			if (capGui > 0) {
				sql += "AND doc.levelsendid = " + capGui + " ";
			}
			// Noi phat hanh
			if ((noiPhatHanh != null) && (noiPhatHanh.trim().length() > 0)) {
				sql += "AND (lower(iss.issuingplacename) LIKE '" + noiPhatHanh
						+ "' OR lower(doc.issuingplaceothername) LIKE '"
						+ noiPhatHanh + "') ";
			}
			// Do uu tien
			if ((uuTien != null) && (uuTien.trim().length() > 0)) {
				sql += "AND doc.privilegelevelid = '" + uuTien.trim() + "' ";
			}
			// Cac thanh phan cua ngay den
			if (ngayDenYear > 0) {
				sql += "AND DATE_PART('year', doc.datearrive) = " + ngayDenYear
						+ " ";
				// Thang
				if ((ngayDenMonth > 0) && (ngayDenMonth < 13)) {
					sql += "AND DATE_PART('month', doc.datearrive) = "
							+ ngayDenMonth + " ";
					// Ngay
					if ((ngayDenDay > 0) && (ngayDenDay < 32)) {
						sql += "AND DATE_PART('day', doc.datearrive) = "
								+ ngayDenDay + " ";
					}
				}
			} // end if
				// Loai van ban, doi thanh So Van Ban
			if (loaiVB > 0) {
//				sql += "AND doc.documenttypeid = " + loaiVB + " ";
				sql += "AND doc.documentrecordtypeid = " + loaiVB + " ";
			}
			// Phong ban
			if ((phongBan != null) && (phongBan.trim().length() > 0)) {
				sql += "AND (log.departmentprocessid = '" + phongBan
						+ "' OR log.departmentreceiveid = '" + phongBan + "') ";
			}
			// Trich yeu
			if ((trichYeu != null) && (trichYeu.trim().length() > 0)) {
				sql += "AND lower(doc.briefcontent) LIKE '" + trichYeu + "' ";
			}

			sql = CustomSQLUtil.replaceOrderBy(sql, obc);

			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("PmlEdmDocumentReceipt",
					PmlEdmDocumentReceiptImpl.class);

			return (List<PmlEdmDocumentReceipt>) QueryUtil.list(q,
					getDialect(), start, end);

		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}

	/**
	 * TIM KIEM CONG VAN THEO FORM SEARCH 14/10/2010
	 */
	public List<PmlEdmDocumentReceipt> getListCVDenDaXuLyChung(long userId,
			String soVBDen, String soHieuGoc, int loaiSoVanBan,
			String issuingplaceId, String noiBanHanh, String trichYeu,
			String tuNgay, String denNgay, String ngayHetHan, int start,
			int end, OrderByComparator obc) throws SystemException {
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
			if (!"".equals(ngayHetHan)) {
				ngayHetHan = sdf.format(df.parse(ngayHetHan));
			}
		} catch (ParseException e) {
		}

		Session session = null;

		try {
			session = openSession();

			String sql = "SELECT cv.* ";
			sql += " FROM pml_edm_documentreceipt cv, (SELECT  DISTINCT (pml_documentreceipt_log.documentreceiptid), MAX  (pml_documentreceipt_log.transition_) AS tran  ";
			sql += " FROM pml_documentreceipt_log ";
			sql += " WHERE  pml_documentreceipt_log.processer = " + userId;
			sql += " GROUP BY pml_documentreceipt_log.documentreceiptid ";
			sql += ") AS pml_receipt_log, pml_documentreceipt_log log";
			sql += " WHERE ( pml_receipt_log.documentreceiptid = log.documentreceiptid ) ";
			sql += " AND ( pml_receipt_log.tran = log.transition_ ) ";
			sql += " AND ( cv.documentreceiptid = log.documentreceiptid ) ";
			sql += " AND ( '" + fromDate + "' <= log.dateprocess";
			sql += " AND log.dateprocess <= '" + toDate + "' )";

			if (!"".equals(ngayHetHan)) {
				sql += " AND (log.senddatebefore + log.numdateprocess + songaynghile(log.senddatebefore, log.numdateprocess)) <= '"
						+ ngayHetHan + "'";
			}

			if (!"".equals(soVBDen)) {
				sql += " AND (lower(cv.numberdocumentreceipt) LIKE (lower('%"
						+ soVBDen + "%'))) ";
			}

			if (!"".equals(soHieuGoc)) {
				sql += " AND (lower(cv.documentreference) LIKE (lower('%"
						+ soHieuGoc + "%'))) ";
			}

			if (!"".equals(issuingplaceId)) {
				sql = sql
						.replace(
								") AS pml_receipt_log, pml_documentreceipt_log log",
								") AS pml_receipt_log, pml_documentreceipt_log log, pml_edm_issuingplace iss ");
				sql += " AND cv.issuingplaceid = iss.issuingplaceid ";
				sql += " AND iss.issuingplaceid = '" + issuingplaceId + "' ";
			}

			if (!"".equals(noiBanHanh)) {
				sql += " AND (lower(cv.issuingplaceothername) LIKE (lower('%"
						+ noiBanHanh + "%'))) ";
			}

			if (0 != loaiSoVanBan) {
				sql = sql
						.replace(
								") AS pml_receipt_log, pml_documentreceipt_log log",
								") AS pml_receipt_log, pml_documentreceipt_log log, pml_edm_documenttype dt, pml_edm_documentrecordtype drt ");
				sql += " AND cv.documenttypeid = dt.documenttypeid ";
				sql += " AND dt.documentrecordtypeid = drt.documentrecordtypeid";
				sql += " AND drt.documentrecordtypeid = " + loaiSoVanBan;
			}

			if (!"".equals(trichYeu)) {
				sql += " AND (lower(cv.briefcontent) LIKE (lower('%" + trichYeu
						+ "%'))) ";
			}

			sql = CustomSQLUtil.replaceOrderBy(sql, obc);

			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("pml_edm_documentreceipt",
					PmlEdmDocumentReceiptImpl.class);

			return (List<PmlEdmDocumentReceipt>) QueryUtil.list(q,
					getDialect(), start, end);
		} catch (Exception e) {
			throw processException(e);
		} finally {
			closeSession(session);
		}
	}

	public int countListCVDenDaXuLyChung(long userId, String soVBDen,
			String soHieuGoc, int loaiSoVanBan, String issuingplaceId,
			String noiBanHanh, String trichYeu, String tuNgay, String denNgay,
			String ngayHetHan) throws SystemException {
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
			if (!"".equals(ngayHetHan)) {
				ngayHetHan = sdf.format(df.parse(ngayHetHan));
			}
		} catch (ParseException e) {
		}

		Session session = null;

		try {
			session = openSession();

			String sql = "SELECT COUNT(*) AS COUNT_VALUE ";
			sql += " FROM pml_edm_documentreceipt cv, (SELECT  DISTINCT (pml_documentreceipt_log.documentreceiptid), MAX  (pml_documentreceipt_log.transition_) AS tran  ";
			sql += " FROM pml_documentreceipt_log ";
			sql += " WHERE  pml_documentreceipt_log.processer = " + userId;
			sql += " GROUP BY pml_documentreceipt_log.documentreceiptid ";
			sql += ") AS pml_receipt_log, pml_documentreceipt_log log";
			sql += " WHERE ( pml_receipt_log.documentreceiptid = log.documentreceiptid ) ";
			sql += " AND ( pml_receipt_log.tran = log.transition_ ) ";
			sql += " AND ( cv.documentreceiptid = log.documentreceiptid ) ";
			sql += " AND ( '" + fromDate + "' <= log.dateprocess";
			sql += " AND log.dateprocess <= '" + toDate + "' )";

			if (!"".equals(ngayHetHan)) {
				sql += " AND (log.senddatebefore + log.numdateprocess + songaynghile(log.senddatebefore, log.numdateprocess))  <= '"
						+ ngayHetHan + "'";
			}

			if (!"".equals(soVBDen)) {
				sql += " AND (lower(cv.numberdocumentreceipt) LIKE (lower('%"
						+ soVBDen + "%'))) ";
			}

			if (!"".equals(soHieuGoc)) {
				sql += " AND (lower(cv.documentreference) LIKE (lower('%"
						+ soHieuGoc + "%'))) ";
			}

			if (!"".equals(issuingplaceId)) {
				sql = sql
						.replace(
								") AS pml_receipt_log, pml_documentreceipt_log log",
								") AS pml_receipt_log, pml_documentreceipt_log log, pml_edm_issuingplace iss ");
				sql += " AND cv.issuingplaceid = iss.issuingplaceid ";
				sql += " AND iss.issuingplaceid = '" + issuingplaceId + "' ";
			}

			if (!"".equals(noiBanHanh)) {
				sql += " AND (lower(cv.issuingplaceothername) LIKE (lower('%"
						+ noiBanHanh + "%'))) ";
			}

			if (0 != loaiSoVanBan) {
				sql = sql
						.replace(
								") AS pml_receipt_log, pml_documentreceipt_log log",
								") AS pml_receipt_log, pml_documentreceipt_log log, pml_edm_documenttype dt, pml_edm_documentrecordtype drt ");
				sql += " AND cv.documenttypeid = dt.documenttypeid ";
				sql += " AND dt.documentrecordtypeid = drt.documentrecordtypeid";
				sql += " AND drt.documentrecordtypeid = " + loaiSoVanBan;
			}

			if (!"".equals(trichYeu)) {
				sql += " AND (lower(cv.briefcontent) LIKE (lower('%" + trichYeu
						+ "%'))) ";
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

	public List<PmlEdmDocumentReceipt> getListCVDenDaXuLyTuXuLy(long userId,
			String soVBDen, String soHieuGoc, int loaiSoVanBan,
			String issuingplaceId, String noiBanHanh, String trichYeu,
			String tuNgay, String denNgay, String ngayHetHan, int start,
			int end, OrderByComparator obc) throws SystemException {
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
			if (!"".equals(ngayHetHan)) {
				ngayHetHan = sdf.format(df.parse(ngayHetHan));
			}
		} catch (ParseException e) {
		}

		Session session = null;

		try {
			session = openSession();

			String sql = "SELECT cv.* ";
			sql += " FROM pml_edm_documentreceipt cv, (SELECT  DISTINCT (pml_documentreceipt_log.documentreceiptid), MAX  (pml_documentreceipt_log.transition_) AS tran  ";
			sql += " FROM pml_documentreceipt_log ";
			sql += " WHERE  pml_documentreceipt_log.processer = " + userId;
			sql += " GROUP BY pml_documentreceipt_log.documentreceiptid ";
			sql += ") AS pml_receipt_log, pml_documentreceipt_log log";
			sql += " WHERE ( pml_receipt_log.documentreceiptid = log.documentreceiptid ) ";
			sql += " AND ( pml_receipt_log.tran = log.transition_ ) ";
			sql += " AND ( log.processer = log.receiver ) ";
			sql += " AND ( cv.documentreceiptid = log.documentreceiptid ) ";
			sql += " AND ( '" + fromDate
					+ "' <= log.dateprocess AND log.dateprocess <= '" + toDate
					+ "' )";

			if (!"".equals(ngayHetHan)) {
				sql += " AND (log.senddatebefore + log.numdateprocess + songaynghile(log.senddatebefore, log.numdateprocess))  <= '"
						+ ngayHetHan + "'";
			}

			if (!"".equals(soVBDen)) {
				sql += " AND (lower(cv.numberdocumentreceipt) LIKE (lower('%"
						+ soVBDen + "%'))) ";
			}

			if (!"".equals(soHieuGoc)) {
				sql += " AND (lower(cv.documentreference) LIKE (lower('%"
						+ soHieuGoc + "%'))) ";
			}

			if (!"".equals(issuingplaceId)) {
				sql = sql
						.replace(
								") AS pml_receipt_log, pml_documentreceipt_log log",
								") AS pml_receipt_log, pml_documentreceipt_log log, pml_edm_issuingplace iss ");
				sql += " AND cv.issuingplaceid = iss.issuingplaceid ";
				sql += " AND iss.issuingplaceid = '" + issuingplaceId + "' ";
			}

			if (!"".equals(noiBanHanh)) {
				sql += " AND (lower(cv.issuingplaceothername) LIKE (lower('%"
						+ noiBanHanh + "%'))) ";
			}

			if (0 != loaiSoVanBan) {
				sql = sql
						.replace(
								") AS pml_receipt_log, pml_documentreceipt_log log",
								") AS pml_receipt_log, pml_documentreceipt_log log, pml_edm_documenttype dt, pml_edm_documentrecordtype drt ");
				sql += " AND cv.documenttypeid = dt.documenttypeid ";
				sql += " AND dt.documentrecordtypeid = drt.documentrecordtypeid";
				sql += " AND drt.documentrecordtypeid = " + loaiSoVanBan;
			}

			if (!"".equals(trichYeu)) {
				sql += " AND (lower(cv.briefcontent) LIKE (lower('%" + trichYeu
						+ "%'))) ";
			}

			sql = CustomSQLUtil.replaceOrderBy(sql, obc);

			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("pml_edm_documentreceipt",
					PmlEdmDocumentReceiptImpl.class);

			return (List<PmlEdmDocumentReceipt>) QueryUtil.list(q,
					getDialect(), start, end);
		} catch (Exception e) {
			throw processException(e);
		} finally {
			closeSession(session);
		}
	}

	/**
	 * count cvden da xu ly, tu xu ly
	 */
	public int countListCVDenDaXuLyTuXuLy(long userId, String soVBDen,
			String soHieuGoc, int loaiSoVanBan, String issuingplaceId,
			String noiBanHanh, String trichYeu, String tuNgay, String denNgay,
			String ngayHetHan) throws SystemException {
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
			if (!"".equals(ngayHetHan)) {
				ngayHetHan = sdf.format(df.parse(ngayHetHan));
			}
		} catch (ParseException e) {
		}

		Session session = null;

		try {
			session = openSession();

			String sql = "SELECT COUNT(*) AS COUNT_VALUE ";
			sql += " FROM pml_edm_documentreceipt cv, (SELECT  DISTINCT (pml_documentreceipt_log.documentreceiptid), MAX  (pml_documentreceipt_log.transition_) AS tran  ";
			sql += " FROM pml_documentreceipt_log ";
			sql += " WHERE  pml_documentreceipt_log.processer = " + userId;
			sql += " GROUP BY pml_documentreceipt_log.documentreceiptid ";
			sql += ") AS pml_receipt_log, pml_documentreceipt_log log";
			sql += " WHERE ( pml_receipt_log.documentreceiptid = log.documentreceiptid ) ";
			sql += " AND ( pml_receipt_log.tran = log.transition_ ) ";
			sql += " AND ( log.processer = log.receiver ) ";
			sql += " AND ( cv.documentreceiptid = log.documentreceiptid ) ";
			sql += " AND ( '" + fromDate
					+ "' <= log.dateprocess AND log.dateprocess <= '" + toDate
					+ "' )";

			if (!"".equals(ngayHetHan)) {
				sql += " AND (log.senddatebefore + log.numdateprocess + songaynghile(log.senddatebefore, log.numdateprocess))  <= '"
						+ ngayHetHan + "'";
			}

			if (!"".equals(soVBDen)) {
				sql += " AND (lower(cv.numberdocumentreceipt) LIKE (lower('%"
						+ soVBDen + "%'))) ";
			}

			if (!"".equals(soHieuGoc)) {
				sql += " AND (lower(cv.documentreference) LIKE (lower('%"
						+ soHieuGoc + "%'))) ";
			}

			if (!"".equals(issuingplaceId)) {
				sql = sql
						.replace(
								") AS pml_receipt_log, pml_documentreceipt_log log",
								") AS pml_receipt_log, pml_documentreceipt_log log, pml_edm_issuingplace iss ");
				sql += " AND cv.issuingplaceid = iss.issuingplaceid ";
				sql += " AND iss.issuingplaceid = '" + issuingplaceId + "' ";
			}

			if (!"".equals(noiBanHanh)) {
				sql += " AND (lower(cv.issuingplaceothername) LIKE (lower('%"
						+ noiBanHanh + "%'))) ";
			}

			if (0 != loaiSoVanBan) {
				sql = sql
						.replace(
								") AS pml_receipt_log, pml_documentreceipt_log log",
								") AS pml_receipt_log, pml_documentreceipt_log log, pml_edm_documenttype dt, pml_edm_documentrecordtype drt ");
				sql += " AND cv.documenttypeid = dt.documenttypeid ";
				sql += " AND dt.documentrecordtypeid = drt.documentrecordtypeid";
				sql += " AND drt.documentrecordtypeid = " + loaiSoVanBan;
			}

			if (!"".equals(trichYeu)) {
				sql += " AND (lower(cv.briefcontent) LIKE (lower('%" + trichYeu
						+ "%'))) ";
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
	 * CV DEN DA XU LY TRE HAN
	 * 
	 */
	public List<PmlEdmDocumentReceipt> getListCVDenDaXuLyChung_treHan(
			long userId, String soVBDen, String soHieuGoc, int loaiSoVanBan,
			String issuingplaceId, String noiBanHanh, String trichYeu,
			String tuNgay, String denNgay, String ngayHetHan, int start,
			int end, OrderByComparator obc) throws SystemException {
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
			if (!"".equals(ngayHetHan)) {
				ngayHetHan = sdf.format(df.parse(ngayHetHan));
			}
		} catch (ParseException e) {
		}

		Session session = null;

		try {
			session = openSession();

			String sql = " SELECT cv.* ";
			sql += " FROM pml_edm_documentreceipt cv, ( ";
			sql += " SELECT  log.documentreceiptid, MAX (log.transition_) AS tran ";
			sql += " FROM pml_documentreceipt_log log ";
			sql += " WHERE  log.processer = " + userId;
			sql += " GROUP BY log.documentreceiptid ";
			sql += ") AS logden, pml_documentreceipt_log log";
			sql += " WHERE  logden.documentreceiptid = log.documentreceiptid ";
			sql += " AND logden.tran = log.transition_ ";
			sql += " AND cv.documentreceiptid = logden.documentreceiptid ";
			sql += " AND  log.senddatebefore IS NOT NULL ";
			sql += " AND ( '" + fromDate
					+ "' <= log.dateprocess AND log.dateprocess <= '" + toDate
					+ "' )";
			sql += " AND(log.senddatebefore + log.numdateprocess + songaynghile(log.senddatebefore, log.numdateprocess)) < log.dateprocess ";

			if (!"".equals(ngayHetHan)) {
				sql += " AND (log.senddatebefore + log.numdateprocess + songaynghile(log.senddatebefore, log.numdateprocess))  <= '"
						+ ngayHetHan + "'";
			}

			if (!"".equals(soVBDen)) {
				sql += " AND (lower(cv.numberdocumentreceipt) LIKE (lower('%"
						+ soVBDen + "%'))) ";
			}

			if (!"".equals(soHieuGoc)) {
				sql += " AND (lower(cv.documentreference) LIKE (lower('%"
						+ soHieuGoc + "%'))) ";
			}

			if (!"".equals(issuingplaceId)) {
				sql = sql
						.replace(") AS logden, pml_documentreceipt_log log",
								") AS logden, pml_documentreceipt_log log, pml_edm_issuingplace iss ");
				sql += " AND cv.issuingplaceid = iss.issuingplaceid ";
				sql += " AND iss.issuingplaceid = '" + issuingplaceId + "' ";
			}

			if (!"".equals(noiBanHanh)) {
				sql += " AND (lower(cv.issuingplaceothername) LIKE (lower('%"
						+ noiBanHanh + "%'))) ";
			}

			if (0 != loaiSoVanBan) {
				sql = sql
						.replace(
								") AS logden, pml_documentreceipt_log log",
								") AS logden, pml_documentreceipt_log log, pml_edm_documenttype dt, pml_edm_documentrecordtype drt ");
				sql += " AND cv.documenttypeid = dt.documenttypeid ";
				sql += " AND dt.documentrecordtypeid = drt.documentrecordtypeid";
				sql += " AND drt.documentrecordtypeid = " + loaiSoVanBan;
			}

			if (!"".equals(trichYeu)) {
				sql += " AND (lower(cv.briefcontent) LIKE (lower('%" + trichYeu
						+ "%'))) ";
			}

			sql = CustomSQLUtil.replaceOrderBy(sql, obc);

			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("pml_edm_documentreceipt",
					PmlEdmDocumentReceiptImpl.class);

			return (List<PmlEdmDocumentReceipt>) QueryUtil.list(q,
					getDialect(), start, end);
		} catch (Exception e) {
			throw processException(e);
		} finally {
			closeSession(session);
		}
	}

	/**
	 * cv den xu ly chung - tre han
	 */
	public int countListCVDenDaXuLyChung_treHan(long userId, String soVBDen,
			String soHieuGoc, int loaiSoVanBan, String issuingplaceId,
			String noiBanHanh, String trichYeu, String tuNgay, String denNgay,
			String ngayHetHan) throws SystemException {
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
			if (!"".equals(ngayHetHan)) {
				ngayHetHan = sdf.format(df.parse(ngayHetHan));
			}
		} catch (ParseException e) {
		}

		Session session = null;

		try {
			session = openSession();

			String sql = "SELECT COUNT(*) AS COUNT_VALUE ";
			sql += " FROM pml_edm_documentreceipt cv, ( ";
			sql += " SELECT  log.documentreceiptid, MAX (log.transition_) AS tran ";
			sql += " FROM pml_documentreceipt_log log ";
			sql += " WHERE  log.processer = " + userId;
			sql += " GROUP BY log.documentreceiptid ";
			sql += ") AS logden, pml_documentreceipt_log log";
			sql += " WHERE  logden.documentreceiptid = log.documentreceiptid ";
			sql += " AND logden.tran = log.transition_ ";
			sql += " AND cv.documentreceiptid = logden.documentreceiptid ";
			sql += " AND  log.senddatebefore IS NOT NULL ";
			sql += " AND ( '" + fromDate
					+ "' <= log.dateprocess AND log.dateprocess <= '" + toDate
					+ "' )";
			sql += " AND(log.senddatebefore + log.numdateprocess + songaynghile(log.senddatebefore, log.numdateprocess)) < log.dateprocess ";

			if (!"".equals(ngayHetHan)) {
				sql += " AND (log.senddatebefore + log.numdateprocess + songaynghile(log.senddatebefore, log.numdateprocess))  <= '"
						+ ngayHetHan + "'";
			}

			if (!"".equals(soVBDen)) {
				sql += " AND (lower(cv.numberdocumentreceipt) LIKE (lower('%"
						+ soVBDen + "%'))) ";
			}

			if (!"".equals(soHieuGoc)) {
				sql += " AND (lower(cv.documentreference) LIKE (lower('%"
						+ soHieuGoc + "%'))) ";
			}

			if (!"".equals(issuingplaceId)) {
				sql = sql
						.replace(") AS logden, pml_documentreceipt_log log",
								") AS logden, pml_documentreceipt_log log, pml_edm_issuingplace iss ");
				sql += " AND cv.issuingplaceid = iss.issuingplaceid ";
				sql += " AND iss.issuingplaceid = '" + issuingplaceId + "' ";
			}

			if (!"".equals(noiBanHanh)) {
				sql += " AND (lower(cv.issuingplaceothername) LIKE (lower('%"
						+ noiBanHanh + "%'))) ";
			}

			if (0 != loaiSoVanBan) {
				sql = sql
						.replace(
								") AS logden, pml_documentreceipt_log log",
								") AS logden, pml_documentreceipt_log log, pml_edm_documenttype dt, pml_edm_documentrecordtype drt ");
				sql += " AND cv.documenttypeid = dt.documenttypeid ";
				sql += " AND dt.documentrecordtypeid = drt.documentrecordtypeid";
				sql += " AND drt.documentrecordtypeid = " + loaiSoVanBan;
			}

			if (!"".equals(trichYeu)) {
				sql += " AND (lower(cv.briefcontent) LIKE (lower('%" + trichYeu
						+ "%'))) ";
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
	 * cv den da xu ly - tu xu ly - tre han
	 */
	public List<PmlEdmDocumentReceipt> getListCVDenDaXuLyTuXuLy_treHan(
			long userId, String soVBDen, String soHieuGoc, int loaiSoVanBan,
			String issuingplaceId, String noiBanHanh, String trichYeu,
			String tuNgay, String denNgay, String ngayHetHan, int start,
			int end, OrderByComparator obc) throws SystemException {
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
			if (!"".equals(ngayHetHan)) {
				ngayHetHan = sdf.format(df.parse(ngayHetHan));
			}
		} catch (ParseException e) {
		}

		Session session = null;

		try {
			session = openSession();

			String sql = "SELECT cv.* ";
			sql += " FROM pml_edm_documentreceipt cv, ( ";
			sql += " SELECT  log.documentreceiptid, MAX (log.transition_) AS tran ";
			sql += " FROM pml_documentreceipt_log log ";
			sql += " WHERE  log.processer = " + userId;
			sql += " GROUP BY log.documentreceiptid ";
			sql += ") AS logden, pml_documentreceipt_log log";
			sql += " WHERE  logden.documentreceiptid = log.documentreceiptid ";
			sql += " AND logden.tran = log.transition_ ";
			sql += " AND log.processer = log.receiver ";
			sql += " AND cv.documentreceiptid = logden.documentreceiptid ";
			sql += " AND  log.senddatebefore IS NOT NULL ";
			sql += " AND ( '" + fromDate
					+ "' <= log.dateprocess AND log.dateprocess <= '" + toDate
					+ "' )";
			sql += " AND(log.senddatebefore + log.numdateprocess + songaynghile(log.senddatebefore, log.numdateprocess)) < log.dateprocess ";

			if (!"".equals(ngayHetHan)) {
				sql += " AND (log.senddatebefore + log.numdateprocess + songaynghile(log.senddatebefore, log.numdateprocess))  <= '"
						+ ngayHetHan + "'";
			}

			if (!"".equals(soVBDen)) {
				sql += " AND (lower(cv.numberdocumentreceipt) LIKE (lower('%"
						+ soVBDen + "%'))) ";
			}

			if (!"".equals(soHieuGoc)) {
				sql += " AND (lower(cv.documentreference) LIKE (lower('%"
						+ soHieuGoc + "%'))) ";
			}

			if (!"".equals(issuingplaceId)) {
				sql = sql
						.replace(") AS logden, pml_documentreceipt_log log",
								") AS logden, pml_documentreceipt_log log, pml_edm_issuingplace iss ");
				sql += " AND cv.issuingplaceid = iss.issuingplaceid ";
				sql += " AND iss.issuingplaceid = '" + issuingplaceId + "' ";
			}

			if (!"".equals(noiBanHanh)) {
				sql += " AND (lower(cv.issuingplaceothername) LIKE (lower('%"
						+ noiBanHanh + "%'))) ";
			}

			if (0 != loaiSoVanBan) {
				sql = sql
						.replace(
								") AS logden, pml_documentreceipt_log log",
								") AS logden, pml_documentreceipt_log log, pml_edm_documenttype dt, pml_edm_documentrecordtype drt ");
				sql += " AND cv.documenttypeid = dt.documenttypeid ";
				sql += " AND dt.documentrecordtypeid = drt.documentrecordtypeid";
				sql += " AND drt.documentrecordtypeid = " + loaiSoVanBan;
			}

			if (!"".equals(trichYeu)) {
				sql += " AND (lower(cv.briefcontent) LIKE (lower('%" + trichYeu
						+ "%'))) ";
			}

			sql = CustomSQLUtil.replaceOrderBy(sql, obc);

			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("pml_edm_documentreceipt",
					PmlEdmDocumentReceiptImpl.class);

			return (List<PmlEdmDocumentReceipt>) QueryUtil.list(q,
					getDialect(), start, end);
		} catch (Exception e) {
			throw processException(e);
		} finally {
			closeSession(session);
		}
	}

	/**
	 * cv den da xu ly - tu xu ly - tre han
	 */
	public int countListCVDenDaXuLyTuXuLy_treHan(long userId, String soVBDen,
			String soHieuGoc, int loaiSoVanBan, String issuingplaceId,
			String noiBanHanh, String trichYeu, String tuNgay, String denNgay,
			String ngayHetHan) throws SystemException {
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
			if (!"".equals(ngayHetHan)) {
				ngayHetHan = sdf.format(df.parse(ngayHetHan));
			}
		} catch (ParseException e) {
		}

		Session session = null;

		try {
			session = openSession();

			String sql = "SELECT COUNT(*) AS COUNT_VALUE ";
			sql += " FROM pml_edm_documentreceipt cv, ( ";
			sql += " SELECT  log.documentreceiptid, MAX (log.transition_) AS tran ";
			sql += " FROM pml_documentreceipt_log log ";
			sql += " WHERE  log.processer = " + userId;
			sql += " GROUP BY log.documentreceiptid ";
			sql += ") AS logden, pml_documentreceipt_log log";
			sql += " WHERE  logden.documentreceiptid = log.documentreceiptid ";
			sql += " AND logden.tran = log.transition_ ";
			sql += " AND log.processer = log.receiver ";
			sql += " AND cv.documentreceiptid = logden.documentreceiptid ";
			sql += " AND  log.senddatebefore IS NOT NULL ";
			sql += " AND ( '" + fromDate
					+ "' <= log.dateprocess AND log.dateprocess <= '" + toDate
					+ "' )";
			sql += " AND(log.senddatebefore + log.numdateprocess + songaynghile(log.senddatebefore, log.numdateprocess)) < log.dateprocess ";

			if (!"".equals(ngayHetHan)) {
				sql += " AND (log.senddatebefore + log.numdateprocess + songaynghile(log.senddatebefore, log.numdateprocess))  <= '"
						+ ngayHetHan + "'";
			}

			if (!"".equals(soVBDen)) {
				sql += " AND (lower(cv.numberdocumentreceipt) LIKE (lower('%"
						+ soVBDen + "%'))) ";
			}

			if (!"".equals(soHieuGoc)) {
				sql += " AND (lower(cv.documentreference) LIKE (lower('%"
						+ soHieuGoc + "%'))) ";
			}

			if (!"".equals(issuingplaceId)) {
				sql = sql
						.replace(") AS logden, pml_documentreceipt_log log",
								") AS logden, pml_documentreceipt_log log, pml_edm_issuingplace iss ");
				sql += " AND cv.issuingplaceid = iss.issuingplaceid ";
				sql += " AND iss.issuingplaceid = '" + issuingplaceId + "' ";
			}

			if (!"".equals(noiBanHanh)) {
				sql += " AND (lower(cv.issuingplaceothername) LIKE (lower('%"
						+ noiBanHanh + "%'))) ";
			}

			if (0 != loaiSoVanBan) {
				sql = sql
						.replace(
								") AS logden, pml_documentreceipt_log log",
								") AS logden, pml_documentreceipt_log log, pml_edm_documenttype dt, pml_edm_documentrecordtype drt ");
				sql += " AND cv.documenttypeid = dt.documenttypeid ";
				sql += " AND dt.documentrecordtypeid = drt.documentrecordtypeid";
				sql += " AND drt.documentrecordtypeid = " + loaiSoVanBan;
			}

			if (!"".equals(trichYeu)) {
				sql += " AND (lower(cv.briefcontent) LIKE (lower('%" + trichYeu
						+ "%'))) ";
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

	public List<PmlEdmDocumentReceipt> findByDocumentReceipt_Users_Status_DangXuLy(
			List<Long> userIds, long statusId, String soVBDen,
			String soHieuGoc, int loaiSoVanBan, String issuingplaceId,
			String noiBanHanh, String trichYeu, String tuNgay, String denNgay,
			String ngayHetHan, int start, int end, OrderByComparator obc)
			throws Exception {
		Session session = null;

		try {
			session = openSession();

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
				if (!"".equals(ngayHetHan)) {
					ngayHetHan = sdf.format(df.parse(ngayHetHan));
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

			DocumentReceiptLiferayWorkflowService workflowService = new DocumentReceiptLiferayWorkflowService();
			List<Long> listProcessId = workflowService
					.getListProcessInstanceByStatusId(userIds, statusId);

			String sql = "SELECT DISTINCT(cv.*) ";
			sql += "FROM pml_edm_documentreceipt cv, pml_documentreceipt_wf cvwf,";
			sql += " (SELECT MAX(log.transition_) as maxtran, log.documentreceiptid";
			sql += " FROM pml_documentreceipt_log log";
			sql += " WHERE log.processer IN (" + userIdList + ")"; // truong hop
																	// xu ly
																	// thay nen
																	// nhap vao
																	// ds userId
			sql += " GROUP BY log.documentreceiptid) AS a, pml_documentreceipt_log log";
			if (0 != loaiSoVanBan) { // chon so cong van
				sql += ", pml_edm_documenttype dt, pml_edm_documentrecordtype drt";
			}

			if (!"".equals(issuingplaceId)) {
				sql += ", pml_edm_issuingplace iss ";
			}

			sql += " WHERE cv.documentreceiptid = cvwf.documentreceiptid ";
			sql += " AND NOT EXISTS (SELECT * FROM pml_edm_answerdetail WHERE documentreceiptid = cv.documentreceiptid) ";

			sql += " AND cvwf.processid in (";

			for (Long processId : listProcessId) {
				sql += processId + ",";
			}

			sql += "0)";

			sql += " AND log.documentreceiptid = cvwf.documentreceiptid";
			// sql += " AND cv.documentreceiptid = log.documentreceiptid";
			sql += " AND a.maxtran = log.transition_";
			sql += " AND a.documentreceiptid = log.documentreceiptid";
			sql += " AND log.dateprocess is null ";
			sql += " AND (log.senddatebefore IS NULL  "; // truong hop vua tiep
															// nhan ko co
															// senddatebefore
			sql += " OR (log.senddatebefore IS NOT NULL "; // TH nhan van ban tu
															// nguoi khac chuyen
															// den
			sql += " AND ( '" + fromDate
					+ "' <= log.senddatebefore AND log.senddatebefore <= '"
					+ toDate + "' )))";
			sql += " AND (log.numdateprocess > 0 OR (log.numdateprocess = 0))";

			if (0 != loaiSoVanBan) {
				sql += " AND cv.documenttypeid = dt.documenttypeid AND dt.documentrecordtypeid = drt.documentrecordtypeid AND drt.documentrecordtypeid = "
						+ loaiSoVanBan;
			}

			if (!"".equals(ngayHetHan)) {
				sql += " AND (log.senddatebefore + log.numdateprocess + songaynghile(log.senddatebefore, log.numdateprocess))  <= '"
						+ ngayHetHan + "'";
			}

			if (!"".equals(soVBDen)) {
				sql += " AND (lower(cv.numberdocumentreceipt) LIKE (lower('%"
						+ soVBDen + "%'))) ";
			}

			if (!"".equals(soHieuGoc)) {
				sql += " AND (lower(cv.documentreference) LIKE (lower('%"
						+ soHieuGoc + "%'))) ";
			}

			if (!"".equals(issuingplaceId)) {
				sql += " AND cv.issuingplaceid = iss.issuingplaceid ";
				sql += " AND iss.issuingplaceid = '" + issuingplaceId + "' ";
			}

			if (!"".equals(noiBanHanh)) {
				sql += " AND (lower(cv.issuingplaceothername) LIKE (lower('%"
						+ noiBanHanh + "%'))) ";
			}

			if (!"".equals(trichYeu)) {
				sql += " AND (lower(cv.briefcontent) LIKE (lower('%" + trichYeu
						+ "%'))) ";
			}

			sql = CustomSQLUtil.replaceOrderBy(sql, obc);
			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("PmlEdmDocumentReceipt",
					PmlEdmDocumentReceiptImpl.class);

			return (List<PmlEdmDocumentReceipt>) QueryUtil.list(q,
					getDialect(), start, end);
		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}

	public int countByDocumentReceipt_Users_Status_DangXuLy(List<Long> userIds,
			long statusId, String soVBDen, String soHieuGoc, int loaiSoVanBan,
			String issuingplaceId, String noiBanHanh, String trichYeu,
			String tuNgay, String denNgay, String ngayHetHan) throws Exception {
		Session session = null;

		try {
			session = openSession();

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
				if (!"".equals(ngayHetHan)) {
					ngayHetHan = sdf.format(df.parse(ngayHetHan));
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

			DocumentReceiptLiferayWorkflowService workflowService = new DocumentReceiptLiferayWorkflowService();
			List<Long> listProcessId = workflowService
					.getListProcessInstanceByStatusId(userIds, statusId);

			String sql = "SELECT COUNT(*) AS COUNT_VALUE ";
			sql += "FROM pml_edm_documentreceipt cv, pml_documentreceipt_wf cvwf,";
			sql += " (SELECT MAX(log.transition_) as maxtran, log.documentreceiptid";
			sql += " FROM pml_documentreceipt_log log";
			sql += " WHERE log.processer IN (" + userIdList + ")"; // truong hop
																	// xu ly
																	// thay nen
																	// nhap vao
																	// ds userId
			sql += " GROUP BY log.documentreceiptid) AS a, pml_documentreceipt_log log";
			if (0 != loaiSoVanBan) { // chon so cong van
				sql += ", pml_edm_documenttype dt, pml_edm_documentrecordtype drt";
			}

			if (!"".equals(issuingplaceId)) {
				sql += ", pml_edm_issuingplace iss ";
			}

			sql += " WHERE cv.documentreceiptid = cvwf.documentreceiptid ";
			sql += " AND NOT EXISTS (SELECT * FROM pml_edm_answerdetail WHERE documentreceiptid = cv.documentreceiptid) ";

			sql += " AND cvwf.processid in (";

			for (Long processId : listProcessId) {
				sql += processId + ",";
			}

			sql += "0)";

			sql += " AND log.documentreceiptid = cvwf.documentreceiptid";
			sql += " AND a.maxtran = log.transition_";
			sql += " AND a.documentreceiptid = log.documentreceiptid";
			sql += " AND log.dateprocess is null ";
			sql += " AND (log.senddatebefore IS NULL  "; // truong hop vua tiep
															// nhan ko co
															// senddatebefore
			sql += " OR (log.senddatebefore IS NOT NULL "; // TH nhan van ban tu
															// nguoi khac chuyen
															// den
			sql += " AND ( '" + fromDate
					+ "' <= log.senddatebefore AND log.senddatebefore <= '"
					+ toDate + "' )))";
			sql += " AND (log.numdateprocess > 0 OR (log.numdateprocess = 0))";

			if (0 != loaiSoVanBan) {
				sql += " AND cv.documenttypeid = dt.documenttypeid AND dt.documentrecordtypeid = drt.documentrecordtypeid AND drt.documentrecordtypeid = "
						+ loaiSoVanBan;
			}

			if (!"".equals(ngayHetHan)) {
				sql += " AND (log.senddatebefore + log.numdateprocess + songaynghile(log.senddatebefore, log.numdateprocess))  <= '"
						+ ngayHetHan + "'";
			}

			if (!"".equals(soVBDen)) {
				sql += " AND (lower(cv.numberdocumentreceipt) LIKE (lower('%"
						+ soVBDen + "%'))) ";
			}

			if (!"".equals(soHieuGoc)) {
				sql += " AND (lower(cv.documentreference) LIKE (lower('%"
						+ soHieuGoc + "%'))) ";
			}

			if (!"".equals(issuingplaceId)) {
				sql += " AND cv.issuingplaceid = iss.issuingplaceid ";
				sql += " AND iss.issuingplaceid = '" + issuingplaceId + "' ";
			}

			if (!"".equals(noiBanHanh)) {
				sql += " AND (lower(cv.issuingplaceothername) LIKE (lower('%"
						+ noiBanHanh + "%'))) ";
			}

			if (!"".equals(trichYeu)) {
				sql += " AND (lower(cv.briefcontent) LIKE (lower('%" + trichYeu
						+ "%'))) ";
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

	public List<PmlEdmDocumentReceipt> findByDocumentReceipt_Users_Status_DangXuLy_TreHan(
			List<Long> userIds, long statusId, String soVBDen,
			String soHieuGoc, int loaiSoVanBan, String issuingplaceId,
			String noiBanHanh, String trichYeu, String tuNgay, String denNgay,
			String ngayHetHan, int start, int end, OrderByComparator obc)
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
			if (!"".equals(ngayHetHan)) {
				ngayHetHan = sdf.format(df.parse(ngayHetHan));
			}
		} catch (ParseException e) {
		}

		Session session = null;

		try {
			session = openSession();

			// Lay ngay hien tai
			String currentDate = new SimpleDateFormat("yyyy-MM-dd")
					.format(new Date());

			String userIdList = "";
			for (int i = 0; i < userIds.size(); i++) {
				if (i != userIds.size() - 1) {
					userIdList += userIds.get(i) + ", ";
				}
				userIdList += userIds.get(i);
			}
			DocumentReceiptLiferayWorkflowService workflowService = new DocumentReceiptLiferayWorkflowService();
			List<Long> listProcessId = workflowService
					.getListProcessInstanceByStatusId(userIds, statusId);

			String sql = "SELECT DISTINCT(cv.*) ";
			sql += "FROM pml_edm_documentreceipt cv, pml_documentreceipt_wf cvwf, ";
			sql += "(SELECT MAX(log.transition_) as maxtran, log.documentreceiptid";
			sql += " FROM pml_documentreceipt_log log";
			sql += " WHERE log.processer IN (" + userIdList + ")"; // truong hop
																	// xu ly
																	// thay nen
																	// nhap vao
																	// ds userId
			sql += " GROUP BY log.documentreceiptid) AS a, pml_documentreceipt_log log";

			if (0 != loaiSoVanBan) {
				sql += ", pml_edm_documenttype dt, pml_edm_documentrecordtype drt";
			}

			if (!"".equals(issuingplaceId)) {
				sql += ", pml_edm_issuingplace iss ";
			}

			sql += " WHERE cv.documentreceiptid = cvwf.documentreceiptid ";
			sql += " AND NOT EXISTS (SELECT * FROM pml_edm_answerdetail WHERE documentreceiptid = cv.documentreceiptid) ";

			sql += " AND cvwf.processid in (";

			for (Long processId : listProcessId) {
				sql += processId + ",";
			}

			sql += "0) ";

			sql += " AND cv.datearrive + cv.processtime + songaynghile(cv.datearrive, cv.processtime) < '"
					+ currentDate + "'";

			sql += " AND log.documentreceiptid = cvwf.documentreceiptid";
			sql += " AND a.maxtran = log.transition_";
			sql += " AND a.documentreceiptid = log.documentreceiptid";
			sql += " AND log.dateprocess is null ";
			sql += " AND log.senddatebefore is not null AND log.senddatebefore <= '"
					+ currentDate + "'";
			sql += " AND ( '" + fromDate
					+ "' <= log.senddatebefore AND log.senddatebefore <= '"
					+ toDate + "' )";
			sql += " AND log.numdateprocess > 0 ";
			sql += " AND (log.senddatebefore + log.numdateprocess + songaynghile(log.senddatebefore, log.numdateprocess)) < '"
					+ currentDate + "'";

			if (0 != loaiSoVanBan) {
				sql += " AND cv.documenttypeid = dt.documenttypeid AND dt.documentrecordtypeid = drt.documentrecordtypeid AND drt.documentrecordtypeid = "
						+ loaiSoVanBan;
			}

			if (!"".equals(ngayHetHan)) {
				sql += " AND (log.senddatebefore + log.numdateprocess + songaynghile(log.senddatebefore, log.numdateprocess))  <= '"
						+ ngayHetHan + "'";
			}

			if (!"".equals(soVBDen)) {
				sql += " AND (lower(cv.numberdocumentreceipt) LIKE (lower('%"
						+ soVBDen + "%'))) ";
			}

			if (!"".equals(soHieuGoc)) {
				sql += " AND (lower(cv.documentreference) LIKE (lower('%"
						+ soHieuGoc + "%'))) ";
			}

			if (!"".equals(issuingplaceId)) {
				sql += " AND cv.issuingplaceid = iss.issuingplaceid ";
				sql += " AND iss.issuingplaceid = '" + issuingplaceId + "' ";
			}

			if (!"".equals(noiBanHanh)) {
				sql += " AND (lower(cv.issuingplaceothername) LIKE (lower('%"
						+ noiBanHanh + "%'))) ";
			}

			if (!"".equals(trichYeu)) {
				sql += " AND (lower(cv.briefcontent) LIKE (lower('%" + trichYeu
						+ "%'))) ";
			}

			sql = CustomSQLUtil.replaceOrderBy(sql, obc);

			SQLQuery q = session.createSQLQuery(sql);

			q.addEntity("PmlEdmDocumentReceipt",
					PmlEdmDocumentReceiptImpl.class);

			return (List<PmlEdmDocumentReceipt>) QueryUtil.list(q,
					getDialect(), start, end);
		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}

	public int countByDocumentReceipt_Users_Status_DangXuLy_TreHan(
			List<Long> userIds, long statusId, String soVBDen,
			String soHieuGoc, int loaiSoVanBan, String issuingplaceId,
			String noiBanHanh, String trichYeu, String tuNgay, String denNgay,
			String ngayHetHan) throws Exception {

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
			if (!"".equals(ngayHetHan)) {
				ngayHetHan = sdf.format(df.parse(ngayHetHan));
			}
		} catch (ParseException e) {
		}

		Session session = null;

		try {
			session = openSession();

			// Lay ngay hien tai
			String currentDate = new SimpleDateFormat("yyyy-MM-dd")
					.format(new Date());

			String userIdList = "";
			for (int i = 0; i < userIds.size(); i++) {
				if (i != userIds.size() - 1) {
					userIdList += userIds.get(i) + ", ";
				}
				userIdList += userIds.get(i);
			}

			DocumentReceiptLiferayWorkflowService workflowService = new DocumentReceiptLiferayWorkflowService();
			List<Long> listProcessId = workflowService
					.getListProcessInstanceByStatusId(userIds, statusId);

			String sql = "SELECT COUNT(DISTINCT(cv.documentreceiptid)) AS COUNT_VALUE ";
			sql += "FROM pml_edm_documentreceipt cv, pml_documentreceipt_wf cvwf, ";
			sql += "(SELECT MAX(log.transition_) as maxtran, log.documentreceiptid";
			sql += " FROM pml_documentreceipt_log log";
			sql += " WHERE log.processer IN (" + userIdList + ")"; // truong hop
																	// xu ly
																	// thay nen
																	// nhap vao
																	// ds userId
			sql += " GROUP BY log.documentreceiptid) AS a, pml_documentreceipt_log log";

			if (0 != loaiSoVanBan) {
				sql += ", pml_edm_documenttype dt, pml_edm_documentrecordtype drt";
			}

			if (!"".equals(issuingplaceId)) {
				sql += ", pml_edm_issuingplace iss ";
			}

			sql += " WHERE cv.documentreceiptid = cvwf.documentreceiptid ";
			sql += " AND NOT EXISTS (SELECT * FROM pml_edm_answerdetail WHERE documentreceiptid = cv.documentreceiptid) ";

			sql += "AND cvwf.processid in (";

			for (Long processId : listProcessId) {
				sql += processId + ",";
			}

			sql += "0) ";

			sql += " AND cv.datearrive + cv.processtime + songaynghile(cv.datearrive, cv.processtime) < '"
					+ currentDate + "'";

			sql += " AND log.documentreceiptid = cvwf.documentreceiptid";
			sql += " AND a.maxtran = log.transition_";
			sql += " AND a.documentreceiptid = log.documentreceiptid";
			sql += " AND log.dateprocess is null ";
			sql += " AND log.senddatebefore is not null AND log.senddatebefore <= '"
					+ currentDate + "'";
			sql += " AND ( '" + fromDate
					+ "' <= log.senddatebefore AND log.senddatebefore <= '"
					+ toDate + "' )";
			sql += " AND log.numdateprocess > 0 ";
			sql += " AND (log.senddatebefore + log.numdateprocess + songaynghile(log.senddatebefore, log.numdateprocess)) < '"
					+ currentDate + "'";

			if (0 != loaiSoVanBan) {
				sql += " AND cv.documenttypeid = dt.documenttypeid AND dt.documentrecordtypeid = drt.documentrecordtypeid AND drt.documentrecordtypeid = "
						+ loaiSoVanBan;
			}

			if (!"".equals(ngayHetHan)) {
				sql += " AND (log.senddatebefore + log.numdateprocess + songaynghile(log.senddatebefore, log.numdateprocess))  <= '"
						+ ngayHetHan + "'";
			}

			if (!"".equals(soVBDen)) {
				sql += " AND (lower(cv.numberdocumentreceipt) LIKE (lower('%"
						+ soVBDen + "%'))) ";
			}

			if (!"".equals(soHieuGoc)) {
				sql += " AND (lower(cv.documentreference) LIKE (lower('%"
						+ soHieuGoc + "%'))) ";
			}

			if (!"".equals(issuingplaceId)) {
				sql += " AND cv.issuingplaceid = iss.issuingplaceid ";
				sql += " AND iss.issuingplaceid = '" + issuingplaceId + "' ";
			}

			if (!"".equals(noiBanHanh)) {
				sql += " AND (lower(cv.issuingplaceothername) LIKE (lower('%"
						+ noiBanHanh + "%'))) ";
			}

			if (!"".equals(trichYeu)) {
				sql += " AND (lower(cv.briefcontent) LIKE (lower('%" + trichYeu
						+ "%'))) ";
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

	public List<PmlEdmDocumentReceipt> findByDocumentReceipt_Users(
			List<Long> userIds, String soVBDen, String soHieuGoc,
			int loaiSoVanBan, String issuingplaceId, String noiBanHanh,
			String trichYeu, String tuNgay, String denNgay, int start, int end,
			OrderByComparator obc) throws Exception {
		Session session = null;

		try {
			session = openSession();

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

			DocumentReceiptLiferayWorkflowService workflowService = new DocumentReceiptLiferayWorkflowService();
			List<Long> listProcessId = workflowService
					.getProcessInstances(userIds);

			String sql = "SELECT DISTINCT(cv.*) ";
			sql += "FROM pml_edm_documentreceipt cv, pml_documentreceipt_wf cvwf, ";
			sql += " (SELECT MAX(log.transition_) as maxtran, log.documentreceiptid";
			sql += " FROM pml_documentreceipt_log log";
			sql += " WHERE log.processer IN (" + userIdList + ")"; // truong hop
																	// xu ly
																	// thay nen
																	// nhap vao
																	// ds userId
			sql += " GROUP BY log.documentreceiptid) AS a, pml_documentreceipt_log log";

			if (0 != loaiSoVanBan) { // chon loai so cong van
				sql += ", pml_edm_documenttype dt";
			}

			if (!"".equals(issuingplaceId)) {
				sql += ", pml_edm_issuingplace iss ";
			}

			sql += " WHERE cv.documentreceiptid = cvwf.documentreceiptid ";
			sql += " AND NOT EXISTS (SELECT * FROM pml_edm_answerdetail WHERE documentreceiptid = cv.documentreceiptid) ";

			sql += "AND cvwf.processid in (";

			for (Long processId : listProcessId) {
				sql += processId + ",";
			}

			sql += "0)";

			sql += " AND log.documentreceiptid = cvwf.documentreceiptid";
			sql += " AND a.maxtran = log.transition_";
			sql += " AND a.documentreceiptid = log.documentreceiptid";
			sql += " AND log.dateprocess is null ";
			sql += " AND (log.senddatebefore IS NULL  "; // truong hop vua tiep
															// nhan ko co
															// senddatebefore
			sql += " OR (log.senddatebefore IS NOT NULL "; // TH nhan van ban tu
															// nguoi khac chuyen
															// den
			sql += " AND ( '" + fromDate
					+ "' <= log.senddatebefore AND log.senddatebefore <= '"
					+ toDate + "' )))";

			if (0 != loaiSoVanBan) {
				sql += " AND cv.documenttypeid = dt.documenttypeid  AND dt.documenttypeid = "
						+ loaiSoVanBan;// ham nay select theo loai VB
			}

			if (!"".equals(soVBDen)) {
				sql += " AND (lower(cv.numberdocumentreceipt) LIKE (lower('%"
						+ soVBDen + "%'))) ";
			}

			if (!"".equals(soHieuGoc)) {
				sql += " AND (lower(cv.documentreference) LIKE (lower('%"
						+ soHieuGoc + "%'))) ";
			}

			if (!"".equals(issuingplaceId)) {
				sql += " AND cv.issuingplaceid = iss.issuingplaceid ";
				sql += " AND iss.issuingplaceid = '" + issuingplaceId + "' ";
			}

			if (!"".equals(noiBanHanh)) {
				sql += " AND (lower(cv.issuingplaceothername) LIKE (lower('%"
						+ noiBanHanh + "%'))) ";
			}

			if (!"".equals(trichYeu)) {
				sql += " AND (lower(cv.briefcontent) LIKE (lower('%" + trichYeu
						+ "%'))) ";
			}

			sql = CustomSQLUtil.replaceOrderBy(sql, obc);

			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("PmlEdmDocumentReceipt",
					PmlEdmDocumentReceiptImpl.class);

			return (List<PmlEdmDocumentReceipt>) QueryUtil.list(q,
					getDialect(), start, end);
		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}

	public int countByDocumentReceipt_Users(List<Long> userIds, String soVBDen,
			String soHieuGoc, int loaiSoVanBan, String issuingplaceId,
			String noiBanHanh, String trichYeu, String tuNgay, String denNgay)
			throws Exception {
		Session session = null;

		try {
			session = openSession();

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

			DocumentReceiptLiferayWorkflowService workflowService = new DocumentReceiptLiferayWorkflowService();
			List<Long> listProcessId = workflowService
					.getProcessInstances(userIds);

			String sql = "SELECT COUNT(DISTINCT(cv.documentreceiptid)) AS COUNT_VALUE ";
			sql += "FROM pml_edm_documentreceipt cv, pml_documentreceipt_wf cvwf, ";
			sql += " (SELECT MAX(log.transition_) as maxtran, log.documentreceiptid";
			sql += " FROM pml_documentreceipt_log log";
			sql += " WHERE log.processer IN (" + userIdList + ")"; // truong hop
																	// xu ly
																	// thay nen
																	// nhap vao
																	// ds userId
			sql += " GROUP BY log.documentreceiptid) AS a, pml_documentreceipt_log log";

			if (0 != loaiSoVanBan) { // chon loai so cong van
				sql += ", pml_edm_documenttype dt";
			}

			if (!"".equals(issuingplaceId)) {
				sql += ", pml_edm_issuingplace iss ";
			}

			sql += " WHERE cv.documentreceiptid = cvwf.documentreceiptid ";
			sql += " AND NOT EXISTS (SELECT * FROM pml_edm_answerdetail WHERE documentreceiptid = cv.documentreceiptid) ";

			sql += "AND cvwf.processid in (";

			for (Long processId : listProcessId) {
				sql += processId + ",";
			}

			sql += "0)";

			sql += " AND log.documentreceiptid = cvwf.documentreceiptid";
			sql += " AND a.maxtran = log.transition_";
			sql += " AND a.documentreceiptid = log.documentreceiptid";
			sql += " AND log.dateprocess is null ";
			sql += " AND (log.senddatebefore IS NULL  "; // truong hop vua tiep
															// nhan ko co
															// senddatebefore
			sql += " OR (log.senddatebefore IS NOT NULL "; // TH nhan van ban tu
															// nguoi khac chuyen
															// den
			sql += " AND ( '" + fromDate
					+ "' <= log.senddatebefore AND log.senddatebefore <= '"
					+ toDate + "' )))";

			if (0 != loaiSoVanBan) {
				sql += " AND cv.documenttypeid = dt.documenttypeid  AND dt.documenttypeid = "
						+ loaiSoVanBan;// ham nay select theo loai VB
			}

			if (!"".equals(soVBDen)) {
				sql += " AND (lower(cv.numberdocumentreceipt) LIKE (lower('%"
						+ soVBDen + "%'))) ";
			}

			if (!"".equals(soHieuGoc)) {
				sql += " AND (lower(cv.documentreference) LIKE (lower('%"
						+ soHieuGoc + "%'))) ";
			}

			if (!"".equals(issuingplaceId)) {
				sql += " AND cv.issuingplaceid = iss.issuingplaceid ";
				sql += " AND iss.issuingplaceid = '" + issuingplaceId + "' ";
			}

			if (!"".equals(noiBanHanh)) {
				sql += " AND (lower(cv.issuingplaceothername) LIKE (lower('%"
						+ noiBanHanh + "%'))) ";
			}

			if (!"".equals(trichYeu)) {
				sql += " AND (lower(cv.briefcontent) LIKE (lower('%" + trichYeu
						+ "%'))) ";
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

	// end yenlt 14/10/2010

	/**
	 * phmphuc them cac phuong thuc lay ds log tuong tu nhu receipt muc dich lay
	 * noi dung yeu cau xu ly cho tung receipt 12/11/2010
	 */
	// chuyen vien dang xu ly
	public List<PmlDocumentReceiptLog> findByDocumentReceiptLog_Users_Status_DangXuLy(
			List<Long> userIds, long statusId, String soVBDen,
			String soHieuGoc, int loaiSoVanBan, String issuingplaceId,
			String noiBanHanh, String trichYeu, String tuNgay, String denNgay,
			String ngayHetHan, int start, int end, OrderByComparator obc)
			throws Exception {
		Session session = null;

		try {
			session = openSession();

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
				if (!"".equals(ngayHetHan)) {
					ngayHetHan = sdf.format(df.parse(ngayHetHan));
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

			DocumentReceiptLiferayWorkflowService workflowService = new DocumentReceiptLiferayWorkflowService();
			List<Long> listProcessId = workflowService
					.getListProcessInstanceByStatusId(userIds, statusId);

			String sql = "SELECT log.*, cv.generalorderno, cv.datearrive ";
			sql += "FROM pml_edm_documentreceipt cv, pml_documentreceipt_wf cvwf,";
			sql += " (SELECT MAX(log.transition_) as maxtran, log.documentreceiptid";
			sql += " FROM pml_documentreceipt_log log";
			sql += " WHERE log.receiver IN (" + userIdList + ")"; // truong hop
																	// xu ly
																	// thay nen
																	// nhap vao
																	// ds userId
			sql += " GROUP BY log.documentreceiptid) AS a, pml_documentreceipt_log log";

			if (0 != loaiSoVanBan) { // chon so cong van
				sql += ", pml_edm_documenttype dt, pml_edm_documentrecordtype drt";
			}

			if (!"".equals(issuingplaceId)) {
				sql += ", pml_edm_issuingplace iss ";
			}

			sql += " WHERE cv.documentreceiptid = cvwf.documentreceiptid ";
			sql += " AND NOT EXISTS (SELECT * FROM pml_edm_answerdetail WHERE documentreceiptid = cv.documentreceiptid) ";

			sql += " AND cvwf.processid in (";

			for (Long processId : listProcessId) {
				sql += processId + ",";
			}

			sql += "0)";

			sql += " AND log.documentreceiptid = cvwf.documentreceiptid";
			sql += " AND a.maxtran = log.transition_";
			sql += " AND a.documentreceiptid = log.documentreceiptid";
			sql += " AND cv.datearrive is not null ";
			sql += " AND ( '" + fromDate
					+ "' <= cv.datearrive AND cv.datearrive <= '" + toDate
					+ "' )";

			if (0 != loaiSoVanBan) {
				sql += " AND cv.documenttypeid = dt.documenttypeid AND dt.documentrecordtypeid = drt.documentrecordtypeid AND drt.documentrecordtypeid = "
						+ loaiSoVanBan;
			}

			if (!"".equals(ngayHetHan)) {
				sql += " AND (log.dateprocess + log.numdateprocess + songaynghile(log.dateprocess, log.numdateprocess))  <= '"
						+ ngayHetHan + "'";
			}

			if (!"".equals(soVBDen)) {
				sql += " AND (lower(cv.numberdocumentreceipt) LIKE (lower('%"
						+ soVBDen + "%'))) ";
			}

			if (!"".equals(soHieuGoc)) {
				sql += " AND (lower(cv.documentreference) LIKE (lower('%"
						+ soHieuGoc + "%'))) ";
			}

			if (!"".equals(issuingplaceId)) {
				sql += " AND cv.issuingplaceid = iss.issuingplaceid ";
				sql += " AND iss.issuingplaceid = '" + issuingplaceId + "' ";
			}

			if (!"".equals(noiBanHanh)) {
				sql += " AND (lower(cv.issuingplaceothername) LIKE (lower('%"
						+ noiBanHanh + "%'))) ";
			}

			if (!"".equals(trichYeu)) {
				sql += " AND (lower(cv.briefcontent) LIKE (lower('%" + trichYeu
						+ "%'))) ";
			}

			sql = CustomSQLUtil.replaceOrderBy(sql, obc);
			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("PmlDocumentReceiptLog",
					PmlDocumentReceiptLogImpl.class);

			return (List<PmlDocumentReceiptLog>) QueryUtil.list(q,
					getDialect(), start, end);
		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}

	// chuyen vien xu ly tre han
	public List<PmlDocumentReceiptLog> findByDocumentReceiptLog_Users_Status_DangXuLy_TreHan(
			List<Long> userIds, long statusId, String soVBDen,
			String soHieuGoc, int loaiSoVanBan, String issuingplaceId,
			String noiBanHanh, String trichYeu, String tuNgay, String denNgay,
			String ngayHetHan, int start, int end, OrderByComparator obc)
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
			if (!"".equals(ngayHetHan)) {
				ngayHetHan = sdf.format(df.parse(ngayHetHan));
			}
		} catch (ParseException e) {
		}

		Session session = null;

		try {
			session = openSession();

			// Lay ngay hien tai
			String currentDate = new SimpleDateFormat("yyyy-MM-dd")
					.format(new Date());

			String userIdList = "";
			for (int i = 0; i < userIds.size(); i++) {
				if (i != userIds.size() - 1) {
					userIdList += userIds.get(i) + ", ";
				}
				userIdList += userIds.get(i);
			}
			DocumentReceiptLiferayWorkflowService workflowService = new DocumentReceiptLiferayWorkflowService();
			List<Long> listProcessId = workflowService
					.getListProcessInstanceByStatusId(userIds, statusId);

			String sql = "SELECT log.*, cv.generalorderno, cv.datearrive ";
			sql += "FROM pml_edm_documentreceipt cv, pml_documentreceipt_wf cvwf, ";
			sql += "(SELECT MAX(transition_) as maxtran, documentreceiptid";
			sql += " FROM pml_documentreceipt_log ";
			sql += " WHERE receiver IN (" + userIdList + ") OR (transition_ = 1 AND processer IN (" + userIdList + "))"; 
			sql += " GROUP BY documentreceiptid) AS a, pml_documentreceipt_log log";

			if (0 != loaiSoVanBan) {
				sql += ", pml_edm_documenttype dt, pml_edm_documentrecordtype drt";
			}

			if (!"".equals(issuingplaceId)) {
				sql += ", pml_edm_issuingplace iss ";
			}

			sql += " WHERE cv.documentreceiptid = cvwf.documentreceiptid ";
			sql += " AND NOT EXISTS (SELECT * FROM pml_edm_answerdetail WHERE documentreceiptid = cv.documentreceiptid) ";

			sql += " AND cvwf.processid in (";

			for (Long processId : listProcessId) {
				sql += processId + ",";
			}

			sql += "0) ";

			sql += " AND cv.datearrive + cv.processtime + songaynghile(cv.datearrive, cv.processtime) < '"
					+ currentDate + "'";

			sql += " AND log.documentreceiptid = cvwf.documentreceiptid";
			sql += " AND a.maxtran = log.transition_";
			sql += " AND a.documentreceiptid = log.documentreceiptid";
			sql += " AND cv.datearrive is not null ";
			sql += " AND ( '" + fromDate
					+ "' <= cv.datearrive AND cv.datearrive <= '" + toDate
					+ "' )";
			sql += " AND (log.dateprocess + log.numdateprocess + songaynghile(log.dateprocess, log.numdateprocess)) < '"
					+ currentDate + "'";

			if (0 != loaiSoVanBan) {
				sql += " AND cv.documenttypeid = dt.documenttypeid AND dt.documentrecordtypeid = drt.documentrecordtypeid AND drt.documentrecordtypeid = "
						+ loaiSoVanBan;
			}

			if (!"".equals(ngayHetHan)) {
				sql += " AND (log.dateprocess + log.numdateprocess + songaynghile(log.dateprocess, log.numdateprocess))  <= '"
						+ ngayHetHan + "'";
			}

			if (!"".equals(soVBDen)) {
				sql += " AND (lower(cv.numberdocumentreceipt) LIKE (lower('%"
						+ soVBDen + "%'))) ";
			}

			if (!"".equals(soHieuGoc)) {
				sql += " AND (lower(cv.documentreference) LIKE (lower('%"
						+ soHieuGoc + "%'))) ";
			}

			if (!"".equals(issuingplaceId)) {
				sql += " AND cv.issuingplaceid = iss.issuingplaceid ";
				sql += " AND iss.issuingplaceid = '" + issuingplaceId + "' ";
			}

			if (!"".equals(noiBanHanh)) {
				sql += " AND (lower(cv.issuingplaceothername) LIKE (lower('%"
						+ noiBanHanh + "%'))) ";
			}

			if (!"".equals(trichYeu)) {
				sql += " AND (lower(cv.briefcontent) LIKE (lower('%" + trichYeu
						+ "%'))) ";
			}

			sql = CustomSQLUtil.replaceOrderBy(sql, obc);

			SQLQuery q = session.createSQLQuery(sql);

			q.addEntity("PmlDocumentReceiptLog",
					PmlDocumentReceiptLogImpl.class);

			return (List<PmlDocumentReceiptLog>) QueryUtil.list(q,
					getDialect(), start, end);
		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}

	// truong hop xu ly thay
	public List<PmlDocumentReceiptLog> findByDocumentReceiptLog_Users(
			List<Long> userIds, String soVBDen, String soHieuGoc,
			int loaiSoVanBan, String issuingplaceId, String noiBanHanh,
			String trichYeu, String tuNgay, String denNgay, int start, int end,
			OrderByComparator obc) throws Exception {
		Session session = null;

		try {
			session = openSession();

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

			DocumentReceiptLiferayWorkflowService workflowService = new DocumentReceiptLiferayWorkflowService();
			List<Long> listProcessId = workflowService
					.getProcessInstances(userIds);

			String sql = "SELECT log.*, cv.generalorderno, cv.datearrive ";
			sql += "FROM pml_edm_documentreceipt cv, pml_documentreceipt_wf cvwf, ";
			sql += "(SELECT MAX(transition_) as maxtran, documentreceiptid";
			sql += " FROM pml_documentreceipt_log ";
			sql += " WHERE receiver IN (" + userIdList + ") OR (transition_ = 1 AND processer IN (" + userIdList + "))"; 
			sql += " GROUP BY documentreceiptid) AS a, pml_documentreceipt_log log";

			if (0 != loaiSoVanBan) { // chon loai so cong van
				sql += ", pml_edm_documenttype dt";
			}

			if (!"".equals(issuingplaceId)) {
				sql += ", pml_edm_issuingplace iss ";
			}

			sql += " WHERE cv.documentreceiptid = cvwf.documentreceiptid ";
			sql += " AND NOT EXISTS (SELECT * FROM pml_edm_answerdetail WHERE documentreceiptid = cv.documentreceiptid) ";

			sql += "AND cvwf.processid in (";

			for (Long processId : listProcessId) {
				sql += processId + ",";
			}

			sql += "0)";

			sql += " AND log.documentreceiptid = cvwf.documentreceiptid";
			sql += " AND a.maxtran = log.transition_";
			sql += " AND a.documentreceiptid = log.documentreceiptid";
			sql += " AND log.dateprocess is not null ";
			sql += " AND ( '" + fromDate
					+ "' <= log.dateprocess AND log.dateprocess <= '" + toDate
					+ "' )";

			if (0 != loaiSoVanBan) {
				sql += " AND cv.documenttypeid = dt.documenttypeid  AND dt.documenttypeid = "
						+ loaiSoVanBan;
			}

			if (!"".equals(soVBDen)) {
				sql += " AND (lower(cv.numberdocumentreceipt) LIKE (lower('%"
						+ soVBDen + "%'))) ";
			}

			if (!"".equals(soHieuGoc)) {
				sql += " AND (lower(cv.documentreference) LIKE (lower('%"
						+ soHieuGoc + "%'))) ";
			}

			if (!"".equals(issuingplaceId)) {
				sql += " AND cv.issuingplaceid = iss.issuingplaceid ";
				sql += " AND iss.issuingplaceid = '" + issuingplaceId + "' ";
			}

			if (!"".equals(noiBanHanh)) {
				sql += " AND (lower(cv.issuingplaceothername) LIKE (lower('%"
						+ noiBanHanh + "%'))) ";
			}

			if (!"".equals(trichYeu)) {
				sql += " AND (lower(cv.briefcontent) LIKE (lower('%" + trichYeu
						+ "%'))) ";
			}

			sql = CustomSQLUtil.replaceOrderBy(sql, obc);

			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("PmlDocumentReceiptLog",
					PmlDocumentReceiptLogImpl.class);

			return (List<PmlDocumentReceiptLog>) QueryUtil.list(q,
					getDialect(), start, end);
		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}

	// end phmphuc add 12/11/2010

	// vu update 26122010

	public int countBy_isPublic_mainDepartmentProcessId_Date(String isPublic,
			String mainDepartmentProcessId, String tuNgay, String denNgay,
			String listUserId) throws SystemException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");

		String fromDate = "";
		String endDate = "";

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		int year = calendar.get(Calendar.YEAR);

		try {
			if ("".endsWith(tuNgay)) {
				tuNgay = "01/01/" + year;
			}
			if ("".equals(denNgay)) {
				denNgay = "31/12/" + year;
			}

			fromDate = sdf.format(df.parse(tuNgay));
			endDate = sdf.format(df.parse(denNgay));
		} catch (Exception e) {
			e.printStackTrace();
		}

		Session session = null;
		try {
			session = openSession();
			String sql = "SELECT COUNT(*) AS COUNT_VALUE FROM pml_edm_documentreceipt  WHERE ispublic = '"
					+ 0 + "'";
			sql += "AND maindepartmentprocessid LIKE '"
					+ mainDepartmentProcessId.trim() + "' ";
			sql += "AND mainuserprocessid in (" + listUserId + ") ";
			sql += "AND ( '" + fromDate + "' <= datearrive AND datearrive <= '"
					+ endDate + "')";

			SQLQuery q = session.createSQLQuery(sql);
			q.addScalar(COUNT_COLUMN_NAME, Type.LONG);

			Iterator<Long> it = q.list().iterator();
			if (it.hasNext()) {
				Long count = it.next();
				if (count != null) {
					return count.intValue();
				}
			}
			return 0;

		} catch (Exception e) {
			throw new SystemException();
		}

	}

	public List<PmlEdmDocumentReceipt> findBy_isPublic_mainDepartmentProcessId_Date(
			String isPublic, String mainDepartmentProcessId, String tuNgay,
			String denNgay, String listUserId, int start, int end,
			OrderByComparator order) throws SystemException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		String fromDate = "";
		String toDate = "";

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		int year = calendar.get(Calendar.YEAR);

		try {
			if ("".equalsIgnoreCase(tuNgay)) {
				tuNgay = "01/01/" + year;
			}
			if ("".equalsIgnoreCase(denNgay)) {
				denNgay = "31/12/" + year;
			}

			fromDate = sdf.format(df.parse(tuNgay));
			toDate = sdf.format(df.parse(denNgay));
		} catch (ParseException e) {
			e.printStackTrace();
		}

		Session session = null;
		try {
			session = openSession();
			String sql = "SELECT * FROM pml_edm_documentreceipt WHERE ispublic LIKE '"
					+ 0 + "'";

			sql += "AND maindepartmentprocessid LIKE '"
					+ mainDepartmentProcessId.trim() + "' ";
			sql += "AND mainuserprocessid in (" + listUserId + ") ";

			sql += " AND('" + fromDate
					+ "' <= datearrive  AND  datearrive <= '" + toDate + "')";
			sql = CustomSQLUtil.replaceOrderBy(sql, order);
			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("pml_edm_documentreceipt",
					PmlEdmDocumentReceiptImpl.class);
			return (List<PmlEdmDocumentReceipt>) QueryUtil.list(q,
					getDialect(), start, end);

		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}

	} // end update Vu

	// phmphuc add 05/01/2011 - ham kiem tra so den theo so theo nam co ton tai
	// trong csdl chua
	public int countByNumberDocumentReceipt(String numberDocumentReceipt,
			int issuingYear, long documentReceiptId) throws SystemException {

		Session session = null;
		try {
			session = openSession();

			String sql = "SELECT COUNT(cvden.*) AS COUNT_VALUE";
			sql += " FROM pml_edm_documentreceipt cvden WHERE";
			if (documentReceiptId != 0) {
				sql += " documentreceiptid != " + documentReceiptId + " AND";
			}
			sql += " cvden.numberdocumentreceipt = '" + numberDocumentReceipt
					+ "' ";
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

	// ham kiem tra so hieu trung cho edit
	public int countByDocumentReference(String documentReference,
			int issuingYear, long documentReceiptId) throws SystemException {

		Session session = null;
		try {
			session = openSession();

			String sql = "SELECT COUNT(*) AS COUNT_VALUE FROM pml_edm_documentreceipt";
			sql += " WHERE documentreceiptid != " + documentReceiptId;
			sql += " AND documentreference = '" + documentReference + "' ";
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

	// TriLTM

	public List<PmlEdmDocumentReceipt> findBy_R_B_F_T(String documentReference,
			String briefContent, Date fromDate, Date toDate,
			boolean andOperator, int start, int end, OrderByComparator obc)
			throws SystemException {

		return findBy_R_B_F_T(new String[] { documentReference },
				new String[] { briefContent }, fromDate, toDate, andOperator,
				start, end, obc);
	}

	private List<PmlEdmDocumentReceipt> findBy_R_B_F_T(
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
				sql = StringUtil.replace(sql, "(datearrive >= ?) AND",
						StringPool.BLANK);
			}

			if (Validator.isNull(toDate)) {
				sql = StringUtil.replace(sql, "(datearrive <= ?) AND",
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

			q.addEntity("pml_edm_documentreceipt",
					PmlEdmDocumentReceiptImpl.class);

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

			return (List<PmlEdmDocumentReceipt>) QueryUtil.list(q,
					getDialect(), start, end);

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
				sql = StringUtil.replace(sql, "(datearrive >= ?) AND",
						StringPool.BLANK);
			}

			if (Validator.isNull(toDate)) {
				sql = StringUtil.replace(sql, "(datearrive <= ?) AND",
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
}
