package com.nss.portlet.van_ban_phap_quy.service.persistence;

import java.util.Iterator;
import java.util.List;

import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.Type;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.nss.portlet.van_ban_phap_quy.model.FileDinhKem;
import com.nss.portlet.van_ban_phap_quy.model.impl.FileDinhKemImpl;

public class FileDinhKemFinderImpl extends BasePersistenceImpl implements FileDinhKemFinder{

	public int countFileDinhKem(long maVanBanPhapQuy) throws SystemException {
		Session session = null;
		try {
			session = openSession();
			String sql = " SELECT COUNT(*) AS COUNT_VALUE ";
			sql += " FROM nss_file_dinh_kem ";
			sql += " WHERE nss_file_dinh_kem.ma_van_ban_phap_quy = " + maVanBanPhapQuy;
			
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
	
	public List<FileDinhKem> findFileDinhKem(long maVanBanPhapQuy, int start, int end) throws SystemException {
		Session session = null;
		try {
			session = openSession();
			String sql = " SELECT DISTINCT(nss_file_dinh_kem.*) ";
			sql += " FROM nss_file_dinh_kem ";
			sql += " WHERE nss_file_dinh_kem.ma_van_ban_phap_quy = " + maVanBanPhapQuy;
			sql += " ORDER BY nss_file_dinh_kem.mo_ta ASC";
			
			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("nss_file_dinh_kem", FileDinhKemImpl.class);
			
			return (List<FileDinhKem>) QueryUtil.list(q, getDialect(), start, end);
		} catch (Exception e) {
			throw new SystemException(e);
		}
		finally{
			closeSession(session);
		}
	}
}
