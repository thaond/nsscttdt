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
import com.sgs.portlet.document.receipt.model.impl.PmlEdmDocumentRecordToImpl;

@SuppressWarnings("unchecked")
public class PmlEdmDocumentRecordToFinderImpl extends BasePersistenceImpl implements PmlEdmDocumentRecordToFinder{
	public static String FIND_BY_LOAI_SO = PmlEdmDocumentRecordToFinder.class.getName() + ".findBy_LOAI_SO";
	public static String COUNT_BY_LOAI_SO = PmlEdmDocumentRecordToFinder.class.getName() + ".countBy_LOAI_SO";
	public static String FIND_BY_LOAI_PB = PmlEdmDocumentRecordToFinder.class.getName() + ".findBy_LOAI_PB";
	public static String COUNT_BY_LOAI_PB = PmlEdmDocumentRecordToFinder.class.getName() + ".countBy_LOAI_PB";
	
	/**
	 * SO CONG VAN DEN CUA SO
	 */
	public List<PmlEdmDocumentRecordTo> findByKeywords(String keywords,int start, int end, OrderByComparator obc) throws SystemException{
		String[] loaiSoCVs = null;
		String[] so = null;
		
		boolean andOperator = false;
		if(Validator.isNotNull(keywords)){
			loaiSoCVs = CustomSQLUtil.keywords(keywords, true);
			so = CustomSQLUtil.keywords(keywords, true);
		}else{
			andOperator = true;
		}
		return findDocumentRecordToAgency (loaiSoCVs, so,andOperator, start, end, obc);
	}
	
	public List<PmlEdmDocumentRecordTo> findDocumentRecordToAgency(String loaiSoCVs, String so, boolean andOperator, int start, int end, OrderByComparator obc) throws SystemException {
		return findDocumentRecordToAgency(new String[]{loaiSoCVs}, new String[]{so}, andOperator, start, end, obc);
	}
	
	public List<PmlEdmDocumentRecordTo> findDocumentRecordToAgency(String[] loaiSoCVs, String[] so, boolean andOperator, int start, int end, OrderByComparator obc) throws SystemException {
		loaiSoCVs = CustomSQLUtil.keywords(loaiSoCVs, true);
		so = CustomSQLUtil.keywords(so, true);
		
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(FIND_BY_LOAI_SO);
			
			sql = CustomSQLUtil.replaceKeywords(sql, "lower(pml_edm_documentrecordtype.documentrecordtypename)", StringPool.LIKE, false, loaiSoCVs);
			sql = CustomSQLUtil.replaceKeywords(sql, "lower(pml_agency.agencyname)", StringPool.LIKE, true, so);
			sql = CustomSQLUtil.replaceAndOperator(sql, andOperator);
			sql = CustomSQLUtil.replaceOrderBy(sql, obc);
			
			SQLQuery q = session.createSQLQuery(sql);
			
			q.addEntity("pml_edm_documentrecordto", PmlEdmDocumentRecordToImpl.class);
			
			QueryPos qpos = QueryPos.getInstance(q);
			qpos.add(loaiSoCVs,2);
			qpos.add(so,2);
			 
			return (List<PmlEdmDocumentRecordTo>) QueryUtil.list(q, getDialect(), start, end);
		} catch (Exception e) {
			throw new SystemException(e);
		}
		finally{
			closeSession(session);
		}
	}
	
	public int countByKeywords(String keywords) throws SystemException{
		
		String[] loaiSoCVs = null;
		String[] so = null;
		
		boolean andOperator = false;
		if(Validator.isNotNull(keywords)){
			loaiSoCVs = CustomSQLUtil.keywords(keywords, true);
			so = CustomSQLUtil.keywords(keywords, true);
		}else{
			andOperator = true;
		}
		return countDocumentRecordToAgency (loaiSoCVs, so,andOperator);
	}

	public int countDocumentRecordToAgency(String loaiSoCVs, String so,
			boolean andOperator) throws SystemException {
		return countDocumentRecordToAgency(new String[]{loaiSoCVs}, new String[]{so}, andOperator);
	}
	
	public int countDocumentRecordToAgency(String[] loaiSoCVs, String[] so,
			boolean andOperator) throws SystemException {
		
		loaiSoCVs = CustomSQLUtil.keywords(loaiSoCVs, true);
		so = CustomSQLUtil.keywords(so, true);
		
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(COUNT_BY_LOAI_SO);
			
			sql = CustomSQLUtil.replaceKeywords(sql, "lower(pml_edm_documentrecordtype.documentrecordtypename)", StringPool.LIKE, false, loaiSoCVs);
			sql = CustomSQLUtil.replaceKeywords(sql, "lower(pml_agency.agencyname)", StringPool.LIKE, true, so);
			sql = CustomSQLUtil.replaceAndOperator(sql, andOperator);
			SQLQuery q = session.createSQLQuery(sql);
			
			q.addScalar(COUNT_COLUMN_NAME, Type.LONG);
			
			QueryPos qpos = QueryPos.getInstance(q);
			qpos.add(loaiSoCVs,2);
			qpos.add(so,2);
			
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
	
	/**
	 * SO CONG VAN DEN CUA PHONG BAN
	 */
	public List<PmlEdmDocumentRecordTo> findByKeywordsPB(String keywords,int start, int end, OrderByComparator obc) throws SystemException{
		String[] loaiSoCVs = null;
		String[] phongBan = null;
		
		boolean andOperator = false;
		if(Validator.isNotNull(keywords)){
			loaiSoCVs = CustomSQLUtil.keywords(keywords, true);
			phongBan = CustomSQLUtil.keywords(keywords, true);
		}else{
			andOperator = true;
		}
		return findDocumentRecordToDepartment (loaiSoCVs, phongBan,andOperator, start, end, obc);
	}
	
	public List<PmlEdmDocumentRecordTo> findDocumentRecordToDepartment(String loaiSoCVs, String phongBan, boolean andOperator, int start, int end, OrderByComparator obc) throws SystemException {
		return findDocumentRecordToDepartment(new String[]{loaiSoCVs}, new String[]{phongBan}, andOperator, start, end, obc);
	}
	
	public List<PmlEdmDocumentRecordTo> findDocumentRecordToDepartment(String[] loaiSoCVs, String[] phongBan, boolean andOperator, int start, int end, OrderByComparator obc) throws SystemException {
		loaiSoCVs = CustomSQLUtil.keywords(loaiSoCVs, true);
		phongBan = CustomSQLUtil.keywords(phongBan, true);
		
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(FIND_BY_LOAI_PB);
			
			sql = CustomSQLUtil.replaceKeywords(sql, "lower(pml_edm_documentrecordtype.documentrecordtypename)", StringPool.LIKE, false, loaiSoCVs);
			sql = CustomSQLUtil.replaceKeywords(sql, "lower(pml_departments.departmentsname)", StringPool.LIKE, true, phongBan);
			sql = CustomSQLUtil.replaceAndOperator(sql, andOperator);
			sql = CustomSQLUtil.replaceOrderBy(sql, obc);
			
			SQLQuery q = session.createSQLQuery(sql);
			
			q.addEntity("pml_edm_documentrecordto", PmlEdmDocumentRecordToImpl.class);
			
			QueryPos qpos = QueryPos.getInstance(q);
			qpos.add(loaiSoCVs,2);
			qpos.add(phongBan,2);
			 
			return (List<PmlEdmDocumentRecordTo>) QueryUtil.list(q, getDialect(), start, end);
		} catch (Exception e) {
			throw new SystemException(e);
		}
		finally{
			closeSession(session);
		}
	}
	
	public int countByKeywordsPB(String keywords) throws SystemException{
		
		String[] loaiSoCVs = null;
		String[] phongBan = null;
		
		boolean andOperator = false;
		if(Validator.isNotNull(keywords)){
			loaiSoCVs = CustomSQLUtil.keywords(keywords, true);
			phongBan = CustomSQLUtil.keywords(keywords, true);
		}else{
			andOperator = true;
		}
		return countDocumentRecordToDepartment (loaiSoCVs, phongBan,andOperator);
	}

	public int countDocumentRecordToDepartment(String loaiSoCVs, String phongBan,
			boolean andOperator) throws SystemException {
		return countDocumentRecordToDepartment(new String[]{loaiSoCVs}, new String[]{phongBan}, andOperator);
	}
	
	public int countDocumentRecordToDepartment(String[] loaiSoCVs, String[] phongBan,
			boolean andOperator) throws SystemException {
		
		loaiSoCVs = CustomSQLUtil.keywords(loaiSoCVs, true);
		phongBan = CustomSQLUtil.keywords(phongBan, true);
		
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(COUNT_BY_LOAI_PB);
			
			sql = CustomSQLUtil.replaceKeywords(sql, "lower(pml_edm_documentrecordtype.documentrecordtypename)", StringPool.LIKE, false, loaiSoCVs);
			sql = CustomSQLUtil.replaceKeywords(sql, "lower(pml_departments.departmentsname)", StringPool.LIKE, true, phongBan);
			sql = CustomSQLUtil.replaceAndOperator(sql, andOperator);
			SQLQuery q = session.createSQLQuery(sql);
			
			q.addScalar(COUNT_COLUMN_NAME, Type.LONG);
			
			QueryPos qpos = QueryPos.getInstance(q);
			qpos.add(loaiSoCVs,2);
			qpos.add(phongBan,2);
			
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
}
