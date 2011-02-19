package com.sgs.portlet.vanbannoibo.workflow;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.apache.struts.action.ActionMapping;

import com.liferay.util.portlet.PortletProps;
import com.sgs.liferay.web.struts.support.TaskNameDispatcher;

public class VanBanNoiBoProcessTaskNameDispatcher implements TaskNameDispatcher {
	
	public static final String STRUTS_ACTION_TO_FORM_PREFIX = "struts_action.vanbannoibo.form";
	public static final String STRUTS_ACTION_TO_ACTION_PREFIX = "struts_action.vanbannoibo.action";
	
	public String dispatchToView(String formName, ActionMapping mapping, RenderRequest req, RenderResponse res) {
		String st = "";
		st = PortletProps.get(STRUTS_ACTION_TO_FORM_PREFIX + "." + formName);
		return st;
	}

	
	public String dispatchToAction(String formName, ActionMapping mapping, RenderRequest req, RenderResponse res) {
		String st = "";
		st = PortletProps.get(STRUTS_ACTION_TO_ACTION_PREFIX + "." + formName);
		return st;
	}
}
