/**
 * 
 */
package com.sgs.portlet.onedoor.service.persistence;

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
import com.sgs.portlet.onedoor.model.PmlWorkflow;
import com.sgs.portlet.onedoor.model.impl.PmlWorkflowImpl;

/**
 * @author minhnv
 *
 */
public class PmlWorkflowFinderImpl extends BasePersistenceImpl implements PmlWorkflowFinder { 
	public static String COUNT_BY_ONEDOORWORKFLOW = PmlWorkflowFinder.class.getName() + ".countByOneDoorWorkflow";
	public static String FIND_BY_ONEDOORWORKFLOW = PmlWorkflowFinder.class.getName()+ ".findByOneDoorWorkflow";
	
	public int countByKeywords(String keywords) throws SystemException{
		String[] fileTypeNames = null;
		String[] workflowNames = null;
		boolean andOperator = false;
		if(Validator.isNotNull(keywords)){
			fileTypeNames = CustomSQLUtil.keywords(keywords, true);
			workflowNames = CustomSQLUtil.keywords(keywords, true);
		}else{
			andOperator = true;
		}
		
		return countByOneDoorWoorkflow(fileTypeNames, workflowNames, andOperator);
	}
	public int countByOneDoorWoorkflow(String fileTypeName, String workflowName, boolean andOperator) throws SystemException{
		return countByOneDoorWoorkflow(new String[]{fileTypeName}, new String[]{workflowName}, andOperator);
	}
	
	
	public int countByOneDoorWoorkflow(String[] fileTypeNames, String[] workflowNames,
			boolean andOperator) throws SystemException {
		fileTypeNames = CustomSQLUtil.keywords(fileTypeNames, true);	
		workflowNames = CustomSQLUtil.keywords(workflowNames, true);	
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(COUNT_BY_ONEDOORWORKFLOW);
			
			sql = CustomSQLUtil.replaceKeywords(sql, "lower(pml_filetype.filetypename)", StringPool.LIKE, false, fileTypeNames);
			sql = CustomSQLUtil.replaceKeywords(sql, "lower(pml_workflow.workflow)", StringPool.LIKE, true, workflowNames);
			sql = CustomSQLUtil.replaceAndOperator(sql, andOperator);
			
			SQLQuery q = session.createSQLQuery(sql);
			q.addScalar(COUNT_COLUMN_NAME, Type.LONG);
			
			QueryPos qpos = QueryPos.getInstance(q);
			qpos.add(fileTypeNames, 2);
			qpos.add(workflowNames, 2);
			
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

	
	
	
	public List<PmlWorkflow> findByKeywords(String keywords, int start, int end, OrderByComparator obc) throws SystemException{
		String[] fileTypeNames = null;
		String[] workflowNames = null;
		
		boolean andOperator = false;
		if(Validator.isNotNull(keywords)){
			fileTypeNames = CustomSQLUtil.keywords(keywords, true);
			workflowNames = CustomSQLUtil.keywords(keywords, true);
		}else{
			andOperator = true;
		}
		return findByOneDoorWoorkflow(fileTypeNames, workflowNames, andOperator, start, end, obc);
	}

	public List<PmlWorkflow> findByOneDoorWoorkflow(String fileTypeName, String workflowName, boolean andOperator, int start, int end, OrderByComparator obc) throws SystemException{
		return findByOneDoorWoorkflow(new String[]{fileTypeName}, new String[]{workflowName}, andOperator, start, end, obc);
	}
	
	public List<PmlWorkflow> findByOneDoorWoorkflow(String[] fileTypeNames, String[] workflowNames,
			boolean andOperator, int start, int end,
			OrderByComparator obc) throws SystemException {
		
		fileTypeNames = CustomSQLUtil.keywords(fileTypeNames, true);
		workflowNames = CustomSQLUtil.keywords(workflowNames, true);
		
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(FIND_BY_ONEDOORWORKFLOW);
			
			sql = CustomSQLUtil.replaceKeywords(sql, "lower(pml_filetype.filetypename)", StringPool.LIKE, false, fileTypeNames);
			sql = CustomSQLUtil.replaceKeywords(sql, "lower(pml_workflow.workflow)", StringPool.LIKE, true, workflowNames);
			sql = CustomSQLUtil.replaceAndOperator(sql, andOperator);
			sql = CustomSQLUtil.replaceOrderBy(sql, obc);
			
			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("pml_workflow", PmlWorkflowImpl.class);
			
			QueryPos qpos = QueryPos.getInstance(q);
			qpos.add(fileTypeNames,2);
			qpos.add(workflowNames,2);
			
			return (List<PmlWorkflow>) QueryUtil.list(q, getDialect(), start, end);
		} catch (Exception e) {
			throw new SystemException(e);
		}
		finally{
			closeSession(session);
		}
	}
}
