
package com.sgs.portlet.documentrecord.action;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.liferay.portal.struts.PortletAction;
import com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend;
import com.sgs.portlet.document.send.service.PmlEdmBookDocumentSendLocalServiceUtil;

public class ViewAction extends PortletAction {

	public void processAction(
		ActionMapping mapping, ActionForm form, PortletConfig config,
		ActionRequest req, ActionResponse res)
		throws Exception {
		
	}

	public ActionForward render(
		ActionMapping mapping, ActionForm form, PortletConfig config,
		RenderRequest req, RenderResponse res)
		throws Exception {

		return mapping.findForward("portlet.sgs.documentrecord.view");
	}
}
