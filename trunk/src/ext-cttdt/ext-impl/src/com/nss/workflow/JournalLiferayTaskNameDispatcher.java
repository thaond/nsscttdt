/**
 * 
 */
package com.nss.workflow;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.apache.struts.action.ActionMapping;

import com.liferay.util.portlet.PortletProps;
import com.sgs.liferay.web.struts.support.TaskNameDispatcher;

/**
 * @author hieuvh
 * 
 */
public class JournalLiferayTaskNameDispatcher implements TaskNameDispatcher {
	public static final String STRUTS_ACTION_TO_FORM_PREFIX = "struts_action.workflow.journal.article.form";
	public static final String STRUTS_ACTION_TO_ACTION_PREFIX = "struts_action.workflow.journal.article.action";

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.sgs.liferay.web.struts.support.TaskNameDispatcher#dispatch(java.lang
	 * .String, org.apache.struts.action.ActionMapping,
	 * javax.portlet.RenderRequest, javax.portlet.RenderResponse)
	 */
	public String dispatchToView(String formName, ActionMapping mapping,
			RenderRequest req, RenderResponse res) {
		String st = "";

		st = PortletProps.get(STRUTS_ACTION_TO_FORM_PREFIX + "." + formName);

		return st;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.sgs.liferay.web.struts.support.TaskNameDispatcher#dispatchToAction
	 * (java.lang.String, org.apache.struts.action.ActionMapping,
	 * javax.portlet.RenderRequest, javax.portlet.RenderResponse)
	 */
	public String dispatchToAction(String formName, ActionMapping mapping,
			RenderRequest req, RenderResponse res) {

		String st = "";

		st = PortletProps.get(STRUTS_ACTION_TO_ACTION_PREFIX + "." + formName);

		return st;
	}

}
