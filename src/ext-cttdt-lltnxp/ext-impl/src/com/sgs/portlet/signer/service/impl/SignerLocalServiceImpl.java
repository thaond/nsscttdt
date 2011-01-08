package com.sgs.portlet.signer.service.impl;

import java.util.List;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.model.User;
import com.sgs.portlet.signer.NoSuchSignerException;
import com.sgs.portlet.signer.model.Signer;
import com.sgs.portlet.signer.service.base.SignerLocalServiceBaseImpl;

public class SignerLocalServiceImpl extends SignerLocalServiceBaseImpl {
	/**
	 * @method searchCount	
	 * @param keywords
	 * @return int
	 * dem ket qua tra ve khi tim kiem theo keywords
	 */
	public int searchCount(String keywords) throws SystemException{
		return signerFinder.countByKeywords(keywords);
	}
	
	/**
	 * @method searchCount	
	 * @param lastName, firstName, andOperator
	 * @return int
	 * dem ket qua tra ve khi tim kiem nang cao
	 */
	public int searchCount(String lastName, String firstName, boolean andOperator) throws SystemException{
		return signerFinder.countByH_TEN_P(lastName, firstName,  andOperator);
	}
	
	/**
	 * @method search
	 * @param keywords, start, end, obc
	 * @return  ListUser
	 * tra ve danh sach user khi tim kiem theo keywords
	 */
	public List<User> search(String keywords, int start, int end, OrderByComparator obc) throws SystemException{
		return signerFinder.findByKeywords(keywords, start, end, obc);
	}
	
	/**
	 * @method search
	 * @param lastName,firstName,andOperator, start, end, obc
	 * @return  ListUser
	 * tra ve danh sach user khi tim kiem nang cao
	 */
	public List<User> search(String lastName, String firstName,  boolean andOperator, int start, int end, OrderByComparator obc) throws SystemException{
		return signerFinder.findByH_TEN_P(lastName, firstName, andOperator, start, end, obc);
	}
	
	/**
	 * @param keywords 
	 * @method hasSigner
	 * @param userId
	 * @return  boolean
	 * kiem tra co doi tuong Signer voi userId nhap vao khong
	 * @throws SystemException 
	 */
	public int searchCountAfterChecked(String keywords) throws SystemException{
		return signerFinder.countByKeywordsAfterChecked(keywords);
	}
	
	public int searchCountAfterChecked(String lastName, String firstName, boolean andOperator) throws SystemException{
		return signerFinder.countByH_TEN_AFTER_CHECKED(lastName, firstName, andOperator);
	}
	
	public List<User> searchAfterChecked(String keywords, int start, int end, OrderByComparator obc) throws SystemException{
		return signerFinder.findByKeywordsAfterChecked(keywords, start, end, obc);
	}
	
	public List<User> searchAfterChecked(String lastName, String firstName, boolean andOperator, int start, int end, OrderByComparator obc) throws SystemException{
		return signerFinder.findByH_TEN_AFTER_CHECKED(lastName, firstName, andOperator, start, end, obc);
	}
	
	public boolean hasSigner(long userId){
		
		try {
			return (signerFinder.containSigner(userId)== 0 ? false : true);
		} catch (SystemException e) {			
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * Lay tat ca signer
	 * @return
	 * @throws SystemException
	 */
	public List<Signer> getAll() 
	throws SystemException {
		try {
			return signerPersistence.findAll();
		} // end try
		catch (Exception ex) {
			return null;
		} // end catch
	}
	
	/**
	 * Them Signer
	 * @param userId
	 * @return
	 * @throws SystemException
	 */
	public Signer addSigner(long userId) 
	throws SystemException {
		try {
			// Kiem tra userId la duy nhat trong bang
			try {
				Signer existingItem = signerPersistence.findByUserId(userId);
				if (existingItem != null) { // Khong cho phep them vao bang
					System.out.println("UserId nay da co trong bang. Khong the them tiep.");
					return null;
				}
			} // end try
			catch (NoSuchSignerException e) {
				// Do no thing
			}
			Signer newItem = signerPersistence.create(CounterLocalServiceUtil.increment());
			newItem.setUserId(userId);
			
			return signerPersistence.update(newItem, false);
		} // end try
		catch (Exception ex) {
			System.out.println("SignerLocalServiceImpl.java Co loi khi them Signer: " + ex.getMessage());
			return null;
		} // end catch
	}
	
	/**
	 * Xoa Signer dua vao userId
	 * @param userId
	 * @return
	 * @throws SystemException
	 */
	public boolean removeByUserId(long userId) 
	throws SystemException {
		try {
			Signer delItem = signerPersistence.findByUserId(userId);
			delItem = signerPersistence.remove(delItem);
			if (delItem == null) {
				return false;
			} // end if
			return true;
		} // end try
		catch (Exception ex) {
			return false;
		} // end catch
	}
}