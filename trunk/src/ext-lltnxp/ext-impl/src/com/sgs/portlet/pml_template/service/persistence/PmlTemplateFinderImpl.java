package com.sgs.portlet.pml_template.service.persistence;

import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;

import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.Type;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;
import com.sgs.portlet.pml_template.model.PmlTemplate;
import com.sgs.portlet.pml_template.model.impl.PmlTemplateImpl;

public class PmlTemplateFinderImpl extends BasePersistenceImpl implements PmlTemplateFinder{

	public int countPmlTemplate(String type, String valueType) throws SystemException {
		Session session = null;
		try {
			session = openSession();
			String sql = "SELECT COUNT(*) AS COUNT_VALUE ";
			sql += "FROM pml_template";
			if ("mabieumau".equals(type)) {
				sql += " WHERE (lower(pml_template.templatecode) LIKE lower('%" +  valueType + "%'))"; 
			} else if ("tenbieumau".equals(type)) {
				sql += " WHERE (lower(pml_template.templatename) LIKE lower('%" + valueType + "%'))";
			} else if ("phongbanhanh".equals(type)) {
				sql += " WHERE ";
				sql = sql.replace("FROM pml_template", "FROM pml_template, pml_departments");
				sql += " pml_departments.departmentsid = pml_template.departmentid";
				sql += " AND pml_departments.departmentsid = '" +  valueType + "'";
			} else if ("ngaybanhanh".equals(type)) {
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				String ngayBanHanh = dateFormat.format(sdf.parse(valueType));
				sql += " WHERE pml_template.publishdate = '" + ngayBanHanh + "'";
			} 
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
	
	public List<PmlTemplate> findPmlTemplate(String type, String valueType, int start, int end,
			OrderByComparator obc) throws SystemException {
		
		Session session = null;
		try {
			session = openSession();
			String sql = "SELECT DISTINCT pml_template.* ";
			sql += "FROM pml_template";
			if ("mabieumau".equals(type)) {
				sql += " WHERE (lower(pml_template.templatecode) LIKE lower('%" +  valueType + "%'))"; 
			} else if ("tenbieumau".equals(type)) {
				sql += " WHERE (lower(pml_template.templatename) LIKE lower('%" + valueType + "%'))";
			} else if ("phongbanhanh".equals(type)) {
				sql += " WHERE ";
				sql = sql.replace("FROM pml_template", "FROM pml_template, pml_departments");
				sql += " pml_departments.departmentsid = pml_template.departmentid";
				sql += " AND pml_departments.departmentsid = '" +  valueType + "'";
			} else if ("ngaybanhanh".equals(type)) {
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				String ngayBanHanh = dateFormat.format(sdf.parse(valueType));
				sql += " WHERE pml_template.publishdate = '" +  ngayBanHanh + "'";
			} 
			sql = CustomSQLUtil.replaceOrderBy(sql, obc);
			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("pml_template", PmlTemplateImpl.class);
			
			return (List<PmlTemplate>) QueryUtil.list(q, getDialect(), start, end);
		} catch (Exception e) {
			throw new SystemException(e);
		}
		finally{
			closeSession(session);
		}
	}
}
