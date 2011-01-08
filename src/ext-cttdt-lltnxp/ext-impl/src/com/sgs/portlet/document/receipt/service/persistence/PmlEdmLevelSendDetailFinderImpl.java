package com.sgs.portlet.document.receipt.service.persistence;

import java.util.Iterator;

import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.Type;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;

public class PmlEdmLevelSendDetailFinderImpl extends BasePersistenceImpl implements PmlEdmLevelSendDetailFinder{
	public static String CONTAIN_LEVELSEND = PmlEdmLevelSendDetailFinder.class.getName()+ ".checkContainLevelSend";
	
	public int containLevelSend(int levelSendId, String issuingPlaceId) throws SystemException{
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(CONTAIN_LEVELSEND);
			SQLQuery q = session.createSQLQuery(sql);
			q.addScalar(COUNT_COLUMN_NAME, Type.LONG);
			q.setInteger(0, levelSendId);
			q.setString(1, issuingPlaceId);
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
