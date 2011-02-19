package com.sgs.portlet.document.receipt.service.persistence;

import java.util.Iterator;
import java.util.List;

import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.Type;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;
import com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo;
import com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordType;
import com.sgs.portlet.document.receipt.model.impl.PmlEdmDocumentRecordToImpl;
import com.sgs.portlet.document.receipt.model.impl.PmlEdmDocumentRecordTypeImpl;

public class PmlEdmDocumentRecordTypeFinderImpl extends BasePersistenceImpl implements PmlEdmDocumentRecordTypeFinder{
	// minh 20100206
	public static String COUNT_BY_PMLEDMDOCUMENTRECORDTYPE = PmlEdmDocumentRecordTypeFinder.class.getName() + ".countByPmlEdmDocumentRecordType";
	public static String FIND_BY_PMLEDMDOCUMENTRECORDTYPE = PmlEdmDocumentRecordTypeFinder.class.getName()+ ".findByPmlEdmDocumentRecordType";
	
	
	public int countByKeywords(String keywords) throws SystemException{
		String[] pmlEdmDocumentRecordTypeCodes = null;
		String[] pmlEdmDocumentRecordTypeNames = null;
		boolean andOperator = false;
		if(Validator.isNotNull(keywords)){
			pmlEdmDocumentRecordTypeCodes = CustomSQLUtil.keywords(keywords, true);
			pmlEdmDocumentRecordTypeNames = CustomSQLUtil.keywords(keywords, true);
		}else{
			andOperator = true;
		}
		
		return countByPmlEdmDocumentRecordType(pmlEdmDocumentRecordTypeCodes, pmlEdmDocumentRecordTypeNames, andOperator);
	}
	
	public int countByPmlEdmDocumentRecordType(String pmlEdmDocumentRecordTypeCode, String pmlEdmDocumentRecordTypeName, boolean andOperator) throws SystemException{
		return countByPmlEdmDocumentRecordType(new String[]{pmlEdmDocumentRecordTypeCode}, new String[]{pmlEdmDocumentRecordTypeName}, andOperator);
	}
	
	public int countByPmlEdmDocumentRecordType(String[] pmlEdmDocumentRecordTypeCodes,
			String[] pmlEdmDocumentRecordTypeNames,
			boolean andOperator) throws SystemException {
		pmlEdmDocumentRecordTypeCodes = CustomSQLUtil.keywords(pmlEdmDocumentRecordTypeCodes, true);
		pmlEdmDocumentRecordTypeNames = CustomSQLUtil.keywords(pmlEdmDocumentRecordTypeNames, true);
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(COUNT_BY_PMLEDMDOCUMENTRECORDTYPE);
			
			sql = CustomSQLUtil.replaceKeywords(sql, "lower(documentrecordtypecode)", StringPool.LIKE, true, pmlEdmDocumentRecordTypeCodes);
			sql = CustomSQLUtil.replaceKeywords(sql, "lower(documentrecordtypename)", StringPool.LIKE, true, pmlEdmDocumentRecordTypeNames);
			sql = CustomSQLUtil.replaceAndOperator(sql, andOperator);
			
			SQLQuery q = session.createSQLQuery(sql);
			q.addScalar(COUNT_COLUMN_NAME, Type.LONG);			
			QueryPos qpos = QueryPos.getInstance(q);
			qpos.add(pmlEdmDocumentRecordTypeCodes, 2);
			qpos.add(pmlEdmDocumentRecordTypeNames, 2);
			
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
	
	public List<PmlEdmDocumentRecordType> findByKeywords(String keywords, int start, int end, OrderByComparator obc) throws SystemException{
		String[] pmlEdmDocumentRecordTypeCodes = null;
		String[] pmlEdmDocumentRecordTypeNames = null;
		boolean andOperator = false;
		if(Validator.isNotNull(keywords)){
			pmlEdmDocumentRecordTypeCodes = CustomSQLUtil.keywords(keywords, true);
			pmlEdmDocumentRecordTypeNames = CustomSQLUtil.keywords(keywords, true);
		}else{
			andOperator = true;
		}
		
		return findByPmlEdmDocumentRecordType(pmlEdmDocumentRecordTypeCodes, pmlEdmDocumentRecordTypeNames, andOperator, start, end, obc);
	}

	public List<PmlEdmDocumentRecordType> findByPmlEdmDocumentRecordType(String pmlEdmDocumentRecordTypeCode, String pmlEdmDocumentRecordTypeName, boolean andOperator, int start, int end, OrderByComparator obc) throws SystemException{
		return findByPmlEdmDocumentRecordType(new String[]{pmlEdmDocumentRecordTypeCode}, new String[]{pmlEdmDocumentRecordTypeName}, andOperator, start, end, obc);
	}
	
	public List<PmlEdmDocumentRecordType> findByPmlEdmDocumentRecordType(String[] pmlEdmDocumentRecordTypeCodes,
			String[] pmlEdmDocumentRecordTypeNames, 
			boolean andOperator, int start, int end,
			OrderByComparator obc) throws SystemException {
		
		pmlEdmDocumentRecordTypeCodes = CustomSQLUtil.keywords(pmlEdmDocumentRecordTypeCodes, true);
		pmlEdmDocumentRecordTypeNames = CustomSQLUtil.keywords(pmlEdmDocumentRecordTypeNames, true);
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(FIND_BY_PMLEDMDOCUMENTRECORDTYPE);
			
			sql = CustomSQLUtil.replaceKeywords(sql, "lower(documentrecordtypecode)", StringPool.LIKE, true, pmlEdmDocumentRecordTypeCodes);
			sql = CustomSQLUtil.replaceKeywords(sql, "lower(documentrecordtypename)", StringPool.LIKE, true, pmlEdmDocumentRecordTypeNames);
			sql = CustomSQLUtil.replaceAndOperator(sql, andOperator);
			sql = CustomSQLUtil.replaceOrderBy(sql, obc);
			
			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("pml_edm_documentrecordtype", PmlEdmDocumentRecordTypeImpl.class);
			
			QueryPos qpos = QueryPos.getInstance(q);
			qpos.add(pmlEdmDocumentRecordTypeCodes,2);
			qpos.add(pmlEdmDocumentRecordTypeNames,2);
			
			return (List<PmlEdmDocumentRecordType>) QueryUtil.list(q, getDialect(), start, end);
		} catch (Exception e) {
			throw new SystemException(e);
		}
		finally{
			closeSession(session);
		}
	}
	// end
	
	// vu update 25122010
	public List<PmlEdmDocumentRecordType> findByDocumentRecordTypeCode(String documentRecordTypeCode) throws SystemException{ 
		Session session = null;
		documentRecordTypeCode = documentRecordTypeCode.toLowerCase();
		try {
			session = openSession();
			String sql = "SELECT * FROM pml_edm_documentrecordtype WHERE lower(documentrecordtypecode) LIKE ?";
			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("PmlEdmDocumentRecordType", PmlEdmDocumentRecordTypeImpl.class);
			QueryPos qPos = QueryPos.getInstance(q);
			qPos.add(documentRecordTypeCode);
			
			return (List<PmlEdmDocumentRecordType>) QueryUtil.list(q,
						getDialect(), QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		} catch (Exception e) {
			throw new SystemException(e);
		}finally{
			closeSession(session);
		}
	}
	//end
	
	// phmphuc add 13/01/2011 - lay nhung loai so vb duoc tao so vb cho co quan trong nam hien tai
	public List<PmlEdmDocumentRecordType> getDocumentRecordTypeUseForAgency(String flag, String agencyId, int currentYear) throws Exception {
		Session session = null;
		try {
			session = openSession();

			String sql = "select retype.* from pml_edm_documentrecordtype retype";
			// cho so vb den
			if (flag.equals("vbden")) {
				sql += " inner join pml_edm_documentrecordto reto";
				sql += " on retype.documentrecordtypeid = reto.documentrecordtypeid";
				sql += " and reto.agencyid = '" + agencyId + "'";
				sql += " and reto.yearinuse = '" + currentYear + "'";
			}
			else if (flag.equals("vbdi")) {
				sql += " inner join pml_edm_bookdocumentsend book";
				sql += " on retype.documentrecordtypeid = book.documentrecordtypeid";
				sql += " and book.agencyid = '" + agencyId + "'";
				sql += " and book.yearinuse = '" + currentYear + "'";
			} 
			// cho so vb di
			sql += " order by retype.documentrecordtypename ASC";

			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("PmlEdmDocumentRecordType", PmlEdmDocumentRecordTypeImpl.class);

			return (List<PmlEdmDocumentRecordType>) QueryUtil.list(q, getDialect(), -1, -1);
		} catch (Exception e) {
			throw processException(e);
		} finally {
			closeSession(session);
		}
	}
	// end phmphuc add 13/01/2011
	
	// vu update 20110210 kiem tra so van ban da duoc tao hay chua
	public List<PmlEdmDocumentRecordTo> findByDocumentRecordTypeId_Year(int documentRecordTypeId, String year) throws SystemException{ 
		Session session = null;
		try {
			session = openSession();
			String sql = "SELECT * FROM pml_edm_documentrecordto";
			sql += "pml_edm_documentrecordto.documentrecordtypeid = '" + documentRecordTypeId + "' ";
			sql += " AND pml_edm_documentrecordto.yearinuse = '" + year + "' ";
			
			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("PmlEdmDocumentRecordTo", PmlEdmDocumentRecordToImpl.class);
			
			return (List<PmlEdmDocumentRecordTo>) QueryUtil.list(q, getDialect(), QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		} catch (Exception e) {
			throw new SystemException(e);
		}finally{
			closeSession(session);
		}
	}
	
	// end vu update 20110210
	
	// minh update 20110215
	public List<PmlEdmDocumentRecordType> getDocumentRecordTypeUseForDeparment(String departmentId, int currentYear) throws Exception {
		Session session = null;
		try {
			session = openSession();

			String sql = "select retype.* from pml_edm_documentrecordtype retype";
			sql += " inner join pml_edm_bookdocumentsend book";
			sql += " on retype.documentrecordtypeid = book.documentrecordtypeid";
			sql += " and book.departmentsid = '" + departmentId + "'";
			sql += " and book.yearinuse = '" + currentYear + "'";
			sql += " order by retype.documentrecordtypename ASC";

			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("PmlEdmDocumentRecordType", PmlEdmDocumentRecordTypeImpl.class);

			return (List<PmlEdmDocumentRecordType>) QueryUtil.list(q, getDialect(), -1, -1);
		} catch (Exception e) {
			throw processException(e);
		} finally {
			closeSession(session);
		}
	}
	// end minh update 20110215
}
