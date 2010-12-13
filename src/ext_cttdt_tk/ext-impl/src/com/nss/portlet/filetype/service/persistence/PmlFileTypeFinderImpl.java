package com.nss.portlet.filetype.service.persistence;

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
import com.nss.portlet.filetype.model.PmlFileType;
import com.nss.portlet.filetype.model.impl.PmlFileTypeImpl;

public class PmlFileTypeFinderImpl extends BasePersistenceImpl implements PmlFileTypeFinder{
	public static String COUNT_BY_FILETYPE = PmlFileTypeFinder.class.getName() + ".countByFileType";
	public static String FIND_BY_FILETYPE = PmlFileTypeFinder.class.getName()+ ".findByFileType";
	public int countByKeywords(String keywords) throws SystemException{
		String[] fileTypeCodes = null;
		String[] fileTypeNames = null;		
		boolean andOperator = false;
		if(Validator.isNotNull(keywords)){
			fileTypeCodes = CustomSQLUtil.keywords(keywords, true);
			fileTypeNames = CustomSQLUtil.keywords(keywords, true);		
		}else{
			andOperator = true;
		}
		
		return countByFileType(fileTypeCodes, fileTypeNames, andOperator);
	}
	
	public int countByFileType(String fileTypeCode, String fileTypeName, boolean andOperator) throws SystemException{
		return countByFileType(new String[]{fileTypeCode}, new String[]{fileTypeName}, andOperator);
	}
	
	
	public int countByFileType(String[] fileTypeCodes, String[] fileTypeNames,
			boolean andOperator) throws SystemException {
		fileTypeCodes = CustomSQLUtil.keywords(fileTypeCodes, true);
		fileTypeNames = CustomSQLUtil.keywords(fileTypeNames, true);
		
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(COUNT_BY_FILETYPE);
			
			sql = CustomSQLUtil.replaceKeywords(sql, "lower(pml_filetype.filetypecode)", StringPool.LIKE, false, fileTypeCodes);			
			sql = CustomSQLUtil.replaceKeywords(sql, "lower(pml_filetype.filetypename)", StringPool.LIKE, true, fileTypeNames);
			sql = CustomSQLUtil.replaceAndOperator(sql, andOperator);
			
			SQLQuery q = session.createSQLQuery(sql);
			q.addScalar(COUNT_COLUMN_NAME, Type.LONG);
			
			QueryPos qpos = QueryPos.getInstance(q);
			qpos.add(fileTypeCodes, 2);
			qpos.add(fileTypeNames, 2);
			
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
	
	public List<PmlFileType> findByKeywords(String keywords, int start, int end, OrderByComparator obc) throws SystemException{
		String[] fileTypeCodes = null;
		String[] fileTypeNames = null;		
		boolean andOperator = false;
		if(Validator.isNotNull(keywords)){
			fileTypeCodes = CustomSQLUtil.keywords(keywords, true);
			fileTypeNames = CustomSQLUtil.keywords(keywords, true);		
		}else{
			andOperator = true;
		}
		
		return findByFileType(fileTypeCodes, fileTypeNames, andOperator, start, end, obc);
	}

	public List<PmlFileType> findByFileType(String fileTypeCode, String fileTypeName, boolean andOperator, int start, int end, OrderByComparator obc) throws SystemException{
		return findByFileType(new String[]{fileTypeCode}, new String[]{fileTypeName}, andOperator, start, end, obc);
	}
	
	public List<PmlFileType> findByFileType(String[] fileTypeCodes, String[] fileTypeNames,
			boolean andOperator, int start, int end,
			OrderByComparator obc) throws SystemException {
		
		fileTypeCodes = CustomSQLUtil.keywords(fileTypeCodes, true);
		fileTypeNames = CustomSQLUtil.keywords(fileTypeNames, true);
		
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(FIND_BY_FILETYPE);
			
			sql = CustomSQLUtil.replaceKeywords(sql, "lower(pml_filetype.filetypecode)", StringPool.LIKE, false, fileTypeCodes);			
			sql = CustomSQLUtil.replaceKeywords(sql, "lower(pml_filetype.filetypename)", StringPool.LIKE, true, fileTypeNames);
			sql = CustomSQLUtil.replaceAndOperator(sql, andOperator);
			sql = CustomSQLUtil.replaceOrderBy(sql, obc);
			
			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("pml_filetype", PmlFileTypeImpl.class);
			
			QueryPos qpos = QueryPos.getInstance(q);
			qpos.add(fileTypeCodes,2);
			qpos.add(fileTypeNames,2);
			
			return (List<PmlFileType>) QueryUtil.list(q, getDialect(), start, end);
		} catch (Exception e) {
			throw new SystemException(e);
		}
		finally{
			closeSession(session);
		}
	}
	
}
