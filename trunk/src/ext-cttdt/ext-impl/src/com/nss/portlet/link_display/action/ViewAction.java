package com.nss.portlet.link_display.action;

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
import com.nss.portlet.link.model.LienKetWebsite;
import com.nss.portlet.link.model.LoaiWebsite;
import com.nss.portlet.link.service.LienKetWebsiteLocalServiceUtil;
import com.nss.portlet.link.service.LoaiWebsiteLocalServiceUtil;

public class ViewAction extends PortletAction {
	
	public void processAction(ActionMapping mapping, ActionForm form,
			PortletConfig config, ActionRequest req, ActionResponse res)
			throws Exception {
		/*
		 * Process Action Code Goes Here
		 * 
		 * */
	}

	
	
	public ActionForward render(ActionMapping mapping, ActionForm form,
			PortletConfig config, RenderRequest req, RenderResponse res)
			throws Exception {
			if (getForward(req) != null && !getForward(req).equals("")) {
				return mapping.findForward(getForward(req)); // Use forward set in processAction if available
			} else {
				List<LoaiWebsite> loaiWebsiteList = LoaiWebsiteLocalServiceUtil.findByActive(1);
				List<LienKetWebsite> lienKetWebsiteList = LienKetWebsiteLocalServiceUtil.findByActive(1);
				req.setAttribute("loaiWebsiteList", loaiWebsiteList);
				req.setAttribute("lienKetWebsiteList", lienKetWebsiteList);
				
				return mapping.findForward("portlet.nss.link_display.view");
			}
	}

}
