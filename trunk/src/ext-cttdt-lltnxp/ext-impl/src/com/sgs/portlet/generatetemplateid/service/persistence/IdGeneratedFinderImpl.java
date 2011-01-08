package com.sgs.portlet.generatetemplateid.service.persistence;

import java.util.Iterator;
import java.util.List;

import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.Type;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.sgs.portlet.generatetemplateid.model.IdGenerated;
import com.sgs.portlet.generatetemplateid.model.impl.IdGeneratedImpl;

public class IdGeneratedFinderImpl extends BasePersistenceImpl implements IdGeneratedFinder{
	public int countAll() throws SystemException{
		Session session = null;
		
		try {
			session = openSession();
			String sql = "SELECT COUNT(*) AS COUNT_VALUE ";
			sql += " FROM pml_idgenerated ";
			sql += " WHERE 1=1";
			SQLQuery q = session.createSQLQuery(sql);
			q.addScalar(COUNT_COLUMN_NAME, Type.LONG);
			
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
	
	public List<IdGenerated> findAll(int start, int end) throws SystemException {
		Session session = null;
		try {
			session = openSession();
			String sql = "SELECT pml_idgenerated.* ";
			sql += " FROM pml_idgenerated ";
			sql += " WHERE 1=1";
			
			SQLQuery q = session.createSQLQuery(sql);
			
			q.addEntity("pml_idgenerated", IdGeneratedImpl.class);
			
			return (List<IdGenerated>) QueryUtil.list(q, getDialect(), start, end);
		} catch (Exception e) {
			throw new SystemException(e);
		}
		finally{
			closeSession(session);
		}
	}
}
