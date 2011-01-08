/**
 * Dinh nghia cac ham de tuong tac hibernate
 * 
 * @author XUAN CONG
 */
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
import com.sgs.portlet.document.receipt.model.PmlEdmDocumentType;
import com.sgs.portlet.document.receipt.model.impl.PmlEdmDocumentTypeImpl;

public class PmlEdmDocumentTypeFinderImpl extends BasePersistenceImpl
		implements PmlEdmDocumentTypeFinder {
	// minh 20100206
	public static String COUNT_BY_PMLEDMDOCUMENTTYPE = PmlEdmDocumentTypeFinder.class.getName() + ".countByPmlEdmDocumentType";
	public static String FIND_BY_PMLEDMDOCUMENTTYPE = PmlEdmDocumentTypeFinder.class.getName()+ ".findByPmlEdmDocumentType";
	
	
	public int countByKeywords(String keywords) throws SystemException{
		String[] pmlEdmDocumentTypeNames = null;
		String[] pmlEdmDocumentRecordTypeNames = null;
		boolean andOperator = false;
		if(Validator.isNotNull(keywords)){
			pmlEdmDocumentTypeNames = CustomSQLUtil.keywords(keywords, true);
			pmlEdmDocumentRecordTypeNames = CustomSQLUtil.keywords(keywords, true);
		}else{
			andOperator = true;
		}
		
		return countByPmlEdmDocumentType(pmlEdmDocumentTypeNames, pmlEdmDocumentRecordTypeNames, andOperator);
	}
	
	public int countByPmlEdmDocumentType(String pmlEdmDocumentTypeName, String pmlEdmDocumentRecordTypeName, boolean andOperator) throws SystemException{
		return countByPmlEdmDocumentType(new String[]{pmlEdmDocumentTypeName}, new String[]{pmlEdmDocumentRecordTypeName}, andOperator);
	}
	
	public int countByPmlEdmDocumentType(String[] pmlEdmDocumentTypeNames,
			String[] pmlEdmDocumentRecordTypeNames,
			boolean andOperator) throws SystemException {
		pmlEdmDocumentTypeNames = CustomSQLUtil.keywords(pmlEdmDocumentTypeNames, true);
		pmlEdmDocumentRecordTypeNames = CustomSQLUtil.keywords(pmlEdmDocumentRecordTypeNames, true);
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(COUNT_BY_PMLEDMDOCUMENTTYPE);
			
			sql = CustomSQLUtil.replaceKeywords(sql, "lower(pml_edm_documenttype.documenttypename)", StringPool.LIKE, true, pmlEdmDocumentTypeNames);
			sql = CustomSQLUtil.replaceKeywords(sql, "lower(pml_edm_documentrecordtype.documentrecordtypename)", StringPool.LIKE, true, pmlEdmDocumentRecordTypeNames);
			sql = CustomSQLUtil.replaceAndOperator(sql, andOperator);
			
			SQLQuery q = session.createSQLQuery(sql);
			q.addScalar(COUNT_COLUMN_NAME, Type.LONG);
			
			QueryPos qpos = QueryPos.getInstance(q);
			qpos.add(pmlEdmDocumentTypeNames, 2);
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
	
	public List<PmlEdmDocumentType> findByKeywords(String keywords, int start, int end, OrderByComparator obc) throws SystemException{
		String[] pmlEdmDocumentTypeNames = null;
		String[] pmlEdmDocumentRecordTypeNames = null;
		boolean andOperator = false;
		if(Validator.isNotNull(keywords)){
			pmlEdmDocumentTypeNames = CustomSQLUtil.keywords(keywords, true);
			pmlEdmDocumentRecordTypeNames = CustomSQLUtil.keywords(keywords, true);
		}else{
			andOperator = true;
		}
		
		return findByPmlEdmDocumentType(pmlEdmDocumentTypeNames, pmlEdmDocumentRecordTypeNames, andOperator, start, end, obc);
	}

	public List<PmlEdmDocumentType> findByPmlEdmDocumentType(String pmlEdmDocumentTypeName, String pmlEdmDocumentRecordTypeName, boolean andOperator, int start, int end, OrderByComparator obc) throws SystemException{
		return findByPmlEdmDocumentType(new String[]{pmlEdmDocumentTypeName}, new String[]{pmlEdmDocumentRecordTypeName}, andOperator, start, end, obc);
	}
	
	public List<PmlEdmDocumentType> findByPmlEdmDocumentType(String[] pmlEdmDocumentTypeNames,
			String[] pmlEdmDocumentRecordTypeNames, 
			boolean andOperator, int start, int end,
			OrderByComparator obc) throws SystemException {
		
		pmlEdmDocumentTypeNames = CustomSQLUtil.keywords(pmlEdmDocumentTypeNames, true);
		pmlEdmDocumentRecordTypeNames = CustomSQLUtil.keywords(pmlEdmDocumentRecordTypeNames, true);
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(FIND_BY_PMLEDMDOCUMENTTYPE);
			
			sql = CustomSQLUtil.replaceKeywords(sql, "lower(pml_edm_documenttype.documenttypename)", StringPool.LIKE, true, pmlEdmDocumentTypeNames);
			sql = CustomSQLUtil.replaceKeywords(sql, "lower(pml_edm_documentrecordtype.documentrecordtypename)", StringPool.LIKE, true, pmlEdmDocumentRecordTypeNames);
			sql = CustomSQLUtil.replaceAndOperator(sql, andOperator);
			sql = CustomSQLUtil.replaceOrderBy(sql, obc);
			
			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("pml_edm_documenttype", PmlEdmDocumentTypeImpl.class);
			
			QueryPos qpos = QueryPos.getInstance(q);
			qpos.add(pmlEdmDocumentTypeNames,2);
			qpos.add(pmlEdmDocumentRecordTypeNames,2);
			
			return (List<PmlEdmDocumentType>) QueryUtil.list(q, getDialect(), start, end);
		} catch (Exception e) {
			throw new SystemException(e);
		}
		finally{
			closeSession(session);
		}
	}
	// end
	
	public List<PmlEdmDocumentType> findByDocumentTypeIds(
			List<Long> documentTypeIds) throws Exception {
		Session session = null;

		try {
			session = openSession();

			String sql = "SELECT DISTINCT(dt.*) ";
			sql += "FROM pml_edm_documenttype dt ";
			sql += "WHERE 1 = 0 ";

			// Doc documentTypeIds de parse dieu kien loc du lieu
			for (Long documentTypeId : documentTypeIds) {
				sql += " OR documenttypeid = " + String.valueOf(documentTypeId.longValue());
			}

			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("PmlEdmDocumentType",
					PmlEdmDocumentTypeImpl.class);

			return (List<PmlEdmDocumentType>) QueryUtil.list(q,
					getDialect(), QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}
}
