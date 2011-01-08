package com.sgs.portlet.pml_ho_so_cong_viec.service.persistence;

import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.Type;
//import com.liferay.portal.kernel.util.CalendarUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
//import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
//import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
//import com.ext.portlet.odmodule.service.persistence.ODTypeFinder;
import com.sgs.portlet.pml_ho_so_cong_viec.model.PmlChiTietHSCV;
import com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec;
import com.sgs.portlet.pml_ho_so_cong_viec.model.impl.PmlHoSoCongViecImpl;
import com.sgs.portlet.pml_ho_so_cong_viec.model.impl.PmlChiTietHSCVImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;
import com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt;
import com.sgs.portlet.document.receipt.model.impl.PmlEdmDocumentReceiptImpl;
import com.sgs.portlet.document.send.model.PmlEdmDocumentSend;
import com.sgs.portlet.document.send.model.impl.PmlEdmDocumentSendImpl;

import com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile;
import com.sgs.portlet.document.receipt.model.impl.PmlEdmAttachedFileImpl;
import com.sgs.portlet.document.send.model.PmlEdmWriteDocumentSend;
import com.sgs.portlet.document.send.model.impl.PmlEdmWriteDocumentSendImpl;

//import java.sql.Timestamp;

//import java.util.Date;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * <a href="PmlChiTietHSCVFinderImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Hai Trieu
 *
 */
public class PmlChiTietHSCVFinderImpl 
	extends BasePersistenceImpl implements PmlChiTietHSCVFinder { 
	public static String COUNT_BY_CVDEN =
		PmlChiTietHSCVFinder.class.getName() + ".countByCVDen";

	public static String FIND_BY_CVDEN =
		PmlChiTietHSCVFinder.class.getName() + ".findByCVDen";
	
	public static String COUNT_BY_CVDI =
		PmlChiTietHSCVFinder.class.getName() + ".countByCVDi";

	public static String FIND_BY_CVDI =
		PmlChiTietHSCVFinder.class.getName() + ".findByCVDi";

	// Ham tim kiem khoa ngoai trong ban pml_ho_so_cong_viec
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
	
	// Ham tim kiem cong van den thuoc ho so cong viec
	public List<PmlEdmDocumentReceipt> findByCVDen(long idHoSoCongViec, int start, int end, OrderByComparator obc)
		throws SystemException {

		Session session = null;

		try {
			session = openSession();

			String sql = CustomSQLUtil.get(FIND_BY_CVDEN);

			sql = CustomSQLUtil.replaceOrderBy(sql, obc);

			SQLQuery q = session.createSQLQuery(sql);

			q.addEntity("pml_edm_documentreceipt", PmlEdmDocumentReceiptImpl.class);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(idHoSoCongViec);

			return (List<PmlEdmDocumentReceipt>)QueryUtil.list(
				q, getDialect(), start, end);
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
		finally {
			closeSession(session);
		}
	}
	// Ham tim kiem cong van di thuoc ho so cong viec
	public List<PmlEdmDocumentSend> findByCVDi(long idHoSoCongViec, int start, int end, OrderByComparator obc)
		throws SystemException {

		Session session = null;

		try {
			session = openSession();

			String sql = CustomSQLUtil.get(FIND_BY_CVDI);

			sql = CustomSQLUtil.replaceOrderBy(sql, obc);

			SQLQuery q = session.createSQLQuery(sql);

			q.addEntity("pml_edm_documentsend", PmlEdmDocumentSendImpl.class);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(idHoSoCongViec);

			return (List<PmlEdmDocumentSend>)QueryUtil.list(
				q, getDialect(), start, end);
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
		finally {
			closeSession(session);
		}
	}
	// ham tim file dinh kem cua cong van
	// 1 cong van den co nhieu file dinh kem	
	public List<PmlEdmAttachedFile> findBy_F_ATT_CVDEN(long[] documentreceiptids)
		throws SystemException {

		Session session = null;

		try {
			session = openSession();
	
			StringBuilder queryCount = new StringBuilder();
			queryCount.append(" SELECT COUNT(*) AS COUNT_VALUE ");
			StringBuilder queryFind = new StringBuilder();
			queryFind.append(" SELECT att.* ");
			StringBuilder queryAfter = new StringBuilder();
	
			queryAfter.append(" FROM pml_edm_documentreceipt doc inner join pml_edm_attachedfile att ");
			queryAfter.append(" on doc.documentreceiptid = att.objectcontentid ");
			queryAfter.append(" WHERE 1 = 0 ");
	
			if ((documentreceiptids != null) && (documentreceiptids.length > 0)) {
	
				for (int i = 0; i < documentreceiptids.length; i++) {

					if (documentreceiptids.length == 1)
//queryAfter.append(documentreceiptids[i]);
						queryAfter.append(" AND att.objectcontentid = ?");
					else
					{
						queryAfter.append(" OR att.objectcontentid = ? ");
					}	
				}
	
				queryAfter.append(" ");
			}
	
			SQLQuery qCount = session.createSQLQuery(queryCount.toString() + queryAfter.toString());
			int count = 0;

			qCount.addScalar(COUNT_COLUMN_NAME, Type.LONG);
			
			QueryPos qPos = QueryPos.getInstance(qCount);
if ((documentreceiptids != null) && (documentreceiptids.length > 0)) {
				
				for (int i = 0; i < documentreceiptids.length; i++) {
						qPos.add(documentreceiptids[i]);
				}
			}
	
			Iterator<Long> itr = qCount.list().iterator();
	
			if (itr.hasNext()) {
				Long countLong = itr.next();
				if (countLong != null) {
					count = countLong.intValue();
				}
			}
			
			SQLQuery qFind = session.createSQLQuery(queryFind.toString() + queryAfter.toString());
	
			qFind.addEntity("pml_edm_attachedfile", PmlEdmAttachedFileImpl.class);
	
			qPos = QueryPos.getInstance(qFind);
if ((documentreceiptids != null) && (documentreceiptids.length > 0)) {
				for (int i = 0; i < documentreceiptids.length; i++) {
						qPos.add(documentreceiptids[i]);
				}
			}

			return (List<PmlEdmAttachedFile>)QueryUtil.list(
					qFind, getDialect(), 0, count);
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
		finally {
			closeSession(session);
		}
	}

	// ham tim file dinh kem cua cong van
	// 1 cong van di co nhieu file dinh kem	
	public List<PmlEdmAttachedFile> findBy_F_ATT_CVDI(long[] documentreceiptids)
		throws SystemException {

		Session session = null;

		try {
			session = openSession();
	
			StringBuilder queryCount = new StringBuilder();
			queryCount.append(" SELECT COUNT(*) AS COUNT_VALUE ");
			StringBuilder queryFind = new StringBuilder();
			queryFind.append(" SELECT att.* ");
			StringBuilder queryAfter = new StringBuilder();
	
			queryAfter.append(" FROM pml_edm_documentsend doc inner join pml_edm_attachedfile att ");
			queryAfter.append(" on doc.documentsendid = att.objectcontentid ");
			queryAfter.append(" WHERE 1 = 0 ");
	
			if ((documentreceiptids != null) && (documentreceiptids.length > 0)) {
	
				for (int i = 0; i < documentreceiptids.length; i++) {

if (documentreceiptids.length == 1) {
						queryAfter.append(" AND att.objectcontentid = ?");
					}
					else {						
						queryAfter.append(" OR att.objectcontentid = ? ");
					}	
				}
	
				queryAfter.append(" ");
			}
	
			SQLQuery qCount = session.createSQLQuery(queryCount.toString() + queryAfter.toString());
			int count = 0;

			qCount.addScalar(COUNT_COLUMN_NAME, Type.LONG);
			
			QueryPos qPos = QueryPos.getInstance(qCount);
if ((documentreceiptids != null) && (documentreceiptids.length > 0)) {
				
				for (int i = 0; i < documentreceiptids.length; i++) {
					
						qPos.add(documentreceiptids[i]);
				}
			}
	
			Iterator<Long> itr = qCount.list().iterator();
	
			if (itr.hasNext()) {
				Long countLong = itr.next();
				if (countLong != null) {
					count = countLong.intValue();
				}
			}
			
			SQLQuery qFind = session.createSQLQuery(queryFind.toString() + queryAfter.toString());
	
			qFind.addEntity("pml_edm_attachedfile", PmlEdmAttachedFileImpl.class);
	
			qPos = QueryPos.getInstance(qFind);

if ((documentreceiptids != null) && (documentreceiptids.length > 0)) {

				for (int i = 0; i < documentreceiptids.length; i++) {

					qPos.add(documentreceiptids[i]);
				}
			}
			return (List<PmlEdmAttachedFile>)QueryUtil.list(
					qFind, getDialect(), 0, count);
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
		finally {
			closeSession(session);
		}
	}
	// dem so luong cong van den cua ho so chi tiet cong viec
	public int countByCVDen(long idHoSoCongViec, boolean andOperator)
	throws SystemException {

	Session session = null;

		try {
			session = openSession();

			String sql = CustomSQLUtil.get(COUNT_BY_CVDEN);

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME, Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(idHoSoCongViec);	
	
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
	// dem so luong cong van di cua ho so chi tiet cong viec
	public int countByCVDi(long idHoSoCongViec, boolean andOperator)
	throws SystemException {

	Session session = null;

		try {
			session = openSession();

			String sql = CustomSQLUtil.get(COUNT_BY_CVDI);

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME, Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(idHoSoCongViec);	
	
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
// ham tim Ngay tao cua van ban di
	public List<PmlEdmWriteDocumentSend> findBy_CreateDateDocSend(long[] documentSendIds)
		throws SystemException {

		Session session = null;

		try {
			session = openSession();
	
			StringBuilder queryCount = new StringBuilder();
			queryCount.append(" SELECT COUNT(*) AS COUNT_VALUE ");
			StringBuilder queryFind = new StringBuilder();
			queryFind.append(" SELECT docSend.* ");
			StringBuilder queryAfter = new StringBuilder();
	
			queryAfter.append(" FROM pml_edm_documentsend doc inner join pml_edm_writedocumentsend docSend ");
			queryAfter.append(" on doc.documentsendid = docSend.documentsendid ");
			queryAfter.append(" WHERE 1 = 0 ");
	
			if ((documentSendIds != null) && (documentSendIds.length > 0)) {
	
				for (int i = 0; i < documentSendIds.length; i++) {

					if (documentSendIds.length == 1) {
						queryAfter.append(" AND docSend.documentsendid = ?");
					}
					else {						
						queryAfter.append(" OR docSend.documentsendid = ? ");
					}	
				}
	
				queryAfter.append(" ");
			}
	
			SQLQuery qCount = session.createSQLQuery(queryCount.toString() + queryAfter.toString());
			int count = 0;

			qCount.addScalar(COUNT_COLUMN_NAME, Type.LONG);
			
			QueryPos qPos = QueryPos.getInstance(qCount);
			if ((documentSendIds != null) && (documentSendIds.length > 0)) {
				
				for (int i = 0; i < documentSendIds.length; i++) {
					
						qPos.add(documentSendIds[i]);
				}
			}
	
			Iterator<Long> itr = qCount.list().iterator();
	
			if (itr.hasNext()) {
				Long countLong = itr.next();
				if (countLong != null) {
					count = countLong.intValue();
				}
			}
			
			SQLQuery qFind = session.createSQLQuery(queryFind.toString() + queryAfter.toString());
	
			qFind.addEntity("pml_edm_writedocumentsend", PmlEdmWriteDocumentSendImpl.class);
	
			qPos = QueryPos.getInstance(qFind);

			if ((documentSendIds != null) && (documentSendIds.length > 0)) {

				for (int i = 0; i < documentSendIds.length; i++) {

					qPos.add(documentSendIds[i]);
				}
			}
			return (List<PmlEdmWriteDocumentSend>)QueryUtil.list(
					qFind, getDialect(), 0, count);
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
		finally {
			closeSession(session);
		}
	}
}