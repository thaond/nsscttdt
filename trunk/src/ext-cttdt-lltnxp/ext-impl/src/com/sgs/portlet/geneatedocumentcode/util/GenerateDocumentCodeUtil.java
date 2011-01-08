package com.sgs.portlet.geneatedocumentcode.util;

import java.util.List;

import com.sgs.portlet.generatetemplateid.model.IdGenerated;
import com.sgs.portlet.generatetemplateid.service.IdGeneratedLocalServiceUtil;
import com.sgs.portlet.generatetemplateid.service.persistence.IdGeneratedUtil;

public class GenerateDocumentCodeUtil {
	public void editGenerateCode(long id, String year, long currentValue) throws Exception {
		IdGenerated idGenerated = IdGeneratedLocalServiceUtil.getIdGenerated(id);
		idGenerated.setYear(year);
		idGenerated.setCurValue(currentValue);
		IdGeneratedLocalServiceUtil.updateIdGenerated(idGenerated);
	}
	
	public void deleteIdGenerated (long id) throws Exception {
		IdGeneratedLocalServiceUtil.deleteIdGenerated(id);
	}
	
	public List<IdGenerated> getListIdGenerated() throws Exception {
		List<IdGenerated> idGeneratedList = IdGeneratedUtil.findAll();
		return idGeneratedList;
	}
}
