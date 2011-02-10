package com.ext.portlet.processtype.util;

import java.util.List;

import com.ext.portlet.processtype.model.ProcessType;
import com.ext.portlet.processtype.service.ProcessTypeLocalServiceUtil;
import com.ext.portlet.processtype.service.persistence.ProcessTypeUtil;
import com.ext.portlet.saveprocesstype.model.SaveProcessType;
import com.ext.portlet.saveprocesstype.service.persistence.SaveProcessTypeUtil;
import com.ext.portlet.util.StringUtil;

public class PmlProcessTypeUtil {
	public static boolean updateProcessType(int id, String nameProcessType, 
			int flagProcessType) {
		try {
			ProcessType processType = ProcessTypeUtil.findByPrimaryKey(id);
			if (processType != null) {
				nameProcessType = StringUtil.encodeHtml(nameProcessType);
				processType.setFlagProcessType(flagProcessType);
				processType.setName(nameProcessType);
				ProcessTypeLocalServiceUtil.updateProcessType(processType);
				return true;
			}
			return false;
		} catch (Exception e) {
			return false;
		}
	}
	
	public static boolean deleteProcessType(long processTypeId) {
		
		List<SaveProcessType> saveProcessTypeList = null;
		try {
			saveProcessTypeList = SaveProcessTypeUtil.findByFlagProcessType(processTypeId);
		} catch (Exception e) {}
		
		if (saveProcessTypeList != null && !saveProcessTypeList.isEmpty()) {
			return false;
		} else {
			try {
				ProcessTypeUtil.remove(processTypeId);
				return true;
			} catch (Exception e) {
				return false;
			} // end catch
		} // end else
	}	
}