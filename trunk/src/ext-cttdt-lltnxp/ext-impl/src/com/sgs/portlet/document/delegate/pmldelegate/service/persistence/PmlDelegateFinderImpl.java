package com.sgs.portlet.document.delegate.pmldelegate.service.persistence;

import java.util.Iterator;
import java.util.List;

import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.Type;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.sgs.portlet.document.delegate.pmldelegate.model.PmlDelegate;
import com.sgs.portlet.document.delegate.pmldelegate.model.impl.PmlDelegateImpl;

public class PmlDelegateFinderImpl extends BasePersistenceImpl implements PmlDelegateFinder {
	public List<PmlDelegate> findAllDelegate(int start, int end) throws SystemException{
		Session session = null;
		try {
			session = openSession();
			String sql = "SELECT pml_delegate.* ";
			sql += " FROM pml_delegate ";
			sql += " WHERE 1=1";
			
			SQLQuery q = session.createSQLQuery(sql);
			
			q.addEntity("pml_delegate", PmlDelegateImpl.class);
			 
			return (List<PmlDelegate>) QueryUtil.list(q, getDialect(), start, end);
		} catch (Exception e) {
			throw new SystemException(e);
		}
		finally{
			closeSession(session);
		}
	}
	
	public int countAllDelegate() throws SystemException {
		Session session = null;
		
		try {
			session = openSession();
			String sql = "SELECT COUNT(*) AS COUNT_VALUE ";
			sql += " FROM pml_delegate ";
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
}
