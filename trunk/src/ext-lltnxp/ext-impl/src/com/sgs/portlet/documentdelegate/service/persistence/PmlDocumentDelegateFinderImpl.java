/**
 * 
 */
package com.sgs.portlet.documentdelegate.service.persistence;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.Type;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;
import com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt;
import com.sgs.portlet.document.receipt.model.impl.PmlEdmDocumentReceiptImpl;
import com.sgs.portlet.document.send.model.PmlEdmDocumentSend;
import com.sgs.portlet.document.send.model.impl.PmlEdmDocumentSendImpl;
import com.sgs.portlet.documentdelegate.model.PmlDocumentDelegate;
import com.sgs.portlet.documentdelegate.model.impl.PmlDocumentDelegateImpl;
import com.sgs.portlet.pmluser.model.PmlUser;
import com.sgs.portlet.pmluser.model.impl.PmlUserImpl;

/**
 * @author WIN7
 *
 */
@SuppressWarnings("unchecked")
public class PmlDocumentDelegateFinderImpl extends BasePersistenceImpl implements  PmlDocumentDelegateFinder{
	public static String COUNT_SD_TD_USERISDELEGATE = PmlDocumentDelegateFinder.class.getName() + ".countBy_SD_TD_USERISDELEGATE";
	public static String FIND_SD_TD_USERISDELEGATE = PmlDocumentDelegateFinder.class.getName()+ ".findBy_SD_TD_USERISDELEGATE";
	
	public static String FIND_ALLUSERISDELEGATE = PmlDocumentDelegateFinder.class.getName()+ ".findByALLUSERISDELEGATE";

	public List<PmlDocumentDelegate> findBy_ALLUSERISDELEGATE(int start, int end, OrderByComparator obc) throws SystemException {
		Session session = null;
		try {
			session = openSession();
			
			String sql = CustomSQLUtil.get(FIND_ALLUSERISDELEGATE);
			sql = CustomSQLUtil.replaceOrderBy(sql, obc);
			SQLQuery q = session.createSQLQuery(sql);
			
			q.addEntity("pml_edm_documentdelegate", PmlDocumentDelegateImpl.class);
			
			return (List<PmlDocumentDelegate>) QueryUtil.list(q, getDialect(), start, end);
		} catch (Exception e) {
			throw new SystemException(e);
		}
		finally{
			closeSession(session);
		}
	}
	
	public int countBy_SD_TD_USERISDELEGATE(long userDelegate, 
			String fromDateDelegate, String toDateDelegate, String listUserIsDelegate
			) throws SystemException {
		
//		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
//		Date fromDate = new Date();
//		Date toDate = new Date();
//		if (!"".equals(fromDateDelegate) && null != fromDateDelegate) {
//			try {
//				fromDate =dateFormat.parse(fromDateDelegate);
//			} catch (ParseException e) {
//				e.printStackTrace();
//			}
//		}
//		
//		if (!"".equals(toDateDelegate) && null != toDateDelegate) {
//			try {
//				toDate =dateFormat.parse(toDateDelegate);
//			} catch (ParseException e) {
//				e.printStackTrace();
//			}
//		}
		
//		Timestamp fromDateStamp = new Timestamp(fromDate.getTime());
//		Timestamp toDateStamp = new Timestamp(toDate.getTime());
		
		
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(COUNT_SD_TD_USERISDELEGATE);
			
			SQLQuery q = session.createSQLQuery(sql);
			q.addScalar(COUNT_COLUMN_NAME, Type.LONG);
			
			QueryPos qpos = QueryPos.getInstance(q);
			qpos.add(userDelegate);
			
			Iterator<Long> iter = q.list().iterator();
			if(iter.hasNext()){
				Long count = iter.next();
				if(count!= null){
					return count.intValue();
				}
			}
			return 0;
		} catch (Exception e) {
			throw new SystemException(e);
		}
		finally{
			closeSession(session);
		}
	}
	
	
	public List<PmlDocumentDelegate> findBy_SD_TD_USERISDELEGATE(long userDelegate, 
			String fromDateDelegate, String toDateDelegate, String listUserIsDelegate, int start, int end
			, OrderByComparator obc) throws SystemException {
//		
//		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
//		Date fromDate = new Date();
//		Date toDate = new Date();
//		if (!"".equals(fromDateDelegate) && null != fromDateDelegate) {
//			try {
//				fromDate =dateFormat.parse(fromDateDelegate);
//			} catch (ParseException e) {
//				e.printStackTrace();
//			}
//		}
//		
//		if (!"".equals(toDateDelegate) && null != toDateDelegate) {
//			try {
//				toDate =dateFormat.parse(toDateDelegate);
//			} catch (ParseException e) {
//				e.printStackTrace();
//			}
//		}
		
//		Timestamp fromDateStamp = new Timestamp(fromDate.getTime());
//		Timestamp toDateStamp = new Timestamp(toDate.getTime());
		
		
		Session session = null;
		try {
			session = openSession();
			
			String sql = CustomSQLUtil.get(FIND_SD_TD_USERISDELEGATE);
			sql = CustomSQLUtil.replaceOrderBy(sql, obc);
			SQLQuery q = session.createSQLQuery(sql);
			
			q.addEntity("pml_edm_documentdelegate", PmlDocumentDelegateImpl.class);
			
			QueryPos qpos = QueryPos.getInstance(q);
			qpos.add(userDelegate);
//			qpos.add(fromDateStamp);
//			qpos.add(toDateStamp);
			
			return (List<PmlDocumentDelegate>) QueryUtil.list(q, getDialect(), start, end);
		} catch (Exception e) {
			throw new SystemException(e);
		}
		finally{
			closeSession(session);
		}
	}
	
	// lay danh sach nguoi uy quyen - chuyen vien lay danh sach lanh dao uy quyen
	public List<PmlUser> getDanhSachNguoiUyQuyen(long userIsDelegateId, int start, int end, OrderByComparator obc) throws SystemException {
		Session session = null;
		
		try {
			session = openSession();
			
			String sql = "select distinct(us.*) from pml_user us, pml_edm_documentdelegate delegate";
			sql += " where us.userid = delegate.userdelegateid";
			sql += " and delegate.userisdelegateid = " + userIsDelegateId;
			sql += " order by us.firstname asc, us.lastname asc, us.middlename asc";
			
			sql = CustomSQLUtil.replaceOrderBy(sql, obc);
			
			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("pml_user", PmlUserImpl.class);

			return (List<PmlUser>) QueryUtil.list(q, getDialect(), start, end);
		} catch (Exception e) {
			throw processException(e);
		} finally {
			closeSession(session);
		}
	}
	
	public int countDanhSachNguoiUyQuyen(long userIsDelegateId) throws SystemException {
		Session session = null;
		try {
			session = openSession();
			
			String sql = "SELECT COUNT(distinct(userdelegateid)) AS COUNT_VALUE";
			sql += " FROM pml_edm_documentdelegate";
			sql += " WHERE userisdelegateid = " + userIsDelegateId;
			
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
	
	// lay danh sach nguoi duoc uy quyen - lanh dao lay danh sach chuyen vien duoc uy quyen
	public List<PmlUser> getDanhSachNguoiDuocUyQuyen(long userDelegateId, int start, int end, OrderByComparator obc) throws SystemException {
		Session session = null;
		
		try {
			session = openSession();

			String sql = "select distinct(us.*) from pml_user us, pml_edm_documentdelegate delegate";
			sql += " where us.userid = delegate.userisdelegateid";
			sql += " and delegate.userdelegateid = " + userDelegateId;
			sql += " order by us.firstname asc, us.lastname asc, us.middlename asc";
			
			sql = CustomSQLUtil.replaceOrderBy(sql, obc);
			
			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("pml_user", PmlUserImpl.class);

			return (List<PmlUser>) QueryUtil.list(q, getDialect(), start, end);
		} catch (Exception e) {
			throw processException(e);
		} finally {
			closeSession(session);
		}
	}
	
	public int countDanhSachNguoiDuocUyQuyen(long userDelegateId) throws SystemException {
		Session session = null;
		try {
			session = openSession();
			
			String sql = "SELECT COUNT(distinct(userdelegateid)) AS COUNT_VALUE";
			sql += " FROM pml_edm_documentdelegate";
			sql += " WHERE userdelegateid = " + userDelegateId;
			
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
	
	// dem so luong van ban den duoc xu ly thay
	public int countNumOfDocumentReceiptIsDelegated(long userDelegateId, long userIsDelegateId, Date fromDate, Date toDate) throws SystemException {
		Session session = null;
		try {
			session = openSession();
			
			String ngaybatdau = new SimpleDateFormat("yyyy-MM-dd").format(fromDate);
			String ngayketthuc = new SimpleDateFormat("yyyy-MM-dd").format(toDate);
			
			String sql = "SELECT COUNT(DISTINCT(documentreceiptid)) AS COUNT_VALUE";
			sql += " FROM pml_documentreceipt_log";
			sql += " WHERE dateprocess is not null and dateprocess >= '" + ngaybatdau + "' AND dateprocess <= '" + ngayketthuc + "'";
			sql += " AND processer = " + userDelegateId + " AND directprocesserid = " + userIsDelegateId;
			
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
	
	public List<PmlEdmDocumentReceipt> getNumOfDocumentReceiptIsDelegated(long userDelegateId, long userIsDelegateId, Date fromDate, 
						Date toDate, int start, int end, OrderByComparator obc) throws SystemException {
		Session session = null;
		try {
			session = openSession();
			
			String ngaybatdau = new SimpleDateFormat("yyyy-MM-dd").format(fromDate);
			String ngayketthuc = new SimpleDateFormat("yyyy-MM-dd").format(toDate);
			
			String sql = "select receipt.*";
			sql += " from pml_edm_documentreceipt receipt, pml_documentreceipt_log log,";
			sql += " (SELECT MAX(transition_) AS maxtran, documentreceiptid" +
				   " FROM pml_documentreceipt_log WHERE processer = " + userDelegateId + " GROUP BY documentreceiptid) as a";
			sql += " WHERE log.documentreceiptid = receipt.documentreceiptid";
			sql += " AND receipt.documentreceiptid = a.documentreceiptid AND log.transition_ = a.maxtran";
			sql += " AND log.dateprocess is not null AND log.dateprocess >= '" + ngaybatdau + "' AND log.dateprocess <= '" + ngayketthuc + "'";
			sql += " AND log.directprocesserid = " + userIsDelegateId;
			sql += " ORDER BY receipt.generalorderno ASC";
			
			sql = CustomSQLUtil.replaceOrderBy(sql, obc);
			
			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("pml_edm_documentreceipt", PmlEdmDocumentReceiptImpl.class);
			
			return (List<PmlEdmDocumentReceipt>) QueryUtil.list(q, getDialect(), start, end);
		} catch (Exception e) {
			throw processException(e);
		} finally {
			closeSession(session);
		}
	}
	
	// dem so luong van ban di duoc xu ly thay
	public int countNumOfDocumentSendIsDelegated(long userDelegateId, long userIsDelegateId, Date fromDate, Date toDate) throws SystemException {
		Session session = null;
		try {
			session = openSession();
			
			String ngaybatdau = new SimpleDateFormat("yyyy-MM-dd").format(fromDate);
			String ngayketthuc = new SimpleDateFormat("yyyy-MM-dd").format(toDate);
			
			String sql = "SELECT COUNT(DISTINCT(documentsendid)) AS COUNT_VALUE";
			sql += " FROM pml_documentsend_log";
			sql += " WHERE dateprocess is not null AND dateprocess >= '" + ngaybatdau + "' AND dateprocess <= '" + ngayketthuc + "'";
			sql += " AND processer = " + userDelegateId + " AND directprocesserid = " + userIsDelegateId;
			
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
	
	public List<PmlEdmDocumentSend> getNumOfDocumentSendIsDelegated(long userDelegateId, long userIsDelegateId, Date fromDate, Date toDate,
			int start, int end, OrderByComparator obc) throws SystemException {
		Session session = null;
		try {
			session = openSession();
			
			String ngaybatdau = new SimpleDateFormat("yyyy-MM-dd").format(fromDate);
			String ngayketthuc = new SimpleDateFormat("yyyy-MM-dd").format(toDate);
			
			String sql = "SELECT send.*";
			sql += " FROM pml_edm_documentsend send, pml_documentsend_log log,";
			sql += " (SELECT MAX(transition_) AS maxtran, documentsendid" +
				   " FROM pml_documentsend_log WHERE processer = " + userDelegateId + " GROUP BY documentsendid) as a";
			sql += " WHERE log.documentsendid = send.documentsendid";
			sql += " AND send.documentsendid = a.documentsendid AND log.transition_ = a.maxtran";
			sql += " AND log.dateprocess is not null AND log.dateprocess >= '" + ngaybatdau + "' AND log.dateprocess <= '" + ngayketthuc + "'";
			sql += " AND log.directprocesserid = " + userIsDelegateId;
			sql += " ORDER BY send.numofdocref ASC";
			
			sql = CustomSQLUtil.replaceOrderBy(sql, obc);
			
			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("pml_edm_documentsend", PmlEdmDocumentSendImpl.class);
			
			return (List<PmlEdmDocumentSend>) QueryUtil.list(q, getDialect(), start, end);
		} catch (Exception e) {
			throw processException(e);
		} finally {
			closeSession(session);
		}
	}
}
