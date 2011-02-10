package com.sgs.portlet.generatetemplateid.service.impl;

import java.util.List;

import com.liferay.portal.SystemException;
import com.liferay.util.portlet.PortletProps;
import com.sgs.portlet.generatetemplateid.NoSuchIdGeneratedException;
import com.sgs.portlet.generatetemplateid.model.IdGenerated;
import com.sgs.portlet.generatetemplateid.model.IdTemplate;
import com.sgs.portlet.generatetemplateid.service.base.IdTemplateServiceBaseImpl;
import com.sgs.portlet.generatetemplateid.service.persistence.IdGeneratedUtil;
import com.sgs.portlet.generatetemplateid.service.persistence.IdTemplateUtil;
import com.sgs.portlet.generatetemplateid.util.IdTemplateConstants;

public class IdTemplateServiceImpl extends IdTemplateServiceBaseImpl {
	public String generatedId(String template) throws SystemException, NoSuchIdGeneratedException {
		List<IdTemplate> idTemplates = IdTemplateUtil.findByFormat(template);
		System.out.println("Id find = " + idTemplates);
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
	/**
	 * phuong thuc nay dung de generate id cho tung class cu the <br>
	 * dua vao file portlet.properties se xac dinh duoc template cho tung class. <br>
	 * Voi 1 template co duoc, se generate id cho template do. <br>
	 * 
	 * Cach su dung:<br>
	 *  - mo file WEB-INF/classes/portlet.properties<br>
	 *  - Them vao 1 property voi cu phap nhu sau<br>
	 *  {Ten class can generate id}={teplate}<br>
	 *  Vi du:<br>
	 *  	City=CT[YY][Num]<br>
	 *  Hien tai chi ho tro: <br>
	 *  	[YY] : year<br>
	 *  	[Num]: STT<br>
	 *  	Text<br>
	 *  
	 *  Tao database de test nhu sau:<br>
	 *  -Bang pml_idtemplate:<br> 
	 *  	field format co gia tri nu template ben tren<br>
	 *  	field startnumber : 1
	 *  	field description : Template for {ClassName}<br>
	 *  -Bang pml_idgenerated:<br>
	 *  	field year : 09<br>
	 *  	field curNum : 1<br>
	 *  ***Chu y: id cua 2 bang tren phai giong nhau. Id cua pml_idgenerated<br> 
	 *  	se tham chieu den id cua pml_idtemplate.<br>
	 *  - goi phuong thuc sau de generate id cua 1 class cu the<br>
	 *  IdTemplateServiceUtil.generateId(Class clazz);<br>
	 */
	public String generatedId(Class clazz) throws SystemException, NoSuchIdGeneratedException {
		String name = clazz.getName();
		String template = PortletProps.get(name);
		return generatedId(template);
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
	
	public String generatedStringId(String template) throws SystemException, NoSuchIdGeneratedException {
		String templateStr = PortletProps.get(template);
		List<IdTemplate> idTemplates = IdTemplateUtil.findByFormat(templateStr);
		if (idTemplates == null || idTemplates.size() == 0) {
			return "";
		}
		long id = idTemplates.get(0).getTemplateId();
		String result = templateStr;
		String entry = "";
		String replace = "";
		for (int i = 0; i < IdTemplateConstants.TEMPLATE_ARRAYS.length; i++) {
			entry = IdTemplateConstants.TEMPLATE_ARRAYS[i];
			replace = findEntryStringValue(entry, id);
			result = result.replace(entry, replace);
		}
		
		return result;
	}
	
	private String findEntryStringValue(String entry, long id) throws NoSuchIdGeneratedException, SystemException {
		String result = "";
		IdGenerated idGenerated = IdGeneratedUtil.findByPrimaryKey(id);
		String year = idGenerated.getYear();
		long curNumber = idGenerated.getCurValue();
		if (IdTemplateConstants.YY.equals(entry)) {
			result = "" + year;
		}
		if (IdTemplateConstants.NUMBER.equals(entry)) {
			curNumber += 1;
			result += String.valueOf(curNumber);
			idGenerated.setCurValue(curNumber);
			IdGeneratedUtil.update(idGenerated);
		}
		return result;
	} 

}
