/**
 * 
 */
package com.sgs.portlet.documentdelegate.service.persistence;

import java.util.Iterator;
import java.util.List;

import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.Type;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;
import com.sgs.portlet.documentdelegate.model.PmlDocumentDelegate;
import com.sgs.portlet.documentdelegate.model.impl.PmlDocumentDelegateImpl;

/**
 * @author WIN7
 *
 */
public class PmlDocumentDelegateFinderImpl extends BasePersistenceImpl implements  PmlDocumentDelegateFinder{
	public static String COUNT_SD_TD_USERISDELEGATE = PmlDocumentDelegateFinder.class.getName() + ".countBy_SD_TD_USERISDELEGATE";
	public static String FIND_SD_TD_USERISDELEGATE = PmlDocumentDelegateFinder.class.getName()+ ".findBy_SD_TD_USERISDELEGATE";

	public int countBy_SD_TD_USERISDELEGATE(long userDelegate, 
			String fromDateDelegate, String toDateDelegate, String listUserIsDelegate
			) throws SystemException {
		
//		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
//		Date fromDate = new Date();
//		Date toDate = new Date();
//		if (!"".equals(fromDateDelegate) && null != fromDateDelegate) {
//			try {
//				fromDate =dateFormat.parse(fromDateDelegate);
//			} catch (ParseException e) {
//				e.printStackTrace();
//			}
//		}
//		
//		if (!"".equals(toDateDelegate) && null != toDateDelegate) {
//			try {
//				toDate =dateFormat.parse(toDateDelegate);
//			} catch (ParseException e) {
//				e.printStackTrace();
//			}
//		}
		
//		Timestamp fromDateStamp = new Timestamp(fromDate.getTime());
//		Timestamp toDateStamp = new Timestamp(toDate.getTime());
		
		
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(COUNT_SD_TD_USERISDELEGATE);
			
			SQLQuery q = session.createSQLQuery(sql);
			q.addScalar(COUNT_COLUMN_NAME, Type.LONG);
			
			QueryPos qpos = QueryPos.getInstance(q);
			qpos.add(userDelegate);
			
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
	
	
	
	
	public List<PmlDocumentDelegate> findBy_SD_TD_USERISDELEGATE(long userDelegate, 
			String fromDateDelegate, String toDateDelegate, String listUserIsDelegate, int start, int end
			, OrderByComparator obc) throws SystemException {
//		
//		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
//		Date fromDate = new Date();
//		Date toDate = new Date();
//		if (!"".equals(fromDateDelegate) && null != fromDateDelegate) {
//			try {
//				fromDate =dateFormat.parse(fromDateDelegate);
//			} catch (ParseException e) {
//				e.printStackTrace();
//			}
//		}
//		
//		if (!"".equals(toDateDelegate) && null != toDateDelegate) {
//			try {
//				toDate =dateFormat.parse(toDateDelegate);
//			} catch (ParseException e) {
//				e.printStackTrace();
//			}
//		}
		
//		Timestamp fromDateStamp = new Timestamp(fromDate.getTime());
//		Timestamp toDateStamp = new Timestamp(toDate.getTime());
		
		
		Session session = null;
		try {
			session = openSession();
			
			String sql = CustomSQLUtil.get(FIND_SD_TD_USERISDELEGATE);
			sql = CustomSQLUtil.replaceOrderBy(sql, obc);
			
			SQLQuery q = session.createSQLQuery(sql);
			
			q.addEntity("pml_edm_documentdelegate", PmlDocumentDelegateImpl.class);
			
			QueryPos qpos = QueryPos.getInstance(q);
			qpos.add(userDelegate);
//			qpos.add(fromDateStamp);
//			qpos.add(toDateStamp);
			
			return (List<PmlDocumentDelegate>) QueryUtil.list(q, getDialect(), start, end);
		} catch (Exception e) {
			throw new SystemException(e);
		}
		finally{
			closeSession(session);
		}
	}
}
