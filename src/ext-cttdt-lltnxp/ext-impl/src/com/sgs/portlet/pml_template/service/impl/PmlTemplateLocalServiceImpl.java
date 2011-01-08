package com.sgs.portlet.pml_template.service.impl;

import java.util.List;

import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.sgs.portlet.pml_template.model.PmlTemplate;
import com.sgs.portlet.pml_template.service.base.PmlTemplateLocalServiceBaseImpl;


public class PmlTemplateLocalServiceImpl extends PmlTemplateLocalServiceBaseImpl {
	public List<PmlTemplate> search(String type, String valueType, int start, int end,
			OrderByComparator obc) throws SystemException {
		return pmlTemplateFinder.findPmlTemplate(type, valueType, start, end, obc);
	}
	
	public int searchCount(String type, String valueType) throws SystemException {
		return pmlTemplateFinder.countPmlTemplate(type, valueType);
	}
}
