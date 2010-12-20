package com.nss.portlet.adv_display.action;

import java.util.ArrayList;
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
import com.nss.portlet.adv.model.QuangCao;
import com.nss.portlet.adv.service.QuangCaoLocalServiceUtil;

public class ViewAction extends PortletAction {
	
	public void processAction(ActionMapping mapping, ActionForm form,
			PortletConfig config, ActionRequest req, ActionResponse res)
			throws Exception {
	}

	
	
	public ActionForward render(ActionMapping mapping, ActionForm form,
			PortletConfig config, RenderRequest req, RenderResponse res)
			throws Exception {
			if (getForward(req) != null && !getForward(req).equals("")) {
				return mapping.findForward(getForward(req)); // Use forward set in processAction if available
			} else {
				List<QuangCao> quangCaoList = new ArrayList<QuangCao>();
				quangCaoList = QuangCaoLocalServiceUtil.findByActive(1);
				req.setAttribute("quangCaoList", quangCaoList);
				return mapping.findForward("portlet.nss.adv_display.view");
			}
	}

}
