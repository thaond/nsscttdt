package com.nss.portlet.partner_management.action;

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
import com.nss.portlet.partner.model.Partner;
import com.nss.portlet.partner.service.PartnerLocalServiceUtil;

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
		
			List<Partner> partners = PartnerLocalServiceUtil.getPartners(-1, -1);
			List<Partner> partnerList = new ArrayList<Partner>();
			
			if (partners.size() > 0) {
				for (Partner partner: partners) {
					if (partner.getActive() == 1) {
						partnerList.add(partner);
					}
				}
			}
			req.setAttribute("partnerList", partnerList);
	
			return mapping.findForward("portlet.nss.partner_management.view");
		}
	}
}