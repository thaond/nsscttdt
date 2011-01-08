package com.sgs.portlet.generatetemplateid.service.persistence;

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
import com.sgs.portlet.generatetemplateid.model.IdTemplate;
import com.sgs.portlet.generatetemplateid.model.impl.IdTemplateImpl;

public class IdTemplateFinderImpl extends BasePersistenceImpl implements IdTemplateFinder{
	public static String FIND_BY_MA_MOTA = IdTemplateFinder.class.getName() + ".findBy_MA_MOTA";
	public static String COUNT_BY_MA_MOTA = IdTemplateFinder.class.getName() + ".countBy_MA_MOTA";
	
	public int countByKeywords(String keywords) throws SystemException{
		String[] formats = null;
		String[] des = null;
		
		boolean andOperator = false;
		if(Validator.isNotNull(keywords)){
			formats = CustomSQLUtil.keywords(keywords, true);
			des = CustomSQLUtil.keywords(keywords, true);
		}else{
			andOperator = true;
		}
		
		return countByMA_MOTA (formats,des,andOperator);
	}
	
	public int countByMA_MOTA(String format, String des, boolean andOperator) throws SystemException {
		return countByMA_MOTA(new String[]{format}, new String[]{des}, andOperator);
	}
	
	public int countByMA_MOTA(String[] formats, String[] des,
			boolean andOperator) throws SystemException {
		formats = CustomSQLUtil.keywords(formats, true);
		des = CustomSQLUtil.keywords(des, true);
		
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(COUNT_BY_MA_MOTA);
			
			sql = CustomSQLUtil.replaceKeywords(sql, "lower(format)", StringPool.LIKE, false, formats);
			sql = CustomSQLUtil.replaceKeywords(sql, "lower(description)", StringPool.LIKE, true, des);
			sql = CustomSQLUtil.replaceAndOperator(sql, andOperator);
			
			SQLQuery q = session.createSQLQuery(sql);
			q.addScalar(COUNT_COLUMN_NAME, Type.LONG);
			
			QueryPos qpos = QueryPos.getInstance(q);
			qpos.add(formats,2);
			qpos.add(des,2);
			
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


	public List<IdTemplate> findByKeywords(String keywords, int start, int end, OrderByComparator obc) throws SystemException{
		String[] formats = null;
		String[] des = null;
		
		boolean andOperator = false;
		if(Validator.isNotNull(keywords)){
			formats = CustomSQLUtil.keywords(keywords, true);
			des = CustomSQLUtil.keywords(keywords, true);
		}else{
			andOperator = true;
		}
		return findByMA_MOTA (formats, des,andOperator, start, end, obc);
	}

	public List<IdTemplate> findByMA_MOTA(String format, String des, boolean andOperator, int start, int end, OrderByComparator obc) throws SystemException{
		return findByMA_MOTA(new String[]{format}, new String[]{des}, andOperator, start, end, obc);
	}
	public List<IdTemplate> findByMA_MOTA(String[] formats, String[] des,
			boolean andOperator, int start, int end, OrderByComparator obc) throws SystemException {
		formats = CustomSQLUtil.keywords(formats, true);
		des = CustomSQLUtil.keywords(des, true);
		
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(FIND_BY_MA_MOTA);
			
			sql = CustomSQLUtil.replaceKeywords(sql, "lower(format)", StringPool.LIKE, false, formats);
			sql = CustomSQLUtil.replaceKeywords(sql, "lower(description)", StringPool.LIKE, true, des);
			sql = CustomSQLUtil.replaceAndOperator(sql, andOperator);
			sql = CustomSQLUtil.replaceOrderBy(sql, obc);
			
			SQLQuery q = session.createSQLQuery(sql);
			
			q.addEntity("pml_idtemplate", IdTemplateImpl.class);
			
			QueryPos qpos = QueryPos.getInstance(q);
			qpos.add(formats,2);
			qpos.add(des,2);
			 
			return (List<IdTemplate>) QueryUtil.list(q, getDialect(), start, end);
		} catch (Exception e) {
			throw new SystemException(e);
		}
		finally{
			closeSession(session);
		}
	}
}
