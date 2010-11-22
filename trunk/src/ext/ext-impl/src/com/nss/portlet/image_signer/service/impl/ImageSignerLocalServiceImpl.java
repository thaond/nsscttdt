package com.nss.portlet.image_signer.service.impl;

import java.util.List;

import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.model.User;
import com.nss.portlet.image_signer.service.base.ImageSignerLocalServiceBaseImpl;


public class ImageSignerLocalServiceImpl extends ImageSignerLocalServiceBaseImpl {
	public int countByName(String name) throws SystemException{
		return imageSignerFinder.countByName(name);
	}
	public List<User> findByName(String name, int start, int end,
			OrderByComparator obc) throws SystemException{
		return imageSignerFinder.findBy(name, start, end, obc);
	}
	public int count_User_Image(String firstnames, String middlenames,
			String lastnames, boolean andOperator) throws SystemException{
		return imageSignerFinder.count_User_Image(firstnames, middlenames, lastnames, andOperator);
	}
	public List<User> find_User_Image(String firstnames, String middlenames,
			String lastnames, int start, int end, boolean andOperator,
			OrderByComparator obc) throws SystemException{
		return imageSignerFinder.find_user_Image(firstnames, middlenames, lastnames, start, end, andOperator, obc);
	}
}
