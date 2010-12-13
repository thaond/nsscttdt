package com.nss.portlet.generatetemplateid.service.impl;

import java.util.List;

import com.liferay.portal.SystemException;
import com.liferay.util.portlet.PortletProps;
import com.nss.portlet.generatetemplateid.NoSuchIdGeneratedException;
import com.nss.portlet.generatetemplateid.model.IdGenerated;
import com.nss.portlet.generatetemplateid.model.IdTemplate;
import com.nss.portlet.generatetemplateid.service.base.IdTemplateServiceBaseImpl;
import com.nss.portlet.generatetemplateid.service.persistence.IdGeneratedUtil;
import com.nss.portlet.generatetemplateid.service.persistence.IdTemplateUtil;
import com.nss.portlet.generatetemplateid.util.IdTemplateConstants;


public class IdTemplateServiceImpl extends IdTemplateServiceBaseImpl {
	public String generatedId(Class clazz) throws SystemException, NoSuchIdGeneratedException {
		String name = clazz.getName();
		String template = PortletProps.get(name);
		return generatedId(template);
	}
	
	public String generatedId(String template) throws SystemException, NoSuchIdGeneratedException {
		List<IdTemplate> idTemplates = IdTemplateUtil.findByFormat(template);
		if (idTemplates == null || idTemplates.size() == 0) {
			return "";
		}
		long id = idTemplates.get(0).getTemplateId();
		String result = template;
		String entry = "";
		String replace = "";
		for (int i = 0; i < IdTemplateConstants.TEMPLATE_ARRAYS.length; i++) {
			entry = IdTemplateConstants.TEMPLATE_ARRAYS[i];
			replace = findEntryValue(entry, id);
			result = result.replace(entry, replace);
		}
		
		return result;
	}
	
	private String findEntryValue(String entry, long id) throws NoSuchIdGeneratedException, SystemException {
		String result = "";
		IdGenerated idGenerated = IdGeneratedUtil.findByPrimaryKey(id);
		String year = idGenerated.getYear();
		long curNumber = idGenerated.getCurValue();
		if (IdTemplateConstants.YY.equals(entry)) {
			result = "" + year;
		}
		if (IdTemplateConstants.NUMBER.equals(entry)) {
			curNumber += 1;
			int len = 7 - String.valueOf(curNumber).length();
			for (int i = 0; i < len; i++) {
				result += "0";
			}
			result += String.valueOf(curNumber);
			idGenerated.setCurValue(curNumber);
			IdGeneratedUtil.update(idGenerated);
		}
		return result;
	}
}
