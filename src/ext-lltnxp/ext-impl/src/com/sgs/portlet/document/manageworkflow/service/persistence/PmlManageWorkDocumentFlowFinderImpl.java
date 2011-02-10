package com.sgs.portlet.document.manageworkflow.service.persistence;

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
import com.sgs.portlet.document.manageworkflow.model.PmlManageWorkDocumentFlow;
import com.sgs.portlet.document.manageworkflow.model.impl.PmlManageWorkDocumentFlowImpl;

public class PmlManageWorkDocumentFlowFinderImpl extends BasePersistenceImpl implements PmlManageWorkDocumentFlowFinder {
	public static String COUNT_BY_DOCUMENTWORKFLOW = PmlManageWorkDocumentFlowFinder.class.getName() + ".countByDocumentWorkflow";
	public static String FIND_BY_DOCUMENTWORKFLOW = PmlManageWorkDocumentFlowFinder.class.getName()+ ".findByDocumentWorkflow";
	
	public int countByKeywords(String keywords) throws SystemException{
		String[] workflowNames = null;
		String[] descriptions = null;
		boolean andOperator = false;
		if(Validator.isNotNull(keywords)){
			workflowNames = CustomSQLUtil.keywords(keywords, true);
			descriptions = CustomSQLUtil.keywords(keywords, true);
		}else{
			andOperator = true;
		}
		
		return countByDocumentWorkflow(workflowNames, descriptions, andOperator);
	}
	public int countByDocumentWorkflow(String workflowName, String description, boolean andOperator) throws SystemException{
		return countByDocumentWorkflow(new String[]{workflowName}, new String[]{description}, andOperator);
	}
	
	
	public int countByDocumentWorkflow(String[] workflowNames, String[] descriptions,
			boolean andOperator) throws SystemException {
		workflowNames = CustomSQLUtil.keywords(workflowNames, true);	
		descriptions = CustomSQLUtil.keywords(descriptions, true);	
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(COUNT_BY_DOCUMENTWORKFLOW);
			
			sql = CustomSQLUtil.replaceKeywords(sql, "lower(workflowname)", StringPool.LIKE, true, workflowNames);
			sql = CustomSQLUtil.replaceKeywords(sql, "lower(description)", StringPool.LIKE, true, descriptions);
			sql = CustomSQLUtil.replaceAndOperator(sql, andOperator);
			
			SQLQuery q = session.createSQLQuery(sql);
			q.addScalar(COUNT_COLUMN_NAME, Type.LONG);
			
			QueryPos qpos = QueryPos.getInstance(q);
			qpos.add(workflowNames, 2);
			qpos.add(descriptions, 2);
			
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

	
	
	
	public List<PmlManageWorkDocumentFlow> findByKeywords(String keywords, int start, int end, OrderByComparator obc) throws SystemException{
		String[] workflowNames = null;
		String[] descriptions = null;
		
		boolean andOperator = false;
		if(Validator.isNotNull(keywords)){
			workflowNames = CustomSQLUtil.keywords(keywords, true);
			descriptions = CustomSQLUtil.keywords(keywords, true);
		}else{
			andOperator = true;
		}
		return findByDocumentWorkflow(workflowNames, descriptions, andOperator, start, end, obc);
	}

	public List<PmlManageWorkDocumentFlow> findByDocumentWorkflow(String workflowName, String description, boolean andOperator, int start, int end, OrderByComparator obc) throws SystemException{
		return findByDocumentWorkflow(new String[]{workflowName}, new String[]{description}, andOperator, start, end, obc);
	}
	
	public List<PmlManageWorkDocumentFlow> findByDocumentWorkflow(String[] workflowNames, String[] descriptions,
			boolean andOperator, int start, int end,
			OrderByComparator obc) throws SystemException {
		
		workflowNames = CustomSQLUtil.keywords(workflowNames, true);
		descriptions = CustomSQLUtil.keywords(descriptions, true);
		
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(FIND_BY_DOCUMENTWORKFLOW);
			
			sql = CustomSQLUtil.replaceKeywords(sql, "lower(workflowname)", StringPool.LIKE, true, workflowNames);
			sql = CustomSQLUtil.replaceKeywords(sql, "lower(description)", StringPool.LIKE, true, descriptions);
			sql = CustomSQLUtil.replaceAndOperator(sql, andOperator);
			sql = CustomSQLUtil.replaceOrderBy(sql, obc);
			
			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("pml_manage_documentworkflow", PmlManageWorkDocumentFlowImpl.class);
		
			QueryPos qpos = QueryPos.getInstance(q);
			qpos.add(workflowNames,2);
			qpos.add(descriptions,2);
			
			return (List<PmlManageWorkDocumentFlow>) QueryUtil.list(q, getDialect(), start, end);
		} catch (Exception e) {
			throw new SystemException(e);
		}
		finally{
			closeSession(session);
		}
	}
}
