package com.sgs.portlet.attachedfile.service.persistence;

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
import com.sgs.portlet.attachedfile.model.AttachedFile;
import com.sgs.portlet.attachedfile.model.impl.AttachedFileImpl;
/**
 * 
 * @author Yenlt 28/01/2010
 *
 */
public class AttachedFileFinderImpl extends BasePersistenceImpl implements AttachedFileFinder{
	public static String FIND_BY_TEN_MA = AttachedFileFinder.class.getName() + ".findBy_TEN_MA";
	public static String COUNT_BY_TEN_MA = AttachedFileFinder.class.getName() + ".countBy_TEN_MA";
	
	public int countByKeywords(String keywords) throws SystemException{
		String[] codes = null;
		String[] names = null;
		
		boolean andOperator = false;
		if(Validator.isNotNull(keywords)){
			codes = CustomSQLUtil.keywords(keywords, true);
			names = CustomSQLUtil.keywords(keywords, true);
		}else{
			andOperator = true;
		}
		
		return countByTEN_MA(codes,names,andOperator);
	}

	public int countByTEN_MA(String code, String name, boolean andOperator) throws SystemException{
		return countByTEN_MA(new String[]{code}, new String[]{name}, andOperator);
	}
	
	public int countByTEN_MA(String[] codes, String[] names,
			boolean andOperator) throws SystemException {
		codes = CustomSQLUtil.keywords(codes, true);
		names = CustomSQLUtil.keywords(names, true);
		
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(COUNT_BY_TEN_MA);
			
			sql = CustomSQLUtil.replaceKeywords(sql, "lower(attachedfilecode)", StringPool.LIKE, false, codes);
			sql = CustomSQLUtil.replaceKeywords(sql, "lower(attachedfilename)", StringPool.LIKE, true, names);
			sql = CustomSQLUtil.replaceAndOperator(sql, andOperator);
			
			SQLQuery q = session.createSQLQuery(sql);
			q.addScalar(COUNT_COLUMN_NAME, Type.LONG);
			
			QueryPos qpos = QueryPos.getInstance(q);
			qpos.add(codes,2);
			qpos.add(names,2);
			
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
	
	public List<AttachedFile> findByKeywords(String keywords,int start, int end, OrderByComparator obc) throws SystemException{
		String[] codes = null;
		String[] names = null;
		
		boolean andOperator = false;
		if(Validator.isNotNull(keywords)){
			codes = CustomSQLUtil.keywords(keywords, true);
			names = CustomSQLUtil.keywords(keywords, true);
		}else{
			andOperator = true;
		}
		return findTEN_MA (codes, names,andOperator, start, end, obc);
	}

	public List<AttachedFile> findTEN_MA(String code, String name, boolean andOperator, int start, int end, OrderByComparator obc) throws SystemException {
		return findTEN_MA(new String[]{code}, new String[]{name}, andOperator, start, end, obc);
	}

	public List<AttachedFile> findTEN_MA(String[] codes, String[] names,
			boolean andOperator, int start, int end, OrderByComparator obc) throws SystemException {
		codes = CustomSQLUtil.keywords(codes, true);
		names = CustomSQLUtil.keywords(names, true);
		
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(FIND_BY_TEN_MA);
			
			sql = CustomSQLUtil.replaceKeywords(sql, "lower(attachedfilecode)", StringPool.LIKE, false, codes);
			sql = CustomSQLUtil.replaceKeywords(sql, "lower(attachedfilename)", StringPool.LIKE, true, names);
			sql = CustomSQLUtil.replaceAndOperator(sql, andOperator);
			sql = CustomSQLUtil.replaceOrderBy(sql, obc);
			
			SQLQuery q = session.createSQLQuery(sql);
			
			q.addEntity("pml_attachedfile", AttachedFileImpl.class);
			
			QueryPos qpos = QueryPos.getInstance(q);
			qpos.add(codes,2);
			qpos.add(names,2);
			 
			return (List<AttachedFile>) QueryUtil.list(q, getDialect(), start, end);
		} catch (Exception e) {
			throw new SystemException(e);
		}
		finally{
			closeSession(session);
		}
	}

}
