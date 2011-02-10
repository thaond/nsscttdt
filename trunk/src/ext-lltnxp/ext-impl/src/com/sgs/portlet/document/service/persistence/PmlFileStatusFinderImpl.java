package com.sgs.portlet.document.service.persistence;

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
import com.sgs.portlet.document.model.PmlFileStatus;
import com.sgs.portlet.document.model.impl.PmlFileStatusImpl;
/**
 * 
 * @author kaila
 *
 */
public class PmlFileStatusFinderImpl extends BasePersistenceImpl implements PmlFileStatusFinder{
	public static String FIND_BY_MA_TEN_CV = PmlFileStatusFinder.class.getName() + ".findBy_MA_TEN_CV";
	public static String COUNT_BY_MA_TEN_CV = PmlFileStatusFinder.class.getName()+ ".countBy_MA_TEN_CV";
	public static String FIND_BY_MA_TEN_MC = PmlFileStatusFinder.class.getName() + ".findBy_MA_TEN_MC";
	public static String COUNT_BY_MA_TEN_MC = PmlFileStatusFinder.class.getName()+ ".countBy_MA_TEN_MC";
	
	/**
	 * countByKeywordsCV
	 * @param keywords
	 * @return
	 * @throws SystemException
	 */
	public int countByKeywordsCV(String keywords) throws SystemException{
		String[] fileStatusCodes = null;
		String[] fileStatusNames = null;
		boolean andOperator = false;
		
		if(Validator.isNotNull(keywords)){
			fileStatusCodes = CustomSQLUtil.keywords(keywords);
			fileStatusNames = CustomSQLUtil.keywords(keywords);
		}else{
			andOperator = true;
		}
		
		return countByMA_TEN_CV(fileStatusCodes,fileStatusNames,andOperator);
	}

	public int countByMA_TEN_CV(String fileStatusCode,
			String fileStatusName, boolean andOperator) throws SystemException {
		
		return countByMA_TEN_CV(new String[]{fileStatusCode}, new String[]{fileStatusName}, andOperator);
	}
	public int countByMA_TEN_CV(String[] fileStatusCodes,
			String[] fileStatusNames, boolean andOperator) throws SystemException {
		
		fileStatusCodes = CustomSQLUtil.keywords(fileStatusCodes);
		fileStatusNames = CustomSQLUtil.keywords(fileStatusNames);
		
		Session session = null;
		
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(COUNT_BY_MA_TEN_CV);
			
			sql = CustomSQLUtil.replaceKeywords(sql, "lower(filestatuscode)", StringPool.LIKE, false, fileStatusCodes);
			sql = CustomSQLUtil.replaceKeywords(sql, "lower(filestatusname)", StringPool.LIKE, true, fileStatusNames);
			sql = CustomSQLUtil.replaceAndOperator(sql, andOperator);
			
			SQLQuery q = session.createSQLQuery(sql);
			
			q.addScalar(COUNT_COLUMN_NAME, Type.LONG);
			
			QueryPos qpos = QueryPos.getInstance(q);
			 qpos.add(fileStatusCodes,2);
			 qpos.add(fileStatusNames,2);
			
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
	 * @METHOD countByKeywordsMC
	 * @param keywords
	 * @return
	 * @throws SystemException
	 */
	public int countByKeywordsMC(String keywords) throws SystemException{
		String[] fileStatusCodes = null;
		String[] fileStatusNames = null;
		
		boolean andOperator = false;
		
		if(Validator.isNotNull(keywords)){
			fileStatusCodes = CustomSQLUtil.keywords(keywords);
			fileStatusNames = CustomSQLUtil.keywords(keywords);
		}else{
			andOperator = true;
		}
		
		return countByMA_TEN_MC(fileStatusCodes,fileStatusNames,andOperator);
	}
	
	public int countByMA_TEN_MC(String fileStatusCode,
			String fileStatusName, boolean andOperator) throws SystemException {
		
		return countByMA_TEN_MC(new String[]{fileStatusCode}, new String[]{fileStatusName}, andOperator);
	}
	public int countByMA_TEN_MC(String[] fileStatusCodes,
			String[] fileStatusNames, boolean andOperator) throws SystemException {
		
		fileStatusCodes = CustomSQLUtil.keywords(fileStatusCodes);
		fileStatusNames = CustomSQLUtil.keywords(fileStatusNames);
		
		Session session = null;
		
		try {
			session = openSession();
			
			String sql = CustomSQLUtil.get(COUNT_BY_MA_TEN_MC);
			
			sql = CustomSQLUtil.replaceKeywords(sql, "lower(filestatuscode)", StringPool.LIKE, false, fileStatusCodes);
			sql = CustomSQLUtil.replaceKeywords(sql, "lower(filestatusname)", StringPool.LIKE, true, fileStatusNames);
			sql = CustomSQLUtil.replaceAndOperator(sql, andOperator);
			
			SQLQuery q = session.createSQLQuery(sql);
			
			q.addScalar(COUNT_COLUMN_NAME, Type.LONG);
			
			QueryPos qpos = QueryPos.getInstance(q);
			qpos.add(fileStatusCodes,2);
			qpos.add(fileStatusNames,2);
			
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
	 * @method findByKeywordsCVs
	 * @param keywords
	 * @param start
	 * @param end
	 * @param obc
	 * @return
	 * @throws SystemException
	 */
	public List<PmlFileStatus> findByKeywordsCV(String keywords,int start, int end, OrderByComparator obc) throws SystemException{
		
		String[] fileStatusCodes = null;
		String[] fileStatusNames = null;
		
		boolean andOperator = false;
		
		if(Validator.isNotNull(keywords)){
			fileStatusCodes = CustomSQLUtil.keywords(keywords);
			fileStatusNames = CustomSQLUtil.keywords(keywords);
		}else{
			andOperator = true;
		}
		
		return findByMA_TEN_CV(fileStatusCodes, fileStatusNames, andOperator, start, end, obc);
	}

	public List<PmlFileStatus> findByMA_TEN_CV(String fileStatusCode,
			String fileStatusName, boolean andOperator, int start, int end,
			OrderByComparator obc) throws SystemException {
		
		return findByMA_TEN_CV(new String[]{fileStatusCode},new String[]{fileStatusName},
				andOperator,start, end, obc);
	}
	
	public List<PmlFileStatus> findByMA_TEN_CV(String[] fileStatusCodes,
			String[] fileStatusNames, boolean andOperator, int start, int end,
			OrderByComparator obc) throws SystemException {
		
		fileStatusCodes = CustomSQLUtil.keywords(fileStatusCodes);
		fileStatusNames = CustomSQLUtil.keywords(fileStatusNames);
		
		Session session = null;
		
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(FIND_BY_MA_TEN_CV);
			
			sql = CustomSQLUtil.replaceKeywords(sql, "lower(filestatuscode)", StringPool.LIKE, false, fileStatusCodes);
			sql = CustomSQLUtil.replaceKeywords(sql, "lower(filestatusname)", StringPool.LIKE, true, fileStatusNames);
			sql = CustomSQLUtil.replaceAndOperator(sql, andOperator);
			sql = CustomSQLUtil.replaceOrderBy(sql, obc);
			
			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("pml_filestatus", PmlFileStatusImpl.class);
			
			QueryPos qpos = QueryPos.getInstance(q);
			 qpos.add(fileStatusCodes,2);
			 qpos.add(fileStatusNames,2);
			 
			return (List<PmlFileStatus>) QueryUtil.list(q, getDialect(), start, end);
		} catch (Exception e) {
			throw new SystemException(e);
		}
		finally{
			closeSession(session);
		}
	}
	/**
	 * @method findByKeywordsMC
	 * @param keywords
	 * @param start
	 * @param end
	 * @param obc
	 * @return
	 * @throws SystemException
	 */
	public List<PmlFileStatus> findByKeywordsMC(String keywords,int start, int end, OrderByComparator obc) throws SystemException{
		String[] fileStatusCodes = null;
		String[] fileStatusNames = null;
		
		boolean andOperator = false;
		if(Validator.isNotNull(keywords)){
			fileStatusCodes = CustomSQLUtil.keywords(keywords);
			fileStatusNames = CustomSQLUtil.keywords(keywords);
		}else{
			andOperator = true;
		}
		
		return findByMA_TEN_MC(fileStatusCodes, fileStatusNames, andOperator, start, end, obc);
	}
	
	public List<PmlFileStatus> findByMA_TEN_MC(String fileStatusCode,
			String fileStatusName, boolean andOperator, int start, int end,
			OrderByComparator obc) throws SystemException {
		
		return findByMA_TEN_MC(new String[]{fileStatusCode},new String[]{fileStatusName},
				andOperator,start, end, obc);
	}
	
	public List<PmlFileStatus> findByMA_TEN_MC(String[] fileStatusCodes,
			String[] fileStatusNames, boolean andOperator, int start, int end,
			OrderByComparator obc) throws SystemException {
		
		fileStatusCodes = CustomSQLUtil.keywords(fileStatusCodes);
		fileStatusNames = CustomSQLUtil.keywords(fileStatusNames);
		
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(FIND_BY_MA_TEN_MC);
			
			sql = CustomSQLUtil.replaceKeywords(sql, "lower(filestatuscode)", StringPool.LIKE, false, fileStatusCodes);
			sql = CustomSQLUtil.replaceKeywords(sql, "lower(filestatusname)", StringPool.LIKE, true, fileStatusNames);
			sql = CustomSQLUtil.replaceAndOperator(sql, andOperator);
			sql = CustomSQLUtil.replaceOrderBy(sql, obc);
			
			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("pml_filestatus", PmlFileStatusImpl.class);
			
			QueryPos qpos = QueryPos.getInstance(q);
			qpos.add(fileStatusCodes,2);
			qpos.add(fileStatusNames,2);
			
			return (List<PmlFileStatus>) QueryUtil.list(q, getDialect(), start, end);
		} catch (Exception e) {
			throw new SystemException(e);
		}
		finally{
			closeSession(session);
		}
	}
	
}
