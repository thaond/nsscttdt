package com.sgs.portlet.generatetemplateid.service.impl;

import java.util.List;

import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.sgs.portlet.generatetemplateid.model.IdTemplate;
import com.sgs.portlet.generatetemplateid.service.base.IdTemplateLocalServiceBaseImpl;


public class IdTemplateLocalServiceImpl extends IdTemplateLocalServiceBaseImpl {
	public int searchCount(String keywords) throws SystemException{
		return idTemplateFinder.countByKeywords(keywords);
	}
	
	public int searchCount(String format, String des, boolean andOperator) throws SystemException {
		return idTemplateFinder.countByMA_MOTA(format, des, andOperator);
	}
	
	public List<IdTemplate> search(String keywords, int start, int end, OrderByComparator obc) throws SystemException{
		return idTemplateFinder.findByKeywords(keywords, start, end, obc);
	}
	
	public List<IdTemplate> search(String format, String des, boolean andOperator, int start, int end, OrderByComparator obc) throws SystemException{
		return idTemplateFinder.findByMA_MOTA(format, des, andOperator, start, end, obc);
	}
}
