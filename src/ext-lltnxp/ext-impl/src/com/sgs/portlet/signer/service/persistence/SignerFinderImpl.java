package com.sgs.portlet.signer.service.persistence;

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
import com.liferay.portal.model.User;
import com.liferay.portal.model.impl.UserImpl;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;

public class SignerFinderImpl extends BasePersistenceImpl implements SignerFinder{
	public static String FIND_BY_H_TEN = SignerFinder.class.getName() + ".findBy_H_TEN";
	public static String COUNT_BY_H_TEN = SignerFinder.class.getName()+ ".countBy_H_TEN";
	public static String FIND_BY_H_TEN_AFTER_CHECKED = SignerFinder.class.getName() + ".findBy_H_TEN_AFTER_CHECKED";
	public static String COUNT_BY_H_TEN_AFTER_CHECKED = SignerFinder.class.getName()+ ".countBy_H_TEN_AFTER_CHECKED";
	public static String CONTAIN_SIGNER = SignerFinder.class.getName()+ ".checkContainSigner";
	/**
	 * @method countByKeywords	
	 * @param keywords
	 * @return int
	 * dem dong du lieu khi tim kiem don gian
	 */
	public int countByKeywords(String keywords) throws SystemException{
		String[] lastNames = null;
		String[] firstNames = null;
		
		boolean andOperator = false;
		if(Validator.isNotNull(keywords)){
			lastNames = CustomSQLUtil.keywords(keywords, false);
			firstNames = CustomSQLUtil.keywords(keywords, false);
		}else{
			andOperator = true;
		}
		
		return countByH_TEN_P(lastNames,firstNames,andOperator);
	}
	public int countByH_TEN_P(String lastName, String firstName,boolean andOperator) throws SystemException{
		return countByH_TEN_P(new String[]{lastName}, new String[]{firstName}, andOperator);
	}
	/**
	 * @method countByH_TEN_P	
	 * @param lastNames, firstNames, andOperator
	 * @return int
	 * dem dong du lieu khi tim kiem nang cao
	 */
	public int countByH_TEN_P(String[] lastNames, String[] firstNames,
			boolean andOperator) throws SystemException {
		lastNames = CustomSQLUtil.keywords(lastNames, false);
		firstNames = CustomSQLUtil.keywords(firstNames, false);
		
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(COUNT_BY_H_TEN);
			
			sql = CustomSQLUtil.replaceKeywords(sql, "contact_.lastname", StringPool.LIKE, false, lastNames);
			sql = CustomSQLUtil.replaceKeywords(sql, "contact_.firstname", StringPool.LIKE, false, firstNames);
			sql = CustomSQLUtil.replaceAndOperator(sql, andOperator);
			
			SQLQuery q = session.createSQLQuery(sql);
			q.addScalar(COUNT_COLUMN_NAME, Type.LONG);
			
			QueryPos qpos = QueryPos.getInstance(q);
			 qpos.add(lastNames,2);
			 qpos.add(firstNames,2);
			
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
	/**
	 * @method countByKeywordsAfterChecked	
	 * @param keywords
	 * @return int
	 * dem dong du lieu khi tim kiem don gian
	 */
	public int countByKeywordsAfterChecked(String keywords) throws SystemException{
		String[] lastNames = null;
		String[] firstNames = null;
		
		boolean andOperator = false;
		if(Validator.isNotNull(keywords)){
			lastNames = CustomSQLUtil.keywords(keywords, false);
			firstNames = CustomSQLUtil.keywords(keywords, false);
		}else{
			andOperator = true;
		}
		
		return countByH_TEN_AFTER_CHECKED(lastNames,firstNames,andOperator);
	}

	public int countByH_TEN_AFTER_CHECKED(String lastName, String firstName,boolean andOperator) throws SystemException{
		return countByH_TEN_AFTER_CHECKED(new String[]{lastName}, new String[]{firstName}, andOperator);
	}
	
	public int countByH_TEN_AFTER_CHECKED(String[] lastNames,String[] firstNames, boolean andOperator) throws SystemException {
		lastNames = CustomSQLUtil.keywords(lastNames, false);
		firstNames = CustomSQLUtil.keywords(firstNames, false);
		
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(COUNT_BY_H_TEN_AFTER_CHECKED);
			
			sql = CustomSQLUtil.replaceKeywords(sql, "contact_.lastname", StringPool.LIKE, false, lastNames);
			sql = CustomSQLUtil.replaceKeywords(sql, "contact_.firstname", StringPool.LIKE, false, firstNames);
			sql = CustomSQLUtil.replaceAndOperator(sql, andOperator);
			
			SQLQuery q = session.createSQLQuery(sql);
			q.addScalar(COUNT_COLUMN_NAME, Type.LONG);
			
			QueryPos qpos = QueryPos.getInstance(q);
			 qpos.add(lastNames,2);
			 qpos.add(firstNames,2);
			
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
	/**
	 * @method findByKeywords	
	 * @param keywords, start, end, obc
	 * @return ListUser
	 * tim kiem theo tieu chi don gian
	 */
	public List<User> findByKeywords(String keywords,int start, int end, OrderByComparator obc) throws SystemException{
		String[] lastNames = null;
		String[] firstNames = null;
		
		boolean andOperator = false;
		if(Validator.isNotNull(keywords)){
			lastNames = CustomSQLUtil.keywords(keywords, false);
			firstNames = CustomSQLUtil.keywords(keywords, false);
		}else{
			andOperator = true;
		}
		return findByH_TEN_P(lastNames, firstNames, andOperator, start, end, obc);
	}

	public List<User> findByH_TEN_P(String lastName, String firstName,boolean andOperator, int start, int end, OrderByComparator obc) throws SystemException{
		return findByH_TEN_P(new String[]{lastName}, new String[]{firstName}, andOperator, start, end, obc);
	}
	/**
	 * @method findByH_TEN_P	
	 * @param lastNames,firstNames,andOperator, start, end, obc
	 * @return ListUser
	 * tim kiem theo tieu chi nang cao
	 */
	public List<User> findByH_TEN_P(String[] lastNames, String[] firstNames,
			boolean andOperator, int start, int end,
			OrderByComparator obc) throws SystemException {
		lastNames = CustomSQLUtil.keywords(lastNames, false);
		firstNames = CustomSQLUtil.keywords(firstNames, false);
		
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(FIND_BY_H_TEN);
			
			sql = CustomSQLUtil.replaceKeywords(sql, "contact_.lastname", StringPool.LIKE, false, lastNames);
			sql = CustomSQLUtil.replaceKeywords(sql, "contact_.firstname", StringPool.LIKE, false, firstNames);
			sql = CustomSQLUtil.replaceAndOperator(sql, andOperator);
			sql = CustomSQLUtil.replaceOrderBy(sql, obc);
			
			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("user_", UserImpl.class);
			
			QueryPos qpos = QueryPos.getInstance(q);
			 qpos.add(lastNames,2);
			 qpos.add(firstNames,2);
			 
			return (List<User>) QueryUtil.list(q, getDialect(), start, end);
		} catch (Exception e) {
			throw new SystemException(e);
		}
		finally{
			closeSession(session);
		}
	}
	/**
	 * ================================
	 */
	
	public List<User> findByKeywordsAfterChecked(String keywords,int start, int end, OrderByComparator obc) throws SystemException{
		String[] lastNames = null;
		String[] firstNames = null;
		
		boolean andOperator = false;
		if(Validator.isNotNull(keywords)){
			lastNames = CustomSQLUtil.keywords(keywords, false);
			firstNames = CustomSQLUtil.keywords(keywords, false);
		}else{
			andOperator = true;
		}
		return findByH_TEN_AFTER_CHECKED(lastNames, firstNames, andOperator, start, end, obc);
	}

	public List<User> findByH_TEN_AFTER_CHECKED(String lastName, String firstName,boolean andOperator, int start, int end, OrderByComparator obc) throws SystemException{
		return findByH_TEN_AFTER_CHECKED(new String[]{lastName}, new String[]{firstName}, andOperator, start, end, obc);
	}
	/**
	 * @method findByH_TEN_P	
	 * @param lastNames,firstNames,andOperator, start, end, obc
	 * @return ListUser
	 * tim kiem theo tieu chi nang cao
	 */
	public List<User> findByH_TEN_AFTER_CHECKED(String[] lastNames, String[] firstNames,
			boolean andOperator, int start, int end,
			OrderByComparator obc) throws SystemException {
		lastNames = CustomSQLUtil.keywords(lastNames, false);
		firstNames = CustomSQLUtil.keywords(firstNames, false);
		
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(FIND_BY_H_TEN_AFTER_CHECKED);
			
			sql = CustomSQLUtil.replaceKeywords(sql, "contact_.lastname", StringPool.LIKE, false, lastNames);
			sql = CustomSQLUtil.replaceKeywords(sql, "contact_.firstname", StringPool.LIKE, false, firstNames);
			sql = CustomSQLUtil.replaceAndOperator(sql, andOperator);
			sql = CustomSQLUtil.replaceOrderBy(sql, obc);
			
			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("user_", UserImpl.class);
			
			QueryPos qpos = QueryPos.getInstance(q);
			 qpos.add(lastNames,2);
			 qpos.add(firstNames,2);
			 
			return (List<User>) QueryUtil.list(q, getDialect(), start, end);
		} catch (Exception e) {
			throw new SystemException(e);
		}
		finally{
			closeSession(session);
		}
	}
	
	
	/**
	 * @method containtSigner	
	 * @param userId
	 * @return int
	 * kiem tra co doi tuong Signer nao voi userId nhap vao khong
	 */
	public int containSigner(long userId) throws SystemException{
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(CONTAIN_SIGNER);
			SQLQuery q = session.createSQLQuery(sql);
			q.addScalar(COUNT_COLUMN_NAME, Type.LONG);
			q.setLong(0, userId);
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
