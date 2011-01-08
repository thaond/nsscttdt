package com.sgs.portlet.pmllevelsend.service.persistence;

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
import com.sgs.portlet.pmllevelsend.model.PmlEdmLevelSend;
import com.sgs.portlet.pmllevelsend.model.impl.PmlEdmLevelSendImpl;

public class PmlEdmLevelSendFinderImpl extends BasePersistenceImpl implements PmlEdmLevelSendFinder {
	// minh 20100206
	public static String COUNT_BY_PMLEDMLEVELSEND = PmlEdmLevelSendFinder.class.getName() + ".countByPmlEdmLevelSend";
	public static String FIND_BY_PMLEDMLEVELSEND = PmlEdmLevelSendFinder.class.getName()+ ".findByPmlEdmLevelSend";
	
	
	
	public int countByKeywords(String keywords) throws SystemException{
		String[] pmlEdmLevelSendNames = null;
		boolean andOperator = false;
		if(Validator.isNotNull(keywords)){
			pmlEdmLevelSendNames = CustomSQLUtil.keywords(keywords, true);
		}else{
			andOperator = true;
		}
		
		return countByPmlEdmLevelSend(pmlEdmLevelSendNames, andOperator);
	}

	
	
	public int countByPmlEdmLevelSend(String[] pmlEdmLevelSendNames, 
			boolean andOperator) throws SystemException {
		pmlEdmLevelSendNames = CustomSQLUtil.keywords(pmlEdmLevelSendNames, true);
		
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(COUNT_BY_PMLEDMLEVELSEND);
			
			sql = CustomSQLUtil.replaceKeywords(sql, "lower(levelsendname)", StringPool.LIKE, true, pmlEdmLevelSendNames);
			sql = CustomSQLUtil.replaceAndOperator(sql, andOperator);
			
			SQLQuery q = session.createSQLQuery(sql);
			q.addScalar(COUNT_COLUMN_NAME, Type.LONG);
			
			QueryPos qpos = QueryPos.getInstance(q);
			qpos.add(pmlEdmLevelSendNames, 2);
			
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
	
	public List<PmlEdmLevelSend> findByKeywords(String keywords, int start, int end, OrderByComparator obc) throws SystemException{
		String[] pmlEdmLevelSendNames = null;
		boolean andOperator = false;
		if(Validator.isNotNull(keywords)){
			pmlEdmLevelSendNames = CustomSQLUtil.keywords(keywords, true);
		}else{
			andOperator = true;
		}
		
		return findByPmlEdmLevelSend(pmlEdmLevelSendNames, andOperator, start, end, obc);
	}

	
	public List<PmlEdmLevelSend> findByPmlEdmLevelSend(String[] pmlEdmLevelSendNames,
			boolean andOperator, int start, int end,
			OrderByComparator obc) throws SystemException {
		
		pmlEdmLevelSendNames = CustomSQLUtil.keywords(pmlEdmLevelSendNames, true);
		
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(FIND_BY_PMLEDMLEVELSEND);
			
			sql = CustomSQLUtil.replaceKeywords(sql, "lower(levelsendname)", StringPool.LIKE, true, pmlEdmLevelSendNames);
			sql = CustomSQLUtil.replaceAndOperator(sql, andOperator);
			sql = CustomSQLUtil.replaceOrderBy(sql, obc);
			
			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("pml_edm_levelsend", PmlEdmLevelSendImpl.class);
			
			QueryPos qpos = QueryPos.getInstance(q);
			qpos.add(pmlEdmLevelSendNames,2);
			
			return (List<PmlEdmLevelSend>) QueryUtil.list(q, getDialect(), start, end);
		} catch (Exception e) {
			throw new SystemException(e);
		}
		finally{
			closeSession(session);
		}
	}
	// end
	
	public List<PmlEdmLevelSend> findByLevelSendIds(
			List<Integer> levelSendIds) throws Exception {
		Session session = null;

		try {
			session = openSession();

			String sql = "SELECT DISTINCT(ls.*) ";
			sql += "FROM pml_edm_levelsend ls ";
			sql += "WHERE 1 = 0 ";

			// Doc levelSendIds de parse dieu kien loc du lieu
			for (Integer levelSendId : levelSendIds) {
				sql += " OR levelsendid = " + String.valueOf(levelSendId.intValue());
			}

			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("PmlEdmLevelSend",
					PmlEdmLevelSendImpl.class);

			return (List<PmlEdmLevelSend>) QueryUtil.list(q,
					getDialect(), QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}
}
