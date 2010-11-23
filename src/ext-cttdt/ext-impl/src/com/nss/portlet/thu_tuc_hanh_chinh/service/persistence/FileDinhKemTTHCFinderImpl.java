package com.nss.portlet.thu_tuc_hanh_chinh.service.persistence;

import java.util.Iterator;
import java.util.List;

import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.Type;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.nss.portlet.thu_tuc_hanh_chinh.model.FileDinhKemTTHC;
import com.nss.portlet.thu_tuc_hanh_chinh.model.impl.FileDinhKemTTHCImpl;

public class FileDinhKemTTHCFinderImpl extends BasePersistenceImpl implements FileDinhKemTTHCFinder{
	public int countFileDinhKem(long maThuTucHanhChinh) throws SystemException {
		Session session = null;
		try {
			session = openSession();
			String sql = " SELECT COUNT(*) AS COUNT_VALUE ";
			sql += " FROM nss_file_dinh_kem_tthc ";
			sql += " WHERE nss_file_dinh_kem_tthc.mathutuchanhchinh = " + maThuTucHanhChinh;
			
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
	
	public List<FileDinhKemTTHC> findFileDinhKem(long maThuTucHanhChinh, int start, int end) throws SystemException {
		Session session = null;
		try {
			session = openSession();
			String sql = " SELECT DISTINCT(nss_file_dinh_kem_tthc.*) ";
			sql += " FROM nss_file_dinh_kem_tthc ";
			sql += " WHERE nss_file_dinh_kem_tthc.mathutuchanhchinh = " + maThuTucHanhChinh;
			
			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("nss_file_dinh_kem_tthc", FileDinhKemTTHCImpl.class);
			
			return (List<FileDinhKemTTHC>) QueryUtil.list(q, getDialect(), start, end);
		} catch (Exception e) {
			throw new SystemException(e);
		}
		finally{
			closeSession(session);
		}
	} 
	
}
