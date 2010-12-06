/**
 * 
 */
package com.sgs.liferay.jbpm.util;

import java.util.Iterator;
import java.util.List;

import com.sgs.liferay.jbpm.param.WorkflowParam;

/**
 * @author hieuvh
 *
 */
public class WorkflowParamUtil {

	/**
	 * @param workflowParams
	 * @param paramName
	 * @return
	 */
	public static String getParam(List<WorkflowParam> workflowParams, String paramName) {
		
		for (Iterator iterator = workflowParams.iterator(); iterator.hasNext();) {
			WorkflowParam workflowParam = (WorkflowParam) iterator.next();

			if (paramName.equals(workflowParam.getName())) {
				return workflowParam.getValue();
			}
		}

		return null;
	}
	
	/**
	 * @param workflowParams
	 * @param paramName
	 * @param defaultValue
	 * @return
	 */
	public static long getLong(List<WorkflowParam> workflowParams, String paramName, long defaultValue) {
		String value = getParam(workflowParams, paramName);
		long result = defaultValue;
		
		try {
			result = Long.parseLong(value);
		} catch (Exception e) {
		}
		
		return result;
	}
	
	/**
	 * @param workflowParams
	 * @param paramName
	 * @param defaultValue
	 * @return
	 */
	public static String getString(List<WorkflowParam> workflowParams, String paramName, String defaultValue) {
		String value = getParam(workflowParams, paramName);
		String result = defaultValue;
		
		if (value != null) {
			result = value;
		}
		
		return result;
	}
	
}
